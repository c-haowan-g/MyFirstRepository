/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

import java.math.BigDecimal;


/**
 * 分拣规则维护
 * @author lcm
 * @Date 2018-08-15 09:28:58
 */
public class SortltemTab4 {
    private String itemid_s;//物料编码
	private String materialdesc_s; //物料描述
    private String   pattern_s;//花纹
    private String cj_s;//层级
    private BigDecimal num_i;//抽检比例
    private BigDecimal spare3_s;//备胎  0/1
	public String getItemid_s() {
		return itemid_s;
	}
	public void setItemid_s(String itemid_s) {
		this.itemid_s = itemid_s;
	}
	public BigDecimal getSpare3_s() {
		return spare3_s;
	}
	public void setSpare3_s(BigDecimal spare3_s) {
		this.spare3_s = spare3_s;
	}
	public BigDecimal getNum_i() {
		return num_i;
	}
	public void setNum_i(BigDecimal num_i) {
		this.num_i = num_i;
	}
	public String getMaterialdesc_s() {
		return materialdesc_s;
	}
	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}
	
	public String getPattern_s() {
		return pattern_s;
	}
	public void setPattern_s(String pattern_s) {
		this.pattern_s = pattern_s;
	}
	public String getCj_s() {
		return cj_s;
	}
	public void setCj_s(String cj_s) {
		this.cj_s = cj_s;
	}
    
}
