package tech.qijin.satellites.favorites.service.spi.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.favorites.db.model.FaFavorites;
import tech.qijin.satellites.favorites.service.FavoritesService;
import tech.qijin.satellites.favorites.service.bo.FavoritesBo;
import tech.qijin.satellites.favorites.service.spi.ItemServiceProvider;
import tech.qijin.satellites.favorites.service.spi.SpiService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class SpiServiceImpl implements SpiService {
    @Autowired
    private FavoritesService favoritesService;
    @Autowired
    private ItemServiceProvider itemServiceProvider;

    @Override
    public List<FavoritesBo> pageFavorites() {
        List<FaFavorites> favorites = favoritesService.pageFavorites();
        if (CollectionUtils.isEmpty(favorites)) {
            return Collections.emptyList();
        }
        List<Long> itemIds = favorites.stream()
                .map(FaFavorites::getItemId)
                .collect(Collectors.toList());
        Map<Long, Object> itemMap = itemServiceProvider.mapItemsByIds(itemIds);
        return favorites.stream()
                .map(item -> {
                    FavoritesBo favoritesBo = new FavoritesBo();
                    favoritesBo.setItemId(item.getItemId());
                    favoritesBo.setItem(itemMap.get(item.getItemId()));
                    return favoritesBo;
                }).collect(Collectors.toList());
    }
}
