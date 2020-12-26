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
 * 模具使用履历
 * 
 * @author 刘朋
 * @Date 2018-08-22 16:49:40
 */
@ATDefinition("C_MM_WorkList")
@Entity
@XmlRootElement
@Table(name = "AT_C_MM_WORKLIST")
public class WorkList extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 160)
	private String agenc_no_s;

	@Comment("胶囊条码")
	@Column(nullable = true, length = 160)
	private String capsule_code_s;

	@Comment("修改人")
	@Column(nullable = true, length = 160)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 11)
	private Date changed_time_t;

	@Comment("更换原因")
	@Column(nullable = true, length = 160)
	private String chang_reason_s;

	@Comment("是否检查漏油")
	@Column(nullable = true, length = 160)
	private String check_oilspill_s;

	@Comment("作业班次")
	@Column(nullable = true, length = 160)
	private String class_id_s;

	@Comment("洗模类型 /修理类型")
	@Column(nullable = true, length = 160)
	private String clent_ype_s;

	@Comment("创建人")
	@Column(nullable = true, length = 160)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 11)
	private Date created_time_t;

	@Comment("当前物料编码")
	@Column(nullable = true, length = 200)
	private String current_material_code_s;

	@Comment("作业人")
	@Column(nullable = true, length = 160)
	private String execution_operator_s;

	@Comment("是否结束    0:未结束 1：已结束")
	@Column(nullable = true, length = 160)
	private String isend_s;

	@Comment("能否正常使用")
	@Column(nullable = true, length = 160)
	private String isvalid_s;

	@Comment("当前规格编码")
	@Column(nullable = true, length = 200)
	private String lastspeccode_s;

	@Comment("机台编码")
	@Column(nullable = true, length = 160)
	private String machinecode_s;

	@Comment("备注")
	@Column(nullable = true, length = 400)
	private String mold_code_s;

	@Comment("模具条码")
	@Column(nullable = true, length = 80)
	private String moldcode_s;
	
	@Comment("作业结束时间")
	@Column(nullable = true, length = 160)
	private Date operate_endtime_t;

	@Comment("作业开始时间")
	@Column(nullable = true, length = 160)
	private Date operate_starttime_t;

	@Comment("机台作业类型  1模具换上，2换胶囊，3洗模 4 模具换下 5模具修理6组装")
	@Column(nullable = true, length = 160)
	private String operate_type_s;

	@Comment("换模计划号")
	@Column(nullable = true, length = 160)
	private String planno_changemold_s;

	@Comment("生产日期")
	@Column(nullable = true, length = 16)
	private String product_date_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = false, length = 160)
	private String record_flag_s;

	@Comment("是否更换密封圈")
	@Column(nullable = true, length = 160)
	private String replace_seals_s;

	@Comment("作业班组")
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

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = false, length = 160)
	private String s_factory_s;

	@Comment("使用次数")
	@Column(nullable = true, length = 160)
	private String usenumber_s;

	@Comment("当前记录次数")
	@Column(nullable = true, length = 160)
	private String usenum_current_s;

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
	public String getMoldcode_s() {
		return moldcode_s;
	}



	public void setMoldcode_s(String moldcode_s) {
		this.moldcode_s = moldcode_s;
	}



	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getCapsule_code_s() {
		return capsule_code_s;
	}

	@XmlElement
	public void setCapsule_code_s(String capsule_code_s) {
		this.capsule_code_s = capsule_code_s;
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

	public String getChang_reason_s() {
		return chang_reason_s;
	}

	@XmlElement
	public void setChang_reason_s(String chang_reason_s) {
		this.chang_reason_s = chang_reason_s;
	}

	public String getCheck_oilspill_s() {
		return check_oilspill_s;
	}

	@XmlElement
	public void setCheck_oilspill_s(String check_oilspill_s) {
		this.check_oilspill_s = check_oilspill_s;
	}

	public String getClass_id_s() {
		return class_id_s;
	}

	@XmlElement
	public void setClass_id_s(String class_id_s) {
		this.class_id_s = class_id_s;
	}

	public String getClent_ype_s() {
		return clent_ype_s;
	}

	@XmlElement
	public void setClent_ype_s(String clent_ype_s) {
		this.clent_ype_s = clent_ype_s;
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

	public String getCurrent_material_code_s() {
		return current_material_code_s;
	}

	@XmlElement
	public void setCurrent_material_code_s(String current_material_code_s) {
		this.current_material_code_s = current_material_code_s;
	}

	public String getExecution_operator_s() {
		return execution_operator_s;
	}

	@XmlElement
	public void setExecution_operator_s(String execution_operator_s) {
		this.execution_operator_s = execution_operator_s;
	}

	public String getIsend_s() {
		return isend_s;
	}

	@XmlElement
	public void setIsend_s(String isend_s) {
		this.isend_s = isend_s;
	}

	public String getIsvalid_s() {
		return isvalid_s;
	}

	@XmlElement
	public void setIsvalid_s(String isvalid_s) {
		this.isvalid_s = isvalid_s;
	}

	public String getLastspeccode_s() {
		return lastspeccode_s;
	}

	@XmlElement
	public void setLastspeccode_s(String lastspeccode_s) {
		this.lastspeccode_s = lastspeccode_s;
	}

	public String getMachinecode_s() {
		return machinecode_s;
	}

	@XmlElement
	public void setMachinecode_s(String machinecode_s) {
		this.machinecode_s = machinecode_s;
	}

	public String getMold_code_s() {
		return mold_code_s;
	}

	@XmlElement
	public void setMold_code_s(String mold_code_s) {
		this.mold_code_s = mold_code_s;
	}

	public Date getOperate_endtime_t() {
		return operate_endtime_t;
	}

	public void setOperate_endtime_t(Date operate_endtime_t) {
		this.operate_endtime_t = operate_endtime_t;
	}

	public Date getOperate_starttime_t() {
		return operate_starttime_t;
	}

	public void setOperate_starttime_t(Date operate_starttime_t) {
		this.operate_starttime_t = operate_starttime_t;
	}

	public String getOperate_type_s() {
		return operate_type_s;
	}

	@XmlElement
	public void setOperate_type_s(String operate_type_s) {
		this.operate_type_s = operate_type_s;
	}

	public String getPlanno_changemold_s() {
		return planno_changemold_s;
	}

	@XmlElement
	public void setPlanno_changemold_s(String planno_changemold_s) {
		this.planno_changemold_s = planno_changemold_s;
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

	public String getReplace_seals_s() {
		return replace_seals_s;
	}

	@XmlElement
	public void setReplace_seals_s(String replace_seals_s) {
		this.replace_seals_s = replace_seals_s;
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

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getUsenumber_s() {
		return usenumber_s;
	}

	@XmlElement
	public void setUsenumber_s(String usenumber_s) {
		this.usenumber_s = usenumber_s;
	}

	public String getUsenum_current_s() {
		return usenum_current_s;
	}

	@XmlElement
	public void setUsenum_current_s(String usenum_current_s) {
		this.usenum_current_s = usenum_current_s;
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
