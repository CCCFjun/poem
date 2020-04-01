package com.mwt.oes.controller;

import com.mwt.oes.domain.QuestionType;
import com.mwt.oes.service.AdminBankManageService;
import com.mwt.oes.service.AdminPaperService;
import com.mwt.oes.service.AdminTypeService;
import com.mwt.oes.util.QiniuCloudUtil;
import com.mwt.oes.util.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class AdminBankManageController {
    @Autowired
    private AdminPaperService adminPaperService;
    @Autowired
    private AdminBankManageService adminBankManageService;
    @Autowired
    private AdminTypeService adminTypeService;

    //根据单判填选出题型
    @RequestMapping("/getLangOptionByType")
    public ServerResponse getLangOptionByType(@RequestParam("type")Integer type){
        List<QuestionType> resultList = adminTypeService.getLangOptionByType(type);
        return ServerResponse.createBySuccess("获取部分题型信息成功",resultList);
    }

    //    获取全部单选题信息
    @RequestMapping("/getSingleList")
    public ServerResponse getSingleList(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> singleList = adminBankManageService.getSingleList();
        map.put("singleList",singleList);
        List<Map<String, Object>> langOptions = adminPaperService.getLangOptions();
        map.put("langOptions",langOptions);
        return ServerResponse.createBySuccess("获取全部单选题信息成功",map);
    }

    //    获取搜索单选题信息
    @RequestMapping("/searchSingleList")
    public ServerResponse searchSingleList(@RequestParam("content")String content,
                                           @RequestParam("langId")Integer langId,
                                           @RequestParam("composeFlag")String composeFlag){
        List<Map<String, Object>> resultList = adminBankManageService.searchSingleList(content, langId, composeFlag);
        return ServerResponse.createBySuccess("获取搜索单选题信息成功",resultList);
    }

    //  删除单选题
    @RequestMapping(value = "/deleteSingle",method = RequestMethod.POST)
    public ServerResponse deleteSingle(@RequestBody Map<String, Object> obj){
        int singleId = (int) obj.get("singleId");
        int result = adminBankManageService.deleteSingle(singleId);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }

    // 上传题目配图
    @RequestMapping(value = "/uploadPicture",method = RequestMethod.POST)
    public ServerResponse uploadPicture(MultipartFile file){
        try {
            byte[] bytes = file.getBytes();
            String imageName = "programImages/" + UUID.randomUUID().toString();
            String url = "";

            try {
                //使用base64方式上传到七牛云
                url = QiniuCloudUtil.put64image(bytes, imageName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return ServerResponse.createBySuccess("文件上传成功",url);
        } catch (IOException e) {
            return ServerResponse.createByError("文件上传发生异常！");
        }
    }

    // 添加单选题题目
    @RequestMapping(value = "/insertSingleInfo",method = RequestMethod.POST)
    public ServerResponse insertSingleInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.insertSingleInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("添加成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，添加失败");
        }
    }

    // 更新单选题题目
    @RequestMapping(value = "/updateSingleInfo",method = RequestMethod.POST)
    public ServerResponse updateSingleInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.updateSingleInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("更新成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，更新失败");
        }
    }

    // 添加导入单选题Excel文件
    @RequestMapping(value = "/insertSingleList",method = RequestMethod.POST)
    public ServerResponse insertSingleList(@RequestBody Map<String, Object> obj){
        List<Map<String, Object>> singleList = (List<Map<String, Object>>) obj.get("singleList");
        int result = adminBankManageService.insertSingleList(singleList);
        return ServerResponse.createBySuccess("文件上传成功",result);
    }

    // ----------------------------------------------------------------------------------
    //    获取全部多选题信息
    @RequestMapping("/getMultipleList")
    public ServerResponse getMultipleList(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> multipleList = adminBankManageService.getMultipleList();
        map.put("multipleList",multipleList);
        List<Map<String, Object>> langOptions = adminPaperService.getLangOptions();
        map.put("langOptions",langOptions);
        return ServerResponse.createBySuccess("获取全部多选题信息成功",map);
    }

    //    获取搜索多选题信息
    @RequestMapping("/searchMultipleList")
    public ServerResponse searchMultipleList(@RequestParam("content")String content,
                                           @RequestParam("langId")Integer langId,
                                           @RequestParam("composeFlag")String composeFlag){
        List<Map<String, Object>> resultList = adminBankManageService.searchMultipleList(content, langId, composeFlag);
        return ServerResponse.createBySuccess("获取搜索多选题信息成功",resultList);
    }

    //  删除多选题
    @RequestMapping(value = "/deleteMultiple",method = RequestMethod.POST)
    public ServerResponse deleteMultiple(@RequestBody Map<String, Object> obj){
        int multipleId = (int) obj.get("multipleId");
        int result = adminBankManageService.deleteMultiple(multipleId);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }

    // 添加多选题题目
    @RequestMapping(value = "/insertMultipleInfo",method = RequestMethod.POST)
    public ServerResponse insertMultipleInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.insertMultipleInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("添加成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，添加失败");
        }
    }

    // 更新多选题题目
    @RequestMapping(value = "/updateMultipleInfo",method = RequestMethod.POST)
    public ServerResponse updateMultipleInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.updateMultipleInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("更新成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，更新失败");
        }
    }

    // 添加导入多选题Excel文件
    @RequestMapping(value = "/insertMultipleList",method = RequestMethod.POST)
    public ServerResponse insertMultipleList(@RequestBody Map<String, Object> obj){
        List<Map<String, Object>> multipleList = (List<Map<String, Object>>) obj.get("multipleList");
        int result = adminBankManageService.insertMultipleList(multipleList);
        return ServerResponse.createBySuccess("文件上传成功",result);
    }
    // ----------------------------------------------------------------------------------
    //    获取全部判断题信息
    @RequestMapping("/getJudgeList")
    public ServerResponse getJudgeList(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> judgeList = adminBankManageService.getJudgeList();
        map.put("judgeList",judgeList);
        List<Map<String, Object>> langOptions = adminPaperService.getLangOptions();
        map.put("langOptions",langOptions);
        return ServerResponse.createBySuccess("获取全部判断题信息成功",map);
    }

    //    获取搜索判断题信息
    @RequestMapping("/searchJudgeList")
    public ServerResponse searchJudgeList(@RequestParam("content")String content,
                                             @RequestParam("langId")Integer langId,
                                             @RequestParam("composeFlag")String composeFlag){
        List<Map<String, Object>> resultList = adminBankManageService.searchJudgeList(content, langId, composeFlag);
        return ServerResponse.createBySuccess("获取搜索判断题信息成功",resultList);
    }

    //  删除判断题
    @RequestMapping(value = "/deleteJudge",method = RequestMethod.POST)
    public ServerResponse deleteJudge(@RequestBody Map<String, Object> obj){
        int judgeId = (int) obj.get("judgeId");
        int result = adminBankManageService.deleteJudge(judgeId);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }

    // 添加判断题题目
    @RequestMapping(value = "/insertJudgeInfo",method = RequestMethod.POST)
    public ServerResponse insertJudgeInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.insertJudgeInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("添加成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，添加失败");
        }
    }

    // 更新判断题题目
    @RequestMapping(value = "/updateJudgeInfo",method = RequestMethod.POST)
    public ServerResponse updateJudgeInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.updateJudgeInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("更新成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，更新失败");
        }
    }
    // 添加导入判断题Excel文件
    @RequestMapping(value = "/insertJudgeList",method = RequestMethod.POST)
    public ServerResponse insertJudgeList(@RequestBody Map<String, Object> obj){
        List<Map<String, Object>> judgeList = (List<Map<String, Object>>) obj.get("judgeList");
        int result = adminBankManageService.insertJudgeList(judgeList);
        return ServerResponse.createBySuccess("文件上传成功",result);
    }
    // ----------------------------------------------------------------------------------
    //    获取全部填空题信息
    @RequestMapping("/getFillList")
    public ServerResponse getFillList(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> fillList = adminBankManageService.getFillList();
        map.put("fillList",fillList);
        List<Map<String, Object>> langOptions = adminPaperService.getLangOptions();
        map.put("langOptions",langOptions);
        return ServerResponse.createBySuccess("获取全部填空题信息成功",map);
    }

    //    获取搜索填空题信息
    @RequestMapping("/searchFillList")
    public ServerResponse searchFillList(@RequestParam("content")String content,
                                          @RequestParam("langId")Integer langId,
                                          @RequestParam("composeFlag")String composeFlag){
        List<Map<String, Object>> resultList = adminBankManageService.searchFillList(content, langId, composeFlag);
        return ServerResponse.createBySuccess("获取搜索填空题信息成功",resultList);
    }

    //  删除填空题
    @RequestMapping(value = "/deleteFill",method = RequestMethod.POST)
    public ServerResponse deleteFill(@RequestBody Map<String, Object> obj){
        int fillId = (int) obj.get("fillId");
        int result = adminBankManageService.deleteFill(fillId);
        if(result > 0){
            return ServerResponse.createBySuccess("删除成功",null);
        } else {
            return ServerResponse.createByError("数据库错误，删除失败");
        }
    }

    // 添加填空题题目
    @RequestMapping(value = "/insertFillInfo",method = RequestMethod.POST)
    public ServerResponse insertFillInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.insertFillInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("添加成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，添加失败");
        }
    }

    // 更新填空题题目
    @RequestMapping(value = "/updateFillInfo",method = RequestMethod.POST)
    public ServerResponse updateFillInfo(@RequestBody Map<String, Object> obj) {
        int result = adminBankManageService.updateFillInfo(obj);
        if (result > 0) {
            return ServerResponse.createBySuccess("更新成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，更新失败");
        }
    }
    // 添加导入填空题Excel文件
    @RequestMapping(value = "/inserFillList",method = RequestMethod.POST)
    public ServerResponse inserFillList(@RequestBody Map<String, Object> obj){
        List<Map<String, Object>> fillList = (List<Map<String, Object>>) obj.get("fillList");
        int result = adminBankManageService.inserFillList(fillList);
        return ServerResponse.createBySuccess("文件上传成功",result);
    }
}
