package com.payment.model;

import java.util.ArrayList;
import java.util.List;

public class SysRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("ROLE_ID is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("ROLE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("ROLE_ID =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("ROLE_ID <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("ROLE_ID >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_ID >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("ROLE_ID <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("ROLE_ID <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("ROLE_ID like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("ROLE_ID not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("ROLE_ID in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("ROLE_ID not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("ROLE_ID between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("ROLE_ID not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("ROLE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("ROLE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("ROLE_CODE =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("ROLE_CODE <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("ROLE_CODE >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_CODE >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("ROLE_CODE <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("ROLE_CODE <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("ROLE_CODE like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("ROLE_CODE not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("ROLE_CODE in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("ROLE_CODE not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("ROLE_CODE between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("ROLE_CODE not between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("ROLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("ROLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("ROLE_NAME =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("ROLE_NAME <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("ROLE_NAME >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("ROLE_NAME <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("ROLE_NAME <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("ROLE_NAME like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("ROLE_NAME not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("ROLE_NAME in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("ROLE_NAME not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("ROLE_NAME between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("ROLE_NAME not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRightsIsNull() {
            addCriterion("RIGHTS is null");
            return (Criteria) this;
        }

        public Criteria andRightsIsNotNull() {
            addCriterion("RIGHTS is not null");
            return (Criteria) this;
        }

        public Criteria andRightsEqualTo(String value) {
            addCriterion("RIGHTS =", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotEqualTo(String value) {
            addCriterion("RIGHTS <>", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsGreaterThan(String value) {
            addCriterion("RIGHTS >", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsGreaterThanOrEqualTo(String value) {
            addCriterion("RIGHTS >=", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsLessThan(String value) {
            addCriterion("RIGHTS <", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsLessThanOrEqualTo(String value) {
            addCriterion("RIGHTS <=", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsLike(String value) {
            addCriterion("RIGHTS like", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotLike(String value) {
            addCriterion("RIGHTS not like", value, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsIn(List<String> values) {
            addCriterion("RIGHTS in", values, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotIn(List<String> values) {
            addCriterion("RIGHTS not in", values, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsBetween(String value1, String value2) {
            addCriterion("RIGHTS between", value1, value2, "rights");
            return (Criteria) this;
        }

        public Criteria andRightsNotBetween(String value1, String value2) {
            addCriterion("RIGHTS not between", value1, value2, "rights");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andAddQxIsNull() {
            addCriterion("ADD_QX is null");
            return (Criteria) this;
        }

        public Criteria andAddQxIsNotNull() {
            addCriterion("ADD_QX is not null");
            return (Criteria) this;
        }

        public Criteria andAddQxEqualTo(String value) {
            addCriterion("ADD_QX =", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxNotEqualTo(String value) {
            addCriterion("ADD_QX <>", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxGreaterThan(String value) {
            addCriterion("ADD_QX >", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxGreaterThanOrEqualTo(String value) {
            addCriterion("ADD_QX >=", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxLessThan(String value) {
            addCriterion("ADD_QX <", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxLessThanOrEqualTo(String value) {
            addCriterion("ADD_QX <=", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxLike(String value) {
            addCriterion("ADD_QX like", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxNotLike(String value) {
            addCriterion("ADD_QX not like", value, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxIn(List<String> values) {
            addCriterion("ADD_QX in", values, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxNotIn(List<String> values) {
            addCriterion("ADD_QX not in", values, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxBetween(String value1, String value2) {
            addCriterion("ADD_QX between", value1, value2, "addQx");
            return (Criteria) this;
        }

        public Criteria andAddQxNotBetween(String value1, String value2) {
            addCriterion("ADD_QX not between", value1, value2, "addQx");
            return (Criteria) this;
        }

        public Criteria andDelQxIsNull() {
            addCriterion("DEL_QX is null");
            return (Criteria) this;
        }

        public Criteria andDelQxIsNotNull() {
            addCriterion("DEL_QX is not null");
            return (Criteria) this;
        }

        public Criteria andDelQxEqualTo(String value) {
            addCriterion("DEL_QX =", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxNotEqualTo(String value) {
            addCriterion("DEL_QX <>", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxGreaterThan(String value) {
            addCriterion("DEL_QX >", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_QX >=", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxLessThan(String value) {
            addCriterion("DEL_QX <", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxLessThanOrEqualTo(String value) {
            addCriterion("DEL_QX <=", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxLike(String value) {
            addCriterion("DEL_QX like", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxNotLike(String value) {
            addCriterion("DEL_QX not like", value, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxIn(List<String> values) {
            addCriterion("DEL_QX in", values, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxNotIn(List<String> values) {
            addCriterion("DEL_QX not in", values, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxBetween(String value1, String value2) {
            addCriterion("DEL_QX between", value1, value2, "delQx");
            return (Criteria) this;
        }

        public Criteria andDelQxNotBetween(String value1, String value2) {
            addCriterion("DEL_QX not between", value1, value2, "delQx");
            return (Criteria) this;
        }

        public Criteria andEditQxIsNull() {
            addCriterion("EDIT_QX is null");
            return (Criteria) this;
        }

        public Criteria andEditQxIsNotNull() {
            addCriterion("EDIT_QX is not null");
            return (Criteria) this;
        }

        public Criteria andEditQxEqualTo(String value) {
            addCriterion("EDIT_QX =", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxNotEqualTo(String value) {
            addCriterion("EDIT_QX <>", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxGreaterThan(String value) {
            addCriterion("EDIT_QX >", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxGreaterThanOrEqualTo(String value) {
            addCriterion("EDIT_QX >=", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxLessThan(String value) {
            addCriterion("EDIT_QX <", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxLessThanOrEqualTo(String value) {
            addCriterion("EDIT_QX <=", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxLike(String value) {
            addCriterion("EDIT_QX like", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxNotLike(String value) {
            addCriterion("EDIT_QX not like", value, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxIn(List<String> values) {
            addCriterion("EDIT_QX in", values, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxNotIn(List<String> values) {
            addCriterion("EDIT_QX not in", values, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxBetween(String value1, String value2) {
            addCriterion("EDIT_QX between", value1, value2, "editQx");
            return (Criteria) this;
        }

        public Criteria andEditQxNotBetween(String value1, String value2) {
            addCriterion("EDIT_QX not between", value1, value2, "editQx");
            return (Criteria) this;
        }

        public Criteria andChaQxIsNull() {
            addCriterion("CHA_QX is null");
            return (Criteria) this;
        }

        public Criteria andChaQxIsNotNull() {
            addCriterion("CHA_QX is not null");
            return (Criteria) this;
        }

        public Criteria andChaQxEqualTo(String value) {
            addCriterion("CHA_QX =", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxNotEqualTo(String value) {
            addCriterion("CHA_QX <>", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxGreaterThan(String value) {
            addCriterion("CHA_QX >", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxGreaterThanOrEqualTo(String value) {
            addCriterion("CHA_QX >=", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxLessThan(String value) {
            addCriterion("CHA_QX <", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxLessThanOrEqualTo(String value) {
            addCriterion("CHA_QX <=", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxLike(String value) {
            addCriterion("CHA_QX like", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxNotLike(String value) {
            addCriterion("CHA_QX not like", value, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxIn(List<String> values) {
            addCriterion("CHA_QX in", values, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxNotIn(List<String> values) {
            addCriterion("CHA_QX not in", values, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxBetween(String value1, String value2) {
            addCriterion("CHA_QX between", value1, value2, "chaQx");
            return (Criteria) this;
        }

        public Criteria andChaQxNotBetween(String value1, String value2) {
            addCriterion("CHA_QX not between", value1, value2, "chaQx");
            return (Criteria) this;
        }

        public Criteria andQxIdIsNull() {
            addCriterion("QX_ID is null");
            return (Criteria) this;
        }

        public Criteria andQxIdIsNotNull() {
            addCriterion("QX_ID is not null");
            return (Criteria) this;
        }

        public Criteria andQxIdEqualTo(String value) {
            addCriterion("QX_ID =", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdNotEqualTo(String value) {
            addCriterion("QX_ID <>", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdGreaterThan(String value) {
            addCriterion("QX_ID >", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdGreaterThanOrEqualTo(String value) {
            addCriterion("QX_ID >=", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdLessThan(String value) {
            addCriterion("QX_ID <", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdLessThanOrEqualTo(String value) {
            addCriterion("QX_ID <=", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdLike(String value) {
            addCriterion("QX_ID like", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdNotLike(String value) {
            addCriterion("QX_ID not like", value, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdIn(List<String> values) {
            addCriterion("QX_ID in", values, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdNotIn(List<String> values) {
            addCriterion("QX_ID not in", values, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdBetween(String value1, String value2) {
            addCriterion("QX_ID between", value1, value2, "qxId");
            return (Criteria) this;
        }

        public Criteria andQxIdNotBetween(String value1, String value2) {
            addCriterion("QX_ID not between", value1, value2, "qxId");
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