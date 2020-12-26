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
 * 成型班次计划表
 * @author 王海霖
 * @Date 2019-08-06 08:17:31
 */
@ATDefinition("B_PP_ClassPlan")
@Entity
@XmlRootElement
@Table(name="AT_B_PP_ClassPlan")
public class ClassPlan extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("操作副手工号")
    @Column(nullable=true,length=80)
    private String assistantworker_id_s;
    
    @Comment("操作副手姓名")
    @Column(nullable=true,length=80)
    private String assistantworker_name_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("生产班次")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("关闭原因")
    @Column(nullable=true,length=80)
    private String close_reason_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("结束时间")
    @Column(nullable=true,length=0)
    private Date end_time_t;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("机台类型")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    @Comment("生产班组")
    @Column(nullable=true,length=80)
    private String group_s;
    
    @Comment("操作主手工号")
    @Column(nullable=true,length=80)
    private String mainworker_id_s;
    
    @Comment("操作主手姓名")
    @Column(nullable=true,length=80)
    private String mainworker_name_s;
    
    @Comment("胎胚物料编码（SAP品号）")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("胎胚物料名称")
    @Column(nullable=true,length=80)
    private String material_desc_s;
    
    @Comment("班次计划号")
    @Column(nullable=true,length=80)
    private String order_code_s;
    
    @Comment("班次计划顺序")
    @Column(nullable=true,length=0)
    private Integer order_queue_i;
    
    @Comment("日计划号")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("工艺配方索引")
    @Column(nullable=true,length=80)
    private String processbom_index_s;
    
    @Comment("执行日期")
    @Column(nullable=true,length=80)
    private String production_date_s;
    
    @Comment("产品阶段")
    @Column(nullable=true,length=80)
    private String production_step_s;
    
    @Comment("计划数量")
    @Column(nullable=true,length=0)
    private Integer quantity_order_i;
    
    @Comment("实际数量")
    @Column(nullable=true,length=0)
    private Integer quantity_real_i;
    
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
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("开始时间")
    @Column(nullable=true,length=0)
    private Date start_time_t;
    
    @Comment("计划状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("胎胚版本号")
    @Column(nullable=true,length=80)
    private String version_s;
    
    @Comment("操作三手工号")
    @Column(nullable=true,length=80)
    private String worker3_id_s;
    
    @Comment("操作三手姓名")
    @Column(nullable=true,length=80)
    private String worker3_name_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAssistantworker_id_s(){
        return assistantworker_id_s;
    }
    
    @XmlElement
    public void setAssistantworker_id_s(String assistantworker_id_s){
        this.assistantworker_id_s=assistantworker_id_s;
    }
        
    public String getAssistantworker_name_s(){
        return assistantworker_name_s;
    }
    
    @XmlElement
    public void setAssistantworker_name_s(String assistantworker_name_s){
        this.assistantworker_name_s=assistantworker_name_s;
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
        
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
    }
        
    public String getClose_reason_s(){
        return close_reason_s;
    }
    
    @XmlElement
    public void setClose_reason_s(String close_reason_s){
        this.close_reason_s=close_reason_s;
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
        
    public Date getEnd_time_t(){
        return end_time_t;
    }
    
    @XmlElement
    public void setEnd_time_t(Date end_time_t){
        this.end_time_t=end_time_t;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_type_s(){
        return equip_type_s;
    }
    
    @XmlElement
    public void setEquip_type_s(String equip_type_s){
        this.equip_type_s=equip_type_s;
    }
        
    public String getGroup_s(){
        return group_s;
    }
    
    @XmlElement
    public void setGroup_s(String group_s){
        this.group_s=group_s;
    }
        
    public String getMainworker_id_s(){
        return mainworker_id_s;
    }
    
    @XmlElement
    public void setMainworker_id_s(String mainworker_id_s){
        this.mainworker_id_s=mainworker_id_s;
    }
        
    public String getMainworker_name_s(){
        return mainworker_name_s;
    }
    
    @XmlElement
    public void setMainworker_name_s(String mainworker_name_s){
        this.mainworker_name_s=mainworker_name_s;
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
        
    public String getOrder_code_s(){
        return order_code_s;
    }
    
    @XmlElement
    public void setOrder_code_s(String order_code_s){
        this.order_code_s=order_code_s;
    }
        
    public Integer getOrder_queue_i(){
        return order_queue_i;
    }
    
    @XmlElement
    public void setOrder_queue_i(Integer order_queue_i){
        this.order_queue_i=order_queue_i;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProcessbom_index_s(){
        return processbom_index_s;
    }
    
    @XmlElement
    public void setProcessbom_index_s(String processbom_index_s){
        this.processbom_index_s=processbom_index_s;
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
        
    public Integer getQuantity_order_i(){
        return quantity_order_i;
    }
    
    @XmlElement
    public void setQuantity_order_i(Integer quantity_order_i){
        this.quantity_order_i=quantity_order_i;
    }
        
    public Integer getQuantity_real_i(){
        return quantity_real_i;
    }
    
    @XmlElement
    public void setQuantity_real_i(Integer quantity_real_i){
        this.quantity_real_i=quantity_real_i;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public Date getStart_time_t(){
        return start_time_t;
    }
    
    @XmlElement
    public void setStart_time_t(Date start_time_t){
        this.start_time_t=start_time_t;
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
        
    public String getWorker3_id_s(){
        return worker3_id_s;
    }
    
    @XmlElement
    public void setWorker3_id_s(String worker3_id_s){
        this.worker3_id_s=worker3_id_s;
    }
        
    public String getWorker3_name_s(){
        return worker3_name_s;
    }
    
    @XmlElement
    public void setWorker3_name_s(String worker3_name_s){
        this.worker3_name_s=worker3_name_s;
    }
        
    
    
    
}
