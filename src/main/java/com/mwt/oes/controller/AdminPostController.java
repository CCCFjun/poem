package com.mwt.oes.controller;

import com.mwt.oes.domain.PostLabel;
import com.mwt.oes.domain.UserPost;
import com.mwt.oes.service.AdminPostService;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminPostController {

    @Autowired
    private AdminPostService adminPostService;

    @RequestMapping("/getPostLabelList")
    public ServerResponse getPostLabelList(){
        List<PostLabel> resultList = adminPostService.getPostLabelList();
        return ServerResponse.createBySuccess("获取全部帖子类型成功",resultList);
    }

    /*
     *获取论坛全部帖子
     */
    @RequestMapping("/getPostList")
    public ServerResponse getPostList(){
        List<UserPost> resultMap = adminPostService.getPostList();
        return ServerResponse.createBySuccess("获取全部帖子类型成功",resultMap);
    }

    //搜索帖子
    @RequestMapping("/searchPostList")
    public ServerResponse searchPostList(@RequestParam("content")String content,
                                         @RequestParam("labelId")Integer labelId){
        List<UserPost> resultList = adminPostService.searchPostList(content, labelId);
        return ServerResponse.createBySuccess("获取搜索试卷信息成功",resultList);
    }

    //  删贴
    @RequestMapping(value = "/deletePost",method = RequestMethod.POST)
    public ServerResponse deleteType(@RequestBody Map<String, Object> obj){
        Integer pid = (Integer) obj.get("pid");
        int result = adminPostService.deletePost(pid);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }
}
