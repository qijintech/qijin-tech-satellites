package tech.qijin.satellites.favorites.spi;

import java.util.List;
import java.util.Map;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface FavoritesProvider {

    Map<Long, Object> mapFavoritesItemByIds(List<Long> itemIds);
}
