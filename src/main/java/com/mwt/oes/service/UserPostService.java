package com.mwt.oes.service;

import com.mwt.oes.domain.UserPost;
import com.mwt.oes.domain.UserReplay;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserPostService {
    public int userAddPost(String userPhone, String content, String title, Date createTime,  Integer labelId);
    public Map<String, Object> getPostListByLabel();
    public UserPost getPostDetailByPid(Integer pid);
    public Map<String, Object> getReplayByPid(Integer pid);
    public int userAddReplay(String userPhone, Integer pid, String replayContent, Date createTime);
    public int updateLikePost(Integer pid, String userPhone);
    public List<Map<String, Object>> getAllLikePost(String userPhone);
    public List getAllLikePostOnlyPid(String userPhone);
}
