/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 硫化返修记录
 * @author 王超
 * @Date 2020-04-09 12:00:47
 */
@ATDefinition("C_QM_REPAIR_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_C_QM_REPAIR_RECORD")
public class CuringRepairRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 荆门8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("硫化结束时间")
    @Column(nullable=true,length=0)
    private Date curing_end_time_t;
    
    @Comment("硫化操作工")
    @Column(nullable=true,length=80)
    private String curing_operator_s;
    
    @Comment("硫化开始时间")
    @Column(nullable=true,length=0)
    private Date curing_start_time_t;
    
    @Comment("病象")
    @Column(nullable=true,length=80)
    private String disease_items_s;
    
    @Comment("外检操作工")
    @Column(nullable=true,length=80)
    private String external_operator_s;
    
    @Comment("外检操作时间")
    @Column(nullable=true,length=0)
    private Date external_time_t;
    
    @Comment("机台编码")
    @Column(nullable=true,length=80)
    private String machinecode_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=80)
    private String material_spec_s;
    
    @Comment("物料描述")
    @Column(nullable=true,length=80)
    private String mterial_desc_s;
    
    @Comment("修补项目")
    @Column(nullable=true,length=80)
    private String patch_content_s;
    
    @Comment("修补结果")
    @Column(nullable=true,length=80)
    private String patch_results_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("返修班次")
    @Column(nullable=true,length=80)
    private String repair_class_s;
    
    @Comment("返修班组")
    @Column(nullable=true,length=80)
    private String repair_group_s;
    
    @Comment("返修时间")
    @Column(nullable=true,length=80)
    private String repair_time_s;
    
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("轮胎条码")
    @Column(nullable=false,length=80)
    private String tyre_barcode_s;
    
    @Comment("返修工号")
    @Column(nullable=true,length=80)
    private String worker_id_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Date getCuring_end_time_t(){
        return curing_end_time_t;
    }
    
    @XmlElement
    public void setCuring_end_time_t(Date curing_end_time_t){
        this.curing_end_time_t=curing_end_time_t;
    }
        
    public String getCuring_operator_s(){
        return curing_operator_s;
    }
    
    @XmlElement
    public void setCuring_operator_s(String curing_operator_s){
        this.curing_operator_s=curing_operator_s;
    }
        
    public Date getCuring_start_time_t(){
        return curing_start_time_t;
    }
    
    @XmlElement
    public void setCuring_start_time_t(Date curing_start_time_t){
        this.curing_start_time_t=curing_start_time_t;
    }
        
    public String getDisease_items_s(){
        return disease_items_s;
    }
    
    @XmlElement
    public void setDisease_items_s(String disease_items_s){
        this.disease_items_s=disease_items_s;
    }
        
    public String getExternal_operator_s(){
        return external_operator_s;
    }
    
    @XmlElement
    public void setExternal_operator_s(String external_operator_s){
        this.external_operator_s=external_operator_s;
    }
        
    public Date getExternal_time_t(){
        return external_time_t;
    }
    
    @XmlElement
    public void setExternal_time_t(Date external_time_t){
        this.external_time_t=external_time_t;
    }
        
    public String getMachinecode_s(){
        return machinecode_s;
    }
    
    @XmlElement
    public void setMachinecode_s(String machinecode_s){
        this.machinecode_s=machinecode_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_spec_s(){
        return material_spec_s;
    }
    
    @XmlElement
    public void setMaterial_spec_s(String material_spec_s){
        this.material_spec_s=material_spec_s;
    }
        
    public String getMterial_desc_s(){
        return mterial_desc_s;
    }
    
    @XmlElement
    public void setMterial_desc_s(String mterial_desc_s){
        this.mterial_desc_s=mterial_desc_s;
    }
        
    public String getPatch_content_s(){
        return patch_content_s;
    }
    
    @XmlElement
    public void setPatch_content_s(String patch_content_s){
        this.patch_content_s=patch_content_s;
    }
        
    public String getPatch_results_s(){
        return patch_results_s;
    }
    
    @XmlElement
    public void setPatch_results_s(String patch_results_s){
        this.patch_results_s=patch_results_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRepair_class_s(){
        return repair_class_s;
    }
    
    @XmlElement
    public void setRepair_class_s(String repair_class_s){
        this.repair_class_s=repair_class_s;
    }
        
    public String getRepair_group_s(){
        return repair_group_s;
    }
    
    @XmlElement
    public void setRepair_group_s(String repair_group_s){
        this.repair_group_s=repair_group_s;
    }
        
    public String getRepair_time_s(){
        return repair_time_s;
    }
    
    @XmlElement
    public void setRepair_time_s(String repair_time_s){
        this.repair_time_s=repair_time_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyre_barcode_s(){
        return tyre_barcode_s;
    }
    
    @XmlElement
    public void setTyre_barcode_s(String tyre_barcode_s){
        this.tyre_barcode_s=tyre_barcode_s;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }
        
    
    
    
}
