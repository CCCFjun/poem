package com.mwt.oes.service.impl;

import com.mwt.oes.dao.NoticeMapper;
import com.mwt.oes.domain.Notice;
import com.mwt.oes.domain.NoticeExample;
import com.mwt.oes.service.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminNoticeServiceImpl implements AdminNoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Map<String, Object>> getNoticesList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        NoticeExample noticeExample = new NoticeExample();
        noticeExample.setOrderByClause("notice_create_time desc");
        List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);
        for (Notice notice : noticeList){
            Map<String, Object> map = new HashMap<>();
            map.put("id", noticeList.indexOf(notice) + 1);
            map.put("noticeId", notice.getNoticeId());
            map.put("noticeContent", notice.getNoticeContent());
            map.put("noticeCreateTime", notice.getNoticeCreateTime());
            map.put("adminName", notice.getAdminName());
            map.put("ano", notice.getAno());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> searchNoticeInfo(String noticeContent, String adminName) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria = noticeExample.createCriteria();
        if(!noticeContent.equals("undefined")) {
            criteria.andNoticeContentLike("%" + noticeContent + "%");
        }
        if(!adminName.equals("undefined")) {
            criteria.andAdminNameLike("%" + adminName + "%");
        }
        noticeExample.setOrderByClause("notice_id asc");
        List<Notice> noticeList = noticeMapper.selectByExample(noticeExample);
        for (Notice notice : noticeList){
            Map<String, Object> map = new HashMap<>();
            map.put("id", noticeList.indexOf(notice) + 1);
            map.put("noticeId", notice.getNoticeId());
            map.put("noticeContent", notice.getNoticeContent());
            map.put("ano", notice.getAno());
            map.put("noticeCreateTime", notice.getNoticeCreateTime());
            map.put("adminName", notice.getAdminName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public boolean noticeContentIsExist(String noticeContent) {
        NoticeExample noticeExample = new NoticeExample();
        NoticeExample.Criteria criteria = noticeExample.createCriteria();
        criteria.andNoticeContentEqualTo(noticeContent);
        List<Notice> resultList = noticeMapper.selectByExample(noticeExample);
        if(resultList.size() > 0){
            return  true;
        } else {
            return false;
        }
    }

    @Override
    public int insertNoticeInfo(Notice notice) {
        int result = noticeMapper.insertSelective(notice);
        return result;
    }

    @Override
    public int updateNoticeInfo(Notice notice) {
        int result = noticeMapper.updateByPrimaryKeySelective(notice);
        return result;
    }

    @Override
    public int deleteNotice(Integer noticeId) {
        int result = noticeMapper.deleteByPrimaryKey(noticeId);
        return result;
    }
}
