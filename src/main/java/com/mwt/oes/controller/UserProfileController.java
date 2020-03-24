package com.mwt.oes.controller;

import com.mwt.oes.domain.User;
import com.mwt.oes.service.UserProfileService;
import com.mwt.oes.service.AdminNoticeService;
import com.mwt.oes.service.UserSystemService;
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
@RequestMapping("/api/user")
public class UserProfileController {
    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private AdminNoticeService adminNoticeService;
    @Autowired
    private UserSystemService userSystemService;

    //    获取公告列表信息
    @RequestMapping("/getNoticesList")
    public ServerResponse getNoticesList(){
        List<Map<String, Object>> resultList = adminNoticeService.getNoticesList();
        return ServerResponse.createBySuccess("获取全部公告信息成功",resultList);
    }

    /*
        发送反馈留言
     */
    @RequestMapping(value = "/userSendFeedback", method = RequestMethod.POST)
    public ServerResponse userSendFeedback(@RequestBody Map<String, String> obj) throws IOException {
        //判断会话是否失效
/*        if (request.getSession(false)==null){
            return ServerResponse.createByError("会话失效，请重新登录");
        }*/

        String content = obj.get("feedback");
        String userPhone = obj.get("userPhone");

//        HttpSession session = request.getSession();
        User user = userSystemService.getUserInfoByUserPhone(userPhone);

        String userName = user.getUserName();

        if(content.equals("")){
            return ServerResponse.createByError("留言内容为空");
        }
        else if(content.length() > 255){
            return ServerResponse.createByError("留言内容最多为255个字符");
        }
        else {
            int result = userProfileService.userSendFeedback(content, new Date(), userPhone, userName);
            if(result == 0){
                return ServerResponse.createByError("数据库错误，留言失败");
            }
            else {
                ConcurrentHashMap<String, WebSocketDemo> webSocketSet = WebSocketDemo.getWebSocketDemo();
                for (String key : webSocketSet.keySet()) {
                    if (key.length() == 6) {
                        webSocketSet.get(key).sendMessage("留言");
                    }
                }
                return ServerResponse.createBySuccess("留言成功,请等待管理员回复",null);
            }
        }
    }

    /*
        我的页面顶部右侧管理员回复消息提醒
     */
    @RequestMapping(value = "/adminReplyCount", method = RequestMethod.GET)
    public ServerResponse adminReplyCount(@RequestParam("userPhone") String userPhone){
        int count = userProfileService.getAdminReplyCount(userPhone, "1");
        if(count == 0){
            return ServerResponse.createByError("暂无管理员回复消息");
        }
        else {
            return ServerResponse.createBySuccess("获取管理员回复数目成功",count);
        }
    }
}
