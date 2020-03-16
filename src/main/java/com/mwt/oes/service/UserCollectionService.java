package com.mwt.oes.service;

import com.mwt.oes.domain.StudentPaperAnswer;

import java.util.List;
import java.util.Map;

public interface UserCollectionService {
    public int updatePaperAnswerIsCollect(StudentPaperAnswer studentPaperAnswer);
    public List<Map<String, Object>> getAllCollections(String userPhone);
    public Map<String, Object> getSingleByAnswerId(Integer answerId);
    public Map<String, Object> getJudgeByAnswerId(Integer answerId);
    public Map<String, Object> getFillByAnswerId(Integer answerId);
}
