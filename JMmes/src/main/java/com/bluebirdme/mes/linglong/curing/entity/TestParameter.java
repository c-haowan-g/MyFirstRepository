/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 硫化日计划关联参数表
 * 
 * @author 刘朋
 * @Date 2018-09-19 11:18:13
 */
@ATDefinition("C_MM_PlanCuringParameter")
@Entity
@Table(name = "AT_C_MM_PLANCURINGPARAMETER")
public class TestParameter extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = true, length = 80)
	private String agenc_no_s;

	@Comment("修改人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = true, length = 80)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 0)
	private Date created_time_t;

	@Comment("机台号")
	@Column(nullable = true, length = 80)
	private String equip_code_s;

	@Comment("试验胎参数值")
	@Column(nullable = true, length = 80)
	private String formulapara_id_s;

	@Comment("工艺来源（C 硫化 B 成型）")
	@Column(nullable = true, length = 80)
	private String formula_from_s;

	@Comment("工艺配方ID")
	@Column(nullable = true, length = 80)
	private String formula_id_s;

	@Comment("物料编码(40位)")
	@Column(nullable = true, length = 80)
	private String material_code_s;

	@Comment("参数代码")
	@Column(nullable = true, length = 80)
	private String parameter_code_s;

	@Comment("参数逻辑地址")
	@Column(nullable = true, length = 80)
	private String parameter_logicaddress_s;

	@Comment("参数名称")
	@Column(nullable = true, length = 80)
	private String parameter_name_s;

	@Comment("参数值")
	@Column(nullable = true, length = 80)
	private String parameter_value_s;

	@Comment("日计划号")
	@Column(nullable = true, length = 80)
	private String producting_dayplan_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = false, length = 80)
	private String record_flag_s;

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

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = true, length = 80)
	private String s_factory_s;

	@Comment("试验胎标识位(0 不是 1 是)")
	@Column(nullable = true, length = 80)
	private String test_flag_s;

	@Comment("胎胚物料代码")
	@Column(nullable = true, length = 80)
	private String tyre_materialcode_s;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
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

	public String getEquip_code_s() {
		return equip_code_s;
	}

	@XmlElement
	public void setEquip_code_s(String equip_code_s) {
		this.equip_code_s = equip_code_s;
	}

	public String getFormulapara_id_s() {
		return formulapara_id_s;
	}

	@XmlElement
	public void setFormulapara_id_s(String formulapara_id_s) {
		this.formulapara_id_s = formulapara_id_s;
	}

	public String getFormula_from_s() {
		return formula_from_s;
	}

	@XmlElement
	public void setFormula_from_s(String formula_from_s) {
		this.formula_from_s = formula_from_s;
	}

	public String getFormula_id_s() {
		return formula_id_s;
	}

	@XmlElement
	public void setFormula_id_s(String formula_id_s) {
		this.formula_id_s = formula_id_s;
	}

	public String getMaterial_code_s() {
		return material_code_s;
	}

	@XmlElement
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public String getParameter_code_s() {
		return parameter_code_s;
	}

	@XmlElement
	public void setParameter_code_s(String parameter_code_s) {
		this.parameter_code_s = parameter_code_s;
	}

	public String getParameter_logicaddress_s() {
		return parameter_logicaddress_s;
	}

	@XmlElement
	public void setParameter_logicaddress_s(String parameter_logicaddress_s) {
		this.parameter_logicaddress_s = parameter_logicaddress_s;
	}

	public String getParameter_name_s() {
		return parameter_name_s;
	}

	@XmlElement
	public void setParameter_name_s(String parameter_name_s) {
		this.parameter_name_s = parameter_name_s;
	}

	public String getParameter_value_s() {
		return parameter_value_s;
	}

	@XmlElement
	public void setParameter_value_s(String parameter_value_s) {
		this.parameter_value_s = parameter_value_s;
	}

	public String getProducting_dayplan_s() {
		return producting_dayplan_s;
	}

	@XmlElement
	public void setProducting_dayplan_s(String producting_dayplan_s) {
		this.producting_dayplan_s = producting_dayplan_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
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

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getTest_flag_s() {
		return test_flag_s;
	}

	@XmlElement
	public void setTest_flag_s(String test_flag_s) {
		this.test_flag_s = test_flag_s;
	}

	public String getTyre_materialcode_s() {
		return tyre_materialcode_s;
	}

	@XmlElement
	public void setTyre_materialcode_s(String tyre_materialcode_s) {
		this.tyre_materialcode_s = tyre_materialcode_s;
	}

}
