package tech.qijin.satellites.item.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tech.qijin.satellites.item.db.model.ItemInfo;
import tech.qijin.satellites.item.db.model.ItemInfoExtend;
import tech.qijin.satellites.item.db.model.ItemModel;
import tech.qijin.satellites.item.db.model.ItemTag;
import tech.qijin.satellites.item.service.ItemService;
import tech.qijin.satellites.item.service.bo.ItemDetailBo;
import tech.qijin.satellites.item.service.bo.ItemInfoBo;
import tech.qijin.satellites.item.service.helper.ItemInfoHelper;
import tech.qijin.satellites.item.service.helper.ItemModelHelper;
import tech.qijin.satellites.item.service.helper.ItemTagHelper;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.utils.MAssert;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/24
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemInfoHelper itemInfoHelper;
    @Autowired
    private ItemModelHelper itemModelHelper;
    @Autowired
    private ItemTagHelper itemTagHelper;

    @Override
    public List<ItemInfoBo> pageItemInfoBos() {
        List<ItemInfo> itemInfos = itemInfoHelper.pageItemInfo();
        if (CollectionUtils.isEmpty(itemInfos)) {
            return Collections.emptyList();
        }
        List<Long> itemIds = itemInfos.stream().map(ItemInfo::getId).collect(Collectors.toList());
        Map<Long, ItemModel> itemAndModelMap = itemModelHelper.mapItemAndFirstItemModelByItemIds(itemIds);
        return itemInfos.stream().map(itemInfo -> {
            ItemInfoBo itemInfoBo = new ItemInfoBo();
            itemInfoBo.setItemInfo(itemInfo);
            itemInfoBo.setItemModel(itemAndModelMap.get(itemInfo.getId()));
            return itemInfoBo;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<ItemDetailBo> getItemDetailById(Long itemId) {
        Optional<ItemInfo> itemInfoOpt = itemInfoHelper.getItemInfoById(itemId);
        if (!itemInfoOpt.isPresent()) {
            return Optional.empty();
        }
        Optional<ItemInfoExtend> itemInfoExtendOpt = itemInfoHelper.getItemInfoExtendByItemId(itemInfoOpt.get().getId());
        Optional<ItemModel> itemModelOpt = itemModelHelper.getFirstItemModelByItemId(itemInfoOpt.get().getId());
        ItemDetailBo itemDetailBo = new ItemDetailBo();
        itemDetailBo.setItemInfo(itemInfoOpt.get());
        itemDetailBo.setItemInfoExtend(itemInfoExtendOpt.get());
        itemDetailBo.setItemModel(itemModelOpt.get());
        return Optional.of(itemDetailBo);
    }

    @Override
    public List<ItemModel> listItemModel(Long itemId) {
        return null;
    }

    @Override
    public List<ItemTag> listItemTags(Long itemId) {
        return null;
    }
}
