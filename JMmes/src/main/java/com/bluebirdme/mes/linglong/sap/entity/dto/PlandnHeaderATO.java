package com.bluebirdme.mes.linglong.sap.entity.dto;

import com.bluebirdme.mes.linglong.sap.entity.PlandnHeader;


public class PlandnHeaderATO extends PlandnHeader {
	
	
	private String lineitemno_s;
	private String materialcode_s;
	private String materialdesc_s;
	private String qty_s;
	private String batch_s;
	
	
	
	public String getMaterialdesc_s() {
		return materialdesc_s;
	}
	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}
	public String getLineitemno_s() {
		return lineitemno_s;
	}
	public void setLineitemno_s(String lineitemno_s) {
		this.lineitemno_s = lineitemno_s;
	}
	public String getMaterialcode_s() {
		return materialcode_s;
	}
	public void setMaterialcode_s(String materialcode_s) {
		this.materialcode_s = materialcode_s;
	}
	public String getBatch_s() {
		return batch_s;
	}
	public void setBatch_s(String batch_s) {
		this.batch_s = batch_s;
	}
	public String getQty_s() {
		return qty_s;
	}
	public void setQty_s(String qty_s) {
		this.qty_s = qty_s;
	}
	
	
	
	
	
	
  
}
