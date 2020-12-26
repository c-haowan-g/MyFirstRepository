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

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 模具胶囊库位管理
 * 
 * @author 刘朋
 * @Date 2018-08-11 11:46:36
 */
@ATDefinition("C_WH_LocationSettings")
@Entity
@Table(name = "AT_C_WH_LocationSettings")
public class LocationSetting extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = false, length = 80)
	private String agenc_no_s;

	@Comment("BOI")
	@Column(nullable = true, length = 80)
	private String boitanland_s;

	@Comment("更新人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("更新时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = true, length = 100)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 0)
	private Date created_time_t = new Date();

	@Comment("ERP编码")
	@Column(nullable = true, length = 80)
	private String erpcode_s;

	@Comment("库存条码")
	@Column(nullable = true, length = 100)
	private String inventory_barcode_s;

	@Comment("库存容量")
	@Column(nullable = true, length = 80)
	private String inventory_capacity_s;

	@Comment("库存编码")
	@Column(nullable = true, length = 80)
	private String inventory_code_s;

	@Comment("存放物料编码")
	@Column(nullable = true, length = 80)
	private String inventory_materialcode_s;

	@Comment("库存编码中文")
	@Column(nullable = true, length = 100)
	private String inventory_name_cn_s;

	@Comment("库存名称英文")
	@Column(nullable = true, length = 100)
	private String inventory_name_en_s;

	@Comment("库存类型")
	@Column(nullable = true, length = 80)
	private String inventory_type_s;

	@Comment("是否启用")
	@Column(nullable = true, length = 80)
	private String isenable_s;

	@Comment("是否允许包含子库存 ")
	@Column(nullable = true, length = 80)
	private String is_allow_child_stock_s;

	@Comment("最后入库时间（库位推荐有关）")
	@Column(nullable = true, length = 0)
	private Date lastintime_t;

	@Comment("入库锁定标记")
	@Column(nullable = true, length = 80)
	private String lockflag_s;

	@Comment("发货锁定标记")
	@Column(nullable = true, length = 80)
	private String lockoutflag_s;

	@Comment("父结构路径")
	@Column(nullable = true, length = 400)
	private String parent_flag_s;

	@Comment("父库存")
	@Column(nullable = true, length = 100)
	private String parent_stock_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = false, length = 80)
	private String record_flag_s = "A";

	@Comment("备注")
	@Column(nullable = true, length = 100)
	private String remarks_s;

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

	@Comment("存放物料质量状态")
	@Column(nullable = true, length = 80)
	private String stockqs_s;

	@Comment("存放规格")
	@Column(nullable = true, length = 80)
	private String store_specifications_s;

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getBoitanland_s() {
		return boitanland_s;
	}

	public void setBoitanland_s(String boitanland_s) {
		this.boitanland_s = boitanland_s;
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

	public String getErpcode_s() {
		return erpcode_s;
	}

	public void setErpcode_s(String erpcode_s) {
		this.erpcode_s = erpcode_s;
	}

	public String getInventory_barcode_s() {
		return inventory_barcode_s;
	}

	public void setInventory_barcode_s(String inventory_barcode_s) {
		this.inventory_barcode_s = inventory_barcode_s;
	}

	public String getInventory_capacity_s() {
		return inventory_capacity_s;
	}

	public void setInventory_capacity_s(String inventory_capacity_s) {
		this.inventory_capacity_s = inventory_capacity_s;
	}

	public String getInventory_code_s() {
		return inventory_code_s;
	}

	public void setInventory_code_s(String inventory_code_s) {
		this.inventory_code_s = inventory_code_s;
	}

	public String getInventory_materialcode_s() {
		return inventory_materialcode_s;
	}

	public void setInventory_materialcode_s(String inventory_materialcode_s) {
		this.inventory_materialcode_s = inventory_materialcode_s;
	}

	public String getInventory_name_cn_s() {
		return inventory_name_cn_s;
	}

	public void setInventory_name_cn_s(String inventory_name_cn_s) {
		this.inventory_name_cn_s = inventory_name_cn_s;
	}

	public String getInventory_name_en_s() {
		return inventory_name_en_s;
	}

	public void setInventory_name_en_s(String inventory_name_en_s) {
		this.inventory_name_en_s = inventory_name_en_s;
	}

	public String getInventory_type_s() {
		return inventory_type_s;
	}

	public void setInventory_type_s(String inventory_type_s) {
		this.inventory_type_s = inventory_type_s;
	}

	public String getIsenable_s() {
		return isenable_s;
	}

	public void setIsenable_s(String isenable_s) {
		this.isenable_s = isenable_s;
	}

	public String getIs_allow_child_stock_s() {
		return is_allow_child_stock_s;
	}

	public void setIs_allow_child_stock_s(String is_allow_child_stock_s) {
		this.is_allow_child_stock_s = is_allow_child_stock_s;
	}

	public Date getLastintime_t() {
		return lastintime_t;
	}

	public void setLastintime_t(Date lastintime_t) {
		this.lastintime_t = lastintime_t;
	}

	public String getLockflag_s() {
		return lockflag_s;
	}

	public void setLockflag_s(String lockflag_s) {
		this.lockflag_s = lockflag_s;
	}

	public String getLockoutflag_s() {
		return lockoutflag_s;
	}

	public void setLockoutflag_s(String lockoutflag_s) {
		this.lockoutflag_s = lockoutflag_s;
	}

	public String getParent_flag_s() {
		return parent_flag_s;
	}

	public void setParent_flag_s(String parent_flag_s) {
		this.parent_flag_s = parent_flag_s;
	}

	public String getParent_stock_s() {
		return parent_stock_s;
	}

	public void setParent_stock_s(String parent_stock_s) {
		this.parent_stock_s = parent_stock_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getRemarks_s() {
		return remarks_s;
	}

	public void setRemarks_s(String remarks_s) {
		this.remarks_s = remarks_s;
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

	public String getStockqs_s() {
		return stockqs_s;
	}

	public void setStockqs_s(String stockqs_s) {
		this.stockqs_s = stockqs_s;
	}

	public String getStore_specifications_s() {
		return store_specifications_s;
	}

	public void setStore_specifications_s(String store_specifications_s) {
		this.store_specifications_s = store_specifications_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

}
