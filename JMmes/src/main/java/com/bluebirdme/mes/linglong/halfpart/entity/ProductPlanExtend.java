/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.core.system.base.entity.BaseEntity;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 半部件计划拓展字段
 * @author 兰颖慧
 * @Date 2019-05-01 15:02:27
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPlanExtend extends ProductPlan {

    private float morn_planquantityconfirm_f;
    private float noon_planquantityconfirm_f;
    private float even_planquantityconfirm_f;
    private float total_planquantityconfirm_f;
    private String morn_planno_s;
    private String noon_planno_s;
    private String even_planno_s;
    private Integer morn_plan_order_i;
    private Integer noon_plan_order_i;
    private Integer even_plan_order_i;
    private String morn_atr_key;
    private String noon_atr_key;
    private String even_atr_key;
    private String morn_atr_name;
    private String noon_atr_name;
    private String even_atr_name;
    private String morn_status_s;
    private String noon_status_s;
    private String even_status_s;
	public String getMorn_planno_s() {
		return morn_planno_s;
	}
	public void setMorn_planno_s(String morn_planno_s) {
		this.morn_planno_s = morn_planno_s;
	}
	public String getNoon_planno_s() {
		return noon_planno_s;
	}
	public void setNoon_planno_s(String noon_planno_s) {
		this.noon_planno_s = noon_planno_s;
	}
	public String getEven_planno_s() {
		return even_planno_s;
	}
	public void setEven_planno_s(String even_planno_s) {
		this.even_planno_s = even_planno_s;
	}
	public Integer getMorn_plan_order_i() {
		return morn_plan_order_i;
	}
	public void setMorn_plan_order_i(Integer morn_plan_order_i) {
		this.morn_plan_order_i = morn_plan_order_i;
	}
	public Integer getNoon_plan_order_i() {
		return noon_plan_order_i;
	}
	public void setNoon_plan_order_i(Integer noon_plan_order_i) {
		this.noon_plan_order_i = noon_plan_order_i;
	}
	public Integer getEven_plan_order_i() {
		return even_plan_order_i;
	}
	public void setEven_plan_order_i(Integer even_plan_order_i) {
		this.even_plan_order_i = even_plan_order_i;
	}
	public String getMorn_atr_key() {
		return morn_atr_key;
	}
	public void setMorn_atr_key(String morn_atr_key) {
		this.morn_atr_key = morn_atr_key;
	}
	public String getNoon_atr_key() {
		return noon_atr_key;
	}
	public void setNoon_atr_key(String noon_atr_key) {
		this.noon_atr_key = noon_atr_key;
	}
	public String getEven_atr_key() {
		return even_atr_key;
	}
	public void setEven_atr_key(String even_atr_key) {
		this.even_atr_key = even_atr_key;
	}
	public String getMorn_atr_name() {
		return morn_atr_name;
	}
	public void setMorn_atr_name(String morn_atr_name) {
		this.morn_atr_name = morn_atr_name;
	}
	public String getNoon_atr_name() {
		return noon_atr_name;
	}
	public void setNoon_atr_name(String noon_atr_name) {
		this.noon_atr_name = noon_atr_name;
	}
	public String getEven_atr_name() {
		return even_atr_name;
	}
	public void setEven_atr_name(String even_atr_name) {
		this.even_atr_name = even_atr_name;
	}
	public float getMorn_planquantityconfirm_f() {
		return morn_planquantityconfirm_f;
	}
	public void setMorn_planquantityconfirm_f(float morn_planquantityconfirm_f) {
		this.morn_planquantityconfirm_f = morn_planquantityconfirm_f;
	}
	public float getNoon_planquantityconfirm_f() {
		return noon_planquantityconfirm_f;
	}
	public void setNoon_planquantityconfirm_f(float noon_planquantityconfirm_f) {
		this.noon_planquantityconfirm_f = noon_planquantityconfirm_f;
	}
	public float getTotal_planquantityconfirm_f() {
		return total_planquantityconfirm_f;
	}
	public void setTotal_planquantityconfirm_f(float total_planquantityconfirm_f) {
		this.total_planquantityconfirm_f = total_planquantityconfirm_f;
	}
	public float getEven_planquantityconfirm_f() {
		return even_planquantityconfirm_f;
	}
	public void setEven_planquantityconfirm_f(float even_planquantityconfirm_f) {
		this.even_planquantityconfirm_f = even_planquantityconfirm_f;
	}
	public String getMorn_status_s() {
		return morn_status_s;
	}
	public void setMorn_status_s(String morn_status_s) {
		this.morn_status_s = morn_status_s;
	}
	public String getNoon_status_s() {
		return noon_status_s;
	}
	public void setNoon_status_s(String noon_status_s) {
		this.noon_status_s = noon_status_s;
	}
	public String getEven_status_s() {
		return even_status_s;
	}
	public void setEven_status_s(String even_status_s) {
		this.even_status_s = even_status_s;
	}

}
