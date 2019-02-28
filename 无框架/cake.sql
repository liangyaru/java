/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : item

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2018-10-22 09:33:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cake`
-- ----------------------------
DROP TABLE IF EXISTS `cake`;
CREATE TABLE `cake` (
  `cnum` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `discount` int(11) DEFAULT NULL,
  `bigpic` varchar(50) DEFAULT NULL,
  `smallpic1` varchar(50) DEFAULT NULL,
  `smallpic2` varchar(50) DEFAULT NULL,
  `smallpic3` varchar(50) DEFAULT NULL,
  `star` int(11) DEFAULT NULL,
  `tag` varchar(20) DEFAULT NULL,
  `type` int(20) DEFAULT NULL,
  PRIMARY KEY (`cnum`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cake
-- ----------------------------
INSERT INTO `cake` VALUES ('1', 'Sydeney', 'The cake comes from English.Its original meaning is oblate bread.In the meantime,it refers to happiness', '1', '100', '3', 'images/g3.png', 'images/s31.png', 'images/s32.png', 'images/s33.png', '8', 'friend', '5');
INSERT INTO `cake` VALUES ('2', 'Frozen', 'Please preserve in room temperature and consume in 11~15 days', '1', '30', '5', 'images/g4.png', 'images/s41.png', 'images/s42.png', 'images/s43.png', '2', 'lover', '8');
INSERT INTO `cake` VALUES ('3', 'Chocolate ', 'Cake cutting is one of the most wonderful ways of celebrating a special moment. What better way to celebrate than with a rich and mouth watering chocochips cake.', '1', '40', '4', 'images/g5.png', 'images/s51.png', 'images/s52.png', 'images/s53.png', '3', 'sister', '7');
INSERT INTO `cake` VALUES ('4', 'Furite Tower', 'Place in room temperature for 15~30 Mins before tasting for best flavor if refrigerated. Black tea, green tea, or coffee are great choices to go with the cake.', '1', '50', '4', 'images/g6.png', 'images/s61.png', 'images/s62.png', 'images/s63.png', '2', 'brother', '6');
INSERT INTO `cake` VALUES ('5', 'Macarons kiss', 'Best to taste while chilled. Defrost in refrigerator for 6 to 8 hours if frozen. Include all layers when tasting. Refreshing teas or coffee are great choices with the cake.', '1', '60', '4', 'images/g7.png', 'images/s71.png', 'images/s72.png', 'images/s73.png', '1', 'kids', '4');
INSERT INTO `cake` VALUES ('6', 'dream', 'Needs to be refrigerated in 1.5 hrs and consume in 3 days or consume in 7 days if frozen to ensure the freshness and the delicacy of the cake.', '1', '170', '4', 'images/g8.png', 'images/s81.png', 'images/s82.png', 'images/s83.png', '3', 'parents', '4');
INSERT INTO `cake` VALUES ('7', 'The love of Ball', 'With rich buttery orange blossom flavor?Simple and Rustic appearance.', '1', '90', '5', 'images/g9.png', 'images/s91.png', 'images/s92.png', 'images/s93.png', '2', 'friend', '4');
INSERT INTO `cake` VALUES ('8', 'Crisp cake', 'According to legend, the Crown Princess of Japan\'s Royal Family.', '1', '200', '4', 'images/g10.png', 'images/s101.png', 'images/s102.png', 'images/s103.png', '3', 'lover', '5');
INSERT INTO `cake` VALUES ('9', 'My heart forever', 'Alice Gift Set can choose any two of our retangular cakes.', '1', '80', '7', 'images/m1.png', 'images/t11.png', 'images/t12.png', 'images/t13.png', '1', 'sister', '4');
INSERT INTO `cake` VALUES ('10', 'Pink pig', 'Top premium butter refined from fresh milk,With baking technique inherit from Holland,Forging the golden aristocratic manifesto,Aromatic with rich and thick texture.', '1', '120', '4', 'images/m2.png', 'images/t21.png', 'images/t22.png', 'images/t23.png', '2', 'brother', '4');
INSERT INTO `cake` VALUES ('11', 'Doreaemon', 'With light and refreshing cheese flavor.Low in sugar and fat for healthy living.Suitable for the whole family to enjoy.', '2', '25', '5', 'images/m3.png', 'images/t31.png', 'images/t32.png', 'images/t33.png', '1', 'kids', '4');
INSERT INTO `cake` VALUES ('12', 'Mikey', 'Best to taste while chilled. Black tea are great choices for the cake.', '2', '50', '7', 'images/m4.png', 'images/t41.png', 'images/t42.png', 'images/t43.png', '2', 'parents', '4');
INSERT INTO `cake` VALUES ('13', 'Hello Kitty', 'Warm black tea, green tea, or wu-long tea are great complimentary drinks.', '2', '30', '6', 'images/m5.png', 'images/t51.png', 'images/t52.png', 'images/t53.png', '1', 'friend', '4');
INSERT INTO `cake` VALUES ('14', 'Tiramisu', 'you can eat it anytime and best to consume with teas to bring out the best flavour.', '2', '60', '6', 'images/m6.png', 'images/t61.png', 'images/t62.png', 'images/t63.png', '1', 'lover', '4');
INSERT INTO `cake` VALUES ('15', 'Green tea\'s love', 'Macadamia Nut Tart and Chocolate Langue de chat in 10~20 days.', '2', '90', '5', 'images/m7.png', 'images/t71.png', 'images/t72.png', 'images/t73.png', '2', 'sister', '4');
INSERT INTO `cake` VALUES ('16', 'Sweet cake', 'Fresh delivered premium Italian cheese,Moist and melt in your mouth texture.', '2', '120', '7', 'images/m8.png', 'images/t81.png', 'images/t82.png', 'images/t83.png', '2', 'brother', '4');
INSERT INTO `cake` VALUES ('17', 'The melody of love', 'King and Queen presented their joyous blessing.Giving her hand to the Prince.', '2', '70', '4', 'images/m9.png', 'images/t91.png', 'images/t92.png', 'images/t93.png', '3', 'kids', '6');
INSERT INTO `cake` VALUES ('18', 'The Magellan Galaxy', 'Spontaneously falling under the enchantment of French charm.', '2', '60', '5', 'images/2.png', 'images/21.png', 'images/22.png', 'images/23.png', '2', 'parentd', '7');
INSERT INTO `cake` VALUES ('19', 'Fruit flavor', 'Crisp and Golden color with robust milky caramel aroma.', '3', '90', '5', 'images/g1.png', 'images/s11.png', 'images/s12.png', 'images/s13.png', '3', 'friend', '8');
INSERT INTO `cake` VALUES ('20', 'Cheesecake', 'Taking a bite will lead to unstoppable indulgence.', '4', '180', '1', 'images/g1.jpg', 'images/11.jpg', 'images/12.jpg', 'images/13.jpg', '1', 'lover', '7');
INSERT INTO `cake` VALUES ('21', 'Besting cake ', 'Amo Bakery presents to you the royal class Alice Gift Set', '4', '160', '2', 'images/g2.jpg', 'images/s21.png', 'images/s22.png', 'images/s23.png', '2', 'friend', '6');

-- ----------------------------
-- Table structure for `caketype`
-- ----------------------------
DROP TABLE IF EXISTS `caketype`;
CREATE TABLE `caketype` (
  `tnum` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `state` int(5) DEFAULT NULL,
  `prenum` int(11) DEFAULT NULL,
  PRIMARY KEY (`tnum`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of caketype
-- ----------------------------
INSERT INTO `caketype` VALUES ('1', 'birthday', '0', '0');
INSERT INTO `caketype` VALUES ('2', 'wedding', '0', '0');
INSERT INTO `caketype` VALUES ('3', 'Specail', '0', '0');
INSERT INTO `caketype` VALUES ('4', 'Chocolate', '1', '1');
INSERT INTO `caketype` VALUES ('5', 'Minxed', '1', '1');
INSERT INTO `caketype` VALUES ('6', 'Butterscotch', '1', '2');
INSERT INTO `caketype` VALUES ('7', 'Vanilla', '1', '2');
INSERT INTO `caketype` VALUES ('8', 'Eggless Cakes', '1', '3');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cnum` int(8) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `cake` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`cnum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `orderdetails`
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails` (
  `dnum` int(8) NOT NULL AUTO_INCREMENT,
  `onum` int(8) DEFAULT NULL,
  `cnum` int(8) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `rprice` int(11) DEFAULT NULL,
  PRIMARY KEY (`dnum`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of orderdetails
-- ----------------------------
INSERT INTO `orderdetails` VALUES ('1', '1', '3', '1', '16');
INSERT INTO `orderdetails` VALUES ('2', '2', '6', '1', '68');
INSERT INTO `orderdetails` VALUES ('3', '3', '18', '1', '30');
INSERT INTO `orderdetails` VALUES ('4', '4', '11', '1', '12');
INSERT INTO `orderdetails` VALUES ('5', '5', '4', '1', '20');
INSERT INTO `orderdetails` VALUES ('6', '6', '11', '1', '12');
INSERT INTO `orderdetails` VALUES ('7', '7', '8', '1', '80');
INSERT INTO `orderdetails` VALUES ('8', '8', '9', '1', '56');
INSERT INTO `orderdetails` VALUES ('9', '9', '11', '1', '12');
INSERT INTO `orderdetails` VALUES ('10', '10', '3', '1', '16');
INSERT INTO `orderdetails` VALUES ('11', '11', '2', '1', '15');

-- ----------------------------
-- Table structure for `personal`
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `email` varchar(50) NOT NULL,
  `first_name` varchar(5) DEFAULT NULL,
  `last_name` varchar(10) DEFAULT NULL,
  `registertime` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('1217654597@qq.com', 'liang', 'shuli', '2018-10-20 01:02:33', '081922');
INSERT INTO `personal` VALUES ('123456654@qq.com', 'liang', 'haha', '2018-10-20 08:19:02', '1234567');
INSERT INTO `personal` VALUES ('1234567890@qq.com', 'zhang', 'san', '2018-10-18 10:44:12', '1234567');
INSERT INTO `personal` VALUES ('12367765432223@qq.com', 'sdg', 'saertjnv', '2018-10-21 07:34:35', '123');
INSERT INTO `personal` VALUES ('234678765@qq.com', 'liang', 'shuqing', '2018-10-20 01:11:10', '23456');
INSERT INTO `personal` VALUES ('275740767@qq.com', 'liang', 'yaru', '2018-10-18 10:43:50', '123456');
INSERT INTO `personal` VALUES ('9876543210@qq.com', 'wang', 'wu', '2018-10-18 10:44:54', '12345678');

-- ----------------------------
-- Table structure for `uorder`
-- ----------------------------
DROP TABLE IF EXISTS `uorder`;
CREATE TABLE `uorder` (
  `onum` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(20) DEFAULT NULL,
  `user` varchar(30) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`onum`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of uorder
-- ----------------------------
INSERT INTO `uorder` VALUES ('1', '2018-10-21 01:52:43', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('2', '2018-10-21 07:31:35', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('3', '2018-10-21 07:31:54', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('4', '2018-10-21 07:35:57', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('5', '2018-10-21 07:37:23', '9876543210@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('6', '2018-10-21 07:44:07', '9876543210@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('7', '2018-10-21 07:44:22', '9876543210@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('8', '2018-10-21 07:44:43', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('9', '2018-10-21 07:51:37', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('10', '2018-10-21 07:52:27', '275740767@qq.com', null, null, 'addCart');
INSERT INTO `uorder` VALUES ('11', '2018-10-21 08:03:26', '275740767@qq.com', null, null, 'addCart');
