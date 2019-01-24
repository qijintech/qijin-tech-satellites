package tech.qijin.satellites.favorites.service.spi;

import java.util.List;
import java.util.Map;

/**
 * @author michealyang
 * @date 2019/1/10
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface ItemServiceProvider {
    Map<Long, Object> mapItemsByIds(List<Long> itemIds);
}
