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
 * 硫化生产日计划
 * @author 刘程明
 * @Date 2018-10-08 15:46:14
 */
@ATDefinition("C_PP_REPORTOFPLANSCHEDULE")
@Entity
@XmlRootElement
@Table(name="AT_C_PP_REPORTOFPLANSCHEDULE")
public class ReportOfPlanSchedule extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=80)
    private String approval_time_s;
    
    @Comment("审核人")
    @Column(nullable=true,length=100)
    private String approver_s;
    
    @Comment("更新人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("更新时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("胎胚版本(左)")
    @Column(nullable=true,length=80)
    private String childbom_ver_left_s;
    
    @Comment("胎胚版本(右)")
    @Column(nullable=true,length=80)
    private String childbom_ver_right_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("机台条码(左)")
    @Column(nullable=true,length=80)
    private String equip_code_left_s;
    
    @Comment("机台条码(右)")
    @Column(nullable=true,length=80)
    private String equip_code_right_s;
    
    @Comment("物料编码(左)")
    @Column(nullable=true,length=80)
    private String material_code_left_s;
    
    @Comment("物料编码(右)")
    @Column(nullable=true,length=100)
    private String material_code_right_s;
    
    @Comment("物料名称(左)")
    @Column(nullable=true,length=200)
    private String material_desc_left_s;
    
    @Comment("物料名称(右)")
    @Column(nullable=true,length=200)
    private String material_desc_right_s;
    
    @Comment("物料名称(左)")
    @Column(nullable=true,length=200)
    private String material_name_left_s;
    
    @Comment("备注(左)")
    @Column(nullable=true,length=100)
    private String memo_left_s;
    
    @Comment("备注(右)")
    @Column(nullable=true,length=100)
    private String memo_right_s;
    
    @Comment("中班完成量(左)")
    @Column(nullable=true,length=0)
    private Integer output_midclass_left_i;
    
    @Comment("中班完成量(右)")
    @Column(nullable=true,length=0)
    private Integer output_midclass_right_i;
    
    @Comment("早班完成量(左)")
    @Column(nullable=true,length=0)
    private Integer output_morclass_left_i;
    
    @Comment("早班完成量(右)")
    @Column(nullable=true,length=0)
    private Integer output_morclass_right_i;
    
    @Comment("晚班完成量(左)")
    @Column(nullable=true,length=0)
    private Integer output_nigclass_left_i;
    
    @Comment("晚班完成量(右)")
    @Column(nullable=true,length=0)
    private Integer output_nigclass_right_i;
    
    @Comment("中班计划量-左")
    @Column(nullable=true,length=0)
    private Integer planamount_mid_left_i;
    
    @Comment("中班计划量-右")
    @Column(nullable=true,length=0)
    private Integer planamount_mid_right_i;
    
    @Comment("早班计划量-左")
    @Column(nullable=true,length=0)
    private Integer planamount_mor_left_i;
    
    @Comment("早班计划量-右")
    @Column(nullable=true,length=0)
    private Integer planamount_mor_right_i;
    
    @Comment("晚班计划量-左")
    @Column(nullable=true,length=0)
    private Integer planamount_nig_left_i;
    
    @Comment("晚班计划量-右")
    @Column(nullable=true,length=0)
    private Integer planamount_nig_right_i;
    
    @Comment("月计划号")
    @Column(nullable=true,length=80)
    private String planno_month_s;
    
    @Comment("未用")
    @Column(nullable=true,length=0)
    private Integer planqty_mid_left_i;
    
    @Comment("未用")
    @Column(nullable=true,length=0)
    private Integer planqty_mid_right_i;
    
    @Comment("未用")
    @Column(nullable=true,length=0)
    private Integer planqty_mor_left_i;
    
    @Comment("未用")
    @Column(nullable=true,length=0)
    private Integer planqty_mor_right_i;
    
    @Comment("未用")
    @Column(nullable=true,length=0)
    private Integer planqty_nigclass_left_i;
    
    @Comment("未用")
    @Column(nullable=true,length=0)
    private Integer planqty_nigclass_right_i;
    
    @Comment("日计划号")
    @Column(nullable=false,length=80)
    private String plan_no_s;
    
    @Comment("日计划顺序")
    @Column(nullable=true,length=80)
    private String plan_queue_s;
    
    @Comment("工艺配方ID成型")
    @Column(nullable=true,length=80)
    private String processbom_index_build_s;
    
    @Comment("工艺配方ID硫化")
    @Column(nullable=true,length=80)
    private String processbom_index_curing_s;
    
    @Comment("成本收集器版本(左)")
    @Column(nullable=true,length=80)
    private String productionver_left_s;
    
    @Comment("成本收集器版本(右)")
    @Column(nullable=true,length=80)
    private String productionver_right_s;
    
    @Comment("胎胚品号(左)")
    @Column(nullable=true,length=80)
    private String production_bom_left_s;
    
    @Comment("胎胚品号(右)")
    @Column(nullable=true,length=80)
    private String production_bom_right_s;
    
    @Comment("计划生产日期")
    @Column(nullable=true,length=8)
    private String production_date_s;
    
    @Comment("产线条码")
    @Column(nullable=true,length=80)
    private String production_line_s;
    
    @Comment("所属产品阶段(左)")
    @Column(nullable=true,length=80)
    private String production_step_left_s;
    
    @Comment("所属产品阶段(右)")
    @Column(nullable=true,length=80)
    private String production_step_right_s;
    
    @Comment("日完成量(左)")
    @Column(nullable=true,length=0)
    private Integer qty_dayproduct_left_i;
    
    @Comment("日完成量(右)")
    @Column(nullable=true,length=0)
    private Integer qty_dayproduct_right_i;
    
    @Comment("日计划量(左)")
    @Column(nullable=true,length=0)
    private Integer quantity_dayplan_left_i;
    
    @Comment("日计划量(右)")
    @Column(nullable=true,length=0)
    private Integer quantity_dayplan_right_i;
    
    @Comment("中班原因分析(左)")
    @Column(nullable=true,length=100)
    private String reason_midclass_left_s;
    
    @Comment("中班原因分析(右)")
    @Column(nullable=true,length=100)
    private String reason_midclass_right_s;
    
    @Comment("早班原因分析(左)")
    @Column(nullable=true,length=100)
    private String reason_morclass_left_s;
    
    @Comment("早班原因分析(右)")
    @Column(nullable=true,length=100)
    private String reason_morclass_right_s;
    
    @Comment("晚班原因分析(左)")
    @Column(nullable=true,length=100)
    private String reason_nigclass_left_s;
    
    @Comment("晚班原因分析(右)")
    @Column(nullable=true,length=100)
    private String reason_nigclass_right_s;
    
    @Comment("记录标志(A可用，D删除)")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
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
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("外胎物料规格(左)")
    @Column(nullable=true,length=200)
    private String specification_left_s;
    
    @Comment("外胎物料规格(右)")
    @Column(nullable=true,length=200)
    private String specification_right_s;
    
    @Comment("计划状态 218 ")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getApproval_time_s(){
        return approval_time_s;
    }
    
    @XmlElement
    public void setApproval_time_s(String approval_time_s){
        this.approval_time_s=approval_time_s;
    }
        
    public String getApprover_s(){
        return approver_s;
    }
    
    @XmlElement
    public void setApprover_s(String approver_s){
        this.approver_s=approver_s;
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
        
    public String getChildbom_ver_left_s(){
        return childbom_ver_left_s;
    }
    
    @XmlElement
    public void setChildbom_ver_left_s(String childbom_ver_left_s){
        this.childbom_ver_left_s=childbom_ver_left_s;
    }
        
    public String getChildbom_ver_right_s(){
        return childbom_ver_right_s;
    }
    
    @XmlElement
    public void setChildbom_ver_right_s(String childbom_ver_right_s){
        this.childbom_ver_right_s=childbom_ver_right_s;
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
        
    public String getEquip_code_left_s(){
        return equip_code_left_s;
    }
    
    @XmlElement
    public void setEquip_code_left_s(String equip_code_left_s){
        this.equip_code_left_s=equip_code_left_s;
    }
        
    public String getEquip_code_right_s(){
        return equip_code_right_s;
    }
    
    @XmlElement
    public void setEquip_code_right_s(String equip_code_right_s){
        this.equip_code_right_s=equip_code_right_s;
    }
        
    public String getMaterial_code_left_s(){
        return material_code_left_s;
    }
    
    @XmlElement
    public void setMaterial_code_left_s(String material_code_left_s){
        this.material_code_left_s=material_code_left_s;
    }
        
    public String getMaterial_code_right_s(){
        return material_code_right_s;
    }
    
    @XmlElement
    public void setMaterial_code_right_s(String material_code_right_s){
        this.material_code_right_s=material_code_right_s;
    }
        
    public String getMaterial_desc_left_s(){
        return material_desc_left_s;
    }
    
    @XmlElement
    public void setMaterial_desc_left_s(String material_desc_left_s){
        this.material_desc_left_s=material_desc_left_s;
    }
        
    public String getMaterial_desc_right_s(){
        return material_desc_right_s;
    }
    
    @XmlElement
    public void setMaterial_desc_right_s(String material_desc_right_s){
        this.material_desc_right_s=material_desc_right_s;
    }
        
    public String getMaterial_name_left_s(){
        return material_name_left_s;
    }
    
    @XmlElement
    public void setMaterial_name_left_s(String material_name_left_s){
        this.material_name_left_s=material_name_left_s;
    }
        
    public String getMemo_left_s(){
        return memo_left_s;
    }
    
    @XmlElement
    public void setMemo_left_s(String memo_left_s){
        this.memo_left_s=memo_left_s;
    }
        
    public String getMemo_right_s(){
        return memo_right_s;
    }
    
    @XmlElement
    public void setMemo_right_s(String memo_right_s){
        this.memo_right_s=memo_right_s;
    }
        
    public Integer getOutput_midclass_left_i(){
        return output_midclass_left_i;
    }
    
    @XmlElement
    public void setOutput_midclass_left_i(Integer output_midclass_left_i){
        this.output_midclass_left_i=output_midclass_left_i;
    }
        
    public Integer getOutput_midclass_right_i(){
        return output_midclass_right_i;
    }
    
    @XmlElement
    public void setOutput_midclass_right_i(Integer output_midclass_right_i){
        this.output_midclass_right_i=output_midclass_right_i;
    }
        
    public Integer getOutput_morclass_left_i(){
        return output_morclass_left_i;
    }
    
    @XmlElement
    public void setOutput_morclass_left_i(Integer output_morclass_left_i){
        this.output_morclass_left_i=output_morclass_left_i;
    }
        
    public Integer getOutput_morclass_right_i(){
        return output_morclass_right_i;
    }
    
    @XmlElement
    public void setOutput_morclass_right_i(Integer output_morclass_right_i){
        this.output_morclass_right_i=output_morclass_right_i;
    }
        
    public Integer getOutput_nigclass_left_i(){
        return output_nigclass_left_i;
    }
    
    @XmlElement
    public void setOutput_nigclass_left_i(Integer output_nigclass_left_i){
        this.output_nigclass_left_i=output_nigclass_left_i;
    }
        
    public Integer getOutput_nigclass_right_i(){
        return output_nigclass_right_i;
    }
    
    @XmlElement
    public void setOutput_nigclass_right_i(Integer output_nigclass_right_i){
        this.output_nigclass_right_i=output_nigclass_right_i;
    }
        
    public Integer getPlanamount_mid_left_i(){
        return planamount_mid_left_i;
    }
    
    @XmlElement
    public void setPlanamount_mid_left_i(Integer planamount_mid_left_i){
        this.planamount_mid_left_i=planamount_mid_left_i;
    }
        
    public Integer getPlanamount_mid_right_i(){
        return planamount_mid_right_i;
    }
    
    @XmlElement
    public void setPlanamount_mid_right_i(Integer planamount_mid_right_i){
        this.planamount_mid_right_i=planamount_mid_right_i;
    }
        
    public Integer getPlanamount_mor_left_i(){
        return planamount_mor_left_i;
    }
    
    @XmlElement
    public void setPlanamount_mor_left_i(Integer planamount_mor_left_i){
        this.planamount_mor_left_i=planamount_mor_left_i;
    }
        
    public Integer getPlanamount_mor_right_i(){
        return planamount_mor_right_i;
    }
    
    @XmlElement
    public void setPlanamount_mor_right_i(Integer planamount_mor_right_i){
        this.planamount_mor_right_i=planamount_mor_right_i;
    }
        
    public Integer getPlanamount_nig_left_i(){
        return planamount_nig_left_i;
    }
    
    @XmlElement
    public void setPlanamount_nig_left_i(Integer planamount_nig_left_i){
        this.planamount_nig_left_i=planamount_nig_left_i;
    }
        
    public Integer getPlanamount_nig_right_i(){
        return planamount_nig_right_i;
    }
    
    @XmlElement
    public void setPlanamount_nig_right_i(Integer planamount_nig_right_i){
        this.planamount_nig_right_i=planamount_nig_right_i;
    }
        
    public String getPlanno_month_s(){
        return planno_month_s;
    }
    
    @XmlElement
    public void setPlanno_month_s(String planno_month_s){
        this.planno_month_s=planno_month_s;
    }
        
    public Integer getPlanqty_mid_left_i(){
        return planqty_mid_left_i;
    }
    
    @XmlElement
    public void setPlanqty_mid_left_i(Integer planqty_mid_left_i){
        this.planqty_mid_left_i=planqty_mid_left_i;
    }
        
    public Integer getPlanqty_mid_right_i(){
        return planqty_mid_right_i;
    }
    
    @XmlElement
    public void setPlanqty_mid_right_i(Integer planqty_mid_right_i){
        this.planqty_mid_right_i=planqty_mid_right_i;
    }
        
    public Integer getPlanqty_mor_left_i(){
        return planqty_mor_left_i;
    }
    
    @XmlElement
    public void setPlanqty_mor_left_i(Integer planqty_mor_left_i){
        this.planqty_mor_left_i=planqty_mor_left_i;
    }
        
    public Integer getPlanqty_mor_right_i(){
        return planqty_mor_right_i;
    }
    
    @XmlElement
    public void setPlanqty_mor_right_i(Integer planqty_mor_right_i){
        this.planqty_mor_right_i=planqty_mor_right_i;
    }
        
    public Integer getPlanqty_nigclass_left_i(){
        return planqty_nigclass_left_i;
    }
    
    @XmlElement
    public void setPlanqty_nigclass_left_i(Integer planqty_nigclass_left_i){
        this.planqty_nigclass_left_i=planqty_nigclass_left_i;
    }
        
    public Integer getPlanqty_nigclass_right_i(){
        return planqty_nigclass_right_i;
    }
    
    @XmlElement
    public void setPlanqty_nigclass_right_i(Integer planqty_nigclass_right_i){
        this.planqty_nigclass_right_i=planqty_nigclass_right_i;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getPlan_queue_s(){
        return plan_queue_s;
    }
    
    @XmlElement
    public void setPlan_queue_s(String plan_queue_s){
        this.plan_queue_s=plan_queue_s;
    }
        
    public String getProcessbom_index_build_s(){
        return processbom_index_build_s;
    }
    
    @XmlElement
    public void setProcessbom_index_build_s(String processbom_index_build_s){
        this.processbom_index_build_s=processbom_index_build_s;
    }
        
    public String getProcessbom_index_curing_s(){
        return processbom_index_curing_s;
    }
    
    @XmlElement
    public void setProcessbom_index_curing_s(String processbom_index_curing_s){
        this.processbom_index_curing_s=processbom_index_curing_s;
    }
        
    public String getProductionver_left_s(){
        return productionver_left_s;
    }
    
    @XmlElement
    public void setProductionver_left_s(String productionver_left_s){
        this.productionver_left_s=productionver_left_s;
    }
        
    public String getProductionver_right_s(){
        return productionver_right_s;
    }
    
    @XmlElement
    public void setProductionver_right_s(String productionver_right_s){
        this.productionver_right_s=productionver_right_s;
    }
        
    public String getProduction_bom_left_s(){
        return production_bom_left_s;
    }
    
    @XmlElement
    public void setProduction_bom_left_s(String production_bom_left_s){
        this.production_bom_left_s=production_bom_left_s;
    }
        
    public String getProduction_bom_right_s(){
        return production_bom_right_s;
    }
    
    @XmlElement
    public void setProduction_bom_right_s(String production_bom_right_s){
        this.production_bom_right_s=production_bom_right_s;
    }
        
    public String getProduction_date_s(){
        return production_date_s;
    }
    
    @XmlElement
    public void setProduction_date_s(String production_date_s){
        this.production_date_s=production_date_s;
    }
        
    public String getProduction_line_s(){
        return production_line_s;
    }
    
    @XmlElement
    public void setProduction_line_s(String production_line_s){
        this.production_line_s=production_line_s;
    }
        
    public String getProduction_step_left_s(){
        return production_step_left_s;
    }
    
    @XmlElement
    public void setProduction_step_left_s(String production_step_left_s){
        this.production_step_left_s=production_step_left_s;
    }
        
    public String getProduction_step_right_s(){
        return production_step_right_s;
    }
    
    @XmlElement
    public void setProduction_step_right_s(String production_step_right_s){
        this.production_step_right_s=production_step_right_s;
    }
        
    public Integer getQty_dayproduct_left_i(){
        return qty_dayproduct_left_i;
    }
    
    @XmlElement
    public void setQty_dayproduct_left_i(Integer qty_dayproduct_left_i){
        this.qty_dayproduct_left_i=qty_dayproduct_left_i;
    }
        
    public Integer getQty_dayproduct_right_i(){
        return qty_dayproduct_right_i;
    }
    
    @XmlElement
    public void setQty_dayproduct_right_i(Integer qty_dayproduct_right_i){
        this.qty_dayproduct_right_i=qty_dayproduct_right_i;
    }
        
    public Integer getQuantity_dayplan_left_i(){
        return quantity_dayplan_left_i;
    }
    
    @XmlElement
    public void setQuantity_dayplan_left_i(Integer quantity_dayplan_left_i){
        this.quantity_dayplan_left_i=quantity_dayplan_left_i;
    }
        
    public Integer getQuantity_dayplan_right_i(){
        return quantity_dayplan_right_i;
    }
    
    @XmlElement
    public void setQuantity_dayplan_right_i(Integer quantity_dayplan_right_i){
        this.quantity_dayplan_right_i=quantity_dayplan_right_i;
    }
        
    public String getReason_midclass_left_s(){
        return reason_midclass_left_s;
    }
    
    @XmlElement
    public void setReason_midclass_left_s(String reason_midclass_left_s){
        this.reason_midclass_left_s=reason_midclass_left_s;
    }
        
    public String getReason_midclass_right_s(){
        return reason_midclass_right_s;
    }
    
    @XmlElement
    public void setReason_midclass_right_s(String reason_midclass_right_s){
        this.reason_midclass_right_s=reason_midclass_right_s;
    }
        
    public String getReason_morclass_left_s(){
        return reason_morclass_left_s;
    }
    
    @XmlElement
    public void setReason_morclass_left_s(String reason_morclass_left_s){
        this.reason_morclass_left_s=reason_morclass_left_s;
    }
        
    public String getReason_morclass_right_s(){
        return reason_morclass_right_s;
    }
    
    @XmlElement
    public void setReason_morclass_right_s(String reason_morclass_right_s){
        this.reason_morclass_right_s=reason_morclass_right_s;
    }
        
    public String getReason_nigclass_left_s(){
        return reason_nigclass_left_s;
    }
    
    @XmlElement
    public void setReason_nigclass_left_s(String reason_nigclass_left_s){
        this.reason_nigclass_left_s=reason_nigclass_left_s;
    }
        
    public String getReason_nigclass_right_s(){
        return reason_nigclass_right_s;
    }
    
    @XmlElement
    public void setReason_nigclass_right_s(String reason_nigclass_right_s){
        this.reason_nigclass_right_s=reason_nigclass_right_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    public String getSpecification_left_s(){
        return specification_left_s;
    }
    
    @XmlElement
    public void setSpecification_left_s(String specification_left_s){
        this.specification_left_s=specification_left_s;
    }
        
    public String getSpecification_right_s(){
        return specification_right_s;
    }
    
    @XmlElement
    public void setSpecification_right_s(String specification_right_s){
        this.specification_right_s=specification_right_s;
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
        
    
    
    
}
