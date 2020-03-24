package com.mwt.oes.domain;

import java.util.Date;

public class Paper {
    private Integer paperId;

    private String paperName;

    private Date paperCreateTime;

    private Integer paperDuration;

    private Integer paperDifficulty;

    private String paperAttention;

    private Integer paperType;

    private Integer participateNum;

    private String paperImgSrc;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName == null ? null : paperName.trim();
    }

    public Date getPaperCreateTime() {
        return paperCreateTime;
    }

    public void setPaperCreateTime(Date paperCreateTime) {
        this.paperCreateTime = paperCreateTime;
    }

    public Integer getPaperDuration() {
        return paperDuration;
    }

    public void setPaperDuration(Integer paperDuration) {
        this.paperDuration = paperDuration;
    }

    public Integer getPaperDifficulty() {
        return paperDifficulty;
    }

    public void setPaperDifficulty(Integer paperDifficulty) {
        this.paperDifficulty = paperDifficulty;
    }

    public String getPaperAttention() {
        return paperAttention;
    }

    public void setPaperAttention(String paperAttention) {
        this.paperAttention = paperAttention == null ? null : paperAttention.trim();
    }

    public Integer getPaperType() {
        return paperType;
    }

    public void setPaperType(Integer paperType) {
        this.paperType = paperType;
    }

    public Integer getParticipateNum() {
        return participateNum;
    }

    public void setParticipateNum(Integer participateNum) {
        this.participateNum = participateNum;
    }

    public String getPaperImgSrc() {
        return paperImgSrc;
    }

    public void setPaperImgSrc(String paperImgSrc) {
        this.paperImgSrc = paperImgSrc;
    }
}