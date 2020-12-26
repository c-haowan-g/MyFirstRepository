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
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 胶囊库存管理
 * 
 * @author 刘朋
 * @Date 2018-08-01 17:56:14
 */
@ATDefinition("C_WH_CapsuleStock")
@Entity
@XmlRootElement
@Table(name = "AT_C_WH_CAPSULESTOCK")
public class CapsuleStock extends RockWellBaseEntity {

	@Comment("机构编号")
	@Column(nullable = false, length = 16)
	private String agenc_no_s;

	@Comment("胶囊规格")
	@Column(nullable = false, length = 80)
	private String capsule_code_s;

	@Comment("厂商")
	@Column(nullable = true, length = 200)
	private String capsule_factory_s;

	@Comment("胶囊批次号")
	@Column(nullable = true, length = 80)
	private String capsule_id_s;

	@Comment("更新人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("更新时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = true, length = 80)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 0)
	private Date created_time_t = new Date();

	@Comment("采购进厂日期")
	@Column(nullable = true, length = 0)
	private Date in_time_t;

	@Comment("物料编码")
	@Column(nullable = true, length = 80)
	private String material_code_s;

	@Comment("采购数量")
	@Column(nullable = true, length = 0)
	private Integer num_purchase_i;

	@Comment("使用数量")
	@Column(nullable = true, length = 0)
	private Integer num_recipients_i;

	@Comment("剩余数量")
	@Column(nullable = true, length = 0)
	private Integer num_surplus_i;

	@Comment("胶囊校验位码")
	@Column(nullable = true, length = 8)
	private String parity_code_s;

	@Comment("采购人")
	@Column(nullable = true, length = 20)
	private String purchaser_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = false, length = 4)
	private String record_flag_s = "A";

	@Comment("工厂")
	@Column(nullable = false, length = 5)
	private String s_factory_s;

	@Comment("备用字段1")
	@Column(nullable = true, length = 50)
	private String spare1_s;

	@Comment("备用字段2")
	@Column(nullable = true, length = 50)
	private String spare2_s;

	@Comment("备用字段3")
	@Column(nullable = true, length = 50)
	private String spare3_s;

	@Comment("备用字段4")
	@Column(nullable = true, length = 50)
	private String spare4_s;

	@Comment("备用字段5")
	@Column(nullable = true, length = 50)
	private String spare5_s;

	@Comment("存放位置")
	@Column(nullable = true, length = 20)
	private String store_place_s;

	@Comment("供应商编号")
	@Column(nullable = true, length = 80)
	private String suppliers_no_s;

	@Comment("入库时间")
	@Column(nullable = true, length = 0)
	private Date use_time_t = new Date();

	@Comment("入库人")
	@Column(nullable = true, length = 20)
	private String user_id_s;

	public String getCapsule_code_s() {
		return capsule_code_s;
	}

	public void setCapsule_code_s(String capsule_code_s) {
		this.capsule_code_s = capsule_code_s;
	}

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getCapsule_factory_s() {
		return capsule_factory_s;
	}

	public void setCapsule_factory_s(String capsule_factory_s) {
		this.capsule_factory_s = capsule_factory_s;
	}

	public String getCapsule_id_s() {
		return capsule_id_s;
	}

	public void setCapsule_id_s(String capsule_id_s) {
		this.capsule_id_s = capsule_id_s;
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

	public Date getIn_time_t() {
		return in_time_t;
	}

	public void setIn_time_t(Date in_time_t) {
		this.in_time_t = in_time_t;
	}

	public String getMaterial_code_s() {
		return material_code_s;
	}

	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public Integer getNum_purchase_i() {
		return num_purchase_i;
	}

	public void setNum_purchase_i(Integer num_purchase_i) {
		this.num_purchase_i = num_purchase_i;
	}

	public Integer getNum_recipients_i() {
		return num_recipients_i;
	}

	public void setNum_recipients_i(Integer num_recipients_i) {
		this.num_recipients_i = num_recipients_i;
	}

	public Integer getNum_surplus_i() {
		return num_surplus_i;
	}

	public void setNum_surplus_i(Integer num_surplus_i) {
		this.num_surplus_i = num_surplus_i;
	}

	public String getParity_code_s() {
		return parity_code_s;
	}

	public void setParity_code_s(String parity_code_s) {
		this.parity_code_s = parity_code_s;
	}

	public String getPurchaser_s() {
		return purchaser_s;
	}

	public void setPurchaser_s(String purchaser_s) {
		this.purchaser_s = purchaser_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
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

	public String getStore_place_s() {
		return store_place_s;
	}

	public void setStore_place_s(String store_place_s) {
		this.store_place_s = store_place_s;
	}

	public String getSuppliers_no_s() {
		return suppliers_no_s;
	}

	public void setSuppliers_no_s(String suppliers_no_s) {
		this.suppliers_no_s = suppliers_no_s;
	}

	public Date getUse_time_t() {
		return use_time_t;
	}

	public void setUse_time_t(Date use_time_t) {
		this.use_time_t = use_time_t;
	}

	public String getUser_id_s() {
		return user_id_s;
	}

	public void setUser_id_s(String user_id_s) {
		this.user_id_s = user_id_s;
	}

}
