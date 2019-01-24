package tech.qijin.satellites.comments.service.impl;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.comments.db.model.CmComment;
import tech.qijin.satellites.comments.service.bo.CommentBo;
import tech.qijin.satellites.comments.service.CommentService;
import tech.qijin.satellites.comments.service.helper.CommentHelper;
import tech.qijin.usercenter.client.util.UserUtil;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.NumberUtil;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentHelper commentHelper;

    @Override
    public CmComment submit(Long baseId, Long replyId, String content) {
        CmComment comment = new CmComment();
        //TODO check baseId and replyId
        comment.setUserId(UserUtil.getUserId());
        comment.setBaseId(baseId);
        comment.setReplyId(replyId);
        comment.setChannel(ChannelUtil.getChannel());
        comment.setContent(content);
        commentHelper.insert(comment);
        return comment;
    }

    @Override
    public List<CommentBo> pageCommentBos() {
        List<CmComment> baseComments = commentHelper.pageComments();
        if (CollectionUtils.isEmpty(baseComments)) {
            return Collections.emptyList();
        }
        List<Long> baseCommentIds = baseComments.stream()
                .map(CmComment::getId)
                .collect(Collectors.toList());
        Map<Long, List<CmComment>> baseCommentsMap = commentHelper.mapCommentsByBaseIds(baseCommentIds);
        return baseComments.stream()
                .map(comment -> {
                    CommentBo commentBo = new CommentBo();
                    commentBo.setBaseComment(comment);
                    List<CmComment> replyComments = baseCommentsMap.get(comment.getId());
                    List<Long> commentIds = getCommentIds(comment, replyComments);
                    commentBo.setCommentIds(commentIds);
                    commentBo.setReplayComments(replyComments);
                    return commentBo;
                }).collect(Collectors.toList());
    }

    @Override
    public List<CommentBo> pageUserCommentBos(Long userId) {
        return null;
    }

    @Override
    public List<CommentBo> pageUserReplyCommentBos(Long userId) {
        return null;
    }

    @Override
    public List<CommentBo> pageUserRepliedCommentBos(Long userId) {
        return null;
    }

    private List<Long> getCommentIds(CmComment baseComment, List<CmComment> replyComments) {
        Long userId = UserUtil.getUserId();
        if (NumberUtil.nullOrLeZero(userId)) {
            return Collections.emptyList();
        }
        List<Long> commentIds = Lists.newArrayList();
        if (baseComment != null && baseComment.getUserId().equals(userId)) {
            commentIds.add(baseComment.getUserId());
        }
        if (CollectionUtils.isNotEmpty(replyComments)) {
            commentIds.addAll(replyComments.stream()
                    .filter(comment -> userId.equals(comment.getUserId()))
                    .map(CmComment::getId)
                    .collect(Collectors.toList()));
        }
        return commentIds;
    }
}
