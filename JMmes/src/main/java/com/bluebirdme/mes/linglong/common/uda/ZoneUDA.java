/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.uda;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * STORAGE_ZONE
 * @author 李迺锟
 * @Date 2019-08-08 13:08:37
 */

public class ZoneUDA {
    
		/**
		* 企业（招远 8000；德州 8002  柳州 8003 泰国 8004） 
		*/
     	@Comment("企业（招远 8000；德州 8002  柳州 8003 泰国 8004）")
	    public static final String AGENCNO = "agencNo" ;
		/**
		* 库区条码 
		*/
     	@Comment("库区条码")
	    public static final String INVENTORY_BARCODE = "inventory_Barcode" ;
		/**
		* 库区名称英文 
		*/
     	@Comment("库区名称英文")
	    public static final String INVENTORY_NAME_EN = "inventory_Name_EN" ;
		/**
		* 是否允许包含子库区  
		*/
     	@Comment("是否允许包含子库区 ")
	    public static final String IS_ALLOW_CHILD_STOCK = "is_Allow_Child_Stock" ;
		/**
		* 库区物料组 
		*/
     	@Comment("库区物料组")
	    public static final String MATERIALGROUP = "materialGroup" ;
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
		* 父结构路径 
		*/
     	@Comment("父结构路径")
	    public static final String PARENT_FLAG = "parent_Flag" ;
		/**
		* 父库区 
		*/
     	@Comment("父库区")
	    public static final String PARENT_STOCK = "parent_Stock" ;
		/**
		* 所属工序 
		*/
     	@Comment("所属工序")
	    public static final String PROCESS = "process" ;
		/**
		* 备注 
		*/
     	@Comment("备注")
	    public static final String REMARKS = "remarks" ;
		/**
		* 工厂（1全钢 2半钢） 
		*/
     	@Comment("工厂（1全钢 2半钢）")
	    public static final String S_FACTORY = "s_factory" ;
		/**
		* 存放规格 
		*/
     	@Comment("存放规格")
	    public static final String STORAGE_SPECIFICATIONS = "storage_Specifications" ;
		/**
		* 库区类型 基础数据227 
		*/
     	@Comment("库区类型 基础数据227")
	    public static final String STORAGE_TYPE = "storage_Type" ;
		/**
		* 库区划分 
		*/
     	@Comment("库区划分")
	    public static final String STORAGE_ZONE_BARCODE = "storage_Zone_BarCode" ;
    
}
