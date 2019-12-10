package tech.qijin.satellites.im.server.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.qijin.util4j.web.pojo.ResultVo;

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
@RestController
@RequestMapping("/api/v1/im/base/message")
public class MessageController {

    @GetMapping("/echo")
    public ResultVo echo(String msg) {
        return ResultVo.instance().data(msg);
    }
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
    @PostMapping("/send")
    public Object sendMessage() {
        return null;
    }
}
