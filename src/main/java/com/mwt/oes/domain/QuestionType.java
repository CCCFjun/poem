package com.mwt.oes.domain;

import java.util.Date;

public class QuestionType {
    private Integer langId;

    private String langName;

    private String langDesc;

    private String langImgSrc;

    private Date langCreateTime;

    private String langCreatedBy;

    private Date langChangeTime;

    private Integer langMainType;

    private String langEnName;

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    public String getLangName() {
        return langName;
    }

    public void setLangName(String langName) {
        this.langName = langName == null ? null : langName.trim();
    }

    public String getLangDesc() {
        return langDesc;
    }

    public void setLangDesc(String langDesc) {
        this.langDesc = langDesc == null ? null : langDesc.trim();
    }

    public String getLangImgSrc() {
        return langImgSrc;
    }

    public void setLangImgSrc(String langImgSrc) {
        this.langImgSrc = langImgSrc == null ? null : langImgSrc.trim();
    }

    public Date getLangCreateTime() {
        return langCreateTime;
    }

    public void setLangCreateTime(Date langCreateTime) {
        this.langCreateTime = langCreateTime;
    }

    public String getLangCreatedBy() {
        return langCreatedBy;
    }

    public void setLangCreatedBy(String langCreatedBy) {
        this.langCreatedBy = langCreatedBy == null ? null : langCreatedBy.trim();
    }

    public Date getLangChangeTime() {
        return langChangeTime;
    }

    public void setLangChangeTime(Date langChangeTime) {
        this.langChangeTime = langChangeTime;
    }

    public Integer getLangMainType() {
        return langMainType;
    }

    public void setLangMainType(Integer langMainType) {
        this.langMainType = langMainType;
    }

    public String getLangEnName() {
        return langEnName;
    }

    public void setLangEnName(String langEnName) {
        this.langEnName = langEnName == null ? null : langEnName.trim();
    }
}