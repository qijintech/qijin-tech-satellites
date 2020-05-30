package tech.qijin.satellites.im.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.cell.im.db.model.ImConversation;
import tech.qijin.cell.im.service.CellImConversationService;
import tech.qijin.satellites.im.service.StConversationService;
import tech.qijin.satellites.im.service.bo.ConversationBo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class StConversationServiceImpl implements StConversationService {
    @Autowired
    private CellImConversationService cellImConversationService;

    @Override
    public List<ConversationBo> listConversationHistory(Long uid, Long versionId, Integer count) {
        List<ImConversation> imConversations = cellImConversationService.listConversationHistory(uid, versionId, count);
        if (CollectionUtils.isEmpty(imConversations)) {
            return Collections.EMPTY_LIST;
        }
        // TODO 补充用户信息
        return imConversations.stream()
                .map(imConversation -> ConversationBo.builder().imConversation(imConversation).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ConversationBo> listConversationNew(Long uid, Long versionId, Integer count) {
        List<ImConversation> imConversations = cellImConversationService.listConversationNew(uid, versionId, count);
        if (CollectionUtils.isEmpty(imConversations)) {
            return Collections.EMPTY_LIST;
        }
        // TODO 补充用户信息
        return imConversations.stream()
                .map(imConversation -> ConversationBo.builder().imConversation(imConversation).build())
                .collect(Collectors.toList());
    }
}
