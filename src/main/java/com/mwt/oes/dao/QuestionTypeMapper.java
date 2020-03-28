package com.mwt.oes.dao;

import com.mwt.oes.domain.QuestionType;
import com.mwt.oes.domain.QuestionTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionTypeMapper {
    int countByExample(QuestionTypeExample example);

    int deleteByExample(QuestionTypeExample example);

    int deleteByPrimaryKey(Integer langId);

    int insert(QuestionType record);

    int insertSelective(QuestionType record);

    List<QuestionType> selectByExample(QuestionTypeExample example);

    QuestionType selectByPrimaryKey(Integer langId);

    int updateByExampleSelective(@Param("record") QuestionType record, @Param("example") QuestionTypeExample example);

    int updateByExample(@Param("record") QuestionType record, @Param("example") QuestionTypeExample example);

    int updateByPrimaryKeySelective(QuestionType record);

    int updateByPrimaryKey(QuestionType record);
}