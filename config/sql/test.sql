/*
Navicat MySQL Data Transfer

Source Server         : 47.108.150.218
Source Server Version : 50729
Source Host           : 47.108.150.218:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2021-01-04 18:22:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` varchar(48) NOT NULL COMMENT '客户端id',
  `client_secret` varchar(256) NOT NULL COMMENT '客户端密钥',
  `resource_ids` varchar(256) DEFAULT NULL COMMENT '资源集合',
  `scope` varchar(256) NOT NULL COMMENT '授权范围',
  `authorized_grant_types` varchar(256) NOT NULL COMMENT '授权类型',
  `web_server_redirect_uri` varchar(256) DEFAULT NULL COMMENT '回调地址',
  `authorities` varchar(256) DEFAULT NULL COMMENT '权限',
  `access_token_validity` bigint(11) NOT NULL COMMENT '令牌过期秒数',
  `refresh_token_validity` bigint(11) NOT NULL COMMENT '刷新令牌过期秒数',
  `additional_information` varchar(4096) DEFAULT NULL COMMENT '附加说明',
  `autoapprove` varchar(256) DEFAULT NULL COMMENT '自动授权',
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(2) NOT NULL COMMENT '状态',
  `is_deleted` int(2) NOT NULL COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('22', 'extjs', '{noop}extjs', '', 'all', 'refresh_token,password,authorization_code', 'http://localhost:1000/login/oauth2/code/okta', '', '1296000000', '1296000000', '', '', '1', '2019-11-11 10:11:46', '1', '2020-09-03 17:45:01', '1', '0');

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT '0' COMMENT '父主键',
  `code` varchar(255) DEFAULT NULL COMMENT '字典码',
  `dict_key` varchar(255) DEFAULT NULL COMMENT '字典值',
  `dict_value` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `remark` varchar(255) DEFAULT NULL COMMENT '字典备注',
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=113 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', '0', 'sex', '0', '性别', '1', '性别', '0');
INSERT INTO `dict` VALUES ('2', '1', 'sex', '1', '男', '1', '男', '0');
INSERT INTO `dict` VALUES ('3', '1', 'sex', '2', '女', '2', '女', '0');
INSERT INTO `dict` VALUES ('4', '0', 'notice', '0', '通知类型', '2', '通知类型', '0');
INSERT INTO `dict` VALUES ('5', '4', 'notice', '1', '发布通知', '1', '发布通知', '0');
INSERT INTO `dict` VALUES ('6', '4', 'notice', '2', '批转通知', '2', '批转通知', '0');
INSERT INTO `dict` VALUES ('8', '4', 'notice', '4', '指示通知', '4', '指示通知', '0');
INSERT INTO `dict` VALUES ('9', '4', 'notice', '5', '任免通知', '5', '任免通知', '0');
INSERT INTO `dict` VALUES ('10', '4', 'notice', '6', '事务通知', '6', '事务通知', '0');
INSERT INTO `dict` VALUES ('11', '0', 'menu_category', '0', '菜单类型', '3', '菜单类型', '0');
INSERT INTO `dict` VALUES ('12', '11', 'menu_category', '1', '菜单', '1', '菜单', '0');
INSERT INTO `dict` VALUES ('13', '11', 'menu_category', '2', '按钮', '2', '按钮', '0');
INSERT INTO `dict` VALUES ('14', '0', 'button_func', '0', '按钮功能', '4', '按钮功能', '0');
INSERT INTO `dict` VALUES ('15', '14', 'button_func', '1', '工具栏', '1', '工具栏', '0');
INSERT INTO `dict` VALUES ('16', '14', 'button_func', '2', '操作栏', '2', '操作栏', '0');
INSERT INTO `dict` VALUES ('17', '14', 'button_func', '3', '工具操作栏', '3', '工具操作栏', '0');
INSERT INTO `dict` VALUES ('18', '0', 'yes_no', '0', '是否', '5', '是否', '0');
INSERT INTO `dict` VALUES ('19', '18', 'yes_no', '1', '否', '1', '否', '0');
INSERT INTO `dict` VALUES ('20', '18', 'yes_no', '2', '是', '2', '是', '0');
INSERT INTO `dict` VALUES ('73', '0', 'sentence', '2020', '2020', null, null, '0');
INSERT INTO `dict` VALUES ('74', '0', 'sentence', '2021', '2021', null, null, '0');
INSERT INTO `dict` VALUES ('75', '0', 'sentence', '蝴蝶结', '蝴蝶结', null, null, '0');
INSERT INTO `dict` VALUES ('76', '0', 'sentence', '进度', '进度', null, null, '0');
INSERT INTO `dict` VALUES ('77', '0', 'sentence', '礼物', '礼物', null, null, '0');
INSERT INTO `dict` VALUES ('78', '0', 'sentence', '男人', '男人', null, null, '0');
INSERT INTO `dict` VALUES ('79', '0', 'sentence', '女人', '女人', null, null, '0');
INSERT INTO `dict` VALUES ('80', '0', 'sentence', '朋友圈', '朋友圈', null, null, '0');
INSERT INTO `dict` VALUES ('81', '0', 'sentence', '圣诞', '圣诞', null, null, '0');
INSERT INTO `dict` VALUES ('82', '0', 'sentence', '时间', '时间', null, null, '0');
INSERT INTO `dict` VALUES ('83', '0', 'sentence', '时尚', '时尚', null, null, '0');
INSERT INTO `dict` VALUES ('84', '0', 'sentence', '台词', '台词', null, null, '0');
INSERT INTO `dict` VALUES ('85', '0', 'sentence', '应用', '应用', null, null, '0');
INSERT INTO `dict` VALUES ('86', '0', 'sentence', '游戏', '游戏', null, null, '0');
INSERT INTO `dict` VALUES ('87', '0', 'sentence', 'AUGUST', 'AUGUST', null, null, '0');
INSERT INTO `dict` VALUES ('88', '0', 'sentence', 'emoji', 'emoji', null, null, '0');
INSERT INTO `dict` VALUES ('89', '0', 'sentence', 'July', 'July', null, null, '0');
INSERT INTO `dict` VALUES ('90', '0', 'sentence', 'NOMO', 'NOMO', null, null, '0');
INSERT INTO `dict` VALUES ('91', '0', 'sentence', 'summer', 'summer', null, null, '0');
INSERT INTO `dict` VALUES ('92', '0', 'sentence', '1月', '1月', null, null, '0');
INSERT INTO `dict` VALUES ('93', '0', 'sentence', '元诞', '元诞', null, null, '0');
INSERT INTO `dict` VALUES ('94', '0', 'sentence', '低温', '低温', null, null, '0');
INSERT INTO `dict` VALUES ('95', '0', 'sentence', '爱情', '爱情', null, null, '0');
INSERT INTO `dict` VALUES ('96', '0', 'sentence', '礼物', '礼物', null, null, '0');
INSERT INTO `dict` VALUES ('97', '0', 'sentence', '男人', '男人', null, null, '0');
INSERT INTO `dict` VALUES ('98', '0', 'emoji', '单位', '单位', null, null, '0');
INSERT INTO `dict` VALUES ('99', '0', 'emoji', '动物', '动物', null, null, '0');
INSERT INTO `dict` VALUES ('100', '0', 'emoji', '几何', '几何', null, null, '0');
INSERT INTO `dict` VALUES ('101', '0', 'emoji', '箭头', '箭头', null, null, '0');
INSERT INTO `dict` VALUES ('102', '0', 'emoji', '棋牌', '棋牌', null, null, '0');
INSERT INTO `dict` VALUES ('103', '0', 'emoji', '圈圈', '圈圈', null, null, '0');
INSERT INTO `dict` VALUES ('104', '0', 'emoji', '热门', '热门', null, null, '0');
INSERT INTO `dict` VALUES ('105', '0', 'emoji', '日期', '日期', null, null, '0');
INSERT INTO `dict` VALUES ('106', '0', 'emoji', '圣诞', '圣诞', null, null, '0');
INSERT INTO `dict` VALUES ('107', '0', 'emoji', '手帐', '手帐', null, null, '0');
INSERT INTO `dict` VALUES ('108', '0', 'emoji', '天气', '天气', null, null, '0');
INSERT INTO `dict` VALUES ('109', '0', 'emoji', '文字', '文字', null, null, '0');
INSERT INTO `dict` VALUES ('110', '0', 'emoji', '心情', '心情', null, null, '0');
INSERT INTO `dict` VALUES ('111', '0', 'emoji', '星星', '星星', null, null, '0');
INSERT INTO `dict` VALUES ('112', '0', 'emoji', '音乐', '音乐', null, null, '0');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级菜单',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `alias` varchar(255) DEFAULT NULL COMMENT '菜单别名',
  `path` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `source` varchar(255) DEFAULT NULL COMMENT '菜单资源',
  `sort` int(2) DEFAULT NULL COMMENT '排序',
  `category` int(2) DEFAULT NULL COMMENT '菜单类型',
  `action` int(2) DEFAULT '0' COMMENT '操作按钮类型',
  `is_open` int(2) DEFAULT '1' COMMENT '是否打开新页面',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `tenant_code` varchar(12) DEFAULT '000000' COMMENT '租户编号',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `category` int(11) DEFAULT NULL COMMENT '类型',
  `release_time` datetime DEFAULT NULL COMMENT '发布时间',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `to_user` bigint(11) DEFAULT NULL,
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  `is_deleted` int(2) DEFAULT NULL COMMENT '是否已删除，0为未删除，1为删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7038 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL COMMENT '主键',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '真名',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` smallint(6) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(512) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL COMMENT '角色id',
  `dept_id` varchar(255) DEFAULT NULL COMMENT '部门id',
  `enabled` int(2) DEFAULT '0' COMMENT '是否已删除',
  `locked` int(2) DEFAULT '0',
  `expired` int(2) DEFAULT '0',
  `type` int(2) NOT NULL COMMENT '0为用户；1为员工',
  `path` varchar(1024) DEFAULT NULL,
  `tenant_code` varchar(12) DEFAULT '000000' COMMENT '租户编号',
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '{ecx}90b9aa7e25f80cf4f64e990b78a9fc5ebd6cecad', '管理员', '管理员', 'admin@bladex.vip', '22233322', '2018-08-08 00:00:00', '1', '/atom-file/resource/仓井空/adc24597-9a93-4a11-82b5-64699a03a73b.png', '1', '1', '1', '0', '0', '0', '', '000000', '1', '2018-08-08 00:00:00', '-1', '2020-07-08 09:54:05');
