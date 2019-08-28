package tech.qijin.satellites.item.service.helper;

import java.util.List;

import tech.qijin.satellites.item.db.model.ItemTag;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface ItemTagHelper {
    List<ItemTag> listItemTagByItemId(Long itemId);
}
