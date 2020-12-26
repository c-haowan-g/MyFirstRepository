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
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;

/**
 * 胶囊使用履历(胶囊信息+胶囊使用履历)
 * 
 * @author 刘朋
 * @Date 2018-08-25 09:58:59
 */
@Entity
@XmlRootElement
@Table(name = "AT_C_MM_CAPSULE")
public class Capsules extends RockWellBaseEntity {

	@Comment("换胶囊后使用次数")
	@Column(nullable = true, length = 0)
	private Integer after_change_bladder_num_i;

	@Comment("洗胶囊使用次数")
	@Column(nullable = true, length = 0)
	private Integer after_clean_bladder_num_i;

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 80)
	private String agenc_no_s;

	@Comment("报警值")
	@Column(nullable = true, length = 0)
	private Integer alarm_number_i;

	@Comment("批次号")
	@Column(nullable = true, length = 80)
	private String batch_no_s;

	@Comment("胶囊的条码/二维码/RFID芯片等")
	@Column(nullable = true, length = 100)
	private String capsule_code_s;

	@Comment("胶囊名称")
	@Column(nullable = true, length = 320)
	private String capsule_name_s;

	@Comment("胶囊规格")
	@Column(nullable = true, length = 200)
	private String capsule_spec_s;

	@Comment("胶囊类型")
	@Column(nullable = true, length = 80)
	private String capsule_type_s;

	@Comment("修改人")
	@Column(nullable = true, length = 100)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("消耗数量")
	@Column(nullable = true, length = 0)
	private Integer consume_quantity_i;

	@Comment("创建人")
	@Column(nullable = true, length = 100)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 0)
	private Date created_time_t;

	@Comment("物料编码")
	@Column(nullable = true, length = 80)
	private String material_code_s;

	@Comment("最高使用次数")
	@Column(nullable = true, length = 0)
	private Integer max_limit_i;

	@Comment("库存数量")
	@Column(nullable = true, length = 0)
	private Integer onhand1_i;

	@Comment("库存数量")
	@Column(nullable = true, length = 80)
	private String onhand_s;

	@Comment("胶囊校验位码")
	@Column(nullable = true, length = 80)
	private String parity_code_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 80)
	private String record_flag_s;

	@Comment("报废原因")
	@Column(nullable = true, length = 80)
	private String scrap_reason_s;

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

	@Comment("状态")
	@Column(nullable = true, length = 80)
	private String statues_s;

	@Comment("储位地址")
	@Column(nullable = true, length = 80)
	private String store_place_s;

	@Comment("工厂")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	@Comment("累计使用次数")
	@Column(nullable = true, length = 0)
	private Integer total_number_i;

	@Comment("托盘条码")
	@Column(nullable = true, length = 80)
	private String tray_code_s;

	public Integer getAfter_change_bladder_num_i() {
		return after_change_bladder_num_i;
	}

	public void setAfter_change_bladder_num_i(Integer after_change_bladder_num_i) {
		this.after_change_bladder_num_i = after_change_bladder_num_i;
	}

	public Integer getAfter_clean_bladder_num_i() {
		return after_clean_bladder_num_i;
	}

	public void setAfter_clean_bladder_num_i(Integer after_clean_bladder_num_i) {
		this.after_clean_bladder_num_i = after_clean_bladder_num_i;
	}

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public Integer getAlarm_number_i() {
		return alarm_number_i;
	}

	public void setAlarm_number_i(Integer alarm_number_i) {
		this.alarm_number_i = alarm_number_i;
	}

	public String getBatch_no_s() {
		return batch_no_s;
	}

	public void setBatch_no_s(String batch_no_s) {
		this.batch_no_s = batch_no_s;
	}

	public String getCapsule_code_s() {
		return capsule_code_s;
	}

	public void setCapsule_code_s(String capsule_code_s) {
		this.capsule_code_s = capsule_code_s;
	}

	public String getCapsule_name_s() {
		return capsule_name_s;
	}

	public void setCapsule_name_s(String capsule_name_s) {
		this.capsule_name_s = capsule_name_s;
	}

	public String getCapsule_spec_s() {
		return capsule_spec_s;
	}

	public void setCapsule_spec_s(String capsule_spec_s) {
		this.capsule_spec_s = capsule_spec_s;
	}

	public String getCapsule_type_s() {
		return capsule_type_s;
	}

	public void setCapsule_type_s(String capsule_type_s) {
		this.capsule_type_s = capsule_type_s;
	}

	public String getChanged_by_s() {
		return changed_by_s;
	}

	public void setChanged_by_s(String changed_by_s) {
		this.changed_by_s = changed_by_s;
	}

	public Date getChanged_time_t() {
		return changed_time_t;
	}

	public void setChanged_time_t(Date changed_time_t) {
		this.changed_time_t = changed_time_t;
	}

	public Integer getConsume_quantity_i() {
		return consume_quantity_i;
	}

	public void setConsume_quantity_i(Integer consume_quantity_i) {
		this.consume_quantity_i = consume_quantity_i;
	}

	public String getCreated_by_s() {
		return created_by_s;
	}

	public void setCreated_by_s(String created_by_s) {
		this.created_by_s = created_by_s;
	}

	public Date getCreated_time_t() {
		return created_time_t;
	}

	public void setCreated_time_t(Date created_time_t) {
		this.created_time_t = created_time_t;
	}

	public String getMaterial_code_s() {
		return material_code_s;
	}

	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public Integer getMax_limit_i() {
		return max_limit_i;
	}

	public void setMax_limit_i(Integer max_limit_i) {
		this.max_limit_i = max_limit_i;
	}

	public Integer getOnhand1_i() {
		return onhand1_i;
	}

	public void setOnhand1_i(Integer onhand1_i) {
		this.onhand1_i = onhand1_i;
	}

	public String getOnhand_s() {
		return onhand_s;
	}

	public void setOnhand_s(String onhand_s) {
		this.onhand_s = onhand_s;
	}

	public String getParity_code_s() {
		return parity_code_s;
	}

	public void setParity_code_s(String parity_code_s) {
		this.parity_code_s = parity_code_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getScrap_reason_s() {
		return scrap_reason_s;
	}

	public void setScrap_reason_s(String scrap_reason_s) {
		this.scrap_reason_s = scrap_reason_s;
	}

	public String getSpare1_s() {
		return spare1_s;
	}

	public void setSpare1_s(String spare1_s) {
		this.spare1_s = spare1_s;
	}

	public String getSpare2_s() {
		return spare2_s;
	}

	public void setSpare2_s(String spare2_s) {
		this.spare2_s = spare2_s;
	}

	public String getSpare3_s() {
		return spare3_s;
	}

	public void setSpare3_s(String spare3_s) {
		this.spare3_s = spare3_s;
	}

	public String getSpare4_s() {
		return spare4_s;
	}

	public void setSpare4_s(String spare4_s) {
		this.spare4_s = spare4_s;
	}

	public String getSpare5_s() {
		return spare5_s;
	}

	public void setSpare5_s(String spare5_s) {
		this.spare5_s = spare5_s;
	}

	public String getStatues_s() {
		return statues_s;
	}

	public void setStatues_s(String statues_s) {
		this.statues_s = statues_s;
	}

	public String getStore_place_s() {
		return store_place_s;
	}

	public void setStore_place_s(String store_place_s) {
		this.store_place_s = store_place_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public Integer getTotal_number_i() {
		return total_number_i;
	}

	public void setTotal_number_i(Integer total_number_i) {
		this.total_number_i = total_number_i;
	}

	public String getTray_code_s() {
		return tray_code_s;
	}

	public void setTray_code_s(String tray_code_s) {
		this.tray_code_s = tray_code_s;
	}

}
