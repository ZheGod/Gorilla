package com.gorilla.sdkUI.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GorillaCaseConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GorillaCaseConfigExample() {
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

        public Criteria andRecordTagIsNull() {
            addCriterion("record_tag is null");
            return (Criteria) this;
        }

        public Criteria andRecordTagIsNotNull() {
            addCriterion("record_tag is not null");
            return (Criteria) this;
        }

        public Criteria andRecordTagEqualTo(String value) {
            addCriterion("record_tag =", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagNotEqualTo(String value) {
            addCriterion("record_tag <>", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagGreaterThan(String value) {
            addCriterion("record_tag >", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagGreaterThanOrEqualTo(String value) {
            addCriterion("record_tag >=", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagLessThan(String value) {
            addCriterion("record_tag <", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagLessThanOrEqualTo(String value) {
            addCriterion("record_tag <=", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagLike(String value) {
            addCriterion("record_tag like", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagNotLike(String value) {
            addCriterion("record_tag not like", value, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagIn(List<String> values) {
            addCriterion("record_tag in", values, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagNotIn(List<String> values) {
            addCriterion("record_tag not in", values, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagBetween(String value1, String value2) {
            addCriterion("record_tag between", value1, value2, "recordTag");
            return (Criteria) this;
        }

        public Criteria andRecordTagNotBetween(String value1, String value2) {
            addCriterion("record_tag not between", value1, value2, "recordTag");
            return (Criteria) this;
        }

        public Criteria andCaseVersionIsNull() {
            addCriterion("case_version is null");
            return (Criteria) this;
        }

        public Criteria andCaseVersionIsNotNull() {
            addCriterion("case_version is not null");
            return (Criteria) this;
        }

        public Criteria andCaseVersionEqualTo(String value) {
            addCriterion("case_version =", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionNotEqualTo(String value) {
            addCriterion("case_version <>", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionGreaterThan(String value) {
            addCriterion("case_version >", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionGreaterThanOrEqualTo(String value) {
            addCriterion("case_version >=", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionLessThan(String value) {
            addCriterion("case_version <", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionLessThanOrEqualTo(String value) {
            addCriterion("case_version <=", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionLike(String value) {
            addCriterion("case_version like", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionNotLike(String value) {
            addCriterion("case_version not like", value, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionIn(List<String> values) {
            addCriterion("case_version in", values, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionNotIn(List<String> values) {
            addCriterion("case_version not in", values, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionBetween(String value1, String value2) {
            addCriterion("case_version between", value1, value2, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseVersionNotBetween(String value1, String value2) {
            addCriterion("case_version not between", value1, value2, "caseVersion");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNull() {
            addCriterion("case_name is null");
            return (Criteria) this;
        }

        public Criteria andCaseNameIsNotNull() {
            addCriterion("case_name is not null");
            return (Criteria) this;
        }

        public Criteria andCaseNameEqualTo(String value) {
            addCriterion("case_name =", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotEqualTo(String value) {
            addCriterion("case_name <>", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThan(String value) {
            addCriterion("case_name >", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameGreaterThanOrEqualTo(String value) {
            addCriterion("case_name >=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThan(String value) {
            addCriterion("case_name <", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLessThanOrEqualTo(String value) {
            addCriterion("case_name <=", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameLike(String value) {
            addCriterion("case_name like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotLike(String value) {
            addCriterion("case_name not like", value, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameIn(List<String> values) {
            addCriterion("case_name in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotIn(List<String> values) {
            addCriterion("case_name not in", values, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameBetween(String value1, String value2) {
            addCriterion("case_name between", value1, value2, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseNameNotBetween(String value1, String value2) {
            addCriterion("case_name not between", value1, value2, "caseName");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueIsNull() {
            addCriterion("case_recordValue is null");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueIsNotNull() {
            addCriterion("case_recordValue is not null");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueEqualTo(String value) {
            addCriterion("case_recordValue =", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueNotEqualTo(String value) {
            addCriterion("case_recordValue <>", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueGreaterThan(String value) {
            addCriterion("case_recordValue >", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueGreaterThanOrEqualTo(String value) {
            addCriterion("case_recordValue >=", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueLessThan(String value) {
            addCriterion("case_recordValue <", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueLessThanOrEqualTo(String value) {
            addCriterion("case_recordValue <=", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueLike(String value) {
            addCriterion("case_recordValue like", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueNotLike(String value) {
            addCriterion("case_recordValue not like", value, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueIn(List<String> values) {
            addCriterion("case_recordValue in", values, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueNotIn(List<String> values) {
            addCriterion("case_recordValue not in", values, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueBetween(String value1, String value2) {
            addCriterion("case_recordValue between", value1, value2, "caseRecordValue");
            return (Criteria) this;
        }

        public Criteria andCaseRecordvalueNotBetween(String value1, String value2) {
            addCriterion("case_recordValue not between", value1, value2, "caseRecordValue");
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