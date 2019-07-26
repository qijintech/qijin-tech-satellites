package tech.qijin.satellites.order.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
    private Long id;

    private Long orderId;

    private String orderNo;

    private Integer skuId;

    private String skuName;

    private String skuPic;

    private String skuDesc;

    private BigDecimal skuOriginPrice;

    private BigDecimal skuSalesPrice;

    private BigDecimal skuOrderAmount;

    private BigDecimal itemReducedAmount;

    private Byte orderPriceType;

    private Integer categoryId;

    private Integer quantity;

    private String skuUnit;

    private String skuUnitDesc;

    private Integer orderStock;

    private Boolean valid;

    private Date ctime;

    private Date utime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public String getSkuPic() {
        return skuPic;
    }

    public void setSkuPic(String skuPic) {
        this.skuPic = skuPic == null ? null : skuPic.trim();
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc == null ? null : skuDesc.trim();
    }

    public BigDecimal getSkuOriginPrice() {
        return skuOriginPrice;
    }

    public void setSkuOriginPrice(BigDecimal skuOriginPrice) {
        this.skuOriginPrice = skuOriginPrice;
    }

    public BigDecimal getSkuSalesPrice() {
        return skuSalesPrice;
    }

    public void setSkuSalesPrice(BigDecimal skuSalesPrice) {
        this.skuSalesPrice = skuSalesPrice;
    }

    public BigDecimal getSkuOrderAmount() {
        return skuOrderAmount;
    }

    public void setSkuOrderAmount(BigDecimal skuOrderAmount) {
        this.skuOrderAmount = skuOrderAmount;
    }

    public BigDecimal getItemReducedAmount() {
        return itemReducedAmount;
    }

    public void setItemReducedAmount(BigDecimal itemReducedAmount) {
        this.itemReducedAmount = itemReducedAmount;
    }

    public Byte getOrderPriceType() {
        return orderPriceType;
    }

    public void setOrderPriceType(Byte orderPriceType) {
        this.orderPriceType = orderPriceType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSkuUnit() {
        return skuUnit;
    }

    public void setSkuUnit(String skuUnit) {
        this.skuUnit = skuUnit == null ? null : skuUnit.trim();
    }

    public String getSkuUnitDesc() {
        return skuUnitDesc;
    }

    public void setSkuUnitDesc(String skuUnitDesc) {
        this.skuUnitDesc = skuUnitDesc == null ? null : skuUnitDesc.trim();
    }

    public Integer getOrderStock() {
        return orderStock;
    }

    public void setOrderStock(Integer orderStock) {
        this.orderStock = orderStock;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}