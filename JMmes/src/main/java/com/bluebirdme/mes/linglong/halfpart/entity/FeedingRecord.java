/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 投料记录
 * 
 * @author 刘朋
 * @Date 2019-20-10 8:34:42
 */
@ATDefinition("A_MM_FeedingRecord")
@Entity
@XmlRootElement
@Table(name = "AT_A_MM_FEEDINGRECORD")
public class FeedingRecord extends RockWellBaseEntity {

	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
	@Column(nullable = false, length = 80)
	private String agenc_no_s;

	@Comment("原料条码")
	@Column(nullable = true, length = 80)
	private String barcode_s;

	@Comment("班次")
	@Column(nullable = true, length = 80)
	private String bz_class_s;

	@Comment("班组")
	@Column(nullable = true, length = 80)
	private String bz_group_s;

	@Comment("修改人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("消耗量-总")
	@Column(nullable = true, length = 0)
	private String consumeamount_f;

	@Comment("创建人")
	@Column(nullable = false, length = 80)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = false, length = 0)
	private Date created_time_t;

	@Comment("投料量（重量、数量、长度）")
	@Column(nullable = true, length = 80)
	private String feedamount_f;

	@Comment("投料类型")
	@Column(nullable = true, length = 80)
	private String feedingtype_s;

	@Comment("是否有剩余  可删除")
	@Column(nullable = true, length = 80)
	private String haveresidual_s;

	@Comment("投料时间")
	@Column(nullable = true, length = 0)
	private Date inputtime_t;

	@Comment("机台条码")
	@Column(nullable = true, length = 80)
	private String machinecode_s;

	@Comment("投料计数器数")
	@Column(nullable = true, length = 0)
	private String macnumin_f;

	@Comment("撤下计数器数")
	@Column(nullable = true, length = 0)
	private String macnumout_f;

	@Comment("物料编码")
	@Column(nullable = true, length = 80)
	private String materialcode_s;

	@Comment("物料名称")
	@Column(nullable = true, length = 80)
	private String materialname_s;

	@Comment("备注")
	@Column(nullable = true, length = 80)
	private String memo_s;

	@Comment("产出数量")
	@Column(nullable = true, length = 0)
	private String opnum_f;

	@Comment("工单号")
	@Column(nullable = true, length = 80)
	private String order_planno_s;

