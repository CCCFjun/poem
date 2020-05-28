package com.mwt.oes.service.impl;

import com.mwt.oes.dao.*;
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
    @Autowired
    UserLikePostMapper userLikePostMapper;

    /*
        发帖
     */
    @Override
    public int userAddPost(String userPhone, String content, String title,
                           Date createTime,  Integer labelId) {
        UserPost userPost = new UserPost();
        userPost.setUserPhone(userPhone);
        userPost.setContent(content);
        userPost.setTitle(title);
        userPost.setInitTime(createTime);
        userPost.setLabelId(labelId);
        userPost.setReplayCount(0);
        userPost.setGood(0);
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
        userPostExampleAll.setOrderByClause("init_time desc");
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
        userPostExampleOne.setOrderByClause("init_time desc");
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
        userPostExampleTwo.setOrderByClause("init_time desc");
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

    /*
        喜欢帖子
     */
    @Override
    public int updateLikePost(Integer pid, String userPhone) {
        UserLikePostExample userLikePostExample = new UserLikePostExample();
        UserLikePostExample.Criteria criteria = userLikePostExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone).andPidEqualTo(pid);
        List<UserLikePost> likeList = userLikePostMapper.selectByExample(userLikePostExample);
        UserPost userPost = userPostMapper.selectByPrimaryKey(pid);
        if(likeList.size() == 0){  //没有喜欢过这个帖子，现在喜欢+1
            UserLikePost userLikePost = new UserLikePost();
            userLikePost.setPid(pid);
            userLikePost.setUserPhone(userPhone);
            userLikePostMapper.insertSelective(userLikePost);
            //帖子喜欢数+1
            int count = userPost.getGood() + 1;
            userPost.setGood(count);
        }else{   //取消喜欢-1
            userLikePostMapper.deleteByExample(userLikePostExample);
            int count = userPost.getGood() - 1;
            userPost.setGood(count);
        }
        int result = userPostMapper.updateByPrimaryKeySelective(userPost);
        return result;
    }

    /*
        q全部喜欢帖子
     */
    @Override
    public List<Map<String, Object>> getAllLikePost(String userPhone){
        List<Map<String, Object>> resultList = new ArrayList<>();

        UserLikePostExample userLikePostExample = new UserLikePostExample();
        UserLikePostExample.Criteria criteria = userLikePostExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);

        List<UserLikePost> userLikePostsList = userLikePostMapper.selectByExample(userLikePostExample);
        for (UserLikePost userLikePost : userLikePostsList){
            Map<String, Object> map = new HashMap<>();
            int pid = userLikePost.getPid();
            map.put("pid", userLikePost.getPid());
            UserPost userPost = userPostMapper.selectByPrimaryKey(pid);
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria2 = userExample.createCriteria();
            criteria2.andUserPhoneEqualTo(userPost.getUserPhone());
            List<User> userInfo = userMapper.selectByExample(userExample);
            map.put("userInfo",userInfo);
            map.put("content", userPost.getContent());
            map.put("title", userPost.getTitle());
            map.put("initTime", userPost.getInitTime());
            map.put("replayCount", userPost.getReplayCount());
            map.put("good", userPost.getGood());
            resultList.add(map);
        }

        return resultList;
    }

    /*
        q全部喜欢帖子pid
     */
    @Override
    public List getAllLikePostOnlyPid(String userPhone){
        List pidList = new ArrayList<>();

        UserLikePostExample userLikePostExample = new UserLikePostExample();
        UserLikePostExample.Criteria criteria = userLikePostExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);

        List<UserLikePost> userLikePostsList = userLikePostMapper.selectByExample(userLikePostExample);
        for (UserLikePost userLikePost : userLikePostsList){
            pidList.add(userLikePost.getPid());
        }

        return pidList;
    }
}
