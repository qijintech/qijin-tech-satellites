package tech.qijin.satellites.order.db.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Integer> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Integer> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNull() {
            addCriterion("sku_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNotNull() {
            addCriterion("sku_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuNameEqualTo(String value) {
            addCriterion("sku_name =", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotEqualTo(String value) {
            addCriterion("sku_name <>", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThan(String value) {
            addCriterion("sku_name >", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_name >=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThan(String value) {
            addCriterion("sku_name <", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanOrEqualTo(String value) {
            addCriterion("sku_name <=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLike(String value) {
            addCriterion("sku_name like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotLike(String value) {
            addCriterion("sku_name not like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameIn(List<String> values) {
            addCriterion("sku_name in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotIn(List<String> values) {
            addCriterion("sku_name not in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameBetween(String value1, String value2) {
            addCriterion("sku_name between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotBetween(String value1, String value2) {
            addCriterion("sku_name not between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuPicIsNull() {
            addCriterion("sku_pic is null");
            return (Criteria) this;
        }

        public Criteria andSkuPicIsNotNull() {
            addCriterion("sku_pic is not null");
            return (Criteria) this;
        }

        public Criteria andSkuPicEqualTo(String value) {
            addCriterion("sku_pic =", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicNotEqualTo(String value) {
            addCriterion("sku_pic <>", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicGreaterThan(String value) {
            addCriterion("sku_pic >", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicGreaterThanOrEqualTo(String value) {
            addCriterion("sku_pic >=", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicLessThan(String value) {
            addCriterion("sku_pic <", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicLessThanOrEqualTo(String value) {
            addCriterion("sku_pic <=", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicLike(String value) {
            addCriterion("sku_pic like", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicNotLike(String value) {
            addCriterion("sku_pic not like", value, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicIn(List<String> values) {
            addCriterion("sku_pic in", values, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicNotIn(List<String> values) {
            addCriterion("sku_pic not in", values, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicBetween(String value1, String value2) {
            addCriterion("sku_pic between", value1, value2, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuPicNotBetween(String value1, String value2) {
            addCriterion("sku_pic not between", value1, value2, "skuPic");
            return (Criteria) this;
        }

        public Criteria andSkuDescIsNull() {
            addCriterion("sku_desc is null");
            return (Criteria) this;
        }

        public Criteria andSkuDescIsNotNull() {
            addCriterion("sku_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSkuDescEqualTo(String value) {
            addCriterion("sku_desc =", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescNotEqualTo(String value) {
            addCriterion("sku_desc <>", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescGreaterThan(String value) {
            addCriterion("sku_desc >", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescGreaterThanOrEqualTo(String value) {
            addCriterion("sku_desc >=", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescLessThan(String value) {
            addCriterion("sku_desc <", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescLessThanOrEqualTo(String value) {
            addCriterion("sku_desc <=", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescLike(String value) {
            addCriterion("sku_desc like", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescNotLike(String value) {
            addCriterion("sku_desc not like", value, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescIn(List<String> values) {
            addCriterion("sku_desc in", values, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescNotIn(List<String> values) {
            addCriterion("sku_desc not in", values, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescBetween(String value1, String value2) {
            addCriterion("sku_desc between", value1, value2, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuDescNotBetween(String value1, String value2) {
            addCriterion("sku_desc not between", value1, value2, "skuDesc");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceIsNull() {
            addCriterion("sku_origin_price is null");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceIsNotNull() {
            addCriterion("sku_origin_price is not null");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceEqualTo(BigDecimal value) {
            addCriterion("sku_origin_price =", value, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceNotEqualTo(BigDecimal value) {
            addCriterion("sku_origin_price <>", value, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceGreaterThan(BigDecimal value) {
            addCriterion("sku_origin_price >", value, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sku_origin_price >=", value, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceLessThan(BigDecimal value) {
            addCriterion("sku_origin_price <", value, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sku_origin_price <=", value, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceIn(List<BigDecimal> values) {
            addCriterion("sku_origin_price in", values, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceNotIn(List<BigDecimal> values) {
            addCriterion("sku_origin_price not in", values, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sku_origin_price between", value1, value2, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOriginPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sku_origin_price not between", value1, value2, "skuOriginPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceIsNull() {
            addCriterion("sku_sales_price is null");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceIsNotNull() {
            addCriterion("sku_sales_price is not null");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceEqualTo(BigDecimal value) {
            addCriterion("sku_sales_price =", value, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceNotEqualTo(BigDecimal value) {
            addCriterion("sku_sales_price <>", value, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceGreaterThan(BigDecimal value) {
            addCriterion("sku_sales_price >", value, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sku_sales_price >=", value, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceLessThan(BigDecimal value) {
            addCriterion("sku_sales_price <", value, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sku_sales_price <=", value, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceIn(List<BigDecimal> values) {
            addCriterion("sku_sales_price in", values, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceNotIn(List<BigDecimal> values) {
            addCriterion("sku_sales_price not in", values, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sku_sales_price between", value1, value2, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuSalesPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sku_sales_price not between", value1, value2, "skuSalesPrice");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountIsNull() {
            addCriterion("sku_order_amount is null");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountIsNotNull() {
            addCriterion("sku_order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountEqualTo(BigDecimal value) {
            addCriterion("sku_order_amount =", value, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("sku_order_amount <>", value, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("sku_order_amount >", value, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sku_order_amount >=", value, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountLessThan(BigDecimal value) {
            addCriterion("sku_order_amount <", value, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sku_order_amount <=", value, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountIn(List<BigDecimal> values) {
            addCriterion("sku_order_amount in", values, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("sku_order_amount not in", values, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sku_order_amount between", value1, value2, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andSkuOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sku_order_amount not between", value1, value2, "skuOrderAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountIsNull() {
            addCriterion("item_reduced_amount is null");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountIsNotNull() {
            addCriterion("item_reduced_amount is not null");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountEqualTo(BigDecimal value) {
            addCriterion("item_reduced_amount =", value, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountNotEqualTo(BigDecimal value) {
            addCriterion("item_reduced_amount <>", value, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountGreaterThan(BigDecimal value) {
            addCriterion("item_reduced_amount >", value, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("item_reduced_amount >=", value, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountLessThan(BigDecimal value) {
            addCriterion("item_reduced_amount <", value, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("item_reduced_amount <=", value, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountIn(List<BigDecimal> values) {
            addCriterion("item_reduced_amount in", values, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountNotIn(List<BigDecimal> values) {
            addCriterion("item_reduced_amount not in", values, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_reduced_amount between", value1, value2, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andItemReducedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("item_reduced_amount not between", value1, value2, "itemReducedAmount");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeIsNull() {
            addCriterion("order_price_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeIsNotNull() {
            addCriterion("order_price_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeEqualTo(Byte value) {
            addCriterion("order_price_type =", value, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeNotEqualTo(Byte value) {
            addCriterion("order_price_type <>", value, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeGreaterThan(Byte value) {
            addCriterion("order_price_type >", value, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_price_type >=", value, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeLessThan(Byte value) {
            addCriterion("order_price_type <", value, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("order_price_type <=", value, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeIn(List<Byte> values) {
            addCriterion("order_price_type in", values, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeNotIn(List<Byte> values) {
            addCriterion("order_price_type not in", values, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeBetween(Byte value1, Byte value2) {
            addCriterion("order_price_type between", value1, value2, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andOrderPriceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("order_price_type not between", value1, value2, "orderPriceType");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andSkuUnitIsNull() {
            addCriterion("sku_unit is null");
            return (Criteria) this;
        }

        public Criteria andSkuUnitIsNotNull() {
            addCriterion("sku_unit is not null");
            return (Criteria) this;
        }

        public Criteria andSkuUnitEqualTo(String value) {
            addCriterion("sku_unit =", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitNotEqualTo(String value) {
            addCriterion("sku_unit <>", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitGreaterThan(String value) {
            addCriterion("sku_unit >", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitGreaterThanOrEqualTo(String value) {
            addCriterion("sku_unit >=", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitLessThan(String value) {
            addCriterion("sku_unit <", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitLessThanOrEqualTo(String value) {
            addCriterion("sku_unit <=", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitLike(String value) {
            addCriterion("sku_unit like", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitNotLike(String value) {
            addCriterion("sku_unit not like", value, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitIn(List<String> values) {
            addCriterion("sku_unit in", values, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitNotIn(List<String> values) {
            addCriterion("sku_unit not in", values, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitBetween(String value1, String value2) {
            addCriterion("sku_unit between", value1, value2, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitNotBetween(String value1, String value2) {
            addCriterion("sku_unit not between", value1, value2, "skuUnit");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescIsNull() {
            addCriterion("sku_unit_desc is null");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescIsNotNull() {
            addCriterion("sku_unit_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescEqualTo(String value) {
            addCriterion("sku_unit_desc =", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescNotEqualTo(String value) {
            addCriterion("sku_unit_desc <>", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescGreaterThan(String value) {
            addCriterion("sku_unit_desc >", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescGreaterThanOrEqualTo(String value) {
            addCriterion("sku_unit_desc >=", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescLessThan(String value) {
            addCriterion("sku_unit_desc <", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescLessThanOrEqualTo(String value) {
            addCriterion("sku_unit_desc <=", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescLike(String value) {
            addCriterion("sku_unit_desc like", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescNotLike(String value) {
            addCriterion("sku_unit_desc not like", value, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescIn(List<String> values) {
            addCriterion("sku_unit_desc in", values, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescNotIn(List<String> values) {
            addCriterion("sku_unit_desc not in", values, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescBetween(String value1, String value2) {
            addCriterion("sku_unit_desc between", value1, value2, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andSkuUnitDescNotBetween(String value1, String value2) {
            addCriterion("sku_unit_desc not between", value1, value2, "skuUnitDesc");
            return (Criteria) this;
        }

        public Criteria andOrderStockIsNull() {
            addCriterion("order_stock is null");
            return (Criteria) this;
        }

        public Criteria andOrderStockIsNotNull() {
            addCriterion("order_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStockEqualTo(Integer value) {
            addCriterion("order_stock =", value, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockNotEqualTo(Integer value) {
            addCriterion("order_stock <>", value, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockGreaterThan(Integer value) {
            addCriterion("order_stock >", value, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_stock >=", value, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockLessThan(Integer value) {
            addCriterion("order_stock <", value, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockLessThanOrEqualTo(Integer value) {
            addCriterion("order_stock <=", value, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockIn(List<Integer> values) {
            addCriterion("order_stock in", values, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockNotIn(List<Integer> values) {
            addCriterion("order_stock not in", values, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockBetween(Integer value1, Integer value2) {
            addCriterion("order_stock between", value1, value2, "orderStock");
            return (Criteria) this;
        }

        public Criteria andOrderStockNotBetween(Integer value1, Integer value2) {
            addCriterion("order_stock not between", value1, value2, "orderStock");
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