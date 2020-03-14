package com.mwt.oes.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<UserExample.Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<UserExample.Criteria>();
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

    public List<UserExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(UserExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public UserExample.Criteria or() {
        UserExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public UserExample.Criteria createCriteria() {
        UserExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected UserExample.Criteria createCriteriaInternal() {
        UserExample.Criteria criteria = new UserExample.Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<UserExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<UserExample.Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<UserExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<UserExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new UserExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new UserExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new UserExample.Criterion(condition, value1, value2));
        }

        public UserExample.Criteria andUserPhoneIsNull() {
            addCriterion("user_phone is null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneIsNotNull() {
            addCriterion("user_phone is not null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneEqualTo(String value) {
            addCriterion("user_phone =", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneNotEqualTo(String value) {
            addCriterion("user_phone <>", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneGreaterThan(String value) {
            addCriterion("user_phone >", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("user_phone >=", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneLessThan(String value) {
            addCriterion("user_phone <", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneLessThanOrEqualTo(String value) {
            addCriterion("user_phone <=", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneLike(String value) {
            addCriterion("user_phone like", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneNotLike(String value) {
            addCriterion("user_phone not like", value, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneIn(List<String> values) {
            addCriterion("user_phone in", values, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneNotIn(List<String> values) {
            addCriterion("user_phone not in", values, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneBetween(String value1, String value2) {
            addCriterion("user_phone between", value1, value2, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPhoneNotBetween(String value1, String value2) {
            addCriterion("user_phone not between", value1, value2, "user_phone");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswIsNull() {
            addCriterion("user_psw is null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswIsNotNull() {
            addCriterion("user_psw is not null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswEqualTo(String value) {
            addCriterion("user_psw =", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswNotEqualTo(String value) {
            addCriterion("user_psw <>", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswGreaterThan(String value) {
            addCriterion("user_psw >", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswGreaterThanOrEqualTo(String value) {
            addCriterion("user_psw >=", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswLessThan(String value) {
            addCriterion("user_psw <", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswLessThanOrEqualTo(String value) {
            addCriterion("user_psw <=", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswLike(String value) {
            addCriterion("user_psw like", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswNotLike(String value) {
            addCriterion("user_psw not like", value, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswIn(List<String> values) {
            addCriterion("user_psw in", values, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswNotIn(List<String> values) {
            addCriterion("user_psw not in", values, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswBetween(String value1, String value2) {
            addCriterion("user_psw between", value1, value2, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserPswNotBetween(String value1, String value2) {
            addCriterion("user_psw not between", value1, value2, "stuPsw");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "stuName");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcIsNull() {
            addCriterion("user_img_src is null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcIsNotNull() {
            addCriterion("user_img_src is not null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcEqualTo(String value) {
            addCriterion("user_img_src =", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcNotEqualTo(String value) {
            addCriterion("user_img_src <>", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcGreaterThan(String value) {
            addCriterion("user_img_src >", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("user_img_src >=", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcLessThan(String value) {
            addCriterion("user_img_src <", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcLessThanOrEqualTo(String value) {
            addCriterion("user_img_src <=", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcLike(String value) {
            addCriterion("user_img_src like", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcNotLike(String value) {
            addCriterion("user_img_src not like", value, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcIn(List<String> values) {
            addCriterion("user_img_src in", values, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcNotIn(List<String> values) {
            addCriterion("user_img_src not in", values, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcBetween(String value1, String value2) {
            addCriterion("user_img_src between", value1, value2, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserImgSrcNotBetween(String value1, String value2) {
            addCriterion("user_img_src not between", value1, value2, "userImgSrc");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexIsNull() {
            addCriterion("user_sex is null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexIsNotNull() {
            addCriterion("user_sex is not null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexEqualTo(String value) {
            addCriterion("user_sex =", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexNotEqualTo(String value) {
            addCriterion("user_sex <>", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexGreaterThan(String value) {
            addCriterion("user_sex >", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexGreaterThanOrEqualTo(String value) {
            addCriterion("user_sex >=", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexLessThan(String value) {
            addCriterion("user_sex <", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexLessThanOrEqualTo(String value) {
            addCriterion("user_sex <=", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexLike(String value) {
            addCriterion("user_sex like", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexNotLike(String value) {
            addCriterion("user_sex not like", value, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexIn(List<String> values) {
            addCriterion("user_sex in", values, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexNotIn(List<String> values) {
            addCriterion("user_sex not in", values, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexBetween(String value1, String value2) {
            addCriterion("user_sex between", value1, value2, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserSexNotBetween(String value1, String value2) {
            addCriterion("user_sex not between", value1, value2, "userSex");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionIsNull() {
            addCriterion("user_introduction is null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionIsNotNull() {
            addCriterion("user_introduction is not null");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionEqualTo(String value) {
            addCriterion("user_introduction =", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionNotEqualTo(String value) {
            addCriterion("user_introduction <>", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionGreaterThan(String value) {
            addCriterion("user_introduction >", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("user_introduction >=", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionLessThan(String value) {
            addCriterion("user_introduction <", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionLessThanOrEqualTo(String value) {
            addCriterion("user_introduction <=", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionLike(String value) {
            addCriterion("user_introduction like", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionNotLike(String value) {
            addCriterion("user_introduction not like", value, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionIn(List<String> values) {
            addCriterion("user_introduction in", values, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionNotIn(List<String> values) {
            addCriterion("user_introduction not in", values, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionBetween(String value1, String value2) {
            addCriterion("user_introduction between", value1, value2, "userIntroduction");
            return (UserExample.Criteria) this;
        }

        public UserExample.Criteria andUserIntroductionNotBetween(String value1, String value2) {
            addCriterion("user_introduction not between", value1, value2, "userIntroduction");
            return (UserExample.Criteria) this;
        }

    }

    public static class Criteria extends UserExample.GeneratedCriteria {

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
