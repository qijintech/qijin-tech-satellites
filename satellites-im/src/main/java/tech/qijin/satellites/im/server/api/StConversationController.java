package tech.qijin.satellites.im.server.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.satellites.im.server.vo.ConversationDataVo;
import tech.qijin.satellites.im.server.vo.ConversationRespVo;
import tech.qijin.satellites.im.server.vo.ConversationVo;
import tech.qijin.satellites.im.server.vo.UserVo;
import tech.qijin.satellites.im.service.StConversationService;
import tech.qijin.satellites.im.service.bo.ConversationBo;
import tech.qijin.util4j.utils.DateUtil;
import tech.qijin.util4j.web.interceptor.annotation.ChannelRequired;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 会话相关操作
 * <p>
 * 包含功能:
 * <ul>
 * <li>会话列表 - 按最新消息排序</li>
 * <li>删除会话</li>
 * <li>会话置顶 - Optional</li>
 * <li>会话免打扰 - Optional</li>
 * <li>清空聊天记录 - Optional</li>
 * </ul>
 * </p>
 *
 * @author michealyang
 * @date 2019-11-04
 * @relax: 开始眼保健操 ←_← ↓_↓ →_→ ↑_↑
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/im/base/conversation")
public class StConversationController {
    @Autowired
    private StConversationService stConversationService;

    @ChannelRequired
    @RequestMapping("/list/history")
    public ConversationRespVo listConversationHistory(@NotNull Long uid, Long versionId, Integer count) {
        List<ConversationBo> conversationBos = stConversationService.listConversationHistory(uid, versionId, count);
        return ConversationRespVo.builder()
                .conversations(convert(conversationBos))
                .unreadTotal(0)
                .build();
    }

    @ChannelRequired
    @RequestMapping("/list/new")
    public ConversationRespVo listConversationNew(@NotNull Long uid, Long versionId, Integer count) {
        List<ConversationBo> conversationBos = stConversationService.listConversationNew(uid, versionId, count);
        return ConversationRespVo.builder()
                .conversations(convert(conversationBos))
                .unreadTotal(0)
                .build();
    }

    private List<ConversationDataVo> convert(List<ConversationBo> conversationBos) {
        if (CollectionUtils.isEmpty(conversationBos)) {
            return Collections.EMPTY_LIST;
        }
        return conversationBos.stream()
                .filter(Objects::nonNull)
                .filter(conversationBo -> conversationBo.getImConversation() != null)
                .map(conversationBo -> {
                    ConversationVo conversationVo = ConversationVo.builder()
                            .versionId(conversationBo.getImConversation().getVersionId())
                            .unreadCount(0) // TODO
                            .updateTime(DateUtil.formatStr(conversationBo.getImConversation().getUpdateTime(), DateUtil.YYYYMMDDHHMM))
                            .lastMsg(conversationBo.getImConversation().getLastMsg())
                            .build();
                    // TODO 更新user
                    UserVo userVo = UserVo.builder()
                            .build();
                    return ConversationDataVo.builder()
                            .userVo(userVo)
                            .conversationVo(conversationVo)
                            .build();
                }).collect(Collectors.toList());
    }
}
