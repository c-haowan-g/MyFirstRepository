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
 * (半部件)库存台账
 * @author 栾和源
 * @Date 2020-03-05 16:11:38
 */
@ATDefinition("A_SM_LEDGER")
@Entity
@XmlRootElement
@Table(name="AT_A_SM_LEDGER")
public class Ledger extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("副手操作工")
    @Column(nullable=true,length=80)
    private String assistantoperator_s;
    
    @Comment("条码号")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("物料批次状态 基础数据107")
    @Column(nullable=true,length=80)
    private String batchstatus_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("客户标识")
    @Column(nullable=true,length=80)
    private String customerflag_s;
    
    @Comment("延期时间，按小时计算")
    @Column(nullable=true,length=0)
    private Date delaytime_t;
    
    @Comment("病象")
    @Column(nullable=true,length=80)
    private String diseasecode_s;
    
    @Comment("描述-机台名称 ")
    @Column(nullable=true,length=80)
    private String equipdescription_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("先进先出标识 0 否 1 是")
    @Column(nullable=true,length=80)
    private String firstinout_s;
    
    @Comment("是否质量追踪冻结  0：否  1：是  冻结时不允许流转至下一工序")
    @Column(nullable=true,length=80)
    private String freezeflag_s;
    
    @Comment("半卷料确认标识")
    @Column(nullable=true,length=80)
    private String half_confirm_s;
    
    @Comment("库存操作标记 0 正常入库 1 盘库入库")
    @Column(nullable=true,length=80)
    private String inorout_s;
    
    @Comment("库存状态 基础数据111")
    @Column(nullable=true,length=80)
    private String inventory_status_s;
    
    @Comment("是否申请延期 0 否 1 是 ")
    @Column(nullable=true,length=80)
    private String isrequest_s;
    
    @Comment("是否用完 0 否1 是")
    @Column(nullable=true,length=80)
    private String isrunout_s;
    
    @Comment("当前库存位置 推荐库位")
    @Column(nullable=true,length=80)
    private String location_s;
    
    @Comment("当前剩余 数量/长度/ 重量")
    @Column(nullable=true,length=0)
    private String l_num_f;
    
    @Comment("机台类型（基础数据211） ")
    @Column(nullable=true,length=80)
    private String machinetype_s;
    
    @Comment("主手")
    @Column(nullable=true,length=80)
    private String mainoperator_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String materielcode_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String materielname_s;
    
    @Comment("物料组 基础数据308")
    @Column(nullable=true,length=80)
    private String m_group_s;
    
    @Comment("物料类型 基础数据 304")
    @Column(nullable=true,length=80)
    private String m_type_s;
    
    @Comment("计量单位 基础数据305")
    @Column(nullable=true,length=80)
    private String m_units_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date outputtime_t;
    
    @Comment("过期时间")
    @Column(nullable=true,length=0)
    private Date outtime_t;
    
    @Comment("工装条码(口型板)")
    @Column(nullable=true,length=80)
    private String plate_code_s;
    
    @Comment("生产时间")
    @Column(nullable=true,length=0)
    private Date productiondate_t;
    
    @Comment("质检人")
    @Column(nullable=true,length=80)
    private String qualityby_s;
    
    @Comment("质检时间")
    @Column(nullable=true,length=0)
    private Date qualitydate_t;
    
    @Comment("质量状态 基础数据106")
    @Column(nullable=true,length=80)
    private String quality_status_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("特殊放行状态 0 不放行 1：特殊放行")
    @Column(nullable=true,length=80)
    private String release_s;
    
    @Comment("卷曲工")
    @Column(nullable=true,length=80)
    private String rollworker_s;
    
    @Comment("SAP物料组 基础数据308 外部系统301开头的")
    @Column(nullable=true,length=80)
    private String sapm_group_s;
    
    @Comment("班次 基础数据118 ")
    @Column(nullable=true,length=80)
    private String shifts_s;
    
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
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("库存类型 基础数据112 ")
    @Column(nullable=true,length=80)
    private String stocktype_s;
    
    @Comment("停放时间")
    @Column(nullable=true,length=0)
    private Date stoptime_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("过期时效小时/天")
    @Column(nullable=true,length=0)
    private String timelimit_f;
    
    @Comment("载具条码")
    @Column(nullable=true,length=80)
    private String vehicles_code_s;
    
    @Comment("重量（原料胶料）")
    @Column(nullable=true,length=0)
    private String weight_f;
    
    @Comment("产出初始数量/长度 /重量(半部件产出)")
    @Column(nullable=true,length=0)
    private String yl_num_f;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAssistantoperator_s(){
        return assistantoperator_s;
    }
    
    @XmlElement
    public void setAssistantoperator_s(String assistantoperator_s){
        this.assistantoperator_s=assistantoperator_s;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getBatchstatus_s(){
        return batchstatus_s;
    }
    
    @XmlElement
    public void setBatchstatus_s(String batchstatus_s){
        this.batchstatus_s=batchstatus_s;
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
        
    public String getCustomerflag_s(){
        return customerflag_s;
    }
    
    @XmlElement
    public void setCustomerflag_s(String customerflag_s){
        this.customerflag_s=customerflag_s;
    }
        
    public Date getDelaytime_t(){
        return delaytime_t;
    }
    
    @XmlElement
    public void setDelaytime_t(Date delaytime_t){
        this.delaytime_t=delaytime_t;
    }
        
    public String getDiseasecode_s(){
        return diseasecode_s;
    }
    
    @XmlElement
    public void setDiseasecode_s(String diseasecode_s){
        this.diseasecode_s=diseasecode_s;
    }
        
    public String getEquipdescription_s(){
        return equipdescription_s;
    }
    
    @XmlElement
    public void setEquipdescription_s(String equipdescription_s){
        this.equipdescription_s=equipdescription_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getFirstinout_s(){
        return firstinout_s;
    }
    
    @XmlElement
    public void setFirstinout_s(String firstinout_s){
        this.firstinout_s=firstinout_s;
    }
        
    public String getFreezeflag_s(){
        return freezeflag_s;
    }
    
    @XmlElement
    public void setFreezeflag_s(String freezeflag_s){
        this.freezeflag_s=freezeflag_s;
    }
        
    public String getHalf_confirm_s(){
        return half_confirm_s;
    }
    
    @XmlElement
    public void setHalf_confirm_s(String half_confirm_s){
        this.half_confirm_s=half_confirm_s;
    }
        
    public String getInorout_s(){
        return inorout_s;
    }
    
    @XmlElement
    public void setInorout_s(String inorout_s){
        this.inorout_s=inorout_s;
    }
        
    public String getInventory_status_s(){
        return inventory_status_s;
    }
    
    @XmlElement
    public void setInventory_status_s(String inventory_status_s){
        this.inventory_status_s=inventory_status_s;
    }
        
    public String getIsrequest_s(){
        return isrequest_s;
    }
    
    @XmlElement
    public void setIsrequest_s(String isrequest_s){
        this.isrequest_s=isrequest_s;
    }
        
    public String getIsrunout_s(){
        return isrunout_s;
    }
    
    @XmlElement
    public void setIsrunout_s(String isrunout_s){
        this.isrunout_s=isrunout_s;
    }
        
    public String getLocation_s(){
        return location_s;
    }
    
    @XmlElement
    public void setLocation_s(String location_s){
        this.location_s=location_s;
    }
        
    public String getL_num_f(){
        return l_num_f;
    }
    
    @XmlElement
    public void setL_num_f(String l_num_f){
        this.l_num_f=l_num_f;
    }
        
    public String getMachinetype_s(){
        return machinetype_s;
    }
    
    @XmlElement
    public void setMachinetype_s(String machinetype_s){
        this.machinetype_s=machinetype_s;
    }
        
    public String getMainoperator_s(){
        return mainoperator_s;
    }
    
    @XmlElement
    public void setMainoperator_s(String mainoperator_s){
        this.mainoperator_s=mainoperator_s;
    }
        
    public String getMaterielcode_s(){
        return materielcode_s;
    }
    
    @XmlElement
    public void setMaterielcode_s(String materielcode_s){
        this.materielcode_s=materielcode_s;
    }
        
    public String getMaterielname_s(){
        return materielname_s;
    }
    
    @XmlElement
    public void setMaterielname_s(String materielname_s){
        this.materielname_s=materielname_s;
    }
        
    public String getM_group_s(){
        return m_group_s;
    }
    
    @XmlElement
    public void setM_group_s(String m_group_s){
        this.m_group_s=m_group_s;
    }
        
    public String getM_type_s(){
        return m_type_s;
    }
    
    @XmlElement
    public void setM_type_s(String m_type_s){
        this.m_type_s=m_type_s;
    }
        
    public String getM_units_s(){
        return m_units_s;
    }
    
    @XmlElement
    public void setM_units_s(String m_units_s){
        this.m_units_s=m_units_s;
    }
        
    public Date getOutputtime_t(){
        return outputtime_t;
    }
    
    @XmlElement
    public void setOutputtime_t(Date outputtime_t){
        this.outputtime_t=outputtime_t;
    }
        
    public Date getOuttime_t(){
        return outtime_t;
    }
    
    @XmlElement
    public void setOuttime_t(Date outtime_t){
        this.outtime_t=outtime_t;
    }
        
    public String getPlate_code_s(){
        return plate_code_s;
    }
    
    @XmlElement
    public void setPlate_code_s(String plate_code_s){
        this.plate_code_s=plate_code_s;
    }
        
    public Date getProductiondate_t(){
        return productiondate_t;
    }
    
    @XmlElement
    public void setProductiondate_t(Date productiondate_t){
        this.productiondate_t=productiondate_t;
    }
        
    public String getQualityby_s(){
        return qualityby_s;
    }
    
    @XmlElement
    public void setQualityby_s(String qualityby_s){
        this.qualityby_s=qualityby_s;
    }
        
    public Date getQualitydate_t(){
        return qualitydate_t;
    }
    
    @XmlElement
    public void setQualitydate_t(Date qualitydate_t){
        this.qualitydate_t=qualitydate_t;
    }
        
    public String getQuality_status_s(){
        return quality_status_s;
    }
    
    @XmlElement
    public void setQuality_status_s(String quality_status_s){
        this.quality_status_s=quality_status_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRelease_s(){
        return release_s;
    }
    
    @XmlElement
    public void setRelease_s(String release_s){
        this.release_s=release_s;
    }
        
    public String getRollworker_s(){
        return rollworker_s;
    }
    
    @XmlElement
    public void setRollworker_s(String rollworker_s){
        this.rollworker_s=rollworker_s;
    }
        
    public String getSapm_group_s(){
        return sapm_group_s;
    }
    
    @XmlElement
    public void setSapm_group_s(String sapm_group_s){
        this.sapm_group_s=sapm_group_s;
    }
        
    public String getShifts_s(){
        return shifts_s;
    }
    
    @XmlElement
    public void setShifts_s(String shifts_s){
        this.shifts_s=shifts_s;
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
        
    public String getStocktype_s(){
        return stocktype_s;
    }
    
    @XmlElement
    public void setStocktype_s(String stocktype_s){
        this.stocktype_s=stocktype_s;
    }
        
    public Date getStoptime_t(){
        return stoptime_t;
    }
    
    @XmlElement
    public void setStoptime_t(Date stoptime_t){
        this.stoptime_t=stoptime_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTimelimit_f(){
        return timelimit_f;
    }
    
    @XmlElement
    public void setTimelimit_f(String timelimit_f){
        this.timelimit_f=timelimit_f;
    }
        
    public String getVehicles_code_s(){
        return vehicles_code_s;
    }
    
    @XmlElement
    public void setVehicles_code_s(String vehicles_code_s){
        this.vehicles_code_s=vehicles_code_s;
    }
        
    public String getWeight_f(){
        return weight_f;
    }
    
    @XmlElement
    public void setWeight_f(String weight_f){
        this.weight_f=weight_f;
    }
        
    public String getYl_num_f(){
        return yl_num_f;
    }
    
    @XmlElement
    public void setYl_num_f(String yl_num_f){
        this.yl_num_f=yl_num_f;
    }
        
    
    
    
}
