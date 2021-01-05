/*
Navicat MySQL Data Transfer

Source Server         : 47.108.150.218
Source Server Version : 50729
Source Host           : 47.108.150.218:3306
Source Database       : test_word

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2021-01-05 16:57:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for word
-- ----------------------------
DROP TABLE IF EXISTS `word`;
CREATE TABLE `word` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(256) COLLATE utf8mb4_bin NOT NULL,
  `is_deleted` int(2) DEFAULT '0' COMMENT '是否已删除',
  `enabled` int(2) DEFAULT '0' COMMENT '是否已删除',
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of word
-- ----------------------------
INSERT INTO `word` VALUES ('30', '??????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('31', '鼠༲你༲好༲看༲', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('32', '?②⓪②⓪?', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('33', '今天 ■■■■■■□□□□ 57.2%', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('34', '♥️❤️??????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('35', '???????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('36', '♡ Life+u＝sweet ♡', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('37', '?ʜᴀ͟ᴘ͟ᴘ͟ʏ ᴠᴀʟᴇɴᴛɪɴᴇ\'s ᴅᴀʏ̆̈ ♥', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('38', '? ???? ??? ????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('39', '??? ???? ??? ??? ?? ??? ???? ?\'?? ???? ????.', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('40', '?? ??? ???? ????? ???? ??\'?? ?? ????.', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('41', '???? ????? ?͇?͇?͇?͇ ???', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('42', '♡ ???? ??? ??? ???? ?ིྀ', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('43', 'уσυ ωιℓℓ αℓωαуѕ вє му ℓσνє, му ℓσνє.', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('44', '?♡ ᶫᵒᵛᵉᵧₒᵤ ☪︎✨', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('45', '♡⃝ ????? ??????\'? ???. ◡̈ ☽⋆\n谢⃐谢⃐您⃐让⃐我⃐有⃐了⃐无⃐条⃐件⃐的⃐退⃐路⃐\n可⃐以⃐随⃐时⃐退⃐回⃐到⃐您⃐的⃐保⃐护⃐圈⃐', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('46', '✐. ??????\'? ??? 〰︎ ?·?·?\n您的肩膀是我看世界的瞭望台\n是您把我举过头顶看世界', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('47', '??????? ??????\'? ?????\n¨̮✦—我最爱的帅老头 ʚ•͈⚇•͈ɞ', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('48', '?ℓσνє уσυ ❤Father ✨\n小时候最想要快快长大\n而长大后希望你能慢慢变老再慢一点', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('49', '— ? ❥❥❥❥❥ ? —', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('50', '???\n???', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('51', '?⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂╮\n?各位美丽的仙女们\n? 节日快乐\n?⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂╯', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('52', '✐.ɴɪᴄᴇ ᴅᴀʏ 〰︎', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('53', 'ʚ?ྀིɞ︎', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('54', '????? ????????? ❄️ ??', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('55', '/???./', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('56', '??? ❽', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('57', '??? ⑧', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('58', '⁸/₈ Sᴀᴛᴜʀᴅᴀʏ', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('59', '?/? ????????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('60', '???? |', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('61', '???? |', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('62', '?: ?: ?: ?: ', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('63', 'ʚ ??????\'? ??? ɞ\n你是坚韧的大树\n也是温柔的阳光', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('64', '?ℍ???? ????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('65', '? ???? ??? ???? ? ????? ?????????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('66', '???? ?? ?? ??? ?? ??? ??? ?? ?????? ??? ?????.', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('67', '???????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('68', '????\n???', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('69', '????????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('70', '???? ???????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('71', '??????? ?????', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('72', '?HEᒪᒪO ᗩᑌGᑌᔕT 希望八月运气爆棚', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('73', '????? ?????? | 愿下半年一切安好?', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('74', '?≋≋ ? ? 夏天的风暖暖的吹过', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('75', '?葡萄成熟时', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('76', 'ᵕ̈ ɴɪᴄᴇ ? ᵕ̈દ ᵕ̈ ૩ ?\n⛅?????????\n没̻ 有̻ 西̻ 瓜̻ 冰̻ 淇̻ 淋̻ 的̻ 夏̻ 天̻ 不̻ 完̻ 美̻', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('77', '♡✈ ♡ ? ♡ ? ♡ ?♡⛵ ♡\n?h a v e  a  s w e e t  d a y?\n整⃙ 个⃙ 夏⃙ 天⃙ 想⃙ 环⃙ 游⃙ 世⃙ 界⃙', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('78', '? ╭══╮ ╭═══════╮\n  ╭╯整个夏天 ║想和你环游世界\n  ╰⊙ ═ ⊙╯ ╰═⊙═⊙══⊙╯', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('79', '  ʚ◡̈⃝ɞ 整个夏天想和你环游全世界?\n\n╭ ◜◝ ͡  ◜◝╮\n(   ⸝⸝⸝⁰⃚⃙̴ ༝ ⁰⃚⃙̴⸝⸝⸝  )\n╰◟◞  ͜   ◟◞╯\n日子有盼头 生活才可爱 ฅ՞•ﻌ•՞ฅ\n\n☁️ 今天天气是晴，心情是想你๑⃙⃘´༥`๑⃙⃘\n\n今日限定 ?本人全糖去冰 ” દ ᵕ̈ ૩وً', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('80', '??? ???', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('81', '♡+♡=♡²', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('82', '(｡・//ε//・｡)', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('83', '(　ﾟ∀ﾟ) ﾉ♡\n\nヾ(●゜▽゜●)♡ \n\nΣ>―(〃°ω°〃)♡→\n\nε٩(๑> ₃ <)۶з', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('84', '≧〔゜゜〕≦\n\n( ´(00)`)\n\nヾ(；ﾟ(OO)ﾟ)ﾉ\n\n(❍ᴥ❍ʋ)\n\n／/( ◕‿‿◕ )＼', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('85', '(￣ヘ￣;)\n\n(-_-;)\n\n(-_-メ)\n\n(~_~;)\n\n(๐•̆ ·̭ •̆๐)', '0', '0', null, null, null, null);
INSERT INTO `word` VALUES ('86', '(っ˘̩╭╮˘̩)っ\n\n(｡•́︿•̀｡)\n\n༼;´༎ຶ ۝ ༎ຶ༽\n\n｡:ﾟ(;´∩`;)ﾟ:｡\n\n(个_个)\n\n(´°̥̥̥̥̥̥̥̥ω°̥̥̥̥̥̥̥̥｀)', '0', '0', null, null, null, null);

-- ----------------------------
-- Table structure for word_tag
-- ----------------------------
DROP TABLE IF EXISTS `word_tag`;
CREATE TABLE `word_tag` (
  `word_id` int(11) NOT NULL,
  `tag` varchar(64) NOT NULL,
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`word_id`,`tag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word_tag
-- ----------------------------
INSERT INTO `word_tag` VALUES ('17', '几何', null, null);

-- ----------------------------
-- Table structure for word_typ
-- ----------------------------
DROP TABLE IF EXISTS `word_typ`;
CREATE TABLE `word_typ` (
  `word_id` int(11) NOT NULL,
  `typ` varchar(64) NOT NULL,
  `create_user` bigint(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`word_id`,`typ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of word_typ
-- ----------------------------
INSERT INTO `word_typ` VALUES ('17', 'emoji', null, null);
