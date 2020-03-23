package com.mwt.oes.domain;

import java.util.Date;

public class Notice {
    private Integer noticeId;

    private String noticeContent;

    private Date noticeCreateTime;

    private String adminName;

    private String ano;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano == null ? null : ano.trim();
    }
}