/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 80015
Source Host           : 127.0.0.1:3306
Source Database       : exam4

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-03-14 15:51:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `ano` char(6) NOT NULL COMMENT '管理员号',
  `adm_psw` varchar(255) NOT NULL DEFAULT '123456' COMMENT '登录密码，默认为123456',
  `adm_name` varchar(255) NOT NULL COMMENT '管理员姓名',
  `adm_sex` varchar(255) NOT NULL DEFAULT '男' COMMENT '管理员性别',
  `adm_email` varchar(255) NOT NULL COMMENT '管理员邮箱',
  `adm_phone` char(11) DEFAULT NULL COMMENT '管理员手机号码',
  `adm_last_login_time` datetime DEFAULT NULL COMMENT '管理员最近登录时间',
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('100000', '123456', '小王', '男', '123456@qq.com', '13358452698', '2019-04-22 01:57:55');
INSERT INTO `admin` VALUES ('100001', '123456', '小李', '男', '123456@qq.com', '13358452695', null);
INSERT INTO `admin` VALUES ('123456', '123456', '小张', '男', '123456@qq.com', '13380544897', '2019-05-07 16:32:26');

-- ----------------------------
-- Table structure for bank_fill_que
-- ----------------------------
DROP TABLE IF EXISTS `bank_fill_que`;
CREATE TABLE `bank_fill_que` (
  `fill_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '填空题id',
  `fill_content` varchar(255) DEFAULT NULL COMMENT '填空题内容',
  `fill_answer` varchar(255) DEFAULT NULL COMMENT '填空题答案',
  `compose_flag` varchar(255) DEFAULT '0' COMMENT '是否被组成',
  `answer_explain` varchar(255) DEFAULT NULL COMMENT '题目解析',
  `lang_id` int(11) DEFAULT NULL COMMENT '该题所属编程语言',
  `fill_img_src` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fill_id`),
  KEY `fill_lang_id` (`lang_id`),
  CONSTRAINT `fill_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `que_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_fill_que
