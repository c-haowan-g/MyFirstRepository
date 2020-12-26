/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.sap.entity.ProductVersion;

/**
 * SAP下发生产版本
 * 
 * @author 刘朋
 * @Date 2018-09-22 16:49:09
 */
public class ProductVersionDTO extends ProductVersion {

	private List<ProductVersion> inserted;
	private List<ProductVersion> deleted;
	private List<ProductVersion> updated;

	public List<ProductVersion> getInserted() {
		return inserted;
	}

	public void setInserted(List<ProductVersion> inserted) {
		this.inserted = inserted;
	}

	public List<ProductVersion> getDeleted() {
		return deleted;
	}

	public void setDeleted(List<ProductVersion> deleted) {
		this.deleted = deleted;
	}

	public List<ProductVersion> getUpdated() {
		return updated;
	}

	public void setUpdated(List<ProductVersion> updated) {
		this.updated = updated;
	}

}
