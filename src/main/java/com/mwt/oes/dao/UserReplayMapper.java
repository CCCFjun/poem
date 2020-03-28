package com.mwt.oes.dao;

import com.mwt.oes.domain.UserReplay;
import com.mwt.oes.domain.UserReplayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserReplayMapper {
    int countByExample(UserReplayExample example);

    int deleteByExample(UserReplayExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(UserReplay record);

    int insertSelective(UserReplay record);

    List<UserReplay> selectByExample(UserReplayExample example);

    UserReplay selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") UserReplay record, @Param("example") UserReplayExample example);

    int updateByExample(@Param("record") UserReplay record, @Param("example") UserReplayExample example);

    int updateByPrimaryKeySelective(UserReplay record);

    int updateByPrimaryKey(UserReplay record);
}