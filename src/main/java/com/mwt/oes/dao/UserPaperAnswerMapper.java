package com.mwt.oes.dao;

import com.mwt.oes.domain.UserPaperAnswer;
import com.mwt.oes.domain.UserPaperAnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}