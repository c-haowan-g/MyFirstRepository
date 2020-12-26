/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 胎胚延期表
 * @author 王海霖
 * @Date 2020-02-26 15:36:01
 */
@ATDefinition("B_MM_TYREDELAY")
@Entity
@XmlRootElement
@Table(name="AT_B_MM_TYREDELAY")
public class TyreDelay extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 荆门 8023")
    @Column(nullable=false,length=16)
    private String agenc_no_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=50)
    private String building_time_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=20)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("延期人")
    @Column(nullable=false,length=20)
    private String delay_by_s;
    
    @Comment("延期时间")
    @Column(nullable=false,length=0)
    private Date delay_time_t;
    
    @Comment("物料编号")
    @Column(nullable=true,length=40)
    private String materialcode_s;
    
    @Comment("物料描述")
    @Column(nullable=true,length=200)
    private String materialdesc_s;
    
    @Comment("记录标志，A可用，D")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
    @Comment("轮胎条码")
    @Column(nullable=false,length=40)
    private String tyrebarcode_s;
    
    @Comment("有效期")
    @Column(nullable=true,length=50)
    private String validtime_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBuilding_time_s(){
        return building_time_s;
    }
    
    @XmlElement
    public void setBuilding_time_s(String building_time_s){
        this.building_time_s=building_time_s;
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
        
    public String getDelay_by_s(){
        return delay_by_s;
    }
    
    @XmlElement
    public void setDelay_by_s(String delay_by_s){
        this.delay_by_s=delay_by_s;
    }
        
    public Date getDelay_time_t(){
        return delay_time_t;
    }
    
    @XmlElement
    public void setDelay_time_t(Date delay_time_t){
        this.delay_time_t=delay_time_t;
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
        
    public String getValidtime_s(){
        return validtime_s;
    }
    
    @XmlElement
    public void setValidtime_s(String validtime_s){
        this.validtime_s=validtime_s;
    }
        
    
    
    
}
