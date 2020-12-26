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
 * 半部件配送履历
 * 
 * @author 刘朋
 * @Date 2019-03-09 8:20:56
 */
@ATDefinition("A_MM_DELIVERYRECORD")
@Entity
@XmlRootElement
@Table(name = "AT_A_MM_DELIVERYRECORD")
public class DeliveryRecord extends RockWellBaseEntity {

	@Comment("批次条码")
	@Column(nullable = true, length = 80)
	private String batchcode_s;

	@Comment("修改人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("班次")
	@Column(nullable = true, length = 80)
	private String class_s;

	@Comment("创建人")
	@Column(nullable = false, length = 80)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = false, length = 0)
	private Date created_time_t;

	@Comment("拉料库位")
	@Column(nullable = true, length = 80)
	private String fromlocation_s;

	@Comment("配送人工号")
	@Column(nullable = true, length = 80)
	private String deliveryer_s;

	@Comment("配送人名称")
	@Column(nullable = true, length = 80)
	private String deliveryname_s;

	@Comment("配送时间")
	@Column(nullable = true, length = 0)
	private Date deliverytime_t;

	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
	@Column(nullable = false, length = 80)
	private String enterprise_num_s;

	@Comment("机台条码")
	@Column(nullable = true, length = 80)
	private String machinecode_s;

	@Comment("物料编码")
	@Column(nullable = true, length = 80)
	private String materialcode_s;

	@Comment("物料名称")
	@Column(nullable = true, length = 80)
	private String materialname_s;

	@Comment("物料规格")
	@Column(nullable = true, length = 80)
	private String materialspec_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = false, length = 80)
	private String record_flag_s;

	@Comment("备用字段10")
	@Column(nullable = true, length = 80)
	private String spare10_s;

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

	@Comment("备用字段6")
	@Column(nullable = true, length = 80)
	private String spare6_s;

	@Comment("备用字段7")
	@Column(nullable = true, length = 80)
	private String spare7_s;

	@Comment("备用字段8")
	@Column(nullable = true, length = 80)
	private String spare8_s;

	@Comment("备用字段9")
	@Column(nullable = true, length = 80)
	private String spare9_s;

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	@Comment("载具条码")
	@Column(nullable = true, length = 80)
	private String vehiclecode_s;

	@Comment("重量")
	@Column(nullable = true, length = 80)
	private String weight_s;

	public String getBatchcode_s() {
		return batchcode_s;
	}

	@XmlElement
	public void setBatchcode_s(String batchcode_s) {
		this.batchcode_s = batchcode_s;
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

	public String getClass_s() {
		return class_s;
	}

	@XmlElement
	public void setClass_s(String class_s) {
		this.class_s = class_s;
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

	public String getFromlocation_s() {
		return fromlocation_s;
	}

	@XmlElement
	public void setFromlocation_s(String fromlocation_s) {
		this.fromlocation_s = fromlocation_s;
	}

	public String getDeliveryer_s() {
		return deliveryer_s;
	}

	@XmlElement
	public void setDeliveryer_s(String deliveryer_s) {
		this.deliveryer_s = deliveryer_s;
	}

	public String getDeliveryname_s() {
		return deliveryname_s;
	}

	@XmlElement
	public void setDeliveryname_s(String deliveryname_s) {
		this.deliveryname_s = deliveryname_s;
	}

	public Date getDeliverytime_t() {
		return deliverytime_t;
	}

	@XmlElement
	public void setDeliverytime_t(Date deliverytime_t) {
		this.deliverytime_t = deliverytime_t;
	}

	public String getEnterprise_num_s() {
		return enterprise_num_s;
	}

	@XmlElement
	public void setEnterprise_num_s(String enterprise_num_s) {
		this.enterprise_num_s = enterprise_num_s;
	}

	public String getMachinecode_s() {
		return machinecode_s;
	}

	@XmlElement
	public void setMachinecode_s(String machinecode_s) {
		this.machinecode_s = machinecode_s;
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

	public String getMaterialspec_s() {
		return materialspec_s;
	}

	@XmlElement
	public void setMaterialspec_s(String materialspec_s) {
		this.materialspec_s = materialspec_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getSpare10_s() {
		return spare10_s;
	}

	@XmlElement
	public void setSpare10_s(String spare10_s) {
		this.spare10_s = spare10_s;
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

	public String getSpare6_s() {
		return spare6_s;
	}

	@XmlElement
	public void setSpare6_s(String spare6_s) {
		this.spare6_s = spare6_s;
	}

	public String getSpare7_s() {
		return spare7_s;
	}

	@XmlElement
	public void setSpare7_s(String spare7_s) {
		this.spare7_s = spare7_s;
	}

	public String getSpare8_s() {
		return spare8_s;
	}

	@XmlElement
	public void setSpare8_s(String spare8_s) {
		this.spare8_s = spare8_s;
	}

	public String getSpare9_s() {
		return spare9_s;
	}

	@XmlElement
	public void setSpare9_s(String spare9_s) {
		this.spare9_s = spare9_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getVehiclecode_s() {
		return vehiclecode_s;
	}

	@XmlElement
	public void setVehiclecode_s(String vehiclecode_s) {
		this.vehiclecode_s = vehiclecode_s;
	}

	public String getWeight_s() {
		return weight_s;
	}

	@XmlElement
	public void setWeight_s(String weight_s) {
		this.weight_s = weight_s;
	}

}
