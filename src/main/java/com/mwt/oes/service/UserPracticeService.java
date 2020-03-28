package com.mwt.oes.service;

import com.mwt.oes.domain.QuestionType;

import java.util.List;
import java.util.Map;

public interface UserPracticeService {
    public List<QuestionType> getPracticeKind();
    public QuestionType getKindInfoById(Integer langId);
    public List<Map<String, Object>> getRandomSingleList(Integer num, Integer kindId);
    public List<Map<String, Object>> getRandomJudgeList(Integer num);
    public List<Map<String, Object>> getRandomFillList(Integer num);
    public List<Map<String, Object>> getRandomFillTwoList(Integer num);
}
