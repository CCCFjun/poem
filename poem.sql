/*
Navicat MySQL Data Transfer

Source Server         : aliyunsql
Source Server Version : 80016
Source Host           : rm-bp1577m3027au395jco.mysql.rds.aliyuncs.com:3306
Source Database       : poem

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2020-05-28 11:54:54
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
INSERT INTO `admin` VALUES ('100000', 'e10adc3949ba59abbe56e057f20f883e', '清风', '女', '123456@qq.com', '13358452698', '2019-04-22 01:57:55');
INSERT INTO `admin` VALUES ('100001', 'e10adc3949ba59abbe56e057f20f883e', '明月', '女', '123456@qq.com', '13358452695', null);
INSERT INTO `admin` VALUES ('123456', 'e10adc3949ba59abbe56e057f20f883e', '星辰', '女', '123456@qq.com', '13380544897', '2020-05-27 06:40:03');

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
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_fill_que
-- ----------------------------
INSERT INTO `bank_fill_que` VALUES ('35', '窗前明月光的下一句', '疑是地上霜', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('36', '举头望明月的下一句', '低头思故乡', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('37', '白日依山尽下一句', '黄河入海流', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('38', '看图写诗句', '西北望长安', '1', null, '11', 'http://qa3asqugo.bkt.clouddn.com/h1.png');
INSERT INTO `bank_fill_que` VALUES ('39', '看图写诗句', '家书抵万金', '1', null, '11', 'http://qa3asqugo.bkt.clouddn.com/h2.png');
INSERT INTO `bank_fill_que` VALUES ('41', '“清明时节雨纷纷”的下一句', '路上行人欲断魂', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('42', '“日暮汉宫传蜡烛”的下一句', '轻烟散入五侯家', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('43', '“罗浮山下四时春”的下一句', '卢橘杨梅次第新', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('44', '“日啖荔枝三百颗”的下一句', '不辞长作岭南人', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('45', '“采得百花成蜜后”的下一句', '为谁辛苦为谁甜', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('46', '”春眠不觉晓“的下一句。(孟浩然：《春晓》)', '处处闻啼鸟', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('47', '”报得三春晖“的上一句。(孟郊：《游子吟》)', '谁言寸草心', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('48', '“红豆生南国”的下一句。(王维：《相思》)', '春来发几枝', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('49', '”当春乃发生“的上一句。(杜甫：《春夜喜雨》)', '好雨知时节', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('50', '“春色满园关不住”的下一句。（叶绍翁：（《游园不值》）', '一枝红杏出墙来', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('51', '”城春草木深“的上一句。(杜甫：《春望》)', '国破山河在', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('52', '”力尽不知热“的下一句 。(白居易：《观刈麦》', '但惜夏日长', '1', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('53', '_____________，春去夏犹清。(李商隐：《晚晴》)', '深居俯夹城', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('54', '首夏犹清和，_____________ 。(谢灵运：《游赤石进帆海》)', '芳草亦未歇', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('55', '_____________，开轩纳微凉。(杜甫：《夏夜叹》)', '仲夏苦夜短', '0', null, '10', null);
INSERT INTO `bank_fill_que` VALUES ('56', '农夫方夏耘，_____________ 。(戴复古：《大热》)', '安坐吾敢食', '1', null, '10', null);
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
INSERT INTO `bank_fill_que` VALUES ('68', '看图写诗句', '亲朋无一字', '1', null, '11', 'http://qa3asqugo.bkt.clouddn.com/h3.png');
INSERT INTO `bank_fill_que` VALUES ('69', '看图写诗句', '明月松间照', '1', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h4.png');
INSERT INTO `bank_fill_que` VALUES ('70', '看图写诗句', '半江瑟瑟半江红', '0', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h5.png');
INSERT INTO `bank_fill_que` VALUES ('71', '看图写诗句', '没在石棱中', '1', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h6.png');
INSERT INTO `bank_fill_que` VALUES ('72', '看图写诗句', '万紫千红总是春', '1', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h7.png');
INSERT INTO `bank_fill_que` VALUES ('73', '看图写诗句', '待到重阳日', '1', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h8.png');
INSERT INTO `bank_fill_que` VALUES ('74', '看图写诗句', '一览众山小', '1', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h9.png');
INSERT INTO `bank_fill_que` VALUES ('75', '看图写诗句', '众里寻他千百度', '1', '', '11', 'http://qa3asqugo.bkt.clouddn.com/h10.png');

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
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_judge_que
-- ----------------------------
INSERT INTO `bank_judge_que` VALUES ('25', '“过尽千帆皆不是”是韦庄的词句。', 'F', '1', '是温庭筠的《望江南·梳洗罢》', '13');
INSERT INTO `bank_judge_que` VALUES ('26', '《花间集》里边的第一首歌词是《菩萨蛮》。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('27', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('28', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', '', '13');
INSERT INTO `bank_judge_que` VALUES ('29', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', '', '13');
INSERT INTO `bank_judge_que` VALUES ('30', '清朝的张惠言说温庭筠的这首《菩萨蛮》是“感士不遇也”。', 'T', '1', '', '13');
INSERT INTO `bank_judge_que` VALUES ('101', '“解落山秋叶，能开二月花”中的“三秋”是指三个秋天。', 'F', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('102', '苏轼是“唐宋八大家”之一。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('103', '“吟”是古代诗歌的一种名称，和“歌”、“曲”相似。', 'F', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('104', '卢纶是唐代著名的诗人，是“大历十大才子”之一。', 'T', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('105', '“独怜幽草涧边生”中的“独怜”是“孤独，寂寞”的意思。', 'F', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('106', '“千门万户曈曈日，总把新桃换旧符”这里的桃符指的是对联。', 'T', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('107', '文学史上被称为“诗鬼”的是唐代诗人李贺。', 'T', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('108', '《搜神记》是一部志怪小说集，作者是东晋的干宝。', 'T', '1', null, '13');
INSERT INTO `bank_judge_que` VALUES ('109', '文学史上的“苏辛”是婉约词派苏轼、辛弃疾的合称', 'F', '1', '二人同为豪放词派的代表', '13');
INSERT INTO `bank_judge_que` VALUES ('110', '提出文章“合为时而著，歌诗合为事而作”文学主张的是杜甫。', 'F', '0', '此句出自新乐府运动倡导者白居易', '13');
INSERT INTO `bank_judge_que` VALUES ('111', '张君瑞和崔莺莺是元曲戏曲《西厢记》中的主要人物。', 'F', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('112', '古人用于天干、地支纪年，天干有12个，地支有10个。', 'F', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('113', '古诗文常提到“花中四君子”，分别是梅、兰、竹、桂。', 'F', '0', null, '13');
INSERT INTO `bank_judge_que` VALUES ('114', '明朝时期，科举制度完备，考试分为四级，院试、乡试、会试、殿试。', 'F', '0', null, '13');

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
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bank_single_choice_que
-- ----------------------------
INSERT INTO `bank_single_choice_que` VALUES ('39', '\"拱手而立\"表示对长者的尊敬，一般来说，男子行拱手礼时应该：', 'A、左手在外', 'B、右手在外', null, null, null, null, null, 'A', '1', '解析测试测试测试测试测试测试测试测试', '12');
INSERT INTO `bank_single_choice_que` VALUES ('40', '《三十六计》是体现我国古代卓越军事思想的一部兵书，下列不属于《三十六计》的是：', 'A、浑水摸鱼', 'B、反戈一击', 'C、笑里藏刀', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('41', '“但使龙城飞将在，不教胡马度阴山”中的“飞将”指像（  ）那样的将士。', 'A、张飞', 'B、李广', 'C、霍去病', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('42', '形容月亮的诗甚多，下列那一句与月亮无关？', 'A、团团冰镜吐清辉', 'B、玉蝉离海上', 'C、大珠小珠落玉盘', null, null, null, null, 'C', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('43', '“字字看来都是血，十年辛苦不寻常”是下列哪位名家对自己作品的“自评诗”？', 'A、施耐庵《水浒传》', 'B、吴承恩《西游记》', 'C、曹雪芹《红楼梦》', null, null, null, null, 'C', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('44', '诗经的《硕鼠硕鼠，无食我黍》诗中“黍”指的是那种农作物？', 'A、高粱', 'B、黄米', 'C、谷子', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('45', '杜甫《春夜喜雨》“晓看红湿处，花重锦官城”锦官城是指如今的何处？', 'A、成都', 'B、重庆', 'C、洛阳', null, null, null, null, 'A', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('46', '“不为五斗米折腰”源于对我国哪位诗人高尚气节的评价？', 'A、李白', 'B、陶渊明', 'C、苏轼', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('49', '“昔年有狂客，号尔谪仙人”，诗中“谪仙人”指哪位诗人：', 'A、李白', 'B、杜甫', 'C、苏轼', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('50', '杜甫笔下“功盖三分国，名成八阵图”是赞扬哪位历史人物：', 'A、汉武帝', 'B、诸葛亮', 'C、刘邦', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('51', '下列哪句不是描写西湖美景？', 'A、接天莲叶无穷碧，映日荷花别样红', 'B、水光潋滟晴方好，山色空濛雨亦奇', 'C、湖光秋月两相和，潭面无风镜未磨', null, null, null, null, 'C', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('52', '《凤求凰》演绎的是哪一对情侣的爱情故事？', 'A、李清照和赵明诚', 'B、卓文君和司马相如', 'C、范蠡和西施', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('53', '“小蛮腰”的说法出自哪位文学家？', 'A、晏几道', 'B、白居易', 'C、温庭筠', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('54', '李白曾说“眼前有景道不得，崔郎题诗在上头”的诗是哪一首？', 'A、《登鹳雀楼》', 'B、《登黄鹤楼》', 'C、《登金陵凤凰台》', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('55', '下列哪位诗人凭借哪首诗，赢得了“以孤篇压倒全唐”的美誉？', 'A、陈子昂《登幽州台歌》', 'B、张若虚《春江花月夜》', 'C、杨炯《从军行》', null, null, null, null, 'B', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('56', '“十五好剑术，遍干诸侯。三十成文章，历抵卿相。”指的是哪位诗人？', 'A、辛弃疾', 'B、李白', 'C、王昌龄', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('57', '唐代哪位诗人留存的诗作最多？', 'A、白居易', 'B、李白', 'C、杜甫', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('58', '高适《别董大》，董大的职业是', 'A、琴师', 'B、词人', 'C、厨师', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('59', '《敕勒歌》是由当时哪种语言翻译成汉语的', 'A、鲜卑语', 'B、蒙古语', 'C、维吾尔语', null, null, null, null, 'A', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('60', '诗经《蒹葭》，蒹葭指的是哪一种植物', 'A、芦苇', 'B、莞荽', 'C、水仙', null, null, null, null, 'A', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('61', '诗经《木瓜》“报之以琼琚”，琼琚指的是', 'A、美女', 'B、美食', 'C、美玉', null, null, null, null, 'C', '1', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('62', '“春宵一刻值千金”出自宋代哪位名人之手', 'A、柳永', 'B、苏轼', 'C、李煜', null, null, null, null, 'B', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('64', '无为在 ___ 路，儿女共沾巾。', '歧', '岐', '骑', '其', '起', '企', null, 'A', '0', '', '14');
INSERT INTO `bank_single_choice_que` VALUES ('65', '众女嫉余之 ___ 眉兮，谣诼谓余以善淫。', '蛾', '鹅', '娥', '饿', '额', '俄', null, 'A', '0', null, '14');
INSERT INTO `bank_single_choice_que` VALUES ('66', '秋风 ___ 瑟，洪波涌起', '萧', '潇', '箫', '笑', '消', '肖', null, 'A', '0', null, '14');
INSERT INTO `bank_single_choice_que` VALUES ('67', '根据以下提示词，写出所描述的诗人', '女性', '宋朝', '赌书', null, null, null, null, '李清照', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('78', '根据以下提示词，写出所描述的诗人', '长安', '酒', '诗仙', null, null, null, null, '李白', '0', '', '15');
INSERT INTO `bank_single_choice_que` VALUES ('79', '根据以下提示词，写出所描述的诗人', '婉约', '第七', '蓦然回首', null, null, null, null, '柳永', '0', '', '15');
INSERT INTO `bank_single_choice_que` VALUES ('87', '根据以下提示词，写出所描述的诗人', '初唐四杰', '浙江义乌', '观光', null, null, null, null, '骆宾王', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('88', '根据以下提示词，写出所描述的诗人', '采菊', '彭泽令', '五柳', null, null, null, null, '陶渊明', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('89', '根据以下提示词，写出所描述的诗人', '野火', '中唐', '琵琶行', null, null, null, null, '白居易', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('90', '根据以下提示词，写出所描述的诗人', '田园', '诗佛', '诗中有画', null, null, null, null, '王维', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('91', '根据以下提示词，写出所描述的诗人', '丹心', '东市', '正气歌', null, null, null, null, '文天祥', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('92', '根据以下提示词，写出所描述的诗人', '乌台诗案', '河东狮吼', '泛舟赤壁', null, null, null, null, '苏轼', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('93', '根据以下提示词，写出所描述的诗人', '浪漫', '长相独特', '三李', null, null, null, null, '李贺', '0', null, '15');
INSERT INTO `bank_single_choice_que` VALUES ('110', '“温故而知新，可以为师矣”出自', '论语', '孟子', '礼记', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('111', '“一道残阳铺水中，半江瑟瑟半江红”的瑟瑟是什么意思', '碧绿', '寒冷', '寂寥', null, null, null, null, 'A', '0', null, '12');
INSERT INTO `bank_single_choice_que` VALUES ('112', '“挥手自兹去，萧萧班马鸣”的班马指什么', '有花纹的马', '离群的马', '以班固，司马迁喻人', null, null, null, null, 'B', '0', null, '12');

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
  `feedback_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '0' COMMENT '留言状态0为管理员未读，1为管理员已读',
  `reply_time` datetime DEFAULT NULL COMMENT '管理员回复时间',
  PRIMARY KEY (`feedback_id`),
  KEY `feedback_ano` (`ano`),
  KEY `feedback_user_phone` (`user_phone`) USING BTREE,
  CONSTRAINT `feedback_ano` FOREIGN KEY (`ano`) REFERENCES `admin` (`ano`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('152', '可以再多一点题型嘛', '2020-03-23 20:21:19', '11111111112', '咕咕咕', '技术小哥努力ing', '123456', '小张', '1', '2020-03-23 20:34:29');
INSERT INTO `feedback` VALUES ('153', '难度可以再大点', '2020-03-23 20:42:39', '11111111113', '哈哈', null, null, null, '1', null);
INSERT INTO `feedback` VALUES ('155', '可以多来点科举嘛', '2020-04-01 06:09:59', '15280406892', 'cf', null, null, null, '1', null);
INSERT INTO `feedback` VALUES ('156', '我很喜欢', '2020-04-02 04:57:15', '11222222222', '这么大一个警花', null, null, null, '1', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('12', '燕子归来 · 诗词大会', '2020-03-04 10:33:55', '6000', '4', '', '2', '41', 'http://qa3asqugo.bkt.clouddn.com/2.png');
INSERT INTO `paper` VALUES ('13', '女生节 · 诗词大会', '2020-03-04 10:52:29', '600', '5', '', '1', '8', 'http://qa3asqugo.bkt.clouddn.com/6.jpg');
INSERT INTO `paper` VALUES ('14', '惊蛰 · 诗词大会', '2020-03-12 16:26:52', '1800', '5', '', '1', '9', 'http://qa3asqugo.bkt.clouddn.com/4.png');
INSERT INTO `paper` VALUES ('15', '龙抬头 · 诗词大会', '2020-04-02 05:25:48', '600', '4', '', '2', '3', 'http://qa3asqugo.bkt.clouddn.com/1.png');
INSERT INTO `paper` VALUES ('16', '春分 · 诗词大会', '2020-04-02 05:26:19', '600', '4', '', '1', '7', 'http://qa3asqugo.bkt.clouddn.com/2.png');
INSERT INTO `paper` VALUES ('18', '随机', '2020-05-27 06:41:03', '600', null, '', '1', '1', 'http://qa3asqugo.bkt.clouddn.com/programImages/d1b01122-7bd0-4a6d-b9c0-ac5cc18b709f');
INSERT INTO `paper` VALUES ('19', '固定', '2020-05-27 06:52:54', '600', null, '', '2', '1', 'http://qa3asqugo.bkt.clouddn.com/programImages/c37d41f4-450c-4bb0-a6c6-451e47d1400b');

-- ----------------------------
-- Table structure for paper_que
-- ----------------------------
DROP TABLE IF EXISTS `paper_que`;
CREATE TABLE `paper_que` (
  `que_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '问题id',
  `que_type` int(11) DEFAULT NULL COMMENT '题类型',
  `single_id` int(11) DEFAULT NULL COMMENT '单选题id',
  `multiple_id` int(11) DEFAULT NULL,
  `judge_id` int(11) DEFAULT NULL COMMENT '判断题id',
  `fill_id` int(11) DEFAULT NULL COMMENT '填空题id',
  `paper_id` int(11) DEFAULT NULL COMMENT '试卷id',
  PRIMARY KEY (`que_id`),
  KEY `que_single_id` (`single_id`),
  KEY `que_judge_id` (`judge_id`),
  KEY `que_fill_id` (`fill_id`),
  KEY `que_paper_id` (`paper_id`),
  CONSTRAINT `que_fill_id` FOREIGN KEY (`fill_id`) REFERENCES `bank_fill_que` (`fill_id`),
  CONSTRAINT `que_judge_id` FOREIGN KEY (`judge_id`) REFERENCES `bank_judge_que` (`judge_id`),
  CONSTRAINT `que_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `paper` (`paper_id`),
  CONSTRAINT `que_single_id` FOREIGN KEY (`single_id`) REFERENCES `bank_single_choice_que` (`single_id`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8;

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
INSERT INTO `paper_que` VALUES ('272', '1', '40', null, null, null, '15');
INSERT INTO `paper_que` VALUES ('273', '1', '41', null, null, null, '15');
INSERT INTO `paper_que` VALUES ('274', '1', '42', null, null, null, '15');
INSERT INTO `paper_que` VALUES ('275', '2', null, null, '26', null, '15');
INSERT INTO `paper_que` VALUES ('276', '2', null, null, '27', null, '15');
INSERT INTO `paper_que` VALUES ('277', '3', null, null, null, '35', '15');
INSERT INTO `paper_que` VALUES ('278', '4', null, null, null, '38', '15');
INSERT INTO `paper_que` VALUES ('279', '1', '42', null, null, null, '16');
INSERT INTO `paper_que` VALUES ('280', '1', '50', null, null, null, '16');
INSERT INTO `paper_que` VALUES ('281', '2', null, null, '29', null, '16');
INSERT INTO `paper_que` VALUES ('282', '2', null, null, '27', null, '16');
INSERT INTO `paper_que` VALUES ('283', '3', null, null, null, '56', '16');
INSERT INTO `paper_que` VALUES ('284', '3', null, null, null, '46', '16');
INSERT INTO `paper_que` VALUES ('285', '4', null, null, null, '75', '16');
INSERT INTO `paper_que` VALUES ('286', '4', null, null, null, '74', '16');
INSERT INTO `paper_que` VALUES ('327', '1', '53', null, null, null, '18');
INSERT INTO `paper_que` VALUES ('328', '1', '45', null, null, null, '18');
INSERT INTO `paper_que` VALUES ('329', '2', null, null, '109', null, '18');
INSERT INTO `paper_que` VALUES ('330', '3', null, null, null, '43', '18');
INSERT INTO `paper_que` VALUES ('331', '4', null, null, null, '72', '18');
INSERT INTO `paper_que` VALUES ('332', '1', '39', null, null, null, '19');
INSERT INTO `paper_que` VALUES ('333', '1', '40', null, null, null, '19');

-- ----------------------------
-- Table structure for post_label
-- ----------------------------
DROP TABLE IF EXISTS `post_label`;
CREATE TABLE `post_label` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `posts_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_label
-- ----------------------------
INSERT INTO `post_label` VALUES ('1', '题目贴', '用户讨论原创题目或系统中的题目', '4');
INSERT INTO `post_label` VALUES ('2', '闲话贴', '用户交流诗词学习的经历等', '9');

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
  `lang_main_type` int(11) DEFAULT NULL COMMENT '题型主要展示形式，1选择 2判断 3填空',
  `lang_en_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '题型英文名，匹配前端图标',
  PRIMARY KEY (`lang_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO `question_type` VALUES ('10', '承上启下', '写出题目诗句的上句或下句', 'http://q6b41spn5.bkt.clouddn.com/1.png', '2020-03-04 10:06:23', null, null, '3', 'fill1');
INSERT INTO `question_type` VALUES ('11', '画中有话', '根据图片写出所描绘的诗句', 'http://q6b41spn5.bkt.clouddn.com/2.png', '2020-03-04 10:07:08', null, null, '3', 'fill2');
INSERT INTO `question_type` VALUES ('12', '百里挑一', '从选项中选出唯一正确的选项', 'http://q6b41spn5.bkt.clouddn.com/1.png', null, null, null, '1', 'single1');
INSERT INTO `question_type` VALUES ('13', '分秒必争', '判断对错', 'http://q6b41spn5.bkt.clouddn.com/2.png', null, null, '2020-03-24 10:30:07', '2', 'judge1');
INSERT INTO `question_type` VALUES ('14', '眼花缭乱', '选择正确的汉字', null, null, null, '2020-03-31 16:56:24', '1', 'single2');
INSERT INTO `question_type` VALUES ('15', '剥丝抽茧', '根据依次给出的提示，填写诗人姓名', null, null, null, null, '1', 'single3');

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
INSERT INTO `user` VALUES ('11111111112', '2bf122570d7f7a9ba96448355b02cbc2', '咕咕咕', 'http://qa3asqugo.bkt.clouddn.com/t8.jpg', '啊', '女');
INSERT INTO `user` VALUES ('11111111113', '2bf122570d7f7a9ba96448355b02cbc2', '哈哈', 'http://qa3asqugo.bkt.clouddn.com/t7.jpg', '停云霭霭', '男');
INSERT INTO `user` VALUES ('11111111114', '2bf122570d7f7a9ba96448355b02cbc2', '测试', 'http://qa3asqugo.bkt.clouddn.com/t6.jpg', null, '女');
INSERT INTO `user` VALUES ('11112222222', '2bf122570d7f7a9ba96448355b02cbc2', '羲兮', 'http://qa3asqugo.bkt.clouddn.com/t5.jpg', null, '女');
INSERT INTO `user` VALUES ('11122222222', '7926db052a275e422091fa1c5f5bbb91', '山牙子', 'http://qa3asqugo.bkt.clouddn.com/t4.jpg', null, '男');
INSERT INTO `user` VALUES ('11222222222', '2bf122570d7f7a9ba96448355b02cbc2', '这么大一个警花', 'http://qa3asqugo.bkt.clouddn.com/t3.jpg', null, '男');
INSERT INTO `user` VALUES ('12345678900', '2bf122570d7f7a9ba96448355b02cbc2', '123456', 'http://qa3asqugo.bkt.clouddn.com/t2.jpg', null, '男');
INSERT INTO `user` VALUES ('13518866137', '2bf122570d7f7a9ba96448355b02cbc2', '注册测试', null, null, '男');
INSERT INTO `user` VALUES ('15280406892', '2bf122570d7f7a9ba96448355b02cbc2', 'cf', 'http://qa3asqugo.bkt.clouddn.com/t1.jpg', '飞入寻常百姓家', '女');

-- ----------------------------
-- Table structure for user_like_post
-- ----------------------------
DROP TABLE IF EXISTS `user_like_post`;
CREATE TABLE `user_like_post` (
  `like_id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) DEFAULT NULL,
  `user_phone` char(11) NOT NULL,
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_like_post
-- ----------------------------
INSERT INTO `user_like_post` VALUES ('12', '1', '11111111112');
INSERT INTO `user_like_post` VALUES ('39', '12', '15280406892');
INSERT INTO `user_like_post` VALUES ('40', '13', '15280406892');
INSERT INTO `user_like_post` VALUES ('41', '16', '11112222222');
INSERT INTO `user_like_post` VALUES ('42', '13', '11112222222');
INSERT INTO `user_like_post` VALUES ('43', '7', '11112222222');
INSERT INTO `user_like_post` VALUES ('48', '17', '15280406892');

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
) ENGINE=InnoDB AUTO_INCREMENT=999 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_paper_answer
-- ----------------------------
INSERT INTO `user_paper_answer` VALUES ('710', 'A', '1', '162', '12', '1', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('711', 'A', '0', '163', '12', '1', '11112222222');
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
INSERT INTO `user_paper_answer` VALUES ('830', 'A', '1', '177', '13', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('831', 'T', '0', '178', '13', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('832', '要是手速所', '0', '179', '13', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('833', '西北望长安', '1', '180', '13', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('834', 'A', '0', '272', '15', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('835', 'A', '0', '273', '15', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('836', 'A', '0', '274', '15', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('837', 'T', '1', '275', '15', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('838', 'T', '1', '276', '15', '1', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('839', '疑是地上霜', '1', '277', '15', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('840', '西北望长安', '1', '278', '15', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('841', 'C', '1', '279', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('842', 'B', '1', '280', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('843', 'F', '0', '281', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('844', 'F', '0', '282', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('845', '不会', '0', '283', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('846', '处处闻啼鸟', '1', '284', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('847', '自然用上线', '0', '285', '16', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('848', '自然用上线', '0', '286', '16', '1', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('849', 'B', '1', '272', '15', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('850', 'B', '1', '273', '15', '1', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('851', 'C', '1', '274', '15', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('852', 'F', '0', '275', '15', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('853', 'F', '0', '276', '15', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('854', '疑是地上霜', '1', '277', '15', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('855', '西北望长安', '1', '278', '15', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('856', 'B', '1', '272', '15', '1', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('857', 'B', '1', '273', '15', '1', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('858', 'C', '1', '274', '15', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('859', 'F', '0', '275', '15', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('860', 'F', '0', '276', '15', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('861', '疑是地上霜', '1', '277', '15', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('862', '西北望长安', '1', '278', '15', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('863', 'C', '1', '279', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('864', 'B', '1', '280', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('865', 'F', '0', '281', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('866', 'F', '0', '282', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('867', '我不会', '0', '283', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('868', '处处闻啼鸟', '1', '284', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('869', '众', '0', '285', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('870', '众', '0', '286', '16', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('871', 'A', '1', '181', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('872', 'B', '1', '182', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('873', 'C', '0', '183', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('874', 'F', '1', '184', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('875', 'F', '0', '185', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('876', '疑是地上霜', '1', '186', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('877', '处处闻啼鸟', '0', '187', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('878', '西北望长安', '1', '188', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('879', 'B', '0', '177', '13', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('880', 'F', '1', '178', '13', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('881', '疑是地上霜', '1', '179', '13', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('882', '西北望长安', '1', '180', '13', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('891', 'A', '1', '181', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('892', 'B', '1', '182', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('893', 'C', '0', '183', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('894', 'F', '1', '184', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('895', 'F', '0', '185', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('896', '疑是地上霜', '1', '186', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('897', '处处闻啼鸟', '0', '187', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('898', '西北望长安', '1', '188', '14', '0', '11222222222');
INSERT INTO `user_paper_answer` VALUES ('923', 'A', '0', '279', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('924', 'B', '1', '280', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('925', 'F', '0', '281', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('926', 'F', '0', '282', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('927', '啊', '0', '283', '16', '1', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('928', '啊', '0', '284', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('929', '啊啊啊', '0', '285', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('930', '嗯嗯', '0', '286', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('931', 'C', '1', '279', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('932', 'B', '1', '280', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('933', 'F', '0', '281', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('934', 'F', '0', '282', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('935', '我不会', '0', '283', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('936', '处处闻啼鸟', '1', '284', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('937', '这个是', '0', '285', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('938', '有人', '0', '286', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('939', 'C', '1', '279', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('940', 'B', '1', '280', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('941', 'C', '1', '279', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('942', 'F', '0', '281', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('943', 'B', '1', '280', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('944', 'F', '0', '282', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('945', 'F', '0', '281', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('946', 'F', '0', '282', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('947', '我不会', '0', '283', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('948', '我不会', '0', '283', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('949', '处处闻啼鸟', '1', '284', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('950', '处处闻啼鸟', '1', '284', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('951', '这个是', '0', '285', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('952', '这个是', '0', '285', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('953', '有人', '0', '286', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('954', '有人', '0', '286', '16', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('955', 'B', '0', '177', '13', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('956', 'F', '1', '178', '13', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('957', '啊', '0', '179', '13', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('958', '暗暗', '0', '180', '13', '0', '11112222222');
INSERT INTO `user_paper_answer` VALUES ('992', 'A', '0', '327', '18', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('993', 'A', '1', '328', '18', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('994', 'F', '1', '329', '18', '1', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('995', '不会', '0', '330', '18', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('996', '不会', '0', '331', '18', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('997', 'A', '1', '332', '19', '0', '15280406892');
INSERT INTO `user_paper_answer` VALUES ('998', 'A', '0', '333', '19', '0', '15280406892');

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
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_paper_score
-- ----------------------------
INSERT INTO `user_paper_score` VALUES ('80', '3', '67189', '2020-03-05 15:27:05', '2020-03-05 15:28:12', '12', '11112222222');
INSERT INTO `user_paper_score` VALUES ('86', '5', '109005', '2020-03-07 10:57:40', '2020-03-07 10:59:29', '12', '11111111113');
INSERT INTO `user_paper_score` VALUES ('87', '2', '28297', '2020-03-07 18:26:59', '2020-03-07 18:27:27', '13', '11111111113');
INSERT INTO `user_paper_score` VALUES ('111', '2', '18262', '2020-04-02 06:38:26', '2020-04-02 06:38:44', '13', '15280406892');
INSERT INTO `user_paper_score` VALUES ('112', '4', '20186', '2020-04-02 06:46:23', '2020-04-02 06:46:44', '15', '11112222222');
INSERT INTO `user_paper_score` VALUES ('113', '3', '62523', '2020-04-02 07:09:53', '2020-04-02 07:10:55', '16', '15280406892');
INSERT INTO `user_paper_score` VALUES ('114', '5', '26444', '2020-04-02 07:12:05', '2020-04-02 07:12:32', '15', '15280406892');
INSERT INTO `user_paper_score` VALUES ('115', '5', '23038', '2020-04-08 11:41:52', '2020-04-08 11:42:15', '15', '11222222222');
INSERT INTO `user_paper_score` VALUES ('116', '3', '603316', '2020-04-08 11:49:24', '2020-04-08 11:59:27', '16', '11222222222');
INSERT INTO `user_paper_score` VALUES ('117', '5', '1803611', '2020-04-08 12:03:36', '2020-04-08 12:19:27', '14', '11222222222');
INSERT INTO `user_paper_score` VALUES ('118', '3', '21973', '2020-04-08 12:08:19', '2020-04-08 12:08:41', '13', '11222222222');
INSERT INTO `user_paper_score` VALUES ('123', '3', '603991', '2020-04-08 12:31:51', '2020-04-08 12:32:37', '16', '11112222222');
INSERT INTO `user_paper_score` VALUES ('124', '1', '41359', '2020-04-08 12:33:12', '2020-04-08 12:33:53', '13', '11112222222');
INSERT INTO `user_paper_score` VALUES ('129', '2', '20043', '2020-05-27 06:41:45', '2020-05-27 06:42:05', '18', '15280406892');
INSERT INTO `user_paper_score` VALUES ('130', '1', '4729', '2020-05-27 06:53:33', '2020-05-27 06:53:37', '19', '15280406892');

-- ----------------------------
-- Table structure for user_post
-- ----------------------------
DROP TABLE IF EXISTS `user_post`;
CREATE TABLE `user_post` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `init_time` datetime DEFAULT NULL,
  `label_id` int(11) DEFAULT NULL,
  `replay_count` int(255) unsigned zerofill DEFAULT NULL,
  `top` int(255) unsigned zerofill DEFAULT NULL,
  `good` int(11) unsigned zerofill DEFAULT NULL,
  `user_phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `pid` (`pid`) USING BTREE,
  KEY `userphone` (`user_phone`),
  CONSTRAINT `userphone` FOREIGN KEY (`user_phone`) REFERENCES `user` (`user_phone`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_post
-- ----------------------------
INSERT INTO `user_post` VALUES ('1', '测试测试从', '测试', '2020-03-29 11:03:06', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '00000000001', '11111111113');
INSERT INTO `user_post` VALUES ('7', '多情应是我', '慕寒', '2020-03-30 11:03:47', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000002', null, '00000000001', '11111111112');
INSERT INTO `user_post` VALUES ('8', '身负行囊，北方向南方。\n琴歌送我，琴歌声长过路长。\n斟酒作别就他乡，谈笑也匆忙。\n今终归，坐当初小楼旧轩窗。', '十年一晌', '2020-03-30 11:10:42', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000004', null, '00000000000', '11112222222');
INSERT INTO `user_post` VALUES ('9', '啦啦啦啦啦', '来聊天啦', '2020-04-01 02:05:52', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', null, '00000000000', '15280406892');
INSERT INTO `user_post` VALUES ('10', '时间测试1421', '', '2020-04-01 06:21:22', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', null, '00000000000', '15280406892');
INSERT INTO `user_post` VALUES ('11', '测试', '', '2020-04-01 07:21:14', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', null, '00000000000', '15280406892');
INSERT INTO `user_post` VALUES ('12', '松香接地走\n挥癯龙绣虎出怀袖\n起微石落海连波动\n描数曲箜篌线同轴\n勒笔烟直大漠 沧浪盘虬\n一纸淋漓漫点方圆透\n记我 长风万里绕指未相勾\n形生意成 此意 逍遥不游', '吹梦到西洲', '2020-04-01 07:51:34', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', null, '00000000001', '15280406892');
INSERT INTO `user_post` VALUES ('13', '百年后却看 六朝故地 流光泰然\n应废墟之中 仍有后人 撑篙而来\n满载了笙歌月一船 烟波清湛\n再拍落细雪如金粉 不肯沾', '雪拥金陵岸', '2020-04-02 00:44:20', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000', null, '00000000002', '15280406892');
INSERT INTO `user_post` VALUES ('14', '我觉得歌词有点复杂。', '《吹梦到西洲》歌词大家觉得怎么样', '2020-04-02 06:02:25', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, null, '11222222222');
INSERT INTO `user_post` VALUES ('16', '“无何化有 感物知春秋”\n无何化有什么意思？', '', '2020-04-09 10:54:23', '1', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000003', null, '00000000001', '15280406892');
INSERT INTO `user_post` VALUES ('17', '发帖', '测试', '2020-05-26 07:13:45', '2', '000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001', null, '00000000001', '15280406892');

-- ----------------------------
-- Table structure for user_replay
-- ----------------------------
DROP TABLE IF EXISTS `user_replay`;
CREATE TABLE `user_replay` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `init_time` datetime DEFAULT NULL,
  `up` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `user_phone` char(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `rid` (`rid`) USING BTREE,
  KEY `pid` (`pid`),
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `user_post` (`pid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_replay
-- ----------------------------
INSERT INTO `user_replay` VALUES ('9', '你远来为客 夜舟枕一溪风月', '2020-03-30 11:04:51', null, '7', '11112222222');
INSERT INTO `user_replay` VALUES ('10', '无端划开我 心头漪涟\n\n寂寞渔火 何处摇曳', '2020-03-30 11:05:27', null, '7', '11112222222');
INSERT INTO `user_replay` VALUES ('11', '我好喜欢', '2020-03-30 11:13:16', null, '8', '11112222222');
INSERT INTO `user_replay` VALUES ('12', '好听哦', '2020-03-30 20:08:58', null, '8', '11222222222');
INSERT INTO `user_replay` VALUES ('13', '初识', '2020-03-31 14:07:03', null, '1', '11112222222');
INSERT INTO `user_replay` VALUES ('14', '慕寒超棒', '2020-04-01 02:02:34', null, '8', '15280406892');
INSERT INTO `user_replay` VALUES ('15', '啊啊啊', '2020-04-01 06:48:48', null, '8', '15280406892');
INSERT INTO `user_replay` VALUES ('17', '确实，不看翻译不知道它在讲些什么。', '2020-04-09 10:46:35', null, '14', '15280406892');
INSERT INTO `user_replay` VALUES ('18', '无何有，典故名，典出《庄子集释》\n卷一上〈内篇·逍遥游〉。\n庄子几次说到“无何有之乡”，指的\n是空无所有的地方。', '2020-04-09 10:55:26', null, '16', '11112222222');
INSERT INTO `user_replay` VALUES ('19', '我也是不知道', '2020-05-26 06:06:40', null, '16', '15280406892');
INSERT INTO `user_replay` VALUES ('20', '测试', '2020-05-26 07:01:07', null, '16', '15280406892');
INSERT INTO `user_replay` VALUES ('21', '评论', '2020-05-26 11:32:26', null, '17', '15280406892');

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_rotation_img
-- ----------------------------
INSERT INTO `user_rotation_img` VALUES ('9', '观山海', 'http://qa3asqugo.bkt.clouddn.com/7.jpg', '2020-04-01 02:42:52', '123456', '星辰');
INSERT INTO `user_rotation_img` VALUES ('10', '观山海', 'http://qa3asqugo.bkt.clouddn.com/8.jpg', '2020-04-01 02:43:37', '123456', '星辰');
INSERT INTO `user_rotation_img` VALUES ('11', '观山海', 'http://qa3asqugo.bkt.clouddn.com/9.jpg', '2020-04-01 02:43:45', '123456', '星辰');
INSERT INTO `user_rotation_img` VALUES ('12', '观山海', 'http://qa3asqugo.bkt.clouddn.com/10.jpg', '2020-04-01 02:43:54', '123456', '星辰');
INSERT INTO `user_rotation_img` VALUES ('13', '观山海', 'http://qa3asqugo.bkt.clouddn.com/11.jpg', '2020-04-01 02:44:06', '123456', '星辰');
INSERT INTO `user_rotation_img` VALUES ('14', '观山海', 'http://qa3asqugo.bkt.clouddn.com/12.jpg', '2020-04-01 02:44:15', '123456', '星辰');
