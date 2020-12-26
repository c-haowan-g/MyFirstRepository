/*
Navicat Oracle Data Transfer
Oracle Client Version : 12.2.0.1.0

Source Server         : 虚拟机_42ZAUIJQ0QN5895
Source Server Version : 110200
Source Host           : 42ZAUIJQ0QN5895:1521
Source Schema         : MES

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2018-07-09 11:44:13
*/


-- ----------------------------
-- Table structure for AT_MES_QM_REAS
-- ----------------------------
DROP TABLE "MES"."AT_MES_QM_REAS";
CREATE TABLE "MES"."AT_MES_QM_REAS" (
"SITE_NUM" NUMBER(19) NOT NULL ,
"ATR_KEY" NUMBER(19) NOT NULL ,
"ATR_NAME" VARCHAR2(255 CHAR) NULL ,
"CREATION_TIME" TIMESTAMP(6)  NULL ,
"CREATION_TIME_U" TIMESTAMP(6)  NULL ,
"CREATION_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"LAST_MODIFIED_TIME" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_U" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"PARENT_KEY" NUMBER(19) NULL ,
"PURGE_STATUS" NUMBER(19) NULL ,
"TRX_ID" VARCHAR2(255 CHAR) NULL ,
"XFR_INSERT_PID" NUMBER(19) NULL ,
"XFR_UPDATE_PID" NUMBER(19) NULL ,
"ARCH_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"BANBURYING_S" VARCHAR2(80 CHAR) NULL ,
"CHANGED_BY_S" VARCHAR2(80 CHAR) NULL ,
"CHANGED_TIME_T" TIMESTAMP(6)  NULL ,
"COLLET_CD_DESC_S" VARCHAR2(80 CHAR) NOT NULL ,
"COLLET_CD_S" VARCHAR2(80 CHAR) NOT NULL ,
"CREATED_BY_S" VARCHAR2(80 CHAR) NOT NULL ,
"CREATED_TIME_T" TIMESTAMP(6)  NOT NULL ,
"CURING_S" VARCHAR2(80 CHAR) NULL ,
"DW_IS_WARM_S" VARCHAR2(80 CHAR) NULL ,
"DW_NUM1_I" NUMBER(10) NULL ,
"DW_NUM2_I" NUMBER(10) NULL ,
"DW_RECEIVE_DEPT_S" VARCHAR2(80 CHAR) NULL ,
"DW_WHERE1_S" VARCHAR2(80 CHAR) NULL ,
"DW_WHERE2_S" VARCHAR2(80 CHAR) NULL ,
"DW_WORKSHOP_S" VARCHAR2(80 CHAR) NULL ,
"FRONTEND_S" VARCHAR2(80 CHAR) NULL ,
"HANDLE_S" VARCHAR2(80 CHAR) NULL ,
"MOLDING_S" VARCHAR2(80 CHAR) NULL ,
"RAW_S" VARCHAR2(80 CHAR) NULL ,
"REAS_CD_S" VARCHAR2(80 CHAR) NOT NULL ,
"REAS_DESC_S" VARCHAR2(80 CHAR) NOT NULL ,
"REAS_GRP_DESC_S" VARCHAR2(80 CHAR) NOT NULL ,
"REAS_GRP_TYPE_S" VARCHAR2(80 CHAR) NOT NULL ,
"RECORD_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"S_FACTORY_S" VARCHAR2(80 CHAR) NOT NULL ,
"SPARE1_S" VARCHAR2(80 CHAR) NULL ,
"SPARE2_S" VARCHAR2(80 CHAR) NULL ,
"SPARE3_S" VARCHAR2(80 CHAR) NULL ,
"SPARE4_S" VARCHAR2(80 CHAR) NULL ,
"SPARE5_S" VARCHAR2(80 CHAR) NULL ,
"THERMOMETRIC_S" VARCHAR2(80 CHAR) NULL ,
"TYRE_T_S" VARCHAR2(80 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of AT_MES_QM_REAS
-- ----------------------------

-- ----------------------------
-- Table structure for AT_MES_ZJ_ENT
-- ----------------------------
DROP TABLE "MES"."AT_MES_ZJ_ENT";
CREATE TABLE "MES"."AT_MES_ZJ_ENT" (
"SITE_NUM" NUMBER(19) NOT NULL ,
"ATR_KEY" NUMBER(19) NOT NULL ,
"ATR_NAME" VARCHAR2(255 CHAR) NULL ,
"CREATION_TIME" TIMESTAMP(6)  NULL ,
"CREATION_TIME_U" TIMESTAMP(6)  NULL ,
"CREATION_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"LAST_MODIFIED_TIME" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_U" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"PARENT_KEY" NUMBER(19) NULL ,
"PURGE_STATUS" NUMBER(19) NULL ,
"TRX_ID" VARCHAR2(255 CHAR) NULL ,
"XFR_INSERT_PID" NUMBER(19) NULL ,
"XFR_UPDATE_PID" NUMBER(19) NULL ,
"ARCH_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"CHANGED_BY_S" VARCHAR2(80 CHAR) NULL ,
"CHANGED_TIME_T" TIMESTAMP(6)  NULL ,
"CREATED_BY_S" VARCHAR2(80 CHAR) NOT NULL ,
"CREATED_TIME_T" TIMESTAMP(6)  NOT NULL ,
"ENTBARCODE_S" VARCHAR2(80 CHAR) NOT NULL ,
"ENTNAME_S" VARCHAR2(80 CHAR) NULL ,
"ENTTYPE_I" NUMBER(10) NOT NULL ,
"ISWORK_I" NUMBER(10) NOT NULL ,
"RECORD_FLAG_S" VARCHAR2(80 CHAR) NULL ,
"RIMNO_I" NUMBER(10) NULL ,
"S_FACTORY_S" VARCHAR2(80 CHAR) NOT NULL ,
"SPARE1_S" VARCHAR2(80 CHAR) NULL ,
"SPARE2_S" VARCHAR2(80 CHAR) NULL ,
"SPARE3_S" VARCHAR2(80 CHAR) NULL ,
"SPARE4_S" VARCHAR2(80 CHAR) NULL ,
"SPARE5_S" VARCHAR2(80 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of AT_MES_ZJ_ENT
-- ----------------------------

-- ----------------------------
-- Table structure for AT_MES_ZJ_RECIPE
-- ----------------------------
DROP TABLE "MES"."AT_MES_ZJ_RECIPE";
CREATE TABLE "MES"."AT_MES_ZJ_RECIPE" (
"SITE_NUM" NUMBER(19) NOT NULL ,
"ATR_KEY" NUMBER(19) NOT NULL ,
"ATR_NAME" VARCHAR2(255 CHAR) NULL ,
"CREATION_TIME" TIMESTAMP(6)  NULL ,
"CREATION_TIME_U" TIMESTAMP(6)  NULL ,
"CREATION_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"LAST_MODIFIED_TIME" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_U" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"PARENT_KEY" NUMBER(19) NULL ,
"PURGE_STATUS" NUMBER(19) NULL ,
"TRX_ID" VARCHAR2(255 CHAR) NULL ,
"XFR_INSERT_PID" NUMBER(19) NULL ,
"XFR_UPDATE_PID" NUMBER(19) NULL ,
"ARCH_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"CHANGED_BY_S" VARCHAR2(80 CHAR) NULL ,
"CHANGED_TIME_T" TIMESTAMP(6)  NULL ,
"CREATED_BY_S" VARCHAR2(80 CHAR) NOT NULL ,
"CREATED_TIME_T" TIMESTAMP(6)  NOT NULL ,
"ENTTYPE_I" NUMBER(10) NULL ,
"JUDGEID_I" NUMBER(10) NULL ,
"NUM_I" NUMBER(10) NULL ,
"RECIPENO_S" VARCHAR2(80 CHAR) NULL ,
"RECORD_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"REMARK_S" VARCHAR2(100 CHAR) NULL ,
"S_FACTORY_S" VARCHAR2(80 CHAR) NOT NULL ,
"SPARE1_S" VARCHAR2(80 CHAR) NULL ,
"SPARE2_S" VARCHAR2(80 CHAR) NULL ,
"SPARE3_S" VARCHAR2(80 CHAR) NULL ,
"SPARE4_S" VARCHAR2(80 CHAR) NULL ,
"SPARE5_S" VARCHAR2(80 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of AT_MES_ZJ_RECIPE
-- ----------------------------

-- ----------------------------
-- Table structure for AT_MES_ZJ_RIM
-- ----------------------------
DROP TABLE "MES"."AT_MES_ZJ_RIM";
CREATE TABLE "MES"."AT_MES_ZJ_RIM" (
"SITE_NUM" NUMBER(19) NOT NULL ,
"ATR_KEY" NUMBER(19) NOT NULL ,
"ATR_NAME" VARCHAR2(255 CHAR) NULL ,
"CREATION_TIME" TIMESTAMP(6)  NULL ,
"CREATION_TIME_U" TIMESTAMP(6)  NULL ,
"CREATION_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"LAST_MODIFIED_TIME" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_U" TIMESTAMP(6)  NULL ,
"LAST_MODIFIED_TIME_Z" VARCHAR2(255 CHAR) NULL ,
"PARENT_KEY" NUMBER(19) NULL ,
"PURGE_STATUS" NUMBER(19) NULL ,
"TRX_ID" VARCHAR2(255 CHAR) NULL ,
"XFR_INSERT_PID" NUMBER(19) NULL ,
"XFR_UPDATE_PID" NUMBER(19) NULL ,
"ARCH_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"BORE_S" VARCHAR2(20 CHAR) NOT NULL ,
"CHANGED_BY_S" VARCHAR2(80 CHAR) NULL ,
"CHANGED_TIME_T" TIMESTAMP(6)  NULL ,
"CREATED_BY_S" VARCHAR2(80 CHAR) NOT NULL ,
"CREATED_TIME_T" TIMESTAMP(6)  NOT NULL ,
"ENTTYPE_I" NUMBER(10) NOT NULL ,
"MAXRIM_S" VARCHAR2(20 CHAR) NOT NULL ,
"MINRIM_S" VARCHAR2(20 CHAR) NOT NULL ,
"RECORD_FLAG_S" VARCHAR2(80 CHAR) NOT NULL ,
"RIMNO_S" VARCHAR2(20 CHAR) NOT NULL ,
"S_FACTORY_S" VARCHAR2(20 CHAR) NOT NULL ,
"SPARE1_S" VARCHAR2(20 CHAR) NULL ,
"SPARE2_S" VARCHAR2(20 CHAR) NULL ,
"SPARE3_S" VARCHAR2(20 CHAR) NULL ,
"SPARE4_S" VARCHAR2(20 CHAR) NULL ,
"SPARE5_S" VARCHAR2(20 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of AT_MES_ZJ_RIM
-- ----------------------------

-- ----------------------------
-- Table structure for CORE_DEPARTMENT
-- ----------------------------
DROP TABLE "MES"."CORE_DEPARTMENT";
CREATE TABLE "MES"."CORE_DEPARTMENT" (
"ID" NUMBER(19) NOT NULL ,
"MEMO" VARCHAR2(255 CHAR) NULL ,
"NAME" VARCHAR2(255 CHAR) NOT NULL ,
"PID" NUMBER(19) NULL ,
"SORTNO" NUMBER(10) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "MES"."CORE_DEPARTMENT"."NAME" IS '部门名称';

-- ----------------------------
-- Records of CORE_DEPARTMENT
-- ----------------------------
INSERT INTO "MES"."CORE_DEPARTMENT" VALUES ('2332', null, '研发部', null, null);

-- ----------------------------
-- Table structure for CORE_EXPORT_OPTIONS
-- ----------------------------
DROP TABLE "MES"."CORE_EXPORT_OPTIONS";
CREATE TABLE "MES"."CORE_EXPORT_OPTIONS" (
"ID" NUMBER(19) NOT NULL ,
"ENTITYCLASSNAME" VARCHAR2(255 CHAR) NULL ,
"OPTIONS" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_EXPORT_OPTIONS
-- ----------------------------

-- ----------------------------
-- Table structure for CORE_MENU
-- ----------------------------
DROP TABLE "MES"."CORE_MENU";
CREATE TABLE "MES"."CORE_MENU" (
"ID" NUMBER(19) NOT NULL ,
"CODE" VARCHAR2(255 CHAR) NOT NULL ,
"NAME" VARCHAR2(255 CHAR) NOT NULL ,
"PID" NUMBER(19) NULL ,
"SORTNO" NUMBER(10) NULL ,
"TYPE" NUMBER(10) NOT NULL ,
"URL" VARCHAR2(255 CHAR) NULL ,
"PINYININDEX" VARCHAR2(255 BYTE) NULL ,
"NAME_TH" VARCHAR2(255 BYTE) NULL ,
"NAME_EN" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_MENU
-- ----------------------------
INSERT INTO "MES"."CORE_MENU" VALUES ('2354', 'USER_PERMISSION', '设置权限', '2323', null, '3', null, 'SZQX', 'PERMISSION', 'PERMISSION');
INSERT INTO "MES"."CORE_MENU" VALUES ('2353', 'USER_EDIT', '编辑', '2323', null, '3', null, 'TJ', 'EDIT', 'EDIT');
INSERT INTO "MES"."CORE_MENU" VALUES ('2397', 'SYSTEM_x', 'xxx', '2321', null, '1', null, 'XXX', 'xx', 'xx');
INSERT INTO "MES"."CORE_MENU" VALUES ('2325', 'MENU', '菜单配置', '2321', null, '2', 'view?page=common/menu', 'CDPZ', 'Menu Congifuration', 'Menu Congifuration');
INSERT INTO "MES"."CORE_MENU" VALUES ('2321', 'SYSTEM', '系统配置', null, '1', '1', null, 'XTPZ', 'System Configuration', 'System Configuration');
INSERT INTO "MES"."CORE_MENU" VALUES ('2323', 'USER', '用户管理', '2321', '1', '2', 'view?page=common/user', 'YHGL', 'User Management', 'User Management');
INSERT INTO "MES"."CORE_MENU" VALUES ('2327', 'ROLE', '角色管理', '2321', null, '2', 'view?page=common/role', 'JSGL', 'Role Management', 'Role Management');
INSERT INTO "MES"."CORE_MENU" VALUES ('2330', 'Department', '组织机构', '2321', null, '2', 'view?page=common/menu', 'ZZJG', 'Department Management', 'Department Management');
INSERT INTO "MES"."CORE_MENU" VALUES ('2352', 'USER_ADD', '添加', '2323', null, '3', null, 'TJ', 'Add', 'Add');

-- ----------------------------
-- Table structure for CORE_PERMISSION
-- ----------------------------
DROP TABLE "MES"."CORE_PERMISSION";
CREATE TABLE "MES"."CORE_PERMISSION" (
"ID" NUMBER(19) NOT NULL ,
"ROLEID" NUMBER(19) NULL ,
"USERID" NUMBER(19) NULL ,
"MENUID" NUMBER(19) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_PERMISSION
-- ----------------------------
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2290', null, '2256', '2021');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2291', null, '2256', '2023');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2292', null, '2256', '2025');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2301', null, '2245', '2021');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2302', null, '2245', '2023');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2303', null, '2245', '2025');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2304', null, '2245', '2039');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2391', '2369', null, '2321');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2392', '2369', null, '2323');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2393', '2369', null, '2352');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2394', '2369', null, '2325');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2395', '2369', null, '2330');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2386', null, '2349', '2321');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2387', null, '2349', '2325');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2388', null, '2349', '2330');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2389', null, '2349', '2327');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2175', '2126', null, '2021');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2176', '2126', null, '2023');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2177', '2126', null, '2027');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2178', '2126', null, '2025');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2208', '2125', null, '2021');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2209', '2125', null, '2023');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2210', '2125', null, '2029');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2212', '2122', null, '2021');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2213', '2122', null, '2023');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2214', '2122', null, '2027');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2215', '2122', null, '2029');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2354', '2351', null, '2321');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2355', '2351', null, '2323');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2356', '2351', null, '2352');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2357', '2351', null, '2353');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2358', '2351', null, '2354');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2359', '2351', null, '2325');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2360', '2351', null, '2330');
INSERT INTO "MES"."CORE_PERMISSION" VALUES ('2361', '2351', null, '2327');

