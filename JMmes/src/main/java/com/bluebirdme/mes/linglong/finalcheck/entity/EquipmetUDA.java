/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * 设备表
 * 
 * @author 刘朋
 * @Date 2019-09-03 11:40:29
 */

public class EquipmetUDA {

	/**
	 * 企业（招远 8000；德州 8002 柳州 8003 泰国 8004）
	 */
	@Comment("企业（招远 8000；德州 8002  柳州 8003 泰国 8004）")
	public static final String AGENCNO = "agencNo";
	/**
	 * 投料口要料百分比
	 */
	@Comment("投料口要料百分比")
	public static final String ASKMATERIALPERCENT = "askMaterialPercent";
	/**
	 * 胎筒产出条码
	 */
	@Comment("胎筒产出条码")
	public static final String BARCODE = "barcode";
	/**
	 * 胎筒产出条码（上一个）
	 */
	@Comment("胎筒产出条码（上一个）")
	public static final String BARCODELAST = "barcodeLast";
	/**
	 * 正向投料称重起始重量
	 */
	@Comment("正向投料称重起始重量")
	public static final String BEGINWEIGHT = "beginWeight";
	/**
	 * BOM物料
	 */
	@Comment("BOM物料")
	public static final String BOM_MATERIAL_CODE = "bom_Material_Code";
	/**
	 * 操作人
	 */
	@Comment("操作人")
	public static final String CHANGEBY = "changeBy";
	/**
	 * 操作时间
	 */
	@Comment("操作时间")
	public static final String CHANGETIME = "changeTime";
	/**
	 * 物料大类
	 */
	@Comment("物料大类")
	public static final String CONFIGCLASS = "configClass";
	/**
	 * MES物料组
	 */
	@Comment("MES物料组")
	public static final String CONFIGCLASSMES = "configClassMES";
	/**
	 * 物料大类名称
	 */
	@Comment("物料大类名称")
	public static final String CONFIGCLASSNAME = "configClassName";
	/**
	 * 投料校验结果
	 */
	@Comment("投料校验结果")
	public static final String CONFIGRESULT = "configResult";
	/**
	 * 是否启用校验
	 */
	@Comment("是否启用校验")
	public static final String CONFIGSTATUS = "configStatus";
	/**
	 * 当前物料额定消耗（BOM物料用量）
	 */
	@Comment("当前物料额定消耗（BOM物料用量）")
	public static final String CONSUMPTION = "consumption";
	/**
	 * 余料控制编码
	 */
	@Comment("余料控制编码")
	public static final String CONTROLCODE = "controlCode";
	/**
	 * 当前投料物料总数量
	 */
	@Comment("当前投料物料总数量")
	public static final String CURRENTMATERIELAMOUNT = "currentMaterielAmount";
	/**
	 * 当前投料物料剩余数量
	 */
	@Comment("当前投料物料剩余数量")
	public static final String CURRENTMATERIELSURPLUSAMOUNT = "currentMaterielSurplusAmount";
	/**
	 * 当前物料条码（RFID条码）
	 */
	@Comment("当前物料条码（RFID条码）")
	public static final String CURRENT_BARCODE = "current_Barcode";
	/**
	 * 当前物料批次条码
	 */
	@Comment("当前物料批次条码")
	public static final String CURRENT_BATCH_CODE = "current_Batch_Code";
	/**
	 * 当前物料编码
	 */
	@Comment("当前物料编码")
	public static final String CURRENT_MATERIAL_CODE = "current_Material_Code";
	/**
	 * 当前物料规格
	 */
	@Comment("当前物料规格")
	public static final String CURRENT_MATERIAL_SPEC = "current_Material_Spec";
	/**
	 * 子设备是否启用
	 */
	@Comment("子设备是否启用")
	public static final String DEVICE_VALID = "device_Valid";
	/**
	 * 更换载具差值
	 */
	@Comment("更换载具差值")
	public static final String DIFFERENTVALUE = "differentValue";
	/**
	 * 正向投料称重结束重量
	 */
	@Comment("正向投料称重结束重量")
	public static final String ENDWEIGHT = "endWeight";
	/**
	 * 子设备类型（基础数据161）
	 */
	@Comment("子设备类型（基础数据161） ")
	public static final String EQUIP_TYPE = "equip_Type";
	/**
	 * 半卷料确认
	 */
	@Comment("半卷料确认")
	public static final String HALF_CONFIRM = "half_Confirm";
	/**
	 * 工装移入移出逻辑地址
	 */
	@Comment("工装移入移出逻辑地址")
	public static final String INTOUTADDRESS = "intoutAddress";
	/**
	 * 设备IP
	 */
	@Comment("设备IP")
	public static final String IP_ADDRESS = "ip_Address";
	/**
	 * 上一个工装条码
	 */
	@Comment("上一个工装条码")
	public static final String LAST_BARCODE = "last_Barcode";
	/**
	 * 上一个物料批次条码
	 */
	@Comment("上一个物料批次条码")
	public static final String LAST_BATCH_CODE = "last_Batch_Code";
	/**
	 * 上一个物料编码
	 */
	@Comment("上一个物料编码")
	public static final String LAST_MATERIAL_CODE = "last_Material_Code";
	/**
	 * 物料线边数量
	 */
	@Comment("物料线边数量")
	public static final String LINE_AMOUNT = "line_Amount";
	/**
	 * 机台组 数据字典320
	 */
	@Comment("机台组 数据字典320")
	public static final String MACHINEGROUP = "machineGroup";
	/**
	 * 产出口分组(A-B)
	 */
	@Comment("产出口分组(A-B)")
	public static final String OUTPUTGROUP = "outputGroup";
	/**
	 * 投入胶案数量
	 */
	@Comment("投入胶案数量")
	public static final String PLASTICNUMBER = "plasticNumber";
	/**
	 * 所属工序：252005
	 */
	@Comment("所属工序：252005")
	public static final String PROCESS = "process";
	/**
	 * 产线编码(父设备)
	 */
	@Comment("产线编码(父设备)")
	public static final String PRODUCTIONLINE_CODE = "productionline_Code";
	/**
	 * 备注
	 */
	@Comment("备注")
	public static final String REMARK = "remark";
	/**
	 * RFID逻辑地址
	 */
	@Comment("RFID逻辑地址")
	public static final String RFIDADDRESS = "rfidAddress";
	/**
	 * 半卷料载具条码
	 */
	@Comment("半卷料载具条码")
	public static final String RFIDCODE = "rfidCode";
	/**
	 * RFID设备天线编码
	 */
	@Comment("RFID设备天线编码")
	public static final String RFID_ANTENNA_CODE = "rfid_Antenna_Code";
	/**
	 * 工厂（1全钢 2半钢）
	 */
	@Comment("工厂（1全钢 2半钢）")
	public static final String S_FACTORY = "s_factory";
	/**
	 * 胎筒扫描状态（01-已扫描，02-已产出）
	 */
	@Comment("胎筒扫描状态（01-已扫描，02-已产出）")
	public static final String SCANSTATUS = "scanStatus";
	/**
	 * 胎筒扫描状态（数据字典357）（上一个）
	 */
	@Comment("胎筒扫描状态（数据字典357）（上一个）")
	public static final String SCANSTATUSLAST = "scanStatusLast";
	/**
	 * 特殊要求
	 */
	@Comment("特殊要求")
	public static final String SPECIALCONTROL = "specialControl";
	/**
	 * 特殊选择
	 */
	@Comment("特殊选择")
	public static final String SPECIALSELECT = "specialSelect";
	/**
	 * 设备状态 0不正常1正常
	 */
	@Comment("设备状态 0不正常1正常")
	public static final String STATUS = "status";
	/**
	 * 钢丝投料切换信号 A B
	 */
	@Comment("钢丝投料切换信号 A B")
	public static final String STEELFLAG = "steelFlag";
	/**
	 * 胎胚车额定数量
	 */
	@Comment("胎胚车额定数量")
	public static final String TIRE_FULL_NUMBER = "tire_Full_Number";
	/**
	 * 胎胚车物料编码
	 */
	@Comment("胎胚车物料编码")
	public static final String TIRE_MATERIAL_CODE = "tire_Material_Code";
	/**
	 * 胎胚车实际数量
	 */
	@Comment("胎胚车实际数量")
	public static final String TIRE_REAL_NUMBER = "tire_Real_Number";
	/**
	 * 胎胚车编码
	 */
	@Comment("胎胚车编码")
	public static final String TIRE_SHELF_CODE = "tire_Shelf_Code";

}
