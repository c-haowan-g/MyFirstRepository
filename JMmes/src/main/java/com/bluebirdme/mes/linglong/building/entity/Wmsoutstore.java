/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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
 * 胎胚出库实绩表
 * @author 王海霖
 * @Date 2019-03-27 13:32:32
 */
@ATDefinition("INT_WH_WMSOUTSTORE")
@Entity
@XmlRootElement
@Table(name="AT_INT_WH_WMSOUTSTORE")
public class Wmsoutstore extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
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
    
    @Comment("机台号")
    @Column(nullable=true,length=80)
    private String machinno_s;
    
    @Comment("出库时间")
    @Column(nullable=true,length=0)
    private Date outstoredata_t;
    
    @Comment("出库位置")
    @Column(nullable=true,length=80)
    private String outstorelocation_s;
    
    @Comment("出库类型")
    @Column(nullable=true,length=80)
    private String outstoretype_s;
    
    @Comment("计划号")
    @Column(nullable=true,length=80)
    private String plancode_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("旋转角度")
    @Column(nullable=true,length=80)
    private String rotationangle_s;
    
    @Comment("SAP品号")
    @Column(nullable=true,length=80)
    private String sapcode_s;
    
    @Comment("备用字段true")
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
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("喷涂标识")
    @Column(nullable=true,length=80)
    private String sprayinglogo_s;
    
    @Comment("喷涂时间")
    @Column(nullable=true,length=0)
    private Date sprayingtime_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("条码号")
    @Column(nullable=true,length=80)
    private String tirebarcode_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
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
        
    public String getMachinno_s(){
        return machinno_s;
    }
    
    @XmlElement
    public void setMachinno_s(String machinno_s){
        this.machinno_s=machinno_s;
    }
        
    public Date getOutstoredata_t(){
        return outstoredata_t;
    }
    
    @XmlElement
    public void setOutstoredata_t(Date outstoredata_t){
        this.outstoredata_t=outstoredata_t;
    }
        
    public String getOutstorelocation_s(){
        return outstorelocation_s;
    }
    
    @XmlElement
    public void setOutstorelocation_s(String outstorelocation_s){
        this.outstorelocation_s=outstorelocation_s;
    }
        
    public String getOutstoretype_s(){
        return outstoretype_s;
    }
    
    @XmlElement
    public void setOutstoretype_s(String outstoretype_s){
        this.outstoretype_s=outstoretype_s;
    }
        
    public String getPlancode_s(){
        return plancode_s;
    }
    
    @XmlElement
    public void setPlancode_s(String plancode_s){
        this.plancode_s=plancode_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRotationangle_s(){
        return rotationangle_s;
    }
    
    @XmlElement
    public void setRotationangle_s(String rotationangle_s){
        this.rotationangle_s=rotationangle_s;
    }
        
    public String getSapcode_s(){
        return sapcode_s;
    }
    
    @XmlElement
    public void setSapcode_s(String sapcode_s){
        this.sapcode_s=sapcode_s;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getSprayinglogo_s(){
        return sprayinglogo_s;
    }
    
    @XmlElement
    public void setSprayinglogo_s(String sprayinglogo_s){
        this.sprayinglogo_s=sprayinglogo_s;
    }
        
    public Date getSprayingtime_t(){
        return sprayingtime_t;
    }
    
    @XmlElement
    public void setSprayingtime_t(Date sprayingtime_t){
        this.sprayingtime_t=sprayingtime_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTirebarcode_s(){
        return tirebarcode_s;
    }
    
    @XmlElement
    public void setTirebarcode_s(String tirebarcode_s){
        this.tirebarcode_s=tirebarcode_s;
    }
    
}
