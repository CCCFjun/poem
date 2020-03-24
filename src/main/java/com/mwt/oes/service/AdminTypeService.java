package com.mwt.oes.service;

import com.mwt.oes.domain.QuestionType;

import java.util.List;
import java.util.Map;

public interface AdminTypeService {
    public List<Map<String, Object>> getTypesList();
    public List<Map<String, Object>> searchTypesList(String langName);
    public int insertTypeInfo(QuestionType questionType);
    public int updateTypeInfo(QuestionType questionType);
    public int deleteType(Integer langId);
}
