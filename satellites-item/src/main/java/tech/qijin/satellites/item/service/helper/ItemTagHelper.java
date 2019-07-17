package tech.qijin.satellites.item.service.helper;

import tech.qijin.satellites.item.db.model.ItemTag;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface ItemTagHelper {
    List<ItemTag> listItemTagByItemId(Long itemId);
}
