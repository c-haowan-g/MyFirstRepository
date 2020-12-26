/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 
 * @author Goofy
 * @Date 2018年9月12日 下午2:59:06
 */
@ATDefinition("C_MM_PlanCuringParameter")
@Entity
@Table(name="AT_C_MM_PlanCuringParameter")
public class CuringProcessParameter extends RockWellBaseEntity {
	
	
	public CuringProcessParameter(String dailyPlanCode,Map<String,Object> map,String material_code,int direction){
		
		this.agenc_no_s=LLConstant.JING_MEN_CODE;
		this.s_factory_s=LLWebUtils.factory();
		this.record_flag_s="A";
		this.producting_dayplan_s=dailyPlanCode;
		this.parameter_code_s=(String) map.get("PARMCODE_S");
		this.parameter_name_s=(String) map.get("PARMNAME_S");
		this.parameter_value_s=(String) map.get("VALUE_S");
		this.parameter_logicaddress_s=(String) map.get("LOGICALADDRESS_S");
		if(direction==1){
			//右物料编码
		this.spare1_s=material_code;}
		else{
			//左物料编码
		this.material_code_s=material_code;}
		
	}
public CuringProcessParameter(String dailyPlanCode,Map<String,Object> map){
		
		this.agenc_no_s=LLConstant.JING_MEN_CODE;
		this.s_factory_s=LLWebUtils.factory();
		this.record_flag_s="A";
		this.producting_dayplan_s=dailyPlanCode;
		this.parameter_code_s=(String) map.get("PARMCODE_S");
		this.parameter_name_s=(String) map.get("PARMNAME_S");
		this.parameter_value_s=(String) map.get("VALUE_S");
		this.parameter_logicaddress_s=(String) map.get("LOGICALADDRESS_S");
		
		
	}
	
public CuringProcessParameter(String factory,String dailyPlanCode,Map<String,Object> map,String material_code,int direction){
		
		this.agenc_no_s=LLConstant.JING_MEN_CODE;
		this.s_factory_s=LLWebUtils.factory();
		this.record_flag_s="A";
		this.producting_dayplan_s=dailyPlanCode;
		this.parameter_code_s=(String) map.get("PARAMETER_CODE_S");
		this.parameter_name_s=(String) map.get("PARAMETER_NAME_S");
		this.parameter_value_s=(String) map.get("PARAMETER_VALUE_S");
		this.parameter_logicaddress_s=(String) map.get("PARAMETER_LOGICADDRESS_S");
		this.formulapara_id_s=(String) map.get("FORMULAPARA_ID_S");
		this.test_flag_s=(String) map.get("TEST_FLAG_S");
		if(direction==1){
			//右物料编码
		this.spare1_s=material_code;}
		else{
			//左物料编码
		this.material_code_s=material_code;}
	}
	
	
	public CuringProcessParameter() {
	}
	private String producting_dayplan_s;
	private String parameter_logicaddress_s;
	private String parameter_code_s;
	private String parameter_name_s;
	private String parameter_value_s;
	private String s_factory_s;
	private String agenc_no_s;
	private String record_flag_s;
	private String formulapara_id_s ;
	private String spare1_s;
	private String material_code_s;
	
	public String getMaterial_code_s() {
		return material_code_s;
	}
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}
	public String getSpare1_s() {
		return spare1_s;
	}

	public void setSpare1_s(String spare1_s) {
		this.spare1_s = spare1_s;
	}

	public String getFormulapara_id_s() {
		return formulapara_id_s;
	}

	public void setFormulapara_id_s(String formulapara_id_s) {
		this.formulapara_id_s = formulapara_id_s;
	}
	private String test_flag_s;
	
	

	public String getTest_flag_s() {
		return test_flag_s;
	}

	public void setTest_flag_s(String test_flag_s) {
		this.test_flag_s = test_flag_s;
	}

	public String getProducting_dayplan_s() {
		return producting_dayplan_s;
	}
	public void setProducting_dayplan_s(String producting_dayplan_s) {
		this.producting_dayplan_s = producting_dayplan_s;
	}
	public String getParameter_logicaddress_s() {
		return parameter_logicaddress_s;
	}
	public void setParameter_logicaddress_s(String parameter_logicaddress_s) {
		this.parameter_logicaddress_s = parameter_logicaddress_s;
	}
	public String getParameter_code_s() {
		return parameter_code_s;
	}
	public void setParameter_code_s(String parameter_code_s) {
		this.parameter_code_s = parameter_code_s;
	}
	public String getParameter_name_s() {
		return parameter_name_s;
	}
	public void setParameter_name_s(String parameter_name_s) {
		this.parameter_name_s = parameter_name_s;
	}
	public String getParameter_value_s() {
		return parameter_value_s;
	}
	public void setParameter_value_s(String parameter_value_s) {
		this.parameter_value_s = parameter_value_s;
	}
	public String getS_factory_s() {
		return s_factory_s;
	}
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}
	public String getAgenc_no_s() {
		return agenc_no_s;
	}
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}
	public String getRecord_flag_s() {
		return record_flag_s;
	}
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}
}
