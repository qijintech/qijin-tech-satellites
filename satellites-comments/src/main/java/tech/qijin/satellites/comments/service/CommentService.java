package tech.qijin.satellites.comments.service;

import tech.qijin.satellites.comments.db.model.CmComment;
import tech.qijin.satellites.comments.service.bo.CommentBo;

import java.util.List;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface CommentService {
    /**
     * 提交评论
     *
     * @param baseId
     * @param replyId
     * @param content
     */
    CmComment submit(Long baseId, Long replyId, String content);

    /**
     * 分页查看所有的基类评论，包含其他用户的回复
     *
     * @return
     */
    List<CommentBo> pageCommentBos();

    /**
     * 分页查看用户自己的基类评论，包含其他用户的回复
     *
     * @param userId
     * @return
     */
    List<CommentBo> pageUserCommentBos(Long userId);

    /**
     * 分页查看用户主动回复的评论
     *
     * @param userId
     * @return
     */
    List<CommentBo> pageUserReplyCommentBos(Long userId);

    /**
     * 分页查看用户被回复的评论
     *
     * @param userId
     * @return
     */
    List<CommentBo> pageUserRepliedCommentBos(Long userId);
}
