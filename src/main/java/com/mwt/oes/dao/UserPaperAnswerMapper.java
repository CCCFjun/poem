package com.mwt.oes.dao;

import com.mwt.oes.domain.UserPaperAnswer;
import com.mwt.oes.domain.UserPaperAnswerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPaperAnswerMapper {
    int countByExample(UserPaperAnswerExample example);

    int deleteByExample(UserPaperAnswerExample example);

    int deleteByPrimaryKey(Integer answerId);

    int insert(UserPaperAnswer record);

    int insertSelective(UserPaperAnswer record);

    List<UserPaperAnswer> selectByExample(UserPaperAnswerExample example);

    UserPaperAnswer selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") UserPaperAnswer record, @Param("example") UserPaperAnswerExample example);

    int updateByExample(@Param("record") UserPaperAnswer record, @Param("example") UserPaperAnswerExample example);

    int updateByPrimaryKeySelective(UserPaperAnswer record);

    int updateByPrimaryKey(UserPaperAnswer record);

    int selectSingleCorrectCount(UserPaperAnswer record);

    int selectMultipleCorrectCount(UserPaperAnswer record);

    int selectJudgeCorrectCount(UserPaperAnswer record);

    int selectFillCorrectCount(UserPaperAnswer record);
}