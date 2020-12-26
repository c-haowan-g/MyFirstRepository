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
 * 成型定额表
 * @author 周志祥
 * @Date 2019-06-05 09:40:52
 */
@ATDefinition("B_MM_Quota")
@Entity
@XmlRootElement
@Table(name="AT_B_MM_QUOTA")
public class BuildQuota extends RockWellBaseEntity{
    
    
	    @Comment("创建人")
	    @Column(nullable=true,length=80)
	    private String created_by_s;
	    
	    @Comment("创建时间")
	    @Column(nullable=true,length=0)
	    private Date created_time_t;
	    
	    @Comment("机台类型")
	    @Column(nullable=true,length=80)
	    private String equip_type_s;
	    
	    @Comment("胎胚编码")
	    @Column(nullable=true,length=80)
	    private String materialcode_s;
	    
	    @Comment("胎胚描述")
	    @Column(nullable=true,length=80)
	    private String materialdesc_s;
	    
	    @Comment("规格")
	    @Column(nullable=true,length=80)
	    private String materialspec_s;
	    
	    @Comment("定额数量")
	    @Column(nullable=true,length=80)
	    private String quotacount_s;
	    
	    @Comment("是否可用")
	    @Column(nullable=true,length=80)
	    private String record_flag_s_s;
	    
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
	    
	    @Comment("工厂（1全钢2半钢）")
	    @Column(nullable=true,length=80)
	    private String s_factory_s;
	    
	    @Comment("胎体成型方式")
	    @Column(nullable=true,length=80)
	    private String tyretype_s;
	    
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
	        
	    public String getEquip_type_s(){
	        return equip_type_s;
	    }
	    
	    @XmlElement
	    public void setEquip_type_s(String equip_type_s){
	        this.equip_type_s=equip_type_s;
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
	        
	    public String getMaterialspec_s(){
	        return materialspec_s;
	    }
	    
	    @XmlElement
	    public void setMaterialspec_s(String materialspec_s){
	        this.materialspec_s=materialspec_s;
	    }
	        
	    public String getQuotacount_s(){
	        return quotacount_s;
	    }
	    
	    @XmlElement
	    public void setQuotacount_s(String quotacount_s){
	        this.quotacount_s=quotacount_s;
	    }
	        
	    public String getRecord_flag_s_s(){
	        return record_flag_s_s;
	    }
	    
	    @XmlElement
	    public void setRecord_flag_s_s(String record_flag_s_s){
	        this.record_flag_s_s=record_flag_s_s;
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
	        
	    public String getTyretype_s(){
	        return tyretype_s;
	    }
	    
	    @XmlElement
	    public void setTyretype_s(String tyretype_s){
	        this.tyretype_s=tyretype_s;
	    }
	        
    
    
    
}
