/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;

/**
 * 硫化生产日计划 Title: ProductionDayPlanEXT
 * 
 * @author penga_liu
 * @Date 2019年11月2日 上午9:15:22
 */
public class ProductionDayPlanEXT extends ProductionDayPlan {

	private String spec_left_s;
	private String spec_right_s;

	public String getSpec_left_s() {
		return spec_left_s;
	}

	public void setSpec_left_s(String spec_left_s) {
		this.spec_left_s = spec_left_s;
	}

	public String getSpec_right_s() {
		return spec_right_s;
	}

	public void setSpec_right_s(String spec_right_s) {
		this.spec_right_s = spec_right_s;
	}

}
