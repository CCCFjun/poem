package com.mwt.oes.service;

import com.mwt.oes.domain.QuestionType;

import java.util.List;
import java.util.Map;

public interface UserPracticeService {
    public List<QuestionType> getPracticeKind();
    public QuestionType getKindInfoById(Integer langId);
    public List<Map<String, Object>> getRandomSingleList();
    public List<Map<String, Object>> getRandomJudgeList();
    public List<Map<String, Object>> getRandomFillList();
    public List<Map<String, Object>> getRandomFillTwoList();
}
