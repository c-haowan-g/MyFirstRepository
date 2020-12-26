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
 * 换工装计划表
 * @author 兰颖慧
 * @Date 2019-03-14 16:12:08
 */
@ATDefinition("B_PP_ChangeMould")
@Entity
@XmlRootElement
@Table(name="AT_B_PP_CHANGEMOULD")
public class ChangeMould extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
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
    
    @Comment("换工装日期")
    @Column(nullable=false,length=80)
    private String changetime_s;
    
    @Comment("换工装班次")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("机台编码 ")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("执行开始时间")
    @Column(nullable=true,length=0)
    private Date excute_begintime_t;
    
    @Comment("执行结束时间")
    @Column(nullable=true,length=0)
    private Date excute_time_t;
    
    @Comment("胎胚物料编码（SAP品号）")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String material_name_s;
    
    @Comment("胎胚规格")
    @Column(nullable=true,length=80)
    private String material_spec_s;
    
    @Comment("换工装计划编号")
    @Column(nullable=false,length=80)
    private String plan_no_s;
    
    @Comment("换工装计划状态")
    @Column(nullable=true,length=80)
    private String plan_status_s;
    
    @Comment("成型日计划号")
    @Column(nullable=false,length=80)
    private String production_plan_no_s;
    
    @Comment("记录标志，A可用，D删除")
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("顺序号")
    @Column(nullable=true,length=80)
    private String plan_queue_s;
    
    public String getPlan_queue_s() {
		return plan_queue_s;
	}

	public void setPlan_queue_s(String plan_queue_s) {
		this.plan_queue_s = plan_queue_s;
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
        
    public String getChangetime_s(){
        return changetime_s;
    }
    
    @XmlElement
    public void setChangetime_s(String changetime_s){
        this.changetime_s=changetime_s;
    }
        
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
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
        
    public Date getExcute_begintime_t(){
        return excute_begintime_t;
    }
    
    @XmlElement
    public void setExcute_begintime_t(Date excute_begintime_t){
        this.excute_begintime_t=excute_begintime_t;
    }
        
    public Date getExcute_time_t(){
        return excute_time_t;
    }
    
    @XmlElement
    public void setExcute_time_t(Date excute_time_t){
        this.excute_time_t=excute_time_t;
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
        
    public String getMaterial_spec_s(){
        return material_spec_s;
    }
    
    @XmlElement
    public void setMaterial_spec_s(String material_spec_s){
        this.material_spec_s=material_spec_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getPlan_status_s(){
        return plan_status_s;
    }
    
    @XmlElement
    public void setPlan_status_s(String plan_status_s){
        this.plan_status_s=plan_status_s;
    }
        
    public String getProduction_plan_no_s(){
        return production_plan_no_s;
    }
    
    @XmlElement
    public void setProduction_plan_no_s(String production_plan_no_s){
        this.production_plan_no_s=production_plan_no_s;
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
