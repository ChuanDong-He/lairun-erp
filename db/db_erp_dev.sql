/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : db_erp_dev

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2020-04-12 12:50:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_attribute_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_attribute_info`;
CREATE TABLE `sys_attribute_info` (
  `attribute_id` int(11) NOT NULL,
  `attribute` varchar(255) DEFAULT NULL,
  `attribute_desc` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `status` varchar(3) DEFAULT '10A',
  PRIMARY KEY (`attribute_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_attribute_info
-- ----------------------------
INSERT INTO `sys_attribute_info` VALUES ('1', 'productName', '产品名称', '产品信息', '1', '10A');
INSERT INTO `sys_attribute_info` VALUES ('2', 'productCode', '产品编号', '产品信息', '2', '10A');
INSERT INTO `sys_attribute_info` VALUES ('3', 'productSpecification', '产品规格', '产品信息', '3', '10A');
INSERT INTO `sys_attribute_info` VALUES ('4', 'stockNumber', '库存', '产品信息', '4', '10A');
INSERT INTO `sys_attribute_info` VALUES ('5', 'price', '单价', '产品信息', '5', '10A');
INSERT INTO `sys_attribute_info` VALUES ('7', 'price', '单价', '采购订单/产品信息', '1', '10A');

-- ----------------------------
-- Table structure for sys_dept_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept_info`;
CREATE TABLE `sys_dept_info` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) NOT NULL,
  `up_dept_id` int(11) DEFAULT NULL,
  `status` varchar(3) NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_user` varchar(50) DEFAULT NULL,
  `updated_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_dept_info
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_info`;
CREATE TABLE `sys_menu_info` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `up_menu_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `component` varchar(255) DEFAULT NULL,
  `tree_leve` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `status` varchar(3) DEFAULT '10A',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_menu_info
-- ----------------------------
INSERT INTO `sys_menu_info` VALUES ('1', '0', '产品管理', null, null, null, '1', '1', '10A');
INSERT INTO `sys_menu_info` VALUES ('2', '1', '产品信息', null, null, null, '2', '1', '10A');
INSERT INTO `sys_menu_info` VALUES ('3', '0', '订单管理', null, null, null, '1', '1', '10A');
INSERT INTO `sys_menu_info` VALUES ('4', '3', '采购订单', null, null, null, '2', '1', '10A');
INSERT INTO `sys_menu_info` VALUES ('5', '3', '销售订单', null, null, null, '2', '2', '10A');
INSERT INTO `sys_menu_info` VALUES ('6', '3', '销售额度', null, null, null, '2', '3', '10A');
INSERT INTO `sys_menu_info` VALUES ('7', '0', '客户管理', null, null, null, '1', '3', '10A');
INSERT INTO `sys_menu_info` VALUES ('8', '7', '客户信息', null, null, null, '2', '1', '10A');
INSERT INTO `sys_menu_info` VALUES ('9', '7', '供应商信息', null, null, null, '2', '2', '10A');
INSERT INTO `sys_menu_info` VALUES ('10', '0', '系统管理', null, null, null, '1', '4', '10A');
INSERT INTO `sys_menu_info` VALUES ('11', '10', '用户信息', null, null, null, '2', '1', '10A');
INSERT INTO `sys_menu_info` VALUES ('12', '10', '角色信息', null, null, null, '2', '2', '10A');

-- ----------------------------
-- Table structure for sys_operation_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_info`;
CREATE TABLE `sys_operation_info` (
  `operation_id` int(11) NOT NULL,
  `operation_code` varchar(255) DEFAULT NULL,
  `operation_desc` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `status` varchar(3) DEFAULT '10A',
  PRIMARY KEY (`operation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_operation_info
-- ----------------------------
INSERT INTO `sys_operation_info` VALUES ('1', null, '库存修改', null, '产品信息', '1', '10A');
INSERT INTO `sys_operation_info` VALUES ('2', null, '价格', null, '产品信息', '2', '10A');
INSERT INTO `sys_operation_info` VALUES ('3', null, '入库', null, '采购订单/入库信息', '1', '10A');

-- ----------------------------
-- Table structure for sys_role_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_info`;
CREATE TABLE `sys_role_info` (
  `role_id` varchar(50) NOT NULL,
  `role_name` varchar(50) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `status` varchar(3) NOT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_user` varchar(50) DEFAULT NULL,
  `updated_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_info
-- ----------------------------
INSERT INTO `sys_role_info` VALUES ('ADMIN', '系统管理员', '系统管理员', '10A', '2019-12-11 17:14:57', '2020-04-05 13:36:01', '', '');
INSERT INTO `sys_role_info` VALUES ('NORMAL', '普通角色', '普通角色', '10A', '2019-12-19 13:11:05', '2019-12-19 13:11:05', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_role_permission_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_rel`;
CREATE TABLE `sys_role_permission_rel` (
  `role_id` varchar(255) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of sys_role_permission_rel
-- ----------------------------
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '1', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '2', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '3', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '4', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '5', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '6', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '7', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '8', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '9', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '10', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '11', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('ADMIN', '12', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '4', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '5', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '7', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '8', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '9', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '1', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '2', 'MENU');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '5', 'ATTR');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '7', 'ATTR');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '2', 'OPERATION');
INSERT INTO `sys_role_permission_rel` VALUES ('NORMAL', '3', 'OPERATION');

-- ----------------------------
-- Table structure for sys_user_info
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_info`;
CREATE TABLE `sys_user_info` (
  `user_id` varchar(50) NOT NULL COMMENT '用户ID',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100) DEFAULT NULL COMMENT '用户密码',
  `phone_number` varchar(20) DEFAULT NULL,
  `telephone_number` varchar(20) DEFAULT NULL,
  `fax_number` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` varchar(3) NOT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_user` varchar(50) DEFAULT NULL,
  `updated_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_info
-- ----------------------------
INSERT INTO `sys_user_info` VALUES ('admin', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', '18888888888', '010-567893', '010-654356', 'x_holic@outlook.com', '10A', null, '2019-12-11 17:20:05', '2020-04-05 10:31:29', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test', '测试账号', 'e10adc3949ba59abbe56e057f20f883e', null, null, null, null, '10A', null, '2019-12-19 13:11:34', '2020-04-06 21:13:13', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test1', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:23:20', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test10', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:40:50', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test11', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:40:58', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test12', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:41:03', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test2', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:40:39', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test3', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:41:23', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test4', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:41:40', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test5', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:21:33', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test6', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 21:41:40', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test7', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-04-02 16:50:50', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test8', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 22:54:46', 'admin', 'admin');
INSERT INTO `sys_user_info` VALUES ('test9', '测试账号', '123456', null, null, null, null, '10D', null, '2019-12-19 13:11:34', '2020-03-30 22:54:46', 'admin', 'admin');

-- ----------------------------
-- Table structure for sys_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel` (
  `user_id` varchar(50) NOT NULL,
  `role_id` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role_rel
-- ----------------------------
INSERT INTO `sys_user_role_rel` VALUES ('admin', 'ADMIN');
INSERT INTO `sys_user_role_rel` VALUES ('test', 'NORMAL');
