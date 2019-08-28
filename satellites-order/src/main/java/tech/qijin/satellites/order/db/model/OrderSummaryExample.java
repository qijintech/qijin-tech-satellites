package tech.qijin.satellites.order.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderSummaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdIsNull() {
            addCriterion("former_order_id is null");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdIsNotNull() {
            addCriterion("former_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdEqualTo(Long value) {
            addCriterion("former_order_id =", value, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdNotEqualTo(Long value) {
            addCriterion("former_order_id <>", value, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdGreaterThan(Long value) {
            addCriterion("former_order_id >", value, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("former_order_id >=", value, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdLessThan(Long value) {
            addCriterion("former_order_id <", value, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("former_order_id <=", value, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdIn(List<Long> values) {
            addCriterion("former_order_id in", values, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdNotIn(List<Long> values) {
            addCriterion("former_order_id not in", values, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdBetween(Long value1, Long value2) {
            addCriterion("former_order_id between", value1, value2, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andFormerOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("former_order_id not between", value1, value2, "formerOrderId");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNull() {
            addCriterion("acct_id is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("acct_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(Long value) {
            addCriterion("acct_id =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(Long value) {
            addCriterion("acct_id <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(Long value) {
            addCriterion("acct_id >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(Long value) {
            addCriterion("acct_id >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(Long value) {
            addCriterion("acct_id <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(Long value) {
            addCriterion("acct_id <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<Long> values) {
            addCriterion("acct_id in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<Long> values) {
            addCriterion("acct_id not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(Long value1, Long value2) {
            addCriterion("acct_id between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(Long value1, Long value2) {
            addCriterion("acct_id not between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(Long value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(Long value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(Long value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(Long value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(Long value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<Long> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<Long> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(Long value1, Long value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(Long value1, Long value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNull() {
            addCriterion("customer_name is null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIsNotNull() {
            addCriterion("customer_name is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerNameEqualTo(String value) {
            addCriterion("customer_name =", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotEqualTo(String value) {
            addCriterion("customer_name <>", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThan(String value) {
            addCriterion("customer_name >", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameGreaterThanOrEqualTo(String value) {
            addCriterion("customer_name >=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThan(String value) {
            addCriterion("customer_name <", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLessThanOrEqualTo(String value) {
            addCriterion("customer_name <=", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameLike(String value) {
            addCriterion("customer_name like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotLike(String value) {
            addCriterion("customer_name not like", value, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameIn(List<String> values) {
            addCriterion("customer_name in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotIn(List<String> values) {
            addCriterion("customer_name not in", values, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameBetween(String value1, String value2) {
            addCriterion("customer_name between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andCustomerNameNotBetween(String value1, String value2) {
            addCriterion("customer_name not between", value1, value2, "customerName");
            return (Criteria) this;
        }

        public Criteria andPoiIdIsNull() {
            addCriterion("poi_id is null");
            return (Criteria) this;
        }

        public Criteria andPoiIdIsNotNull() {
            addCriterion("poi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPoiIdEqualTo(Long value) {
            addCriterion("poi_id =", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdNotEqualTo(Long value) {
            addCriterion("poi_id <>", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdGreaterThan(Long value) {
            addCriterion("poi_id >", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdGreaterThanOrEqualTo(Long value) {
            addCriterion("poi_id >=", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdLessThan(Long value) {
            addCriterion("poi_id <", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdLessThanOrEqualTo(Long value) {
            addCriterion("poi_id <=", value, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdIn(List<Long> values) {
            addCriterion("poi_id in", values, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdNotIn(List<Long> values) {
            addCriterion("poi_id not in", values, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdBetween(Long value1, Long value2) {
            addCriterion("poi_id between", value1, value2, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiIdNotBetween(Long value1, Long value2) {
            addCriterion("poi_id not between", value1, value2, "poiId");
            return (Criteria) this;
        }

        public Criteria andPoiNameIsNull() {
            addCriterion("poi_name is null");
            return (Criteria) this;
        }

        public Criteria andPoiNameIsNotNull() {
            addCriterion("poi_name is not null");
            return (Criteria) this;
        }

        public Criteria andPoiNameEqualTo(String value) {
            addCriterion("poi_name =", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameNotEqualTo(String value) {
            addCriterion("poi_name <>", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameGreaterThan(String value) {
            addCriterion("poi_name >", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameGreaterThanOrEqualTo(String value) {
            addCriterion("poi_name >=", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameLessThan(String value) {
            addCriterion("poi_name <", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameLessThanOrEqualTo(String value) {
            addCriterion("poi_name <=", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameLike(String value) {
            addCriterion("poi_name like", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameNotLike(String value) {
            addCriterion("poi_name not like", value, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameIn(List<String> values) {
            addCriterion("poi_name in", values, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameNotIn(List<String> values) {
            addCriterion("poi_name not in", values, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameBetween(String value1, String value2) {
            addCriterion("poi_name between", value1, value2, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiNameNotBetween(String value1, String value2) {
            addCriterion("poi_name not between", value1, value2, "poiName");
            return (Criteria) this;
        }

        public Criteria andPoiTypeIsNull() {
            addCriterion("poi_type is null");
            return (Criteria) this;
        }

        public Criteria andPoiTypeIsNotNull() {
            addCriterion("poi_type is not null");
            return (Criteria) this;
        }

        public Criteria andPoiTypeEqualTo(Byte value) {
            addCriterion("poi_type =", value, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeNotEqualTo(Byte value) {
            addCriterion("poi_type <>", value, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeGreaterThan(Byte value) {
            addCriterion("poi_type >", value, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("poi_type >=", value, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeLessThan(Byte value) {
            addCriterion("poi_type <", value, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeLessThanOrEqualTo(Byte value) {
            addCriterion("poi_type <=", value, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeIn(List<Byte> values) {
            addCriterion("poi_type in", values, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeNotIn(List<Byte> values) {
            addCriterion("poi_type not in", values, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeBetween(Byte value1, Byte value2) {
            addCriterion("poi_type between", value1, value2, "poiType");
            return (Criteria) this;
        }

        public Criteria andPoiTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("poi_type not between", value1, value2, "poiType");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdIsNull() {
            addCriterion("recipient_info_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdIsNotNull() {
            addCriterion("recipient_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdEqualTo(Long value) {
            addCriterion("recipient_info_id =", value, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdNotEqualTo(Long value) {
            addCriterion("recipient_info_id <>", value, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdGreaterThan(Long value) {
            addCriterion("recipient_info_id >", value, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recipient_info_id >=", value, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdLessThan(Long value) {
            addCriterion("recipient_info_id <", value, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdLessThanOrEqualTo(Long value) {
            addCriterion("recipient_info_id <=", value, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdIn(List<Long> values) {
            addCriterion("recipient_info_id in", values, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdNotIn(List<Long> values) {
            addCriterion("recipient_info_id not in", values, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdBetween(Long value1, Long value2) {
            addCriterion("recipient_info_id between", value1, value2, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRecipientInfoIdNotBetween(Long value1, Long value2) {
            addCriterion("recipient_info_id not between", value1, value2, "recipientInfoId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseIsNull() {
            addCriterion("cancel_excuse is null");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseIsNotNull() {
            addCriterion("cancel_excuse is not null");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseEqualTo(String value) {
            addCriterion("cancel_excuse =", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseNotEqualTo(String value) {
            addCriterion("cancel_excuse <>", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseGreaterThan(String value) {
            addCriterion("cancel_excuse >", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_excuse >=", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseLessThan(String value) {
            addCriterion("cancel_excuse <", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseLessThanOrEqualTo(String value) {
            addCriterion("cancel_excuse <=", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseLike(String value) {
            addCriterion("cancel_excuse like", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseNotLike(String value) {
            addCriterion("cancel_excuse not like", value, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseIn(List<String> values) {
            addCriterion("cancel_excuse in", values, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseNotIn(List<String> values) {
            addCriterion("cancel_excuse not in", values, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseBetween(String value1, String value2) {
            addCriterion("cancel_excuse between", value1, value2, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelExcuseNotBetween(String value1, String value2) {
            addCriterion("cancel_excuse not between", value1, value2, "cancelExcuse");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkIsNull() {
            addCriterion("cancel_remark is null");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkIsNotNull() {
            addCriterion("cancel_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkEqualTo(String value) {
            addCriterion("cancel_remark =", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkNotEqualTo(String value) {
            addCriterion("cancel_remark <>", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkGreaterThan(String value) {
            addCriterion("cancel_remark >", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_remark >=", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkLessThan(String value) {
            addCriterion("cancel_remark <", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkLessThanOrEqualTo(String value) {
            addCriterion("cancel_remark <=", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkLike(String value) {
            addCriterion("cancel_remark like", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkNotLike(String value) {
            addCriterion("cancel_remark not like", value, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkIn(List<String> values) {
            addCriterion("cancel_remark in", values, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkNotIn(List<String> values) {
            addCriterion("cancel_remark not in", values, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkBetween(String value1, String value2) {
            addCriterion("cancel_remark between", value1, value2, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andCancelRemarkNotBetween(String value1, String value2) {
            addCriterion("cancel_remark not between", value1, value2, "cancelRemark");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseIsNull() {
            addCriterion("reject_excuse is null");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseIsNotNull() {
            addCriterion("reject_excuse is not null");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseEqualTo(String value) {
            addCriterion("reject_excuse =", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseNotEqualTo(String value) {
            addCriterion("reject_excuse <>", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseGreaterThan(String value) {
            addCriterion("reject_excuse >", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseGreaterThanOrEqualTo(String value) {
            addCriterion("reject_excuse >=", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseLessThan(String value) {
            addCriterion("reject_excuse <", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseLessThanOrEqualTo(String value) {
            addCriterion("reject_excuse <=", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseLike(String value) {
            addCriterion("reject_excuse like", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseNotLike(String value) {
            addCriterion("reject_excuse not like", value, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseIn(List<String> values) {
            addCriterion("reject_excuse in", values, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseNotIn(List<String> values) {
            addCriterion("reject_excuse not in", values, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseBetween(String value1, String value2) {
            addCriterion("reject_excuse between", value1, value2, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andRejectExcuseNotBetween(String value1, String value2) {
            addCriterion("reject_excuse not between", value1, value2, "rejectExcuse");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNull() {
            addCriterion("payment_type is null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIsNotNull() {
            addCriterion("payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeEqualTo(Byte value) {
            addCriterion("payment_type =", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotEqualTo(Byte value) {
            addCriterion("payment_type <>", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThan(Byte value) {
            addCriterion("payment_type >", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_type >=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThan(Byte value) {
            addCriterion("payment_type <", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeLessThanOrEqualTo(Byte value) {
            addCriterion("payment_type <=", value, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeIn(List<Byte> values) {
            addCriterion("payment_type in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotIn(List<Byte> values) {
            addCriterion("payment_type not in", values, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeBetween(Byte value1, Byte value2) {
            addCriterion("payment_type between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_type not between", value1, value2, "paymentType");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(Byte value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(Byte value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(Byte value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(Byte value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(Byte value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<Byte> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<Byte> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(Byte value1, Byte value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(Byte value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(Byte value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(Byte value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(Byte value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<Byte> values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<Byte> values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(Byte value1, Byte value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNull() {
            addCriterion("paid_time is null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNotNull() {
            addCriterion("paid_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeEqualTo(Date value) {
            addCriterion("paid_time =", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotEqualTo(Date value) {
            addCriterion("paid_time <>", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThan(Date value) {
            addCriterion("paid_time >", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paid_time >=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThan(Date value) {
            addCriterion("paid_time <", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThanOrEqualTo(Date value) {
            addCriterion("paid_time <=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIn(List<Date> values) {
            addCriterion("paid_time in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotIn(List<Date> values) {
            addCriterion("paid_time not in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeBetween(Date value1, Date value2) {
            addCriterion("paid_time between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotBetween(Date value1, Date value2) {
            addCriterion("paid_time not between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Integer value) {
            addCriterion("payment_id =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Integer value) {
            addCriterion("payment_id <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Integer value) {
            addCriterion("payment_id >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_id >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Integer value) {
            addCriterion("payment_id <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Integer value) {
            addCriterion("payment_id <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Integer> values) {
            addCriterion("payment_id in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Integer> values) {
            addCriterion("payment_id not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Integer value1, Integer value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andOriginAmountIsNull() {
            addCriterion("origin_amount is null");
            return (Criteria) this;
        }

        public Criteria andOriginAmountIsNotNull() {
            addCriterion("origin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOriginAmountEqualTo(BigDecimal value) {
            addCriterion("origin_amount =", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountNotEqualTo(BigDecimal value) {
            addCriterion("origin_amount <>", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountGreaterThan(BigDecimal value) {
            addCriterion("origin_amount >", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("origin_amount >=", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountLessThan(BigDecimal value) {
            addCriterion("origin_amount <", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("origin_amount <=", value, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountIn(List<BigDecimal> values) {
            addCriterion("origin_amount in", values, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountNotIn(List<BigDecimal> values) {
            addCriterion("origin_amount not in", values, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("origin_amount between", value1, value2, "originAmount");
            return (Criteria) this;
        }

        public Criteria andOriginAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("origin_amount not between", value1, value2, "originAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNull() {
            addCriterion("total_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIsNotNull() {
            addCriterion("total_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalAmountEqualTo(BigDecimal value) {
            addCriterion("total_amount =", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotEqualTo(BigDecimal value) {
            addCriterion("total_amount <>", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThan(BigDecimal value) {
            addCriterion("total_amount >", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount >=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThan(BigDecimal value) {
            addCriterion("total_amount <", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_amount <=", value, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountIn(List<BigDecimal> values) {
            addCriterion("total_amount in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotIn(List<BigDecimal> values) {
            addCriterion("total_amount not in", values, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andTotalAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_amount not between", value1, value2, "totalAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountIsNull() {
            addCriterion("reduced_amount is null");
            return (Criteria) this;
        }

        public Criteria andReducedAmountIsNotNull() {
            addCriterion("reduced_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReducedAmountEqualTo(BigDecimal value) {
            addCriterion("reduced_amount =", value, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountNotEqualTo(BigDecimal value) {
            addCriterion("reduced_amount <>", value, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountGreaterThan(BigDecimal value) {
            addCriterion("reduced_amount >", value, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reduced_amount >=", value, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountLessThan(BigDecimal value) {
            addCriterion("reduced_amount <", value, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reduced_amount <=", value, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountIn(List<BigDecimal> values) {
            addCriterion("reduced_amount in", values, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountNotIn(List<BigDecimal> values) {
            addCriterion("reduced_amount not in", values, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduced_amount between", value1, value2, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andReducedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reduced_amount not between", value1, value2, "reducedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(Byte value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(Byte value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(Byte value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(Byte value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(Byte value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<Byte> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<Byte> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(Byte value1, Byte value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(Byte value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(Byte value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(Byte value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(Byte value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(Byte value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<Byte> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<Byte> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(Byte value1, Byte value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Short value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Short value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Short value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Short value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Short value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Short value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Short> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Short> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Short value1, Short value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Short value1, Short value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valid not between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Integer value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Integer value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Integer value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Integer value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Integer> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Integer> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNull() {
            addCriterion("utime is null");
            return (Criteria) this;
        }

        public Criteria andUtimeIsNotNull() {
            addCriterion("utime is not null");
            return (Criteria) this;
        }

        public Criteria andUtimeEqualTo(Date value) {
            addCriterion("utime =", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotEqualTo(Date value) {
            addCriterion("utime <>", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThan(Date value) {
            addCriterion("utime >", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("utime >=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThan(Date value) {
            addCriterion("utime <", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeLessThanOrEqualTo(Date value) {
            addCriterion("utime <=", value, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeIn(List<Date> values) {
            addCriterion("utime in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotIn(List<Date> values) {
            addCriterion("utime not in", values, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeBetween(Date value1, Date value2) {
            addCriterion("utime between", value1, value2, "utime");
            return (Criteria) this;
        }

        public Criteria andUtimeNotBetween(Date value1, Date value2) {
            addCriterion("utime not between", value1, value2, "utime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}