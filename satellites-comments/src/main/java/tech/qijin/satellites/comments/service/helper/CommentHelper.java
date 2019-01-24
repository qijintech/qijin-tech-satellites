package tech.qijin.satellites.comments.service.helper;

import tech.qijin.satellites.comments.db.model.CmComment;
import tech.qijin.satellites.comments.service.bo.CommentBo;

import java.util.List;
import java.util.Map;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
public interface CommentHelper {
    void insert(CmComment comment);


    /**
     * 分页查看所有基类评论
     * <p>
     * 所谓“基类评论”，是指不包含回复的评论
     * </p>
     *
     * @return
     */
    List<CmComment> pageComments();

    /**
     * 分页查看指定用户自己的基类评论
     *
     * @return
     */
    List<CmComment> pageUserComments(Long userId);

    /**
     * 根据comment id的列表查询comment
     *
     * @param baseIds
     * @return
     */
    List<CmComment> listCommentsByIds(List<Long> baseIds);

    /**
     * 根据base id的列表查询comment
     *
     * @param ids
     * @return
     */
    List<CmComment> listCommentsByBaseIds(List<Long> ids);

    /**
     * 根据base id的列表查询comment，返回baseId与comment list的映射
     *
     * @param ids
     * @return
     */
    Map<Long, List<CmComment>> mapCommentsByBaseIds(List<Long> ids);
}
