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

public class WorkOrderResultPrint {

	private String atr_key;
	
    private String class_id_s;
 
    private String equip_code_s;
    
    private String material_name_s;

    private Integer totalquantity;
    
    private Integer gradea;
    
    private Integer gradea0;
    
    private Integer secondlevel;
    
    private Integer waste;
    
    private Integer specialwaste;
        
    private String username;

    private String spare1_s;//日计划表硫化总时间
    
    private String curing_openmoulddate;
    private String curing_closemoulddate;
    
    private String qualitycompletionrate;
    private String s_factory_s;
    private String material_code_s;
    
    
    public String getMaterial_code_s() {
		return material_code_s;
	}

	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getCuring_openmoulddate() {
		return curing_openmoulddate;
	}

	public void setCuring_openmoulddate(String curing_openmoulddate) {
		this.curing_openmoulddate = curing_openmoulddate;
	}

	public String getCuring_closemoulddate() {
		return curing_closemoulddate;
	}

	public void setCuring_closemoulddate(String curing_closemoulddate) {
		this.curing_closemoulddate = curing_closemoulddate;
	}

	public String getSpare1_s() {
		return spare1_s;
	}

	public void setSpare1_s(String spare1_s) {
		this.spare1_s = spare1_s;
	}

	
    

	public String getAtr_key() {
		return atr_key;
	}

	public void setAtr_key(String atr_key) {
		this.atr_key = atr_key;
	}

	public String getQualitycompletionrate() {
		return qualitycompletionrate;
	}

	public void setQualitycompletionrate(String qualitycompletionrate) {
		this.qualitycompletionrate = qualitycompletionrate;
	}



	public String getClass_id_s() {
		return class_id_s;
	}

	public void setClass_id_s(String class_id_s) {
		this.class_id_s = class_id_s;
	}

	public String getEquip_code_s() {
		return equip_code_s;
	}

	public void setEquip_code_s(String equip_code_s) {
		this.equip_code_s = equip_code_s;
	}

	

	public String getMaterial_name_s() {
		return material_name_s;
	}

	public void setMaterial_name_s(String material_name_s) {
		this.material_name_s = material_name_s;
	}

	public Integer getTotalquantity() {
		return totalquantity;
	}

	public void setTotalquantity(Integer totalquantity) {
		this.totalquantity = totalquantity;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
