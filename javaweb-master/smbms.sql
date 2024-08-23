/*
 Navicat Premium Data Transfer

 Source Server         : wuduan
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : smbms

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 03/03/2022 21:11:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for smbms_bill
-- ----------------------------
DROP TABLE IF EXISTS `smbms_bill`;
CREATE TABLE `smbms_bill`  (
  `id` int(11) NOT NULL,
  `billCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productUnit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `produtCount` decimal(10, 2) NULL DEFAULT NULL,
  `totalPrice` decimal(10, 2) NULL DEFAULT NULL,
  `isPayment` int(11) NULL DEFAULT NULL,
  `providerId` int(11) NULL DEFAULT NULL,
  `createdBy` int(11) NULL DEFAULT NULL,
  `creationDate` date NULL DEFAULT NULL,
  `modifyBy` int(11) NULL DEFAULT NULL,
  `modifyDate` date NULL DEFAULT NULL,
  `providerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for smbms_provider
-- ----------------------------
DROP TABLE IF EXISTS `smbms_provider`;
CREATE TABLE `smbms_provider`  (
  `id` int(11) NOT NULL,
  `proCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proDesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proContact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `proFax` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createBy` int(11) NULL DEFAULT NULL,
  `creationDate` date NULL DEFAULT NULL,
  `modifyBy` int(255) NULL DEFAULT NULL,
  `modifyDate` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for smbms_role
-- ----------------------------
DROP TABLE IF EXISTS `smbms_role`;
CREATE TABLE `smbms_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `createdBy` int(11) NULL DEFAULT NULL,
  `creationDate` date NULL DEFAULT NULL,
  `modifyBy` int(11) NULL DEFAULT NULL,
  `modifyDate` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smbms_role
-- ----------------------------
INSERT INTO `smbms_role` VALUES (1, '1', '管理员', 1, '2022-02-24', 1, '2022-02-18');
INSERT INTO `smbms_role` VALUES (2, '2', '菜鸟', 1, '2022-02-09', 1, '2022-02-22');
INSERT INTO `smbms_role` VALUES (3, '3', '用户', 1, '2022-02-23', 1, '2022-02-21');

-- ----------------------------
-- Table structure for smbms_user
-- ----------------------------
DROP TABLE IF EXISTS `smbms_user`;
CREATE TABLE `smbms_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` int(11) NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userRole` int(11) NULL DEFAULT NULL,
  `createBy` int(10) NULL DEFAULT NULL,
  `creationDate` date NULL DEFAULT NULL,
  `modifyBy` int(10) NULL DEFAULT NULL,
  `modifyDate` date NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `userRoleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smbms_user
-- ----------------------------
INSERT INTO `smbms_user` VALUES (1, 'admin', '钟吾褍', '123456', 1, '2022-02-17', '11111111', '福建', 1, 1, '2022-02-24', 1, '2022-02-11', 19, '管理员');
INSERT INTO `smbms_user` VALUES (2, 'user', '普通用户', '123456', 1, '2022-02-26', '2222222', '福建', 2, 1, '2022-02-04', 1, '2022-02-23', 20, '菜鸟');
INSERT INTO `smbms_user` VALUES (3, 'user2', 'user2', '123456', 2, '2022-02-26', '33333', '福建', 2, 1, '2022-02-17', 1, '2022-02-02', 19, '菜鸟');

SET FOREIGN_KEY_CHECKS = 1;
