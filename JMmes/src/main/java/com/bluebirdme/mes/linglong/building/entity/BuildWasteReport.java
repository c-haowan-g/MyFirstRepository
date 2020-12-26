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

/**
 * 产出实绩表
 * @author 周志祥
 * @Date 2019-06-04 13:16:25
 */

public class BuildWasteReport {
    
	private String material_code_s;
	private String material_name_s;
	private String curingspeccode_s;
	private String materialspec_s;
	private Integer sumcount;
	private Integer gradea;
	private Integer gradea0;
	private Integer secondlevel;
	private Integer waste;
	private Integer specialwaste;
    private Integer sumwaste;
    private Integer curingwaste;
    private Integer buildwaste;
    private Integer dynawaste;
    private Integer xlightwaste;
    private Integer visuwaste;
	public String getMaterial_code_s() {
		return material_code_s;
	}
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}
	public String getMaterial_name_s() {
		return material_name_s;
	}
	public void setMaterial_name_s(String material_name_s) {
		this.material_name_s = material_name_s;
	}
	public String getCuringspeccode_s() {
		return curingspeccode_s;
	}
	public void setCuringspeccode_s(String curingspeccode_s) {
		this.curingspeccode_s = curingspeccode_s;
	}
	public String getMaterialspec_s() {
		return materialspec_s;
	}
	public void setMaterialspec_s(String materialspec_s) {
		this.materialspec_s = materialspec_s;
	}
	
	public Integer getSumcount() {
		return sumcount;
	}
	public void setSumcount(Integer sumcount) {
		this.sumcount = sumcount;
	}
	public Integer getGradea() {
		return gradea;
	}
	public void setGradea(Integer gradea) {
		this.gradea = gradea;
	}
	public Integer getGradea0() {
		return gradea0;
	}
	public void setGradea0(Integer gradea0) {
		this.gradea0 = gradea0;
	}
	public Integer getSecondlevel() {
		return secondlevel;
	}
	public void setSecondlevel(Integer secondlevel) {
		this.secondlevel = secondlevel;
	}
	public Integer getWaste() {
		return waste;
	}
	public void setWaste(Integer waste) {
		this.waste = waste;
	}
	public Integer getSpecialwaste() {
		return specialwaste;
	}
	public void setSpecialwaste(Integer specialwaste) {
		this.specialwaste = specialwaste;
	}
	public Integer getSumwaste() {
		return sumwaste;
	}
	public void setSumwaste(Integer sumwaste) {
		this.sumwaste = sumwaste;
	}
	public Integer getCuringwaste() {
		return curingwaste;
	}
	public void setCuringwaste(Integer curingwaste) {
		this.curingwaste = curingwaste;
	}
	public Integer getBuildwaste() {
		return buildwaste;
	}
	public void setBuildwaste(Integer buildwaste) {
		this.buildwaste = buildwaste;
	}
	public Integer getDynawaste() {
		return dynawaste;
	}
	public void setDynawaste(Integer dynawaste) {
		this.dynawaste = dynawaste;
	}
	public Integer getXlightwaste() {
		return xlightwaste;
	}
	public void setXlightwaste(Integer xlightwaste) {
		this.xlightwaste = xlightwaste;
	}
	public Integer getVisuwaste() {
		return visuwaste;
	}
	public void setVisuwaste(Integer visuwaste) {
		this.visuwaste = visuwaste;
	}
   
    
    
}
