/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 硫化月计划编制
 * 
 * @author lp
 * @Date 2018-08-07 13:15:32
 */
@Entity
@XmlRootElement
@Table(name = "AT_C_PP_SapProductionPlan")
@ATDefinition("C_PP_SapProductionPlan")
public class CuringProductionMonthPlan extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 80)
	private String agenc_no_s = "8023";

	@Comment("机构名称")
	@Column(nullable = false, length = 80)
	private String agen_name_s = "荆门";

	@Comment("BOM标识")
	@Column(nullable = true, length = 80)
	private String bom_flag_s;

	@Comment("更新人编号")
	@Column(nullable = true, length = 100)
	private String changed_by_s;

	@Comment("更新人时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = true, length = 100)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 0)
	private Date created_time_t;

	@Comment("花纹")
	@Column(nullable = true, length = 80)
	private String flowershape_s;

	@Comment("层级")
	@Column(nullable = true, length = 80)
	private String layclass_s;

	@Comment("物料编码")
	@Column(nullable = true, length = 80)
	private String material_code_s;

	@Comment("物料组")
	@Column(nullable = true, length = 80)
	private String material_group_s;

	@Comment("物料描述")
	@Column(nullable = true, length = 160)
	private String material_name_s;

	@Comment("备注")
	@Column(nullable = true, length = 100)
	private String memo_s;

	@Comment("MES增加标识")
	@Column(nullable = true, length = 80)
	private String mes_flag_s;

	@Comment("月份")
	@Column(nullable = false, length = 0)
	private Integer month_i;

	@Comment("订单号")
	@Column(nullable = true, length = 80)
	private String order_sap_s;

	@Comment("超产百分比")
	@Column(nullable = true, length = 80)
	private String overproduction_percent_s;

	@Comment("月计划号")
	@Column(nullable = false, length = 80)
	private String planno_month_s;

	@Comment("计划生产时间")
	@Column(nullable = true, length = 0)
	private Date planproduct_time_t;

	@Comment("工厂号")
	@Column(nullable = false, length = 80)
	private String plant_s = "8023";

	@Comment("计划结束时间")
	@Column(nullable = true, length = 0)
	private Date plan_endtime_t;

	@Comment("计划开始时间")
	@Column(nullable = true, length = 0)
	private Date plan_starttime_t;

	@Comment("计划状态")
	@Column(nullable = true, length = 80)
	private String plan_status_s;

	@Comment("计划实际生产量")
	@Column(nullable = true, length = 0)
	private BigDecimal quantity_actual_f;

	@Comment("月计划数量")
	@Column(nullable = false, length = 0)
	private BigDecimal quantity_plan_f;

	@Comment("已排产数量")
	@Column(nullable = true, length = 0)
	private BigDecimal quantity_producted_f;

	@Comment("接收时间")
	@Column(nullable = true, length = 0)
	private Date receive_time_t;

	@Comment("记录标志")
	@Column(nullable = true, length = 80)
	private String record_flag_s;

	@Comment("配方标识")
	@Column(nullable = true, length = 80)
	private String repicp_flag_s;

	@Comment("SAP原数量")
	@Column(nullable = true, length = 0)
	private BigDecimal sap_quantity_original_f;

	@Comment("备用字段1")
	@Column(nullable = true, length = 80)
	private String spare1_s;

	@Comment("备用字段2")
	@Column(nullable = true, length = 80)
	private String spare2_s;

	@Comment("备用字段3")
	@Column(nullable = true, length = 80)
	private String spare3_s;

	@Comment("备用字段4")
	@Column(nullable = true, length = 80)
	private String spare4_s;

	@Comment("备用字段5")
	@Column(nullable = true, length = 80)
	private String spare5_s;

	@Comment("规格")
	@Column(nullable = true, length = 100)
	private String specification_s;

	@Comment("分厂号")
	@Column(nullable = true, length = 80)
	private String subplant_s;

	@Comment("工厂（E全钢 9半钢）")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getAgen_name_s() {
		return agen_name_s;
	}

	@XmlElement
	public void setAgen_name_s(String agen_name_s) {
		this.agen_name_s = agen_name_s;
	}

	public String getBom_flag_s() {
		return bom_flag_s;
	}

	@XmlElement
	public void setBom_flag_s(String bom_flag_s) {
		this.bom_flag_s = bom_flag_s;
	}

	public String getChanged_by_s() {
		return changed_by_s;
	}

	@XmlElement
	public void setChanged_by_s(String changed_by_s) {
		this.changed_by_s = changed_by_s;
	}

	public Date getChanged_time_t() {
		return changed_time_t;
	}

	@XmlElement
	public void setChanged_time_t(Date changed_time_t) {
		this.changed_time_t = changed_time_t;
	}

	public String getCreated_by_s() {
		return created_by_s;
	}

	@XmlElement
	public void setCreated_by_s(String created_by_s) {
		this.created_by_s = created_by_s;
	}

	public Date getCreated_time_t() {
		return created_time_t;
	}

	@XmlElement
	public void setCreated_time_t(Date created_time_t) {
		this.created_time_t = created_time_t;
	}

	public String getFlowershape_s() {
		return flowershape_s;
	}

	@XmlElement
	public void setFlowershape_s(String flowershape_s) {
		this.flowershape_s = flowershape_s;
	}

	public String getLayclass_s() {
		return layclass_s;
	}

	@XmlElement
	public void setLayclass_s(String layclass_s) {
		this.layclass_s = layclass_s;
	}

	public String getMaterial_code_s() {
		return material_code_s;
	}

	@XmlElement
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public String getMaterial_group_s() {
		return material_group_s;
	}

	@XmlElement
	public void setMaterial_group_s(String material_group_s) {
		this.material_group_s = material_group_s;
	}

	public String getMaterial_name_s() {
		return material_name_s;
	}

	@XmlElement
	public void setMaterial_name_s(String material_name_s) {
		this.material_name_s = material_name_s;
	}

	public String getMemo_s() {
		return memo_s;
	}

	@XmlElement
	public void setMemo_s(String memo_s) {
		this.memo_s = memo_s;
	}

	public String getMes_flag_s() {
		return mes_flag_s;
	}

	@XmlElement
	public void setMes_flag_s(String mes_flag_s) {
		this.mes_flag_s = mes_flag_s;
	}

	public Integer getMonth_i() {
		return month_i;
	}

	@XmlElement
	public void setMonth_i(Integer month_i) {
		this.month_i = month_i;
	}

	public String getOrder_sap_s() {
		return order_sap_s;
	}

	@XmlElement
	public void setOrder_sap_s(String order_sap_s) {
		this.order_sap_s = order_sap_s;
	}

	public String getOverproduction_percent_s() {
		return overproduction_percent_s;
	}

	@XmlElement
	public void setOverproduction_percent_s(String overproduction_percent_s) {
		this.overproduction_percent_s = overproduction_percent_s;
	}

	public String getPlanno_month_s() {
		return planno_month_s;
	}

	@XmlElement
	public void setPlanno_month_s(String planno_month_s) {
		this.planno_month_s = planno_month_s;
	}

	public Date getPlanproduct_time_t() {
		return planproduct_time_t;
	}

	@XmlElement
	public void setPlanproduct_time_t(Date planproduct_time_t) {
		this.planproduct_time_t = planproduct_time_t;
	}

	public String getPlant_s() {
		return plant_s;
	}

	@XmlElement
	public void setPlant_s(String plant_s) {
		this.plant_s = plant_s;
	}

	public Date getPlan_endtime_t() {
		return plan_endtime_t;
	}

	@XmlElement
	public void setPlan_endtime_t(Date plan_endtime_t) {
		this.plan_endtime_t = plan_endtime_t;
	}

	public Date getPlan_starttime_t() {
		return plan_starttime_t;
	}

	@XmlElement
	public void setPlan_starttime_t(Date plan_starttime_t) {
		this.plan_starttime_t = plan_starttime_t;
	}

	public String getPlan_status_s() {
		return plan_status_s;
	}

	@XmlElement
	public void setPlan_status_s(String plan_status_s) {
		this.plan_status_s = plan_status_s;
	}

	public BigDecimal getQuantity_actual_f() {
		return quantity_actual_f;
	}

	@XmlElement
	public void setQuantity_actual_f(BigDecimal quantity_actual_f) {
		this.quantity_actual_f = quantity_actual_f;
	}

	public BigDecimal getQuantity_plan_f() {
		return quantity_plan_f;
	}

	@XmlElement
	public void setQuantity_plan_f(BigDecimal quantity_plan_f) {
		this.quantity_plan_f = quantity_plan_f;
	}

	public BigDecimal getQuantity_producted_f() {
		return quantity_producted_f;
	}

	@XmlElement
	public void setQuantity_producted_f(BigDecimal quantity_producted_f) {
		this.quantity_producted_f = quantity_producted_f;
	}

	public Date getReceive_time_t() {
		return receive_time_t;
	}

	@XmlElement
	public void setReceive_time_t(Date receive_time_t) {
		this.receive_time_t = receive_time_t;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getRepicp_flag_s() {
		return repicp_flag_s;
	}

	@XmlElement
	public void setRepicp_flag_s(String repicp_flag_s) {
		this.repicp_flag_s = repicp_flag_s;
	}

	public BigDecimal getSap_quantity_original_f() {
		return sap_quantity_original_f;
	}

	@XmlElement
	public void setSap_quantity_original_f(BigDecimal sap_quantity_original_f) {
		this.sap_quantity_original_f = sap_quantity_original_f;
	}

	public String getSpare1_s() {
		return spare1_s;
	}

	@XmlElement
	public void setSpare1_s(String spare1_s) {
		this.spare1_s = spare1_s;
	}

	public String getSpare2_s() {
		return spare2_s;
	}

	@XmlElement
	public void setSpare2_s(String spare2_s) {
		this.spare2_s = spare2_s;
	}

	public String getSpare3_s() {
		return spare3_s;
	}

	@XmlElement
	public void setSpare3_s(String spare3_s) {
		this.spare3_s = spare3_s;
	}

	public String getSpare4_s() {
		return spare4_s;
	}

	@XmlElement
	public void setSpare4_s(String spare4_s) {
		this.spare4_s = spare4_s;
	}

	public String getSpare5_s() {
		return spare5_s;
	}

	@XmlElement
	public void setSpare5_s(String spare5_s) {
		this.spare5_s = spare5_s;
	}

	public String getSpecification_s() {
		return specification_s;
	}

	@XmlElement
	public void setSpecification_s(String specification_s) {
		this.specification_s = specification_s;
	}

	public String getSubplant_s() {
		return subplant_s;
	}

	@XmlElement
	public void setSubplant_s(String subplant_s) {
		this.subplant_s = subplant_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}
}
