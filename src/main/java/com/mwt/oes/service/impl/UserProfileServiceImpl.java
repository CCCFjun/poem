package com.mwt.oes.service.impl;

import com.mwt.oes.dao.FeedbackMapper;
import com.mwt.oes.domain.Feedback;
import com.mwt.oes.domain.FeedbackExample;
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

    /*
        我的页面顶部右侧管理员回复消息提醒
    */
    @Override
    public int getAdminReplyCount(String userPhone, String feedbackStatus){
        FeedbackExample example = new FeedbackExample();
        FeedbackExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        criteria.andFeedbackStatusEqualTo(feedbackStatus);
        int count = feedbackMapper.countByExample(example);
        return count;
    }
}
