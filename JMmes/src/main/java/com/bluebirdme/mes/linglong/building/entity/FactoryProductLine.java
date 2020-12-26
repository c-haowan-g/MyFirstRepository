/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.core.system.base.entity.BaseEntity;

/**
 * 成型机台信息管理
 * @author 刘程明
 * @Date 2019-01-11 15:02:27
 */
@Entity
public class FactoryProductLine extends BaseEntity {
 
	private String area_name;
	private String activetime_t;
	private String changeby_s;
	private Date changetime_t;
	private String createby_s;
	private Date createtime_t;
	private String department_s;
	private String description;
	private String factory_s;
	private String machinegroup_s;
	private String machinetype_s;
	private String manufacturingtime_t;
	private String memo_s;
	private String model_s;
	private String process_s;
	private String p_line_key;
	private String p_line_name;
	private String remarks_s;
	private String responsible_s;
	private String servicelife_s;
	private String shape_s;
	private String specification_s;
	private String weight_s;
	private String producttype_s;
	private String isplate_s;
	private String category;
	public String getProducttype_s() {
		return producttype_s;
	}
	public void setProducttype_s(String producttype_s) {
		this.producttype_s = producttype_s;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public String getActivetime_t() {
		return activetime_t;
	}
	public String getChangeby_s() {
		return changeby_s;
	}
	public Date getChangetime_t() {
		return changetime_t;
	}
	public String getCreateby_s() {
		return createby_s;
	}
	public Date getCreatetime_t() {
		return createtime_t;
	}
	public String getDepartment_s() {
		return department_s;
	}
	public String getDescription() {
		return description;
	}
	public String getFactory_s() {
		return factory_s;
	}
	public String getMachinegroup_s() {
		return machinegroup_s;
	}
	public String getMachinetype_s() {
		return machinetype_s;
	}
	public String getManufacturingtime_t() {
		return manufacturingtime_t;
	}
	public String getMemo_s() {
		return memo_s;
	}
	public String getModel_s() {
		return model_s;
	}
	public String getProcess_s() {
		return process_s;
	}
	public String getP_line_key() {
		return p_line_key;
	}
	public String getP_line_name() {
		return p_line_name;
	}
	public String getRemarks_s() {
		return remarks_s;
	}
	public String getResponsible_s() {
		return responsible_s;
	}
	public String getServicelife_s() {
		return servicelife_s;
	}
	public String getShape_s() {
		return shape_s;
	}
	public String getSpecification_s() {
		return specification_s;
	}
	public String getWeight_s() {
		return weight_s;
	}
	public void setActivetime_t(String activetime_t) {
		this.activetime_t = activetime_t;
	}
	public void setChangeby_s(String changeby_s) {
		this.changeby_s = changeby_s;
	}
	public void setChangetime_t(Date changetime_t) {
		this.changetime_t = changetime_t;
	}
	public void setCreateby_s(String createby_s) {
		this.createby_s = createby_s;
	}
	public void setCreatetime_t(Date createtime_t) {
		this.createtime_t = createtime_t;
	}
	public void setDepartment_s(String department_s) {
		this.department_s = department_s;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setFactory_s(String factory_s) {
		this.factory_s = factory_s;
	}
	public void setMachinegroup_s(String machinegroup_s) {
		this.machinegroup_s = machinegroup_s;
	}
	public void setMachinetype_s(String machinetype_s) {
		this.machinetype_s = machinetype_s;
	}
	public void setManufacturingtime_t(String manufacturingtime_t) {
		this.manufacturingtime_t = manufacturingtime_t;
	}
	public void setMemo_s(String memo_s) {
		this.memo_s = memo_s;
	}
	public void setModel_s(String model_s) {
		this.model_s = model_s;
	}
	public void setProcess_s(String process_s) {
		this.process_s = process_s;
	}
	public void setP_line_key(String p_line_key) {
		this.p_line_key = p_line_key;
	}
	public void setP_line_name(String p_line_name) {
		this.p_line_name = p_line_name;
	}
	public void setRemarks_s(String remarks_s) {
		this.remarks_s = remarks_s;
	}
	public void setResponsible_s(String responsible_s) {
		this.responsible_s = responsible_s;
	}
	public void setServicelife_s(String servicelife_s) {
		this.servicelife_s = servicelife_s;
	}
	public void setShape_s(String shape_s) {
		this.shape_s = shape_s;
	}
	public void setSpecification_s(String specification_s) {
		this.specification_s = specification_s;
	}
	public void setWeight_s(String weight_s) {
		this.weight_s = weight_s;
	}
	public String getIsplate_s() {
		return isplate_s;
	}
	public void setIsplate_s(String isplate_s) {
		this.isplate_s = isplate_s;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
