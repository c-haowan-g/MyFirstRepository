/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 成型胎胚车信息查询
 * @author 王超
 * @Date 2020-07-10 10:09:16
 */
@ATDefinition("B_BM_TIRECAR_REAL")
@Entity
@XmlRootElement
@Table(name="AT_B_BM_TIRECAR_REAL")
public class TireCarReal extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("胎胚条码")
    @Column(nullable=false,length=80)
    private String barcode_s;
    
    @Comment("更新人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("更新时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("胎胚过期时间")
    @Column(nullable=true,length=0)
    private String greentire_beyondtime_f;
    
    @Comment("胎胚停放时间")
    @Column(nullable=true,length=0)
    private String greentire_parktime_f;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date instoretime_t;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=80)
    private String material_spec_s;
    
    @Comment("库位编码")
    @Column(nullable=true,length=80)
    private String placebar_s;
    
    @Comment("位置状态")
    @Column(nullable=true,length=80)
    private String placestatus_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("RFID")
    @Column(nullable=true,length=80)
    private String rfidcode_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String space1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String space2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String space3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String space4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String space5_s;
    
    @Comment("存放类型")
    @Column(nullable=true,length=80)
    private String storetype_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("胎胚车编号")
    @Column(nullable=false,length=80)
    private String tire_shelf_code_s;
    
    @Comment("胎胚车描述")
    @Column(nullable=true,length=80)
    private String tire_shelf_description_s;
    
    @Comment("胎胚车名称")
    @Column(nullable=true,length=80)
    private String tire_shelf_name_s;
    
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
        
    public String getGreentire_beyondtime_f(){
        return greentire_beyondtime_f;
    }
    
    @XmlElement
    public void setGreentire_beyondtime_f(String greentire_beyondtime_f){
        this.greentire_beyondtime_f=greentire_beyondtime_f;
    }
        
    public String getGreentire_parktime_f(){
        return greentire_parktime_f;
    }
    
    @XmlElement
    public void setGreentire_parktime_f(String greentire_parktime_f){
        this.greentire_parktime_f=greentire_parktime_f;
    }
        
    public Date getInstoretime_t(){
        return instoretime_t;
    }
    
    @XmlElement
    public void setInstoretime_t(Date instoretime_t){
        this.instoretime_t=instoretime_t;
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
        
    public String getPlacebar_s(){
        return placebar_s;
    }
    
    @XmlElement
    public void setPlacebar_s(String placebar_s){
        this.placebar_s=placebar_s;
    }
        
    public String getPlacestatus_s(){
        return placestatus_s;
    }
    
    @XmlElement
    public void setPlacestatus_s(String placestatus_s){
        this.placestatus_s=placestatus_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRfidcode_s(){
        return rfidcode_s;
    }
    
    @XmlElement
    public void setRfidcode_s(String rfidcode_s){
        this.rfidcode_s=rfidcode_s;
    }
        
    public String getSpace1_s(){
        return space1_s;
    }
    
    @XmlElement
    public void setSpace1_s(String space1_s){
        this.space1_s=space1_s;
    }
        
    public String getSpace2_s(){
        return space2_s;
    }
    
    @XmlElement
    public void setSpace2_s(String space2_s){
        this.space2_s=space2_s;
    }
        
    public String getSpace3_s(){
        return space3_s;
    }
    
    @XmlElement
    public void setSpace3_s(String space3_s){
        this.space3_s=space3_s;
    }
        
    public String getSpace4_s(){
        return space4_s;
    }
    
    @XmlElement
    public void setSpace4_s(String space4_s){
        this.space4_s=space4_s;
    }
        
    public String getSpace5_s(){
        return space5_s;
    }
    
    @XmlElement
    public void setSpace5_s(String space5_s){
        this.space5_s=space5_s;
    }
        
    public String getStoretype_s(){
        return storetype_s;
    }
    
    @XmlElement
    public void setStoretype_s(String storetype_s){
        this.storetype_s=storetype_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTire_shelf_code_s(){
        return tire_shelf_code_s;
    }
    
    @XmlElement
    public void setTire_shelf_code_s(String tire_shelf_code_s){
        this.tire_shelf_code_s=tire_shelf_code_s;
    }
        
    public String getTire_shelf_description_s(){
        return tire_shelf_description_s;
    }
    
    @XmlElement
    public void setTire_shelf_description_s(String tire_shelf_description_s){
        this.tire_shelf_description_s=tire_shelf_description_s;
    }
        
    public String getTire_shelf_name_s(){
        return tire_shelf_name_s;
    }
    
    @XmlElement
    public void setTire_shelf_name_s(String tire_shelf_name_s){
        this.tire_shelf_name_s=tire_shelf_name_s;
    }
        
    
    
    
}
