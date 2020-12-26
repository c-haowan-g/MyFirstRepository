/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

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
 * 组织机构日志表
 * 
 * @author 刘朋
 * @Date 2018-10-17 09:02:58
 */
@ATDefinition("INT_HR_ORG_LOG")
@Entity
@XmlRootElement
@Table(name = "AT_INT_HR_ORG_LOG")
public class OrgLog extends RockWellBaseEntity {

	@Comment("更新标记，A新增，D删除，U修改")
	@Column(nullable = true, length = 80)
	private String iftrans_s;

	@Comment("备注")
	@Column(nullable = true, length = 200)
	private String memo_s;

	@Comment("主键ID(MES部门表)")
	@Column(nullable = true, length = 0)
	private Integer mes_id_i;

	@Comment("父ID(MES部门表)")
	@Column(nullable = true, length = 0)
	private Integer mes_pid_i;

	@Comment("部门名称")
	@Column(nullable = true, length = 200)
	private String name_s;

	@Comment("组织ID")
	@Column(nullable = true, length = 200)
	private String org_id_s;

	@Comment("父组织ID")
	@Column(nullable = true, length = 200)
	private String parent_id_s;

	@Comment("接收时间")
	@Column(nullable = true, length = 0)
	private Date receive_time_t;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 200)
	private String record_flag_s;

	@Comment("排序")
	@Column(nullable = true, length = 0)
	private Integer sortno_i;

	@Comment("状态：Y-有效，N-无效")
	@Column(nullable = true, length = 80)
	private String state_s;

	public String getIftrans_s() {
		return iftrans_s;
	}

	@XmlElement
	public void setIftrans_s(String iftrans_s) {
		this.iftrans_s = iftrans_s;
	}

	public String getMemo_s() {
		return memo_s;
	}

	@XmlElement
	public void setMemo_s(String memo_s) {
		this.memo_s = memo_s;
	}

	public Integer getMes_id_i() {
		return mes_id_i;
	}

	@XmlElement
	public void setMes_id_i(Integer mes_id_i) {
		this.mes_id_i = mes_id_i;
	}

	public Integer getMes_pid_i() {
		return mes_pid_i;
	}

	@XmlElement
	public void setMes_pid_i(Integer mes_pid_i) {
		this.mes_pid_i = mes_pid_i;
	}

	public String getName_s() {
		return name_s;
	}

	@XmlElement
	public void setName_s(String name_s) {
		this.name_s = name_s;
	}

	public String getOrg_id_s() {
		return org_id_s;
	}

	@XmlElement
	public void setOrg_id_s(String org_id_s) {
		this.org_id_s = org_id_s;
	}

	public String getParent_id_s() {
		return parent_id_s;
	}

	@XmlElement
	public void setParent_id_s(String parent_id_s) {
		this.parent_id_s = parent_id_s;
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

	public Integer getSortno_i() {
		return sortno_i;
	}

	@XmlElement
	public void setSortno_i(Integer sortno_i) {
		this.sortno_i = sortno_i;
	}

	public String getState_s() {
		return state_s;
	}

	@XmlElement
	public void setState_s(String state_s) {
		this.state_s = state_s;
	}

}
