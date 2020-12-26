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
 * 工艺参数修改履历表
 * @author 刘程明
 * @Date 2019-04-16 09:18:24
 */
@ATDefinition("B_QM_Formula_Record")
@Entity
@XmlRootElement
@Table(name="AT_B_QM_FORMULA_RECORD")
public class FormulaRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("配方修改来源")
    @Column(nullable=true,length=80)
    private String alter_source_s;
    
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
    
    @Comment("机台号")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("工艺配方索引号")
    @Column(nullable=false,length=80)
    private String formula_index_s;
    
    @Comment("工艺修改记录索引")
    @Column(nullable=true,length=80)
    private String formula_modify_index_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("工艺参数ID")
    @Column(nullable=true,length=80)
    private String parameter_id_s;
    
    @Comment("工艺参数名称")
    @Column(nullable=true,length=80)
    private String parameter_name_s;
    
    @Comment("工艺参数PLC地址")
    @Column(nullable=true,length=80)
    private String parameter_plcaddress_s;
    
    @Comment("工艺参数PLC值")
    @Column(nullable=true,length=80)
    private String parameter_plcvalue_s;
    
    @Comment("生产日计划号")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("产线号")
    @Column(nullable=true,length=80)
    private String productlinecode_s;
    
    @Comment("记录标志")
    @Column(nullable=false,length=80)
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
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlter_source_s(){
        return alter_source_s;
    }
    
    @XmlElement
    public void setAlter_source_s(String alter_source_s){
        this.alter_source_s=alter_source_s;
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
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getFormula_index_s(){
        return formula_index_s;
    }
    
    @XmlElement
    public void setFormula_index_s(String formula_index_s){
        this.formula_index_s=formula_index_s;
    }
        
    public String getFormula_modify_index_s(){
        return formula_modify_index_s;
    }
    
    @XmlElement
    public void setFormula_modify_index_s(String formula_modify_index_s){
        this.formula_modify_index_s=formula_modify_index_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getParameter_id_s(){
        return parameter_id_s;
    }
    
    @XmlElement
    public void setParameter_id_s(String parameter_id_s){
        this.parameter_id_s=parameter_id_s;
    }
        
    public String getParameter_name_s(){
        return parameter_name_s;
    }
    
    @XmlElement
    public void setParameter_name_s(String parameter_name_s){
        this.parameter_name_s=parameter_name_s;
    }
        
    public String getParameter_plcaddress_s(){
        return parameter_plcaddress_s;
    }
    
    @XmlElement
    public void setParameter_plcaddress_s(String parameter_plcaddress_s){
        this.parameter_plcaddress_s=parameter_plcaddress_s;
    }
        
    public String getParameter_plcvalue_s(){
        return parameter_plcvalue_s;
    }
    
    @XmlElement
    public void setParameter_plcvalue_s(String parameter_plcvalue_s){
        this.parameter_plcvalue_s=parameter_plcvalue_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProductlinecode_s(){
        return productlinecode_s;
    }
    
    @XmlElement
    public void setProductlinecode_s(String productlinecode_s){
        this.productlinecode_s=productlinecode_s;
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
        
    
    
    
}
