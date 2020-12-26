/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.sap.entity.Customer;

/**
 * 客户主数据信息
 * 
 * @author 刘朋
 * @Date 2018-09-25 15:16:48
 */
public class CustomerDTO extends Customer {

	private List<Customer> inserted;
	private List<Customer> deleted;
	private List<Customer> updated;

	public List<Customer> getInserted() {
		return inserted;
	}

	public void setInserted(List<Customer> inserted) {
		this.inserted = inserted;
	}

	public List<Customer> getDeleted() {
		return deleted;
	}

	public void setDeleted(List<Customer> deleted) {
		this.deleted = deleted;
	}

	public List<Customer> getUpdated() {
		return updated;
	}

	public void setUpdated(List<Customer> updated) {
		this.updated = updated;
	}

}
