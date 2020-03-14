package com.mwt.oes.controller;

import com.mwt.oes.service.UserPracticeService;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserPracticeController {

    @Autowired
    private UserPracticeService userPracticeService;

    //  选择题请求随机出题
    @RequestMapping(value = "/getSinglePractice")
    public ServerResponse getSinglePractice(){
        List<Map<String, Object>> resultList = userPracticeService.getRandomSingleList();
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }

    //  判断题请求随机出题
    @RequestMapping(value = "/getJudgePractice")
    public ServerResponse getJudgePractice(){
        List<Map<String, Object>> resultList = userPracticeService.getRandomJudgeList();
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }

    //  填空题请求随机出题
    @RequestMapping(value = "/getFillPractice")
    public ServerResponse getFillPractice(){
        List<Map<String, Object>> resultList = userPracticeService.getRandomFillList();
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }

    //  填空题二请求随机出题
    @RequestMapping(value = "/getFillTwoPractice")
    public ServerResponse getFillTwoPractice(){
        List<Map<String, Object>> resultList = userPracticeService.getRandomFillTwoList();
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }
}
