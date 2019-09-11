/*
Navicat MySQL Data Transfer

Source Server         : lank
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : toilet_radar

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-08-07 10:42:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for toilet
-- ----------------------------
DROP TABLE IF EXISTS `toilet`;
CREATE TABLE `toilet` (
  `pk_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(100) NOT NULL,
  `longitude` decimal(10,0) NOT NULL,
  `latitude` decimal(10,0) NOT NULL,
  `check_status` tinyint(1) unsigned NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `picture_url` varchar(500) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `fix_status` tinyint(1) unsigned NOT NULL,
  `delete_status` tinyint(1) unsigned NOT NULL,
  `create_time` datetime NOT NULL,
  `modify_time` datetime DEFAULT NULL,
  `score` decimal(2,1) DEFAULT NULL,
  `like_number` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `publisher` varchar(255) DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
