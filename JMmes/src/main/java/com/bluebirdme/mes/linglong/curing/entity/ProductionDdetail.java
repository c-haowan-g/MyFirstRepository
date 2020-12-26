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
 * 硫化报产冲产明细表
 * @author 时永良
 * @Date 2020-01-22 09:45:34
 */
@ATDefinition("C_MM_ProductionDetail")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_PRODUCTIONDETAIL")
public class ProductionDdetail extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002；柳州 8003； 泰国8004； 荆门8023）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("硫化质量等级")
    @Column(nullable=true,length=80)
    private String curing_grade_s;
    
    @Comment("机台编码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("规格描述")
    @Column(nullable=true,length=80)
    private String material_name_s;
    
    @Comment("是否补硫化 1：是 0：否 ")
    @Column(nullable=true,length=80)
    private String patch_curingflag_s;
    
    @Comment("生产日期")
    @Column(nullable=true,length=80)
    private String product_date_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("生产报工流水号")
    @Column(nullable=true,length=80)
    private String serial_number_s;
    
    @Comment("固化标识 1:已固化 0或者null :未固化")
    @Column(nullable=true,length=80)
    private String solidif_yflag_s;
    
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
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getCuring_grade_s(){
        return curing_grade_s;
    }
    
    @XmlElement
    public void setCuring_grade_s(String curing_grade_s){
        this.curing_grade_s=curing_grade_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
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
        
    public String getPatch_curingflag_s(){
        return patch_curingflag_s;
    }
    
    @XmlElement
    public void setPatch_curingflag_s(String patch_curingflag_s){
        this.patch_curingflag_s=patch_curingflag_s;
    }
        
    public String getProduct_date_s(){
        return product_date_s;
    }
    
    @XmlElement
    public void setProduct_date_s(String product_date_s){
        this.product_date_s=product_date_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSerial_number_s(){
        return serial_number_s;
    }
    
    @XmlElement
    public void setSerial_number_s(String serial_number_s){
        this.serial_number_s=serial_number_s;
    }
        
    public String getSolidif_yflag_s(){
        return solidif_yflag_s;
    }
    
    @XmlElement
    public void setSolidif_yflag_s(String solidif_yflag_s){
        this.solidif_yflag_s=solidif_yflag_s;
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
        
    
    
    
}
