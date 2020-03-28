/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 80015
Source Host           : 127.0.0.1:3306
Source Database       : exam4

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-03-27 15:03:06
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
INSERT INTO `admin` VALUES ('100000', '123456', '清风', '女', '123456@qq.com', '13358452698', '2019-04-22 01:57:55');
INSERT INTO `admin` VALUES ('100001', '123456', '明月', '女', '123456@qq.com', '13358452695', null);
INSERT INTO `admin` VALUES ('123456', '123456', '星辰', '女', '123456@qq.com', '13380544897', '2020-03-26 19:50:00');

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
  CONSTRAINT `fill_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `question_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_fill_que
-- ----------------------------
INSERT INTO `bank_fill_que` VALUES ('35', '窗前明月光的上一句', '疑是地上霜', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('36', '举头望明月上一句', '低头思故乡', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('37', '白日依山尽下一句', '黄河入海流', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('38', '看图写诗句', '欲穷千里目', '1', null, '11', 'http://q6b41spn5.bkt.clouddn.com/2.png');
INSERT INTO `bank_fill_que` VALUES ('39', '看图写诗句', '一生一世一双人', '1', null, '11', 'http://q6b41spn5.bkt.clouddn.com/1.png');
INSERT INTO `bank_fill_que` VALUES ('41', '“清明时节雨纷纷”的下一句', '路上行人欲断魂', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('42', '“日暮汉宫传蜡烛”的下一句', '轻烟散入五侯家', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('43', '“罗浮山下四时春”的下一句', '卢橘杨梅次第新', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('44', '“日啖荔枝三百颗”的下一句', '不辞长作岭南人', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('45', '“采得百花成蜜后”的下一句', '为谁辛苦为谁甜', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('46', '”春眠不觉晓“的下一句。(孟浩然：《春晓》)', '处处闻啼鸟', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('47', '”报得三春晖“的上一句。(孟郊：《游子吟》)', '谁言寸草心', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('48', '“红豆生南国”的下一句。(王维：《相思》)', '春来发几枝', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('49', '”当春乃发生“的上一句。(杜甫：《春夜喜雨》)', '好雨知时节', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('50', '“春色满园关不住”的下一句。（叶绍翁：（《游园不值》）', '一枝红杏出墙来', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('51', '”城春草木深“的上一句。(杜甫：《春望》)', '国破山河在', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('52', '”力尽不知热“的下一句 。(白居易：《观刈麦》', '但惜夏日长', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('53', '_____________，春去夏犹清。(李商隐：《晚晴》)', '深居俯夹城', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('54', '首夏犹清和，_____________ 。(谢灵运：《游赤石进帆海》)', '芳草亦未歇', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('55', '_____________，开轩纳微凉。(杜甫：《夏夜叹》)', '仲夏苦夜短', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('56', '农夫方夏耘，_____________ 。(戴复古：《大热》)', '安坐吾敢食', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('57', '人皆苦炎热，_____________ 。(李昂：《夏日联句》)', '我爱夏日长', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('58', '_____________，新雨带秋岚。(岑参：《水亭送华阴王少府还县》)', '残云收夏暑', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('59', '明月不谙离恨苦，_____________  。——晏殊《鹊踏枝》', '斜光到晓穿朱户', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('60', '_____________，为伊消得人憔悴。－柳永《凤栖梧》', '衣带渐宽终不悔', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('61', '两情若是久长时，_____________。－秦观《鹊桥仙》', '又岂在朝朝暮暮', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('62', '_____________？此时此夜难为情。－李白《三五七言》', '相思相见知何日', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('63', '曾经沧海难为水，_____________ 。－元稹《离思五首其四》', '除却巫山不是云', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('64', '_____________，恨不相逢未嫁时。－张籍《节妇吟》', '还君明珠双泪垂', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('65', '落红不是无情物，_____________  。－龚自珍《己亥杂诗》', '化作春泥更护花', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('66', '_____________，为谁风露立中宵。－黄景仁《绮怀诗二首其一》', '似此星辰非昨夜', '1', null, '10', null);
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
  CONSTRAINT `judge_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `question_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_judge_que
-- ----------------------------
INSERT INTO `bank_judge_que` VALUES ('25', '“过尽千帆皆不是”是韦庄的词句。', 'F', '1', '是温庭筠的《望江南·梳洗罢》', '13');
INSERT INTO `bank_judge_que` VALUES ('26', '《花间集》里边的第一首歌词是《菩萨蛮》。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('27', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('28', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', '', '13');
INSERT INTO `bank_judge_que` VALUES ('29', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', '', '13');
INSERT INTO `bank_judge_que` VALUES ('30', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', '', '13');

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
  CONSTRAINT `multiple_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `question_type` (`lang_id`)
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
  CONSTRAINT `single_lang_id` FOREIGN KEY (`lang_id`) REFERENCES `question_type` (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_single_choice_que
-- ----------------------------
INSERT INTO `bank_single_choice_que` VALUES ('39', '\"拱手而立\"表示对长者的尊敬，一般来说，男子行拱手礼时应该：', 'A、左手在外', 'B、右手在外', null, null, null, null, null, 'A', '1', '解析测试测试测试测试测试测试测试测试', '12');
INSERT INTO `bank_single_choice_que` VALUES ('40', '《三十六计》是体现我国古代卓越军事思想的一部兵书，下列不属于《三十六计》的是：', 'A、浑水摸鱼', 'B、反戈一击', 'C、笑里藏刀', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('41', '“但使龙城飞将在，不教胡马度阴山”中的“飞将”指像（  ）那样的将士。', 'A、张飞', 'B、李广', 'C、霍去病', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('42', '形容月亮的诗甚多，下列那一句与月亮无关？', 'A、团团冰镜吐清辉', 'B、玉蝉离海上', 'C、大珠小珠落玉盘', null, null, null, null, 'C', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('43', '“字字看来都是血，十年辛苦不寻常”是下列哪位名家对自己作品的“自评诗”？', 'A、施耐庵《水浒传》', 'B、吴承恩《西游记》', 'C、曹雪芹《红楼梦》', null, null, null, null, 'C', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('44', '诗经的《硕鼠硕鼠，无食我黍》诗中“黍”指的是那种农作物？', 'A、高粱', 'B、黄米', 'C、谷子', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('45', '杜甫《春夜喜雨》“晓看红湿处，花重锦官城”锦官城是指如今的何处？', 'A、成都', 'B、重庆', 'C、洛阳', null, null, null, null, 'A', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('46', '“不为五斗米折腰”源于对我国哪位诗人高尚气节的评价？', 'A、李白', 'B、陶渊明', 'C、苏轼', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('49', '“昔年有狂客，号尔谪仙人”，诗中“谪仙人”指哪位诗人：', 'A、李白', 'B、杜甫', 'C、苏轼', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('50', '杜甫笔下“功盖三分国，名成八阵图”是赞扬哪位历史人物：', 'A、汉武帝', 'B、诸葛亮', 'C、刘邦', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('51', '下列哪句不是描写西湖美景？', 'A、接天莲叶无穷碧，映日荷花别样红', 'B、水光潋滟晴方好，山色空濛雨亦奇', 'C、湖光秋月两相和，潭面无风镜未磨', null, null, null, null, 'C', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('52', '《凤求凰》演绎的是哪一对情侣的爱情故事？', 'A、李清照和赵明诚', 'B、卓文君和司马相如', 'C、范蠡和西施', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('53', '“小蛮腰”的说法出自哪位文学家？', 'A、晏几道', 'B、白居易', 'C、温庭筠', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('54', '李白曾说“眼前有景道不得，崔郎题诗在上头”的诗是哪一首？', 'A、《登鹳雀楼》', 'B、《登黄鹤楼》', 'C、《登金陵凤凰台》', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('55', '下列哪位诗人凭借哪首诗，赢得了“以孤篇压倒全唐”的美誉？', 'A、陈子昂《登幽州台歌》', 'B、张若虚《春江花月夜》', 'C、杨炯《从军行》', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('56', '“十五好剑术，遍干诸侯。三十成文章，历抵卿相。”指的是哪位诗人？', 'A、辛弃疾', 'B、李白', 'C、王昌龄', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('57', '唐代哪位诗人留存的诗作最多？', 'A、白居易', 'B、李白', 'C、杜甫', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('58', '高适《别董大》，董大的职业是', 'A、琴师', 'B、词人', 'C、厨师', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('59', '《敕勒歌》是由当时哪种语言翻译成汉语的', 'A、鲜卑语', 'B、蒙古语', 'C、维吾尔语', null, null, null, null, 'A', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('60', '诗经《蒹葭》，蒹葭指的是哪一种植物', 'A、芦苇', 'B、莞荽', 'C、水仙', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('61', '诗经《木瓜》“报之以琼琚”，琼琚指的是', 'A、美女', 'B、美食', 'C、美玉', null, null, null, null, 'C', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('62', '“春宵一刻值千金”出自宋代哪位名人之手', 'A、柳永', 'B、苏轼', 'C、李煜', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('64', '无为在 ___ 路，儿女共沾巾。', '歧', '岐', '骑', '其', '起', '企', null, 'A', '0', '', '14');
INSERT INTO `bank_single_choice_que` VALUES ('65', '众女嫉余之 ___ 眉兮，谣诼谓余以善淫。', '蛾', '鹅', '娥', '饿', '额', '俄', null, 'A', '0', null, '14');
INSERT INTO `bank_single_choice_que` VALUES ('66', '秋风 ___ 瑟，洪波涌起', '萧', '潇', '箫', '笑', '消', '肖', null, 'A', '0', null, '14');
INSERT INTO `bank_single_choice_que` VALUES ('67', '根据以下提示词，写出所描述的诗人', '女性', '宋朝', '赌书', null, null, null, null, '李清照', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('78', '根据以下提示词，写出所描述的诗人', '长安', '酒', '诗仙', null, null, null, null, '李白', '0', '', '15');
INSERT INTO `bank_single_choice_que` VALUES ('79', '根据以下提示词，写出所描述的诗人', '婉约', '第七', '蓦然回首', null, null, null, null, '柳永', '0', '', '15');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `feedback_content` varchar(255) NOT NULL COMMENT '反馈内容',
  `feedback_create_time` datetime NOT NULL COMMENT '反馈创建时间',
  `user_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户手机号',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
  `adm_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员回复',
  `ano` char(6) DEFAULT NULL COMMENT '管理员号',
  `adm_name` varchar(255) DEFAULT NULL COMMENT '管理员姓名',
  `feedback_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '留言状态0为管理员未读，1为管理员已读用户未读，2为用户已读',
  `reply_time` datetime DEFAULT NULL COMMENT '管理员回复时间',
  PRIMARY KEY (`feedback_id`),
  KEY `feedback_ano` (`ano`),
  KEY `feedback_user_phone` (`user_phone`) USING BTREE,
  CONSTRAINT `feedback_ano` FOREIGN KEY (`ano`) REFERENCES `admin` (`ano`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('152', '可以再多一点题型嘛', '2020-03-23 20:21:19', '11111111112', '咕咕咕', '技术小哥努力ing', '123456', '小张', '1', '2020-03-23 20:34:29');
INSERT INTO `feedback` VALUES ('153', '难度可以再大点', '2020-03-23 20:42:39', '11111111113', '哈哈', null, null, null, '0', null);
INSERT INTO `feedback` VALUES ('154', '#害羞;', '2020-03-23 20:45:53', '11111111113', '哈哈', null, null, null, '0', null);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告id',
  `notice_content` varchar(255) NOT NULL COMMENT '公告内容',
  `notice_create_time` datetime DEFAULT NULL COMMENT '公告创建时间',
  `admin_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建公告的管理员姓名',
  `ano` char(6) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建公告管理员号',
  PRIMARY KEY (`notice_id`),
  KEY `notice_ano` (`ano`) USING BTREE,
  CONSTRAINT `notice_ano` FOREIGN KEY (`ano`) REFERENCES `admin` (`ano`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('49', '学海中新增百里挑一模式，快去挑战吧。', '2020-03-23 19:09:41', '星辰', '123456');
INSERT INTO `notice` VALUES ('50', '学海中新增争分夺秒模式，快去挑战吧。', '2020-03-23 19:09:41', '清风', '100000');

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
  `participate_num` int(11) DEFAULT '0' COMMENT '已参加人数',
  `paper_img_src` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('12', '春分 · 诗词大会', '2020-03-04 10:33:55', '6000', '4', '', '2', '40', 'http://q6b41spn5.bkt.clouddn.com/3.png');
INSERT INTO `paper` VALUES ('13', '女生节 · 诗词大会', '2020-03-04 10:52:29', '600', '5', '', '1', '2', 'http://q6b41spn5.bkt.clouddn.com/2.png');
INSERT INTO `paper` VALUES ('14', '惊蛰 · 诗词大会', '2020-03-12 16:26:52', '1800', '5', '', '1', '8', 'http://q6b41spn5.bkt.clouddn.com/4.png');

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
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=utf8;

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
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type` (
  `lang_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题型id',
  `lang_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题型名称',
  `lang_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题型描述',
  `lang_img_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题型图标',
  `lang_create_time` datetime DEFAULT NULL COMMENT '题型创建时间',
  `lang_created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题型被创建者',
  `lang_change_time` datetime DEFAULT NULL COMMENT '题型最近修改时间',
  `lang_last_changer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题型最近被修改者',
  `lang_en_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '题型英文名，匹配前端图标',
  PRIMARY KEY (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO `question_type` VALUES ('10', '承上启下', '写出题目诗句的上句或下句', 'http://q6b41spn5.bkt.clouddn.com/1.png', '2020-03-04 10:06:23', null, null, null, 'fill1');
INSERT INTO `question_type` VALUES ('11', '画中有话', '根据图片写出所描绘的诗句', 'http://q6b41spn5.bkt.clouddn.com/2.png', '2020-03-04 10:07:08', null, null, null, 'fill2');
INSERT INTO `question_type` VALUES ('12', '百里挑一', '从选项中选出唯一正确的选项', 'http://q6b41spn5.bkt.clouddn.com/1.png', null, null, null, null, 'single1');
INSERT INTO `question_type` VALUES ('13', '分秒必争', '判断对错', 'http://q6b41spn5.bkt.clouddn.com/2.png', null, null, '2020-03-24 10:30:07', null, 'judge1');
INSERT INTO `question_type` VALUES ('14', '眼花缭乱', '选择正确的汉字', null, null, null, null, null, 'single2');
INSERT INTO `question_type` VALUES ('15', '剥丝抽茧', '根据依次给出的提示，填写诗人姓名', null, null, null, null, null, 'single3');

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
INSERT INTO `user` VALUES ('11111111112', '121212', '咕咕咕', 'http://q6b41spn5.bkt.clouddn.com/profiles/1ec44d82-6082-4624-89c2-06776b924c79', '啊', '女');
INSERT INTO `user` VALUES ('11111111113', '131313', '哈哈', null, '停云霭霭', '男');
INSERT INTO `user` VALUES ('11111111114', '123456', '测试', null, null, '女');
INSERT INTO `user` VALUES ('11112222222', '123456', '羲兮', 'http://q6b41spn5.bkt.clouddn.com/1.png', null, '女');

-- ----------------------------
-- Table structure for user_paper_answer
-- ----------------------------
DROP TABLE IF EXISTS `user_paper_answer`;
CREATE TABLE `user_paper_answer` (
  `answer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生答卷答案id',
  `stu_answer` varchar(255) DEFAULT NULL COMMENT '学生答卷答案',
  `isCorrect` varchar(255) DEFAULT NULL COMMENT '答案是否正确',
  `que_id` int(11) DEFAULT NULL COMMENT '问题id',
  `paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  `isCollect` varchar(255) DEFAULT '0' COMMENT '是否被收藏,0为否，1为是',
  `user_phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`answer_id`),
  KEY `answer_que_id` (`que_id`),
  KEY `answer_paper_id` (`paper_id`),
  KEY `user_phone` (`user_phone`) USING BTREE,
  CONSTRAINT `answer_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `answer_que_id` FOREIGN KEY (`que_id`) REFERENCES `paper_que` (`que_id`),
  CONSTRAINT `user_phone` FOREIGN KEY (`user_phone`) REFERENCES `user` (`user_phone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=800 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_paper_answer
-- ----------------------------
INSERT INTO `user_paper_answer` VALUES ('710', 'A', '1', '162', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('711', 'A', '0', '163', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('712', 'A', '0', '164', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('713', 'F', '1', '165', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('714', 'F', '0', '166', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('715', 'T', '1', '167', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('716', '咕咕咕', '0', '168', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('717', '疯疯癫癫', '0', '169', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('718', '芳芳菲菲', '0', '170', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('719', '噢噢噢噢', '0', '171', '12', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('730', 'A', '1', '162', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('731', 'A', '0', '163', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('732', 'B', '1', '164', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('733', 'T', '0', '165', '12', '1', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('734', 'F', '0', '166', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('735', 'T', '1', '167', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('736', '疑是地上霜', '1', '168', '12', '1', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('737', '举头望明月', '0', '169', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('738', '白日依山尽', '0', '170', '12', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('739', '欲穷千里目', '1', '171', '12', '1', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('740', 'A', '1', '177', '13', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('741', 'T', '0', '178', '13', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('742', '疑是地上霜', '1', '179', '13', '0', '11111111113');
INSERT INTO `user_paper_answer` VALUES ('743', '黄河入海流', '0', '180', '13', '0', '11111111113');

-- ----------------------------
-- Table structure for user_paper_score
-- ----------------------------
DROP TABLE IF EXISTS `user_paper_score`;
CREATE TABLE `user_paper_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生答卷分数id',
  `score` int(11) DEFAULT NULL COMMENT '学生答卷总分',
  `time_used` int(11) DEFAULT NULL COMMENT '答题花费时间，单位毫秒',
  `start_time` datetime DEFAULT NULL COMMENT '答题开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '答题结束时间',
  `paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  `user_phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `score_paper_id` (`paper_id`),
  KEY `score_user_phone` (`user_phone`),
  CONSTRAINT `score_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `score_user_phone` FOREIGN KEY (`user_phone`) REFERENCES `user` (`user_phone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_paper_score
-- ----------------------------
INSERT INTO `user_paper_score` VALUES ('80', '3', '67189', '2020-03-05 15:27:05', '2020-03-05 15:28:12', '12', '11112222222');
INSERT INTO `user_paper_score` VALUES ('86', '5', '109005', '2020-03-07 10:57:40', '2020-03-07 10:59:29', '12', '11111111113');
INSERT INTO `user_paper_score` VALUES ('87', '2', '28297', '2020-03-07 18:26:59', '2020-03-07 18:27:27', '13', '11111111113');

-- ----------------------------
-- Table structure for user_rotation_img
-- ----------------------------
DROP TABLE IF EXISTS `user_rotation_img`;
CREATE TABLE `user_rotation_img` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '轮播图id',
  `img_title` varchar(255) DEFAULT NULL COMMENT '轮播图标题',
  `img_src` varchar(255) NOT NULL COMMENT '轮播图图片地址',
  `img_create_time` datetime NOT NULL COMMENT '轮播图创建时间',
  `ano` int(11) NOT NULL COMMENT '创建轮播图的管理员id',
  `adm_name` varchar(255) DEFAULT NULL COMMENT '创建轮播图的管理员姓名',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_rotation_img
-- ----------------------------
INSERT INTO `user_rotation_img` VALUES ('7', '3月14日白色情人节活动', 'http://q6b41spn5.bkt.clouddn.com/programImages/25604bf4-2597-487c-b9e7-7295ae93ac9c', '2020-03-15 10:19:10', '123456', '小张');
INSERT INTO `user_rotation_img` VALUES ('8', '3月14日白色情人节活动2', 'http://q6b41spn5.bkt.clouddn.com/2.png', '2020-03-15 10:19:10', '123456', '小张');
