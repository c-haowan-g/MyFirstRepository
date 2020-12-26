/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 成型报产数据
 * @author 兰颖慧
 * @Date 2019-02-27 15:04:20
 */
public class WorkOrderResultReport{
    //成型班次
    private String building_shift_s;
	//生产版本
	private String production_ver_s;
	//物料编码
	private String material_code_s;
	//物料名称
	private String material_name_s;
	//合计数量
	private String total;

	//成型班次
	public String getBuilding_shift_s() {
		return building_shift_s;
	}
	public void setBuilding_shift_s(String building_shift_s) {
		this.building_shift_s = building_shift_s;
	}
	//生产版本
	public String getProduction_ver_s() {
		return production_ver_s;
	}
	public void setProduction_ver_s(String production_ver_s) {
		this.production_ver_s = production_ver_s;
	}
	//物料编码
	public String getMaterial_code_s() {
		return material_code_s;
	}
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}
	//物料名称
	public String getMaterial_name_s() {
		return material_name_s;
	}
	public void setMaterial_name_s(String material_name_s) {
		this.material_name_s = material_name_s;
	}
	//合计数量
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}


}
