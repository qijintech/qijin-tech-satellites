package tech.qijin.satellites.order.service.domain.entity;

import java.util.List;

/**
 * @version 创建时间: 2019/7/25.
 */
public class OrderAggre {

    private Long id;

    private String orderNo;

    private OrderSummaryEntity summaryInfo;

    /**
     * 配送信息
     */
    private OrderRecipientEntity recipientInfo;

    /**
     * 付款信息
     */
    private OrderPaymentEntity orderPaymentEntity;

    /**
     * 订单明细
     */
    private List<OrderItem> orderItemList;
}