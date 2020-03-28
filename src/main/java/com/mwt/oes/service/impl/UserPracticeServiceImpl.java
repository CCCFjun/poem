package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.UserPracticeService;
import com.mwt.oes.util.FindContentWithImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserPracticeServiceImpl implements UserPracticeService {
    @Autowired
    BankSingleChoiceQueMapper bankSingleChoiceQueMapper;
    @Autowired
    BankJudgeQueMapper bankJudgeQueMapper;
    @Autowired
    BankFillQueMapper bankFillQueMapper;
    @Autowired
    QuestionTypeMapper questionTypeMapper;


    /*
            获取全部练习题型分类
         */
    @Override
    public List<QuestionType> getPracticeKind() {
        QuestionTypeExample example = new QuestionTypeExample();
        example.setOrderByClause("lang_id asc");
        List<QuestionType> result = questionTypeMapper.selectByExample(example);
        return result;
    }

    /*
        通过langId获取题型信息
     */
    @Override
    public QuestionType getKindInfoById(Integer kindId) {
        QuestionType questionType = questionTypeMapper.selectByPrimaryKey(kindId);
        return questionType;
    }

    @Override
    public List<Map<String, Object>> getRandomSingleList(Integer num, Integer kindId) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<BankSingleChoiceQue> bankSingleChoiceQueList = bankSingleChoiceQueMapper.getRandomSingleByCountAndLangId(num,kindId);
        for (BankSingleChoiceQue bankSingleChoiceQue : bankSingleChoiceQueList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", bankSingleChoiceQueList.indexOf(bankSingleChoiceQue) + 1);
            map.put("singleId", bankSingleChoiceQue.getSingleId());
            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            map.put("content", singleContentMap.get("content"));
            map.put("pictureSrc", singleContentMap.get("pictureSrc"));
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
            if(bankSingleChoiceQue.getChoiceC()!=null){
                optionC.put("label",bankSingleChoiceQue.getChoiceC());
                optionC.put("value","C");
                optionsList.add(optionC);
            }

            Map<String, String> optionD = new HashMap<>();
            if(bankSingleChoiceQue.getChoiceD()!=null){
                optionD.put("label",bankSingleChoiceQue.getChoiceD());
                optionD.put("value","D");
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
            map.put("options", optionsList);
            map.put("singleAnswer", bankSingleChoiceQue.getSingleAnswer());
            map.put("composeFlag", bankSingleChoiceQue.getComposeFlag());
            map.put("answerExplain", bankSingleChoiceQue.getAnswerExplain());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> getRandomJudgeList(Integer num) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<BankJudgeQue> bankJudgeQueList = bankJudgeQueMapper.getRandomJudgeByCountAndLangId(num,13);
        for (BankJudgeQue bankJudgeQue : bankJudgeQueList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", bankJudgeQueList.indexOf(bankJudgeQue) + 1);
            map.put("judgeId", bankJudgeQue.getJudgeId());
            map.put("content", bankJudgeQue.getJudgeContent());
//            if(bankJudgeQue.getJudgeAnswer() == "T"){
//                map.put("judgeAnswer", "正确");
//            }else{
//                map.put("judgeAnswer", "错误");
//            }
            map.put("judgeAnswer", bankJudgeQue.getJudgeAnswer());

            map.put("composeFlag", bankJudgeQue.getComposeFlag());
            map.put("answerExplain", bankJudgeQue.getAnswerExplain());
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
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> getRandomFillList(Integer num) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<BankFillQue> bankFillQueList = bankFillQueMapper.getRandomFillByCountAndLangId(num,10);
        for (BankFillQue bankFillQue : bankFillQueList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", bankFillQueList.indexOf(bankFillQue) + 1);
            map.put("fillId", bankFillQue.getFillId());
            map.put("content", bankFillQue.getFillContent());
            map.put("composeFlag", bankFillQue.getComposeFlag());
            map.put("fillAnswer", bankFillQue.getFillAnswer());
            map.put("answerExplain", bankFillQue.getAnswerExplain());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> getRandomFillTwoList(Integer num) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<BankFillQue> bankFillQueList = bankFillQueMapper.getRandomFillByCountAndLangId(num,11);
        for (BankFillQue bankFillQue : bankFillQueList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", bankFillQueList.indexOf(bankFillQue) + 1);
            map.put("fillId", bankFillQue.getFillId());
            map.put("content", bankFillQue.getFillContent());
            map.put("composeFlag", bankFillQue.getComposeFlag());
            map.put("fillAnswer", bankFillQue.getFillAnswer());
            map.put("answerExplain", bankFillQue.getAnswerExplain());
            map.put("fillImgSrc", bankFillQue.getFillImgSrc());
            resultList.add(map);
        }
        return resultList;
    }
}
