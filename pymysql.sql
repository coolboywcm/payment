/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : pymysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-09 22:51:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for py_active
-- ----------------------------
DROP TABLE IF EXISTS `py_active`;
CREATE TABLE `py_active` (
  `ID` varchar(32) NOT NULL DEFAULT '',
  `ORG_ID` varchar(32) DEFAULT NULL,
  `SHOP_ID` varchar(32) DEFAULT NULL COMMENT '商户ID',
  `BONUS_ID` varchar(32) DEFAULT NULL COMMENT '奖金池ID',
  `BONUS_LIMIT` decimal(10,2) DEFAULT NULL COMMENT '活动原价-定额活动',
  `BONUS_TYPE` varchar(8) DEFAULT NULL COMMENT '卡识别类型',
  `NAME` varchar(1000) DEFAULT NULL COMMENT '活动名称',
  `AD_INFO` varchar(1000) DEFAULT NULL COMMENT '广告信息',
  `YHZCS` int(3) DEFAULT NULL COMMENT '优惠总次数-定额活动',
  `DRZDCS` int(3) DEFAULT NULL COMMENT '单日最多次数-定额活动',
  `HDYJ` decimal(10,2) DEFAULT NULL COMMENT '活动原价-定额活动',
  `YHDJ` decimal(10,2) DEFAULT NULL COMMENT '优惠单价-定额活动',
  `DKKCYCS` int(3) DEFAULT NULL COMMENT '单卡可参与次数-定额活动',
  `ZDXFJE` decimal(10,2) DEFAULT NULL COMMENT '最低消费金额-折扣优惠-立减优惠-随机优惠',
  `ZK` decimal(5,2) DEFAULT NULL COMMENT '折扣-折扣优惠',
  `DBYHJE` decimal(10,2) DEFAULT NULL COMMENT '单笔优惠限额-折扣优惠',
  `DKZGYHJE` decimal(10,2) DEFAULT NULL COMMENT '单卡最高优惠金额-折扣优惠',
  `LJJE` decimal(10,2) DEFAULT NULL COMMENT '立减金额-立减优惠',
  `DKHJYHXE` decimal(10,2) DEFAULT NULL COMMENT '单卡合计优惠限额-立减优惠-随机优惠',
  `DBZDYH` decimal(10,2) DEFAULT NULL COMMENT '单笔最低优惠-随机优惠',
  `DBZGYH` decimal(10,2) DEFAULT NULL COMMENT '单笔最高优惠-随机优惠',
  `BEGIN_DATE` varchar(32) DEFAULT NULL COMMENT '起始日期',
  `END_DATE` varchar(32) DEFAULT NULL COMMENT '终止日期',
  `WEEK` varchar(100) DEFAULT NULL COMMENT '星期选择,逗号格开',
  `BEGIN_TIME` varchar(32) DEFAULT NULL COMMENT '每天开始时间',
  `END_TIME` varchar(32) DEFAULT NULL COMMENT '每天结束始时间',
  `CARD_IDENTIFY_TYPE` varchar(8) DEFAULT NULL COMMENT '卡识别类型',
  `CARD_ADD_TYPE` varchar(8) DEFAULT NULL,
  `TYPE` varchar(8) DEFAULT NULL COMMENT '活动类型',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `HDZJE` decimal(10,2) DEFAULT NULL COMMENT '活动总金额-折扣优惠',
  `MRZGHDJE` decimal(10,2) DEFAULT NULL COMMENT '每日最高活动金额 -折扣优惠',
  `CARD_NO` text,
  `CARD_BIN` text,
  `USED_TOTAL` decimal(10,2) DEFAULT '0.00' COMMENT '活动已使用金额',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_active
-- ----------------------------
INSERT INTO `py_active` VALUES ('2f148957236340d9b73104b58e5a93f1', '1', '6929933ac1bd4262a8f52c4ed35be501', '0f5a5ebf040c4f19a2c89ca3df0d19b4', null, '1', 'afsdf', 'sdfsd', null, null, null, null, null, '11.00', null, null, null, null, '55.00', '22.00', '33.00', '2018-08-31', '2018-09-02', '7', '10:44', '10:44', '1', '1', 'sjyh', '1', '2018-08-31 10:45:32', '1', null, '222.00', '', '111|222', '0.00');
INSERT INTO `py_active` VALUES ('4b02d72defcc4ef196e4c984c4962de1', '1', '1', '53ad51c7288f4549950ff3ed366b0c7b', null, '1', '111', '222', null, null, null, null, null, '11.00', null, null, null, '11.00', '11.00', null, null, '2018-08-31', '2018-08-31', '6,7', '10:33', '10:33', '1', '1', 'ljyh', '1', '2018-08-31 10:34:34', '1', null, '200.00', '', '111|222', '0.00');
INSERT INTO `py_active` VALUES ('602bfe517d0b475486e5e22ab7926589', '1', '1', '0f5a5ebf040c4f19a2c89ca3df0d19b4', null, '1', '折扣优惠', '22', '33', null, null, '33.00', null, '1000.00', '33.00', '33.00', '55.00', null, null, null, null, '2018-07-17', '2018-08-19', '1,2,3,4,5,6,7', '16:18', '16:18', '1', '2', 'zkyh', '1', '2018-07-17 22:31:09', '04531ede793c40ba9b90959bb3119a2b', '11.00', '22.00', '', '', null);
INSERT INTO `py_active` VALUES ('91f4ba84ffd244c9bfceeedb7cdc90ca', '1', '1', '0f5a5ebf040c4f19a2c89ca3df0d19b4', null, '1', '11', '22', null, null, null, null, null, '11.00', null, null, null, null, '11.00', '11.00', '11.00', '2018-07-04', '2018-08-21', '6,7', '16:25', '16:25', '1', '', 'sjyh', '1', '2018-07-18 23:45:54', '04531ede793c40ba9b90959bb3119a2b', '300.00', '100.00', '', '', '0.00');
INSERT INTO `py_active` VALUES ('a7ffa8d4758948b68f7f2e9ea34ac95a', '1', '6929933ac1bd4262a8f52c4ed35be501', '0f5a5ebf040c4f19a2c89ca3df0d19b4', null, '1', '11', '11', null, null, null, null, null, '11.00', null, null, null, null, '11.00', '22.00', '33.00', '2018-08-22', '2018-09-01', '6,7', '10:59', '10:59', '1', '1', 'sjyh', '1', '2018-08-31 11:00:06', '1', null, '11.00', '', '111', '0.00');
INSERT INTO `py_active` VALUES ('acc55aa197ec423583197385719fc7cf', '1', '1', null, null, null, '111', '22', '11', '22', '1000.00', '1000.00', '1', null, null, null, null, null, null, null, null, '2018-07-18', '2018-08-18', '7', '16:20', '16:20', '2', '1', 'dehd', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b', null, null, '', '', '0.00');
INSERT INTO `py_active` VALUES ('efe420a8738c4c3da300d36554415d28', '1', '1', '0f5a5ebf040c4f19a2c89ca3df0d19b4', null, '1', '22', '33', null, null, null, null, null, '11.00', null, null, null, '11.00', '11.00', null, null, '2018-07-13', '2018-07-27', '6,7', '17:27', '17:27', '1', '1', 'ljyh', '1', '2018-07-23 17:28:05', '1', null, '222.00', '', '111', '0.00');

-- ----------------------------
-- Table structure for py_active_card
-- ----------------------------
DROP TABLE IF EXISTS `py_active_card`;
CREATE TABLE `py_active_card` (
  `ID` varchar(32) NOT NULL DEFAULT '',
  `BATCH_ID` varchar(32) DEFAULT NULL COMMENT '批次ID',
  `ACTIVE_ID` varchar(32) DEFAULT NULL COMMENT '活动ID',
  `CARD_NO` varchar(32) DEFAULT NULL COMMENT '卡号/卡bin',
  `INDENTIFY_TYPE` varchar(8) DEFAULT NULL COMMENT '卡辨识类型1:卡BIN识别 2:卡号识别',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_active_card
-- ----------------------------
INSERT INTO `py_active_card` VALUES ('025204de5a33468db329a4108f80d371', '2f148957236340d9b73104b58e5a93f1', '2f148957236340d9b73104b58e5a93f1', '222', '1', '1', '2018-08-31 10:45:32', '1');
INSERT INTO `py_active_card` VALUES ('03411d535db04f5c8350f95a3a1ba93a', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '622888', '2', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('15394fcce6be485b9e2e1699d0eeb1be', '91f4ba84ffd244c9bfceeedb7cdc90ca', '91f4ba84ffd244c9bfceeedb7cdc90ca', '111', '1', '1', '2018-07-18 23:45:54', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('1dd015d31278454e897cd84530713d5b', '91f4ba84ffd244c9bfceeedb7cdc90ca', '91f4ba84ffd244c9bfceeedb7cdc90ca', '222', '1', '1', '2018-07-18 23:45:54', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('21a0cd4211174a9a96ca1e34088bf938', 'efe420a8738c4c3da300d36554415d28', 'efe420a8738c4c3da300d36554415d28', '111', '1', '1', '2018-07-23 17:28:05', '1');
INSERT INTO `py_active_card` VALUES ('3adc454456c44e0cbd840a3d23f8456b', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '111', '1', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('450d1a44d7d84acf8b931477e44e6baf', '2f148957236340d9b73104b58e5a93f1', '2f148957236340d9b73104b58e5a93f1', '111', '1', '1', '2018-08-31 10:45:32', '1');
INSERT INTO `py_active_card` VALUES ('51c7b34bb1f0461fbd5fcca51d0708ef', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '6222777', '2', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('85ada9166e7e4c96bc83db62020dd46f', 'a7ffa8d4758948b68f7f2e9ea34ac95a', 'a7ffa8d4758948b68f7f2e9ea34ac95a', '111', '1', '1', '2018-08-31 11:00:06', '1');
INSERT INTO `py_active_card` VALUES ('a002d4da392645c6914d80e1b7a1ebf6', '4b02d72defcc4ef196e4c984c4962de1', '4b02d72defcc4ef196e4c984c4962de1', '111', '1', '1', '2018-08-31 10:34:34', '1');
INSERT INTO `py_active_card` VALUES ('ade74fbbfa9a45ceac8993e905991649', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '333', '1', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('bf759a6cf5e2429e908258db20dbc698', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '222', '1', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('c2f609b1e21e432ebd64bf50c3d0155a', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '555', '1', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('c8e28c293f914145a6058448248f40e7', 'acc55aa197ec423583197385719fc7cf', 'acc55aa197ec423583197385719fc7cf', '666', '1', '1', '2018-07-18 23:44:42', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_card` VALUES ('d2bf4fa79e87470ba3a876d102b1113a', '4b02d72defcc4ef196e4c984c4962de1', '4b02d72defcc4ef196e4c984c4962de1', '222', '1', '1', '2018-08-31 10:34:34', '1');

-- ----------------------------
-- Table structure for py_active_detail
-- ----------------------------
DROP TABLE IF EXISTS `py_active_detail`;
CREATE TABLE `py_active_detail` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ACTIVE_ID` varchar(32) DEFAULT NULL COMMENT '活动ID',
  `DBJE` decimal(10,2) DEFAULT NULL COMMENT '达标金额（随机优惠、立减优惠）',
  `SJYHZXZ` decimal(10,2) DEFAULT NULL COMMENT '随机优惠最低值（随机优惠）',
  `SJYHZDDZ` decimal(10,2) DEFAULT NULL COMMENT '随机优惠最大值（随机优惠）',
  `LJJE` decimal(10,2) DEFAULT NULL COMMENT '立减金额（立减优惠）',
  `DCXFZDGMS` int(5) DEFAULT NULL COMMENT '单次消费最大购买数（立减优惠）',
  `TITLE` varchar(1000) DEFAULT NULL COMMENT '明细标题',
  `YHQDJE` decimal(10,2) DEFAULT NULL COMMENT '优惠起点金额（折扣优惠）',
  `YHFDJE` decimal(10,2) DEFAULT NULL COMMENT '优惠封顶金额（折扣优惠,）',
  `YHZK` decimal(10,2) DEFAULT NULL COMMENT '优惠折扣（折扣优惠）',
  `HDYJ` decimal(10,2) DEFAULT NULL COMMENT '活动原价（定额优惠）',
  `YHJE` decimal(10,2) DEFAULT NULL COMMENT '优惠金额（定额优惠）',
  `DCXFZDGMFS` decimal(10,0) DEFAULT NULL COMMENT '单次消费最大购买份数（定额优惠）',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `DETAIL_DESC` varchar(1000) DEFAULT NULL COMMENT '描述',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动明细';

-- ----------------------------
-- Records of py_active_detail
-- ----------------------------
INSERT INTO `py_active_detail` VALUES ('2091718bb9bd471fbc4d7609f2d11d94', 'efe420a8738c4c3da300d36554415d28', '100.00', null, null, '11.00', '1', '555', null, null, null, null, null, null, '1', '描述', '2018-07-23 17:54:12', '1');
INSERT INTO `py_active_detail` VALUES ('2f84480d519a42c686234b27a8c5c4b1', 'acc55aa197ec423583197385719fc7cf', null, null, null, null, null, '序号', null, null, null, '11.00', '22.00', '33', '1', '22', '2018-07-24 15:09:31', '1');
INSERT INTO `py_active_detail` VALUES ('4ab4be5d5940473887d028fdf8c2b1e9', 'efe420a8738c4c3da300d36554415d28', '100.00', null, null, '11.00', '1', '555', null, null, null, null, null, null, '1', '描述', '2018-07-23 17:42:45', '1');
INSERT INTO `py_active_detail` VALUES ('579b140a3dd1420c9ef1034f391b2028', '91f4ba84ffd244c9bfceeedb7cdc90ca', '100.00', '10.00', '20.00', null, null, '555', null, null, null, null, null, null, '1', '描述', '2018-07-23 17:31:34', '1');
INSERT INTO `py_active_detail` VALUES ('99f5cf6961374e1796d76f5cf9a962c7', '602bfe517d0b475486e5e22ab7926589', null, null, null, null, null, '112a', '22.00', '33.00', '8.00', null, null, null, '0', '描述', '2018-07-23 16:59:45', '1');
INSERT INTO `py_active_detail` VALUES ('d502824500ad41cbb9f6313ffec3505d', 'acc55aa197ec423583197385719fc7cf', null, null, null, null, null, '555', null, null, null, '11.00', '22.00', '33', '1', '描述', '2018-07-24 15:04:11', '1');

-- ----------------------------
-- Table structure for py_active_shop
-- ----------------------------
DROP TABLE IF EXISTS `py_active_shop`;
CREATE TABLE `py_active_shop` (
  `ID` varchar(32) NOT NULL,
  `ACTIVE_ID` varchar(32) DEFAULT NULL,
  `SHOP_ID` varchar(32) DEFAULT NULL,
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_active_shop
-- ----------------------------
INSERT INTO `py_active_shop` VALUES ('259ac61f1bf04ac59ac3a414360411b4', '602bfe517d0b475486e5e22ab7926589', '1', '2018-07-18 20:48:46', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_shop` VALUES ('28b8ca96b10246429ce620b7f492de67', 'efe420a8738c4c3da300d36554415d28', '1', '2018-07-23 17:53:57', '1');
INSERT INTO `py_active_shop` VALUES ('3f1a9665bdbe45bd85a4ae6375206219', '18a912b9dc974ace8562c390f812438b', '1', '2018-07-16 23:52:13', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_shop` VALUES ('42f1ad83a1b448ae99d053f8f4937ff5', '18a912b9dc974ace8562c390f812438b', '2d14fb56655a46a287babef7de89bcc0', '2018-07-16 23:52:14', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_shop` VALUES ('47a59e26824f40c59197ffec5e1c5fd5', '602bfe517d0b475486e5e22ab7926589', '80021de01c374ce78425e01c5eeeacff', '2018-07-18 20:48:46', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_shop` VALUES ('5a73d6f4c8a446d99a71fefeb7311a91', '602bfe517d0b475486e5e22ab7926589', '0bb4ad4cd2c5445db6f7b5783d2098f7', '2018-07-18 20:48:46', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_shop` VALUES ('9fe6018206da4fd8b65101a8942acefe', '18a912b9dc974ace8562c390f812438b', '0bb4ad4cd2c5445db6f7b5783d2098f7', '2018-07-16 23:52:13', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_active_shop` VALUES ('a1ed7fe8af6c4911850bf55038b881c4', 'acc55aa197ec423583197385719fc7cf', '0bb4ad4cd2c5445db6f7b5783d2098f7', '2018-07-24 15:03:53', '1');
INSERT INTO `py_active_shop` VALUES ('b349dcc5c1d547fb965163d05cabf2f0', 'acc55aa197ec423583197385719fc7cf', '2d14fb56655a46a287babef7de89bcc0', '2018-07-24 15:03:53', '1');
INSERT INTO `py_active_shop` VALUES ('b51005a6719f42e6be8d02c306dd0cc8', 'efe420a8738c4c3da300d36554415d28', '0bb4ad4cd2c5445db6f7b5783d2098f7', '2018-07-23 17:53:57', '1');
INSERT INTO `py_active_shop` VALUES ('ed25819b042245609aa851425b2e8ae3', '91f4ba84ffd244c9bfceeedb7cdc90ca', '0bb4ad4cd2c5445db6f7b5783d2098f7', '2018-08-31 16:35:14', '1');

-- ----------------------------
-- Table structure for py_adimg
-- ----------------------------
DROP TABLE IF EXISTS `py_adimg`;
CREATE TABLE `py_adimg` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `NAME` varchar(128) DEFAULT NULL,
  `FILE_ID_1` varchar(64) DEFAULT NULL COMMENT '文件ID1',
  `TIP1` varchar(255) DEFAULT NULL,
  `FILE_ID_2` varchar(64) DEFAULT NULL COMMENT '文件ID2',
  `TIP2` varchar(255) DEFAULT NULL,
  `FILE_ID_3` varchar(64) DEFAULT NULL COMMENT '文件ID3',
  `TIP3` varchar(255) DEFAULT NULL,
  `ORG_ID` varchar(64) DEFAULT NULL COMMENT '所属机构',
  `SHOP_ID` varchar(64) DEFAULT NULL COMMENT '所属商户',
  `TERMINAL_ID` varchar(4000) DEFAULT NULL COMMENT '终端ID',
  `ORDER_INDEX` varchar(64) DEFAULT NULL COMMENT '排序号',
  `TYPE` varchar(8) DEFAULT NULL COMMENT '类型(1-机构,2-商户,3- 终端)',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告信息';

-- ----------------------------
-- Records of py_adimg
-- ----------------------------
INSERT INTO `py_adimg` VALUES ('60b87bd093434ab798721685cee85379', '江苏中行2', 'b934abababfa4aef85ebad75295bbec9.png', 'a', '199919d104554a8c85ea3739e25a7e29.png', 'b', '549139bb2f78427b81aa66bfd3fba466.png', 'c', '1', '6929933ac1bd4262a8f52c4ed35be501', '1852865acdc74278b42d938e1a7a4cf9,1c3be752de664c76ac2a289e4532634e,2c047306e6a9405e9207b69d57c5adab,368753a060b64661909ce386bf5e8407,48090620a8844e3d8fb7f7a884648170,4cf6b6ade8f74d9283246aac2d05d5f2,6b724696e5bb4bfea47cb6800a7cae94,7930537ad3bd449eabff52f53ab62eea,aa0710a535cb476aaafdc633a1c1294c,b43168e52d034157b4a5d32c4af63cf8,c06924e340274d56856f954134c00294,d6f4ca037ec443379eecb7d9e620a2c3,eb9fdc14dcc44d0ea8ebcee8aa2e1863', null, '2', '2018-09-09 22:26:27', '1');

-- ----------------------------
-- Table structure for py_bonus_pool
-- ----------------------------
DROP TABLE IF EXISTS `py_bonus_pool`;
CREATE TABLE `py_bonus_pool` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ORG_ID` varchar(64) DEFAULT NULL COMMENT '归属机构',
  `NAME` varchar(64) DEFAULT NULL COMMENT '奖金池名称',
  `TOTAL` decimal(10,2) DEFAULT NULL COMMENT '奖金池总额',
  `DETAIL_DESC` varchar(1000) DEFAULT NULL COMMENT '详细描述',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `USED_TOTAL` decimal(10,2) DEFAULT '0.00',
  `SHARE_RATIO` decimal(4,2) DEFAULT NULL COMMENT '分润百分比',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='奖金池';

-- ----------------------------
-- Records of py_bonus_pool
-- ----------------------------
INSERT INTO `py_bonus_pool` VALUES ('0e9bab3b2aa343329633f620511d1bec', '2', '11', '11.00', '111', '0', '2018-07-14 18:42:06', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('0f5a5ebf040c4f19a2c89ca3df0d19b4', '2', '11', '5000.00', '描述', '1', '2018-07-24 16:58:00', '1', '0.00', '60.00');
INSERT INTO `py_bonus_pool` VALUES ('11a6b78cbb5f4cb4a783659524b14c21', '2', '江苏中行', '22.00', '111111', '0', '2018-07-14 18:42:30', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('2f7cd84923b943d5a7a0008a8e4a2514', '1', '1', '1.00', '2', '0', '2018-07-14 18:14:25', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('53ad51c7288f4549950ff3ed366b0c7b', '', '111', '22.00', '', '1', '2018-07-14 17:53:29', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('8c55684673dd4b3f8b9b68abe58af4c5', '3', 'abc', '10000.00', 'sdfsf', '0', '2018-07-14 20:14:54', '04531ede793c40ba9b90959bb3119a2b', '0.00', null);
INSERT INTO `py_bonus_pool` VALUES ('a1c9617f8e3b45dfb71ef33e67b1e30c', '1', '11', '22.00', '111111', '0', '2018-07-14 18:29:36', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('bbd5cb6532b5477d9dbaf677c789bd7d', '2', '11', '2233.00', '33', '0', '2018-07-14 21:01:08', '04531ede793c40ba9b90959bb3119a2b', '0.00', null);
INSERT INTO `py_bonus_pool` VALUES ('c34f21403244418e83b8d3a7f0f4393c', '2', '2233', '11.00', '111111', '0', '2018-07-14 18:45:01', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('cab12ed4046e4a4f9f326d4a0c832be5', null, null, null, null, '1', '2018-07-14 18:15:03', '04531ede793c40ba9b90959bb3119a2b', null, null);
INSERT INTO `py_bonus_pool` VALUES ('cd8c9b96753443e7bd8b6b798fdac3a1', '2', '江苏中行', '11.00', '11', '0', '2018-07-14 18:43:31', '04531ede793c40ba9b90959bb3119a2b', null, null);

-- ----------------------------
-- Table structure for py_order
-- ----------------------------
DROP TABLE IF EXISTS `py_order`;
CREATE TABLE `py_order` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ORDER_NO` varchar(64) DEFAULT NULL COMMENT '订单流水(平台订单号，系统时间)',
  `ORG_ORDER_NO` varchar(64) DEFAULT NULL COMMENT '原始交易流水',
  `TRADE_NAME` varchar(128) DEFAULT NULL COMMENT '交易名称',
  `TRADE_CODE` varchar(32) DEFAULT NULL COMMENT '交易码',
  `SHOP_CODE` varchar(32) DEFAULT NULL COMMENT '商户编号',
  `POS_CODE` varchar(64) DEFAULT NULL COMMENT 'POS终端号',
  `CARD_NO` varchar(64) DEFAULT NULL COMMENT '卡号',
  `SN` varchar(64) DEFAULT NULL COMMENT '硬件序列号',
  `VERSION` varchar(32) DEFAULT NULL COMMENT '收银台版本号',
  `SHOP_ID` varchar(32) DEFAULT NULL COMMENT '商户ID',
  `CASHIER_ID` varchar(32) DEFAULT NULL COMMENT '收营员ID',
  `ACTIVE_ID` varchar(32) DEFAULT NULL COMMENT '活动ID',
  `CARD_ID` varchar(32) DEFAULT NULL COMMENT '卡ID',
  `ORDER_AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '订单金额',
  `IS_DISCOUNT` varchar(8) DEFAULT NULL COMMENT '是否参与优惠(0:否 1:是)',
  `IS_REFUND` varchar(8) DEFAULT '0' COMMENT '是否退款(0:否 1:是)',
  `REAL_REFUND_AMOUNT` decimal(10,2) DEFAULT '0.00' COMMENT '实际退款金额',
  `DISCOUNT` decimal(5,2) DEFAULT NULL COMMENT '折扣',
  `DISCOUNT_AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '优惠金额',
  `DISCOUNT_AMOUNT_TOTAL` decimal(10,2) DEFAULT NULL COMMENT '总优惠金额',
  `REAL_AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '实际金额',
  `PAY_TYPE` varchar(32) DEFAULT NULL COMMENT '支付方式',
  `PAY_TIME` datetime DEFAULT NULL COMMENT '支付时间',
  `REQ_INFO` text COMMENT '请求原文',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态(1:待支付 2:已支付 3:撤销)',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息';

-- ----------------------------
-- Records of py_order
-- ----------------------------
INSERT INTO `py_order` VALUES ('1', '20180729', '1234567', '测试交易', 'abc', '99999999911016', '111', '62227', '2323', '1.1', '0bb4ad4cd2c5445db6f7b5783d2098f7', '2dfdeae986594119bf9cfa5b374a3aef', '602bfe517d0b475486e5e22ab7926589', '1', '1000.00', '1', '0', '0.00', null, '100.00', '100.00', '900.00', '1', '2018-07-29 14:21:47', null, '2', '2018-07-29 14:21:47');

-- ----------------------------
-- Table structure for py_shop_info
-- ----------------------------
DROP TABLE IF EXISTS `py_shop_info`;
CREATE TABLE `py_shop_info` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `CODE` varchar(64) DEFAULT NULL COMMENT '商户编号',
  `NAME` varchar(64) DEFAULT NULL COMMENT '商户名称',
  `ORG_ID` varchar(64) DEFAULT NULL COMMENT '所属机构',
  `SHORT_NAME` varchar(64) DEFAULT NULL COMMENT '商户简称',
  `TYPE` varchar(64) DEFAULT NULL COMMENT '商户类型(餐饮,电影娱乐)',
  `ADDRESS` varchar(64) DEFAULT NULL COMMENT '详细地址',
  `CONTACT_NUM` varchar(64) DEFAULT NULL COMMENT '联系人',
  `CONTACT_NAME` varchar(64) DEFAULT NULL COMMENT '联系电话',
  `EMAIL` varchar(64) DEFAULT NULL COMMENT 'EMAIL',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户信息';

-- ----------------------------
-- Records of py_shop_info
-- ----------------------------
INSERT INTO `py_shop_info` VALUES ('0bb4ad4cd2c5445db6f7b5783d2098f7', '99999999911016', '11', '2', '33', '2', '111', '18011111111', '11', 'sdfs@qq.com', '1', '2018-07-14 18:35:19', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_shop_info` VALUES ('1', '99999999911018', '总商户', '1', '总商', '1', '鼓楼区', '059183706662', '店长', 'sdfsd@qq.com', '1', '2018-06-24 21:45:10', '1');
INSERT INTO `py_shop_info` VALUES ('2d14fb56655a46a287babef7de89bcc0', '99999999911019', '11', '2', '1', '2', '111', '18011111111', '11', 'sdfs@qq.com', '1', '2018-07-14 18:38:50', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_shop_info` VALUES ('6929933ac1bd4262a8f52c4ed35be501', '99999999911020', '江苏中行1', '1', '江苏中行1', '1', '22222', '18011111111', '11', 'sdfs@qq.com', '1', '2018-07-14 18:40:36', '1');
INSERT INTO `py_shop_info` VALUES ('80021de01c374ce78425e01c5eeeacff', '99999999911021', '江苏中行', '2', '江苏中行', '2', '22222', '18011111111', '222', 'sdfs@qq.com', '1', '2018-07-14 18:41:40', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `py_shop_info` VALUES ('ddcc2b23d6dc499eb31c8c690c3ec47e', '99999999911022', '22', '2', '22', '1', '22222', '222', '222', 'sdfs@qq.com', '0', '2018-06-25 22:07:41', '04531ede793c40ba9b90959bb3119a2b');

-- ----------------------------
-- Table structure for py_sign
-- ----------------------------
DROP TABLE IF EXISTS `py_sign`;
CREATE TABLE `py_sign` (
  `ID` varchar(32) DEFAULT NULL,
  `USER_ID` varchar(128) DEFAULT NULL COMMENT '操作员号',
  `operator_Code` varchar(128) DEFAULT NULL COMMENT ' 签到码',
  `trains_Code` varchar(128) DEFAULT NULL COMMENT '交易码',
  `version` varchar(128) DEFAULT NULL COMMENT '收银台版本号',
  `shop_No` varchar(128) DEFAULT NULL COMMENT '商户号',
  `pos_No` varchar(128) DEFAULT NULL COMMENT '终端号 ',
  `sn` varchar(128) DEFAULT NULL COMMENT '硬件序列号',
  `sign_In_Time` varchar(128) DEFAULT NULL COMMENT '签到时间',
  `sign_Out_Time` varchar(128) DEFAULT NULL COMMENT '签出时间',
  `CREATE_TIME` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of py_sign
-- ----------------------------

-- ----------------------------
-- Table structure for py_terminal
-- ----------------------------
DROP TABLE IF EXISTS `py_terminal`;
CREATE TABLE `py_terminal` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `SHOP_ID` varchar(32) DEFAULT NULL COMMENT '商户ID',
  `BATCH_ID` varchar(32) DEFAULT NULL,
  `CODE` varchar(128) DEFAULT NULL COMMENT '终端编号',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商户终端信息';

-- ----------------------------
-- Records of py_terminal
-- ----------------------------
INSERT INTO `py_terminal` VALUES ('03cf26ebfc9940b4a2a6e08ba214409c', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091120', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('1852865acdc74278b42d938e1a7a4cf9', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091113', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('1c3be752de664c76ac2a289e4532634e', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091122', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('2c047306e6a9405e9207b69d57c5adab', '6929933ac1bd4262a8f52c4ed35be501', null, '20091112', '1', '1', '2018-09-09 17:52:57');
INSERT INTO `py_terminal` VALUES ('368753a060b64661909ce386bf5e8407', '6929933ac1bd4262a8f52c4ed35be501', null, '20091111', '1', '1', '2018-09-09 17:04:30');
INSERT INTO `py_terminal` VALUES ('48090620a8844e3d8fb7f7a884648170', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091117', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('4cf6b6ade8f74d9283246aac2d05d5f2', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091118', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('58745e65cfdd4084b92969e44d9cc24f', 'ddcc2b23d6dc499eb31c8c690c3ec47e', '3089a5d478ad4d0a8f5315df5e4b87a7', '20010106', '0', '04531ede793c40ba9b90959bb3119a2b', '2018-07-14 23:23:17');
INSERT INTO `py_terminal` VALUES ('6b724696e5bb4bfea47cb6800a7cae94', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091123', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('7930537ad3bd449eabff52f53ab62eea', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091119', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('82b665be1962447a9b7a9cda50c52455', '1', '3089a5d478ad4d0a8f5315df5e4b87a7', '20010102', '1', '04531ede793c40ba9b90959bb3119a2b', '2018-07-14 23:23:17');
INSERT INTO `py_terminal` VALUES ('85195461e940453ebf6dfbce9d6d5f3a', '80021de01c374ce78425e01c5eeeacff', '3089a5d478ad4d0a8f5315df5e4b87a7', '20010105', '1', '04531ede793c40ba9b90959bb3119a2b', '2018-07-14 23:23:17');
INSERT INTO `py_terminal` VALUES ('a0d4eb62d5d640ceb7445aa4fd1712a0', '2d14fb56655a46a287babef7de89bcc0', '3089a5d478ad4d0a8f5315df5e4b87a7', '20010103', '1', '04531ede793c40ba9b90959bb3119a2b', '2018-07-14 23:23:17');
INSERT INTO `py_terminal` VALUES ('aa0710a535cb476aaafdc633a1c1294c', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091116', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('b43168e52d034157b4a5d32c4af63cf8', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091121', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('c06924e340274d56856f954134c00294', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091114', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('d6f4ca037ec443379eecb7d9e620a2c3', '6929933ac1bd4262a8f52c4ed35be501', '92a34dde0ef342518977f15eefc68d0a', '20091115', '1', '1', '2018-09-09 17:53:17');
INSERT INTO `py_terminal` VALUES ('eb9fdc14dcc44d0ea8ebcee8aa2e1863', '6929933ac1bd4262a8f52c4ed35be501', '3089a5d478ad4d0a8f5315df5e4b87a7', '20010104', '1', '04531ede793c40ba9b90959bb3119a2b', '2018-07-14 23:23:17');
INSERT INTO `py_terminal` VALUES ('f06fcaa575ac4d6fafd9bdb63d7fc3c2', '0bb4ad4cd2c5445db6f7b5783d2098f7', '3089a5d478ad4d0a8f5315df5e4b87a7', '20010101', '1', '04531ede793c40ba9b90959bb3119a2b', '2018-07-14 23:23:17');

-- ----------------------------
-- Table structure for py_terminal_adimg
-- ----------------------------
DROP TABLE IF EXISTS `py_terminal_adimg`;
CREATE TABLE `py_terminal_adimg` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `ADIMG_ID` varchar(64) DEFAULT NULL COMMENT '广告ID',
  `TERMINAL_ID` varchar(64) DEFAULT NULL COMMENT '终端ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='终端广告信息';

-- ----------------------------
-- Records of py_terminal_adimg
-- ----------------------------
INSERT INTO `py_terminal_adimg` VALUES ('008dab6d07ac4c60acdf288b4dafc7fc', '60b87bd093434ab798721685cee85379', '6b724696e5bb4bfea47cb6800a7cae94');
INSERT INTO `py_terminal_adimg` VALUES ('0d79c5273e8547b6acb2eae7e8771292', '60b87bd093434ab798721685cee85379', '1852865acdc74278b42d938e1a7a4cf9');
INSERT INTO `py_terminal_adimg` VALUES ('2ca0d0a23e2247e5a0d797f62ed3291f', '60b87bd093434ab798721685cee85379', '4cf6b6ade8f74d9283246aac2d05d5f2');
INSERT INTO `py_terminal_adimg` VALUES ('355ad1ff94d2474bb0ebc02cec4cb0ff', '60b87bd093434ab798721685cee85379', '7930537ad3bd449eabff52f53ab62eea');
INSERT INTO `py_terminal_adimg` VALUES ('3ff189834dac42f186a8b6ed207e5557', '60b87bd093434ab798721685cee85379', '1c3be752de664c76ac2a289e4532634e');
INSERT INTO `py_terminal_adimg` VALUES ('5ade58c8d97e4d11ae962db96a16f32d', '60b87bd093434ab798721685cee85379', 'aa0710a535cb476aaafdc633a1c1294c');
INSERT INTO `py_terminal_adimg` VALUES ('6a040a7537ce41a9b0c4a52211921259', '60b87bd093434ab798721685cee85379', '2c047306e6a9405e9207b69d57c5adab');
INSERT INTO `py_terminal_adimg` VALUES ('a6934e1160f04b13b0a3b0363c1ea0bc', '60b87bd093434ab798721685cee85379', '48090620a8844e3d8fb7f7a884648170');
INSERT INTO `py_terminal_adimg` VALUES ('d08a2693e7b340cf9941192523e4ac22', '60b87bd093434ab798721685cee85379', '368753a060b64661909ce386bf5e8407');
INSERT INTO `py_terminal_adimg` VALUES ('d14f01a163b24495b0061743f96b8663', '60b87bd093434ab798721685cee85379', 'b43168e52d034157b4a5d32c4af63cf8');
INSERT INTO `py_terminal_adimg` VALUES ('ddbabb412a1d42f1a33b3c1f8e94979a', '60b87bd093434ab798721685cee85379', 'c06924e340274d56856f954134c00294');
INSERT INTO `py_terminal_adimg` VALUES ('f8505cec1fc14116b2b8f71035c67639', '60b87bd093434ab798721685cee85379', 'd6f4ca037ec443379eecb7d9e620a2c3');
INSERT INTO `py_terminal_adimg` VALUES ('fa0e194a131245cc9ac709c3e610b28e', '60b87bd093434ab798721685cee85379', 'eb9fdc14dcc44d0ea8ebcee8aa2e1863');

-- ----------------------------
-- Table structure for sys_app_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_user`;
CREATE TABLE `sys_app_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `SFID` varchar(100) DEFAULT NULL,
  `START_TIME` varchar(100) DEFAULT NULL,
  `END_TIME` varchar(100) DEFAULT NULL,
  `YEARS` int(10) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app_user
-- ----------------------------
INSERT INTO `sys_app_user` VALUES ('04762c0b28b643939455c7800c2e2412', 'dsfsd', 'f1290186a5d0b1ceab27f4e77c0c5d68', 'w', '', '55896f5ce3c0494fa6850775a4e29ff6', '', '', '0', '', '18766666666', '', '', '', '0', '001', '18766666666@qq.com');
INSERT INTO `sys_app_user` VALUES ('3faac8fe5c0241e593e0f9ea6f2d5870', 'dsfsdf', 'f1290186a5d0b1ceab27f4e77c0c5d68', 'wewe', '', '68f23fc0caee475bae8d52244dea8444', '', '', '1', '', '18767676767', '', '', '', '0', 'wqwe', 'qweqwe@qq.com');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `ID` varchar(32) NOT NULL,
  `KEY` varchar(255) DEFAULT NULL,
  `VALUE` varchar(255) DEFAULT NULL,
  `DESC` varchar(255) DEFAULT NULL,
  `GROUP` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('1', '1', '待支付', '订单支付状态', 'ORDER_PAY_STATE');
INSERT INTO `sys_dict` VALUES ('11', '1', '支付运营商', '角色类型', 'ROLE_TYPE');
INSERT INTO `sys_dict` VALUES ('12', '2', '下级支付运营商', '角色类型', 'ROLE_TYPE');
INSERT INTO `sys_dict` VALUES ('13', '3', '商户', '角色类型', 'ROLE_TYPE');
INSERT INTO `sys_dict` VALUES ('15', '4', '收银员', '角色类型', 'ROLE_TYPE');
INSERT INTO `sys_dict` VALUES ('2', '2', '已支付', '订单支付状态', 'ORDER_PAY_STATE');
INSERT INTO `sys_dict` VALUES ('3', '3', '已撤销', '订单支付状态', 'ORDER_PAY_STATE');

-- ----------------------------
-- Table structure for sys_dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionaries`;
CREATE TABLE `sys_dictionaries` (
  `ZD_ID` varchar(100) NOT NULL,
  `NAME` varchar(100) DEFAULT NULL,
  `BIANMA` varchar(100) DEFAULT NULL,
  `ORDY_BY` int(10) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `JB` int(10) DEFAULT NULL,
  `P_BM` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ZD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionaries
-- ----------------------------
INSERT INTO `sys_dictionaries` VALUES ('212a6765fddc4430941469e1ec8c8e6c', '人事部', '001', '1', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_001');
INSERT INTO `sys_dictionaries` VALUES ('3cec73a7cc8a4cb79e3f6ccc7fc8858c', '行政部', '002', '2', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_002');
INSERT INTO `sys_dictionaries` VALUES ('48724375640341deb5ef01ac51a89c34', '北京', 'dq001', '1', 'cdba0b5ef20e4fc0a5231fa3e9ae246a', '2', 'DQ_dq001');
INSERT INTO `sys_dictionaries` VALUES ('5a1547632cca449db378fbb9a042b336', '研发部', '004', '4', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_004');
INSERT INTO `sys_dictionaries` VALUES ('7f9cd74e60a140b0aea5095faa95cda3', '财务部', '003', '3', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_003');
INSERT INTO `sys_dictionaries` VALUES ('b861bd1c3aba4934acdb5054dd0d0c6e', '科技不', 'kj', '7', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_kj');
INSERT INTO `sys_dictionaries` VALUES ('c067fdaf51a141aeaa56ed26b70de863', '部门', 'BM', '1', '0', '1', 'BM');
INSERT INTO `sys_dictionaries` VALUES ('cdba0b5ef20e4fc0a5231fa3e9ae246a', '地区', 'DQ', '2', '0', '1', 'DQ');
INSERT INTO `sys_dictionaries` VALUES ('f184bff5081d452489271a1bd57599ed', '上海', 'SH', '2', 'cdba0b5ef20e4fc0a5231fa3e9ae246a', '2', 'DQ_SH');
INSERT INTO `sys_dictionaries` VALUES ('f30bf95e216d4ebb8169ff0c86330b8f', '客服部', '006', '6', 'c067fdaf51a141aeaa56ed26b70de863', '2', 'BM_006');

-- ----------------------------
-- Table structure for sys_file
-- ----------------------------
DROP TABLE IF EXISTS `sys_file`;
CREATE TABLE `sys_file` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `FILE_PATCH` varchar(1024) DEFAULT NULL COMMENT '物理路径',
  `URL` varchar(1024) DEFAULT NULL COMMENT 'URL',
  `FILE_NAME` varchar(1024) DEFAULT NULL COMMENT '文件名',
  `ORI_FILE_NAME` varchar(1024) DEFAULT NULL COMMENT '文件原始名称',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统文件';

-- ----------------------------
-- Records of sys_file
-- ----------------------------
INSERT INTO `sys_file` VALUES ('37ce2af1269f4b7c86b6416b25edb4c2', 'D:\\Workspace\\.metadata\\.me_tcat\\webapps\\payment-webapp\\uploadFiles\\adimg\\802b7a45bd904b50965a399c0e33803b.png', null, '802b7a45bd904b50965a399c0e33803b.png', '131314thixg06aq2axxczb.jpg.thumb.png', '2018-09-09 22:35:15', null);
INSERT INTO `sys_file` VALUES ('6176041c8f994fd8b4a92de3c49c3bab', 'D:\\Workspace\\.metadata\\.me_tcat\\webapps\\payment-webapp\\uploadFiles\\adimg\\b934abababfa4aef85ebad75295bbec9.png', null, 'b934abababfa4aef85ebad75295bbec9.png', '131314thixg06aq2axxczb.jpg.thumb.png', '2018-09-09 22:36:22', null);
INSERT INTO `sys_file` VALUES ('6484b2da8e954f6da4521497ea7fce75', 'D:\\Workspace\\.metadata\\.me_tcat\\webapps\\payment-webapp\\uploadFiles\\adimg\\549139bb2f78427b81aa66bfd3fba466.png', null, '549139bb2f78427b81aa66bfd3fba466.png', '131314thixg06aq2axxczb.jpg.thumb.png', '2018-09-09 22:26:27', null);
INSERT INTO `sys_file` VALUES ('8ae27e744ebd48e197358a8df07b76c9', 'D:\\Workspace\\.metadata\\.me_tcat\\webapps\\payment-webapp\\uploadFiles\\adimg\\199919d104554a8c85ea3739e25a7e29.png', null, '199919d104554a8c85ea3739e25a7e29.png', '131314thixg06aq2axxczb.jpg.thumb.png', '2018-09-09 22:26:27', null);
INSERT INTO `sys_file` VALUES ('9571f8f550dc4dba8dae1cf51424e94d', 'D:\\Workspace\\.metadata\\.me_tcat\\webapps\\payment-webapp\\uploadFiles\\adimg\\437947187c784dcc871bc281a5485608.png', null, '437947187c784dcc871bc281a5485608.png', '131314thixg06aq2axxczb.jpg.thumb.png', '2018-09-09 22:26:27', null);
INSERT INTO `sys_file` VALUES ('c6840c5b763c4d4980a2984aeed61cf0', 'D:\\Workspace\\.metadata\\.me_tcat\\webapps\\payment-webapp\\uploadFiles\\adimg\\6df1db1daeee4a10bf4b5df42a144430.png', null, '6df1db1daeee4a10bf4b5df42a144430.png', '131314thixg06aq2axxczb.jpg.thumb.png', '2018-09-09 22:27:37', null);

-- ----------------------------
-- Table structure for sys_gl_qx
-- ----------------------------
DROP TABLE IF EXISTS `sys_gl_qx`;
CREATE TABLE `sys_gl_qx` (
  `GL_ID` varchar(100) NOT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `FX_QX` int(10) DEFAULT NULL,
  `FW_QX` int(10) DEFAULT NULL,
  `QX1` int(10) DEFAULT NULL,
  `QX2` int(10) DEFAULT NULL,
  `QX3` int(10) DEFAULT NULL,
  `QX4` int(10) DEFAULT NULL,
  PRIMARY KEY (`GL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_gl_qx
-- ----------------------------
INSERT INTO `sys_gl_qx` VALUES ('1', '2', '1', '1', '1', '1', '1', '1');
INSERT INTO `sys_gl_qx` VALUES ('2', '1', '0', '0', '1', '1', '1', '1');
INSERT INTO `sys_gl_qx` VALUES ('55896f5ce3c0494fa6850775a4e29ff6', '7', '0', '0', '1', '0', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('68f23fc0caee475bae8d52244dea8444', '7', '0', '0', '1', '0', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('7dfd8d1f7b6245d283217b7e63eec9b2', '1', '1', '1', '0', '0', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('ac66961adaa2426da4470c72ffeec117', '1', '1', '0', '0', '1', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('b0c77c29dfa140dc9b14a29c056f824f', '7', '1', '0', '1', '0', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('e74f713314154c35bd7fc98897859fe3', '6', '1', '1', '1', '1', '0', '0');
INSERT INTO `sys_gl_qx` VALUES ('f944a9df72634249bbcb8cb73b0c9b86', '7', '1', '1', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(255) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `MENU_ORDER` varchar(100) DEFAULT NULL,
  `MENU_ICON` varchar(30) DEFAULT NULL,
  `MENU_TYPE` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '机构维护', '#', '0', '1', 'icon-sitemap', '2');
INSERT INTO `sys_menu` VALUES ('2', '机构管理', 'org/index', '1', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('5', '系统用户', 'user/listUsers.do', '25', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('6', '商户门店', '#', '0', '2', 'icon-home', '2');
INSERT INTO `sys_menu` VALUES ('9', '奖金池', '#', '0', '3', 'icon-money', '2');
INSERT INTO `sys_menu` VALUES ('13', '奖金池', 'bonus/listBonus', '9', '0', null, '2');
INSERT INTO `sys_menu` VALUES ('15', '促销活动', '#', '0', '4', 'icon-gift', '2');
INSERT INTO `sys_menu` VALUES ('16', '定额活动', 'active/listActives?type=dehd', '15', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('17', '折扣优惠', 'active/listActives?type=zkyh', '15', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('18', '随机优惠', 'active/listActives?type=sjyh', '15', '3', null, '2');
INSERT INTO `sys_menu` VALUES ('19', '立减优惠', 'active/listActives?type=ljyh', '15', '4', null, '2');
INSERT INTO `sys_menu` VALUES ('22', '流水查询', '#', '0', '5', 'icon-list', '2');
INSERT INTO `sys_menu` VALUES ('25', '系统信息', '#', '0', '8', 'icon-cogs', '2');
INSERT INTO `sys_menu` VALUES ('26', '报表查询', '#', '0', '6', 'icon-signal', '2');
INSERT INTO `sys_menu` VALUES ('61', '商户门店', 'shop/listShops', '6', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('62', '终端编号', 'terminal/listTerminal', '6', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('63', '门店收银员', 'cashier/listCashier', '6', '3', null, '2');
INSERT INTO `sys_menu` VALUES ('221', '交易流水查询', 'order/listOrder?type=1', '22', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('252', '角色管理', 'role/listRole', '25', '2', '', '2');
INSERT INTO `sys_menu` VALUES ('253', '广告管理', 'adimg/listAdimg', '25', '3', null, '2');
INSERT INTO `sys_menu` VALUES ('261', '业务汇总报表', 'report/busCollectAll', '26', '1', null, '2');
INSERT INTO `sys_menu` VALUES ('262', '活动汇总报表', 'report/activeCollectList', '26', '2', null, '2');
INSERT INTO `sys_menu` VALUES ('263', '分润报表', 'report/cashierShareList', '26', '3', null, null);

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org` (
  `ID` varchar(32) NOT NULL COMMENT 'ID',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '上级ID',
  `NAME` varchar(64) DEFAULT NULL COMMENT '机构名称',
  `SHORT_NAME` varchar(64) DEFAULT NULL COMMENT '机构简称',
  `STATE` varchar(8) DEFAULT '1' COMMENT '状态',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构信息';

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES ('018e927580cb4135ba2c17364bb6e18e', 'c64ee459fef94e2e87e372a84864fd21', 'a3', 'a3', '0', '2018-06-24 19:54:47', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `sys_org` VALUES ('1', '0', '中国银行总行', '中总行', '1', null, null);
INSERT INTO `sys_org` VALUES ('1e556d125dd84015a2fa7c7812bd312a', '3', 'aaa', 'aaa', '0', '2018-06-24 19:54:19', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `sys_org` VALUES ('2', '1', '福建银行', '福建银行', '1', null, null);
INSERT INTO `sys_org` VALUES ('3', '1', '江苏中行1', '江苏中行', '1', null, null);
INSERT INTO `sys_org` VALUES ('39c05faae4af442cb1212276458d0cf6', '4687ccd806fc4813819ebf6be5f6629b', '111测试1', '111测试', '0', '2018-07-31 11:10:21', '1');
INSERT INTO `sys_org` VALUES ('4687ccd806fc4813819ebf6be5f6629b', '3', 'test1', 'test1', '1', '2018-07-31 11:08:40', '1');
INSERT INTO `sys_org` VALUES ('647333bb2cc44b7bb35142d99df7f3fd', '1e556d125dd84015a2fa7c7812bd312a', 'a1', 'a1', '0', '2018-06-24 19:54:29', '04531ede793c40ba9b90959bb3119a2b');
INSERT INTO `sys_org` VALUES ('c64ee459fef94e2e87e372a84864fd21', '647333bb2cc44b7bb35142d99df7f3fd', 'a2', 'a2', '0', '2018-06-24 19:54:37', '04531ede793c40ba9b90959bb3119a2b');

-- ----------------------------
-- Table structure for sys_right
-- ----------------------------
DROP TABLE IF EXISTS `sys_right`;
CREATE TABLE `sys_right` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `NAME` varchar(64) DEFAULT NULL COMMENT '权限名称',
  `CODE` varchar(64) DEFAULT NULL COMMENT '权限编码',
  `TYPE` varchar(64) DEFAULT NULL COMMENT '权限类型',
  `MENU_ID` varchar(32) DEFAULT NULL COMMENT '菜单ID',
  `STATE` varchar(8) DEFAULT NULL COMMENT '状态',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限信息';

-- ----------------------------
-- Records of sys_right
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(100) NOT NULL,
  `ROLE_CODE` varchar(100) DEFAULT NULL COMMENT '权限编码',
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `ADD_QX` varchar(255) DEFAULT NULL,
  `DEL_QX` varchar(255) DEFAULT NULL,
  `EDIT_QX` varchar(255) DEFAULT NULL,
  `CHA_QX` varchar(255) DEFAULT NULL,
  `QX_ID` varchar(100) DEFAULT NULL,
  `STATE` varchar(8) DEFAULT '1' COMMENT '状态',
  `TYPE` varchar(8) DEFAULT NULL COMMENT '权限类型',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'ADMIN', '支付运营商', '4194294', '0', '1', '1', '1', '1', '1', '1', '1', null, null);
INSERT INTO `sys_role` VALUES ('2', 'XJYYS', '下级运营商', '4194294', '0', '1048822', '50', '34', '54', '2', '1', '2', null, null);
INSERT INTO `sys_role` VALUES ('3', 'SH', '商户', '', '0', '', '', '', '', '', '1', '3', null, null);
INSERT INTO `sys_role` VALUES ('4', 'SYY', '收银员', '', '0', '', '', '', '', '', '1', '4', null, null);
INSERT INTO `sys_role` VALUES ('481ef4c53aaa4a8cb94239d450551e99', null, '测试角色', null, null, null, null, null, null, null, '1', '3', '2018-08-19 18:15:48', '2');

-- ----------------------------
-- Table structure for sys_role_right
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_right`;
CREATE TABLE `sys_role_right` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `ROLE_ID` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `RIGHT_ID` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

-- ----------------------------
-- Records of sys_role_right
-- ----------------------------
INSERT INTO `sys_role_right` VALUES ('0791542c49fc4fb1a3499c351216d601', '1', '221', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('07d3ca5e7a83444cacb16267c1ef6828', '2', '252', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('09f781aba075499bafa3312b21c8c711', '2', '221', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('219d78dcd4d24ac5aa6cad3edb899fe7', '481ef4c53aaa4a8cb94239d450551e99', '221', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('23bf28e8b99a44c1a3c3ffe17a4b98da', '3', '13', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('265256a7b04d49c4b7501618ef4e130e', '1', '63', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('3252d0aab34e4339953b281bf7a1c08e', '3', '16', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('32e4b93cc78e4e508dfaf45c7be4cd92', '1', '61', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('3b80055dee5c40b589cf4c4a6980d021', '3', '63', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('460ec82f464a4be7aca6421d529b560a', '2', '62', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('47d67824165043ea8f83c94c98430f82', '481ef4c53aaa4a8cb94239d450551e99', '5', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('49025157740e41fb9605c58ceddd4ee5', '3', '17', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('498ba9f5c4a7422fa62b66a045c94940', '3', '252', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('49ca17c817d542b8ac732e4c804a5e78', '3', '263', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('5300c1901ef24ac78cd251b5d6a07e4f', '481ef4c53aaa4a8cb94239d450551e99', '63', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('5613dc06b4ca431f81e89d538162eed5', '481ef4c53aaa4a8cb94239d450551e99', '13', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('574087e2f35c4b5a8fdcddf46d27f948', '481ef4c53aaa4a8cb94239d450551e99', '262', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('58fc0efd86fb4ccf85a4bd3f57390186', '2', '263', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('5af711f6df0f4e37b2a16789866b23aa', '2', '5', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('5b5d8698cd3e4fc380ea9b7dd735b442', '1', '261', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('5c9b7b838d02443f828808bf8589ed98', '481ef4c53aaa4a8cb94239d450551e99', '261', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('5dcc07401dfc420088a49d478637c22c', '3', '261', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('61c0e8feaf2f46b189f3e8ad89b3c3fd', '3', '262', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('626cde3f92e2484dbb859574815d3203', '2', '63', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('627977bd6f7a4b2384868e77d37d546a', '1', '262', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('677eafc7841b4a2dbc19fdac4fb567ac', '1', '16', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('6fb744a1f9a84395ab4d7e2502d8b972', '3', '61', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('7ac0faca52f94ec48ba13828ba179aeb', '2', '19', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('81e0ae8b6c9a49f590287d75b9780809', '2', '17', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('833e8f0224614bd196b34b98da61d134', '4', '13', '2018-08-19 19:22:57', null);
INSERT INTO `sys_role_right` VALUES ('83b85e4b2ab04cebb7f90c66adae9ab4', '1', '19', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('8e48fce8de9d42b9b553e193173fb76e', '2', '61', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('8fa9cceadf2b47ed94ea4c08f84507c6', '1', '5', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('90513ec2e8814e18b0c11d6f172443b8', '481ef4c53aaa4a8cb94239d450551e99', '252', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('9dba532f922e4188886fb306dc731ae9', '3', '19', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('9e4dfc8ecf444239a19fbb25debd86a1', '2', '18', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('9f592cddf3e94a77bdbca854bba5cee4', '3', '2', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('a0b7e2c9643648f28b103d7ed3b6e65e', '481ef4c53aaa4a8cb94239d450551e99', '2', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('a298bb0cbe3742918a1cb9b41d3a6ba2', '1', '252', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('a330cb619a8a4c8a8dab01321f21087a', '2', '261', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('a95582eb475843a08080bfc1dee1ca7b', '1', '253', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('abf14c3fe746473c8e0abb41a33f5d32', '3', '18', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('b04ac5a9f4894ece8394478440fa6ef1', '2', '16', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('b0eb83492c0c4f88a585970bc5cc60f7', '1', '17', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('b3b9b7c64d644c84ab2d57c699fc684d', '2', '2', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('b4298d0f760a4f4a903050ee51855e4d', '3', '5', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('bb67a39e37b64755a66495282a5e7c9d', '1', '2', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('bbbf984ff0be4a6db9b0312f8e68ad13', '481ef4c53aaa4a8cb94239d450551e99', '16', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('c1de746c5e8e474d97b4ae7243a7a0b1', '3', '221', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('d1d8a9efca244638a0afe50d64c3e8fe', '2', '13', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('db5ad8be5cf24959892a1559584ca014', '1', '18', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('e3bf213b1cfe4987a8c669dc17b64aa7', '1', '62', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('e4cb273ff8c74ca4b799e826b4b84e9b', '481ef4c53aaa4a8cb94239d450551e99', '19', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('f2126b9fda844f64adc35924646b3637', '1', '13', '2018-09-07 16:19:16', null);
INSERT INTO `sys_role_right` VALUES ('f72d6957dbc3452080f3a70f5f02cf03', '2', '262', '2018-08-22 10:56:22', null);
INSERT INTO `sys_role_right` VALUES ('f7aace8b184d4329810d1c4ba0c2045b', '481ef4c53aaa4a8cb94239d450551e99', '17', '2018-08-19 19:24:03', null);
INSERT INTO `sys_role_right` VALUES ('f7f406d0358949f6916a788c49a6b741', '3', '62', '2018-08-22 10:56:27', null);
INSERT INTO `sys_role_right` VALUES ('fcd6fa0b98054d1ea4a97b1592b14932', '1', '263', '2018-09-07 16:19:16', null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '登陆名',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '登陆密码',
  `NAME` varchar(255) DEFAULT NULL COMMENT '用户姓名',
  `RIGHTS` varchar(255) DEFAULT NULL COMMENT '权限编码',
  `ROLE_ID` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `LAST_LOGIN` varchar(255) DEFAULT NULL COMMENT '最近登录时间',
  `IP` varchar(100) DEFAULT NULL COMMENT '最近登录IP',
  `STATUS` varchar(32) DEFAULT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `SKIN` varchar(100) DEFAULT NULL COMMENT '系统皮肤',
  `EMAIL` varchar(32) DEFAULT NULL COMMENT 'EMAIL',
  `NUMBER` varchar(100) DEFAULT NULL COMMENT '编号',
  `PHONE` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(100) DEFAULT NULL COMMENT '创建用户',
  `SLAT` varchar(32) DEFAULT NULL COMMENT '密码盐值',
  `SHOP_ID` varchar(32) DEFAULT NULL COMMENT '收银员对应商店ID',
  `ORG_ID` varchar(32) DEFAULT NULL,
  `opcode` varchar(100) DEFAULT NULL COMMENT '操作码',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('04531ede793c40ba9b90959bb3119a2b', 'test222', '95b9eecaffa7e80d28744d1110568b1b1eff95ea', '测试2', '', '1', '2018-08-15 21:39:51', '', '0', 'sfdf', 'default', 'asda@dsfsd.com', 'asf', '18088888888', null, null, null, null, '3', null);
INSERT INTO `sys_user` VALUES ('1', 'admin', 'de41b7fb99201d8334c23c014db35ecd92df81bc', '系统管理员', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2018-09-09 22:23:27', '127.0.0.1', '0', '最高统治者', 'default', 'admin@main.com', '001', '18788888888', null, null, null, null, '0', null);
INSERT INTO `sys_user` VALUES ('2', 'submgr', '2ec18a51266179d6ebf36766f74cc381ec4974bb', '下级支付运营商', '1133671055321055258374707980945218933803269864762743594642571294', '481ef4c53aaa4a8cb94239d450551e99', '2018-08-19 22:17:15', '127.0.0.1', '0', '下级支付运营商', 'default', 'admin@main.com', '001', '18788888888', null, null, null, null, '1', null);
INSERT INTO `sys_user` VALUES ('2dfdeae986594119bf9cfa5b374a3aef', '123a', '236f27e4c0597a7ac63868eb5f0311122a467873', '123a', null, '4', '2018-08-31 11:30:50', null, null, null, null, null, null, null, '2018-08-06 22:21:34', '04531ede793c40ba9b90959bb3119a2b', null, '6929933ac1bd4262a8f52c4ed35be501', '0', null);

-- ----------------------------
-- Table structure for sys_user_qx
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_qx`;
CREATE TABLE `sys_user_qx` (
  `U_ID` varchar(100) NOT NULL,
  `C1` int(10) DEFAULT NULL,
  `C2` int(10) DEFAULT NULL,
  `C3` int(10) DEFAULT NULL,
  `C4` int(10) DEFAULT NULL,
  `Q1` int(10) DEFAULT NULL,
  `Q2` int(10) DEFAULT NULL,
  `Q3` int(10) DEFAULT NULL,
  `Q4` int(10) DEFAULT NULL,
  PRIMARY KEY (`U_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_qx
-- ----------------------------
INSERT INTO `sys_user_qx` VALUES ('1', '1', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('2', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO `sys_user_qx` VALUES ('55896f5ce3c0494fa6850775a4e29ff6', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('68f23fc0caee475bae8d52244dea8444', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('7dfd8d1f7b6245d283217b7e63eec9b2', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('ac66961adaa2426da4470c72ffeec117', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('b0c77c29dfa140dc9b14a29c056f824f', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('e74f713314154c35bd7fc98897859fe3', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `sys_user_qx` VALUES ('f944a9df72634249bbcb8cb73b0c9b86', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for sys_user_right
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_right`;
CREATE TABLE `sys_user_right` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `USER_ID` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `RIGHT_ID` varchar(64) DEFAULT NULL COMMENT '权限ID',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户权限';

-- ----------------------------
-- Records of sys_user_right
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `ID` varchar(32) NOT NULL DEFAULT '' COMMENT 'ID',
  `USER_ID` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `RIGHT_ID` varchar(64) DEFAULT NULL COMMENT '角色ID',
  `CREATE_TIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建用户',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_pictures
-- ----------------------------
DROP TABLE IF EXISTS `tb_pictures`;
CREATE TABLE `tb_pictures` (
  `PICTURES_ID` varchar(100) NOT NULL,
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `NAME` varchar(255) DEFAULT NULL COMMENT '文件名',
  `PATH` varchar(255) DEFAULT NULL COMMENT '路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `MASTER_ID` varchar(255) DEFAULT NULL COMMENT '属于',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`PICTURES_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pictures
-- ----------------------------
INSERT INTO `tb_pictures` VALUES ('1d16c4e6ac2d46fda5802462819b3162', '图片', 'ef09a150ba8f4f36864fbfa6540ffda8.jpg', '20150803/ef09a150ba8f4f36864fbfa6540ffda8.jpg', '2015-08-03 14:31:32', '1', '图片管理处上传');
INSERT INTO `tb_pictures` VALUES ('aa07d74f97fe4171be10067f6e738820', '图片', 'c238f8ac2343484daee37c70855c217a.jpg', '20150803/c238f8ac2343484daee37c70855c217a.jpg', '2015-08-03 14:33:08', '1', '图片管理处上传');
INSERT INTO `tb_pictures` VALUES ('bd0f0dbf926b41c986e14d7e3008e65a', '图片', 'f91e764e253f4de384bec4c7e6342af3.jpg', '20150803/f91e764e253f4de384bec4c7e6342af3.jpg', '2015-08-03 14:31:32', '1', '图片管理处上传');
INSERT INTO `tb_pictures` VALUES ('ccde8af6778f42e7924ede153d9c1465', '图片', '25dba768c6a04904b2cfce26730ee50d.jpg', '20150803/25dba768c6a04904b2cfce26730ee50d.jpg', '2015-08-03 14:31:33', '1', '图片管理处上传');

-- ----------------------------
-- Table structure for weixin_command
-- ----------------------------
DROP TABLE IF EXISTS `weixin_command`;
CREATE TABLE `weixin_command` (
  `COMMAND_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `COMMANDCODE` varchar(255) DEFAULT NULL COMMENT '应用路径',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(1) NOT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`COMMAND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_command
-- ----------------------------
INSERT INTO `weixin_command` VALUES ('2636750f6978451b8330874c9be042c2', '锁定服务器', 'rundll32.exe user32.dll,LockWorkStation', '2015-05-10 21:25:06', '1', '锁定计算机');
INSERT INTO `weixin_command` VALUES ('46217c6d44354010823241ef484f7214', '打开浏览器', 'C:/Program Files/Internet Explorer/iexplore.exe', '2015-05-09 02:43:02', '1', '打开浏览器操作');
INSERT INTO `weixin_command` VALUES ('576adcecce504bf3bb34c6b4da79a177', '关闭浏览器', 'taskkill /f /im iexplore.exe', '2015-05-09 02:36:48', '1', '关闭浏览器操作');
INSERT INTO `weixin_command` VALUES ('854a157c6d99499493f4cc303674c01f', '关闭QQ', 'taskkill /f /im qq.exe', '2015-05-10 21:25:46', '1', '关闭QQ');
INSERT INTO `weixin_command` VALUES ('ab3a8c6310ca4dc8b803ecc547e55ae7', '打开QQ', 'D:/SOFT/QQ/QQ/Bin/qq.exe', '2015-05-10 21:25:25', '1', '打开QQ');

-- ----------------------------
-- Table structure for weixin_imgmsg
-- ----------------------------
DROP TABLE IF EXISTS `weixin_imgmsg`;
CREATE TABLE `weixin_imgmsg` (
  `IMGMSG_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) NOT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `TITLE1` varchar(255) DEFAULT NULL COMMENT '标题1',
  `DESCRIPTION1` varchar(255) DEFAULT NULL COMMENT '描述1',
  `IMGURL1` varchar(255) DEFAULT NULL COMMENT '图片地址1',
  `TOURL1` varchar(255) DEFAULT NULL COMMENT '超链接1',
  `TITLE2` varchar(255) DEFAULT NULL COMMENT '标题2',
  `DESCRIPTION2` varchar(255) DEFAULT NULL COMMENT '描述2',
  `IMGURL2` varchar(255) DEFAULT NULL COMMENT '图片地址2',
  `TOURL2` varchar(255) DEFAULT NULL COMMENT '超链接2',
  `TITLE3` varchar(255) DEFAULT NULL COMMENT '标题3',
  `DESCRIPTION3` varchar(255) DEFAULT NULL COMMENT '描述3',
  `IMGURL3` varchar(255) DEFAULT NULL COMMENT '图片地址3',
  `TOURL3` varchar(255) DEFAULT NULL COMMENT '超链接3',
  `TITLE4` varchar(255) DEFAULT NULL COMMENT '标题4',
  `DESCRIPTION4` varchar(255) DEFAULT NULL COMMENT '描述4',
  `IMGURL4` varchar(255) DEFAULT NULL COMMENT '图片地址4',
  `TOURL4` varchar(255) DEFAULT NULL COMMENT '超链接4',
  `TITLE5` varchar(255) DEFAULT NULL COMMENT '标题5',
  `DESCRIPTION5` varchar(255) DEFAULT NULL COMMENT '描述5',
  `IMGURL5` varchar(255) DEFAULT NULL COMMENT '图片地址5',
  `TOURL5` varchar(255) DEFAULT NULL COMMENT '超链接5',
  `TITLE6` varchar(255) DEFAULT NULL COMMENT '标题6',
  `DESCRIPTION6` varchar(255) DEFAULT NULL COMMENT '描述6',
  `IMGURL6` varchar(255) DEFAULT NULL COMMENT '图片地址6',
  `TOURL6` varchar(255) DEFAULT NULL COMMENT '超链接6',
  `TITLE7` varchar(255) DEFAULT NULL COMMENT '标题7',
  `DESCRIPTION7` varchar(255) DEFAULT NULL COMMENT '描述7',
  `IMGURL7` varchar(255) DEFAULT NULL COMMENT '图片地址7',
  `TOURL7` varchar(255) DEFAULT NULL COMMENT '超链接7',
  `TITLE8` varchar(255) DEFAULT NULL COMMENT '标题8',
  `DESCRIPTION8` varchar(255) DEFAULT NULL COMMENT '描述8',
  `IMGURL8` varchar(255) DEFAULT NULL COMMENT '图片地址8',
  `TOURL8` varchar(255) DEFAULT NULL COMMENT '超链接8',
  PRIMARY KEY (`IMGMSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_imgmsg
-- ----------------------------
INSERT INTO `weixin_imgmsg` VALUES ('380b2cb1f4954315b0e20618f7b5bd8f', '首页', '2015-05-10 20:51:09', '1', '图文回复', '图文回复标题', '图文回复描述', 'http://a.hiphotos.baidu.com/image/h%3D360/sign=c6c7e73ebc389b5027ffe654b535e5f1/a686c9177f3e6709392bb8df3ec79f3df8dc55e3.jpg', 'www.baidu.com', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for weixin_textmsg
-- ----------------------------
DROP TABLE IF EXISTS `weixin_textmsg`;
CREATE TABLE `weixin_textmsg` (
  `TEXTMSG_ID` varchar(100) NOT NULL,
  `KEYWORD` varchar(255) DEFAULT NULL COMMENT '关键词',
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '内容',
  `CREATETIME` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`TEXTMSG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weixin_textmsg
-- ----------------------------
INSERT INTO `weixin_textmsg` VALUES ('303c190498a045bdbba4c940c2f0d9f9', '1ss', '1ssddd', '2015-05-18 20:17:02', '1', '1ssdddsd');
INSERT INTO `weixin_textmsg` VALUES ('63681adbe7144f10b66d6863e07f23c2', '你好', '你也好', '2015-05-09 02:39:23', '1', '文本回复');
INSERT INTO `weixin_textmsg` VALUES ('695cd74779734231928a253107ab0eeb', '吃饭', '吃了噢噢噢噢', '2015-05-10 22:52:27', '1', '文本回复');
INSERT INTO `weixin_textmsg` VALUES ('d4738af7aea74a6ca1a5fb25a98f9acb', '关注', '关注', '2015-05-11 02:12:36', '1', '关注回复');
