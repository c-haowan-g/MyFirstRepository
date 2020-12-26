/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 密炼胶料产出车次实绩表
 * @author 栾和源
 * @Date 2020-08-04 13:14:19
 */
@ATDefinition("MX_MM_POLYTRAIN_PROD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_POLYTRAIN_PROD")
public class Drprodimplement extends RockWellBaseEntity{
    
    
    @Comment("加炭黑时间")
    @Column(nullable=true,length=0)
    private Integer addcbtime_i;
    
    @Comment("加胶时间")
    @Column(nullable=true,length=0)
    private Integer addnrtime_i;
    
    @Comment("加油时间 ")
    @Column(nullable=true,length=0)
    private Integer addoiltime_i;
    
    @Comment("机构编号")
    @Column(nullable=true,length=10)
    private String agenc_no_s;
    
    @Comment("设定车次")
    @Column(nullable=true,length=25)
    private String allche_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("载具条码：M + 8 位流水号")
    @Column(nullable=true,length=40)
    private String carrier_code_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("排胶能量")
    @Column(nullable=true,length=0)
    private String dischargeenergy_f;
    
    @Comment("排胶功率")
    @Column(nullable=true,length=0)
    private String dischargepower_f;
    
    @Comment("排胶温度")
    @Column(nullable=true,length=0)
    private String dischargetemp_f;
    
    @Comment("机台编码")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("班组")
    @Column(nullable=true,length=25)
    private String group_code_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("间隔时间")
    @Column(nullable=true,length=0)
    private Integer intervals_i;
    
    @Comment("JPW：上辅机回传接收次数")
    @Column(nullable=true,length=25)
    private String jpw_s;
    
    @Comment("胶料车次批次号，长度19位： 母胶车次批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 MC91907011010010001 终炼胶车次批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 FC91907011010010001")
    @Column(nullable=true,length=50)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("MES快检车次号")
    @Column(nullable=true,length=0)
    private Integer mes_serial_id_i;
    
    @Comment("炼胶时间")
    @Column(nullable=true,length=0)
    private Integer mixtime_i;
    
    @Comment("外键ID：MX_MM_POLY_PROD.LOT_NO")
    @Column(nullable=true,length=80)
    private String polyprod_id_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date product_time_t;
    
    @Comment("生产日期")
    @Column(nullable=true,length=80)
    private String prod_date_s;
    
    @Comment("产出方式")
    @Column(nullable=true,length=25)
    private String prod_type_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方时间")
    @Column(nullable=true,length=0)
    private Integer recipetime_i;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
    @Comment("密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("上辅机车次号")
    @Column(nullable=true,length=0)
    private Integer serial_id_i;
    
    @Comment("班次")
    @Column(nullable=true,length=25)
    private String shift_code_s;
    
    @Comment("备用字段1：无称量实绩原因备注")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2：下发人姓名")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3：下发时间")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4：下发标识：0-未下发、1-已下发")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5：月产量汇总：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("开始时间")
    @Column(nullable=true,length=25)
    private String start_datetime_s;
    
    @Comment("状态编码")
    @Column(nullable=true,length=50)
    private String state_code_s;
    
    @Comment("工厂代码（1.全钢，2.半钢）")
    @Column(nullable=true,length=10)
    private String s_factory_s;
    
    @Comment("产出重量")
    @Column(nullable=true,length=25)
    private String weight_s;
    
    @Comment("密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO")
    @Column(nullable=true,length=50)
    private String wo_no_s;
    
    public Integer getAddcbtime_i(){
        return addcbtime_i;
    }
    
    @XmlElement
    public void setAddcbtime_i(Integer addcbtime_i){
        this.addcbtime_i=addcbtime_i;
    }
        
    public Integer getAddnrtime_i(){
        return addnrtime_i;
    }
    
    @XmlElement
    public void setAddnrtime_i(Integer addnrtime_i){
        this.addnrtime_i=addnrtime_i;
    }
        
    public Integer getAddoiltime_i(){
        return addoiltime_i;
    }
    
    @XmlElement
    public void setAddoiltime_i(Integer addoiltime_i){
        this.addoiltime_i=addoiltime_i;
    }
        
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAllche_s(){
        return allche_s;
    }
    
