/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity;

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
 * SAP下发生产版本
 * 
 * @author 刘朋
 * @Date 2018-09-22 16:49:09
 */
@ATDefinition("INT_SAP_PRODUCTVERSION")
@Entity
@XmlRootElement
@Table(name = "AT_INT_SAP_PRODUCTVERSION")
public class ProductVersion extends RockWellBaseEntity {

	@Comment("成本收集器状态（KA允许报产）")
	@Column(nullable = true, length = 100)
	private String cost_col_status_s;

	@Comment("预留1")
	@Column(nullable = true, length = 100)
	private String dummy1_s;

	@Comment("预留2")
	@Column(nullable = true, length = 100)
	private String dummy2_s;

	@Comment("预留3")
	@Column(nullable = true, length = 100)
	private String dummy3_s;

	@Comment("预留4")
	@Column(nullable = true, length = 100)
	private String dummy4_s;

	@Comment("物料编号80位")
	@Column(nullable = false, length = 80)
	private String material_code_s;

	@Comment("物料状态")
	@Column(nullable = true, length = 100)
	private String matstatus_s;

	@Comment("生产版本状态,1代表锁定，空值‘’代表未锁定")
	@Column(nullable = true, length = 80)
	private String mksp_s;

	@Comment("工厂号")
	@Column(nullable = false, length = 80)
	private String plant_s;

	@Comment("生产版本号")
	@Column(nullable = true, length = 100)
	private String production_ver_s;

	@Comment("接收时间")
	@Column(nullable = true, length = 0)
	private Date receive_time_t;

	@Comment("版本描述")
	@Column(nullable = true, length = 400)
	private String verdesc_s;

	public String getCost_col_status_s() {
		return cost_col_status_s;
	}

	@XmlElement
	public void setCost_col_status_s(String cost_col_status_s) {
		this.cost_col_status_s = cost_col_status_s;
	}

	public String getDummy1_s() {
		return dummy1_s;
	}

	@XmlElement
	public void setDummy1_s(String dummy1_s) {
		this.dummy1_s = dummy1_s;
	}

	public String getDummy2_s() {
		return dummy2_s;
	}

	@XmlElement
	public void setDummy2_s(String dummy2_s) {
		this.dummy2_s = dummy2_s;
	}

	public String getDummy3_s() {
		return dummy3_s;
	}

	@XmlElement
	public void setDummy3_s(String dummy3_s) {
		this.dummy3_s = dummy3_s;
	}

	public String getDummy4_s() {
		return dummy4_s;
	}

	@XmlElement
	public void setDummy4_s(String dummy4_s) {
		this.dummy4_s = dummy4_s;
	}

	public String getMaterial_code_s() {
		return material_code_s;
	}

	@XmlElement
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public String getMatstatus_s() {
		return matstatus_s;
	}

	@XmlElement
	public void setMatstatus_s(String matstatus_s) {
		this.matstatus_s = matstatus_s;
	}

	public String getMksp_s() {
		return mksp_s;
	}

	@XmlElement
	public void setMksp_s(String mksp_s) {
		this.mksp_s = mksp_s;
	}

	public String getPlant_s() {
		return plant_s;
	}

	@XmlElement
	public void setPlant_s(String plant_s) {
		this.plant_s = plant_s;
	}

	public String getProduction_ver_s() {
		return production_ver_s;
	}

	@XmlElement
	public void setProduction_ver_s(String production_ver_s) {
		this.production_ver_s = production_ver_s;
	}

	public Date getReceive_time_t() {
		return receive_time_t;
	}

	@XmlElement
	public void setReceive_time_t(Date receive_time_t) {
		this.receive_time_t = receive_time_t;
	}

	public String getVerdesc_s() {
		return verdesc_s;
	}

	@XmlElement
	public void setVerdesc_s(String verdesc_s) {
		this.verdesc_s = verdesc_s;
	}

}
