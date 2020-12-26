/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core;

/**
 * rockwell的UDA字段
 * @author 兰颖慧
 *
 */
public interface RockWellUDA  {
	
	/**
	 * 产线UDA
	 * @author 兰颖慧
	 *
	 */
	public final static class ProductlineUDA{
		//成型用

		public final static String PROCESS="process";
		public final static String REMARKS="remarks";
		public final static String MODEL="model";
		public final static String SPECIFICATION="specification";
		public final static String FACTORY="factory";
		public final static String MANUFACTURINGTIME="manufacturingTime";
		public final static String SHAPE="shape";
		public final static String WEIGHT="weight";
		public final static String SERVICELIFE="serviceLife";
		public final static String ACTIVETIME="activeTime";
		public final static String DEPARTMENT="department";
		public final static String RESPONSIBLE="responsible";
		public final static String MACHINEGROUP="machineGroup";
		public final static String MACHINETYPE="machineType";
		public final static String MEMO="memo";
		public final static String CREATEBY="createby";
		public final static String CREATETIME="createTime";
		public final static String CHANGEBY="changeby";
		public final static String CHANGETIME="changeTime";
		public final static String PROCESS_INDEX="process_Index";
		public final static String PRODUCTTYPE="productType";
		public final static String S_FACTORY="s_factory";
		public final static String AGENCNO="agencNo";
		public final static String ISPLATE="isPlate";
		public final static String EQUIPCODE="equipCode";
		public final static String MATCHING="matching";
		public final static String STATUS="status";
		public final static String PRODUCTLINESTATUS="productLineStatus";
		public final static String LINE_MAXVALUE="line_MaxValue";
//		public final static String CATEGORY="category";

	}
	
	public final static class EquipMentUDA{
		public final static String EQUIP_TYPE="equip_Type";
		public final static String PRODUCTIONLINE_CODE="productionline_Code";
		public final static String IP_ADDRESS="ip_Address";
		public final static String RFID_ANTENNA_CODE="rfid_Antenna_Code";
		public final static String CURRENT_BATCH_CODE="current_Batch_Code";
		public final static String CURRENT_BARCODE="current_Barcode";
		public final static String CURRENT_MATERIAL_CODE="current_Material_Code";
		public final static String LAST_BARCODE="last_Barcode";
		public final static String LAST_MATERIAL_CODE="last_Material_Code";
		public final static String LAST_BATCH_CODE="last_Batch_Code";
		public final static String CONFIGSTATUS="configStatus";
		public final static String CONFIGRESULT="configResult";
		public final static String CONFIGCLASS="configClass";
		public final static String REMARK="remark";
		public final static String STATUS="status";
		public final static String CHANGEBY="changeBy";
		public final static String CHANGETIME="changeTime";
		public final static String BOM_MATERIAL_CODE="bom_Material_Code";
		public final static String HALF_CONFIRM="half_Confirm";
		public final static String LINE_AMOUNT="line_Amount";
		public final static String CONFIGCLASSNAME="configClassName";
		public final static String CURRENT_MATERIAL_SPEC="current_Material_Spec";
		public final static String SPECIALCONTROL="specialControl";
		public final static String TIRE_SHELF_CODE="tire_Shelf_Code";
		public final static String TIRE_MATERIAL_CODE="tire_Material_Code";
		public final static String BARCODE="barcode";
		public final static String SCANSTATUS="scanStatus";
		public final static String TIRE_FULL_NUMBER="tire_Full_Number";
		public final static String TIRE_REAL_NUMBER="tire_Real_Number";
		public final static String DEVICE_VALID="device_Valid";
		public final static String RFIDCODE="rfidCode";
		public final static String CURRENTMATERIELAMOUNT="currentMaterielAmount";
		public final static String CURRENTMATERIELSURPLUSAMOUNT="currentMaterielSurplusAmount";
		public final static String CONSUMPTION="consumption";
		public final static String BEGINWEIGHT="beginWeight";
		public final static String ENDWEIGHT="endWeight";
		public final static String DIFFERENTVALUE="differentValue";
		public final static String CONFIGCLASSMES="configClassMES";
		public final static String CONTROLCODE="controlCode";
		public final static String S_FACTORY="s_factory";
		public final static String AGENCNO="agencNo";
		public final static String MACHINEGROUP="machineGroup";
		public final static String PROCESS="process";
		public final static String OUTPUTGROUP="outputGroup";
		public final static String PLASTICNUMBER="plasticNumber";
		public final static String RFIDADDRESS="rfidAddress";
		public final static String INTOUTADDRESS="intoutAddress";
		public final static String SPECIALSELECT="specialSelect";
		
	}
	
    public final static class StorageZoneUDA{
    	public final static String STORAGE_TYPE="storage_Type";
    	public final static String INVENTORY_BARCODE="inventory_Barcode";
    	public final static String STORAGE_SPECIFICATIONS="storage_Specifications";
    	public final static String PARENT_STOCK="parent_Stock";
    	public final static String IS_ALLOW_CHILD_STOCK="is_Allow_Child_Stock";
    	public final static String REMARKS="remarks";
    	public final static String INVENTORY_NAME_EN="inventory_Name_EN";
    	public final static String PARENT_FLAG="parent_Flag";
    	public final static String OPERATER="operater";
    	public final static String OPERATETIME="operateTime";
    	public final static String STORAGE_ZONE_BARCODE="storage_Zone_BarCode";
    	public final static String S_FACTORY="s_factory";
    	public final static String AGENCNO="agencNo";
    	public final static String PROCESS="process";
    	public final static String MATERIALGROUP="materialGroup";
    	
	}
    
    public final static class StorageUnitUDA{
    	public final static String STORAGE_ZONE_BARCODE="storage_Zone_Barcode";
    	public final static String BOITANLAND="boiTanland";
    	public final static String ERPCODE="erpCode";
    	public final static String INVENTORY_MATERIALCODE="inventory_Materialcode";
    	public final static String INVENTORY_MATERIALNAME="inventory_Materialname";
    	public final static String STOCKSTATUS="stockStatus";
    	public final static String LASTINTIME="lastInTime";
    	public final static String LOCKFLAG="lockFlag";
    	public final static String LOCKOUTFLAG="lockOutFlag";
    	public final static String OPERATER="operater";
    	public final static String OPERATETIME="operateTime";
    	public final static String S_FACTORY="s_factory";
    	public final static String ANENCNO="anencNo";
    	public final static String PROCESS="process";
    	public final static String CURRENT_QUANTITY="current_Quantity";
    	public final static String LOCKINFLAG="lockInFlag";
    	public final static String CURRENT_STORAGE="current_Storage";
    	public final static String CANUSE="canUse";
    	public final static String SAPM_GROUP="sapm_Group";
    	public final static String MACHINECODE="machineCode";
    	
	}
	public final static class UDAType{
		public final static String PRODUCTIONLINE="ProductionLine";
		public final static String SITE="Site";
		public final static String EQUIPMENT="Equipment";
		public final static String STORAGEZONE="StorageZone";
		public final static String STORAGEUNIT="StorageUnit";
	}
}
