package com.mwt.oes.controller;

import com.mwt.oes.domain.User;
import com.mwt.oes.service.UserSystemService;
import com.mwt.oes.util.EmailUtil;
import com.mwt.oes.util.MobilePhoneUtil;
import com.mwt.oes.util.ProfileImageSavaUtil;
import com.mwt.oes.util.ServerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
//@CrossOrigin
public class UserSystemController {

    /*
        用户系统控制器：包含根据学号查找用户信息,用户登录校验，用户注册，用户找回密码，用户密码修改，用户个人信息修改，用户退出登录
     */

    @Autowired
    private UserSystemService userSystemService;

    //Log4j日志处理
    public static Logger log = LoggerFactory.getLogger(UserSystemController.class);


    /*
        校验用户登录
     */
    @RequestMapping(value = "/checkUserLogin", method = RequestMethod.POST)
    public ServerResponse checkUserLogin(@RequestBody(required = false)User user,
                                            HttpServletRequest request){
        String userPhone = user.getUserPhone();
        String userPsw = user.getUserPsw();
//        HttpSession session = request.getSession();

        if(userPhone.equals(""))
            return ServerResponse.createByError("手机号为空");

        //判断手机号存在与否
        boolean isUserPhoneFlag = userSystemService.userPhoneIsExist(userPhone);
        if (!isUserPhoneFlag)
            return ServerResponse.createByError("手机号不存在");
        else if(userPsw.isEmpty())
            return ServerResponse.createByError("手机号存在，但未输入密码");

        //判断学号密码是否匹配
        List<User> resultList = userSystemService.checkUserPsw(userPhone, userPsw);
        if (resultList != null && resultList.size() > 0){
            //将登录成功后的用户信息存入session
//            session.setAttribute("userObj",resultList.get(0));
            //返回给前台json数据
            return ServerResponse.createBySuccess("登录成功",resultList.get(0));
        }
        else {
            return ServerResponse.createByError("密码错误");
        }
    }

    /*
        用户注册
     */
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    public ServerResponse userRegister(@RequestBody Map<String, String> obj){
        String newUserName = obj.get("newUserName");
        String newUserPhone = obj.get("newUserPhone");
        String newUserPsw = obj.get("newUserPsw");
        String newUserPswConfirm = obj.get("newUserPswConfirm");
        //性别默认为男
        String userSex = "男";

        if(newUserPhone.isEmpty()){
            return ServerResponse.createByError("手机号为空");
        }

        boolean isRegistered = userSystemService.userPhoneIsExist(newUserPhone);
        if(isRegistered){
            return ServerResponse.createByError("此手机号已被注册");
        }
        else if(newUserPhone.length() != 11){
            return ServerResponse.createByError("手机号长度为11位");
        }
        else if(newUserPsw.isEmpty()){
            return ServerResponse.createByError("密码为空");
        }
        else if(newUserPsw.length() < 6){
            return ServerResponse.createByError("密码长度至少为6位");
        }
        else if(newUserPswConfirm.isEmpty()){
            return ServerResponse.createByError("再次输入密码为空");
        }
        else if(!newUserPsw.equals(newUserPswConfirm)){
            return ServerResponse.createByError("两次输入密码不一致");
        }
        else if(newUserName.isEmpty()){
            return ServerResponse.createByError("昵称为空");
        }
        else {
            int result = userSystemService.registerUser(newUserPhone, newUserPsw, newUserName, userSex);
            if(result == 0)
                return ServerResponse.createByError("数据库错误，注册失败");
            else
                return ServerResponse.createBySuccess("注册成功",null);
        }
    }

