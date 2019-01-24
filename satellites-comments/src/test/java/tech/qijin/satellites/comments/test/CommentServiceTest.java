package tech.qijin.satellites.comments.test;

import com.alibaba.fastjson.JSON;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.qijin.satellites.comments.db.model.CmComment;
import tech.qijin.satellites.comments.service.CommentService;
import tech.qijin.satellites.comments.service.bo.CommentBo;
import tech.qijin.usercenter.client.pojo.User;
import tech.qijin.usercenter.client.util.UserUtil;
import tech.qijin.util4j.utils.NumberUtil;

import java.util.List;

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
        User user = new User();
        user.setUserId(10010L);
        UserUtil.setUser(user);
        CmComment comment = commentService.submit(4L, 4L, "来自" + user.getUserId() + "的回复");
        Assert.assertNotNull(comment);
        Assert.assertTrue(NumberUtil.gtZero(comment.getId()));
        log.info("commentId={}", comment.getId());
    }

    @Test
    public void replyReply() {
        User user = new User();
        user.setUserId(10000L);
        UserUtil.setUser(user);
        commentService.submit(4L, 5L, "来自" + user.getUserId() + "的回复");
    }

    @Test
    public void pageCommentBos() {
        List<CommentBo> commentBos = commentService.pageCommentBos();
        log.info("commentBos={}", JSON.toJSONString(commentBos));
    }
}
