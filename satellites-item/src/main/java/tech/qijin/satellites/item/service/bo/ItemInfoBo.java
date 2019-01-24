package tech.qijin.satellites.item.service.bo;

import lombok.Data;
import tech.qijin.satellites.item.db.model.ItemInfo;
import tech.qijin.satellites.item.db.model.ItemModel;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class ItemInfoBo {
    private ItemInfo itemInfo;
    /**
     * 第一个关联model
     */
    private ItemModel itemModel;
}
