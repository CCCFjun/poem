package com.mwt.oes.service.impl;

import com.mwt.oes.dao.UserMapper;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    UserMapper userMapper;

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
        int result = userMapper.updateByPrimaryKeySelective(user);
        return result;
    }

}
