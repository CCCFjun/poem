package com.mwt.oes.controller;

import com.mwt.oes.domain.Notice;
import com.mwt.oes.service.AdminNoticeService;
import com.mwt.oes.util.ServerResponse;
import com.mwt.oes.websocket.WebSocketDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminNoticeController {
    @Autowired
    private AdminNoticeService adminNoticeService;

    //    获取公告列表信息
    @RequestMapping("/getNoticesList")
    public ServerResponse getNoticesList(){
        List<Map<String, Object>> resultList = adminNoticeService.getNoticesList();
        return ServerResponse.createBySuccess("获取全部公告信息成功",resultList);
    }

    //    获取搜索公告列表信息
    @RequestMapping("/searchNoticesList")
    public ServerResponse searchNoticesList(@RequestParam("noticeContent")String noticeContent,
                                            @RequestParam("adminName")String adminName){
        List<Map<String, Object>> resultList = adminNoticeService.searchNoticeInfo(noticeContent, adminName);
        return ServerResponse.createBySuccess("获取搜索公告信息成功",resultList);
    }

    //    更新公告信息
    @RequestMapping(value = "/updateNoticeInfo",method = RequestMethod.POST)
    public ServerResponse updateNoticeInfo(@RequestBody(required = false) Notice notice){
        int result = adminNoticeService.updateNoticeInfo(notice);
        if (result > 0){
            return ServerResponse.createBySuccess("更新公告信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，更新公告信息失败");
        }
    }

    //    添加公告信息
    @RequestMapping(value = "/insertNoticeInfo",method = RequestMethod.POST)
    public ServerResponse insertNoticeInfo(@RequestBody(required = false) Notice notice) throws IOException {
        boolean noticeContentIsExist = adminNoticeService.noticeContentIsExist(notice.getNoticeContent());
        if(noticeContentIsExist){
            return ServerResponse.createByError("此公告内容已存在，请创新新的公告内容");
        }

        notice.setNoticeCreateTime(new Date());
        int result = adminNoticeService.insertNoticeInfo(notice);
        if (result > 0){
            // 插入公告时向用户推送消息
            ConcurrentHashMap<String, WebSocketDemo> webSocketSet = WebSocketDemo.getWebSocketDemo();
            for (String key : webSocketSet.keySet()) {
                if (key.length() == 12) {
                    webSocketSet.get(key).sendMessage("公告");
                }
            }
            return ServerResponse.createBySuccess("插入公告信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，插入公告信息失败");
        }
    }

    //  删除公告信息
    @RequestMapping(value = "/deleteNotice",method = RequestMethod.POST)
    public ServerResponse deleteScore(@RequestBody Map<String, Object> obj) throws IOException {
        Integer noticeId = (Integer) obj.get("noticeId");
        int result = adminNoticeService.deleteNotice(noticeId);
        if(result > 0){
            // 删除公告时向用户推送消息
            ConcurrentHashMap<String, WebSocketDemo> webSocketSet = WebSocketDemo.getWebSocketDemo();
            for (String key : webSocketSet.keySet()) {
                if (key.length() == 12) {
                    webSocketSet.get(key).sendMessage("公告");
                }
            }
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }
}
