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
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 硫化报警信息表
 * 
 * @author 刘朋
 * @Date 2018-11-27 16:07:15
 */
@ATDefinition("C_QM_ALERTSRECORD")
@Entity
@XmlRootElement
@Table(name = "AT_C_QM_ALERTSRECORD")
public class Alertsrecord extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 80)
	private String agenc_no_s;

	@Comment("报警来源")
	@Column(nullable = true, length = 80)
	private String alarm_from_s;

	@Comment("报警次数")
	@Column(nullable = true, length = 0)
	private Integer alarm_number_i;

	@Comment("报警代码")
	@Column(nullable = true, length = 80)
	private String alert_code_s;

	@Comment("报警内容")
	@Column(nullable = true, length = 400)
	private String alert_content_s;

	@Comment("报警等级")
	@Column(nullable = true, length = 80)
	private String alert_level_s;

	@Comment("报警处理状态基础数据234  1未处理 2已下发 3已放行 4已恢复")
	@Column(nullable = false, length = 80)
	private String alert_status_s;

	@Comment("报警时间")
	@Column(nullable = true, length = 80)
	private String alert_time_s;

	@Comment("报警值")
	@Column(nullable = true, length = 80)
	private String alert_value_s;

	@Comment("交换前条码")
	@Column(nullable = true, length = 80)
	private String change_barcode_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 0)
	private Date created_time_t;

	@Comment("机台条码")
	@Column(nullable = false, length = 80)
	private String equip_code_s;

	@Comment("操作时间")
	@Column(nullable = true, length = 0)
	private Date operatetime_t;

	@Comment("操作人")
	@Column(nullable = true, length = 80)
	private String operator_s;

	@Comment("质量确认人")
	@Column(nullable = true, length = 80)
	private String quality_confirmor_s;

	@Comment("质量确认时间")
	@Column(nullable = true, length = 0)
	private Date quality_confirmtime_t;

	@Comment("确认质量")
	@Column(nullable = true, length = 80)
	private String quality_s;

	@Comment("记录标志,A可用，D删除")
	@Column(nullable = true, length = 80)
	private String record_flag_s;

	@Comment("恢复时间")
	@Column(nullable = true, length = 80)
	private String recovery_time_s;

	@Comment("恢复值")
	@Column(nullable = true, length = 80)
	private String recovery_value_s;

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
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	@Comment("轮胎条码")
	@Column(nullable = true, length = 80)
	private String tyre_barcode_s;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getAlarm_from_s() {
		return alarm_from_s;
	}

	@XmlElement
	public void setAlarm_from_s(String alarm_from_s) {
		this.alarm_from_s = alarm_from_s;
	}

	public Integer getAlarm_number_i() {
		return alarm_number_i;
	}

	@XmlElement
	public void setAlarm_number_i(Integer alarm_number_i) {
		this.alarm_number_i = alarm_number_i;
	}

	public String getAlert_code_s() {
		return alert_code_s;
	}

	@XmlElement
	public void setAlert_code_s(String alert_code_s) {
		this.alert_code_s = alert_code_s;
	}

	public String getAlert_content_s() {
		return alert_content_s;
	}

	@XmlElement
	public void setAlert_content_s(String alert_content_s) {
		this.alert_content_s = alert_content_s;
	}

	public String getAlert_level_s() {
		return alert_level_s;
	}

	@XmlElement
	public void setAlert_level_s(String alert_level_s) {
		this.alert_level_s = alert_level_s;
	}

	public String getAlert_status_s() {
		return alert_status_s;
	}

	@XmlElement
	public void setAlert_status_s(String alert_status_s) {
		this.alert_status_s = alert_status_s;
	}

	public String getAlert_time_s() {
		return alert_time_s;
	}

	@XmlElement
	public void setAlert_time_s(String alert_time_s) {
		this.alert_time_s = alert_time_s;
	}

	public String getAlert_value_s() {
		return alert_value_s;
	}

	@XmlElement
	public void setAlert_value_s(String alert_value_s) {
		this.alert_value_s = alert_value_s;
	}

	public String getChange_barcode_s() {
		return change_barcode_s;
	}

	@XmlElement
	public void setChange_barcode_s(String change_barcode_s) {
		this.change_barcode_s = change_barcode_s;
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

	public Date getOperatetime_t() {
		return operatetime_t;
	}

	@XmlElement
	public void setOperatetime_t(Date operatetime_t) {
		this.operatetime_t = operatetime_t;
	}

	public String getOperator_s() {
		return operator_s;
	}

	@XmlElement
	public void setOperator_s(String operator_s) {
		this.operator_s = operator_s;
	}

	public String getQuality_confirmor_s() {
		return quality_confirmor_s;
	}

	@XmlElement
	public void setQuality_confirmor_s(String quality_confirmor_s) {
		this.quality_confirmor_s = quality_confirmor_s;
	}

	public Date getQuality_confirmtime_t() {
		return quality_confirmtime_t;
	}

	@XmlElement
	public void setQuality_confirmtime_t(Date quality_confirmtime_t) {
		this.quality_confirmtime_t = quality_confirmtime_t;
	}

	public String getQuality_s() {
		return quality_s;
	}

	@XmlElement
	public void setQuality_s(String quality_s) {
		this.quality_s = quality_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getRecovery_time_s() {
		return recovery_time_s;
	}

	@XmlElement
	public void setRecovery_time_s(String recovery_time_s) {
		this.recovery_time_s = recovery_time_s;
	}

	public String getRecovery_value_s() {
		return recovery_value_s;
	}

	@XmlElement
	public void setRecovery_value_s(String recovery_value_s) {
		this.recovery_value_s = recovery_value_s;
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

	public String getTyre_barcode_s() {
		return tyre_barcode_s;
	}

	@XmlElement
	public void setTyre_barcode_s(String tyre_barcode_s) {
		this.tyre_barcode_s = tyre_barcode_s;
	}

}
