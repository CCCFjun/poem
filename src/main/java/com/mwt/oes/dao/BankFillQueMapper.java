package com.mwt.oes.dao;

import com.mwt.oes.domain.BankFillQue;
import com.mwt.oes.domain.BankFillQueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankFillQueMapper {
    int countByExample(BankFillQueExample example);

    int deleteByExample(BankFillQueExample example);

    int deleteByPrimaryKey(Integer fillId);

    int insert(BankFillQue record);

    int insertSelective(BankFillQue record);

    List<BankFillQue> selectByExample(BankFillQueExample example);

    BankFillQue selectByPrimaryKey(Integer fillId);

    int updateByExampleSelective(@Param("record") BankFillQue record, @Param("example") BankFillQueExample example);

    int updateByExample(@Param("record") BankFillQue record, @Param("example") BankFillQueExample example);

    int updateByPrimaryKeySelective(BankFillQue record);

    int updateByPrimaryKey(BankFillQue record);

    List<BankFillQue> getFillQueListByPaperId(Integer paperId);

    List<BankFillQue> getFillQueListByPaperIdAndLangId(Integer paperId,Integer langId);

    List<BankFillQue> getRandomFillByCountAndLangId(@Param("fillNum")Integer fillNum,Integer langId);
}