package com.mwt.oes.service.impl;

import com.mwt.oes.dao.PostLabelMapper;
import com.mwt.oes.dao.UserPostMapper;
import com.mwt.oes.dao.UserReplayMapper;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.AdminPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminPostServiceImpl implements AdminPostService {

    @Autowired
    PostLabelMapper postLabelMapper;
    @Autowired
    UserPostMapper userPostMapper;
    @Autowired
    UserReplayMapper userReplayMapper;

    //帖子类型列表
    @Override
    public List<PostLabel> getPostLabelList() {
        PostLabelExample postLabelExample = new PostLabelExample();
        postLabelExample.setOrderByClause("lid");
        List<PostLabel> resultList = postLabelMapper.selectByExample(postLabelExample);
        return resultList;
    }

    //帖子列表
    @Override
    public List<UserPost> getPostList() {
        UserPostExample userPostExample = new UserPostExample();
        userPostExample.setOrderByClause("pid");
        List<UserPost> resultList = userPostMapper.selectByExample(userPostExample);
        return resultList;
    }

    //搜索
    @Override
    public List<UserPost> searchPostList(String content, Integer labelId) {
        UserPostExample userPostExample = new UserPostExample();
        UserPostExample.Criteria criteria = userPostExample.createCriteria();
        if(!content.equals("undefined")) {
            criteria.andContentLike("%" + content + "%");
        }
        if(labelId != 0){
            criteria.andLabelIdEqualTo(labelId);
        }
        userPostExample.setOrderByClause("pid asc");
        List<UserPost> userPostList = userPostMapper.selectByExample(userPostExample);
        return userPostList;
    }

    //删帖
    @Override
    public int deletePost(Integer pid) {
        UserReplayExample userReplayExample = new UserReplayExample();
        UserReplayExample.Criteria criteria = userReplayExample.createCriteria();
        criteria.andPidEqualTo(pid);
        List<UserReplay> userReplayList = userReplayMapper.selectByExample(userReplayExample);
        for (UserReplay userReplay : userReplayList) {
            userReplayMapper.deleteByPrimaryKey(userReplay.getRid());
        }
        int result = userPostMapper.deleteByPrimaryKey(pid);
        return result;
    }
    
}
