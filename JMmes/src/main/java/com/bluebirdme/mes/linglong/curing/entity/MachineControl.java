/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * 硫化机台运行状态表
 * 
 * @author 时永良
 * @Date 2018-09-07 18:54:46
 */
@ATDefinition("C_MM_MachineControl")
@Entity
@XmlRootElement
@Table(name = "AT_C_MM_MACHINECONTROL")
public class MachineControl extends RockWellBaseEntity {

    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("警报需解除受控 1：是 （受控）  0：否（不受控，自动解除）")
    @Column(nullable=true,length=80)
    private String alarm_controlflag_s;
    
    @Comment("允许手动硫化： 1 是 0：否")
    @Column(nullable=true,length=80)
    private String allowareacvulcanization_s;
    
    @Comment("所属区(车间)")
    @Column(nullable=false,length=80)
    private String belong_section_s;
    
    @Comment("开启容量控制 线边库容量，量设置在基础数据中")
    @Column(nullable=true,length=0)
    private Integer capacity_control_i;
    
    @Comment("胶囊条码")
    @Column(nullable=true,length=80)
    private String capsule_id_s;
    
    @Comment("胶囊上限次数")
    @Column(nullable=true,length=0)
    private Integer capsule_limmit_i;
    
    @Comment("胶囊超上限使用次数")
    @Column(nullable=true,length=0)
    private Integer capsule_overlimit_i;
    
    @Comment("胶囊使用次数")
    @Column(nullable=true,length=0)
    private Integer capsule_recount_i;
    
    @Comment("胶囊规格")
    @Column(nullable=true,length=80)
    private String capsule_spec_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("换模工")
    @Column(nullable=true,length=80)
    private String changemold_operator_s;
    
    @Comment("当前班次")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("当前外胎物料编码")
    @Column(nullable=true,length=80)
    private String curr_materialcode_s;
    
    @Comment("当前外胎物料规格")
    @Column(nullable=true,length=80)
    private String curr_productspec_s;
    
    @Comment("延硫时间，做总时间校验时需要")
    @Column(nullable=true,length=80)
    private String delay_time_s;
    
    @Comment("年周日")
    @Column(nullable=true,length=80)
    private String dot_s;
    
    @Comment("最优胎胚角度")
    @Column(nullable=true,length=0)
    private Integer embryos_point_i;
    
    @Comment("当前胎胚编码")
    @Column(nullable=true,length=80)
    private String embryo_code_s;
    
    @Comment("当前胎胚规格")
    @Column(nullable=true,length=80)
    private String embryo_spec_s;
    
    @Comment("机台条码")
    @Column(nullable=false,length=80)
    private String equip_code_s;
    
    @Comment("产线名称")
    @Column(nullable=true,length=80)
    private String equip_group_s;
    
