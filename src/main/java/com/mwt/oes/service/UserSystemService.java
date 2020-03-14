package com.mwt.oes.service;

import com.mwt.oes.domain.User;

import java.util.Date;
import java.util.List;

public interface UserSystemService {
    public List<User> checkUserPsw(String userPhone, String userPsw);
    public boolean userPhoneIsExist(String userPhone);
    public int registerUser(String newUserPhone, String newUserPsw, String newUserName,
                            String userSex);
    public User getUserInfoByUserPhone(String userPhone);
    public boolean updateUser(User user);
}
