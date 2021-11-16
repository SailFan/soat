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

 Date: 16/11/2021 23:59:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for soat_roles
-- ----------------------------
DROP TABLE IF EXISTS `soat_roles`;
CREATE TABLE `soat_roles` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of soat_roles
-- ----------------------------
BEGIN;
INSERT INTO `soat_roles` VALUES (1, 'admin');
INSERT INTO `soat_roles` VALUES (2, 'guest');
INSERT INTO `soat_roles` VALUES (3, 'dev');
INSERT INTO `soat_roles` VALUES (4, 'pm');
INSERT INTO `soat_roles` VALUES (5, 'opt');
INSERT INTO `soat_roles` VALUES (6, 'qa');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
