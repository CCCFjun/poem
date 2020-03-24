package com.mwt.oes.service;

import java.util.Date;

public interface UserProfileService {
    public int userSendFeedback(String content, Date createTime, String userPhone, String userName);
    public int getAdminReplyCount(String userPhone, String feedbackStatus);
}
