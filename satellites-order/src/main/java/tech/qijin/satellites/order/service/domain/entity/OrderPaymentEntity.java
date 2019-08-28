package tech.qijin.satellites.order.service.domain.entity;

import java.util.Date;

/**
 * @version 创建时间: 2019/7/25.
 */
public class OrderPaymentEntity {

    private Long id;

    private String orderNo;

    private Byte paymentType;

    private Byte paymentMethod;

    private Byte paymentStatus;

    private Date paidTime;

    private Integer paymentId;
}