    /*
       用户个人信息修改
    */
    @RequestMapping(value = "/userInfoChange", method = RequestMethod.POST)
    public ServerResponse userInfoChange(MultipartFile userImgSrc,
                                            HttpServletRequest request){

        HttpSession session = request.getSession();
        String userPhone = request.getParameter("userPhone");
        User user = userSystemService.getUserInfoByUserPhone(userPhone);

        String userName = request.getParameter("userName");
        String userSex = request.getParameter("userSex");
        String userIntroduction = request.getParameter("userIntroduction");

        if(userName.isEmpty()){
            return ServerResponse.createByError("姓名为空");
        }
        else if(userSex.isEmpty()){
            return ServerResponse.createByError("性别为空");
        }
        else if(userIntroduction.isEmpty()){
            return ServerResponse.createByError("签名为空");
        }
        else if(userName.equals(user.getUserName()) && userSex.equals(user.getUserSex())
                && userIntroduction.equals(user.getUserIntroduction())
                && userImgSrc == null){
            return ServerResponse.createByError("信息修改与之前一致");
        }
        else {
            if (userImgSrc != null){
                user.setUserImgSrc(ProfileImageSavaUtil.qiniuImageSave(userImgSrc,user));
            }
            user.setUserName(userName);
            user.setUserSex(userSex);
            user.setUserIntroduction(userIntroduction);
            //判断信息是否修改成功
            boolean isUpdate = userSystemService.updateUser(user);
            if(isUpdate){
                session.setAttribute("stuObj",user);
                return ServerResponse.createBySuccess("信息修改成功",user);
            }
            else {
                return ServerResponse.createByError("信息修改失败");
            }
        }
    }

    /*
        用户密码修改
     */
    @RequestMapping(value = "/userPswChange", method = RequestMethod.POST)
    public ServerResponse userPswChange(@RequestBody Map<String, String> jsonObject, HttpServletRequest request){
        //判断会话是否失效
/*        if (request.getSession(false)==null){
            return ServerResponse.createByError("会话失效，请重新登录");
        }*/
        String oldUserPsw = jsonObject.get("password");
        String userPsw = jsonObject.get("newPassword");
        String userPswConfirm = jsonObject.get("newPasswordConfirm");
        String userPhone = jsonObject.get("userPhone");

        HttpSession session = request.getSession();
        User user = userSystemService.getUserInfoByUserPhone(userPhone);

        if(oldUserPsw.equals("")){
            return ServerResponse.createByError("原始密码为空");
        }
        if(!user.getUserPsw().equals(oldUserPsw)){
            return ServerResponse.createByError("原始密码错误");
        }
        if(userPsw.isEmpty()){
            return ServerResponse.createByError("新密码为空");
        }
        else if(userPsw.length() < 6){
            return ServerResponse.createByError("新密码长度至少为6位");
        }
        else if(userPswConfirm.isEmpty()){
            return ServerResponse.createByError("确认新密码为空");
        }
        else if(!userPsw.equals(userPswConfirm)){
            return ServerResponse.createByError("两次输入密码不一致");
        }
        else if(userPswConfirm.equals(user.getUserPsw())){
            return ServerResponse.createByError("新密码与旧密码相同，请重新设置");
        }
        else {
            user.setUserPsw(userPswConfirm);
            //判断密码是否修改成功
            boolean isUpdate = userSystemService.updateUser(user);
            if(isUpdate){
                session.setAttribute("stuObj",user);
                return ServerResponse.createBySuccess("密码修改成功",null);
            }
            else {
                return ServerResponse.createByError("密码修改失败");
            }
        }
    }
   
    /*
        用户退出登录
     */
    @RequestMapping("/userLoginOut")
    public ServerResponse userLoginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return ServerResponse.createBySuccess("退出登录成功",null);
    }

    /*
        通过phone获取用户信息
     */
    @RequestMapping("/getUserDetailByUserp")
    public ServerResponse getUserDetailByUserp(@RequestParam("userPhone")String userPhone ){
        User user = userSystemService.getUserInfoByUserPhone(userPhone);
        if(user != null){
            return ServerResponse.createBySuccess("pid为" + userPhone + "的帖子信息获取成功", user);
        }
        else {
            return ServerResponse.createByError("pid为" + userPhone + "的帖子信息获取失败");
        }
    }
}
