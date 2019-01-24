package tech.qijin.satellites.favorites.service.spi;

import tech.qijin.satellites.favorites.service.bo.FavoritesBo;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface SpiService {
    List<FavoritesBo> pageFavorites();
}
