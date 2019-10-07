package com.payment.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PyActiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PyActiveExample() {
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

        public Criteria andBonusIdIsNull() {
            addCriterion("BONUS_ID is null");
            return (Criteria) this;
        }

        public Criteria andBonusIdIsNotNull() {
            addCriterion("BONUS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBonusIdEqualTo(String value) {
            addCriterion("BONUS_ID =", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdNotEqualTo(String value) {
            addCriterion("BONUS_ID <>", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdGreaterThan(String value) {
            addCriterion("BONUS_ID >", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdGreaterThanOrEqualTo(String value) {
            addCriterion("BONUS_ID >=", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdLessThan(String value) {
            addCriterion("BONUS_ID <", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdLessThanOrEqualTo(String value) {
            addCriterion("BONUS_ID <=", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdLike(String value) {
            addCriterion("BONUS_ID like", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdNotLike(String value) {
            addCriterion("BONUS_ID not like", value, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdIn(List<String> values) {
            addCriterion("BONUS_ID in", values, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdNotIn(List<String> values) {
            addCriterion("BONUS_ID not in", values, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdBetween(String value1, String value2) {
            addCriterion("BONUS_ID between", value1, value2, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusIdNotBetween(String value1, String value2) {
            addCriterion("BONUS_ID not between", value1, value2, "bonusId");
            return (Criteria) this;
        }

        public Criteria andBonusLimitIsNull() {
            addCriterion("BONUS_LIMIT is null");
            return (Criteria) this;
        }

        public Criteria andBonusLimitIsNotNull() {
            addCriterion("BONUS_LIMIT is not null");
            return (Criteria) this;
        }

        public Criteria andBonusLimitEqualTo(BigDecimal value) {
            addCriterion("BONUS_LIMIT =", value, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitNotEqualTo(BigDecimal value) {
            addCriterion("BONUS_LIMIT <>", value, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitGreaterThan(BigDecimal value) {
            addCriterion("BONUS_LIMIT >", value, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BONUS_LIMIT >=", value, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitLessThan(BigDecimal value) {
            addCriterion("BONUS_LIMIT <", value, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BONUS_LIMIT <=", value, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitIn(List<BigDecimal> values) {
            addCriterion("BONUS_LIMIT in", values, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitNotIn(List<BigDecimal> values) {
            addCriterion("BONUS_LIMIT not in", values, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BONUS_LIMIT between", value1, value2, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BONUS_LIMIT not between", value1, value2, "bonusLimit");
            return (Criteria) this;
        }

        public Criteria andBonusTypeIsNull() {
            addCriterion("BONUS_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBonusTypeIsNotNull() {
            addCriterion("BONUS_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBonusTypeEqualTo(String value) {
            addCriterion("BONUS_TYPE =", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeNotEqualTo(String value) {
            addCriterion("BONUS_TYPE <>", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeGreaterThan(String value) {
            addCriterion("BONUS_TYPE >", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BONUS_TYPE >=", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeLessThan(String value) {
            addCriterion("BONUS_TYPE <", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeLessThanOrEqualTo(String value) {
            addCriterion("BONUS_TYPE <=", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeLike(String value) {
            addCriterion("BONUS_TYPE like", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeNotLike(String value) {
            addCriterion("BONUS_TYPE not like", value, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeIn(List<String> values) {
            addCriterion("BONUS_TYPE in", values, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeNotIn(List<String> values) {
            addCriterion("BONUS_TYPE not in", values, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeBetween(String value1, String value2) {
            addCriterion("BONUS_TYPE between", value1, value2, "bonusType");
            return (Criteria) this;
        }

        public Criteria andBonusTypeNotBetween(String value1, String value2) {
            addCriterion("BONUS_TYPE not between", value1, value2, "bonusType");
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

        public Criteria andAdInfoIsNull() {
            addCriterion("AD_INFO is null");
            return (Criteria) this;
        }

        public Criteria andAdInfoIsNotNull() {
            addCriterion("AD_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andAdInfoEqualTo(String value) {
            addCriterion("AD_INFO =", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoNotEqualTo(String value) {
            addCriterion("AD_INFO <>", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoGreaterThan(String value) {
            addCriterion("AD_INFO >", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoGreaterThanOrEqualTo(String value) {
            addCriterion("AD_INFO >=", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoLessThan(String value) {
            addCriterion("AD_INFO <", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoLessThanOrEqualTo(String value) {
            addCriterion("AD_INFO <=", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoLike(String value) {
            addCriterion("AD_INFO like", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoNotLike(String value) {
            addCriterion("AD_INFO not like", value, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoIn(List<String> values) {
            addCriterion("AD_INFO in", values, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoNotIn(List<String> values) {
            addCriterion("AD_INFO not in", values, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoBetween(String value1, String value2) {
            addCriterion("AD_INFO between", value1, value2, "adInfo");
            return (Criteria) this;
        }

        public Criteria andAdInfoNotBetween(String value1, String value2) {
            addCriterion("AD_INFO not between", value1, value2, "adInfo");
            return (Criteria) this;
        }

        public Criteria andYhzcsIsNull() {
            addCriterion("YHZCS is null");
            return (Criteria) this;
        }

        public Criteria andYhzcsIsNotNull() {
            addCriterion("YHZCS is not null");
            return (Criteria) this;
        }

        public Criteria andYhzcsEqualTo(Integer value) {
            addCriterion("YHZCS =", value, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsNotEqualTo(Integer value) {
            addCriterion("YHZCS <>", value, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsGreaterThan(Integer value) {
            addCriterion("YHZCS >", value, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("YHZCS >=", value, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsLessThan(Integer value) {
            addCriterion("YHZCS <", value, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsLessThanOrEqualTo(Integer value) {
            addCriterion("YHZCS <=", value, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsIn(List<Integer> values) {
            addCriterion("YHZCS in", values, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsNotIn(List<Integer> values) {
            addCriterion("YHZCS not in", values, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsBetween(Integer value1, Integer value2) {
            addCriterion("YHZCS between", value1, value2, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andYhzcsNotBetween(Integer value1, Integer value2) {
            addCriterion("YHZCS not between", value1, value2, "yhzcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsIsNull() {
            addCriterion("DRZDCS is null");
            return (Criteria) this;
        }

        public Criteria andDrzdcsIsNotNull() {
            addCriterion("DRZDCS is not null");
            return (Criteria) this;
        }

        public Criteria andDrzdcsEqualTo(Integer value) {
            addCriterion("DRZDCS =", value, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsNotEqualTo(Integer value) {
            addCriterion("DRZDCS <>", value, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsGreaterThan(Integer value) {
            addCriterion("DRZDCS >", value, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DRZDCS >=", value, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsLessThan(Integer value) {
            addCriterion("DRZDCS <", value, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsLessThanOrEqualTo(Integer value) {
            addCriterion("DRZDCS <=", value, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsIn(List<Integer> values) {
            addCriterion("DRZDCS in", values, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsNotIn(List<Integer> values) {
            addCriterion("DRZDCS not in", values, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsBetween(Integer value1, Integer value2) {
            addCriterion("DRZDCS between", value1, value2, "drzdcs");
            return (Criteria) this;
        }

        public Criteria andDrzdcsNotBetween(Integer value1, Integer value2) {
            addCriterion("DRZDCS not between", value1, value2, "drzdcs");
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

        public Criteria andYhdjIsNull() {
            addCriterion("YHDJ is null");
            return (Criteria) this;
        }

        public Criteria andYhdjIsNotNull() {
            addCriterion("YHDJ is not null");
            return (Criteria) this;
        }

        public Criteria andYhdjEqualTo(BigDecimal value) {
            addCriterion("YHDJ =", value, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjNotEqualTo(BigDecimal value) {
            addCriterion("YHDJ <>", value, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjGreaterThan(BigDecimal value) {
            addCriterion("YHDJ >", value, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YHDJ >=", value, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjLessThan(BigDecimal value) {
            addCriterion("YHDJ <", value, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YHDJ <=", value, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjIn(List<BigDecimal> values) {
            addCriterion("YHDJ in", values, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjNotIn(List<BigDecimal> values) {
            addCriterion("YHDJ not in", values, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHDJ between", value1, value2, "yhdj");
            return (Criteria) this;
        }

        public Criteria andYhdjNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YHDJ not between", value1, value2, "yhdj");
            return (Criteria) this;
        }

        public Criteria andDkkcycsIsNull() {
            addCriterion("DKKCYCS is null");
            return (Criteria) this;
        }

        public Criteria andDkkcycsIsNotNull() {
            addCriterion("DKKCYCS is not null");
            return (Criteria) this;
        }

        public Criteria andDkkcycsEqualTo(Integer value) {
            addCriterion("DKKCYCS =", value, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsNotEqualTo(Integer value) {
            addCriterion("DKKCYCS <>", value, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsGreaterThan(Integer value) {
            addCriterion("DKKCYCS >", value, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DKKCYCS >=", value, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsLessThan(Integer value) {
            addCriterion("DKKCYCS <", value, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsLessThanOrEqualTo(Integer value) {
            addCriterion("DKKCYCS <=", value, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsIn(List<Integer> values) {
            addCriterion("DKKCYCS in", values, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsNotIn(List<Integer> values) {
            addCriterion("DKKCYCS not in", values, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsBetween(Integer value1, Integer value2) {
            addCriterion("DKKCYCS between", value1, value2, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andDkkcycsNotBetween(Integer value1, Integer value2) {
            addCriterion("DKKCYCS not between", value1, value2, "dkkcycs");
            return (Criteria) this;
        }

        public Criteria andZdxfjeIsNull() {
            addCriterion("ZDXFJE is null");
            return (Criteria) this;
        }

        public Criteria andZdxfjeIsNotNull() {
            addCriterion("ZDXFJE is not null");
            return (Criteria) this;
        }

        public Criteria andZdxfjeEqualTo(BigDecimal value) {
            addCriterion("ZDXFJE =", value, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeNotEqualTo(BigDecimal value) {
            addCriterion("ZDXFJE <>", value, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeGreaterThan(BigDecimal value) {
            addCriterion("ZDXFJE >", value, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZDXFJE >=", value, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeLessThan(BigDecimal value) {
            addCriterion("ZDXFJE <", value, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZDXFJE <=", value, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeIn(List<BigDecimal> values) {
            addCriterion("ZDXFJE in", values, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeNotIn(List<BigDecimal> values) {
            addCriterion("ZDXFJE not in", values, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZDXFJE between", value1, value2, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZdxfjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZDXFJE not between", value1, value2, "zdxfje");
            return (Criteria) this;
        }

        public Criteria andZkIsNull() {
            addCriterion("ZK is null");
            return (Criteria) this;
        }

        public Criteria andZkIsNotNull() {
            addCriterion("ZK is not null");
            return (Criteria) this;
        }

        public Criteria andZkEqualTo(BigDecimal value) {
            addCriterion("ZK =", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotEqualTo(BigDecimal value) {
            addCriterion("ZK <>", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkGreaterThan(BigDecimal value) {
            addCriterion("ZK >", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZK >=", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLessThan(BigDecimal value) {
            addCriterion("ZK <", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZK <=", value, "zk");
            return (Criteria) this;
        }

        public Criteria andZkIn(List<BigDecimal> values) {
            addCriterion("ZK in", values, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotIn(List<BigDecimal> values) {
            addCriterion("ZK not in", values, "zk");
            return (Criteria) this;
        }

        public Criteria andZkBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZK between", value1, value2, "zk");
            return (Criteria) this;
        }

        public Criteria andZkNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZK not between", value1, value2, "zk");
            return (Criteria) this;
        }

        public Criteria andDbyhjeIsNull() {
            addCriterion("DBYHJE is null");
            return (Criteria) this;
        }

        public Criteria andDbyhjeIsNotNull() {
            addCriterion("DBYHJE is not null");
            return (Criteria) this;
        }

        public Criteria andDbyhjeEqualTo(BigDecimal value) {
            addCriterion("DBYHJE =", value, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeNotEqualTo(BigDecimal value) {
            addCriterion("DBYHJE <>", value, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeGreaterThan(BigDecimal value) {
            addCriterion("DBYHJE >", value, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DBYHJE >=", value, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeLessThan(BigDecimal value) {
            addCriterion("DBYHJE <", value, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DBYHJE <=", value, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeIn(List<BigDecimal> values) {
            addCriterion("DBYHJE in", values, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeNotIn(List<BigDecimal> values) {
            addCriterion("DBYHJE not in", values, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBYHJE between", value1, value2, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDbyhjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBYHJE not between", value1, value2, "dbyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeIsNull() {
            addCriterion("DKZGYHJE is null");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeIsNotNull() {
            addCriterion("DKZGYHJE is not null");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeEqualTo(BigDecimal value) {
            addCriterion("DKZGYHJE =", value, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeNotEqualTo(BigDecimal value) {
            addCriterion("DKZGYHJE <>", value, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeGreaterThan(BigDecimal value) {
            addCriterion("DKZGYHJE >", value, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DKZGYHJE >=", value, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeLessThan(BigDecimal value) {
            addCriterion("DKZGYHJE <", value, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DKZGYHJE <=", value, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeIn(List<BigDecimal> values) {
            addCriterion("DKZGYHJE in", values, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeNotIn(List<BigDecimal> values) {
            addCriterion("DKZGYHJE not in", values, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DKZGYHJE between", value1, value2, "dkzgyhje");
            return (Criteria) this;
        }

        public Criteria andDkzgyhjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DKZGYHJE not between", value1, value2, "dkzgyhje");
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

        public Criteria andDkhjyhxeIsNull() {
            addCriterion("DKHJYHXE is null");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeIsNotNull() {
            addCriterion("DKHJYHXE is not null");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeEqualTo(BigDecimal value) {
            addCriterion("DKHJYHXE =", value, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeNotEqualTo(BigDecimal value) {
            addCriterion("DKHJYHXE <>", value, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeGreaterThan(BigDecimal value) {
            addCriterion("DKHJYHXE >", value, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DKHJYHXE >=", value, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeLessThan(BigDecimal value) {
            addCriterion("DKHJYHXE <", value, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DKHJYHXE <=", value, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeIn(List<BigDecimal> values) {
            addCriterion("DKHJYHXE in", values, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeNotIn(List<BigDecimal> values) {
            addCriterion("DKHJYHXE not in", values, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DKHJYHXE between", value1, value2, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDkhjyhxeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DKHJYHXE not between", value1, value2, "dkhjyhxe");
            return (Criteria) this;
        }

        public Criteria andDbzdyhIsNull() {
            addCriterion("DBZDYH is null");
            return (Criteria) this;
        }

        public Criteria andDbzdyhIsNotNull() {
            addCriterion("DBZDYH is not null");
            return (Criteria) this;
        }

        public Criteria andDbzdyhEqualTo(BigDecimal value) {
            addCriterion("DBZDYH =", value, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhNotEqualTo(BigDecimal value) {
            addCriterion("DBZDYH <>", value, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhGreaterThan(BigDecimal value) {
            addCriterion("DBZDYH >", value, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DBZDYH >=", value, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhLessThan(BigDecimal value) {
            addCriterion("DBZDYH <", value, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DBZDYH <=", value, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhIn(List<BigDecimal> values) {
            addCriterion("DBZDYH in", values, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhNotIn(List<BigDecimal> values) {
            addCriterion("DBZDYH not in", values, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBZDYH between", value1, value2, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzdyhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBZDYH not between", value1, value2, "dbzdyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhIsNull() {
            addCriterion("DBZGYH is null");
            return (Criteria) this;
        }

        public Criteria andDbzgyhIsNotNull() {
            addCriterion("DBZGYH is not null");
            return (Criteria) this;
        }

        public Criteria andDbzgyhEqualTo(BigDecimal value) {
            addCriterion("DBZGYH =", value, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhNotEqualTo(BigDecimal value) {
            addCriterion("DBZGYH <>", value, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhGreaterThan(BigDecimal value) {
            addCriterion("DBZGYH >", value, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("DBZGYH >=", value, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhLessThan(BigDecimal value) {
            addCriterion("DBZGYH <", value, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhLessThanOrEqualTo(BigDecimal value) {
            addCriterion("DBZGYH <=", value, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhIn(List<BigDecimal> values) {
            addCriterion("DBZGYH in", values, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhNotIn(List<BigDecimal> values) {
            addCriterion("DBZGYH not in", values, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBZGYH between", value1, value2, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andDbzgyhNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("DBZGYH not between", value1, value2, "dbzgyh");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNull() {
            addCriterion("BEGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andBeginDateIsNotNull() {
            addCriterion("BEGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDateEqualTo(String value) {
            addCriterion("BEGIN_DATE =", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotEqualTo(String value) {
            addCriterion("BEGIN_DATE <>", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThan(String value) {
            addCriterion("BEGIN_DATE >", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateGreaterThanOrEqualTo(String value) {
            addCriterion("BEGIN_DATE >=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThan(String value) {
            addCriterion("BEGIN_DATE <", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLessThanOrEqualTo(String value) {
            addCriterion("BEGIN_DATE <=", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateLike(String value) {
            addCriterion("BEGIN_DATE like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotLike(String value) {
            addCriterion("BEGIN_DATE not like", value, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateIn(List<String> values) {
            addCriterion("BEGIN_DATE in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotIn(List<String> values) {
            addCriterion("BEGIN_DATE not in", values, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateBetween(String value1, String value2) {
            addCriterion("BEGIN_DATE between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andBeginDateNotBetween(String value1, String value2) {
            addCriterion("BEGIN_DATE not between", value1, value2, "beginDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(String value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(String value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(String value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(String value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(String value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLike(String value) {
            addCriterion("END_DATE like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotLike(String value) {
            addCriterion("END_DATE not like", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(List<String> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(List<String> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(String value1, String value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(String value1, String value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("WEEK is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("WEEK =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("WEEK <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("WEEK >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("WEEK >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("WEEK <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("WEEK <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("WEEK like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("WEEK not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("WEEK in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("WEEK not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("WEEK between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("WEEK not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("BEGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("BEGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(String value) {
            addCriterion("BEGIN_TIME =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(String value) {
            addCriterion("BEGIN_TIME <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(String value) {
            addCriterion("BEGIN_TIME >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(String value) {
            addCriterion("BEGIN_TIME >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(String value) {
            addCriterion("BEGIN_TIME <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(String value) {
            addCriterion("BEGIN_TIME <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLike(String value) {
            addCriterion("BEGIN_TIME like", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotLike(String value) {
            addCriterion("BEGIN_TIME not like", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<String> values) {
            addCriterion("BEGIN_TIME in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<String> values) {
            addCriterion("BEGIN_TIME not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(String value1, String value2) {
            addCriterion("BEGIN_TIME between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(String value1, String value2) {
            addCriterion("BEGIN_TIME not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(String value) {
            addCriterion("END_TIME =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(String value) {
            addCriterion("END_TIME <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(String value) {
            addCriterion("END_TIME >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
            addCriterion("END_TIME >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(String value) {
            addCriterion("END_TIME <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(String value) {
            addCriterion("END_TIME <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLike(String value) {
            addCriterion("END_TIME like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotLike(String value) {
            addCriterion("END_TIME not like", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<String> values) {
            addCriterion("END_TIME in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<String> values) {
            addCriterion("END_TIME not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(String value1, String value2) {
            addCriterion("END_TIME between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(String value1, String value2) {
            addCriterion("END_TIME not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeIsNull() {
            addCriterion("CARD_IDENTIFY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeIsNotNull() {
            addCriterion("CARD_IDENTIFY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeEqualTo(String value) {
            addCriterion("CARD_IDENTIFY_TYPE =", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeNotEqualTo(String value) {
            addCriterion("CARD_IDENTIFY_TYPE <>", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeGreaterThan(String value) {
            addCriterion("CARD_IDENTIFY_TYPE >", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_IDENTIFY_TYPE >=", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeLessThan(String value) {
            addCriterion("CARD_IDENTIFY_TYPE <", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeLessThanOrEqualTo(String value) {
            addCriterion("CARD_IDENTIFY_TYPE <=", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeLike(String value) {
            addCriterion("CARD_IDENTIFY_TYPE like", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeNotLike(String value) {
            addCriterion("CARD_IDENTIFY_TYPE not like", value, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeIn(List<String> values) {
            addCriterion("CARD_IDENTIFY_TYPE in", values, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeNotIn(List<String> values) {
            addCriterion("CARD_IDENTIFY_TYPE not in", values, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeBetween(String value1, String value2) {
            addCriterion("CARD_IDENTIFY_TYPE between", value1, value2, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardIdentifyTypeNotBetween(String value1, String value2) {
            addCriterion("CARD_IDENTIFY_TYPE not between", value1, value2, "cardIdentifyType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeIsNull() {
            addCriterion("CARD_ADD_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeIsNotNull() {
            addCriterion("CARD_ADD_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeEqualTo(String value) {
            addCriterion("CARD_ADD_TYPE =", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeNotEqualTo(String value) {
            addCriterion("CARD_ADD_TYPE <>", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeGreaterThan(String value) {
            addCriterion("CARD_ADD_TYPE >", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CARD_ADD_TYPE >=", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeLessThan(String value) {
            addCriterion("CARD_ADD_TYPE <", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeLessThanOrEqualTo(String value) {
            addCriterion("CARD_ADD_TYPE <=", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeLike(String value) {
            addCriterion("CARD_ADD_TYPE like", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeNotLike(String value) {
            addCriterion("CARD_ADD_TYPE not like", value, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeIn(List<String> values) {
            addCriterion("CARD_ADD_TYPE in", values, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeNotIn(List<String> values) {
            addCriterion("CARD_ADD_TYPE not in", values, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeBetween(String value1, String value2) {
            addCriterion("CARD_ADD_TYPE between", value1, value2, "cardAddType");
            return (Criteria) this;
        }

        public Criteria andCardAddTypeNotBetween(String value1, String value2) {
            addCriterion("CARD_ADD_TYPE not between", value1, value2, "cardAddType");
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

        public Criteria andHdzjeIsNull() {
            addCriterion("HDZJE is null");
            return (Criteria) this;
        }

        public Criteria andHdzjeIsNotNull() {
            addCriterion("HDZJE is not null");
            return (Criteria) this;
        }

        public Criteria andHdzjeEqualTo(BigDecimal value) {
            addCriterion("HDZJE =", value, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeNotEqualTo(BigDecimal value) {
            addCriterion("HDZJE <>", value, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeGreaterThan(BigDecimal value) {
            addCriterion("HDZJE >", value, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HDZJE >=", value, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeLessThan(BigDecimal value) {
            addCriterion("HDZJE <", value, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HDZJE <=", value, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeIn(List<BigDecimal> values) {
            addCriterion("HDZJE in", values, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeNotIn(List<BigDecimal> values) {
            addCriterion("HDZJE not in", values, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HDZJE between", value1, value2, "hdzje");
            return (Criteria) this;
        }

        public Criteria andHdzjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HDZJE not between", value1, value2, "hdzje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeIsNull() {
            addCriterion("MRZGHDJE is null");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeIsNotNull() {
            addCriterion("MRZGHDJE is not null");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeEqualTo(BigDecimal value) {
            addCriterion("MRZGHDJE =", value, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeNotEqualTo(BigDecimal value) {
            addCriterion("MRZGHDJE <>", value, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeGreaterThan(BigDecimal value) {
            addCriterion("MRZGHDJE >", value, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MRZGHDJE >=", value, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeLessThan(BigDecimal value) {
            addCriterion("MRZGHDJE <", value, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MRZGHDJE <=", value, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeIn(List<BigDecimal> values) {
            addCriterion("MRZGHDJE in", values, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeNotIn(List<BigDecimal> values) {
            addCriterion("MRZGHDJE not in", values, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MRZGHDJE between", value1, value2, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andMrzghdjeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MRZGHDJE not between", value1, value2, "mrzghdje");
            return (Criteria) this;
        }

        public Criteria andUsedTotalIsNull() {
            addCriterion("USED_TOTAL is null");
            return (Criteria) this;
        }

        public Criteria andUsedTotalIsNotNull() {
            addCriterion("USED_TOTAL is not null");
            return (Criteria) this;
        }

        public Criteria andUsedTotalEqualTo(BigDecimal value) {
            addCriterion("USED_TOTAL =", value, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalNotEqualTo(BigDecimal value) {
            addCriterion("USED_TOTAL <>", value, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalGreaterThan(BigDecimal value) {
            addCriterion("USED_TOTAL >", value, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_TOTAL >=", value, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalLessThan(BigDecimal value) {
            addCriterion("USED_TOTAL <", value, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED_TOTAL <=", value, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalIn(List<BigDecimal> values) {
            addCriterion("USED_TOTAL in", values, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalNotIn(List<BigDecimal> values) {
            addCriterion("USED_TOTAL not in", values, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_TOTAL between", value1, value2, "usedTotal");
            return (Criteria) this;
        }

        public Criteria andUsedTotalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED_TOTAL not between", value1, value2, "usedTotal");
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