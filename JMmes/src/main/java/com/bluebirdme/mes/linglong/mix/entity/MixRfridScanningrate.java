/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * PLM密炼物料表
 * @author 陈国强
 * @Date 2020-08-25 08:21:09
 */
@ATDefinition("INT_PLM_MIXMATERIAL")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_MIXMATERIAL")
public class MixRfridScanningrate extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("警报值")
    @Column(nullable=true,length=0)
    private String alarmvalue_f;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("基本单位")
    @Column(nullable=true,length=80)
    private String baseunit_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源：0-PLM原数据、1-自动生成、2-SAP原数据")
    @Column(nullable=true,length=80)
    private String data_source_s;
    
    @Comment("数据来源类型：0-上辅机配方、1-配料系统配方")
    @Column(nullable=true,length=80)
    private String data_source_type_s;
    
    @Comment("备用1：接口预留，物料规格 例如 HT204/41")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("备用2：接口预留，等同物料等级，与等同物料代码对应 例如 0、1、2、3…")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("等同物料分组")
    @Column(nullable=true,length=80)
    private String equivalentmaterial_s;
    
    @Comment("允许误差： 0.3-炭黑 0.02-粉料 0.1-油料 2-返回胶 0.3-胶料允许误差：0.3-返回胶")
    @Column(nullable=true,length=0)
    private String error_allow_d;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("内径")
    @Column(nullable=true,length=0)
    private String innerdia_d;
    
    @Comment("加温是否管控：0-否、1-是")
    @Column(nullable=true,length=80)
    private String isheat_s;
    
    @Comment("配套代码：例如：DV代表大众")
    @Column(nullable=true,length=80)
    private String matchingcode_s;
    
    @Comment("物料编号")
    @Column(nullable=true,length=100)
    private String materialcode_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=80)
    private String materialgroup_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String materialname_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=200)
    private String materialspec_s;
    
    @Comment("物料状态：为空正常可用，反之亦然 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购")
    @Column(nullable=true,length=80)
    private String materialstatus_s;
    
    @Comment("物料类别(上辅机定义)：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料")
    @Column(nullable=true,length=80)
    private String materialtype_s;
    
    @Comment("物料类别（SAP定义）：ROH-原辅料、HALB-半成品、FERT-产成品、ZUVA-零价值物料、ROH1-材料")
    @Column(nullable=true,length=80)
    private String materialtype_sap_s;
    
    @Comment("最短加温时间")
    @Column(nullable=true,length=0)
    private String maxheattime_f;
    
    @Comment("最大库存")
    @Column(nullable=true,length=0)
    private String maximumstock_f;
    
    @Comment("最长加温时间")
    @Column(nullable=true,length=0)
    private String minheattime_f;
    
    @Comment("最小库存")
    @Column(nullable=true,length=0)
    private String minimumstock_f;
    
    @Comment("外径")
    @Column(nullable=true,length=0)
    private String outerdia_d;
    
    @Comment("有效期是否管控：0-否、1-是")
    @Column(nullable=true,length=80)
    private String overduecontrol_s;
    
    @Comment("最长存放时间(h)")
    @Column(nullable=true,length=0)
    private String overtime_f;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识：0-未下发、1-已下发、2-下发失败")
    @Column(nullable=true,length=80)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("密炼快检检验百分比")
    @Column(nullable=true,length=0)
    private Integer sip_i;
    
    @Comment("最小存放时间(h)")
    @Column(nullable=true,length=0)
    private String smalltime_f;
    
    @Comment("库存是否报警：0-否、1-是")
    @Column(nullable=true,length=80)
    private String stockalarm_s;
    
    @Comment("供应商代码 例如：100019|100018")
    @Column(nullable=true,length=800)
    private String supplycode_s;
    
    @Comment("供应商名称 例如：A|B")
    @Column(nullable=true,length=800)
    private String supplyname_s;
    
    @Comment("截面高密炼快检检验百分比")
    @Column(nullable=true,length=0)
    private String tyreheight_d;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlarmvalue_f(){
        return alarmvalue_f;
    }
    
    @XmlElement
    public void setAlarmvalue_f(String alarmvalue_f){
        this.alarmvalue_f=alarmvalue_f;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getBaseunit_s(){
        return baseunit_s;
    }
    
    @XmlElement
    public void setBaseunit_s(String baseunit_s){
        this.baseunit_s=baseunit_s;
    }
        
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public Date getChanged_time_t(){
        return changed_time_t;
    }
    
    @XmlElement
    public void setChanged_time_t(Date changed_time_t){
        this.changed_time_t=changed_time_t;
    }
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getData_source_s(){
        return data_source_s;
    }
    
    @XmlElement
    public void setData_source_s(String data_source_s){
        this.data_source_s=data_source_s;
    }
        
    public String getData_source_type_s(){
        return data_source_type_s;
    }
    
    @XmlElement
    public void setData_source_type_s(String data_source_type_s){
        this.data_source_type_s=data_source_type_s;
    }
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
    }
        
    public String getEquivalentmaterial_s(){
        return equivalentmaterial_s;
    }
    
    @XmlElement
    public void setEquivalentmaterial_s(String equivalentmaterial_s){
        this.equivalentmaterial_s=equivalentmaterial_s;
    }
        
    public String getError_allow_d(){
        return error_allow_d;
    }
    
    @XmlElement
    public void setError_allow_d(String error_allow_d){
        this.error_allow_d=error_allow_d;
    }
        
    public String getGuid_s(){
        return guid_s;
    }
    
    @XmlElement
    public void setGuid_s(String guid_s){
        this.guid_s=guid_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInnerdia_d(){
        return innerdia_d;
    }
    
    @XmlElement
    public void setInnerdia_d(String innerdia_d){
        this.innerdia_d=innerdia_d;
    }
        
    public String getIsheat_s(){
        return isheat_s;
    }
    
    @XmlElement
    public void setIsheat_s(String isheat_s){
        this.isheat_s=isheat_s;
    }
        
    public String getMatchingcode_s(){
        return matchingcode_s;
    }
    
    @XmlElement
    public void setMatchingcode_s(String matchingcode_s){
        this.matchingcode_s=matchingcode_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
    }
        
    public String getMaterialname_s(){
        return materialname_s;
    }
    
    @XmlElement
    public void setMaterialname_s(String materialname_s){
        this.materialname_s=materialname_s;
    }
        
    public String getMaterialspec_s(){
        return materialspec_s;
    }
    
    @XmlElement
    public void setMaterialspec_s(String materialspec_s){
        this.materialspec_s=materialspec_s;
    }
        
    public String getMaterialstatus_s(){
        return materialstatus_s;
    }
    
    @XmlElement
    public void setMaterialstatus_s(String materialstatus_s){
        this.materialstatus_s=materialstatus_s;
    }
        
    public String getMaterialtype_s(){
        return materialtype_s;
    }
    
    @XmlElement
    public void setMaterialtype_s(String materialtype_s){
        this.materialtype_s=materialtype_s;
    }
        
    public String getMaterialtype_sap_s(){
        return materialtype_sap_s;
    }
    
    @XmlElement
    public void setMaterialtype_sap_s(String materialtype_sap_s){
        this.materialtype_sap_s=materialtype_sap_s;
    }
        
    public String getMaxheattime_f(){
        return maxheattime_f;
    }
    
    @XmlElement
    public void setMaxheattime_f(String maxheattime_f){
        this.maxheattime_f=maxheattime_f;
    }
        
    public String getMaximumstock_f(){
        return maximumstock_f;
    }
    
    @XmlElement
    public void setMaximumstock_f(String maximumstock_f){
        this.maximumstock_f=maximumstock_f;
    }
        
    public String getMinheattime_f(){
        return minheattime_f;
    }
    
    @XmlElement
    public void setMinheattime_f(String minheattime_f){
        this.minheattime_f=minheattime_f;
    }
        
    public String getMinimumstock_f(){
        return minimumstock_f;
    }
    
    @XmlElement
    public void setMinimumstock_f(String minimumstock_f){
        this.minimumstock_f=minimumstock_f;
    }
        
    public String getOuterdia_d(){
        return outerdia_d;
    }
    
    @XmlElement
    public void setOuterdia_d(String outerdia_d){
        this.outerdia_d=outerdia_d;
    }
        
    public String getOverduecontrol_s(){
        return overduecontrol_s;
    }
    
    @XmlElement
    public void setOverduecontrol_s(String overduecontrol_s){
        this.overduecontrol_s=overduecontrol_s;
    }
        
    public String getOvertime_f(){
        return overtime_f;
    }
    
    @XmlElement
    public void setOvertime_f(String overtime_f){
        this.overtime_f=overtime_f;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSend_by_s(){
        return send_by_s;
    }
    
    @XmlElement
    public void setSend_by_s(String send_by_s){
        this.send_by_s=send_by_s;
    }
        
    public String getSend_name_s(){
        return send_name_s;
    }
    
    @XmlElement
    public void setSend_name_s(String send_name_s){
        this.send_name_s=send_name_s;
    }
        
    public String getSend_state_s(){
        return send_state_s;
    }
    
    @XmlElement
    public void setSend_state_s(String send_state_s){
        this.send_state_s=send_state_s;
    }
        
    public Date getSend_time_t(){
        return send_time_t;
    }
    
    @XmlElement
    public void setSend_time_t(Date send_time_t){
        this.send_time_t=send_time_t;
    }
        
    public Integer getSip_i(){
        return sip_i;
    }
    
    @XmlElement
    public void setSip_i(Integer sip_i){
        this.sip_i=sip_i;
    }
        
    public String getSmalltime_f(){
        return smalltime_f;
    }
    
    @XmlElement
    public void setSmalltime_f(String smalltime_f){
        this.smalltime_f=smalltime_f;
    }
        
    public String getStockalarm_s(){
        return stockalarm_s;
    }
    
    @XmlElement
    public void setStockalarm_s(String stockalarm_s){
        this.stockalarm_s=stockalarm_s;
    }
        
    public String getSupplycode_s(){
        return supplycode_s;
    }
    
    @XmlElement
    public void setSupplycode_s(String supplycode_s){
        this.supplycode_s=supplycode_s;
    }
        
    public String getSupplyname_s(){
        return supplyname_s;
    }
    
    @XmlElement
    public void setSupplyname_s(String supplyname_s){
        this.supplyname_s=supplyname_s;
    }
        
    public String getTyreheight_d(){
        return tyreheight_d;
    }
    
    @XmlElement
    public void setTyreheight_d(String tyreheight_d){
        this.tyreheight_d=tyreheight_d;
    }
        
    
    
    
}
