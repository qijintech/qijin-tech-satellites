package tech.qijin.satellites.favorites.service.helper;

import tech.qijin.satellites.favorites.db.model.FaFavorites;

import java.util.List;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface FavoritesHelper {
    Optional<FaFavorites> getFavorites(Long userId, Long itemId);

    List<FaFavorites> pageFavorites(Long userId);

    void insertFavorites(FaFavorites favorites);

    void setCollect(FaFavorites favorites, boolean collect);
}
