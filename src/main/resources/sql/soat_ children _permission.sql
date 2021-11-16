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

 Date: 16/11/2021 23:59:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for soat_ children _permission
-- ----------------------------
DROP TABLE IF EXISTS `soat_ children _permission`;
CREATE TABLE `soat_ children _permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of soat_ children _permission
-- ----------------------------
BEGIN;
INSERT INTO `soat_ children _permission` VALUES (1, 'sys:p:create', '新增接口', 2);
INSERT INTO `soat_ children _permission` VALUES (2, 'sys:p:update', '修改接口', 2);
INSERT INTO `soat_ children _permission` VALUES (3, 'sys:p:delete', '删除接口', 2);
INSERT INTO `soat_ children _permission` VALUES (4, 'sys:p:check', '查看接口', 2);
INSERT INTO `soat_ children _permission` VALUES (5, 'sys:inter:create', '新增缺陷', 3);
INSERT INTO `soat_ children _permission` VALUES (6, 'sys:inter:update', '修改缺陷', 3);
INSERT INTO `soat_ children _permission` VALUES (7, 'sys:inter:check', '查看接口', 3);
INSERT INTO `soat_ children _permission` VALUES (8, 'sys:inter:delete', '删除缺陷', 3);
INSERT INTO `soat_ children _permission` VALUES (10, 'sys:rp:add', '添加角色', 9);
INSERT INTO `soat_ children _permission` VALUES (11, 'sys:rp:edit', '编辑角色', 9);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
