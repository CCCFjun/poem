package com.mwt.oes.service.impl;

import com.mwt.oes.dao.UserMapper;
import com.mwt.oes.domain.User;
import com.mwt.oes.domain.UserExample;
import com.mwt.oes.service.UserSystemService;
import com.mwt.oes.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserSystemServiceImpl implements UserSystemService {

    @Autowired
    UserMapper userMapper;

    /*
        根据手机号查找用户信息
     */
    public User getUserInfoByUserPhone(String userPhone) {
        return userMapper.selectByPrimaryKey(userPhone);
    }

    /*
        校验用户登录
     */
    @Override
    public List<User> checkUserPsw(String userPhone, String userPsw) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone).andUserPswEqualTo(Md5Util.StringInMd5(userPsw));
        List<User> result = userMapper.selectByExample(example);
        return result;
    }

    /*
        判断手机号是否存在数据库用户表中
     */
    @Override
    public boolean userPhoneIsExist(String userPhone) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        List<User> result = userMapper.selectByExample(example);
        if(result.size()>0)
            return true;
        else
            return false;
    }

    /*
        注册用户信息，用户注册插入用户信息到用户表
     */
    @Override
    public int registerUser(String newUserPhone, String newUserPsw, String newUserName,
                               String userSex) {
        User user = new User();
        user.setUserPhone(newUserPhone);
        user.setUserPsw(Md5Util.StringInMd5(newUserPsw));
        user.setUserName(newUserName);
        user.setUserSex(userSex);
        int result = userMapper.insertSelective(user);
        return result;
    }

    /*
        更新用户信息
     */
    public boolean updateUser(User user){
        int result = userMapper.updateByPrimaryKey(user);
        if (result > 0){
            return true;
        }
        return false;
    }


}
