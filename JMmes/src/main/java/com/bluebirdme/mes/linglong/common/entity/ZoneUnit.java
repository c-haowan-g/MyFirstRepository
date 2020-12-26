/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

import java.util.Date;
/**
 * 库区库位管理
 * @author 李迺锟
 * @Date 2019-04-19 10:02:27
 */
public class ZoneUnit {
 
	private String parent_key;
	private String storage_unit_key;
	private String storage_zone_barcode_s;   //库位划分
	private String storage_unit_name;        //库位名称
	private String description;              //库位描述
	private String max_storage_duration;     //库存容量
	private String current_storage_i;        //当前库存数量-1
	private String erpcode_s;                //存放规格
	private String inventory_materialcode_s; //存放物料编码
	private String inventory_materialname_s; //存放物料编码
	private Date   lastintime_t;             //最后入库时间
	private String canuse_s;                 //有效标识 是否启用库位 启用1 未启用0-1
	private String lockflag_s;               //是否占用-1
	private String lockinflag_s;             //半部件入库锁定标记-1
	private String lockoutflag_s;            //出库锁定标记-1
	private String operater_s;
	private Date   operatetime_t;
	private String sapm_group_s;             //有效标识 是否启用库位 启用1 未启用0-1
	private String stockstatus_s;
	private String boitanland_s;
	private String current_quantity_i;
	private String inventory_barcode_s;  //库区逻辑条码
	private String storage_zone_name;    //库区条码
	private String machinecode_s;    //库区条码
	
	
	public String getParent_key() {
		return parent_key;
	}
	public void setParent_key(String parent_key) {
		this.parent_key = parent_key;
	}
	public String getStorage_unit_key() {
		return storage_unit_key;
	}
	public void setStorage_unit_key(String storage_unit_key) {
		this.storage_unit_key = storage_unit_key;
	}
	public String getStorage_unit_name() {
		return storage_unit_name;
	}
	public void setStorage_unit_name(String storage_unit_name) {
		this.storage_unit_name = storage_unit_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStorage_zone_barcode_s() {
		return storage_zone_barcode_s;
	}
	public void setStorage_zone_barcode_s(String storage_zone_barcode_s) {
		this.storage_zone_barcode_s = storage_zone_barcode_s;
	}

	public String getErpcode_s() {
		return erpcode_s;
	}
	public void setErpcode_s(String erpcode_s) {
		this.erpcode_s = erpcode_s;
	}
	public String getInventory_materialcode_s() {
		return inventory_materialcode_s;
	}
	public void setInventory_materialcode_s(String inventory_materialcode_s) {
		this.inventory_materialcode_s = inventory_materialcode_s;
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
	public String getOperater_s() {
		return operater_s;
	}
	public void setOperater_s(String operater_s) {
		this.operater_s = operater_s;
	}
	public Date getOperatetime_t() {
		return operatetime_t;
	}
	public void setOperatetime_t(Date operatetime_t) {
		this.operatetime_t = operatetime_t;
	}
	public String getMax_storage_duration() {
		return max_storage_duration;
	}
	public void setMax_storage_duration(String max_storage_duration) {
		this.max_storage_duration = max_storage_duration;
	}
	public String getCanuse_s() {
		return canuse_s;
	}
	public void setCanuse_s(String canuse_s) {
		this.canuse_s = canuse_s;
	}
	public String getCurrent_storage_i() {
		return current_storage_i;
	}
	public void setCurrent_storage_i(String current_storage_i) {
		this.current_storage_i = current_storage_i;
	}
	public String getLockinflag_s() {
		return lockinflag_s;
	}
	public void setLockinflag_s(String lockinflag_s) {
		this.lockinflag_s = lockinflag_s;
	}
	public String getSapm_group_s() {
		return sapm_group_s;
	}
	public void setSapm_group_s(String sapm_group_s) {
		this.sapm_group_s = sapm_group_s;
	}
	public String getStockstatus_s() {
		return stockstatus_s;
	}
	public void setStockstatus_s(String stockstatus_s) {
		this.stockstatus_s = stockstatus_s;
	}
	public String getBoitanland_s() {
		return boitanland_s;
	}
	public void setBoitanland_s(String boitanland_s) {
		this.boitanland_s = boitanland_s;
	}
	public String getCurrent_quantity_i() {
		return current_quantity_i;
	}
	public void setCurrent_quantity_i(String current_quantity_i) {
		this.current_quantity_i = current_quantity_i;
	}
	public String getInventory_barcode_s() {
		return inventory_barcode_s;
	}
	public void setInventory_barcode_s(String inventory_barcode_s) {
		this.inventory_barcode_s = inventory_barcode_s;
	}
	public String getStorage_zone_name() {
		return storage_zone_name;
	}
	public void setStorage_zone_name(String storage_zone_name) {
		this.storage_zone_name = storage_zone_name;
	}
	public String getMachinecode_s() {
		return machinecode_s;
	}
	public void setMachinecode_s(String machinecode_s) {
		this.machinecode_s = machinecode_s;
	}
	public String getInventory_materialname_s() {
		return inventory_materialname_s;
	}
	public void setInventory_materialname_s(String inventory_materialname_s) {
		this.inventory_materialname_s = inventory_materialname_s;
	}
	
	
}
