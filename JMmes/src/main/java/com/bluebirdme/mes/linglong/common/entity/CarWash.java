/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

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
 * PLM密炼配方洗车规则表
 * @author 陈国强
 * @Date 2020-09-07 16:14:36
 */
@ATDefinition("INT_PLM_MIXRECIPE_CARWASH")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_MIXRECIPE_CARWASH")
public class CarWash extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 20003")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("洗车数：必须大于或等于2，操作符0时清空")
    @Column(nullable=true,length=0)
    private Integer carwash_num_i;
    
    @Comment("是否启用：0-启用、1-停用")
    @Column(nullable=true,length=80)
    private String carwash_status_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("备用1")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("备用2")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=100)
    private String id_s;
    
    @Comment("洗车配方编号，操作符0时清空")
    @Column(nullable=true,length=80)
    private String recipe_code_carwash_s;
    
    @Comment("生产配方编号")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("洗车配方名称，操作符0时清空")
    @Column(nullable=true,length=100)
    private String recipe_name_carwash_s;
    
    @Comment("生产配方名称")
    @Column(nullable=true,length=100)
    private String recipe_name_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("操作符：0-无洗车要求、1-后洗车、2-前洗车")
    @Column(nullable=true,length=80)
    private String sign_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Integer getCarwash_num_i(){
        return carwash_num_i;
    }
    
    @XmlElement
    public void setCarwash_num_i(Integer carwash_num_i){
        this.carwash_num_i=carwash_num_i;
    }
        
    public String getCarwash_status_s(){
        return carwash_status_s;
    }
    
    @XmlElement
    public void setCarwash_status_s(String carwash_status_s){
        this.carwash_status_s=carwash_status_s;
    }
        
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
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getRecipe_code_carwash_s(){
        return recipe_code_carwash_s;
    }
    
    @XmlElement
    public void setRecipe_code_carwash_s(String recipe_code_carwash_s){
        this.recipe_code_carwash_s=recipe_code_carwash_s;
    }
        
    public String getRecipe_code_s(){
        return recipe_code_s;
    }
    
    @XmlElement
    public void setRecipe_code_s(String recipe_code_s){
        this.recipe_code_s=recipe_code_s;
    }
        
    public String getRecipe_name_carwash_s(){
        return recipe_name_carwash_s;
    }
    
    @XmlElement
    public void setRecipe_name_carwash_s(String recipe_name_carwash_s){
        this.recipe_name_carwash_s=recipe_name_carwash_s;
    }
        
    public String getRecipe_name_s(){
        return recipe_name_s;
    }
    
    @XmlElement
    public void setRecipe_name_s(String recipe_name_s){
        this.recipe_name_s=recipe_name_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSign_s(){
        return sign_s;
    }
    
    @XmlElement
    public void setSign_s(String sign_s){
        this.sign_s=sign_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
