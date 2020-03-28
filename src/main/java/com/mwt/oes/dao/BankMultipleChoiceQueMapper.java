package com.mwt.oes.dao;

import com.mwt.oes.domain.BankMultipleChoiceQue;
import com.mwt.oes.domain.BankMultipleChoiceQueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankMultipleChoiceQueMapper {
    int countByExample(BankMultipleChoiceQueExample example);

    int deleteByExample(BankMultipleChoiceQueExample example);

    int deleteByPrimaryKey(Integer multipleId);

    int insert(BankMultipleChoiceQue record);

    int insertSelective(BankMultipleChoiceQue record);

    List<BankMultipleChoiceQue> selectByExample(BankMultipleChoiceQueExample example);

    BankMultipleChoiceQue selectByPrimaryKey(Integer multipleId);

    int updateByExampleSelective(@Param("record") BankMultipleChoiceQue record, @Param("example") BankMultipleChoiceQueExample example);

    int updateByExample(@Param("record") BankMultipleChoiceQue record, @Param("example") BankMultipleChoiceQueExample example);

    int updateByPrimaryKeySelective(BankMultipleChoiceQue record);

    int updateByPrimaryKey(BankMultipleChoiceQue record);
}