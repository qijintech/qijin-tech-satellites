package tech.qijin.satellites.comments.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import tech.qijin.satellites.comments.db.model.CmComment;
import tech.qijin.satellites.comments.service.CommentService;
import tech.qijin.satellites.comments.service.bo.CommentBo;
import tech.qijin.util4j.utils.NumberUtil;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/

public class CommentServiceTest extends BaseTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void submit() {
        CmComment comment = commentService.submit(null, null, "再评论");
        Assert.assertNotNull(comment);
        Assert.assertTrue(NumberUtil.gtZero(comment.getId()));
        log.info("commentId={}", comment.getId());
    }

    @Test
    public void reply() {
    }

    @Test
    public void replyReply() {
    }

    @Test
    public void pageCommentBos() {
        List<CommentBo> commentBos = commentService.pageCommentBos();
        log.info("commentBos={}", JSON.toJSONString(commentBos));
    }
}
