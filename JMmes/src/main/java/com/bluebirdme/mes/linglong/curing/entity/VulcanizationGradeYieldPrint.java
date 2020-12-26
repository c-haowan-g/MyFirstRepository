/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;


/**
 * 硫化等级产量
 * @author 王海霖
 *
 */
public class VulcanizationGradeYieldPrint {

	private String atr_key;//主键
	
    private Integer quantity_plan;//计划量

    private Integer active_output;//实际产量
    
    private Integer gradea;//一级
    
    private Integer secondlevel;//二级
    
    private Integer waste;//废品
        
    private String username;//姓名
    
    private String usercode;//员工编号
    
    private String first_grade;//一级品率

    private String percentofpass;//合格率
    
    private String qualitycompletionrate;//完成率
    
    
    
	public String getFirst_grade() {
		return first_grade;
	}

	public void setFirst_grade(String first_grade) {
		this.first_grade = first_grade;
	}

	public String getPercentofpass() {
		return percentofpass;
	}

	public void setPercentofpass(String percentofpass) {
		this.percentofpass = percentofpass;
	}

	public String getQualitycompletionrate() {
		return qualitycompletionrate;
	}

	public void setQualitycompletionrate(String qualitycompletionrate) {
		this.qualitycompletionrate = qualitycompletionrate;
	}

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getAtr_key() {
		return atr_key;
	}

	public void setAtr_key(String atr_key) {
		this.atr_key = atr_key;
	}

	public Integer getQuantity_plan() {
		return quantity_plan;
	}

	public void setQuantity_plan(Integer quantity_plan) {
		this.quantity_plan = quantity_plan;
	}

	public Integer getActive_output() {
		return active_output;
	}

	public void setActive_output(Integer active_output) {
		this.active_output = active_output;
	}

	public Integer getGradea() {
		return gradea;
	}

	public void setGradea(Integer gradea) {
		this.gradea = gradea;
	}

	
	public Integer getSecondlevel() {
		return secondlevel;
	}

	public void setSecondlevel(Integer secondlevel) {
		this.secondlevel = secondlevel;
	}


	public Integer getWaste() {
		return waste;
	}

	public void setWaste(Integer waste) {
		this.waste = waste;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

   
  
}
