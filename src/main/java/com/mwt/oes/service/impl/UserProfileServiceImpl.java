package com.mwt.oes.service.impl;

import com.mwt.oes.dao.FeedbackMapper;
import com.mwt.oes.domain.Feedback;
import com.mwt.oes.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    FeedbackMapper feedbackMapper;
    /*
        学生我的页面反馈留言
     */
    @Override
    public int userSendFeedback(String content, Date createTime, String userPhone, String userName) {
        Feedback feedback = new Feedback();
        feedback.setFeedbackContent(content);
        feedback.setFeedbackCreateTime(createTime);
        feedback.setUserPhone(userPhone);
        feedback.setUserName(userName);
        int result = feedbackMapper.insertSelective(feedback);

        return result;
    }
}
