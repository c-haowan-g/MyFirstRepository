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
 * 模具报备履历
 * @author 时永良
 * @Date 2019-07-22 11:56:29
 */
@ATDefinition("C_MM_MoldRecord")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_MOLDRECORD")
public class MoldRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("确认人")
    @Column(nullable=true,length=100)
    private String assembled_people_s;
    
    @Comment("确认时间")
    @Column(nullable=true,length=0)
    private Date assembly_time_t;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("换模计划号")
    @Column(nullable=true,length=80)
    private String chmode_plan_no_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("右模具花纹")
    @Column(nullable=true,length=80)
    private String flowerpatter_right_s;
    
    @Comment("左模具花纹")
    @Column(nullable=true,length=100)
    private String flower_pattern_left_s;
    
    @Comment("左模物料")
    @Column(nullable=true,length=160)
    private String material_code_left_s;
    
    @Comment("右模物料")
    @Column(nullable=true,length=160)
    private String material_code_right_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String memo_s;
    
    @Comment("左模具编号")
    @Column(nullable=true,length=80)
    private String mold_code_left_s;
    
    @Comment("右模具编号")
    @Column(nullable=true,length=80)
    private String mold_code_right_s;
    
    @Comment("右模具名称")
    @Column(nullable=true,length=80)
    private String mold_desc_right_s;
    
    @Comment("左模具名称")
    @Column(nullable=true,length=200)
    private String mold_desc_s;
    
    @Comment("左模具规格")
    @Column(nullable=true,length=200)
    private String mold_spec_left_s;
    
    @Comment("右模具规格")
    @Column(nullable=true,length=80)
    private String mold_spec_right_s;
    
    @Comment("操作类型")
    @Column(nullable=true,length=80)
    private String optype_s;
    
    @Comment("左层级")
    @Column(nullable=true,length=80)
    private String ply_left_s;
    
    @Comment("右层级")
    @Column(nullable=true,length=160)
    private String ply_right_s;
    
    @Comment("记录标志,A可用，D删除")
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
    
    @Comment("计划状态(已备模，待备模)")
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
        
    public String getAssembled_people_s(){
        return assembled_people_s;
    }
    
    @XmlElement
    public void setAssembled_people_s(String assembled_people_s){
        this.assembled_people_s=assembled_people_s;
    }
        
    public Date getAssembly_time_t(){
        return assembly_time_t;
    }
    
    @XmlElement
    public void setAssembly_time_t(Date assembly_time_t){
        this.assembly_time_t=assembly_time_t;
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
        
    public String getChmode_plan_no_s(){
        return chmode_plan_no_s;
    }
    
    @XmlElement
    public void setChmode_plan_no_s(String chmode_plan_no_s){
        this.chmode_plan_no_s=chmode_plan_no_s;
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
        
    public String getFlowerpatter_right_s(){
        return flowerpatter_right_s;
    }
    
    @XmlElement
    public void setFlowerpatter_right_s(String flowerpatter_right_s){
        this.flowerpatter_right_s=flowerpatter_right_s;
    }
        
    public String getFlower_pattern_left_s(){
        return flower_pattern_left_s;
    }
    
    @XmlElement
    public void setFlower_pattern_left_s(String flower_pattern_left_s){
        this.flower_pattern_left_s=flower_pattern_left_s;
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
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getMold_code_left_s(){
        return mold_code_left_s;
    }
    
    @XmlElement
    public void setMold_code_left_s(String mold_code_left_s){
        this.mold_code_left_s=mold_code_left_s;
    }
        
    public String getMold_code_right_s(){
        return mold_code_right_s;
    }
    
    @XmlElement
    public void setMold_code_right_s(String mold_code_right_s){
        this.mold_code_right_s=mold_code_right_s;
    }
        
    public String getMold_desc_right_s(){
        return mold_desc_right_s;
    }
    
    @XmlElement
    public void setMold_desc_right_s(String mold_desc_right_s){
        this.mold_desc_right_s=mold_desc_right_s;
    }
        
    public String getMold_desc_s(){
        return mold_desc_s;
    }
    
    @XmlElement
    public void setMold_desc_s(String mold_desc_s){
        this.mold_desc_s=mold_desc_s;
    }
        
    public String getMold_spec_left_s(){
        return mold_spec_left_s;
    }
    
    @XmlElement
    public void setMold_spec_left_s(String mold_spec_left_s){
        this.mold_spec_left_s=mold_spec_left_s;
    }
        
    public String getMold_spec_right_s(){
        return mold_spec_right_s;
    }
    
    @XmlElement
    public void setMold_spec_right_s(String mold_spec_right_s){
        this.mold_spec_right_s=mold_spec_right_s;
    }
        
    public String getOptype_s(){
        return optype_s;
    }
    
    @XmlElement
    public void setOptype_s(String optype_s){
        this.optype_s=optype_s;
    }
        
    public String getPly_left_s(){
        return ply_left_s;
    }
    
    @XmlElement
    public void setPly_left_s(String ply_left_s){
        this.ply_left_s=ply_left_s;
    }
        
    public String getPly_right_s(){
        return ply_right_s;
    }
    
    @XmlElement
    public void setPly_right_s(String ply_right_s){
        this.ply_right_s=ply_right_s;
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
