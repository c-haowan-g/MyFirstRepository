/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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

/**
 * 成型机台信息管理
 * @author 刘程明
 * @Date 2019-01-11 15:02:27
 */
@Entity
public class SubEquipment extends BaseEntity {
	private String p_line_name;//产线名称
	private String wc_name;//对应工作中心得名称
	private String equip_name;//子设备名称
	private String description;//子设备描述
	private String scanstatuslast_s;
	private String barcodelast_s;
	private String specialselect_s;
	private String plasticnumber_i;
	private String askmaterialpercent_f;
	private String steelflag_s;
	private String outputgroup_s;
	private String tire_real_number_i;
	private String device_valid_s;
	private String rfidcode_s;
	private String currentmaterielamount_f;
	private String currentmaterielsurplusamount_f;
	private String consumption_f;
	private String beginweight_f;
	private String endweight_f;
	private String differentvalue_f;
	private String configclassmes_s;
	private String controlcode_s;
	private String s_factory_s;
	private String agencno_s;
	private String machinegroup_s;
	private String process_s;
	private String equip_type_s;
	private String productionline_code_s;
	private String ip_address_s;
	private String rfid_antenna_code_s;
	private String current_batch_code_s;
	private String current_barcode_s;
	private String current_material_code_s;
	private String last_barcode_s;
	private String last_material_code_s;
	private String last_batch_code_s;
	private String configstatus_s;
	private String configresult_s;
	private String configclass_s;
	private String remark_s;
	private String status_s;
	private String changeby_s;
	private String changetime_t;
	private String bom_material_code_s;
	private String half_confirm_s;
	private String line_amount_i;
	private String configclassname_s;
	private String current_material_spec_s;
	private String specialcontrol_s;
	private String tire_shelf_code_s;
	private String tire_material_code_s;
	private String barcode_s;
	private String scanstatus_s;
	private String rfidaddress_s;
	
	
	public String getRfidaddress_s() {
		return rfidaddress_s;
	}
	public void setRfidaddress_s(String rfidaddress_s) {
		this.rfidaddress_s = rfidaddress_s;
	}
	public String getP_line_name() {
		return p_line_name;
	}
	public void setP_line_name(String p_line_name) {
		this.p_line_name = p_line_name;
	}
	public String getWc_name() {
		return wc_name;
	}
	public void setWc_name(String wc_name) {
		this.wc_name = wc_name;
	}
	public String getEquip_name() {
		return equip_name;
	}
	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getScanstatuslast_s() {
		return scanstatuslast_s;
	}
	public void setScanstatuslast_s(String scanstatuslast_s) {
		this.scanstatuslast_s = scanstatuslast_s;
	}
	public String getBarcodelast_s() {
		return barcodelast_s;
	}
	public void setBarcodelast_s(String barcodelast_s) {
		this.barcodelast_s = barcodelast_s;
	}
	public String getSpecialselect_s() {
		return specialselect_s;
	}
	public void setSpecialselect_s(String specialselect_s) {
		this.specialselect_s = specialselect_s;
	}
	public String getPlasticnumber_i() {
		return plasticnumber_i;
	}
	public void setPlasticnumber_i(String plasticnumber_i) {
		this.plasticnumber_i = plasticnumber_i;
	}
	public String getAskmaterialpercent_f() {
		return askmaterialpercent_f;
	}
	public void setAskmaterialpercent_f(String askmaterialpercent_f) {
		this.askmaterialpercent_f = askmaterialpercent_f;
	}
	public String getSteelflag_s() {
		return steelflag_s;
	}
	public void setSteelflag_s(String steelflag_s) {
		this.steelflag_s = steelflag_s;
	}
	public String getOutputgroup_s() {
		return outputgroup_s;
	}
	public void setOutputgroup_s(String outputgroup_s) {
		this.outputgroup_s = outputgroup_s;
	}
	public String getTire_real_number_i() {
		return tire_real_number_i;
	}
	public void setTire_real_number_i(String tire_real_number_i) {
		this.tire_real_number_i = tire_real_number_i;
	}
	public String getDevice_valid_s() {
		return device_valid_s;
	}
	public void setDevice_valid_s(String device_valid_s) {
		this.device_valid_s = device_valid_s;
	}
	public String getRfidcode_s() {
		return rfidcode_s;
	}
	public void setRfidcode_s(String rfidcode_s) {
		this.rfidcode_s = rfidcode_s;
	}
	public String getCurrentmaterielamount_f() {
		return currentmaterielamount_f;
	}
	public void setCurrentmaterielamount_f(String currentmaterielamount_f) {
		this.currentmaterielamount_f = currentmaterielamount_f;
	}
	public String getCurrentmaterielsurplusamount_f() {
		return currentmaterielsurplusamount_f;
	}
	public void setCurrentmaterielsurplusamount_f(
			String currentmaterielsurplusamount_f) {
		this.currentmaterielsurplusamount_f = currentmaterielsurplusamount_f;
	}
	public String getConsumption_f() {
		return consumption_f;
	}
	public void setConsumption_f(String consumption_f) {
		this.consumption_f = consumption_f;
	}
	public String getBeginweight_f() {
		return beginweight_f;
	}
	public void setBeginweight_f(String beginweight_f) {
		this.beginweight_f = beginweight_f;
	}
	public String getEndweight_f() {
		return endweight_f;
	}
	public void setEndweight_f(String endweight_f) {
		this.endweight_f = endweight_f;
	}
	public String getDifferentvalue_f() {
		return differentvalue_f;
	}
	public void setDifferentvalue_f(String differentvalue_f) {
		this.differentvalue_f = differentvalue_f;
	}
	public String getConfigclassmes_s() {
		return configclassmes_s;
	}
	public void setConfigclassmes_s(String configclassmes_s) {
		this.configclassmes_s = configclassmes_s;
	}
	public String getControlcode_s() {
		return controlcode_s;
	}
	public void setControlcode_s(String controlcode_s) {
		this.controlcode_s = controlcode_s;
	}
	public String getS_factory_s() {
		return s_factory_s;
	}
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}
	public String getAgencno_s() {
		return agencno_s;
	}
	public void setAgencno_s(String agencno_s) {
		this.agencno_s = agencno_s;
	}
	public String getMachinegroup_s() {
		return machinegroup_s;
	}
	public void setMachinegroup_s(String machinegroup_s) {
		this.machinegroup_s = machinegroup_s;
	}
	public String getProcess_s() {
		return process_s;
	}
	public void setProcess_s(String process_s) {
		this.process_s = process_s;
	}
	public String getEquip_type_s() {
		return equip_type_s;
	}
	public void setEquip_type_s(String equip_type_s) {
		this.equip_type_s = equip_type_s;
	}
	public String getProductionline_code_s() {
		return productionline_code_s;
	}
	public void setProductionline_code_s(String productionline_code_s) {
		this.productionline_code_s = productionline_code_s;
	}
	public String getIp_address_s() {
		return ip_address_s;
	}
	public void setIp_address_s(String ip_address_s) {
		this.ip_address_s = ip_address_s;
	}
	public String getRfid_antenna_code_s() {
		return rfid_antenna_code_s;
	}
	public void setRfid_antenna_code_s(String rfid_antenna_code_s) {
		this.rfid_antenna_code_s = rfid_antenna_code_s;
	}
	public String getCurrent_batch_code_s() {
		return current_batch_code_s;
	}
	public void setCurrent_batch_code_s(String current_batch_code_s) {
		this.current_batch_code_s = current_batch_code_s;
	}
	public String getCurrent_barcode_s() {
		return current_barcode_s;
	}
	public void setCurrent_barcode_s(String current_barcode_s) {
		this.current_barcode_s = current_barcode_s;
	}
	public String getCurrent_material_code_s() {
		return current_material_code_s;
	}
	public void setCurrent_material_code_s(String current_material_code_s) {
		this.current_material_code_s = current_material_code_s;
	}
	public String getLast_barcode_s() {
		return last_barcode_s;
	}
	public void setLast_barcode_s(String last_barcode_s) {
		this.last_barcode_s = last_barcode_s;
	}
	public String getLast_material_code_s() {
		return last_material_code_s;
	}
	public void setLast_material_code_s(String last_material_code_s) {
		this.last_material_code_s = last_material_code_s;
	}
	public String getLast_batch_code_s() {
		return last_batch_code_s;
	}
	public void setLast_batch_code_s(String last_batch_code_s) {
		this.last_batch_code_s = last_batch_code_s;
	}
	public String getConfigstatus_s() {
		return configstatus_s;
	}
	public void setConfigstatus_s(String configstatus_s) {
		this.configstatus_s = configstatus_s;
	}
	public String getConfigresult_s() {
		return configresult_s;
	}
	public void setConfigresult_s(String configresult_s) {
		this.configresult_s = configresult_s;
	}
	public String getConfigclass_s() {
		return configclass_s;
	}
	public void setConfigclass_s(String configclass_s) {
		this.configclass_s = configclass_s;
	}
	public String getRemark_s() {
		return remark_s;
	}
	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}
	public String getStatus_s() {
		return status_s;
	}
	public void setStatus_s(String status_s) {
		this.status_s = status_s;
	}
	public String getChangeby_s() {
		return changeby_s;
	}
	public void setChangeby_s(String changeby_s) {
		this.changeby_s = changeby_s;
	}
	public String getChangetime_t() {
		return changetime_t;
	}
	public void setChangetime_t(String changetime_t) {
		this.changetime_t = changetime_t;
	}
	public String getBom_material_code_s() {
		return bom_material_code_s;
	}
	public void setBom_material_code_s(String bom_material_code_s) {
		this.bom_material_code_s = bom_material_code_s;
	}
	public String getHalf_confirm_s() {
		return half_confirm_s;
	}
	public void setHalf_confirm_s(String half_confirm_s) {
		this.half_confirm_s = half_confirm_s;
	}
	public String getLine_amount_i() {
		return line_amount_i;
	}
	public void setLine_amount_i(String line_amount_i) {
		this.line_amount_i = line_amount_i;
	}
	public String getConfigclassname_s() {
		return configclassname_s;
	}
	public void setConfigclassname_s(String configclassname_s) {
		this.configclassname_s = configclassname_s;
	}
	public String getCurrent_material_spec_s() {
		return current_material_spec_s;
	}
	public void setCurrent_material_spec_s(String current_material_spec_s) {
		this.current_material_spec_s = current_material_spec_s;
	}
	public String getSpecialcontrol_s() {
		return specialcontrol_s;
	}
	public void setSpecialcontrol_s(String specialcontrol_s) {
		this.specialcontrol_s = specialcontrol_s;
	}
	public String getTire_shelf_code_s() {
		return tire_shelf_code_s;
	}
	public void setTire_shelf_code_s(String tire_shelf_code_s) {
		this.tire_shelf_code_s = tire_shelf_code_s;
	}
	public String getTire_material_code_s() {
		return tire_material_code_s;
	}
	public void setTire_material_code_s(String tire_material_code_s) {
		this.tire_material_code_s = tire_material_code_s;
	}
	public String getBarcode_s() {
		return barcode_s;
	}
	public void setBarcode_s(String barcode_s) {
		this.barcode_s = barcode_s;
	}
	public String getScanstatus_s() {
		return scanstatus_s;
	}
	public void setScanstatus_s(String scanstatus_s) {
		this.scanstatus_s = scanstatus_s;
	}
	
}
