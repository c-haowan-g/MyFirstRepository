/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 机台配置状态信息表
 * @author 兰颖慧
 * @Date 2019-05-10 09:04:17
 */
@ATDefinition("CM_EM_EquipmentStatus")
@Entity
@XmlRootElement
@Table(name="AT_CM_EM_EQUIPMENTSTATUS")
public class HalfpartEquipmentStatus extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("正向投料称重起始重量")
    @Column(nullable=true,length=0)
    private Integer beginweight_i;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String changeby_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date changetime_t;
    
    @Comment("物料大类  物料大类113")
    @Column(nullable=true,length=80)
    private String configclass_s;
    
    @Comment("投料校验结果")
    @Column(nullable=true,length=80)
    private String configresult_s;
    
    @Comment("是否启用校验 0 否 1 是")
    @Column(nullable=true,length=80)
    private String configstatus_s;
    
    @Comment("消耗数量")
    @Column(nullable=true,length=0)
    private String consumequantity_f;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("当前物料条码（RFID条码）")
    @Column(nullable=true,length=80)
    private String current_barcode_s;
    
    @Comment("当前物料批次条码")
    @Column(nullable=true,length=80)
    private String current_batch_code_s;
    
    @Comment("当前物料编码")
    @Column(nullable=true,length=80)
    private String current_material_code_s;
    
    @Comment("更换载具差值")
    @Column(nullable=true,length=0)
    private Integer differentvalue_i;
    
    @Comment("正向投料称重结束重量")
    @Column(nullable=true,length=0)
    private Integer endweight_i;
    
    @Comment("子设备编码")
    @Column(nullable=true,length=80)
    private String equipmentcode_s;
    
    @Comment("机台配置信息条码")
    @Column(nullable=false,length=80)
    private String equipmentconfigcode_s;
    
    @Comment("子设备名称")
    @Column(nullable=true,length=80)
    private String equipmentname_s;
    
    @Comment("机台配置状态条码")
    @Column(nullable=false,length=80)
    private String equipmentstatuscode_s;
    
    @Comment("特殊选择")
    @Column(nullable=true,length=80)
    private String equipspecialselect_s;
    
    @Comment("子设备类型（基础数据115）")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    @Comment("设备IP")
    @Column(nullable=true,length=80)
    private String ip_address_s;
    
    @Comment("上一个工装条码")
    @Column(nullable=true,length=80)
    private String last_barcode_s;
    
    @Comment("上一个物料批次条码")
    @Column(nullable=true,length=80)
    private String last_batch_code_s;
    
    @Comment("上一个物料编码")
    @Column(nullable=true,length=80)
    private String last_material_code_s;
    
    @Comment("剩余数量")
    @Column(nullable=true,length=0)
    private String leavequantity_f;
    
    @Comment("当前物料名称")
    @Column(nullable=true,length=80)
    private String materialname_s;
    
    @Comment("产出口分组(A-B)")
    @Column(nullable=true,length=80)
    private String outputgroup_s;
    
    @Comment("完成量")
    @Column(nullable=true,length=0)
    private Long outquantity_i;
    
    @Comment("投料口要料百分比")
    @Column(nullable=true,length=0)
    private String percent_f;
    
    @Comment("当前计划号 工单号")
    @Column(nullable=true,length=80)
    private String planno_s;
    
    @Comment("计划量 工单计划量")
    @Column(nullable=true,length=0)
    private Integer planquantity_i;
    
    @Comment("物料版本")
    @Column(nullable=true,length=80)
    private String productiongver_s;
    
    @Comment("产线编码(父设备)")
    @Column(nullable=true,length=80)
    private String productionline_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String remark_s;
    
    @Comment("RFID设备天线编码")
    @Column(nullable=true,length=80)
    private String rfid_antenna_code_s;
    
    @Comment("SAP物料组 基础数据308 外部系统301开头的")
    @Column(nullable=true,length=80)
    private String sapm_group_s;
    
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
    
    @Comment("设备状态 0不正常 1 正常")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("钢丝投料切换信号 A B")
    @Column(nullable=true,length=80)
    private String steelflag_s;
    
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
        
    public Integer getBeginweight_i(){
        return beginweight_i;
    }
    
    @XmlElement
    public void setBeginweight_i(Integer beginweight_i){
        this.beginweight_i=beginweight_i;
    }
        
    public String getChangeby_s(){
        return changeby_s;
    }
    
    @XmlElement
    public void setChangeby_s(String changeby_s){
        this.changeby_s=changeby_s;
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
        
    public Date getChangetime_t(){
        return changetime_t;
    }
    
    @XmlElement
    public void setChangetime_t(Date changetime_t){
        this.changetime_t=changetime_t;
    }
        
    public String getConfigclass_s(){
        return configclass_s;
    }
    
    @XmlElement
    public void setConfigclass_s(String configclass_s){
        this.configclass_s=configclass_s;
    }
        
    public String getConfigresult_s(){
        return configresult_s;
    }
    
    @XmlElement
    public void setConfigresult_s(String configresult_s){
        this.configresult_s=configresult_s;
    }
        
    public String getConfigstatus_s(){
        return configstatus_s;
    }
    
    @XmlElement
    public void setConfigstatus_s(String configstatus_s){
        this.configstatus_s=configstatus_s;
    }
        
    public String getConsumequantity_f(){
        return consumequantity_f;
    }
    
    @XmlElement
    public void setConsumequantity_f(String consumequantity_f){
        this.consumequantity_f=consumequantity_f;
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
        
    public String getCurrent_barcode_s(){
        return current_barcode_s;
    }
    
    @XmlElement
    public void setCurrent_barcode_s(String current_barcode_s){
        this.current_barcode_s=current_barcode_s;
    }
        
    public String getCurrent_batch_code_s(){
        return current_batch_code_s;
    }
    
    @XmlElement
    public void setCurrent_batch_code_s(String current_batch_code_s){
        this.current_batch_code_s=current_batch_code_s;
    }
        
    public String getCurrent_material_code_s(){
        return current_material_code_s;
    }
    
    @XmlElement
    public void setCurrent_material_code_s(String current_material_code_s){
        this.current_material_code_s=current_material_code_s;
    }
        
    public Integer getDifferentvalue_i(){
        return differentvalue_i;
    }
    
    @XmlElement
    public void setDifferentvalue_i(Integer differentvalue_i){
        this.differentvalue_i=differentvalue_i;
    }
        
    public Integer getEndweight_i(){
        return endweight_i;
    }
    
    @XmlElement
    public void setEndweight_i(Integer endweight_i){
        this.endweight_i=endweight_i;
    }
        
    public String getEquipmentcode_s(){
        return equipmentcode_s;
    }
    
    @XmlElement
    public void setEquipmentcode_s(String equipmentcode_s){
        this.equipmentcode_s=equipmentcode_s;
    }
        
    public String getEquipmentconfigcode_s(){
        return equipmentconfigcode_s;
    }
    
    @XmlElement
    public void setEquipmentconfigcode_s(String equipmentconfigcode_s){
        this.equipmentconfigcode_s=equipmentconfigcode_s;
    }
        
    public String getEquipmentname_s(){
        return equipmentname_s;
    }
    
    @XmlElement
    public void setEquipmentname_s(String equipmentname_s){
        this.equipmentname_s=equipmentname_s;
    }
        
    public String getEquipmentstatuscode_s(){
        return equipmentstatuscode_s;
    }
    
    @XmlElement
    public void setEquipmentstatuscode_s(String equipmentstatuscode_s){
        this.equipmentstatuscode_s=equipmentstatuscode_s;
    }
        
    public String getEquipspecialselect_s(){
        return equipspecialselect_s;
    }
    
    @XmlElement
    public void setEquipspecialselect_s(String equipspecialselect_s){
        this.equipspecialselect_s=equipspecialselect_s;
    }
        
    public String getEquip_type_s(){
        return equip_type_s;
    }
    
    @XmlElement
    public void setEquip_type_s(String equip_type_s){
        this.equip_type_s=equip_type_s;
    }
        
    public String getIp_address_s(){
        return ip_address_s;
    }
    
    @XmlElement
    public void setIp_address_s(String ip_address_s){
        this.ip_address_s=ip_address_s;
    }
        
    public String getLast_barcode_s(){
        return last_barcode_s;
    }
    
    @XmlElement
    public void setLast_barcode_s(String last_barcode_s){
        this.last_barcode_s=last_barcode_s;
    }
        
    public String getLast_batch_code_s(){
        return last_batch_code_s;
    }
    
    @XmlElement
    public void setLast_batch_code_s(String last_batch_code_s){
        this.last_batch_code_s=last_batch_code_s;
    }
        
    public String getLast_material_code_s(){
        return last_material_code_s;
    }
    
    @XmlElement
    public void setLast_material_code_s(String last_material_code_s){
        this.last_material_code_s=last_material_code_s;
    }
        
    public String getLeavequantity_f(){
        return leavequantity_f;
    }
    
    @XmlElement
    public void setLeavequantity_f(String leavequantity_f){
        this.leavequantity_f=leavequantity_f;
    }
        
    public String getMaterialname_s(){
        return materialname_s;
    }
    
    @XmlElement
    public void setMaterialname_s(String materialname_s){
        this.materialname_s=materialname_s;
    }
        
    public String getOutputgroup_s(){
        return outputgroup_s;
    }
    
    @XmlElement
    public void setOutputgroup_s(String outputgroup_s){
        this.outputgroup_s=outputgroup_s;
    }
        
    public Long getOutquantity_i(){
        return outquantity_i;
    }
    
    @XmlElement
    public void setOutquantity_i(Long outquantity_i){
        this.outquantity_i=outquantity_i;
    }
        
    public String getPercent_f(){
        return percent_f;
    }
    
    @XmlElement
    public void setPercent_f(String percent_f){
        this.percent_f=percent_f;
    }
        
    public String getPlanno_s(){
        return planno_s;
    }
    
    @XmlElement
    public void setPlanno_s(String planno_s){
        this.planno_s=planno_s;
    }
        
    public Integer getPlanquantity_i(){
        return planquantity_i;
    }
    
    @XmlElement
    public void setPlanquantity_i(Integer planquantity_i){
        this.planquantity_i=planquantity_i;
    }
        
    public String getProductiongver_s(){
        return productiongver_s;
    }
    
    @XmlElement
    public void setProductiongver_s(String productiongver_s){
        this.productiongver_s=productiongver_s;
    }
        
    public String getProductionline_code_s(){
        return productionline_code_s;
    }
    
    @XmlElement
    public void setProductionline_code_s(String productionline_code_s){
        this.productionline_code_s=productionline_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemark_s(){
        return remark_s;
    }
    
    @XmlElement
    public void setRemark_s(String remark_s){
        this.remark_s=remark_s;
    }
        
    public String getRfid_antenna_code_s(){
        return rfid_antenna_code_s;
    }
    
    @XmlElement
    public void setRfid_antenna_code_s(String rfid_antenna_code_s){
        this.rfid_antenna_code_s=rfid_antenna_code_s;
    }
        
    public String getSapm_group_s(){
        return sapm_group_s;
    }
    
    @XmlElement
    public void setSapm_group_s(String sapm_group_s){
        this.sapm_group_s=sapm_group_s;
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
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getSteelflag_s(){
        return steelflag_s;
    }
    
    @XmlElement
    public void setSteelflag_s(String steelflag_s){
        this.steelflag_s=steelflag_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
