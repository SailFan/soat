-- MySQL dump 10.13  Distrib 5.5.62, for Linux (x86_64)
--
-- Host: localhost    Database: soat
-- ------------------------------------------------------
-- Server version	5.5.62-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `soat_account`
--

DROP TABLE IF EXISTS `soat_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `cerater` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_account`
--

LOCK TABLES `soat_account` WRITE;
/*!40000 ALTER TABLE `soat_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `soat_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_devices`
--

DROP TABLE IF EXISTS `soat_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_devices` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `devices_type` varchar(255) DEFAULT NULL,
  `devices_possessor` varchar(255) DEFAULT NULL,
  `borrow_date` datetime DEFAULT NULL,
  `plan_date` datetime DEFAULT NULL,
  `current_possessor` varchar(255) DEFAULT NULL,
  `is_return` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_devices`
--

LOCK TABLES `soat_devices` WRITE;
/*!40000 ALTER TABLE `soat_devices` DISABLE KEYS */;
INSERT INTO `soat_devices` VALUES (1,'手机','刘文凡','2021-12-01 15:09:54','2021-12-01 15:09:59','李元芳','1','备注');
/*!40000 ALTER TABLE `soat_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_id_number`
--

DROP TABLE IF EXISTS `soat_id_number`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_id_number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_number` varchar(150) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `is_use` varchar(11) DEFAULT NULL,
  `is_hide` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_id_number`
--

LOCK TABLES `soat_id_number` WRITE;
/*!40000 ALTER TABLE `soat_id_number` DISABLE KEYS */;
/*!40000 ALTER TABLE `soat_id_number` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_nav`
--

DROP TABLE IF EXISTS `soat_nav`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_nav` (
  `id` int(11) NOT NULL,
  `nav_name` varchar(20) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_nav`
--

LOCK TABLES `soat_nav` WRITE;
/*!40000 ALTER TABLE `soat_nav` DISABLE KEYS */;
INSERT INTO `soat_nav` VALUES (1,'工程',0,'/i'),(4,'资源管理',0,'/iManagement'),(5,'系统设置',0,'/o'),(6,'账号管理',4,'/accounts'),(7,'设备管理',4,'/devices'),(8,'用户管理',5,'/users'),(9,'角色管理',5,'/permission'),(10,'接口运行统计',1,'/statement'),(13,'工程管理',1,'/project'),(14,'文档',0,'/file'),(16,'文档列表',14,'/documentList'),(17,'工具',0,'/utils'),(18,'删除账号关联',17,'/deleteAccountLink');
/*!40000 ALTER TABLE `soat_nav` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_permission`
--

DROP TABLE IF EXISTS `soat_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_permission`
--

LOCK TABLES `soat_permission` WRITE;
/*!40000 ALTER TABLE `soat_permission` DISABLE KEYS */;
INSERT INTO `soat_permission` VALUES (1,'sys:p:create','新增接口','1'),(2,'sys:p:update','修改接口','1'),(3,'sys:p:delete','删除接口','1'),(4,'sys:p:check','查看接口','1'),(5,'sys:inter:create','新增缺陷','2'),(6,'sys:inter:update','修改缺陷','2'),(7,'sys:inter:check','查看接口','2'),(8,'sys:inter:delete','删除缺陷','2'),(10,'sys:rp:add','添加角色','1'),(11,'sys:rp:edit','编辑角色','1'),(12,'sys:nav','导航接口','1');
/*!40000 ALTER TABLE `soat_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_project`
--

DROP TABLE IF EXISTS `soat_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `forbidden` int(11) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `project_version` varchar(255) DEFAULT NULL,
  `principal` varchar(255) DEFAULT NULL,
  `test_principal` varchar(255) DEFAULT NULL,
  `dev_principal` varchar(255) DEFAULT NULL,
  `project_type` varchar(255) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_project`
--

LOCK TABLES `soat_project` WRITE;
/*!40000 ALTER TABLE `soat_project` DISABLE KEYS */;
/*!40000 ALTER TABLE `soat_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_roles`
--

DROP TABLE IF EXISTS `soat_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_roles` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  `role_tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_roles`
--

LOCK TABLES `soat_roles` WRITE;
/*!40000 ALTER TABLE `soat_roles` DISABLE KEYS */;
INSERT INTO `soat_roles` VALUES (1,'管理员1','admin'),(3,'开发者','dev'),(4,'产品经理','opt'),(6,'测试人员','qa'),(15,'来宾账号','guest');
/*!40000 ALTER TABLE `soat_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_roles_permissions`
--

DROP TABLE IF EXISTS `soat_roles_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_roles_permissions` (
  `r_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`r_id`,`p_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_roles_permissions`
--

LOCK TABLES `soat_roles_permissions` WRITE;
/*!40000 ALTER TABLE `soat_roles_permissions` DISABLE KEYS */;
INSERT INTO `soat_roles_permissions` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,10),(1,11),(3,2),(3,5),(3,10),(4,4),(6,1),(6,4),(6,12),(15,3);
/*!40000 ALTER TABLE `soat_roles_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_set`
--

DROP TABLE IF EXISTS `soat_set`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_set` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `creater` varchar(255) NOT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `base_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_set`
--

LOCK TABLES `soat_set` WRITE;
/*!40000 ALTER TABLE `soat_set` DISABLE KEYS */;
INSERT INTO `soat_set` VALUES (2,'测试集二','2021-08-01 02:32:02','2021-08-01 02:32:02','刘文凡','刘文凡','http://www.baidu.com'),(4,'测试集二','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(5,'测试集二','2021-08-01 02:55:26','2021-08-01 02:55:26','刘文凡','刘文凡','http://www.baidu.com'),(6,'测试集二','2021-08-01 02:56:22','2021-08-01 02:56:22','刘文凡','刘文凡','http://www.baidu.com'),(7,'测试集二','2021-08-01 10:58:11','2021-08-01 10:58:11','刘文凡','刘文凡','http://www.baidu.com'),(8,'测试集7','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(9,'测试集8','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(10,'测试集9','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(11,'测试集10','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(12,'测试集11','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(13,'测试集12','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(14,'测试集13','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(15,'测试集14','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(16,'测试集15','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com'),(17,'测试集16','2021-08-01 02:30:21','2021-08-01 02:30:21','刘文凡','刘文凡','http://www.baidu.com');
/*!40000 ALTER TABLE `soat_set` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_users`
--

DROP TABLE IF EXISTS `soat_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(20) DEFAULT '',
  `phone` varchar(20) DEFAULT '',
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_users`
--

LOCK TABLES `soat_users` WRITE;
/*!40000 ALTER TABLE `soat_users` DISABLE KEYS */;
INSERT INTO `soat_users` VALUES (2,'系统管理员','165d0dbe7c285ab6a98190261863f0c7','soat','admin','afan6203@126.com','qa','13893887430',0),(4,'杜煌','165d0dbe7c285ab6a98190261863f0c7','soat','dev','afan6205@126.com','开发人员','17600576201',0),(5,'用户五','a3eb67417ed506a6e7800f3236b6f85c','soat','test','m17600576201@163.com','qa','17600576201',1),(6,'用户五','a3eb67417ed506a6e7800f3236b6f85c','soat','test','m17600576201@163.com','qa','17600576201',1);
/*!40000 ALTER TABLE `soat_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soat_users_roles`
--

DROP TABLE IF EXISTS `soat_users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soat_users_roles` (
  `u_id` int(11) NOT NULL,
  `r_id` int(11) NOT NULL,
  PRIMARY KEY (`u_id`,`r_id`) USING BTREE,
  KEY `r_id_f` (`r_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soat_users_roles`
--

LOCK TABLES `soat_users_roles` WRITE;
/*!40000 ALTER TABLE `soat_users_roles` DISABLE KEYS */;
INSERT INTO `soat_users_roles` VALUES (6,3),(4,4),(2,6),(3,6);
/*!40000 ALTER TABLE `soat_users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-28 23:31:41
