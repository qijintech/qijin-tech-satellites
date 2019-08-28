package tech.qijin.satellites.user.auth.pojo;

import java.io.Serializable;

import lombok.Data;
import tech.qijin.util4j.trace.pojo.Channel;

/**
 * @author michealyang
 * @date 2019/1/8
 * 开始做眼保健操：←_← ↑_↑ →_→ ↓_↓
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 4088551383729239719L;
    private Long userId;
    private String userName;
    private Channel channel;
}
