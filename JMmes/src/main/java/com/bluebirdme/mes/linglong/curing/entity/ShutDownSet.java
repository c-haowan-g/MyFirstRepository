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
 * 硫化报警停机参数
 * 
 * @author 周清玉
 * @Date 2018-08-20 08:42:24
 */
@ATDefinition("C_QM_ShutDownSet")
@Entity
@XmlRootElement
@Table(name = "AT_C_QM_SHUTDOWNSET")
public class ShutDownSet extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 160)
	private String agenc_no_s;

	@Comment("报警停机次数")
	@Column(nullable = true, length = 160)
	private String alarm_number_s;

	@Comment("归档标记")
	@Column(nullable = true, length = 160)
	private String arch_flag_s;

	@Comment("修改人")
	@Column(nullable = true, length = 160)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 11)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = true, length = 160)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 11)
	private Date created_time_t;

	@Comment("轮胎判级 报警等级")
	@Column(nullable = true, length = 160)
	private String judge_lever_s;

	@Comment("备注")
	@Column(nullable = true, length = 200)
	private String memo_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 160)
	private String record_flag_s;

	@Comment("时间范围  秒")
	@Column(nullable = true, length = 160)
	private String set_time_s;

	@Comment("备用字段1")
	@Column(nullable = true, length = 160)
	private String spare1_s;

	@Comment("备用字段2")
	@Column(nullable = true, length = 160)
	private String spare2_s;

	@Comment("备用字段3")
	@Column(nullable = true, length = 160)
	private String spare3_s;

	@Comment("备用字段4")
	@Column(nullable = true, length = 160)
	private String spare4_s;

	@Comment("备用字段5")
	@Column(nullable = true, length = 160)
	private String spare5_s;

	@Comment("工厂")
	@Column(nullable = false, length = 160)
	private String s_factory_s;

	@Comment("有效标识  1:有效 0 无效")
	@Column(nullable = true, length = 160)
	private String valid_flag_s;

	@Comment("CHANGED_TIME_U")
	@Column(nullable = true, length = 11)
	private Date changed_time_u;

	@Comment("CREATED_TIME_U")
	@Column(nullable = true, length = 11)
	private Date created_time_u;

	@Comment("CREATED_TIME_Z")
	@Column(nullable = true, length = 128)
	private String created_time_z;

	@Comment("CHANGED_TIME_Z")
	@Column(nullable = true, length = 128)
	private String changed_time_z;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getAlarm_number_s() {
		return alarm_number_s;
	}

	@XmlElement
	public void setAlarm_number_s(String alarm_number_s) {
		this.alarm_number_s = alarm_number_s;
	}

	public String getArch_flag_s() {
		return arch_flag_s;
	}

	@XmlElement
	public void setArch_flag_s(String arch_flag_s) {
		this.arch_flag_s = arch_flag_s;
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

	public String getJudge_lever_s() {
		return judge_lever_s;
	}

	@XmlElement
	public void setJudge_lever_s(String judge_lever_s) {
		this.judge_lever_s = judge_lever_s;
	}

	public String getMemo_s() {
		return memo_s;
	}

	@XmlElement
	public void setMemo_s(String memo_s) {
		this.memo_s = memo_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getSet_time_s() {
		return set_time_s;
	}

	@XmlElement
	public void setSet_time_s(String set_time_s) {
		this.set_time_s = set_time_s;
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

	public String getValid_flag_s() {
		return valid_flag_s;
	}

	@XmlElement
	public void setValid_flag_s(String valid_flag_s) {
		this.valid_flag_s = valid_flag_s;
	}

	public Date getChanged_time_u() {
		return changed_time_u;
	}

	@XmlElement
	public void setChanged_time_u(Date changed_time_u) {
		this.changed_time_u = changed_time_u;
	}

	public Date getCreated_time_u() {
		return created_time_u;
	}

	@XmlElement
	public void setCreated_time_u(Date created_time_u) {
		this.created_time_u = created_time_u;
	}

	public String getCreated_time_z() {
		return created_time_z;
	}

	@XmlElement
	public void setCreated_time_z(String created_time_z) {
		this.created_time_z = created_time_z;
	}

	public String getChanged_time_z() {
		return changed_time_z;
	}

	@XmlElement
	public void setChanged_time_z(String changed_time_z) {
		this.changed_time_z = changed_time_z;
	}

}