    @XmlElement
    public void setAllche_s(String allche_s){
        this.allche_s=allche_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getCarrier_code_s(){
        return carrier_code_s;
    }
    
    @XmlElement
    public void setCarrier_code_s(String carrier_code_s){
        this.carrier_code_s=carrier_code_s;
    }
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public String getCreated_name_s(){
        return created_name_s;
    }
    
    @XmlElement
    public void setCreated_name_s(String created_name_s){
        this.created_name_s=created_name_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDatasource_s(){
        return datasource_s;
    }
    
    @XmlElement
    public void setDatasource_s(String datasource_s){
        this.datasource_s=datasource_s;
    }
        
    public String getDischargeenergy_f(){
        return dischargeenergy_f;
    }
    
    @XmlElement
    public void setDischargeenergy_f(String dischargeenergy_f){
        this.dischargeenergy_f=dischargeenergy_f;
    }
        
    public String getDischargepower_f(){
        return dischargepower_f;
    }
    
    @XmlElement
    public void setDischargepower_f(String dischargepower_f){
        this.dischargepower_f=dischargepower_f;
    }
        
    public String getDischargetemp_f(){
        return dischargetemp_f;
    }
    
    @XmlElement
    public void setDischargetemp_f(String dischargetemp_f){
        this.dischargetemp_f=dischargetemp_f;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public String getGroup_code_s(){
        return group_code_s;
    }
    
    @XmlElement
    public void setGroup_code_s(String group_code_s){
        this.group_code_s=group_code_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public Integer getIntervals_i(){
        return intervals_i;
    }
    
    @XmlElement
    public void setIntervals_i(Integer intervals_i){
        this.intervals_i=intervals_i;
    }
        
    public String getJpw_s(){
        return jpw_s;
    }
    
    @XmlElement
    public void setJpw_s(String jpw_s){
        this.jpw_s=jpw_s;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
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
        
    public Integer getMes_serial_id_i(){
        return mes_serial_id_i;
    }
    
    @XmlElement
    public void setMes_serial_id_i(Integer mes_serial_id_i){
        this.mes_serial_id_i=mes_serial_id_i;
    }
        
    public Integer getMixtime_i(){
        return mixtime_i;
    }
    
    @XmlElement
    public void setMixtime_i(Integer mixtime_i){
        this.mixtime_i=mixtime_i;
    }
        
    public String getPolyprod_id_s(){
        return polyprod_id_s;
    }
    
    @XmlElement
    public void setPolyprod_id_s(String polyprod_id_s){
        this.polyprod_id_s=polyprod_id_s;
    }
        
    public Date getProduct_time_t(){
        return product_time_t;
    }
    
    @XmlElement
    public void setProduct_time_t(Date product_time_t){
        this.product_time_t=product_time_t;
    }
        
    public String getProd_date_s(){
        return prod_date_s;
    }
    
    @XmlElement
    public void setProd_date_s(String prod_date_s){
        this.prod_date_s=prod_date_s;
    }
        
    public String getProd_type_s(){
        return prod_type_s;
    }
    
    @XmlElement
    public void setProd_type_s(String prod_type_s){
        this.prod_type_s=prod_type_s;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public Integer getRecipetime_i(){
        return recipetime_i;
    }
    
    @XmlElement
    public void setRecipetime_i(Integer recipetime_i){
        this.recipetime_i=recipetime_i;
    }
        
    public String getRecipe_bom_version_s(){
        return recipe_bom_version_s;
    }
    
    @XmlElement
    public void setRecipe_bom_version_s(String recipe_bom_version_s){
        this.recipe_bom_version_s=recipe_bom_version_s;
    }
        
    public String getRecipe_code_s(){
        return recipe_code_s;
    }
    
    @XmlElement
    public void setRecipe_code_s(String recipe_code_s){
        this.recipe_code_s=recipe_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public Integer getSerial_id_i(){
        return serial_id_i;
    }
    
    @XmlElement
    public void setSerial_id_i(Integer serial_id_i){
        this.serial_id_i=serial_id_i;
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
        
    public String getStart_datetime_s(){
        return start_datetime_s;
    }
    
    @XmlElement
    public void setStart_datetime_s(String start_datetime_s){
        this.start_datetime_s=start_datetime_s;
    }
        
    public String getState_code_s(){
        return state_code_s;
    }
    
    @XmlElement
    public void setState_code_s(String state_code_s){
        this.state_code_s=state_code_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
