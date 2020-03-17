package com.mwt.oes.service.impl;

import com.mwt.oes.dao.UserRotationImgMapper;
import com.mwt.oes.domain.UserRotationImg;
import com.mwt.oes.domain.UserRotationImgExample;
import com.mwt.oes.service.AdminRotationImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminRotationImgServiceImpl implements AdminRotationImgService {

    @Autowired
    UserRotationImgMapper userRotationImgMapper;

    @Override
    public List<Map<String, Object>> getRotationImgsList() {
        List<Map<String, Object>> resultList = new ArrayList<>();
        UserRotationImgExample userRotationImgExample = new UserRotationImgExample();
        userRotationImgExample.setOrderByClause("img_id asc");
        List<UserRotationImg> userRotationImgList = userRotationImgMapper.selectByExample(userRotationImgExample);
        for (UserRotationImg userRotationImg : userRotationImgList) {
            int index = userRotationImgList.indexOf(userRotationImg);
            Map<String, Object> map = new HashMap<>();
            map.put("id", index + 1);
            map.put("imgId", userRotationImg.getImgId());
            map.put("imgTitle", userRotationImg.getImgTitle());
            map.put("imgCreateTime", userRotationImg.getImgCreateTime());
            map.put("imgSrc", userRotationImg.getImgSrc());
            map.put("ano", userRotationImg.getAno());
            map.put("admName", userRotationImg.getAdmName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public List<Map<String, Object>> searchRotationImgsList(String imgTitle, String admName) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        UserRotationImgExample userRotationImgExample = new UserRotationImgExample();
        UserRotationImgExample.Criteria criteria = userRotationImgExample.createCriteria();
        if (!imgTitle.equals("undefined")) {
            criteria.andImgTitleLike("%" + imgTitle + "%");
        }
        if (!admName.equals("undefined")) {
            criteria.andAdmNameLike("%" + admName + "%");
        }
        userRotationImgExample.setOrderByClause("img_id asc");
        List<UserRotationImg> userRotationImgList = userRotationImgMapper.selectByExample(userRotationImgExample);
        for (UserRotationImg userRotationImg : userRotationImgList) {
            int index = userRotationImgList.indexOf(userRotationImg);
            Map<String, Object> map = new HashMap<>();
            map.put("id", index + 1);
            map.put("imgId", userRotationImg.getImgId());
            map.put("imgTitle", userRotationImg.getImgTitle());
            map.put("imgSrc", userRotationImg.getImgSrc());
            map.put("ano", userRotationImg.getAno());
            map.put("imgCreateTime", userRotationImg.getImgCreateTime());
            map.put("admName", userRotationImg.getAdmName());
            resultList.add(map);
        }
        return resultList;
    }

    @Override
    public int insertRotationImgInfo(UserRotationImg userRotationImg) {
        userRotationImg.setImgCreateTime(new Date());
        int result = userRotationImgMapper.insertSelective(userRotationImg);
        return result;
    }

    @Override
    public int updateRotationImgInfo(UserRotationImg userRotationImg) {
        int result = userRotationImgMapper.updateByPrimaryKeySelective(userRotationImg);
        return result;
    }

    @Override
    public int deleteRotationImgInfo(Integer imgId) {
        int result = userRotationImgMapper.deleteByPrimaryKey(imgId);
        return result;
    }
}
