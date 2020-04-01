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
    - studentPaperAnswer表中删除sno，重命名userPaperAnswer,会出现一堆错误，改不过来，先放着
    - 科举部分，使用UserExamController
    - 收藏题目，UserCollectingController
    
##3月17日
1. 整理代码
    - 轮播图用户/管理员，更名userRotationImg
    - 用户题型练习UserPractice
 ###idea
  - 判断题练习带时间
  
 ##3月18日
 1. 整理代码
    - 题型改isRecommend为en_name，根据enname前端在imgs中找到对应图标
    题型管理模块可能就不用了。
    
 ##3月21日
 1. 代码
   - 答题区分等级
 
 ##3月22日
 可以访问云服务器的接口数据了
 1. 问题
   - 服务器登录功能不可以了，不懂为什么
   - 使用swagger失败，api出不来，那就不用了吧
 2. 步骤
   - 打成jar包，放在/poem下
   
 ##3月23日
 1. 代码
  - 删除adminteacher管理
  - 公告管理完成
  - 留言管理，管理员端代码没有安装jquery
  
##3月24日
###idea
 - 意见回复功能，涉及webstock不知道还要不要做
 - 点字成诗题型，选择题
 
##3月31
- 密码md5加密，admin前端加密，user前后端加密
- 论坛完成
##4月1日
- 前端加了flexible，配了rem那个工具，大小总体调好了，但还是会左右摆，部署到服务器后，登录按钮没了，但打包出来的按钮还在
