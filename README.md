# poem
诗词问答后端
##3月14日
###步骤
1. 整理代码并上传（删除原代码中没有用到的地方，保存到自己的库
    - 管理员后台部分，把教师端改为管理员端，登录部分已改

2. 成功连接阿里云数据库

3. 为了速度，平时还是连本地数据库即可
 

###idea  
 - 多选题模式，可以是“选出下列与李白有关的词语”题目类型，放在练习里，试卷里先不用
 - 前端轮播图，学海页面，题目类型列表左边是圆图，右边汉字介绍
 
 ##3月15日
 ###步骤
 1. 整理代码
     - programmLanguage更名为questionType，字段名没变，subject改为type
     - teacherSystemService删了
     
 2. 已测试完成
     - 题型管理模块  AdminType 
     - 用户管理模块  AdminUser
     - 轮播图管理模块AdminRotation
     - 试卷管理      AdminPaper
     - 题库管理AdminBankManage
     
 3. 计划
     - paper表里把langid删掉
     - 公告管理，teacherNoticeService也不要
     
##3月16日
###步骤
1. 整理代码
    - studentPaperAnswer表中删除sno，重命名userPaperAnswer
