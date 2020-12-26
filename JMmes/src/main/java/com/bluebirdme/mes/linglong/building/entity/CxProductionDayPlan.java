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
 * 成型日计划表
 * @author 刘程明
 * @Date 2019-03-14 09:50:42
 */
@ATDefinition("B_PP_ProductionDayPlan")
@Entity
@XmlRootElement
@Table(name="AT_B_PP_PRODUCTIONDAYPLAN")
public class CxProductionDayPlan extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("审核人")
    @Column(nullable=true,length=80)
    private String audit_by_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date audit_time_t;
    
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
    
    @Comment("客户标识")
    @Column(nullable=true,length=80)
    private String customer_flag_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=80)
    private String equip_name_s;
    
    @Comment("机台类型")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    @Comment("胎胚物料编码（SAP品号）")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("胎胚物料名称")
    @Column(nullable=true,length=80)
    private String material_desc_s;
    
    @Comment("中班完成量")
    @Column(nullable=true,length=0)
    private Integer output_midclass_i;
    
    @Comment("早班完成量")
    @Column(nullable=true,length=0)
    private Integer output_morclass_i;
    
    @Comment("晚班完成量")
    @Column(nullable=true,length=0)
    private Integer output_nigclass_i;
    
    @Comment("中班计划量")
    @Column(nullable=true,length=0)
    private Integer planamount_mid_i;
    
    @Comment("早班计划量")
    @Column(nullable=true,length=0)
    private Integer planamount_mor_i;
    
    @Comment("晚班计划量")
    @Column(nullable=true,length=0)
    private Integer planamount_nig_i;
    
    @Comment("月计划号")
    @Column(nullable=true,length=80)
    private String planno_month_s;
    
    @Comment("日计划号")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("日计划顺序")
    @Column(nullable=true,length=0)
    private Integer plan_queue_i;
    
    @Comment("工艺配方索引号")
    @Column(nullable=true,length=80)
    private String processbom_index_s;
    
    @Comment("成本收集器版本")
    @Column(nullable=true,length=80)
    private String productionver_s;
    
    @Comment("计划生产日期")
    @Column(nullable=true,length=80)
    private String production_date_s;
    
    @Comment("产品阶段")
    @Column(nullable=true,length=80)
    private String production_step_s;
    
    @Comment("日计划量")
    @Column(nullable=true,length=0)
    private Integer quantity_dayplan_i;
    
    @Comment("日完成量")
    @Column(nullable=true,length=0)
    private Integer quantity_dayproduct_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("SAP物料版本")
    @Column(nullable=true,length=80)
    private String sap_version_s;
    
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
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("计划状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("胎胚版本号")
    @Column(nullable=true,length=80)
    private String version_s;
    
    @Comment("工单号")
    @Column(nullable=true,length=80)
    private String order_number_s;
    
    
    public String getOrder_number_s() {
		return order_number_s;
	}

	public void setOrder_number_s(String order_number_s) {
		this.order_number_s = order_number_s;
	}

	public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAudit_by_s(){
        return audit_by_s;
    }
    
    @XmlElement
    public void setAudit_by_s(String audit_by_s){
        this.audit_by_s=audit_by_s;
    }
        
    public Date getAudit_time_t(){
        return audit_time_t;
    }
    
    @XmlElement
    public void setAudit_time_t(Date audit_time_t){
        this.audit_time_t=audit_time_t;
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
        
    public String getCustomer_flag_s(){
        return customer_flag_s;
    }
    
    @XmlElement
    public void setCustomer_flag_s(String customer_flag_s){
        this.customer_flag_s=customer_flag_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public String getEquip_type_s(){
        return equip_type_s;
    }
    
    @XmlElement
    public void setEquip_type_s(String equip_type_s){
        this.equip_type_s=equip_type_s;
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
        
    public Integer getOutput_midclass_i(){
        return output_midclass_i;
    }
    
    @XmlElement
    public void setOutput_midclass_i(Integer output_midclass_i){
        this.output_midclass_i=output_midclass_i;
    }
        
    public Integer getOutput_morclass_i(){
        return output_morclass_i;
    }
    
    @XmlElement
    public void setOutput_morclass_i(Integer output_morclass_i){
        this.output_morclass_i=output_morclass_i;
    }
        
    public Integer getOutput_nigclass_i(){
        return output_nigclass_i;
    }
    
    @XmlElement
    public void setOutput_nigclass_i(Integer output_nigclass_i){
        this.output_nigclass_i=output_nigclass_i;
    }
        
    public Integer getPlanamount_mid_i(){
        return planamount_mid_i;
    }
    
    @XmlElement
    public void setPlanamount_mid_i(Integer planamount_mid_i){
        this.planamount_mid_i=planamount_mid_i;
    }
        
    public Integer getPlanamount_mor_i(){
        return planamount_mor_i;
    }
    
    @XmlElement
    public void setPlanamount_mor_i(Integer planamount_mor_i){
        this.planamount_mor_i=planamount_mor_i;
    }
        
    public Integer getPlanamount_nig_i(){
        return planamount_nig_i;
    }
    
    @XmlElement
    public void setPlanamount_nig_i(Integer planamount_nig_i){
        this.planamount_nig_i=planamount_nig_i;
    }
        
    public String getPlanno_month_s(){
        return planno_month_s;
    }
    
    @XmlElement
    public void setPlanno_month_s(String planno_month_s){
        this.planno_month_s=planno_month_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public Integer getPlan_queue_i(){
        return plan_queue_i;
    }
    
    @XmlElement
    public void setPlan_queue_i(Integer plan_queue_i){
        this.plan_queue_i=plan_queue_i;
    }
        
    public String getProcessbom_index_s(){
        return processbom_index_s;
    }
    
    @XmlElement
    public void setProcessbom_index_s(String processbom_index_s){
        this.processbom_index_s=processbom_index_s;
    }
        
    public String getProductionver_s(){
        return productionver_s;
    }
    
    @XmlElement
    public void setProductionver_s(String productionver_s){
        this.productionver_s=productionver_s;
    }
        
    public String getProduction_date_s(){
        return production_date_s;
    }
    
    @XmlElement
    public void setProduction_date_s(String production_date_s){
        this.production_date_s=production_date_s;
    }
        
    public String getProduction_step_s(){
        return production_step_s;
    }
    
    @XmlElement
    public void setProduction_step_s(String production_step_s){
        this.production_step_s=production_step_s;
    }
        
    public Integer getQuantity_dayplan_i(){
        return quantity_dayplan_i;
    }
    
    @XmlElement
    public void setQuantity_dayplan_i(Integer quantity_dayplan_i){
        this.quantity_dayplan_i=quantity_dayplan_i;
    }
        
    public Integer getQuantity_dayproduct_i(){
        return quantity_dayproduct_i;
    }
    
    @XmlElement
    public void setQuantity_dayproduct_i(Integer quantity_dayproduct_i){
        this.quantity_dayproduct_i=quantity_dayproduct_i;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSap_version_s(){
        return sap_version_s;
    }
    
    @XmlElement
    public void setSap_version_s(String sap_version_s){
        this.sap_version_s=sap_version_s;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
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
