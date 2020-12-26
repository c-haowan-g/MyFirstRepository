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
 * 密炼料仓清理履历表
 * @author 栾和源
 * @Date 2020-08-05 08:57:48
 */
@ATDefinition("MX_MM_SILOCLEAR_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_SILOCLEAR_RECORD")
public class SiloclearRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=100)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("清理人")
    @Column(nullable=true,length=80)
    private String clear_by_s;
    
    @Comment("清理人姓名")
    @Column(nullable=true,length=80)
    private String clear_name_s;
    
    @Comment("清理时间")
    @Column(nullable=true,length=80)
    private String clear_time_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=100)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("机台编码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("班组：301001-甲班、301002-乙班、301003-丙班")
    @Column(nullable=true,length=80)
    private String group_code_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("密炼生成配方编号")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String shift_code_s;
    
    @Comment("料仓号（1、2、3…7）")
    @Column(nullable=true,length=80)
    private String silono_s;
    
    @Comment("料仓类型： 057001-密炼机胶架投料口 057002-碎胶机胶架投料口 057003-自动小料 057004-人工小料 057005-一次法小料 057006-油罐 057007-炭黑罐 057008-白炭黑罐")
    @Column(nullable=true,length=80)
    private String silo_type_s;
    
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
    
    @Comment("配套供应商编号")
    @Column(nullable=true,length=80)
    private String supplier_code_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    @Comment("密炼工单跟踪表，工单号，外键，MX_PP_WO.WO_NO")
    @Column(nullable=true,length=80)
    private String wo_no_s;
    
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
        
    public String getClear_by_s(){
        return clear_by_s;
    }
    
    @XmlElement
    public void setClear_by_s(String clear_by_s){
        this.clear_by_s=clear_by_s;
    }
        
    public String getClear_name_s(){
        return clear_name_s;
    }
    
    @XmlElement
    public void setClear_name_s(String clear_name_s){
        this.clear_name_s=clear_name_s;
    }
        
    public String getClear_time_s(){
        return clear_time_s;
    }
    
    @XmlElement
    public void setClear_time_s(String clear_time_s){
        this.clear_time_s=clear_time_s;
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
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getGroup_code_s(){
        return group_code_s;
    }
    
    @XmlElement
    public void setGroup_code_s(String group_code_s){
        this.group_code_s=group_code_s;
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
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public String getRecipe_code_s(){
        return recipe_code_s;
    }
    
    @XmlElement
    public void setRecipe_code_s(String recipe_code_s){
        this.recipe_code_s=recipe_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getShift_code_s(){
        return shift_code_s;
    }
    
    @XmlElement
    public void setShift_code_s(String shift_code_s){
        this.shift_code_s=shift_code_s;
    }
        
    public String getSilono_s(){
        return silono_s;
    }
    
    @XmlElement
    public void setSilono_s(String silono_s){
        this.silono_s=silono_s;
    }
        
    public String getSilo_type_s(){
        return silo_type_s;
    }
    
    @XmlElement
    public void setSilo_type_s(String silo_type_s){
        this.silo_type_s=silo_type_s;
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
        
    public String getSupplier_code_s(){
        return supplier_code_s;
    }
    
    @XmlElement
    public void setSupplier_code_s(String supplier_code_s){
        this.supplier_code_s=supplier_code_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
