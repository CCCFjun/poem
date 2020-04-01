package com.mwt.oes.dao;

import com.mwt.oes.domain.UserLikePost;
import com.mwt.oes.domain.UserLikePostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLikePostMapper {
    int countByExample(UserLikePostExample example);

    int deleteByExample(UserLikePostExample example);

    int deleteByPrimaryKey(Integer likeId);

    int insert(UserLikePost record);

    int insertSelective(UserLikePost record);

    List<UserLikePost> selectByExample(UserLikePostExample example);

    UserLikePost selectByPrimaryKey(Integer likeId);

    int updateByExampleSelective(@Param("record") UserLikePost record, @Param("example") UserLikePostExample example);

    int updateByExample(@Param("record") UserLikePost record, @Param("example") UserLikePostExample example);

    int updateByPrimaryKeySelective(UserLikePost record);

    int updateByPrimaryKey(UserLikePost record);
}