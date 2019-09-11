/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50711
 Source Host           : localhost:3306
 Source Schema         : toilet_radar

 Target Server Type    : MySQL
 Target Server Version : 50711
 File Encoding         : 65001

 Date: 02/08/2019 22:00:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `pk_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `wx_photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `wx_name` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pet_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `identity` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `delete_status` tinyint(1) UNSIGNED NOT NULL,
  `create_time` datetime(0) NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `pk_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `score` tinyint(2) UNSIGNED NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `delete_status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0,
  `like_count` int(10) UNSIGNED NULL DEFAULT 0,
  `fr_toilet` bigint(20) UNSIGNED NOT NULL,
  `fr_account` bigint(20) UNSIGNED NOT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES (1, '这里是测试的评论', 8, NULL, '2019-08-01 16:16:01', 0, 1, 10085, 2111);
INSERT INTO `review` VALUES (2, '这里是测试的评论2', 8, '2019-08-01 11:08:51', '2019-08-01 11:08:51', 0, 1, 10085, 2111);
INSERT INTO `review` VALUES (3, '这里是测试的评论3', 10, '2019-08-01 11:10:04', '2019-08-02 14:30:28', 0, 1, 10085, 2131);
INSERT INTO `review` VALUES (4, '这里是测试的评论4', 8, '2019-08-01 11:10:15', '2019-08-01 11:10:15', 0, 0, 10085, 2121);
INSERT INTO `review` VALUES (5, '这里是测试的评论5', 8, '2019-08-01 11:10:28', '2019-08-02 21:18:15', 0, 1, 10086, 2121);
INSERT INTO `review` VALUES (6, '这里是测试的评论6', 8, '2019-08-01 11:10:42', '2019-08-01 16:20:22', 0, 1, 10086, 2111);
INSERT INTO `review` VALUES (7, '点赞了该厕所', 5, '2019-08-02 17:02:13', '2019-08-02 21:30:56', 0, 1, 10086, 2333);

-- ----------------------------
-- Table structure for toilet
-- ----------------------------
DROP TABLE IF EXISTS `toilet`;
CREATE TABLE `toilet`  (
  `pk_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `longitude` decimal(10, 0) NOT NULL,
  `latitude` decimal(10, 0) NOT NULL,
  `check_status` tinyint(1) UNSIGNED NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `picture_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fix_status` tinyint(1) UNSIGNED NOT NULL,
  `delete_status` tinyint(1) UNSIGNED NOT NULL,
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `score` decimal(2, 1) NULL DEFAULT 0.0,
  `like_number` bigint(20) NULL DEFAULT 0,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10087 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of toilet
-- ----------------------------
INSERT INTO `toilet` VALUES (10085, '广州', 34, 234, 1, '在你旁边', NULL, NULL, 1, 0, '2019-08-02 15:51:44', '2019-08-02 15:51:44', 0.0, 0);
INSERT INTO `toilet` VALUES (10086, '佛山', 34, 55, 1, '在我旁边', NULL, NULL, 1, 0, '2019-08-02 15:52:26', '2019-08-02 15:52:26', 7.0, 3);

-- ----------------------------
-- Table structure for waste_bin
-- ----------------------------
DROP TABLE IF EXISTS `waste_bin`;
CREATE TABLE `waste_bin`  (
  `pk_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `longitude` decimal(10, 0) NOT NULL,
  `latitue` decimal(10, 0) NOT NULL,
  `check_status` tinyint(1) UNSIGNED NOT NULL,
  `type` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `delete_status` tinyint(1) UNSIGNED NOT NULL,
  `create_time` datetime(0) NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
