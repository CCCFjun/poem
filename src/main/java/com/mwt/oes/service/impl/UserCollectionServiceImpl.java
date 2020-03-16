package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.UserCollectionService;
import com.mwt.oes.util.FindContentWithImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserCollectionServiceImpl implements UserCollectionService {

    @Autowired
    StudentPaperAnswerMapper studentPaperAnswerMapper;
    @Autowired
    BankSingleChoiceQueMapper bankSingleChoiceQueMapper;
    @Autowired
    BankJudgeQueMapper bankJudgeQueMapper;
    @Autowired
    BankFillQueMapper bankFillQueMapper;
    @Autowired
    PaperQueMapper paperQueMapper;

    /*
        请求根据answerId更新学生试卷答案表isCollect字段
     */
    @Override
    public int updatePaperAnswerIsCollect(StudentPaperAnswer studentPaperAnswer){
        int result = studentPaperAnswerMapper.updateByPrimaryKeySelective(studentPaperAnswer);
        return result;
    }

    /*
       获取全部收藏题目
    */
    @Override
    public List<Map<String, Object>> getAllCollections(String userPhone) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        StudentPaperAnswerExample studentPaperAnswerExample = new StudentPaperAnswerExample();
        StudentPaperAnswerExample.Criteria criteria = studentPaperAnswerExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        criteria.andIscollectEqualTo("1");
        List<StudentPaperAnswer> studentPaperAnswerList = studentPaperAnswerMapper.selectByExample(studentPaperAnswerExample);
        for (StudentPaperAnswer studentPaperAnswer : studentPaperAnswerList){
            Map<String, Object> map = new HashMap<>();
            Integer queId = studentPaperAnswer.getQueId();
            //存储答案id
            map.put("answerId",studentPaperAnswer.getAnswerId());
            PaperQue paperQue = paperQueMapper.selectByPrimaryKey(queId);
            //存储题目类型
            map.put("queType",paperQue.getQueType());
            if(paperQue.getQueType() == 1){
                BankSingleChoiceQue bankSingleChoiceQue = bankSingleChoiceQueMapper.selectByPrimaryKey(paperQue.getSingleId());
                Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
                map.put("content",singleContentMap.get("content"));
            }
            if (paperQue.getQueType() == 2){
                BankJudgeQue bankJudgeQue = bankJudgeQueMapper.selectByPrimaryKey(paperQue.getJudgeId());
                map.put("content",bankJudgeQue.getJudgeContent());
            }
            if(paperQue.getQueType() == 3 || paperQue.getQueType() == 4){
                BankFillQue bankFillQue = bankFillQueMapper.selectByPrimaryKey(paperQue.getFillId());
                map.put("content",bankFillQue.getFillContent());
            }
            resultList.add(map);
        }

        return resultList;
    }

    /*
        通过answerId获取收藏单选题信息
    */
    public Map<String, Object> getSingleByAnswerId(Integer answerId){
        Map<String, Object> map = new HashMap<>();
        StudentPaperAnswer studentPaperAnswer = studentPaperAnswerMapper.selectByPrimaryKey(answerId);
        map.put("stuAnswer",studentPaperAnswer.getStuAnswer());
        map.put("isCorrect",studentPaperAnswer.getIscorrect());
        map.put("isCollect",studentPaperAnswer.getIscollect());

        PaperQue paperQue = paperQueMapper.selectByPrimaryKey(studentPaperAnswer.getQueId());

        BankSingleChoiceQue bankSingleChoiceQue = bankSingleChoiceQueMapper.selectByPrimaryKey(paperQue.getSingleId());
        Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
        map.put("singleContent",singleContentMap.get("content"));
        map.put("pictureSrc",singleContentMap.get("pictureSrc"));
        map.put("singleAnswer",bankSingleChoiceQue.getSingleAnswer());
        map.put("answerExplain",bankSingleChoiceQue.getAnswerExplain());

        //获取单选题选项数组
        List<Map<String, String>> optionsList = new ArrayList<>();
        Map<String, String> optionA = new HashMap<>();
        optionA.put("label",bankSingleChoiceQue.getChoiceA());
        optionA.put("value","A");
        optionsList.add(optionA);
        Map<String, String> optionB = new HashMap<>();
        optionB.put("label",bankSingleChoiceQue.getChoiceB());
        optionB.put("value","B");
        optionsList.add(optionB);
        Map<String, String> optionC = new HashMap<>();
        if(bankSingleChoiceQue.getChoiceC()!=null) {
            optionC.put("label", bankSingleChoiceQue.getChoiceC());
            optionC.put("value", "C");
            optionsList.add(optionC);
        }
        Map<String, String> optionD = new HashMap<>();
        if(bankSingleChoiceQue.getChoiceD()!=null) {
            optionD.put("label", bankSingleChoiceQue.getChoiceD());
            optionD.put("value", "D");
            optionsList.add(optionD);
        }
        Map<String, String> optionE = new HashMap<>();
        if(bankSingleChoiceQue.getChoiceE()!=null) {
            optionE.put("label", bankSingleChoiceQue.getChoiceE());
            optionE.put("value", "E");
            optionsList.add(optionE);
        }
        Map<String, String> optionF = new HashMap<>();
        if(bankSingleChoiceQue.getChoiceF()!=null) {
            optionF.put("label", bankSingleChoiceQue.getChoiceF());
            optionF.put("value", "F");
            optionsList.add(optionF);
        }
        Map<String, String> optionG = new HashMap<>();
        if(bankSingleChoiceQue.getChoiceG()!=null) {
            optionG.put("label", bankSingleChoiceQue.getChoiceG());
            optionG.put("value", "G");
            optionsList.add(optionG);
        }
        map.put("options",optionsList);

        return map;
    }

    /*
        通过answerId获取收藏判断题信息
    */
    public Map<String, Object> getJudgeByAnswerId(Integer answerId){
        Map<String, Object> map = new HashMap<>();

        StudentPaperAnswer studentPaperAnswer = studentPaperAnswerMapper.selectByPrimaryKey(answerId);
        map.put("stuAnswer",studentPaperAnswer.getStuAnswer());
        map.put("isCorrect",studentPaperAnswer.getIscorrect());
        map.put("isCollect",studentPaperAnswer.getIscollect());

        PaperQue paperQue = paperQueMapper.selectByPrimaryKey(studentPaperAnswer.getQueId());

        BankJudgeQue bankJudgeQue = bankJudgeQueMapper.selectByPrimaryKey(paperQue.getJudgeId());
        map.put("judgeContent",bankJudgeQue.getJudgeContent());
        map.put("judgeAnswer",bankJudgeQue.getJudgeAnswer());
        map.put("answerExplain",bankJudgeQue.getAnswerExplain());

        List<Map<String, String>> optionsList = new ArrayList<>();
        Map<String, String> optionT = new HashMap<>();
        optionT.put("label","正确");
        optionT.put("value","T");
        optionsList.add(optionT);
        Map<String, String> optionF = new HashMap<>();
        optionF.put("label","错误");
        optionF.put("value","F");
        optionsList.add(optionF);
        map.put("options",optionsList);

        return map;
    }
    /*
        通过answerId获取收藏填空题信息
    */
    public Map<String, Object> getFillByAnswerId(Integer answerId){
        Map<String, Object> map = new HashMap<>();

        StudentPaperAnswer studentPaperAnswer = studentPaperAnswerMapper.selectByPrimaryKey(answerId);
        map.put("stuAnswer",studentPaperAnswer.getStuAnswer());
        map.put("isCorrect",studentPaperAnswer.getIscorrect());
        map.put("isCollect",studentPaperAnswer.getIscollect());

        PaperQue paperQue = paperQueMapper.selectByPrimaryKey(studentPaperAnswer.getQueId());

        BankFillQue bankFillQue = bankFillQueMapper.selectByPrimaryKey(paperQue.getFillId());

        map.put("fillContent",bankFillQue.getFillContent());
        map.put("fillAnswer",bankFillQue.getFillAnswer());
        map.put("answerExplain",bankFillQue.getAnswerExplain());
        map.put("fillImgSrc",bankFillQue.getFillImgSrc());

        return map;
    }
}
