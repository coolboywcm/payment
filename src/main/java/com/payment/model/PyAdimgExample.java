package com.payment.model;

import java.util.ArrayList;
import java.util.List;

public class PyAdimgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyAdimgExample() {
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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFileId1IsNull() {
            addCriterion("FILE_ID_1 is null");
            return (Criteria) this;
        }

        public Criteria andFileId1IsNotNull() {
            addCriterion("FILE_ID_1 is not null");
            return (Criteria) this;
        }

        public Criteria andFileId1EqualTo(String value) {
            addCriterion("FILE_ID_1 =", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1NotEqualTo(String value) {
            addCriterion("FILE_ID_1 <>", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1GreaterThan(String value) {
            addCriterion("FILE_ID_1 >", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1GreaterThanOrEqualTo(String value) {
            addCriterion("FILE_ID_1 >=", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1LessThan(String value) {
            addCriterion("FILE_ID_1 <", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1LessThanOrEqualTo(String value) {
            addCriterion("FILE_ID_1 <=", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1Like(String value) {
            addCriterion("FILE_ID_1 like", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1NotLike(String value) {
            addCriterion("FILE_ID_1 not like", value, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1In(List<String> values) {
            addCriterion("FILE_ID_1 in", values, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1NotIn(List<String> values) {
            addCriterion("FILE_ID_1 not in", values, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1Between(String value1, String value2) {
            addCriterion("FILE_ID_1 between", value1, value2, "fileId1");
            return (Criteria) this;
        }

        public Criteria andFileId1NotBetween(String value1, String value2) {
            addCriterion("FILE_ID_1 not between", value1, value2, "fileId1");
            return (Criteria) this;
        }

        public Criteria andTip1IsNull() {
            addCriterion("TIP1 is null");
            return (Criteria) this;
        }

        public Criteria andTip1IsNotNull() {
            addCriterion("TIP1 is not null");
            return (Criteria) this;
        }

        public Criteria andTip1EqualTo(String value) {
            addCriterion("TIP1 =", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1NotEqualTo(String value) {
            addCriterion("TIP1 <>", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1GreaterThan(String value) {
            addCriterion("TIP1 >", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1GreaterThanOrEqualTo(String value) {
            addCriterion("TIP1 >=", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1LessThan(String value) {
            addCriterion("TIP1 <", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1LessThanOrEqualTo(String value) {
            addCriterion("TIP1 <=", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1Like(String value) {
            addCriterion("TIP1 like", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1NotLike(String value) {
            addCriterion("TIP1 not like", value, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1In(List<String> values) {
            addCriterion("TIP1 in", values, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1NotIn(List<String> values) {
            addCriterion("TIP1 not in", values, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1Between(String value1, String value2) {
            addCriterion("TIP1 between", value1, value2, "tip1");
            return (Criteria) this;
        }

        public Criteria andTip1NotBetween(String value1, String value2) {
            addCriterion("TIP1 not between", value1, value2, "tip1");
            return (Criteria) this;
        }

        public Criteria andFileId2IsNull() {
            addCriterion("FILE_ID_2 is null");
            return (Criteria) this;
        }

        public Criteria andFileId2IsNotNull() {
            addCriterion("FILE_ID_2 is not null");
            return (Criteria) this;
        }

        public Criteria andFileId2EqualTo(String value) {
            addCriterion("FILE_ID_2 =", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2NotEqualTo(String value) {
            addCriterion("FILE_ID_2 <>", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2GreaterThan(String value) {
            addCriterion("FILE_ID_2 >", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2GreaterThanOrEqualTo(String value) {
            addCriterion("FILE_ID_2 >=", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2LessThan(String value) {
            addCriterion("FILE_ID_2 <", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2LessThanOrEqualTo(String value) {
            addCriterion("FILE_ID_2 <=", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2Like(String value) {
            addCriterion("FILE_ID_2 like", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2NotLike(String value) {
            addCriterion("FILE_ID_2 not like", value, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2In(List<String> values) {
            addCriterion("FILE_ID_2 in", values, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2NotIn(List<String> values) {
            addCriterion("FILE_ID_2 not in", values, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2Between(String value1, String value2) {
            addCriterion("FILE_ID_2 between", value1, value2, "fileId2");
            return (Criteria) this;
        }

        public Criteria andFileId2NotBetween(String value1, String value2) {
            addCriterion("FILE_ID_2 not between", value1, value2, "fileId2");
            return (Criteria) this;
        }

        public Criteria andTip2IsNull() {
            addCriterion("TIP2 is null");
            return (Criteria) this;
        }

        public Criteria andTip2IsNotNull() {
            addCriterion("TIP2 is not null");
            return (Criteria) this;
        }

        public Criteria andTip2EqualTo(String value) {
            addCriterion("TIP2 =", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2NotEqualTo(String value) {
            addCriterion("TIP2 <>", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2GreaterThan(String value) {
            addCriterion("TIP2 >", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2GreaterThanOrEqualTo(String value) {
            addCriterion("TIP2 >=", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2LessThan(String value) {
            addCriterion("TIP2 <", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2LessThanOrEqualTo(String value) {
            addCriterion("TIP2 <=", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2Like(String value) {
            addCriterion("TIP2 like", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2NotLike(String value) {
            addCriterion("TIP2 not like", value, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2In(List<String> values) {
            addCriterion("TIP2 in", values, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2NotIn(List<String> values) {
            addCriterion("TIP2 not in", values, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2Between(String value1, String value2) {
            addCriterion("TIP2 between", value1, value2, "tip2");
            return (Criteria) this;
        }

        public Criteria andTip2NotBetween(String value1, String value2) {
            addCriterion("TIP2 not between", value1, value2, "tip2");
            return (Criteria) this;
        }

        public Criteria andFileId3IsNull() {
            addCriterion("FILE_ID_3 is null");
            return (Criteria) this;
        }

        public Criteria andFileId3IsNotNull() {
            addCriterion("FILE_ID_3 is not null");
            return (Criteria) this;
        }

        public Criteria andFileId3EqualTo(String value) {
            addCriterion("FILE_ID_3 =", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3NotEqualTo(String value) {
            addCriterion("FILE_ID_3 <>", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3GreaterThan(String value) {
            addCriterion("FILE_ID_3 >", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3GreaterThanOrEqualTo(String value) {
            addCriterion("FILE_ID_3 >=", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3LessThan(String value) {
            addCriterion("FILE_ID_3 <", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3LessThanOrEqualTo(String value) {
            addCriterion("FILE_ID_3 <=", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3Like(String value) {
            addCriterion("FILE_ID_3 like", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3NotLike(String value) {
            addCriterion("FILE_ID_3 not like", value, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3In(List<String> values) {
            addCriterion("FILE_ID_3 in", values, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3NotIn(List<String> values) {
            addCriterion("FILE_ID_3 not in", values, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3Between(String value1, String value2) {
            addCriterion("FILE_ID_3 between", value1, value2, "fileId3");
            return (Criteria) this;
        }

        public Criteria andFileId3NotBetween(String value1, String value2) {
            addCriterion("FILE_ID_3 not between", value1, value2, "fileId3");
            return (Criteria) this;
        }

        public Criteria andTip3IsNull() {
            addCriterion("TIP3 is null");
            return (Criteria) this;
        }

        public Criteria andTip3IsNotNull() {
            addCriterion("TIP3 is not null");
            return (Criteria) this;
        }

        public Criteria andTip3EqualTo(String value) {
            addCriterion("TIP3 =", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3NotEqualTo(String value) {
            addCriterion("TIP3 <>", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3GreaterThan(String value) {
            addCriterion("TIP3 >", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3GreaterThanOrEqualTo(String value) {
            addCriterion("TIP3 >=", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3LessThan(String value) {
            addCriterion("TIP3 <", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3LessThanOrEqualTo(String value) {
            addCriterion("TIP3 <=", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3Like(String value) {
            addCriterion("TIP3 like", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3NotLike(String value) {
            addCriterion("TIP3 not like", value, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3In(List<String> values) {
            addCriterion("TIP3 in", values, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3NotIn(List<String> values) {
            addCriterion("TIP3 not in", values, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3Between(String value1, String value2) {
            addCriterion("TIP3 between", value1, value2, "tip3");
            return (Criteria) this;
        }

        public Criteria andTip3NotBetween(String value1, String value2) {
            addCriterion("TIP3 not between", value1, value2, "tip3");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(String value) {
            addCriterion("SHOP_ID =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(String value) {
            addCriterion("SHOP_ID <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(String value) {
            addCriterion("SHOP_ID >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("SHOP_ID >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(String value) {
            addCriterion("SHOP_ID <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(String value) {
            addCriterion("SHOP_ID <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLike(String value) {
            addCriterion("SHOP_ID like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotLike(String value) {
            addCriterion("SHOP_ID not like", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<String> values) {
            addCriterion("SHOP_ID in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<String> values) {
            addCriterion("SHOP_ID not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(String value1, String value2) {
            addCriterion("SHOP_ID between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(String value1, String value2) {
            addCriterion("SHOP_ID not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdIsNull() {
            addCriterion("TERMINAL_ID is null");
            return (Criteria) this;
        }

        public Criteria andTerminalIdIsNotNull() {
            addCriterion("TERMINAL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTerminalIdEqualTo(String value) {
            addCriterion("TERMINAL_ID =", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdNotEqualTo(String value) {
            addCriterion("TERMINAL_ID <>", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdGreaterThan(String value) {
            addCriterion("TERMINAL_ID >", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdGreaterThanOrEqualTo(String value) {
            addCriterion("TERMINAL_ID >=", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdLessThan(String value) {
            addCriterion("TERMINAL_ID <", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdLessThanOrEqualTo(String value) {
            addCriterion("TERMINAL_ID <=", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdLike(String value) {
            addCriterion("TERMINAL_ID like", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdNotLike(String value) {
            addCriterion("TERMINAL_ID not like", value, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdIn(List<String> values) {
            addCriterion("TERMINAL_ID in", values, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdNotIn(List<String> values) {
            addCriterion("TERMINAL_ID not in", values, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdBetween(String value1, String value2) {
            addCriterion("TERMINAL_ID between", value1, value2, "terminalId");
            return (Criteria) this;
        }

        public Criteria andTerminalIdNotBetween(String value1, String value2) {
            addCriterion("TERMINAL_ID not between", value1, value2, "terminalId");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNull() {
            addCriterion("ORDER_INDEX is null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIsNotNull() {
            addCriterion("ORDER_INDEX is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIndexEqualTo(String value) {
            addCriterion("ORDER_INDEX =", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotEqualTo(String value) {
            addCriterion("ORDER_INDEX <>", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThan(String value) {
            addCriterion("ORDER_INDEX >", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexGreaterThanOrEqualTo(String value) {
            addCriterion("ORDER_INDEX >=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThan(String value) {
            addCriterion("ORDER_INDEX <", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLessThanOrEqualTo(String value) {
            addCriterion("ORDER_INDEX <=", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexLike(String value) {
            addCriterion("ORDER_INDEX like", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotLike(String value) {
            addCriterion("ORDER_INDEX not like", value, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexIn(List<String> values) {
            addCriterion("ORDER_INDEX in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotIn(List<String> values) {
            addCriterion("ORDER_INDEX not in", values, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexBetween(String value1, String value2) {
            addCriterion("ORDER_INDEX between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andOrderIndexNotBetween(String value1, String value2) {
            addCriterion("ORDER_INDEX not between", value1, value2, "orderIndex");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("TYPE like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("TYPE not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("CREATE_TIME like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("CREATE_TIME not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("CREATE_USER_ID like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("CREATE_USER_ID not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
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