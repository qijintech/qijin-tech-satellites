package tech.qijin.satellites.item.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.satellites.item.db.model.ItemInfo;
import tech.qijin.satellites.item.db.model.ItemModel;
import tech.qijin.satellites.item.server.vo.ItemVo;
import tech.qijin.satellites.item.service.ItemService;
import tech.qijin.satellites.item.service.bo.ItemBo;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.ConvertUtil;
import tech.qijin.util4j.utils.MAssert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@RequestMapping("/item")
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/list")
    public List<ItemVo> getItems() {
        List<ItemBo> itemBos = itemService.pageItemBos();
        return itemBos.stream()
                .map(itemBo ->
                        convertItemVo(itemBo.getItemInfo(), itemBo.getItemModel())
                ).collect(Collectors.toList());
    }

    private ItemVo convertItemVo(ItemInfo itemInfo, ItemModel model) {
        MAssert.notNull(itemInfo, ResEnum.BAD_GATEWAY);
        MAssert.notNull(model, ResEnum.BAD_GATEWAY);
        ItemVo itemVo = new ItemVo();
        itemVo.setTitle(itemInfo.getTitle());
        itemVo.setIntroduction(itemInfo.getIntroduction());
        itemVo.setOriginalPrice(model.getOriginalPrice());
        itemVo.setMemberPrice(model.getMemberPrice());
        itemVo.setDiscountPrice(model.getDiscountPrice());
        return itemVo;
    }
}
