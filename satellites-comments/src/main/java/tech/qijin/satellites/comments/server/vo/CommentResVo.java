package tech.qijin.satellites.comments.server.vo;

import lombok.Data;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class CommentResVo {
    private Long baseId;
    private Long replyId;
    private String content;
    private Long userId;
    private String userName;
}
