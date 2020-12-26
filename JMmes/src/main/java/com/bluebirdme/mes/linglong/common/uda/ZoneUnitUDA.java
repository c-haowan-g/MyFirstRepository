/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.uda;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * UDAZoneUnit
 * @author 李迺锟
 * @Date 2019-08-08 13:09:15
 */

public class ZoneUnitUDA {
    
		/**
		* 企业（招远 8000；德州 8002  柳州 8003 泰国 8004） 
		*/
     	@Comment("企业（招远 8000；德州 8002  柳州 8003 泰国 8004）")
	    public static final String AGENCNO = "agencNo" ;
		/**
		* BOI 
		*/
     	@Comment("BOI")
	    public static final String BOITANLAND = "boiTanland" ;
		/**
		* 有效标识 是否启用这个库位 0-启用  1-停用 
		*/
     	@Comment("有效标识 是否启用这个库位 0-启用  1-停用")
	    public static final String CANUSE = "canUse" ;
		/**
		* 当前库存数量 
		*/
     	@Comment("当前库存数量")
	    public static final String CURRENT_QUANTITY = "current_Quantity" ;
		/**
		* 半部件当前库存数量 
		*/
     	@Comment("半部件当前库存数量")
	    public static final String CURRENT_STORAGE = "current_Storage" ;
		/**
		* ERP编码 
		*/
     	@Comment("ERP编码")
	    public static final String ERPCODE = "erpCode" ;
		/**
		* 存放物料编码 
		*/
     	@Comment("存放物料编码")
	    public static final String INVENTORY_MATERIALCODE = "inventory_Materialcode" ;
		/**
		* 存放物料名称 
		*/
     	@Comment("存放物料名称")
	    public static final String INVENTORY_MATERIALNAME = "inventory_Materialname" ;
		/**
		* 最后入库时间（库位推荐有关） 
		*/
     	@Comment("最后入库时间（库位推荐有关）")
	    public static final String LASTINTIME = "lastInTime" ;
		/**
		* 入库锁定标记：0-未锁定（正常），1-锁定（已占用） 
		*/
     	@Comment("入库锁定标记：0-未锁定（正常），1-锁定（已占用）")
	    public static final String LOCKFLAG = "lockFlag" ;
		/**
		* 半部件入库锁定标记 不允许入 0-未锁定（正常），1-锁定（禁用）) 
		*/
     	@Comment("半部件入库锁定标记 不允许入 0-未锁定（正常），1-锁定（禁用）)")
	    public static final String LOCKINFLAG = "lockInFlag" ;
		/**
		* 发货锁定标记 
		*/
     	@Comment("发货锁定标记")
	    public static final String LOCKOUTFLAG = "lockOutFlag" ;
		/**
		* 机台条码 
		*/
     	@Comment("机台条码")
	    public static final String MACHINECODE = "machineCode" ;
		/**
		* 操作时间 
		*/
     	@Comment("操作时间")
	    public static final String OPERATETIME = "operateTime" ;
		/**
		* 操作人 
		*/
     	@Comment("操作人")
	    public static final String OPERATER = "operater" ;
		/**
		* 所属工序 
		*/
     	@Comment("所属工序")
	    public static final String PROCESS = "process" ;
		/**
		* 工厂（1全钢 2半钢） 
		*/
     	@Comment("工厂（1全钢 2半钢）")
	    public static final String S_FACTORY = "s_factory" ;
		/**
		* SAP物料组（基础数据308外部系统301开头的） 
		*/
     	@Comment("SAP物料组（基础数据308外部系统301开头的）")
	    public static final String SAPM_GROUP = "sapm_Group" ;
		/**
		* 存放物料质量状态 
		*/
     	@Comment("存放物料质量状态")
	    public static final String STOCKSTATUS = "stockStatus" ;
		/**
		* 库区划分编码 
		*/
     	@Comment("库区划分编码")
	    public static final String STORAGE_ZONE_BARCODE = "storage_Zone_Barcode" ;
    
}
