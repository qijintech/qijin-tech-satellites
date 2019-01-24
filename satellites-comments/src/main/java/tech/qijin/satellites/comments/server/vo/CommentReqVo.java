package tech.qijin.satellites.comments.server.vo;

import lombok.Data;
import tech.qijin.util4j.lang.vo.PageVo;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class CommentReqVo extends PageVo {
    private Long baseId;
    private Long replyId;
    private String content;
}
