package tech.qijin.satellites.order.service.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version 创建时间: 2019/7/25.
 */
public class OrderSummaryEntity {
    private Long id;

    private String orderNo;
    /**
     * 下订单客户信息
     */
    private Long acctId;

    private Long customerId;

    private String customerName;

    /**
     * 门店Id
     */
    private Long poiId;

    /**
     * 门店名称
     */
    private String poiName;

    /**
     * 门店类型
     */
    private Byte poiType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 城市
     */
    private Integer cityId;
    /**
     * 订单状态
     */
    private Short status;

    /**
     * 原价，划掉的价格
     */
    private BigDecimal originPrice;

    /**
     * 下单的价格
     */
    private BigDecimal orderPrice;

    /**
     * 订单类型:1-自下单，2-换货订单
     */
    private Byte orderType;

    private Short version;

    private Boolean valid;

    /**
     * 代下单时下单人ID
     */
    private Integer creatorId;

    private Date ctime;

    private Date utime;

}
