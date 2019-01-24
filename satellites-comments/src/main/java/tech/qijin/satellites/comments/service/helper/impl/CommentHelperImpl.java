package tech.qijin.satellites.comments.service.helper.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.satellites.comments.db.dao.CmCommentDao;
import tech.qijin.satellites.comments.db.model.CmComment;
import tech.qijin.satellites.comments.db.model.CmCommentExample;
import tech.qijin.satellites.comments.service.helper.CommentHelper;
import tech.qijin.util4j.lang.constant.ResEnum;
import tech.qijin.util4j.trace.util.ChannelUtil;
import tech.qijin.util4j.utils.MAssert;
import tech.qijin.util4j.web.util.PageHelperProxy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Service
public class CommentHelperImpl implements CommentHelper {

    @Autowired
    private CmCommentDao commentDao;

    @Override
    public void insert(CmComment comment) {
        checkComment(comment);
        commentDao.insertSelective(comment);
    }

    @Override
    public List<CmComment> pageComments() {
        CmCommentExample example = new CmCommentExample();
        example.or().andChannelEqualTo(ChannelUtil.getChannel());
        return PageHelperProxy.getLocalPage()
                .doSelectPage(() -> commentDao.selectByExample(example));
    }

    @Override
    public List<CmComment> pageUserComments(Long userId) {
        CmCommentExample example = new CmCommentExample();
        example.or().andUserIdEqualTo(userId)
                .andChannelEqualTo(ChannelUtil.getChannel())
                .andReplyIdEqualTo(0L);
        return PageHelperProxy.getLocalPage()
                .doSelectPage(() -> commentDao.selectByExample(example));
    }

    @Override
    public List<CmComment> listCommentsByIds(List<Long> ids) {
        CmCommentExample example = new CmCommentExample();
        example.or()
                .andChannelEqualTo(ChannelUtil.getChannel())
                .andIdIn(ids);
        return commentDao.selectByExample(example);
    }

    @Override
    public List<CmComment> listCommentsByBaseIds(List<Long> baseIds) {
        CmCommentExample example = new CmCommentExample();
        example.or()
                .andChannelEqualTo(ChannelUtil.getChannel())
                .andBaseIdIn(baseIds);
        return commentDao.selectByExample(example);
    }

    @Override
    public Map<Long, List<CmComment>> mapCommentsByBaseIds(List<Long> ids) {
        return listCommentsByBaseIds(ids).stream()
                .collect(Collectors.groupingBy(CmComment::getBaseId, Collectors.toList()));
    }

    /**
     * 校验Comment合法性
     *
     * <p>
     * 不校验userId。当userId为空时，认为是匿名用户
     * </p>
     *
     * @param comment
     */
    private void checkComment(CmComment comment) {
        MAssert.notNull(comment, ResEnum.INVALID_PARAM);
        MAssert.notNull(comment.getChannel(), ResEnum.INVALID_PARAM);
        MAssert.isTrue(StringUtils.isNotBlank(comment.getContent()),
                ResEnum.INVALID_PARAM.code, "content can't be blank");
    }
}
