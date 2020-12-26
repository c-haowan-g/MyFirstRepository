/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.uda;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * 硫化机台信息管 理
 * @author 司乔靖
 * @Date 2019-07-13 09:55:26
 */

public class ProductionLineUDA {
    
		/**
		* 启用时间 
		*/
     	@Comment("启用时间")
	    public static final String ACTIVETIME = "activeTime" ;
		/**
		* 企业（招远 8000；德州 8002  柳州 8003 泰国 8004） 
		*/
     	@Comment("企业（招远 8000；德州 8002  柳州 8003 泰国 8004）")
	    public static final String AGENCNO = "agencNo" ;
		/**
		* 修改时间 
		*/
     	@Comment("修改时间")
	    public static final String CHANGETIME = "changeTime" ;
		/**
		* 修改人 
		*/
     	@Comment("修改人")
	    public static final String CHANGEBY = "changeby" ;
		/**
		* 创建时间 
		*/
     	@Comment("创建时间")
	    public static final String CREATETIME = "createTime" ;
		/**
		* 创建人 
		*/
     	@Comment("创建人")
	    public static final String CREATEBY = "createby" ;
		/**
		* 所属部门 
		*/
     	@Comment("所属部门")
	    public static final String DEPARTMENT = "department" ;
		/**
		* 设备代码（半部件设备） 
		*/
     	@Comment("设备代码（半部件设备）")
	    public static final String EQUIPCODE = "equipCode" ;
		/**
		* 厂商 
		*/
     	@Comment("厂商")
	    public static final String FACTORY = "factory" ;
		/**
		* 是否有口型板 
		*/
     	@Comment("是否有口型板")
	    public static final String ISPLATE = "isPlate" ;
		/**
		* 机台组 全钢（基础数据167） 半钢（基础数据171） 
		*/
     	@Comment("机台组 全钢（基础数据167） 半钢（基础数据171）")
	    public static final String MACHINEGROUP = "machineGroup" ;
		/**
		* 机台类型 
		*/
     	@Comment("机台类型")
	    public static final String MACHINETYPE = "machineType" ;
		/**
		* 制造年月 
		*/
     	@Comment("制造年月")
	    public static final String MANUFACTURINGTIME = "manufacturingTime" ;
		/**
		* 配套厂家 
		*/
     	@Comment("配套厂家")
	    public static final String MATCHING = "matching" ;
		/**
		* 备注 
		*/
     	@Comment("备注")
	    public static final String MEMO = "memo" ;
		/**
		* 型号 
		*/
     	@Comment("型号")
	    public static final String MODEL = "model" ;
		/**
		* 所属工序:252005 
		*/
     	@Comment("所属工序:252005")
	    public static final String PROCESS = "process" ;
		/**
		* 工艺配方索引号(系统生成) 
		*/
     	@Comment("工艺配方索引号(系统生成)")
	    public static final String PROCESS_INDEX = "process_Index" ;
		/**
		* 产线状态 
		*/
     	@Comment("产线状态")
	    public static final String PRODUCTLINESTATUS = "productLineStatus" ;
		/**
		* 生产模式 
		*/
     	@Comment("生产模式")
	    public static final String PRODUCTTYPE = "productType" ;
		/**
		* 额定能力 
		*/
     	@Comment("额定能力")
	    public static final String REMARKS = "remarks" ;
		/**
		* 责任人 
		*/
     	@Comment("责任人")
	    public static final String RESPONSIBLE = "responsible" ;
		/**
		* 工厂（1全钢 2半钢） 
		*/
     	@Comment("工厂（1全钢 2半钢）")
	    public static final String S_FACTORY = "s_factory" ;
		/**
		* 使用年限 
		*/
     	@Comment("使用年限")
	    public static final String SERVICELIFE = "serviceLife" ;
		/**
		* 外形尺寸 
		*/
     	@Comment("外形尺寸")
	    public static final String SHAPE = "shape" ;
		/**
		* 规格 
		*/
     	@Comment("规格")
	    public static final String SPECIFICATION = "specification" ;
		/**
		* 机台状态 
		*/
     	@Comment("机台状态")
	    public static final String STATUS = "status" ;
		/**
		* 重量 
		*/
     	@Comment("重量")
	    public static final String WEIGHT = "weight" ;
     	/**
     	 * 机台IP
     	 */
     	@Comment("重量")
     	public static final String IP_S = "IP" ;
    
}
