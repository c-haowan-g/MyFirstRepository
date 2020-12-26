/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

/**
 * 配方标准维护
 * @author 司乔靖
 * @Date 2018-08-01 10:00:25
 */

public class RecipeAll extends Recipe{
    
	 private String recipeno;
	 private String itemid_s;

	public String getItemid_s() {
		return itemid_s;
	}

	public void setItemid_s(String itemid_s) {
		this.itemid_s = itemid_s;
	}

	public String getRecipeno() {
		return recipeno;
	}

	public void setRecipeno(String recipeno) {
		this.recipeno = recipeno;
	} 
}
