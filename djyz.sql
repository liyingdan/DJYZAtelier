/*
Navicat MySQL Data Transfer

Source Server         : hhh
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : djyz

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-28 12:34:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `art_describe` varchar(255) DEFAULT NULL,
  `num_support` bigint(20) DEFAULT NULL,
  `num_nonsupport` bigint(20) DEFAULT NULL,
  `num_comment` bigint(20) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '拍摄婚纱的注意事项', '1、随时补妆\r\n\r\n在拍摄过程中，我们也许会有亲吻的镜头。口红可是女人显气色的法宝，决不能丢。在kiss完后，我们要记得补口红。并且在补口红的时候一定用粉扑在我们的嘴巴周围，因为嘴巴周围的热气会使嘴巴周围的皮肤脱妆。如果你的肤色黑黄，那样也会有一圈黄黄的，就不太美啦。2、适当侧身\r\n\r\n拍婚纱照的时候千万不要傻乎乎的正对着镜头，一定要稍稍的偏一点身子，微微颔首。如果我们直直的站着，就会很没有灵气，并且拍出来的效果总是会差很多。3、最佳角度\r\n\r\n每个人都有自己的最佳拍照角度哦，那么自己的最佳角度要怎么找呢。我们可以在拍照前，试着自己给自己各方面拍一组照片，然后问问身边好朋友的意见，这样应该就能准确的找出自己的最佳角度了哟。4、坐姿体态\r\n\r\n姿态优美，体态轻盈是对一个女孩子外表最好的评价。拍婚纱照之前，我们一定要在家多练习自己的体态问题。因为现在的工作环境，很多人都有脖子前倾的问题，而这一点真的很影响个人气质。为了拍出优美的坐姿，请记住，除了身体要坐直外，双腿还应在脚踝处相交。5、花束握法\r\n\r\n一般在我们拍照的时候都会用到很多道具，而手捧花就是其中一种。要想自己拍照不死板，我们应在在腰际线上将花束握于身前，胳膊从髋部略向外张开即可。如果胳膊完全张开，我们将会显得更高大些。还有一种松散的握法，就是一只手随意握着花，另一只手在身边自然下垂，这种握法看起来更为放松。6、放松微笑\r\n\r\n有些时候新人在拍照时会因为太紧张，而忘记了微笑，从而使得表情太冷酷、毫无表情、毫无情感。如果不知道摆什么姿势，那就放轻松微笑吧。在家对着镜子多笑笑，找到自己最美的微笑。放轻松，人在紧张状态下，是拍不出好照片的。\r\n', '随时补妆在拍摄过程中', '3', '3', '3', '3');
INSERT INTO `article` VALUES ('2', '怎样才能拍出适合自己的艺术写真？', '1、了解你，你的性格、了解你的故事\r\n2、要有时间去了解摄影师，互相了解，如何拍，怎么引导\r\n3、信任是开始大概构思一下，然后找到你喜欢的写真的照片，发给摄影师，然后为什么喜欢？\r\n是不是真的适合你？\r\n好看的并不一定都适合。\r\n定风格、\r\n选时间、\r\n定地点、\r\n准备衣服、准备妆容、准备情绪\r\n摄影师准备光线、器材、辅助道具等\r\n\r\n然后开始拍吧\r\n', '了解你，你的性格', '3', '1', '1', '2');
INSERT INTO `article` VALUES ('5', '三亚湾哪片海滩风景最好？\r\n', '沿着三亚湾路背对着市区一直往亚太国际会议酒店方向走，你会经过人迹稀少的沙滩。觉得会让你满意！景美，人少。\r\n', '沿着三亚湾背对着', '3', '2', null, '1');

-- ----------------------------
-- Table structure for clothes_order
-- ----------------------------
DROP TABLE IF EXISTS `clothes_order`;
CREATE TABLE `clothes_order` (
  `clo_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '衣服订单id',
  `clothes_id` bigint(20) DEFAULT NULL COMMENT '订单对应衣服id',
  `custmer_id` bigint(20) DEFAULT NULL COMMENT '租赁客户',
  `clothes_order_state` bigint(20) DEFAULT NULL COMMENT '订单状态',
  `clothes_order_date` date DEFAULT NULL,
  PRIMARY KEY (`clo_order_id`),
  KEY `clothes_id` (`clothes_id`),
  KEY `custmer_id` (`custmer_id`),
  KEY `clothes_order_state` (`clothes_order_state`),
  CONSTRAINT `clothes_order_ibfk_1` FOREIGN KEY (`clothes_id`) REFERENCES `rent_clothes` (`clo_id`),
  CONSTRAINT `clothes_order_ibfk_2` FOREIGN KEY (`custmer_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `clothes_order_ibfk_3` FOREIGN KEY (`clothes_order_state`) REFERENCES `clothes_order_state` (`cos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes_order
-- ----------------------------
INSERT INTO `clothes_order` VALUES ('2', '3', '1', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('27', '3', '2', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('28', '8', '2', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('30', '6', '2', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('31', '5', '2', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('36', '4', '2', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('37', '5', '2', '1', '2019-06-24');
INSERT INTO `clothes_order` VALUES ('41', '4', '2', '1', '2019-06-26');

-- ----------------------------
-- Table structure for clothes_order_state
-- ----------------------------
DROP TABLE IF EXISTS `clothes_order_state`;
CREATE TABLE `clothes_order_state` (
  `cos_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cos_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cos_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes_order_state
-- ----------------------------
INSERT INTO `clothes_order_state` VALUES ('1', '已预约');
INSERT INTO `clothes_order_state` VALUES ('2', '已借出');
INSERT INTO `clothes_order_state` VALUES ('3', '已归还');

-- ----------------------------
-- Table structure for clothes_type
-- ----------------------------
DROP TABLE IF EXISTS `clothes_type`;
CREATE TABLE `clothes_type` (
  `clo_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clo_type_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`clo_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clothes_type
-- ----------------------------
INSERT INTO `clothes_type` VALUES ('1', '礼服');
INSERT INTO `clothes_type` VALUES ('2', '婚纱');
INSERT INTO `clothes_type` VALUES ('3', '汉服');
INSERT INTO `clothes_type` VALUES ('4', 'cosplay');

-- ----------------------------
-- Table structure for combo
-- ----------------------------
DROP TABLE IF EXISTS `combo`;
CREATE TABLE `combo` (
  `co_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `co_name` varchar(20) DEFAULT NULL,
  `co_picture` varchar(255) DEFAULT NULL,
  `co_type` bigint(20) DEFAULT NULL,
  `co_desc` varchar(100) DEFAULT NULL,
  `detail_pic1` varchar(255) DEFAULT NULL,
  `detail_pic2` varchar(255) DEFAULT NULL,
  `detail_pic3` varchar(255) DEFAULT NULL,
  `detail_pic4` varchar(255) DEFAULT NULL,
  `detail_pic5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`co_id`),
  KEY `type` (`co_type`),
  CONSTRAINT `combo_ibfk_1` FOREIGN KEY (`co_type`) REFERENCES `combotype` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combo
-- ----------------------------
INSERT INTO `combo` VALUES ('3', '入骨相思', 'com23.png', '1', '无', 'comb1.jpg', 'comb2.jpg', 'comb3.jpg', 'comb4.jpg', 'comb5.jpg');
INSERT INTO `combo` VALUES ('4', '倾心情恋', 'com27.png', '1', '无', 'comb6.jpg', 'comb7.jpg', 'comb8.jpg', 'comb9.jpg', 'comb10.jpg');
INSERT INTO `combo` VALUES ('5', '浪漫时光', 'com28.png', '1', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('6', '巴黎诱惑', 'com32.png', '1', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('7', '一幕芳华', 'com29.png', '1', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('8', '湛蓝点黛', 'com36.png', '1', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('9', '低头浅笑', 'com25.png', '2', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('10', '沧旌踏歌', 'com35.png', '3', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('11', '冷瞳少女', 'com34.png', '3', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('12', '唤醒秋日', 'com22.png', '3', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('13', '桥栈溪水', 'com20.png', '3', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('14', '微笑向暖', 'com38.png', '3', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('15', '拥抱爱情', 'com39.png', '3', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('16', '南以蓝暖', 'com29.png', '4', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('17', '怦然心动', 'com29.png', '4', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('18', '橙色心意', 'com32.png', '5', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('19', '盛夏流年', 'com36.png', '6', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('20', '最好的时光', 'com35.png', '7', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('21', '豆蔻夏时', 'com28.png', '8', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');
INSERT INTO `combo` VALUES ('22', '青春小诗', 'com34.png', '8', '无', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg', 'comb6.jpg');

-- ----------------------------
-- Table structure for combotype
-- ----------------------------
DROP TABLE IF EXISTS `combotype`;
CREATE TABLE `combotype` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT,
  `tname` varchar(50) DEFAULT NULL,
  `tdec` varchar(100) DEFAULT NULL,
  `tpicture` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combotype
-- ----------------------------
INSERT INTO `combotype` VALUES ('1', '婚纱摄影', '愿此间，山有木兮卿有意', 'type2.jpg');
INSERT INTO `combotype` VALUES ('2', '古风特写', '鲜花怒马少年时，一日看尽长安花', 'type4.jpg');
INSERT INTO `combotype` VALUES ('3', '个人写真', '我不是归人，我是过客', 'type1.jpg');
INSERT INTO `combotype` VALUES ('4', '情侣写真', '你若是天父，我必然是最虔诚的教徒', 'type7.jpg');
INSERT INTO `combotype` VALUES ('5', '童年记忆', '小时候也是同一个我，用一个下午的时间看蚂蚁搬家，等石头开花', 'type6.jpg');
INSERT INTO `combotype` VALUES ('6', '毕业季', '岁月极美，在于它必然的流逝', 'type5.JPEG');
INSERT INTO `combotype` VALUES ('7', '亲子照', '团圆--', 'type3.jpg');
INSERT INTO `combotype` VALUES ('8', 'cosplay', '无', 'type8.jpg');

-- ----------------------------
-- Table structure for combo_location
-- ----------------------------
DROP TABLE IF EXISTS `combo_location`;
CREATE TABLE `combo_location` (
  `cid` bigint(20) NOT NULL,
  `lid` bigint(20) NOT NULL,
  `combo_price` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`cid`,`lid`),
  KEY `lid` (`lid`),
  CONSTRAINT `combo_location_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `combo` (`co_id`),
  CONSTRAINT `combo_location_ibfk_2` FOREIGN KEY (`lid`) REFERENCES `shooting_location` (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combo_location
-- ----------------------------
INSERT INTO `combo_location` VALUES ('3', '7', '10000');
INSERT INTO `combo_location` VALUES ('3', '9', '12000');
INSERT INTO `combo_location` VALUES ('3', '11', '26000');
INSERT INTO `combo_location` VALUES ('4', '7', '50000');
INSERT INTO `combo_location` VALUES ('4', '9', '80000');
INSERT INTO `combo_location` VALUES ('5', '7', '50000');
INSERT INTO `combo_location` VALUES ('5', '9', '20000');
INSERT INTO `combo_location` VALUES ('5', '11', '35000');

-- ----------------------------
-- Table structure for combo_order
-- ----------------------------
DROP TABLE IF EXISTS `combo_order`;
CREATE TABLE `combo_order` (
  `com_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `price` double DEFAULT NULL COMMENT '订单总价格',
  `com_oder_date` date DEFAULT NULL COMMENT '订单生成日期',
  `start_date` varchar(10) DEFAULT '' COMMENT '摄影套餐拍摄开始日期',
  `combo_id` bigint(20) DEFAULT NULL COMMENT '关联摄影套餐的id',
  `customer_id` bigint(20) DEFAULT NULL COMMENT '用户',
  `shootting_location_id` bigint(20) DEFAULT NULL COMMENT '摄影地点',
  `shooting_state` bigint(10) DEFAULT NULL COMMENT '订单完成状态',
  PRIMARY KEY (`com_order_id`),
  KEY `combo_id` (`combo_id`),
  KEY `customer_id` (`customer_id`),
  KEY `shootting_location_id` (`shootting_location_id`),
  KEY `shooting_state` (`shooting_state`),
  CONSTRAINT `combo_order_ibfk_1` FOREIGN KEY (`combo_id`) REFERENCES `combo` (`co_id`),
  CONSTRAINT `combo_order_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`),
  CONSTRAINT `combo_order_ibfk_3` FOREIGN KEY (`shootting_location_id`) REFERENCES `shooting_location` (`lid`),
  CONSTRAINT `combo_order_ibfk_4` FOREIGN KEY (`shooting_state`) REFERENCES `combo_order_state` (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combo_order
-- ----------------------------
INSERT INTO `combo_order` VALUES ('1', '1000', '2019-05-23', '1号', '3', '1', '7', '3');
INSERT INTO `combo_order` VALUES ('2', '5000', '2019-05-23', '5号', '4', '3', '7', '2');
INSERT INTO `combo_order` VALUES ('3', '1200', '2019-05-23', '17号', '3', '3', '9', '4');
INSERT INTO `combo_order` VALUES ('4', '8000', '2019-05-23', '25号', '4', '3', '9', '2');
INSERT INTO `combo_order` VALUES ('5', '2600', '2019-05-23', '1号', '3', '3', '11', '4');
INSERT INTO `combo_order` VALUES ('20', '1000', '2019-05-24', '1号', '3', '1', '7', '3');
INSERT INTO `combo_order` VALUES ('21', '1000', '2019-06-07', '1号', '3', '1', '7', '3');
INSERT INTO `combo_order` VALUES ('22', '5000', '2019-06-22', '25号', '3', '1', '7', '2');
INSERT INTO `combo_order` VALUES ('23', '1000', '2019-06-22', '5号', '3', '2', '7', '2');
INSERT INTO `combo_order` VALUES ('24', '1000', '2019-06-22', '5号', '3', '3', '7', '2');
INSERT INTO `combo_order` VALUES ('25', '2600', '2019-06-22', '23号', '3', '2', '11', '1');
INSERT INTO `combo_order` VALUES ('26', '5000', '2019-06-23', '25号', '4', '2', '7', '1');
INSERT INTO `combo_order` VALUES ('27', '1000', '2019-06-25', '5号', '3', '2', '7', '1');
INSERT INTO `combo_order` VALUES ('28', '1000', '2019-06-25', '9号', '3', '2', '7', '1');
INSERT INTO `combo_order` VALUES ('31', '1000', '2019-06-26', '1号', '3', '1', '7', '1');
INSERT INTO `combo_order` VALUES ('33', '10000', '2019-06-26', '13号', '3', '1', '7', '1');
INSERT INTO `combo_order` VALUES ('34', '10000', '2019-06-26', '13号', '3', '2', '7', '1');
INSERT INTO `combo_order` VALUES ('35', '26000', '2019-06-28', '5号', '3', '2', '11', '1');
INSERT INTO `combo_order` VALUES ('36', '26000', '2019-06-28', '12号', '3', '2', '11', '1');

-- ----------------------------
-- Table structure for combo_order_state
-- ----------------------------
DROP TABLE IF EXISTS `combo_order_state`;
CREATE TABLE `combo_order_state` (
  `os_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `os_state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of combo_order_state
-- ----------------------------
INSERT INTO `combo_order_state` VALUES ('1', '已预约');
INSERT INTO `combo_order_state` VALUES ('2', '已付款');
INSERT INTO `combo_order_state` VALUES ('3', '拍摄完成');
INSERT INTO `combo_order_state` VALUES ('4', '取消订单');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `com_id` bigint(11) NOT NULL AUTO_INCREMENT,
  `article_id` bigint(11) DEFAULT NULL,
  `com_content` varchar(255) DEFAULT NULL,
  `customer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`com_id`),
  KEY `article_id_2` (`article_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`article_id`) REFERENCES `article` (`aid`),
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '1', '翻番方法付付付付付付付付', '1');
INSERT INTO `comment` VALUES ('2', '1', '斤斤计较军军军军军军军军军军军军军', '2');
INSERT INTO `comment` VALUES ('3', '1', '啦啦啦', '3');
INSERT INTO `comment` VALUES ('4', '2', '啦啦啦', '3');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `cust_phone` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `header_pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cust_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '毛园', '1234', '15254118385', null, 'clo2.jpg');
INSERT INTO `customer` VALUES ('2', '苗文静', '1234', '15254118667', '济南', 'clo2.jpg');
INSERT INTO `customer` VALUES ('3', '李应丹', '1234', '15254129572', '山东', 'clo3.jpg');
INSERT INTO `customer` VALUES ('5', 'lyddd', '1234', '15117773517', null, 'clo7.jpg');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `rid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `rid` (`rid`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '苗文静', '1234', '1');
INSERT INTO `employee` VALUES ('2', '彤', '1234', '2');
INSERT INTO `employee` VALUES ('3', '瑶', '1234', '2');
INSERT INTO `employee` VALUES ('6', '李应丹', '1234', '1');
INSERT INTO `employee` VALUES ('18', '小月', '123', '2');
INSERT INTO `employee` VALUES ('19', '222', '222', '2');
INSERT INTO `employee` VALUES ('20', '55', '5', '2');

-- ----------------------------
-- Table structure for employee_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `employee_role_rel`;
CREATE TABLE `employee_role_rel` (
  `eid` bigint(20) NOT NULL,
  `rid` bigint(20) NOT NULL,
  PRIMARY KEY (`eid`,`rid`),
  KEY `rid` (`rid`),
  CONSTRAINT `employee_role_rel_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `employee` (`eid`),
  CONSTRAINT `employee_role_rel_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee_role_rel
-- ----------------------------
INSERT INTO `employee_role_rel` VALUES ('1', '1');
INSERT INTO `employee_role_rel` VALUES ('3', '1');
INSERT INTO `employee_role_rel` VALUES ('1', '2');
INSERT INTO `employee_role_rel` VALUES ('2', '2');

-- ----------------------------
-- Table structure for guest_photo
-- ----------------------------
DROP TABLE IF EXISTS `guest_photo`;
CREATE TABLE `guest_photo` (
  `gu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gu_time` varchar(100) DEFAULT NULL,
  `gu_pic1` varchar(255) DEFAULT NULL,
  `gu_pic2` varchar(255) DEFAULT NULL,
  `gu_pic3` varchar(255) DEFAULT NULL,
  `gu_pic4` varchar(255) DEFAULT NULL,
  `gu_pic5` varchar(255) DEFAULT NULL,
  `gu_pic6` varchar(255) DEFAULT NULL,
  `gu_pic7` varchar(255) DEFAULT NULL,
  `gu_pic8` varchar(255) DEFAULT NULL,
  `gu_pic9` varchar(255) DEFAULT NULL,
  `gu_pic10` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of guest_photo
-- ----------------------------
INSERT INTO `guest_photo` VALUES ('1', '19年第二季度第三期', 'gue1.jpg', 'gue2.jpg', 'gue3.jpg', 'gue4.jpg', 'gue5.jpg', 'gue6.jpg', 'gue7.jpg', 'gue8.jpg', 'gue9.jpg', 'gue10.jpg');
INSERT INTO `guest_photo` VALUES ('2', '19年第二季度第二期', 'gue1.jpg', 'gue2.jpg', 'gue3.jpg', 'gue4.jpg', 'gue5.jpg', 'gue6.jpg', 'gue7.jpg', 'gue8.jpg', 'gue9.jpg', 'gue10.jpg');
INSERT INTO `guest_photo` VALUES ('3', '19年第二季度第一期', 'gue1.jpg', 'gue2.jpg', 'gue3.jpg', 'gue4.jpg', 'gue5.jpg', 'gue6.jpg', 'gue7.jpg', 'gue8.jpg', 'gue9.jpg', 'gue10.jpg');
INSERT INTO `guest_photo` VALUES ('4', '19年第四季度第三期', 'gue1.jpg', 'gue2.jpg', 'gue3.jpg', 'gue4.jpg', 'gue5.jpg', 'gue6.jpg', 'gue7.jpg', 'gue8.jpg', 'gue9.jpg', 'gue10.jpg');
INSERT INTO `guest_photo` VALUES ('5', '19年第四季度第二期', 'gue1.jpg', 'gue2.jpg', 'gue3.jpg', 'gue4.jpg', 'gue5.jpg', 'gue6.jpg', 'gue7.jpg', 'gue8.jpg', 'gue9.jpg', 'gue10.jpg');
INSERT INTO `guest_photo` VALUES ('6', '19年第四季度第一期', 'gue1.jpg', 'gue2.jpg', 'gue3.jpg', 'gue4.jpg', 'gue5.jpg', 'gue6.jpg', 'gue7.jpg', 'gue8.jpg', 'gue9.jpg', 'gue10.jpg');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) DEFAULT NULL,
  `presource` varchar(50) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '客户主页', 'customer:index');
INSERT INTO `permission` VALUES ('2', '租赁服装主页', 'rentClothes:index');
INSERT INTO `permission` VALUES ('3', '摄影套餐主页', 'como:index');
INSERT INTO `permission` VALUES ('4', '员工主页', 'employee:index');
INSERT INTO `permission` VALUES ('5', '摄影订单主页', 'comboorder:index');
INSERT INTO `permission` VALUES ('6', '服装订单主页', 'clothesorder:index');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT,
  `ppic` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for rent_clothes
-- ----------------------------
DROP TABLE IF EXISTS `rent_clothes`;
CREATE TABLE `rent_clothes` (
  `clo_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `clo_name` varchar(50) DEFAULT NULL,
  `clo_price` double DEFAULT NULL,
  `clo_picture` varchar(255) DEFAULT NULL,
  `clo_amount` bigint(10) DEFAULT NULL COMMENT '衣服数量',
  `clo_type` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`clo_id`),
  KEY `clo_type` (`clo_type`),
  CONSTRAINT `rent_clothes_ibfk_1` FOREIGN KEY (`clo_type`) REFERENCES `clothes_type` (`clo_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rent_clothes
-- ----------------------------
INSERT INTO `rent_clothes` VALUES ('3', '晚礼服女2019新款夏季生日派对连衣短裙小礼服连衣裙黑色露肩聚会口袋', '400', 'clo4.jpg', '3', '1');
INSERT INTO `rent_clothes` VALUES ('4', '白色晚礼服女2019新款高贵优雅宴会中长款名媛聚会显瘦洋装小礼服蕾丝', '200', 'clo2.jpg', '-1', '1');
INSERT INTO `rent_clothes` VALUES ('5', '年会晚礼服女2019新款宴会洋装生日派对连衣裙长袖中长酒会小黑裙', '200', 'clo1.jpg', '1', '1');
INSERT INTO `rent_clothes` VALUES ('6', '汉服女学生改良齐胸襦裙中国风公主抖音古装古风超仙锦鲤裙汉元素不对称', '300', '463797934.jpg', '4', '3');
INSERT INTO `rent_clothes` VALUES ('8', '汉服女学生改良齐胸襦裙中国风公主抖音古装古风超仙锦鲤裙汉元素口袋', '400', '-294404861.jpg', '4', '3');
INSERT INTO `rent_clothes` VALUES ('9', '汉服女学生改良齐胸襦裙中国风抖音逍遥客古装超仙忘川秋水汉元素口袋', '200', '-219161406.jpg', '5', '3');
INSERT INTO `rent_clothes` VALUES ('10', '赫本婚纱礼服2019新款长拖尾公主新娘结婚复古显瘦抹胸缎面简约女不对称', '600', '763651273.jpg', '5', '2');
INSERT INTO `rent_clothes` VALUES ('11', '婚纱礼服新娘2019结婚新款法式复古缎面简约显瘦小个子出门纱拖尾镂空', '500', '889256874.jpg', '5', '2');
INSERT INTO `rent_clothes` VALUES ('12', '婚纱礼服2019新款简约一字肩长袖赫本显瘦长拖尾拼接纱网镂空', '1000', '-1222014430.jpg', '5', '4');
INSERT INTO `rent_clothes` VALUES ('13', '主婚纱2018新款新娘拖尾奢华梦幻公主赫本抖音星空抹胸婚纱女新娘镂空', '500', '-1511925426.jpg', '5', '2');
INSERT INTO `rent_clothes` VALUES ('14', '婚纱2019新款新娘女小个子超仙奢华赫本星空简约显瘦网红抖音拖尾', '400', '1676147823.jpg', '5', '4');
INSERT INTO `rent_clothes` VALUES ('15', '主婚纱2019新款新娘拖尾奢华梦幻公主赫本抖音星空抹胸婚纱女新娘纱网', '600', '2060312862.jpg', '5', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` bigint(20) NOT NULL,
  `rname` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员');
INSERT INTO `role` VALUES ('2', '摄影师');

-- ----------------------------
-- Table structure for role_permission_rel
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_rel`;
CREATE TABLE `role_permission_rel` (
  `rid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  PRIMARY KEY (`rid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_rel
-- ----------------------------
INSERT INTO `role_permission_rel` VALUES ('1', '1');
INSERT INTO `role_permission_rel` VALUES ('1', '2');
INSERT INTO `role_permission_rel` VALUES ('1', '3');
INSERT INTO `role_permission_rel` VALUES ('1', '4');
INSERT INTO `role_permission_rel` VALUES ('1', '5');
INSERT INTO `role_permission_rel` VALUES ('1', '6');
INSERT INTO `role_permission_rel` VALUES ('2', '2');
INSERT INTO `role_permission_rel` VALUES ('2', '5');

-- ----------------------------
-- Table structure for shooting_days_10
-- ----------------------------
DROP TABLE IF EXISTS `shooting_days_10`;
CREATE TABLE `shooting_days_10` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shooting_days_10
-- ----------------------------
INSERT INTO `shooting_days_10` VALUES ('1', '1号', '11', '1');
INSERT INTO `shooting_days_10` VALUES ('2', '12号', '11', '1');
INSERT INTO `shooting_days_10` VALUES ('3', '23号', '11', '1');

-- ----------------------------
-- Table structure for shooting_days_3
-- ----------------------------
DROP TABLE IF EXISTS `shooting_days_3`;
CREATE TABLE `shooting_days_3` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`),
  KEY `shooting_location_id` (`shooting_location_id`),
  CONSTRAINT `shooting_days_3_ibfk_1` FOREIGN KEY (`shooting_location_id`) REFERENCES `shooting_location` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shooting_days_3
-- ----------------------------
INSERT INTO `shooting_days_3` VALUES ('3', '1号', '7', '4');
INSERT INTO `shooting_days_3` VALUES ('4', '5号', '7', '4');
INSERT INTO `shooting_days_3` VALUES ('5', '9号', '7', '1');
INSERT INTO `shooting_days_3` VALUES ('6', '13号', '7', '1');
INSERT INTO `shooting_days_3` VALUES ('7', '17号', '7', '0');
INSERT INTO `shooting_days_3` VALUES ('8', '21号', '7', '0');
INSERT INTO `shooting_days_3` VALUES ('9', '25号', '7', '2');

-- ----------------------------
-- Table structure for shooting_days_5
-- ----------------------------
DROP TABLE IF EXISTS `shooting_days_5`;
CREATE TABLE `shooting_days_5` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`),
  KEY `shooting_location_id` (`shooting_location_id`),
  CONSTRAINT `shooting_days_5_ibfk_1` FOREIGN KEY (`shooting_location_id`) REFERENCES `shooting_location` (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shooting_days_5
-- ----------------------------
INSERT INTO `shooting_days_5` VALUES ('1', '1号', '10', '0');
INSERT INTO `shooting_days_5` VALUES ('2', '7号', '10', '0');
INSERT INTO `shooting_days_5` VALUES ('3', '13号', '10', '0');
INSERT INTO `shooting_days_5` VALUES ('4', '19号', '10', '0');
INSERT INTO `shooting_days_5` VALUES ('5', '25号', '10', '0');

-- ----------------------------
-- Table structure for shooting_days_7
-- ----------------------------
DROP TABLE IF EXISTS `shooting_days_7`;
CREATE TABLE `shooting_days_7` (
  `shooting_days_id` bigint(5) NOT NULL AUTO_INCREMENT,
  `shooting_days` varchar(10) DEFAULT NULL,
  `shooting_location_id` bigint(5) DEFAULT NULL,
  `shooting_times` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`shooting_days_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shooting_days_7
-- ----------------------------
INSERT INTO `shooting_days_7` VALUES ('1', '1号', '9', '0');
INSERT INTO `shooting_days_7` VALUES ('2', '9号', '9', '0');
INSERT INTO `shooting_days_7` VALUES ('3', '17号', '9', '1');
INSERT INTO `shooting_days_7` VALUES ('4', '25号', '9', '1');

-- ----------------------------
-- Table structure for shooting_location
-- ----------------------------
DROP TABLE IF EXISTS `shooting_location`;
CREATE TABLE `shooting_location` (
  `lid` bigint(20) NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) DEFAULT NULL,
  `shooting_days` bigint(5) DEFAULT NULL,
  `time_limit` bigint(5) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shooting_location
-- ----------------------------
INSERT INTO `shooting_location` VALUES ('7', '青岛', '3', '5');
INSERT INTO `shooting_location` VALUES ('9', '上海', '5', '6');
INSERT INTO `shooting_location` VALUES ('10', '三亚', '5', '3');
INSERT INTO `shooting_location` VALUES ('11', '巴黎', '10', '1');
