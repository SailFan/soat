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

 Date: 17/11/2021 00:00:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for soat_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `soat_roles_permissions`;
CREATE TABLE `soat_roles_permissions` (
  `r_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`r_id`,`p_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of soat_roles_permissions
-- ----------------------------
BEGIN;
INSERT INTO `soat_roles_permissions` VALUES (1, 1);
INSERT INTO `soat_roles_permissions` VALUES (1, 2);
INSERT INTO `soat_roles_permissions` VALUES (2, 1);
INSERT INTO `soat_roles_permissions` VALUES (3, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
