/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

/**
 * 合格率
 * @author 刘程明
 * @Date 2018-09-12 17:58:15
 */
public class DynaBalanceCheResultPrint   {
    private String speccount;
    private String curingspeccode_s;
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

	private String materialdesc_s;

	public String getSpeccount() {
		return speccount;
	}

	public void setSpeccount(String speccount) {
		this.speccount = speccount;
	}

    
}
