/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.annotations.Comment;

/**
 * 硫化换模计划表
 * @author 李彦
 * @Date 2018-08-07 13:21:53
 */
@Entity
@XmlRootElement
@Table(name="AT_C_PP_MoldChangePlan")
@ATDefinition("C_PP_MoldChangePlan")
public class MoldChangePlan extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("换模班次")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("机台编码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("完成时间")
    @Column(nullable=true,length=0)
    private Date excute_time_t;
    
    @Comment("执行情况")
    @Column(nullable=true,length=80)
    private String executive_s;
    
    @Comment("花纹(左模)")
    @Column(nullable=true,length=100)
    private String flowercode_left_s;
    
    @Comment("右模花纹")
    @Column(nullable=true,length=100)
    private String flowercode_right_s;
    
    @Comment("是否温模")
    @Column(nullable=true,length=80)
    private String heat_mold_s;
    
    @Comment("物料编码(左模)")
    @Column(nullable=true,length=160)
    private String material_code_left_s;
    
    @Comment("右模物料编码")
    @Column(nullable=true,length=160)
    private String material_code_right_s;
    
    @Comment("物料名称(左模)")
    @Column(nullable=true,length=160)
    private String material_name_left_s;
    
    @Comment("右模物料名称")
    @Column(nullable=true,length=160)
    private String material_name_right_s;
    
    @Comment("模具分类")
    @Column(nullable=true,length=80)
    private String modle_sort_s;
    
    @Comment("右模模具条码")
    @Column(nullable=true,length=80)
    private String moldbarcode_right_s;
    
    @Comment("模具条码 （左模）")
    @Column(nullable=true,length=80)
    private String mold_barcode_left_s;
    
    @Comment("换模日期")
    @Column(nullable=true,length=80)
    private String mold_changetime_s;
    
    @Comment("备模确认时间")
    @Column(nullable=true,length=0)
    private Date mold_conf_time_t;
    
    @Comment("备模确认人")
    @Column(nullable=true,length=80)
    private String mold_conf_worker_s;
    
    @Comment("旧右模模具条码")
    @Column(nullable=true,length=80)
    private String old_moldbarcode_right_s;
    
    @Comment("旧模具条码 （左模）")
    @Column(nullable=true,length=80)
    private String old_mold_barcode_s;
    
    @Comment("计划编号")
    @Column(nullable=true,length=80)
    private String planno_changemold_s;
    
    @Comment("计划数量控制  0：否 1：是  根据编制的换模计划时间启用控制，执行后释放控制0")
    @Column(nullable=false,length=80)
    private String plannum_control_s;
    
    @Comment("硫化生产计划.PLAN_NO")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("计划状态")
    @Column(nullable=true,length=80)
    private String plan_status_s;
    
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
    
    @Comment("规格(左模)")
    @Column(nullable=true,length=100)
    private String speccode_left_s;
    
    @Comment("右模规格")
    @Column(nullable=true,length=100)
    private String speccode_right_s;
    
    @Comment("备模状态 已备模、待备模")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    public MoldChangePlan(){
    	this.agenc_no_s=LLConstant.JING_MEN_CODE;
    	this.record_flag_s="A";
    }
    
    public MoldChangePlan(String factory){
    	this.s_factory_s=factory;
    	this.agenc_no_s=LLConstant.JING_MEN_CODE;
    	this.record_flag_s="A";
    }
    
    public MoldChangePlan(String factory,String createdByUser,Date createdTime){
    	this.s_factory_s=factory;
    	this.agenc_no_s=LLConstant.JING_MEN_CODE;
    	this.record_flag_s="A";
    	this.created_by_s=createdByUser;
    	this.created_time_t=createdTime;
    }
     
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
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
        
     
    public Date getExcute_time_t(){
        return excute_time_t;
    }
    
    @XmlElement
    public void setExcute_begintime_t(Date excute_time_t){
        this.excute_time_t=excute_time_t;
    }
        
     
    public String getExecutive_s(){
        return executive_s;
    }
    
    @XmlElement
    public void setExecutive_s(String executive_s){
        this.executive_s=executive_s;
    }
        
     
    public String getFlowercode_left_s(){
        return flowercode_left_s;
    }
    
    @XmlElement
    public void setFlowercode_left_s(String flowercode_left_s){
        this.flowercode_left_s=flowercode_left_s;
    }
        
     
    public String getFlowercode_right_s(){
        return flowercode_right_s;
    }
    
    @XmlElement
    public void setFlowercode_right_s(String flowercode_right_s){
        this.flowercode_right_s=flowercode_right_s;
    }
        
     
    public String getHeat_mold_s(){
        return heat_mold_s;
    }
    
    @XmlElement
    public void setHeat_mold_s(String heat_mold_s){
        this.heat_mold_s=heat_mold_s;
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
        
     
    public String getMaterial_name_left_s(){
        return material_name_left_s;
    }
    
    @XmlElement
    public void setMaterial_name_left_s(String material_name_left_s){
        this.material_name_left_s=material_name_left_s;
    }
        
     
    public String getMaterial_name_right_s(){
        return material_name_right_s;
    }
    
    @XmlElement
    public void setMaterial_name_right_s(String material_name_right_s){
        this.material_name_right_s=material_name_right_s;
    }
        
     
    public String getModle_sort_s(){
        return modle_sort_s;
    }
    
    @XmlElement
    public void setModle_sort_s(String modle_sort_s){
        this.modle_sort_s=modle_sort_s;
    }
        
     
    public String getMoldbarcode_right_s(){
        return moldbarcode_right_s;
    }
    
    @XmlElement
    public void setMoldbarcode_right_s(String moldbarcode_right_s){
        this.moldbarcode_right_s=moldbarcode_right_s;
    }
        
     
    public String getMold_barcode_left_s(){
        return mold_barcode_left_s;
    }
    
    @XmlElement
    public void setMold_barcode_left_s(String mold_barcode_left_s){
        this.mold_barcode_left_s=mold_barcode_left_s;
    }
        
     
    public String getMold_changetime_s(){
        return mold_changetime_s;
    }
    
    @XmlElement
    public void setMold_changetime_s(String mold_changetime_s){
        this.mold_changetime_s=mold_changetime_s;
    }
        
     
    public Date getMold_conf_time_t(){
        return mold_conf_time_t;
    }
    
    @XmlElement
    public void setMold_conf_time_t(Date mold_conf_time_t){
        this.mold_conf_time_t=mold_conf_time_t;
    }
        
     
    public String getMold_conf_worker_s(){
        return mold_conf_worker_s;
    }
    
    @XmlElement
    public void setMold_conf_worker_s(String mold_conf_worker_s){
        this.mold_conf_worker_s=mold_conf_worker_s;
    }
        
     
    public String getOld_moldbarcode_right_s(){
        return old_moldbarcode_right_s;
    }
    
    @XmlElement
    public void setOld_moldbarcode_right_s(String old_moldbarcode_right_s){
        this.old_moldbarcode_right_s=old_moldbarcode_right_s;
    }
        
     
    public String getOld_mold_barcode_s(){
        return old_mold_barcode_s;
    }
    
    @XmlElement
    public void setOld_mold_barcode_s(String old_mold_barcode_s){
        this.old_mold_barcode_s=old_mold_barcode_s;
    }
        
     
    public String getPlanno_changemold_s(){
        return planno_changemold_s;
    }
    
    @XmlElement
    public void setPlanno_changemold_s(String planno_changemold_s){
        this.planno_changemold_s=planno_changemold_s;
    }
        
     
    public String getPlannum_control_s(){
        return plannum_control_s;
    }
    
    @XmlElement
    public void setPlannum_control_s(String plannum_control_s){
        this.plannum_control_s=plannum_control_s;
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
        
     
    public String getSpeccode_left_s(){
        return speccode_left_s;
    }
    
    @XmlElement
    public void setSpeccode_left_s(String speccode_left_s){
        this.speccode_left_s=speccode_left_s;
    }
        
     
    public String getSpeccode_right_s(){
        return speccode_right_s;
    }
    
    @XmlElement
    public void setSpeccode_right_s(String speccode_right_s){
        this.speccode_right_s=speccode_right_s;
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
