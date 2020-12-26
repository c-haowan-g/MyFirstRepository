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
 * 投料扫描及校验表
 * @author 司乔靖
 * @Date 2019-02-16 08:53:13
 */
@ATDefinition("B_MM_FEEDINGCHECK_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_B_MM_FEEDINGCHECK_RECORD")
public class FeedingCheck_Record extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("批次/条码")
    @Column(nullable=true,length=80)
    private String batchno_s;
    
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
    
    @Comment("错误原因")
    @Column(nullable=true,length=80)
    private String error_s;
    
    @Comment("投料口编码")
    @Column(nullable=true,length=80)
    private String feeding_code_s;
    
    @Comment("投料口名称")
    @Column(nullable=true,length=80)
    private String feeding_name_s;
    
    @Comment("防错结果")
    @Column(nullable=true,length=80)
    private String feeding_result_s;
    
    @Comment("工装ID")
    @Column(nullable=true,length=80)
    private String frock_id_s;
    
    @Comment("投料时间")
    @Column(nullable=true,length=0)
    private Date in_time_t;
    
    @Comment("物料编码(SAP品号)")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String material_name_s;
    
    @Comment("物料类型")
    @Column(nullable=true,length=80)
    private String material_type_s;
    
    @Comment("移出时间")
    @Column(nullable=true,length=0)
    private Date out_time_t;
    
    @Comment("胎胚日计划号")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("队列ID")
    @Column(nullable=true,length=80)
    private String queue_id_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("工装RFID条码")
    @Column(nullable=true,length=80)
    private String rfid_code_s;
    
    @Comment("扫描类型")
    @Column(nullable=true,length=80)
    private String scan_type_s;
    
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
    
    @Comment("投料状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("同步类型")
    @Column(nullable=true,length=80)
    private String sync_type_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("胎胚物料编码")
    @Column(nullable=true,length=80)
    private String tire_material_code_s;
    
    @Comment("操作工名称")
    @Column(nullable=true,length=80)
    private String worker_id_s;
    
    @Comment("操作工编码")
    @Column(nullable=true,length=80)
    private String worker_name_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBatchno_s(){
        return batchno_s;
    }
    
    @XmlElement
    public void setBatchno_s(String batchno_s){
        this.batchno_s=batchno_s;
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
        
    public String getError_s(){
        return error_s;
    }
    
    @XmlElement
    public void setError_s(String error_s){
        this.error_s=error_s;
    }
        
    public String getFeeding_code_s(){
        return feeding_code_s;
    }
    
    @XmlElement
    public void setFeeding_code_s(String feeding_code_s){
        this.feeding_code_s=feeding_code_s;
    }
        
    public String getFeeding_name_s(){
        return feeding_name_s;
    }
    
    @XmlElement
    public void setFeeding_name_s(String feeding_name_s){
        this.feeding_name_s=feeding_name_s;
    }
        
    public String getFeeding_result_s(){
        return feeding_result_s;
    }
    
    @XmlElement
    public void setFeeding_result_s(String feeding_result_s){
        this.feeding_result_s=feeding_result_s;
    }
        
    public String getFrock_id_s(){
        return frock_id_s;
    }
    
    @XmlElement
    public void setFrock_id_s(String frock_id_s){
        this.frock_id_s=frock_id_s;
    }
        
    public Date getIn_time_t(){
        return in_time_t;
    }
    
    @XmlElement
    public void setIn_time_t(Date in_time_t){
        this.in_time_t=in_time_t;
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
        
    public String getMaterial_type_s(){
        return material_type_s;
    }
    
    @XmlElement
    public void setMaterial_type_s(String material_type_s){
        this.material_type_s=material_type_s;
    }
        
    public Date getOut_time_t(){
        return out_time_t;
    }
    
    @XmlElement
    public void setOut_time_t(Date out_time_t){
        this.out_time_t=out_time_t;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getQueue_id_s(){
        return queue_id_s;
    }
    
    @XmlElement
    public void setQueue_id_s(String queue_id_s){
        this.queue_id_s=queue_id_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRfid_code_s(){
        return rfid_code_s;
    }
    
    @XmlElement
    public void setRfid_code_s(String rfid_code_s){
        this.rfid_code_s=rfid_code_s;
    }
        
    public String getScan_type_s(){
        return scan_type_s;
    }
    
    @XmlElement
    public void setScan_type_s(String scan_type_s){
        this.scan_type_s=scan_type_s;
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
        
    public String getSync_type_s(){
        return sync_type_s;
    }
    
    @XmlElement
    public void setSync_type_s(String sync_type_s){
        this.sync_type_s=sync_type_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTire_material_code_s(){
        return tire_material_code_s;
    }
    
    @XmlElement
    public void setTire_material_code_s(String tire_material_code_s){
        this.tire_material_code_s=tire_material_code_s;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }
        
    public String getWorker_name_s(){
        return worker_name_s;
    }
    
    @XmlElement
    public void setWorker_name_s(String worker_name_s){
        this.worker_name_s=worker_name_s;
    }
        
    
    
    
}
