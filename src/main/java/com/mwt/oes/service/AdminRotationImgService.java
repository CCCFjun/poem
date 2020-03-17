package com.mwt.oes.service;

import com.mwt.oes.domain.UserRotationImg;

import java.util.List;
import java.util.Map;

public interface AdminRotationImgService {
    public List<Map<String, Object>> getRotationImgsList();
    public List<Map<String, Object>> searchRotationImgsList(String imgTitle, String admName);
    public int insertRotationImgInfo(UserRotationImg userRotationImg);
    public int updateRotationImgInfo(UserRotationImg userRotationImg);
    public int deleteRotationImgInfo(Integer imgId);
}
