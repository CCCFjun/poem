package com.mwt.oes.dao;

import com.mwt.oes.domain.UserPaperScore;
import com.mwt.oes.domain.UserPaperScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPaperScoreMapper {
    int countByExample(UserPaperScoreExample example);

    int deleteByExample(UserPaperScoreExample example);

    int deleteByPrimaryKey(Integer scoreId);

    int insert(UserPaperScore record);

    int insertSelective(UserPaperScore record);

    List<UserPaperScore> selectByExample(UserPaperScoreExample example);

    UserPaperScore selectByPrimaryKey(Integer scoreId);

    int updateByExampleSelective(@Param("record") UserPaperScore record, @Param("example") UserPaperScoreExample example);

    int updateByExample(@Param("record") UserPaperScore record, @Param("example") UserPaperScoreExample example);

    int updateByPrimaryKeySelective(UserPaperScore record);

    int updateByPrimaryKey(UserPaperScore record);
}