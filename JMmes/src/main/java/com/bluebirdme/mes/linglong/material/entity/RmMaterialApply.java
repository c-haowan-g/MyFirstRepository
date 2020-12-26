/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.entity;

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
 * 原材料领料计划主表
 * @author 李昂
 * @Date 2020-09-25 16:35:58
 */
@ATDefinition("RM_PP_MATERIALAPPLY")
@Entity
@XmlRootElement
@Table(name="AT_RM_PP_MATERIALAPPLY")
public class RmMaterialApply extends RockWellBaseEntity{
    
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源0-计划倒推1-手动添加")
    @Column(nullable=true,length=80)
    private String data_source_s;
    
    @Comment("主键ID")
    @Column(nullable=false,length=80)
    private String id_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("用料生产日期")
    @Column(nullable=true,length=40)
    private String prod_date_s;
    
    @Comment("用料生产班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=false,length=80)
    private String prod_shift_s;
    
    @Comment("允许超差")
    @Column(nullable=false,length=0)
    private String qty_allow_receive_f;
    
    @Comment("计划重量")
    @Column(nullable=false,length=0)
    private String qty_apply_f;
    
    @Comment("接受重量")
    @Column(nullable=false,length=0)
    private String qty_receive_f;
    
    @Comment("备用字段10")
    @Column(nullable=false,length=100)
    private String spare10_s;
    
    @Comment("备用字段1")
    @Column(nullable=false,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=false,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=false,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=false,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=false,length=100)
    private String spare5_s;
    
    @Comment("备用字段6")
    @Column(nullable=false,length=100)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=false,length=100)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=false,length=100)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=false,length=100)
    private String spare9_s;
    
    @Comment("接受库区")
    @Column(nullable=true,length=25)
    private String store_type_s;
    
    @Comment("工厂：1-全钢，2-半钢")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public String getChanged_name_s(){
        return changed_name_s;
    }
    
    @XmlElement
    public void setChanged_name_s(String changed_name_s){
        this.changed_name_s=changed_name_s;
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
        
    public String getCreated_name_s(){
        return created_name_s;
    }
    
    @XmlElement
    public void setCreated_name_s(String created_name_s){
        this.created_name_s=created_name_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getData_source_s(){
        return data_source_s;
    }
    
    @XmlElement
    public void setData_source_s(String data_source_s){
        this.data_source_s=data_source_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getProd_date_s(){
        return prod_date_s;
    }
    
    @XmlElement
    public void setProd_date_s(String prod_date_s){
        this.prod_date_s=prod_date_s;
    }
        
    public String getProd_shift_s(){
        return prod_shift_s;
    }
    
    @XmlElement
    public void setProd_shift_s(String prod_shift_s){
        this.prod_shift_s=prod_shift_s;
    }
        
    public String getQty_allow_receive_f(){
        return qty_allow_receive_f;
    }
    
    @XmlElement
    public void setQty_allow_receive_f(String qty_allow_receive_f){
        this.qty_allow_receive_f=qty_allow_receive_f;
    }
        
    public String getQty_apply_f(){
        return qty_apply_f;
    }
    
    @XmlElement
    public void setQty_apply_f(String qty_apply_f){
        this.qty_apply_f=qty_apply_f;
    }
        
    public String getQty_receive_f(){
        return qty_receive_f;
    }
    
    @XmlElement
    public void setQty_receive_f(String qty_receive_f){
        this.qty_receive_f=qty_receive_f;
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
        
    public String getStore_type_s(){
        return store_type_s;
    }
    
    @XmlElement
    public void setStore_type_s(String store_type_s){
        this.store_type_s=store_type_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
