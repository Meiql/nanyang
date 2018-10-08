
-- ----------------------------
-- Table structure for z_formula
-- ----------------------------
DROP TABLE IF EXISTS `z_formula`;
CREATE TABLE `z_formula` (
  `id` varchar(50) NOT NULL,
  `name` varchar(200) NOT NULL COMMENT '名称',
  `chineseName` varchar(500) DEFAULT NULL COMMENT '表达式的中文名称',
  `expression` varchar(5000) DEFAULT NULL COMMENT '表达式',
  `chineseExpression` varchar(5000) DEFAULT NULL COMMENT '表达式的中文显示',
  `sysExpression` int(11) NOT NULL DEFAULT '0' COMMENT '是否是系统变量,0是 1否',
  `projectName` varchar(500) NOT NULL COMMENT '项目名称,用于区分不同项目的公式',
  `inEffectiveDate` datetime NOT NULL DEFAULT '2017-01-01 00:00:00' COMMENT '起效日期',
  `active` int(11) NOT NULL DEFAULT '0' COMMENT '是否可用',
  `expressionCode` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公式';

-- ----------------------------
-- Records of z_formula
-- ----------------------------
INSERT INTO `z_formula` VALUES ('N000002', '交通补助', '交通补助', null, null, '0', 'salary', '2017-07-14 17:06:48', '0', null);
INSERT INTO `z_formula` VALUES ('N000003', '工伤保险', null, null, null, '0', 'salary', '2017-07-14 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('N000004', '失业保险', null, null, null, '0', 'salary', '2017-07-14 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('N000005', '养老保险', '养老保险', null, null, '0', 'salary', '2017-07-24 14:26:37', '0', null);
INSERT INTO `z_formula` VALUES ('N000006', '生育保险', null, null, null, '0', 'salary', '2017-07-14 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('N000007', '公积金', null, null, null, '0', 'salary', '2017-07-14 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('N000008', '失业补欠款', '失业补欠款', null, null, '0', 'salary', '2017-08-02 14:27:37', '0', null);
INSERT INTO `z_formula` VALUES ('N000009', '商业补充医疗', null, null, null, '0', 'salary', '2017-07-14 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('N000010', '医疗保险', '医疗保险', null, null, '0', 'salary', '2017-08-02 13:50:38', '0', null);
INSERT INTO `z_formula` VALUES ('N000011', '电话费补助', '电话费补助', null, null, '0', 'salary', '2017-07-31 14:54:23', '0', null);
INSERT INTO `z_formula` VALUES ('N000012', '考勤', '考勤', null, null, '0', 'salary', '2017-07-14 10:45:59', '0', null);
INSERT INTO `z_formula` VALUES ('N000013', '请假', '请假', null, null, '0', 'salary', '2017-07-26 11:53:44', '0', null);
INSERT INTO `z_formula` VALUES ('N000014', '加班', '加班', null, null, '0', 'salary', '2017-07-26 11:54:03', '0', null);
INSERT INTO `z_formula` VALUES ('N000015', '服务费', '服务费', null, null, '0', 'salary', '2017-08-02 14:27:10', '0', null);
INSERT INTO `z_formula` VALUES ('N000016', '12', '12', null, null, '0', 'salary', '2017-08-07 10:40:06', '0', null);
INSERT INTO `z_formula` VALUES ('N000017', '其他增项', '其他增项', null, null, '0', 'salary', '2017-08-14 10:57:28', '0', null);
INSERT INTO `z_formula` VALUES ('N000018', '其他减项', '其他减项', null, null, '0', 'salary', '2017-08-14 10:58:43', '0', null);
INSERT INTO `z_formula` VALUES ('salary_baseSalary', '工资项合计', '工资项合计', '(salay_jibenpay+salay_kaohepay+salay_gonglingpay)*salary_ondutydays/salary_monthdays', '(基本工资+考核工资+工龄工资)*本月在职天数/本月总天数', '1', 'salary', '2017-07-03 00:00:00', '0', '(salay_jibenpay+salay_kaohepay+salay_gonglingpay)*salary_ondutydays/salary_monthdays');
INSERT INTO `z_formula` VALUES ('salary_day', '日工资', '日工资', '((salay_jibenpay+salay_kaohepay+salay_gonglingpay)*salary_ondutydays/salary_monthdays)/salary_monthdays', '工资项合计/本月总天数', '1', 'salary', '2012-01-01 00:00:00', '0', 'salary_baseSalary/salary_monthdays');
INSERT INTO `z_formula` VALUES ('salary_geshui', '个税', '个税', '((salay_jibenpay+salay_kaohepay+salay_gonglingpay+(N000014-N000013-N000012+N000011+N000017-N000018)-(N000003+N000004+N000005+N000010+N000006+N000008+N000009+N000007))-3500)*salary_taxrate-salary_taxshu', '(个税基数-3500)*个税税率-个税速算扣除数', '1', 'salary', '2017-07-03 00:00:00', '0', '(salary_taxbase-3500)*salary_taxrate-salary_taxshu');
INSERT INTO `z_formula` VALUES ('salary_monthdays', '本月总天数', '本月总天数', null, null, '0', 'salary', '2017-07-03 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('salary_ondutydays', '本月在职天数', '本月在职天数', null, null, '0', 'salary', '2017-07-03 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('salary_shifupay', '实付工资', '实付工资', '(((salay_jibenpay+salay_kaohepay+salay_gonglingpay)*salary_ondutydays/salary_monthdays)+(N000014-N000013-N000012+N000011+N000017-N000018))-(((salay_jibenpay+salay_kaohepay+salay_gonglingpay+(N000014-N000013-N000012+N000011+N000017-N000018)-(N000003+N000004+N000005+N000010+N000006+N000008+N000009+N000007))-3500)*salary_taxrate-salary_taxshu)-(N000003+N000004+N000005+N000010+N000006+N000008+N000009+N000007)', '应付工资-个税-统筹公积金合计', '1', 'salary', '2017-07-03 00:00:00', '0', 'salary_yingfupay-salary_geshui-salary_tongchougjj');
INSERT INTO `z_formula` VALUES ('salary_taxbase', '个税基数', '个税基数', 'salay_jibenpay+salay_kaohepay+salay_gonglingpay+(N000014-N000013-N000012+N000011+N000017-N000018)-(N000003+N000004+N000005+N000010+N000006+N000008+N000009+N000007)', '基本工资+考核工资+工龄工资+工资增减项合计-统筹公积金合计', '1', 'salary', '2017-07-03 00:00:00', '0', 'salay_jibenpay+salay_kaohepay+salay_gonglingpay+salary_zengjian-salary_tongchougjj');
INSERT INTO `z_formula` VALUES ('salary_taxrate', '个税税率', '个税税率', null, null, '0', 'salary', '2017-07-03 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('salary_taxshu', '个税速算扣除数', '个税速算扣除数', null, null, '0', 'salary', '2017-07-03 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('salary_tongchougjj', '统筹公积金合计', '统筹公积金合计', 'N000003+N000004+N000005+N000010+N000006+N000008+N000009+N000007', '工伤保险+失业保险+养老保险+医疗保险+生育保险+失业补欠款+商业补充医疗+公积金', '1', 'salary', '2012-01-01 00:00:00', '0', 'N000003+N000004+N000005+N000010+N000006+N000008+N000009+N000007');
INSERT INTO `z_formula` VALUES ('salary_yingfupay', '应付工资', '应付工资', '((salay_jibenpay+salay_kaohepay+salay_gonglingpay)*salary_ondutydays/salary_monthdays)+(N000014-N000013-N000012+N000011+N000017-N000018)', '工资项合计+工资增减项合计', '1', 'salary', '2017-07-03 00:00:00', '0', 'salary_baseSalary+salary_zengjian');
INSERT INTO `z_formula` VALUES ('salary_zengjian', '工资增减项合计', '工资增减项合计', 'N000014-N000013-N000012+N000011+N000017-N000018', '加班-请假-考勤+电话费补助+其他增项-其他减项', '1', 'salary', '2017-06-01 00:00:00', '0', 'N000014-N000013-N000012+N000011+N000017-N000018');
INSERT INTO `z_formula` VALUES ('salay_gonglingpay', '工龄工资', '工龄工资', null, null, '0', 'salary', '2017-07-03 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('salay_jibenpay', '基本工资', '基本工资', null, '', '0', 'salary', '2017-07-03 00:00:00', '0', null);
INSERT INTO `z_formula` VALUES ('salay_kaohepay', '考核工资', '考核工资', null, '', '0', 'salary', '2017-07-03 00:00:00', '0', null);
