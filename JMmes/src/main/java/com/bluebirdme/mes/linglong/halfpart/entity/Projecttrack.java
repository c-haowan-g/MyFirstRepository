/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 半部件计划跟踪
 * @author 徐秉正
 * @Date 2020-03-06 16:32:51
 */
@ATDefinition("A_PM_PRODUCTPLAN")
@Entity
@XmlRootElement
@Table(name="AT_A_PM_PRODUCTPLAN")
public class Projecttrack extends RockWellBaseEntity{
    
    
	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("成型倒推标识 0 否 1 是")
    @Column(nullable=false,length=80)
    private String buildingrecord_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("班次 基础数据字典 118")
    @Column(nullable=true,length=80)
    private String classcode_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("客户标识  设置基础数据字典 317")
    @Column(nullable=true,length=80)
    private String customerflag_s;
    
    @Comment("机台号")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("产出组")
    @Column(nullable=true,length=80)
    private String equip_outport_s;
    
    @Comment("是否自动 0否 1 是")
    @Column(nullable=false,length=80)
    private String handflag_s;
    
    @Comment("物料编码")
    @Column(nullable=false,length=80)
    private String materialcode_s;
    
    @Comment("物料组描述")
    @Column(nullable=false,length=80)
    private String materialdesc_s;
    
    @Comment("物料组")
    @Column(nullable=false,length=80)
    private String materialgroup_s;
    
    @Comment("物料名称")
    @Column(nullable=false,length=80)
    private String materialname_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String memo_s;
    
    @Comment("计划量超产百分比 5%-基础数据字典 116")
    @Column(nullable=true,length=0)
    private Float overpercent_f;
    
    @Comment("工艺版本号")
    @Column(nullable=false,length=80)
    private String paraversion_s;
    
    @Comment("计划生产日期")
    @Column(nullable=true,length=80)
    private String plandate_s;
    
    @Comment("计划结束时间")
    @Column(nullable=true,length=0)
    private Date planfinishtime_t;
    
    @Comment("计划完成量")
    @Column(nullable=false,length=0)
    private String planfinish_f;
    
    @Comment("日计划号：生成规则")
    @Column(nullable=false,length=80)
    private String planno_s;
    
    @Comment("确认计划量 ")
    @Column(nullable=false,length=0)
    private Float planquantityconfirm_f;
    
    @Comment("倒推计划量")
    @Column(nullable=false,length=0)
    private Float planquantity_f;
    
    @Comment("计划开始时间")
    @Column(nullable=true,length=0)
    private Date planstarttime_t;
    
    @Comment("计划顺序优先级")
    @Column(nullable=false,length=0)
    private Integer plan_order_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("配方版本(BOM)")
    @Column(nullable=false,length=80)
    private String repiceno_s;
    
    @Comment("审核人")
    @Column(nullable=true,length=80)
    private String reviewer_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date reviewtime_t;
    
    @Comment("SAP下发版本号")
    @Column(nullable=false,length=80)
    private String sapversion_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("规格")
    @Column(nullable=false,length=80)
    private String specification_s;
    
