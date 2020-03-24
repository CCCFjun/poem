package com.mwt.oes.service;

import com.mwt.oes.domain.Paper;
import com.mwt.oes.domain.UserPaperScore;

import java.util.List;
import java.util.Map;

public interface UserExamService {
    public Paper getPapersInfoByPaperId(Integer paperId);
    public Map<String, Integer> getPaperQueNumByPaperId(Integer paperId);
    public List<Map<String, Object>> getSingleQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getJudgeQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getFillQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getFillTwoQueListByPaperId(Integer paperId);
    public List<UserPaperScore> getCurrentPaperStatus(String userPhone, Integer paperId);
    public int insertStudentPaperScore(UserPaperScore userPaperScore);
    public int insertPaperAnswerAndPaperScore(String userPhone, Integer paperId, List<String> singleAnswers,
                                              List<String> judgeAnswers,
                                              List<String> fillAnswers,List<String> fillTwoAnswers, int timeUsed);
    public List<Map<String, Object>> getSingleQueListByJoinedPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getJudgeQueListByJoinedPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getFillQueListByJoinedPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getFillTwoQueListByJoinedPaperId(String userPhone, Integer paperId);
    public List<Map<String, Object>> getScoreListByPaperId(Integer paperId);
}
