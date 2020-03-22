package com.mwt.oes.controller;

import com.mwt.oes.service.AdminPaperService;
import com.mwt.oes.util.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
@Api(tags = {"管理员试卷管理Api文档"})
public class AdminPaperController {
    @Autowired
    private AdminPaperService adminPaperService;

    //    获取试卷列表信息
    @RequestMapping("/getAdminPapersList")
    @ApiOperation(value = "获取试卷列表信息")
    public ServerResponse getAdminPapersList(){
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> papersList = adminPaperService.getPapersList();
        map.put("papersList",papersList);
        return ServerResponse.createBySuccess("获取全部试卷信息成功",map);
    }

    //    获取搜索试卷列表信息
    @RequestMapping("/searchPapersList")
    public ServerResponse searchPapersList(@RequestParam("paperName")String paperName,
                                           @RequestParam("paperType")Integer paperType){
        List<Map<String, Object>> resultList = adminPaperService.searchPapersList(paperName, paperType);
        return ServerResponse.createBySuccess("获取搜索试卷信息成功",resultList);
    }

    //  删除选中试卷信息
    @RequestMapping(value = "/deletePaper",method = RequestMethod.POST)
    public ServerResponse deletePaper(@RequestBody Map<String, Object> obj){
        Integer paperId = (Integer) obj.get("paperId");
        int selectResult = adminPaperService.selectPaperScoreByPaperId(paperId);
        if(selectResult > 0) {
            return ServerResponse.createByError("该试卷已有学生参加考试，删除失败");
        } else {
            int deleteResult = adminPaperService.deletePaper(paperId);
            if(deleteResult > 0){
                return ServerResponse.createBySuccess("删除成功",null);
            } else {
                return ServerResponse.createByError("数据库错误，删除失败");
            }
        }
    }

    //  获取选中试卷问题详情
    @RequestMapping("/getPaperQueDetailByPaperId")
    public ServerResponse getPaperQueDetailByPaperId(@RequestParam("paperId")Integer paperId,
                                                     @RequestParam("totalNum")Integer totalNum){
        Map<String, Object> resultMap = adminPaperService.getPaperQueDetailByPaperId(paperId, totalNum);
        return ServerResponse.createBySuccess("获取选中试卷问题详情成功",resultMap);
    }

    //  请求随机组卷，插入试卷数据，即发布试卷
    @RequestMapping(value = "/randomInsertPaperInfo",method = RequestMethod.POST)
    public ServerResponse randomInsertPaperInfo(@RequestBody Map<String, Object> obj){
        int result = adminPaperService.randomInsertPaperInfo(obj);
        if (result >0) {
            return ServerResponse.createBySuccess("试卷发布成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，试卷发布失败");
        }
    }

    //  通过langId获取题型下的所有问题
    @RequestMapping("/getPaperQueDetailByLangId")
    public ServerResponse getPaperQueDetailByLangId(){
        Map<String, Object> resultMap = adminPaperService.getPaperQueDetailByLangId();
        return ServerResponse.createBySuccess("获取选中题型下所有问题成功",resultMap);
    }

    //  请求固定组卷，插入试卷数据，即发布试卷
    @RequestMapping(value = "/fixedInsertPaperInfo",method = RequestMethod.POST)
    public ServerResponse fixedInsertPaperInfo(@RequestBody Map<String, Object> obj){
        int result = adminPaperService.fixedInsertPaperInfo(obj);
        if (result >0) {
            return ServerResponse.createBySuccess("试卷发布成功",result);
        } else {
            return ServerResponse.createByError("数据库错误，试卷发布失败");
        }
    }
}
