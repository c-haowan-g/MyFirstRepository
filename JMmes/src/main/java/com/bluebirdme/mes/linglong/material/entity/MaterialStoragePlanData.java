/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.entity;

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
 * 盘库数据管理表
 * @author 李德晓
 * @Date 2020-08-11 08:41:41
 */
@ATDefinition("CM_WH_ITEM_INV_EXEC")
@Entity
@XmlRootElement
@Table(name="AT_CM_WH_ITEM_INV_EXEC")
public class MaterialStoragePlanData extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=false,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=2)
    private String arch_flag_s;
    
    @Comment("单位")
    @Column(nullable=true,length=80)
    private String baseunit_s;
    
    @Comment("载具条码")
    @Column(nullable=true,length=40)
    private String carrier_code_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("数据对库处理标记：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String check_hand_flag_s;
    
    @Comment("数据对库处理反馈")
    @Column(nullable=true,length=2000)
    private String check_hand_msg_s;
    
    @Comment("数据对库处理时间")
    @Column(nullable=true,length=0)
    private Date check_hand_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名 ")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("机台编码")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("盘点时库位编码")
    @Column(nullable=true,length=80)
    private String inventory_loc_code_s;
    
    @Comment("盘点时库位 ")
    @Column(nullable=true,length=80)
    private String inventory_loc_s;
    
    @Comment("盘点数量")
    @Column(nullable=true,length=0)
    private String inventory_qty_f;
    
    @Comment("盘库结果类型： 345001-正常(数据一致) 345002-正常(数据不一致) 345003-有实物，无信息 345004-有信息，无实物")
    @Column(nullable=true,length=80)
    private String inventory_result_s;
    
    @Comment("盘点重量")
    @Column(nullable=true,length=0)
    private String inventory_weight_f;
    
    @Comment("入库日期")
    @Column(nullable=true,length=80)
    private String in_date_s;
    
    @Comment("作业名称")
    @Column(nullable=true,length=200)
    private String job_name_s;
    
    @Comment("盘库计划管理表作业号：外键，CM_WH_ITEM_INV_JOB.JOB_NO")
    @Column(nullable=false,length=80)
    private String job_no_s;
    
    @Comment("批次号")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=80)
    private String material_group_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("出库日期")
    @Column(nullable=true,length=80)
    private String out_date_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=80)
    private String product_time_s;
    
    @Comment("记录标志：A-可用，D-删除")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("进厂批次")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=100)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=100)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=100)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=100)
    private String spare9_s;
    
    @Comment("状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库）")
    @Column(nullable=true,length=80)
    private String state_code_s;
    
    @Comment("系统中库位编码")
    @Column(nullable=true,length=80)
    private String sys_loc_code_s;
    
    @Comment("系统中库位")
    @Column(nullable=true,length=80)
    private String sys_loc_s;
    
    @Comment("系统数量")
    @Column(nullable=true,length=0)
    private String sys_qty_f;
    
    @Comment("系统重量")
    @Column(nullable=true,length=0)
    private String sys_weight_f;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getBaseunit_s(){
        return baseunit_s;
    }
    
    @XmlElement
    public void setBaseunit_s(String baseunit_s){
        this.baseunit_s=baseunit_s;
    }
        
    public String getCarrier_code_s(){
        return carrier_code_s;
    }
    
    @XmlElement
    public void setCarrier_code_s(String carrier_code_s){
        this.carrier_code_s=carrier_code_s;
    }
        
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public String getChanged_name_s(){
        return changed_name_s;
    }
    
    @XmlElement
    public void setChanged_name_s(String changed_name_s){
        this.changed_name_s=changed_name_s;
    }
        
    public Date getChanged_time_t(){
        return changed_time_t;
    }
    
    @XmlElement
    public void setChanged_time_t(Date changed_time_t){
        this.changed_time_t=changed_time_t;
    }
        
    public String getCheck_hand_flag_s(){
        return check_hand_flag_s;
    }
    
    @XmlElement
    public void setCheck_hand_flag_s(String check_hand_flag_s){
        this.check_hand_flag_s=check_hand_flag_s;
    }
        
    public String getCheck_hand_msg_s(){
        return check_hand_msg_s;
    }
    
    @XmlElement
    public void setCheck_hand_msg_s(String check_hand_msg_s){
        this.check_hand_msg_s=check_hand_msg_s;
    }
        
    public Date getCheck_hand_time_t(){
        return check_hand_time_t;
    }
    
    @XmlElement
    public void setCheck_hand_time_t(Date check_hand_time_t){
        this.check_hand_time_t=check_hand_time_t;
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
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInventory_loc_code_s(){
        return inventory_loc_code_s;
    }
    
    @XmlElement
    public void setInventory_loc_code_s(String inventory_loc_code_s){
        this.inventory_loc_code_s=inventory_loc_code_s;
    }
        
    public String getInventory_loc_s(){
        return inventory_loc_s;
    }
    
    @XmlElement
    public void setInventory_loc_s(String inventory_loc_s){
        this.inventory_loc_s=inventory_loc_s;
    }
        
    public String getInventory_qty_f(){
        return inventory_qty_f;
    }
    
    @XmlElement
    public void setInventory_qty_f(String inventory_qty_f){
        this.inventory_qty_f=inventory_qty_f;
    }
        
    public String getInventory_result_s(){
        return inventory_result_s;
    }
    
    @XmlElement
    public void setInventory_result_s(String inventory_result_s){
        this.inventory_result_s=inventory_result_s;
    }
        
    public String getInventory_weight_f(){
        return inventory_weight_f;
    }
    
    @XmlElement
    public void setInventory_weight_f(String inventory_weight_f){
        this.inventory_weight_f=inventory_weight_f;
    }
        
    public String getIn_date_s(){
        return in_date_s;
    }
    
    @XmlElement
    public void setIn_date_s(String in_date_s){
        this.in_date_s=in_date_s;
    }
        
    public String getJob_name_s(){
        return job_name_s;
    }
    
    @XmlElement
    public void setJob_name_s(String job_name_s){
        this.job_name_s=job_name_s;
    }
        
    public String getJob_no_s(){
        return job_no_s;
    }
    
    @XmlElement
    public void setJob_no_s(String job_no_s){
        this.job_no_s=job_no_s;
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
        
    public String getMaterial_group_s(){
        return material_group_s;
    }
    
    @XmlElement
    public void setMaterial_group_s(String material_group_s){
        this.material_group_s=material_group_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getOut_date_s(){
        return out_date_s;
    }
    
    @XmlElement
    public void setOut_date_s(String out_date_s){
        this.out_date_s=out_date_s;
    }
        
    public String getProduct_time_s(){
        return product_time_s;
    }
    
    @XmlElement
    public void setProduct_time_s(String product_time_s){
        this.product_time_s=product_time_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    public String getState_code_s(){
        return state_code_s;
    }
    
    @XmlElement
    public void setState_code_s(String state_code_s){
        this.state_code_s=state_code_s;
    }
        
    public String getSys_loc_code_s(){
        return sys_loc_code_s;
    }
    
    @XmlElement
    public void setSys_loc_code_s(String sys_loc_code_s){
        this.sys_loc_code_s=sys_loc_code_s;
    }
        
    public String getSys_loc_s(){
        return sys_loc_s;
    }
    
    @XmlElement
    public void setSys_loc_s(String sys_loc_s){
        this.sys_loc_s=sys_loc_s;
    }
        
    public String getSys_qty_f(){
        return sys_qty_f;
    }
    
    @XmlElement
    public void setSys_qty_f(String sys_qty_f){
        this.sys_qty_f=sys_qty_f;
    }
        
    public String getSys_weight_f(){
        return sys_weight_f;
    }
    
    @XmlElement
    public void setSys_weight_f(String sys_weight_f){
        this.sys_weight_f=sys_weight_f;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
