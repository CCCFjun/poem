package com.mwt.oes.service;

import com.mwt.oes.domain.User;

import java.util.List;
import java.util.Map;

public interface UserPracticeService {
    public List<Map<String, Object>> getRandomSingleList();
    public List<Map<String, Object>> getRandomJudgeList();
    public List<Map<String, Object>> getRandomFillList();
    public List<Map<String, Object>> getRandomFillTwoList();
}
