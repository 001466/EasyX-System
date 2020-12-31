/*
Navicat MySQL Data Transfer

Source Server         : 47.108.150.218
Source Server Version : 50729
Source Host           : 47.108.150.218:3306
Source Database       : test_word

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-12-31 09:28:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` text NOT NULL,
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除',
  `enabled` int(2) DEFAULT '0' COMMENT '是否已删除',
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of word
-- ----------------------------

-- ----------------------------
-- Table structure for word_dict
-- ----------------------------
DROP TABLE IF EXISTS `word_dict`;
CREATE TABLE `word_dict` (
  `word_id` int(11) NOT NULL,
  `dict_id` int(11) DEFAULT NULL,
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`word_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of word_dict
-- ----------------------------
