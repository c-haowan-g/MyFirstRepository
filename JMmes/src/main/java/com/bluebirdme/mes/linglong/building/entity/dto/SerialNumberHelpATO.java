package com.bluebirdme.mes.linglong.building.entity.dto;

import com.bluebirdme.mes.linglong.building.entity.SerialNumberHelp;

public class SerialNumberHelpATO extends SerialNumberHelp{
	private String created_by_name;
	private String changed_by_name;
	public String getCreated_by_name() {
		return created_by_name;
	}
	public void setCreated_by_name(String created_by_name) {
		this.created_by_name = created_by_name;
	}
	public String getChanged_by_name() {
		return changed_by_name;
	}
	public void setChanged_by_name(String changed_by_name) {
		this.changed_by_name = changed_by_name;
	}
	
	
}
