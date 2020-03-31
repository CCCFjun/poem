package com.mwt.oes.service.impl;

import com.mwt.oes.dao.PostLabelMapper;
import com.mwt.oes.dao.UserMapper;
import com.mwt.oes.dao.UserPostMapper;
import com.mwt.oes.dao.UserReplayMapper;
import com.mwt.oes.domain.*;
import com.mwt.oes.service.UserPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserPostServiceImpl implements UserPostService {
    @Autowired
    UserPostMapper userPostMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserReplayMapper userReplayMapper;
    @Autowired
    PostLabelMapper postLabelMapper;

    /*
        发帖
     */
    @Override
    public int userAddPost(String userPhone, String content, String title, Date createTime,  Integer labelId) {
        UserPost userPost = new UserPost();
        userPost.setUserPhone(userPhone);
        userPost.setContent(content);
        userPost.setTitle(title);
        userPost.setInitTime(createTime);
        userPost.setLabelId(labelId);
        userPost.setReplayCount(0);
        int result = userPostMapper.insertSelective(userPost);
        //该类型帖子数+1
        PostLabel postLabel = postLabelMapper.selectByPrimaryKey(labelId);
        int count = postLabel.getPostsCount() + 1;
        postLabel.setPostsCount(count);
        postLabelMapper.updateByPrimaryKeySelective(postLabel);
        return result;
    }
    /*
        帖子列表分类展示
    */
    @Override
    public Map<String, Object> getPostListByLabel() {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> allPostData = new ArrayList<>();
        List<Map<String, Object>> onePostData = new ArrayList<>();
        List<Map<String, Object>> twoPostData = new ArrayList<>();

        UserPostExample userPostExampleAll = new UserPostExample();
        List<UserPost> userPostListAll = userPostMapper.selectByExample(userPostExampleAll);
        for (UserPost userPost : userPostListAll) {
            Map<String, Object> allMap = new HashMap<>();

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserPhoneEqualTo(userPost.getUserPhone());
            List<User> userInfo = userMapper.selectByExample(userExample);

            allMap.put("userInfo",userInfo);
            allMap.put("pid", userPost.getPid());
            allMap.put("content", userPost.getContent());
            allMap.put("title", userPost.getTitle());
            allMap.put("initTime", userPost.getInitTime());
            allMap.put("replayCount", userPost.getReplayCount());
            allMap.put("good", userPost.getGood());
            allPostData.add(allMap);
        }

        UserPostExample userPostExampleOne = new UserPostExample();
        UserPostExample.Criteria criteriaOne = userPostExampleOne.createCriteria();
        criteriaOne.andLabelIdEqualTo(1);
        List<UserPost> userPostListOne = userPostMapper.selectByExample(userPostExampleOne);
        for (UserPost userPost : userPostListOne) {
            Map<String, Object> oneMap = new HashMap<>();

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserPhoneEqualTo(userPost.getUserPhone());
            List<User> userInfo = userMapper.selectByExample(userExample);

            oneMap.put("userInfo",userInfo);
            oneMap.put("pid", userPost.getPid());
            oneMap.put("content", userPost.getContent());
            oneMap.put("title", userPost.getTitle());
            oneMap.put("initTime", userPost.getInitTime());
            oneMap.put("replayCount", userPost.getReplayCount());
            oneMap.put("good", userPost.getGood());
            onePostData.add(oneMap);
        }

        UserPostExample userPostExampleTwo = new UserPostExample();
        UserPostExample.Criteria criteriaTwo = userPostExampleTwo.createCriteria();
        criteriaTwo.andLabelIdEqualTo(2);
        List<UserPost> userPostListTwo = userPostMapper.selectByExample(userPostExampleTwo);
        for (UserPost userPost : userPostListTwo) {
            Map<String, Object> twoMap = new HashMap<>();

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUserPhoneEqualTo(userPost.getUserPhone());
            List<User> userInfo = userMapper.selectByExample(userExample);

            twoMap.put("userInfo",userInfo);
            twoMap.put("pid", userPost.getPid());
            twoMap.put("content", userPost.getContent());
            twoMap.put("title", userPost.getTitle());
            twoMap.put("initTime", userPost.getInitTime());
            twoMap.put("replayCount", userPost.getReplayCount());
            twoMap.put("good", userPost.getGood());
            twoPostData.add(twoMap);
        }

        map.put("allPostData",allPostData);
        map.put("onePostData",onePostData);
        map.put("twoPostData",twoPostData);
        return map;
    }

    /*
        通过pid获取帖子信息
     */
    @Override
    public UserPost getPostDetailByPid(Integer pid) {
        UserPost userPost = userPostMapper.selectByPrimaryKey(pid);
        return userPost;
    }

    /*
        通过pid获取帖子评论信息
     */
    @Override
    public Map<String, Object> getReplayByPid(Integer pid) {
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();

        UserReplayExample userReplayExample = new UserReplayExample();
        UserReplayExample.Criteria criteria = userReplayExample.createCriteria();
        criteria.andPidEqualTo(pid);
        List<UserReplay> userReplayList = userReplayMapper.selectByExample(userReplayExample);
        for (UserReplay userReplay : userReplayList) {
            Map<String, Object> map2 = new HashMap<>();

            UserExample userExample = new UserExample();
            UserExample.Criteria criteria2 = userExample.createCriteria();
            criteria2.andUserPhoneEqualTo(userReplay.getUserPhone());
            List<User> userInfo = userMapper.selectByExample(userExample);

            map2.put("userInfo",userInfo);
            map2.put("rid", userReplay.getRid());
            map2.put("content", userReplay.getContent());
            map2.put("initTime", userReplay.getInitTime());
            list.add(map2);
        }
        map.put("list",list);
        return map;
    }

    /*
        发评论
     */
    @Override
    public int userAddReplay(String userPhone, Integer pid, String replayContent, Date createTime) {
        UserReplay userReplay = new UserReplay();
        userReplay.setUserPhone(userPhone);
        userReplay.setPid(pid);
        userReplay.setContent(replayContent);
        userReplay.setInitTime(createTime);
        int result = userReplayMapper.insertSelective(userReplay);
        //帖子回复数+1
        UserPost userPost = userPostMapper.selectByPrimaryKey(pid);
        int count = userPost.getReplayCount() + 1;
        userPost.setReplayCount(count);
        userPostMapper.updateByPrimaryKeySelective(userPost);
        return result;
    }
}
