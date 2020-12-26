/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * 半部件日计划倒推异常记录表
 * @author 兰颖慧
 * @Date 2019-08-08 16:01:47
 */
@ATDefinition("A_PM_ProductPlan_LOG")
@Entity
@XmlRootElement
@Table(name="AT_A_PM_PRODUCTPLAN_LOG")
public class ProductPlanLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号:柳州 8003")
    @Column(nullable=false,length=10)
    private String agenc_no_s;
    
    @Comment("班次")
    @Column(nullable=true,length=10)
    private String classcode_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=30)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("客户标识  设置基础数据字典 317")
    @Column(nullable=true,length=80)
    private String customerflag_s;
    
    @Comment("异常描述")
    @Column(nullable=true,length=500)
    private String exceptionaldesc_s;
    
    @Comment("主产机台")
    @Column(nullable=true,length=80)
    private String hostmachine_s;
    
    @Comment("物料编码")
    @Column(nullable=false,length=80)
    private String materialcode_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=2)
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
    
    @Comment("未排产量")
    @Column(nullable=true,length=80)
    private String surplusdemand_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=10)
    private String s_factory_s;
    
    @Comment("副产机台")
    @Column(nullable=true,length=80)
    private String vicemachine_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
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
        
    public String getExceptionaldesc_s(){
        return exceptionaldesc_s;
    }
    
    @XmlElement
    public void setExceptionaldesc_s(String exceptionaldesc_s){
        this.exceptionaldesc_s=exceptionaldesc_s;
    }
        
    public String getHostmachine_s(){
        return hostmachine_s;
    }
    
    @XmlElement
    public void setHostmachine_s(String hostmachine_s){
        this.hostmachine_s=hostmachine_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
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
        
    public String getSurplusdemand_s(){
        return surplusdemand_s;
    }
    
    @XmlElement
    public void setSurplusdemand_s(String surplusdemand_s){
        this.surplusdemand_s=surplusdemand_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getVicemachine_s(){
        return vicemachine_s;
    }
    
    @XmlElement
    public void setVicemachine_s(String vicemachine_s){
        this.vicemachine_s=vicemachine_s;
    }
        
    
    
    
}
