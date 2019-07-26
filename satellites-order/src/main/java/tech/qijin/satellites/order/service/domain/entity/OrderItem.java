package tech.qijin.satellites.order.service.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 创建时间: 2019/7/25.
 */
public class OrderItem {

    /**
     * 商品信息
     */
    private Product product;

    /**
     * 下单时该商品的总价格（平摊过优惠的价格）
     */
    private BigDecimal totalAmount;

    private Integer quantity;

    private Date ctime;

    private Date utime;

    private Boolean valid;
}
