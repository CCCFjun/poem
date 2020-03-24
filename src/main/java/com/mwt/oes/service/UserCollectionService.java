package com.mwt.oes.service;

import com.mwt.oes.domain.UserPaperAnswer;

import java.util.List;
import java.util.Map;

public interface UserCollectionService {
    public int updatePaperAnswerIsCollect(UserPaperAnswer userPaperAnswer);
    public List<Map<String, Object>> getAllCollections(String userPhone);
    public Map<String, Object> getSingleByAnswerId(Integer answerId);
    public Map<String, Object> getJudgeByAnswerId(Integer answerId);
    public Map<String, Object> getFillByAnswerId(Integer answerId);
}
