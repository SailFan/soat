/*
 Navicat MySQL Data Transfer

 Source Server         : 本机mysql数据库
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : soat

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 29/10/2021 20:01:32
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for soat_interface
-- ----------------------------
DROP TABLE IF EXISTS `soat_interface`;
CREATE TABLE `soat_interface`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `run` int NULL DEFAULT NULL,
  `headers` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `set_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_interface
-- ----------------------------
INSERT INTO `soat_interface` VALUES (1, '百度查询', 'https://www.w3school.com.cn/python/python_getstarted.asp', 'get', NULL, 0, NULL, 1);
INSERT INTO `soat_interface` VALUES (2, '查询经销商', 'http://www.baidu.com', 'GET', '{\'name\':\'111\',\'pppp\':\'333333\'}', 0, '{\'Content-Type\':\'application/json\'}', NULL);

-- ----------------------------
-- Table structure for soat_nav
-- ----------------------------
DROP TABLE IF EXISTS `soat_nav`;
CREATE TABLE `soat_nav`  (
  `id` int NOT NULL,
  `nav_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int NULL DEFAULT NULL,
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_nav
-- ----------------------------
INSERT INTO `soat_nav` VALUES (1, '接口管理', 0, '/lei2');
INSERT INTO `soat_nav` VALUES (2, '测试导航一', 0, '/lei2');
INSERT INTO `soat_nav` VALUES (3, '测试导航二', 0, '/lei2');
INSERT INTO `soat_nav` VALUES (4, '测试导航三', 0, '/lei2');
INSERT INTO `soat_nav` VALUES (5, '系统设置', 0, '/lei2');
INSERT INTO `soat_nav` VALUES (6, '导航一分类一', 2, '/lei2');
INSERT INTO `soat_nav` VALUES (7, '导航一分类二', 2, '/lei1');
INSERT INTO `soat_nav` VALUES (8, '用户管理', 5, '/users');

-- ----------------------------
-- Table structure for soat_permission
-- ----------------------------
DROP TABLE IF EXISTS `soat_permission`;
CREATE TABLE `soat_permission`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_permission
-- ----------------------------
INSERT INTO `soat_permission` VALUES (1, 'sys:p:create', '新增项目');
INSERT INTO `soat_permission` VALUES (2, 'sys:p:update', '修改项目');
INSERT INTO `soat_permission` VALUES (3, 'sys:p:delete', '删除项目');
INSERT INTO `soat_permission` VALUES (4, 'sys:p:check', '查看项目');
INSERT INTO `soat_permission` VALUES (5, 'sys:b:create', '新增缺陷');
INSERT INTO `soat_permission` VALUES (6, 'sys:b:update', '修改缺陷');
INSERT INTO `soat_permission` VALUES (7, 'sys:b:check', '查看缺陷');
INSERT INTO `soat_permission` VALUES (8, 'sys:b:delete', '删除缺陷');

-- ----------------------------
-- Table structure for soat_project
-- ----------------------------
DROP TABLE IF EXISTS `soat_project`;
CREATE TABLE `soat_project`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_date` datetime(6) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),
  `forbidden` int NULL DEFAULT NULL,
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `test_principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dev_principal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `project_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `start_time` datetime(6) NULL DEFAULT NULL,
  `end_time` datetime(6) NULL DEFAULT NULL,
  `priority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_project
-- ----------------------------

-- ----------------------------
-- Table structure for soat_roles
-- ----------------------------
DROP TABLE IF EXISTS `soat_roles`;
CREATE TABLE `soat_roles`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_roles
-- ----------------------------
INSERT INTO `soat_roles` VALUES (1, 'admin');
INSERT INTO `soat_roles` VALUES (2, 'guest');
INSERT INTO `soat_roles` VALUES (3, 'dev');
INSERT INTO `soat_roles` VALUES (4, 'pm');
INSERT INTO `soat_roles` VALUES (5, 'opt');
INSERT INTO `soat_roles` VALUES (6, 'qa');

-- ----------------------------
-- Table structure for soat_roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `soat_roles_permissions`;
CREATE TABLE `soat_roles_permissions`  (
  `r_id` int NOT NULL,
  `p_id` int NOT NULL,
  PRIMARY KEY (`r_id`, `p_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_roles_permissions
-- ----------------------------
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

-- ----------------------------
-- Table structure for soat_set
-- ----------------------------
DROP TABLE IF EXISTS `soat_set`;
CREATE TABLE `soat_set`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(6) NOT NULL,
  `update_time` datetime(6) NOT NULL,
  `creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `updater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `base_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_set
-- ----------------------------
INSERT INTO `soat_set` VALUES (2, '测试集二', '2021-08-01 02:32:02.167000', '2021-08-01 02:32:02.167000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (4, '测试集二', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (5, '测试集二', '2021-08-01 02:55:26.389000', '2021-08-01 02:55:26.389000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (6, '测试集二', '2021-08-01 02:56:22.295000', '2021-08-01 02:56:22.295000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (7, '测试集二', '2021-08-01 10:58:11.374000', '2021-08-01 10:58:11.374000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (8, '测试集7', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (9, '测试集8', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (10, '测试集9', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (11, '测试集10', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (12, '测试集11', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (13, '测试集12', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (14, '测试集13', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (15, '测试集14', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (16, '测试集15', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');
INSERT INTO `soat_set` VALUES (17, '测试集16', '2021-08-01 02:30:21.171000', '2021-08-01 02:30:21.171000', '刘文凡', '刘文凡', 'http://www.baidu.com');

-- ----------------------------
-- Table structure for soat_users
-- ----------------------------
DROP TABLE IF EXISTS `soat_users`;
CREATE TABLE `soat_users`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `status` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_users
-- ----------------------------
INSERT INTO `soat_users` VALUES (2, '系统管理员', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'admin', 'afan6203@126.com', '超级管理员', '13893887430', 1);
INSERT INTO `soat_users` VALUES (3, '刘文凡', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'liyuanfang', 'afan6204@126.com', '测试人员', NULL, 0);
INSERT INTO `soat_users` VALUES (4, '杜煌', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'dev', 'afan6205@126.com', '开发人员', NULL, 1);
INSERT INTO `soat_users` VALUES (5, '杨树军', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'opt', 'afan6206@126.com', '运维人员', NULL, 1);
INSERT INTO `soat_users` VALUES (6, '张楠', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'pm', 'afan6207@126.com', '产品经理', NULL, 1);
INSERT INTO `soat_users` VALUES (20, '张大晨', 'a3eb67417ed506a6e7800f3236b6f85c', 'soat', 'zhan', 'afan33@163.com', '', '18899900011', 1);

-- ----------------------------
-- Table structure for soat_users_roles
-- ----------------------------
DROP TABLE IF EXISTS `soat_users_roles`;
CREATE TABLE `soat_users_roles`  (
  `u_id` int NOT NULL,
  `r_id` int NOT NULL,
  PRIMARY KEY (`u_id`, `r_id`) USING BTREE,
  INDEX `r_id_f`(`r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of soat_users_roles
-- ----------------------------
INSERT INTO `soat_users_roles` VALUES (2, 1);
INSERT INTO `soat_users_roles` VALUES (6, 3);
INSERT INTO `soat_users_roles` VALUES (4, 4);
INSERT INTO `soat_users_roles` VALUES (5, 5);
INSERT INTO `soat_users_roles` VALUES (2, 6);
INSERT INTO `soat_users_roles` VALUES (3, 6);

SET FOREIGN_KEY_CHECKS = 1;
