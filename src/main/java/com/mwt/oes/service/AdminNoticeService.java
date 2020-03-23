package com.mwt.oes.service;

import com.mwt.oes.domain.Notice;

import java.util.List;
import java.util.Map;

public interface AdminNoticeService {
    public List<Map<String, Object>> getNoticesList();
    public List<Map<String, Object>> searchNoticeInfo(String noticeContent, String adminName);
    public boolean noticeContentIsExist(String noticeContent);
    public int insertNoticeInfo(Notice notice);
    public int updateNoticeInfo(Notice notice);
    public int deleteNotice(Integer noticeId);
}
