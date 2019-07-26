package tech.qijin.satellites.order.service.domain.entity;

import java.math.BigDecimal;

/**
 * @version 创建时间: 2019/7/25.
 */
public class Product {
    private Integer skuId;

    private String skuName;

    private String skuPic;

    private String skuDesc;

    private BigDecimal skuOriginPrice;

    private BigDecimal skuPrice;

    private BigDecimal skuOrderPrice;

    private BigDecimal itemReducedAmount;

    private Byte orderPriceType;

    private Integer categoryId;

    private Integer quantity;

    private String skuUnit;

    private String skuUnitDesc;

    private Integer orderStock;

}
