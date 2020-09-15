/*
 Navicat MySQL Data Transfer

 Source Server         : 172.16.87.131
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 172.16.87.131:3306
 Source Schema         : demo_order

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 14/09/2020 19:35:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL DEFAULT '' COMMENT '活动名称',
  `sku_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品sku',
  `discount` decimal(4,2) NOT NULL DEFAULT '0.00' COMMENT '活动折扣',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='活动表';

-- ----------------------------
-- Records of activity
-- ----------------------------
BEGIN;
INSERT INTO `activity` VALUES (1, '秋季大酬宾', 1001, 9.00);
INSERT INTO `activity` VALUES (2, '秋季大酬宾', 1003, 8.00);
COMMIT;

-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL DEFAULT '' COMMENT '优惠券编号',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '优惠券类型',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '满足多少金额优惠',
  `reduction` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='优惠券表';

-- ----------------------------
-- Records of coupon
-- ----------------------------
BEGIN;
INSERT INTO `coupon` VALUES (1, '20200001', 1, 100.00, 10.00);
INSERT INTO `coupon` VALUES (2, '20200002', 2, 0.00, 20.00);
COMMIT;

-- ----------------------------
-- Table structure for freight
-- ----------------------------
DROP TABLE IF EXISTS `freight`;
CREATE TABLE `freight` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `freight_template_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '运费模板ID',
  `sku_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品sku',
  `freight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费',
  `province_code` varchar(6) NOT NULL DEFAULT '' COMMENT '省',
  `province_name` varchar(45) NOT NULL DEFAULT '',
  `city_code` varchar(6) NOT NULL DEFAULT '' COMMENT '市',
  `city_name` varchar(45) NOT NULL DEFAULT '',
  `country_code` varchar(6) NOT NULL DEFAULT '' COMMENT '县、县级市',
  `country_name` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of freight
-- ----------------------------
BEGIN;
INSERT INTO `freight` VALUES (1, 1, 1001, 5.00, '110000', '北京市', '110100', '北京市', '110105', '朝阳区');
INSERT INTO `freight` VALUES (2, 2, 1001, 10.00, '370000', '山东省', '370600', '烟台市', '370683', '莱州市');
INSERT INTO `freight` VALUES (3, 1, 1002, 10.00, '110000', '北京市', '110100', '北京市', '110105', '朝阳区');
COMMIT;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sku_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品sku',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '商品价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN;
INSERT INTO `goods` VALUES (1, 1001, 'mac pro', 17999.00);
INSERT INTO `goods` VALUES (2, 1002, 'iphone', 5266.00);
INSERT INTO `goods` VALUES (3, 1003, 'think in java', 56.00);
INSERT INTO `goods` VALUES (4, 1004, '精通Python', 39.00);
INSERT INTO `goods` VALUES (5, 1005, '精通Mysql', 68.00);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
