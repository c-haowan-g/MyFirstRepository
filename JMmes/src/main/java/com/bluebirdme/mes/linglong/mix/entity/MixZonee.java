/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;
import java.util.Date;

/**
 * 库区库位管理
 * @author 李迺锟
 * @Date 2019-04-18 15:39:27
 */
public class MixZonee  {
	private String storage_zone_key;//id
	private String storage_zone_name;//库区流水条码
	private String category;//库区条码
	private String description;//库区描述
	private String storage_type_s;//库区类型
	private String inventory_barcode_s;//库区逻辑条码
	private String storage_specifications_s;//存放规格
	private String parent_stock_s;//父库区
	private String is_allow_child_stock_s;//是否允许包含子库区
	private String remarks_s;//备注
	private String inventory_name_en_s;//库区名称英文
	private String parent_flag_s;//父结构路径
	private String operater_s;//操作人
    private Date   operatetime_t;//操作时间
    private String storage_zone_barcode_s;//库区划分
    private String materialgroup_s; //库区物料组
    private String s_factory_s;
    
   
	public String getS_factory_s() {
		return s_factory_s;
	}
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}
	public String getStorage_zone_key() {
		return storage_zone_key;
	}
	public void setStorage_zone_key(String storage_zone_key) {
		this.storage_zone_key = storage_zone_key;
	}
    public String getMaterialgroup_s() {
		return materialgroup_s;
	}
	public void setMaterialgroup_s(String materialgroup_s) {
		this.materialgroup_s = materialgroup_s;
	}
	public String getStorage_zone_name() {
		return storage_zone_name;
	}
	public String getDescription() {
		return description;
	}
	public String getStorage_type_s() {
		return storage_type_s;
	}
	public String getInventory_barcode_s() {
		return inventory_barcode_s;
	}
	public String getStorage_specifications_s() {
		return storage_specifications_s;
	}
	public String getParent_stock_s() {
		return parent_stock_s;
	}
	public String getIs_allow_child_stock_s() {
		return is_allow_child_stock_s;
	}
	public String getRemarks_s() {
		return remarks_s;
	}
	public String getInventory_name_en_s() {
		return inventory_name_en_s;
	}
	public String getParent_flag_s() {
		return parent_flag_s;
	}
	public String getOperater_s() {
		return operater_s;
	}
	public Date getOperatetime_t() {
		return operatetime_t;
	}
	public String getStorage_zone_barcode_s() {
		return storage_zone_barcode_s;
	}
	public void setStorage_zone_name(String storage_zone_name) {
		this.storage_zone_name = storage_zone_name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setStorage_type_s(String storage_type_s) {
		this.storage_type_s = storage_type_s;
	}
	public void setInventory_barcode_s(String inventory_barcode_s) {
		this.inventory_barcode_s = inventory_barcode_s;
	}
	public void setStorage_specifications_s(String storage_specifications_s) {
		this.storage_specifications_s = storage_specifications_s;
	}
	public void setParent_stock_s(String parent_stock_s) {
		this.parent_stock_s = parent_stock_s;
	}
	public void setIs_allow_child_stock_s(String is_allow_child_stock_s) {
		this.is_allow_child_stock_s = is_allow_child_stock_s;
	}
	public void setRemarks_s(String remarks_s) {
		this.remarks_s = remarks_s;
	}
	public void setInventory_name_en_s(String inventory_name_en_s) {
		this.inventory_name_en_s = inventory_name_en_s;
	}
	public void setParent_flag_s(String parent_flag_s) {
		this.parent_flag_s = parent_flag_s;
	}
	public void setOperater_s(String operater_s) {
		this.operater_s = operater_s;
	}
	public void setOperatetime_t(Date operatetime_t) {
		this.operatetime_t = operatetime_t;
	}
	public void setStorage_zone_barcode_s(String storage_zone_barcode_s) {
		this.storage_zone_barcode_s = storage_zone_barcode_s;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
