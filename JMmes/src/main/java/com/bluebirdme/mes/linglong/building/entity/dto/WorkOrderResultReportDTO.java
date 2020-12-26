/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.building.entity.WorkOrderResultReport;

/**
 * 成型报产
 * 
 * @author 兰颖慧
 * @Date 2019-02-27 11:45:20
 */
public class WorkOrderResultReportDTO extends WorkOrderResultReport {
	// 创建实体列表对象
	private List<WorkOrderResultReport> selectedrows;
	// 成型开始时间
	private String begintime;
	// 成型结束时间
	private String endtime;

	// 成型开始时间
	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	// 成型结束时间
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	// 创建实体列表对象
	public List<WorkOrderResultReport> getSelectedrows() {
		return selectedrows;
	}

	public void setSelectedrows(List<WorkOrderResultReport> selectedrows) {
		this.selectedrows = selectedrows;
	}

}
