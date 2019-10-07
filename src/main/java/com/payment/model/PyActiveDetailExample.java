package com.payment.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PyActiveDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyActiveDetailExample() {
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

        public Criteria andActiveIdIsNull() {
            addCriterion("ACTIVE_ID is null");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNotNull() {
            addCriterion("ACTIVE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIdEqualTo(String value) {
            addCriterion("ACTIVE_ID =", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotEqualTo(String value) {
            addCriterion("ACTIVE_ID <>", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThan(String value) {
            addCriterion("ACTIVE_ID >", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVE_ID >=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThan(String value) {
            addCriterion("ACTIVE_ID <", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThanOrEqualTo(String value) {
            addCriterion("ACTIVE_ID <=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLike(String value) {
            addCriterion("ACTIVE_ID like", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotLike(String value) {
            addCriterion("ACTIVE_ID not like", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIn(List<String> values) {
            addCriterion("ACTIVE_ID in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotIn(List<String> values) {
            addCriterion("ACTIVE_ID not in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdBetween(String value1, String value2) {
            addCriterion("ACTIVE_ID between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotBetween(String value1, String value2) {
            addCriterion("ACTIVE_ID not between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andDbjeIsNull() {
            addCriterion("DBJE is null");
            return (Criteria) this;
        }

        public Criteria andDbjeIsNotNull() {
            addCriterion("DBJE is not null");
            return (Criteria) this;
        }

        public Criteria andDbjeEqualTo(BigDecimal value) {
            addCriterion("DBJE =", value, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeNotEqualTo(BigDecimal value) {
            addCriterion("DBJE <>", value, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeGreaterThan(BigDecimal value) {
            addCriterion("DBJE >", value, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DBJE >=", value, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeLessThan(BigDecimal value) {
            addCriterion("DBJE <", value, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DBJE <=", value, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeIn(List<BigDecimal> values) {
            addCriterion("DBJE in", values, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeNotIn(List<BigDecimal> values) {
            addCriterion("DBJE not in", values, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBJE between", value1, value2, "dbje");
            return (Criteria) this;
        }

        public Criteria andDbjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBJE not between", value1, value2, "dbje");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzIsNull() {
            addCriterion("SJYHZXZ is null");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzIsNotNull() {
            addCriterion("SJYHZXZ is not null");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzEqualTo(BigDecimal value) {
            addCriterion("SJYHZXZ =", value, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzNotEqualTo(BigDecimal value) {
            addCriterion("SJYHZXZ <>", value, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzGreaterThan(BigDecimal value) {
            addCriterion("SJYHZXZ >", value, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJYHZXZ >=", value, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzLessThan(BigDecimal value) {
            addCriterion("SJYHZXZ <", value, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJYHZXZ <=", value, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzIn(List<BigDecimal> values) {
            addCriterion("SJYHZXZ in", values, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzNotIn(List<BigDecimal> values) {
            addCriterion("SJYHZXZ not in", values, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJYHZXZ between", value1, value2, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzxzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJYHZXZ not between", value1, value2, "sjyhzxz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzIsNull() {
            addCriterion("SJYHZDDZ is null");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzIsNotNull() {
            addCriterion("SJYHZDDZ is not null");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzEqualTo(BigDecimal value) {
            addCriterion("SJYHZDDZ =", value, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzNotEqualTo(BigDecimal value) {
            addCriterion("SJYHZDDZ <>", value, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzGreaterThan(BigDecimal value) {
            addCriterion("SJYHZDDZ >", value, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SJYHZDDZ >=", value, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzLessThan(BigDecimal value) {
            addCriterion("SJYHZDDZ <", value, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SJYHZDDZ <=", value, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzIn(List<BigDecimal> values) {
            addCriterion("SJYHZDDZ in", values, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzNotIn(List<BigDecimal> values) {
            addCriterion("SJYHZDDZ not in", values, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJYHZDDZ between", value1, value2, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andSjyhzddzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SJYHZDDZ not between", value1, value2, "sjyhzddz");
            return (Criteria) this;
        }

        public Criteria andLjjeIsNull() {
            addCriterion("LJJE is null");
            return (Criteria) this;
        }

        public Criteria andLjjeIsNotNull() {
            addCriterion("LJJE is not null");
            return (Criteria) this;
        }

        public Criteria andLjjeEqualTo(BigDecimal value) {
            addCriterion("LJJE =", value, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeNotEqualTo(BigDecimal value) {
            addCriterion("LJJE <>", value, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeGreaterThan(BigDecimal value) {
            addCriterion("LJJE >", value, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LJJE >=", value, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeLessThan(BigDecimal value) {
            addCriterion("LJJE <", value, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LJJE <=", value, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeIn(List<BigDecimal> values) {
            addCriterion("LJJE in", values, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeNotIn(List<BigDecimal> values) {
            addCriterion("LJJE not in", values, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LJJE between", value1, value2, "ljje");
            return (Criteria) this;
        }

        public Criteria andLjjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LJJE not between", value1, value2, "ljje");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsIsNull() {
            addCriterion("DCXFZDGMS is null");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsIsNotNull() {
            addCriterion("DCXFZDGMS is not null");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsEqualTo(Integer value) {
            addCriterion("DCXFZDGMS =", value, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsNotEqualTo(Integer value) {
            addCriterion("DCXFZDGMS <>", value, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsGreaterThan(Integer value) {
            addCriterion("DCXFZDGMS >", value, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DCXFZDGMS >=", value, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsLessThan(Integer value) {
            addCriterion("DCXFZDGMS <", value, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsLessThanOrEqualTo(Integer value) {
            addCriterion("DCXFZDGMS <=", value, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsIn(List<Integer> values) {
            addCriterion("DCXFZDGMS in", values, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsNotIn(List<Integer> values) {
            addCriterion("DCXFZDGMS not in", values, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsBetween(Integer value1, Integer value2) {
            addCriterion("DCXFZDGMS between", value1, value2, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmsNotBetween(Integer value1, Integer value2) {
            addCriterion("DCXFZDGMS not between", value1, value2, "dcxfzdgms");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andYhqdjeIsNull() {
            addCriterion("YHQDJE is null");
            return (Criteria) this;
        }

        public Criteria andYhqdjeIsNotNull() {
            addCriterion("YHQDJE is not null");
            return (Criteria) this;
        }

        public Criteria andYhqdjeEqualTo(BigDecimal value) {
            addCriterion("YHQDJE =", value, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeNotEqualTo(BigDecimal value) {
            addCriterion("YHQDJE <>", value, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeGreaterThan(BigDecimal value) {
            addCriterion("YHQDJE >", value, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YHQDJE >=", value, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeLessThan(BigDecimal value) {
            addCriterion("YHQDJE <", value, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YHQDJE <=", value, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeIn(List<BigDecimal> values) {
            addCriterion("YHQDJE in", values, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeNotIn(List<BigDecimal> values) {
            addCriterion("YHQDJE not in", values, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHQDJE between", value1, value2, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhqdjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHQDJE not between", value1, value2, "yhqdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeIsNull() {
            addCriterion("YHFDJE is null");
            return (Criteria) this;
        }

        public Criteria andYhfdjeIsNotNull() {
            addCriterion("YHFDJE is not null");
            return (Criteria) this;
        }

        public Criteria andYhfdjeEqualTo(BigDecimal value) {
            addCriterion("YHFDJE =", value, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeNotEqualTo(BigDecimal value) {
            addCriterion("YHFDJE <>", value, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeGreaterThan(BigDecimal value) {
            addCriterion("YHFDJE >", value, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YHFDJE >=", value, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeLessThan(BigDecimal value) {
            addCriterion("YHFDJE <", value, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YHFDJE <=", value, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeIn(List<BigDecimal> values) {
            addCriterion("YHFDJE in", values, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeNotIn(List<BigDecimal> values) {
            addCriterion("YHFDJE not in", values, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHFDJE between", value1, value2, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhfdjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHFDJE not between", value1, value2, "yhfdje");
            return (Criteria) this;
        }

        public Criteria andYhzkIsNull() {
            addCriterion("YHZK is null");
            return (Criteria) this;
        }

        public Criteria andYhzkIsNotNull() {
            addCriterion("YHZK is not null");
            return (Criteria) this;
        }

        public Criteria andYhzkEqualTo(BigDecimal value) {
            addCriterion("YHZK =", value, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkNotEqualTo(BigDecimal value) {
            addCriterion("YHZK <>", value, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkGreaterThan(BigDecimal value) {
            addCriterion("YHZK >", value, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YHZK >=", value, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkLessThan(BigDecimal value) {
            addCriterion("YHZK <", value, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YHZK <=", value, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkIn(List<BigDecimal> values) {
            addCriterion("YHZK in", values, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkNotIn(List<BigDecimal> values) {
            addCriterion("YHZK not in", values, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHZK between", value1, value2, "yhzk");
            return (Criteria) this;
        }

        public Criteria andYhzkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHZK not between", value1, value2, "yhzk");
            return (Criteria) this;
        }

        public Criteria andHdyjIsNull() {
            addCriterion("HDYJ is null");
            return (Criteria) this;
        }

        public Criteria andHdyjIsNotNull() {
            addCriterion("HDYJ is not null");
            return (Criteria) this;
        }

        public Criteria andHdyjEqualTo(BigDecimal value) {
            addCriterion("HDYJ =", value, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjNotEqualTo(BigDecimal value) {
            addCriterion("HDYJ <>", value, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjGreaterThan(BigDecimal value) {
            addCriterion("HDYJ >", value, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HDYJ >=", value, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjLessThan(BigDecimal value) {
            addCriterion("HDYJ <", value, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HDYJ <=", value, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjIn(List<BigDecimal> values) {
            addCriterion("HDYJ in", values, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjNotIn(List<BigDecimal> values) {
            addCriterion("HDYJ not in", values, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HDYJ between", value1, value2, "hdyj");
            return (Criteria) this;
        }

        public Criteria andHdyjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HDYJ not between", value1, value2, "hdyj");
            return (Criteria) this;
        }

        public Criteria andYhjeIsNull() {
            addCriterion("YHJE is null");
            return (Criteria) this;
        }

        public Criteria andYhjeIsNotNull() {
            addCriterion("YHJE is not null");
            return (Criteria) this;
        }

        public Criteria andYhjeEqualTo(BigDecimal value) {
            addCriterion("YHJE =", value, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeNotEqualTo(BigDecimal value) {
            addCriterion("YHJE <>", value, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeGreaterThan(BigDecimal value) {
            addCriterion("YHJE >", value, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YHJE >=", value, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeLessThan(BigDecimal value) {
            addCriterion("YHJE <", value, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YHJE <=", value, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeIn(List<BigDecimal> values) {
            addCriterion("YHJE in", values, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeNotIn(List<BigDecimal> values) {
            addCriterion("YHJE not in", values, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHJE between", value1, value2, "yhje");
            return (Criteria) this;
        }

        public Criteria andYhjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHJE not between", value1, value2, "yhje");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsIsNull() {
            addCriterion("DCXFZDGMFS is null");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsIsNotNull() {
            addCriterion("DCXFZDGMFS is not null");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsEqualTo(Long value) {
            addCriterion("DCXFZDGMFS =", value, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsNotEqualTo(Long value) {
            addCriterion("DCXFZDGMFS <>", value, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsGreaterThan(Long value) {
            addCriterion("DCXFZDGMFS >", value, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsGreaterThanOrEqualTo(Long value) {
            addCriterion("DCXFZDGMFS >=", value, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsLessThan(Long value) {
            addCriterion("DCXFZDGMFS <", value, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsLessThanOrEqualTo(Long value) {
            addCriterion("DCXFZDGMFS <=", value, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsIn(List<Long> values) {
            addCriterion("DCXFZDGMFS in", values, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsNotIn(List<Long> values) {
            addCriterion("DCXFZDGMFS not in", values, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsBetween(Long value1, Long value2) {
            addCriterion("DCXFZDGMFS between", value1, value2, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andDcxfzdgmfsNotBetween(Long value1, Long value2) {
            addCriterion("DCXFZDGMFS not between", value1, value2, "dcxfzdgmfs");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andDetailDescIsNull() {
            addCriterion("DETAIL_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDetailDescIsNotNull() {
            addCriterion("DETAIL_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDetailDescEqualTo(String value) {
            addCriterion("DETAIL_DESC =", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescNotEqualTo(String value) {
            addCriterion("DETAIL_DESC <>", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescGreaterThan(String value) {
            addCriterion("DETAIL_DESC >", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescGreaterThanOrEqualTo(String value) {
            addCriterion("DETAIL_DESC >=", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescLessThan(String value) {
            addCriterion("DETAIL_DESC <", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescLessThanOrEqualTo(String value) {
            addCriterion("DETAIL_DESC <=", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescLike(String value) {
            addCriterion("DETAIL_DESC like", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescNotLike(String value) {
            addCriterion("DETAIL_DESC not like", value, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescIn(List<String> values) {
            addCriterion("DETAIL_DESC in", values, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescNotIn(List<String> values) {
            addCriterion("DETAIL_DESC not in", values, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescBetween(String value1, String value2) {
            addCriterion("DETAIL_DESC between", value1, value2, "detailDesc");
            return (Criteria) this;
        }

        public Criteria andDetailDescNotBetween(String value1, String value2) {
            addCriterion("DETAIL_DESC not between", value1, value2, "detailDesc");
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