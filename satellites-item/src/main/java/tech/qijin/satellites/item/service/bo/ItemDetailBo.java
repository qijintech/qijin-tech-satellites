package tech.qijin.satellites.item.service.bo;

import lombok.Data;
import tech.qijin.satellites.item.db.model.ItemInfoExtend;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class ItemDetailBo extends ItemBo {
    private ItemInfoExtend itemInfoExtend;
}
