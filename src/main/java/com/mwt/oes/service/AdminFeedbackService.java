package com.mwt.oes.service;

import com.mwt.oes.domain.Feedback;

import java.util.List;
import java.util.Map;

public interface AdminFeedbackService {
    public List<Map<String, Object>> getFeedbacksList();
    public int getUnReplyCount();
    public List<Map<String, Object>> searchFeedbacksList(String feedbackContent);
    public int deleteFeedback(Integer feedbackId);
    public int readFeedback(Integer feedbackId);
}
