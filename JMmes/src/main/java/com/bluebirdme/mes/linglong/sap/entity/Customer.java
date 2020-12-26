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
 * 客户主数据信息
 * 
 * @author 刘朋
 * @Date 2018-09-25 15:16:48
 */
@ATDefinition("INT_SAP_CUSTOMER")
@Entity
@XmlRootElement
@Table(name = "AT_INT_SAP_CUSTOMER")
public class Customer extends RockWellBaseEntity {

	@Comment("地区ID，A、B等/亚太区等")
	@Column(nullable = true, length = 300)
	private String areaid_s;

	@Comment("地区描述，A、B等/亚太区等")
	@Column(nullable = true, length = 300)
	private String area_s;

	@Comment("核准情况（1：已核准、2：尚待核准、3：不准交易）")
	@Column(nullable = true, length = 80)
	private String authorize_s;

	@Comment("创建日期")
	@Column(nullable = true, length = 80)
	private String cdate_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 80)
	private String ctime_s;

	@Comment("公司代码")
	@Column(nullable = true, length = 80)
	private String comparea_s;

	@Comment("联系人")
	@Column(nullable = true, length = 80)
	private String contactor_s;

	@Comment("国家描述")
	@Column(nullable = true, length = 80)
	private String countrydesc_s;

	@Comment("国家")
	@Column(nullable = true, length = 80)
	private String countryid_s;

	@Comment("客户全称英文")
	@Column(nullable = true, length = 300)
	private String customename_en_s;

	@Comment("客户全称")
	@Column(nullable = true, length = 300)
	private String customename_s;

	@Comment("客户全称英文")
	@Column(nullable = true, length = 300)
	private String customename_th_s;

	@Comment("客户简称英文")
	@Column(nullable = true, length = 300)
	private String customenick_en_s;

	@Comment("客户简称")
	@Column(nullable = true, length = 80)
	private String customenick_s;

	@Comment("客户简称泰文")
	@Column(nullable = true, length = 300)
	private String customenick_th_s;

	@Comment("客户编码")
	@Column(nullable = true, length = 80)
	private String customerid_s;

	@Comment("部门描述")
	@Column(nullable = true, length = 300)
	private String deptdesc_s;

	@Comment("部门")
	@Column(nullable = true, length = 80)
	private String deptid_s;

	@Comment("客户的删除标记 (销售级别0)")
	@Column(nullable = true, length = 80)
	private String dummy1_s;

	@Comment("预留2")
	@Column(nullable = true, length = 80)
	private String dummy2_s;

	@Comment("预留3")
	@Column(nullable = true, length = 80)
	private String dummy3_s;

	@Comment("预留4")
	@Column(nullable = true, length = 80)
	private String dummy4_s;

	@Comment("总公司编号")
	@Column(nullable = true, length = 80)
	private String headcomid_s;

	@Comment("总公司名称")
	@Column(nullable = true, length = 200)
	private String headcom_s;

	@Comment("无描述")
	@Column(nullable = true, length = 80)
	private String ma004_s;

	@Comment("无描述")
	@Column(nullable = true, length = 80)
	private String ma023_s;

	@Comment("无描述")
	@Column(nullable = true, length = 80)
	private String ma024_s;

	@Comment("无描述")
	@Column(nullable = true, length = 80)
	private String ma076_s;

	@Comment("无描述")
	@Column(nullable = true, length = 80)
	private String ma102_s;

	@Comment("品牌描述")
	@Column(nullable = true, length = 200)
	private String markdesc_s;

	@Comment("品牌")
	@Column(nullable = true, length = 80)
	private String mark_s;

	@Comment("渠道描述")
	@Column(nullable = true, length = 300)
	private String passdesc_s;

	@Comment("渠道，出口/内销")
	@Column(nullable = true, length = 80)
	private String pass_s;

	@Comment("备注，地址注释")
	@Column(nullable = true, length = 200)
	private String remark_s;

	@Comment("业务人员，需要传入代码和描述，EC根据此信息维护")
	@Column(nullable = true, length = 80)
	private String salesid_s;

	@Comment("业务人员名")
	@Column(nullable = true, length = 80)
	private String salesname_s;

	@Comment("物料删除状态 ")
	@Column(nullable = true, length = 80)
	private String status_s;

	@Comment("同步时间")
	@Column(nullable = true, length = 0)
	private Date synchronous_time_t;

	@Comment("税号")
	@Column(nullable = true, length = 80)
	private String taxid_s;

	@Comment("最后修改日期")
	@Column(nullable = true, length = 80)
	private String udate_s;

	@Comment("最后修改时间")
	@Column(nullable = true, length = 80)
	private String utime_s;

	public String getAreaid_s() {
		return areaid_s;
	}

	@XmlElement
	public void setAreaid_s(String areaid_s) {
		this.areaid_s = areaid_s;
	}

	public String getArea_s() {
		return area_s;
	}

	@XmlElement
	public void setArea_s(String area_s) {
		this.area_s = area_s;
	}

	public String getAuthorize_s() {
		return authorize_s;
	}

	@XmlElement
	public void setAuthorize_s(String authorize_s) {
		this.authorize_s = authorize_s;
	}

	public String getCdate_s() {
		return cdate_s;
	}

	@XmlElement
	public void setCdate_s(String cdate_s) {
		this.cdate_s = cdate_s;
	}

	public String getCtime_s() {
		return ctime_s;
	}

	@XmlElement
	public void setCtime_s(String ctime_s) {
		this.ctime_s = ctime_s;
	}

	public String getComparea_s() {
		return comparea_s;
	}

	@XmlElement
	public void setComparea_s(String comparea_s) {
		this.comparea_s = comparea_s;
	}

	public String getContactor_s() {
		return contactor_s;
	}

	@XmlElement
	public void setContactor_s(String contactor_s) {
		this.contactor_s = contactor_s;
	}

	public String getCountrydesc_s() {
		return countrydesc_s;
	}

	@XmlElement
	public void setCountrydesc_s(String countrydesc_s) {
		this.countrydesc_s = countrydesc_s;
	}

	public String getCountryid_s() {
		return countryid_s;
	}

	@XmlElement
	public void setCountryid_s(String countryid_s) {
		this.countryid_s = countryid_s;
	}

	public String getCustomename_en_s() {
		return customename_en_s;
	}

	@XmlElement
	public void setCustomename_en_s(String customename_en_s) {
		this.customename_en_s = customename_en_s;
	}

	public String getCustomename_s() {
		return customename_s;
	}

	@XmlElement
	public void setCustomename_s(String customename_s) {
		this.customename_s = customename_s;
	}

	public String getCustomename_th_s() {
		return customename_th_s;
	}

	@XmlElement
	public void setCustomename_th_s(String customename_th_s) {
		this.customename_th_s = customename_th_s;
	}

	public String getCustomenick_en_s() {
		return customenick_en_s;
	}

	@XmlElement
	public void setCustomenick_en_s(String customenick_en_s) {
		this.customenick_en_s = customenick_en_s;
	}

	public String getCustomenick_s() {
		return customenick_s;
	}

	@XmlElement
	public void setCustomenick_s(String customenick_s) {
		this.customenick_s = customenick_s;
	}

	public String getCustomenick_th_s() {
		return customenick_th_s;
	}

	@XmlElement
	public void setCustomenick_th_s(String customenick_th_s) {
		this.customenick_th_s = customenick_th_s;
	}

	public String getCustomerid_s() {
		return customerid_s;
	}

	@XmlElement
	public void setCustomerid_s(String customerid_s) {
		this.customerid_s = customerid_s;
	}

	public String getDeptdesc_s() {
		return deptdesc_s;
	}

	@XmlElement
	public void setDeptdesc_s(String deptdesc_s) {
		this.deptdesc_s = deptdesc_s;
	}

	public String getDeptid_s() {
		return deptid_s;
	}

	@XmlElement
	public void setDeptid_s(String deptid_s) {
		this.deptid_s = deptid_s;
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

	public String getHeadcomid_s() {
		return headcomid_s;
	}

	@XmlElement
	public void setHeadcomid_s(String headcomid_s) {
		this.headcomid_s = headcomid_s;
	}

	public String getHeadcom_s() {
		return headcom_s;
	}

	@XmlElement
	public void setHeadcom_s(String headcom_s) {
		this.headcom_s = headcom_s;
	}

	public String getMa004_s() {
		return ma004_s;
	}

	@XmlElement
	public void setMa004_s(String ma004_s) {
		this.ma004_s = ma004_s;
	}

	public String getMa023_s() {
		return ma023_s;
	}

	@XmlElement
	public void setMa023_s(String ma023_s) {
		this.ma023_s = ma023_s;
	}

	public String getMa024_s() {
		return ma024_s;
	}

	@XmlElement
	public void setMa024_s(String ma024_s) {
		this.ma024_s = ma024_s;
	}

	public String getMa076_s() {
		return ma076_s;
	}

	@XmlElement
	public void setMa076_s(String ma076_s) {
		this.ma076_s = ma076_s;
	}

	public String getMa102_s() {
		return ma102_s;
	}

	@XmlElement
	public void setMa102_s(String ma102_s) {
		this.ma102_s = ma102_s;
	}

	public String getMarkdesc_s() {
		return markdesc_s;
	}

	@XmlElement
	public void setMarkdesc_s(String markdesc_s) {
		this.markdesc_s = markdesc_s;
	}

	public String getMark_s() {
		return mark_s;
	}

	@XmlElement
	public void setMark_s(String mark_s) {
		this.mark_s = mark_s;
	}

	public String getPassdesc_s() {
		return passdesc_s;
	}

	@XmlElement
	public void setPassdesc_s(String passdesc_s) {
		this.passdesc_s = passdesc_s;
	}

	public String getPass_s() {
		return pass_s;
	}

	@XmlElement
	public void setPass_s(String pass_s) {
		this.pass_s = pass_s;
	}

	public String getRemark_s() {
		return remark_s;
	}

	@XmlElement
	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}

	public String getSalesid_s() {
		return salesid_s;
	}

	@XmlElement
	public void setSalesid_s(String salesid_s) {
		this.salesid_s = salesid_s;
	}

	public String getSalesname_s() {
		return salesname_s;
	}

	@XmlElement
	public void setSalesname_s(String salesname_s) {
		this.salesname_s = salesname_s;
	}

	public String getStatus_s() {
		return status_s;
	}

	@XmlElement
	public void setStatus_s(String status_s) {
		this.status_s = status_s;
	}

	public Date getSynchronous_time_t() {
		return synchronous_time_t;
	}

	@XmlElement
	public void setSynchronous_time_t(Date synchronous_time_t) {
		this.synchronous_time_t = synchronous_time_t;
	}

	public String getTaxid_s() {
		return taxid_s;
	}

	@XmlElement
	public void setTaxid_s(String taxid_s) {
		this.taxid_s = taxid_s;
	}

	public String getUdate_s() {
		return udate_s;
	}

	@XmlElement
	public void setUdate_s(String udate_s) {
		this.udate_s = udate_s;
	}

	public String getUtime_s() {
		return utime_s;
	}

	@XmlElement
	public void setUtime_s(String utime_s) {
		this.utime_s = utime_s;
	}

}
