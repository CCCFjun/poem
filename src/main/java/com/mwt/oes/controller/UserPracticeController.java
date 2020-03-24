package com.mwt.oes.controller;

import com.mwt.oes.domain.QuestionType;
import com.mwt.oes.service.AdminRotationImgService;
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
    @Autowired
    private AdminRotationImgService adminRotationImgService;

    //    获取全部轮播图信息
    @RequestMapping("/getRotationImgsList")
    public ServerResponse getRotationImgsList(){
        List<Map<String, Object>> resultList = adminRotationImgService.getRotationImgsList();
        return ServerResponse.createBySuccess("获取全部轮播图信息成功",resultList);
    }

    /*
        获取全部练习题型分类
     */
    @RequestMapping("/getPracticeKind")
    public ServerResponse getPracticeKind(){
        List<QuestionType> resultList = userPracticeService.getPracticeKind();
        if(resultList != null && resultList.size() > 0){
            return ServerResponse.createBySuccess("练习题型分类获取成功",resultList);
        }
        else {
            return ServerResponse.createByError("练习题型分类获取失败");
        }
    }

    /*
        通过langId获取题型信息
     */
    @RequestMapping("/getKindInfoById")
    public ServerResponse getKindInfoById(@RequestParam("kindId")Integer kindId ){
        QuestionType questionType = userPracticeService.getKindInfoById(kindId);
        if(questionType != null){
//            log.info(questionType.getLangImgSrc());
            return ServerResponse.createBySuccess("题型id为" + kindId + "的信息获取成功", questionType);
        }
        else {
            return ServerResponse.createByError("题型id为" + kindId + "的信息获取失败");
        }
    }

    //  选择题请求随机出题
    @RequestMapping(value = "/getSinglePractice")
    public ServerResponse getSinglePractice(@RequestParam("queNum")Integer num){
        List<Map<String, Object>> resultList = userPracticeService.getRandomSingleList(num);
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }

    //  判断题请求随机出题
    @RequestMapping(value = "/getJudgePractice")
    public ServerResponse getJudgePractice(@RequestParam("queNum")Integer num){
        List<Map<String, Object>> resultList = userPracticeService.getRandomJudgeList(num);
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }

    //  填空题请求随机出题
    @RequestMapping(value = "/getFillPractice")
    public ServerResponse getFillPractice(@RequestParam("queNum")Integer num){
        List<Map<String, Object>> resultList = userPracticeService.getRandomFillList(num);
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }

    //  填空题二请求随机出题
    @RequestMapping(value = "/getFillTwoPractice")
    public ServerResponse getFillTwoPractice(@RequestParam("queNum")Integer num){
        List<Map<String, Object>> resultList = userPracticeService.getRandomFillTwoList(num);
        return ServerResponse.createBySuccess("题目发布成功",resultList);
    }
}
