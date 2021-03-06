package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.AdminPaperService;
import com.mwt.oes.service.UserExamService;
import com.mwt.oes.util.FindContentWithImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminPaperServiceImpl implements AdminPaperService {

    @Autowired
    QuestionTypeMapper questionTypeMapper;
    @Autowired
    PaperMapper paperMapper;
    @Autowired
    UserExamService userExamService;
    @Autowired
    UserPaperScoreMapper userPaperScoreMapper;
    @Autowired
    PaperQueMapper paperQueMapper;
    @Autowired
    BankSingleChoiceQueMapper bankSingleChoiceQueMapper;
    @Autowired
    BankMultipleChoiceQueMapper bankMultipleChoiceQueMapper;
    @Autowired
    BankJudgeQueMapper bankJudgeQueMapper;
    @Autowired
    BankFillQueMapper bankFillQueMapper;

    @Override
    public List<Map<String, Object>> getPapersList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        PaperExample paperExample = new PaperExample();
        paperExample.setOrderByClause("paper_create_time desc");
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        for (Paper paper : paperList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", paperList.indexOf(paper) + 1);
            map.put("paperId", paper.getPaperId());
            map.put("paperName", paper.getPaperName());
            map.put("paperDuration", paper.getPaperDuration());
            map.put("paperDifficulty", paper.getPaperDifficulty());
            map.put("paperAttention", paper.getPaperAttention());
            map.put("paperType", paper.getPaperType());
            map.put("paperImgSrc", paper.getPaperImgSrc());

            Map<String, Integer> queNum = userExamService.getPaperQueNumByPaperId(paper.getPaperId());
            map.put("singleNum", queNum.get("singleNum"));
//            map.put("multipleNum", queNum.get("multipleNum"));
            map.put("judgeNum", queNum.get("judgeNum"));
            map.put("fillNum", queNum.get("fillNum"));
            map.put("totalNum", queNum.get("totalNum"));

            map.put("participateNum", paper.getParticipateNum());
            map.put("paperCreateTime", paper.getPaperCreateTime());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> getLangOptions() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        QuestionTypeExample questionTypeExample = new QuestionTypeExample();
        questionTypeExample.setOrderByClause("lang_id asc");
        List<QuestionType> questionTypeList = questionTypeMapper.selectByExample(questionTypeExample);
        for (QuestionType questionType : questionTypeList) {
            Map<String, Object> map = new HashMap<>();
            map.put("label", questionType.getLangName());
            map.put("key", questionType.getLangId());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> searchPapersList(String paperName, Integer paperType) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        PaperExample paperExample = new PaperExample();
        PaperExample.Criteria criteria = paperExample.createCriteria();
        if(!paperName.equals("undefined")) {
            criteria.andPaperNameLike("%" + paperName + "%");
        }
        if(paperType != 0){
            criteria.andPaperTypeEqualTo(paperType);
        }
        paperExample.setOrderByClause("paper_id asc");
        List<Paper> paperList = paperMapper.selectByExample(paperExample);
        for (Paper paper : paperList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", paperList.indexOf(paper) + 1);
            map.put("paperId", paper.getPaperId());
            map.put("paperName", paper.getPaperName());

            map.put("paperDuration", paper.getPaperDuration());
            map.put("paperDifficulty", paper.getPaperDifficulty());
            map.put("paperType", paper.getPaperType());
            map.put("paperAttention", paper.getPaperAttention());

            Map<String, Integer> queNum = userExamService.getPaperQueNumByPaperId(paper.getPaperId());
            map.put("singleNum", queNum.get("singleNum"));
//            map.put("multipleNum", queNum.get("multipleNum"));
            map.put("judgeNum", queNum.get("judgeNum"));
            map.put("fillNum", queNum.get("fillNum"));
            map.put("totalNum", queNum.get("totalNum"));

            map.put("participateNum", paper.getParticipateNum());
            map.put("paperCreateTime", paper.getPaperCreateTime());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int selectPaperScoreByPaperId(Integer paperId) {
        UserPaperScoreExample userPaperScoreExample = new UserPaperScoreExample();
        UserPaperScoreExample.Criteria criteria = userPaperScoreExample.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        List<UserPaperScore> resultList = userPaperScoreMapper.selectByExample(userPaperScoreExample);
        return resultList.size();
    }

    @Override
    public int deletePaper(Integer paperId) {
        //  删除paper_que表中数据
        PaperQueExample paperQueExample = new PaperQueExample();
        PaperQueExample.Criteria criteria = paperQueExample.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        int deletePaperQueResult = paperQueMapper.deleteByExample(paperQueExample);
        //  删除paper表中数据
        int deletePaperResult = paperMapper.deleteByPrimaryKey(paperId);
        return deletePaperResult;
    }

    @Override
    public Map<String, Object> getPaperQueDetailByPaperId(Integer paperId, Integer totalNum) {
        Map<String, Object> map = new HashMap<>();

        List<Map<String, Object>> singleOneData = new ArrayList<>();
        List<Map<String, Object>> judgeOneData = new ArrayList<>();
        List<Map<String, Object>> fillOneData = new ArrayList<>();
        List<Map<String, Object>> fillTwoData = new ArrayList<>();
//        System.out.println("1");

        // 获取百里挑一（单选题）问题列表
        List<BankSingleChoiceQue> singleChoiceQueList = bankSingleChoiceQueMapper.getSingleQueListByPaperIdAndLangId(paperId,12);
        System.out.println("1");
        for (BankSingleChoiceQue bankSingleChoiceQue : singleChoiceQueList) {
            int singleIndex = singleChoiceQueList.indexOf(bankSingleChoiceQue);
            Map<String, Object> singleMap = new HashMap<>();
            //问题id加上第一级题目类型数量
            singleMap.put("id",singleIndex + 5);

            //获取单选题题目内容
//            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            singleMap.put("label",(singleIndex + 1) + "、" + bankSingleChoiceQue.getSingleContent());

            //获取单选题答案内容和正确答案
            List<Map<String, Object>> singleAnswersList = new ArrayList<>();
            Map<String, Object> singleChoiceA = new HashMap<>();
            singleChoiceA.put("id",singleIndex*8 + totalNum + 5);
            singleChoiceA.put("label",bankSingleChoiceQue.getChoiceA());
            singleAnswersList.add(singleChoiceA);
            Map<String, Object> singleChoiceB = new HashMap<>();
            singleChoiceB.put("id",singleIndex*8 + 1 + totalNum + 5);
            singleChoiceB.put("label",bankSingleChoiceQue.getChoiceB());
            singleAnswersList.add(singleChoiceB);
            if (bankSingleChoiceQue.getChoiceC() != null) {
                Map<String, Object> singleChoiceC = new HashMap<>();
                singleChoiceC.put("id",singleIndex*8 + 2 + totalNum + 5);
                singleChoiceC.put("label",bankSingleChoiceQue.getChoiceC());
                singleAnswersList.add(singleChoiceC);
            }
            if (bankSingleChoiceQue.getChoiceD() != null) {
                Map<String, Object> singleChoiceD = new HashMap<>();
                singleChoiceD.put("id",singleIndex*8 + 3 + totalNum + 5);
                singleChoiceD.put("label",bankSingleChoiceQue.getChoiceD());
                singleAnswersList.add(singleChoiceD);
            }
            if (bankSingleChoiceQue.getChoiceE() != null) {
                Map<String, Object> singleChoiceE = new HashMap<>();
                singleChoiceE.put("id",singleIndex*8 + 4 + totalNum + 5);
                singleChoiceE.put("label",bankSingleChoiceQue.getChoiceE());
                singleAnswersList.add(singleChoiceE);
            }
            if (bankSingleChoiceQue.getChoiceF() != null) {
                Map<String, Object> singleChoiceF = new HashMap<>();
                singleChoiceF.put("id",singleIndex*8 + 5 + totalNum + 5);
                singleChoiceF.put("label",bankSingleChoiceQue.getChoiceF());
                singleAnswersList.add(singleChoiceF);
            }
            if (bankSingleChoiceQue.getChoiceG() != null) {
                Map<String, Object> singleChoiceG = new HashMap<>();
                singleChoiceG.put("id",singleIndex*8 + 6 + totalNum + 5);
                singleChoiceG.put("label",bankSingleChoiceQue.getChoiceG());
                singleAnswersList.add(singleChoiceG);
            }
            Map<String, Object> singleAnswer = new HashMap<>();
            singleAnswer.put("id",singleIndex*8 + 7 + totalNum + 5);
            singleAnswer.put("label","正确答案：" + bankSingleChoiceQue.getSingleAnswer());
            singleAnswersList.add(singleAnswer);

            singleMap.put("children",singleAnswersList);
            singleOneData.add(singleMap);
        }

        int singleNum = singleChoiceQueList.size();


        // 获取多选题问题列表
//        List<BankMultipleChoiceQue> multipleChoiceQueList = bankMultipleChoiceQueMapper.getMultipleQueListByPaperId(paperId);
//        for (BankMultipleChoiceQue bankMultipleChoiceQue : multipleChoiceQueList) {
//            int multipleIndex = multipleChoiceQueList.indexOf(bankMultipleChoiceQue);
//            Map<String, Object> multipleMap = new HashMap<>();
//            //问题id加上第一级题目类型数量加上单选题数量
//            multipleMap.put("id",multipleIndex + 5 + singleNum);
//
//            //获取多选题题目内容
//            Map<String, String> multipleContentMap = FindContentWithImage.findContentWithImage(bankMultipleChoiceQue.getMultipleContent());
//            multipleMap.put("label",(multipleIndex + 1 + singleNum) + "、" + multipleContentMap.get("content"));
//
//            //获取多选题答案内容和正确答案
//            List<Map<String, Object>> multipleAnswersList = new ArrayList<>();
//            Map<String, Object> multipleChoiceA = new HashMap<>();
//            multipleChoiceA.put("id",multipleIndex*8 + totalNum + 5 + singleNum*8);
//            multipleChoiceA.put("label",bankMultipleChoiceQue.getChoiceA());
//            multipleAnswersList.add(multipleChoiceA);
//            Map<String, Object> multipleChoiceB = new HashMap<>();
//            multipleChoiceB.put("id",multipleIndex*8 + 1 + totalNum + 5 + singleNum*8);
//            multipleChoiceB.put("label",bankMultipleChoiceQue.getChoiceB());
//            multipleAnswersList.add(multipleChoiceB);
//            if (bankMultipleChoiceQue.getChoiceC() != null){
//                Map<String, Object> multipleChoiceC = new HashMap<>();
//                multipleChoiceC.put("id",multipleIndex*8 + 2 + totalNum + 5 + singleNum*8);
//                multipleChoiceC.put("label",bankMultipleChoiceQue.getChoiceC());
//                multipleAnswersList.add(multipleChoiceC);
//            }
//            if (bankMultipleChoiceQue.getChoiceD() != null){
//                Map<String, Object> multipleChoiceD = new HashMap<>();
//                multipleChoiceD.put("id",multipleIndex*8 + 3 + totalNum + 5 + singleNum*8);
//                multipleChoiceD.put("label",bankMultipleChoiceQue.getChoiceD());
//                multipleAnswersList.add(multipleChoiceD);
//            }
//            if (bankMultipleChoiceQue.getChoiceE() != null){
//                Map<String, Object> multipleChoiceE = new HashMap<>();
//                multipleChoiceE.put("id",multipleIndex*8 + 4 + totalNum + 5 + singleNum*8);
//                multipleChoiceE.put("label",bankMultipleChoiceQue.getChoiceE());
//                multipleAnswersList.add(multipleChoiceE);
//            }
//            if (bankMultipleChoiceQue.getChoiceF() != null){
//                Map<String, Object> multipleChoiceF = new HashMap<>();
//                multipleChoiceF.put("id",multipleIndex*8 + 5 + totalNum + 5 + singleNum*8);
//                multipleChoiceF.put("label",bankMultipleChoiceQue.getChoiceF());
//                multipleAnswersList.add(multipleChoiceF);
//            }
//            if (bankMultipleChoiceQue.getChoiceG() != null){
//                Map<String, Object> multipleChoiceG = new HashMap<>();
//                multipleChoiceG.put("id",multipleIndex*8 + 6 + totalNum + 5 + singleNum*8);
//                multipleChoiceG.put("label",bankMultipleChoiceQue.getChoiceG());
//                multipleAnswersList.add(multipleChoiceG);
//            }
//
//            Map<String, Object> multipleAnswer = new HashMap<>();
//            multipleAnswer.put("id",multipleIndex*8 + 7 + totalNum + 5 + singleNum*8);
//            multipleAnswer.put("label","正确答案：" + bankMultipleChoiceQue.getMultipleAnswer());
//            multipleAnswersList.add(multipleAnswer);
//
//            multipleMap.put("children",multipleAnswersList);
//            multipleData.add(multipleMap);
//        }
//
//        int multipleNum = multipleChoiceQueList.size();

        // 获取分秒必争（判断题）问题列表
        List<BankJudgeQue> judgeQueList = bankJudgeQueMapper.getJudgeQueListByPaperIdAndLangId(paperId,13);
        for (BankJudgeQue bankJudgeQue : judgeQueList){
            int judgeIndex = judgeQueList.indexOf(bankJudgeQue);
            Map<String, Object> judgeMap = new HashMap<>();
            judgeMap.put("id",judgeIndex + 5 + singleNum);

            //获取判断题题目内容
            judgeMap.put("label",(judgeIndex + 1 + singleNum) + "、" + bankJudgeQue.getJudgeContent());

            //获取判断题正确答案
            List<Map<String, Object>> judgeAnswersList = new ArrayList<>();
            Map<String, Object> judgeAnswer = new HashMap<>();
            judgeAnswer.put("id",judgeIndex*1 + totalNum + 5 + singleNum*8);
            judgeAnswer.put("label","正确答案：" + bankJudgeQue.getJudgeAnswer());
            judgeAnswersList.add(judgeAnswer);

            judgeMap.put("children",judgeAnswersList);
            judgeOneData.add(judgeMap);
        }

        int judgeNum = judgeQueList.size();

        // 获取承上启下（填空题）问题列表
        List<BankFillQue> fillQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,10);
        for (BankFillQue bankFillQue : fillQueList){
            int fillIndex = fillQueList.indexOf(bankFillQue);
            Map<String, Object> fillMap = new HashMap<>();
            fillMap.put("id",fillIndex + 5 + singleNum + judgeNum);

            //获取填空题题目内容
            fillMap.put("label",(fillIndex + 1 + singleNum + judgeNum) + "、" + bankFillQue.getFillContent());

            //获取填空题正确答案
            List<Map<String, Object>> fillAnswersList = new ArrayList<>();
            Map<String, Object> fillAnswer = new HashMap<>();
            fillAnswer.put("id",fillIndex*1 + totalNum + 5 + singleNum*8 + judgeNum*1);
            fillAnswer.put("label","正确答案：" + bankFillQue.getFillAnswer());
            fillAnswersList.add(fillAnswer);

            fillMap.put("children",fillAnswersList);
            fillOneData.add(fillMap);
        }

        int fillOneNum = fillQueList.size();

        // 获取画中有话（填空题）问题列表
        List<BankFillQue> fillTwoQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,11);
        for (BankFillQue bankFillQue : fillTwoQueList){
            int fillIndex = fillTwoQueList.indexOf(bankFillQue);
            Map<String, Object> fillMap = new HashMap<>();
            fillMap.put("id",fillIndex + 5 + singleNum + fillOneNum + judgeNum);

            //获取填空题题目内容
            fillMap.put("label",(fillIndex + 1 + singleNum + fillOneNum + judgeNum) + "、" + bankFillQue.getFillImgSrc());

            //获取填空题正确答案
            List<Map<String, Object>> fillAnswersList = new ArrayList<>();
            Map<String, Object> fillAnswer = new HashMap<>();
            fillAnswer.put("id",fillIndex*1 + totalNum + 5 + singleNum*8 + fillOneNum*1 + judgeNum*1);
            fillAnswer.put("label","正确答案：" + bankFillQue.getFillAnswer());
            fillAnswersList.add(fillAnswer);

            fillMap.put("children",fillAnswersList);
            fillTwoData.add(fillMap);
        }

        map.put("singleOneData",singleOneData);
        map.put("judgeOneData",judgeOneData);
        map.put("fillOneData",fillOneData);
        map.put("fillTwoData",fillTwoData);
        return map;
    }

    @Override
    public int randomInsertPaperInfo(Map<String, Object> obj) {
        String paperName = (String) obj.get("paperName");
        Integer paperDuration = (Integer) obj.get("paperDuration");
        Integer paperDifficulty = (Integer) obj.get("paperDifficulty");
        String paperAttention = (String) obj.get("paperAttention");
        String paperImgSrc = (String) obj.get("paperImgSrc");
        Integer singleNum = (Integer) obj.get("singleNum");
        Integer judgeNum = (Integer) obj.get("judgeNum");
        Integer fillNum = (Integer) obj.get("fillNum");
        Integer fillTwoNum = (Integer) obj.get("fillTwoNum");
        Paper paper = new Paper();
        paper.setPaperName(paperName);
        paper.setPaperDuration(paperDuration);
        paper.setPaperDifficulty(paperDifficulty);
        paper.setPaperAttention(paperAttention);
        paper.setPaperCreateTime(new Date());
        paper.setPaperImgSrc(paperImgSrc);
        paper.setPaperType(1);
        int paperId = paperMapper.selectMaxPaperId() + 1;
        paper.setPaperId(paperId);

        //  插入试卷信息到paper表
        int result = paperMapper.insertSelective(paper);

        //  插入试卷问题信息到paper_que表
        //  单选题百里挑一
        List<BankSingleChoiceQue> bankSingleChoiceQueList = bankSingleChoiceQueMapper.getRandomSingleByCountAndLangId(singleNum,12);
        for (BankSingleChoiceQue bankSingleChoiceQue : bankSingleChoiceQueList) {
            int singleId = bankSingleChoiceQue.getSingleId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(1);
            paperQue.setSingleId(singleId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            bankSingleChoiceQue.setComposeFlag("1");
            bankSingleChoiceQueMapper.updateByPrimaryKeySelective(bankSingleChoiceQue);
        }

        //  多选题
//        List<BankMultipleChoiceQue> bankMultipleChoiceQueList = bankMultipleChoiceQueMapper.getRandomMultipleByCountAndLangId(langId, multipleNum);
//        for (BankMultipleChoiceQue bankMultipleChoiceQue : bankMultipleChoiceQueList) {
//            int multipleId = bankMultipleChoiceQue.getMultipleId();
//            PaperQue paperQue = new PaperQue();
//            paperQue.setQueType(2);
//            paperQue.setMultipleId(multipleId);
//            paperQue.setPaperId(paperId);
//            paperQueMapper.insertSelective(paperQue);
//            //更新compose_flag字段
//            bankMultipleChoiceQue.setComposeFlag("1");
//            bankMultipleChoiceQueMapper.updateByPrimaryKeySelective(bankMultipleChoiceQue);
//        }

        //  判断题分秒必争
        List<BankJudgeQue> bankJudgeQueList = bankJudgeQueMapper.getRandomJudgeByCountAndLangId(judgeNum,13);
        for (BankJudgeQue bankJudgeQue : bankJudgeQueList) {
            int judgeId = bankJudgeQue.getJudgeId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(2);
            paperQue.setJudgeId(judgeId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            bankJudgeQue.setComposeFlag("1");
            bankJudgeQueMapper.updateByPrimaryKeySelective(bankJudgeQue);
        }

        //  填空题承上启下
        List<BankFillQue> bankFillQueList = bankFillQueMapper.getRandomFillByCountAndLangId(fillNum,10);
        for (BankFillQue bankFillQue : bankFillQueList) {
            int fillId = bankFillQue.getFillId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(3);
            paperQue.setFillId(fillId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            bankFillQue.setComposeFlag("1");
            bankFillQueMapper.updateByPrimaryKeySelective(bankFillQue);
        }
        //  填空题画中有话
        List<BankFillQue> bankFillTwoQueList = bankFillQueMapper.getRandomFillByCountAndLangId(fillTwoNum,11);
        for (BankFillQue bankFillQue : bankFillTwoQueList) {
            int fillId = bankFillQue.getFillId();
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(4);
            paperQue.setFillId(fillId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            bankFillQue.setComposeFlag("1");
            bankFillQueMapper.updateByPrimaryKeySelective(bankFillQue);
        }

        return result;
    }

    @Override
    public Map<String, Object> getPaperQueDetailByLangId() {
        Map<String, Object> map = new HashMap<>();

        List<Map<String, Object>> singleData = new ArrayList<>();
//        List<Map<String, Object>> multipleData = new ArrayList<>();
        List<Map<String, Object>> judgeData = new ArrayList<>();
        List<Map<String, Object>> fillData = new ArrayList<>();
        List<Map<String, Object>> fillTwoData = new ArrayList<>();

//        百里挑一（单选题）
        BankSingleChoiceQueExample bankSingleChoiceQueExample = new BankSingleChoiceQueExample();
        BankSingleChoiceQueExample.Criteria criteriaSingle = bankSingleChoiceQueExample.createCriteria();
        criteriaSingle.andLangIdEqualTo(12);
        List<BankSingleChoiceQue> bankSingleChoiceQueList = bankSingleChoiceQueMapper.selectByExample(bankSingleChoiceQueExample);
        for (BankSingleChoiceQue bankSingleChoiceQue : bankSingleChoiceQueList) {
            int singleId = bankSingleChoiceQue.getSingleId();
            Map<String, Object> singleMap = new HashMap<>();
            // 在每个singleId前加上1连接
            int id = (int) (Math.pow(10,String.valueOf(singleId).length()) + singleId);
            singleMap.put("id",id);
            //获取单选题题目内容
            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            String composeFlag = bankSingleChoiceQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "（已组过）" : "（未组过）";
            singleMap.put("label",composeStr + (bankSingleChoiceQueList.indexOf(bankSingleChoiceQue) + 1) + "、" + singleContentMap.get("content"));

            singleData.add(singleMap);
        }

//        BankMultipleChoiceQueExample bankMultipleChoiceQueExample = new BankMultipleChoiceQueExample();
//        BankMultipleChoiceQueExample.Criteria criteriaMultiple = bankMultipleChoiceQueExample.createCriteria();
//        criteriaMultiple.andLangIdEqualTo(langId);
//        List<BankMultipleChoiceQue> bankMultipleChoiceQueList = bankMultipleChoiceQueMapper.selectByExample(bankMultipleChoiceQueExample);
//        for (BankMultipleChoiceQue bankMultipleChoiceQue : bankMultipleChoiceQueList) {
//            int multipleId = bankMultipleChoiceQue.getMultipleId();
//            Map<String, Object> multipleMap = new HashMap<>();
//            // 在每个multipleId前加上2连接
//            int id = (int) (Math.pow(10,String.valueOf(multipleId).length())*2 + multipleId);
//            multipleMap.put("id",id);
//            //获取多选题题目内容
//            Map<String, String> multipleContentMap = FindContentWithImage.findContentWithImage(bankMultipleChoiceQue.getMultipleContent());
//            String composeFlag = bankMultipleChoiceQue.getComposeFlag();
//            String composeStr = composeFlag.equals("1") ? "（已组过）" : "（未组过）";
//            multipleMap.put("label",composeStr + (bankMultipleChoiceQueList.indexOf(bankMultipleChoiceQue) + 1) + "、" + multipleContentMap.get("content"));
//
//            multipleData.add(multipleMap);
//        }

//        分秒必争（判断题）
        BankJudgeQueExample bankJudgeQueExample = new BankJudgeQueExample();
        BankJudgeQueExample.Criteria criteriaJudge = bankJudgeQueExample.createCriteria();
        criteriaJudge.andLangIdEqualTo(13);
        List<BankJudgeQue> bankJudgeQueList = bankJudgeQueMapper.selectByExample(bankJudgeQueExample);
        for (BankJudgeQue bankJudgeQue : bankJudgeQueList) {
            int judgeId = bankJudgeQue.getJudgeId();
            Map<String, Object> judgeMap = new HashMap<>();
            // 在每个judgeId前加上2连接
            int id = (int) (Math.pow(10,String.valueOf(judgeId).length())*2 + judgeId);
            judgeMap.put("id",id);
//            System.out.println(judgeId + "---" + id);
            //获取判断题题目内容
            String composeFlag = bankJudgeQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "（已组过）" : "（未组过）";
            judgeMap.put("label",composeStr + (bankJudgeQueList.indexOf(bankJudgeQue) + 1) + "、" + bankJudgeQue.getJudgeContent());

            judgeData.add(judgeMap);
        }

//      承上启下（填空题）
        BankFillQueExample bankFillQueExample = new BankFillQueExample();
        BankFillQueExample.Criteria criteriaFill = bankFillQueExample.createCriteria();
        criteriaFill.andLangIdEqualTo(10);
        List<BankFillQue> bankFillQueList = bankFillQueMapper.selectByExample(bankFillQueExample);
        for (BankFillQue bankFillQue : bankFillQueList) {
            int fillId = bankFillQue.getFillId();
            Map<String, Object> fillMap = new HashMap<>();
            // 在每个fillId前加上3连接
            int id = (int) (Math.pow(10,String.valueOf(fillId).length())*3 + fillId);
            fillMap.put("id",id);
            //获取填空题题目内容
            String composeFlag = bankFillQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "（已组过）" : "（未组过）";
            fillMap.put("label",composeStr + (bankFillQueList.indexOf(bankFillQue) + 1) + "、" + bankFillQue.getFillContent());

            fillData.add(fillMap);
        }

//      画中有话（填空题）
        BankFillQueExample bankFillTwoQueExample = new BankFillQueExample();
        BankFillQueExample.Criteria criteriaFillTwo = bankFillTwoQueExample.createCriteria();
        criteriaFillTwo.andLangIdEqualTo(11);
        List<BankFillQue> bankFillTwoQueList = bankFillQueMapper.selectByExample(bankFillTwoQueExample);
        for (BankFillQue bankFillQue : bankFillTwoQueList) {
            int fillId = bankFillQue.getFillId();
            Map<String, Object> fillMap = new HashMap<>();
            // 在每个fillId前加上3连接
            int id = (int) (Math.pow(10,String.valueOf(fillId).length())*4 + fillId);
            fillMap.put("id",id);
            //获取填空题题目内容
            String composeFlag = bankFillQue.getComposeFlag();
            String composeStr = composeFlag.equals("1") ? "（已组过）" : "（未组过）";
            fillMap.put("label",composeStr + (bankFillTwoQueList.indexOf(bankFillQue) + 1) + "、" + bankFillQue.getFillImgSrc());

            fillTwoData.add(fillMap);
        }

        map.put("singleData",singleData);
//        map.put("multipleData",multipleData);
        map.put("judgeData",judgeData);
        map.put("fillData",fillData);
        map.put("fillTwoData",fillTwoData);
        return map;
    }

    @Override
    public int fixedInsertPaperInfo(Map<String, Object> obj) {
        String paperName = (String) obj.get("paperName");
        Integer paperDuration = (Integer) obj.get("paperDuration");
        Integer paperDifficulty = (Integer) obj.get("paperDifficulty");
        String paperAttention = (String) obj.get("paperAttention");
        String paperImgSrc = (String) obj.get("paperImgSrc");
        List<Integer> singleNum = (List<Integer>) obj.get("singleNum");
        List<Integer> judgeNum = (List<Integer>) obj.get("judgeNum");
        List<Integer> fillNum = (List<Integer>) obj.get("fillNum");
        List<Integer> fillTwoNum = (List<Integer>) obj.get("fillTwoNum");
        Paper paper = new Paper();
        paper.setPaperName(paperName);
        paper.setPaperDuration(paperDuration);
        paper.setPaperDifficulty(paperDifficulty);
        paper.setPaperAttention(paperAttention);
        paper.setPaperCreateTime(new Date());
        paper.setPaperImgSrc(paperImgSrc);
        paper.setPaperType(2);
        int paperId = paperMapper.selectMaxPaperId() + 1;
        paper.setPaperId(paperId);
        //  插入试卷信息到paper表
        int result = paperMapper.insertSelective(paper);
        //单选题百里挑一
        for (Integer singleId : singleNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(1);
            paperQue.setSingleId(singleId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            BankSingleChoiceQue bankSingleChoiceQue = new BankSingleChoiceQue();
            bankSingleChoiceQue.setSingleId(singleId);
            bankSingleChoiceQue.setComposeFlag("1");
            bankSingleChoiceQueMapper.updateByPrimaryKeySelective(bankSingleChoiceQue);
        }
        //多选题
//        for (Integer multipleId : multipleNum) {
//            PaperQue paperQue = new PaperQue();
//            paperQue.setQueType(2);
//            paperQue.setMultipleId(multipleId);
//            paperQue.setPaperId(paperId);
//            paperQueMapper.insertSelective(paperQue);
//            //更新compose_flag字段
//            BankMultipleChoiceQue bankMultipleChoiceQue = new BankMultipleChoiceQue();
//            bankMultipleChoiceQue.setMultipleId(multipleId);
//            bankMultipleChoiceQue.setComposeFlag("1");
//            bankMultipleChoiceQueMapper.updateByPrimaryKeySelective(bankMultipleChoiceQue);
//        }
        //判断题分秒必争
        for (Integer judgeId : judgeNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(2);
            paperQue.setJudgeId(judgeId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            BankJudgeQue bankJudgeQue = new BankJudgeQue();
            bankJudgeQue.setJudgeId(judgeId);
            bankJudgeQue.setComposeFlag("1");
            bankJudgeQueMapper.updateByPrimaryKeySelective(bankJudgeQue);
        }
        //填空题承上启下
        for (Integer fillId : fillNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(3);
            paperQue.setFillId(fillId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            BankFillQue bankFillQue = new BankFillQue();
            bankFillQue.setFillId(fillId);
            bankFillQue.setComposeFlag("1");
            bankFillQueMapper.updateByPrimaryKeySelective(bankFillQue);
        }
        //填空题画中有话
        for (Integer fillId : fillTwoNum) {
            PaperQue paperQue = new PaperQue();
            paperQue.setQueType(4);
            paperQue.setFillId(fillId);
            paperQue.setPaperId(paperId);
            paperQueMapper.insertSelective(paperQue);
            //更新compose_flag字段
            BankFillQue bankFillQue = new BankFillQue();
            bankFillQue.setFillId(fillId);
            bankFillQue.setComposeFlag("1");
            bankFillQueMapper.updateByPrimaryKeySelective(bankFillQue);
        }
        return result;
    }
}
