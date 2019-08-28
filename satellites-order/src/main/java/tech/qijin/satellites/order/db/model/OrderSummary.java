package tech.qijin.satellites.order.db.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderSummary {
    private Long id;

    private Long formerOrderId;

    private String orderNo;

    private Long acctId;

    private Long customerId;

    private String customerName;

    private Long poiId;

    private String poiName;

    private Byte poiType;

    private Long recipientInfoId;

    private String remark;

    private String cancelExcuse;

    private String cancelRemark;

    private String rejectExcuse;

    private Integer cityId;

    private Short status;

    private Byte paymentType;

    private Byte paymentMethod;

    private Byte paymentStatus;

    private Date paidTime;

    private Integer paymentId;

    private BigDecimal originAmount;

    private BigDecimal totalAmount;

    private BigDecimal orderAmount;

    private BigDecimal reducedAmount;

    private Byte orderType;

    private Byte source;

    private Short version;

    private Boolean valid;

    private Integer creatorId;

    private Date ctime;

    private Date utime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFormerOrderId() {
        return formerOrderId;
    }

    public void setFormerOrderId(Long formerOrderId) {
        this.formerOrderId = formerOrderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Long getPoiId() {
        return poiId;
    }

    public void setPoiId(Long poiId) {
        this.poiId = poiId;
    }

    public String getPoiName() {
        return poiName;
    }

    public void setPoiName(String poiName) {
        this.poiName = poiName == null ? null : poiName.trim();
    }

    public Byte getPoiType() {
        return poiType;
    }

    public void setPoiType(Byte poiType) {
        this.poiType = poiType;
    }

    public Long getRecipientInfoId() {
        return recipientInfoId;
    }

    public void setRecipientInfoId(Long recipientInfoId) {
        this.recipientInfoId = recipientInfoId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCancelExcuse() {
        return cancelExcuse;
    }

    public void setCancelExcuse(String cancelExcuse) {
        this.cancelExcuse = cancelExcuse == null ? null : cancelExcuse.trim();
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark == null ? null : cancelRemark.trim();
    }

    public String getRejectExcuse() {
        return rejectExcuse;
    }

    public void setRejectExcuse(String rejectExcuse) {
        this.rejectExcuse = rejectExcuse == null ? null : rejectExcuse.trim();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Byte paymentType) {
        this.paymentType = paymentType;
    }

    public Byte getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Byte paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Byte getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Byte paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(BigDecimal originAmount) {
        this.originAmount = originAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getReducedAmount() {
        return reducedAmount;
    }

    public void setReducedAmount(BigDecimal reducedAmount) {
        this.reducedAmount = reducedAmount;
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
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