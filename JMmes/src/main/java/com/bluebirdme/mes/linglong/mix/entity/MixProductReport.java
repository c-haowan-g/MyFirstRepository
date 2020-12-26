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
 * 密炼小料包产出实绩表
 * @author 陈国强
 * @Date 2020-08-22 15:45:47
 */
@ATDefinition("MX_MM_RECIPEBAG_PROD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_RECIPEBAG_PROD")
public class MixProductReport extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
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
    
    @Comment("备用字段1：无称量实绩原因备注")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("备用字段2：小料袋关联小料车批次号")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用字段3：物料最小存放时间或允许出库时间")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用字段5：月产量汇总：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=40)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("误差")
    @Column(nullable=true,length=20)
    private String error_out_s;
    
    @Comment("班组")
    @Column(nullable=true,length=25)
    private String group_code_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("批次信息，长度19位 小料批次号：固定字符+工厂+生产日期+班次+机台+计划号+流水号 自动配料：FA91907011010010001 人工配料：FH91907011010010001")
    @Column(nullable=true,length=25)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("产出重量")
    @Column(nullable=true,length=20)
    private String output_weight_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date product_time_t;
    
    @Comment("生产日期")
    @Column(nullable=true,length=80)
    private String prod_date_s;
    
    @Comment("产出状态：0-手动、1-自动")
    @Column(nullable=true,length=2)
    private String prod_state_s;
    
    @Comment("产出方式")
    @Column(nullable=true,length=25)
    private String prod_type_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
    @Comment("密炼生成配方编号，外键")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("车次")
    @Column(nullable=true,length=25)
    private String serial_id_s;
    
    @Comment("班次")
    @Column(nullable=true,length=25)
    private String shift_code_s;
    
    @Comment("状态编码")
    @Column(nullable=true,length=50)
    private String state_code_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("称量总重量")
    @Column(nullable=true,length=25)
    private String totalweight_s;
    
    @Comment("托盘号")
    @Column(nullable=true,length=25)
    private String tray_no_s;
    
    @Comment("是否超差：0-正常、1-超差")
    @Column(nullable=true,length=2)
    private String warning_sgn_s;
    
    @Comment("密炼工单跟踪表，工单号")
    @Column(nullable=true,length=25)
    private String wo_no_s;
    
    @Comment("总数量")
    @Column(nullable=true,length=25)
    private String trainCount;
    
    @Comment("产出重量")
    @Column(nullable=true,length=25)
    private String totalWeight; 
    
    @Comment("主机手")
    @Column(nullable=true,length=100)
    private String recipe_code_name_s;
    
    
    public String getTrainCount() {
		return trainCount;
	}
    @XmlElement
	public void setTrainCount(String trainCount) {
		this.trainCount = trainCount;
	}

	public String getTotalWeight() {
		return totalWeight;
	}
	  @XmlElement
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getRecipe_code_name_s() {
		return recipe_code_name_s;
	}
	  @XmlElement
	public void setRecipe_code_name_s(String recipe_code_name_s) {
		this.recipe_code_name_s = recipe_code_name_s;
	}

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
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
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
        
    public String getError_out_s(){
        return error_out_s;
    }
    
    @XmlElement
    public void setError_out_s(String error_out_s){
        this.error_out_s=error_out_s;
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
        
    public String getOutput_weight_s(){
        return output_weight_s;
    }
    
    @XmlElement
    public void setOutput_weight_s(String output_weight_s){
        this.output_weight_s=output_weight_s;
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
        
    public String getProd_state_s(){
        return prod_state_s;
    }
    
    @XmlElement
    public void setProd_state_s(String prod_state_s){
        this.prod_state_s=prod_state_s;
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
        
    public String getSerial_id_s(){
        return serial_id_s;
    }
    
    @XmlElement
    public void setSerial_id_s(String serial_id_s){
        this.serial_id_s=serial_id_s;
    }
        
    public String getShift_code_s(){
        return shift_code_s;
    }
    
    @XmlElement
    public void setShift_code_s(String shift_code_s){
        this.shift_code_s=shift_code_s;
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
        
    public String getTotalweight_s(){
        return totalweight_s;
    }
    
    @XmlElement
    public void setTotalweight_s(String totalweight_s){
        this.totalweight_s=totalweight_s;
    }
        
    public String getTray_no_s(){
        return tray_no_s;
    }
    
    @XmlElement
    public void setTray_no_s(String tray_no_s){
        this.tray_no_s=tray_no_s;
    }
        
    public String getWarning_sgn_s(){
        return warning_sgn_s;
    }
    
    @XmlElement
    public void setWarning_sgn_s(String warning_sgn_s){
        this.warning_sgn_s=warning_sgn_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
