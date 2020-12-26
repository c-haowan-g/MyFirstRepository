/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 年周号履历
 * @author 周志祥
 * @Date 2019-03-12 15:18:47
 */
@ATDefinition("C_MM_DOTRECORD")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_DOTRECORD")
public class DotRecord extends RockWellBaseEntity{
    
    
    @Comment("班组")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("年周号")
    @Column(nullable=true,length=80)
    private String dotnum_s;
    
    @Comment("机台")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("班次")
    @Column(nullable=true,length=80)
    private String group_id_s;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String operator_id_s;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date operator_time_t;
    
    @Comment("是否可用")
    @Column(nullable=true,length=80)
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
    
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDotnum_s(){
        return dotnum_s;
    }
    
    @XmlElement
    public void setDotnum_s(String dotnum_s){
        this.dotnum_s=dotnum_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getGroup_id_s(){
        return group_id_s;
    }
    
    @XmlElement
    public void setGroup_id_s(String group_id_s){
        this.group_id_s=group_id_s;
    }
        
    public String getOperator_id_s(){
        return operator_id_s;
    }
    
    @XmlElement
    public void setOperator_id_s(String operator_id_s){
        this.operator_id_s=operator_id_s;
    }
        
    public Date getOperator_time_t(){
        return operator_time_t;
    }
    
    @XmlElement
    public void setOperator_time_t(Date operator_time_t){
        this.operator_time_t=operator_time_t;
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
        
    
    
    
}
