/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.curing.entity.ProductionDayPlan;

/**
 * 硫化生产日计划
 * @author 高飞
 * @Date 2018-09-06 14:34:18
 */
public class ProductionDayPlanDTO extends ProductionDayPlan{
    
    private List<ProductionDayPlan> inserted;
    private List<ProductionDayPlan> deleted;
    private List<ProductionDayPlan> updated;
    List<String> testParameterList;//用户选择的试验胎计划号列表
    String fromdate;//复制时选择的起始日期
    public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public List<String> getTestParameterList() {
		return testParameterList;
	}
	public void setTestParameterList(List<String> testParameterList) {
		this.testParameterList = testParameterList;
	}
	public List<ProductionDayPlan> getInserted() {
        return inserted;
    }
    public void setInserted(List<ProductionDayPlan> inserted) {
        this.inserted = inserted;
    }
    public List<ProductionDayPlan> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ProductionDayPlan> deleted) {
        this.deleted = deleted;
    }
    public List<ProductionDayPlan> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ProductionDayPlan> updated) {
        this.updated = updated;
    }
    
    
    
}
