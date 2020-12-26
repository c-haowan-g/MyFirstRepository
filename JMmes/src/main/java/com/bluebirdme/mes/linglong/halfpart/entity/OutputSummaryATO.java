package com.bluebirdme.mes.linglong.halfpart.entity;

public class OutputSummaryATO {

	//主键
	private String atr_key;
	
	//机台条码
	private String machinecode_s;
	
	//机台名称
	private String machinename_s;
	
	//物料编码
	private String materialcode_s;
	
	//物料名称
	private String materialname_s;
	
	//班次
	private String outclass_s;
	
	//助手操作工
	private String operator1_s;
	
	//汇总量
	private String amount_i;
	
	//汇总量
	private String outnum_f;

	public String getAtr_key() {
		return atr_key;
	}

	public void setAtr_key(String atr_key) {
		this.atr_key = atr_key;
	}

	public String getOutclass_s() {
		return outclass_s;
	}

	public void setOutclass_s(String outclass_s) {
		this.outclass_s = outclass_s;
	}

	public String getAmount_i() {
		return amount_i;
	}

	public void setAmount_i(String amount_i) {
		this.amount_i = amount_i;
	}

	public String getOutnum_f() {
		return outnum_f;
	}

	public void setOutnum_f(String outnum_f) {
		this.outnum_f = outnum_f;
	}

	public String getMachinecode_s() {
		return machinecode_s;
	}

	public void setMachinecode_s(String machinecode_s) {
		this.machinecode_s = machinecode_s;
	}

	public String getMachinename_s() {
		return machinename_s;
	}

	public void setMachinename_s(String machinename_s) {
		this.machinename_s = machinename_s;
	}

	public String getMaterialcode_s() {
		return materialcode_s;
	}

	public void setMaterialcode_s(String materialcode_s) {
		this.materialcode_s = materialcode_s;
	}

	public String getMaterialname_s() {
		return materialname_s;
	}

	public void setMaterialname_s(String materialname_s) {
		this.materialname_s = materialname_s;
	}

	public String getOperator1_s() {
		return operator1_s;
	}

	public void setOperator1_s(String operator1_s) {
		this.operator1_s = operator1_s;
	}
	
	
}
