/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : lost_found

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 26/05/2019 22:24:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for lost_item
-- ----------------------------
DROP TABLE IF EXISTS `lost_item`;
CREATE TABLE `lost_item`  (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Photo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `QQ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Release_time` datetime(0) NULL DEFAULT NULL,
  `Item_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lost_item
-- ----------------------------
INSERT INTO `lost_item` VALUES (1, '三生三世', '132', '3321', 'asd', NULL, 'asd');

-- ----------------------------
-- Table structure for lost_photo_data
-- ----------------------------
DROP TABLE IF EXISTS `lost_photo_data`;
CREATE TABLE `lost_photo_data`  (
  `Id` int(4) NOT NULL,
  `Photo` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pick_photo_data
-- ----------------------------
DROP TABLE IF EXISTS `pick_photo_data`;
CREATE TABLE `pick_photo_data`  (
  `Id` int(4) NULL DEFAULT NULL,
  `Photo` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for pick_up_items
-- ----------------------------
DROP TABLE IF EXISTS `pick_up_items`;
CREATE TABLE `pick_up_items`  (
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  `Description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Photo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `QQ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Openid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Release_time` datetime(0) NULL DEFAULT NULL,
  `Item_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `Openid` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Gender` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Phone` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `QQ` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Openid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
