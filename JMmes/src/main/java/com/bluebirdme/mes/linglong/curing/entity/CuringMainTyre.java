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
 * 硫化与成型轮胎主表
 * 
 * @author 李迺锟
 * @Date 2019-08-05 15:01:32
 */
@ATDefinition("C_MM_Curing_MainTyre")
@Entity
@XmlRootElement
@Table(name = "AT_C_MM_CURING_MAINTYRE")
public class CuringMainTyre extends RockWellBaseEntity {

	@Comment("机构代码")
	@Column(nullable = true, length = 20)
	private String agenc_no_s;

	@Comment("报警标记")
	@Column(nullable = true, length = 80)
	private String alarm_flag_s;

	@Comment("归档标记")
	@Column(nullable = true, length = 5)
	private String arch_flag_s;

	@Comment("当前工序质量等级")
	@Column(nullable = true, length = 80)
	private String atpresentgradecode_s;

	@Comment("外胎延时硫化标记， 1为延时硫化，其余为空")
	@Column(nullable = true, length = 20)
	private String curingtimedelay_s;

	@Comment("硫化总时间")
	@Column(nullable = true, length = 50)
	private String curingtotaltime_s;

	@Comment("首条确认")
	@Column(nullable = true, length = 80)
	private String firstflag_s;

	@Comment("轮胎毛重量")
	@Column(nullable = true, length = 80)
	private String gross_weight_s;

	@Comment("机台")
	@Column(nullable = true, length = 10)
	private String machinecode_s;

	@Comment("月计划")
	@Column(nullable = true, length = 80)
	private String monthlyplan_s;

	@Comment("结束时间")
	@Column(nullable = true, length = 0)
	private Date overtime_t;

	@Comment("当前工序")
	@Column(nullable = true, length = 80)
	private String proess_s;

