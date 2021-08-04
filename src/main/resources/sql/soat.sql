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

 Date: 04/08/2021 23:23:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for soat_permission
-- ----------------------------
DROP TABLE IF EXISTS `soat_permission`;
CREATE TABLE `soat_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of soat_permission
-- ----------------------------
BEGIN;
INSERT INTO `soat_permission` VALUES (1, 'sys:p:create', '新增项目');
INSERT INTO `soat_permission` VALUES (2, 'sys:p:update', '修改项目');
INSERT INTO `soat_permission` VALUES (3, 'sys:p:delete', '删除项目');
INSERT INTO `soat_permission` VALUES (4, 'sys:p:check', '查看项目');
INSERT INTO `soat_permission` VALUES (5, 'sys:b:create', '新增缺陷');
INSERT INTO `soat_permission` VALUES (6, 'sys:b:update', '修改缺陷');
INSERT INTO `soat_permission` VALUES (7, 'sys:b:check', '查看缺陷');
INSERT INTO `soat_permission` VALUES (8, 'sys:b:delete', '删除缺陷');
COMMIT;

-- ----------------------------
-- Table structure for soat_project
-- ----------------------------
DROP TABLE IF EXISTS `soat_project`;
CREATE TABLE `soat_project` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `create_date` datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  `forbidden` int(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `project_version` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `test_principal` varchar(255) DEFAULT NULL,
  `dev_principal` varchar(255) DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for soat_roles
-- ----------------------------
DROP TABLE IF EXISTS `soat_roles`;
CREATE TABLE `soat_roles` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

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

-- ----------------------------
-- Table structure for soat_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `soat_roles_permissions`;
CREATE TABLE `soat_roles_permissions` (
  `r_id` int(50) NOT NULL,
  `p_id` int(50) NOT NULL,
  PRIMARY KEY (`r_id`,`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of soat_roles_permissions
-- ----------------------------
BEGIN;
INSERT INTO `soat_roles_permissions` VALUES (1, 1);
INSERT INTO `soat_roles_permissions` VALUES (1, 2);
INSERT INTO `soat_roles_permissions` VALUES (1, 3);
INSERT INTO `soat_roles_permissions` VALUES (1, 4);
INSERT INTO `soat_roles_permissions` VALUES (1, 5);
INSERT INTO `soat_roles_permissions` VALUES (1, 6);
INSERT INTO `soat_roles_permissions` VALUES (1, 7);
INSERT INTO `soat_roles_permissions` VALUES (1, 8);
INSERT INTO `soat_roles_permissions` VALUES (2, 4);
INSERT INTO `soat_roles_permissions` VALUES (2, 7);
INSERT INTO `soat_roles_permissions` VALUES (3, 4);
INSERT INTO `soat_roles_permissions` VALUES (3, 7);
INSERT INTO `soat_roles_permissions` VALUES (6, 4);
INSERT INTO `soat_roles_permissions` VALUES (6, 5);
INSERT INTO `soat_roles_permissions` VALUES (6, 6);
INSERT INTO `soat_roles_permissions` VALUES (6, 7);
INSERT INTO `soat_roles_permissions` VALUES (6, 8);
COMMIT;

-- ----------------------------
-- Table structure for soat_set
-- ----------------------------
DROP TABLE IF EXISTS `soat_set`;
CREATE TABLE `soat_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_time` datetime(6) NOT NULL,
  `update_time` datetime(6) NOT NULL,
  `creater` varchar(255) NOT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `base_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of soat_set
-- ----------------------------
BEGIN;
INSERT INTO `soat_set` VALUES (2, '测试集二', '2021-08-01 02:32:02.167000', '2021-08-01 02:32:02.167000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (4, '测试集二', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (5, '测试集二', '2021-08-01 02:55:26.389000', '2021-08-01 02:55:26.389000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (6, '测试集二', '2021-08-01 02:56:22.295000', '2021-08-01 02:56:22.295000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (7, '测试集二', '2021-08-01 10:58:11.374000', '2021-08-01 10:58:11.374000', '刘文凡', '刘文凡', 'http://www.baidu.com');
COMMIT;

-- ----------------------------
-- Table structure for soat_users
-- ----------------------------
DROP TABLE IF EXISTS `soat_users`;
CREATE TABLE `soat_users` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of soat_users
-- ----------------------------
BEGIN;
INSERT INTO `soat_users` VALUES (2, '张晨', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'zhangchen', 'afan6203@126.com');
INSERT INTO `soat_users` VALUES (3, '刘文凡', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'liuwenfan', 'afan6203@126.com');
INSERT INTO `soat_users` VALUES (4, '熊佳牧', 'a3eb67417ed506a6e7800f3236b6f85c', '123456', 'xiongjiamu', 'afan6203@126.com');
INSERT INTO `soat_users` VALUES (5, '团子', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'tuanzi', 'afan6203@126.com');
INSERT INTO `soat_users` VALUES (6, '贾振东', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'jiazhendong', 'afan6203@126.com');
COMMIT;

-- ----------------------------
-- Table structure for soat_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `soat_users_roles`;
CREATE TABLE `soat_users_roles` (
  `u_id` int(50) NOT NULL,
  `r_id` int(50) NOT NULL,
  PRIMARY KEY (`u_id`,`r_id`),
  KEY `r_id_f` (`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of soat_users_roles
-- ----------------------------
BEGIN;
INSERT INTO `soat_users_roles` VALUES (2, 1);
INSERT INTO `soat_users_roles` VALUES (6, 3);
INSERT INTO `soat_users_roles` VALUES (4, 4);
INSERT INTO `soat_users_roles` VALUES (5, 5);
INSERT INTO `soat_users_roles` VALUES (2, 6);
INSERT INTO `soat_users_roles` VALUES (3, 6);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
