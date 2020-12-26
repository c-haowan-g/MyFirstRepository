package com.bluebirdme.mes.linglong.halfpart.entity.sos;

import com.bluebird.dataaccess.ATRowHelper;
import com.datasweep.compatibility.client.ATRow;
import com.datasweep.compatibility.pnuts.Functions;
import com.rockwell.mes.commons.base.ifc.objects.MESATObject;

/**
* @author 代码生成工具
* 半部件日计划表
*/
public class A_Pm_ProductPlan extends MESATObject {
/**
* 数据库读取时创建实体构造
* @param atRow 读取数据带的Row对象
*/
public A_Pm_ProductPlan(ATRow atRow)
{
super(atRow);
}
/**
* 设置AtRrow到当前对象
* 
* @param atRow
*/
public void SetATRow(ATRow atRow) {
this.dgtATRow = atRow;
}
/**
* 用于复合事务环境时，构造新的实体，传入同一个Functions
* 创建新的数据实体，注意构建的新实体，保存到数据库时对应的insert
* @return
 */
public static A_Pm_ProductPlan createNew(Functions functions)
{
ATRow aTRow=ATRowHelper.createATRow(TableName, functions);
A_Pm_ProductPlan data=new A_Pm_ProductPlan(aTRow);
return data;
}

/*
* 用于PD中AT定义的表名，注意不是数据库中的表名
*/
@Override
public String getATDefinitionName() {
return TableName;
}
/**
* 映射的表名
*/
public static String TableName="A_PM_ProductPlan";

/**
* 版本ID
*/
private static final long serialVersionUID = 1L;
/**
* PD中的定义的AT映射列AGENC_NO,机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
*/
public static final String Column_Agenc_No = "AGENC_NO";
/**
* PD中的定义的AT映射列BUILDINGRECORD,成型倒推标识 0 否 1 是
*/
public static final String Column_BuildingRecord = "BUILDINGRECORD";
/**
* PD中的定义的AT映射列CHANGED_BY,修改人
*/
public static final String Column_Changed_By = "CHANGED_BY";
/**
* PD中的定义的AT映射列CHANGED_TIME,修改时间
*/
public static final String Column_Changed_Time = "CHANGED_TIME";
/**
* PD中的定义的AT映射列CLASSCODE,班次 基础数据字典 118
*/
public static final String Column_ClassCode = "CLASSCODE";
/**
* PD中的定义的AT映射列CREATED_BY,创建人
*/
public static final String Column_Created_By = "CREATED_BY";
/**
* PD中的定义的AT映射列CREATED_TIME,创建时间
*/
public static final String Column_Created_Time = "CREATED_TIME";
/**
* PD中的定义的AT映射列CUSTOMERFLAG,客户标识  设置基础数据字典 317
*/
public static final String Column_CustomerFlag = "CUSTOMERFLAG";
/**
* PD中的定义的AT映射列EQUIP_CODE,机台号
*/
public static final String Column_Equip_Code = "EQUIP_CODE";
/**
* PD中的定义的AT映射列EQUIP_OUTPORT,产出组
*/
public static final String Column_Equip_OutPort = "EQUIP_OUTPORT";
/**
* PD中的定义的AT映射列HANDFLAG,是否自动 0否 1 是
*/
public static final String Column_HandFlag = "HANDFLAG";
/**
* PD中的定义的AT映射列MATERIALCODE,物料编码
*/
public static final String Column_MaterialCode = "MATERIALCODE";
/**
* PD中的定义的AT映射列MATERIALDESC,物料组描述
*/
public static final String Column_MaterialDesc = "MATERIALDESC";
/**
* PD中的定义的AT映射列MATERIALGROUP,物料组
*/
public static final String Column_MaterialGroup = "MATERIALGROUP";
/**
* PD中的定义的AT映射列MATERIALNAME,物料名称
*/
public static final String Column_MaterialName = "MATERIALNAME";
/**
* PD中的定义的AT映射列MEMO,备注
*/
public static final String Column_Memo = "MEMO";
/**
* PD中的定义的AT映射列OVERPERCENT,计划量超产百分比 5%-基础数据字典 116
*/
public static final String Column_OverPercent = "OVERPERCENT";
/**
* PD中的定义的AT映射列PARAVERSION,工艺版本号
*/
public static final String Column_ParaVersion = "PARAVERSION";
/**
* PD中的定义的AT映射列PLANDATE,计划生产日期
*/
public static final String Column_PlanDate = "PLANDATE";
/**
* PD中的定义的AT映射列PLANFINISHTIME,计划结束时间
*/
public static final String Column_PlanfinishTime = "PLANFINISHTIME";
/**
* PD中的定义的AT映射列PLANFINISH,计划完成量
*/
public static final String Column_Planfinish = "PLANFINISH";
/**
* PD中的定义的AT映射列PLANNO,日计划号：生成规则
*/
public static final String Column_PlanNo = "PLANNO";
/**
* PD中的定义的AT映射列PLANQUANTITYCONFIRM,确认计划量 
*/
public static final String Column_PlanQuantityconfirm = "PLANQUANTITYCONFIRM";
/**
* PD中的定义的AT映射列PLANQUANTITY,倒推计划量
*/
public static final String Column_PlanQuantity = "PLANQUANTITY";
/**
* PD中的定义的AT映射列PLANSTARTTIME,计划开始时间
*/
public static final String Column_PlanstartTime = "PLANSTARTTIME";
/**
* PD中的定义的AT映射列PLAN_ORDER,计划顺序优先级
*/
public static final String Column_Plan_Order = "PLAN_ORDER";
/**
* PD中的定义的AT映射列RECORD_FLAG,记录标志，A可用，D删除
*/
public static final String Column_Record_Flag = "RECORD_FLAG";
/**
* PD中的定义的AT映射列REPICENO,配方版本(BOM)
*/
public static final String Column_RepiceNo = "REPICENO";
/**
* PD中的定义的AT映射列REVIEWER,审核人
*/
public static final String Column_ReViewer = "REVIEWER";
/**
* PD中的定义的AT映射列REVIEWTIME,审核时间
*/
public static final String Column_ReViewTime = "REVIEWTIME";
/**
* PD中的定义的AT映射列SAPVERSION,SAP下发版本号
*/
public static final String Column_SAPVersion = "SAPVERSION";
/**
* PD中的定义的AT映射列SPARE10,备用字段10
*/
public static final String Column_Spare10 = "SPARE10";
/**
* PD中的定义的AT映射列SPARE1,备用字段1
*/
public static final String Column_Spare1 = "SPARE1";
/**
* PD中的定义的AT映射列SPARE2,备用字段2
*/
public static final String Column_Spare2 = "SPARE2";
/**
* PD中的定义的AT映射列SPARE3,备用字段3
*/
public static final String Column_Spare3 = "SPARE3";
/**
* PD中的定义的AT映射列SPARE4,备用字段4
*/
public static final String Column_Spare4 = "SPARE4";
/**
* PD中的定义的AT映射列SPARE5,备用字段5
*/
public static final String Column_Spare5 = "SPARE5";
/**
* PD中的定义的AT映射列SPARE6,备用字段6
*/
public static final String Column_Spare6 = "SPARE6";
/**
* PD中的定义的AT映射列SPARE7,备用字段7
*/
public static final String Column_Spare7 = "SPARE7";
/**
* PD中的定义的AT映射列SPARE8,备用字段8
*/
public static final String Column_Spare8 = "SPARE8";
/**
* PD中的定义的AT映射列SPARE9,备用字段9
*/
public static final String Column_Spare9 = "SPARE9";
/**
* PD中的定义的AT映射列SPECIFICATION,规格
*/
public static final String Column_Specification = "SPECIFICATION";
/**
* PD中的定义的AT映射列STATUS,计划状态：基础数据104
*/
public static final String Column_Status = "STATUS";
/**
* PD中的定义的AT映射列S_FACTORY,工厂（1全钢 2半钢）
*/
public static final String Column_S_Factory = "S_FACTORY";
/**
*机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
**/
private String agenc_No;
/**
*成型倒推标识 0 否 1 是
**/
private String buildingRecord;
/**
*修改人
**/
private String changed_By;
/**
*修改时间
**/
private com.datasweep.compatibility.ui.Time changed_Time;
/**
*班次 基础数据字典 118
**/
private String classCode;
/**
*创建人
**/
private String created_By;
/**
*创建时间
**/
private com.datasweep.compatibility.ui.Time created_Time;
/**
*客户标识  设置基础数据字典 317
**/
private String customerFlag;
/**
*机台号
**/
private String equip_Code;
/**
*产出组
**/
private String equip_OutPort;
/**
*是否自动 0否 1 是
**/
private String handFlag;
/**
*物料编码
**/
private String materialCode;
/**
*物料组描述
**/
private String materialDesc;
/**
*物料组
**/
private String materialGroup;
/**
*物料名称
**/
private String materialName;
/**
*备注
**/
private String memo;
/**
*计划量超产百分比 5%-基础数据字典 116
**/
private Float overPercent;
/**
*工艺版本号
**/
private String paraVersion;
/**
*计划生产日期
**/
private String planDate;
/**
*计划结束时间
**/
private com.datasweep.compatibility.ui.Time planfinishTime;
/**
*计划完成量
**/
private Long planfinish;
/**
*日计划号：生成规则
**/
private String planNo;
/**
*确认计划量 
**/
private Float planQuantityconfirm;
/**
*倒推计划量
**/
private Float planQuantity;
/**
*计划开始时间
**/
private com.datasweep.compatibility.ui.Time planstartTime;
/**
*计划顺序优先级
**/
private Long plan_Order;
/**
*记录标志，A可用，D删除
**/
private String record_Flag;
/**
*配方版本(BOM)
**/
private String repiceNo;
/**
*审核人
**/
private String reViewer;
/**
*审核时间
**/
private com.datasweep.compatibility.ui.Time reViewTime;
/**
*SAP下发版本号
**/
private String sAPVersion;
/**
*备用字段10
**/
private String spare10;
/**
*备用字段1
**/
private String spare1;
/**
*备用字段2
**/
private String spare2;
/**
*备用字段3
**/
private String spare3;
/**
*备用字段4
**/
private String spare4;
/**
*备用字段5
**/
private String spare5;
/**
*备用字段6
**/
private String spare6;
/**
*备用字段7
**/
private String spare7;
/**
*备用字段8
**/
private String spare8;
/**
*备用字段9
**/
private String spare9;
/**
*规格
**/
private String specification;
/**
*计划状态：基础数据104
**/
private String status;
/**
*工厂（1全钢 2半钢）
**/
private String s_Factory;

/**
* @return 机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
*/
public String getAgenc_No() {

return agenc_No;
}


/**
* @param 设置机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
*/
public void setAgenc_No(String agenc_No) {
this.agenc_No = agenc_No;
}


/**
* @return 成型倒推标识 0 否 1 是
*/
public String getBuildingRecord() {

return buildingRecord;
}


/**
* @param 设置成型倒推标识 0 否 1 是
*/
public void setBuildingRecord(String buildingRecord) {
this.buildingRecord = buildingRecord;
}


/**
* @return 修改人
*/
public String getChanged_By() {

return changed_By;
}


/**
* @param 设置修改人
*/
public void setChanged_By(String changed_By) {
this.changed_By = changed_By;
}


/**
* @return 修改时间
*/
public com.datasweep.compatibility.ui.Time getChanged_Time() {

return changed_Time;
}


/**
* @param 设置修改时间
*/
public void setChanged_Time(com.datasweep.compatibility.ui.Time changed_Time) {
this.changed_Time = changed_Time;
}


/**
* @return 班次 基础数据字典 118
*/
public String getClassCode() {

return classCode;
}


/**
* @param 设置班次 基础数据字典 118
*/
public void setClassCode(String classCode) {
this.classCode = classCode;
}


/**
* @return 创建人
*/
public String getCreated_By() {

return created_By;
}


/**
* @param 设置创建人
*/
public void setCreated_By(String created_By) {
this.created_By = created_By;
}


/**
* @return 创建时间
*/
public com.datasweep.compatibility.ui.Time getCreated_Time() {

return created_Time;
}


/**
* @param 设置创建时间
*/
public void setCreated_Time(com.datasweep.compatibility.ui.Time created_Time) {
this.created_Time = created_Time;
}


/**
* @return 客户标识  设置基础数据字典 317
*/
public String getCustomerFlag() {

return customerFlag;
}


/**
* @param 设置客户标识  设置基础数据字典 317
*/
public void setCustomerFlag(String customerFlag) {
this.customerFlag = customerFlag;
}


/**
* @return 机台号
*/
public String getEquip_Code() {

return equip_Code;
}


/**
* @param 设置机台号
*/
public void setEquip_Code(String equip_Code) {
this.equip_Code = equip_Code;
}


/**
* @return 产出组
*/
public String getEquip_OutPort() {

return equip_OutPort;
}


/**
* @param 设置产出组
*/
public void setEquip_OutPort(String equip_OutPort) {
this.equip_OutPort = equip_OutPort;
}


/**
* @return 是否自动 0否 1 是
*/
public String getHandFlag() {

return handFlag;
}


/**
* @param 设置是否自动 0否 1 是
*/
public void setHandFlag(String handFlag) {
this.handFlag = handFlag;
}


/**
* @return 物料编码
*/
public String getMaterialCode() {

return materialCode;
}


/**
* @param 设置物料编码
*/
public void setMaterialCode(String materialCode) {
this.materialCode = materialCode;
}


/**
* @return 物料组描述
*/
public String getMaterialDesc() {

return materialDesc;
}


/**
* @param 设置物料组描述
*/
public void setMaterialDesc(String materialDesc) {
this.materialDesc = materialDesc;
}


/**
* @return 物料组
*/
public String getMaterialGroup() {

return materialGroup;
}


/**
* @param 设置物料组
*/
public void setMaterialGroup(String materialGroup) {
this.materialGroup = materialGroup;
}


/**
* @return 物料名称
*/
public String getMaterialName() {

return materialName;
}


/**
* @param 设置物料名称
*/
public void setMaterialName(String materialName) {
this.materialName = materialName;
}


/**
* @return 备注
*/
public String getMemo() {

return memo;
}


/**
* @param 设置备注
*/
public void setMemo(String memo) {
this.memo = memo;
}


/**
* @return 计划量超产百分比 5%-基础数据字典 116
*/
public Float getOverPercent() {

return overPercent;
}


/**
* @param 设置计划量超产百分比 5%-基础数据字典 116
*/
public void setOverPercent(Float overPercent) {
this.overPercent = overPercent;
}


/**
* @return 工艺版本号
*/
public String getParaVersion() {

return paraVersion;
}


/**
* @param 设置工艺版本号
*/
public void setParaVersion(String paraVersion) {
this.paraVersion = paraVersion;
}


/**
* @return 计划生产日期
*/
public String getPlanDate() {

return planDate;
}


/**
* @param 设置计划生产日期
*/
public void setPlanDate(String planDate) {
this.planDate = planDate;
}


/**
* @return 计划结束时间
*/
public com.datasweep.compatibility.ui.Time getPlanfinishTime() {

return planfinishTime;
}


/**
* @param 设置计划结束时间
*/
public void setPlanfinishTime(com.datasweep.compatibility.ui.Time planfinishTime) {
this.planfinishTime = planfinishTime;
}


/**
* @return 计划完成量
*/
public Long getPlanfinish() {

return planfinish;
}


/**
* @param 设置计划完成量
*/
public void setPlanfinish(Long planfinish) {
this.planfinish = planfinish;
}


/**
* @return 日计划号：生成规则
*/
public String getPlanNo() {

return planNo;
}


/**
* @param 设置日计划号：生成规则
*/
public void setPlanNo(String planNo) {
this.planNo = planNo;
}


/**
* @return 确认计划量 
*/
public Float getPlanQuantityconfirm() {

return planQuantityconfirm;
}


/**
* @param 设置确认计划量 
*/
public void setPlanQuantityconfirm(Float planQuantityconfirm) {
this.planQuantityconfirm = planQuantityconfirm;
}


/**
* @return 倒推计划量
*/
public Float getPlanQuantity() {

return planQuantity;
}


/**
* @param 设置倒推计划量
*/
public void setPlanQuantity(Float planQuantity) {
this.planQuantity = planQuantity;
}


/**
* @return 计划开始时间
*/
public com.datasweep.compatibility.ui.Time getPlanstartTime() {

return planstartTime;
}


/**
* @param 设置计划开始时间
*/
public void setPlanstartTime(com.datasweep.compatibility.ui.Time planstartTime) {
this.planstartTime = planstartTime;
}


/**
* @return 计划顺序优先级
*/
public Long getPlan_Order() {

return plan_Order;
}


/**
* @param 设置计划顺序优先级
*/
public void setPlan_Order(Long plan_Order) {
this.plan_Order = plan_Order;
}


/**
* @return 记录标志，A可用，D删除
*/
public String getRecord_Flag() {

return record_Flag;
}


/**
* @param 设置记录标志，A可用，D删除
*/
public void setRecord_Flag(String record_Flag) {
this.record_Flag = record_Flag;
}


/**
* @return 配方版本(BOM)
*/
public String getRepiceNo() {

return repiceNo;
}


/**
* @param 设置配方版本(BOM)
*/
public void setRepiceNo(String repiceNo) {
this.repiceNo = repiceNo;
}


/**
* @return 审核人
*/
public String getReViewer() {

return reViewer;
}


/**
* @param 设置审核人
*/
public void setReViewer(String reViewer) {
this.reViewer = reViewer;
}


/**
* @return 审核时间
*/
public com.datasweep.compatibility.ui.Time getReViewTime() {

return reViewTime;
}


/**
* @param 设置审核时间
*/
public void setReViewTime(com.datasweep.compatibility.ui.Time reViewTime) {
this.reViewTime = reViewTime;
}


/**
* @return SAP下发版本号
*/
public String getSAPVersion() {

return sAPVersion;
}


/**
* @param 设置SAP下发版本号
*/
public void setSAPVersion(String sAPVersion) {
this.sAPVersion = sAPVersion;
}


/**
* @return 备用字段10
*/
public String getSpare10() {

return spare10;
}


/**
* @param 设置备用字段10
*/
public void setSpare10(String spare10) {
this.spare10 = spare10;
}


/**
* @return 备用字段1
*/
public String getSpare1() {

return spare1;
}


/**
* @param 设置备用字段1
*/
public void setSpare1(String spare1) {
this.spare1 = spare1;
}


/**
* @return 备用字段2
*/
public String getSpare2() {

return spare2;
}


/**
* @param 设置备用字段2
*/
public void setSpare2(String spare2) {
this.spare2 = spare2;
}


/**
* @return 备用字段3
*/
public String getSpare3() {

return spare3;
}


/**
* @param 设置备用字段3
*/
public void setSpare3(String spare3) {
this.spare3 = spare3;
}


/**
* @return 备用字段4
*/
public String getSpare4() {

return spare4;
}


/**
* @param 设置备用字段4
*/
public void setSpare4(String spare4) {
this.spare4 = spare4;
}


/**
* @return 备用字段5
*/
public String getSpare5() {

return spare5;
}


/**
* @param 设置备用字段5
*/
public void setSpare5(String spare5) {
this.spare5 = spare5;
}


/**
* @return 备用字段6
*/
public String getSpare6() {

return spare6;
}


/**
* @param 设置备用字段6
*/
public void setSpare6(String spare6) {
this.spare6 = spare6;
}


/**
* @return 备用字段7
*/
public String getSpare7() {

return spare7;
}


/**
* @param 设置备用字段7
*/
public void setSpare7(String spare7) {
this.spare7 = spare7;
}


/**
* @return 备用字段8
*/
public String getSpare8() {

return spare8;
}


/**
* @param 设置备用字段8
*/
public void setSpare8(String spare8) {
this.spare8 = spare8;
}


/**
* @return 备用字段9
*/
public String getSpare9() {

return spare9;
}


/**
* @param 设置备用字段9
*/
public void setSpare9(String spare9) {
this.spare9 = spare9;
}


/**
* @return 规格
*/
public String getSpecification() {

return specification;
}


/**
* @param 设置规格
*/
public void setSpecification(String specification) {
this.specification = specification;
}


/**
* @return 计划状态：基础数据104
*/
public String getStatus() {

return status;
}


/**
* @param 设置计划状态：基础数据104
*/
public void setStatus(String status) {
this.status = status;
}


/**
* @return 工厂（1全钢 2半钢）
*/
public String getS_Factory() {

return s_Factory;
}


/**
* @param 设置工厂（1全钢 2半钢）
*/
public void setS_Factory(String s_Factory) {
this.s_Factory = s_Factory;
}

}
