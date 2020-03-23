package com.mwt.oes.service.impl;

import com.mwt.oes.dao.FeedbackMapper;
import com.mwt.oes.dao.UserMapper;
import com.mwt.oes.domain.User;
import com.mwt.oes.domain.Feedback;
import com.mwt.oes.domain.FeedbackExample;
import com.mwt.oes.service.AdminFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminFeedbackServiceImpl implements AdminFeedbackService {

    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> getFeedbacksList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        FeedbackExample feedbackExample = new FeedbackExample();
        feedbackExample.setOrderByClause("feedback_status asc");
        List<Feedback> feedbackList = feedbackMapper.selectByExample(feedbackExample);
        for (Feedback feedback : feedbackList) {
            int index = feedbackList.indexOf(feedback);
            Map<String, Object> map = new HashMap<>();
            map.put("id", index + 1);
            map.put("feedbackId", feedback.getFeedbackId());
            map.put("feedbackContent", feedback.getFeedbackContent());
            map.put("feedbackCreateTime", feedback.getFeedbackCreateTime());
            map.put("userPhone", feedback.getUserPhone());
            User user = userMapper.selectByPrimaryKey(feedback.getUserPhone());
            map.put("userName", feedback.getUserName());
            map.put("admAnswer", feedback.getAdmAnswer());
            map.put("ano", feedback.getAno());
            map.put("admName", feedback.getAdmName());
            map.put("feedbackStatus", feedback.getFeedbackStatus());
            map.put("replyTime", feedback.getReplyTime());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int getUnReplyCount() {
        FeedbackExample feedbackExample = new FeedbackExample();
        FeedbackExample.Criteria criteria = feedbackExample.createCriteria();
        criteria.andFeedbackStatusEqualTo("0");
        int result = feedbackMapper.countByExample(feedbackExample);
        return result;
    }

    @Override
    public List<Map<String, Object>> searchFeedbacksList(String feedbackContent, String userName, String admAnswer, String admName, String feedbackStatus) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        FeedbackExample feedbackExample = new FeedbackExample();
        FeedbackExample.Criteria criteria = feedbackExample.createCriteria();
        if (!feedbackContent.equals("undefined")) {
            criteria.andFeedbackContentLike("%" + feedbackContent + "%");
        }
        if (!userName.equals("undefined")) {
            criteria.andUserNameLike("%" + userName + "%");
        }
        if (!admAnswer.equals("undefined")) {
            criteria.andAdmAnswerLike("%" + admAnswer + "%");
        }
        if (!admName.equals("undefined")) {
            criteria.andAdmNameLike("%" + admName + "%");
        }
        if (!feedbackStatus.equals("undefined")) {
            if (feedbackStatus.equals("0")) {
                criteria.andFeedbackStatusEqualTo("0");
            } else {
                List<String> value = new ArrayList<>();
                value.add("1");
                value.add("2");
                criteria.andFeedbackStatusIn(value);
            }
        }
        feedbackExample.setOrderByClause("feedback_status asc");
        List<Feedback> feedbackList = feedbackMapper.selectByExample(feedbackExample);
        for (Feedback feedback : feedbackList) {
            int index = feedbackList.indexOf(feedback);
            Map<String, Object> map = new HashMap<>();
            map.put("id", index + 1);
            map.put("feedbackId", feedback.getFeedbackId());
            map.put("feedbackContent", feedback.getFeedbackContent());
            map.put("feedbackCreateTime", feedback.getFeedbackCreateTime());
            map.put("userPhone", feedback.getUserPhone());
            User user = userMapper.selectByPrimaryKey(feedback.getUserPhone());
            map.put("userName", feedback.getUserName());
            map.put("admAnswer", feedback.getAdmAnswer());
            map.put("admName", feedback.getAdmName());
            map.put("ano", feedback.getAno());
            map.put("feedbackStatus", feedback.getFeedbackStatus());
            map.put("replyTime", feedback.getReplyTime());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int deleteFeedback(Integer feedbackId) {
        int resule = feedbackMapper.deleteByPrimaryKey(feedbackId);
        return resule;
    }

    @Override
    public int replyFeedback(Feedback feedback) {
        feedback.setReplyTime(new Date());
        feedback.setFeedbackStatus("1");
        int result = feedbackMapper.updateByPrimaryKeySelective(feedback);
        return result;
    }
}
