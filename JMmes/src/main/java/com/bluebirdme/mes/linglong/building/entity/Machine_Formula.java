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
 * 成型工艺配方查询
 * @author 司乔靖
 * @Date 2019-02-18 13:47:29
 */
@ATDefinition("B_QM_Machine_Formula")
@Entity
@XmlRootElement
@Table(name="AT_B_QM_MACHINE_FORMULA")
public class Machine_Formula extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
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
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("胎胚物料编码（SAP品号）")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("胎胚物料名称")
    @Column(nullable=true,length=80)
    private String material_desc_s;
    
    @Comment("新配方标识")
    @Column(nullable=true,length=80)
    private String new_flag_s;
    
    @Comment("工艺参数ID")
    @Column(nullable=true,length=80)
    private String parameter_id_s;
    
    @Comment("工艺参数下限值")
    @Column(nullable=true,length=80)
    private String parameter_lowervalue_s;
    
    @Comment("工艺参数名称")
    @Column(nullable=true,length=80)
    private String parameter_name_s;
    
    @Comment("工艺参数PLC地址")
    @Column(nullable=true,length=80)
    private String parameter_plcaddress_s;
    
    @Comment("工艺参数PLC值")
    @Column(nullable=true,length=80)
    private String parameter_plcvalue_s;
    
    @Comment("工艺参数标准值")
    @Column(nullable=true,length=80)
    private String parameter_standardvalue_s;
    
    @Comment("工艺参数上限值")
    @Column(nullable=true,length=80)
    private String parameter_uppervalue_s;
    
    @Comment("参数类型代码")
    @Column(nullable=true,length=80)
    private String parmtype_code_s;
    
    @Comment("参数类型名称")
    @Column(nullable=true,length=80)
    private String parmtype_name_s;
    
    @Comment("工艺配方")
    @Column(nullable=true,length=80)
    private String processbom_index_s;
    
    @Comment("产品阶段")
    @Column(nullable=true,length=80)
    private String production_step_s;
    
    @Comment("记录标志，A可用，D删除")
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("胎胚版本号")
    @Column(nullable=true,length=80)
    private String version_s;
    
    @Comment("设备类型")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    
    public String getEquip_type_s() {
		return equip_type_s;
	}

	public void setEquip_type_s(String equip_type_s) {
		this.equip_type_s = equip_type_s;
	}

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
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_desc_s(){
        return material_desc_s;
    }
    
    @XmlElement
    public void setMaterial_desc_s(String material_desc_s){
        this.material_desc_s=material_desc_s;
    }
        
    public String getNew_flag_s(){
        return new_flag_s;
    }
    
    @XmlElement
    public void setNew_flag_s(String new_flag_s){
        this.new_flag_s=new_flag_s;
    }
        
    public String getParameter_id_s(){
        return parameter_id_s;
    }
    
    @XmlElement
    public void setParameter_id_s(String parameter_id_s){
        this.parameter_id_s=parameter_id_s;
    }
        
    public String getParameter_lowervalue_s(){
        return parameter_lowervalue_s;
    }
    
    @XmlElement
    public void setParameter_lowervalue_s(String parameter_lowervalue_s){
        this.parameter_lowervalue_s=parameter_lowervalue_s;
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
        
    public String getParameter_standardvalue_s(){
        return parameter_standardvalue_s;
    }
    
    @XmlElement
    public void setParameter_standardvalue_s(String parameter_standardvalue_s){
        this.parameter_standardvalue_s=parameter_standardvalue_s;
    }
        
    public String getParameter_uppervalue_s(){
        return parameter_uppervalue_s;
    }
    
    @XmlElement
    public void setParameter_uppervalue_s(String parameter_uppervalue_s){
        this.parameter_uppervalue_s=parameter_uppervalue_s;
    }
        
    public String getParmtype_code_s(){
        return parmtype_code_s;
    }
    
    @XmlElement
    public void setParmtype_code_s(String parmtype_code_s){
        this.parmtype_code_s=parmtype_code_s;
    }
        
    public String getParmtype_name_s(){
        return parmtype_name_s;
    }
    
    @XmlElement
    public void setParmtype_name_s(String parmtype_name_s){
        this.parmtype_name_s=parmtype_name_s;
    }
        
    public String getProcessbom_index_s(){
        return processbom_index_s;
    }
    
    @XmlElement
    public void setProcessbom_index_s(String processbom_index_s){
        this.processbom_index_s=processbom_index_s;
    }
        
    public String getProduction_step_s(){
        return production_step_s;
    }
    
    @XmlElement
    public void setProduction_step_s(String production_step_s){
        this.production_step_s=production_step_s;
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
        
    public String getVersion_s(){
        return version_s;
    }
    
    @XmlElement
    public void setVersion_s(String version_s){
        this.version_s=version_s;
    }
        
    
    
    
}
