package tech.qijin.satellites.comments.server.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tech.qijin.satellites.comments.server.vo.CommentReqVo;
import tech.qijin.satellites.comments.service.CommentService;
import tech.qijin.satellites.comments.service.bo.CommentBo;
import tech.qijin.util4j.web.annotation.ChannelRequired;
import tech.qijin.util4j.web.pojo.ResultVo;

/**
 * @author michealyang
 * @date 2019/1/6
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ChannelRequired
    @PostMapping("/submit")
    public ResultVo submit(@RequestBody CommentReqVo commentVo) {
        return ResultVo.instance().success();
    }

    @ChannelRequired
    @GetMapping("/list")
    public List<CommentBo> list() {
        return commentService.pageCommentBos();
    }
}
