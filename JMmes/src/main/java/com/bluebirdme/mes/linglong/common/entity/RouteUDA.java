/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * Route
 * @author 葛迎祥
 * @Date 2020-05-07 13:47:54
 */

public class RouteUDA {
    
		/**
		* 创建时间 
		*/
     	@Comment("创建时间")
	    public static final String CREATEDATE = "CreateDate" ;
		/**
		* 创建人 
		*/
     	@Comment("创建人")
	    public static final String CREATEUSER = "CreateUser" ;
		/**
		* 设备类型代码 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 
		*/
     	@Comment("设备类型代码 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机")
	    public static final String EQUIPMENTCODE = "EquipmentCode" ;
		/**
		* 设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机 
		*/
     	@Comment("设备类型名称： 10-挤出联动线 11-钢丝圈成型机 12-胎圈贴合机 16-钢丝帘布压延机 17-多刀裁断机 20-尼龙帘布一次裁断 21-尼龙帘布二次裁断 22-全钢一次法成型机 23-半钢VMI一次法成型机 25-半钢二次法成型机")
	    public static final String EQUIPMENTTYPECODE = "EquipmentTypeCode" ;
		/**
		* 失效时间 
		*/
     	@Comment("失效时间")
	    public static final String EXPIREDATE = "ExpireDate" ;
		/**
		* 分厂  外胎BOM【半钢 G1 全钢 G2】、 胎胚BOM【胎胚一次法 G1 胎胚二次法 G3 全钢 G2】 
		*/
     	@Comment("分厂  外胎BOM【半钢 G1 全钢 G2】、 胎胚BOM【胎胚一次法 G1 胎胚二次法 G3 全钢 G2】")
	    public static final String FACTORY = "Factory" ;
		/**
		* 修改人 
		*/
     	@Comment("修改人")
	    public static final String MODIFIER = "Modifier" ;
		/**
		* 胎胚施工代码 
		*/
     	@Comment("胎胚施工代码")
	    public static final String PDMMAT = "Pdmmat" ;
		/**
		* 工艺版本号 
		*/
     	@Comment("工艺版本号")
	    public static final String PROCESSVERSION = "ProcessVersion" ;
		/**
		* 接收时间 
		*/
     	@Comment("接收时间")
	    public static final String RECEIVE_TIME = "Receive_Time" ;
		/**
		* 记录标志，A可用，D删除 
		*/
     	@Comment("记录标志，A可用，D删除")
	    public static final String RECORD_FLAG = "Record_Flag" ;
		/**
		* 工艺路线名称 
		*/
     	@Comment("工艺路线名称")
	    public static final String ROUTECODE = "RouteCode" ;
		/**
		* SAP品号-储胎9位品号 
		*/
     	@Comment("SAP品号-储胎9位品号")
	    public static final String SAPMAT = "Sapmat" ;
		/**
		* SAP品号  
		*/
     	@Comment("SAP品号 ")
	    public static final String SAPMAT_TEMP = "Sapmat_Temp" ;
		/**
		* 产品阶段 试制 01 试产 02 投产03 
		*/
     	@Comment("产品阶段 试制 01 试产 02 投产03")
	    public static final String STAGE = "Stage" ;
		/**
		* 胎胚版本号 
		*/
     	@Comment("胎胚版本号")
	    public static final String VERSION = "Version" ;
		/**
		* 工厂 柳州 8003 
		*/
     	@Comment("工厂 柳州 8003")
	    public static final String WERKS = "Werks" ;
    
}
