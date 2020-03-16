package com.mwt.oes.controller;

import com.mwt.oes.domain.Paper;
import com.mwt.oes.domain.StudentPaperScore;
import com.mwt.oes.service.UserExamService;
import com.mwt.oes.util.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
//@CrossOrigin
public class UserExamController {

    @Autowired
    private UserExamService userExamService;

    //Log4j日志处理
    public static Logger log = LoggerFactory.getLogger(StudentSystemController.class);

    /*
       通过paperId获取试卷及各题型题目
    */
    @RequestMapping("/getPapersInfoByPaperId")
    public ServerResponse getPapersInfoByPaperId(@RequestParam("paperId")Integer paperId ){
        Paper paper = userExamService.getPapersInfoByPaperId(paperId);
        Map<String, Integer> numObj = userExamService.getPaperQueNumByPaperId(paperId);
        List<Map<String, Object>> singleQueList = userExamService.getSingleQueListByPaperId(paperId);
        List<Map<String, Object>> judgeQueList = userExamService.getJudgeQueListByPaperId(paperId);
        List<Map<String, Object>> fillQueList = userExamService.getFillQueListByPaperId(paperId);
        List<Map<String, Object>> fillTwoQueList = userExamService.getFillTwoQueListByPaperId(paperId);
        if(paper != null && numObj != null){
            Map<String, Object> map = new HashMap<>();
            map.put("paperInfo",paper);
            map.put("queNumInfo",numObj);
            map.put("singleQueList",singleQueList);
            map.put("judgeQueList",judgeQueList);
            map.put("fillQueList",fillQueList);
            map.put("fillTwoQueList",fillTwoQueList);
            return ServerResponse.createBySuccess("试卷id为" + paperId + "的试卷信息获取成功",map);
        }
        else {
            return ServerResponse.createByError("试卷id为" + paperId + "的试卷信息获取失败");
        }
    }

    /*
        请求获取当前试卷状态，即是否已完成
     */
    @RequestMapping(value = "/getCurrentPaperStatus", method = RequestMethod.POST)
    public ServerResponse getCurrentPaperStatus(@RequestBody(required = false)StudentPaperScore studentPaperScore){
        String userPhone = studentPaperScore.getUserPhone();
        Integer paperId = studentPaperScore.getPaperId();
        List<StudentPaperScore> resultList = userExamService.getCurrentPaperStatus(userPhone, paperId);
        if(resultList != null && resultList.size() > 0){
            return ServerResponse.createBySuccess("当前试卷已完成",resultList);
        }
        else {
            return ServerResponse.createByError("当前试卷未完成");
        }
    }

    /*
        插入用户成绩表成绩信息，包含三个字段，考试开始时间、手机号和试卷id
     */
    @RequestMapping(value = "/insertStudentPaperScore", method = RequestMethod.POST)
    public ServerResponse insertStudentPaperScore(@RequestBody(required = false)StudentPaperScore studentPaperScore){
        studentPaperScore.setStartTime(new Date());
        int result = userExamService.insertStudentPaperScore(studentPaperScore);
        if(result == 0)
            return ServerResponse.createByError("数据库错误，插入学生成绩表失败");
        else
            return ServerResponse.createBySuccess("账号" + studentPaperScore.getUserPhone() + "试卷id" + studentPaperScore.getPaperId() + "初始化插入学生成绩表信息成功",null);
    }

    /*
       提交答卷，插入用户成绩表成绩信息和试卷答题记录信息
    */
    @RequestMapping(value = "/submitPaper", method = RequestMethod.POST)
    public ServerResponse submitPaper(@RequestBody Map<String, Object> obj){

        //学号
        String userPhone = (String) obj.get("userPhone");
        //试卷id
        Integer paperId = Integer.parseInt((String) obj.get("paperId"));
        //单选题答案数组
        List<String> singleAnswers = (List) obj.get("singleAnswers");
        //判断题答案数组
        List<String> judgeAnswers = (List) obj.get("judgeAnswers");
        //填空题答案数组
        List<String> fillAnswers = (List) obj.get("fillAnswers");
        //填空题答案数组
        List<String> fillTwoAnswers = (List) obj.get("fillTwoAnswers");
        //考试花费时间
        int timeUsed = (Integer) obj.get("timeUsed");

        int result = userExamService.insertPaperAnswerAndPaperScore(userPhone, paperId, singleAnswers,
                judgeAnswers, fillAnswers, fillTwoAnswers,timeUsed);

        if(result == 0){
            return ServerResponse.createByError("数据库错误，插入试卷答案记录表或用户成绩表失败");
        }
        else {
            return ServerResponse.createBySuccess("账号" + userPhone + "试卷id" + paperId + "交卷成功，数据已插入数据库并已自动计算出成绩",null);
        }
    }

    /*
       通过userPhone和paperId获取已参与试卷的题目和个人回答
    */
    @RequestMapping("/getPapersInfoByJoinedPaperId")
    public ServerResponse getPapersInfoByJoinedPaperId(@RequestParam("userPhone")String userPhone,
                                                      @RequestParam("paperId")Integer paperId ){
        Paper paper = userExamService.getPapersInfoByPaperId(paperId);
        Map<String, Integer> numObj = userExamService.getPaperQueNumByPaperId(paperId);
        List<Map<String, Object>> singleQueList = userExamService.getSingleQueListByJoinedPaperId(userPhone, paperId);
        List<Map<String, Object>> judgeQueList = userExamService.getJudgeQueListByJoinedPaperId(userPhone, paperId);
        List<Map<String, Object>> fillQueList = userExamService.getFillQueListByJoinedPaperId(userPhone, paperId);
        List<Map<String, Object>> fillTwoQueList = userExamService.getFillTwoQueListByJoinedPaperId(userPhone, paperId);
        if(paper != null && numObj != null){
            Map<String, Object> map = new HashMap<>();
            map.put("paperInfo",paper);
            map.put("queNumInfo",numObj);
            map.put("singleQueList",singleQueList);
            map.put("judgeQueList",judgeQueList);
            map.put("fillQueList",fillQueList);
            map.put("fillTwoQueList",fillTwoQueList);
            return ServerResponse.createBySuccess("错题试卷id为" + paperId + "的试卷信息获取成功",map);
        }
        else {
            return ServerResponse.createByError("错题试卷id为" + paperId + "的试卷信息获取失败");
        }
    }

    /*
        请求获取当前试卷的成绩排行
     */
    @RequestMapping(value = "/getScoreListByPaperId")
    public ServerResponse getScoreListByPaperId(@RequestParam("paperId")Integer paperId){
        List<Map<String, Object>> resultList = userExamService.getScoreListByPaperId(paperId);
        if(resultList != null && resultList.size() > 0){
            return ServerResponse.createBySuccess("排行如下",resultList);
        }
        else {
            return ServerResponse.createByError("当前试卷未完成");
        }
    }
}
