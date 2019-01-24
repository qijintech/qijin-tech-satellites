package tech.qijin.satellites.item.service.helper;

import tech.qijin.satellites.item.db.model.ItemInfo;
import tech.qijin.satellites.item.db.model.ItemInfoExtend;

import java.util.List;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface ItemInfoHelper {
    /**
     *
     * @param id
     * @return
     */
    Optional<ItemInfo> getItemInfoById(Long id);

    /**
     *
     * @param itemId
     * @return
     */
    Optional<ItemInfoExtend> getItemInfoExtendByItemId(Long itemId);

    /**
     *
     * @return
     */
    List<ItemInfo> pageItemInfo();
}
