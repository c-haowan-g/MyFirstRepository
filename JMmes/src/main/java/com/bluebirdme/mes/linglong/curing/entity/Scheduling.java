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
 * 人员排班查询
 * 
 * @author 刘朋
 * @Date 2018-08-20 15:33:47
 */
@ATDefinition("C_MM_Scheduling")
@Entity
@XmlRootElement
@Table(name = "AT_C_MM_SCHEDULING")
public class Scheduling extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 160)
	private String agenc_no_s;

	@Comment("更新人编号")
	@Column(nullable = true, length = 160)
	private String changed_by_s;

	@Comment("更新人时间")
	@Column(nullable = true, length = 11)
	private Date changed_time_t;

	@Comment("班次")
	@Column(nullable = true, length = 160)
	private String class_id_s;

	@Comment("创建人")
	@Column(nullable = true, length = 160)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 11)
	private Date created_time_t;

	@Comment("结束时间")
	@Column(nullable = true, length = 11)
	private Date end_time_t;

	@Comment("机台条码")
	@Column(nullable = true, length = 160)
	private String equip_code_s;

	@Comment("备注")
	@Column(nullable = true, length = 160)
	private String memo_s;

	@Comment("工序")
	@Column(nullable = true, length = 160)
	private String process_s;

	@Comment("领用日期")
	@Column(nullable = true, length = 16)
	private String product_date_s;

	@Comment("记录标志(A可用，D删除)")
	@Column(nullable = false, length = 160)
	private String record_flag_s;

	@Comment("班组")
	@Column(nullable = true, length = 160)
	private String shift_id_s;

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

	@Comment("开始时间")
	@Column(nullable = true, length = 11)
	private Date start_time_t;

	@Comment("工厂(1全钢 2半钢)")
	@Column(nullable = false, length = 160)
	private String s_factory_s;

	@Comment("人员编码")
	@Column(nullable = true, length = 200)
	private String user_id_s;

	@Comment("人员名称")
	@Column(nullable = true, length = 200)
	private String user_name_s;

	@Comment("人员类型")
	@Column(nullable = true, length = 200)
	private String user_type_s;

	@Comment("车间")
	@Column(nullable = true, length = 160)
	private String workshop_s;

	@Comment("CHANGED_TIME_U")
	@Column(nullable = true, length = 11)
	private Date changed_time_u;

	@Comment("CREATED_TIME_U")
	@Column(nullable = true, length = 11)
	private Date created_time_u;

	@Comment("START_TIME_U")
	@Column(nullable = true, length = 11)
	private Date start_time_u;

	@Comment("CREATED_TIME_Z")
	@Column(nullable = true, length = 128)
	private String created_time_z;

	@Comment("END_TIME_Z")
	@Column(nullable = true, length = 128)
	private String end_time_z;

	@Comment("END_TIME_U")
	@Column(nullable = true, length = 11)
	private Date end_time_u;

	@Comment("START_TIME_Z")
	@Column(nullable = true, length = 128)
	private String start_time_z;

	@Comment("PRODECT_DATE_T")
	@Column(nullable = true, length = 11)
	private String prodect_date_t;

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

	public String getClass_id_s() {
		return class_id_s;
	}

	@XmlElement
	public void setClass_id_s(String class_id_s) {
		this.class_id_s = class_id_s;
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

	public Date getEnd_time_t() {
		return end_time_t;
	}

	@XmlElement
	public void setEnd_time_t(Date end_time_t) {
		this.end_time_t = end_time_t;
	}

	public String getEquip_code_s() {
		return equip_code_s;
	}

	@XmlElement
	public void setEquip_code_s(String equip_code_s) {
		this.equip_code_s = equip_code_s;
	}

	public String getMemo_s() {
		return memo_s;
	}

	@XmlElement
	public void setMemo_s(String memo_s) {
		this.memo_s = memo_s;
	}

	public String getProcess_s() {
		return process_s;
	}

	@XmlElement
	public void setProcess_s(String process_s) {
		this.process_s = process_s;
	}

	public String getProduct_date_s() {
		return product_date_s;
	}

	@XmlElement
	public void setProduct_date_s(String product_date_s) {
		this.product_date_s = product_date_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getShift_id_s() {
		return shift_id_s;
	}

	@XmlElement
	public void setShift_id_s(String shift_id_s) {
		this.shift_id_s = shift_id_s;
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

	public Date getStart_time_t() {
		return start_time_t;
	}

	@XmlElement
	public void setStart_time_t(Date start_time_t) {
		this.start_time_t = start_time_t;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getUser_id_s() {
		return user_id_s;
	}

	@XmlElement
	public void setUser_id_s(String user_id_s) {
		this.user_id_s = user_id_s;
	}

	public String getUser_name_s() {
		return user_name_s;
	}

	@XmlElement
	public void setUser_name_s(String user_name_s) {
		this.user_name_s = user_name_s;
	}

	public String getUser_type_s() {
		return user_type_s;
	}

	@XmlElement
	public void setUser_type_s(String user_type_s) {
		this.user_type_s = user_type_s;
	}

	public String getWorkshop_s() {
		return workshop_s;
	}

	@XmlElement
	public void setWorkshop_s(String workshop_s) {
		this.workshop_s = workshop_s;
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

	public Date getStart_time_u() {
		return start_time_u;
	}

	@XmlElement
	public void setStart_time_u(Date start_time_u) {
		this.start_time_u = start_time_u;
	}

	public String getCreated_time_z() {
		return created_time_z;
	}

	@XmlElement
	public void setCreated_time_z(String created_time_z) {
		this.created_time_z = created_time_z;
	}

	public String getEnd_time_z() {
		return end_time_z;
	}

	@XmlElement
	public void setEnd_time_z(String end_time_z) {
		this.end_time_z = end_time_z;
	}

	public Date getEnd_time_u() {
		return end_time_u;
	}

	@XmlElement
	public void setEnd_time_u(Date end_time_u) {
		this.end_time_u = end_time_u;
	}

	public String getStart_time_z() {
		return start_time_z;
	}

	@XmlElement
	public void setStart_time_z(String start_time_z) {
		this.start_time_z = start_time_z;
	}

	public String getProdect_date_t() {
		return prodect_date_t;
	}

	@XmlElement
	public void setProdect_date_t(String prodect_date_t) {
		this.prodect_date_t = prodect_date_t;
	}

	public String getChanged_time_z() {
		return changed_time_z;
	}

	@XmlElement
	public void setChanged_time_z(String changed_time_z) {
		this.changed_time_z = changed_time_z;
	}

}