    @Comment("设备IP")
    @Column(nullable=true,length=80)
    private String equip_ip_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=80)
    private String equip_name_s;
    
    @Comment("机台类型： 211001-密炼机 211002-成型机 211003-硫化机")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    @Comment("首模需验证 受控  1：是 0：否（首模不需验证）")
    @Column(nullable=true,length=80)
    private String firstmold_controlflag_s;
    
    @Comment("机台换模标记 1是，0，不是")
    @Column(nullable=true,length=80)
    private String first_flag_s;
    
    @Comment("先入先出 1：是 0否")
    @Column(nullable=true,length=80)
    private String first_inout_s;
    
    @Comment("是否有日计划 1：是 0：否")
    @Column(nullable=true,length=0)
    private Boolean ishavedayplay_y;
    
    @Comment("机台状态： 214001-生产 214002-待机 214003-维修 214004-换模具 214005-换胶囊 214006-冻结 214007-停机")
    @Column(nullable=false,length=80)
    private String isused_s;
    
    @Comment("上一个物料编码")
    @Column(nullable=true,length=80)
    private String last_materialcode_s;
    
    @Comment("计划数量")
    @Column(nullable=true,length=0)
    private Integer max_output_i;
    
    @Comment("是否温模，1是，0，否")
    @Column(nullable=true,length=80)
    private String mold_heatflag_s;
    
    @Comment("模具条码")
    @Column(nullable=true,length=80)
    private String mold_id_s;
    
    @Comment("模具规格")
    @Column(nullable=true,length=80)
    private String mold_spec_s;
    
    @Comment("是否单机运行   1 是  0 否")
    @Column(nullable=true,length=80)
    private String offlinerunflag_s;
    
    @Comment("开模时间")
    @Column(nullable=true,length=0)
    private Date openmold_time_t;
    
    @Comment("当前硫化操作工")
    @Column(nullable=true,length=80)
    private String operator_s;
    
    @Comment("换模计划号")
    @Column(nullable=true,length=80)
    private String planno_changemold_s;
    
    @Comment("所属 工序  工序编码为数据字典中维护的")
    @Column(nullable=false,length=80)
    private String plant_s;
    
    @Comment("日计划号")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("当前外胎物料版本")
    @Column(nullable=true,length=80)
    private String productionver_s;
    
    @Comment("生产日期")
    @Column(nullable=true,length=8)
    private String product_date_s;
    
    @Comment("产线条码")
    @Column(nullable=true,length=80)
    private String product_line_s;
    
    @Comment("生产模式 0 单例模式  1 连续模式")
    @Column(nullable=true,length=80)
    private String product_type_s;
    
    @Comment("后工序停机控制开关 1：是  0： 否")
    @Column(nullable=true,length=80)
    private String qs_stop_s;
    
    @Comment("首模数量记录 基础数据233")
    @Column(nullable=true,length=0)
    private Integer record_count_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("当前班组")
    @Column(nullable=true,length=80)
    private String shift_id_s;
    
    @Comment("备用字段1 换胶囊开始时间")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2 新胶囊条码")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3 胶囊更换原因")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4 新胶囊规格")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5 当前机台领用人")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("备用字段6 洗模受控 1：是 0否")
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
    
    @Comment("四小时首模验证流程")
    @Column(nullable=true,length=80)
    private String stop_fourhour_s;
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("当前外胎物料编码10位")
    @Column(nullable=true,length=80)
    private String ten_materialcode_s;
    
    @Comment("后充气受控 1：是  0：否  （后充气信号）")
    @Column(nullable=true,length=80)
    private String tyrebar_controlflag_s;
    
    @Comment("投料是否管控，1：是 0：否")
    @Column(nullable=true,length=80)
    private String tyre_feeding_s;
    
    @Comment("胚胎领用验证 1：是  0： 否")
    @Column(nullable=true,length=80)
    private String tyre_pickver_s;
    
    @Comment("胎胚时效性验证  1：是  0： 否")
    @Column(nullable=true,length=80)
    private String tyre_timever_s;
    
    @Comment("验证放行标志，0不放行，1：放行")
    @Column(nullable=true,length=80)
    private String verification_mark_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlarm_controlflag_s(){
        return alarm_controlflag_s;
    }
    
    @XmlElement
    public void setAlarm_controlflag_s(String alarm_controlflag_s){
        this.alarm_controlflag_s=alarm_controlflag_s;
    }
        
    public String getAllowareacvulcanization_s(){
        return allowareacvulcanization_s;
    }
    
    @XmlElement
    public void setAllowareacvulcanization_s(String allowareacvulcanization_s){
        this.allowareacvulcanization_s=allowareacvulcanization_s;
    }
        
    public String getBelong_section_s(){
        return belong_section_s;
    }
    
    @XmlElement
    public void setBelong_section_s(String belong_section_s){
        this.belong_section_s=belong_section_s;
    }
        
    public Integer getCapacity_control_i(){
        return capacity_control_i;
    }
    
    @XmlElement
    public void setCapacity_control_i(Integer capacity_control_i){
        this.capacity_control_i=capacity_control_i;
    }
        
    public String getCapsule_id_s(){
        return capsule_id_s;
    }
    
    @XmlElement
    public void setCapsule_id_s(String capsule_id_s){
        this.capsule_id_s=capsule_id_s;
    }
        
    public Integer getCapsule_limmit_i(){
        return capsule_limmit_i;
    }
    
    @XmlElement
    public void setCapsule_limmit_i(Integer capsule_limmit_i){
        this.capsule_limmit_i=capsule_limmit_i;
    }
        
    public Integer getCapsule_overlimit_i(){
        return capsule_overlimit_i;
    }
    
    @XmlElement
    public void setCapsule_overlimit_i(Integer capsule_overlimit_i){
        this.capsule_overlimit_i=capsule_overlimit_i;
    }
        
    public Integer getCapsule_recount_i(){
        return capsule_recount_i;
    }
    
    @XmlElement
    public void setCapsule_recount_i(Integer capsule_recount_i){
        this.capsule_recount_i=capsule_recount_i;
    }
        
    public String getCapsule_spec_s(){
        return capsule_spec_s;
    }
    
    @XmlElement
    public void setCapsule_spec_s(String capsule_spec_s){
        this.capsule_spec_s=capsule_spec_s;
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
        
    public String getChangemold_operator_s(){
        return changemold_operator_s;
    }
    
    @XmlElement
    public void setChangemold_operator_s(String changemold_operator_s){
        this.changemold_operator_s=changemold_operator_s;
    }
        
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
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
        
    public String getCurr_materialcode_s(){
        return curr_materialcode_s;
    }
    
    @XmlElement
    public void setCurr_materialcode_s(String curr_materialcode_s){
        this.curr_materialcode_s=curr_materialcode_s;
    }
        
    public String getCurr_productspec_s(){
        return curr_productspec_s;
    }
    
    @XmlElement
    public void setCurr_productspec_s(String curr_productspec_s){
        this.curr_productspec_s=curr_productspec_s;
    }
        
    public String getDelay_time_s(){
        return delay_time_s;
    }
    
    @XmlElement
    public void setDelay_time_s(String delay_time_s){
        this.delay_time_s=delay_time_s;
    }
        
    public String getDot_s(){
        return dot_s;
    }
    
    @XmlElement
    public void setDot_s(String dot_s){
        this.dot_s=dot_s;
    }
        
    public Integer getEmbryos_point_i(){
        return embryos_point_i;
    }
    
    @XmlElement
    public void setEmbryos_point_i(Integer embryos_point_i){
        this.embryos_point_i=embryos_point_i;
    }
        
    public String getEmbryo_code_s(){
        return embryo_code_s;
    }
    
    @XmlElement
    public void setEmbryo_code_s(String embryo_code_s){
        this.embryo_code_s=embryo_code_s;
    }
        
    public String getEmbryo_spec_s(){
        return embryo_spec_s;
    }
    
    @XmlElement
    public void setEmbryo_spec_s(String embryo_spec_s){
        this.embryo_spec_s=embryo_spec_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_group_s(){
        return equip_group_s;
    }
    
    @XmlElement
    public void setEquip_group_s(String equip_group_s){
        this.equip_group_s=equip_group_s;
    }
        
    public String getEquip_ip_s(){
        return equip_ip_s;
    }
    
    @XmlElement
    public void setEquip_ip_s(String equip_ip_s){
        this.equip_ip_s=equip_ip_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public String getEquip_type_s(){
        return equip_type_s;
    }
    
    @XmlElement
    public void setEquip_type_s(String equip_type_s){
        this.equip_type_s=equip_type_s;
    }
        
    public String getFirstmold_controlflag_s(){
        return firstmold_controlflag_s;
    }
    
    @XmlElement
    public void setFirstmold_controlflag_s(String firstmold_controlflag_s){
        this.firstmold_controlflag_s=firstmold_controlflag_s;
    }
        
    public String getFirst_flag_s(){
        return first_flag_s;
    }
    
    @XmlElement
    public void setFirst_flag_s(String first_flag_s){
        this.first_flag_s=first_flag_s;
    }
        
    public String getFirst_inout_s(){
        return first_inout_s;
    }
    
    @XmlElement
    public void setFirst_inout_s(String first_inout_s){
        this.first_inout_s=first_inout_s;
    }
        
        
    public Boolean getIshavedayplay_y() {
		return ishavedayplay_y;
	}
    @XmlElement
	public void setIshavedayplay_y(Boolean ishavedayplay_y) {
		this.ishavedayplay_y = ishavedayplay_y;
	}

	public String getIsused_s(){
        return isused_s;
    }
    
    @XmlElement
    public void setIsused_s(String isused_s){
        this.isused_s=isused_s;
    }
        
    public String getLast_materialcode_s(){
        return last_materialcode_s;
    }
    
    @XmlElement
    public void setLast_materialcode_s(String last_materialcode_s){
        this.last_materialcode_s=last_materialcode_s;
    }
        
    public Integer getMax_output_i(){
        return max_output_i;
    }
    
    @XmlElement
    public void setMax_output_i(Integer max_output_i){
        this.max_output_i=max_output_i;
    }
        
    public String getMold_heatflag_s(){
        return mold_heatflag_s;
    }
    
    @XmlElement
    public void setMold_heatflag_s(String mold_heatflag_s){
        this.mold_heatflag_s=mold_heatflag_s;
    }
        
    public String getMold_id_s(){
        return mold_id_s;
    }
    
    @XmlElement
    public void setMold_id_s(String mold_id_s){
        this.mold_id_s=mold_id_s;
    }
        
    public String getMold_spec_s(){
        return mold_spec_s;
    }
    
    @XmlElement
    public void setMold_spec_s(String mold_spec_s){
        this.mold_spec_s=mold_spec_s;
    }
        
    public String getOfflinerunflag_s(){
        return offlinerunflag_s;
    }
    
    @XmlElement
    public void setOfflinerunflag_s(String offlinerunflag_s){
        this.offlinerunflag_s=offlinerunflag_s;
    }
        
    public Date getOpenmold_time_t(){
        return openmold_time_t;
    }
    
    @XmlElement
    public void setOpenmold_time_t(Date openmold_time_t){
        this.openmold_time_t=openmold_time_t;
    }
        
    public String getOperator_s(){
        return operator_s;
    }
    
    @XmlElement
    public void setOperator_s(String operator_s){
        this.operator_s=operator_s;
    }
        
    public String getPlanno_changemold_s(){
        return planno_changemold_s;
    }
    
    @XmlElement
    public void setPlanno_changemold_s(String planno_changemold_s){
        this.planno_changemold_s=planno_changemold_s;
    }
        
    public String getPlant_s(){
        return plant_s;
    }
    
    @XmlElement
    public void setPlant_s(String plant_s){
        this.plant_s=plant_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProductionver_s(){
        return productionver_s;
    }
    
    @XmlElement
    public void setProductionver_s(String productionver_s){
        this.productionver_s=productionver_s;
    }
        
    public String getProduct_date_s(){
        return product_date_s;
    }
    
    @XmlElement
    public void setProduct_date_s(String product_date_s){
        this.product_date_s=product_date_s;
    }
        
    public String getProduct_line_s(){
        return product_line_s;
    }
    
    @XmlElement
    public void setProduct_line_s(String product_line_s){
        this.product_line_s=product_line_s;
    }
        
    public String getProduct_type_s(){
        return product_type_s;
    }
    
    @XmlElement
    public void setProduct_type_s(String product_type_s){
        this.product_type_s=product_type_s;
    }
        
    public String getQs_stop_s(){
        return qs_stop_s;
    }
    
    @XmlElement
    public void setQs_stop_s(String qs_stop_s){
        this.qs_stop_s=qs_stop_s;
    }
        
    public Integer getRecord_count_i(){
        return record_count_i;
    }
    
    @XmlElement
    public void setRecord_count_i(Integer record_count_i){
        this.record_count_i=record_count_i;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getShift_id_s(){
        return shift_id_s;
    }
    
    @XmlElement
    public void setShift_id_s(String shift_id_s){
        this.shift_id_s=shift_id_s;
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
        
    public String getStop_fourhour_s(){
        return stop_fourhour_s;
    }
    
    @XmlElement
    public void setStop_fourhour_s(String stop_fourhour_s){
        this.stop_fourhour_s=stop_fourhour_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTen_materialcode_s(){
        return ten_materialcode_s;
    }
    
    @XmlElement
    public void setTen_materialcode_s(String ten_materialcode_s){
        this.ten_materialcode_s=ten_materialcode_s;
    }
        
    public String getTyrebar_controlflag_s(){
        return tyrebar_controlflag_s;
    }
    
    @XmlElement
    public void setTyrebar_controlflag_s(String tyrebar_controlflag_s){
        this.tyrebar_controlflag_s=tyrebar_controlflag_s;
    }
        
    public String getTyre_feeding_s(){
        return tyre_feeding_s;
    }
    
    @XmlElement
    public void setTyre_feeding_s(String tyre_feeding_s){
        this.tyre_feeding_s=tyre_feeding_s;
    }
        
    public String getTyre_pickver_s(){
        return tyre_pickver_s;
    }
    
    @XmlElement
    public void setTyre_pickver_s(String tyre_pickver_s){
        this.tyre_pickver_s=tyre_pickver_s;
    }
        
    public String getTyre_timever_s(){
        return tyre_timever_s;
    }
    
    @XmlElement
    public void setTyre_timever_s(String tyre_timever_s){
        this.tyre_timever_s=tyre_timever_s;
    }
        
    public String getVerification_mark_s(){
        return verification_mark_s;
    }
    
    @XmlElement
    public void setVerification_mark_s(String verification_mark_s){
        this.verification_mark_s=verification_mark_s;
    }
}
