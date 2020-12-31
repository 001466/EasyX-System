/*
Navicat MySQL Data Transfer

Source Server         : 47.108.150.218
Source Server Version : 50729
Source Host           : 47.108.150.218:3306
Source Database       : test_order

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-12-31 11:20:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL,
  `type` varchar(64) DEFAULT NULL,
  `custom_name` varchar(64) DEFAULT NULL,
  `custom_mobile` varchar(64) DEFAULT NULL,
  `custom_email` varchar(64) DEFAULT NULL,
  `custom_wechat` varchar(64) DEFAULT NULL,
  `custom_qq` varchar(64) DEFAULT NULL,
  `custom_content` varchar(128) DEFAULT NULL,
  `custom_type` int(11) DEFAULT NULL COMMENT '0付费1免费',
  `custom_from` varchar(64) DEFAULT NULL,
  `custom_visit_url` varchar(128) DEFAULT NULL,
  `product_id` varchar(64) DEFAULT NULL,
  `product_type` varchar(64) DEFAULT NULL,
  `product_branch` varchar(128) DEFAULT NULL,
  `product_material` varchar(128) DEFAULT NULL,
  `product_price` decimal(8,2) DEFAULT NULL,
  `deliver_province` varchar(64) DEFAULT NULL,
  `deliver_city` varchar(64) DEFAULT NULL,
  `deliver_county` varchar(64) DEFAULT NULL,
  `deliver_adderss` varchar(512) DEFAULT NULL,
  `deliver_time` varchar(64) DEFAULT NULL,
  `deliver_status` int(11) DEFAULT NULL COMMENT '0未发货1已发货-1已退货',
  `deliver_express` varchar(128) DEFAULT NULL,
  `deliver_express_id` varchar(64) DEFAULT NULL,
  `create_user` bigint(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_ip` varchar(32) DEFAULT NULL,
  `update_user` bigint(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_ip` varchar(32) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0未转化1已转化',
  `browser_type` varchar(32) DEFAULT NULL,
  `browser_name` varchar(32) DEFAULT NULL,
  `browser_os` varchar(32) DEFAULT NULL,
  `rate_unit` varchar(32) DEFAULT NULL,
  `rate_val` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for visitor
-- ----------------------------
DROP TABLE IF EXISTS `visitor`;
CREATE TABLE `visitor` (
  `custom_type` int(11) DEFAULT NULL COMMENT '0付费1免费',
  `custom_from` varchar(64) DEFAULT NULL,
  `custom_visit_url` varchar(128) DEFAULT NULL,
  `product_type` varchar(64) DEFAULT NULL,
  `product_price` decimal(8,2) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_ip` varchar(64) DEFAULT NULL,
  `browser_name` varchar(64) DEFAULT NULL,
  `browser_os` varchar(64) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0未转化1已转化',
  `rate_unit` varchar(32) DEFAULT NULL,
  `rate_val` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='visitor';
