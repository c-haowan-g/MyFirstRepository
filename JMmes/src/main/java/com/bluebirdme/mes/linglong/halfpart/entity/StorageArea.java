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
 * 线边库表
 * @author 栾和源
 * @Date 2020-03-10 13:07:41
 */
@ATDefinition("A_MM_STORAGEAREA")
@Entity
@XmlRootElement
@Table(name="AT_A_MM_STORAGEAREA")
public class StorageArea extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 ")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("条码号 ")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("箱号")
    @Column(nullable=true,length=80)
    private String boxcode_s;
    
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
    
    @Comment("当前剩余 数量/长度/ 重量 ")
    @Column(nullable=true,length=0)
    private String current_num_f;
    
    @Comment("延期时间，按小时计算 ")
    @Column(nullable=true,length=0)
    private Date delaytime_t;
    
    @Comment("配送人 ")
    @Column(nullable=true,length=80)
    private String deliverier_s;
    
    @Comment("配送时间 ")
    @Column(nullable=true,length=0)
    private Date deliverytime_t;
    
    @Comment("机台条码 ")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("产出初始数量/长度 /重量(半部件产出) ")
    @Column(nullable=true,length=0)
    private String ini_num_f;
    
    @Comment("是否用完 0 否1 是 ")
    @Column(nullable=true,length=80)
    private String isrunout_s;
    
    @Comment("当前库存位置 推荐库位 ")
    @Column(nullable=true,length=80)
    private String location_s;
    
    @Comment("物料大类 113 ")
    @Column(nullable=true,length=80)
    private String materialgroup_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String materielcode_s;
    
    @Comment("物料名称 ")
    @Column(nullable=true,length=80)
    private String materielname_s;
    
    @Comment("物料组 基础数据308 ")
    @Column(nullable=true,length=80)
    private String m_group_s;
    
    @Comment("物料类型 基础数据 304 ")
    @Column(nullable=true,length=80)
    private String m_type_s;
    
    @Comment("计量单位 基础数据305 ")
    @Column(nullable=true,length=80)
    private String m_units_s;
    
    @Comment("产出时间 ")
    @Column(nullable=true,length=0)
    private Date outputtime_t;
    
    @Comment("过期时间 ")
    @Column(nullable=true,length=0)
    private Date outtime_t;
    
    @Comment("质量状态 基础数据106 ")
    @Column(nullable=true,length=80)
    private String quality_status_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
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
    
    @Comment("规格 ")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("库存类型 基础数据 227 ")
    @Column(nullable=true,length=80)
    private String stocktype_s;
    
    @Comment("工厂（1全钢 2半钢） ")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("载具条码 ")
    @Column(nullable=true,length=80)
    private String vehicles_code_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getBoxcode_s(){
        return boxcode_s;
    }
    
    @XmlElement
    public void setBoxcode_s(String boxcode_s){
        this.boxcode_s=boxcode_s;
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
        
    public String getCurrent_num_f(){
        return current_num_f;
    }
    
    @XmlElement
    public void setCurrent_num_f(String current_num_f){
        this.current_num_f=current_num_f;
    }
        
    public Date getDelaytime_t(){
        return delaytime_t;
    }
    
    @XmlElement
    public void setDelaytime_t(Date delaytime_t){
        this.delaytime_t=delaytime_t;
    }
        
    public String getDeliverier_s(){
        return deliverier_s;
    }
    
    @XmlElement
    public void setDeliverier_s(String deliverier_s){
        this.deliverier_s=deliverier_s;
    }
        
    public Date getDeliverytime_t(){
        return deliverytime_t;
    }
    
    @XmlElement
    public void setDeliverytime_t(Date deliverytime_t){
        this.deliverytime_t=deliverytime_t;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getIni_num_f(){
        return ini_num_f;
    }
    
    @XmlElement
    public void setIni_num_f(String ini_num_f){
        this.ini_num_f=ini_num_f;
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
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getVehicles_code_s(){
        return vehicles_code_s;
    }
    
    @XmlElement
    public void setVehicles_code_s(String vehicles_code_s){
        this.vehicles_code_s=vehicles_code_s;
    }
        
    
    
    
}
