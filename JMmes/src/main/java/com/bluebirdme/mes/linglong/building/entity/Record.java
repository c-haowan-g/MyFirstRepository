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
 * 质量检测履历
 * @author 司乔靖
 * @Date 2019-03-28 09:56:27
 */
@ATDefinition("B_QM_QUALITYCHECK_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_B_QM_QUALITYCHECK_RECORD")
public class Record extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("换规首条确认标记")
    @Column(nullable=true,length=80)
    private String aqhm_flag_s;
    
    @Comment("轮胎类型区分：")
    @Column(nullable=true,length=80)
    private String attribute_s;
    
    @Comment("缺陷代码1")
    @Column(nullable=true,length=80)
    private String cause_code1_s;
    
    @Comment("缺陷代码2")
    @Column(nullable=true,length=80)
    private String cause_code2_s;
    
    @Comment("缺陷代码3")
    @Column(nullable=true,length=80)
    private String cause_code3_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("检验点")
    @Column(nullable=true,length=80)
    private String check_point_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("班组")
    @Column(nullable=true,length=80)
    private String group_code_s;
    
    @Comment("是否复检：0未复检、1已复检过")
    @Column(nullable=true,length=80)
    private String is_rck_s;
    
    @Comment("生产机台")
    @Column(nullable=true,length=80)
    private String machine_code_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料描述")
    @Column(nullable=true,length=80)
    private String material_desc_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=80)
    private String material_spec_s;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date oper_time_t;
    
    @Comment("当前工序")
    @Column(nullable=true,length=80)
    private String proess_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("班次")
    @Column(nullable=true,length=80)
    private String shift_code_s;
    
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
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=80)
    private String tyre_barcode_s;
    
    @Comment("轮胎判定结果编码")
    @Column(nullable=true,length=80)
    private String tyre_status_code_s;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String worker_id_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAqhm_flag_s(){
        return aqhm_flag_s;
    }
    
    @XmlElement
    public void setAqhm_flag_s(String aqhm_flag_s){
        this.aqhm_flag_s=aqhm_flag_s;
    }
        
    public String getAttribute_s(){
        return attribute_s;
    }
    
    @XmlElement
    public void setAttribute_s(String attribute_s){
        this.attribute_s=attribute_s;
    }
        
    public String getCause_code1_s(){
        return cause_code1_s;
    }
    
    @XmlElement
    public void setCause_code1_s(String cause_code1_s){
        this.cause_code1_s=cause_code1_s;
    }
        
    public String getCause_code2_s(){
        return cause_code2_s;
    }
    
    @XmlElement
    public void setCause_code2_s(String cause_code2_s){
        this.cause_code2_s=cause_code2_s;
    }
        
    public String getCause_code3_s(){
        return cause_code3_s;
    }
    
    @XmlElement
    public void setCause_code3_s(String cause_code3_s){
        this.cause_code3_s=cause_code3_s;
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
        
    public String getCheck_point_s(){
        return check_point_s;
    }
    
    @XmlElement
    public void setCheck_point_s(String check_point_s){
        this.check_point_s=check_point_s;
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
        
    public String getGroup_code_s(){
        return group_code_s;
    }
    
    @XmlElement
    public void setGroup_code_s(String group_code_s){
        this.group_code_s=group_code_s;
    }
        
    public String getIs_rck_s(){
        return is_rck_s;
    }
    
    @XmlElement
    public void setIs_rck_s(String is_rck_s){
        this.is_rck_s=is_rck_s;
    }
        
    public String getMachine_code_s(){
        return machine_code_s;
    }
    
    @XmlElement
    public void setMachine_code_s(String machine_code_s){
        this.machine_code_s=machine_code_s;
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
        
    public String getMaterial_spec_s(){
        return material_spec_s;
    }
    
    @XmlElement
    public void setMaterial_spec_s(String material_spec_s){
        this.material_spec_s=material_spec_s;
    }
        
    public Date getOper_time_t(){
        return oper_time_t;
    }
    
    @XmlElement
    public void setOper_time_t(Date oper_time_t){
        this.oper_time_t=oper_time_t;
    }
        
    public String getProess_s(){
        return proess_s;
    }
    
    @XmlElement
    public void setProess_s(String proess_s){
        this.proess_s=proess_s;
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
        
    public String getTyre_barcode_s(){
        return tyre_barcode_s;
    }
    
    @XmlElement
    public void setTyre_barcode_s(String tyre_barcode_s){
        this.tyre_barcode_s=tyre_barcode_s;
    }
        
    public String getTyre_status_code_s(){
        return tyre_status_code_s;
    }
    
    @XmlElement
    public void setTyre_status_code_s(String tyre_status_code_s){
        this.tyre_status_code_s=tyre_status_code_s;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }
        
    
    
    
}
