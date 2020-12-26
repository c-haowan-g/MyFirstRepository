package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import com.bluebirdme.mes.linglong.finalcheck.entity.Balandproresult;

/**
 * 扩展实体
 * 
 * @author Administrator
 * 
 */
public class BalandproresultATO extends Balandproresult {
	private String curingspeccode_s;
	private String created_by;// 创建
	private String changed_by;// 修改
	private String gradecode_s;// 总质量等级
	private String curingmachinecode_s;// 硫化机台
	private String buildinmachinecode_s;// 成型机台

	public String getBuildinmachinecode_s() {
		return buildinmachinecode_s;
	}

	public void setBuildinmachinecode_s(String buildinmachinecode_s) {
		this.buildinmachinecode_s = buildinmachinecode_s;
	}

	public String getCuringmachinecode_s() {
		return curingmachinecode_s;
	}

	public void setCuringmachinecode_s(String curingmachinecode_s) {
		this.curingmachinecode_s = curingmachinecode_s;
	}

	public String getCuringspeccode_s() {
		return curingspeccode_s;
	}

	public void setCuringspeccode_s(String curingspeccode_s) {
		this.curingspeccode_s = curingspeccode_s;
	}

	public String getMaterialdesc_s() {
		return materialdesc_s;
	}

	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getChanged_by() {
		return changed_by;
	}

	public void setChanged_by(String changed_by) {
		this.changed_by = changed_by;
	}

	public String getGradecode_s() {
		return gradecode_s;
	}

	public void setGradecode_s(String gradecode_s) {
		this.gradecode_s = gradecode_s;
	}

	private String materialdesc_s;
}
