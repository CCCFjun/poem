package com.mwt.oes.controller;

import com.mwt.oes.domain.User;
import com.mwt.oes.service.UserSystemService;
import com.mwt.oes.service.AdminUserService;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private UserSystemService userSystemService;

    //    获取用户列表信息
    @RequestMapping("/getUserList")
    public ServerResponse getUsersList(){
        List<User> resultList = adminUserService.getUserList();
        return ServerResponse.createBySuccess("获取全部用户信息成功",resultList);
    }


    //    获取搜索用户列表信息
    @RequestMapping("/searchUserInfo")
    public ServerResponse searchUserInfo(@RequestParam("userPhone")String userPhone,
                                            @RequestParam("userName")String userName,
                                            @RequestParam("userSex")String userSex){
        List<User> resultList = adminUserService.searchUserInfo(userPhone, userName, userSex);
        return ServerResponse.createBySuccess("获取搜索用户信息成功",resultList);
    }

    //    添加用户信息
    @RequestMapping(value = "/insertUserInfo",method = RequestMethod.POST)
    public ServerResponse insertUserInfo(@RequestBody(required = false)User user){
        boolean isRegistered = userSystemService.userPhoneIsExist(user.getUserPhone());
        if(isRegistered){
            return ServerResponse.createByError("此手机号已被注册");
        }

        int result = adminUserService.insertUserInfo(user);
        if (result > 0){
            return ServerResponse.createBySuccess("插入用户信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，插入用户信息失败");
        }
    }

    //    更新用户状态
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public ServerResponse updateUserInfo(@RequestBody(required = false)User user){
        int result = adminUserService.updateUserInfo(user);
        if (result > 0){
            return ServerResponse.createBySuccess("更新用户信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，更新用户信息失败");
        }
    }

}

