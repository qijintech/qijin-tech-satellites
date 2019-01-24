package tech.qijin.satellites.favorites.service.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.favorites.db.model.FaFavorites;
import tech.qijin.satellites.favorites.service.FavoritesService;
import tech.qijin.satellites.favorites.service.helper.FavoritesHelper;
import tech.qijin.usercenter.client.util.UserUtil;
import tech.qijin.util4j.aop.annotation.Cas;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.utils.NumberUtil;

import java.util.List;
import java.util.Optional;

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
    public List<FaFavorites> pageFavorites() {
        Long userId = UserUtil.getUserId();
        return favoritesHelper.pageFavorites(userId);
    }
}
