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
 * 胎胚库存明细表
 * @author 王海霖
 * @Date 2019-03-25 16:49:09
 */
@ATDefinition("B_WH_GREENTIRE_DETAIL")
@Entity
@XmlRootElement
@Table(name="AT_B_WH_GREENTIRE_DETAIL")
public class GreentireDetail extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("外观是否合格")
    @Column(nullable=true,length=80)
    private String appearanceok_s;
    
    @Comment("是否绑定胎胚车 1-绑定 0-解绑")
    @Column(nullable=true,length=80)
    private String bingding_s;
    
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
    
    @Comment("胎胚过期时间")
    @Column(nullable=true,length=0)
    private String greentire_beyondtime_f;
    
    @Comment("胎胚停放时间")
    @Column(nullable=true,length=0)
    private String greentire_parktime_f;
    
    @Comment("成型机号")
    @Column(nullable=true,length=80)
    private String machinno_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=256)
    private String material_name_s;
    
    @Comment("生产时间")
    @Column(nullable=true,length=0)
    private Date productiondate_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("备用字段true")
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
    
    @Comment("物料规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("库存类型")
    @Column(nullable=true,length=80)
    private String stocktype_s;
    
    @Comment("库存位置")
    @Column(nullable=true,length=80)
    private String storagelocation_s;
    
    @Comment("入库时间")
    @Column(nullable=true,length=0)
    private Date storeentrytime_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("条码号")
    @Column(nullable=true,length=80)
    private String tirebarcode_s;
    
    @Comment("胎胚车编号")
    @Column(nullable=true,length=80)
    private String tire_car_code_s;
    
    @Comment("重量是否合格")
    @Column(nullable=true,length=80)
    private String weightok_s;
    
    @Comment("胎胚重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAppearanceok_s(){
        return appearanceok_s;
    }
    
    @XmlElement
    public void setAppearanceok_s(String appearanceok_s){
        this.appearanceok_s=appearanceok_s;
    }
        
    public String getBingding_s(){
        return bingding_s;
    }
    
    @XmlElement
    public void setBingding_s(String bingding_s){
        this.bingding_s=bingding_s;
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
        
    public String getMachinno_s(){
        return machinno_s;
    }
    
    @XmlElement
    public void setMachinno_s(String machinno_s){
        this.machinno_s=machinno_s;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getStocktype_s(){
        return stocktype_s;
    }
    
    @XmlElement
    public void setStocktype_s(String stocktype_s){
        this.stocktype_s=stocktype_s;
    }
        
    public String getStoragelocation_s(){
        return storagelocation_s;
    }
    
    @XmlElement
    public void setStoragelocation_s(String storagelocation_s){
        this.storagelocation_s=storagelocation_s;
    }
        
    public Date getStoreentrytime_t(){
        return storeentrytime_t;
    }
    
    @XmlElement
    public void setStoreentrytime_t(Date storeentrytime_t){
        this.storeentrytime_t=storeentrytime_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTirebarcode_s(){
        return tirebarcode_s;
    }
    
    @XmlElement
    public void setTirebarcode_s(String tirebarcode_s){
        this.tirebarcode_s=tirebarcode_s;
    }
        
    public String getTire_car_code_s(){
        return tire_car_code_s;
    }
    
    @XmlElement
    public void setTire_car_code_s(String tire_car_code_s){
        this.tire_car_code_s=tire_car_code_s;
    }
        
    public String getWeightok_s(){
        return weightok_s;
    }
    
    @XmlElement
    public void setWeightok_s(String weightok_s){
        this.weightok_s=weightok_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    
    
    
}
