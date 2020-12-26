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
 * 胎胚超期预警
 * @author 李德晓
 * @Date 2020-07-06 13:52:23
 */
@ATDefinition("B_MM_WORKORDERRESULT")
@Entity
@XmlRootElement
@Table(name="AT_B_MM_WORKORDERRESULT")
public class EmbryoOverDateWarning extends RockWellBaseEntity{
    
    
    @Comment("产出标记 基础数据105 105001正常产出105002补产出105003取消产出")
    @Column(nullable=true,length=80)
    private String add_flag_s;
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("成型生产时间")
    @Column(nullable=true,length=0)
    private Date building_date_t;
    
    @Comment("成型班组")
    @Column(nullable=true,length=80)
    private String building_group_s;
    
    @Comment("成型班次")
    @Column(nullable=true,length=80)
    private String building_shift_s;
    
    @Comment("胎胚重量")
    @Column(nullable=true,length=80)
    private String building_weight_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间 ")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("DOT号")
    @Column(nullable=true,length=80)
    private String dot_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=80)
    private String equip_name_s;
    
    @Comment("是否首条")
    @Column(nullable=true,length=80)
    private String first_s;
    
    @Comment("工艺配方索引号")
    @Column(nullable=true,length=80)
    private String formula_index_s;
    
    @Comment("是否有效 1:有效 0 无效")
    @Column(nullable=true,length=80)
    private String is_flag_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("规格描述")
    @Column(nullable=true,length=80)
    private String material_name_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=80)
    private String material_spec_s;
    
    @Comment("日计划号")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("生产版本")
    @Column(nullable=true,length=80)
    private String production_ver_s;
    
    @Comment("质检状态")
    @Column(nullable=true,length=80)
    private String quality_status_s;
    
    @Comment("重量是否合格")
    @Column(nullable=true,length=80)
    private String quality_weight_status_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("计划内顺序号")
    @Column(nullable=true,length=80)
    private String serial_number_s;
    
    @Comment("固化时间")
    @Column(nullable=true,length=0)
    private Date solid_time_t;
    
    @Comment("固化标识 1:已固化 0或者null :未固化")
    @Column(nullable=true,length=80)
    private String solid_yflag_s;
    
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
    
    @Comment("特殊标识")
    @Column(nullable=true,length=80)
    private String special_mark_s;
    
    @Comment("标准重量")
    @Column(nullable=true,length=80)
    private String standard_weight_s;
    
    @Comment("质量状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("胎胚车编号")
    @Column(nullable=true,length=80)
    private String tire_car_code_s;
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=80)
    private String tyre_barcode_s;
    
    @Comment("单位")
    @Column(nullable=true,length=80)
    private String unit_s;
    
    @Comment("成型工人_主手")
    @Column(nullable=true,length=80)
    private String worker1_id_s;
    
    @Comment("成型工人_主手名称")
    @Column(nullable=true,length=80)
    private String worker1_name_s;
    
    @Comment("成型工人_副手")
    @Column(nullable=true,length=80)
    private String worker2_id_s;
    
    @Comment("成型工人_副手名称")
    @Column(nullable=true,length=80)
    private String worker2_name_s;
    
    @Comment("成型工人_副手2")
    @Column(nullable=true,length=80)
    private String worker3_id_s;
    
    @Comment("成型工人_副手2名称")
    @Column(nullable=true,length=80)
    private String worker3_name_s;
    
    @Comment("工单编号")
    @Column(nullable=true,length=80)
    private String work_order_id_s;
    
    public String getAdd_flag_s(){
        return add_flag_s;
    }
    
    @XmlElement
    public void setAdd_flag_s(String add_flag_s){
        this.add_flag_s=add_flag_s;
    }
        
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Date getBuilding_date_t(){
        return building_date_t;
    }
    
    @XmlElement
    public void setBuilding_date_t(Date building_date_t){
        this.building_date_t=building_date_t;
    }
        
    public String getBuilding_group_s(){
        return building_group_s;
    }
    
    @XmlElement
    public void setBuilding_group_s(String building_group_s){
        this.building_group_s=building_group_s;
    }
        
    public String getBuilding_shift_s(){
        return building_shift_s;
    }
    
    @XmlElement
    public void setBuilding_shift_s(String building_shift_s){
        this.building_shift_s=building_shift_s;
    }
        
    public String getBuilding_weight_s(){
        return building_weight_s;
    }
    
    @XmlElement
    public void setBuilding_weight_s(String building_weight_s){
        this.building_weight_s=building_weight_s;
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
        
    public String getDot_s(){
        return dot_s;
    }
    
    @XmlElement
    public void setDot_s(String dot_s){
        this.dot_s=dot_s;
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
        
    public String getFirst_s(){
        return first_s;
    }
    
    @XmlElement
    public void setFirst_s(String first_s){
        this.first_s=first_s;
    }
        
    public String getFormula_index_s(){
        return formula_index_s;
    }
    
    @XmlElement
    public void setFormula_index_s(String formula_index_s){
        this.formula_index_s=formula_index_s;
    }
        
    public String getIs_flag_s(){
        return is_flag_s;
    }
    
    @XmlElement
    public void setIs_flag_s(String is_flag_s){
        this.is_flag_s=is_flag_s;
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
        
    public String getMaterial_spec_s(){
        return material_spec_s;
    }
    
    @XmlElement
    public void setMaterial_spec_s(String material_spec_s){
        this.material_spec_s=material_spec_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProduction_ver_s(){
        return production_ver_s;
    }
    
    @XmlElement
    public void setProduction_ver_s(String production_ver_s){
        this.production_ver_s=production_ver_s;
    }
        
    public String getQuality_status_s(){
        return quality_status_s;
    }
    
    @XmlElement
    public void setQuality_status_s(String quality_status_s){
        this.quality_status_s=quality_status_s;
    }
        
    public String getQuality_weight_status_s(){
        return quality_weight_status_s;
    }
    
    @XmlElement
    public void setQuality_weight_status_s(String quality_weight_status_s){
        this.quality_weight_status_s=quality_weight_status_s;
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
        
    public Date getSolid_time_t(){
        return solid_time_t;
    }
    
    @XmlElement
    public void setSolid_time_t(Date solid_time_t){
        this.solid_time_t=solid_time_t;
    }
        
    public String getSolid_yflag_s(){
        return solid_yflag_s;
    }
    
    @XmlElement
    public void setSolid_yflag_s(String solid_yflag_s){
        this.solid_yflag_s=solid_yflag_s;
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
        
    public String getSpecial_mark_s(){
        return special_mark_s;
    }
    
    @XmlElement
    public void setSpecial_mark_s(String special_mark_s){
        this.special_mark_s=special_mark_s;
    }
        
    public String getStandard_weight_s(){
        return standard_weight_s;
    }
    
    @XmlElement
    public void setStandard_weight_s(String standard_weight_s){
        this.standard_weight_s=standard_weight_s;
    }
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTire_car_code_s(){
        return tire_car_code_s;
    }
    
    @XmlElement
    public void setTire_car_code_s(String tire_car_code_s){
        this.tire_car_code_s=tire_car_code_s;
    }
        
    public String getTyre_barcode_s(){
        return tyre_barcode_s;
    }
    
    @XmlElement
    public void setTyre_barcode_s(String tyre_barcode_s){
        this.tyre_barcode_s=tyre_barcode_s;
    }
        
    public String getUnit_s(){
        return unit_s;
    }
    
    @XmlElement
    public void setUnit_s(String unit_s){
        this.unit_s=unit_s;
    }
        
    public String getWorker1_id_s(){
        return worker1_id_s;
    }
    
    @XmlElement
    public void setWorker1_id_s(String worker1_id_s){
        this.worker1_id_s=worker1_id_s;
    }
        
    public String getWorker1_name_s(){
        return worker1_name_s;
    }
    
    @XmlElement
    public void setWorker1_name_s(String worker1_name_s){
        this.worker1_name_s=worker1_name_s;
    }
        
    public String getWorker2_id_s(){
        return worker2_id_s;
    }
    
    @XmlElement
    public void setWorker2_id_s(String worker2_id_s){
        this.worker2_id_s=worker2_id_s;
    }
        
    public String getWorker2_name_s(){
        return worker2_name_s;
    }
    
    @XmlElement
    public void setWorker2_name_s(String worker2_name_s){
        this.worker2_name_s=worker2_name_s;
    }
        
    public String getWorker3_id_s(){
        return worker3_id_s;
    }
    
    @XmlElement
    public void setWorker3_id_s(String worker3_id_s){
        this.worker3_id_s=worker3_id_s;
    }
        
    public String getWorker3_name_s(){
        return worker3_name_s;
    }
    
    @XmlElement
    public void setWorker3_name_s(String worker3_name_s){
        this.worker3_name_s=worker3_name_s;
    }
        
    public String getWork_order_id_s(){
        return work_order_id_s;
    }
    
    @XmlElement
    public void setWork_order_id_s(String work_order_id_s){
        this.work_order_id_s=work_order_id_s;
    }
        
    
    
    
}
