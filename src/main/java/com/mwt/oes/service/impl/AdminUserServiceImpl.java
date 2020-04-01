package com.mwt.oes.service.impl;

import com.mwt.oes.dao.UserMapper;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.AdminUserService;
import com.mwt.oes.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    UserMapper userMapper;

    public static final Base64.Decoder DECODER = Base64.getDecoder();

    @Override
    public List<User> getUserList() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("user_phone");
        List<User> resultList = userMapper.selectByExample(userExample);
        return resultList;
    }

    @Override
    public List<User> searchUserInfo(String userPhone, String userName, String userSex) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        if (!userPhone.equals("undefined")){
            criteria.andUserPhoneLike("%" + userPhone + "%");
        }
        if (!userName.equals("undefined")){
            criteria.andUserNameLike("%" + userName + "%");
        }
        if (!userSex.equals("undefined")){
            criteria.andUserSexEqualTo(userSex);
        }
        userExample.setOrderByClause("user_phone");
        List<User> resultList = userMapper.selectByExample(userExample);
        return resultList;
    }

    @Override
    public int insertUserInfo(User user) {
        int result = userMapper.insertSelective(user);
        return result;
    }

    @Override
    public int updateUserInfo(User user) {
        //解密
        String depassword = new String(DECODER.decode(user.getUserPsw()));
        user.setUserPsw(MD5Util.md5(depassword, depassword));
        int result = userMapper.updateByPrimaryKeySelective(user);
        return result;
    }

}
