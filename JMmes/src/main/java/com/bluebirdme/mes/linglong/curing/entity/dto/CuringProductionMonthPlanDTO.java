/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.curing.entity.CuringProductionMonthPlan;

/**
 * 硫化月计划编制
 * 
 * @author 李彦
 * @Date 2018-08-07 13:15:32
 */
public class CuringProductionMonthPlanDTO extends CuringProductionMonthPlan {

	private List<CuringProductionMonthPlan> inserted;
	private List<CuringProductionMonthPlan> deleted;
	private List<CuringProductionMonthPlan> updated;

	public List<CuringProductionMonthPlan> getInserted() {
		return inserted;
	}

	public void setInserted(List<CuringProductionMonthPlan> inserted) {
		this.inserted = inserted;
	}

	public List<CuringProductionMonthPlan> getDeleted() {
		return deleted;
	}

	public void setDeleted(List<CuringProductionMonthPlan> deleted) {
		this.deleted = deleted;
	}

	public List<CuringProductionMonthPlan> getUpdated() {
		return updated;
	}

	public void setUpdated(List<CuringProductionMonthPlan> updated) {
		this.updated = updated;
	}

}
