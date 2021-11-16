/*
 Navicat MySQL Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : soat

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 16/11/2021 23:59:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for soat_permission
-- ----------------------------
DROP TABLE IF EXISTS `soat_permission`;
CREATE TABLE `soat_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of soat_permission
-- ----------------------------
BEGIN;
INSERT INTO `soat_permission` VALUES (1, 'sys:rp', '权限管理');
INSERT INTO `soat_permission` VALUES (2, 'sys:inter', '接口管理');
INSERT INTO `soat_permission` VALUES (3, 'sys:suite', '项目管理');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
