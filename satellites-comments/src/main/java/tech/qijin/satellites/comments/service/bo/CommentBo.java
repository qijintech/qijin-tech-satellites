package tech.qijin.satellites.comments.service.bo;

import lombok.Data;
import lombok.ToString;
import tech.qijin.satellites.comments.db.model.CmComment;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
@ToString
public class CommentBo {
    /**
     * 基类评论
     */
    private CmComment baseComment;
    /**
     * 自己的评论id
     */
    private List<Long> commentIds;
    /**
     * 回复的评论
     */
    private List<CmComment> replayComments;
}
