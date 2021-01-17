/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/01/2021 09:37:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for choose_seat
-- ----------------------------
DROP TABLE IF EXISTS `choose_seat`;
CREATE TABLE `choose_seat`  (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sid` int(11) NOT NULL COMMENT '位置id',
  `stu_id` int(11) NOT NULL COMMENT '学生id',
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预约日期',
  `hour` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约时长',
  `leave_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '离开次数',
  `leave_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '离开时间',
  `enter_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '进馆时间',
  `pause` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否暂离',
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `choose_seat_ibfk_1`(`sid`) USING BTREE,
  INDEX `choose_seat_ibfk_2`(`stu_id`) USING BTREE,
  CONSTRAINT `choose_seat_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `seat` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `choose_seat_ibfk_2` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of choose_seat
-- ----------------------------
INSERT INTO `choose_seat` VALUES (22, 334, 123456, '2020-11-11 22:41:52', '0', '0', '2020-11-11 22:42:59', '2020-11-11 22:42:34', '0');
INSERT INTO `choose_seat` VALUES (23, 421, 123456, '2020-11-14 16:16:45', '0', '-', '-', '-', '0');
INSERT INTO `choose_seat` VALUES (24, 382, 123456, '2020-11-16 16:19:29', '300', '0', '2020-11-16 21:20:40', '2020-11-16 16:20:08', '0');
INSERT INTO `choose_seat` VALUES (25, 412, 123456, '2020-11-16 16:42:01', '278', '9', '2020-11-16 21:20:40', '2020-11-16 16:42:29', '0');
INSERT INTO `choose_seat` VALUES (26, 320, 123456, '2020-11-16 21:07:08', '0', '-', '-', '-', '0');
INSERT INTO `choose_seat` VALUES (27, 334, 123456, '2020-11-16 21:08:34', '2', '0', '2020-11-16 21:11:20', '2020-11-16 21:08:56', '0');
INSERT INTO `choose_seat` VALUES (28, 363, 123456, '2020-11-16 21:14:26', '0', '-', '-', '-', NULL);
INSERT INTO `choose_seat` VALUES (29, 366, 123456, '2020-11-16 21:18:02', '0', '-', '-', '-', NULL);
INSERT INTO `choose_seat` VALUES (30, 363, 123456, '2020-11-17 16:15:07', '0', '-', '-', '-', '0');
INSERT INTO `choose_seat` VALUES (31, 348, 123456, '2020-11-17 17:00:11', '0', '0', '2020-11-17 17:01:04', '2020-11-17 17:00:36', '0');
INSERT INTO `choose_seat` VALUES (32, 376, 123456, '2020-11-17 17:07:43', '0', '0', '2020-11-17 17:08:38', '2020-11-17 17:08:08', '0');
INSERT INTO `choose_seat` VALUES (33, 405, 123456, '2020-11-18 18:55:06', '0', '-', '-', '-', '0');
INSERT INTO `choose_seat` VALUES (34, 334, 123456, '2020-11-18 18:55:34', '1', '2', '2020-11-18 18:57:05', '2020-11-18 18:55:49', '0');
INSERT INTO `choose_seat` VALUES (35, 382, 123456, '2020-11-18 21:38:45', '1', '0', '2020-11-18 21:40:38', '2020-11-18 21:39:06', '0');
INSERT INTO `choose_seat` VALUES (36, 362, 123456, '2020-11-18 21:43:26', '11', '20', '2020-11-18 21:55:43', '2020-11-18 21:43:46', '0');
INSERT INTO `choose_seat` VALUES (37, 364, 123456, '2020-11-18 21:56:33', '20', '6', '2020-11-18 22:17:25', '2020-11-18 21:56:51', '1');
INSERT INTO `choose_seat` VALUES (38, 382, 123456, '2020-11-18 22:17:38', '3', '1', '2020-11-18 22:21:55', '2020-11-18 22:18:43', '0');

-- ----------------------------
-- Table structure for face
-- ----------------------------
DROP TABLE IF EXISTS `face`;
CREATE TABLE `face`  (
  `stu_id` int(255) NOT NULL,
  `face_id` blob NULL,
  PRIMARY KEY (`stu_id`) USING BTREE,
  CONSTRAINT `face_ibfk_1` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of face
-- ----------------------------
INSERT INTO `face` VALUES (123456, 0x0080FA440000A041DA257B3C702111BCC8296EBD574F22BCBBFF1F3E7C0401BEB48450BD035AF0BC92AD0C3C701A873D51FE1E3EB277183EFABDBBBD839EB13DBD66473DA9BB90BC6ACA103D1FDB8A3DDC914ABD500B8ABC119C6ABD59D0D5BDF92CB93BADE3A8BABB7285BA406CD23C57305C3DEC6452BDF56040BDDFC852BDD7494BBD52A5333C5CA5243DC00E7FBD78C1CDBC74F292BDA9FACB3C9271E4BD96FB20BDD83E363D877501BD506A553D9B17A9BBF2ABE1BB03F1193C73F4013D55A7453CF320463DA40B6D3CF7703F3D1849143ECFF2123E68443CBD451F66BD89E3253D8B15A2BC2981923D93173CBDE4A0B03BF01487BDE667B93CA8A0C13D904F33BD2946E3BCC24D03BDDD07C13D77D776BDA24C973D3D1F003DB52BF1BD37B87FBD89172B3C13A1AABD1253C43A9E3585BD39BDD3BDF4AA3BBD0DA1F63D859A29BDC2F8E0BCF211D5BCEED2B53DDD3DBCBDC963B2BD39CDCD3D50F7653D95E6C43C1CB1233C445874BDDF2C07BD4B89633DD452D5BB863155BD3CFAB03D77D790BD855C27BBC8F29ABC8971CEBB69267B3D72DD09BC2AC1C2BCABD1CEBDBAC4753D9345D53B575D2ABCF11EA63DC2232D3E352A8B3DD940E23C5350D9BBDC4E75BC74AE063D0776D73C42865A3D2861AC3C85000C3D64B4F83CEB45073D187A7CBD2744B33DC97F1ABEBD1F06BEBE656B3D3A79693DC6564EBD9D1FEBBDC66BBBBCBD03613CE8B27F3DBE49663D3904CE3CDE6A26BD1730913DBAB2FE3D43D7023E0DBCF7BBF016383D29E6283DE99D0ABD01AF1B3D0121BBBCB12FA0BDE462F43BC65DD6BBC7DEB6BD51F18CBD02B90E3D454A3F3D38C030BD7A37B43D221AF93C0599003E81921C3D092F843D6ABBE0BC0B6BF23BE31C11BD3FF3ACBA453F8EBC5F93C03C3815C1BDB798643D756C51BDA638A9BDEDEF9F3B15764C3D5896393DA47731BD242283BC8C8A083D1C198BBDC0C6313ED8343B3D960BD63CEF19CE3CCDEC9F3D825C0E3D582EDD3DB3815DBC2310A9BD7E4910BD24C6793DF80C973D8C379BBDD29AE93CC95CD53D731B20BC139E353D827393BD64A3A4BC32DC6CBC4DBA923D7AE506BDFEA60EBD75B0FBBDE6D32DBEEBE6A93DF7E1273DCB31BC3D3E0C03BD1F6A8D3C9A2ED4BD07D0CBBD44A3D0BB0D0E39BC793A9C3DD6C296BC73AB5D3D6D4B91BCBCC050BD4390E7BC8D52E13CE9384F3D4E83593CC1F72EBDC992773D325315BE3654943C0E50C93B489632BD97A3E63C17A5193E1104A63CC2ACF43CCCC98ABDFD18D6B955AE84BC1574A1BC7E3A233DD8EF77BD9250D9BDF75776BD5E5544BDFA93D13DA1DF9B3CD2E45EBDC59223BDEBCC1B3D9517233D26517D3D0F23B63C47893E3D6F288A3CBD62483C6D51533D25A7E83C9A5AB4B9A8E46E3D7FB6353DC4276DBCE36A3FBD205612BDC30C963D05CBE33DA48C5DBD48DDF2BD);
INSERT INTO `face` VALUES (123457, 0x0080FA440000A041B7C8FCBC9DBAF6BD19462FBDF58DB33CFA37903DBB72A93C1D4790BD6B6A39BD929FC43DCA74FEBCD8A19C3D4910973D91D8A4BD3EC31A3DC0A030BE5246AC3C0A0C1D3D8F6FC6BD001859BC4FC88E3D5F9BAFBD6DB40CBE41D64D3DC5561FBDCD7D98BDB2D645BC8780493C8E1C0FBDC74EE03D712C8BBD5D3C0DBD5A3F653DB252BCBB0680543DDE53B4BD9E5120BB0BED93BC4F716F3DF1B6B8BDC7A9C3BCBB4B053D7833753CEB24863C07DEA63DAE644FBCBAD0723D97B9033A83A0E13D7F46483B6B059E3CFC24863DDDFE183DEAB5CF3B36B8053B4AE579BD01BFB43CD611E1BD26EBF03D7E47743DCA1FCC3D1D8DAA3CE0C2A23D603F0D3E39E344BC52D7733C59DBD7BC454ABDBC091D4DBD6B4EC8BCF36D2E3D8ACE553DB7DA93BD07F6BDBD7A7DD1BDAFB4823D504A623D0234D2BCFD55FE3A364CDD3DEACC52BDFD691B3DE9EBAE3D38780FBC668FB83BE2B357BD98C7E8BD98E8173C00BF9EBBB5977EBBC964F03DD64F2FBDDF62E83DD83E383DFE459CBD1BA4423D113D13BD82F97DBC711829BCFDDB8D3D5981613DEBA987BDCD592BBD9188EABCE7DF6C3D261EA8BD8D31183D9950FEBCB096403DEEEA06BD037F8B3DD3494DBB2817363DCDA9B7BD79C0AABD6FC0F1BCB380C0BD2185023E199D84BD3962053E30FE033E268FDCBD0D9AAFBCE2C74A3D5FF9F93D76D8903D41BA86BDDF75383B1DED11BD2870293C4D10EDBD46C01F3BCEA605BD4E17D73CDACEEC3DE6FEB63D5A5581BDE577EAB8A5A11FBC3355EEBC534003BC2A2A9FBD1B3935BD5DA120BDD89C18BE3015493C4705073D3653D4BDBE41813DEDD99CBD60EB2ABD1B89813CF0F5E8BD86739D3D22A78BBCC61A2ABCE3873BBD21F7443D5754E3B9E91E1EBCC398BE3DB838DABCFFCDB6BDEFAA63BD60D14BBC40A52DBDE1BA763D0A992E3D0AD6953D6F3893BC4BB8A1BD3D73603D7929EB3C561502BDD60CD5BDE38D70BD9EC94BBA5121BE3DE291F33C3E05903CAA1D763D699ADABD93604DBD1781063A8347A0BD7D5B0DBB0204D33C032B8DBC0F429FBC0EB8353D22BDC9BB788A68BDFF85123E99DDB5BDFA89A4BDE5E261BBD7D3DB3C99ED083DF0E5AFBD035576BDAE76AF3CA19A0DBD17AA573D4A7928BD4851BB3D1B69CC3B686B113CD7A6E1BD307F5B3923C8FD3DCE97FBBCC38F163D63E1673CE0F1743D935F6C3CF89FB73C4797FFBCA81004BE917A023E38DB2ABD9B09EFBBE1388CBC6801D43CB02D81BDB571E5BCEA986A3DB5FD1FBCB9AE893DD9B7123D75495DBD4D6641BD7B3BA03CD5BD883DF51DA53D9F81D73CA235EDBC874821BE207A0DBD36BB4EBC58B23BBC1D8685BD0185853D90E30CBD0BB940BDA0877E3DA769773D16D8093DCB1A41BD1B5F7D3CFAAA293C1701DABCE119BBBD60246EBD623C933DABDA10BCE6E5553D9771753B);

-- ----------------------------
-- Table structure for library
-- ----------------------------
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library`  (
  `lid` int(11) NOT NULL AUTO_INCREMENT COMMENT '书库id',
  `library_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书库名称',
  `seats_num` int(11) NULL DEFAULT NULL COMMENT '位置数量',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否开放',
  PRIMARY KEY (`lid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of library
-- ----------------------------
INSERT INTO `library` VALUES (2, '一号书库', 134, 'opening');
INSERT INTO `library` VALUES (4, '二号书库', 150, 'opening');

-- ----------------------------
-- Table structure for seat
-- ----------------------------
DROP TABLE IF EXISTS `seat`;
CREATE TABLE `seat`  (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '位置id',
  `lid` int(11) NOT NULL COMMENT '所属书库',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '位置坐标',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置状态（是否可使用）',
  `available` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否可预约',
  PRIMARY KEY (`sid`) USING BTREE,
  INDEX `lid`(`lid`) USING BTREE,
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`lid`) REFERENCES `library` (`lid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 439 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of seat
-- ----------------------------
INSERT INTO `seat` VALUES (156, 4, '1,1', 'opening', '1');
INSERT INTO `seat` VALUES (157, 4, '2,1', 'opening', '1');
INSERT INTO `seat` VALUES (158, 4, '4,1', 'opening', '1');
INSERT INTO `seat` VALUES (159, 4, '5,1', 'opening', '1');
INSERT INTO `seat` VALUES (160, 4, '7,1', 'opening', '1');
INSERT INTO `seat` VALUES (161, 4, '8,1', 'opening', '1');
INSERT INTO `seat` VALUES (162, 4, '10,1', 'opening', '1');
INSERT INTO `seat` VALUES (163, 4, '11,1', 'opening', '1');
INSERT INTO `seat` VALUES (164, 4, '13,1', 'opening', '1');
INSERT INTO `seat` VALUES (165, 4, '14,1', 'opening', '1');
INSERT INTO `seat` VALUES (166, 4, '16,1', 'opening', '1');
INSERT INTO `seat` VALUES (167, 4, '17,1', 'opening', '1');
INSERT INTO `seat` VALUES (168, 4, '19,1', 'opening', '1');
INSERT INTO `seat` VALUES (169, 4, '20,1', 'opening', '1');
INSERT INTO `seat` VALUES (170, 4, '1,2', 'opening', '1');
INSERT INTO `seat` VALUES (171, 4, '2,2', 'opening', '1');
INSERT INTO `seat` VALUES (172, 4, '4,2', 'opening', '1');
INSERT INTO `seat` VALUES (173, 4, '5,2', 'opening', '1');
INSERT INTO `seat` VALUES (174, 4, '7,2', 'opening', '1');
INSERT INTO `seat` VALUES (175, 4, '8,2', 'opening', '1');
INSERT INTO `seat` VALUES (176, 4, '10,2', 'opening', '1');
INSERT INTO `seat` VALUES (177, 4, '11,2', 'opening', '1');
INSERT INTO `seat` VALUES (178, 4, '13,2', 'opening', '1');
INSERT INTO `seat` VALUES (179, 4, '14,2', 'opening', '1');
INSERT INTO `seat` VALUES (180, 4, '16,2', 'opening', '1');
INSERT INTO `seat` VALUES (181, 4, '17,2', 'opening', '1');
INSERT INTO `seat` VALUES (182, 4, '19,2', 'opening', '1');
INSERT INTO `seat` VALUES (183, 4, '20,2', 'opening', '1');
INSERT INTO `seat` VALUES (184, 4, '1,3', 'opening', '1');
INSERT INTO `seat` VALUES (185, 4, '2,3', 'opening', '1');
INSERT INTO `seat` VALUES (186, 4, '4,3', 'opening', '1');
INSERT INTO `seat` VALUES (187, 4, '5,3', 'opening', '1');
INSERT INTO `seat` VALUES (188, 4, '7,3', 'opening', '1');
INSERT INTO `seat` VALUES (189, 4, '8,3', 'opening', '1');
INSERT INTO `seat` VALUES (190, 4, '10,3', 'opening', '1');
INSERT INTO `seat` VALUES (191, 4, '11,3', 'opening', '1');
INSERT INTO `seat` VALUES (192, 4, '13,3', 'opening', '1');
INSERT INTO `seat` VALUES (193, 4, '14,3', 'opening', '1');
INSERT INTO `seat` VALUES (194, 4, '16,3', 'opening', '1');
INSERT INTO `seat` VALUES (195, 4, '17,3', 'opening', '1');
INSERT INTO `seat` VALUES (196, 4, '19,3', 'opening', '1');
INSERT INTO `seat` VALUES (197, 4, '20,3', 'opening', '1');
INSERT INTO `seat` VALUES (198, 4, '1,5', 'opening', '1');
INSERT INTO `seat` VALUES (199, 4, '2,5', 'opening', '1');
INSERT INTO `seat` VALUES (200, 4, '4,5', 'opening', '1');
INSERT INTO `seat` VALUES (201, 4, '5,5', 'opening', '1');
INSERT INTO `seat` VALUES (202, 4, '7,5', 'opening', '1');
INSERT INTO `seat` VALUES (203, 4, '8,5', 'opening', '1');
INSERT INTO `seat` VALUES (204, 4, '10,5', 'opening', '1');
INSERT INTO `seat` VALUES (205, 4, '11,5', 'opening', '1');
INSERT INTO `seat` VALUES (206, 4, '13,5', 'opening', '1');
INSERT INTO `seat` VALUES (207, 4, '14,5', 'opening', '1');
INSERT INTO `seat` VALUES (208, 4, '16,5', 'opening', '1');
INSERT INTO `seat` VALUES (209, 4, '17,5', 'opening', '1');
INSERT INTO `seat` VALUES (210, 4, '19,5', 'opening', '1');
INSERT INTO `seat` VALUES (211, 4, '20,5', 'opening', '1');
INSERT INTO `seat` VALUES (212, 4, '1,6', 'opening', '1');
INSERT INTO `seat` VALUES (213, 4, '2,6', 'opening', '1');
INSERT INTO `seat` VALUES (214, 4, '4,6', 'opening', '1');
INSERT INTO `seat` VALUES (215, 4, '5,6', 'opening', '1');
INSERT INTO `seat` VALUES (216, 4, '7,6', 'opening', '1');
INSERT INTO `seat` VALUES (217, 4, '8,6', 'opening', '1');
INSERT INTO `seat` VALUES (218, 4, '10,6', 'opening', '1');
INSERT INTO `seat` VALUES (219, 4, '11,6', 'opening', '1');
INSERT INTO `seat` VALUES (220, 4, '13,6', 'opening', '1');
INSERT INTO `seat` VALUES (221, 4, '14,6', 'opening', '1');
INSERT INTO `seat` VALUES (222, 4, '16,6', 'opening', '1');
INSERT INTO `seat` VALUES (223, 4, '17,6', 'opening', '1');
INSERT INTO `seat` VALUES (224, 4, '19,6', 'opening', '1');
INSERT INTO `seat` VALUES (225, 4, '20,6', 'opening', '1');
INSERT INTO `seat` VALUES (226, 4, '1,7', 'opening', '1');
INSERT INTO `seat` VALUES (227, 4, '2,7', 'opening', '1');
INSERT INTO `seat` VALUES (228, 4, '4,7', 'opening', '1');
INSERT INTO `seat` VALUES (229, 4, '5,7', 'opening', '1');
INSERT INTO `seat` VALUES (230, 4, '7,7', 'opening', '1');
INSERT INTO `seat` VALUES (231, 4, '8,7', 'opening', '1');
INSERT INTO `seat` VALUES (232, 4, '10,7', 'opening', '1');
INSERT INTO `seat` VALUES (233, 4, '11,7', 'opening', '1');
INSERT INTO `seat` VALUES (234, 4, '13,7', 'opening', '1');
INSERT INTO `seat` VALUES (235, 4, '14,7', 'opening', '1');
INSERT INTO `seat` VALUES (236, 4, '16,7', 'opening', '1');
INSERT INTO `seat` VALUES (237, 4, '17,7', 'opening', '1');
INSERT INTO `seat` VALUES (238, 4, '19,7', 'opening', '1');
INSERT INTO `seat` VALUES (239, 4, '20,7', 'opening', '1');
INSERT INTO `seat` VALUES (240, 4, '1,15', 'opening', '1');
INSERT INTO `seat` VALUES (241, 4, '2,15', 'opening', '1');
INSERT INTO `seat` VALUES (242, 4, '4,15', 'opening', '1');
INSERT INTO `seat` VALUES (243, 4, '5,15', 'opening', '1');
INSERT INTO `seat` VALUES (244, 4, '7,15', 'opening', '1');
INSERT INTO `seat` VALUES (245, 4, '8,15', 'opening', '1');
INSERT INTO `seat` VALUES (246, 4, '10,15', 'opening', '1');
INSERT INTO `seat` VALUES (247, 4, '11,15', 'opening', '1');
INSERT INTO `seat` VALUES (248, 4, '13,15', 'opening', '1');
INSERT INTO `seat` VALUES (249, 4, '14,15', 'opening', '1');
INSERT INTO `seat` VALUES (250, 4, '16,15', 'opening', '1');
INSERT INTO `seat` VALUES (251, 4, '17,15', 'opening', '1');
INSERT INTO `seat` VALUES (252, 4, '19,15', 'opening', '1');
INSERT INTO `seat` VALUES (253, 4, '20,15', 'opening', '1');
INSERT INTO `seat` VALUES (254, 4, '1,16', 'opening', '1');
INSERT INTO `seat` VALUES (255, 4, '2,16', 'opening', '1');
INSERT INTO `seat` VALUES (256, 4, '4,16', 'opening', '1');
INSERT INTO `seat` VALUES (257, 4, '5,16', 'opening', '1');
INSERT INTO `seat` VALUES (258, 4, '7,16', 'opening', '1');
INSERT INTO `seat` VALUES (259, 4, '8,16', 'opening', '1');
INSERT INTO `seat` VALUES (260, 4, '10,16', 'opening', '1');
INSERT INTO `seat` VALUES (261, 4, '11,16', 'opening', '1');
INSERT INTO `seat` VALUES (262, 4, '13,16', 'opening', '1');
INSERT INTO `seat` VALUES (263, 4, '14,16', 'opening', '1');
INSERT INTO `seat` VALUES (264, 4, '16,16', 'opening', '1');
INSERT INTO `seat` VALUES (265, 4, '17,16', 'opening', '1');
INSERT INTO `seat` VALUES (266, 4, '19,16', 'opening', '1');
INSERT INTO `seat` VALUES (267, 4, '20,16', 'opening', '1');
INSERT INTO `seat` VALUES (268, 4, '1,17', 'opening', '1');
INSERT INTO `seat` VALUES (269, 4, '2,17', 'opening', '1');
INSERT INTO `seat` VALUES (270, 4, '4,17', 'opening', '1');
INSERT INTO `seat` VALUES (271, 4, '5,17', 'opening', '1');
INSERT INTO `seat` VALUES (272, 4, '7,17', 'opening', '1');
INSERT INTO `seat` VALUES (273, 4, '8,17', 'opening', '1');
INSERT INTO `seat` VALUES (274, 4, '10,17', 'opening', '1');
INSERT INTO `seat` VALUES (275, 4, '11,17', 'opening', '1');
INSERT INTO `seat` VALUES (276, 4, '13,17', 'opening', '1');
INSERT INTO `seat` VALUES (277, 4, '14,17', 'opening', '1');
INSERT INTO `seat` VALUES (278, 4, '16,17', 'opening', '1');
INSERT INTO `seat` VALUES (279, 4, '17,17', 'opening', '1');
INSERT INTO `seat` VALUES (280, 4, '19,17', 'opening', '1');
INSERT INTO `seat` VALUES (281, 4, '20,17', 'opening', '1');
INSERT INTO `seat` VALUES (282, 4, '4,16', 'opening', '1');
INSERT INTO `seat` VALUES (283, 4, '5,16', 'opening', '1');
INSERT INTO `seat` VALUES (284, 4, '7,19', 'opening', '1');
INSERT INTO `seat` VALUES (285, 4, '8,19', 'opening', '1');
INSERT INTO `seat` VALUES (286, 4, '10,19', 'opening', '1');
INSERT INTO `seat` VALUES (287, 4, '11,19', 'opening', '1');
INSERT INTO `seat` VALUES (288, 4, '13,19', 'opening', '1');
INSERT INTO `seat` VALUES (289, 4, '14,19', 'opening', '1');
INSERT INTO `seat` VALUES (290, 4, '4,20', 'opening', '1');
INSERT INTO `seat` VALUES (291, 4, '5,20', 'opening', '1');
INSERT INTO `seat` VALUES (292, 4, '7,20', 'opening', '1');
INSERT INTO `seat` VALUES (293, 4, '8,20', 'opening', '1');
INSERT INTO `seat` VALUES (294, 4, '10,20', 'opening', '1');
INSERT INTO `seat` VALUES (295, 4, '11,20', 'opening', '1');
INSERT INTO `seat` VALUES (296, 4, '13,20', 'opening', '1');
INSERT INTO `seat` VALUES (297, 4, '14,20', 'opening', '1');
INSERT INTO `seat` VALUES (298, 4, '4,21', 'opening', '1');
INSERT INTO `seat` VALUES (299, 4, '5,21', 'opening', '1');
INSERT INTO `seat` VALUES (300, 4, '7,21', 'opening', '1');
INSERT INTO `seat` VALUES (301, 4, '8,21', 'opening', '1');
INSERT INTO `seat` VALUES (302, 4, '10,21', 'opening', '1');
INSERT INTO `seat` VALUES (303, 4, '11,21', 'opening', '1');
INSERT INTO `seat` VALUES (304, 4, '13,21', 'opening', '1');
INSERT INTO `seat` VALUES (305, 4, '14,21', 'opening', '1');
INSERT INTO `seat` VALUES (306, 2, '1,1', 'opening', '1');
INSERT INTO `seat` VALUES (307, 2, '2,1', 'opening', '1');
INSERT INTO `seat` VALUES (308, 2, '4,1', 'opening', '1');
INSERT INTO `seat` VALUES (309, 2, '5,1', 'opening', '1');
INSERT INTO `seat` VALUES (310, 2, '7,1', 'opening', '1');
INSERT INTO `seat` VALUES (311, 2, '8,1', 'opening', '1');
INSERT INTO `seat` VALUES (312, 2, '10,1', 'opening', '1');
INSERT INTO `seat` VALUES (313, 2, '11,1', 'opening', '1');
INSERT INTO `seat` VALUES (314, 2, '13,1', 'opening', '1');
INSERT INTO `seat` VALUES (315, 2, '14,1', 'opening', '1');
INSERT INTO `seat` VALUES (316, 2, '16,1', 'opening', '1');
INSERT INTO `seat` VALUES (317, 2, '17,1', 'opening', '1');
INSERT INTO `seat` VALUES (318, 2, '19,1', 'opening', '1');
INSERT INTO `seat` VALUES (319, 2, '20,1', 'opening', '1');
INSERT INTO `seat` VALUES (320, 2, '1,2', 'opening', '1');
INSERT INTO `seat` VALUES (321, 2, '2,2', 'opening', '1');
INSERT INTO `seat` VALUES (322, 2, '4,2', 'opening', '1');
INSERT INTO `seat` VALUES (323, 2, '5,2', 'opening', '1');
INSERT INTO `seat` VALUES (324, 2, '7,2', 'opening', '1');
INSERT INTO `seat` VALUES (325, 2, '8,2', 'opening', '1');
INSERT INTO `seat` VALUES (326, 2, '10,2', 'opening', '1');
INSERT INTO `seat` VALUES (327, 2, '11,2', 'opening', '1');
INSERT INTO `seat` VALUES (328, 2, '13,2', 'opening', '1');
INSERT INTO `seat` VALUES (329, 2, '14,2', 'opening', '1');
INSERT INTO `seat` VALUES (330, 2, '16,2', 'opening', '1');
INSERT INTO `seat` VALUES (331, 2, '17,2', 'opening', '1');
INSERT INTO `seat` VALUES (332, 2, '19,2', 'opening', '1');
INSERT INTO `seat` VALUES (333, 2, '20,2', 'opening', '1');
INSERT INTO `seat` VALUES (334, 2, '1,3', 'opening', '1');
INSERT INTO `seat` VALUES (335, 2, '2,3', 'opening', '1');
INSERT INTO `seat` VALUES (336, 2, '4,3', 'opening', '1');
INSERT INTO `seat` VALUES (337, 2, '5,3', 'opening', '1');
INSERT INTO `seat` VALUES (338, 2, '7,3', 'opening', '1');
INSERT INTO `seat` VALUES (339, 2, '8,3', 'opening', '1');
INSERT INTO `seat` VALUES (340, 2, '10,3', 'opening', '1');
INSERT INTO `seat` VALUES (341, 2, '11,3', 'opening', '1');
INSERT INTO `seat` VALUES (342, 2, '13,3', 'opening', '1');
INSERT INTO `seat` VALUES (343, 2, '14,3', 'opening', '1');
INSERT INTO `seat` VALUES (344, 2, '16,3', 'opening', '1');
INSERT INTO `seat` VALUES (345, 2, '17,3', 'opening', '1');
INSERT INTO `seat` VALUES (346, 2, '19,3', 'opening', '1');
INSERT INTO `seat` VALUES (347, 2, '20,3', 'opening', '1');
INSERT INTO `seat` VALUES (348, 2, '1,5', 'opening', '1');
INSERT INTO `seat` VALUES (349, 2, '2,5', 'opening', '1');
INSERT INTO `seat` VALUES (350, 2, '4,5', 'opening', '1');
INSERT INTO `seat` VALUES (351, 2, '5,5', 'opening', '1');
INSERT INTO `seat` VALUES (352, 2, '7,5', 'opening', '1');
INSERT INTO `seat` VALUES (353, 2, '8,5', 'opening', '1');
INSERT INTO `seat` VALUES (354, 2, '10,5', 'opening', '1');
INSERT INTO `seat` VALUES (355, 2, '11,5', 'opening', '1');
INSERT INTO `seat` VALUES (356, 2, '13,5', 'opening', '1');
INSERT INTO `seat` VALUES (357, 2, '14,5', 'opening', '1');
INSERT INTO `seat` VALUES (358, 2, '16,5', 'opening', '1');
INSERT INTO `seat` VALUES (359, 2, '17,5', 'opening', '1');
INSERT INTO `seat` VALUES (360, 2, '19,5', 'opening', '1');
INSERT INTO `seat` VALUES (361, 2, '20,5', 'opening', '1');
INSERT INTO `seat` VALUES (362, 2, '1,6', 'opening', '1');
INSERT INTO `seat` VALUES (363, 2, '2,6', 'opening', '1');
INSERT INTO `seat` VALUES (364, 2, '4,6', 'opening', '1');
INSERT INTO `seat` VALUES (365, 2, '5,6', 'opening', '1');
INSERT INTO `seat` VALUES (366, 2, '7,6', 'opening', '1');
INSERT INTO `seat` VALUES (367, 2, '8,6', 'opening', '1');
INSERT INTO `seat` VALUES (368, 2, '10,6', 'opening', '1');
INSERT INTO `seat` VALUES (369, 2, '11,6', 'opening', '1');
INSERT INTO `seat` VALUES (370, 2, '13,6', 'opening', '1');
INSERT INTO `seat` VALUES (371, 2, '14,6', 'opening', '1');
INSERT INTO `seat` VALUES (372, 2, '16,6', 'opening', '1');
INSERT INTO `seat` VALUES (373, 2, '17,6', 'opening', '1');
INSERT INTO `seat` VALUES (374, 2, '19,6', 'opening', '1');
INSERT INTO `seat` VALUES (375, 2, '20,6', 'opening', '1');
INSERT INTO `seat` VALUES (376, 2, '1,7', 'opening', '1');
INSERT INTO `seat` VALUES (377, 2, '2,7', 'opening', '1');
INSERT INTO `seat` VALUES (378, 2, '16,7', 'opening', '1');
INSERT INTO `seat` VALUES (379, 2, '17,7', 'opening', '1');
INSERT INTO `seat` VALUES (380, 2, '19,7', 'opening', '1');
INSERT INTO `seat` VALUES (381, 2, '20,7', 'opening', '1');
INSERT INTO `seat` VALUES (382, 2, '1,15', 'opening', '1');
INSERT INTO `seat` VALUES (383, 2, '2,15', 'opening', '1');
INSERT INTO `seat` VALUES (384, 2, '16,15', 'opening', '1');
INSERT INTO `seat` VALUES (385, 2, '17,15', 'opening', '1');
INSERT INTO `seat` VALUES (386, 2, '19,15', 'opening', '1');
INSERT INTO `seat` VALUES (387, 2, '20,15', 'opening', '1');
INSERT INTO `seat` VALUES (388, 2, '1,16', 'opening', '1');
INSERT INTO `seat` VALUES (389, 2, '2,16', 'opening', '1');
INSERT INTO `seat` VALUES (390, 2, '4,16', 'opening', '1');
INSERT INTO `seat` VALUES (391, 2, '5,16', 'opening', '1');
INSERT INTO `seat` VALUES (392, 2, '7,16', 'opening', '1');
INSERT INTO `seat` VALUES (393, 2, '8,16', 'opening', '1');
INSERT INTO `seat` VALUES (394, 2, '10,16', 'opening', '1');
INSERT INTO `seat` VALUES (395, 2, '11,16', 'opening', '1');
INSERT INTO `seat` VALUES (396, 2, '13,16', 'opening', '1');
INSERT INTO `seat` VALUES (397, 2, '14,16', 'opening', '1');
INSERT INTO `seat` VALUES (398, 2, '16,16', 'opening', '1');
INSERT INTO `seat` VALUES (399, 2, '17,16', 'opening', '1');
INSERT INTO `seat` VALUES (400, 2, '19,16', 'opening', '1');
INSERT INTO `seat` VALUES (401, 2, '20,16', 'opening', '1');
INSERT INTO `seat` VALUES (402, 2, '1,17', 'opening', '1');
INSERT INTO `seat` VALUES (403, 2, '2,17', 'opening', '1');
INSERT INTO `seat` VALUES (404, 2, '4,17', 'opening', '1');
INSERT INTO `seat` VALUES (405, 2, '5,17', 'opening', '1');
INSERT INTO `seat` VALUES (406, 2, '7,17', 'opening', '1');
INSERT INTO `seat` VALUES (407, 2, '8,17', 'opening', '1');
INSERT INTO `seat` VALUES (408, 2, '10,17', 'opening', '1');
INSERT INTO `seat` VALUES (409, 2, '11,17', 'opening', '1');
INSERT INTO `seat` VALUES (410, 2, '13,17', 'opening', '1');
INSERT INTO `seat` VALUES (411, 2, '14,17', 'opening', '1');
INSERT INTO `seat` VALUES (412, 2, '16,17', 'opening', '1');
INSERT INTO `seat` VALUES (413, 2, '17,17', 'opening', '1');
INSERT INTO `seat` VALUES (414, 2, '19,17', 'opening', '1');
INSERT INTO `seat` VALUES (415, 2, '20,17', 'opening', '1');
INSERT INTO `seat` VALUES (416, 2, '4,16', 'opening', '1');
INSERT INTO `seat` VALUES (417, 2, '5,16', 'opening', '1');
INSERT INTO `seat` VALUES (418, 2, '7,19', 'opening', '1');
INSERT INTO `seat` VALUES (419, 2, '8,19', 'opening', '1');
INSERT INTO `seat` VALUES (420, 2, '10,19', 'opening', '1');
INSERT INTO `seat` VALUES (421, 2, '11,19', 'opening', '1');
INSERT INTO `seat` VALUES (422, 2, '13,19', 'opening', '1');
INSERT INTO `seat` VALUES (423, 2, '14,19', 'opening', '1');
INSERT INTO `seat` VALUES (424, 2, '4,20', 'opening', '1');
INSERT INTO `seat` VALUES (425, 2, '5,20', 'opening', '1');
INSERT INTO `seat` VALUES (426, 2, '7,20', 'opening', '1');
INSERT INTO `seat` VALUES (427, 2, '8,20', 'opening', '1');
INSERT INTO `seat` VALUES (428, 2, '10,20', 'opening', '1');
INSERT INTO `seat` VALUES (429, 2, '11,20', 'opening', '1');
INSERT INTO `seat` VALUES (430, 2, '13,20', 'opening', '1');
INSERT INTO `seat` VALUES (431, 2, '14,20', 'opening', '1');
INSERT INTO `seat` VALUES (432, 2, '4,21', 'opening', '1');
INSERT INTO `seat` VALUES (433, 2, '5,21', 'opening', '1');
INSERT INTO `seat` VALUES (434, 2, '7,21', 'opening', '1');
INSERT INTO `seat` VALUES (435, 2, '8,21', 'opening', '1');
INSERT INTO `seat` VALUES (436, 2, '10,21', 'opening', '1');
INSERT INTO `seat` VALUES (437, 2, '11,21', 'opening', '1');
INSERT INTO `seat` VALUES (438, 2, '13,21', 'opening', '1');
INSERT INTO `seat` VALUES (439, 2, '14,21', 'opening', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` int(255) NOT NULL COMMENT '学生id',
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小程序openid',
  `reputation` int(255) NOT NULL COMMENT '信誉值',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态（预留）',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (123456, '张三', 'oPkgs5N27nJEGDv7tniMP4Xz7syI', 100, 'normal');
INSERT INTO `student` VALUES (123457, '李四', NULL, 100, 'normal');
INSERT INTO `student` VALUES (123458, '王五', NULL, 100, 'normal');
INSERT INTO `student` VALUES (123459, '小红', NULL, 100, 'normal');
INSERT INTO `student` VALUES (234560, '钢铁侠', NULL, 100, 'normal');
INSERT INTO `student` VALUES (234567, '小绿', NULL, 100, 'normal');
INSERT INTO `student` VALUES (234568, '小蓝', NULL, 100, 'normal');
INSERT INTO `student` VALUES (234569, '灭霸', NULL, 100, 'normal');
INSERT INTO `student` VALUES (345670, '派大星', NULL, 100, 'normal');
INSERT INTO `student` VALUES (345678, '雷神', NULL, 100, 'normal');
INSERT INTO `student` VALUES (345679, '海绵宝宝', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456120, '小明', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456123, '美国队长', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456124, '张飞', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456127, '李逵', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456128, '张伟', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456129, '小黑', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456780, '蟹老板', NULL, 100, 'normal');
INSERT INTO `student` VALUES (456789, '章鱼哥', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789120, '哥斯拉', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789123, '蜘蛛侠', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789124, '金刚狼', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789125, '绿巨人', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789126, '万磁王', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789127, '暴风女', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789128, '奥特曼', NULL, 100, 'normal');
INSERT INTO `student` VALUES (789129, '小怪兽', NULL, 100, 'normal');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$UoYV236vpfcHqVBn0p1VxeXlRZlasvyj9NUcHRHfY0FOQud/LL9n.');

SET FOREIGN_KEY_CHECKS = 1;
