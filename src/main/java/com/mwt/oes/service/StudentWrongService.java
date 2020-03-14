package com.mwt.oes.service;

import com.mwt.oes.domain.StudentPaperAnswer;

import java.util.List;
import java.util.Map;

public interface StudentWrongService {
    public List<Map<String, Object>> getWrongAllPapers(String sno);
    public List<Map<String, Object>> getWrongPapersByLangId(String sno, Integer langId);
    public List<Map<String, Object>> getSingleQueListByWrongPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getMultipleQueListByWrongPaperId(String sno, Integer paperId);
    public List<Map<String, Object>> getJudgeQueListByWrongPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getFillQueListByWrongPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getFillTwoQueListByWrongPaperId(String userPhone, Integer paperId);
    public int updatePaperAnswerIsCollect(StudentPaperAnswer studentPaperAnswer);
    public List<Map<String, Object>> getAllCollections(String userPhone);
    public List<Map<String, Object>> getCollectionsById(String sno, Integer queType);
    public Map<String, Object> getSingleByAnswerId(Integer answerId);
    public Map<String, Object> getMultipleByAnswerId(Integer answerId);
    public Map<String, Object> getJudgeByAnswerId(Integer answerId);
    public Map<String, Object> getFillByAnswerId(Integer answerId);
}
