package tech.qijin.satellites.item.service.helper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import tech.qijin.satellites.item.db.model.ItemModel;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface ItemModelHelper {
    Optional<ItemModel> getFirstItemModelByItemId(Long itemId);

    Map<Long, ItemModel> mapItemAndFirstItemModelByItemIds(List<Long> itemIds);

    List<ItemModel> listItemModelByItemId(Long itemId);
}
