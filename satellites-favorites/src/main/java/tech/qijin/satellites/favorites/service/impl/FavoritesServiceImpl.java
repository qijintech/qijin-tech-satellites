package tech.qijin.satellites.favorites.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.favorites.db.model.FaFavorites;
import tech.qijin.satellites.favorites.service.FavoritesService;
import tech.qijin.satellites.favorites.service.bo.FavoritesBo;
import tech.qijin.satellites.favorites.service.helper.FavoritesHelper;
import tech.qijin.satellites.favorites.spi.FavoritesProvider;
import tech.qijin.util4j.web.util.UserUtil;
import tech.qijin.util4j.aop.annotation.Cas;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.NumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesHelper favoritesHelper;
    @Autowired
    private FavoritesProvider favoritesProvider;

    @Cas
    @Override
    public void doFavorites(Long itemId) {
        MAssert.isTrue(NumberUtil.gtZero(itemId), ResEnum.INVALID_PARAM);
        Long userId = UserUtil.getUserId();
        Optional<FaFavorites> favoritesOpt = favoritesHelper.getFavorites(userId, itemId);
        if (favoritesOpt.isPresent()) {
            favoritesHelper.setCollect(favoritesOpt.get(), true);
        } else {
            FaFavorites favorites = new FaFavorites();
            favorites.setItemId(itemId);
            favorites.setUserId(userId);
            favoritesHelper.insertFavorites(favorites);
        }
    }

    @Override
    public void cancelFavorites(Long itemId) {
        MAssert.isTrue(NumberUtil.gtZero(itemId), ResEnum.INVALID_EMAIL);
        Long userId = UserUtil.getUserId();
        Optional<FaFavorites> favoritesOpt = favoritesHelper.getFavorites(userId, itemId);
        favoritesOpt.ifPresent(
                favorites -> favoritesHelper.setCollect(favoritesOpt.get(), false)
        );
    }

    @Override
    public List<FavoritesBo> pageFavorites() {
        Long userId = UserUtil.getUserId();
        List<FaFavorites> favorites = favoritesHelper.pageFavorites(userId);
        if (CollectionUtils.isEmpty(favorites)) {
            return Collections.emptyList();
        }
        List<Long> itemIds = favorites.stream()
                .map(FaFavorites::getItemId)
                .collect(Collectors.toList());
        Map<Long, Object> itemMap = favoritesProvider.mapFavoritesItemByIds(itemIds);
        return favorites.stream()
                .map(item -> {
                    FavoritesBo favoritesBo = new FavoritesBo();
                    favoritesBo.setItemId(item.getItemId());
                    favoritesBo.setItem(itemMap.get(item.getItemId()));
                    return favoritesBo;
                }).collect(Collectors.toList());
    }
}
