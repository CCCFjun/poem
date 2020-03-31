package com.mwt.oes.controller;

import com.mwt.oes.domain.Feedback;
import com.mwt.oes.service.AdminFeedbackService;
import com.mwt.oes.util.ServerResponse;
import com.mwt.oes.websocket.WebSocketDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminFeedbackController {
    @Autowired
    private AdminFeedbackService adminFeedbackService;

    //    获取全部留言信息
    @RequestMapping("/getFeedbacksList")
    public ServerResponse getFeedbacksList(){
        List<Map<String, Object>> resultList = adminFeedbackService.getFeedbacksList();
        return ServerResponse.createBySuccess("获取全部留言信息成功",resultList);
    }

    //    获取未回复留言条数
    @RequestMapping("/getUnReplyCount")
    public ServerResponse getUnReplyCount(){
        int result = adminFeedbackService.getUnReplyCount();
        return ServerResponse.createBySuccess("获取未回复留言条数成功",result);
    }

    //    搜索
    @RequestMapping("/searchFeedbacksList")
    public ServerResponse searchFeedbacksList(@RequestParam("feedbackContent")String feedbackContent){
        List<Map<String, Object>> resultList = adminFeedbackService.searchFeedbacksList(feedbackContent);
        return ServerResponse.createBySuccess("获取全部轮播图信息成功",resultList);
    }

    // 删除留言
    @RequestMapping(value = "/deleteFeedback",method = RequestMethod.POST)
    public ServerResponse deleteFeedback(@RequestBody Map<String, Object> obj){
        Integer feedbackId = (Integer) obj.get("feedbackId");
        int result = adminFeedbackService.deleteFeedback(feedbackId);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }

    // 回复留言
    @RequestMapping(value = "/readFeedback",method = RequestMethod.POST)
    public ServerResponse readFeedback(@RequestBody Map<String, Object> obj) throws IOException {
        Integer feedbackId = (Integer) obj.get("fid");
        int result = adminFeedbackService.readFeedback(feedbackId);
        if(result > 0){
            return ServerResponse.createBySuccess("已读成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，已读失败");
        }
    }
}
