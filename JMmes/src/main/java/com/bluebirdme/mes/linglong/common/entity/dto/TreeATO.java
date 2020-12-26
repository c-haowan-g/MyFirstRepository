package com.bluebirdme.mes.linglong.common.entity.dto;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;

public class TreeATO extends RockWellBaseEntity{
	
	private String mater_code_s;
	private String mater_name_s;
	private String child_matercode_s;
	private String child_matername_s;
	public String getMater_code_s() {
		return mater_code_s;
	}
	public void setMater_code_s(String mater_code_s) {
		this.mater_code_s = mater_code_s;
	}
	public String getMater_name_s() {
		return mater_name_s;
	}
	public void setMater_name_s(String mater_name_s) {
		this.mater_name_s = mater_name_s;
	}
	public String getChild_matercode_s() {
		return child_matercode_s;
	}
	public void setChild_matercode_s(String child_matercode_s) {
		this.child_matercode_s = child_matercode_s;
	}
	public String getChild_matername_s() {
		return child_matername_s;
	}
	public void setChild_matername_s(String child_matername_s) {
		this.child_matername_s = child_matername_s;
	}
}
