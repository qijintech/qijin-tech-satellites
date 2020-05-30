package tech.qijin.satellites.im.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.qijin.cell.im.db.model.ImMessage;
import tech.qijin.satellites.im.server.vo.MessageRespVo;
import tech.qijin.satellites.im.server.vo.MessageSendReqVo;
import tech.qijin.satellites.im.server.vo.MessageVo;
import tech.qijin.satellites.im.service.StMessageService;
import tech.qijin.satellites.im.service.bo.MessageBo;
import tech.qijin.util4j.web.interceptor.annotation.ChannelRequired;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 消息相关操作
 * <p>
 * 包含功能:
 * <ul>
 * <li>发送消息</li>
 * <li>拉取最新消息</li>
 * <li>拉取历史消息</li>
 * <li>撤回消息 - Optional</li>
 * <li>删除消息 - Optional</li>
 * <li>已读回执 - Optional</li>
 * <li>消息转发 - Optional</li>
 * <li>消息引用 - Optional</li>
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
@RequestMapping("/api/v1/im/base/message")
public class StMessageController {
    @Autowired
    private StMessageService stMessageService;

    /**
     * 发送消息
     * <p>
     * 支持的消息类型：
     * <ul>
     * <li>文本</li>
     * <li>表情</li>
     * <li>图片</li>
     * <li>语音</li>
     * <li>视频</li>
     * <li>地理位置</li>
     * </ul>
     * </p>
     *
     * @return
     */
    @ChannelRequired
    @PostMapping("/send")
    public Long sendMessage(@NotNull Long uid, @Valid @RequestBody MessageSendReqVo messageSendReqVo) {
        return stMessageService.sendMessage(uid, messageSendReqVo);
    }

    @ChannelRequired
    @GetMapping("/list/history")
    public MessageRespVo listMessageHistory(@NotNull Long uid,
                                            @NotNull Long peerUid,
                                            Long msgId,
                                            Integer count) {
        List<MessageBo> messageBos = stMessageService.listMessageHistory(uid, peerUid, msgId, count);
        return MessageRespVo.builder()
                .user(null)
                .peer(null)
                .messages(messageBos.stream().map(this::convert).collect(Collectors.toList()))
                .build();
    }

    @ChannelRequired
    @GetMapping("/list/new")
    public MessageRespVo listMessageNew(@NotNull Long uid,
                                        @NotNull Long peerUid,
                                        Long msgId,
                                        Integer count) {
        List<MessageBo> messageBos = stMessageService.listMessageNew(uid, peerUid, msgId, count);
        return MessageRespVo.builder()
                .user(null)
                .peer(null)
                .messages(messageBos.stream().map(this::convert).collect(Collectors.toList()))
                .build();
    }

    private MessageVo convert(MessageBo messageBo) {
        if (messageBo == null || messageBo.getCellImMessageBo() == null) {
            return null;
        }
        ImMessage imMessage = messageBo.getCellImMessageBo().getImMessage();
        return MessageVo.builder()
                .msgId(imMessage.getMsgId())
                .msgType(imMessage.getMsgType())
                .fromUid(imMessage.getFromUid())
                .toUid(messageBo.getCellImMessageBo().getToUid())
                .content(messageBo.getCellImMessageBo().getContent())
                .readStatus(imMessage.getReadStatus())
                .createTime(imMessage.getCreateTime())
                .updateTime(imMessage.getUpdateTime())
                .build();
    }
}
