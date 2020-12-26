package com.bluebirdme.mes.linglong.sap.entity.dto;


public class InAllocatingOutboundATO {
    private String reserno_s;
    private String order_s;
    private String plantfrom_s;
    private String plantto_s;
    private String storlocfrom_s;
    private String storlocto_s;
    private String qty_s;
    private String demondsdate_s;//需求日期
    private String isdeliver_s;//是否发货
    private String department_s;//需求部门、、、等级
    
    
    
	public String getDepartment_s() {
		return department_s;
	}
	public void setDepartment_s(String department_s) {
		this.department_s = department_s;
	}
	public String getDemondsdate_s() {
		return demondsdate_s;
	}
	public void setDemondsdate_s(String demondsdate_s) {
		this.demondsdate_s = demondsdate_s;
	}

	
	public String getIsdeliver_s() {
		return isdeliver_s;
	}
	public void setIsdeliver_s(String isdeliver_s) {
		this.isdeliver_s = isdeliver_s;
	}
	public String getReserno_s() {
		return reserno_s;
	}
	public void setReserno_s(String reserno_s) {
		this.reserno_s = reserno_s;
	}
	public String getOrder_s() {
		return order_s;
	}
	public void setOrder_s(String order_s) {
		this.order_s = order_s;
	}
	public String getPlantfrom_s() {
		return plantfrom_s;
	}
	public void setPlantfrom_s(String plantfrom_s) {
		this.plantfrom_s = plantfrom_s;
	}
	public String getPlantto_s() {
		return plantto_s;
	}
	public void setPlantto_s(String plantto_s) {
		this.plantto_s = plantto_s;
	}
	public String getStorlocfrom_s() {
		return storlocfrom_s;
	}
	public void setStorlocfrom_s(String storlocfrom_s) {
		this.storlocfrom_s = storlocfrom_s;
	}
	public String getStorlocto_s() {
		return storlocto_s;
	}
	public void setStorlocto_s(String storlocto_s) {
		this.storlocto_s = storlocto_s;
	}
	public String getQty_s() {
		return qty_s;
	}
	public void setQty_s(String qty_s) {
		this.qty_s = qty_s;
	}
    
    
}
