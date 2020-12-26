package com.bluebirdme.mes.linglong.sap.entity.dto;

import com.bluebirdme.mes.linglong.sap.entity.ActualDNItem;

public class ActualDNItemATO extends ActualDNItem{
	private String dynamicbalancepasstime_t;
	private String materialdesc_s;
	private String gradecode_s;
	private String createdby_s;
	private String creation_time_date;	
	
	public String getCreatedby_s() {
		return createdby_s;
	}
	public void setCreatedby_s(String createdby_s) {
		this.createdby_s = createdby_s;
	}
	public String getDynamicbalancepasstime_t() {
		return dynamicbalancepasstime_t;
	}
	public void setDynamicbalancepasstime_t(String dynamicbalancepasstime_t) {
		this.dynamicbalancepasstime_t = dynamicbalancepasstime_t;
	}
	public String getMaterialdesc_s() {
		return materialdesc_s;
	}
	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}
	public String getGradecode_s() {
		return gradecode_s;
	}
	public void setGradecode_s(String gradecode_s) {
		this.gradecode_s = gradecode_s;
	}
	public String getCreation_time_date() {
		return creation_time_date;
	}
	public void setCreation_time_date(String creation_time_date) {
		this.creation_time_date = creation_time_date;
	}
	
	
	
}
