package com.mwt.oes.service;

import com.mwt.oes.domain.PostLabel;
import com.mwt.oes.domain.UserPost;

import java.util.List;
import java.util.Map;

public interface AdminPostService {
    public List<PostLabel> getPostLabelList();
    public List<UserPost> getPostList();
    public List<UserPost> searchPostList(String content, Integer labelId);
    public int deletePost(Integer pid);
}
