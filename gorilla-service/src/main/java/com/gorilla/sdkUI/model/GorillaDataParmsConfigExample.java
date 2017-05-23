package com.gorilla.sdkUI.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GorillaDataParmsConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GorillaDataParmsConfigExample() {
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNull() {
            addCriterion("case_id is null");
            return (Criteria) this;
        }

        public Criteria andCaseIdIsNotNull() {
            addCriterion("case_id is not null");
            return (Criteria) this;
        }

        public Criteria andCaseIdEqualTo(Long value) {
            addCriterion("case_id =", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotEqualTo(Long value) {
            addCriterion("case_id <>", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThan(Long value) {
            addCriterion("case_id >", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("case_id >=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThan(Long value) {
            addCriterion("case_id <", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdLessThanOrEqualTo(Long value) {
            addCriterion("case_id <=", value, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdIn(List<Long> values) {
            addCriterion("case_id in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotIn(List<Long> values) {
            addCriterion("case_id not in", values, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdBetween(Long value1, Long value2) {
            addCriterion("case_id between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andCaseIdNotBetween(Long value1, Long value2) {
            addCriterion("case_id not between", value1, value2, "caseId");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andRequestDataIsNull() {
            addCriterion("request_data is null");
            return (Criteria) this;
        }

        public Criteria andRequestDataIsNotNull() {
            addCriterion("request_data is not null");
            return (Criteria) this;
        }

        public Criteria andRequestDataEqualTo(String value) {
            addCriterion("request_data =", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotEqualTo(String value) {
            addCriterion("request_data <>", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataGreaterThan(String value) {
            addCriterion("request_data >", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataGreaterThanOrEqualTo(String value) {
            addCriterion("request_data >=", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataLessThan(String value) {
            addCriterion("request_data <", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataLessThanOrEqualTo(String value) {
            addCriterion("request_data <=", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataLike(String value) {
            addCriterion("request_data like", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotLike(String value) {
            addCriterion("request_data not like", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataIn(List<String> values) {
            addCriterion("request_data in", values, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotIn(List<String> values) {
            addCriterion("request_data not in", values, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataBetween(String value1, String value2) {
            addCriterion("request_data between", value1, value2, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotBetween(String value1, String value2) {
            addCriterion("request_data not between", value1, value2, "requestData");
            return (Criteria) this;
        }

        public Criteria andResponseDataIsNull() {
            addCriterion("response_data is null");
            return (Criteria) this;
        }

        public Criteria andResponseDataIsNotNull() {
            addCriterion("response_data is not null");
            return (Criteria) this;
        }

        public Criteria andResponseDataEqualTo(String value) {
            addCriterion("response_data =", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotEqualTo(String value) {
            addCriterion("response_data <>", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataGreaterThan(String value) {
            addCriterion("response_data >", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataGreaterThanOrEqualTo(String value) {
            addCriterion("response_data >=", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLessThan(String value) {
            addCriterion("response_data <", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLessThanOrEqualTo(String value) {
            addCriterion("response_data <=", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLike(String value) {
            addCriterion("response_data like", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotLike(String value) {
            addCriterion("response_data not like", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataIn(List<String> values) {
            addCriterion("response_data in", values, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotIn(List<String> values) {
            addCriterion("response_data not in", values, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataBetween(String value1, String value2) {
            addCriterion("response_data between", value1, value2, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotBetween(String value1, String value2) {
            addCriterion("response_data not between", value1, value2, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseValueIsNull() {
            addCriterion("response_value is null");
            return (Criteria) this;
        }

        public Criteria andResponseValueIsNotNull() {
            addCriterion("response_value is not null");
            return (Criteria) this;
        }

        public Criteria andResponseValueEqualTo(String value) {
            addCriterion("response_value =", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueNotEqualTo(String value) {
            addCriterion("response_value <>", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueGreaterThan(String value) {
            addCriterion("response_value >", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueGreaterThanOrEqualTo(String value) {
            addCriterion("response_value >=", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueLessThan(String value) {
            addCriterion("response_value <", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueLessThanOrEqualTo(String value) {
            addCriterion("response_value <=", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueLike(String value) {
            addCriterion("response_value like", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueNotLike(String value) {
            addCriterion("response_value not like", value, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueIn(List<String> values) {
            addCriterion("response_value in", values, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueNotIn(List<String> values) {
            addCriterion("response_value not in", values, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueBetween(String value1, String value2) {
            addCriterion("response_value between", value1, value2, "responseValue");
            return (Criteria) this;
        }

        public Criteria andResponseValueNotBetween(String value1, String value2) {
            addCriterion("response_value not between", value1, value2, "responseValue");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIsNull() {
            addCriterion("system_version is null");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIsNotNull() {
            addCriterion("system_version is not null");
            return (Criteria) this;
        }

        public Criteria andSystemVersionEqualTo(String value) {
            addCriterion("system_version =", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotEqualTo(String value) {
            addCriterion("system_version <>", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionGreaterThan(String value) {
            addCriterion("system_version >", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionGreaterThanOrEqualTo(String value) {
            addCriterion("system_version >=", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionLessThan(String value) {
            addCriterion("system_version <", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionLessThanOrEqualTo(String value) {
            addCriterion("system_version <=", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionLike(String value) {
            addCriterion("system_version like", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotLike(String value) {
            addCriterion("system_version not like", value, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionIn(List<String> values) {
            addCriterion("system_version in", values, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotIn(List<String> values) {
            addCriterion("system_version not in", values, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionBetween(String value1, String value2) {
            addCriterion("system_version between", value1, value2, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andSystemVersionNotBetween(String value1, String value2) {
            addCriterion("system_version not between", value1, value2, "systemVersion");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNull() {
            addCriterion("device is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotNull() {
            addCriterion("device is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceEqualTo(String value) {
            addCriterion("device =", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotEqualTo(String value) {
            addCriterion("device <>", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThan(String value) {
            addCriterion("device >", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("device >=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThan(String value) {
            addCriterion("device <", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThanOrEqualTo(String value) {
            addCriterion("device <=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLike(String value) {
            addCriterion("device like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotLike(String value) {
            addCriterion("device not like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceIn(List<String> values) {
            addCriterion("device in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotIn(List<String> values) {
            addCriterion("device not in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceBetween(String value1, String value2) {
            addCriterion("device between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotBetween(String value1, String value2) {
            addCriterion("device not between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_Time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_Time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_Time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_Time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_Time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_Time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_Time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_Time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_Time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_Time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_Time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_Time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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