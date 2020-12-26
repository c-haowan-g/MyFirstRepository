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
 * 半部件物流调度履历查询
 * @author 孙尊龙
 * @Date 2020-07-14 14:33:02
 */
@ATDefinition("A_MM_SCHEDULERECORD")
@Entity
@XmlRootElement
@Table(name="AT_A_MM_SCHEDULERECORD")
public class ScheduleRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
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
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String column_9_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equipmentcode_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("调度接口")
    @Column(nullable=true,length=80)
    private String scheduleinterface_s;
    
    @Comment("调度物料")
    @Column(nullable=true,length=80)
    private String schedulematerial_s;
    
    @Comment("调度指令")
    @Column(nullable=true,length=80)
    private String scheduleorder_s;
    
    @Comment("调度数量")
    @Column(nullable=true,length=0)
    private Integer schedulequantity_i;
    
    @Comment("调度结果，0：未完成 1：完成")
    @Column(nullable=true,length=80)
    private String schedulestatus_s;
    
    @Comment("触发时间")
    @Column(nullable=true,length=0)
    private Date scheduletime_t;
    
    @Comment("触发方式 0：自动:1：手动")
    @Column(nullable=true,length=80)
    private String scheduletype_s;
    
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
    @Column(nullable=false,length=80)
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
        
    public String getColumn_9_s(){
        return column_9_s;
    }
    
    @XmlElement
    public void setColumn_9_s(String column_9_s){
        this.column_9_s=column_9_s;
    }
        
    public String getEquipmentcode_s(){
        return equipmentcode_s;
    }
    
    @XmlElement
    public void setEquipmentcode_s(String equipmentcode_s){
        this.equipmentcode_s=equipmentcode_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getScheduleinterface_s(){
        return scheduleinterface_s;
    }
    
    @XmlElement
    public void setScheduleinterface_s(String scheduleinterface_s){
        this.scheduleinterface_s=scheduleinterface_s;
    }
        
    public String getSchedulematerial_s(){
        return schedulematerial_s;
    }
    
    @XmlElement
    public void setSchedulematerial_s(String schedulematerial_s){
        this.schedulematerial_s=schedulematerial_s;
    }
        
    public String getScheduleorder_s(){
        return scheduleorder_s;
    }
    
    @XmlElement
    public void setScheduleorder_s(String scheduleorder_s){
        this.scheduleorder_s=scheduleorder_s;
    }
        
    public Integer getSchedulequantity_i(){
        return schedulequantity_i;
    }
    
    @XmlElement
    public void setSchedulequantity_i(Integer schedulequantity_i){
        this.schedulequantity_i=schedulequantity_i;
    }
        
    public String getSchedulestatus_s(){
        return schedulestatus_s;
    }
    
    @XmlElement
    public void setSchedulestatus_s(String schedulestatus_s){
        this.schedulestatus_s=schedulestatus_s;
    }
        
    public Date getScheduletime_t(){
        return scheduletime_t;
    }
    
    @XmlElement
    public void setScheduletime_t(Date scheduletime_t){
        this.scheduletime_t=scheduletime_t;
    }
        
    public String getScheduletype_s(){
        return scheduletype_s;
    }
    
    @XmlElement
    public void setScheduletype_s(String scheduletype_s){
        this.scheduletype_s=scheduletype_s;
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
