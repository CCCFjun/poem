package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.UserExamService;
import com.mwt.oes.util.FindContentWithImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserExamServiceImpl implements UserExamService {

    @Autowired
    PaperMapper paperMapper;
    @Autowired
    PaperQueMapper paperQueMapper;
    @Autowired
    BankSingleChoiceQueMapper bankSingleChoiceQueMapper;
    @Autowired
    BankJudgeQueMapper bankJudgeQueMapper;
    @Autowired
    BankFillQueMapper bankFillQueMapper;
    @Autowired
    UserPaperScoreMapper userPaperScoreMapper;
    @Autowired
    UserPaperAnswerMapper userPaperAnswerMapper;
    @Autowired
    UserMapper userMapper;

    /*
        通过paperId获取试卷信息
     */
    @Override
    public Paper getPapersInfoByPaperId(Integer paperId) {
        Paper paper = paperMapper.selectByPrimaryKey(paperId);
        return paper;
    }

    /*
        通过paperId获取试卷各问题数量
     */
    @Override
    public Map<String, Integer> getPaperQueNumByPaperId(Integer paperId) {
        PaperQueExample example = new PaperQueExample();
        PaperQueExample.Criteria criteria = example.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        int totalNum = paperQueMapper.countByExample(example);
        criteria.andQueTypeEqualTo(1);
        int singleNum = paperQueMapper.countByExample(example);

        PaperQueExample example1Judge = new PaperQueExample();
        PaperQueExample.Criteria criteriaJudge = example1Judge.createCriteria();
        criteriaJudge.andPaperIdEqualTo(paperId);
        criteriaJudge.andQueTypeEqualTo(2);
        int judgeNum = paperQueMapper.countByExample(example1Judge);

        PaperQueExample example1Fill = new PaperQueExample();
        PaperQueExample.Criteria criteriaFill = example1Fill.createCriteria();
        criteriaFill.andPaperIdEqualTo(paperId);
        criteriaFill.andQueTypeEqualTo(3);
        int fillNum = paperQueMapper.countByExample(example1Fill);

        PaperQueExample example2Fill = new PaperQueExample();
        PaperQueExample.Criteria criteria2Fill = example2Fill.createCriteria();
        criteria2Fill.andPaperIdEqualTo(paperId);
        criteria2Fill.andQueTypeEqualTo(4);
        int fillTwoNum = paperQueMapper.countByExample(example2Fill);

        Map<String, Integer> result = new HashMap<>();
        result.put("totalNum",totalNum);
        result.put("singleNum",singleNum);
        result.put("judgeNum",judgeNum);
        result.put("fillNum",fillNum);
        result.put("fillTwoNum",fillTwoNum);

        return result;
    }

    /*
        获取试卷单选题一列表,题目，选项
     */
    @Override
    public List<Map<String, Object>> getSingleQueListByPaperId(Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankSingleChoiceQue> singleChoiceQueList = bankSingleChoiceQueMapper.getSingleQueListByPaperId(paperId);
        for (BankSingleChoiceQue bankSingleChoiceQue : singleChoiceQueList){
            Map<String, Object> map = new HashMap<>();

            map.put("singleId",bankSingleChoiceQue.getSingleId());

            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            map.put("singleContent",singleContentMap.get("content"));
            map.put("pictureSrc",singleContentMap.get("pictureSrc"));

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
            listResult.add(map);
        }

        return listResult;
    }

    /*
        获取试卷判断题列表信息
     */
    @Override
    public List<Map<String, Object>> getJudgeQueListByPaperId(Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankJudgeQue> judgeQueList = bankJudgeQueMapper.getJudgeQueListByPaperId(paperId);
        for (BankJudgeQue bankJudgeQue : judgeQueList){
            Map<String, Object> map = new HashMap<>();

            map.put("judgeId",bankJudgeQue.getJudgeId());

            map.put("judgeContent",bankJudgeQue.getJudgeContent());

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

            listResult.add(map);
        }

        return listResult;
    }

    /*
        获取试卷填空题一承上启下列表信息
     */
    @Override
    public List<Map<String, Object>> getFillQueListByPaperId(Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankFillQue> fillQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,10);
        for (BankFillQue bankFillQue : fillQueList){
            Map<String, Object> map = new HashMap<>();

            map.put("fillId",bankFillQue.getFillId());

            map.put("fillContent",bankFillQue.getFillContent());

            listResult.add(map);
        }

        return listResult;
    }

    /*
        获取试卷填空题二画中有话列表信息
     */
    @Override
    public List<Map<String, Object>> getFillTwoQueListByPaperId(Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankFillQue> fillTwoQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,11);
        for (BankFillQue bankFillTwoQue : fillTwoQueList){
            Map<String, Object> map = new HashMap<>();

            map.put("fillId",bankFillTwoQue.getFillId());

            map.put("fillContent",bankFillTwoQue.getFillContent());

            map.put("fillImgSrc",bankFillTwoQue.getFillImgSrc());

            listResult.add(map);
        }

        return listResult;
    }

    /*
        请求获取当前试卷状态，即是否已完成
    */
    public List<UserPaperScore> getCurrentPaperStatus(String userPhone, Integer paperId){
        UserPaperScoreExample userPaperScoreExample = new UserPaperScoreExample();
        UserPaperScoreExample.Criteria criteria = userPaperScoreExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        criteria.andPaperIdEqualTo(paperId);
        List<UserPaperScore> listResult = userPaperScoreMapper.selectByExample(userPaperScoreExample);
        return listResult;
    }

    /*
        初始化插入用户成绩表数据，包括考试开始时间、手机号和试卷id
     */
    @Override
    public int insertStudentPaperScore(UserPaperScore userPaperScore) {
        int result = userPaperScoreMapper.insertSelective(userPaperScore);
        // 更新paper表已参加人数
        Paper paper = paperMapper.selectByPrimaryKey(userPaperScore.getPaperId());
        int participateNum = paper.getParticipateNum() + 1;
        paper.setParticipateNum(participateNum);
        paperMapper.updateByPrimaryKeySelective(paper);
        return result;
    }

    /*
        插入学生成绩表成绩信息和学生试卷答题记录信息
     */
    @Override
    public int insertPaperAnswerAndPaperScore(String userPhone, Integer paperId, List<String> singleAnswers,
                                              List<String> judgeAnswers,
                                              List<String> fillAnswers,List<String> fillTwoAnswers, int timeUsed){

        //每题都是1分，分数即答对题数
        //设置初始分数为0
        int score = 0;
        //计算判断题分数
        List<BankJudgeQue> judgeQueList = bankJudgeQueMapper.getJudgeQueListByPaperIdAndLangId(paperId,13);
        for (int i = 0;i < judgeQueList.size();i++){
            String isCorrect = "0";
            if(judgeQueList.get(i).getJudgeAnswer().equals(judgeAnswers.get(i))){
                score++;
                isCorrect = "1";
            }
            UserPaperAnswer userPaperAnswer = new UserPaperAnswer();
            userPaperAnswer.setStuAnswer(judgeAnswers.get(i));
            userPaperAnswer.setIscorrect(isCorrect);
            userPaperAnswer.setQueId(judgeQueList.get(i).getPaperQue().getQueId());
            userPaperAnswer.setPaperId(paperId);
            userPaperAnswer.setUserPhone(userPhone);
            int insertResult = userPaperAnswerMapper.insertSelective(userPaperAnswer);
        }
        //计算单选题yi分数
        List<BankSingleChoiceQue> singleChoiceQueList = bankSingleChoiceQueMapper.getSingleQueListByPaperIdAndLangId(paperId,12);
        for (int i = 0;i < singleChoiceQueList.size();i++){
            String isCorrect = "0";
            if(singleChoiceQueList.get(i).getSingleAnswer().equals(singleAnswers.get(i))){
                score++;
                isCorrect = "1";
            }
            UserPaperAnswer userPaperAnswer = new UserPaperAnswer();
            userPaperAnswer.setStuAnswer(singleAnswers.get(i));
            userPaperAnswer.setIscorrect(isCorrect);
            userPaperAnswer.setQueId(singleChoiceQueList.get(i).getPaperQue().getQueId());
            userPaperAnswer.setPaperId(paperId);
            userPaperAnswer.setUserPhone(userPhone);
            int insertResult = userPaperAnswerMapper.insertSelective(userPaperAnswer);
        }



        //计算填空题分数
        List<BankFillQue> fillQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,10);
        for (int i = 0;i < fillQueList.size();i++){
            String isCorrect = "0";
            if(fillAnswers.get(i) != null){
                if(fillQueList.get(i).getFillAnswer().equalsIgnoreCase(fillAnswers.get(i).trim())){
                    score++;
                    isCorrect = "1";
                }
            }
            UserPaperAnswer userPaperAnswer = new UserPaperAnswer();
            userPaperAnswer.setStuAnswer(fillAnswers.get(i));
            userPaperAnswer.setIscorrect(isCorrect);
            userPaperAnswer.setQueId(fillQueList.get(i).getPaperQue().getQueId());
            userPaperAnswer.setPaperId(paperId);
            userPaperAnswer.setUserPhone(userPhone);
            int insertResult = userPaperAnswerMapper.insertSelective(userPaperAnswer);
        }

        //计算填空题er分数
        List<BankFillQue> fillTwoQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,11);
        for (int i = 0;i < fillTwoQueList.size();i++){
            String isCorrect = "0";
            if(fillTwoAnswers.get(i) != null){
                if(fillTwoQueList.get(i).getFillAnswer().equalsIgnoreCase(fillTwoAnswers.get(i).trim())){
                    score++;
                    isCorrect = "1";
                }
            }
            UserPaperAnswer userPaperAnswer = new UserPaperAnswer();
            userPaperAnswer.setStuAnswer(fillTwoAnswers.get(i));
            userPaperAnswer.setIscorrect(isCorrect);
            userPaperAnswer.setQueId(fillTwoQueList.get(i).getPaperQue().getQueId());
            userPaperAnswer.setPaperId(paperId);
            userPaperAnswer.setUserPhone(userPhone);
            int insertResult = userPaperAnswerMapper.insertSelective(userPaperAnswer);
        }

        //更新用户成绩表数据
        UserPaperScoreExample userPaperScoreExample = new UserPaperScoreExample();
        UserPaperScoreExample.Criteria criteria = userPaperScoreExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        criteria.andPaperIdEqualTo(paperId);
        UserPaperScore userPaperScore = new UserPaperScore();
        userPaperScore.setScore(score);
        userPaperScore.setTimeUsed(timeUsed);
        userPaperScore.setEndTime(new Date());
        int updateResult = userPaperScoreMapper.updateByExampleSelective(userPaperScore, userPaperScoreExample);
        return updateResult;
    }

    /*
        获取试卷单选题yi列表,题目，正确答案，我的答案
    */
    @Override
    public List<Map<String, Object>> getSingleQueListByJoinedPaperId(String userPhone, Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankSingleChoiceQue> singleChoiceQueList = bankSingleChoiceQueMapper.getSingleQueListByPaperIdAndLangId(paperId,12);

        for (BankSingleChoiceQue bankSingleChoiceQue : singleChoiceQueList){
            Map<String, Object> map = new HashMap<>();

            //获取单选题id
            map.put("singleId",bankSingleChoiceQue.getSingleId());

            //通过singleId获取paperQue对象
            PaperQueExample paperQueExample = new PaperQueExample();
            PaperQueExample.Criteria criteria = paperQueExample.createCriteria();
            criteria.andSingleIdEqualTo(bankSingleChoiceQue.getSingleId()).andPaperIdEqualTo(paperId);
            List<PaperQue> paperQueList = paperQueMapper.selectByExample(paperQueExample);
            PaperQue paperQue = paperQueList.get(0);
            map.put("queType",paperQue.getQueType());
            Integer queId = paperQue.getQueId();

            //通过queId获取试卷答案信息
            UserPaperAnswerExample userPaperAnswerExample = new UserPaperAnswerExample();
            UserPaperAnswerExample.Criteria criteria1 = userPaperAnswerExample.createCriteria();
            criteria1.andQueIdEqualTo(queId);
            criteria1.andUserPhoneEqualTo(userPhone);
            List<UserPaperAnswer> userPaperAnswerList = userPaperAnswerMapper.selectByExample(userPaperAnswerExample);

            UserPaperAnswer userPaperAnswer = userPaperAnswerList.get(0);
            map.put("answerId", userPaperAnswer.getAnswerId());
            map.put("stuAnswer", userPaperAnswer.getStuAnswer());
            map.put("isCollect", userPaperAnswer.getIscollect());
            map.put("isCorrect", userPaperAnswer.getIscorrect());


            //获取单选题题目内容
//            Map<String, String> singleContentMap = FindContentWithImage.findContentWithImage(bankSingleChoiceQue.getSingleContent());
            map.put("singleContent",bankSingleChoiceQue.getSingleContent());

            //获取单选题答案
            map.put("singleAnswer",bankSingleChoiceQue.getSingleAnswer());
            map.put("explain",bankSingleChoiceQue.getAnswerExplain());

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
            if(bankSingleChoiceQue.getChoiceC()!=null){
                Map<String, String> optionC = new HashMap<>();
                optionC.put("label",bankSingleChoiceQue.getChoiceC());
                optionC.put("value","C");
                optionsList.add(optionC);
            }
            if(bankSingleChoiceQue.getChoiceD()!=null) {
                Map<String, String> optionD = new HashMap<>();
                optionD.put("label", bankSingleChoiceQue.getChoiceD());
                optionD.put("value", "D");
                optionsList.add(optionD);
            }
            if(bankSingleChoiceQue.getChoiceE()!=null) {
                Map<String, String> optionE = new HashMap<>();
                optionE.put("label", bankSingleChoiceQue.getChoiceE());
                optionE.put("value", "E");
                optionsList.add(optionE);
            }
            if(bankSingleChoiceQue.getChoiceF()!=null) {
                Map<String, String> optionF = new HashMap<>();
                optionF.put("label", bankSingleChoiceQue.getChoiceF());
                optionF.put("value", "F");
                optionsList.add(optionF);
            }
            if(bankSingleChoiceQue.getChoiceG()!=null) {
                Map<String, String> optionG = new HashMap<>();
                optionG.put("label", bankSingleChoiceQue.getChoiceG());
                optionG.put("value", "G");
                optionsList.add(optionG);
            }
            map.put("options", optionsList);
            listResult.add(map);
        }

        return listResult;
    }

    /*
        获取试卷判断题列表信息
     */
    @Override
    public List<Map<String, Object>> getJudgeQueListByJoinedPaperId(String userPhone, Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankJudgeQue> judgeQueList = bankJudgeQueMapper.getJudgeQueListByPaperIdAndLangId(paperId,13);
        for (BankJudgeQue bankJudgeQue : judgeQueList){
            Map<String, Object> map = new HashMap<>();

            map.put("judgeId",bankJudgeQue.getJudgeId());
            //通过judgeId获取paperQue对象
            PaperQueExample paperQueExample = new PaperQueExample();
            PaperQueExample.Criteria criteria = paperQueExample.createCriteria();
            criteria.andJudgeIdEqualTo(bankJudgeQue.getJudgeId()).andPaperIdEqualTo(paperId);
            List<PaperQue> paperQueList = paperQueMapper.selectByExample(paperQueExample);
            PaperQue paperQue = paperQueList.get(0);
            map.put("queType",paperQue.getQueType());
            Integer queId = paperQue.getQueId();

            //通过queId获取试卷答案信息
            UserPaperAnswerExample userPaperAnswerExample = new UserPaperAnswerExample();
            UserPaperAnswerExample.Criteria criteria1 = userPaperAnswerExample.createCriteria();
            criteria1.andQueIdEqualTo(queId).andUserPhoneEqualTo(userPhone);
            List<UserPaperAnswer> userPaperAnswerList = userPaperAnswerMapper.selectByExample(userPaperAnswerExample);
            UserPaperAnswer userPaperAnswer = userPaperAnswerList.get(0);
            map.put("answerId", userPaperAnswer.getAnswerId());
            map.put("stuAnswer", userPaperAnswer.getStuAnswer());
            map.put("isCollect", userPaperAnswer.getIscollect());
            map.put("isCorrect", userPaperAnswer.getIscorrect());

            map.put("judgeContent",bankJudgeQue.getJudgeContent());
            map.put("judgeAnswer",bankJudgeQue.getJudgeAnswer());
            map.put("explain",bankJudgeQue.getAnswerExplain());

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

            listResult.add(map);
        }

        return listResult;
    }

    /*
        获取试卷填空题列表信息
     */
    @Override
    public List<Map<String, Object>> getFillQueListByJoinedPaperId(String userPhone, Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();
        List<BankFillQue> fillQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,10);
        for (BankFillQue bankFillQue : fillQueList){
            Map<String, Object> map = new HashMap<>();
            map.put("fillId",bankFillQue.getFillId());
            PaperQueExample paperQueExample = new PaperQueExample();
            PaperQueExample.Criteria criteria = paperQueExample.createCriteria();
            criteria.andFillIdEqualTo(bankFillQue.getFillId()).andPaperIdEqualTo(paperId);
            List<PaperQue> paperQueList = paperQueMapper.selectByExample(paperQueExample);
            PaperQue paperQue = paperQueList.get(0);
            map.put("queType",paperQue.getQueType());
            Integer queId = paperQue.getQueId();
            UserPaperAnswerExample userPaperAnswerExample = new UserPaperAnswerExample();
            UserPaperAnswerExample.Criteria criteria1 = userPaperAnswerExample.createCriteria();
            criteria1.andQueIdEqualTo(queId);
            criteria1.andUserPhoneEqualTo(userPhone);
            List<UserPaperAnswer> userPaperAnswerList = userPaperAnswerMapper.selectByExample(userPaperAnswerExample);
            UserPaperAnswer userPaperAnswer = userPaperAnswerList.get(0);
            map.put("answerId", userPaperAnswer.getAnswerId());
            map.put("stuAnswer", userPaperAnswer.getStuAnswer());
            map.put("isCollect", userPaperAnswer.getIscollect());
            map.put("isCorrect", userPaperAnswer.getIscorrect());
            map.put("fillContent",bankFillQue.getFillContent());
            map.put("fillAnswer",bankFillQue.getFillAnswer());
            map.put("explain",bankFillQue.getAnswerExplain());
            listResult.add(map);
        }
        return listResult;
    }

    /*
        获取试卷填空题er列表信息
     */
    @Override
    public List<Map<String, Object>> getFillTwoQueListByJoinedPaperId(String userPhone, Integer paperId) {
        List<Map<String, Object>> listResult = new ArrayList<>();

        List<BankFillQue> fillTwoQueList = bankFillQueMapper.getFillQueListByPaperIdAndLangId(paperId,11);
        for (BankFillQue bankFillQue : fillTwoQueList){
            Map<String, Object> map = new HashMap<>();

            map.put("fillId",bankFillQue.getFillId());

            //通过fillId获取paperQue对象
            PaperQueExample paperQueExample = new PaperQueExample();
            PaperQueExample.Criteria criteria = paperQueExample.createCriteria();
            criteria.andFillIdEqualTo(bankFillQue.getFillId()).andPaperIdEqualTo(paperId);
            List<PaperQue> paperQueList = paperQueMapper.selectByExample(paperQueExample);
            PaperQue paperQue = paperQueList.get(0);
            map.put("queType",paperQue.getQueType());
            Integer queId = paperQue.getQueId();

            //通过queId获取试卷答案信息
            UserPaperAnswerExample userPaperAnswerExample = new UserPaperAnswerExample();
            UserPaperAnswerExample.Criteria criteria1 = userPaperAnswerExample.createCriteria();
            criteria1.andQueIdEqualTo(queId);
            criteria1.andUserPhoneEqualTo(userPhone);
            List<UserPaperAnswer> userPaperAnswerList = userPaperAnswerMapper.selectByExample(userPaperAnswerExample);
            UserPaperAnswer userPaperAnswer = userPaperAnswerList.get(0);
            map.put("answerId", userPaperAnswer.getAnswerId());
            map.put("stuAnswer", userPaperAnswer.getStuAnswer());
            map.put("isCollect", userPaperAnswer.getIscollect());
            map.put("isCorrect", userPaperAnswer.getIscorrect());

            map.put("fillContent",bankFillQue.getFillContent());
            map.put("fillAnswer",bankFillQue.getFillAnswer());
            map.put("explain",bankFillQue.getAnswerExplain());
            map.put("fillImgSrc",bankFillQue.getFillImgSrc());

            listResult.add(map);
        }

        return listResult;
    }

    /*
       获取试卷排行
    */
    public List<Map<String, Object>> getScoreListByPaperId(Integer paperId){
        UserPaperScoreExample userPaperScoreExample = new UserPaperScoreExample();
        UserPaperScoreExample.Criteria criteria = userPaperScoreExample.createCriteria();
        criteria.andPaperIdEqualTo(paperId);
        userPaperScoreExample.setOrderByClause("score desc, time_used asc");
        List<UserPaperScore> allScoreListResult = userPaperScoreMapper.selectByExample(userPaperScoreExample);
        List<Map<String, Object>> listResult = new ArrayList<>();

        for (UserPaperScore allScoreList : allScoreListResult){
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria2 = userExample.createCriteria();
            criteria2.andUserPhoneEqualTo(allScoreList.getUserPhone());
            List<User> userInfo = userMapper.selectByExample(userExample);
            Map<String, Object> map = new HashMap<>();

            map.put("userInfo",userInfo);
            map.put("score",allScoreList.getScore());
            map.put("timeUsed",allScoreList.getTimeUsed());

            listResult.add(map);
        }

        return listResult;
    }
}
