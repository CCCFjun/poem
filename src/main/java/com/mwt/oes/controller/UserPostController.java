package com.mwt.oes.controller;

import com.mwt.oes.domain.PostLabel;
import com.mwt.oes.domain.UserPost;
import com.mwt.oes.service.AdminPostService;
import com.mwt.oes.service.UserPostService;
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
public class UserPostController {

    @Autowired
    private AdminPostService adminPostService;
    @Autowired
    private UserPostService userPostService;

    @RequestMapping("/getPostLabelList")
    public ServerResponse getPostLabelList(){
        List<PostLabel> resultList = adminPostService.getPostLabelList();
        return ServerResponse.createBySuccess("获取全部帖子类型成功",resultList);
    }

    /*
        发贴
     */
    @RequestMapping(value = "/userAddPost", method = RequestMethod.POST)
    public ServerResponse userAddPost(@RequestBody Map<String, Object> obj) throws IOException {
        String userPhone = (String)obj.get("userPhone");
        String title = (String)obj.get("postTitle");
        String content = (String)obj.get("postContent");
        Integer labelId = Integer.parseInt((String) obj.get("labelId"));
        if(content.equals("")){
            return ServerResponse.createByError("帖子内容为空");
        }
        else if(content.length() > 255){
            return ServerResponse.createByError("内容最多为255个字符");
        }
        else {
            int result = userPostService.userAddPost(userPhone, content, title, new Date(), labelId);
            if(result == 0){
                return ServerResponse.createByError("数据库错误，发帖失败");
            }
            else {
                ConcurrentHashMap<String, WebSocketDemo> webSocketSet = WebSocketDemo.getWebSocketDemo();
                for (String key : webSocketSet.keySet()) {
                    if (key.length() == 6) {
                        webSocketSet.get(key).sendMessage("留言");
                    }
                }
                return ServerResponse.createBySuccess("发帖成功",null);
            }
        }
    }

    /*
    *获取论坛全部帖子
    */
    @RequestMapping("/getPostList")
    public ServerResponse getPostList(){
        Map<String, Object> resultMap = userPostService.getPostListByLabel();
        return ServerResponse.createBySuccess("获取全部帖子类型成功",resultMap);
    }

    /*
        通过pid获取帖子信息
     */
    @RequestMapping("/getPostDetailByPid")
    public ServerResponse getPostDetailByPid(@RequestParam("pid")Integer pid ){
        UserPost userPost = userPostService.getPostDetailByPid(pid);
        if(userPost != null){
            return ServerResponse.createBySuccess("pid为" + pid + "的帖子信息获取成功", userPost);
        }
        else {
            return ServerResponse.createByError("pid为" + pid + "的帖子信息获取失败");
        }
    }

    /*
        通过pid获取帖子评论信息
     */
    @RequestMapping("/getReplayByPid")
    public ServerResponse getReplayByPid(@RequestParam("pid")Integer pid ){
        Map<String, Object> userReplayList = userPostService.getReplayByPid(pid);
        if(userReplayList != null){
            return ServerResponse.createBySuccess("pid为" + pid + "的帖子信息获取成功", userReplayList);
        }
        else {
            return ServerResponse.createByError("pid为" + pid + "的帖子信息获取失败");
        }
    }

    /*
        发评论
     */
    @RequestMapping(value = "/userAddReplay", method = RequestMethod.POST)
    public ServerResponse userAddReplay(@RequestBody Map<String, Object> obj) throws IOException {
        String userPhone = (String)obj.get("userPhone");
        Integer pid = Integer.parseInt((String) obj.get("pid"));
        String replayContent = (String)obj.get("replayContent");;
        if(replayContent.equals("")){
            return ServerResponse.createByError("回复内容为空");
        }
        else if(replayContent.length() > 255){
            return ServerResponse.createByError("内容最多为255个字符");
        }
        else {
            int result = userPostService.userAddReplay(userPhone, pid, replayContent, new Date());
            if(result == 0){
                return ServerResponse.createByError("数据库错误，发帖失败");
            }
            else {
                ConcurrentHashMap<String, WebSocketDemo> webSocketSet = WebSocketDemo.getWebSocketDemo();
                for (String key : webSocketSet.keySet()) {
                    if (key.length() == 6) {
                        webSocketSet.get(key).sendMessage("留言");
                    }
                }
                return ServerResponse.createBySuccess("评论成功",null);
            }
        }
    }

    /*
        更新帖子喜欢
     */
    @RequestMapping(value = "/updateLikePost", method = RequestMethod.POST)
    public ServerResponse updateLikePost(@RequestBody Map<String, Object> map){
        UserPost userPost = new UserPost();
        Integer pid = (Integer) map.get("pid");
        String userPhone = (String) map.get("userPhone");
        int result = userPostService.updateLikePost(pid, userPhone);
        if(result != 0){
            return ServerResponse.createBySuccess("更新成功",null);
        }
        else {
            return ServerResponse.createByError("更新失败");
        }
    }

    /*
       获取全部喜欢
    */
    @RequestMapping("/getAllLikePost")
    public ServerResponse getAllLikePost(@RequestParam("userPhone")String userPhone){
        List<Map<String, Object>> resultList = userPostService.getAllLikePost(userPhone);
        return ServerResponse.createBySuccess("获取全部收藏题目成功",resultList);
    }

    /*
       获取全部喜欢
    */
    @RequestMapping("/getAllLikePostOnlyPid")
    public ServerResponse getAllLikePostOnlyPid(@RequestParam("userPhone")String userPhone){
        List resultList = userPostService.getAllLikePostOnlyPid(userPhone);
        return ServerResponse.createBySuccess("获取全部收藏题目成功",resultList);
    }
}
