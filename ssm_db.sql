/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : ssm_db

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 12/09/2022 13:04:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tr_blog
-- ----------------------------
DROP TABLE IF EXISTS `tr_blog`;
CREATE TABLE `tr_blog`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `userid` int(0) NOT NULL,
  `descript` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tr_blog
-- ----------------------------
INSERT INTO `tr_blog` VALUES (1, '范德薩范德薩', '發士大夫敢死隊富士達富士達', 1, '電風扇犯得上');
INSERT INTO `tr_blog` VALUES (2, '的撒范德薩發生的', '富商大賈發士大夫', 2, '發士大夫薩芬');
INSERT INTO `tr_blog` VALUES (3, '發射點發射點f', '富士達噶士大夫', 3, '發射點發射點');
INSERT INTO `tr_blog` VALUES (4, '發射點發射點', '廣汎士大夫撒地方', 4, '第三次修改發射點發射點');
INSERT INTO `tr_blog` VALUES (30, '范德薩發士大夫', '<p>發撒德國發生的大事DA實打實DFAS發ASDF</p>', 2, '發撒德國發生的');
INSERT INTO `tr_blog` VALUES (31, '從VS德國撒打發士大夫', '<p>公司答復哈士大夫薩芬士大夫撒地方</p>', 2, '公司答復哈士大夫薩芬');
INSERT INTO `tr_blog` VALUES (32, '非常士大夫士大夫撒旦', '<p>f宋大哥撒旦飛灑發生大</p>', 2, 'f宋大哥撒旦飛灑發生');

-- ----------------------------
-- Table structure for tr_user
-- ----------------------------
DROP TABLE IF EXISTS `tr_user`;
CREATE TABLE `tr_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `type` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tr_user
-- ----------------------------
INSERT INTO `tr_user` VALUES (1, 'test1', 'test2', 2);
INSERT INTO `tr_user` VALUES (2, 'a111111', 'a222222', 1);
INSERT INTO `tr_user` VALUES (3, 'a222222', 'a222222', 0);
INSERT INTO `tr_user` VALUES (4, 'adsfsdf', 'fsdfsdf', 0);
INSERT INTO `tr_user` VALUES (5, 'dfsf', 'fsdfsd', 0);
INSERT INTO `tr_user` VALUES (6, 'hushao2021', 'a111111', 0);
INSERT INTO `tr_user` VALUES (7, '414272559@qq.com', 'a111111', 0);

SET FOREIGN_KEY_CHECKS = 1;
