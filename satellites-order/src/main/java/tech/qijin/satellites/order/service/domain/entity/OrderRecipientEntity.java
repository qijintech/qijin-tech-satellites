package tech.qijin.satellites.order.service.domain.entity;

import java.util.Date;

/**
 * @version 创建时间: 2019/7/25.
 */
public class OrderRecipientEntity {

    private Long id;

    private Long orderId;

    private String orderNo;

    private String recipientName;

    private String recipientTel;

    private String recipientAddr;

    private String expressNo;

    private Boolean valid;

    private Date ctime;

    private Date utime;
}
