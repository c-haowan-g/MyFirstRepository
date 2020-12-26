/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

/**
 * 成型报产数据
 * @author 兰颖慧
 * @Date 2019-02-27 15:04:20
 */
public class UpdateWorkOrderResultReport{
    //成型班次
    private String buildingshift_s;
	//生产版本
	private String productionver_s;
	//物料编码
	private String material_code_s;
	//物料名称
	private String material_name_s;
	//合计数量
	private String total;
	
	public String getBuildingshift_s() {
		return buildingshift_s;
	}
	public void setBuildingshift_s(String buildingshift_s) {
		this.buildingshift_s = buildingshift_s;
	}
	public String getProductionver_s() {
		return productionver_s;
	}
	public void setProductionver_s(String productionver_s) {
		this.productionver_s = productionver_s;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

}
