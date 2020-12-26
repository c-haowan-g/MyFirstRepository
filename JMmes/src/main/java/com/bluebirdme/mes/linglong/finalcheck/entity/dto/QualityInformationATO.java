package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

public class QualityInformationATO {

	//一级品数量
	private String a_count;
	
	//二级品数量
	private String b_count;
	
	//废品数量
	private String waste_count;
	
	//外检废品数量
	private String visual_waste_count;
	
	//动平衡检查废品数量
	private String dynamic_waste_count;

	//x光检测废品数量
	private String xlight_waste_count;

	public String getA_count() {
		return a_count;
	}

	public void setA_count(String a_count) {
		this.a_count = a_count;
	}

	public String getB_count() {
		return b_count;
	}

	public void setB_count(String b_count) {
		this.b_count = b_count;
	}

	public String getWaste_count() {
		return waste_count;
	}

	public void setWaste_count(String waste_count) {
		this.waste_count = waste_count;
	}

	public String getVisual_waste_count() {
		return visual_waste_count;
	}

	public void setVisual_waste_count(String visual_waste_count) {
		this.visual_waste_count = visual_waste_count;
	}

	public String getDynamic_waste_count() {
		return dynamic_waste_count;
	}

	public void setDynamic_waste_count(String dynamic_waste_count) {
		this.dynamic_waste_count = dynamic_waste_count;
	}

	public String getXlight_waste_count() {
		return xlight_waste_count;
	}

	public void setXlight_waste_count(String xlight_waste_count) {
		this.xlight_waste_count = xlight_waste_count;
	}
	
	
}