	@Comment("总质量等级")
	@Column(nullable = true, length = 80)
	private String quality_grade_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 5)
	private String record_flag_s;

	@Comment("备用字段10")
	@Column(nullable = true, length = 80)
	private String reservedate10_s;

	@Comment("备用字段1")
	@Column(nullable = true, length = 80)
	private String reservedate1_s;

	@Comment("备用字段2")
	@Column(nullable = true, length = 80)
	private String reservedate2_s;

	@Comment("备用字段3")
	@Column(nullable = true, length = 80)
	private String reservedate3_s;

	@Comment("备用字段4")
	@Column(nullable = true, length = 80)
	private String reservedate4_s;

	@Comment("备用字段5")
	@Column(nullable = true, length = 80)
	private String reservedate5_s;

	@Comment("备用字段6")
	@Column(nullable = true, length = 80)
	private String reservedate6_s;

	@Comment("备用字段7")
	@Column(nullable = true, length = 80)
	private String reservedate7_s;

	@Comment("备用字段8")
	@Column(nullable = true, length = 80)
	private String reservedate8_s;

	@Comment("检测次数")
	@Column(nullable = true, length = 0)
	private Integer checknumber_i;

	@Comment("备用字段9")
	@Column(nullable = true, length = 80)
	private String reservedate9_s;

	@Comment("厂区")
	@Column(nullable = true, length = 2)
	private String s_factory_s;

	@Comment("开始时间")
	@Column(nullable = true, length = 0)
	private Date starttime_t;

	@Comment("轮胎条码")
	@Column(nullable = true, length = 30)
	private String tyrebarcode_s;

	@Comment("操作工ID")
	@Column(nullable = true, length = 50)
	private String userid_s;

	@Comment("年周号")
	@Column(nullable = true, length = 80)
	private String weeklynumber_s;

	@Comment("物料编码")
	@Column(nullable = true, length = 80)
	private String materialcode_s;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getAlarm_flag_s() {
		return alarm_flag_s;
	}

	@XmlElement
	public void setAlarm_flag_s(String alarm_flag_s) {
		this.alarm_flag_s = alarm_flag_s;
	}

	public String getArch_flag_s() {
		return arch_flag_s;
	}

	@XmlElement
	public void setArch_flag_s(String arch_flag_s) {
		this.arch_flag_s = arch_flag_s;
	}

	public Integer getChecknumber_i() {
		return checknumber_i;
	}

	public void setChecknumber_i(Integer checknumber_i) {
		this.checknumber_i = checknumber_i;
	}

	public String getAtpresentgradecode_s() {
		return atpresentgradecode_s;
	}

	@XmlElement
	public void setAtpresentgradecode_s(String atpresentgradecode_s) {
		this.atpresentgradecode_s = atpresentgradecode_s;
	}

	public String getCuringtimedelay_s() {
		return curingtimedelay_s;
	}

	@XmlElement
	public void setCuringtimedelay_s(String curingtimedelay_s) {
		this.curingtimedelay_s = curingtimedelay_s;
	}

	public String getCuringtotaltime_s() {
		return curingtotaltime_s;
	}

	@XmlElement
	public void setCuringtotaltime_s(String curingtotaltime_s) {
		this.curingtotaltime_s = curingtotaltime_s;
	}

	public String getFirstflag_s() {
		return firstflag_s;
	}

	@XmlElement
	public void setFirstflag_s(String firstflag_s) {
		this.firstflag_s = firstflag_s;
	}

	public String getGross_weight_s() {
		return gross_weight_s;
	}

	@XmlElement
	public void setGross_weight_s(String gross_weight_s) {
		this.gross_weight_s = gross_weight_s;
	}

	public String getMachinecode_s() {
		return machinecode_s;
	}

	@XmlElement
	public void setMachinecode_s(String machinecode_s) {
		this.machinecode_s = machinecode_s;
	}

	public String getMonthlyplan_s() {
		return monthlyplan_s;
	}

	@XmlElement
	public void setMonthlyplan_s(String monthlyplan_s) {
		this.monthlyplan_s = monthlyplan_s;
	}

	public Date getOvertime_t() {
		return overtime_t;
	}

	@XmlElement
	public void setOvertime_t(Date overtime_t) {
		this.overtime_t = overtime_t;
	}

	public String getProess_s() {
		return proess_s;
	}

	@XmlElement
	public void setProess_s(String proess_s) {
		this.proess_s = proess_s;
	}

	public String getQuality_grade_s() {
		return quality_grade_s;
	}

	@XmlElement
	public void setQuality_grade_s(String quality_grade_s) {
		this.quality_grade_s = quality_grade_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getReservedate10_s() {
		return reservedate10_s;
	}

	@XmlElement
	public void setReservedate10_s(String reservedate10_s) {
		this.reservedate10_s = reservedate10_s;
	}

	public String getReservedate1_s() {
		return reservedate1_s;
	}

	@XmlElement
	public void setReservedate1_s(String reservedate1_s) {
		this.reservedate1_s = reservedate1_s;
	}

	public String getReservedate2_s() {
		return reservedate2_s;
	}

	@XmlElement
	public void setReservedate2_s(String reservedate2_s) {
		this.reservedate2_s = reservedate2_s;
	}

	public String getReservedate3_s() {
		return reservedate3_s;
	}

	@XmlElement
	public void setReservedate3_s(String reservedate3_s) {
		this.reservedate3_s = reservedate3_s;
	}

	public String getReservedate4_s() {
		return reservedate4_s;
	}

	@XmlElement
	public void setReservedate4_s(String reservedate4_s) {
		this.reservedate4_s = reservedate4_s;
	}

	public String getReservedate5_s() {
		return reservedate5_s;
	}

	@XmlElement
	public void setReservedate5_s(String reservedate5_s) {
		this.reservedate5_s = reservedate5_s;
	}

	public String getReservedate6_s() {
		return reservedate6_s;
	}

	@XmlElement
	public void setReservedate6_s(String reservedate6_s) {
		this.reservedate6_s = reservedate6_s;
	}

	public String getReservedate7_s() {
		return reservedate7_s;
	}

	@XmlElement
	public void setReservedate7_s(String reservedate7_s) {
		this.reservedate7_s = reservedate7_s;
	}

	public String getReservedate8_s() {
		return reservedate8_s;
	}

	@XmlElement
	public void setReservedate8_s(String reservedate8_s) {
		this.reservedate8_s = reservedate8_s;
	}

	public String getReservedate9_s() {
		return reservedate9_s;
	}

	@XmlElement
	public void setReservedate9_s(String reservedate9_s) {
		this.reservedate9_s = reservedate9_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public Date getStarttime_t() {
		return starttime_t;
	}

	@XmlElement
	public void setStarttime_t(Date starttime_t) {
		this.starttime_t = starttime_t;
	}

	public String getTyrebarcode_s() {
		return tyrebarcode_s;
	}

	@XmlElement
	public void setTyrebarcode_s(String tyrebarcode_s) {
		this.tyrebarcode_s = tyrebarcode_s;
	}

	public String getUserid_s() {
		return userid_s;
	}

	@XmlElement
	public void setUserid_s(String userid_s) {
		this.userid_s = userid_s;
	}

	public String getWeeklynumber_s() {
		return weeklynumber_s;
	}

	@XmlElement
	public void setWeeklynumber_s(String weeklynumber_s) {
		this.weeklynumber_s = weeklynumber_s;
	}

	public String getMaterialcode_s() {
		return materialcode_s;
	}

	@XmlElement
	public void setMaterialcode_s(String materialcode_s) {
		this.materialcode_s = materialcode_s;
	}

}
