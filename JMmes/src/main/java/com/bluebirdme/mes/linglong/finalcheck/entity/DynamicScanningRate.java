package com.bluebirdme.mes.linglong.finalcheck.entity;

import javax.persistence.Entity;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;

@Entity
public class DynamicScanningRate extends RockWellBaseEntity{

	private String created_time_t;
	private String entname_s;
	private String s_p;
	public String getCreated_time_t() {
		return created_time_t;
	}
	public void setCreated_time_t(String created_time_t) {
		this.created_time_t = created_time_t;
	}
	public String getEntname_s() {
		return entname_s;
	}
	public void setEntname_s(String entname_s) {
		this.entname_s = entname_s;
	}
	public String getS_p() {
		return s_p;
	}
	public void setS_p(String s_p) {
		this.s_p = s_p;
	}
	
	
}
