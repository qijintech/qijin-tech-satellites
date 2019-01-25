package tech.qijin.satellites.favorites.service;


import tech.qijin.satellites.favorites.service.bo.FavoritesBo;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface FavoritesService {
    /**
     * 收藏
     *
     * @param itemId
     */
    void doFavorites(Long itemId);

    /**
     * 取消收藏
     *
     * @param itemId
     */
    void cancelFavorites(Long itemId);

    /**
     * 分页查询用户的收藏
     *
     * @return
     */
    List<FavoritesBo> pageFavorites();
}
