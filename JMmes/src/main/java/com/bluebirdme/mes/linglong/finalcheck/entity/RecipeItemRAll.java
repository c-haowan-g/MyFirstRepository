/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

/**
 * 质检配方规格表_全
 * @author 刘程明
 * @Date 2018-08-08 14:16:57
 */
public class RecipeItemRAll extends RecipeItem{
    
   private String materialdesc_s; 
   private String  materialspec_s;
   private String   pattern_s;
   private String cj_s;
   private String recipeno_s;

public String getRecipeno_s() {
	return recipeno_s;
}

public void setRecipeno_s(String recipeno_s) {
	this.recipeno_s = recipeno_s;
}

public String getCj_s() {
	return cj_s;
}

public void setCj_s(String cj_s) {
	this.cj_s = cj_s;
}

public String getmaterialdesc_s() {
	return materialdesc_s;
}

public void setmaterialdesc_s(String materialdesc_s) {
	this.materialdesc_s = materialdesc_s;
}

public String getmaterialspec_s() {
	return materialspec_s;
}

public void setmaterialspec_s(String materialspec_s) {
	this.materialspec_s = materialspec_s;
}

public String getPattern_s() {
	return pattern_s;
}

public void setPattern_s(String pattern_s) {
	this.pattern_s = pattern_s;
}
   
   
}
