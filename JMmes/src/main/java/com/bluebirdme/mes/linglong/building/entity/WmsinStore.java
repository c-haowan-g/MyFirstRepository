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
 * 胎胚入库实绩表
 * @author 王海霖
 * @Date 2019-01-12 08:51:42
 */
@ATDefinition("INT_WH_WMSINSTORE")
@Entity
@XmlRootElement
@Table(name="AT_INT_WH_WMSINSTORE")
public class WmsinStore extends RockWellBaseEntity{
    
    
	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("外观是否合格")
    @Column(nullable=true,length=80)
    private String appearance_ok_s;
    
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
    
    @Comment("入库方式")
    @Column(nullable=true,length=80)
    private String instore_mode_s;
    
    @Comment("入库类型")
    @Column(nullable=true,length=80)
    private String instore_type_s;
    
    @Comment("成型机号")
    @Column(nullable=true,length=80)
    private String machin_no_s;
    
    @Comment("SAP品号")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String material_spec_s;
    
    @Comment("生产时间")
    @Column(nullable=true,length=0)
    private Date production_date_t;
    
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
    
    @Comment("入库位置")
    @Column(nullable=true,length=80)
    private String storage_location_s;
    
    @Comment("入库时间")
    @Column(nullable=true,length=0)
    private Date storeentry_time_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("条码号")
    @Column(nullable=true,length=80)
    private String tire_barcode_s;
    
    @Comment("重量是否合格")
    @Column(nullable=true,length=80)
    private String weight_ok_s;
    
    @Comment("胎胚重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    @Comment("操作工")
    @Column(nullable=true,length=80)
    private String worker_id_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAppearance_ok_s(){
        return appearance_ok_s;
    }
    
    @XmlElement
    public void setAppearance_ok_s(String appearance_ok_s){
        this.appearance_ok_s=appearance_ok_s;
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
        
    public String getInstore_mode_s(){
        return instore_mode_s;
    }
    
    @XmlElement
    public void setInstore_mode_s(String instore_mode_s){
        this.instore_mode_s=instore_mode_s;
    }
        
    public String getInstore_type_s(){
        return instore_type_s;
    }
    
    @XmlElement
    public void setInstore_type_s(String instore_type_s){
        this.instore_type_s=instore_type_s;
    }
        
    public String getMachin_no_s(){
        return machin_no_s;
    }
    
    @XmlElement
    public void setMachin_no_s(String machin_no_s){
        this.machin_no_s=machin_no_s;
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
        
    public Date getProduction_date_t(){
        return production_date_t;
    }
    
    @XmlElement
    public void setProduction_date_t(Date production_date_t){
        this.production_date_t=production_date_t;
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
        
    public String getStorage_location_s(){
        return storage_location_s;
    }
    
    @XmlElement
    public void setStorage_location_s(String storage_location_s){
        this.storage_location_s=storage_location_s;
    }
        
    public Date getStoreentry_time_t(){
        return storeentry_time_t;
    }
    
    @XmlElement
    public void setStoreentry_time_t(Date storeentry_time_t){
        this.storeentry_time_t=storeentry_time_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTire_barcode_s(){
        return tire_barcode_s;
    }
    
    @XmlElement
    public void setTire_barcode_s(String tire_barcode_s){
        this.tire_barcode_s=tire_barcode_s;
    }
        
    public String getWeight_ok_s(){
        return weight_ok_s;
    }
    
    @XmlElement
    public void setWeight_ok_s(String weight_ok_s){
        this.weight_ok_s=weight_ok_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }
        
    
    
    
}
