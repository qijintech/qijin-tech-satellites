package tech.qijin.satellites.im.service;

import tech.qijin.satellites.im.service.bo.ConversationBo;

import java.util.List;

public interface StConversationService {
    List<ConversationBo> listConversationHistory(Long uid, Long versionId, Integer count);
    List<ConversationBo> listConversationNew(Long uid, Long versionId, Integer count);
}
