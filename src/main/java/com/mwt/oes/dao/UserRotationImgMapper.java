package com.mwt.oes.dao;

import com.mwt.oes.domain.UserRotationImg;
import com.mwt.oes.domain.UserRotationImgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRotationImgMapper {
    int countByExample(UserRotationImgExample example);

    int deleteByExample(UserRotationImgExample example);

    int deleteByPrimaryKey(Integer imgId);

    int insert(UserRotationImg record);

    int insertSelective(UserRotationImg record);

    List<UserRotationImg> selectByExample(UserRotationImgExample example);

    UserRotationImg selectByPrimaryKey(Integer imgId);

    int updateByExampleSelective(@Param("record") UserRotationImg record, @Param("example") UserRotationImgExample example);

    int updateByExample(@Param("record") UserRotationImg record, @Param("example") UserRotationImgExample example);

    int updateByPrimaryKeySelective(UserRotationImg record);

    int updateByPrimaryKey(UserRotationImg record);
}