/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 盘库结果管理
 * @author 陈国强
 * @Date 2020-08-20 08:13:07
 */
@ATDefinition("CM_WH_ITEM_INV_RESULT")
@Entity
@XmlRootElement
@Table(name="AT_CM_WH_ITEM_INV_RESULT")
public class MixStoragePlanResult extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=false,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=2)
    private String arch_flag_s;
    
    @Comment("单位 ")
    @Column(nullable=true,length=10)
    private String baseunit_s;
    
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
    
    @Comment("数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("期末结存-数量")
    @Column(nullable=true,length=0)
    private String end_qty_f;
    
    @Comment("期末结存-重量")
    @Column(nullable=true,length=0)
    private String end_weight_f;
    
    @Comment("主键ID")
    @Column(nullable=false,length=80)
    private String id_s;
    
    @Comment("期初结存-数量")
    @Column(nullable=true,length=0)
    private String ini_qty_f;
    
    @Comment("期初结存-重量")
    @Column(nullable=true,length=0)
    private String ini_weight_f;
    
    @Comment("作业名称")
    @Column(nullable=true,length=200)
    private String job_name_s;
    
    @Comment("盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO")
    @Column(nullable=false,length=80)
    private String job_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=80)
    private String material_group_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("生产数量")
    @Column(nullable=true,length=0)
    private String prod_qty_f;
    
    @Comment("生产重量")
    @Column(nullable=true,length=0)
    private String prod_weight_f;
    
    @Comment("记录标志：A-可用，D-删除")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
    @Comment("退库数量")
    @Column(nullable=true,length=0)
    private String return_qty_f;
    
    @Comment("退库重量")
    @Column(nullable=true,length=0)
    private String return_weight_f;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=100)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=100)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=100)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=100)
    private String spare9_s;
    
    @Comment("系统结存-数量")
    @Column(nullable=true,length=0)
    private String sys_qty_f;
    
    @Comment("系统结存-重量")
    @Column(nullable=true,length=0)
    private String sys_weight_f;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
    @Comment("使用数量")
    @Column(nullable=true,length=0)
    private String use_qty_f;
    
    @Comment("使用重量")
    @Column(nullable=true,length=0)
    private String use_weight_f;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getBaseunit_s(){
        return baseunit_s;
    }
    
    @XmlElement
    public void setBaseunit_s(String baseunit_s){
        this.baseunit_s=baseunit_s;
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
        
    public String getDatasource_s(){
        return datasource_s;
    }
    
    @XmlElement
    public void setDatasource_s(String datasource_s){
        this.datasource_s=datasource_s;
    }
        
    public String getEnd_qty_f(){
        return end_qty_f;
    }
    
    @XmlElement
    public void setEnd_qty_f(String end_qty_f){
        this.end_qty_f=end_qty_f;
    }
        
    public String getEnd_weight_f(){
        return end_weight_f;
    }
    
    @XmlElement
    public void setEnd_weight_f(String end_weight_f){
        this.end_weight_f=end_weight_f;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIni_qty_f(){
        return ini_qty_f;
    }
    
    @XmlElement
    public void setIni_qty_f(String ini_qty_f){
        this.ini_qty_f=ini_qty_f;
    }
        
    public String getIni_weight_f(){
        return ini_weight_f;
    }
    
    @XmlElement
    public void setIni_weight_f(String ini_weight_f){
        this.ini_weight_f=ini_weight_f;
    }
        
    public String getJob_name_s(){
        return job_name_s;
    }
    
    @XmlElement
    public void setJob_name_s(String job_name_s){
        this.job_name_s=job_name_s;
    }
        
    public String getJob_no_s(){
        return job_no_s;
    }
    
    @XmlElement
    public void setJob_no_s(String job_no_s){
        this.job_no_s=job_no_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_group_s(){
        return material_group_s;
    }
    
    @XmlElement
    public void setMaterial_group_s(String material_group_s){
        this.material_group_s=material_group_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getProd_qty_f(){
        return prod_qty_f;
    }
    
    @XmlElement
    public void setProd_qty_f(String prod_qty_f){
        this.prod_qty_f=prod_qty_f;
    }
        
    public String getProd_weight_f(){
        return prod_weight_f;
    }
    
    @XmlElement
    public void setProd_weight_f(String prod_weight_f){
        this.prod_weight_f=prod_weight_f;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getReturn_qty_f(){
        return return_qty_f;
    }
    
    @XmlElement
    public void setReturn_qty_f(String return_qty_f){
        this.return_qty_f=return_qty_f;
    }
        
    public String getReturn_weight_f(){
        return return_weight_f;
    }
    
    @XmlElement
    public void setReturn_weight_f(String return_weight_f){
        this.return_weight_f=return_weight_f;
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
        
    public String getSys_qty_f(){
        return sys_qty_f;
    }
    
    @XmlElement
    public void setSys_qty_f(String sys_qty_f){
        this.sys_qty_f=sys_qty_f;
    }
        
    public String getSys_weight_f(){
        return sys_weight_f;
    }
    
    @XmlElement
    public void setSys_weight_f(String sys_weight_f){
        this.sys_weight_f=sys_weight_f;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getUse_qty_f(){
        return use_qty_f;
    }
    
    @XmlElement
    public void setUse_qty_f(String use_qty_f){
        this.use_qty_f=use_qty_f;
    }
        
    public String getUse_weight_f(){
        return use_weight_f;
    }
    
    @XmlElement
    public void setUse_weight_f(String use_weight_f){
        this.use_weight_f=use_weight_f;
    }
        
    
    
    
}