-- ----------------------------
-- Table structure for CORE_ROLE
-- ----------------------------
DROP TABLE "MES"."CORE_ROLE";
CREATE TABLE "MES"."CORE_ROLE" (
"ID" NUMBER(19) NOT NULL ,
"DESCRIPTION" VARCHAR2(255 CHAR) NULL ,
"NAME" VARCHAR2(255 CHAR) NULL ,
"SORTNO" NUMBER(10) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_ROLE
-- ----------------------------
INSERT INTO "MES"."CORE_ROLE" VALUES ('2367', null, '查看权限', null);
INSERT INTO "MES"."CORE_ROLE" VALUES ('2368', null, '编辑权限', null);
INSERT INTO "MES"."CORE_ROLE" VALUES ('2369', null, '终检车间权限', null);
INSERT INTO "MES"."CORE_ROLE" VALUES ('2351', null, '系统管理权限', null);

-- ----------------------------
-- Table structure for CORE_SYSTEM_LOG
-- ----------------------------
DROP TABLE "MES"."CORE_SYSTEM_LOG";
CREATE TABLE "MES"."CORE_SYSTEM_LOG" (
"ID" NUMBER(19) NOT NULL ,
"CLAZZ" VARCHAR2(255 CHAR) NULL ,
"IPADDR" VARCHAR2(255 CHAR) NULL ,
"LOGTIME" NUMBER(19) NOT NULL ,
"METHODCODE" VARCHAR2(255 CHAR) NULL ,
"METHODNAME" VARCHAR2(255 CHAR) NULL ,
"MODULECODE" VARCHAR2(255 CHAR) NULL ,
"MODULENAME" VARCHAR2(255 CHAR) NULL ,
"OPERATEUSER" VARCHAR2(255 CHAR) NOT NULL ,
"OPERATION" VARCHAR2(255 CHAR) NOT NULL ,
"PARAMVALUES" VARCHAR2(4000 CHAR) NULL ,
"SPENDTIME" NUMBER(19) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_SYSTEM_LOG
-- ----------------------------
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('656', 'ViewController', '192.168.75.1', '1529478195183', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('657', 'ViewController', '192.168.75.1', '1529478231634', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('658', 'ViewController', '192.168.75.1', '1529478233096', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('659', 'ViewController', '192.168.75.1', '1529478321069', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('660', 'ViewController', '192.168.75.1', '1529478322227', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('661', 'ViewController', '192.168.75.1', '1529478396356', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('662', 'ViewController', '192.168.75.1', '1529478397668', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('663', 'ViewController', '192.168.75.1', '1529478402174', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('664', 'ViewController', '192.168.75.1', '1529478403301', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('665', 'ViewController', '192.168.75.1', '1529478427303', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('666', 'ViewController', '192.168.75.1', '1529478428466', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('667', 'ViewController', '192.168.75.1', '1529478493554', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('668', 'ViewController', '192.168.75.1', '1529478494698', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('669', 'ViewController', '192.168.75.1', '1529478497750', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('670', 'ViewController', '192.168.75.1', '1529478498852', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('671', 'ViewController', '192.168.75.1', '1529478498872', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('672', 'ViewController', '192.168.75.1', '1529478500092', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('673', 'ViewController', '192.168.75.1', '1529478501050', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('674', 'ViewController', '192.168.75.1', '1529478502139', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('675', 'ViewController', '192.168.75.1', '1529478502822', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('676', 'ViewController', '192.168.75.1', '1529478503913', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('677', 'ViewController', '192.168.75.1', '1529478504798', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('678', 'ViewController', '192.168.75.1', '1529478505901', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('679', 'ViewController', '192.168.75.1', '1529478506600', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('680', 'ViewController', '192.168.75.1', '1529478507696', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('681', 'ViewController', '192.168.75.1', '1529478508804', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('682', 'ViewController', '192.168.75.1', '1529478511818', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('683', 'ViewController', '192.168.75.1', '1529478520576', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('684', 'ViewController', '192.168.75.1', '1529478521713', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('685', 'ViewController', '192.168.75.1', '1529478522497', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('686', 'ViewController', '192.168.75.1', '1529478523596', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('687', 'ViewController', '192.168.75.1', '1529478524141', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('688', 'ViewController', '192.168.75.1', '1529478525267', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('689', 'ViewController', '192.168.75.1', '1529478564330', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('690', 'ViewController', '192.168.75.1', '1529478565615', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('691', 'ViewController', '192.168.75.1', '1529478680351', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('692', 'ViewController', '192.168.75.1', '1529478681815', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('693', 'ViewController', '192.168.75.1', '1529478706584', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('694', 'ViewController', '192.168.75.1', '1529478707711', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('695', 'ViewController', '192.168.75.1', '1529478708520', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('696', 'ViewController', '192.168.75.1', '1529478709630', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('697', 'ViewController', '192.168.75.1', '1529478710669', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('698', 'ViewController', '192.168.75.1', '1529478711765', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('699', 'ViewController', '192.168.75.1', '1529478719482', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('700', 'ViewController', '192.168.75.1', '1529478720666', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('701', 'ViewController', '192.168.75.1', '1529478726217', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('702', 'ViewController', '192.168.75.1', '1529478727403', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('703', 'ViewController', '192.168.75.1', '1529478740598', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('704', 'ViewController', '192.168.75.1', '1529478741789', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('705', 'ViewController', '192.168.75.1', '1529478742171', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('706', 'ViewController', '192.168.75.1', '1529478743317', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('707', 'ViewController', '192.168.75.1', '1529478746066', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('708', 'ViewController', '192.168.75.1', '1529478747165', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('709', 'ViewController', '192.168.75.1', '1529478747971', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('710', 'ViewController', '192.168.75.1', '1529478749109', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('711', 'ViewController', '192.168.75.1', '1529478758921', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('712', 'ViewController', '192.168.75.1', '1529478760091', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('713', 'ViewController', '192.168.75.1', '1529478771554', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('714', 'ViewController', '192.168.75.1', '1529478772710', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('715', 'ViewController', '192.168.75.1', '1529478805859', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('716', 'ViewController', '192.168.75.1', '1529478807276', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('717', 'ViewController', '192.168.75.1', '1529478903319', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('718', 'ViewController', '192.168.75.1', '1529478904601', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('719', 'ViewController', '192.168.75.1', '1529478906019', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('720', 'ViewController', '192.168.75.1', '1529478907338', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('721', 'ViewController', '192.168.75.1', '1529478929100', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('458', 'ViewController', '192.168.75.1', '1529473148379', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('459', 'ViewController', '192.168.75.1', '1529473148695', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('460', 'ViewController', '192.168.75.1', '1529473149637', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('461', 'ViewController', '192.168.75.1', '1529473557005', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('462', 'ViewController', '192.168.75.1', '1529473557336', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('463', 'ViewController', '192.168.75.1', '1529473560552', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('464', 'ViewController', '192.168.75.1', '1529473566855', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('465', 'ViewController', '192.168.75.1', '1529473567045', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('466', 'ViewController', '192.168.75.1', '1529473567978', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('467', 'ViewController', '192.168.75.1', '1529473572449', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('468', 'ViewController', '192.168.75.1', '1529473572610', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('469', 'ViewController', '192.168.75.1', '1529473573554', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('470', 'ViewController', '192.168.75.1', '1529473712742', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('471', 'ViewController', '192.168.75.1', '1529473713133', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('472', 'ViewController', '192.168.75.1', '1529473713972', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('473', 'ViewController', '192.168.75.1', '1529473788363', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('474', 'ViewController', '192.168.75.1', '1529473788623', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('475', 'ViewController', '192.168.75.1', '1529473789549', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('476', 'ViewController', '192.168.75.1', '1529473797701', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('477', 'ViewController', '192.168.75.1', '1529473797892', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('478', 'ViewController', '192.168.75.1', '1529473798823', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('479', 'ViewController', '192.168.75.1', '1529473802678', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('480', 'ViewController', '192.168.75.1', '1529473802951', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('481', 'ViewController', '192.168.75.1', '1529473803875', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('482', 'ViewController', '192.168.75.1', '1529474095832', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('483', 'ViewController', '192.168.75.1', '1529474097240', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('484', 'ViewController', '192.168.75.1', '1529474224998', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('485', 'ViewController', '192.168.75.1', '1529474226345', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('486', 'ViewController', '192.168.75.1', '1529474356535', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('487', 'ViewController', '192.168.75.1', '1529474360047', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('488', 'ViewController', '192.168.75.1', '1529474365396', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('489', 'ViewController', '192.168.75.1', '1529474366680', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('490', 'ViewController', '192.168.75.1', '1529474367847', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('491', 'ViewController', '192.168.75.1', '1529474369059', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('492', 'ViewController', '192.168.75.1', '1529474462864', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('493', 'ViewController', '192.168.75.1', '1529474464310', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('494', 'ViewController', '192.168.75.1', '1529474495267', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('495', 'ViewController', '192.168.75.1', '1529474496644', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('496', 'ViewController', '192.168.75.1', '1529474689745', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('497', 'ViewController', '192.168.75.1', '1529474691085', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('498', 'ViewController', '192.168.75.1', '1529474713421', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('499', 'ViewController', '192.168.75.1', '1529474714808', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('500', 'ViewController', '192.168.75.1', '1529474742956', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('501', 'ViewController', '192.168.75.1', '1529474744316', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('502', 'ViewController', '192.168.75.1', '1529474755272', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('503', 'ViewController', '192.168.75.1', '1529474756575', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('504', 'ViewController', '192.168.75.1', '1529474793486', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('505', 'ViewController', '192.168.75.1', '1529474794841', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('506', 'ViewController', '192.168.75.1', '1529474984757', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('507', 'ViewController', '192.168.75.1', '1529474986087', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('508', 'ViewController', '192.168.75.1', '1529475035064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('509', 'ViewController', '192.168.75.1', '1529475036427', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('510', 'ViewController', '192.168.75.1', '1529475068718', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('511', 'ViewController', '192.168.75.1', '1529475070000', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('512', 'ViewController', '192.168.75.1', '1529475168972', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('513', 'ViewController', '192.168.75.1', '1529475170306', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('514', 'ViewController', '192.168.75.1', '1529475212415', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('515', 'ViewController', '192.168.75.1', '1529475213709', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('516', 'ViewController', '192.168.75.1', '1529475219455', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('517', 'ViewController', '192.168.75.1', '1529475220708', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('518', 'ViewController', '192.168.75.1', '1529475272249', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('519', 'ViewController', '192.168.75.1', '1529475273528', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('520', 'ViewController', '192.168.75.1', '1529475324517', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('521', 'ViewController', '192.168.75.1', '1529475325856', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('522', 'ViewController', '192.168.75.1', '1529475334643', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('523', 'ViewController', '192.168.75.1', '1529475337912', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('524', 'ViewController', '192.168.75.1', '1529475338986', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('525', 'ViewController', '192.168.75.1', '1529475340188', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('526', 'ViewController', '192.168.75.1', '1529475386684', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('527', 'ViewController', '192.168.75.1', '1529475388244', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('528', 'ViewController', '192.168.75.1', '1529475446413', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('529', 'ViewController', '192.168.75.1', '1529475447682', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('530', 'ViewController', '192.168.75.1', '1529475565237', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('531', 'ViewController', '192.168.75.1', '1529475566704', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('532', 'ViewController', '192.168.75.1', '1529475601155', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('533', 'ViewController', '192.168.75.1', '1529475602452', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('534', 'ViewController', '192.168.75.1', '1529475608841', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('535', 'ViewController', '192.168.75.1', '1529475609785', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('536', 'ViewController', '192.168.75.1', '1529475611019', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('537', 'ViewController', '192.168.75.1', '1529475659681', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('538', 'ViewController', '192.168.75.1', '1529475660943', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('539', 'ViewController', '192.168.75.1', '1529475666988', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('540', 'ViewController', '192.168.75.1', '1529475668319', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('541', 'ViewController', '192.168.75.1', '1529475674842', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('542', 'ViewController', '192.168.75.1', '1529475774562', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('543', 'ViewController', '192.168.75.1', '1529475775885', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('544', 'ViewController', '192.168.75.1', '1529475791123', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('545', 'ViewController', '192.168.75.1', '1529475792392', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('546', 'ViewController', '192.168.75.1', '1529475800543', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('547', 'ViewController', '192.168.75.1', '1529475801833', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('548', 'ViewController', '192.168.75.1', '1529475807141', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('549', 'ViewController', '192.168.75.1', '1529475859149', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('550', 'ViewController', '192.168.75.1', '1529475860415', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('551', 'ViewController', '192.168.75.1', '1529475866499', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('552', 'ViewController', '192.168.75.1', '1529475867811', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('553', 'ViewController', '192.168.75.1', '1529475876912', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('554', 'ViewController', '192.168.75.1', '1529475878197', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('555', 'ViewController', '192.168.75.1', '1529475956921', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('556', 'ViewController', '192.168.75.1', '1529475958199', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('557', 'ViewController', '192.168.75.1', '1529475972421', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('558', 'ViewController', '192.168.75.1', '1529475973707', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('559', 'ViewController', '192.168.75.1', '1529476041469', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('560', 'ViewController', '192.168.75.1', '1529476042768', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('561', 'ViewController', '192.168.75.1', '1529476076519', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('562', 'ViewController', '192.168.75.1', '1529476077821', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('563', 'ViewController', '192.168.75.1', '1529476142516', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('564', 'ViewController', '192.168.75.1', '1529476143808', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('565', 'ViewController', '192.168.75.1', '1529476144818', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('566', 'ViewController', '192.168.75.1', '1529476146083', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('567', 'ViewController', '192.168.75.1', '1529476146128', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('568', 'ViewController', '192.168.75.1', '1529476147455', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('569', 'ViewController', '192.168.75.1', '1529476280408', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('570', 'ViewController', '192.168.75.1', '1529476281616', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('571', 'ViewController', '192.168.75.1', '1529476332110', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('572', 'ViewController', '192.168.75.1', '1529476334434', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('573', 'ViewController', '192.168.75.1', '1529476342244', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('574', 'ViewController', '192.168.75.1', '1529476344850', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('575', 'ViewController', '192.168.75.1', '1529476358502', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('576', 'ViewController', '192.168.75.1', '1529476359610', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('577', 'ViewController', '192.168.75.1', '1529476361647', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('578', 'ViewController', '192.168.75.1', '1529476362734', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('579', 'ViewController', '192.168.75.1', '1529476372407', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('580', 'ViewController', '192.168.75.1', '1529476373537', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('581', 'ViewController', '192.168.75.1', '1529476373684', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('582', 'ViewController', '192.168.75.1', '1529476375895', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('583', 'ViewController', '192.168.75.1', '1529476376914', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('584', 'ViewController', '192.168.75.1', '1529476378591', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('585', 'ViewController', '192.168.75.1', '1529476380441', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('586', 'ViewController', '192.168.75.1', '1529476381735', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('587', 'ViewController', '192.168.75.1', '1529476382849', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('588', 'ViewController', '192.168.75.1', '1529476431054', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('589', 'ViewController', '192.168.75.1', '1529476432295', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('590', 'ViewController', '192.168.75.1', '1529476438376', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('591', 'ViewController', '192.168.75.1', '1529476439741', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('592', 'ViewController', '192.168.75.1', '1529476448186', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('593', 'ViewController', '192.168.75.1', '1529476449501', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('594', 'ViewController', '192.168.75.1', '1529476473681', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('595', 'ViewController', '192.168.75.1', '1529476474955', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('596', 'ViewController', '192.168.75.1', '1529476512474', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('597', 'ViewController', '192.168.75.1', '1529476513819', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('598', 'ViewController', '192.168.75.1', '1529476539425', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('599', 'ViewController', '192.168.75.1', '1529476540692', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('600', 'ViewController', '192.168.75.1', '1529476579243', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('601', 'ViewController', '192.168.75.1', '1529476580530', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('602', 'ViewController', '192.168.75.1', '1529476598783', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('603', 'ViewController', '192.168.75.1', '1529476600082', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('604', 'ViewController', '192.168.75.1', '1529476766922', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('605', 'ViewController', '192.168.75.1', '1529476768064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('606', 'ViewController', '192.168.75.1', '1529476930106', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('607', 'ViewController', '192.168.75.1', '1529476931405', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('608', 'ViewController', '192.168.75.1', '1529476949476', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('609', 'ViewController', '192.168.75.1', '1529476953773', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('610', 'ViewController', '192.168.75.1', '1529476954883', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('611', 'ViewController', '192.168.75.1', '1529476975683', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('612', 'ViewController', '192.168.75.1', '1529476976825', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('613', 'ViewController', '192.168.75.1', '1529477050026', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('614', 'ViewController', '192.168.75.1', '1529477051163', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('615', 'ViewController', '192.168.75.1', '1529477127858', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('616', 'ViewController', '192.168.75.1', '1529477129046', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('617', 'ViewController', '192.168.75.1', '1529477151039', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('618', 'ViewController', '192.168.75.1', '1529477152157', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('619', 'ViewController', '192.168.75.1', '1529477196735', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('620', 'ViewController', '192.168.75.1', '1529477197949', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('621', 'ViewController', '192.168.75.1', '1529477240873', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('622', 'ViewController', '192.168.75.1', '1529477242013', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('623', 'ViewController', '192.168.75.1', '1529477248870', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('624', 'ViewController', '192.168.75.1', '1529477250135', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('625', 'ViewController', '192.168.75.1', '1529477325631', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('626', 'ViewController', '192.168.75.1', '1529477326966', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('627', 'ViewController', '192.168.75.1', '1529477343313', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('628', 'ViewController', '192.168.75.1', '1529477344673', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('629', 'ViewController', '192.168.75.1', '1529477352549', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('630', 'ViewController', '192.168.75.1', '1529477353903', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('631', 'ViewController', '192.168.75.1', '1529477358744', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('632', 'ViewController', '192.168.75.1', '1529477360064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('633', 'ViewController', '192.168.75.1', '1529477489609', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('634', 'ViewController', '192.168.75.1', '1529477491129', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('635', 'ViewController', '192.168.75.1', '1529477506422', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('636', 'ViewController', '192.168.75.1', '1529477507550', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('637', 'ViewController', '192.168.75.1', '1529477577001', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('638', 'ViewController', '192.168.75.1', '1529477578145', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('639', 'ViewController', '192.168.75.1', '1529477591832', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('640', 'ViewController', '192.168.75.1', '1529477592943', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('641', 'ViewController', '192.168.75.1', '1529477795611', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('642', 'ViewController', '192.168.75.1', '1529477796775', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('643', 'ViewController', '192.168.75.1', '1529477898695', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('644', 'ViewController', '192.168.75.1', '1529477900005', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('645', 'ViewController', '192.168.75.1', '1529477912861', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('646', 'ViewController', '192.168.75.1', '1529477914121', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('647', 'ViewController', '192.168.75.1', '1529477918109', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('648', 'ViewController', '192.168.75.1', '1529477919239', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('649', 'ViewController', '192.168.75.1', '1529478054257', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('650', 'ViewController', '192.168.75.1', '1529478055568', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('651', 'ViewController', '192.168.75.1', '1529478079437', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('652', 'ViewController', '192.168.75.1', '1529478080711', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('653', 'ViewController', '192.168.75.1', '1529478103020', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('654', 'ViewController', '192.168.75.1', '1529478105859', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('655', 'ViewController', '192.168.75.1', '1529478193899', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('394', 'ViewController', '192.168.75.1', '1529472598140', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('392', 'ViewController', '192.168.75.1', '1529472597028', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('393', 'ViewController', '192.168.75.1', '1529472597196', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('395', 'ViewController', '192.168.75.1', '1529472609629', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('396', 'ViewController', '192.168.75.1', '1529472609832', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('397', 'ViewController', '192.168.75.1', '1529472610759', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('398', 'ViewController', '192.168.75.1', '1529472624876', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('399', 'ViewController', '192.168.75.1', '1529472625117', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('400', 'ViewController', '192.168.75.1', '1529472626038', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('401', 'ViewController', '192.168.75.1', '1529472628143', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('402', 'ViewController', '192.168.75.1', '1529472628281', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('403', 'ViewController', '192.168.75.1', '1529472629230', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('404', 'ViewController', '192.168.75.1', '1529472629371', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('405', 'ViewController', '192.168.75.1', '1529472629532', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('406', 'ViewController', '192.168.75.1', '1529472630192', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('407', 'ViewController', '192.168.75.1', '1529472630330', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('408', 'ViewController', '192.168.75.1', '1529472630770', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('409', 'ViewController', '192.168.75.1', '1529472630913', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('410', 'ViewController', '192.168.75.1', '1529472631092', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('411', 'ViewController', '192.168.75.1', '1529472631236', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('412', 'ViewController', '192.168.75.1', '1529472631416', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('413', 'ViewController', '192.168.75.1', '1529472631553', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('414', 'ViewController', '192.168.75.1', '1529472631686', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('415', 'ViewController', '192.168.75.1', '1529472631874', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('416', 'ViewController', '192.168.75.1', '1529472631984', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('417', 'ViewController', '192.168.75.1', '1529472632149', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('418', 'ViewController', '192.168.75.1', '1529472633094', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('419', 'ViewController', '192.168.75.1', '1529472646416', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('420', 'ViewController', '192.168.75.1', '1529472646572', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('421', 'ViewController', '192.168.75.1', '1529472647517', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('422', 'ViewController', '192.168.75.1', '1529472666788', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('423', 'ViewController', '192.168.75.1', '1529472666963', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('424', 'ViewController', '192.168.75.1', '1529472667896', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('425', 'ViewController', '192.168.75.1', '1529472686633', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('426', 'ViewController', '192.168.75.1', '1529472686786', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('427', 'ViewController', '192.168.75.1', '1529472687745', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('428', 'ViewController', '192.168.75.1', '1529472730529', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('429', 'ViewController', '192.168.75.1', '1529472730723', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('430', 'ViewController', '192.168.75.1', '1529472731656', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('431', 'ViewController', '192.168.75.1', '1529472758286', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('432', 'ViewController', '192.168.75.1', '1529472758458', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('433', 'ViewController', '192.168.75.1', '1529472759388', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('434', 'ViewController', '192.168.75.1', '1529472772196', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('435', 'ViewController', '192.168.75.1', '1529472772368', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('436', 'ViewController', '192.168.75.1', '1529472773305', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('437', 'ViewController', '192.168.75.1', '1529472839833', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('438', 'ViewController', '192.168.75.1', '1529472840159', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('439', 'ViewController', '192.168.75.1', '1529472841122', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('440', 'ViewController', '192.168.75.1', '1529472872483', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('441', 'ViewController', '192.168.75.1', '1529472872987', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('442', 'ViewController', '192.168.75.1', '1529472873914', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('443', 'ViewController', '192.168.75.1', '1529472910840', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('444', 'ViewController', '192.168.75.1', '1529472911169', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('445', 'ViewController', '192.168.75.1', '1529472912087', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('446', 'ViewController', '192.168.75.1', '1529473007547', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('447', 'ViewController', '192.168.75.1', '1529473008171', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('448', 'ViewController', '192.168.75.1', '1529473009092', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('449', 'ViewController', '192.168.75.1', '1529473039623', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('450', 'ViewController', '192.168.75.1', '1529473039981', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('451', 'ViewController', '192.168.75.1', '1529473040917', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('452', 'ViewController', '192.168.75.1', '1529473048313', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('453', 'ViewController', '192.168.75.1', '1529473048609', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('454', 'ViewController', '192.168.75.1', '1529473049559', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('455', 'ViewController', '192.168.75.1', '1529473085886', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('456', 'ViewController', '192.168.75.1', '1529473086171', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('457', 'ViewController', '192.168.75.1', '1529473087107', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('854', 'ViewController', '172.20.10.2', '1529484413147', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('855', 'ViewController', '172.20.10.2', '1529484414554', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('856', 'ViewController', '172.20.10.2', '1529484417649', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('857', 'ViewController', '172.20.10.2', '1529484418861', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('858', 'ViewController', '172.20.10.2', '1529484461962', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('859', 'ViewController', '172.20.10.2', '1529484463288', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('860', 'ViewController', '172.20.10.2', '1529484772627', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('861', 'ViewController', '172.20.10.2', '1529484773970', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('862', 'ViewController', '172.20.10.2', '1529484784665', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('863', 'ViewController', '172.20.10.2', '1529484785802', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('864', 'ViewController', '172.20.10.2', '1529484796014', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('865', 'ViewController', '172.20.10.2', '1529484797313', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('866', 'ViewController', '172.20.10.2', '1529484801126', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('867', 'ViewController', '172.20.10.2', '1529484802225', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('868', 'ViewController', '172.20.10.2', '1529484895170', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('869', 'ViewController', '172.20.10.2', '1529484896414', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('870', 'ViewController', '172.20.10.2', '1529484991126', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('871', 'ViewController', '172.20.10.2', '1529484992446', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('872', 'ViewController', '172.20.10.2', '1529485099063', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('873', 'ViewController', '172.20.10.2', '1529485100383', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('874', 'ViewController', '172.20.10.2', '1529485182479', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('875', 'ViewController', '172.20.10.2', '1529485183800', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('876', 'ViewController', '172.20.10.2', '1529485201099', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('877', 'ViewController', '172.20.10.2', '1529485202348', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('878', 'ViewController', '172.20.10.2', '1529485243107', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('879', 'ViewController', '172.20.10.2', '1529485244386', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('880', 'ViewController', '172.20.10.2', '1529485246876', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('881', 'ViewController', '172.20.10.2', '1529485263298', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('882', 'ViewController', '172.20.10.2', '1529485264571', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('883', 'ViewController', '172.20.10.2', '1529485297204', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('884', 'ViewController', '172.20.10.2', '1529485298458', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('885', 'ViewController', '172.20.10.2', '1529485308686', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('886', 'ViewController', '172.20.10.2', '1529485309935', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('887', 'ViewController', '172.20.10.2', '1529485343396', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('888', 'ViewController', '172.20.10.2', '1529485344665', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('889', 'ViewController', '172.20.10.2', '1529485355543', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('890', 'ViewController', '172.20.10.2', '1529485356797', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('891', 'ViewController', '172.20.10.2', '1529485361167', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('892', 'ViewController', '172.20.10.2', '1529485362426', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('893', 'ViewController', '172.20.10.2', '1529485365564', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('894', 'ViewController', '172.20.10.2', '1529485366779', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('895', 'ViewController', '172.20.10.2', '1529485577207', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('896', 'ViewController', '172.20.10.2', '1529485578618', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('897', 'ViewController', '172.20.10.2', '1529485589606', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('898', 'ViewController', '172.20.10.2', '1529485590907', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('899', 'ViewController', '172.20.10.2', '1529485603776', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('900', 'ViewController', '172.20.10.2', '1529485604935', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('901', 'ViewController', '172.20.10.2', '1529485784129', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('902', 'ViewController', '172.20.10.2', '1529485785499', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('903', 'ViewController', '172.20.10.2', '1529485796201', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('904', 'ViewController', '172.20.10.2', '1529485797468', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('905', 'ViewController', '172.20.10.2', '1529485862882', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('906', 'ViewController', '172.20.10.2', '1529485915663', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('907', 'ViewController', '172.20.10.2', '1529485916992', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('908', 'ViewController', '172.20.10.2', '1529485928196', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('909', 'ViewController', '172.20.10.2', '1529485929308', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('910', 'ViewController', '172.20.10.2', '1529485929835', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('911', 'ViewController', '172.20.10.2', '1529485930717', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('912', 'ViewController', '172.20.10.2', '1529485931869', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('913', 'ViewController', '172.20.10.2', '1529485932017', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('914', 'ViewController', '172.20.10.2', '1529485933183', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('915', 'ViewController', '172.20.10.2', '1529485948088', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('916', 'ViewController', '172.20.10.2', '1529485949368', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('917', 'ViewController', '172.20.10.2', '1529485959105', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('918', 'ViewController', '172.20.10.2', '1529485960353', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('919', 'ViewController', '172.20.10.2', '1529485976451', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('920', 'ViewController', '172.20.10.2', '1529485977614', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1023', 'ViewController', '172.20.10.2', '1529541133189', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1024', 'ViewController', '172.20.10.2', '1529541135805', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1025', 'ViewController', '172.20.10.2', '1529541305920', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1026', 'ViewController', '172.20.10.2', '1529541307282', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1027', 'ViewController', '172.20.10.2', '1529541358864', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1028', 'ViewController', '172.20.10.2', '1529541360183', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1029', 'ViewController', '172.20.10.2', '1529541374716', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1030', 'ViewController', '172.20.10.2', '1529541376013', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1031', 'ViewController', '172.20.10.2', '1529541708996', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1032', 'ViewController', '172.20.10.2', '1529541710344', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1033', 'ViewController', '172.20.10.2', '1529541740808', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1034', 'ViewController', '172.20.10.2', '1529541742064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1035', 'ViewController', '172.20.10.2', '1529541751594', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1036', 'ViewController', '172.20.10.2', '1529541752879', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1037', 'ViewController', '172.20.10.2', '1529541766329', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1038', 'ViewController', '172.20.10.2', '1529541767641', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1039', 'ViewController', '172.20.10.2', '1529541776611', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1040', 'ViewController', '172.20.10.2', '1529541777888', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1041', 'ViewController', '172.20.10.2', '1529541789482', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1042', 'ViewController', '172.20.10.2', '1529541790748', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1043', 'ViewController', '172.20.10.2', '1529541806831', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1044', 'ViewController', '172.20.10.2', '1529541808106', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1045', 'ViewController', '172.20.10.2', '1529541821884', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1046', 'ViewController', '172.20.10.2', '1529541823164', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1047', 'ViewController', '172.20.10.2', '1529541836294', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1048', 'ViewController', '172.20.10.2', '1529541837575', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1049', 'ViewController', '172.20.10.2', '1529542122198', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1050', 'ViewController', '172.20.10.2', '1529542123476', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1051', 'ViewController', '172.20.10.2', '1529542233201', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1052', 'ViewController', '172.20.10.2', '1529542234494', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1053', 'ViewController', '172.20.10.2', '1529542254356', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1054', 'ViewController', '172.20.10.2', '1529542255680', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1055', 'ViewController', '172.20.10.2', '1529542280731', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1056', 'ViewController', '172.20.10.2', '1529542282104', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1057', 'ViewController', '172.20.10.2', '1529542291372', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1058', 'ViewController', '172.20.10.2', '1529542292668', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1059', 'ViewController', '172.20.10.2', '1529542365327', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1060', 'ViewController', '172.20.10.2', '1529542366608', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1061', 'ViewController', '172.20.10.2', '1529542386296', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1062', 'ViewController', '172.20.10.2', '1529542387643', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1063', 'ViewController', '172.20.10.2', '1529542477506', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1064', 'ViewController', '172.20.10.2', '1529542478798', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1065', 'ViewController', '172.20.10.2', '1529542597745', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1066', 'ViewController', '172.20.10.2', '1529542599179', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1067', 'ViewController', '172.20.10.2', '1529542607117', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1068', 'ViewController', '172.20.10.2', '1529542608558', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1069', 'ViewController', '172.20.10.2', '1529542633879', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1070', 'ViewController', '172.20.10.2', '1529542635298', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1071', 'ViewController', '172.20.10.2', '1529542651883', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1072', 'ViewController', '172.20.10.2', '1529542653279', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1073', 'ViewController', '172.20.10.2', '1529543873381', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1074', 'ViewController', '172.20.10.2', '1529543874796', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1075', 'ViewController', '172.20.10.2', '1529544241161', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1076', 'ViewController', '172.20.10.2', '1529544242574', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1077', 'ViewController', '172.20.10.2', '1529544375275', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1078', 'ViewController', '172.20.10.2', '1529544376540', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1079', 'ViewController', '172.20.10.2', '1529544396419', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1080', 'ViewController', '172.20.10.2', '1529544397712', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1081', 'ViewController', '172.20.10.2', '1529544700648', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1082', 'ViewController', '172.20.10.2', '1529544701913', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1083', 'ViewController', '172.20.10.2', '1529544710680', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1084', 'ViewController', '172.20.10.2', '1529544711933', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1085', 'ViewController', '172.20.10.2', '1529544802004', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1086', 'ViewController', '172.20.10.2', '1529544803245', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1087', 'ViewController', '172.20.10.2', '1529544833961', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1088', 'ViewController', '172.20.10.2', '1529544962785', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1089', 'ViewController', '172.20.10.2', '1529544964074', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1090', 'ViewController', '172.20.10.2', '1529545079413', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1091', 'ViewController', '172.20.10.2', '1529545080681', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1092', 'ViewController', '172.20.10.2', '1529545144799', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1093', 'ViewController', '172.20.10.2', '1529545146083', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1094', 'ViewController', '172.20.10.2', '1529545437753', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1095', 'ViewController', '172.20.10.2', '1529545439049', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1096', 'ViewController', '172.20.10.2', '1529545639357', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1097', 'ViewController', '172.20.10.2', '1529545640659', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1098', 'ViewController', '172.20.10.2', '1529545644953', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1099', 'ViewController', '172.20.10.2', '1529545646300', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1100', 'ViewController', '172.20.10.2', '1529545700569', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1101', 'ViewController', '172.20.10.2', '1529545701987', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1102', 'ViewController', '172.20.10.2', '1529545715043', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1103', 'ViewController', '172.20.10.2', '1529545716462', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1104', 'ViewController', '172.20.10.2', '1529545720233', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1105', 'ViewController', '172.20.10.2', '1529545721548', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1106', 'ViewController', '172.20.10.2', '1529545805371', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1107', 'ViewController', '172.20.10.2', '1529545806634', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1108', 'ViewController', '172.20.10.2', '1529545807154', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1109', 'ViewController', '172.20.10.2', '1529545808438', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1110', 'ViewController', '172.20.10.2', '1529545809713', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1111', 'ViewController', '172.20.10.2', '1529545811015', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1112', 'ViewController', '172.20.10.2', '1529545883205', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1113', 'ViewController', '172.20.10.2', '1529545884622', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1114', 'ViewController', '172.20.10.2', '1529546024511', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1115', 'ViewController', '172.20.10.2', '1529546025974', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1116', 'ViewController', '172.20.10.2', '1529546079202', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1117', 'ViewController', '172.20.10.2', '1529546080488', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1118', 'ViewController', '172.20.10.2', '1529546114545', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1119', 'ViewController', '172.20.10.2', '1529546115824', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1120', 'ViewController', '172.20.10.2', '1529546214691', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1121', 'ViewController', '172.20.10.2', '1529546215984', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1122', 'ViewController', '172.20.10.2', '1529546253778', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1123', 'ViewController', '172.20.10.2', '1529546255123', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1124', 'ViewController', '172.20.10.2', '1529546317261', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1125', 'ViewController', '172.20.10.2', '1529546318707', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1126', 'ViewController', '172.20.10.2', '1529546421312', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1127', 'ViewController', '172.20.10.2', '1529546422470', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1128', 'ViewController', '172.20.10.2', '1529546431300', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1129', 'ViewController', '172.20.10.2', '1529546432447', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1130', 'ViewController', '172.20.10.2', '1529546443014', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1131', 'ViewController', '172.20.10.2', '1529546444254', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1132', 'ViewController', '172.20.10.2', '1529546495775', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1133', 'ViewController', '172.20.10.2', '1529546497157', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1134', 'ViewController', '172.20.10.2', '1529546547472', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1135', 'ViewController', '172.20.10.2', '1529546548822', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1136', 'ViewController', '172.20.10.2', '1529546596668', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1137', 'ViewController', '172.20.10.2', '1529546597815', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1138', 'ViewController', '172.20.10.2', '1529546701726', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1139', 'ViewController', '172.20.10.2', '1529546702866', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1140', 'ViewController', '172.20.10.2', '1529546727389', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1141', 'ViewController', '172.20.10.2', '1529546728505', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1142', 'ViewController', '172.20.10.2', '1529546751933', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1143', 'ViewController', '172.20.10.2', '1529546753052', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1144', 'ViewController', '172.20.10.2', '1529546762156', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1145', 'ViewController', '172.20.10.2', '1529546763272', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1146', 'ViewController', '172.20.10.2', '1529546822463', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1147', 'ViewController', '172.20.10.2', '1529546823703', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1148', 'ViewController', '172.20.10.2', '1529546828538', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1149', 'ViewController', '172.20.10.2', '1529546829785', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1150', 'ViewController', '172.20.10.2', '1529546839437', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1151', 'ViewController', '172.20.10.2', '1529546840765', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1152', 'ViewController', '172.20.10.2', '1529546903713', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1153', 'ViewController', '172.20.10.2', '1529546904972', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1154', 'ViewController', '172.20.10.2', '1529546910201', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1155', 'ViewController', '172.20.10.2', '1529546911437', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1156', 'ViewController', '172.20.10.2', '1529546955744', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('981', 'ViewController', '192.168.75.1', '1529538497652', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '6');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('982', 'ViewController', '192.168.75.1', '1529538500348', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('983', 'ViewController', '172.20.10.2', '1529538923844', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('984', 'ViewController', '172.20.10.2', '1529538925098', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('985', 'ViewController', '172.20.10.2', '1529540021761', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('986', 'ViewController', '172.20.10.2', '1529540023068', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('987', 'ViewController', '172.20.10.2', '1529540023994', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('988', 'ViewController', '172.20.10.2', '1529540025247', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('989', 'ViewController', '172.20.10.2', '1529540026556', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('990', 'ViewController', '172.20.10.2', '1529540027883', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('991', 'ViewController', '172.20.10.2', '1529540138876', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('992', 'ViewController', '172.20.10.2', '1529540141094', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('993', 'ViewController', '172.20.10.2', '1529540172548', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('994', 'ViewController', '172.20.10.2', '1529540173815', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('995', 'ViewController', '172.20.10.2', '1529540174768', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('996', 'ViewController', '172.20.10.2', '1529540176046', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('997', 'ViewController', '172.20.10.2', '1529540200619', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('998', 'ViewController', '172.20.10.2', '1529540201931', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('999', 'ViewController', '172.20.10.2', '1529540203239', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1000', 'ViewController', '172.20.10.2', '1529540204524', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1001', 'ViewController', '172.20.10.2', '1529540204965', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1002', 'ViewController', '172.20.10.2', '1529540206317', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1003', 'ViewController', '172.20.10.2', '1529540394234', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1004', 'ViewController', '172.20.10.2', '1529540395480', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1005', 'ViewController', '172.20.10.2', '1529540396931', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1006', 'ViewController', '172.20.10.2', '1529540398203', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1007', 'ViewController', '172.20.10.2', '1529540405100', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1008', 'ViewController', '172.20.10.2', '1529540406380', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1009', 'ViewController', '172.20.10.2', '1529540425727', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1010', 'ViewController', '172.20.10.2', '1529540427008', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1011', 'ViewController', '172.20.10.2', '1529540472199', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1012', 'ViewController', '172.20.10.2', '1529540473531', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1013', 'ViewController', '172.20.10.2', '1529540500351', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1014', 'ViewController', '172.20.10.2', '1529540501640', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1015', 'ViewController', '172.20.10.2', '1529540505323', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1016', 'ViewController', '172.20.10.2', '1529540506504', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1017', 'ViewController', '172.20.10.2', '1529540608868', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1018', 'ViewController', '172.20.10.2', '1529540610120', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1019', 'ViewController', '172.20.10.2', '1529540724935', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1020', 'ViewController', '172.20.10.2', '1529540726222', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1021', 'ViewController', '172.20.10.2', '1529540784751', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1022', 'ViewController', '172.20.10.2', '1529540786078', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1180', 'ViewController', '192.168.75.1', '1529547507407', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1181', 'ViewController', '192.168.75.1', '1529547508639', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1182', 'ViewController', '192.168.75.1', '1529547512718', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1183', 'ViewController', '192.168.75.1', '1529547513873', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1184', 'ViewController', '192.168.75.1', '1529547533623', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1185', 'ViewController', '192.168.75.1', '1529547534795', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1186', 'ViewController', '192.168.75.1', '1529547630022', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1187', 'ViewController', '192.168.75.1', '1529547631189', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1188', 'ViewController', '192.168.75.1', '1529547647336', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1189', 'ViewController', '192.168.75.1', '1529547648460', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1190', 'ViewController', '192.168.75.1', '1529547662333', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1191', 'ViewController', '192.168.75.1', '1529547663500', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1192', 'ViewController', '192.168.75.1', '1529547673189', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1193', 'ViewController', '192.168.75.1', '1529547674306', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1194', 'ViewController', '192.168.75.1', '1529547677041', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1195', 'ViewController', '192.168.75.1', '1529547678122', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1196', 'ViewController', '192.168.75.1', '1529547696738', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1197', 'ViewController', '192.168.75.1', '1529547697851', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1198', 'ViewController', '192.168.75.1', '1529547705499', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1199', 'ViewController', '192.168.75.1', '1529547706604', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1200', 'ViewController', '192.168.75.1', '1529547739097', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1201', 'ViewController', '192.168.75.1', '1529547740205', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1202', 'ViewController', '192.168.75.1', '1529547760772', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1203', 'ViewController', '192.168.75.1', '1529547761910', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1204', 'ViewController', '192.168.75.1', '1529547782267', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1205', 'ViewController', '192.168.75.1', '1529547783405', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1206', 'ViewController', '192.168.75.1', '1529547795563', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1207', 'ViewController', '192.168.75.1', '1529547796693', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1208', 'ViewController', '192.168.75.1', '1529547799706', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1209', 'ViewController', '192.168.75.1', '1529547800893', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1210', 'ViewController', '192.168.75.1', '1529548395692', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1211', 'ViewController', '192.168.75.1', '1529548397119', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1212', 'ViewController', '192.168.75.1', '1529548419734', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1213', 'ViewController', '192.168.75.1', '1529548421008', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1214', 'ViewController', '192.168.75.1', '1529548486584', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1215', 'ViewController', '192.168.75.1', '1529548487897', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1216', 'ViewController', '192.168.75.1', '1529548504640', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1217', 'ViewController', '192.168.75.1', '1529548505926', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1218', 'ViewController', '192.168.75.1', '1529548513835', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1219', 'ViewController', '192.168.75.1', '1529548514948', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1220', 'ViewController', '192.168.75.1', '1529548517119', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1221', 'ViewController', '192.168.75.1', '1529548518294', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1222', 'ViewController', '192.168.75.1', '1529548529328', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1223', 'ViewController', '192.168.75.1', '1529548530467', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1224', 'ViewController', '192.168.75.1', '1529548537900', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1225', 'ViewController', '192.168.75.1', '1529548539006', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1226', 'ViewController', '192.168.75.1', '1529548567420', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1227', 'ViewController', '192.168.75.1', '1529548568704', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1228', 'ViewController', '192.168.75.1', '1529548597622', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1229', 'ViewController', '192.168.75.1', '1529548598774', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1230', 'ViewController', '192.168.75.1', '1529548607090', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1231', 'ViewController', '192.168.75.1', '1529548608204', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1232', 'ViewController', '192.168.75.1', '1529548640042', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1233', 'ViewController', '192.168.75.1', '1529548641299', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1234', 'ViewController', '192.168.75.1', '1529548732109', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1235', 'ViewController', '192.168.75.1', '1529548733560', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1236', 'ViewController', '192.168.75.1', '1529548748220', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1237', 'ViewController', '192.168.75.1', '1529548749483', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1238', 'ViewController', '192.168.75.1', '1529548817417', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1239', 'ViewController', '192.168.75.1', '1529548818681', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1240', 'ViewController', '192.168.75.1', '1529548899054', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1241', 'ViewController', '192.168.75.1', '1529548900336', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1242', 'ViewController', '192.168.75.1', '1529548950699', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1243', 'ViewController', '192.168.75.1', '1529548951967', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1244', 'ViewController', '192.168.75.1', '1529548958339', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1245', 'ViewController', '192.168.75.1', '1529548959576', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1246', 'ViewController', '192.168.75.1', '1529549076203', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1247', 'ViewController', '192.168.75.1', '1529549077482', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1248', 'ViewController', '192.168.75.1', '1529549152135', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1249', 'ViewController', '192.168.75.1', '1529549153479', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1250', 'ViewController', '192.168.75.1', '1529549186365', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1251', 'ViewController', '192.168.75.1', '1529549187698', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1252', 'ViewController', '192.168.75.1', '1529549234013', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1253', 'ViewController', '192.168.75.1', '1529549235300', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1254', 'ViewController', '192.168.75.1', '1529549370114', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1255', 'ViewController', '192.168.75.1', '1529549371266', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1256', 'ViewController', '192.168.75.1', '1529549862607', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1257', 'ViewController', '192.168.75.1', '1529549863887', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1258', 'ViewController', '192.168.75.1', '1529549987698', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1259', 'ViewController', '192.168.75.1', '1529549989428', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1260', 'ViewController', '192.168.75.1', '1529550034136', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1261', 'ViewController', '192.168.75.1', '1529550035575', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1262', 'ViewController', '192.168.75.1', '1529550118490', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1263', 'ViewController', '192.168.75.1', '1529550120029', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1264', 'ViewController', '192.168.75.1', '1529550148737', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1265', 'ViewController', '192.168.75.1', '1529550150222', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1266', 'ViewController', '192.168.75.1', '1529550157534', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1267', 'ViewController', '192.168.75.1', '1529550158913', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1268', 'ViewController', '192.168.75.1', '1529550181817', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1269', 'ViewController', '192.168.75.1', '1529550183236', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1270', 'ViewController', '192.168.75.1', '1529550184606', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('921', 'ViewController', '172.20.10.2', '1529486022408', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('922', 'ViewController', '172.20.10.2', '1529486023708', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('923', 'ViewController', '172.20.10.2', '1529486230157', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('924', 'ViewController', '172.20.10.2', '1529486231354', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('925', 'ViewController', '172.20.10.2', '1529486277370', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('926', 'ViewController', '172.20.10.2', '1529486278887', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('927', 'ViewController', '172.20.10.2', '1529486339088', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('928', 'ViewController', '172.20.10.2', '1529486340601', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('929', 'ViewController', '172.20.10.2', '1529486348456', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('930', 'ViewController', '172.20.10.2', '1529486349886', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('931', 'ViewController', '172.20.10.2', '1529486353987', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('932', 'ViewController', '172.20.10.2', '1529486355435', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('933', 'ViewController', '172.20.10.2', '1529486373042', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('934', 'ViewController', '172.20.10.2', '1529486374501', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('935', 'ViewController', '172.20.10.2', '1529486378537', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('936', 'ViewController', '172.20.10.2', '1529486379947', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('937', 'ViewController', '172.20.10.2', '1529486384587', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('938', 'ViewController', '172.20.10.2', '1529486386035', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('939', 'ViewController', '172.20.10.2', '1529486390664', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('940', 'ViewController', '172.20.10.2', '1529486392064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('941', 'ViewController', '172.20.10.2', '1529486454834', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('942', 'ViewController', '172.20.10.2', '1529486456010', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('943', 'ViewController', '172.20.10.2', '1529486468552', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('944', 'ViewController', '172.20.10.2', '1529486469673', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('945', 'ViewController', '172.20.10.2', '1529486479521', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('946', 'ViewController', '172.20.10.2', '1529486480650', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('947', 'ViewController', '172.20.10.2', '1529486496565', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('948', 'ViewController', '172.20.10.2', '1529486497701', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('949', 'ViewController', '172.20.10.2', '1529486816305', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('950', 'ViewController', '172.20.10.2', '1529486817670', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('951', 'ViewController', '172.20.10.2', '1529487488900', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('952', 'ViewController', '172.20.10.2', '1529487490193', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('953', 'ViewController', '172.20.10.2', '1529487491961', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('954', 'ViewController', '172.20.10.2', '1529487493287', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('955', 'ViewController', '172.20.10.2', '1529487504213', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('956', 'ViewController', '172.20.10.2', '1529487505524', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('957', 'ViewController', '172.20.10.2', '1529487527799', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('958', 'ViewController', '172.20.10.2', '1529487529120', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('959', 'ViewController', '172.20.10.2', '1529487583340', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('960', 'ViewController', '172.20.10.2', '1529487584609', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('961', 'ViewController', '172.20.10.2', '1529487682550', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('962', 'ViewController', '172.20.10.2', '1529487683945', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('963', 'ViewController', '172.20.10.2', '1529487734075', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('964', 'ViewController', '172.20.10.2', '1529487735497', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1157', 'ViewController', '172.20.10.2', '1529546956920', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1158', 'ViewController', '172.20.10.2', '1529546967296', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1159', 'ViewController', '172.20.10.2', '1529546968425', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1160', 'ViewController', '172.20.10.2', '1529546993597', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1161', 'ViewController', '172.20.10.2', '1529546994851', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1162', 'ViewController', '172.20.10.2', '1529547053790', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1163', 'ViewController', '172.20.10.2', '1529547055045', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1164', 'ViewController', '172.20.10.2', '1529547116863', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1165', 'ViewController', '172.20.10.2', '1529547118020', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1166', 'ViewController', '172.20.10.2', '1529547198527', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1167', 'ViewController', '172.20.10.2', '1529547199695', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1168', 'ViewController', '172.20.10.2', '1529547212378', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1169', 'ViewController', '172.20.10.2', '1529547213575', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1170', 'ViewController', '172.20.10.2', '1529547274811', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1171', 'ViewController', '172.20.10.2', '1529547275985', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1172', 'ViewController', '172.20.10.2', '1529547297856', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1173', 'ViewController', '172.20.10.2', '1529547299076', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1174', 'ViewController', '172.20.10.2', '1529547368443', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1175', 'ViewController', '172.20.10.2', '1529547369636', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1176', 'ViewController', '172.20.10.2', '1529547419481', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1177', 'ViewController', '172.20.10.2', '1529547420610', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1178', 'ViewController', '172.20.10.2', '1529547425183', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1179', 'ViewController', '172.20.10.2', '1529547426390', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('722', 'ViewController', '192.168.75.1', '1529478930356', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('723', 'ViewController', '192.168.75.1', '1529478935008', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('724', 'ViewController', '192.168.75.1', '1529478936366', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('725', 'ViewController', '192.168.75.1', '1529478969496', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('726', 'ViewController', '192.168.75.1', '1529478970783', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('727', 'ViewController', '192.168.75.1', '1529478988158', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('728', 'ViewController', '192.168.75.1', '1529478989385', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('729', 'ViewController', '192.168.75.1', '1529479000877', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('730', 'ViewController', '192.168.75.1', '1529479002024', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('731', 'ViewController', '192.168.75.1', '1529479011330', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('732', 'ViewController', '192.168.75.1', '1529479012459', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('733', 'ViewController', '192.168.75.1', '1529479018837', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('734', 'ViewController', '192.168.75.1', '1529479019941', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('735', 'ViewController', '192.168.75.1', '1529479025751', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('736', 'ViewController', '192.168.75.1', '1529479026862', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('737', 'ViewController', '192.168.75.1', '1529479027195', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('738', 'ViewController', '192.168.75.1', '1529479028357', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('739', 'ViewController', '192.168.75.1', '1529479035933', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('740', 'ViewController', '192.168.75.1', '1529479037048', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('741', 'ViewController', '192.168.75.1', '1529479091155', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('742', 'ViewController', '192.168.75.1', '1529479092435', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('743', 'ViewController', '192.168.75.1', '1529479110113', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('744', 'ViewController', '192.168.75.1', '1529479111282', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('745', 'ViewController', '192.168.75.1', '1529479129564', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('746', 'ViewController', '192.168.75.1', '1529479130685', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('747', 'ViewController', '192.168.75.1', '1529479147434', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('748', 'ViewController', '192.168.75.1', '1529479148706', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('749', 'ViewController', '192.168.75.1', '1529479162919', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('750', 'ViewController', '192.168.75.1', '1529479164215', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('751', 'ViewController', '192.168.75.1', '1529479179494', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('752', 'ViewController', '192.168.75.1', '1529479180774', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('753', 'ViewController', '192.168.75.1', '1529479225348', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('754', 'ViewController', '192.168.75.1', '1529479226659', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('755', 'ViewController', '192.168.75.1', '1529479232049', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('756', 'ViewController', '192.168.75.1', '1529479233157', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('757', 'ViewController', '192.168.75.1', '1529479391723', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('758', 'ViewController', '192.168.75.1', '1529479393076', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('759', 'ViewController', '192.168.75.1', '1529479402000', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('760', 'ViewController', '192.168.75.1', '1529479403324', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('761', 'ViewController', '192.168.75.1', '1529480357999', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('762', 'ViewController', '192.168.75.1', '1529480361486', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('763', 'ViewController', '192.168.75.1', '1529480363191', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('764', 'ViewController', '192.168.75.1', '1529480364329', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('765', 'ViewController', '192.168.75.1', '1529480479123', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('766', 'ViewController', '192.168.75.1', '1529480480275', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('767', 'ViewController', '192.168.75.1', '1529480487252', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('768', 'ViewController', '192.168.75.1', '1529480488481', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('769', 'ViewController', '192.168.75.1', '1529480524558', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('770', 'ViewController', '192.168.75.1', '1529480525871', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('771', 'ViewController', '192.168.75.1', '1529480820707', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('772', 'ViewController', '192.168.75.1', '1529480821871', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('773', 'ViewController', '192.168.75.1', '1529481042259', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('774', 'ViewController', '192.168.75.1', '1529481043464', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('775', 'ViewController', '192.168.75.1', '1529481095736', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('776', 'ViewController', '192.168.75.1', '1529481096870', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('777', 'ViewController', '192.168.75.1', '1529481292126', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('778', 'ViewController', '192.168.75.1', '1529481293254', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('779', 'ViewController', '192.168.75.1', '1529481332180', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('780', 'ViewController', '192.168.75.1', '1529481333293', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('781', 'ViewController', '192.168.75.1', '1529481399948', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('782', 'ViewController', '192.168.75.1', '1529481401071', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('783', 'ViewController', '192.168.75.1', '1529481452986', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('784', 'ViewController', '192.168.75.1', '1529481454138', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('785', 'ViewController', '192.168.75.1', '1529481505308', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('786', 'ViewController', '192.168.75.1', '1529481506630', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('787', 'ViewController', '192.168.75.1', '1529481512802', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('788', 'ViewController', '192.168.75.1', '1529481514074', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('789', 'ViewController', '192.168.75.1', '1529481520360', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('790', 'ViewController', '192.168.75.1', '1529481521627', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('791', 'ViewController', '192.168.75.1', '1529481535346', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('792', 'ViewController', '192.168.75.1', '1529481536612', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('793', 'ViewController', '192.168.75.1', '1529482039341', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('794', 'ViewController', '192.168.75.1', '1529482040643', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('795', 'ViewController', '192.168.75.1', '1529482084780', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('796', 'ViewController', '192.168.75.1', '1529482086344', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('797', 'ViewController', '192.168.75.1', '1529482128017', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('798', 'ViewController', '192.168.75.1', '1529482135603', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('799', 'ViewController', '192.168.75.1', '1529482137034', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('800', 'ViewController', '192.168.75.1', '1529482337050', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('801', 'ViewController', '192.168.75.1', '1529482338355', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('802', 'ViewController', '192.168.75.1', '1529482430795', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('803', 'ViewController', '192.168.75.1', '1529482432070', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('804', 'ViewController', '192.168.75.1', '1529482480549', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('805', 'ViewController', '192.168.75.1', '1529482481859', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('806', 'ViewController', '192.168.75.1', '1529482495716', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('807', 'ViewController', '192.168.75.1', '1529482497017', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('808', 'ViewController', '192.168.75.1', '1529482527413', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('809', 'ViewController', '192.168.75.1', '1529482528687', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('810', 'ViewController', '192.168.75.1', '1529482591804', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('811', 'ViewController', '192.168.75.1', '1529482593115', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('812', 'ViewController', '192.168.75.1', '1529482618575', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('813', 'ViewController', '192.168.75.1', '1529482619835', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('814', 'ViewController', '192.168.75.1', '1529482667045', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('815', 'ViewController', '192.168.75.1', '1529482668471', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('816', 'ViewController', '192.168.75.1', '1529482814668', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('817', 'ViewController', '192.168.75.1', '1529482815957', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('818', 'ViewController', '192.168.75.1', '1529482830689', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('819', 'ViewController', '192.168.75.1', '1529482832004', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('820', 'ViewController', '192.168.75.1', '1529482875858', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('821', 'ViewController', '192.168.75.1', '1529482877187', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('822', 'ViewController', '192.168.75.1', '1529482997768', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('823', 'ViewController', '192.168.75.1', '1529482999067', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('824', 'ViewController', '192.168.75.1', '1529483087384', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('825', 'ViewController', '192.168.75.1', '1529483088700', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('826', 'ViewController', '192.168.75.1', '1529483187153', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('827', 'ViewController', '192.168.75.1', '1529483188418', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('828', 'ViewController', '192.168.75.1', '1529483206105', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('829', 'ViewController', '192.168.75.1', '1529483207381', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('830', 'ViewController', '192.168.75.1', '1529483233707', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('831', 'ViewController', '192.168.75.1', '1529483235031', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('832', 'ViewController', '192.168.75.1', '1529483300390', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('833', 'ViewController', '192.168.75.1', '1529483301688', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('834', 'ViewController', '192.168.75.1', '1529483368008', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('835', 'ViewController', '192.168.75.1', '1529483369346', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('836', 'ViewController', '192.168.75.1', '1529483500518', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('837', 'ViewController', '192.168.75.1', '1529483501848', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('838', 'ViewController', '192.168.75.1', '1529483616424', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('839', 'ViewController', '192.168.75.1', '1529483617771', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('840', 'ViewController', '192.168.75.1', '1529483681172', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('841', 'ViewController', '192.168.75.1', '1529483682321', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('842', 'ViewController', '192.168.75.1', '1529483722035', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('843', 'ViewController', '192.168.75.1', '1529483723311', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('844', 'ViewController', '192.168.75.1', '1529483783419', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('845', 'ViewController', '192.168.75.1', '1529483784713', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('846', 'ViewController', '192.168.75.1', '1529483806799', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('847', 'ViewController', '192.168.75.1', '1529483808074', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('848', 'ViewController', '192.168.75.1', '1529483879207', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('849', 'ViewController', '192.168.75.1', '1529483880559', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('850', 'ViewController', '192.168.75.1', '1529483938065', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('851', 'ViewController', '192.168.75.1', '1529483939335', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('852', 'ViewController', '192.168.75.1', '1529483942626', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('853', 'ViewController', '192.168.75.1', '1529483943998', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1271', 'ViewController', '192.168.75.1', '1529550185941', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1272', 'ViewController', '192.168.75.1', '1529550186308', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1273', 'ViewController', '192.168.75.1', '1529550187680', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1274', 'ViewController', '192.168.75.1', '1529550276405', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1275', 'ViewController', '192.168.75.1', '1529550277691', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1276', 'ViewController', '192.168.75.1', '1529550444296', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1277', 'ViewController', '192.168.75.1', '1529550445769', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1278', 'ViewController', '192.168.75.1', '1529550499937', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1279', 'ViewController', '192.168.75.1', '1529550501382', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1280', 'ViewController', '192.168.75.1', '1529550546502', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1281', 'ViewController', '192.168.75.1', '1529550547934', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1282', 'ViewController', '192.168.75.1', '1529550637246', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1283', 'ViewController', '192.168.75.1', '1529550638591', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1284', 'ViewController', '192.168.75.1', '1529550640856', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1285', 'ViewController', '192.168.75.1', '1529550642197', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1286', 'ViewController', '192.168.75.1', '1529550783122', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1287', 'ViewController', '192.168.75.1', '1529550784676', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1288', 'ViewController', '192.168.75.1', '1529550834829', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1289', 'ViewController', '192.168.75.1', '1529550836252', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1290', 'ViewController', '192.168.75.1', '1529550858517', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1291', 'ViewController', '192.168.75.1', '1529550859938', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1292', 'ViewController', '192.168.75.1', '1529550886083', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1293', 'ViewController', '192.168.75.1', '1529550887512', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1294', 'ViewController', '192.168.75.1', '1529550897180', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1295', 'ViewController', '192.168.75.1', '1529550898620', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1296', 'ViewController', '192.168.75.1', '1529550907233', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1297', 'ViewController', '192.168.75.1', '1529550908690', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1298', 'ViewController', '192.168.75.1', '1529550919685', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1299', 'ViewController', '192.168.75.1', '1529550921217', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1300', 'ViewController', '192.168.75.1', '1529550958445', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1301', 'ViewController', '192.168.75.1', '1529550959980', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1302', 'ViewController', '192.168.75.1', '1529551055171', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1303', 'ViewController', '192.168.75.1', '1529551056610', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1304', 'ViewController', '192.168.75.1', '1529551057877', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1305', 'ViewController', '192.168.75.1', '1529551059173', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1306', 'ViewController', '192.168.75.1', '1529551091548', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1307', 'ViewController', '192.168.75.1', '1529551093024', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1308', 'ViewController', '192.168.75.1', '1529551100149', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1309', 'ViewController', '192.168.75.1', '1529551101623', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1310', 'ViewController', '192.168.75.1', '1529551113159', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1311', 'ViewController', '192.168.75.1', '1529551114629', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1312', 'ViewController', '192.168.75.1', '1529551264163', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1313', 'ViewController', '192.168.75.1', '1529551265638', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1314', 'ViewController', '192.168.75.1', '1529551333080', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1315', 'ViewController', '192.168.75.1', '1529551334535', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1316', 'ViewController', '192.168.75.1', '1529551388742', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1317', 'ViewController', '192.168.75.1', '1529551390039', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1318', 'ViewController', '192.168.75.1', '1529551392734', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1319', 'ViewController', '192.168.75.1', '1529551394034', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1320', 'ViewController', '192.168.75.1', '1529551529399', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1321', 'ViewController', '192.168.75.1', '1529551530820', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1322', 'ViewController', '192.168.75.1', '1529551561303', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1323', 'ViewController', '192.168.75.1', '1529551562667', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1324', 'ViewController', '192.168.75.1', '1529551573513', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1325', 'ViewController', '192.168.75.1', '1529551574824', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1326', 'ViewController', '192.168.75.1', '1529551587898', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1327', 'ViewController', '192.168.75.1', '1529551589160', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1328', 'ViewController', '192.168.75.1', '1529551595434', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1329', 'ViewController', '192.168.75.1', '1529551596661', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1330', 'ViewController', '192.168.75.1', '1529551615581', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1331', 'ViewController', '192.168.75.1', '1529551616831', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1332', 'ViewController', '192.168.75.1', '1529551629919', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1333', 'ViewController', '192.168.75.1', '1529551631228', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1334', 'ViewController', '192.168.75.1', '1529551653123', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1335', 'ViewController', '192.168.75.1', '1529551654413', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1336', 'ViewController', '192.168.75.1', '1529551694347', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1337', 'ViewController', '192.168.75.1', '1529551695619', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1338', 'ViewController', '192.168.75.1', '1529551737866', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1339', 'ViewController', '192.168.75.1', '1529551739124', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1340', 'ViewController', '192.168.75.1', '1529551741129', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1341', 'ViewController', '192.168.75.1', '1529551742444', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1342', 'ViewController', '192.168.75.1', '1529551915580', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1343', 'ViewController', '192.168.75.1', '1529551917051', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1344', 'ViewController', '192.168.75.1', '1529551955916', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1345', 'ViewController', '192.168.75.1', '1529551959018', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1346', 'ViewController', '192.168.75.1', '1529551983597', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1347', 'ViewController', '192.168.75.1', '1529551985045', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1348', 'ViewController', '192.168.75.1', '1529552045149', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1349', 'ViewController', '192.168.75.1', '1529552046563', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1350', 'ViewController', '192.168.75.1', '1529552112502', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1351', 'ViewController', '192.168.75.1', '1529552113974', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1352', 'ViewController', '192.168.75.1', '1529552117827', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1353', 'ViewController', '192.168.75.1', '1529552119260', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1354', 'ViewController', '192.168.75.1', '1529552263374', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1355', 'ViewController', '192.168.75.1', '1529552264829', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1356', 'ViewController', '192.168.75.1', '1529552431767', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1357', 'ViewController', '192.168.75.1', '1529552433404', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1358', 'ViewController', '192.168.75.1', '1529552438990', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1359', 'ViewController', '192.168.75.1', '1529552440415', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1360', 'ViewController', '192.168.75.1', '1529552441314', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1361', 'ViewController', '192.168.75.1', '1529552442531', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1362', 'ViewController', '192.168.75.1', '1529552446222', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1363', 'ViewController', '192.168.75.1', '1529552447570', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1364', 'ViewController', '192.168.75.1', '1529552501983', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1365', 'ViewController', '192.168.75.1', '1529552503464', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1366', 'ViewController', '192.168.75.1', '1529552540039', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1367', 'ViewController', '192.168.75.1', '1529552541512', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1368', 'ViewController', '192.168.75.1', '1529552682086', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1369', 'ViewController', '192.168.75.1', '1529552683491', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1370', 'ViewController', '192.168.75.1', '1529552799628', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1371', 'ViewController', '192.168.75.1', '1529552800935', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1372', 'ViewController', '192.168.75.1', '1529552817243', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1373', 'ViewController', '192.168.75.1', '1529552818694', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1374', 'ViewController', '192.168.75.1', '1529552822342', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1375', 'ViewController', '192.168.75.1', '1529552823655', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1376', 'ViewController', '192.168.75.1', '1529552850707', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1377', 'ViewController', '192.168.75.1', '1529552852282', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1378', 'ViewController', '192.168.75.1', '1529552885370', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1379', 'ViewController', '192.168.75.1', '1529552886663', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1380', 'ViewController', '192.168.75.1', '1529552906005', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1381', 'ViewController', '192.168.75.1', '1529552907291', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1382', 'ViewController', '192.168.75.1', '1529552909986', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1383', 'ViewController', '192.168.75.1', '1529552911096', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1384', 'ViewController', '192.168.75.1', '1529552938758', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1385', 'ViewController', '192.168.75.1', '1529552940027', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1386', 'ViewController', '192.168.75.1', '1529552961194', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1387', 'ViewController', '192.168.75.1', '1529552962464', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1388', 'ViewController', '192.168.75.1', '1529552966811', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1389', 'ViewController', '192.168.75.1', '1529552968055', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1390', 'ViewController', '192.168.75.1', '1529553073923', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1391', 'ViewController', '192.168.75.1', '1529553075343', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1392', 'ViewController', '192.168.75.1', '1529553094926', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1393', 'ViewController', '192.168.75.1', '1529553163529', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1394', 'ViewController', '192.168.75.1', '1529553164957', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1395', 'ViewController', '192.168.75.1', '1529558112773', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1396', 'ViewController', '192.168.75.1', '1529558114050', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1397', 'ViewController', '192.168.75.1', '1529558166626', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1398', 'ViewController', '192.168.75.1', '1529558167860', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1399', 'ViewController', '192.168.75.1', '1529558172853', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1400', 'ViewController', '192.168.75.1', '1529558173960', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1401', 'ViewController', '192.168.75.1', '1529558190487', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1402', 'ViewController', '192.168.75.1', '1529558191594', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1599', 'ViewController', '192.168.75.1', '1529561019416', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1600', 'ViewController', '192.168.75.1', '1529561019445', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1601', 'ViewController', '192.168.75.1', '1529561019466', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1602', 'ViewController', '192.168.75.1', '1529561022504', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1603', 'ViewController', '192.168.75.1', '1529561022539', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1604', 'ViewController', '192.168.75.1', '1529561022568', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1605', 'ViewController', '192.168.75.1', '1529561022593', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1606', 'ViewController', '192.168.75.1', '1529561022629', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1607', 'ViewController', '192.168.75.1', '1529561022663', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1608', 'ViewController', '192.168.75.1', '1529561022685', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1609', 'ViewController', '192.168.75.1', '1529561025140', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1610', 'ViewController', '192.168.75.1', '1529561025178', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1611', 'ViewController', '192.168.75.1', '1529561025202', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1612', 'ViewController', '192.168.75.1', '1529561025227', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1613', 'ViewController', '192.168.75.1', '1529561025250', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1614', 'ViewController', '192.168.75.1', '1529561025277', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1615', 'ViewController', '192.168.75.1', '1529561025302', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1616', 'ViewController', '192.168.75.1', '1529561028185', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1617', 'ViewController', '192.168.75.1', '1529561028225', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1618', 'ViewController', '192.168.75.1', '1529561028260', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1619', 'ViewController', '192.168.75.1', '1529561028299', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1620', 'ViewController', '192.168.75.1', '1529561028346', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1621', 'ViewController', '192.168.75.1', '1529561028387', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1622', 'ViewController', '192.168.75.1', '1529561028418', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1623', 'ViewController', '192.168.75.1', '1529561115365', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1624', 'ViewController', '192.168.75.1', '1529561116892', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1625', 'ViewController', '192.168.75.1', '1529561366226', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1626', 'ViewController', '192.168.75.1', '1529561367579', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1627', 'ViewController', '192.168.75.1', '1529561380067', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1628', 'ViewController', '192.168.75.1', '1529561381393', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1629', 'ViewController', '192.168.75.1', '1529561400840', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1630', 'ViewController', '192.168.75.1', '1529561402093', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1631', 'ViewController', '192.168.75.1', '1529561415606', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1632', 'ViewController', '192.168.75.1', '1529561416854', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1633', 'ViewController', '192.168.75.1', '1529561450562', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1634', 'ViewController', '192.168.75.1', '1529561452187', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1635', 'ViewController', '192.168.75.1', '1529561500628', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1636', 'ViewController', '192.168.75.1', '1529561502163', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1637', 'ViewController', '192.168.75.1', '1529561531088', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1638', 'ViewController', '192.168.75.1', '1529561532575', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1639', 'ViewController', '192.168.75.1', '1529561560352', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1640', 'ViewController', '192.168.75.1', '1529561561804', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1641', 'ViewController', '192.168.75.1', '1529561625973', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1642', 'ViewController', '192.168.75.1', '1529561627262', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1643', 'ViewController', '192.168.75.1', '1529561962694', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1644', 'ViewController', '192.168.75.1', '1529561964186', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1645', 'ViewController', '192.168.75.1', '1529562104999', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1646', 'ViewController', '192.168.75.1', '1529562106486', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1647', 'ViewController', '192.168.75.1', '1529562116300', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1648', 'ViewController', '192.168.75.1', '1529562117721', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1649', 'ViewController', '192.168.75.1', '1529562168117', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1650', 'ViewController', '192.168.75.1', '1529562169439', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1651', 'ViewController', '192.168.75.1', '1529562823780', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1652', 'ViewController', '192.168.75.1', '1529562825146', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1653', 'ViewController', '192.168.75.1', '1529562933688', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1654', 'ViewController', '192.168.75.1', '1529562935066', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1655', 'ViewController', '192.168.75.1', '1529562992731', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1656', 'ViewController', '192.168.75.1', '1529562993874', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1657', 'ViewController', '192.168.75.1', '1529563008057', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1658', 'ViewController', '192.168.75.1', '1529563009364', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1659', 'ViewController', '192.168.75.1', '1529563030666', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1660', 'ViewController', '192.168.75.1', '1529563032007', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1661', 'ViewController', '192.168.75.1', '1529563072308', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1662', 'ViewController', '192.168.75.1', '1529563073573', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1663', 'ViewController', '192.168.75.1', '1529563099859', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1664', 'ViewController', '192.168.75.1', '1529563100977', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1665', 'ViewController', '192.168.75.1', '1529563102995', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1666', 'ViewController', '192.168.75.1', '1529563104128', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1667', 'ViewController', '192.168.75.1', '1529563115972', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1668', 'ViewController', '192.168.75.1', '1529563117246', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1669', 'ViewController', '192.168.75.1', '1529563242439', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1670', 'ViewController', '192.168.75.1', '1529563243726', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1671', 'ViewController', '192.168.75.1', '1529563246621', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1672', 'ViewController', '192.168.75.1', '1529563247833', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1673', 'ViewController', '192.168.75.1', '1529563844804', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1674', 'ViewController', '192.168.75.1', '1529563846189', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1675', 'ViewController', '192.168.75.1', '1529563850646', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1676', 'ViewController', '192.168.75.1', '1529563851898', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1677', 'ViewController', '192.168.75.1', '1529563877629', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1678', 'ViewController', '192.168.75.1', '1529563879046', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1679', 'ViewController', '172.20.10.2', '1529564086064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1680', 'ViewController', '172.20.10.2', '1529564087340', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1681', 'ViewController', '172.20.10.2', '1529564292201', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1682', 'ViewController', '172.20.10.2', '1529564293459', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1683', 'ViewController', '172.20.10.2', '1529564343952', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1684', 'ViewController', '172.20.10.2', '1529564345245', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1685', 'ViewController', '172.20.10.2', '1529564350702', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1686', 'ViewController', '172.20.10.2', '1529564351944', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1687', 'ViewController', '172.20.10.2', '1529564408674', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1688', 'ViewController', '172.20.10.2', '1529564409956', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1689', 'ViewController', '172.20.10.2', '1529564458230', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1690', 'ViewController', '172.20.10.2', '1529564459387', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1691', 'ViewController', '172.20.10.2', '1529564475970', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1692', 'ViewController', '172.20.10.2', '1529564477258', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1693', 'ViewController', '172.20.10.2', '1529564488744', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1694', 'ViewController', '172.20.10.2', '1529564490035', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1695', 'ViewController', '172.20.10.2', '1529564510123', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1696', 'ViewController', '172.20.10.2', '1529564511390', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1697', 'ViewController', '172.20.10.2', '1529564574647', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1698', 'ViewController', '172.20.10.2', '1529564575899', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1699', 'ViewController', '172.20.10.2', '1529564622384', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1700', 'ViewController', '172.20.10.2', '1529564623634', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1701', 'ViewController', '172.20.10.2', '1529564755937', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1702', 'ViewController', '172.20.10.2', '1529564757282', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1703', 'ViewController', '172.20.10.2', '1529564798290', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1704', 'ViewController', '172.20.10.2', '1529564799921', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1705', 'ViewController', '172.20.10.2', '1529564858970', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1706', 'ViewController', '172.20.10.2', '1529564860467', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1707', 'ViewController', '172.20.10.2', '1529564936119', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1708', 'ViewController', '172.20.10.2', '1529564937642', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1709', 'ViewController', '172.20.10.2', '1529564975071', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1710', 'ViewController', '172.20.10.2', '1529564976471', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1711', 'ViewController', '172.20.10.2', '1529565018320', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1712', 'ViewController', '172.20.10.2', '1529565019731', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1713', 'ViewController', '172.20.10.2', '1529565057855', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1714', 'ViewController', '172.20.10.2', '1529565059302', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1715', 'ViewController', '172.20.10.2', '1529565267141', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1716', 'ViewController', '172.20.10.2', '1529565268508', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1717', 'ViewController', '172.20.10.2', '1529565272157', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1718', 'ViewController', '172.20.10.2', '1529565273433', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1719', 'ViewController', '172.20.10.2', '1529565398998', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1720', 'ViewController', '172.20.10.2', '1529565400291', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1721', 'ViewController', '172.20.10.2', '1529565419744', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1722', 'ViewController', '172.20.10.2', '1529565420992', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1723', 'ViewController', '172.20.10.2', '1529565448440', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1724', 'ViewController', '172.20.10.2', '1529565449729', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1725', 'ViewController', '172.20.10.2', '1529565454773', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1726', 'ViewController', '172.20.10.2', '1529565456005', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1727', 'ViewController', '172.20.10.2', '1529565470852', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1728', 'ViewController', '172.20.10.2', '1529565472118', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1729', 'ViewController', '172.20.10.2', '1529565502160', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1730', 'ViewController', '172.20.10.2', '1529565503417', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1731', 'ViewController', '172.20.10.2', '1529565611369', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1403', 'ViewController', '192.168.75.1', '1529558204455', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1404', 'ViewController', '192.168.75.1', '1529558205552', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1405', 'ViewController', '192.168.75.1', '1529558225827', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1406', 'ViewController', '192.168.75.1', '1529558226938', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1407', 'ViewController', '192.168.75.1', '1529558251672', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1408', 'ViewController', '192.168.75.1', '1529558252800', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1409', 'ViewController', '192.168.75.1', '1529558261220', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1410', 'ViewController', '192.168.75.1', '1529558262334', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1411', 'ViewController', '192.168.75.1', '1529558301805', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1412', 'ViewController', '192.168.75.1', '1529558302925', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1413', 'ViewController', '192.168.75.1', '1529558325207', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1414', 'ViewController', '192.168.75.1', '1529558326311', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1415', 'ViewController', '192.168.75.1', '1529558335415', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1416', 'ViewController', '192.168.75.1', '1529558336529', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1417', 'ViewController', '192.168.75.1', '1529558343905', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1418', 'ViewController', '192.168.75.1', '1529558345011', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1419', 'ViewController', '192.168.75.1', '1529558388959', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1420', 'ViewController', '192.168.75.1', '1529558390063', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1421', 'ViewController', '192.168.75.1', '1529558402716', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1422', 'ViewController', '192.168.75.1', '1529558403808', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1423', 'ViewController', '192.168.75.1', '1529558437378', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1424', 'ViewController', '192.168.75.1', '1529558438658', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1425', 'ViewController', '192.168.75.1', '1529558445037', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1426', 'ViewController', '192.168.75.1', '1529558446272', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1427', 'ViewController', '192.168.75.1', '1529558449754', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1428', 'ViewController', '192.168.75.1', '1529558450985', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1429', 'ViewController', '192.168.75.1', '1529558463217', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1430', 'ViewController', '192.168.75.1', '1529558464455', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1431', 'ViewController', '192.168.75.1', '1529558487937', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1432', 'ViewController', '192.168.75.1', '1529558489048', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1433', 'ViewController', '192.168.75.1', '1529558942019', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1434', 'ViewController', '192.168.75.1', '1529558943170', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1435', 'ViewController', '192.168.75.1', '1529559052090', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1436', 'ViewController', '192.168.75.1', '1529559053383', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1437', 'ViewController', '192.168.75.1', '1529559066349', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1438', 'ViewController', '192.168.75.1', '1529559067629', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1439', 'ViewController', '192.168.75.1', '1529559083903', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1440', 'ViewController', '192.168.75.1', '1529559085191', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1441', 'ViewController', '192.168.75.1', '1529559121342', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1442', 'ViewController', '192.168.75.1', '1529559122807', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1443', 'ViewController', '192.168.75.1', '1529559188671', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1444', 'ViewController', '192.168.75.1', '1529559190044', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1445', 'ViewController', '192.168.75.1', '1529559190487', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1446', 'ViewController', '192.168.75.1', '1529559191586', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1447', 'ViewController', '192.168.75.1', '1529559221377', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1448', 'ViewController', '192.168.75.1', '1529559222857', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1449', 'ViewController', '192.168.75.1', '1529559223339', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1450', 'ViewController', '192.168.75.1', '1529559224771', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1451', 'ViewController', '192.168.75.1', '1529559245384', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1452', 'ViewController', '192.168.75.1', '1529559246742', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1453', 'ViewController', '192.168.75.1', '1529559642737', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1454', 'ViewController', '192.168.75.1', '1529559644090', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1455', 'ViewController', '192.168.75.1', '1529559690659', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1456', 'ViewController', '192.168.75.1', '1529559691921', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1457', 'ViewController', '192.168.75.1', '1529559752669', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1458', 'ViewController', '192.168.75.1', '1529559756854', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1459', 'ViewController', '192.168.75.1', '1529559757826', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1460', 'ViewController', '192.168.75.1', '1529559758501', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1461', 'ViewController', '192.168.75.1', '1529559759245', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1462', 'ViewController', '192.168.75.1', '1529559759960', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1463', 'ViewController', '192.168.75.1', '1529559760714', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1464', 'ViewController', '192.168.75.1', '1529559761473', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1465', 'ViewController', '192.168.75.1', '1529559762327', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1466', 'ViewController', '192.168.75.1', '1529559763547', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1467', 'ViewController', '192.168.75.1', '1529559764474', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1468', 'ViewController', '192.168.75.1', '1529559765542', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1469', 'ViewController', '192.168.75.1', '1529559766501', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1470', 'ViewController', '192.168.75.1', '1529559767393', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1471', 'ViewController', '192.168.75.1', '1529559768320', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1472', 'ViewController', '192.168.75.1', '1529559769215', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1473', 'ViewController', '192.168.75.1', '1529559820206', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1474', 'ViewController', '192.168.75.1', '1529559821665', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1475', 'ViewController', '192.168.75.1', '1529559904357', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1476', 'ViewController', '192.168.75.1', '1529559905711', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1477', 'ViewController', '192.168.75.1', '1529559934386', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1478', 'ViewController', '192.168.75.1', '1529559935692', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1479', 'ViewController', '192.168.75.1', '1529559950669', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1480', 'ViewController', '192.168.75.1', '1529559951383', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1481', 'ViewController', '192.168.75.1', '1529559951950', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1482', 'ViewController', '192.168.75.1', '1529559952408', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1483', 'ViewController', '192.168.75.1', '1529559952915', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1484', 'ViewController', '192.168.75.1', '1529559953473', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1485', 'ViewController', '192.168.75.1', '1529559954048', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1486', 'ViewController', '192.168.75.1', '1529559954580', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1487', 'ViewController', '192.168.75.1', '1529559956245', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1488', 'ViewController', '192.168.75.1', '1529559956909', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1489', 'ViewController', '192.168.75.1', '1529559957489', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1490', 'ViewController', '192.168.75.1', '1529559958127', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1491', 'ViewController', '192.168.75.1', '1529559958744', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1492', 'ViewController', '192.168.75.1', '1529560100132', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1493', 'ViewController', '192.168.75.1', '1529560101588', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1494', 'ViewController', '192.168.75.1', '1529560105774', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1495', 'ViewController', '192.168.75.1', '1529560106464', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1496', 'ViewController', '192.168.75.1', '1529560107121', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1497', 'ViewController', '192.168.75.1', '1529560107795', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1498', 'ViewController', '192.168.75.1', '1529560108400', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1499', 'ViewController', '192.168.75.1', '1529560108996', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1500', 'ViewController', '192.168.75.1', '1529560109599', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1501', 'ViewController', '192.168.75.1', '1529560110168', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1502', 'ViewController', '192.168.75.1', '1529560110795', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1503', 'ViewController', '192.168.75.1', '1529560111435', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1504', 'ViewController', '192.168.75.1', '1529560112062', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1505', 'ViewController', '192.168.75.1', '1529560221450', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1506', 'ViewController', '192.168.75.1', '1529560222817', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1507', 'ViewController', '192.168.75.1', '1529560352241', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1508', 'ViewController', '192.168.75.1', '1529560353541', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1509', 'ViewController', '192.168.75.1', '1529560392381', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1510', 'ViewController', '192.168.75.1', '1529560393731', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1511', 'ViewController', '192.168.75.1', '1529560399198', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1512', 'ViewController', '192.168.75.1', '1529560400362', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1513', 'ViewController', '192.168.75.1', '1529560401272', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1514', 'ViewController', '192.168.75.1', '1529560402077', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1515', 'ViewController', '192.168.75.1', '1529560402863', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1516', 'ViewController', '192.168.75.1', '1529560403649', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1517', 'ViewController', '192.168.75.1', '1529560404474', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1518', 'ViewController', '192.168.75.1', '1529560405278', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1519', 'ViewController', '192.168.75.1', '1529560406064', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1520', 'ViewController', '192.168.75.1', '1529560407170', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1521', 'ViewController', '192.168.75.1', '1529560408474', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1522', 'ViewController', '192.168.75.1', '1529560409633', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1523', 'ViewController', '192.168.75.1', '1529560410564', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1524', 'ViewController', '192.168.75.1', '1529560411577', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1525', 'ViewController', '192.168.75.1', '1529560412637', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1526', 'ViewController', '192.168.75.1', '1529560413825', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1527', 'ViewController', '192.168.75.1', '1529560414965', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1528', 'ViewController', '192.168.75.1', '1529560632701', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1529', 'ViewController', '192.168.75.1', '1529560634158', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1530', 'ViewController', '192.168.75.1', '1529560640102', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1531', 'ViewController', '192.168.75.1', '1529560640732', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1532', 'ViewController', '192.168.75.1', '1529560641406', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1533', 'ViewController', '192.168.75.1', '1529560642125', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1534', 'ViewController', '192.168.75.1', '1529560643596', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1535', 'ViewController', '192.168.75.1', '1529560644541', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1536', 'ViewController', '192.168.75.1', '1529560645237', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1537', 'ViewController', '192.168.75.1', '1529560645945', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1538', 'ViewController', '192.168.75.1', '1529560646702', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1539', 'ViewController', '192.168.75.1', '1529560647448', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1540', 'ViewController', '192.168.75.1', '1529560648190', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1541', 'ViewController', '192.168.75.1', '1529560648949', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1542', 'ViewController', '192.168.75.1', '1529560649644', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1543', 'ViewController', '192.168.75.1', '1529560843824', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1544', 'ViewController', '192.168.75.1', '1529560845236', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1545', 'ViewController', '192.168.75.1', '1529560848151', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1546', 'ViewController', '192.168.75.1', '1529560848894', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1547', 'ViewController', '192.168.75.1', '1529560849563', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1548', 'ViewController', '192.168.75.1', '1529560850232', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1549', 'ViewController', '192.168.75.1', '1529560852177', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1550', 'ViewController', '192.168.75.1', '1529560853228', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1551', 'ViewController', '192.168.75.1', '1529560854000', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1552', 'ViewController', '192.168.75.1', '1529560868097', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1553', 'ViewController', '192.168.75.1', '1529560869446', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1554', 'ViewController', '192.168.75.1', '1529560871072', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1555', 'ViewController', '192.168.75.1', '1529560871831', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1556', 'ViewController', '192.168.75.1', '1529560872523', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1557', 'ViewController', '192.168.75.1', '1529560873264', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1558', 'ViewController', '192.168.75.1', '1529560874626', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1559', 'ViewController', '192.168.75.1', '1529560875782', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1560', 'ViewController', '192.168.75.1', '1529560891634', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1561', 'ViewController', '192.168.75.1', '1529560892375', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1562', 'ViewController', '192.168.75.1', '1529560893079', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1563', 'ViewController', '192.168.75.1', '1529560954876', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1564', 'ViewController', '192.168.75.1', '1529560956205', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1565', 'ViewController', '192.168.75.1', '1529560974014', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1566', 'ViewController', '192.168.75.1', '1529560974043', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1567', 'ViewController', '192.168.75.1', '1529560974060', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1568', 'ViewController', '192.168.75.1', '1529560974080', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1569', 'ViewController', '192.168.75.1', '1529560974101', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1570', 'ViewController', '192.168.75.1', '1529560974120', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1571', 'ViewController', '192.168.75.1', '1529560974139', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1572', 'ViewController', '192.168.75.1', '1529560978845', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1573', 'ViewController', '192.168.75.1', '1529560978872', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1574', 'ViewController', '192.168.75.1', '1529560978896', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1575', 'ViewController', '192.168.75.1', '1529560978920', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1576', 'ViewController', '192.168.75.1', '1529560978942', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1577', 'ViewController', '192.168.75.1', '1529560978975', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1578', 'ViewController', '192.168.75.1', '1529560979002', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1579', 'ViewController', '192.168.75.1', '1529560982172', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1580', 'ViewController', '192.168.75.1', '1529560982200', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1581', 'ViewController', '192.168.75.1', '1529560982253', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1582', 'ViewController', '192.168.75.1', '1529560982267', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1583', 'ViewController', '192.168.75.1', '1529560982285', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1584', 'ViewController', '192.168.75.1', '1529560982316', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1585', 'ViewController', '192.168.75.1', '1529560982340', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1586', 'ViewController', '192.168.75.1', '1529561012529', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1587', 'ViewController', '192.168.75.1', '1529561013810', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1588', 'ViewController', '192.168.75.1', '1529561016829', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1589', 'ViewController', '192.168.75.1', '1529561016851', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1590', 'ViewController', '192.168.75.1', '1529561016874', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1591', 'ViewController', '192.168.75.1', '1529561016896', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1592', 'ViewController', '192.168.75.1', '1529561016924', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1593', 'ViewController', '192.168.75.1', '1529561016943', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1594', 'ViewController', '192.168.75.1', '1529561016966', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1595', 'ViewController', '192.168.75.1', '1529561019328', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1596', 'ViewController', '192.168.75.1', '1529561019350', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1597', 'ViewController', '192.168.75.1', '1529561019372', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1598', 'ViewController', '192.168.75.1', '1529561019393', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1906', 'ViewController', '192.168.75.1', '1529625204813', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1907', 'ViewController', '192.168.75.1', '1529625206748', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2086', 'MenuController', '192.168.56.1', '1529918787595', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"5555","url":null,"code":"777777","type":3,"pid":2023,"sortNo":3,"id":2025}]', '97');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2111', 'MenuController', '192.168.115.101', '1530003016650', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2112', 'MenuController', '192.168.115.101', '1530003105447', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2138', 'PermissionController', '192.168.115.107', '1530337377575', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2139', 'PermissionController', '192.168.115.107', '1530337383534', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '8');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2140', 'PermissionController', '192.168.115.107', '1530337450047', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '29');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2141', 'PermissionController', '192.168.115.107', '1530337502419', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '683');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2142', 'PermissionController', '192.168.115.107', '1530337525406', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '47');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2143', 'PermissionController', '192.168.115.107', '1530337560467', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '44');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2144', 'PermissionController', '192.168.115.107', '1530337575246', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '29');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2145', 'PermissionController', '192.168.115.107', '1530337590777', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '56');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2146', 'PermissionController', '192.168.115.107', '1530337725240', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '94615');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2147', 'PermissionController', '192.168.115.107', '1530337747703', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":null},{"roleId":2125,"userId":null,"menuId":2039,"id":null},{"roleId":2125,"userId":null,"menuId":2021,"id":null},{"roleId":2125,"userId":null,"menuId":2023,"id":null}]]', '37');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2152', 'PermissionController', '192.168.115.107', '1530337858599', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":2148},{"roleId":2125,"userId":null,"menuId":2039,"id":2149},{"roleId":2125,"userId":null,"menuId":2021,"id":2150},{"roleId":2125,"userId":null,"menuId":2023,"id":2151}]]', '548');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2158', 'PermissionController', '192.168.115.107', '1530337871168', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2021,"id":2153},{"roleId":2125,"userId":null,"menuId":2023,"id":2154},{"roleId":2125,"userId":null,"menuId":2027,"id":2155},{"roleId":2125,"userId":null,"menuId":2025,"id":2156},{"roleId":2125,"userId":null,"menuId":2039,"id":2157}]]', '66');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2163', 'PermissionController', '192.168.115.107', '1530337934579', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2027,"id":2159},{"roleId":2125,"userId":null,"menuId":2039,"id":2160},{"roleId":2125,"userId":null,"menuId":2021,"id":2161},{"roleId":2125,"userId":null,"menuId":2023,"id":2162}]]', '27');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2167', 'PermissionController', '192.168.115.107', '1530338440584', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2126,"userId":null,"menuId":2027,"id":2164},{"roleId":2126,"userId":null,"menuId":2021,"id":2165},{"roleId":2126,"userId":null,"menuId":2023,"id":2166}]]', '52');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2169', 'PermissionController', '192.168.115.107', '1530338455393', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2039,"id":2168}]]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2174', 'PermissionController', '192.168.115.107', '1530338575975', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2122,"userId":null,"menuId":2021,"id":2170},{"roleId":2122,"userId":null,"menuId":2023,"id":2171},{"roleId":2122,"userId":null,"menuId":2027,"id":2172},{"roleId":2122,"userId":null,"menuId":2025,"id":2173}]]', '36');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2179', 'PermissionController', '192.168.115.107', '1530338972670', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2126,"userId":null,"menuId":2021,"id":2175},{"roleId":2126,"userId":null,"menuId":2023,"id":2176},{"roleId":2126,"userId":null,"menuId":2027,"id":2177},{"roleId":2126,"userId":null,"menuId":2025,"id":2178}]]', '30');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2186', 'PermissionController', '192.168.115.107', '1530339172700', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2021,"id":2180},{"roleId":2125,"userId":null,"menuId":2023,"id":2181},{"roleId":2125,"userId":null,"menuId":2027,"id":2182},{"roleId":2125,"userId":null,"menuId":2025,"id":2183},{"roleId":2125,"userId":null,"menuId":2039,"id":2184},{"roleId":2125,"userId":null,"menuId":2029,"id":2185}]]', '30');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2189', 'PermissionController', '192.168.115.107', '1530339177930', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2039,"id":2187},{"roleId":2125,"userId":null,"menuId":2029,"id":2188}]]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2085', 'MenuController', '192.168.56.1', '1529917467107', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"44","url":null,"code":"44444444444","type":3,"pid":2023,"sortNo":2,"id":2027}]', '90');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2201', 'PermissionController', '192.168.115.107', '1530339382822', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2124,"userId":null,"menuId":2021,"id":2197},{"roleId":2124,"userId":null,"menuId":2023,"id":2198},{"roleId":2124,"userId":null,"menuId":2027,"id":2199},{"roleId":2124,"userId":null,"menuId":2025,"id":2200}]]', '60');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2207', 'PermissionController', '192.168.115.107', '1530340251086', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2021,"id":2202},{"roleId":2125,"userId":null,"menuId":2023,"id":2203},{"roleId":2125,"userId":null,"menuId":2027,"id":2204},{"roleId":2125,"userId":null,"menuId":2025,"id":2205},{"roleId":2125,"userId":null,"menuId":2029,"id":2206}]]', '65');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2211', 'PermissionController', '192.168.115.107', '1530342519849', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2021,"id":2208},{"roleId":2125,"userId":null,"menuId":2023,"id":2209},{"roleId":2125,"userId":null,"menuId":2029,"id":2210}]]', '27');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2216', 'PermissionController', '192.168.115.107', '1530342531532', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2122,"userId":null,"menuId":2021,"id":2212},{"roleId":2122,"userId":null,"menuId":2023,"id":2213},{"roleId":2122,"userId":null,"menuId":2027,"id":2214},{"roleId":2122,"userId":null,"menuId":2029,"id":2215}]]', '40');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2218', 'DeptController', '192.168.115.107', '1530343831030', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"432","memo":"432","sortNo":7,"id":2217}]', '339');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2220', 'DeptController', '192.168.115.107', '1530343840146', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"3333","memo":"3333333","sortNo":3,"id":2219}]', '28');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2221', 'DeptController', '192.168.115.107', '1530343850755', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":"32","sortNo":null,"id":null}]', '50');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2222', 'DeptController', '192.168.115.107', '1530343851975', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":"32","sortNo":null,"id":null}]', '13');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2223', 'DeptController', '192.168.115.107', '1530343957533', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":null,"sortNo":2,"id":22}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2224', 'DeptController', '192.168.115.107', '1530344042689', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":null,"sortNo":2,"id":22}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2225', 'DeptController', '192.168.115.107', '1530344044157', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":null,"sortNo":2,"id":22}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2226', 'DeptController', '192.168.115.107', '1530344046765', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":null,"sortNo":2,"id":22}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2227', 'DeptController', '192.168.115.107', '1530344118140', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":null,"sortNo":2,"id":22}]', '18035');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2228', 'DeptController', '192.168.115.107', '1530344151791', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"21","memo":null,"sortNo":2,"id":22}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2229', 'DeptController', '192.168.115.107', '1530344248475', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":null,"name":"44","memo":"44ee","sortNo":4,"id":44}]', '2');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2230', 'DeptController', '192.168.115.107', '1530344290049', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":null,"name":"44","memo":"44ee","sortNo":4,"id":44}]', '155');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2231', 'DeptController', '192.168.115.107', '1530344308618', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '[未登录]', '保存或更新信息', '[{"pid":12,"name":"3333","memo":"3333333","sortNo":1,"id":2219}]', '45');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2233', 'UserController', '192.168.115.107', '1530347173781', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"32","userPassword":null,"userCode":"333","email":null,"phone":null,"position":null,"sex":null,"jobState":null,"accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2232}]', '369');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2235', 'UserController', '192.168.115.107', '1530347228739', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"333","userPassword":null,"userCode":"2222","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2234}]', '27');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2237', 'UserController', '192.168.115.107', '1530347461306', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"333","userPassword":"2b2eb361ece0631ea06cc2ebfa72dd3c","userCode":"2222","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2236}]', '88');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2239', 'UserController', '192.168.115.107', '1530347492369', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"321","userCode":"321321","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2238}]', '22');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2240', 'UserController', '192.168.115.107', '1530347502028', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"2b2eb361ece0631ea06cc2ebfa72dd3c","userCode":"2222","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":null}]', '58');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2241', 'UserController', '192.168.115.107', '1530347503330', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"2b2eb361ece0631ea06cc2ebfa72dd3c","userCode":"2222","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":null}]', '18');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2242', 'UserController', '192.168.115.107', '1530347504463', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"2b2eb361ece0631ea06cc2ebfa72dd3c","userCode":"2222","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":null}]', '17');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2243', 'UserController', '192.168.115.107', '1530348239652', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"321","userCode":"321321","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2238}]', '65');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2244', 'UserController', '192.168.115.107', '1530348273310', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"3211111111","userPassword":"321","userCode":"321321","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2238}]', '12');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1732', 'ViewController', '172.20.10.2', '1529565612660', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1733', 'ViewController', '172.20.10.2', '1529565676951', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1734', 'ViewController', '172.20.10.2', '1529565678245', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1735', 'ViewController', '172.20.10.2', '1529565701925', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1736', 'ViewController', '172.20.10.2', '1529565703252', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1737', 'ViewController', '172.20.10.2', '1529565724697', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1738', 'ViewController', '172.20.10.2', '1529565726006', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1739', 'ViewController', '172.20.10.2', '1529565772357', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1740', 'ViewController', '172.20.10.2', '1529565773504', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1741', 'ViewController', '172.20.10.2', '1529567375129', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1742', 'ViewController', '172.20.10.2', '1529567376276', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1743', 'ViewController', '172.20.10.2', '1529569155288', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1744', 'ViewController', '172.20.10.2', '1529569156432', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1745', 'ViewController', '172.20.10.2', '1529569157871', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1746', 'ViewController', '172.20.10.2', '1529569158975', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1747', 'ViewController', '172.20.10.2', '1529569554293', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1748', 'ViewController', '172.20.10.2', '1529569555413', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1749', 'ViewController', '172.20.10.2', '1529569571983', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1750', 'ViewController', '172.20.10.2', '1529569573104', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1751', 'ViewController', '172.20.10.2', '1529569585206', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1752', 'ViewController', '172.20.10.2', '1529569586314', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1753', 'ViewController', '172.20.10.2', '1529570221337', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1754', 'ViewController', '172.20.10.2', '1529570222551', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1755', 'ViewController', '172.20.10.2', '1529570225307', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1756', 'ViewController', '172.20.10.2', '1529570226465', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1757', 'ViewController', '172.20.10.2', '1529570235649', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1758', 'ViewController', '172.20.10.2', '1529570236810', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1759', 'ViewController', '172.20.10.2', '1529570239246', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1760', 'ViewController', '172.20.10.2', '1529570240417', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1761', 'ViewController', '172.20.10.2', '1529570241157', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1762', 'ViewController', '172.20.10.2', '1529570242300', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1763', 'ViewController', '172.20.10.2', '1529570242600', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1764', 'ViewController', '172.20.10.2', '1529570243746', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1765', 'ViewController', '172.20.10.2', '1529570259564', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1766', 'ViewController', '172.20.10.2', '1529570260796', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1767', 'ViewController', '172.20.10.2', '1529570367067', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1768', 'ViewController', '172.20.10.2', '1529570368412', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1769', 'ViewController', '172.20.10.2', '1529570382224', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1770', 'ViewController', '172.20.10.2', '1529570383500', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1771', 'ViewController', '172.20.10.2', '1529570429505', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1772', 'ViewController', '172.20.10.2', '1529570430775', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1927', 'ViewController', '172.20.10.2', '1529627777868', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1928', 'ViewController', '172.20.10.2', '1529627782235', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1929', 'ViewController', '172.20.10.2', '1529627783094', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1930', 'ViewController', '172.20.10.2', '1529627802062', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1931', 'ViewController', '172.20.10.2', '1529627803394', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1932', 'ViewController', '172.20.10.2', '1529627804286', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1933', 'ViewController', '172.20.10.2', '1529627805202', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1934', 'ViewController', '172.20.10.2', '1529627808738', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1935', 'ViewController', '172.20.10.2', '1529627835876', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1936', 'ViewController', '172.20.10.2', '1529632504623', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1937', 'ViewController', '172.20.10.2', '1529632528908', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1938', 'ViewController', '172.20.10.2', '1529632548026', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1939', 'ViewController', '172.20.10.2', '1529632577327', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1940', 'ViewController', '172.20.10.2', '1529632600130', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1941', 'ViewController', '172.20.10.2', '1529632620160', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1942', 'ViewController', '172.20.10.2', '1529632729153', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1943', 'ViewController', '172.20.10.2', '1529632820507', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1944', 'ViewController', '172.20.10.2', '1529633011883', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1945', 'ViewController', '172.20.10.2', '1529633082309', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1946', 'ViewController', '172.20.10.2', '1529633243810', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '20');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1947', 'ViewController', '172.20.10.2', '1529633321881', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1948', 'ViewController', '172.20.10.2', '1529633437152', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1949', 'ViewController', '172.20.10.2', '1529633460473', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1950', 'ViewController', '172.20.10.2', '1529633489842', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1951', 'ViewController', '172.20.10.2', '1529633532803', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1773', 'ViewController', '172.20.10.2', '1529572037962', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '20');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1774', 'ViewController', '172.20.10.2', '1529572039817', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1775', 'ViewController', '172.20.10.2', '1529572046960', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1776', 'ViewController', '172.20.10.2', '1529572048331', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1777', 'ViewController', '172.20.10.2', '1529572063389', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1778', 'ViewController', '172.20.10.2', '1529572064747', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1779', 'ViewController', '172.20.10.2', '1529572118565', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1780', 'ViewController', '172.20.10.2', '1529572119874', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1781', 'ViewController', '172.20.10.2', '1529572226868', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1782', 'ViewController', '172.20.10.2', '1529572228218', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1783', 'ViewController', '172.20.10.2', '1529572268641', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1784', 'ViewController', '172.20.10.2', '1529572269900', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1785', 'ViewController', '172.20.10.2', '1529572357183', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1786', 'ViewController', '172.20.10.2', '1529572358499', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1787', 'ViewController', '172.20.10.2', '1529572361640', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1788', 'ViewController', '172.20.10.2', '1529572363051', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1789', 'ViewController', '172.20.10.2', '1529572450753', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1790', 'ViewController', '172.20.10.2', '1529572452037', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1791', 'ViewController', '172.20.10.2', '1529572534691', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1792', 'ViewController', '172.20.10.2', '1529572535962', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1793', 'ViewController', '172.20.10.2', '1529572538141', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1794', 'ViewController', '172.20.10.2', '1529572539415', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1908', 'ViewController', '172.20.10.2', '1529625859423', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1909', 'ViewController', '172.20.10.2', '1529625861187', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1910', 'ViewController', '172.20.10.2', '1529625862374', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1911', 'ViewController', '172.20.10.2', '1529625863471', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1912', 'ViewController', '172.20.10.2', '1529625884114', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1913', 'ViewController', '172.20.10.2', '1529625885273', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1914', 'ViewController', '172.20.10.2', '1529625923808', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1915', 'ViewController', '172.20.10.2', '1529625924994', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1916', 'ViewController', '172.20.10.2', '1529625968249', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1917', 'ViewController', '172.20.10.2', '1529625969405', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1918', 'ViewController', '172.20.10.2', '1529626795252', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1919', 'ViewController', '172.20.10.2', '1529626805212', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1920', 'ViewController', '172.20.10.2', '1529626865469', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1921', 'ViewController', '172.20.10.2', '1529626871737', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1922', 'ViewController', '172.20.10.2', '1529626880492', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1923', 'ViewController', '172.20.10.2', '1529626888577', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1924', 'ViewController', '172.20.10.2', '1529626912188', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1925', 'ViewController', '172.20.10.2', '1529627104360', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1926', 'ViewController', '172.20.10.2', '1529627180026', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1952', 'ViewController', '172.20.10.2', '1529635071152', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1963', 'ViewController', '172.20.10.2', '1529639990337', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '4');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1964', 'ViewController', '192.168.75.1', '1529642503901', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1965', 'ViewController', '192.168.75.1', '1529644735503', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1966', 'ViewController', '192.168.75.1', '1529644998715', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '8');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1967', 'ViewController', '192.168.75.1', '1529645035746', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1968', 'ViewController', '192.168.75.1', '1529645083903', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1969', 'ViewController', '192.168.75.1', '1529645164281', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '4');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1970', 'ViewController', '192.168.75.1', '1529645202412', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1971', 'ViewController', '192.168.75.1', '1529645266398', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1972', 'ViewController', '192.168.75.1', '1529645288047', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1973', 'ViewController', '192.168.75.1', '1529645378133', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1974', 'ViewController', '192.168.75.1', '1529645556657', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1975', 'ViewController', '192.168.75.1', '1529645589369', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1976', 'ViewController', '192.168.75.1', '1529645617896', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1977', 'ViewController', '192.168.75.1', '1529646061272', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1978', 'ViewController', '192.168.75.1', '1529646074164', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1979', 'ViewController', '192.168.75.1', '1529646099001', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1980', 'ViewController', '192.168.75.1', '1529646144687', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1981', 'ViewController', '192.168.75.1', '1529647938933', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1982', 'ViewController', '192.168.75.1', '1529647978405', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1983', 'ViewController', '192.168.75.1', '1529647981835', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1984', 'ViewController', '192.168.75.1', '1529647983842', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '134');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1985', 'ViewController', '172.20.10.2', '1529648387557', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1795', 'ViewController', '172.20.10.2', '1529572590785', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1796', 'ViewController', '172.20.10.2', '1529572592643', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1797', 'ViewController', '172.20.10.2', '1529572668791', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1798', 'ViewController', '172.20.10.2', '1529572670093', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1799', 'ViewController', '172.20.10.2', '1529572683143', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1800', 'ViewController', '172.20.10.2', '1529572684404', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1801', 'ViewController', '172.20.10.2', '1529572686678', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1802', 'ViewController', '172.20.10.2', '1529572688074', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1803', 'ViewController', '172.20.10.2', '1529572699621', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1804', 'ViewController', '172.20.10.2', '1529572701776', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1805', 'ViewController', '172.20.10.2', '1529572825328', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1806', 'ViewController', '172.20.10.2', '1529572826521', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1807', 'ViewController', '172.20.10.2', '1529572860179', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1808', 'ViewController', '172.20.10.2', '1529572861496', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1809', 'ViewController', '172.20.10.2', '1529572864145', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1810', 'ViewController', '172.20.10.2', '1529572865555', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1811', 'ViewController', '172.20.10.2', '1529572886514', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1812', 'ViewController', '172.20.10.2', '1529572887885', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1813', 'ViewController', '172.20.10.2', '1529572925416', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1814', 'ViewController', '172.20.10.2', '1529572926696', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1815', 'ViewController', '172.20.10.2', '1529572977897', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1816', 'ViewController', '172.20.10.2', '1529572979208', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1817', 'ViewController', '172.20.10.2', '1529572980858', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1818', 'ViewController', '172.20.10.2', '1529572982180', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1819', 'ViewController', '172.20.10.2', '1529573033228', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1820', 'ViewController', '172.20.10.2', '1529573034510', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1821', 'ViewController', '172.20.10.2', '1529573038047', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1822', 'ViewController', '172.20.10.2', '1529573039413', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1823', 'ViewController', '172.20.10.2', '1529573250210', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1824', 'ViewController', '172.20.10.2', '1529573251521', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1825', 'ViewController', '172.20.10.2', '1529573254133', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1826', 'ViewController', '172.20.10.2', '1529573255430', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1827', 'ViewController', '172.20.10.2', '1529573255822', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1828', 'ViewController', '172.20.10.2', '1529573257140', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1829', 'ViewController', '172.20.10.2', '1529573268470', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1830', 'ViewController', '172.20.10.2', '1529573269735', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1831', 'ViewController', '172.20.10.2', '1529573271572', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1832', 'ViewController', '172.20.10.2', '1529573272870', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1833', 'ViewController', '172.20.10.2', '1529573277052', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1834', 'ViewController', '172.20.10.2', '1529573278404', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1835', 'ViewController', '172.20.10.2', '1529573397223', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1836', 'ViewController', '172.20.10.2', '1529573398535', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1837', 'ViewController', '172.20.10.2', '1529573523901', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1838', 'ViewController', '172.20.10.2', '1529573568588', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1839', 'ViewController', '172.20.10.2', '1529573570075', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1840', 'ViewController', '172.20.10.2', '1529573629738', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1841', 'ViewController', '172.20.10.2', '1529573631032', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1842', 'ViewController', '172.20.10.2', '1529573662317', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1843', 'ViewController', '172.20.10.2', '1529573663586', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1844', 'ViewController', '172.20.10.2', '1529573684589', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1845', 'ViewController', '172.20.10.2', '1529573685858', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1846', 'ViewController', '172.20.10.2', '1529573761984', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1847', 'ViewController', '172.20.10.2', '1529573763278', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1848', 'ViewController', '172.20.10.2', '1529573779318', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1849', 'ViewController', '172.20.10.2', '1529573780585', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1850', 'ViewController', '172.20.10.2', '1529573819661', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1851', 'ViewController', '172.20.10.2', '1529573820952', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1852', 'ViewController', '172.20.10.2', '1529573857625', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1853', 'ViewController', '172.20.10.2', '1529573858902', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1854', 'ViewController', '172.20.10.2', '1529574100252', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1855', 'ViewController', '172.20.10.2', '1529574101573', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1856', 'ViewController', '172.20.10.2', '1529574180394', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1857', 'ViewController', '172.20.10.2', '1529574181676', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1858', 'ViewController', '172.20.10.2', '1529574392643', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1859', 'ViewController', '172.20.10.2', '1529574393938', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1860', 'ViewController', '172.20.10.2', '1529574479608', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1861', 'ViewController', '172.20.10.2', '1529574480918', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1862', 'ViewController', '172.20.10.2', '1529574575297', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1863', 'ViewController', '172.20.10.2', '1529574576598', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1864', 'ViewController', '172.20.10.2', '1529574650976', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1865', 'ViewController', '172.20.10.2', '1529574652289', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1866', 'ViewController', '172.20.10.2', '1529574664038', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1867', 'ViewController', '172.20.10.2', '1529574665299', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1868', 'ViewController', '172.20.10.2', '1529574721979', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1869', 'ViewController', '172.20.10.2', '1529574723285', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1870', 'ViewController', '172.20.10.2', '1529574749220', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1871', 'ViewController', '172.20.10.2', '1529574750558', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1872', 'ViewController', '172.20.10.2', '1529574815803', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1873', 'ViewController', '172.20.10.2', '1529574817139', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1874', 'ViewController', '172.20.10.2', '1529574868047', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1875', 'ViewController', '172.20.10.2', '1529574869337', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1876', 'ViewController', '172.20.10.2', '1529574933035', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1877', 'ViewController', '172.20.10.2', '1529574934325', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1878', 'ViewController', '172.20.10.2', '1529574996844', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1879', 'ViewController', '172.20.10.2', '1529574998140', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1880', 'ViewController', '172.20.10.2', '1529575082069', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1881', 'ViewController', '172.20.10.2', '1529575083383', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1882', 'ViewController', '172.20.10.2', '1529575088379', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1883', 'ViewController', '172.20.10.2', '1529575089696', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1884', 'ViewController', '172.20.10.2', '1529575180762', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1885', 'ViewController', '172.20.10.2', '1529575182077', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1886', 'ViewController', '172.20.10.2', '1529575236761', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1887', 'ViewController', '172.20.10.2', '1529575238067', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1888', 'ViewController', '172.20.10.2', '1529575269710', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1889', 'ViewController', '172.20.10.2', '1529575271024', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1890', 'ViewController', '172.20.10.2', '1529575312595', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1891', 'ViewController', '172.20.10.2', '1529575313898', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1892', 'ViewController', '172.20.10.2', '1529575474774', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1893', 'ViewController', '172.20.10.2', '1529575476101', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1894', 'ViewController', '172.20.10.2', '1529575496442', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1895', 'ViewController', '172.20.10.2', '1529575497822', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1896', 'ViewController', '172.20.10.2', '1529575546201', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1897', 'ViewController', '172.20.10.2', '1529575547400', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1898', 'ViewController', '172.20.10.2', '1529575651392', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1899', 'ViewController', '172.20.10.2', '1529575652526', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1900', 'ViewController', '172.20.10.2', '1529575653664', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1901', 'ViewController', '172.20.10.2', '1529575654821', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1902', 'ViewController', '172.20.10.2', '1529575769747', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1903', 'ViewController', '172.20.10.2', '1529575771035', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1904', 'ViewController', '172.20.10.2', '1529575772523', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["main"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1905', 'ViewController', '172.20.10.2', '1529575773802', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["log/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1953', 'ViewController', '172.20.10.2', '1529635501131', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1954', 'ViewController', '172.20.10.2', '1529635551695', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1955', 'ViewController', '172.20.10.2', '1529635553591', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1956', 'ViewController', '172.20.10.2', '1529635554572', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1957', 'ViewController', '172.20.10.2', '1529635555290', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1958', 'ViewController', '172.20.10.2', '1529635556141', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1959', 'ViewController', '172.20.10.2', '1529635581504', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1960', 'ViewController', '172.20.10.2', '1529635590819', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1961', 'ViewController', '172.20.10.2', '1529636001963', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '4');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('1962', 'ViewController', '172.20.10.2', '1529636182109', 'VIEW_001', 'forward', 'VIEW', '视图模块', '[未登录]', '访问视图', '["menu/index"]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2022', 'MenuController', '192.168.115.101', '1529896035840', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"USER","type":1,"pid":null,"sortNo":null,"id":2021}]', '202');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2024', 'MenuController', '192.168.115.101', '1529896133775', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '19');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2026', 'MenuController', '192.168.115.101', '1529896353580', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"11111111","url":null,"code":"11111111111111","type":3,"pid":2023,"sortNo":null,"id":2025}]', '17');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2028', 'MenuController', '192.168.115.101', '1529896368452', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"44","url":null,"code":"44444444444","type":3,"pid":2023,"sortNo":null,"id":2027}]', '23');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2030', 'MenuController', '192.168.115.101', '1529896585463', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"菜单模块","url":null,"code":"MENU","type":1,"pid":null,"sortNo":null,"id":2029}]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2032', 'MenuController', '192.168.115.101', '1529896635326', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"计划模块","url":null,"code":"1111","type":1,"pid":null,"sortNo":null,"id":2031}]', '14');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2002', 'MenuController', '192.168.115.101', '1529894676482', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"菜单","url":"","code":"MENU","type":1,"pid":null,"sortNo":3,"id":2001}]', '80');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2004', 'MenuController', '192.168.115.101', '1529894762164', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"菜单首页","url":"view?page\u003dmenu/index","code":"MENU_001","type":2,"pid":null,"sortNo":1,"id":2003}]', '23');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2006', 'MenuController', '192.168.115.101', '1529894903123', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"菜单首页2","url":"view?page\u003dmenu/index","code":"MENU_001","type":2,"pid":null,"sortNo":4,"id":2005}]', '30');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2008', 'MenuController', '192.168.115.101', '1529895046321', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"菜单首页3","url":"","code":"sss","type":2,"pid":null,"sortNo":null,"id":2007}]', '17');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2010', 'MenuController', '192.168.115.101', '1529895083284', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"11","url":"","code":"111","type":3,"pid":null,"sortNo":null,"id":2009}]', '29');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2012', 'MenuController', '192.168.115.101', '1529895132663', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"122","url":"","code":"111111111","type":2,"pid":2001,"sortNo":null,"id":2011}]', '27');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2014', 'MenuController', '192.168.115.101', '1529895146423', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"333","url":"33","code":"333333333333","type":3,"pid":2011,"sortNo":null,"id":2013}]', '32');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2016', 'MenuController', '192.168.115.101', '1529895714492', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"321","url":null,"code":"321","type":1,"pid":null,"sortNo":null,"id":2015}]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2018', 'MenuController', '192.168.115.101', '1529895745768', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"32","url":null,"code":"333333333","type":3,"pid":2011,"sortNo":null,"id":2017}]', '14');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2020', 'MenuController', '192.168.115.101', '1529895785192', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"32","url":null,"code":"333333333","type":3,"pid":2011,"sortNo":null,"id":2019}]', '18');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2040', 'MenuController', '192.168.115.101', '1529896758181', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"111","url":null,"code":"11111","type":1,"pid":null,"sortNo":null,"id":2039}]', '35');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2042', 'MenuController', '192.168.115.101', '1529896770062', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"232","url":"32","code":"32","type":1,"pid":2039,"sortNo":null,"id":2041}]', '19');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2047', 'MenuController', '192.168.115.101', '1529896813072', 'FUNC_001', 'save', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"44443","url":null,"code":"3333","type":2,"pid":2039,"sortNo":null,"id":2046}]', '37');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2048', 'MenuController', '192.168.115.101', '1529897336178', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户授权","url":null,"code":"USER_001","type":1,"pid":2021,"sortNo":null,"id":null}]', '342');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2049', 'MenuController', '192.168.115.101', '1529897346337', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户授权","url":null,"code":"USER_001","type":1,"pid":2021,"sortNo":null,"id":null}]', '8');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2051', 'MenuController', '192.168.115.101', '1529897380684', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户授权","url":null,"code":"USER_002","type":1,"pid":2021,"sortNo":null,"id":2050}]', '52');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2052', 'MenuController', '192.168.115.101', '1529905099168', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"44","url":null,"code":"44444444444","type":2,"pid":null,"sortNo":null,"id":null}]', '6');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2053', 'MenuController', '192.168.115.101', '1529905980850', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"5555555","url":null,"code":"555555","type":3,"pid":2023,"sortNo":null,"id":2025}]', '32');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2054', 'MenuController', '192.168.115.101', '1529906193179', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2055', 'MenuController', '192.168.115.101', '1529906206498', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"333","url":null,"code":"333","type":3,"pid":2023,"sortNo":null,"id":2025}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2056', 'MenuController', '192.168.115.101', '1529906213178', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"333","url":null,"code":"33333","type":3,"pid":2023,"sortNo":null,"id":2025}]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2057', 'MenuController', '192.168.115.101', '1529906243594', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"11111111","url":null,"code":"777777","type":3,"pid":2023,"sortNo":null,"id":2025}]', '30');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2058', 'MenuController', '192.168.115.101', '1529906253141', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"5555","url":null,"code":"777777","type":3,"pid":2023,"sortNo":null,"id":2025}]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2059', 'MenuController', '192.168.115.101', '1529906818675', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '21');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2060', 'MenuController', '192.168.115.101', '1529906825124', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2061', 'MenuController', '192.168.115.101', '1529906924417', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2062', 'MenuController', '192.168.115.101', '1529906932186', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '6');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2063', 'MenuController', '192.168.115.101', '1529906977364', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":null,"id":2023}]', '60');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2064', 'MenuController', '192.168.115.101', '1529906995503', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER","type":2,"pid":2021,"sortNo":null,"id":2023}]', '5');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2065', 'MenuController', '192.168.115.101', '1529906999259', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER","type":2,"pid":2021,"sortNo":null,"id":2023}]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2066', 'MenuController', '192.168.115.101', '1529907016843', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER","type":2,"pid":2021,"sortNo":2,"id":2023}]', '6');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2067', 'MenuController', '192.168.115.101', '1529907022251', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理页面2","url":"view?page\u003duser/index","code":"USER_001","type":2,"pid":2021,"sortNo":2,"id":2023}]', '14');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2068', 'MenuController', '192.168.115.101', '1529907048943', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"USER","type":1,"pid":null,"sortNo":1,"id":2021}]', '14');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2069', 'MenuController', '192.168.115.101', '1529907052914', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"111","url":null,"code":"11111","type":1,"pid":null,"sortNo":3,"id":2039}]', '13');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2070', 'MenuController', '192.168.115.101', '1529907056883', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"计划模块","url":null,"code":"1111","type":1,"pid":null,"sortNo":2,"id":2031}]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2071', 'MenuController', '192.168.115.101', '1529907060772', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"菜单模块","url":null,"code":"MENU","type":1,"pid":null,"sortNo":4,"id":2029}]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2072', 'MenuController', '192.168.115.101', '1529907073316', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户授权","url":null,"code":"USER_002","type":1,"pid":2021,"sortNo":1,"id":2050}]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2073', 'MenuController', '192.168.115.101', '1529908320540', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '11');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2074', 'MenuController', '192.168.115.101', '1529908349137', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '36');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2075', 'MenuController', '192.168.115.101', '1529908376025', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '10');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2076', 'MenuController', '192.168.115.101', '1529908437106', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2077', 'MenuController', '192.168.115.101', '1529908439434', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '11');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2078', 'MenuController', '192.168.115.101', '1529908449352', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2041]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2079', 'MenuController', '192.168.115.101', '1529908457278', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2046]', '16');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2080', 'MenuController', '192.168.115.101', '1529908569202', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2031]', '20');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2081', 'MenuController', '192.168.115.101', '1529908576176', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '21');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2082', 'MenuController', '192.168.115.101', '1529908595734', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2050]', '29');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2083', 'MenuController', '192.168.115.101', '1529908601988', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2023]', '8');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2084', 'MenuController', '192.168.115.101', '1529908607170', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2023]', '12');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2087', 'MenuController', '192.168.115.101', '1530001250458', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '33');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2088', 'MenuController', '192.168.115.101', '1530001487218', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2023]', '12');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2089', 'MenuController', '192.168.115.101', '1530001504820', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '45');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2090', 'MenuController', '192.168.115.101', '1530001544250', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '9');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2091', 'MenuController', '192.168.115.101', '1530001576521', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '10');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2092', 'MenuController', '192.168.115.101', '1530001595169', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"111","url":null,"code":"USER","type":1,"pid":null,"sortNo":3,"id":2039}]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2093', 'MenuController', '192.168.115.101', '1530001641530', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '6');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2094', 'MenuController', '192.168.115.101', '1530001653884', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '29');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2095', 'MenuController', '192.168.115.101', '1530001725396', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '34');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2096', 'MenuController', '192.168.115.101', '1530001762009', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '18');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2097', 'MenuController', '192.168.115.101', '1530001785936', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2098', 'MenuController', '192.168.115.101', '1530001807104', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '21');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2099', 'MenuController', '192.168.115.101', '1530001834156', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '16');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2100', 'MenuController', '192.168.115.101', '1530001846917', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '12');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2101', 'MenuController', '192.168.115.101', '1530001893910', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '34');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2102', 'MenuController', '192.168.115.101', '1530001993659', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '47');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2103', 'MenuController', '192.168.115.101', '1530002214396', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"1111","type":1,"pid":null,"sortNo":1,"id":2021}]', '216');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2104', 'MenuController', '192.168.115.101', '1530002222223', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '23');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2105', 'MenuController', '192.168.115.101', '1530002303506', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"11111","type":1,"pid":null,"sortNo":1,"id":2021}]', '8');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2106', 'MenuController', '192.168.115.101', '1530002371863', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[{"name":"用户管理","url":null,"code":"1111","type":1,"pid":null,"sortNo":1,"id":2021}]', '65');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2107', 'MenuController', '192.168.115.101', '1530002744395', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '6');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2108', 'MenuController', '192.168.115.101', '1530002800214', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2109', 'MenuController', '192.168.115.101', '1530002856668', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2110', 'MenuController', '192.168.115.101', '1530002925895', 'MENU_002', 'delete', 'CORE_MENU', '菜单管理', '[未登录]', '保存或更新信息', '[2021]', '16');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2132', 'PermissionController', '192.168.115.107', '1530335497202', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2126,"userId":null,"menuId":2025,"id":2128},{"roleId":2126,"userId":null,"menuId":2029,"id":2129},{"roleId":2126,"userId":null,"menuId":2021,"id":2130},{"roleId":2126,"userId":null,"menuId":2023,"id":2131}]]', '259');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2137', 'PermissionController', '192.168.115.107', '1530336535738', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2126,"userId":null,"menuId":2025,"id":2133},{"roleId":2126,"userId":null,"menuId":2029,"id":2134},{"roleId":2126,"userId":null,"menuId":2021,"id":2135},{"roleId":2126,"userId":null,"menuId":2023,"id":2136}]]', '30');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2196', 'PermissionController', '192.168.115.107', '1530339183036', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":2125,"userId":null,"menuId":2021,"id":2190},{"roleId":2125,"userId":null,"menuId":2023,"id":2191},{"roleId":2125,"userId":null,"menuId":2027,"id":2192},{"roleId":2125,"userId":null,"menuId":2025,"id":2193},{"roleId":2125,"userId":null,"menuId":2039,"id":2194},{"roleId":2125,"userId":null,"menuId":2029,"id":2195}]]', '49');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2266', 'UserController', '192.168.115.107', '1530354097014', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"32","userPassword":null,"userCode":"3232","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":22,"lastLoginIP":null,"lastLoginDate":null,"id":2236}]', '37');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2267', 'UserController', '192.168.115.107', '1530354174225', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"3333","userPassword":null,"userCode":"3343232","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2236}]', '83');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2268', 'UserController', '192.168.115.107', '1530354185800', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"32","userPassword":null,"userCode":"3232","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":22,"lastLoginIP":null,"lastLoginDate":null,"id":2236}]', '75');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2269', 'UserController', '192.168.115.107', '1530354219503', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"3211111111","userPassword":null,"userCode":"321321","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2238}]', '27');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2270', 'UserController', '192.168.115.107', '1530354226442', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"213","userPassword":null,"userCode":"321","email":null,"phone":null,"position":null,"sex":null,"jobState":"试用","accountState":"锁定","memo":null,"deptId":2219,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '77');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2271', 'UserController', '192.168.115.107', '1530354231230', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"11111111","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '40');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2272', 'UserController', '192.168.115.107', '1530354250211', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"32","userPassword":null,"userCode":"432","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '92');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2289', 'UserController', '192.168.115.107', '1530369152471', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"3214443","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '82');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2293', 'PermissionController', '192.168.115.107', '1530369834924', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":null,"userId":2256,"menuId":2021,"id":2290},{"roleId":null,"userId":2256,"menuId":2023,"id":2291},{"roleId":null,"userId":2256,"menuId":2025,"id":2292}]]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2295', 'PermissionController', '192.168.115.107', '1530369843744', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":null,"userId":2245,"menuId":2039,"id":2294}]]', '36');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2300', 'PermissionController', '192.168.115.107', '1530369917270', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":null,"userId":2245,"menuId":2021,"id":2296},{"roleId":null,"userId":2245,"menuId":2023,"id":2297},{"roleId":null,"userId":2245,"menuId":2025,"id":2298},{"roleId":null,"userId":2245,"menuId":2039,"id":2299}]]', '36');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2305', 'PermissionController', '192.168.115.107', '1530369928455', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '[未登录]', '保存权限', '[[{"roleId":null,"userId":2245,"menuId":2021,"id":2301},{"roleId":null,"userId":2245,"menuId":2023,"id":2302},{"roleId":null,"userId":2245,"menuId":2025,"id":2303},{"roleId":null,"userId":2245,"menuId":2039,"id":2304}]]', '62');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2348', 'UserController', '169.254.136.86', '1531095758893', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"测试01","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"1203","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2347}]', '39');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2350', 'UserController', '169.254.136.86', '1531095772651', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"测试02","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"1204","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2349}]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2353', 'MenuController', '169.254.136.86', '1531095866401', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"添加","name_en":"Add","name_th":"Add","pinYinIndex":"TJ","url":null,"code":"USER_ADD","type":3,"pid":2323,"sortNo":null,"id":2352}]', '39');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2362', 'PermissionController', '169.254.136.86', '1531096012645', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '张三', '保存权限', '[[{"roleId":2351,"userId":null,"menuId":2321,"id":2354},{"roleId":2351,"userId":null,"menuId":2323,"id":2355},{"roleId":2351,"userId":null,"menuId":2352,"id":2356},{"roleId":2351,"userId":null,"menuId":2353,"id":2357},{"roleId":2351,"userId":null,"menuId":2354,"id":2358},{"roleId":2351,"userId":null,"menuId":2325,"id":2359},{"roleId":2351,"userId":null,"menuId":2330,"id":2360},{"roleId":2351,"userId":null,"menuId":2327,"id":2361}]]', '44');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2264', 'UserController', '192.168.115.107', '1530353007331', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"784343444","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"734","deptId":2219,"lastLoginIP":null,"lastLoginDate":null,"id":2256}]', '173');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2265', 'UserController', '192.168.115.107', '1530353015200', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"784343444","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"734","deptId":22,"lastLoginIP":null,"lastLoginDate":null,"id":2256}]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2366', 'MenuController', '169.254.136.86', '1531105032247', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '高飞', '保存或更新信息', '[{"name":"角色管理","name_en":"Role Management","name_th":"Role Management","pinYinIndex":"JSGL","url":"view?page\u003dcommon/role","code":"ROLE","type":2,"pid":2321,"sortNo":null,"id":2327}]', '58');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2381', 'PermissionController', '169.254.136.86', '1531106061039', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '高飞', '保存权限', '[[{"roleId":2369,"userId":null,"menuId":2321,"id":2373},{"roleId":2369,"userId":null,"menuId":2323,"id":2374},{"roleId":2369,"userId":null,"menuId":2352,"id":2375},{"roleId":2369,"userId":null,"menuId":2353,"id":2376},{"roleId":2369,"userId":null,"menuId":2354,"id":2377},{"roleId":2369,"userId":null,"menuId":2325,"id":2378},{"roleId":2369,"userId":null,"menuId":2330,"id":2379},{"roleId":2369,"userId":null,"menuId":2327,"id":2380}]]', '35');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2385', 'PermissionController', '169.254.136.86', '1531106068110', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '高飞', '保存权限', '[[{"roleId":2369,"userId":null,"menuId":2321,"id":2382},{"roleId":2369,"userId":null,"menuId":2325,"id":2383},{"roleId":2369,"userId":null,"menuId":2330,"id":2384}]]', '29');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2390', 'PermissionController', '169.254.136.86', '1531106113768', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '高飞', '保存权限', '[[{"roleId":null,"userId":2349,"menuId":2321,"id":2386},{"roleId":null,"userId":2349,"menuId":2325,"id":2387},{"roleId":null,"userId":2349,"menuId":2330,"id":2388},{"roleId":null,"userId":2349,"menuId":2327,"id":2389}]]', '28');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2396', 'PermissionController', '169.254.136.86', '1531106235953', 'PERMISSION_SAVE', 'savePermission', 'PERMISSION', '权限管理', '高飞', '保存权限', '[[{"roleId":2369,"userId":null,"menuId":2321,"id":2391},{"roleId":2369,"userId":null,"menuId":2323,"id":2392},{"roleId":2369,"userId":null,"menuId":2352,"id":2393},{"roleId":2369,"userId":null,"menuId":2325,"id":2394},{"roleId":2369,"userId":null,"menuId":2330,"id":2395}]]', '15');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2398', 'MenuController', '169.254.136.86', '1531107231194', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '高飞', '保存或更新信息', '[{"name":"xxx","name_en":"xx","name_th":"xx","pinYinIndex":"XXX","url":null,"code":"SYSTEM_x","type":1,"pid":2321,"sortNo":null,"id":2397}]', '55');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2246', 'UserController', '192.168.115.107', '1530348287069', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"213","userPassword":"2b2eb361ece0631ea06cc2ebfa72dd3c","userCode":"321","email":null,"phone":null,"position":null,"sex":null,"jobState":"试用","accountState":"锁定","memo":null,"deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2247', 'UserController', '192.168.115.107', '1530348613720', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"78","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '33');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2248', 'UserController', '192.168.115.107', '1530348624062', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"7213","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '18');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2249', 'UserController', '192.168.115.107', '1530348625532', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"7213","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2250', 'UserController', '192.168.115.107', '1530348691761', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"7213","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '43');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2251', 'UserController', '192.168.115.107', '1530348692954', 'MENU_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"7213","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '10');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2252', 'UserController', '192.168.115.107', '1530348970051', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"78","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":null}]', '297');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2254', 'UserController', '192.168.115.107', '1530348973949', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '38');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2255', 'UserController', '192.168.115.107', '1530348998476', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"78","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"734","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":null}]', '50');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2257', 'UserController', '192.168.115.107', '1530349003497', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"784343444","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"734","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2256}]', '58');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2258', 'UserController', '192.168.115.107', '1530349121168', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78222222","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '51');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2259', 'UserController', '192.168.115.107', '1530349268687', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"78222222","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '28');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2260', 'UserController', '192.168.115.107', '1530349277099', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"11111111","userPassword":null,"userCode":"78333","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":null,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '28');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2281', 'UserController', '192.168.115.107', '1530364249347', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞飞飞凤飞飞付","userPassword":null,"userCode":"321444","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '463');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2282', 'UserController', '192.168.115.107', '1530364255180', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"321444","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '34');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2283', 'UserController', '192.168.115.107', '1530364278678', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞3","userPassword":null,"userCode":"321444","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '0');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2284', 'UserController', '192.168.115.107', '1530364281261', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞3","userPassword":null,"userCode":"321444","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '1');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2285', 'UserController', '192.168.115.107', '1530364616213', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"321444","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '78');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2286', 'UserController', '192.168.115.107', '1530364838973', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"3214443","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '31');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2287', 'UserController', '192.168.115.107', '1530364918634', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"3214443","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2288', 'UserController', '192.168.115.107', '1530364923684', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"3214443","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '45');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2273', 'UserController', '192.168.115.107', '1530363995801', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"888","userPassword":null,"userCode":"784343444","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"734","deptId":22,"lastLoginIP":null,"lastLoginDate":null,"id":2256}]', '76351');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2274', 'UserController', '192.168.115.107', '1530364027510', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"32","userPassword":null,"userCode":"432","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '56');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2275', 'UserController', '192.168.115.107', '1530364032633', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"2133333","userPassword":null,"userCode":"321","email":"78","phone":null,"position":"87","sex":"8","jobState":"试用","accountState":"锁定","memo":"732","deptId":2219,"lastLoginIP":null,"lastLoginDate":null,"id":2245}]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2276', 'UserController', '192.168.115.107', '1530364037821', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"32333333333333333333","userPassword":null,"userCode":"432","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '27');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2277', 'UserController', '192.168.115.107', '1530364046908', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"张三","userPassword":null,"userCode":"432","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":12,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '22');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2278', 'UserController', '192.168.115.107', '1530364062190', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"321","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":null}]', '299');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2280', 'UserController', '192.168.115.107', '1530364065327', 'USER_001', 'save2', 'USER', '菜单管理', '[未登录]', '保存或更新信息', '[{"userName":"321","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"321444","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":44,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '43');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2322', 'MenuController', '169.254.136.86', '1531094825148', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"系统配置","name_en":"System Configuration","name_th":"System Configuration","pinYinIndex":"XTPZ","url":null,"code":"SYSTEM","type":1,"pid":null,"sortNo":1,"id":2321}]', '107');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2324', 'MenuController', '169.254.136.86', '1531094880415', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"用户管理","name_en":"User Management","name_th":"User Management","pinYinIndex":"YHGL","url":"view?page\u003dcommon/user","code":"USER","type":2,"pid":2321,"sortNo":1,"id":2323}]', '35');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2326', 'MenuController', '169.254.136.86', '1531094950940', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"菜单配置","name_en":"Menu Congifuration","name_th":"Menu Congifuration","pinYinIndex":"CDPZ","url":"view?page\u003dcommon/menu","code":"MENU","type":2,"pid":2321,"sortNo":null,"id":2325}]', '39');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2328', 'MenuController', '169.254.136.86', '1531095175403', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"角色管理","name_en":"Role Management","name_th":"Role Management","pinYinIndex":"JSGL","url":null,"code":"ROLE","type":2,"pid":2321,"sortNo":null,"id":2327}]', '31');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2329', 'MenuController', '169.254.136.86', '1531095192621', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"角色管理","name_en":"Role Management","name_th":"Role Management","pinYinIndex":"JSGL","url":"view?page\u003dcommon/menu","code":"ROLE","type":2,"pid":2321,"sortNo":null,"id":2327}]', '32');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2331', 'MenuController', '169.254.136.86', '1531095268640', 'MENU_001', 'save2', 'CORE_MENU', '菜单管理', '张三', '保存或更新信息', '[{"name":"组织机构","name_en":"Department Management","name_th":"Department Management","pinYinIndex":"ZZJG","url":"view?page\u003dcommon/menu","code":"Department","type":2,"pid":2321,"sortNo":null,"id":2330}]', '34');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2333', 'DeptController', '169.254.136.86', '1531095289117', 'DEPARTMENT_001', 'save2', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[{"pid":null,"name":"研发部","memo":null,"sortNo":null,"id":2332}]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2334', 'DeptController', '169.254.136.86', '1531095409852', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[12]', '18');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2335', 'DeptController', '169.254.136.86', '1531095416545', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[2219]', '16');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2336', 'DeptController', '169.254.136.86', '1531095428828', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[2219]', '7');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2337', 'DeptController', '169.254.136.86', '1531095460816', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[22]', '18');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2338', 'DeptController', '169.254.136.86', '1531095503266', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[2217]', '10');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2339', 'DeptController', '169.254.136.86', '1531095508106', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[12]', '17');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2340', 'DeptController', '169.254.136.86', '1531095510719', 'DEPARTMENT_002', 'delete', 'CORE_DEPARTMENT', '菜单管理', '张三', '保存或更新信息', '[44]', '11');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2341', 'UserController', '169.254.136.86', '1531095621202', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"风飞凤飞","userPassword":null,"userCode":"3214443","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2279}]', '24');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2342', 'UserController', '169.254.136.86', '1531095625447', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"78","userPassword":null,"userCode":"784343444","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"734","deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2256}]', '19');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2343', 'UserController', '169.254.136.86', '1531095629919', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"张三","userPassword":null,"userCode":"432","email":"78","phone":null,"position":"87","sex":"8","jobState":"在职","accountState":"正常","memo":"732","deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '25');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2344', 'UserController', '169.254.136.86', '1531095678578', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"高飞","userPassword":null,"userCode":"1202","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2253}]', '17');
INSERT INTO "MES"."CORE_SYSTEM_LOG" VALUES ('2346', 'UserController', '169.254.136.86', '1531095709289', 'USER_001', 'save2', 'USER', '菜单管理', '张三', '保存或更新信息', '[{"userName":"高飞","userPassword":"bb497280bcb5c9a889216e79f511cd3a","userCode":"1202","email":null,"phone":null,"position":null,"sex":null,"jobState":"在职","accountState":"正常","memo":null,"deptId":2332,"lastLoginIP":null,"lastLoginDate":null,"id":2345}]', '76');

-- ----------------------------
-- Table structure for CORE_USER
-- ----------------------------
DROP TABLE "MES"."CORE_USER";
CREATE TABLE "MES"."CORE_USER" (
"ID" NUMBER(19) NOT NULL ,
"ACCOUNTSTATE" VARCHAR2(255 CHAR) NOT NULL ,
"DEPTID" NUMBER(19) NULL ,
"EMAIL" VARCHAR2(255 CHAR) NULL ,
"JOBSTATE" VARCHAR2(255 CHAR) NOT NULL ,
"MEMO" VARCHAR2(255 CHAR) NULL ,
"PHONE" VARCHAR2(255 CHAR) NULL ,
"POSITION" VARCHAR2(255 CHAR) NULL ,
"SEX" VARCHAR2(255 CHAR) NULL ,
"USERCODE" VARCHAR2(255 CHAR) NOT NULL ,
"USERNAME" VARCHAR2(255 CHAR) NOT NULL ,
"USERPASSWORD" VARCHAR2(255 CHAR) NOT NULL ,
"LASTLOGINDATE" VARCHAR2(255 CHAR) NULL ,
"LASTLOGINIP" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_USER
-- ----------------------------
INSERT INTO "MES"."CORE_USER" VALUES ('2347', '正常', '2332', null, '在职', null, null, null, null, '1203', '测试01', 'bb497280bcb5c9a889216e79f511cd3a', null, null);
INSERT INTO "MES"."CORE_USER" VALUES ('2349', '正常', '2332', null, '在职', null, null, null, null, '1204', '测试02', 'bb497280bcb5c9a889216e79f511cd3a', null, null);
INSERT INTO "MES"."CORE_USER" VALUES ('2345', '正常', '2332', null, '在职', null, null, null, null, '1202', '高飞', 'bb497280bcb5c9a889216e79f511cd3a', '2018-07-09 11:17:39', '169.254.136.86');

-- ----------------------------
-- Table structure for CORE_USER_ROLE
-- ----------------------------
DROP TABLE "MES"."CORE_USER_ROLE";
CREATE TABLE "MES"."CORE_USER_ROLE" (
"ID" NUMBER(19) NOT NULL ,
"ROLEID" NUMBER(19) NULL ,
"USERID" NUMBER(19) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CORE_USER_ROLE
-- ----------------------------
INSERT INTO "MES"."CORE_USER_ROLE" VALUES ('2370', '2369', '2349');
INSERT INTO "MES"."CORE_USER_ROLE" VALUES ('2371', '2369', '2347');
INSERT INTO "MES"."CORE_USER_ROLE" VALUES ('2372', '2369', '2345');

-- ----------------------------
-- Function structure for GET_SEQUENCE_NUMBER
-- ----------------------------
CREATE OR REPLACE FUNCTION "MES"."GET_SEQUENCE_NUMBER" RETURN NUMBER
IS 
PRAGMA AUTONOMOUS_TRANSACTION;
SEQ_NUM NUMBER;
UPDATED_ROWS NUMBER;
BEGIN
	-- 循环，重新获取ID
	<<repeat>>
	SELECT SEQUENCE_NUMBER INTO SEQ_NUM FROM DATASWEEP_SEQUENCE WHERE SEQ_NUM_ID=2;
	-- 执行ID累加更新操作
	UPDATE DATASWEEP_SEQUENCE SET SEQUENCE_NUMBER=SEQUENCE_NUMBER+1 WHERE SEQ_NUM_ID=2 AND SEQUENCE_NUMBER=SEQ_NUM;
	UPDATED_ROWS:=SQL%ROWCOUNT;
	-- 如果更新行数为0，那么说明失败，需要重新获取,跳转到repeat
	IF UPDATED_ROWS=0 then 
		GOTO repeat;
	END IF;
	COMMIT;
	RETURN SEQ_NUM+1;
END GET_SEQUENCE_NUMBER;
/

-- ----------------------------
-- Sequence structure for HIBERNATE_SEQUENCE
-- ----------------------------
DROP SEQUENCE "MES"."HIBERNATE_SEQUENCE";
CREATE SEQUENCE "MES"."HIBERNATE_SEQUENCE"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 2401
 CACHE 20;

-- ----------------------------
-- Indexes structure for table AT_MES_QM_REAS
-- ----------------------------

-- ----------------------------
-- Checks structure for table AT_MES_QM_REAS
-- ----------------------------
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("SITE_NUM" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("ATR_KEY" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("ARCH_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("COLLET_CD_DESC_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("COLLET_CD_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("CREATED_BY_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("CREATED_TIME_T" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("REAS_CD_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("REAS_DESC_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("REAS_GRP_DESC_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("REAS_GRP_TYPE_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("RECORD_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("S_FACTORY_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD CHECK ("TYRE_T_S" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table AT_MES_QM_REAS
-- ----------------------------
ALTER TABLE "MES"."AT_MES_QM_REAS" ADD PRIMARY KEY ("SITE_NUM", "ATR_KEY");

-- ----------------------------
-- Indexes structure for table AT_MES_ZJ_ENT
-- ----------------------------

-- ----------------------------
-- Checks structure for table AT_MES_ZJ_ENT
-- ----------------------------
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("SITE_NUM" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("ATR_KEY" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("ARCH_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("CREATED_BY_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("CREATED_TIME_T" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("ENTBARCODE_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("ENTTYPE_I" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("ISWORK_I" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD CHECK ("S_FACTORY_S" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table AT_MES_ZJ_ENT
-- ----------------------------
ALTER TABLE "MES"."AT_MES_ZJ_ENT" ADD PRIMARY KEY ("SITE_NUM", "ATR_KEY");

-- ----------------------------
-- Indexes structure for table AT_MES_ZJ_RECIPE
-- ----------------------------

-- ----------------------------
-- Checks structure for table AT_MES_ZJ_RECIPE
-- ----------------------------
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("SITE_NUM" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("ATR_KEY" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("ARCH_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("CREATED_BY_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("CREATED_TIME_T" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("RECORD_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD CHECK ("S_FACTORY_S" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table AT_MES_ZJ_RECIPE
-- ----------------------------
ALTER TABLE "MES"."AT_MES_ZJ_RECIPE" ADD PRIMARY KEY ("SITE_NUM", "ATR_KEY");

-- ----------------------------
-- Indexes structure for table AT_MES_ZJ_RIM
-- ----------------------------

-- ----------------------------
-- Checks structure for table AT_MES_ZJ_RIM
-- ----------------------------
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("SITE_NUM" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("ATR_KEY" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("ARCH_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("BORE_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("CREATED_BY_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("CREATED_TIME_T" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("ENTTYPE_I" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("MAXRIM_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("MINRIM_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("RECORD_FLAG_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("RIMNO_S" IS NOT NULL);
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD CHECK ("S_FACTORY_S" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table AT_MES_ZJ_RIM
-- ----------------------------
ALTER TABLE "MES"."AT_MES_ZJ_RIM" ADD PRIMARY KEY ("SITE_NUM", "ATR_KEY");

-- ----------------------------
-- Indexes structure for table CORE_DEPARTMENT
-- ----------------------------

-- ----------------------------
-- Checks structure for table CORE_DEPARTMENT
-- ----------------------------
ALTER TABLE "MES"."CORE_DEPARTMENT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MES"."CORE_DEPARTMENT" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_DEPARTMENT
-- ----------------------------
ALTER TABLE "MES"."CORE_DEPARTMENT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_EXPORT_OPTIONS
-- ----------------------------

-- ----------------------------
-- Uniques structure for table CORE_EXPORT_OPTIONS
-- ----------------------------
ALTER TABLE "MES"."CORE_EXPORT_OPTIONS" ADD UNIQUE ("ENTITYCLASSNAME");

-- ----------------------------
-- Checks structure for table CORE_EXPORT_OPTIONS
-- ----------------------------
ALTER TABLE "MES"."CORE_EXPORT_OPTIONS" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_EXPORT_OPTIONS
-- ----------------------------
ALTER TABLE "MES"."CORE_EXPORT_OPTIONS" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_MENU
-- ----------------------------
CREATE INDEX "MES"."UK_BXDKUELF92NDXQAGLOY1SN672"
ON "MES"."CORE_MENU" ("NAME" ASC)
LOGGING
VISIBLE;
CREATE INDEX "MES"."UK_KJA31OFQC9NK7HFJDY2KN4BJX"
ON "MES"."CORE_MENU" ("PID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Uniques structure for table CORE_MENU
-- ----------------------------
ALTER TABLE "MES"."CORE_MENU" ADD UNIQUE ("CODE");

-- ----------------------------
-- Checks structure for table CORE_MENU
-- ----------------------------
ALTER TABLE "MES"."CORE_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MES"."CORE_MENU" ADD CHECK ("CODE" IS NOT NULL);
ALTER TABLE "MES"."CORE_MENU" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "MES"."CORE_MENU" ADD CHECK ("TYPE" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_MENU
-- ----------------------------
ALTER TABLE "MES"."CORE_MENU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_PERMISSION
-- ----------------------------

-- ----------------------------
-- Checks structure for table CORE_PERMISSION
-- ----------------------------
ALTER TABLE "MES"."CORE_PERMISSION" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_PERMISSION
-- ----------------------------
ALTER TABLE "MES"."CORE_PERMISSION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table CORE_ROLE
-- ----------------------------
ALTER TABLE "MES"."CORE_ROLE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_ROLE
-- ----------------------------
ALTER TABLE "MES"."CORE_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_SYSTEM_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table CORE_SYSTEM_LOG
-- ----------------------------
ALTER TABLE "MES"."CORE_SYSTEM_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MES"."CORE_SYSTEM_LOG" ADD CHECK ("LOGTIME" IS NOT NULL);
ALTER TABLE "MES"."CORE_SYSTEM_LOG" ADD CHECK ("OPERATEUSER" IS NOT NULL);
ALTER TABLE "MES"."CORE_SYSTEM_LOG" ADD CHECK ("OPERATION" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_SYSTEM_LOG
-- ----------------------------
ALTER TABLE "MES"."CORE_SYSTEM_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_USER
-- ----------------------------

-- ----------------------------
-- Uniques structure for table CORE_USER
-- ----------------------------
ALTER TABLE "MES"."CORE_USER" ADD UNIQUE ("USERCODE");

-- ----------------------------
-- Checks structure for table CORE_USER
-- ----------------------------
ALTER TABLE "MES"."CORE_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "MES"."CORE_USER" ADD CHECK ("ACCOUNTSTATE" IS NOT NULL);
ALTER TABLE "MES"."CORE_USER" ADD CHECK ("JOBSTATE" IS NOT NULL);
ALTER TABLE "MES"."CORE_USER" ADD CHECK ("USERCODE" IS NOT NULL);
ALTER TABLE "MES"."CORE_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "MES"."CORE_USER" ADD CHECK ("USERPASSWORD" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_USER
-- ----------------------------
ALTER TABLE "MES"."CORE_USER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CORE_USER_ROLE
-- ----------------------------

-- ----------------------------
-- Uniques structure for table CORE_USER_ROLE
-- ----------------------------
ALTER TABLE "MES"."CORE_USER_ROLE" ADD UNIQUE ("USERID");

-- ----------------------------
-- Checks structure for table CORE_USER_ROLE
-- ----------------------------
ALTER TABLE "MES"."CORE_USER_ROLE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CORE_USER_ROLE
-- ----------------------------
ALTER TABLE "MES"."CORE_USER_ROLE" ADD PRIMARY KEY ("ID");
