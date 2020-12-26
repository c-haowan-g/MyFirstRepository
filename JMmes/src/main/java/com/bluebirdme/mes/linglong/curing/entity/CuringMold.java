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

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 模具信息管理
 * 
 * @author 刘朋
 * @Date 2018-08-07 13:22:01
 */
@ATDefinition("C_MM_CuringMold")
@Entity
@Table(name = "AT_C_MM_CuringMold")
public class CuringMold extends RockWellBaseEntity {

	@Comment("干冰洗后使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal after_change_mold_num_i;

	@Comment("水洗后使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal after_clean_mold_num_i;

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 160)
	private String agenc_no_s;

	@Comment("修改人")
	@Column(nullable = true, length = 200)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 11)
	private Date changed_time_t;

	@Comment("换模报警值")
	@Column(nullable = true, length = 22)
	private BigDecimal change_alarmnum_i;

	@Comment("水洗最高使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal change_maxnum_i;

	@Comment("洗模报警值")
	@Column(nullable = true, length = 22)
	private BigDecimal clear_alarmnum_i;

	@Comment("干冰洗最高使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal clear_maxnum_i;

	@Comment("环套")
	@Column(nullable = true, length = 160)
	private String collar_s;

	@Comment("创建人")
	@Column(nullable = true, length = 200)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 11)
	private Date created_time_t = new Date();

	@Comment("厂家")
	@Column(nullable = true, length = 400)
	private String factory_s;

	@Comment("花纹")
	@Column(nullable = true, length = 160)
	private String flower_pattern_s;

	@Comment("库存位置")
	@Column(nullable = true, length = 160)
	private String inventory_location_s;

	@Comment("换模时间/入库时间")
	@Column(nullable = true, length = 11)
	private Date load_date_t;

	@Comment("模具的条码/二维码/RFID芯片等，唯一")
	@Column(nullable = true, length = 160)
	private String mold_code_s;

	@Comment("模具名称")
	@Column(nullable = true, length = 160)
	private String mold_desc_s;

	@Comment("干冰洗预警使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal mold_icewash_i;

	@Comment("模具编号（LT1315等）")
	@Column(nullable = true, length = 160)
	private String mold_id_s;

	@Comment("模具物料编码")
	@Column(nullable = true, length = 400)
	private String mold_material_code_s;

	@Comment("砂洗")
	@Column(nullable = true, length = 160)
	private String mold_sandwash_s;

	@Comment("规格")
	@Column(nullable = true, length = 160)
	private String mold_spec_s;

	@Comment("模具类型，与基础数据字典类型关联，用于区分工器具的类型、部门等")
	@Column(nullable = true, length = 160)
	private String mold_type_s;

	@Comment("水洗预警使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal mold_wash_i;

	@Comment("进厂时间")
	@Column(nullable = true, length = 160)
	private String purchase_time_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 160)
	private String record_flag_s;

	@Comment("是否可以组模 0 不可以 1 可以组模")
	@Column(nullable = true, length = 160)
	private String repair_state_s;

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

	@Comment("速度层级")
	@Column(nullable = true, length = 200)
	private String speedlevel_s;

	@Comment("状态 ：600501已出库，600502已入库 600503已报备   600504使用中 600505已报废")
	@Column(nullable = true, length = 160)
	private String statues_id_s;

	@Comment("在库状态 700201在库700202 不在库")
	@Column(nullable = true, length = 160)
	private String stock_status_s;

	@Comment("储位地址")
	@Column(nullable = true, length = 160)
	private String store_place_s;

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = false, length = 160)
	private String s_factory_s;

	@Comment("总累加值")
	@Column(nullable = true, length = 22)
	private BigDecimal total_number_i;

	@Comment("商标")
	@Column(nullable = true, length = 160)
	private String trade_mark_s;

	@Comment("托盘条码")
	@Column(nullable = true, length = 160)
	private String tray_code_s;

	@Comment("换模后当前使用次数")
	@Column(nullable = true, length = 22)
	private BigDecimal use_num_i;

	@Comment("洗模状态 0未清洗 1干冰清洗   水洗变0同时清零 洗模后使用次数（AFTER_CLEAN_MOLD_NUM）")
	@Column(nullable = false, length = 160)
	private String wash_state_s;

	public BigDecimal getAfter_change_mold_num_i() {
		return after_change_mold_num_i;
	}

	public void setAfter_change_mold_num_i(BigDecimal after_change_mold_num_i) {
		this.after_change_mold_num_i = after_change_mold_num_i;
	}

	public BigDecimal getAfter_clean_mold_num_i() {
		return after_clean_mold_num_i;
	}

	public void setAfter_clean_mold_num_i(BigDecimal after_clean_mold_num_i) {
		this.after_clean_mold_num_i = after_clean_mold_num_i;
	}

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
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

	public BigDecimal getChange_alarmnum_i() {
		return change_alarmnum_i;
	}

	public void setChange_alarmnum_i(BigDecimal change_alarmnum_i) {
		this.change_alarmnum_i = change_alarmnum_i;
	}

	public BigDecimal getChange_maxnum_i() {
		return change_maxnum_i;
	}

	public void setChange_maxnum_i(BigDecimal change_maxnum_i) {
		this.change_maxnum_i = change_maxnum_i;
	}

	public BigDecimal getClear_alarmnum_i() {
		return clear_alarmnum_i;
	}

	public void setClear_alarmnum_i(BigDecimal clear_alarmnum_i) {
		this.clear_alarmnum_i = clear_alarmnum_i;
	}

	public BigDecimal getClear_maxnum_i() {
		return clear_maxnum_i;
	}

	public void setClear_maxnum_i(BigDecimal clear_maxnum_i) {
		this.clear_maxnum_i = clear_maxnum_i;
	}

	public String getCollar_s() {
		return collar_s;
	}

	public void setCollar_s(String collar_s) {
		this.collar_s = collar_s;
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

	public String getFactory_s() {
		return factory_s;
	}

	public void setFactory_s(String factory_s) {
		this.factory_s = factory_s;
	}

	public String getFlower_pattern_s() {
		return flower_pattern_s;
	}

	public void setFlower_pattern_s(String flower_pattern_s) {
		this.flower_pattern_s = flower_pattern_s;
	}

	public String getInventory_location_s() {
		return inventory_location_s;
	}

	public void setInventory_location_s(String inventory_location_s) {
		this.inventory_location_s = inventory_location_s;
	}

	public Date getLoad_date_t() {
		return load_date_t;
	}

	public void setLoad_date_t(Date load_date_t) {
		this.load_date_t = load_date_t;
	}

	public String getMold_code_s() {
		return mold_code_s;
	}

	public void setMold_code_s(String mold_code_s) {
		this.mold_code_s = mold_code_s;
	}

	public String getMold_desc_s() {
		return mold_desc_s;
	}

	public void setMold_desc_s(String mold_desc_s) {
		this.mold_desc_s = mold_desc_s;
	}

	public BigDecimal getMold_icewash_i() {
		return mold_icewash_i;
	}

	public void setMold_icewash_i(BigDecimal mold_icewash_i) {
		this.mold_icewash_i = mold_icewash_i;
	}

	public String getMold_id_s() {
		return mold_id_s;
	}

	public void setMold_id_s(String mold_id_s) {
		this.mold_id_s = mold_id_s;
	}

	public String getMold_material_code_s() {
		return mold_material_code_s;
	}

	public void setMold_material_code_s(String mold_material_code_s) {
		this.mold_material_code_s = mold_material_code_s;
	}

	public String getMold_sandwash_s() {
		return mold_sandwash_s;
	}

	public void setMold_sandwash_s(String mold_sandwash_s) {
		this.mold_sandwash_s = mold_sandwash_s;
	}

	public String getMold_spec_s() {
		return mold_spec_s;
	}

	public void setMold_spec_s(String mold_spec_s) {
		this.mold_spec_s = mold_spec_s;
	}

	public String getMold_type_s() {
		return mold_type_s;
	}

	public void setMold_type_s(String mold_type_s) {
		this.mold_type_s = mold_type_s;
	}

	public BigDecimal getMold_wash_i() {
		return mold_wash_i;
	}

	public void setMold_wash_i(BigDecimal mold_wash_i) {
		this.mold_wash_i = mold_wash_i;
	}

	public String getPurchase_time_s() {
		return purchase_time_s;
	}

	public void setPurchase_time_s(String purchase_time_s) {
		this.purchase_time_s = purchase_time_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getRepair_state_s() {
		return repair_state_s;
	}

	public void setRepair_state_s(String repair_state_s) {
		this.repair_state_s = repair_state_s;
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

	public String getSpeedlevel_s() {
		return speedlevel_s;
	}

	public void setSpeedlevel_s(String speedlevel_s) {
		this.speedlevel_s = speedlevel_s;
	}

	public String getStatues_id_s() {
		return statues_id_s;
	}

	public void setStatues_id_s(String statues_id_s) {
		this.statues_id_s = statues_id_s;
	}

	public String getStock_status_s() {
		return stock_status_s;
	}

	public void setStock_status_s(String stock_status_s) {
		this.stock_status_s = stock_status_s;
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

	public BigDecimal getTotal_number_i() {
		return total_number_i;
	}

	public void setTotal_number_i(BigDecimal total_number_i) {
		this.total_number_i = total_number_i;
	}

	public String getTrade_mark_s() {
		return trade_mark_s;
	}

	public void setTrade_mark_s(String trade_mark_s) {
		this.trade_mark_s = trade_mark_s;
	}

	public String getTray_code_s() {
		return tray_code_s;
	}

	public void setTray_code_s(String tray_code_s) {
		this.tray_code_s = tray_code_s;
	}

	public BigDecimal getUse_num_i() {
		return use_num_i;
	}

	public void setUse_num_i(BigDecimal use_num_i) {
		this.use_num_i = use_num_i;
	}

	public String getWash_state_s() {
		return wash_state_s;
	}

	public void setWash_state_s(String wash_state_s) {
		this.wash_state_s = wash_state_s;
	}

}
