package com.mwt.oes.controller;

import com.mwt.oes.domain.UserPaperAnswer;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mwt.oes.service.UserCollectionService;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserCollectionController {

    @Autowired
    private UserCollectionService userCollectionService;

    /*
        请求根据answerId更新学生试卷答案表isCollect字段
     */
    @RequestMapping(value = "/updatePaperAnswerIsCollect", method = RequestMethod.POST)
    public ServerResponse updatePaperAnswerIsCollect(@RequestBody Map<String, Object> map){
        UserPaperAnswer userPaperAnswer = new UserPaperAnswer();
        userPaperAnswer.setAnswerId((Integer) map.get("answerId"));
        userPaperAnswer.setIscollect((String) map.get("isCollect"));
        int result = userCollectionService.updatePaperAnswerIsCollect(userPaperAnswer);
        if(result != 0){
            return ServerResponse.createBySuccess("更新成功",null);
        }
        else {
            return ServerResponse.createByError("更新失败");
        }
    }

    /*
       获取全部收藏题目
    */
    @RequestMapping("/getAllCollections")
    public ServerResponse getAllCollections(@RequestParam("userPhone")String userPhone){
        List<Map<String, Object>> resultList = userCollectionService.getAllCollections(userPhone);
        return ServerResponse.createBySuccess("获取全部收藏题目成功",resultList);
    }

    /*
        通过answerId获取收藏单选题信息
     */
    @RequestMapping("/getSingleByAnswerId")
    public ServerResponse getSingleByAnswerId(@RequestParam("answerId")Integer answerId){
        Map<String, Object> map = userCollectionService.getSingleByAnswerId(answerId);
        if(map != null){
            return ServerResponse.createBySuccess("通过answerId获取收藏单选题信息成功",map);
        }
        else {
            return ServerResponse.createByError("通过answerId获取收藏单选题信息失败");
        }
    }
    /*
        通过answerId获取收藏判断题信息
    */
    @RequestMapping("/getJudgeByAnswerId")
    public ServerResponse getJudgeByAnswerId(@RequestParam("answerId")Integer answerId){
        Map<String, Object> map = userCollectionService.getJudgeByAnswerId(answerId);
        if(map != null){
            return ServerResponse.createBySuccess("通过answerId获取收藏判断题信息成功",map);
        }
        else {
            return ServerResponse.createByError("通过answerId获取收藏判断题信息失败");
        }
    }
    /*
        通过answerId获取收藏填空题信息
    */
    @RequestMapping("/getFillByAnswerId")
    public ServerResponse getFillByAnswerId(@RequestParam("answerId")Integer answerId){
        Map<String, Object> map = userCollectionService.getFillByAnswerId(answerId);
        if(map != null){
            return ServerResponse.createBySuccess("通过answerId获取收藏填空题信息成功",map);
        }
        else {
            return ServerResponse.createByError("通过answerId获取收藏填空题信息失败");
        }
    }
}
