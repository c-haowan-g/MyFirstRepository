/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

/**
 * 分拣规则维护
 * @author lcm
 * @Date 2018-08-15 09:28:58
 */
public class SortltemAll extends Sortltem{
    
	private String entname_s;
	private String materialdesc_s; 
    private String  materialspec_s;
    private String   pattern_s;
    private String cj_s;
    private String recipeno_s;
    private String createdname;
    private String changebyname;
    
	public String getCreatedname() {
		return createdname;
	}
	public void setCreatedname(String createdname) {
		this.createdname = createdname;
	}
	public String getChangebyname() {
		return changebyname;
	}
	public void setChangebyname(String changebyname) {
		this.changebyname = changebyname;
	}
	public String getRecipeno_s() {
		return recipeno_s;
	}
	public void setRecipeno_s(String recipeno_s) {
		this.recipeno_s = recipeno_s;
	}
	public String getEntname_s() {
		return entname_s;
	}
	public void setEntname_s(String entname_s) {
		this.entname_s = entname_s;
	}
	public String getMaterialdesc_s() {
		return materialdesc_s;
	}
	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}
	public String getMaterialspec_s() {
		return materialspec_s;
	}
	public void setMaterialspec_s(String materialspec_s) {
		this.materialspec_s = materialspec_s;
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
