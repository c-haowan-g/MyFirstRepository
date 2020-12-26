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
 * 半部件盘库记录差异表
 * @author 徐秉正
 * @Date 2020-03-16 16:45:03
 */
@ATDefinition("A_SM_STOCKDIFFERENTLIST")
@Entity
@XmlRootElement
@Table(name="AT_A_SM_STOCKDIFFERENTLIST")
public class Stockdifferentlist extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
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
    
    @Comment("盘库类型")
    @Column(nullable=true,length=80)
    private String instoretype_s;
    
    @Comment("生产机台")
    @Column(nullable=true,length=80)
    private String machinno_s;
    
    @Comment("物料编码 ")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=80)
    private String materialgroup_s;
    
    @Comment("盘库信息来源 0：立库  1：人工 ")
    @Column(nullable=true,length=80)
    private String messagefrom_s;
    
    @Comment("生产时间")
    @Column(nullable=true,length=0)
    private Date productiondate_t;
    
    @Comment("生产数量 ")
    @Column(nullable=true,length=80)
    private String quantity_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("盘库结果 0未处理 1处理完成 2过期未处理（同一物料组有的核库数据时，之前的数据） ")
    @Column(nullable=true,length=80)
    private String resultflag_s;
    
    @Comment("载具条码 ")
    @Column(nullable=true,length=80)
    private String rfidno_s;
    
    @Comment("SAP品号")
    @Column(nullable=true,length=80)
    private String sapcode_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
    @Comment("备用字段11")
    @Column(nullable=true,length=80)
    private String spare11_s;
    
    @Comment("备用字段12")
    @Column(nullable=true,length=80)
    private String spare12_s;
    
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
    
    @Comment("盘库单号 ")
    @Column(nullable=true,length=80)
    private String stockno_s;
    
    @Comment("盘库类型 0：盘入 1：盘出  2：盘亏 3：盘盈 （针对于MES数据）")
    @Column(nullable=true,length=80)
    private String stocktype_s;
    
    @Comment("入库位置")
    @Column(nullable=true,length=80)
    private String storagelocation_s;
    
    @Comment("入库时间")
    @Column(nullable=true,length=0)
    private Date storeentrytime_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("条码号")
    @Column(nullable=true,length=80)
    private String tirebarcode_s;
    
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
        
    public String getInstoretype_s(){
        return instoretype_s;
    }
    
    @XmlElement
    public void setInstoretype_s(String instoretype_s){
        this.instoretype_s=instoretype_s;
    }
        
    public String getMachinno_s(){
        return machinno_s;
    }
    
    @XmlElement
    public void setMachinno_s(String machinno_s){
        this.machinno_s=machinno_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
    }
        
    public String getMessagefrom_s(){
        return messagefrom_s;
    }
    
    @XmlElement
    public void setMessagefrom_s(String messagefrom_s){
        this.messagefrom_s=messagefrom_s;
    }
        
    public Date getProductiondate_t(){
        return productiondate_t;
    }
    
    @XmlElement
    public void setProductiondate_t(Date productiondate_t){
        this.productiondate_t=productiondate_t;
    }
        
    public String getQuantity_s(){
        return quantity_s;
    }
    
    @XmlElement
    public void setQuantity_s(String quantity_s){
        this.quantity_s=quantity_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getResultflag_s(){
        return resultflag_s;
    }
    
    @XmlElement
    public void setResultflag_s(String resultflag_s){
        this.resultflag_s=resultflag_s;
    }
        
    public String getRfidno_s(){
        return rfidno_s;
    }
    
    @XmlElement
    public void setRfidno_s(String rfidno_s){
        this.rfidno_s=rfidno_s;
    }
        
    public String getSapcode_s(){
        return sapcode_s;
    }
    
    @XmlElement
    public void setSapcode_s(String sapcode_s){
        this.sapcode_s=sapcode_s;
    }
        
    public String getSpare10_s(){
        return spare10_s;
    }
    
    @XmlElement
    public void setSpare10_s(String spare10_s){
        this.spare10_s=spare10_s;
    }
        
    public String getSpare11_s(){
        return spare11_s;
    }
    
    @XmlElement
    public void setSpare11_s(String spare11_s){
        this.spare11_s=spare11_s;
    }
        
    public String getSpare12_s(){
        return spare12_s;
    }
    
    @XmlElement
    public void setSpare12_s(String spare12_s){
        this.spare12_s=spare12_s;
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
        
    public String getStockno_s(){
        return stockno_s;
    }
    
    @XmlElement
    public void setStockno_s(String stockno_s){
        this.stockno_s=stockno_s;
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
        
    
    
    
}