	@Comment("产出物料编码")
	@Column(nullable = true, length = 80)
	private String productmat_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = false, length = 80)
	private String record_flag_s;

	@Comment("撤下时间")
	@Column(nullable = true, length = 0)
	private Date removetime_t;

	@Comment("RFID地址")
	@Column(nullable = true, length = 80)
	private String rfidadress_s;

	@Comment("扫描类型 0-客户端记录 1-服务端记录")
	@Column(nullable = true, length = 80)
	private String scan_type_s;

	@Comment("序号")
	@Column(nullable = true, length = 80)
	private String serialcode_s;

	@Comment("数据来源  0-手持 1-RFID 3-扫描枪")
	@Column(nullable = true, length = 80)
	private String source_s;

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

	@Comment("钢丝剔除标记 0-否 1-是")
	@Column(nullable = true, length = 80)
	private String steeldelflag_s;

	@Comment("钢丝压延投料记录组 A B")
	@Column(nullable = true, length = 80)
	private String steelflag_s;

	@Comment("剩余量（重量、数量、长度）")
	@Column(nullable = true, length = 0)
	private String surplusamount_f;

	@Comment("同步类型 0-已同步 1-未同步")
	@Column(nullable = true, length = 80)
	private String sync_type_s;

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	@Comment("使用状态 基础数据字典 107")
	@Column(nullable = true, length = 80)
	private String usestatus_s;

	@Comment("载具条码")
	@Column(nullable = true, length = 80)
	private String vehicles_code_s;

	@Comment("操作工名称")
	@Column(nullable = true, length = 80)
	private String worker_id_s;

	@Comment("操作工编码")
	@Column(nullable = true, length = 80)
	private String worker_name_s;

	private String description;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getBarcode_s() {
		return barcode_s;
	}

	@XmlElement
	public void setBarcode_s(String barcode_s) {
		this.barcode_s = barcode_s;
	}

	public String getBz_class_s() {
		return bz_class_s;
	}

	@XmlElement
	public void setBz_class_s(String bz_class_s) {
		this.bz_class_s = bz_class_s;
	}

	public String getBz_group_s() {
		return bz_group_s;
	}

	@XmlElement
	public void setBz_group_s(String bz_group_s) {
		this.bz_group_s = bz_group_s;
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

	public String getConsumeamount_f() {
		return consumeamount_f;
	}

	@XmlElement
	public void setConsumeamount_f(String consumeamount_f) {
		this.consumeamount_f = consumeamount_f;
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

	public String getFeedamount_f() {
		return feedamount_f;
	}

	@XmlElement
	public void setFeedamount_f(String feedamount_f) {
		this.feedamount_f = feedamount_f;
	}

	public String getFeedingtype_s() {
		return feedingtype_s;
	}

	@XmlElement
	public void setFeedingtype_s(String feedingtype_s) {
		this.feedingtype_s = feedingtype_s;
	}

	public String getHaveresidual_s() {
		return haveresidual_s;
	}

	@XmlElement
	public void setHaveresidual_s(String haveresidual_s) {
		this.haveresidual_s = haveresidual_s;
	}

	public Date getInputtime_t() {
		return inputtime_t;
	}

	@XmlElement
	public void setInputtime_t(Date inputtime_t) {
		this.inputtime_t = inputtime_t;
	}

	public String getMachinecode_s() {
		return machinecode_s;
	}

	@XmlElement
	public void setMachinecode_s(String machinecode_s) {
		this.machinecode_s = machinecode_s;
	}

	public String getMacnumin_f() {
		return macnumin_f;
	}

	@XmlElement
	public void setMacnumin_f(String macnumin_f) {
		this.macnumin_f = macnumin_f;
	}

	public String getMacnumout_f() {
		return macnumout_f;
	}

	@XmlElement
	public void setMacnumout_f(String macnumout_f) {
		this.macnumout_f = macnumout_f;
	}

	public String getMaterialcode_s() {
		return materialcode_s;
	}

	@XmlElement
	public void setMaterialcode_s(String materialcode_s) {
		this.materialcode_s = materialcode_s;
	}

	public String getMaterialname_s() {
		return materialname_s;
	}

	@XmlElement
	public void setMaterialname_s(String materialname_s) {
		this.materialname_s = materialname_s;
	}

	public String getMemo_s() {
		return memo_s;
	}

	@XmlElement
	public void setMemo_s(String memo_s) {
		this.memo_s = memo_s;
	}

	public String getOpnum_f() {
		return opnum_f;
	}

	@XmlElement
	public void setOpnum_f(String opnum_f) {
		this.opnum_f = opnum_f;
	}

	public String getOrder_planno_s() {
		return order_planno_s;
	}

	@XmlElement
	public void setOrder_planno_s(String order_planno_s) {
		this.order_planno_s = order_planno_s;
	}

	public String getProductmat_s() {
		return productmat_s;
	}

	@XmlElement
	public void setProductmat_s(String productmat_s) {
		this.productmat_s = productmat_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public Date getRemovetime_t() {
		return removetime_t;
	}

	@XmlElement
	public void setRemovetime_t(Date removetime_t) {
		this.removetime_t = removetime_t;
	}

	public String getRfidadress_s() {
		return rfidadress_s;
	}

	@XmlElement
	public void setRfidadress_s(String rfidadress_s) {
		this.rfidadress_s = rfidadress_s;
	}

	public String getScan_type_s() {
		return scan_type_s;
	}

	@XmlElement
	public void setScan_type_s(String scan_type_s) {
		this.scan_type_s = scan_type_s;
	}

	public String getSerialcode_s() {
		return serialcode_s;
	}

	@XmlElement
	public void setSerialcode_s(String serialcode_s) {
		this.serialcode_s = serialcode_s;
	}

	public String getSource_s() {
		return source_s;
	}

	@XmlElement
	public void setSource_s(String source_s) {
		this.source_s = source_s;
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

	public String getSteeldelflag_s() {
		return steeldelflag_s;
	}

	@XmlElement
	public void setSteeldelflag_s(String steeldelflag_s) {
		this.steeldelflag_s = steeldelflag_s;
	}

	public String getSteelflag_s() {
		return steelflag_s;
	}

	@XmlElement
	public void setSteelflag_s(String steelflag_s) {
		this.steelflag_s = steelflag_s;
	}

	public String getSurplusamount_f() {
		return surplusamount_f;
	}

	@XmlElement
	public void setSurplusamount_f(String surplusamount_f) {
		this.surplusamount_f = surplusamount_f;
	}

	public String getSync_type_s() {
		return sync_type_s;
	}

	@XmlElement
	public void setSync_type_s(String sync_type_s) {
		this.sync_type_s = sync_type_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getUsestatus_s() {
		return usestatus_s;
	}

	@XmlElement
	public void setUsestatus_s(String usestatus_s) {
		this.usestatus_s = usestatus_s;
	}

	public String getVehicles_code_s() {
		return vehicles_code_s;
	}

	@XmlElement
	public void setVehicles_code_s(String vehicles_code_s) {
		this.vehicles_code_s = vehicles_code_s;
	}

	public String getWorker_id_s() {
		return worker_id_s;
	}

	@XmlElement
	public void setWorker_id_s(String worker_id_s) {
		this.worker_id_s = worker_id_s;
	}

	public String getWorker_name_s() {
		return worker_name_s;
	}

	@XmlElement
	public void setWorker_name_s(String worker_name_s) {
		this.worker_name_s = worker_name_s;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
