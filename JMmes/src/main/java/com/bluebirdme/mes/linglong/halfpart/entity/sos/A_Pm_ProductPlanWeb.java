package com.bluebirdme.mes.linglong.halfpart.entity.sos;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.bluebird.proxy.BaseJsonData;
import com.bluebird.webservice.DataTypeChangeHelper;
import com.datasweep.compatibility.pnuts.Functions;

/**
* @author 代码生成工具
*  半部件日计划表A_Pm_ProductPlanWebService
*/
public class A_Pm_ProductPlanWeb extends BaseJsonData {

/**
* 从A_Pm_ProductPlan转化到A_Pm_ProductPlanWeb
* @param a_Pm_ProductPlan
* @return A_Pm_ProductPlanWeb
*/
public static A_Pm_ProductPlanWeb ToWebData(A_Pm_ProductPlan entityData)
{
A_Pm_ProductPlanWeb webData=new A_Pm_ProductPlanWeb();
webData.setAgenc_No(entityData.getAgenc_No());
webData.setBuildingRecord(entityData.getBuildingRecord());
webData.setChanged_By(entityData.getChanged_By());
webData.setChanged_Time(DataTypeChangeHelper.FromRockWellTime(entityData.getChanged_Time()));
webData.setClassCode(entityData.getClassCode());
webData.setCreated_By(entityData.getCreated_By());
webData.setCreated_Time(DataTypeChangeHelper.FromRockWellTime(entityData.getCreated_Time()));
webData.setCustomerFlag(entityData.getCustomerFlag());
webData.setEquip_Code(entityData.getEquip_Code());
webData.setEquip_OutPort(entityData.getEquip_OutPort());
webData.setHandFlag(entityData.getHandFlag());
webData.setMaterialCode(entityData.getMaterialCode());
webData.setMaterialDesc(entityData.getMaterialDesc());
webData.setMaterialGroup(entityData.getMaterialGroup());
webData.setMaterialName(entityData.getMaterialName());
webData.setMemo(entityData.getMemo());
webData.setOverPercent(entityData.getOverPercent());
webData.setParaVersion(entityData.getParaVersion());
webData.setPlanDate(entityData.getPlanDate());
webData.setPlanfinishTime(DataTypeChangeHelper.FromRockWellTime(entityData.getPlanfinishTime()));
webData.setPlanfinish(entityData.getPlanfinish());
webData.setPlanNo(entityData.getPlanNo());
webData.setPlanQuantityconfirm(entityData.getPlanQuantityconfirm());
webData.setPlanQuantity(entityData.getPlanQuantity());
webData.setPlanstartTime(DataTypeChangeHelper.FromRockWellTime(entityData.getPlanstartTime()));
webData.setPlan_Order(entityData.getPlan_Order());
webData.setRecord_Flag(entityData.getRecord_Flag());
webData.setRepiceNo(entityData.getRepiceNo());
webData.setReViewer(entityData.getReViewer());
webData.setReViewTime(DataTypeChangeHelper.FromRockWellTime(entityData.getReViewTime()));
webData.setSAPVersion(entityData.getSAPVersion());
webData.setSpare10(entityData.getSpare10());
webData.setSpare1(entityData.getSpare1());
webData.setSpare2(entityData.getSpare2());
webData.setSpare3(entityData.getSpare3());
webData.setSpare4(entityData.getSpare4());
webData.setSpare5(entityData.getSpare5());
webData.setSpare6(entityData.getSpare6());
webData.setSpare7(entityData.getSpare7());
webData.setSpare8(entityData.getSpare8());
webData.setSpare9(entityData.getSpare9());
webData.setSpecification(entityData.getSpecification());
webData.setStatus(entityData.getStatus());
webData.setS_Factory(entityData.getS_Factory());
return webData;
}
/**
* 从A_Pm_ProductPlanWeb转化到A_Pm_ProductPlan
* @param a_Pm_ProductPlanWeb
* @return A_Pm_ProductPlan
*/
public static A_Pm_ProductPlan ToEntityData(A_Pm_ProductPlanWeb webData,Functions functions)
{
A_Pm_ProductPlan entityData=A_Pm_ProductPlan.createNew(functions);
entityData.setAgenc_No(webData.getAgenc_No());
entityData.setBuildingRecord(webData.getBuildingRecord());
entityData.setChanged_By(webData.getChanged_By());
entityData.setChanged_Time(DataTypeChangeHelper.FromDate(webData.getChanged_Time()));
entityData.setClassCode(webData.getClassCode());
entityData.setCreated_By(webData.getCreated_By());
entityData.setCreated_Time(DataTypeChangeHelper.FromDate(webData.getCreated_Time()));
entityData.setCustomerFlag(webData.getCustomerFlag());
entityData.setEquip_Code(webData.getEquip_Code());
entityData.setEquip_OutPort(webData.getEquip_OutPort());
entityData.setHandFlag(webData.getHandFlag());
entityData.setMaterialCode(webData.getMaterialCode());
entityData.setMaterialDesc(webData.getMaterialDesc());
entityData.setMaterialGroup(webData.getMaterialGroup());
entityData.setMaterialName(webData.getMaterialName());
entityData.setMemo(webData.getMemo());
entityData.setOverPercent(webData.getOverPercent());
entityData.setParaVersion(webData.getParaVersion());
entityData.setPlanDate(webData.getPlanDate());
entityData.setPlanfinishTime(DataTypeChangeHelper.FromDate(webData.getPlanfinishTime()));
entityData.setPlanfinish(webData.getPlanfinish());
entityData.setPlanNo(webData.getPlanNo());
entityData.setPlanQuantityconfirm(webData.getPlanQuantityconfirm());
entityData.setPlanQuantity(webData.getPlanQuantity());
entityData.setPlanstartTime(DataTypeChangeHelper.FromDate(webData.getPlanstartTime()));
entityData.setPlan_Order(webData.getPlan_Order());
entityData.setRecord_Flag(webData.getRecord_Flag());
entityData.setRepiceNo(webData.getRepiceNo());
entityData.setReViewer(webData.getReViewer());
entityData.setReViewTime(DataTypeChangeHelper.FromDate(webData.getReViewTime()));
entityData.setSAPVersion(webData.getSAPVersion());
entityData.setSpare10(webData.getSpare10());
entityData.setSpare1(webData.getSpare1());
entityData.setSpare2(webData.getSpare2());
entityData.setSpare3(webData.getSpare3());
entityData.setSpare4(webData.getSpare4());
entityData.setSpare5(webData.getSpare5());
entityData.setSpare6(webData.getSpare6());
entityData.setSpare7(webData.getSpare7());
entityData.setSpare8(webData.getSpare8());
entityData.setSpare9(webData.getSpare9());
entityData.setSpecification(webData.getSpecification());
entityData.setStatus(webData.getStatus());
entityData.setS_Factory(webData.getS_Factory());
return entityData;
}
/**
*
*/
private static final long serialVersionUID = 1L;

/**
*机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004
**/
@JsonProperty
private String agenc_No;
/**
*成型倒推标识 0 否 1 是
**/
@JsonProperty
private String buildingRecord;
/**
*修改人
**/
@JsonProperty
private String changed_By;
/**
*修改时间
**/
@JsonProperty
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
private java.util.Date changed_Time;
/**
*班次 基础数据字典 118
**/
@JsonProperty
private String classCode;
/**
*创建人
**/
@JsonProperty
private String created_By;
/**
*创建时间
**/
@JsonProperty
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
private java.util.Date created_Time;
/**
*客户标识  设置基础数据字典 317
**/
@JsonProperty
private String customerFlag;
/**
*机台号
**/
@JsonProperty
private String equip_Code;
/**
*产出组
**/
@JsonProperty
private String equip_OutPort;
/**
*是否自动 0否 1 是
**/
@JsonProperty
private String handFlag;
/**
*物料编码
**/
@JsonProperty
private String materialCode;
/**
*物料组描述
**/
@JsonProperty
private String materialDesc;
/**
*物料组
**/
@JsonProperty
private String materialGroup;
/**
*物料名称
**/
@JsonProperty
private String materialName;
/**
*备注
**/
@JsonProperty
private String memo;
/**
*计划量超产百分比 5%-基础数据字典 116
**/
@JsonProperty
private Float overPercent;
/**
*工艺版本号
**/
@JsonProperty
private String paraVersion;
/**
*计划生产日期
**/
@JsonProperty
private String planDate;
/**
*计划结束时间
**/
@JsonProperty
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
private java.util.Date planfinishTime;
/**
*计划完成量
**/
@JsonProperty
private Long planfinish;
/**
*日计划号：生成规则
**/
@JsonProperty
private String planNo;
/**
*确认计划量 
**/
@JsonProperty
private Float planQuantityconfirm;
/**
*倒推计划量
**/
@JsonProperty
private Float planQuantity;
/**
*计划开始时间
**/
@JsonProperty
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
private java.util.Date planstartTime;
/**
*计划顺序优先级
**/
@JsonProperty
private Long plan_Order;
/**
*记录标志，A可用，D删除
**/
@JsonProperty
private String record_Flag;
/**
*配方版本(BOM)
**/
@JsonProperty
private String repiceNo;
/**
*审核人
**/
@JsonProperty
private String reViewer;
/**
*审核时间
**/
@JsonProperty
@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT+8")
private java.util.Date reViewTime;
/**
*SAP下发版本号
**/
@JsonProperty
private String sAPVersion;
/**
*备用字段10
**/
@JsonProperty
private String spare10;
/**
*备用字段1
**/
@JsonProperty
private String spare1;
/**
*备用字段2
**/
@JsonProperty
private String spare2;
/**
*备用字段3
**/
@JsonProperty
private String spare3;
/**
*备用字段4
**/
@JsonProperty
private String spare4;
/**
*备用字段5
**/
@JsonProperty
private String spare5;
/**
*备用字段6
**/
@JsonProperty
private String spare6;
/**
*备用字段7
**/
@JsonProperty
private String spare7;
/**
*备用字段8
**/
@JsonProperty
private String spare8;
/**
*备用字段9
**/
@JsonProperty
private String spare9;
/**
*规格
**/
@JsonProperty
private String specification;
/**
*计划状态：基础数据104
**/
@JsonProperty
private String status;
/**
*工厂（1全钢 2半钢）
**/
@JsonProperty
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
public java.util.Date getChanged_Time() {

return changed_Time;
}


/**
* @param 设置修改时间
*/
public void setChanged_Time(java.util.Date changed_Time) {
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
public java.util.Date getCreated_Time() {

return created_Time;
}


/**
* @param 设置创建时间
*/
public void setCreated_Time(java.util.Date created_Time) {
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
public java.util.Date getPlanfinishTime() {

return planfinishTime;
}


/**
* @param 设置计划结束时间
*/
public void setPlanfinishTime(java.util.Date planfinishTime) {
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
public java.util.Date getPlanstartTime() {

return planstartTime;
}


/**
* @param 设置计划开始时间
*/
public void setPlanstartTime(java.util.Date planstartTime) {
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
public java.util.Date getReViewTime() {

return reViewTime;
}


/**
* @param 设置审核时间
*/
public void setReViewTime(java.util.Date reViewTime) {
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
