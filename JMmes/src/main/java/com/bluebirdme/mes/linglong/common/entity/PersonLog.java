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
 * 用户管理日志表
 * 
 * @author 刘朋
 * @Date 2018-10-17 10:49:36
 */
@ATDefinition("INT_HR_PERSON_LOG")
@Entity
@XmlRootElement
@Table(name = "AT_INT_HR_PERSON_LOG")
public class PersonLog extends RockWellBaseEntity {

	@Comment("账户状态：正常、锁定")
	@Column(nullable = true, length = 80)
	private String accountstate_s;

	@Comment("电子邮件")
	@Column(nullable = true, length = 200)
	private String email_s;

	@Comment("家庭住址")
	@Column(nullable = true, length = 200)
	private String home_address_s;

	@Comment("更新标记，A新增，D删除，U修改")
	@Column(nullable = true, length = 80)
	private String iftrans_s;

	@Comment("主键ID(MES用户表)")
	@Column(nullable = true, length = 0)
	private Integer mes_id_i;

	@Comment("部门ID(MES用户表)")
	@Column(nullable = true, length = 0)
	private Integer mes_org_id_i;

	@Comment("部门ID")
	@Column(nullable = true, length = 200)
	private String org_id_s;

	@Comment("电话号码")
	@Column(nullable = true, length = 200)
	private String phone_s;

	@Comment("接收时间")
	@Column(nullable = true, length = 0)
	private Date receive_time_t;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 80)
	private String record_flag_s;

	@Comment("性别：存储汉字 1-男，2-女")
	@Column(nullable = true, length = 20)
	private String sex_s;

	@Comment("在职状态：存储汉字 Y-在职，N-离职")
	@Column(nullable = true, length = 20)
	private String state_s;

	@Comment("用户工号")
	@Column(nullable = true, length = 200)
	private String usercode_s;

	@Comment("用户名")
	@Column(nullable = true, length = 200)
	private String username_s;

	@Comment("密码（加密）")
	@Column(nullable = true, length = 200)
	private String userpassword_s;

	public String getAccountstate_s() {
		return accountstate_s;
	}

	@XmlElement
	public void setAccountstate_s(String accountstate_s) {
		this.accountstate_s = accountstate_s;
	}

	public String getEmail_s() {
		return email_s;
	}

	@XmlElement
	public void setEmail_s(String email_s) {
		this.email_s = email_s;
	}

	public String getHome_address_s() {
		return home_address_s;
	}

	@XmlElement
	public void setHome_address_s(String home_address_s) {
		this.home_address_s = home_address_s;
	}

	public String getIftrans_s() {
		return iftrans_s;
	}

	@XmlElement
	public void setIftrans_s(String iftrans_s) {
		this.iftrans_s = iftrans_s;
	}

	public Integer getMes_id_i() {
		return mes_id_i;
	}

	@XmlElement
	public void setMes_id_i(Integer mes_id_i) {
		this.mes_id_i = mes_id_i;
	}

	public Integer getMes_org_id_i() {
		return mes_org_id_i;
	}

	@XmlElement
	public void setMes_org_id_i(Integer mes_org_id_i) {
		this.mes_org_id_i = mes_org_id_i;
	}

	public String getOrg_id_s() {
		return org_id_s;
	}

	@XmlElement
	public void setOrg_id_s(String org_id_s) {
		this.org_id_s = org_id_s;
	}

	public String getPhone_s() {
		return phone_s;
	}

	@XmlElement
	public void setPhone_s(String phone_s) {
		this.phone_s = phone_s;
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

	public String getSex_s() {
		return sex_s;
	}

	@XmlElement
	public void setSex_s(String sex_s) {
		this.sex_s = sex_s;
	}

	public String getState_s() {
		return state_s;
	}

	@XmlElement
	public void setState_s(String state_s) {
		this.state_s = state_s;
	}

	public String getUsercode_s() {
		return usercode_s;
	}

	@XmlElement
	public void setUsercode_s(String usercode_s) {
		this.usercode_s = usercode_s;
	}

	public String getUsername_s() {
		return username_s;
	}

	@XmlElement
	public void setUsername_s(String username_s) {
		this.username_s = username_s;
	}

	public String getUserpassword_s() {
		return userpassword_s;
	}

	@XmlElement
	public void setUserpassword_s(String userpassword_s) {
		this.userpassword_s = userpassword_s;
	}

}
