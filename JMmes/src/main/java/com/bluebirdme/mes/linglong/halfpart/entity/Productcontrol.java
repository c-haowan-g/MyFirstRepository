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
 * 机台控制开关表
 * @author 李新宇
 * @Date 2020-03-05 11:18:46
 */
@ATDefinition("CM_EM_ProductControl")
@Entity
@XmlRootElement
@Table(name="AT_CM_EM_PRODUCTCONTROL")
public class Productcontrol extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=80)
    private String changed_time_s;
    
    @Comment("控制编号  机台编号+控制项")
    @Column(nullable=true,length=80)
    private String controlcode_s;
    
    @Comment("控制项    基础数据")
    @Column(nullable=true,length=80)
    private String controlitem_s;
    
    @Comment("控制方式：停机or报警")
    @Column(nullable=true,length=80)
    private String controlmethod_s;
    
    @Comment("控制显示类型")
    @Column(nullable=true,length=80)
    private String controlshowtype_s;
    
    @Comment("控制说明")
    @Column(nullable=true,length=80)
    private String controlspec_s;
    
    @Comment("控制状态：0 不启用 1 启用")
    @Column(nullable=true,length=80)
    private String controlstatus_s;
    
    @Comment("控制类型  0 机台 1 配置项")
    @Column(nullable=true,length=80)
    private String controltype_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("机台条码：需给规则(与机台信息表中的机台条码对应)")
    @Column(nullable=true,length=80)
    private String machinebarcode_s;
    
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
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
        
    public String getChanged_time_s(){
        return changed_time_s;
    }
    
    @XmlElement
    public void setChanged_time_s(String changed_time_s){
        this.changed_time_s=changed_time_s;
    }
        
    public String getControlcode_s(){
        return controlcode_s;
    }
    
    @XmlElement
    public void setControlcode_s(String controlcode_s){
        this.controlcode_s=controlcode_s;
    }
        
    public String getControlitem_s(){
        return controlitem_s;
    }
    
    @XmlElement
    public void setControlitem_s(String controlitem_s){
        this.controlitem_s=controlitem_s;
    }
        
    public String getControlmethod_s(){
        return controlmethod_s;
    }
    
    @XmlElement
    public void setControlmethod_s(String controlmethod_s){
        this.controlmethod_s=controlmethod_s;
    }
        
    public String getControlshowtype_s(){
        return controlshowtype_s;
    }
    
    @XmlElement
    public void setControlshowtype_s(String controlshowtype_s){
        this.controlshowtype_s=controlshowtype_s;
    }
        
    public String getControlspec_s(){
        return controlspec_s;
    }
    
    @XmlElement
    public void setControlspec_s(String controlspec_s){
        this.controlspec_s=controlspec_s;
    }
        
    public String getControlstatus_s(){
        return controlstatus_s;
    }
    
    @XmlElement
    public void setControlstatus_s(String controlstatus_s){
        this.controlstatus_s=controlstatus_s;
    }
        
    public String getControltype_s(){
        return controltype_s;
    }
    
    @XmlElement
    public void setControltype_s(String controltype_s){
        this.controltype_s=controltype_s;
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
        
    public String getMachinebarcode_s(){
        return machinebarcode_s;
    }
    
    @XmlElement
    public void setMachinebarcode_s(String machinebarcode_s){
        this.machinebarcode_s=machinebarcode_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