    @Comment("计划状态：基础数据104")
    @Column(nullable=false,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("设备代码")
    @Column(nullable=true,length=80)
    private String devicecode_s;
    
    
    @Comment("产品阶段")
    @Column(nullable=true,length=80)
    private String productstage_s;
    
    @Comment("工艺版本ID")
    @Column(nullable=true,length=80)
    private String parameterid_s;
    
    @Column(nullable=true,length=80)
    private String changed_time_z;
    public String getChanged_time_z(){
        return changed_time_z;
    }
    @XmlElement
    public void setChanged_time_z(String changed_time_z){
        this.changed_time_z=changed_time_z;
    }
    
    
    
    
    public String getParameterid_s(){
        return parameterid_s;
    }
    @XmlElement
    public void setParameterid_s(String parameterid_s){
        this.parameterid_s=parameterid_s;
    }
    
    public String getDevicecode_s(){
        return devicecode_s;
    }
    @XmlElement
    public void setDevicecode_s(String devicecode_s){
        this.devicecode_s=devicecode_s;
    }
    
    public String getProductstage_s(){
        return productstage_s;
    }
    @XmlElement
    public void setProductstage_s(String productstage_s){
        this.productstage_s=productstage_s;
    }
    
    
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBuildingrecord_s(){
        return buildingrecord_s;
    }
    
    @XmlElement
    public void setBuildingrecord_s(String buildingrecord_s){
        this.buildingrecord_s=buildingrecord_s;
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
        
    public String getClasscode_s(){
        return classcode_s;
    }
    
    @XmlElement
    public void setClasscode_s(String classcode_s){
        this.classcode_s=classcode_s;
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
        
    public String getCustomerflag_s(){
        return customerflag_s;
    }
    
    @XmlElement
    public void setCustomerflag_s(String customerflag_s){
        this.customerflag_s=customerflag_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_outport_s(){
        return equip_outport_s;
    }
    
    @XmlElement
    public void setEquip_outport_s(String equip_outport_s){
        this.equip_outport_s=equip_outport_s;
    }
        
    public String getHandflag_s(){
        return handflag_s;
    }
    
    @XmlElement
    public void setHandflag_s(String handflag_s){
        this.handflag_s=handflag_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialdesc_s(){
        return materialdesc_s;
    }
    
    @XmlElement
    public void setMaterialdesc_s(String materialdesc_s){
        this.materialdesc_s=materialdesc_s;
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
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public Float getOverpercent_f(){
        return overpercent_f;
    }
    
    @XmlElement
    public void setOverpercent_f(Float overpercent_f){
        this.overpercent_f=overpercent_f;
    }
        
    public String getParaversion_s(){
        return paraversion_s;
    }
    
    @XmlElement
    public void setParaversion_s(String paraversion_s){
        this.paraversion_s=paraversion_s;
    }
        
    public String getPlandate_s(){
        return plandate_s;
    }
    
    @XmlElement
    public void setPlandate_s(String plandate_s){
        this.plandate_s=plandate_s;
    }
        
    public Date getPlanfinishtime_t(){
        return planfinishtime_t;
    }
    
    @XmlElement
    public void setPlanfinishtime_t(Date planfinishtime_t){
        this.planfinishtime_t=planfinishtime_t;
    }
        
    public String getPlanfinish_f(){
        return planfinish_f;
    }
    
    @XmlElement
    public void setPlanfinish_f(String planfinish_f){
        this.planfinish_f=planfinish_f;
    }
        
    public String getPlanno_s(){
        return planno_s;
    }
    
    @XmlElement
    public void setPlanno_s(String planno_s){
        this.planno_s=planno_s;
    }
        
    public Float getPlanquantityconfirm_f(){
        return planquantityconfirm_f;
    }
    
    @XmlElement
    public void setPlanquantityconfirm_f(Float planquantityconfirm_f){
        this.planquantityconfirm_f=planquantityconfirm_f;
    }
        
    public Float getPlanquantity_f(){
        return planquantity_f;
    }
    
    @XmlElement
    public void setPlanquantity_f(Float planquantity_f){
        this.planquantity_f=planquantity_f;
    }
        
    public Date getPlanstarttime_t(){
        return planstarttime_t;
    }
    
    @XmlElement
    public void setPlanstarttime_t(Date planstarttime_t){
        this.planstarttime_t=planstarttime_t;
    }
        
    public Integer getPlan_order_i(){
        return plan_order_i;
    }
    
    @XmlElement
    public void setPlan_order_i(Integer plan_order_i){
        this.plan_order_i=plan_order_i;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRepiceno_s(){
        return repiceno_s;
    }
    
    @XmlElement
    public void setRepiceno_s(String repiceno_s){
        this.repiceno_s=repiceno_s;
    }
        
    public String getReviewer_s(){
        return reviewer_s;
    }
    
    @XmlElement
    public void setReviewer_s(String reviewer_s){
        this.reviewer_s=reviewer_s;
    }
        
    public Date getReviewtime_t(){
        return reviewtime_t;
    }
    
    @XmlElement
    public void setReviewtime_t(Date reviewtime_t){
        this.reviewtime_t=reviewtime_t;
    }
        
    public String getSapversion_s(){
        return sapversion_s;
    }
    
    @XmlElement
    public void setSapversion_s(String sapversion_s){
        this.sapversion_s=sapversion_s;
    }
        
    public String getSpare10_s(){
        return spare10_s;
    }
    
    @XmlElement
    public void setSpare10_s(String spare10_s){
        this.spare10_s=spare10_s;
    }
        
    public String getSpare1_s(){
        return spare1_s;
    }
    
    @XmlElement
    public void setSpare1_s(String spare1_s){
        this.spare1_s=spare1_s;
    }
        
    public String getSpare2_s(){
        return spare2_s;
    }
    
    @XmlElement
    public void setSpare2_s(String spare2_s){
        this.spare2_s=spare2_s;
    }
        
    public String getSpare3_s(){
        return spare3_s;
    }
    
    @XmlElement
    public void setSpare3_s(String spare3_s){
        this.spare3_s=spare3_s;
    }
        
    public String getSpare4_s(){
        return spare4_s;
    }
    
    @XmlElement
    public void setSpare4_s(String spare4_s){
        this.spare4_s=spare4_s;
    }
        
    public String getSpare5_s(){
        return spare5_s;
    }
    
    @XmlElement
    public void setSpare5_s(String spare5_s){
        this.spare5_s=spare5_s;
    }
        
    public String getSpare6_s(){
        return spare6_s;
    }
    
    @XmlElement
    public void setSpare6_s(String spare6_s){
        this.spare6_s=spare6_s;
    }
        
    public String getSpare7_s(){
        return spare7_s;
    }
    
    @XmlElement
    public void setSpare7_s(String spare7_s){
        this.spare7_s=spare7_s;
    }
        
    public String getSpare8_s(){
        return spare8_s;
    }
    
    @XmlElement
    public void setSpare8_s(String spare8_s){
        this.spare8_s=spare8_s;
    }
        
    public String getSpare9_s(){
        return spare9_s;
    }
    
    @XmlElement
    public void setSpare9_s(String spare9_s){
        this.spare9_s=spare9_s;
    }
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }

}

