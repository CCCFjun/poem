package com.mwt.oes.dao;

import com.mwt.oes.domain.UserPost;
import com.mwt.oes.domain.UserPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPostMapper {
    int countByExample(UserPostExample example);

    int deleteByExample(UserPostExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(UserPost record);

    int insertSelective(UserPost record);

    List<UserPost> selectByExample(UserPostExample example);

    UserPost selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") UserPost record, @Param("example") UserPostExample example);

    int updateByExample(@Param("record") UserPost record, @Param("example") UserPostExample example);

    int updateByPrimaryKeySelective(UserPost record);

    int updateByPrimaryKey(UserPost record);
}