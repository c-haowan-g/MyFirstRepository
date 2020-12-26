package com.bluebirdme.mes.linglong.curing.entity.dto;


public class WorkOrderResultParam  {

	/**
	 * 生产时间
	 */
	private String production_date_s;
	
	/**
	 * 班次
	 */
	private String class_id_s;
	/**
	 * 物料规格
	 */
	private String material_code_s;
	/**
	 * 物料描述
	 */
	private String material_name_s;
	public String getProduction_date_s() {
		return production_date_s;
	}
	public void setProduction_date_s(String production_date_s) {
		this.production_date_s = production_date_s;
	}
	public String getClass_id_s() {
		return class_id_s;
	}
	public void setClass_id_s(String class_id_s) {
		this.class_id_s = class_id_s;
	}
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
	
	

}
