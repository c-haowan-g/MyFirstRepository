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
 * (半部件)盘库记录主表
 * @author 肖吉朔
 * @Date 2020-09-01 14:09:12
 */
@ATDefinition("A_SM_STOCKINGMAIN")
@Entity
@XmlRootElement
@Table(name="AT_A_SM_STOCKINGMAIN")
public class Stockingmain extends RockWellBaseEntity{
    
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("库位")
    @Column(nullable=true,length=80)
    private String location_s;
    
    @Comment("是否可用")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("盘库类型 1-正式库盘库 2-虚拟库盘库")
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
    
    @Comment("状态")
    @Column(nullable=true,length=80)
    private String state_s;
    
    @Comment("盘库单号")
    @Column(nullable=true,length=80)
    private String stockno_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("盘库数量")
    @Column(nullable=true,length=0)
    private String vehiclecount_d;
    
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
        
    public String getLocation_s(){
        return location_s;
    }
    
    @XmlElement
    public void setLocation_s(String location_s){
        this.location_s=location_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    public String getState_s(){
        return state_s;
    }
    
    @XmlElement
    public void setState_s(String state_s){
        this.state_s=state_s;
    }
        
    public String getStockno_s(){
        return stockno_s;
    }
    
    @XmlElement
    public void setStockno_s(String stockno_s){
        this.stockno_s=stockno_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getVehiclecount_d(){
        return vehiclecount_d;
    }
    
    @XmlElement
    public void setVehiclecount_d(String vehiclecount_d){
        this.vehiclecount_d=vehiclecount_d;
    }
        
    
    
    
}
