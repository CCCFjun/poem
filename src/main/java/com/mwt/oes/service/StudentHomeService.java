package com.mwt.oes.service;

import com.mwt.oes.domain.Paper;
import com.mwt.oes.domain.QuestionType;
import com.mwt.oes.domain.UserRotationImg;
import com.mwt.oes.domain.StudentPaperScore;

import java.util.List;
import java.util.Map;

public interface StudentHomeService {
    public List<UserRotationImg> getRotationImages();
    public List<QuestionType> getLanguagesInfo();
    public List<QuestionType> getPracticeKind();
    public QuestionType getLanguageInfoById(Integer langId);
    public QuestionType getKindInfoById(Integer langId);
    public List<Paper> getPapersInfo(Integer langId);
    public Paper getPapersInfoByPaperId(Integer paperId);
    public Map<String, Integer> getPaperQueNumByPaperId(Integer paperId);
    public int insertStudentPaperScore(StudentPaperScore studentPaperScore);
    public List<Map<String, Object>> getSingleQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getMultipleQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getJudgeQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getFillQueListByPaperId(Integer paperId);
    public List<Map<String, Object>> getFillTwoQueListByPaperId(Integer paperId);
    public int insertPaperAnswerAndPaperScore(String userPhone, Integer paperId, List<String> singleAnswers,
                                              List<String> judgeAnswers,
                                              List<String> fillAnswers, List<String> fillTwoAnswers,int timeUsed);
    public List<StudentPaperScore> getCurrentPaperStatus(String userPhone, Integer paperId);
    public Map<String, Object> getScoreReport(String sno, Integer paperId);
    public List<Map<String, Object>> getScoreListByPaperId(Integer paperId);
}
