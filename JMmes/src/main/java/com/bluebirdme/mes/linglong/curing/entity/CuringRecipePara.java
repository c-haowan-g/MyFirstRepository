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
 * PLM配方下发基础参数表
 * 
 * @author 刘朋
 * @Date 2018-09-27 10:55:48
 */
@ATDefinition("INT_PLM_CURINGRECIPEPARA")
@Entity
@XmlRootElement
@Table(name = "AT_INT_PLM_CURINGRECIPEPARA")
public class CuringRecipePara extends RockWellBaseEntity {

	@Comment("参数类型：1-成型、2-硫化")
	@Column(nullable = true, length = 80)
	private String basetype_s;

	@Comment("主键ID")
	@Column(nullable = true, length = 0)
	private Integer id_i;

	@Comment("逻辑地址")
	@Column(nullable = true, length = 80)
	private String logicaladdress_s;

	@Comment("参数CODE")
	@Column(nullable = true, length = 80)
	private String parmcode_s;

	@Comment("参数中文名称")
	@Column(nullable = true, length = 80)
	private String parmname_s;

	@Comment("参数对象类型代码")
	@Column(nullable = true, length = 80)
	private String parmtypecode_s;

	@Comment("参数对象类型名称： 10-硫化时间 11-胶囊拉伸 12-定型位置 13-定型时间 14-定型压力 15-合模力 16-一次定型高度 17-后充气卡盘宽度 18-后充气压力 19-二次定型高度")
	@Column(nullable = true, length = 80)
	private String parmtypename_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 80)
	private String record_flag_s;

	@Comment("逻辑地址备注")
	@Column(nullable = true, length = 80)
	private String remark_s;

	@Comment("参数值")
	@Column(nullable = true, length = 80)
	private String value_s;

	@Comment("单位")
	@Column(nullable = true, length = 80)
	private String unit_s;
	@Comment("修改人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;
	@Comment("修改时间")
	@Column(nullable = true, length = 80)
	private Date changed_time_t;
	@Comment("机构编号")
	@Column(nullable = false, length = 16)
	private String agenc_no_s;
	@Comment("工厂")
	@Column(nullable = false, length = 160)
	private String s_factory_s;

	public String getS_factory_s() {
		return s_factory_s;
	}

	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
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

	public String getUnit_s() {
		return unit_s;
	}

	public void setUnit_s(String unit_s) {
		this.unit_s = unit_s;
	}

	public String getBasetype_s() {
		return basetype_s;
	}

	@XmlElement
	public void setBasetype_s(String basetype_s) {
		this.basetype_s = basetype_s;
	}

	public Integer getId_i() {
		return id_i;
	}

	@XmlElement
	public void setId_i(Integer id_i) {
		this.id_i = id_i;
	}

	public String getLogicaladdress_s() {
		return logicaladdress_s;
	}

	@XmlElement
	public void setLogicaladdress_s(String logicaladdress_s) {
		this.logicaladdress_s = logicaladdress_s;
	}

	public String getParmcode_s() {
		return parmcode_s;
	}

	@XmlElement
	public void setParmcode_s(String parmcode_s) {
		this.parmcode_s = parmcode_s;
	}

	public String getParmname_s() {
		return parmname_s;
	}

	@XmlElement
	public void setParmname_s(String parmname_s) {
		this.parmname_s = parmname_s;
	}

	public String getParmtypecode_s() {
		return parmtypecode_s;
	}

	@XmlElement
	public void setParmtypecode_s(String parmtypecode_s) {
		this.parmtypecode_s = parmtypecode_s;
	}

	public String getParmtypename_s() {
		return parmtypename_s;
	}

	@XmlElement
	public void setParmtypename_s(String parmtypename_s) {
		this.parmtypename_s = parmtypename_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getRemark_s() {
		return remark_s;
	}

	@XmlElement
	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}

	public String getValue_s() {
		return value_s;
	}

	@XmlElement
	public void setValue_s(String value_s) {
		this.value_s = value_s;
	}

}
