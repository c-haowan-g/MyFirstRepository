/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 半部件入库记录
 * @author 王超
 * @Date 2020-03-05 09:41:14
 */
@ATDefinition("A_SM_InStoreRecord")
@Entity
@XmlRootElement
@Table(name="AT_A_SM_INSTORERECORD")
public class InStoreRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("条码号")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
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
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String column_5_s;
    
    @Comment("入库量")
    @Column(nullable=true,length=0)
    private String inweight_f;
    
    @Comment("入库位置")
    @Column(nullable=true,length=80)
    private String in_location_s;
    
    @Comment("入库时间")
    @Column(nullable=true,length=0)
    private Date in_time_t;
    
    @Comment("生产机台")
    @Column(nullable=true,length=80)
    private String machinno_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=80)
    private String materialgroup_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String materielcode_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String materielname_s;
    
    @Comment("工装条码(口型板)")
    @Column(nullable=true,length=80)
    private String plate_code_s;
    
    @Comment("生产时间")
    @Column(nullable=true,length=0)
    private Date productiondate_t;
    
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
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("入库人班组")
    @Column(nullable=true,length=80)
    private String storage_in_class_s;
    
    @Comment("入库人班次")
    @Column(nullable=true,length=80)
    private String storage_in_shift_s;
    
    @Comment("入库类型 基础数据109")
    @Column(nullable=true,length=80)
    private String storage_in_type_s;
    
    @Comment("入库人人")
    @Column(nullable=true,length=80)
    private String storage_in_worker_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("载具条码")
    @Column(nullable=true,length=80)
    private String vehicles_code_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
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
        
    public String getColumn_5_s(){
        return column_5_s;
    }
    
    @XmlElement
    public void setColumn_5_s(String column_5_s){
        this.column_5_s=column_5_s;
    }
        
    public String getInweight_f(){
        return inweight_f;
    }
    
    @XmlElement
    public void setInweight_f(String inweight_f){
        this.inweight_f=inweight_f;
    }
        
    public String getIn_location_s(){
        return in_location_s;
    }
    
    @XmlElement
    public void setIn_location_s(String in_location_s){
        this.in_location_s=in_location_s;
    }
        
    public Date getIn_time_t(){
        return in_time_t;
    }
    
    @XmlElement
    public void setIn_time_t(Date in_time_t){
        this.in_time_t=in_time_t;
    }
        
    public String getMachinno_s(){
        return machinno_s;
    }
    
    @XmlElement
    public void setMachinno_s(String machinno_s){
        this.machinno_s=machinno_s;
    }
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
    }
        
    public String getMaterielcode_s(){
        return materielcode_s;
    }
    
    @XmlElement
    public void setMaterielcode_s(String materielcode_s){
        this.materielcode_s=materielcode_s;
    }
        
    public String getMaterielname_s(){
        return materielname_s;
    }
    
    @XmlElement
    public void setMaterielname_s(String materielname_s){
        this.materielname_s=materielname_s;
    }
        
    public String getPlate_code_s(){
        return plate_code_s;
    }
    
    @XmlElement
    public void setPlate_code_s(String plate_code_s){
        this.plate_code_s=plate_code_s;
    }
        
    public Date getProductiondate_t(){
        return productiondate_t;
    }
    
    @XmlElement
    public void setProductiondate_t(Date productiondate_t){
        this.productiondate_t=productiondate_t;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getStorage_in_class_s(){
        return storage_in_class_s;
    }
    
    @XmlElement
    public void setStorage_in_class_s(String storage_in_class_s){
        this.storage_in_class_s=storage_in_class_s;
    }
        
    public String getStorage_in_shift_s(){
        return storage_in_shift_s;
    }
    
    @XmlElement
    public void setStorage_in_shift_s(String storage_in_shift_s){
        this.storage_in_shift_s=storage_in_shift_s;
    }
        
    public String getStorage_in_type_s(){
        return storage_in_type_s;
    }
    
    @XmlElement
    public void setStorage_in_type_s(String storage_in_type_s){
        this.storage_in_type_s=storage_in_type_s;
    }
        
    public String getStorage_in_worker_s(){
        return storage_in_worker_s;
    }
    
    @XmlElement
    public void setStorage_in_worker_s(String storage_in_worker_s){
        this.storage_in_worker_s=storage_in_worker_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getVehicles_code_s(){
        return vehicles_code_s;
    }
    
    @XmlElement
    public void setVehicles_code_s(String vehicles_code_s){
        this.vehicles_code_s=vehicles_code_s;
    }
        
    
    
    
}
