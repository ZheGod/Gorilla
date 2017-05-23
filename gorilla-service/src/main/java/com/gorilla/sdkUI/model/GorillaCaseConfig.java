package com.gorilla.sdkUI.model;

import java.util.Date;

public class GorillaCaseConfig {
    private Long id;

    private String recordTag;

    private String caseVersion;

    private String caseName;

    private String caseRecordValue;

    private String systemVersion;

    private String device;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordTag() {
        return recordTag;
    }

    public void setRecordTag(String recordTag) {
        this.recordTag = recordTag == null ? null : recordTag.trim();
    }

    public String getCaseVersion() {
        return caseVersion;
    }

    public void setCaseVersion(String caseVersion) {
        this.caseVersion = caseVersion == null ? null : caseVersion.trim();
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName == null ? null : caseName.trim();
    }

    public String getCaseRecordValue() {
        return caseRecordValue;
    }

    public void setCaseRecordValue(String caseRecordValue) {
        this.caseRecordValue = caseRecordValue == null ? null : caseRecordValue.trim();
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion == null ? null : systemVersion.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}