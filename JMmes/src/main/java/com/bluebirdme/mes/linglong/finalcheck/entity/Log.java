/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * 轮胎锁定记录表
 * @author 陈国强
 * @Date 2020-12-02 16:35:01
 */
@ATDefinition("D_QM_LOCK_LOG")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_LOCK_LOG")
public class Log extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("锁定前等级")
    @Column(nullable=true,length=80)
    private String lock_ago_s;
    
    @Comment("锁定人员编码")
    @Column(nullable=true,length=80)
    private String lock_by_s;
    
    @Comment("锁定人员")
    @Column(nullable=true,length=80)
    private String lock_name_s;
    
    @Comment("锁定后等级")
    @Column(nullable=true,length=80)
    private String lock_rear_s;
    
    @Comment("锁定原因")
    @Column(nullable=true,length=80)
    private String lock_reas_s;
    
    @Comment("锁定备注")
    @Column(nullable=true,length=80)
    private String lock_remark_s;
    
    @Comment("锁定时间")
    @Column(nullable=true,length=0)
    private Date lock_time_t;
    
    @Comment("记录标志(A可用 D删除)")
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
    
    @Comment("当前状态（1已锁定，0已解锁）")
    @Column(nullable=true,length=80)
    private String state_s;
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("轮胎条码（胶囊破裂）")
    @Column(nullable=true,length=80)
    private String tyrebarcode_s;
    
    @Comment("解锁人员编码")
    @Column(nullable=true,length=80)
    private String unlock_by_s;
    
    @Comment("解锁人员")
    @Column(nullable=true,length=80)
    private String unlock_name_s;
    
    @Comment("解锁原因")
    @Column(nullable=true,length=80)
    private String unlock_reas_s;
    
    @Comment("解锁时间")
    @Column(nullable=true,length=0)
    private Date unlock_time_t;
    
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
        
    public String getLock_ago_s(){
        return lock_ago_s;
    }
    
    @XmlElement
    public void setLock_ago_s(String lock_ago_s){
        this.lock_ago_s=lock_ago_s;
    }
        
    public String getLock_by_s(){
        return lock_by_s;
    }
    
    @XmlElement
    public void setLock_by_s(String lock_by_s){
        this.lock_by_s=lock_by_s;
    }
        
    public String getLock_name_s(){
        return lock_name_s;
    }
    
    @XmlElement
    public void setLock_name_s(String lock_name_s){
        this.lock_name_s=lock_name_s;
    }
        
    public String getLock_rear_s(){
        return lock_rear_s;
    }
    
    @XmlElement
    public void setLock_rear_s(String lock_rear_s){
        this.lock_rear_s=lock_rear_s;
    }
        
    public String getLock_reas_s(){
        return lock_reas_s;
    }
    
    @XmlElement
    public void setLock_reas_s(String lock_reas_s){
        this.lock_reas_s=lock_reas_s;
    }
        
    public String getLock_remark_s(){
        return lock_remark_s;
    }
    
    @XmlElement
    public void setLock_remark_s(String lock_remark_s){
        this.lock_remark_s=lock_remark_s;
    }
        
    public Date getLock_time_t(){
        return lock_time_t;
    }
    
    @XmlElement
    public void setLock_time_t(Date lock_time_t){
        this.lock_time_t=lock_time_t;
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
        
    public String getState_s(){
        return state_s;
    }
    
    @XmlElement
    public void setState_s(String state_s){
        this.state_s=state_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyrebarcode_s(){
        return tyrebarcode_s;
    }
    
    @XmlElement
    public void setTyrebarcode_s(String tyrebarcode_s){
        this.tyrebarcode_s=tyrebarcode_s;
    }
        
    public String getUnlock_by_s(){
        return unlock_by_s;
    }
    
    @XmlElement
    public void setUnlock_by_s(String unlock_by_s){
        this.unlock_by_s=unlock_by_s;
    }
        
    public String getUnlock_name_s(){
        return unlock_name_s;
    }
    
    @XmlElement
    public void setUnlock_name_s(String unlock_name_s){
        this.unlock_name_s=unlock_name_s;
    }
        
    public String getUnlock_reas_s(){
        return unlock_reas_s;
    }
    
    @XmlElement
    public void setUnlock_reas_s(String unlock_reas_s){
        this.unlock_reas_s=unlock_reas_s;
    }
        
    public Date getUnlock_time_t(){
        return unlock_time_t;
    }
    
    @XmlElement
    public void setUnlock_time_t(Date unlock_time_t){
        this.unlock_time_t=unlock_time_t;
    }
        
    
    
    
}
