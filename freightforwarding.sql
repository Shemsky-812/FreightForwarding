/*
 Navicat Premium Data Transfer

 Source Server         : localhost-root
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : freightforwarding

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 10/05/2021 11:29:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for capital
-- ----------------------------
DROP TABLE IF EXISTS `capital`;
CREATE TABLE `capital`  (
  `capitalId` int(11) NOT NULL AUTO_INCREMENT,
  `capitalCode` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradId` int(11) NOT NULL,
  `tradType` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradFrom` int(11) NULL DEFAULT NULL,
  `tradFromName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradFromBank` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradFromAccount` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradTo` int(11) NULL DEFAULT NULL,
  `tradToName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradToBank` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradToAccount` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `capitalAmt` decimal(18, 2) NULL DEFAULT NULL,
  `picPath` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`capitalId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '现金信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of capital
-- ----------------------------
INSERT INTO `capital` VALUES (1, '', 1, '贷款', 'LOAN0001', 2, 'XXXX保理有限公司', '招商银行股份有限公司', '75592925361XXX1', 0, 'XXXX银行', '', '', 1050000.00, '', 0, 1, 4, '2017-06-26 09:53:56', NULL, NULL);
INSERT INTO `capital` VALUES (2, '', 1, '保理', 'BLHT0001', 3, 'XXXX核心企业', '招商银行股份有限公司', '7xxxxxxxxxxxx1', 2, 'XXXX保理有限公司', 'XXXX保理有限公司', 'XXXX保理有限公司', 1060000.00, '', 0, 1, 4, '2017-06-26 09:56:48', NULL, NULL);
INSERT INTO `capital` VALUES (3, '', 8, '提现', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 2, 'XXXX保理有限公司', '招商银行股份有限公司', '75592925361XXX1', 4, 'XXXX供应商', 'XXXX供应商', 'XXXX供应商', 87300.00, '', 3, 2, 8, '2017-06-26 10:19:33', 4, '2017-06-26 11:12:17');

-- ----------------------------
-- Table structure for charge_rate
-- ----------------------------
DROP TABLE IF EXISTS `charge_rate`;
CREATE TABLE `charge_rate`  (
  `rateId` int(11) NOT NULL AUTO_INCREMENT,
  `rateType` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rateName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rate` decimal(6, 4) NULL DEFAULT NULL,
  `remark` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleId` int(11) NULL DEFAULT NULL,
  `toCustId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`rateId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '手续费表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of charge_rate
-- ----------------------------
INSERT INTO `charge_rate` VALUES (1, '1', '保理公司转账手续费', 0.0100, NULL, 2, 1, 1, 1, '2017-06-25 13:33:43', NULL, NULL);
INSERT INTO `charge_rate` VALUES (2, '2', '保理公司提现手续费', 0.0000, NULL, 2, 1, 1, 1, '2017-06-25 13:33:59', NULL, NULL);
INSERT INTO `charge_rate` VALUES (3, '2', '运维平台提现手续费', 0.0000, NULL, 21, 1, 1, 1, '2017-06-25 13:35:12', NULL, NULL);
INSERT INTO `charge_rate` VALUES (4, '1', '核心企业转账手续费', 0.0200, NULL, 22, 1, 1, 1, '2017-06-25 13:35:32', NULL, NULL);
INSERT INTO `charge_rate` VALUES (5, '2', '核心企业提现手续费', 0.0200, NULL, 22, 1, 1, 1, '2017-06-25 13:35:54', NULL, NULL);
INSERT INTO `charge_rate` VALUES (6, '1', '供应商转账手续费', 0.0300, NULL, 23, 1, 1, 1, '2017-06-25 13:36:19', NULL, NULL);
INSERT INTO `charge_rate` VALUES (7, '2', '供应商提现手续费', 0.0300, NULL, 23, 1, 1, 1, '2017-06-25 13:36:36', NULL, NULL);

-- ----------------------------
-- Table structure for check_detail
-- ----------------------------
DROP TABLE IF EXISTS `check_detail`;
CREATE TABLE `check_detail`  (
  `detailId` int(11) NOT NULL AUTO_INCREMENT,
  `checkId` int(11) NULL DEFAULT NULL,
  `seqNo` int(3) NULL DEFAULT NULL,
  `funcName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordId` int(11) NULL DEFAULT NULL,
  `checkDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filePath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkUserId` int(11) NULL DEFAULT NULL,
  `checkUserName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkAction` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`detailId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '审核记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of check_detail
-- ----------------------------
INSERT INTO `check_detail` VALUES (1, 1, 1, 'factor', 1, '保理合同没问题', 'null', 4, '保理操作员', 'agree', 3, 4, '2017-06-26 09:49:28', NULL, NULL);
INSERT INTO `check_detail` VALUES (2, 1, 2, 'factor', 1, '贷款合同没问题', 'null', 4, '保理操作员', 'agree', 5, 4, '2017-06-26 09:51:44', NULL, NULL);
INSERT INTO `check_detail` VALUES (3, 1, 3, 'loanAct', 1, '贷款已放款，入账', 'null', 4, '保理操作员', 'agree', 6, 4, '2017-06-26 09:53:56', NULL, NULL);
INSERT INTO `check_detail` VALUES (4, 1, 4, 'factorAct', 1, '转账给核心企业', 'null', 4, '保理操作员', 'agree', 7, 4, '2017-06-26 09:56:47', NULL, NULL);
INSERT INTO `check_detail` VALUES (5, 2, 1, 'transfer', 5, '支付合同款项', 'null', 6, '央企操作员', 'agree', 2, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `check_detail` VALUES (6, 3, 1, 'cashCheck', 8, '1111', 'null', 8, '供应商操作员', 'agree', 2, 8, '2017-06-26 10:19:33', NULL, NULL);
INSERT INTO `check_detail` VALUES (7, 3, 2, 'cashConfirm', 8, '111', '', 4, '保理操作员', 'agree', 3, 4, '2017-06-26 11:12:17', NULL, NULL);

-- ----------------------------
-- Table structure for check_info
-- ----------------------------
DROP TABLE IF EXISTS `check_info`;
CREATE TABLE `check_info`  (
  `checkId` int(11) NOT NULL AUTO_INCREMENT,
  `seqNo` int(3) NULL DEFAULT NULL,
  `funcName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recordId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`checkId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '审核信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of check_info
-- ----------------------------
INSERT INTO `check_info` VALUES (1, 4, 'factorAct', 1, 7, 4, '2017-06-26 09:49:28', 4, '2017-06-26 09:56:47');
INSERT INTO `check_info` VALUES (2, 1, 'transfer', 5, 2, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `check_info` VALUES (3, 2, 'cashConfirm', 8, 3, 8, '2017-06-26 10:19:33', 4, '2017-06-26 11:12:17');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `regId` int(11) NOT NULL AUTO_INCREMENT,
  `custName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperPath` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountBank` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountNum` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eMail` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginNameInp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `passwdInp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `userNameInp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sexInp` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `mobileNoInp` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `eMailInp` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `addressInp` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `loginNameApp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `passwdApp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `userNameApp` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sexApp` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `mobileNoApp` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `eMailApp` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `addressApp` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`regId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业注册信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (2, '招银云创(深圳)信息技术有限公司', '914403003600521031', 'Upload\\1\\2017-06-25 12-39-37\\7.jpg', '招商银行股份有限公司深圳科苑支行', '招银云创(深圳)信息技术有限公司', '755929253610802', '18202128391', 'chenyin@mbcloud.com', '上海市浦东新区瑞昌路385号A区5楼', 'ZYYC01', '123456', '云创操作员', '男', '13800000001', 'ZYYC01@qq.com', '上海市浦东新区瑞昌路385号A区5楼', 'ZYYC02', '123456', '云创复核员', '女', '13800000002', 'ZYYC02@qq.com', '上海市浦东新区瑞昌路385号A区5楼', 3, 1, '2017-06-25 12:39:40', 1, '2017-06-25 13:22:35');
INSERT INTO `company` VALUES (3, 'XXXX保理有限公司', '91440300360052XXX1', 'Upload\\1\\2017-06-25 13-44-48\\1.jpg', '招商银行股份有限公司', 'XXXX保理有限公司', '75592925361XXX1', '13900000000', 'XXXX@qq.com', '上海市浦东新区XXXX', 'BLGS01', '123456', '保理操作员', '男', '13900000001', 'BLGS01@qq.com', '上海市浦东新区XXXX', 'BLGS02', '123456', '保理审核员', '女', '13900000002', 'BLGS02@qq.com', '上海市浦东新区XXXX', 3, 1, '2017-06-25 13:47:06', 1, '2017-06-25 13:55:16');
INSERT INTO `company` VALUES (4, 'XXXX核心企业', '91440300360052XXX2', 'Upload\\1\\2017-06-25 13-49-51\\3.jpg', '招商银行股份有限公司', 'XXXX核心企业', '7xxxxxxxxxxxx1', '13700000000', 'XXXX@qq.com', '上海市浦东新区XXXX', 'HXQY01', '123456', '央企操作员', '男', '13700000001', 'HXQY01@qq.com', '上海市浦东新区XXXX', 'HXQY02', '123456', '央企审核员', '女', '13700000002', 'HXQY02@qq.com', '上海市浦东新区XXXX', 3, 1, '2017-06-25 13:52:47', 1, '2017-06-25 13:55:27');
INSERT INTO `company` VALUES (5, 'XXXX供应商', '91440300360052XXX3', 'Upload\\1\\2017-06-25 13-53-07\\5.jpg', '招商银行股份有限公司', 'XXXX供应商', '7xxxxxxxxxxxx1', '13900000000', 'XXXX@qq.com', '上海市浦东新区XXXX', 'GYS01', '123456', '供应商操作员', '男', '13700000001', 'GYS01@qq.com', '上海市浦东新区XXXX', 'GYS02', '123456', '供应商审核员', '女', '13900000002', 'GYS02@qq.com', '上海市浦东新区XXXX', 3, 1, '2017-06-25 13:54:50', 1, '2017-06-25 13:55:39');

-- ----------------------------
-- Table structure for cust_amt
-- ----------------------------
DROP TABLE IF EXISTS `cust_amt`;
CREATE TABLE `cust_amt`  (
  `custAmtId` int(11) NOT NULL AUTO_INCREMENT,
  `amtCode` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amtLevel` int(11) NULL DEFAULT NULL,
  `amtValue` decimal(18, 2) NULL DEFAULT NULL,
  `tradId` int(11) NULL DEFAULT NULL,
  `tradType` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradFrom` int(11) NULL DEFAULT NULL,
  `tradFromName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradTo` int(11) NULL DEFAULT NULL,
  `tradToName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`custAmtId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业余额信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cust_amt
-- ----------------------------
INSERT INTO `cust_amt` VALUES (1, '878259b1606c4618b18b7086b915ce', 1, 1000000.00, 1, '生成', 'LOAN0001', 0, 'XXXX银行', 2, 'XXXX保理有限公司', 2, 2, 4, '2017-06-26 09:53:56', 4, '2017-06-26 09:56:48');
INSERT INTO `cust_amt` VALUES (2, '878259b1606c4618b18b7086b915ce', 2, 990000.00, 1, '转出', 'BLHT0001', 2, 'XXXX保理有限公司', 3, 'XXXX核心企业', 2, 2, 4, '2017-06-26 09:56:48', NULL, NULL);
INSERT INTO `cust_amt` VALUES (3, '878259b1606c4618b18b7086b915ce', 2, 10000.00, 1, '拆分', 'BLHT0001', NULL, NULL, NULL, NULL, 2, 2, 4, '2017-06-26 09:56:48', 4, '2017-06-26 09:56:48');
INSERT INTO `cust_amt` VALUES (4, '878259b1606c4618b18b7086b915ce', 2, 990000.00, 1, '转入', 'BLHT0001', 2, 'XXXX保理有限公司', 3, 'XXXX核心企业', 3, 2, 4, '2017-06-26 09:56:48', 6, '2017-06-26 10:04:23');
INSERT INTO `cust_amt` VALUES (5, '878259b1606c4618b18b7086b915ce', 3, 10000.00, 1, '转出', 'BLHT0001', 2, 'XXXX保理有限公司', 1, '招银云创(深圳)信息技术有限公司', 2, 2, 4, '2017-06-26 09:56:48', NULL, NULL);
INSERT INTO `cust_amt` VALUES (6, '878259b1606c4618b18b7086b915ce', 3, 10000.00, 1, '转入', 'BLHT0001', 2, 'XXXX保理有限公司', 1, '招银云创(深圳)信息技术有限公司', 1, 1, 4, '2017-06-26 09:56:48', NULL, NULL);
INSERT INTO `cust_amt` VALUES (7, '878259b1606c4618b18b7086b915ce', 3, 98000.00, 5, '转出', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 4, 'XXXX供应商', 3, 2, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `cust_amt` VALUES (8, '878259b1606c4618b18b7086b915ce', 3, 892000.00, 5, '拆分', 'TRANSFERda7008e5af1642cdb06588b40980a1', NULL, NULL, NULL, NULL, 3, 2, 6, '2017-06-26 10:04:23', 6, '2017-06-26 10:04:23');
INSERT INTO `cust_amt` VALUES (9, '878259b1606c4618b18b7086b915ce', 3, 98000.00, 5, '转入', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 4, 'XXXX供应商', 4, 2, 6, '2017-06-26 10:04:23', 4, '2017-06-26 11:12:17');
INSERT INTO `cust_amt` VALUES (10, '878259b1606c4618b18b7086b915ce', 4, 2000.00, 5, '转出', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 1, '招银云创(深圳)信息技术有限公司', 3, 2, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `cust_amt` VALUES (11, '878259b1606c4618b18b7086b915ce', 4, 890000.00, 5, '拆分', 'TRANSFERda7008e5af1642cdb06588b40980a1', NULL, NULL, NULL, NULL, 3, 1, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `cust_amt` VALUES (12, '878259b1606c4618b18b7086b915ce', 4, 2000.00, 5, '转入', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 1, '招银云创(深圳)信息技术有限公司', 1, 1, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `cust_amt` VALUES (13, '878259b1606c4618b18b7086b915ce', 4, 87300.00, 8, '转出', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 2, 'XXXX保理有限公司', 4, 2, 4, '2017-06-26 11:12:17', NULL, NULL);
INSERT INTO `cust_amt` VALUES (14, '878259b1606c4618b18b7086b915ce', 4, 10700.00, 8, '拆分', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 2, 'XXXX保理有限公司', 4, 2, 4, '2017-06-26 11:12:17', 4, '2017-06-26 11:12:17');
INSERT INTO `cust_amt` VALUES (15, '878259b1606c4618b18b7086b915ce', 4, 87300.00, 8, '回收', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 2, 'XXXX保理有限公司', 2, 0, 4, '2017-06-26 11:12:17', NULL, NULL);
INSERT INTO `cust_amt` VALUES (16, '878259b1606c4618b18b7086b915ce', 4, 2700.00, 8, '转出', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 1, '招银云创(深圳)信息技术有限公司', 4, 1, 4, '2017-06-26 11:12:17', NULL, NULL);
INSERT INTO `cust_amt` VALUES (17, '878259b1606c4618b18b7086b915ce', 4, 8000.00, 8, '拆分', 'CASHbd317ad9c7c04059bce2681bfbb3a9', NULL, NULL, NULL, NULL, 4, 1, 4, '2017-06-26 11:12:17', NULL, NULL);
INSERT INTO `cust_amt` VALUES (18, '878259b1606c4618b18b7086b915ce', 5, 2700.00, 8, '转入', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 1, '招银云创(深圳)信息技术有限公司', 1, 1, 4, '2017-06-26 11:12:17', NULL, NULL);

-- ----------------------------
-- Table structure for cust_transaction
-- ----------------------------
DROP TABLE IF EXISTS `cust_transaction`;
CREATE TABLE `cust_transaction`  (
  `tradId` int(11) NOT NULL AUTO_INCREMENT,
  `tradType` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradFrom` int(11) NULL DEFAULT NULL,
  `tradFromName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tradTo` int(11) NULL DEFAULT NULL,
  `tradToName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amtAll` decimal(18, 2) NULL DEFAULT NULL,
  `amtClock` decimal(18, 2) NULL DEFAULT NULL,
  `amtFree` decimal(18, 2) NULL DEFAULT NULL,
  `tradAmt` decimal(18, 2) NULL DEFAULT NULL,
  `chargeRate` decimal(6, 4) NULL DEFAULT NULL,
  `rateAmt` decimal(18, 2) NULL DEFAULT NULL,
  `filePath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custId` int(11) NULL DEFAULT NULL,
  `checkId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`tradId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业交易信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cust_transaction
-- ----------------------------
INSERT INTO `cust_transaction` VALUES (1, '充值', 'LOAN0001', 0, 'XXXX银行', 2, 'XXXX保理有限公司', 1000000.00, 0.00, 1000000.00, 1000000.00, 0.0000, 0.00, '', 2, 0, 2, 4, '2017-06-26 09:53:56', NULL, NULL);
INSERT INTO `cust_transaction` VALUES (2, '转账', 'BLHT0001', 2, 'XXXX保理有限公司', 3, 'XXXX核心企业', 0.00, 0.00, 0.00, 1000000.00, 0.0100, 10000.00, '', 2, 0, 2, 4, '2017-06-26 09:56:47', NULL, NULL);
INSERT INTO `cust_transaction` VALUES (3, '转账', 'BLHT0001', 2, 'XXXX保理有限公司', 3, 'XXXX核心企业', 990000.00, 0.00, 990000.00, 990000.00, 0.0100, 10000.00, '', 3, 0, 2, 4, '2017-06-26 09:56:47', NULL, NULL);
INSERT INTO `cust_transaction` VALUES (4, '手续费', 'BLHT0001', 2, 'XXXX保理有限公司', 1, '招银云创(深圳)信息技术有限公司', 10000.00, 0.00, 10000.00, 10000.00, 0.0000, 0.00, '', 1, 0, 2, 4, '2017-06-26 09:56:48', NULL, NULL);
INSERT INTO `cust_transaction` VALUES (5, '转账', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 4, 'XXXX供应商', 890000.00, 0.00, 890000.00, 100000.00, 0.0200, 2000.00, 'Upload\\6\\2017-06-26 10-03-00\\5.jpg', 3, 2, 2, 6, '2017-06-26 10:04:23', 6, '2017-06-26 10:04:23');
INSERT INTO `cust_transaction` VALUES (6, '转账', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 4, 'XXXX供应商', 98000.00, 100.00, 98000.00, 98000.00, 0.0200, 2000.00, '', 4, 0, 2, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `cust_transaction` VALUES (7, '手续费', 'TRANSFERda7008e5af1642cdb06588b40980a1', 3, 'XXXX核心企业', 1, '招银云创(深圳)信息技术有限公司', 12000.00, 0.00, 12000.00, 2000.00, 0.0000, 0.00, '', 1, 0, 2, 6, '2017-06-26 10:04:23', NULL, NULL);
INSERT INTO `cust_transaction` VALUES (8, '提现', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 2, 'XXXX保理有限公司', 8000.00, 0.00, 8000.00, 90000.00, 0.0300, 2700.00, NULL, 4, 3, 3, 8, '2017-06-26 10:19:19', 4, '2017-06-26 11:12:17');
INSERT INTO `cust_transaction` VALUES (9, '手续费', 'CASHbd317ad9c7c04059bce2681bfbb3a9', 4, 'XXXX供应商', 2, 'XXXX保理有限公司', 14700.00, 0.00, 14700.00, 2700.00, 0.0000, 0.00, '', 1, 0, 2, 4, '2017-06-26 11:12:17', NULL, NULL);

-- ----------------------------
-- Table structure for customer_info
-- ----------------------------
DROP TABLE IF EXISTS `customer_info`;
CREATE TABLE `customer_info`  (
  `custId` int(11) NOT NULL AUTO_INCREMENT,
  `custName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `paperPath` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountBank` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `accountNum` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telNo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eMail` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amtAll` decimal(18, 2) NULL DEFAULT NULL,
  `amtClock` decimal(18, 2) NULL DEFAULT NULL,
  `amtFree` decimal(18, 2) NULL DEFAULT NULL,
  `orgId` int(11) NULL DEFAULT NULL,
  `checkId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`custId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_info
-- ----------------------------
INSERT INTO `customer_info` VALUES (1, '招银云创(深圳)信息技术有限公司', '', '914403003600521031', 'Upload\\1\\2017-06-25 12-39-37\\7.jpg', '招商银行股份有限公司深圳科苑支行', '招银云创(深圳)信息技术有限公司', '755929253610802', '18202128391', 'chenyin@mbcloud.com', '上海市浦东新区瑞昌路385号A区5楼', 14700.00, 0.00, 14700.00, 1, 0, 1, 1, '2017-06-25 13:22:51', 4, '2017-06-26 11:12:17');
INSERT INTO `customer_info` VALUES (2, 'XXXX保理有限公司', '', '91440300360052XXX1', 'Upload\\1\\2017-06-25 13-44-48\\1.jpg', '招商银行股份有限公司', 'XXXX保理有限公司', '75592925361XXX1', '13900000000', 'XXXX@qq.com', '上海市浦东新区XXXX', 0.00, 0.00, 0.00, 2, 0, 1, 1, '2017-06-25 13:55:16', 4, '2017-06-26 09:56:47');
INSERT INTO `customer_info` VALUES (3, 'XXXX核心企业', '', '91440300360052XXX2', 'Upload\\1\\2017-06-25 13-49-51\\3.jpg', '招商银行股份有限公司', 'XXXX核心企业', '7xxxxxxxxxxxx1', '13700000000', 'XXXX@qq.com', '上海市浦东新区XXXX', 890000.00, 0.00, 890000.00, 3, 0, 1, 1, '2017-06-25 13:55:27', 6, '2017-06-26 10:04:23');
INSERT INTO `customer_info` VALUES (4, 'XXXX供应商', '', '91440300360052XXX3', 'Upload\\1\\2017-06-25 13-53-07\\5.jpg', '招商银行股份有限公司', 'XXXX供应商', '7xxxxxxxxxxxx1', '13900000000', 'XXXX@qq.com', '上海市浦东新区XXXX', 8000.00, 0.00, 8000.00, 4, 0, 1, 1, '2017-06-25 13:55:38', 4, '2017-06-26 11:12:17');

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor`  (
  `factorId` int(11) NOT NULL AUTO_INCREMENT,
  `factorCode` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custSell` int(11) NULL DEFAULT NULL,
  `custSellName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custfactor` int(11) NULL DEFAULT NULL,
  `custfactorName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `factorAmt` decimal(18, 2) NULL DEFAULT NULL,
  `payment` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rate` decimal(6, 4) NULL DEFAULT NULL,
  `interest` decimal(18, 2) NULL DEFAULT NULL,
  `tenor` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startDate` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endDate` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filePath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`factorId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '保理合同表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factor
-- ----------------------------
INSERT INTO `factor` VALUES (1, 'BLHT0001', 3, 'XXXX核心企业', 2, 'XXXX保理有限公司', 1000000.00, '到期还本付息', 0.0600, 60000.00, '1年', '2017-06-26', '2018-06-26', 'Upload\\4\\2017-06-26 09-47-38\\1.jpg', 'test', 1, 7, 4, '2017-06-26 09:47:46', 4, '2017-06-26 09:56:47');

-- ----------------------------
-- Table structure for loan
-- ----------------------------
DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan`  (
  `loanId` int(11) NOT NULL AUTO_INCREMENT,
  `loanCode` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custDebtor` int(11) NULL DEFAULT NULL,
  `custDebtorName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `custCreditor` int(11) NULL DEFAULT NULL,
  `custCreditorName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loanAmt` decimal(18, 2) NULL DEFAULT NULL,
  `payment` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rate` decimal(6, 4) NULL DEFAULT NULL,
  `interest` decimal(18, 2) NULL DEFAULT NULL,
  `tenor` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `startDate` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `endDate` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filePath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `factorId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`loanId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '贷款合同表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loan
-- ----------------------------
INSERT INTO `loan` VALUES (1, 'LOAN0001', 2, 'XXXX保理有限公司', 0, 'XXXX银行', 1000000.00, '到期还本付息', 0.0500, 50000.00, '1年', '2017-06-26', '2018-06-26', 'Upload\\4\\2017-06-26 09-51-05\\3.jpg', 'test', 1, 1, 4, '2017-06-26 09:51:21', NULL, NULL);

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`  (
  `logId` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Type` int(2) NULL DEFAULT NULL,
  `RequestIp` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ExceptionCode` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ExceptionDetail` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Params` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  PRIMARY KEY (`logId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 395 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES (89, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:14:13');
INSERT INTO `sys_log` VALUES (90, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:14:29');
INSERT INTO `sys_log` VALUES (91, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\a246f0388ff84ca08d39bd9362c82e.txt', '', NULL, 1, '2017-11-23 15:14:29');
INSERT INTO `sys_log` VALUES (92, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:14:56');
INSERT INTO `sys_log` VALUES (93, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\3a53b4e092e44b5da8088df0145c4c.txt', '', NULL, 1, '2017-11-23 15:14:57');
INSERT INTO `sys_log` VALUES (94, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:15:54');
INSERT INTO `sys_log` VALUES (95, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:42:36');
INSERT INTO `sys_log` VALUES (96, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:43:14');
INSERT INTO `sys_log` VALUES (97, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 15:43:19');
INSERT INTO `sys_log` VALUES (98, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:10:16');
INSERT INTO `sys_log` VALUES (99, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:10:47');
INSERT INTO `sys_log` VALUES (100, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:10:58');
INSERT INTO `sys_log` VALUES (101, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:12:51');
INSERT INTO `sys_log` VALUES (102, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\209cca6634774dc4a8f68502f77d59.txt', '', NULL, 1, '2017-11-23 16:12:51');
INSERT INTO `sys_log` VALUES (103, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:16:08');
INSERT INTO `sys_log` VALUES (104, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:16:10');
INSERT INTO `sys_log` VALUES (105, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\1d875e1376d6417b876ffa225ec8d4.txt', '', NULL, 1, '2017-11-23 16:16:10');
INSERT INTO `sys_log` VALUES (106, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:17:26');
INSERT INTO `sys_log` VALUES (107, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:17:29');
INSERT INTO `sys_log` VALUES (108, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\5c9f4021927a418c8797337ea74b91.txt', '', NULL, 1, '2017-11-23 16:17:29');
INSERT INTO `sys_log` VALUES (109, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:20:53');
INSERT INTO `sys_log` VALUES (110, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:20:57');
INSERT INTO `sys_log` VALUES (111, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\192dd83f35c84373b553ac45ff2bf4.txt', '', NULL, 1, '2017-11-23 16:20:57');
INSERT INTO `sys_log` VALUES (112, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:23:43');
INSERT INTO `sys_log` VALUES (113, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:23:45');
INSERT INTO `sys_log` VALUES (114, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'java.lang.NumberFormatException', 'Upload\\sysLog\\1\\547892caac5f43eeae09e7c9270fa3.txt', '', NULL, 1, '2017-11-23 16:23:45');
INSERT INTO `sys_log` VALUES (115, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:25:03');
INSERT INTO `sys_log` VALUES (116, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:25:05');
INSERT INTO `sys_log` VALUES (117, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:26:50');
INSERT INTO `sys_log` VALUES (118, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:26:52');
INSERT INTO `sys_log` VALUES (119, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'java.lang.NumberFormatException', 'Upload\\sysLog\\1\\82532f3368c1490686bce752776b45.txt', '', NULL, 1, '2017-11-23 16:26:53');
INSERT INTO `sys_log` VALUES (120, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:27:55');
INSERT INTO `sys_log` VALUES (121, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:28:01');
INSERT INTO `sys_log` VALUES (122, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:28:04');
INSERT INTO `sys_log` VALUES (123, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\2548307697894e19bd188dd6a7097c.txt', '', NULL, 1, '2017-11-23 16:28:05');
INSERT INTO `sys_log` VALUES (124, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:28:11');
INSERT INTO `sys_log` VALUES (125, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\bab694ce25794281a99f1e925f4ad1.txt', '', NULL, 1, '2017-11-23 16:28:11');
INSERT INTO `sys_log` VALUES (126, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:31:37');
INSERT INTO `sys_log` VALUES (127, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:31:40');
INSERT INTO `sys_log` VALUES (128, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:31:50');
INSERT INTO `sys_log` VALUES (129, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:31:55');
INSERT INTO `sys_log` VALUES (130, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:32:00');
INSERT INTO `sys_log` VALUES (131, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:35:19');
INSERT INTO `sys_log` VALUES (132, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:35:52');
INSERT INTO `sys_log` VALUES (133, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:35:56');
INSERT INTO `sys_log` VALUES (134, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:35:57');
INSERT INTO `sys_log` VALUES (135, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:35:58');
INSERT INTO `sys_log` VALUES (136, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:03');
INSERT INTO `sys_log` VALUES (137, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:05');
INSERT INTO `sys_log` VALUES (138, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:08');
INSERT INTO `sys_log` VALUES (139, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:08');
INSERT INTO `sys_log` VALUES (140, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:10');
INSERT INTO `sys_log` VALUES (141, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:14');
INSERT INTO `sys_log` VALUES (142, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:16');
INSERT INTO `sys_log` VALUES (143, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 16:36:18');
INSERT INTO `sys_log` VALUES (144, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:01:40');
INSERT INTO `sys_log` VALUES (145, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:01:51');
INSERT INTO `sys_log` VALUES (146, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:02:05');
INSERT INTO `sys_log` VALUES (147, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:02:07');
INSERT INTO `sys_log` VALUES (148, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:02:44');
INSERT INTO `sys_log` VALUES (149, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:03:21');
INSERT INTO `sys_log` VALUES (150, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:03:28');
INSERT INTO `sys_log` VALUES (151, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:04:01');
INSERT INTO `sys_log` VALUES (152, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:04:34');
INSERT INTO `sys_log` VALUES (153, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:05:10');
INSERT INTO `sys_log` VALUES (154, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:10:59');
INSERT INTO `sys_log` VALUES (155, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:12:44');
INSERT INTO `sys_log` VALUES (156, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:13:08');
INSERT INTO `sys_log` VALUES (157, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:15:01');
INSERT INTO `sys_log` VALUES (158, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:15:26');
INSERT INTO `sys_log` VALUES (159, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:18:59');
INSERT INTO `sys_log` VALUES (160, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:20:50');
INSERT INTO `sys_log` VALUES (161, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:21:16');
INSERT INTO `sys_log` VALUES (162, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:21:34');
INSERT INTO `sys_log` VALUES (163, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:22:08');
INSERT INTO `sys_log` VALUES (164, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:26:46');
INSERT INTO `sys_log` VALUES (165, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:28:10');
INSERT INTO `sys_log` VALUES (166, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:29:55');
INSERT INTO `sys_log` VALUES (167, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:30:46');
INSERT INTO `sys_log` VALUES (168, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:40:04');
INSERT INTO `sys_log` VALUES (169, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:40:57');
INSERT INTO `sys_log` VALUES (170, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:44:25');
INSERT INTO `sys_log` VALUES (171, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:46:11');
INSERT INTO `sys_log` VALUES (172, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:46:26');
INSERT INTO `sys_log` VALUES (173, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:46:41');
INSERT INTO `sys_log` VALUES (174, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:46:44');
INSERT INTO `sys_log` VALUES (175, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:55:55');
INSERT INTO `sys_log` VALUES (176, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:56:19');
INSERT INTO `sys_log` VALUES (177, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:56:38');
INSERT INTO `sys_log` VALUES (178, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:56:47');
INSERT INTO `sys_log` VALUES (179, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:56:57');
INSERT INTO `sys_log` VALUES (180, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:57:03');
INSERT INTO `sys_log` VALUES (181, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:58:57');
INSERT INTO `sys_log` VALUES (182, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:59:05');
INSERT INTO `sys_log` VALUES (183, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:59:06');
INSERT INTO `sys_log` VALUES (184, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:59:13');
INSERT INTO `sys_log` VALUES (185, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 17:59:18');
INSERT INTO `sys_log` VALUES (186, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:01:14');
INSERT INTO `sys_log` VALUES (187, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:01:19');
INSERT INTO `sys_log` VALUES (188, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:02:03');
INSERT INTO `sys_log` VALUES (189, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:03:13');
INSERT INTO `sys_log` VALUES (190, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:04:02');
INSERT INTO `sys_log` VALUES (191, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:05:57');
INSERT INTO `sys_log` VALUES (192, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:06:34');
INSERT INTO `sys_log` VALUES (193, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:07:41');
INSERT INTO `sys_log` VALUES (194, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:15:46');
INSERT INTO `sys_log` VALUES (195, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:16:21');
INSERT INTO `sys_log` VALUES (196, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:16:25');
INSERT INTO `sys_log` VALUES (197, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:16:30');
INSERT INTO `sys_log` VALUES (198, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:16:35');
INSERT INTO `sys_log` VALUES (199, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:16:38');
INSERT INTO `sys_log` VALUES (200, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:18:18');
INSERT INTO `sys_log` VALUES (201, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:18:22');
INSERT INTO `sys_log` VALUES (202, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:20:59');
INSERT INTO `sys_log` VALUES (203, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:21:23');
INSERT INTO `sys_log` VALUES (204, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:21:27');
INSERT INTO `sys_log` VALUES (205, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:21:48');
INSERT INTO `sys_log` VALUES (206, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:22:34');
INSERT INTO `sys_log` VALUES (207, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:23:38');
INSERT INTO `sys_log` VALUES (208, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:24:13');
INSERT INTO `sys_log` VALUES (209, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:25:19');
INSERT INTO `sys_log` VALUES (210, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:25:35');
INSERT INTO `sys_log` VALUES (211, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:25:49');
INSERT INTO `sys_log` VALUES (212, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:25:54');
INSERT INTO `sys_log` VALUES (213, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:31:16');
INSERT INTO `sys_log` VALUES (214, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:31:21');
INSERT INTO `sys_log` VALUES (215, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\fdb6febb7e29491b88c46c699d26c1.txt', '', NULL, 1, '2017-11-23 18:31:21');
INSERT INTO `sys_log` VALUES (216, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:33:51');
INSERT INTO `sys_log` VALUES (217, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 1, '127.0.0.1', 'org.hibernate.exception.SQLGrammarException', 'Upload\\sysLog\\1\\fb6ada70f234429eb9ad934072cb67.txt', '', NULL, 1, '2017-11-23 18:33:51');
INSERT INTO `sys_log` VALUES (218, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:35:50');
INSERT INTO `sys_log` VALUES (219, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:35:56');
INSERT INTO `sys_log` VALUES (220, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:36:48');
INSERT INTO `sys_log` VALUES (221, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:37:06');
INSERT INTO `sys_log` VALUES (222, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:38:25');
INSERT INTO `sys_log` VALUES (223, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:38:33');
INSERT INTO `sys_log` VALUES (224, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 18:39:41');
INSERT INTO `sys_log` VALUES (225, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:04:51');
INSERT INTO `sys_log` VALUES (226, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:04:54');
INSERT INTO `sys_log` VALUES (227, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:05:06');
INSERT INTO `sys_log` VALUES (228, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:05:08');
INSERT INTO `sys_log` VALUES (229, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:05:33');
INSERT INTO `sys_log` VALUES (230, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:08:46');
INSERT INTO `sys_log` VALUES (231, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:21:45');
INSERT INTO `sys_log` VALUES (232, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:22:46');
INSERT INTO `sys_log` VALUES (233, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:22:49');
INSERT INTO `sys_log` VALUES (234, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:22:50');
INSERT INTO `sys_log` VALUES (235, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:22:58');
INSERT INTO `sys_log` VALUES (236, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:23:13');
INSERT INTO `sys_log` VALUES (237, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:27:37');
INSERT INTO `sys_log` VALUES (238, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:27:38');
INSERT INTO `sys_log` VALUES (239, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:27:44');
INSERT INTO `sys_log` VALUES (240, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:37:26');
INSERT INTO `sys_log` VALUES (241, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-23 19:37:34');
INSERT INTO `sys_log` VALUES (242, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:11');
INSERT INTO `sys_log` VALUES (243, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:32');
INSERT INTO `sys_log` VALUES (244, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:33');
INSERT INTO `sys_log` VALUES (245, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:54');
INSERT INTO `sys_log` VALUES (246, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:55');
INSERT INTO `sys_log` VALUES (247, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:55');
INSERT INTO `sys_log` VALUES (248, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:56');
INSERT INTO `sys_log` VALUES (249, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:09:58');
INSERT INTO `sys_log` VALUES (250, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:10:03');
INSERT INTO `sys_log` VALUES (251, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:10:07');
INSERT INTO `sys_log` VALUES (252, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:10:10');
INSERT INTO `sys_log` VALUES (253, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:10:31');
INSERT INTO `sys_log` VALUES (254, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-11-28 18:10:43');
INSERT INTO `sys_log` VALUES (255, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-12-26 10:44:28');
INSERT INTO `sys_log` VALUES (256, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-12-26 10:44:33');
INSERT INTO `sys_log` VALUES (257, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-12-26 10:45:03');
INSERT INTO `sys_log` VALUES (258, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-12-26 10:45:05');
INSERT INTO `sys_log` VALUES (259, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2017-12-26 10:45:08');
INSERT INTO `sys_log` VALUES (260, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:40:45');
INSERT INTO `sys_log` VALUES (261, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:41:09');
INSERT INTO `sys_log` VALUES (262, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:41:13');
INSERT INTO `sys_log` VALUES (263, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:41:15');
INSERT INTO `sys_log` VALUES (264, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:41:21');
INSERT INTO `sys_log` VALUES (265, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:41:24');
INSERT INTO `sys_log` VALUES (266, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '0:0:0:0:0:0:0:1', NULL, NULL, NULL, NULL, 1, '2018-03-12 18:42:35');
INSERT INTO `sys_log` VALUES (267, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-03-28 17:14:31');
INSERT INTO `sys_log` VALUES (268, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-03-28 17:14:36');
INSERT INTO `sys_log` VALUES (269, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-05-15 21:22:21');
INSERT INTO `sys_log` VALUES (270, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-05-15 21:22:37');
INSERT INTO `sys_log` VALUES (271, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-05-15 21:22:40');
INSERT INTO `sys_log` VALUES (272, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-05-15 21:23:30');
INSERT INTO `sys_log` VALUES (273, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2018-05-15 21:24:18');
INSERT INTO `sys_log` VALUES (274, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:35:43');
INSERT INTO `sys_log` VALUES (275, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:38:19');
INSERT INTO `sys_log` VALUES (276, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:38:36');
INSERT INTO `sys_log` VALUES (277, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:38:44');
INSERT INTO `sys_log` VALUES (278, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:39:45');
INSERT INTO `sys_log` VALUES (279, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:39:48');
INSERT INTO `sys_log` VALUES (280, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:42:20');
INSERT INTO `sys_log` VALUES (281, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:42:25');
INSERT INTO `sys_log` VALUES (282, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 14:42:36');
INSERT INTO `sys_log` VALUES (283, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:05:33');
INSERT INTO `sys_log` VALUES (284, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:05:46');
INSERT INTO `sys_log` VALUES (285, '日志列表', 'com.SupplyChainFinance.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:05:47');
INSERT INTO `sys_log` VALUES (286, '安全退出', 'com.SupplyChainFinance.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:06:15');
INSERT INTO `sys_log` VALUES (287, '用户登录', 'com.SupplyChainFinance.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:06:38');
INSERT INTO `sys_log` VALUES (288, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:08:20');
INSERT INTO `sys_log` VALUES (289, '用户列表', 'com.SupplyChainFinance.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 15:08:37');
INSERT INTO `sys_log` VALUES (290, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 16:05:43');
INSERT INTO `sys_log` VALUES (291, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 16:05:47');
INSERT INTO `sys_log` VALUES (292, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 16:08:14');
INSERT INTO `sys_log` VALUES (293, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 16:08:18');
INSERT INTO `sys_log` VALUES (294, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 16:11:53');
INSERT INTO `sys_log` VALUES (295, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-10-01 16:11:57');
INSERT INTO `sys_log` VALUES (296, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:18:09');
INSERT INTO `sys_log` VALUES (297, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:18:23');
INSERT INTO `sys_log` VALUES (298, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:18:25');
INSERT INTO `sys_log` VALUES (299, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:18:33');
INSERT INTO `sys_log` VALUES (300, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:19:06');
INSERT INTO `sys_log` VALUES (301, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:19:23');
INSERT INTO `sys_log` VALUES (302, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:19:29');
INSERT INTO `sys_log` VALUES (303, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:20:21');
INSERT INTO `sys_log` VALUES (304, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:20:33');
INSERT INTO `sys_log` VALUES (305, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2019-11-18 12:20:38');
INSERT INTO `sys_log` VALUES (306, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-03-20 11:29:33');
INSERT INTO `sys_log` VALUES (307, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-03-20 11:30:00');
INSERT INTO `sys_log` VALUES (308, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-03-20 11:31:26');
INSERT INTO `sys_log` VALUES (309, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-04-03 17:11:46');
INSERT INTO `sys_log` VALUES (310, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-04-03 17:12:36');
INSERT INTO `sys_log` VALUES (311, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-04-03 17:12:37');
INSERT INTO `sys_log` VALUES (312, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-04-03 17:16:12');
INSERT INTO `sys_log` VALUES (313, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-04-03 17:16:47');
INSERT INTO `sys_log` VALUES (314, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:35:21');
INSERT INTO `sys_log` VALUES (315, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:35:37');
INSERT INTO `sys_log` VALUES (316, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:35:44');
INSERT INTO `sys_log` VALUES (317, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:57:19');
INSERT INTO `sys_log` VALUES (318, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:57:54');
INSERT INTO `sys_log` VALUES (319, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:10');
INSERT INTO `sys_log` VALUES (320, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:40');
INSERT INTO `sys_log` VALUES (321, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:41');
INSERT INTO `sys_log` VALUES (322, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:46');
INSERT INTO `sys_log` VALUES (323, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:50');
INSERT INTO `sys_log` VALUES (324, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:51');
INSERT INTO `sys_log` VALUES (325, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:52');
INSERT INTO `sys_log` VALUES (326, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:58:57');
INSERT INTO `sys_log` VALUES (327, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 19:59:00');
INSERT INTO `sys_log` VALUES (328, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 20:00:28');
INSERT INTO `sys_log` VALUES (329, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 20:00:30');
INSERT INTO `sys_log` VALUES (330, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 20:00:35');
INSERT INTO `sys_log` VALUES (331, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-09 20:00:45');
INSERT INTO `sys_log` VALUES (332, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:28:32');
INSERT INTO `sys_log` VALUES (333, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:28:37');
INSERT INTO `sys_log` VALUES (334, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:32:01');
INSERT INTO `sys_log` VALUES (335, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:32:04');
INSERT INTO `sys_log` VALUES (336, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:34:29');
INSERT INTO `sys_log` VALUES (337, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:38:00');
INSERT INTO `sys_log` VALUES (338, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:38:04');
INSERT INTO `sys_log` VALUES (339, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:40:33');
INSERT INTO `sys_log` VALUES (340, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:40:37');
INSERT INTO `sys_log` VALUES (341, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:45:11');
INSERT INTO `sys_log` VALUES (342, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:45:13');
INSERT INTO `sys_log` VALUES (343, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:46:16');
INSERT INTO `sys_log` VALUES (344, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:46:19');
INSERT INTO `sys_log` VALUES (345, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:46:29');
INSERT INTO `sys_log` VALUES (346, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:46:35');
INSERT INTO `sys_log` VALUES (347, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:46:41');
INSERT INTO `sys_log` VALUES (348, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:49:54');
INSERT INTO `sys_log` VALUES (349, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:49:58');
INSERT INTO `sys_log` VALUES (350, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:56:34');
INSERT INTO `sys_log` VALUES (351, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 21:56:37');
INSERT INTO `sys_log` VALUES (352, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:00:47');
INSERT INTO `sys_log` VALUES (353, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:02:28');
INSERT INTO `sys_log` VALUES (354, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:03:18');
INSERT INTO `sys_log` VALUES (355, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:03:24');
INSERT INTO `sys_log` VALUES (356, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:03:51');
INSERT INTO `sys_log` VALUES (357, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:03:56');
INSERT INTO `sys_log` VALUES (358, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:04:00');
INSERT INTO `sys_log` VALUES (359, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:04:36');
INSERT INTO `sys_log` VALUES (360, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:12:01');
INSERT INTO `sys_log` VALUES (361, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:12:01');
INSERT INTO `sys_log` VALUES (362, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:12:01');
INSERT INTO `sys_log` VALUES (363, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:12:05');
INSERT INTO `sys_log` VALUES (364, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:14:47');
INSERT INTO `sys_log` VALUES (365, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:14:51');
INSERT INTO `sys_log` VALUES (366, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:15:04');
INSERT INTO `sys_log` VALUES (367, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-06-15 22:15:21');
INSERT INTO `sys_log` VALUES (368, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:15:03');
INSERT INTO `sys_log` VALUES (369, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:16:16');
INSERT INTO `sys_log` VALUES (370, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:16:25');
INSERT INTO `sys_log` VALUES (371, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:37');
INSERT INTO `sys_log` VALUES (372, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:41');
INSERT INTO `sys_log` VALUES (373, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:45');
INSERT INTO `sys_log` VALUES (374, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:47');
INSERT INTO `sys_log` VALUES (375, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:49');
INSERT INTO `sys_log` VALUES (376, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:56');
INSERT INTO `sys_log` VALUES (377, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:30:59');
INSERT INTO `sys_log` VALUES (378, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:31:45');
INSERT INTO `sys_log` VALUES (379, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:31:50');
INSERT INTO `sys_log` VALUES (380, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:32:32');
INSERT INTO `sys_log` VALUES (381, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:34:28');
INSERT INTO `sys_log` VALUES (382, '用户新增', 'com.FreightForwarding.controller.SysUserController.userAddConfirm()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:34:40');
INSERT INTO `sys_log` VALUES (383, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:34:43');
INSERT INTO `sys_log` VALUES (384, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:34:58');
INSERT INTO `sys_log` VALUES (385, '用户修改', 'com.FreightForwarding.controller.SysUserController.userAmdConfirm()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:35:05');
INSERT INTO `sys_log` VALUES (386, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:35:07');
INSERT INTO `sys_log` VALUES (387, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:35:15');
INSERT INTO `sys_log` VALUES (388, '用户删除', 'com.FreightForwarding.controller.SysUserController.userDel()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:35:18');
INSERT INTO `sys_log` VALUES (389, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:35:19');
INSERT INTO `sys_log` VALUES (390, '日志列表', 'com.FreightForwarding.controller.SysLogController.logList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:36:25');
INSERT INTO `sys_log` VALUES (391, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2020-08-28 14:36:32');
INSERT INTO `sys_log` VALUES (392, '用户登录', 'com.FreightForwarding.controller.LoginController.welcome()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2021-05-10 11:21:17');
INSERT INTO `sys_log` VALUES (393, '用户列表', 'com.FreightForwarding.controller.SysUserController.userList()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2021-05-10 11:21:24');
INSERT INTO `sys_log` VALUES (394, '安全退出', 'com.FreightForwarding.controller.LoginController.close()', 0, '127.0.0.1', NULL, NULL, NULL, NULL, 1, '2021-05-10 11:22:43');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menuId` int(11) NOT NULL AUTO_INCREMENT,
  `pmenuId` int(11) NULL DEFAULT NULL,
  `menuName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuDesc` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuIcon` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menuAction` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`menuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, '系统管理', '系统管理', 'icon-settings', '', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (2, 1, '用户管理', '用户管理', 'icon-users', '/sysUserController/userIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (3, 2, '用户管理-新增', '用户管理-新增', 'insertBtn', '/sysUserController/userAdd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (4, 2, '用户管理-修改', '用户管理-修改', 'updateBtn', '/sysUserController/userAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (5, 2, '用户管理-删除', '用户管理-删除', 'deleteBtn', '/sysUserController/userDel', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (6, 2, '用户管理-初始化', '用户管理-初始化', 'initializeBtn', '/sysUserController/userPas', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (7, 1, '角色管理', '角色管理', 'icon-grid', '/sysRoleController/roleIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (8, 7, '角色管理-新增', '角色管理-新增', 'insertBtn', '/sysRoleController/roleAdd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (9, 7, '角色管理-修改', '角色管理-修改', 'updateBtn', '/sysRoleController/roleAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (10, 7, '角色管理-删除', '角色管理-删除', 'deleteBtn', '/sysRoleController/roleDel', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (11, 1, '机构管理', '机构管理', 'icon-share', '/sysOrgController/orgIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (12, 11, '机构管理-新增', '机构管理-新增', 'insertBtn', '/sysOrgController/orgAdd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (13, 11, '机构管理-修改', '机构管理-修改', 'updateBtn', '/sysOrgController/orgAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (14, 11, '机构管理-删除', '机构管理-删除', 'deleteBtn', '/sysOrgController/orgDel', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (15, 11, '机构管理-成员查询', '机构管理-成员查询', 'searchBtn', '/sysOrgController/userSearch', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (16, 11, '机构管理-成员移入', '机构管理-成员移入', 'inBtn', '/sysOrgController/userIn', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (17, 11, '机构管理-成员移出', '机构管理-成员移出', 'outBtn', '/sysOrgController/userOut', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (18, 1, '日志管理', '日志管理', 'icon-calendar', '/sysLogController/logIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (19, 0, '账户中心', '账户中心', 'icon-credit-card', '', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (20, 19, '账户信息', '账户信息', 'icon-heart', '/custAccountController/custAccount', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (21, 20, '账户信息-修改', '账户信息-修改', 'updateBtn', '/custAccountController/custAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (22, 20, '账户信息-转账', '账户信息-转账', 'transfer', '/custAccountController/custTransfer', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (23, 20, '账户信息-提现', '账户信息-提现', 'cash', '/custAccountController/custCash', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (24, 20, '账户信息-历史', '账户信息-历史', 'history', '/custAccountController/custHis', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (25, 19, '交易复核', '交易复核', 'icon-check', '/custAccountController/custBusiness', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (26, 25, '交易复核-转账', '交易复核-转账', 'transfer', '/custAccountController/custTransferCheck', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (27, 25, '交易复核-提现', '交易复核-提现', 'cash', '/custAccountController/custCashCheck', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (28, 19, '资金交易', '资金交易', 'icon-star', '/capitalController/capitalIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (29, 28, '资金交易-提现确认', '资金交易-提现确认', 'cash', '/capitalController/capitalCash', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (30, 28, '资金交易-保理收款', '资金交易-保理收款', 'received', '/capitalController/capitalFactorReceived', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (31, 28, '资金交易-贷款偿还', '资金交易-贷款偿还', 'payment', '/capitalController/capitalLoanPayment', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (32, 0, '合同中心', '合同中心', 'icon-layers', '', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (33, 32, '保理合同', '保理合同', 'icon-book-open', '/factorController/factorIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (34, 33, '保理合同-录入', '保理合同-录入', 'insertBtn', '/factorController/factorAdd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (35, 33, '保理合同-修改', '保理合同-修改', 'updateBtn', '/factorController/factorAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (36, 33, '保理合同-删除', '保理合同-删除', 'deleteBtn', '/factorController/factorDel', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (37, 33, '保理合同-录入复核', '保理合同-录入复核', 'addCheck', '/factorController/factorAddCheck', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (38, 33, '保理合同-质押', '保理合同-质押', 'factorLoan', '/factorController/factorLoan', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (39, 33, '保理合同-质押复核', '保理合同-质押复核', 'loanCheck', '/factorController/factorLoanCheck', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (40, 33, '保理合同-质押放款', '保理合同-质押放款', 'loanAction', '/factorController/factorLoanAct', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (41, 33, '保理合同-合同执行', '保理合同-合同执行', 'factorAction', '/factorController/factorAct', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (42, 0, '运维中心', '运维中心', 'icon-wrench', '', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (43, 42, '手续费设置', '手续费设置', 'icon-calculator', '/rateController/rateIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (44, 43, '手续费-新增', '手续费-新增', 'insertBtn', '/rateController/rateAdd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (45, 43, '手续费-修改', '手续费-修改', 'updateBtn', '/rateController/rateAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (46, 43, '手续费-删除', '手续费-删除', 'deleteBtn', '/rateController/rateDel', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (47, 42, '企业信息认证', '企业信息认证', 'icon-eye', '/companyController/companyIndex', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (48, 47, '企业认证-新增', '企业认证-新增', 'insertBtn', '/companyController/companyAdd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (49, 47, '企业认证-修改', '企业认证-修改', 'updateBtn', '/companyController/companyAmd', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (50, 47, '企业认证-删除', '企业认证-删除', 'deleteBtn', '/companyController/companyDel', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (51, 47, '企业认证-审核', '企业认证-审核', 'checkBtn', '/companyController/companyCheck', 1, NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (52, 42, '资金追踪', '资金追踪', 'icon-search', '/custAmtController/custAmtIndex', 1, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_org`;
CREATE TABLE `sys_org`  (
  `orgId` int(11) NOT NULL AUTO_INCREMENT,
  `porgId` int(11) NULL DEFAULT NULL,
  `orgCode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orgName` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `orgDesc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`orgId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织机构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_org
-- ----------------------------
INSERT INTO `sys_org` VALUES (1, 0, '914403003600521031', '招银云创(深圳)信息技术有限公司', '招银云创(深圳)信息技术有限公司', 1, 1, '2017-06-25 13:22:51', NULL, NULL);
INSERT INTO `sys_org` VALUES (2, 0, '91440300360052XXX1', 'XXXX保理有限公司', 'XXXX保理有限公司', 1, 1, '2017-06-25 13:55:16', NULL, NULL);
INSERT INTO `sys_org` VALUES (3, 0, '91440300360052XXX2', 'XXXX核心企业', 'XXXX核心企业', 1, 1, '2017-06-25 13:55:27', NULL, NULL);
INSERT INTO `sys_org` VALUES (4, 0, '91440300360052XXX3', 'XXXX供应商', 'XXXX供应商', 1, 1, '2017-06-25 13:55:38', NULL, NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `roleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `roleName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `roleDesc` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理员', '系统管理员', 1, NULL, NULL, 1, '2017-11-23 15:43:10');
INSERT INTO `sys_role` VALUES (2, '保理公司', '保理公司', 1, 1, '2017-06-02 22:32:29', 1, '2017-06-25 11:54:35');
INSERT INTO `sys_role` VALUES (21, '运维平台', '运维平台', 1, 1, '2017-06-20 17:13:26', 1, '2017-06-26 15:25:20');
INSERT INTO `sys_role` VALUES (22, '核心企业', '核心企业', 1, 1, '2017-06-20 17:13:38', 1, '2017-06-25 11:55:01');
INSERT INTO `sys_role` VALUES (23, '供应商', '供应商', 1, 1, '2017-06-20 17:13:49', 1, '2017-06-25 11:55:09');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `roleMenuId` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) NULL DEFAULT NULL,
  `menuId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`roleMenuId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 271 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (52, 2, 19, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (53, 2, 20, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (54, 2, 21, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (55, 2, 22, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (56, 2, 23, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (57, 2, 24, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (58, 2, 25, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (59, 2, 26, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (60, 2, 27, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (61, 2, 28, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (62, 2, 29, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (63, 2, 30, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (64, 2, 31, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (65, 2, 32, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (66, 2, 33, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (67, 2, 34, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (68, 2, 35, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (69, 2, 36, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (70, 2, 37, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (71, 2, 38, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (72, 2, 39, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (73, 2, 40, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (74, 2, 41, 1, 1, '2017-06-25 11:54:36', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (94, 22, 19, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (95, 22, 20, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (96, 22, 21, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (97, 22, 22, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (98, 22, 23, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (99, 22, 24, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (100, 22, 25, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (101, 22, 26, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (102, 22, 27, 1, 1, '2017-06-25 11:55:01', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (103, 23, 19, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (104, 23, 20, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (105, 23, 21, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (106, 23, 22, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (107, 23, 23, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (108, 23, 24, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (109, 23, 25, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (110, 23, 26, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (111, 23, 27, 1, 1, '2017-06-25 11:55:09', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (112, 21, 19, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (113, 21, 20, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (114, 21, 21, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (115, 21, 22, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (116, 21, 23, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (117, 21, 24, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (118, 21, 25, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (119, 21, 26, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (120, 21, 27, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (121, 21, 42, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (122, 21, 43, 1, 1, '2017-06-26 15:25:20', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (123, 21, 44, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (124, 21, 45, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (125, 21, 46, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (126, 21, 47, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (127, 21, 48, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (128, 21, 49, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (129, 21, 50, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (130, 21, 51, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (131, 21, 52, 1, 1, '2017-06-26 15:25:21', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (219, 1, 1, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (220, 1, 2, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (221, 1, 3, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (222, 1, 4, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (223, 1, 5, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (224, 1, 6, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (225, 1, 7, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (226, 1, 8, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (227, 1, 9, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (228, 1, 10, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (229, 1, 11, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (230, 1, 12, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (231, 1, 13, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (232, 1, 14, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (233, 1, 15, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (234, 1, 16, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (235, 1, 17, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (236, 1, 18, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (237, 1, 19, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (238, 1, 20, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (239, 1, 21, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (240, 1, 22, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (241, 1, 23, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (242, 1, 24, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (243, 1, 25, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (244, 1, 26, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (245, 1, 27, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (246, 1, 28, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (247, 1, 29, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (248, 1, 30, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (249, 1, 31, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (250, 1, 32, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (251, 1, 33, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (252, 1, 34, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (253, 1, 35, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (254, 1, 36, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (255, 1, 37, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (256, 1, 38, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (257, 1, 39, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (258, 1, 40, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (259, 1, 41, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (260, 1, 42, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (261, 1, 43, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (262, 1, 44, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (263, 1, 45, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (264, 1, 46, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (265, 1, 47, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (266, 1, 48, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (267, 1, 49, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (268, 1, 50, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (269, 1, 51, 1, 1, '2017-11-23 15:43:10', NULL, NULL);
INSERT INTO `sys_role_menu` VALUES (270, 1, 52, 1, 1, '2017-11-23 15:43:10', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `loginName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `passwd` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `userCode` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `userName` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `mobileNo` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `eMail` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `picPath` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `roleId` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态',
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '96e79218965eb72c92a549dd5a330112', '', '陈印', '男', '18202128391', 'chenyin@mbcloud.com', '上海市静安区', 'Upload\\userImg\\1\\userPic.jpeg', 1, 1, NULL, NULL, 1, '2019-10-01 14:42:14');
INSERT INTO `sys_user` VALUES (2, 'ZYYC01', '96e79218965eb72c92a549dd5a330112', '', '云创操作员', '男', '13800000001', 'ZYYC01@qq.com', '上海市浦东新区瑞昌路385号A区5楼', NULL, 21, 1, 1, '2017-06-25 13:22:51', 2, '2017-06-25 14:15:31');
INSERT INTO `sys_user` VALUES (3, 'ZYYC02', '96e79218965eb72c92a549dd5a330112', '', '云创复核员', '女', '13800000002', 'ZYYC02@qq.com', '上海市浦东新区瑞昌路385号A区5楼', NULL, 21, 1, 1, '2017-06-25 13:22:51', NULL, NULL);
INSERT INTO `sys_user` VALUES (4, 'BLGS01', '96e79218965eb72c92a549dd5a330112', '', '保理操作员', '男', '13900000001', 'BLGS01@qq.com', '上海市浦东新区XXXX', 'Upload\\userImg\\4\\userPic.jpeg', 2, 1, 1, '2017-06-25 13:55:16', 4, '2017-06-25 18:28:13');
INSERT INTO `sys_user` VALUES (5, 'BLGS02', '96e79218965eb72c92a549dd5a330112', '', '保理审核员', '女', '13900000002', 'BLGS02@qq.com', '上海市浦东新区XXXX', NULL, 2, 1, 1, '2017-06-25 13:55:16', NULL, NULL);
INSERT INTO `sys_user` VALUES (6, 'HXQY01', '96e79218965eb72c92a549dd5a330112', '', '央企操作员', '男', '13700000001', 'HXQY01@qq.com', '上海市浦东新区XXXX', NULL, 22, 1, 1, '2017-06-25 13:55:27', NULL, NULL);
INSERT INTO `sys_user` VALUES (7, 'HXQY02', '96e79218965eb72c92a549dd5a330112', '', '央企审核员', '女', '13700000002', 'HXQY02@qq.com', '上海市浦东新区XXXX', NULL, 22, 1, 1, '2017-06-25 13:55:27', NULL, NULL);
INSERT INTO `sys_user` VALUES (8, 'GYS01', '96e79218965eb72c92a549dd5a330112', '', '供应商操作员', '男', '13700000001', 'GYS01@qq.com', '上海市浦东新区XXXX', NULL, 23, 1, 1, '2017-06-25 13:55:39', NULL, NULL);
INSERT INTO `sys_user` VALUES (9, 'GYS02', '96e79218965eb72c92a549dd5a330112', '', '供应商审核员', '女', '13900000002', 'GYS02@qq.com', '上海市浦东新区XXXX', NULL, 23, 1, 1, '2017-06-25 13:55:39', NULL, NULL);
INSERT INTO `sys_user` VALUES (10, '123123', 'e10adc3949ba59abbe56e057f20f883e', '', '123123', '男', '1123123', '123123', '12312', NULL, 1, 0, 1, '2020-08-28 14:34:40', 1, '2020-08-28 14:35:18');

-- ----------------------------
-- Table structure for sys_user_org
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_org`;
CREATE TABLE `sys_user_org`  (
  `userOrgId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NULL DEFAULT NULL,
  `orgId` int(11) NULL DEFAULT NULL,
  `status` int(2) NULL DEFAULT NULL,
  `crtOptr` int(11) NULL DEFAULT NULL COMMENT '新增用户',
  `crtTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增日期',
  `modOptr` int(11) NULL DEFAULT NULL COMMENT '修改用户',
  `modTime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`userOrgId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户机构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_org
-- ----------------------------
INSERT INTO `sys_user_org` VALUES (1, 2, 1, 1, 1, '2017-06-25 13:22:51', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (2, 3, 1, 1, 1, '2017-06-25 13:22:51', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (3, 1, 1, 1, 1, '2017-06-25 13:29:52', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (4, 4, 2, 1, 1, '2017-06-25 13:55:16', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (5, 5, 2, 1, 1, '2017-06-25 13:55:16', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (6, 6, 3, 1, 1, '2017-06-25 13:55:27', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (7, 7, 3, 1, 1, '2017-06-25 13:55:27', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (8, 8, 4, 1, 1, '2017-06-25 13:55:39', NULL, NULL);
INSERT INTO `sys_user_org` VALUES (9, 9, 4, 1, 1, '2017-06-25 13:55:39', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
