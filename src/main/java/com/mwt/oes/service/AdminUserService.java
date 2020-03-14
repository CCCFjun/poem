package com.mwt.oes.service;

import com.mwt.oes.domain.User;

import java.util.List;
import java.util.Map;

public interface AdminUserService {
    public List<User> getUserList();
    public List<User> searchUserInfo(String userPhone, String userName, String userSex);
    public int insertUserInfo(User user);
    public int updateUserInfo(User user);
}
