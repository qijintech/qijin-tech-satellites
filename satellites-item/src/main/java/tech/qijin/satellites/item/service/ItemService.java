package tech.qijin.satellites.item.service;

import tech.qijin.satellites.item.db.model.ItemModel;
import tech.qijin.satellites.item.db.model.ItemTag;
import tech.qijin.satellites.item.service.bo.ItemDetailBo;
import tech.qijin.satellites.item.service.bo.ItemInfoBo;

import java.util.List;
import java.util.Optional;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface ItemService {

    /**
     * 分页查询item
     *
     * @return
     */
    List<ItemInfoBo> pageItemInfoBos();

    /**
     * 查看item详情
     *
     * @param itemId
     * @return
     */
    Optional<ItemDetailBo> getItemDetailById(Long itemId);

    /**
     * 展示item所有model
     *
     * @param itemId
     * @return
     */
    List<ItemModel> listItemModel(Long itemId);

    /**
     * 展示item所有tag
     *
     * @param itemId
     * @return
     */
    List<ItemTag> listItemTags(Long itemId);
}
