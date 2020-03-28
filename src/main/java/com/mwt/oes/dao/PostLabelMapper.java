package com.mwt.oes.dao;

import com.mwt.oes.domain.PostLabel;
import com.mwt.oes.domain.PostLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostLabelMapper {
    int countByExample(PostLabelExample example);

    int deleteByExample(PostLabelExample example);

    int deleteByPrimaryKey(Integer lid);

    int insert(PostLabel record);

    int insertSelective(PostLabel record);

    List<PostLabel> selectByExample(PostLabelExample example);

    PostLabel selectByPrimaryKey(Integer lid);

    int updateByExampleSelective(@Param("record") PostLabel record, @Param("example") PostLabelExample example);

    int updateByExample(@Param("record") PostLabel record, @Param("example") PostLabelExample example);

    int updateByPrimaryKeySelective(PostLabel record);

    int updateByPrimaryKey(PostLabel record);
}