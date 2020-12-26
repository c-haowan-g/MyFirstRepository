/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

import java.util.Date;


/**
 * 动平衡分拣履历查询
 * @author 刘程明
 * @Date 2018-08-08 12:02:29
 */
public class DetialAll extends Detial{
    //当前状态
	private String nowstate;
	public String getNowstate() {
		return nowstate;
	}
	public void setNowstate(String nowstate) {
		this.nowstate = nowstate;
	}
	//判级状态
	private String pjstate;
	public String getPjstate() {
		return pjstate;
	}
	public void setPjstate(String pjstate) {
		this.pjstate = pjstate;
	}
	//缺陷描述
	private String reas_cn_s;
	public String getReas_cn_s() {
		return reas_cn_s;
	}
	public void setReas_cn_s(String reas_cn_s) {
		this.reas_cn_s = reas_cn_s;
	}
	//病象类描述
	private String collet_code_desc_cn_s;
	public String getCollet_code_desc_cn_s() {
		return collet_code_desc_cn_s;
	}
	public void setCollet_code_desc_cn_s(String collet_code_desc_cn_s) {
		this.collet_code_desc_cn_s = collet_code_desc_cn_s;
	}  
	//总返修次数
	private String totalreworknum_i;
	public String getTotalreworknum_i() {
		return totalreworknum_i;
	}
	public void setTotalreworknum_i(String totalreworknum_i) {
		this.totalreworknum_i = totalreworknum_i;
	}
	
	//硫化机台
	private String curingmachinecode_s;
	public String getCuringmachinecode_s() {
		return curingmachinecode_s;
	}
	public void setCuringmachinecode_s(String curingmachinecode_s) {
		this.curingmachinecode_s = curingmachinecode_s;
	}
	//规格名称
	private String materialdesc_s;
	public String getMaterialdesc_s() {
		return materialdesc_s;
	}
	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}
	
	//开模时间
	private Date curingopenmouldtime_t;
	
	
	public Date getCuringopenmouldtime_t() {
		return curingopenmouldtime_t;
	}
	public void setCuringopenmouldtime_t(Date curingopenmouldtime_t) {
		this.curingopenmouldtime_t = curingopenmouldtime_t;
	}
	//合模时间
	private Date curingclosemouldtime_t;
	public Date getCuringclosemouldtime_t() {
		return curingclosemouldtime_t;
	}
	public void setCuringclosemouldtime_t(Date curingclosemouldtime_t) {
		this.curingclosemouldtime_t = curingclosemouldtime_t;
	}
	
	
}
