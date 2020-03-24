package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminTypeServiceImpl implements AdminTypeService {

    @Autowired
    QuestionTypeMapper queTypeMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    BankFillQueMapper bankFillQueMapper;
    @Autowired
    BankJudgeQueMapper bankJudgeQueMapper;
    @Autowired
    BankSingleChoiceQueMapper bankSingleChoiceQueMapper;

    @Override
    public List<Map<String, Object>> getTypesList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        questionTypeExample.setOrderByClause("lang_id asc");
        List<QuestionType> questionTypeList = queTypeMapper.selectByExample(questionTypeExample);
        for (QuestionType questionType : questionTypeList) {
            int index = questionTypeList.indexOf(questionType);
            Map<String, Object> map = new HashMap<>();
            map.put("id", index + 1);
            map.put("langId", questionType.getLangId());
            map.put("langName", questionType.getLangName());
            map.put("langDesc", questionType.getLangDesc());
            map.put("langImgSrc", questionType.getLangImgSrc());
            map.put("langCreatedBy", questionType.getLangCreatedBy());
            map.put("langChangeTime", questionType.getLangChangeTime());
            map.put("langLastChanger", questionType.getLangLastChanger());
            map.put("langEnName", questionType.getLangEnName());
//            PaperExample paperExample = new PaperExample();
//            PaperExample.Criteria criteria = paperExample.createCriteria();
//            criteria.andLangIdEqualTo(questionType.getLangId());
//            int paperCount = paperMapper.countByExample(paperExample);
//            map.put("paperCount", paperCount);
            BankFillQueExample bankFillQueExample = new BankFillQueExample();
            BankFillQueExample.Criteria criteria = bankFillQueExample.createCriteria();
            criteria.andLangIdEqualTo(questionType.getLangId());
            int queFillCount = bankFillQueMapper.countByExample(bankFillQueExample);
            BankJudgeQueExample bankJudgeQueExample = new BankJudgeQueExample();
            BankJudgeQueExample.Criteria criteria2 = bankJudgeQueExample.createCriteria();
            criteria2.andLangIdEqualTo(questionType.getLangId());
            int queJudgeCount = bankJudgeQueMapper.countByExample(bankJudgeQueExample);
            BankSingleChoiceQueExample bankSingleChoiceQueExample = new BankSingleChoiceQueExample();
            BankSingleChoiceQueExample.Criteria criteria3 = bankSingleChoiceQueExample.createCriteria();
            criteria3.andLangIdEqualTo(questionType.getLangId());
            int queSingleCount = bankSingleChoiceQueMapper.countByExample(bankSingleChoiceQueExample);
            if(queFillCount != 0){
                map.put("queCount", queFillCount);
            }else if(queJudgeCount != 0){
                map.put("queCount", queJudgeCount);
            }else if(queSingleCount != 0){
                map.put("queCount", queSingleCount);
            }else{
                map.put("queCount", 0);
            }

            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> searchTypesList(String langName) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        QuestionTypeExample.Criteria criteria = questionTypeExample.createCriteria();
        if (!langName.equals("undefined")) {
            criteria.andLangNameLike("%" + langName + "%");
        }
        questionTypeExample.setOrderByClause("lang_id asc");
        List<QuestionType> questionTypeList = queTypeMapper.selectByExample(questionTypeExample);
        for (QuestionType questionType : questionTypeList) {
            int index = questionTypeList.indexOf(questionType);
            Map<String, Object> map = new HashMap<>();
            map.put("id", index + 1);
            map.put("langId", questionType.getLangId());
            map.put("langName", questionType.getLangName());
            map.put("langDesc", questionType.getLangDesc());
            map.put("langCreatedBy", questionType.getLangCreatedBy());
            map.put("langImgSrc", questionType.getLangImgSrc());
            map.put("langChangeTime", questionType.getLangChangeTime());
            map.put("langLastChanger", questionType.getLangLastChanger());
            BankFillQueExample bankFillQueExample = new BankFillQueExample();
            BankFillQueExample.Criteria criteria1 = bankFillQueExample.createCriteria();
            criteria1.andLangIdEqualTo(questionType.getLangId());
            int queFillCount = bankFillQueMapper.countByExample(bankFillQueExample);
            BankJudgeQueExample bankJudgeQueExample = new BankJudgeQueExample();
            BankJudgeQueExample.Criteria criteria2 = bankJudgeQueExample.createCriteria();
            criteria2.andLangIdEqualTo(questionType.getLangId());
            int queJudgeCount = bankJudgeQueMapper.countByExample(bankJudgeQueExample);
            BankSingleChoiceQueExample bankSingleChoiceQueExample = new BankSingleChoiceQueExample();
            BankSingleChoiceQueExample.Criteria criteria3 = bankSingleChoiceQueExample.createCriteria();
            criteria3.andLangIdEqualTo(questionType.getLangId());
            int queSingleCount = bankSingleChoiceQueMapper.countByExample(bankSingleChoiceQueExample);
            if(queFillCount != 0){
                map.put("queCount", queFillCount);
            }else if(queJudgeCount != 0){
                map.put("queCount", queJudgeCount);
            }else if(queSingleCount != 0){
                map.put("queCount", queSingleCount);
            }else{
                map.put("queCount", 0);
            }
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int insertTypeInfo(QuestionType questionType) {
        questionType.setLangCreateTime(new Date());
        int result = queTypeMapper.insertSelective(questionType);
        return result;
    }

    @Override
    public int updateTypeInfo(QuestionType questionType) {
        questionType.setLangChangeTime(new Date());
        int result = queTypeMapper.updateByPrimaryKeySelective(questionType);
        return result;
    }

    @Override
    public int deleteType(Integer langId) {
        int result = queTypeMapper.deleteByPrimaryKey(langId);
        return result;
    }
}