-- ----------------------------
INSERT INTO `bank_fill_que` VALUES ('35', '窗前明月光的上一句', '疑是地上霜', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('36', '举头望明月上一句', '低头思故乡', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('37', '白日依山尽下一句', '黄河入海流', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('38', '看图写诗句', '欲穷千里目', '1', null, '11', 'http://q6b41spn5.bkt.clouddn.com/2.png');
INSERT INTO `bank_fill_que` VALUES ('39', '看图写诗句', '一生一世一双人', '0', null, '11', 'http://q6b41spn5.bkt.clouddn.com/1.png');
INSERT INTO `bank_fill_que` VALUES ('41', '“清明时节雨纷纷”的下一句', '路上行人欲断魂', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('42', '“日暮汉宫传蜡烛”的下一句', '轻烟散入五侯家', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('43', '“罗浮山下四时春”的下一句', '卢橘杨梅次第新', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('44', '“日啖荔枝三百颗”的下一句', '不辞长作岭南人', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('45', '“采得百花成蜜后”的下一句', '为谁辛苦为谁甜', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('46', '”春眠不觉晓“的下一句。(孟浩然：《春晓》)', '处处闻啼鸟', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('47', '”报得三春晖“的上一句。(孟郊：《游子吟》)', '谁言寸草心', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('48', '“红豆生南国”的下一句。(王维：《相思》)', '春来发几枝', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('49', '”当春乃发生“的上一句。(杜甫：《春夜喜雨》)', '好雨知时节', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('50', '“春色满园关不住”的下一句。（叶绍翁：（《游园不值》）', '一枝红杏出墙来', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('51', '”城春草木深“的上一句。(杜甫：《春望》)', '国破山河在', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('52', '”力尽不知热“的下一句 。(白居易：《观刈麦》', '但惜夏日长', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('53', '_____________，春去夏犹清。(李商隐：《晚晴》)', '深居俯夹城', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('54', '首夏犹清和，_____________ 。(谢灵运：《游赤石进帆海》)', '芳草亦未歇', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('55', '_____________，开轩纳微凉。(杜甫：《夏夜叹》)', '仲夏苦夜短', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('56', '农夫方夏耘，_____________ 。(戴复古：《大热》)', '安坐吾敢食', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('57', '人皆苦炎热，_____________ 。(李昂：《夏日联句》)', '我爱夏日长', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('58', '_____________，新雨带秋岚。(岑参：《水亭送华阴王少府还县》)', '残云收夏暑', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('59', '明月不谙离恨苦，_____________  。——晏殊《鹊踏枝》', '斜光到晓穿朱户', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('60', '_____________，为伊消得人憔悴。－柳永《凤栖梧》', '衣带渐宽终不悔', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('61', '两情若是久长时，_____________。－秦观《鹊桥仙》', '又岂在朝朝暮暮', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('62', '_____________？此时此夜难为情。－李白《三五七言》', '相思相见知何日', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('63', '曾经沧海难为水，_____________ 。－元稹《离思五首其四》', '除却巫山不是云', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('64', '_____________，恨不相逢未嫁时。－张籍《节妇吟》', '还君明珠双泪垂', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('65', '落红不是无情物，_____________  。－龚自珍《己亥杂诗》', '化作春泥更护花', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('66', '_____________，为谁风露立中宵。－黄景仁《绮怀诗二首其一》', '似此星辰非昨夜', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('67', '直道相思了无益，_____________ 。－李商隐《无题六首其三》', '未妨惆怅是清狂', '0', null, '10', null);

-- ----------------------------
-- Table structure for bank_judge_que
-- ----------------------------
DROP TABLE IF EXISTS `bank_judge_que`;
CREATE TABLE `bank_judge_que` (
  `judge_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '判断题id',
  `judge_content` varchar(255) DEFAULT NULL COMMENT '判断题内容',
  `judge_answer` varchar(255) DEFAULT NULL COMMENT '判断题答案',
  `compose_flag` varchar(255) DEFAULT '0' COMMENT '是否被组成试卷',
  `answer_explain` varchar(255) DEFAULT NULL COMMENT '题目解析',
  `lang_id` int(11) DEFAULT NULL COMMENT '该题所属编程语言',
  PRIMARY KEY (`judge_id`),
  KEY `judge_lang_id` (`lang_id`),
  CONSTRAINT `judge_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `que_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_judge_que
-- ----------------------------
INSERT INTO `bank_judge_que` VALUES ('25', '“过尽千帆皆不是”是韦庄的词句。', 'F', '1', '是温庭筠的《望江南·梳洗罢》', '13');
INSERT INTO `bank_judge_que` VALUES ('26', '《花间集》里边的第一首歌词是《菩萨蛮》。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('27', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', null, '13');

-- ----------------------------
-- Table structure for bank_multiple_choice_que
-- ----------------------------
DROP TABLE IF EXISTS `bank_multiple_choice_que`;
CREATE TABLE `bank_multiple_choice_que` (
  `multiple_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '多选题id',
  `multiple_content` varchar(255) DEFAULT NULL COMMENT '多选题内容',
  `choice_A` varchar(255) DEFAULT NULL COMMENT '选项A',
  `choice_B` varchar(255) DEFAULT NULL COMMENT '选项B',
  `choice_C` varchar(255) DEFAULT NULL COMMENT '选项C',
  `choice_D` varchar(255) DEFAULT NULL COMMENT '选项D',
  `choice_E` varchar(255) DEFAULT NULL COMMENT '选项E',
  `choice_F` varchar(255) DEFAULT NULL COMMENT '选项F',
  `choice_G` varchar(255) DEFAULT NULL COMMENT '选项G',
  `multiple_answer` varchar(255) DEFAULT NULL COMMENT '多选题答案',
  `compose_flag` varchar(255) DEFAULT '0' COMMENT '是否被组成试卷',
  `answer_explain` varchar(255) DEFAULT NULL COMMENT '题目解析',
  `lang_id` int(11) DEFAULT NULL COMMENT '该题所属编程语言',
  PRIMARY KEY (`multiple_id`),
  KEY `multiple_lang_id` (`lang_id`),
  CONSTRAINT `multiple_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `que_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_multiple_choice_que
-- ----------------------------
INSERT INTO `bank_multiple_choice_que` VALUES ('1', '下面说法错误的是（）？[[[31b23b75-6de2-4aef-9c1b-1873ecf45b79]]]', 'A:能被java.exe成功运行的java class文件必须有mian（）方法。', 'B:J2SDK就是Java API。', 'C:Appletviewer.exe可利用jar选项运行.jar文件。', 'D:能被Appletviewer成功运行的java class文件必须有main方法。', 'E:Collection属于MVC模式中的对象。', '', null, 'BCDE', '1', 'A：main是主函数，是程序执行的起始点。没有main函数会报错不能编译执行。B：J2SDK是java开发环境包，包括了JDK（开发工具包）和JRE（运行环境包）。而API是Application Programming Interface，是应用程序编程接口，两者不是一个东西。C：这个楼楼真的没搞懂，欢迎懂得大佬来踢馆。D：Applet只要继承Applet类就行了,不需要main()方法。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('2', '下面说法正确的是（）？', 'A:环境变量可在编译source code（源编译）时指定。', 'B:在编译程序时，所能指定的环境变量不包括classpath。', 'C:javac一次可同时编译数个Java源文件。', 'D:javac.exe能指定编译结果要置于哪个directory（目录）。', 'E:与HttpSessionListener接口有关的方法是sessionInitialized()。', null, null, 'BCD', '1', 'A：环境变量不能再源编译的时候指定的，它的配置一般都是在系统环境变量中。B：错误，可以设置classpath。C：这个不知道怎么讲，我只知道可以。 D：可以，在CDM中就能进行相应的操作。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('3', '下面说法错误的是（）？', 'A:数组是一种对象。', 'B:数组属于一种原生类。', 'C:int number=[]={31,23,33,43,35,63}。', 'D:数组的大小可以任意改变。', 'E:可以在声明数组的同时进行初始化，也可以在声明以后进行初始化。', 'F:可以通过下标来引用数组。', null, 'BCD', '1', 'A：数组是一个对象，其内存分配在堆内。基本类型内存分配在栈内。 B：所谓的原生类，也称基本数据类型或内置对象。显然数组属于引用数据类型。 C：写法错误。D：数组的定义是：相同类型，固定长度的一组数据，一旦被初始化，长度不可更改。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('4', '不能用来修饰interface的有（）？', 'A:private', 'B:public', 'C:protected', 'D:static', null, null, null, 'ACD', '1', 'A：接口是为了让别人实现的，你私有化了，就和自身作用其冲突，所以错误。B：正确。C：接口为的是实现，所以你修饰protected了，别的类就无法实现了，错误。 D：interface是一个接口，也就是说它的方法全部都为空，只有方法名，没有方法体，如果定义成static，那么就能直接调用类来调用抽象方法，没有意义。故而规定interface不能用static修饰。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('5', '下列正确的有（）？', 'A:call by value（值调用）不会改变实际参数的数值。', 'B:call by reference（引用调用）能改变实际参数的参考地址。', 'C:call by reference（引用调用）不能改变实际参数的参考地址。', 'D:call by reference（引用调用）能改变实际参数的内容。', 'E:XML 是一种元语言, 可以用它来描述其他语言。', 'F:类图用来表示系统中类和类与类之间的关系，它是对系统动态结构的描述。', 'G:context为JSP的隐含对象。', 'ACD', '1', 'A：因为在java中，值调用的形参是实参的一个拷贝体。B：正确。C：引用调用，传递的是对象的地址，也就是说你改变的只能是形参对象。 D：引用调用，不能改变实参的参考地址，却能改变实参的属性（内容）。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('6', '下列说法错误的有（）？', 'A:在类方法中可用this来调用本类的类方法。', 'B:在类方法中调用本类的类方法时可直接调用。', 'C:在类方法中只能调用本类中的类方法。', 'D:在类方法中绝对不能调用实例方法。', 'E:在类方法中可使用本类声明的私有变量。', null, null, 'ACD', '1', 'A：所谓的类方法就是静态方法，super和this都指向的是父类和本类的对象，而在类方法中调用的时候，这些指代的对象有可能都还没有创建。静态方法是用类方法名.方法名称调用。 B：正确。C：错误，类方法可以调用其他类的类方法。D：错误，实例化对象，然后调用方法。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('7', '下列说法错误的有（）？', 'A:Java面向对象语言容许单独的过程与函数存在。', 'B:Java面向对象语言容许单独的方法存在。', 'C:Java语言中的方法属于类中的成员。', 'D:Java语言中的方法必定隶属于某一类（对象），调用方法与过程或函数相同。', null, null, null, 'ABC', '1', 'A：错误，java是面向对象编程语言。B：错误，java是面向对象编程的语言。C：错误，类方法属于类中的成员，实例方法属于对象中的成员。D：正确。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('8', '下列属于J2EE的体系是()', 'A:JSP', 'B:JAVA', 'C:Servlet', 'D:WebService', null, null, null, 'AC', '1', 'J2EE的核心技术包括：JDBC(Java Database Connectivity) JNDI(Java Name and Directory Interface)', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('9', '下列函数是public void method(){...}的重载函数有（）？', 'A:public void method(int m){...}', 'B:public int method(){...}', 'C:public void method2(){...}', 'D:public int method(int m,float f){...}', null, null, null, 'AD', '1', '重载函数要求函数必须同名，必须参数数量或者参数类型不同，与修饰符和返回值无关。', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('10', '执行下列代码后，哪个结论是错误的String[] s =new String[10];（）？', 'A:s[10]为\"\";', 'B:s[9]为null;', 'C:s[0]为未定义;', 'D:s.length()=10;', null, null, null, 'ACD', '1', null, '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('17', '测试导入多选题1[[[62bb69e2-ca56-4ee6-aaf3-88fffaacbdb5]]]', 'A:测试A', 'B:测试B', 'C:测试C', 'D:测试D', 'E:测试E', 'F:测试F', null, 'ABCDEF', '0', '测试多选题答案解析1', '1');
INSERT INTO `bank_multiple_choice_que` VALUES ('18', '测试导入多选题2', 'A:测试A', 'B:测试B', 'C:测试C', 'D:测试D', 'E:测试E', null, 'G:测试G', 'BCDG', '0', '测试多选题答案解析2', '2');
INSERT INTO `bank_multiple_choice_que` VALUES ('19', '测试手动添加多选题[[[056ae06e-c54f-4839-acdf-7d56cccbe769]]]', 'A:答案A', 'B:答案B', 'C:答案C', 'D:答案D', 'E:答案E', 'F:答案F', '', 'ACDEF', '0', '测试手动添加多选题答案解析', '2');

-- ----------------------------
-- Table structure for bank_single_choice_que
-- ----------------------------
DROP TABLE IF EXISTS `bank_single_choice_que`;
CREATE TABLE `bank_single_choice_que` (
  `single_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单选题id',
  `single_content` varchar(255) DEFAULT NULL COMMENT '单选题内容',
  `choice_A` varchar(255) DEFAULT NULL COMMENT '选项A',
  `choice_B` varchar(255) DEFAULT NULL COMMENT '选项B',
  `choice_C` varchar(255) DEFAULT NULL COMMENT '选项C',
  `choice_D` varchar(255) DEFAULT NULL COMMENT '选项D',
  `choice_E` varchar(255) DEFAULT NULL COMMENT '选项E',
  `choice_F` varchar(255) DEFAULT NULL COMMENT '选项F',
  `choice_G` varchar(255) DEFAULT NULL COMMENT '选项G',
  `single_answer` varchar(255) DEFAULT NULL COMMENT '单选题答案',
  `compose_flag` varchar(255) DEFAULT '0' COMMENT '是否被组成试卷',
  `answer_explain` varchar(255) DEFAULT NULL COMMENT '题目解析',
  `lang_id` int(11) DEFAULT NULL COMMENT '该题所属编程语言',
  PRIMARY KEY (`single_id`),
  KEY `single_lang_id` (`lang_id`),
  CONSTRAINT `single_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `que_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_single_choice_que
-- ----------------------------
INSERT INTO `bank_single_choice_que` VALUES ('39', '\"拱手而立\"表示对长者的尊敬，一般来说，男子行拱手礼时应该：', 'A、左手在外', 'B、右手在外', null, null, null, null, null, 'A', '1', '解析测试测试测试测试测试测试测试测试', '12');
INSERT INTO `bank_single_choice_que` VALUES ('40', '《三十六计》是体现我国古代卓越军事思想的一部兵书，下列不属于《三十六计》的是：', 'A、浑水摸鱼', 'B、反戈一击', 'C、笑里藏刀', 'D、反客为主', null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('41', '“但使龙城飞将在，不教胡马度阴山”中的“飞将”指像（  ）那样的将士。', 'A、张飞', 'B、李广', 'C、霍去病', 'D、岳飞', null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('42', '形容月亮的诗甚多，下列那一句与月亮无关？', 'A、团团冰镜吐清辉', 'B、玉蝉离海上', 'C、大珠小珠落玉盘', null, null, null, null, 'C', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('43', '“字字看来都是血，十年辛苦不寻常”是下列哪位名家对自己作品的“自评诗”？', 'A、施耐庵《水浒传》', 'B、吴承恩《西游记》', 'C、曹雪芹《红楼梦》', null, null, null, null, 'C', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('44', '诗经的《硕鼠硕鼠，无食我黍》诗中“黍”指的是那种农作物？', 'A、高粱', 'B、黄米', 'C、谷子', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('45', '杜甫《春夜喜雨》“晓看红湿处，花重锦官城”锦官城是指如今的何处？', 'A、成都', 'B、重庆', 'C、洛阳', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('46', '“不为五斗米折腰”源于对我国哪位诗人高尚气节的评价？', 'A、李白', 'B、陶渊明', 'C、苏轼', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('49', '“昔年有狂客，号尔谪仙人”，诗中“谪仙人”指哪位诗人：', 'A、李白', 'B、杜甫', 'C、苏轼', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('50', '杜甫笔下“功盖三分国，名成八阵图”是赞扬哪位历史人物：', 'A、汉武帝', 'B、诸葛亮', 'C、刘邦', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('51', '下列哪句不是描写西湖美景？', 'A、接天莲叶无穷碧，映日荷花别样红', 'B、水光潋滟晴方好，山色空濛雨亦奇', 'C、湖光秋月两相和，潭面无风镜未磨', null, null, null, null, 'C', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('52', '《凤求凰》演绎的是哪一对情侣的爱情故事？', 'A、李清照和赵明诚', 'B、卓文君和司马相如', 'C、范蠡和西施', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('53', '“小蛮腰”的说法出自哪位文学家？', 'A、晏几道', 'B、白居易', 'C、温庭筠', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('54', '李白曾说“眼前有景道不得，崔郎题诗在上头”的诗是哪一首？', 'A、《登鹳雀楼》', 'B、《登黄鹤楼》', 'C、《登金陵凤凰台》', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('55', '下列哪位诗人凭借哪首诗，赢得了“以孤篇压倒全唐”的美誉？', 'A、陈子昂《登幽州台歌》', 'B、张若虚《春江花月夜》', 'C、杨炯《从军行》', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('56', '“十五好剑术，遍干诸侯。三十成文章，历抵卿相。”指的是哪位诗人？', 'A、辛弃疾', 'B、李白', 'C、王昌龄', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('57', '唐代哪位诗人留存的诗作最多？', 'A、白居易', 'B、李白', 'C、杜甫', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('58', '高适《别董大》，董大的职业是', 'A、琴师', 'B、词人', 'C、厨师', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('59', '《敕勒歌》是由当时哪种语言翻译成汉语的', 'A、鲜卑语', 'B、蒙古语', 'C、维吾尔语', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('60', '诗经《蒹葭》，蒹葭指的是哪一种植物', 'A、芦苇', 'B、莞荽', 'C、水仙', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('61', '诗经《木瓜》“报之以琼琚”，琼琚指的是', 'A、美女', 'B、美食', 'C、美玉', null, null, null, null, 'C', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('62', '“春宵一刻值千金”出自宋代哪位名人之手', 'A、柳永', 'B、苏轼', 'C、李煜', null, null, null, null, 'B', '0', null, '12');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `paper_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `paper_name` varchar(255) DEFAULT NULL COMMENT '试卷名称',
  `paper_create_time` datetime DEFAULT NULL COMMENT '试卷创建时间',
  `paper_duration` int(11) DEFAULT NULL COMMENT '考试时长，单位秒',
  `paper_difficulty` int(11) DEFAULT NULL COMMENT '试卷难度',
  `paper_attention` varchar(255) DEFAULT NULL COMMENT '考试注意事项',
  `paper_type` int(11) DEFAULT NULL COMMENT '组卷机制，1为随机，2为固定',
  `single_score` int(11) DEFAULT NULL COMMENT '单选题分配分数',
  `multiple_score` int(11) DEFAULT NULL COMMENT '多选题分配分数',
  `judge_score` int(11) DEFAULT NULL COMMENT '判断题分配分数',
  `fill_score` int(11) DEFAULT NULL COMMENT '填空题分配分数',
  `lang_id` int(11) DEFAULT NULL COMMENT '试卷所属编程语言',
  `participate_num` int(11) DEFAULT '0' COMMENT '已参加人数',
  `paper_img_src` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('12', '哈哈哈哈哈', '2020-03-04 10:33:55', '6000', '4', '', '2', '1', null, '1', '1', null, '39', 'http://q6b41spn5.bkt.clouddn.com/3.png');
INSERT INTO `paper` VALUES ('13', '啊啊啊啊啊啊啊啊', '2020-03-04 10:52:29', '600', '5', '', '1', '1', null, '1', '1', null, '1', 'http://q6b41spn5.bkt.clouddn.com/2.png');
INSERT INTO `paper` VALUES ('14', '第一期诗词大会', '2020-03-12 16:26:52', '1800', '5', '', '1', '1', null, '1', '1', null, '0', null);

-- ----------------------------
-- Table structure for paper_que
-- ----------------------------
DROP TABLE IF EXISTS `paper_que`;
CREATE TABLE `paper_que` (
  `que_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `que_type` int(11) DEFAULT NULL COMMENT '题类型',
  `single_id` int(11) DEFAULT NULL COMMENT '单选题id',
  `multiple_id` int(11) DEFAULT NULL COMMENT '多选题id',
  `judge_id` int(11) DEFAULT NULL COMMENT '判断题id',
  `fill_id` int(11) DEFAULT NULL COMMENT '填空题id',
  `paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  PRIMARY KEY (`que_id`),
  KEY `que_single_id` (`single_id`),
  KEY `que_multiple_id` (`multiple_id`),
  KEY `que_judge_id` (`judge_id`),
  KEY `que_fill_id` (`fill_id`),
  KEY `que_paper_id` (`paper_id`),
  CONSTRAINT `que_fill_id` FOREIGN KEY (`fill_id`) REFERENCES `bank_fill_que` (`fill_id`),
  CONSTRAINT `que_judge_id` FOREIGN KEY (`judge_id`) REFERENCES `bank_judge_que` (`judge_id`),
  CONSTRAINT `que_multiple_id` FOREIGN KEY (`multiple_id`) REFERENCES `bank_multiple_choice_que` (`multiple_id`),
  CONSTRAINT `que_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `que_single_id` FOREIGN KEY (`single_id`) REFERENCES `bank_single_choice_que` (`single_id`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper_que
-- ----------------------------
INSERT INTO `paper_que` VALUES ('162', '1', '39', null, null, null, '12');
INSERT INTO `paper_que` VALUES ('163', '1', '40', null, null, null, '12');
INSERT INTO `paper_que` VALUES ('164', '1', '41', null, null, null, '12');
INSERT INTO `paper_que` VALUES ('165', '2', null, null, '25', null, '12');
INSERT INTO `paper_que` VALUES ('166', '2', null, null, '26', null, '12');
INSERT INTO `paper_que` VALUES ('167', '2', null, null, '27', null, '12');
INSERT INTO `paper_que` VALUES ('168', '3', null, null, null, '35', '12');
INSERT INTO `paper_que` VALUES ('169', '3', null, null, null, '36', '12');
INSERT INTO `paper_que` VALUES ('170', '3', null, null, null, '37', '12');
INSERT INTO `paper_que` VALUES ('171', '4', null, null, null, '38', '12');
INSERT INTO `paper_que` VALUES ('177', '1', '39', null, null, null, '13');
INSERT INTO `paper_que` VALUES ('178', '2', null, null, '25', null, '13');
INSERT INTO `paper_que` VALUES ('179', '3', null, null, null, '35', '13');
INSERT INTO `paper_que` VALUES ('180', '4', null, null, null, '38', '13');
INSERT INTO `paper_que` VALUES ('181', '1', '39', null, null, null, '14');
INSERT INTO `paper_que` VALUES ('182', '1', '40', null, null, null, '14');
INSERT INTO `paper_que` VALUES ('183', '1', '41', null, null, null, '14');
INSERT INTO `paper_que` VALUES ('184', '2', null, null, '25', null, '14');
INSERT INTO `paper_que` VALUES ('185', '2', null, null, '26', null, '14');
INSERT INTO `paper_que` VALUES ('186', '3', null, null, null, '35', '14');
INSERT INTO `paper_que` VALUES ('187', '3', null, null, null, '36', '14');
INSERT INTO `paper_que` VALUES ('188', '4', null, null, null, '38', '14');

-- ----------------------------
-- Table structure for que_type
-- ----------------------------
DROP TABLE IF EXISTS `que_type`;
CREATE TABLE `que_type` (
  `lang_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编程语言id',
  `lang_name` varchar(255) DEFAULT NULL COMMENT '编程语言名称',
  `lang_desc` varchar(255) DEFAULT NULL COMMENT '编程语言描述',
  `lang_img_src` varchar(255) DEFAULT NULL COMMENT '编程语言图标',
  `lang_create_time` datetime DEFAULT NULL COMMENT '编程语言创建时间',
  `lang_created_by` varchar(255) DEFAULT NULL COMMENT '编程语言被创建者',
  `lang_change_time` datetime DEFAULT NULL COMMENT '编程语言最近修改时间',
  `lang_last_changer` varchar(255) DEFAULT NULL COMMENT '编程语言最近被修改者',
  `is_recommend` varchar(255) DEFAULT '0' COMMENT '是否在学生首页显示推荐，默认为0不推荐，1为推荐',
  PRIMARY KEY (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of que_type
-- ----------------------------
INSERT INTO `que_type` VALUES ('10', '承上启下', '写出题目诗句的上句或下句', 'http://q6b41spn5.bkt.clouddn.com/1.png', '2020-03-04 10:06:23', null, null, null, '1');
INSERT INTO `que_type` VALUES ('11', '画中有话', '填空题', 'http://q6b41spn5.bkt.clouddn.com/2.png', '2020-03-04 10:07:08', null, null, null, '1');
INSERT INTO `que_type` VALUES ('12', '百里挑一', '选择', 'http://q6b41spn5.bkt.clouddn.com/1.png', null, null, null, null, '0');
INSERT INTO `que_type` VALUES ('13', '分秒必争', '判断', 'http://q6b41spn5.bkt.clouddn.com/programImages/1ae9b16d-dc97-4059-9ff8-e29d441e0d46', null, null, '2020-03-13 16:25:25', null, '0');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` char(12) NOT NULL COMMENT '主键，学生学号',
  `stu_psw` varchar(255) NOT NULL DEFAULT '123456' COMMENT '登录密码，默认为123456',
  `stu_name` varchar(255) NOT NULL COMMENT '学生姓名',
  `stu_img_src` varchar(255) DEFAULT NULL COMMENT '头像链接',
  `stu_sex` varchar(255) NOT NULL DEFAULT '男' COMMENT '学生性别',
  `stu_email` varchar(255) DEFAULT NULL COMMENT '学生邮箱',
  `stu_phone` char(11) DEFAULT NULL COMMENT '学生手机号码',
  `stu_create_time` datetime NOT NULL COMMENT '学生注册时间',
  `stu_last_login_time` datetime DEFAULT NULL COMMENT '学生最近登录时间',
  `stu_status` char(1) NOT NULL DEFAULT '1' COMMENT '学生登录状态',
  `stu_security_code` varchar(255) NOT NULL DEFAULT '123456' COMMENT '安全码用于密码找回',
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201511314001', '123456', '小四', null, '男', '1234@qq.com', '13458956478', '2019-04-28 01:20:39', null, '1', '123456');
INSERT INTO `student` VALUES ('201511314002', '123456', '小五', null, '男', '1234@qq.com', '13458956478', '2019-04-28 01:21:10', null, '1', '123456');
INSERT INTO `student` VALUES ('201511314003', '123456', '小刘', null, '男', '12345@qq.com', '13565895641', '2019-04-28 01:21:45', '2019-04-28 01:21:47', '1', '123456');
INSERT INTO `student` VALUES ('201511314301', '123456', '小三', 'http://qiniu.maweitao.top/profiles/c721b496-fb54-4fc0-96a8-4a5095584bfd', '男', '123456789@qq.com', '13526459823', '2019-04-28 00:46:29', '2019-04-28 00:47:27', '1', '123456');
INSERT INTO `student` VALUES ('201511314321', '123456', '小马', 'http://qiniu.maweitao.top/profiles/e52b0c14-afe5-46dd-8433-01aa5a667753', '男', '1234567@qq.com', '13658952365', '2019-04-28 00:57:25', '2019-04-28 00:57:28', '1', '123456');
INSERT INTO `student` VALUES ('201521314301', '123456', '谢永宁', 'http://qiniu.maweitao.top/profiles/e67db9be-0faa-4118-abe5-d618f2561108', '男', '123456@qq.com', '13254896548', '2019-03-10 20:15:37', '2019-04-28 01:44:43', '1', '123456');
INSERT INTO `student` VALUES ('201521314302', '123456', '李四', 'http://qiniu.maweitao.top/profiles/bca36eb8-118a-4f16-9e51-e2f8bfa16e5c', '男', '123456@qq.com', '13625498549', '2019-03-11 18:37:18', '2019-04-15 20:16:00', '0', '123456');
INSERT INTO `student` VALUES ('201521314303', '123456', '马瑞欣', 'http://qiniu.maweitao.top/profiles/00b54bf8-dbfe-4952-80b7-045e42e8b11d', '女', '123456@qq.com', '13625894562', '2019-03-31 21:19:19', '2019-04-15 20:17:15', '1', '123456');
INSERT INTO `student` VALUES ('201521314304', '123456', '阿水', 'http://qiniu.maweitao.top/profiles/fd5fb96d-bd08-499f-9092-75699fba9adf', '男', '123456@qq.com', '13652485962', '2019-03-31 22:48:05', '2019-04-15 20:17:35', '0', '123456');
INSERT INTO `student` VALUES ('201521314305', '123456', '马导', 'http://qiniu.maweitao.top/profiles/30db92f7-6fef-401d-b756-765a21e31a2b', '女', '123456@qq.com', '13452685942', '2019-03-31 22:59:39', '2019-04-15 20:18:05', '1', '123456');
INSERT INTO `student` VALUES ('201521314310', '123456', '叶国冲', 'http://qiniu.maweitao.top/profiles/eadb0262-e703-4d66-a3ce-27ce5874a12b', '男', '1234567@qq.com', '13754695862', '2019-03-11 01:10:22', '2019-04-15 20:18:14', '1', '123456');
INSERT INTO `student` VALUES ('201521314316', '123456', '汤梓豪', 'http://qiniu.maweitao.top/profiles/1f987c0f-9af5-46c8-bc8f-1129abb13b22', '男', '123456@qq.com', '13225849856', '2019-03-03 18:59:47', '2019-04-15 20:18:29', '1', '123456');
INSERT INTO `student` VALUES ('201521314318', '123456', '张家豪', 'http://qiniu.maweitao.top/profiles/318dc134-5261-4bac-bde6-e7ea67c7dc53', '男', '123456@qq.com', '13632289756', '2019-03-10 20:10:30', '2019-04-15 20:19:25', '1', '123456');
INSERT INTO `student` VALUES ('201521314319', '123456', '罗建宏', 'http://qiniu.maweitao.top/profiles/9ed8e71c-d67f-4e80-8054-3172e124f41e', '男', '123456@qq.com', '13545687959', '2019-03-10 20:12:14', '2019-04-15 20:20:19', '1', '123456');
INSERT INTO `student` VALUES ('201521314321', '123456', '马伟涛', 'http://qiniu.maweitao.top/profiles/59665a0e-4387-45c9-91c3-0b307c7f0951', '男', '815699563@qq.com', '13602890590', '2019-03-01 18:35:26', '2019-05-07 16:31:01', '1', '123456');
INSERT INTO `student` VALUES ('201521314322', '123456', '杨铎', 'http://qiniu.maweitao.top/profiles/26a86525-916e-429f-afc6-e34450c66316', '男', '123456@qq.com', '13225849856', '2019-03-03 18:25:42', '2019-04-15 20:20:33', '1', '123456');
INSERT INTO `student` VALUES ('201521314323', '123456', '陈国', 'http://qiniu.maweitao.top/profiles/b3d029f1-0237-4595-bdf4-12e8f00cf1d9', '男', '123456@136.com', '15524752689', '2019-03-03 17:20:56', '2019-04-15 20:20:48', '1', '123456');
INSERT INTO `student` VALUES ('201521314330', '123456', '魏伟康', 'http://qiniu.maweitao.top/profiles/560662e3-d83f-43d0-bbcc-d3b830ad5d68', '男', '12345678@qq.com', '18054687965', '2019-03-10 20:17:37', '2019-04-15 20:21:27', '1', '123456');
INSERT INTO `student` VALUES ('201521314332', '123456', '陈荣涛', 'http://qiniu.maweitao.top/profiles/5d1435fb-ca6f-4a20-91bc-f6e79535a45b', '男', '123456@qq.com', '13456987532', '2019-03-10 20:20:32', '2019-04-15 20:22:01', '1', '123456');
INSERT INTO `student` VALUES ('201521314501', '123456', '小明', 'http://qiniu.maweitao.top/profiles/6431fa5d-9307-49f4-93fe-835866d50cca', '男', '123456@qq.com', '13625248596', '2019-04-08 03:32:29', '2019-04-15 20:22:45', '1', '123456');
INSERT INTO `student` VALUES ('201521314502', '123456', '小红', 'http://qiniu.maweitao.top/profiles/20a95a11-7af6-4e9f-ae52-1e0c068ed361', '女', '123456@qq.com', '13456258956', '2019-04-08 03:33:00', '2019-04-15 20:22:59', '1', '123456');
INSERT INTO `student` VALUES ('201521314503', '123456', '小黄', 'http://qiniu.maweitao.top/profiles/1cbc7613-0646-4d37-99e7-dbd5a10890d9', '男', '123456@qq.com', '13456258958', '2019-04-08 03:33:20', '2019-04-15 20:23:15', '1', '123456');
INSERT INTO `student` VALUES ('201521314505', '123456', '小飞', 'http://qiniu.maweitao.top/profiles/c34d8251-a0d7-4f67-a4fd-57719e5548dd', '男', '123456@qq.com', '13895487596', '2019-04-08 03:33:50', '2019-04-15 20:23:38', '1', '123456');
INSERT INTO `student` VALUES ('201521314506', '123456', '小亮', 'http://qiniu.maweitao.top/profiles/a4de68f1-adae-4087-a670-a0b5bce14a05', '男', '123456@qq.com', '13895487599', '2019-04-08 03:34:21', '2019-04-15 20:24:03', '1', '123456');
INSERT INTO `student` VALUES ('201521314507', '123456', '红苹果', 'http://qiniu.maweitao.top/profiles/23026bbc-2e85-4c14-ad8d-8d70094bea56', '女', '123456@qq.com', '13895487545', '2019-04-08 03:34:35', '2019-04-15 20:24:19', '1', '123456');
INSERT INTO `student` VALUES ('201521314508', '123456', '小敏', 'http://qiniu.maweitao.top/profiles/d6511ad5-ece1-43aa-ad69-c385dbe51104', '女', '123456@qq.com', '13895487548', '2019-04-08 03:34:46', '2019-04-15 20:24:33', '1', '123456');
INSERT INTO `student` VALUES ('201521314610', '123456', '飘雪国', 'http://qiniu.maweitao.top/profiles/007f6b62-5af8-4067-924c-ac9c0fe4f24a', '男', '123456@qq.com', '13526489523', '2019-04-08 03:48:40', '2019-04-15 20:24:54', '1', '123456');
INSERT INTO `student` VALUES ('201521314700', '123456', '咸蛋超人', 'http://qiniu.maweitao.top/profiles/9159e950-c550-4594-b15d-e33018eb70b5', '男', '8954233@qq.com', '18952484562', '2019-04-08 15:42:49', '2019-04-15 20:25:09', '1', '123456');
INSERT INTO `student` VALUES ('201521314701', '123456', '泽泽', 'http://qiniu.maweitao.top/profiles/407594a5-b296-4a48-b60b-63985b574218', '男', '123456@qq.com', '13526458952', '2019-04-08 15:44:36', '2019-04-15 20:25:22', '1', '123456');
INSERT INTO `student` VALUES ('201521314900', '123456', '张阿三', null, '男', null, null, '2019-04-16 22:40:19', '2019-04-28 01:45:49', '1', '123456');
INSERT INTO `student` VALUES ('201521314901', '123456', '张小红', null, '女', null, null, '2019-04-16 22:40:19', null, '1', '123456');
INSERT INTO `student` VALUES ('201521314902', '123456', '李阿四', null, '男', null, null, '2019-04-16 22:40:19', null, '1', '123456');

-- ----------------------------
-- Table structure for student_feedback
-- ----------------------------
DROP TABLE IF EXISTS `student_feedback`;
CREATE TABLE `student_feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `feedback_content` varchar(255) NOT NULL COMMENT '反馈内容',
  `feedback_create_time` datetime NOT NULL COMMENT '反馈创建时间',
  `sno` char(12) NOT NULL COMMENT '学号',
  `stu_name` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `adm_answer` varchar(255) DEFAULT NULL COMMENT '管理员回复',
  `ano` char(6) DEFAULT NULL COMMENT '管理员号',
  `adm_name` varchar(255) DEFAULT NULL COMMENT '管理员姓名',
  `feedback_status` char(1) DEFAULT '0' COMMENT '留言状态0为管理员未读，1为管理员已读学生未读，2为学生已读',
  `reply_time` datetime DEFAULT NULL COMMENT '管理员回复时间',
  PRIMARY KEY (`feedback_id`),
  KEY `feedback_sno` (`sno`),
  KEY `feedback_ano` (`ano`),
  CONSTRAINT `feedback_ano` FOREIGN KEY (`ano`) REFERENCES `admin` (`ano`),
  CONSTRAINT `feedback_sno` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=151 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_feedback
-- ----------------------------
INSERT INTO `student_feedback` VALUES ('2', '666', '2019-03-12 00:30:13', '201521314321', '马伟涛', '谢谢您的夸奖！', '100001', '小李', '2', '2019-03-12 14:59:34');
INSERT INTO `student_feedback` VALUES ('3', '加油，继续努力', '2019-03-12 00:30:55', '201521314321', '马伟涛', '好的，收到。记得给五星好评喔', '123456', '小张', '2', '2019-03-12 17:15:53');
INSERT INTO `student_feedback` VALUES ('4', '在线考试系统', '2019-03-12 00:45:16', '201521314321', '马伟涛', '嗯嗯，感谢您的使用', '100001', '小李', '2', '2019-03-13 18:25:11');
INSERT INTO `student_feedback` VALUES ('5', '111', '2019-03-12 00:50:50', '201521314321', '马伟涛', '222', '100000', '小王', '2', '2019-03-13 18:25:31');
INSERT INTO `student_feedback` VALUES ('6', '牛逼', '2019-03-12 00:52:47', '201521314322', '杨铎', '拓荒者牛逼', '100000', '小王', '1', '2019-03-13 19:00:06');
INSERT INTO `student_feedback` VALUES ('7', '小母牛开摩托车咯', '2019-03-12 00:53:07', '201521314322', '杨铎', '牛逼轰轰喔！', '100001', '小李', '1', '2019-03-13 19:00:08');
INSERT INTO `student_feedback` VALUES ('8', '我是谢永宁哈哈哈', '2019-03-13 19:08:47', '201521314301', '谢永宁', '我叼你啊，你再逼', '100000', '小王', '2', '2019-04-02 18:26:26');
INSERT INTO `student_feedback` VALUES ('10', '你好啊，哈哈哈', '2019-03-22 03:52:22', '201521314321', '马伟涛', '呵呵哒', '100000', '小王', '2', '2019-04-02 18:26:22');
INSERT INTO `student_feedback` VALUES ('19', '666', '2019-04-02 18:41:35', '201521314321', '马伟涛', '鸡你太美', '123456', '小张', '2', '2019-04-21 00:29:46');
INSERT INTO `student_feedback` VALUES ('21', '555', '2019-04-02 19:13:15', '201521314321', '马伟涛', '呜呜呜', '123456', '小张', '2', '2019-04-21 00:34:34');
INSERT INTO `student_feedback` VALUES ('23', '222', '2019-04-21 19:32:49', '201521314321', '马伟涛', '222', '100000', '小王', '2', '2019-04-21 23:50:43');
INSERT INTO `student_feedback` VALUES ('24', '111', '2019-04-21 19:33:12', '201521314321', '马伟涛', '111', '100000', '小王', '2', '2019-04-21 23:51:29');
INSERT INTO `student_feedback` VALUES ('36', '11', '2019-04-21 23:38:57', '201521314321', '马伟涛', '11', '100000', '小王', '2', '2019-04-22 00:11:25');
INSERT INTO `student_feedback` VALUES ('37', '111', '2019-04-21 23:40:54', '201521314321', '马伟涛', '111', '100000', '小王', '2', '2019-04-22 00:04:11');
INSERT INTO `student_feedback` VALUES ('38', '888', '2019-04-21 23:42:08', '201521314321', '马伟涛', '888', '100000', '小王', '2', '2019-04-22 00:02:07');
INSERT INTO `student_feedback` VALUES ('39', '大碗面', '2019-04-21 23:49:58', '201521314321', '马伟涛', '面大碗', '100000', '小王', '2', '2019-04-21 23:50:18');
INSERT INTO `student_feedback` VALUES ('40', '5555', '2019-04-21 23:52:31', '201521314321', '马伟涛', '5555', '100000', '小王', '2', '2019-04-21 23:52:49');
INSERT INTO `student_feedback` VALUES ('41', '11', '2019-04-21 23:53:36', '201521314321', '马伟涛', '22', '100000', '小王', '2', '2019-04-21 23:55:22');
INSERT INTO `student_feedback` VALUES ('42', '9999', '2019-04-22 00:04:36', '201521314321', '马伟涛', '9999', '100000', '小王', '2', '2019-04-22 00:04:44');
INSERT INTO `student_feedback` VALUES ('43', '测试一下', '2019-04-22 00:12:47', '201521314321', '马伟涛', '好的', '100000', '小王', '2', '2019-04-22 00:13:05');
INSERT INTO `student_feedback` VALUES ('44', '测试', '2019-04-22 00:14:10', '201521314321', '马伟涛', '测试', '100000', '小王', '2', '2019-04-22 00:14:16');
INSERT INTO `student_feedback` VALUES ('45', 'qqq', '2019-04-22 00:14:59', '201521314321', '马伟涛', 'qqq', '100000', '小王', '2', '2019-04-22 00:15:07');
INSERT INTO `student_feedback` VALUES ('46', '我们', '2019-04-22 00:15:39', '201521314321', '马伟涛', '我们', '100000', '小王', '2', '2019-04-22 00:15:44');
INSERT INTO `student_feedback` VALUES ('47', '8585', '2019-04-22 00:16:01', '201521314321', '马伟涛', '85585', '100000', '小王', '2', '2019-04-22 00:20:17');
INSERT INTO `student_feedback` VALUES ('48', '8888', '2019-04-22 00:16:04', '201521314321', '马伟涛', '8888', '100000', '小王', '2', '2019-04-22 00:16:15');
INSERT INTO `student_feedback` VALUES ('49', '7777', '2019-04-22 00:18:03', '201521314321', '马伟涛', '7777', '100000', '小王', '2', '2019-04-22 00:18:27');
INSERT INTO `student_feedback` VALUES ('50', '1111', '2019-04-22 00:19:53', '201521314321', '马伟涛', '1111', '100000', '小王', '2', '2019-04-22 00:20:02');
INSERT INTO `student_feedback` VALUES ('51', '我们', '2019-04-22 00:20:29', '201521314321', '马伟涛', '我们', '100000', '小王', '2', '2019-04-22 00:20:42');
INSERT INTO `student_feedback` VALUES ('52', '555', '2019-04-22 01:11:39', '201521314321', '马伟涛', '555', '100000', '小王', '2', '2019-04-22 01:41:39');
INSERT INTO `student_feedback` VALUES ('53', '测试额', '2019-04-22 01:40:40', '201521314321', '马伟涛', '测试额', '100000', '小王', '2', '2019-04-22 01:46:30');
INSERT INTO `student_feedback` VALUES ('54', '再来', '2019-04-22 01:41:05', '201521314321', '马伟涛', '再来', '100000', '小王', '2', '2019-04-22 01:51:07');
INSERT INTO `student_feedback` VALUES ('55', '来', '2019-04-22 01:53:58', '201521314321', '马伟涛', '来', '123456', '小张', '2', '2019-04-22 01:55:05');
INSERT INTO `student_feedback` VALUES ('56', '拉来', '2019-04-22 01:54:44', '201521314321', '马伟涛', '拉来', '100000', '小王', '2', '2019-04-22 02:00:01');
INSERT INTO `student_feedback` VALUES ('57', '来来来', '2019-04-22 01:55:52', '201521314321', '马伟涛', '来来来', '100000', '小王', '2', '2019-04-22 02:11:32');
INSERT INTO `student_feedback` VALUES ('58', '啦啦啦', '2019-04-22 01:58:44', '201521314321', '马伟涛', '啦啦啦', '100000', '小王', '2', '2019-04-22 02:12:22');
INSERT INTO `student_feedback` VALUES ('59', '哔哩哔哩', '2019-04-22 01:59:09', '201521314321', '马伟涛', '哔哩哔哩', '123456', '小张', '2', '2019-04-22 02:12:43');
INSERT INTO `student_feedback` VALUES ('60', '大碗宽面', '2019-04-22 01:59:42', '201521314321', '马伟涛', '大碗宽面', '123456', '小张', '2', '2019-04-25 16:05:36');
INSERT INTO `student_feedback` VALUES ('61', '渣渣辉', '2019-04-22 02:13:08', '201521314321', '马伟涛', '渣渣辉', '123456', '小张', '2', '2019-04-25 16:06:16');
INSERT INTO `student_feedback` VALUES ('62', '111', '2019-04-22 02:45:51', '201521314321', '马伟涛', '111', '123456', '小张', '2', '2019-04-22 02:46:51');
INSERT INTO `student_feedback` VALUES ('63', '222', '2019-04-22 02:47:00', '201521314321', '马伟涛', '222', '123456', '小张', '2', '2019-04-22 16:18:14');
INSERT INTO `student_feedback` VALUES ('64', '222', '2019-04-22 16:17:31', '201521314321', '马伟涛', '222', '123456', '小张', '2', '2019-04-22 16:17:46');
INSERT INTO `student_feedback` VALUES ('65', '996', '2019-04-22 16:21:22', '201521314321', '马伟涛', '996', '123456', '小张', '2', '2019-04-25 16:05:11');
INSERT INTO `student_feedback` VALUES ('66', '979', '2019-04-22 16:21:57', '201521314321', '马伟涛', '979', '123456', '小张', '2', '2019-04-22 17:17:36');
INSERT INTO `student_feedback` VALUES ('67', '878', '2019-04-22 16:22:56', '201521314321', '马伟涛', '878', '123456', '小张', '2', '2019-04-22 16:23:55');
INSERT INTO `student_feedback` VALUES ('68', '669', '2019-04-22 17:17:56', '201521314321', '马伟涛', '669', '123456', '小张', '2', '2019-04-23 23:38:34');
INSERT INTO `student_feedback` VALUES ('69', '打包咯', '2019-04-22 19:41:04', '201521314321', '马伟涛', '好的喔', '123456', '小张', '2', '2019-04-22 19:41:16');
INSERT INTO `student_feedback` VALUES ('70', '123', '2019-04-25 16:03:36', '201521314321', '马伟涛', '123', '123456', '小张', '2', '2019-04-25 16:04:05');
INSERT INTO `student_feedback` VALUES ('71', '11', '2019-04-25 16:08:18', '201521314321', '马伟涛', '11', '123456', '小张', '2', '2019-04-25 16:11:38');
INSERT INTO `student_feedback` VALUES ('72', '222', '2019-04-25 16:12:21', '201521314321', '马伟涛', '222', '123456', '小张', '2', '2019-04-25 16:14:48');
INSERT INTO `student_feedback` VALUES ('73', '33', '2019-04-25 16:15:06', '201521314321', '马伟涛', '33', '123456', '小张', '2', '2019-04-25 16:15:20');
INSERT INTO `student_feedback` VALUES ('74', '44', '2019-04-25 16:15:31', '201521314321', '马伟涛', '44', '123456', '小张', '2', '2019-04-25 16:17:22');
INSERT INTO `student_feedback` VALUES ('75', '55', '2019-04-25 16:31:05', '201521314321', '马伟涛', '55', '123456', '小张', '2', '2019-04-25 16:31:43');
INSERT INTO `student_feedback` VALUES ('76', '66', '2019-04-25 16:31:20', '201521314321', '马伟涛', '66', '123456', '小张', '2', '2019-04-25 16:31:53');
INSERT INTO `student_feedback` VALUES ('77', '77', '2019-04-25 16:31:29', '201521314321', '马伟涛', '77', '123456', '小张', '2', '2019-04-25 16:36:52');
INSERT INTO `student_feedback` VALUES ('78', '88', '2019-04-25 16:39:59', '201521314321', '马伟涛', '88', '123456', '小张', '2', '2019-04-25 16:40:09');
INSERT INTO `student_feedback` VALUES ('79', '99', '2019-04-25 16:46:32', '201521314321', '马伟涛', '99', '123456', '小张', '2', '2019-04-25 16:46:37');
INSERT INTO `student_feedback` VALUES ('80', '10', '2019-04-25 16:46:49', '201521314321', '马伟涛', '10', '123456', '小张', '2', '2019-04-25 16:46:57');
INSERT INTO `student_feedback` VALUES ('81', '12', '2019-04-25 16:49:56', '201521314321', '马伟涛', '12', '123456', '小张', '2', '2019-04-25 16:50:39');
INSERT INTO `student_feedback` VALUES ('82', '13', '2019-04-25 16:50:02', '201521314321', '马伟涛', '13', '123456', '小张', '2', '2019-04-25 16:52:34');
INSERT INTO `student_feedback` VALUES ('83', '14', '2019-04-25 16:50:05', '201521314321', '马伟涛', '14', '123456', '小张', '2', '2019-04-25 16:53:08');
INSERT INTO `student_feedback` VALUES ('84', '15', '2019-04-25 16:54:20', '201521314321', '马伟涛', '15', '123456', '小张', '2', '2019-04-25 16:54:26');
INSERT INTO `student_feedback` VALUES ('85', '16', '2019-04-25 16:54:31', '201521314321', '马伟涛', '16', '123456', '小张', '2', '2019-04-25 16:54:43');
INSERT INTO `student_feedback` VALUES ('86', '17', '2019-04-25 16:54:35', '201521314321', '马伟涛', '17', '123456', '小张', '2', '2019-04-25 16:55:46');
INSERT INTO `student_feedback` VALUES ('87', '18', '2019-04-25 16:56:36', '201521314321', '马伟涛', '18', '123456', '小张', '2', '2019-04-25 16:56:46');
INSERT INTO `student_feedback` VALUES ('88', '19', '2019-04-25 16:56:38', '201521314321', '马伟涛', '19', '123456', '小张', '2', '2019-04-25 16:58:13');
INSERT INTO `student_feedback` VALUES ('89', '20', '2019-04-25 16:56:40', '201521314321', '马伟涛', '20', '123456', '小张', '2', '2019-04-25 16:58:24');
INSERT INTO `student_feedback` VALUES ('90', '18', '2019-04-25 16:57:40', '201521314321', '马伟涛', '18', '123456', '小张', '2', '2019-04-25 16:57:47');
INSERT INTO `student_feedback` VALUES ('91', '21', '2019-04-25 16:59:26', '201521314321', '马伟涛', '21', '123456', '小张', '2', '2019-04-25 16:59:31');
INSERT INTO `student_feedback` VALUES ('92', '22', '2019-04-25 16:59:36', '201521314321', '马伟涛', '22', '123456', '小张', '2', '2019-04-25 16:59:40');
INSERT INTO `student_feedback` VALUES ('93', '23', '2019-04-25 16:59:44', '201521314321', '马伟涛', '23', '123456', '小张', '2', '2019-04-25 16:59:48');
INSERT INTO `student_feedback` VALUES ('94', '24', '2019-04-25 16:59:51', '201521314321', '马伟涛', '24', '123456', '小张', '2', '2019-04-25 17:00:48');
INSERT INTO `student_feedback` VALUES ('95', '25', '2019-04-25 16:59:52', '201521314321', '马伟涛', '25', '123456', '小张', '2', '2019-04-25 17:05:34');
INSERT INTO `student_feedback` VALUES ('96', '26', '2019-04-25 17:00:05', '201521314321', '马伟涛', '26', '123456', '小张', '2', '2019-04-25 17:07:02');
INSERT INTO `student_feedback` VALUES ('97', '27', '2019-04-25 17:07:27', '201521314321', '马伟涛', '27', '123456', '小张', '2', '2019-04-25 17:07:32');
INSERT INTO `student_feedback` VALUES ('98', '28', '2019-04-25 17:07:35', '201521314321', '马伟涛', '28', '123456', '小张', '2', '2019-04-25 17:07:46');
INSERT INTO `student_feedback` VALUES ('99', '29', '2019-04-25 17:07:37', '201521314321', '马伟涛', '29', '123456', '小张', '2', '2019-04-25 17:10:07');
INSERT INTO `student_feedback` VALUES ('100', '30', '2019-04-25 17:07:39', '201521314321', '马伟涛', '30', '123456', '小张', '2', '2019-04-25 17:10:53');
INSERT INTO `student_feedback` VALUES ('101', '31', '2019-04-25 17:11:03', '201521314321', '马伟涛', '31', '123456', '小张', '2', '2019-04-25 17:11:06');
INSERT INTO `student_feedback` VALUES ('102', '32', '2019-04-25 17:11:12', '201521314321', '马伟涛', '32', '123456', '小张', '2', '2019-04-25 17:11:25');
INSERT INTO `student_feedback` VALUES ('103', '33', '2019-04-25 17:11:14', '201521314321', '马伟涛', '33', '123456', '小张', '2', '2019-04-25 17:16:26');
INSERT INTO `student_feedback` VALUES ('104', '34', '2019-04-25 17:11:15', '201521314321', '马伟涛', '4', '123456', '小张', '2', '2019-04-25 17:16:44');
INSERT INTO `student_feedback` VALUES ('105', '35', '2019-04-25 17:16:35', '201521314321', '马伟涛', '35', '123456', '小张', '2', '2019-04-25 17:16:51');
INSERT INTO `student_feedback` VALUES ('106', '36', '2019-04-25 17:16:36', '201521314321', '马伟涛', '36', '123456', '小张', '2', '2019-04-25 17:18:11');
INSERT INTO `student_feedback` VALUES ('107', '37', '2019-04-25 17:16:40', '201521314321', '马伟涛', '37', '123456', '小张', '2', '2019-04-25 17:19:16');
INSERT INTO `student_feedback` VALUES ('108', '40', '2019-04-25 17:25:31', '201521314321', '马伟涛', '40', '123456', '小张', '2', '2019-04-25 17:31:06');
INSERT INTO `student_feedback` VALUES ('109', '41', '2019-04-25 17:25:42', '201521314321', '马伟涛', '41', '123456', '小张', '2', '2019-04-25 17:31:33');
INSERT INTO `student_feedback` VALUES ('110', '42', '2019-04-25 17:26:19', '201521314321', '马伟涛', '42', '123456', '小张', '2', '2019-04-25 17:37:53');
INSERT INTO `student_feedback` VALUES ('111', '45', '2019-04-25 17:29:03', '201521314321', '马伟涛', '45', '123456', '小张', '2', '2019-04-25 17:38:29');
INSERT INTO `student_feedback` VALUES ('112', '43', '2019-04-25 17:30:52', '201521314321', '马伟涛', '43', '123456', '小张', '2', '2019-04-25 17:38:15');
INSERT INTO `student_feedback` VALUES ('113', '44', '2019-04-25 17:30:57', '201521314321', '马伟涛', '44', '123456', '小张', '2', '2019-04-25 17:38:19');
INSERT INTO `student_feedback` VALUES ('114', '46', '2019-04-25 17:31:24', '201521314321', '马伟涛', '46', '123456', '小张', '2', '2019-04-25 17:39:08');
INSERT INTO `student_feedback` VALUES ('115', '47', '2019-04-25 17:38:07', '201521314321', '马伟涛', '47', '123456', '小张', '2', '2019-04-25 17:41:00');
INSERT INTO `student_feedback` VALUES ('116', '48', '2019-04-25 17:38:10', '201521314321', '马伟涛', '48', '123456', '小张', '2', '2019-04-25 17:41:47');
INSERT INTO `student_feedback` VALUES ('117', '49', '2019-04-25 17:42:17', '201521314321', '马伟涛', '49', '123456', '小张', '2', '2019-04-25 17:42:36');
INSERT INTO `student_feedback` VALUES ('118', '50', '2019-04-25 17:42:30', '201521314321', '马伟涛', '50', '123456', '小张', '2', '2019-04-25 17:43:04');
INSERT INTO `student_feedback` VALUES ('119', '50', '2019-04-25 17:42:44', '201521314321', '马伟涛', '50', '123456', '小张', '2', '2019-04-25 17:44:51');
INSERT INTO `student_feedback` VALUES ('120', '51', '2019-04-25 17:42:48', '201521314321', '马伟涛', '51', '123456', '小张', '2', '2019-04-25 17:45:04');
INSERT INTO `student_feedback` VALUES ('121', '52', '2019-04-25 17:42:50', '201521314321', '马伟涛', '52', '123456', '小张', '2', '2019-04-25 17:45:16');
INSERT INTO `student_feedback` VALUES ('122', '53', '2019-04-25 17:45:09', '201521314321', '马伟涛', '53', '123456', '小张', '2', '2019-04-25 17:45:22');
INSERT INTO `student_feedback` VALUES ('123', '54', '2019-04-25 17:45:11', '201521314321', '马伟涛', '54', '123456', '小张', '2', '2019-04-25 17:50:36');
INSERT INTO `student_feedback` VALUES ('124', '60', '2019-04-25 17:51:26', '201521314321', '马伟涛', '60', '123456', '小张', '2', '2019-04-25 17:51:56');
INSERT INTO `student_feedback` VALUES ('125', '61', '2019-04-25 17:51:31', '201521314321', '马伟涛', '61', '123456', '小张', '2', '2019-04-25 17:52:08');
INSERT INTO `student_feedback` VALUES ('126', '62', '2019-04-25 17:51:45', '201521314321', '马伟涛', '62', '123456', '小张', '2', '2019-04-25 17:52:22');
INSERT INTO `student_feedback` VALUES ('127', '63', '2019-04-25 17:51:48', '201521314321', '马伟涛', '63', '123456', '小张', '2', '2019-04-25 17:52:57');
INSERT INTO `student_feedback` VALUES ('128', '64', '2019-04-25 17:52:39', '201521314321', '马伟涛', '64', '123456', '小张', '2', '2019-04-25 17:52:44');
INSERT INTO `student_feedback` VALUES ('129', '65', '2019-04-25 17:52:49', '201521314321', '马伟涛', '65', '123456', '小张', '2', '2019-04-25 17:56:01');
INSERT INTO `student_feedback` VALUES ('130', '66', '2019-04-25 17:52:50', '201521314321', '马伟涛', '66', '123456', '小张', '2', '2019-04-26 22:30:15');
INSERT INTO `student_feedback` VALUES ('131', '67', '2019-04-25 17:55:48', '201521314321', '马伟涛', '67', '123456', '小张', '2', '2019-04-26 22:30:18');
INSERT INTO `student_feedback` VALUES ('132', '68', '2019-04-25 17:56:13', '201521314321', '马伟涛', '68', '123456', '小张', '2', '2019-04-25 17:56:18');
INSERT INTO `student_feedback` VALUES ('133', '#流泪;#流泪;#流泪;', '2019-04-26 21:13:52', '201521314321', '马伟涛', '摸摸头', '123456', '小张', '2', '2019-04-26 22:29:42');
INSERT INTO `student_feedback` VALUES ('134', '#爱心;#爱心;#爱心;么么哒', '2019-04-26 21:55:12', '201521314321', '马伟涛', '#爱心;#爱心;么么', '123456', '小张', '2', '2019-04-27 00:24:03');
INSERT INTO `student_feedback` VALUES ('135', '#得意;', '2019-04-26 22:04:23', '201521314321', '马伟涛', null, null, null, '0', null);
INSERT INTO `student_feedback` VALUES ('136', '#发呆;#发呆;', '2019-04-26 22:06:56', '201521314321', '马伟涛', '好的#心碎;', '123456', '小张', '2', '2019-04-27 00:26:21');
INSERT INTO `student_feedback` VALUES ('137', '#发呆;#发呆;#发呆;发呆中', '2019-04-26 22:07:09', '201521314321', '马伟涛', '发呆', '123456', '小张', '2', '2019-04-26 22:30:29');
INSERT INTO `student_feedback` VALUES ('138', '#流泪;#害羞;#闭嘴;', '2019-04-26 22:09:22', '201521314321', '马伟涛', null, null, null, '0', null);
INSERT INTO `student_feedback` VALUES ('139', '#吓;啊啊啊', '2019-04-26 22:17:08', '201521314321', '马伟涛', '#饥饿;#疑问;#衰;咪事阿', '123456', '小张', '2', '2019-04-27 00:29:50');
INSERT INTO `student_feedback` VALUES ('140', '#鼓掌;#坏笑;#微笑;', '2019-04-27 00:35:03', '201521314321', '马伟涛', null, null, null, '0', null);
INSERT INTO `student_feedback` VALUES ('141', '#乒乓;#篮球;来啊', '2019-04-27 02:06:54', '201521314321', '马伟涛', null, null, null, '0', null);
INSERT INTO `student_feedback` VALUES ('142', '#憨笑;嗷嗷嗷', '2019-04-28 00:48:24', '201511314301', '小三', '#发呆;#发呆;啊噢', '123456', '小张', '1', '2019-04-28 00:56:50');
INSERT INTO `student_feedback` VALUES ('143', '#可怜;#可怜;#可怜;哎哎', '2019-04-28 00:51:45', '201511314301', '小三', '1111', '123456', '小张', '1', '2019-05-07 19:17:49');
INSERT INTO `student_feedback` VALUES ('144', '#衰;爱哟', '2019-04-28 00:57:48', '201511314321', '小马', '#害羞;#害羞;害羞', '123456', '小张', '2', '2019-04-28 01:01:16');
INSERT INTO `student_feedback` VALUES ('145', '#亲亲;#亲亲;亲一下', '2019-04-28 01:01:33', '201511314321', '小马', '#咒骂;亲你妹呀', '123456', '小张', '2', '2019-04-28 01:02:16');
INSERT INTO `student_feedback` VALUES ('146', '#亲亲;#糗大了;达', '2019-04-28 01:52:43', '201521314900', '张阿三', '啊啊', '123456', '小张', '1', '2019-05-07 19:02:35');
INSERT INTO `student_feedback` VALUES ('147', '啊哈哈哈#胜利;#鼓掌;', '2019-04-28 02:25:55', '201521314900', '张阿三', '111', '123456', '小张', '1', '2019-05-07 19:02:19');
INSERT INTO `student_feedback` VALUES ('148', '#糗大了;试试', '2019-05-07 16:34:13', '201521314321', '马伟涛', '11', '123456', '小张', '1', '2019-05-07 19:00:06');
INSERT INTO `student_feedback` VALUES ('149', '#发呆;#得意;测试', '2019-05-07 16:35:02', '201521314321', '马伟涛', '#憨笑;#坏笑;#鼓掌;好的喔', '123456', '小张', '2', '2019-05-07 16:35:36');
INSERT INTO `student_feedback` VALUES ('150', '#糗大了;#阴险;', '2019-05-07 17:03:35', '201521314321', '马伟涛', '111#委屈;#抠鼻;', '123456', '小张', '2', '2019-05-07 17:03:59');

-- ----------------------------
-- Table structure for student_home_rotation_img
-- ----------------------------
DROP TABLE IF EXISTS `student_home_rotation_img`;
CREATE TABLE `student_home_rotation_img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
  `img_title` varchar(255) DEFAULT NULL COMMENT '轮播图标题',
  `img_src` varchar(255) NOT NULL COMMENT '轮播图图片地址',
  `img_create_time` datetime NOT NULL COMMENT '轮播图创建时间',
  `ano` int(11) NOT NULL COMMENT '创建轮播图的管理员id',
  `adm_name` varchar(255) DEFAULT NULL COMMENT '创建轮播图的管理员姓名',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_home_rotation_img
-- ----------------------------
INSERT INTO `student_home_rotation_img` VALUES ('1', '轮播图1', 'http://qiniu.maweitao.top/programImages/82a1c26a-39b9-4453-8103-22d0d477478f', '2019-03-05 01:48:22', '123456', '小张');
INSERT INTO `student_home_rotation_img` VALUES ('2', '轮播图2', 'http://qiniu.maweitao.top/programImages/1205f95d-5dd0-4def-8f2c-408f490db07a', '2019-03-05 01:48:45', '123456', '小张');
INSERT INTO `student_home_rotation_img` VALUES ('3', '轮播图3', 'http://qiniu.maweitao.top/programImages/b3c05167-40a7-4bd3-bd6e-ed9bb864bb0a', '2019-03-05 01:49:03', '123456', '小张');
INSERT INTO `student_home_rotation_img` VALUES ('4', '轮播图4', 'http://qiniu.maweitao.top/programImages/4c32633e-3e05-4835-b4b6-dc6695b88d11', '2019-03-05 01:49:17', '123456', '小张');
INSERT INTO `student_home_rotation_img` VALUES ('5', '测试添加轮播图1', 'http://qiniu.maweitao.top/programImages/8f7a39f1-b732-4cf5-b26a-b9c5c70ff272', '2019-04-20 17:18:40', '123456', '小张');
INSERT INTO `student_home_rotation_img` VALUES ('6', '测试添加轮播图2', 'http://qiniu.maweitao.top/programImages/b4bcbbbb-599c-4a6a-b055-4f8bef73e25a', '2019-04-20 17:19:01', '123456', '小张');

-- ----------------------------
-- Table structure for student_paper_answer
-- ----------------------------
DROP TABLE IF EXISTS `student_paper_answer`;
CREATE TABLE `student_paper_answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生答卷答案id',
  `stu_answer` varchar(255) DEFAULT NULL COMMENT '学生答卷答案',
  `isCorrect` varchar(255) DEFAULT NULL COMMENT '答案是否正确',
  `que_id` int(11) DEFAULT NULL COMMENT '问题id',
  `paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  `sno` char(12) DEFAULT NULL COMMENT '学号',
  `isCollect` varchar(255) DEFAULT '0' COMMENT '是否被收藏,0为否，1为是',
  `user_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `answer_que_id` (`que_id`),
  KEY `answer_paper_id` (`paper_id`),
  KEY `answer_sno` (`sno`),
  CONSTRAINT `answer_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `answer_que_id` FOREIGN KEY (`que_id`) REFERENCES `paper_que` (`que_id`),
  CONSTRAINT `answer_sno` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=754 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_paper_answer
-- ----------------------------
INSERT INTO `student_paper_answer` VALUES ('710', 'A', '1', '162', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('711', 'A', '0', '163', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('712', 'A', '0', '164', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('713', 'F', '1', '165', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('714', 'F', '0', '166', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('715', 'T', '1', '167', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('716', '咕咕咕', '0', '168', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('717', '疯疯癫癫', '0', '169', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('718', '芳芳菲菲', '0', '170', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('719', '噢噢噢噢', '0', '171', '12', null, '0', '11112222222');
INSERT INTO `student_paper_answer` VALUES ('730', 'A', '1', '162', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('731', 'A', '0', '163', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('732', 'B', '1', '164', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('733', 'T', '0', '165', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('734', 'F', '0', '166', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('735', 'T', '1', '167', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('736', '疑是地上霜', '1', '168', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('737', '举头望明月', '0', '169', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('738', '白日依山尽', '0', '170', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('739', '欲穷千里目', '1', '171', '12', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('740', 'A', '1', '177', '13', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('741', 'T', '0', '178', '13', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('742', '疑是地上霜', '1', '179', '13', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('743', '黄河入海流', '0', '180', '13', null, '0', '11111111113');
INSERT INTO `student_paper_answer` VALUES ('744', null, '0', '162', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('745', null, '0', '163', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('746', null, '0', '164', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('747', null, '0', '165', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('748', null, '0', '166', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('749', null, '0', '167', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('750', null, '0', '168', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('751', null, '0', '169', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('752', null, '0', '170', '12', null, '0', null);
INSERT INTO `student_paper_answer` VALUES ('753', null, '0', '171', '12', null, '0', null);

-- ----------------------------
-- Table structure for student_paper_score
-- ----------------------------
DROP TABLE IF EXISTS `student_paper_score`;
CREATE TABLE `student_paper_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生答卷分数id',
  `score` int(11) DEFAULT NULL COMMENT '学生答卷总分',
  `time_used` int(11) DEFAULT NULL COMMENT '答题花费时间，单位毫秒',
  `start_time` datetime DEFAULT NULL COMMENT '答题开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '答题结束时间',
  `sno` char(12) DEFAULT NULL COMMENT '学号',
  `paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  `user_phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `score_sno` (`sno`),
  KEY `score_paper_id` (`paper_id`),
  CONSTRAINT `score_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `score_sno` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student_paper_score
-- ----------------------------
INSERT INTO `student_paper_score` VALUES ('80', '3', '67189', '2020-03-05 15:27:05', '2020-03-05 15:28:12', null, '12', '11112222222');
INSERT INTO `student_paper_score` VALUES ('86', '5', '109005', '2020-03-07 10:57:40', '2020-03-07 10:59:29', null, '12', '11111111113');
INSERT INTO `student_paper_score` VALUES ('87', '2', '28297', '2020-03-07 18:26:59', '2020-03-07 18:27:27', null, '13', '11111111113');
INSERT INTO `student_paper_score` VALUES ('94', '3', '67000', null, null, null, '12', '11111111112');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tno` char(6) NOT NULL COMMENT '教工号',
  `tea_psw` varchar(255) NOT NULL DEFAULT '123456' COMMENT '登录密码，默认为123456',
  `tea_name` varchar(255) NOT NULL COMMENT '教师姓名',
  `tea_sex` varchar(255) NOT NULL DEFAULT '男' COMMENT '教师性别',
  `tea_email` varchar(255) DEFAULT NULL COMMENT '教师邮箱',
  `tea_phone` char(11) DEFAULT NULL COMMENT '教师手机号码',
  `tea_last_login_time` datetime DEFAULT NULL COMMENT '教师最近登录时间',
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('100000', '123456', '杨老师', '男', '123456@qq.com', '13524569875', null);
INSERT INTO `teacher` VALUES ('100001', '123456', '高老师', '男', '123456@qq.com', '13658426951', null);
INSERT INTO `teacher` VALUES ('100100', '123456', '侯老师', '男', '123456@qq.com', '13658245962', null);
INSERT INTO `teacher` VALUES ('100860', '123456', '王老师', '男', '123456@qq.com', '13254859621', null);
INSERT INTO `teacher` VALUES ('123456', '123456', '胡老师', '男', '123456@qq.com', '13229622789', '2019-05-07 16:38:13');
INSERT INTO `teacher` VALUES ('654321', '123456', '鸡你太美', '女', null, null, null);

-- ----------------------------
-- Table structure for teacher_notice
-- ----------------------------
DROP TABLE IF EXISTS `teacher_notice`;
CREATE TABLE `teacher_notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师公告id',
  `notice_content` varchar(255) NOT NULL COMMENT '公告内容',
  `notice_create_time` datetime DEFAULT NULL COMMENT '公告创建时间',
  `tea_name` varchar(255) DEFAULT NULL COMMENT '创建公告的教师姓名',
  `tno` char(6) DEFAULT NULL COMMENT '创建公告教工号',
  `sno` char(12) DEFAULT NULL COMMENT '学号',
  `is_see` varchar(255) DEFAULT NULL COMMENT '是否查看',
  PRIMARY KEY (`notice_id`),
  KEY `notice_tno` (`tno`),
  KEY `notice_sno` (`sno`),
  CONSTRAINT `notice_sno` FOREIGN KEY (`sno`) REFERENCES `student` (`sno`),
  CONSTRAINT `notice_tno` FOREIGN KEY (`tno`) REFERENCES `teacher` (`tno`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_notice
-- ----------------------------
INSERT INTO `teacher_notice` VALUES ('1', '2019年3月1号下午两点到四点将会有一场计算机图形学在线考试，请同学们做好相关考试准备。', '2019-03-13 19:43:07', '胡老师', '123456', null, null);
INSERT INTO `teacher_notice` VALUES ('2', '2019年3月2号下午两点到四点将会有一场Java语言程序设计在线考试，请同学们做好相关考试准备。', '2019-03-13 19:43:23', '高老师', '100001', null, null);
INSERT INTO `teacher_notice` VALUES ('3', '2019年3月3号下午两点到四点将会有一场数据库原理与设计在线考试，请同学们做好相关考试准备。', '2019-03-13 19:43:41', '杨老师', '100000', null, null);
INSERT INTO `teacher_notice` VALUES ('4', '2019年3月4号下午两点到四点将会有一场C++语言程序设计在线考试，请同学们做好相关考试准备。', '2019-03-13 19:43:55', '杨老师', '100000', null, null);
INSERT INTO `teacher_notice` VALUES ('5', '2019年3月5号下午两点到四点将会有一场Web程序设计在线考试，请同学们做好相关考试准备。', '2019-03-13 19:45:03', '侯老师', '100100', null, null);
INSERT INTO `teacher_notice` VALUES ('6', '2019年3月6号下午两点到四点将会有一场Android程序设计在线考试，请同学们做好相关考试准备。', '2019-03-13 19:45:09', '侯老师', '100100', null, null);
INSERT INTO `teacher_notice` VALUES ('7', '2019年3月7号下午两点到四点将会有一场计算机网络编程在线考试，请同学们做好相关考试准备。', '2019-03-13 19:45:19', '王老师', '100860', null, null);
INSERT INTO `teacher_notice` VALUES ('8', '2019年3月8号下午两点到四点将会有一场PHP语言程序设计在线考试，请同学们做好相关考试准备。', '2019-03-13 19:45:36', '侯老师', '100100', null, null);
INSERT INTO `teacher_notice` VALUES ('9', '2019年3月9号下午两点到四点将会有一场Ruby语言程序设计在线考试，请同学们做好相关考试准备。', '2019-03-14 16:38:08', '高老师', '100001', null, null);
INSERT INTO `teacher_notice` VALUES ('10', '2019年3月10号下午两点到四点将会有一场JavaScript语言程序设计在线考试，请同学们做好相关考试准备。', '2019-03-14 16:40:00', '侯老师', '100100', null, null);
INSERT INTO `teacher_notice` VALUES ('15', '2019年3月11号下午两点到四点将会有一场计算机图形学在线考试，请同学们做好相关考试准备。', '2019-04-11 17:49:28', '胡老师', '123456', null, null);
INSERT INTO `teacher_notice` VALUES ('16', '2019年3月12号下午两点到四点将会有一场计算机图形学在线考试，请同学们做好相关考试准备。', '2019-04-11 17:49:45', '胡老师', '123456', null, null);
INSERT INTO `teacher_notice` VALUES ('37', '2019年4月22号下午两点到四点将会有一场计算机图形学在线考试，请同学们做好相关考试准备。', '2019-04-22 18:44:29', '胡老师', '123456', null, null);
INSERT INTO `teacher_notice` VALUES ('39', '2019年4月23号下午两点到四点将会有一场计算机图形学在线考试，请同学们做好相关考试准备。', '2019-04-22 19:40:09', '胡老师', '123456', null, null);
INSERT INTO `teacher_notice` VALUES ('42', '2019年4月25号下午两点到四点将会有一场前端测试在线考试，请同学们做好相关考试准备。', '2019-04-25 18:00:28', '胡老师', '123456', null, null);
INSERT INTO `teacher_notice` VALUES ('47', '2019年5月7号下午两点到四点将会有一场前端测试在线考试，请同学们做好相关考试准备。', '2019-05-07 16:48:26', '胡老师', '123456', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_phone` char(11) NOT NULL,
  `user_psw` varchar(255) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `user_img_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像链接',
  `user_introduction` varchar(255) DEFAULT NULL,
  `user_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '男' COMMENT '学生性别',
  PRIMARY KEY (`user_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('11111111112', '121212', '咕咕咕', 'http://q6b41spn5.bkt.clouddn.com/profiles/1ec44d82-6082-4624-89c2-06776b924c79', '啊', '男');
INSERT INTO `user` VALUES ('11111111113', '131313', '哈哈', null, '停云霭霭', '男');
INSERT INTO `user` VALUES ('11111111114', '123456', '测试', null, null, '女');
INSERT INTO `user` VALUES ('11112222222', '123456', '羲兮', 'http://q6b41spn5.bkt.clouddn.com/1.png', null, '女');
