package com.mwt.oes.controller;

import com.mwt.oes.domain.QuestionType;
import com.mwt.oes.service.AdminTypeService;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminTypeController {
    @Autowired
    private AdminTypeService adminTypeService;

    //    获取全部题型信息
    @RequestMapping("/getTypesList")
    public ServerResponse getTypesList(){
        List<Map<String, Object>> resultList = adminTypeService.getTypesList();
        return ServerResponse.createBySuccess("获取全部题型信息成功",resultList);
    }

    //    获取搜索题型信息
//    @RequestMapping("/searchTypesList")
//    public ServerResponse searchTypesList(@RequestParam("langName")String langName,
//                                             @RequestParam("isRecommend")String isRecommend){
//        List<Map<String, Object>> resultList = adminTypeService.searchTypesList(langName, isRecommend);
//        return ServerResponse.createBySuccess("获取搜索题型信息成功",resultList);
//    }

    //    添加题型信息
    @RequestMapping(value = "/insertTypeInfo",method = RequestMethod.POST)
    public ServerResponse insertTypeInfo(@RequestBody(required = false) QuestionType questionType){
        int result = adminTypeService.insertTypeInfo(questionType);
        if (result > 0){
            return ServerResponse.createBySuccess("添加题型信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，添加题型信息失败");
        }
    }

    //    更新题型信息
    @RequestMapping(value = "/updateTypeInfo",method = RequestMethod.POST)
    public ServerResponse updateTypeInfo(@RequestBody(required = false) QuestionType questionType){
        int result = adminTypeService.updateTypeInfo(questionType);
        if (result > 0){
            return ServerResponse.createBySuccess("更新题型信息成功",null);
        }
        else {
            return ServerResponse.createByError("数据库错误，更新题型信息失败");
        }
    }

    //  删除题型信息
    @RequestMapping(value = "/deleteType",method = RequestMethod.POST)
    public ServerResponse deleteType(@RequestBody Map<String, Object> obj){
        Integer langId = (Integer) obj.get("langId");
        int result = adminTypeService.deleteType(langId);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }
}
