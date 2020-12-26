/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.sap.uda;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * 基础物料
 * @author 周清玉
 * @Date 2019-06-21 11:14:46
 */

public class PartUDA {
    
		/**
		* 基本计量单位 
		*/
     	@Comment("基本计量单位")
	    public static final String BASEUNIT = "BaseUnit" ;
		/**
		* 品牌 
		*/
     	@Comment("品牌")
	    public static final String BRAND = "Brand" ;
		/**
		* 创建日期 
		*/
     	@Comment("创建日期")
	    public static final String CD = "CD" ;
		/**
		* 层级 
		*/
     	@Comment("层级")
	    public static final String CJ = "CJ" ;
		/**
		* 创建时间 
		*/
     	@Comment("创建时间")
	    public static final String CTIME = "CTIME" ;
		/**
		* 公司号 
		*/
     	@Comment("公司号")
	    public static final String COMPANYCODE = "CompanyCode" ;
		/**
		* 产品组 
		*/
     	@Comment("产品组")
	    public static final String DIVISION = "Division" ;
		/**
		* 预留1 
		*/
     	@Comment("预留1")
	    public static final String DUMMY1 = "Dummy1" ;
		/**
		* 预留2 
		*/
     	@Comment("预留2")
	    public static final String DUMMY2 = "Dummy2" ;
		/**
		* 预留3 
		*/
     	@Comment("预留3")
	    public static final String DUMMY3 = "Dummy3" ;
		/**
		* 预留4 
		*/
     	@Comment("预留4")
	    public static final String DUMMY4 = "Dummy4" ;
		/**
		* 寸口描述 
		*/
     	@Comment("寸口描述")
	    public static final String EWBEZ = "EWBEZ" ;
		/**
		* 寸口 
		*/
     	@Comment("寸口")
	    public static final String EXTWG = "EXTWG" ;
		/**
		* 发货单位 
		*/
     	@Comment("发货单位")
	    public static final String GISSUEUNIT = "GIssueUnit" ;
		/**
		* 货号 
		*/
     	@Comment("货号")
	    public static final String HH = "HH" ;
		/**
		* HS号 
		*/
     	@Comment("HS号")
	    public static final String HS = "HS" ;
		/**
		* ISOEORRE 
		*/
     	@Comment("ISOEORRE")
	    public static final String ISOEORRE = "ISOEORRE" ;
		/**
		* 长物料描述 
		*/
     	@Comment("长物料描述")
	    public static final String MATDESCFULL = "MatDescFull" ;
		/**
		* 长物料描述英文描述 
		*/
     	@Comment("长物料描述英文描述")
	    public static final String MATDESCFULL_EN = "MatDescFull_EN" ;
		/**
		* 长物料描述泰文描述 
		*/
     	@Comment("长物料描述泰文描述")
	    public static final String MATDESCFULL_TH = "MatDescFull_TH" ;
		/**
		* 物料组 
		*/
     	@Comment("物料组")
	    public static final String MATGRP = "MatGrp" ;
		/**
		* 工厂特定的物料状态： 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购 
		*/
     	@Comment("工厂特定的物料状态： 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购")
	    public static final String MATSTATUS = "MatStatus" ;
		/**
		* 物料类型(FERT 产成品;ROH 原辅料;ROH1 材料;ZUVA 零价值物料;HALB 半成品 
		*/
     	@Comment("物料类型(FERT 产成品;ROH 原辅料;ROH1 材料;ZUVA 零价值物料;HALB 半成品")
	    public static final String MATTYP = "MatTyp" ;
		/**
		* 物料编号80位 
		*/
     	@Comment("物料编号80位")
	    public static final String MATERIALCODE = "MaterialCode" ;
		/**
		* 物料描述 
		*/
     	@Comment("物料描述")
	    public static final String MATERIALDESC = "MaterialDesc" ;
		/**
		* 物料描述英文描述 
		*/
     	@Comment("物料描述英文描述")
	    public static final String MATERIALDESC_EN = "MaterialDesc_EN" ;
		/**
		* 物料描述泰文描述 
		*/
     	@Comment("物料描述泰文描述")
	    public static final String MATERIALDESC_TH = "MaterialDesc_TH" ;
		/**
		* 物料组 
		*/
     	@Comment("物料组")
	    public static final String MATERIALGROUP = "MaterialGroup" ;
		/**
		* 物料描述 
		*/
     	@Comment("物料描述")
	    public static final String MATERIALNAME = "MaterialName" ;
		/**
		* 物料号9位 
		*/
     	@Comment("物料号9位")
	    public static final String MATERIALPURE = "MaterialPure" ;
		/**
		* 物料编号40位 
		*/
     	@Comment("物料编号40位")
	    public static final String MATERIALSHORT = "MaterialShort" ;
		/**
		* 规格 
		*/
     	@Comment("规格")
	    public static final String MATERIALSPEC = "MaterialSpec" ;
		/**
		* 净重 
		*/
     	@Comment("净重")
	    public static final String NETHEAVY = "NetHeavy" ;
		/**
		* 旧物料号 
		*/
     	@Comment("旧物料号")
	    public static final String OLDMATCODE = "OldMatCode" ;
		/**
		* 超交率 
		*/
     	@Comment("超交率")
	    public static final String OVERDELIVERYRATE = "OverDeliveryRate" ;
		/**
		* 花纹 
		*/
     	@Comment("花纹")
	    public static final String PATTERN = "Pattern" ;
		/**
		* 工厂号 
		*/
     	@Comment("工厂号")
	    public static final String PLANT = "Plant" ;
		/**
		* 生产单位 
		*/
     	@Comment("生产单位")
	    public static final String PRODUCTUNIT = "ProductUnit" ;
		/**
		* 采购单位 
		*/
     	@Comment("采购单位")
	    public static final String PURCHASEUNIT = "PurchaseUnit" ;
		/**
		* 换算比例(发货单位->基本单位) 
		*/
     	@Comment("换算比例(发货单位->基本单位)")
	    public static final String RATEGI2B = "RateGI2b" ;
		/**
		* 换算比例(生产单位->基本单位) 
		*/
     	@Comment("换算比例(生产单位->基本单位)")
	    public static final String RATEPP2B = "RatePp2b" ;
		/**
		* 换算比例(采购单位->基本单位) 
		*/
     	@Comment("换算比例(采购单位->基本单位)")
	    public static final String RATEPR2B = "RatePr2b" ;
		/**
		* 换算比例(销售单位->基本单位) 
		*/
     	@Comment("换算比例(销售单位->基本单位)")
	    public static final String RATESO2B = "RateSo2b" ;
		/**
		* 换算比例(库存单位->基本单位) 
		*/
     	@Comment("换算比例(库存单位->基本单位)")
	    public static final String RATEST2B = "RateSt2b" ;
		/**
		* 特殊采购类型 
		*/
     	@Comment("特殊采购类型")
	    public static final String SOBSL = "SOBSL" ;
		/**
		* 商品名称 
		*/
     	@Comment("商品名称")
	    public static final String SPMC = "SPMC" ;
		/**
		* 销售单位 
		*/
     	@Comment("销售单位")
	    public static final String SALESUNIT = "SalesUnit" ;
		/**
		* 跨工厂物料状态： 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购 
		*/
     	@Comment("跨工厂物料状态： 01-因采购/仓库二被冻结 02-因任务清单/BOM而被冻结 Z1-冻结物料，只能库存收发货 Z2-冻结物料，不允许所有操作 Z3-冻结物料，只能库存收发货和采购")
	    public static final String STATUS = "Status" ;
		/**
		* StatusZ1 
		*/
     	@Comment("StatusZ1")
	    public static final String STATUSZ1 = "StatusZ1" ;
		/**
		* 库存单位 
		*/
     	@Comment("库存单位")
	    public static final String STOCKUNIT = "StockUnit" ;
		/**
		* 分厂号 
		*/
     	@Comment("分厂号")
	    public static final String SUBPLANT = "SubPlant" ;
		/**
		* 泰国使用规格 
		*/
     	@Comment("泰国使用规格")
	    public static final String THSPEC = "THSpec" ;
		/**
		* 胎胚号 
		*/
     	@Comment("胎胚号")
	    public static final String TPNO = "TPNo" ;
		/**
		* 最后修改日期 
		*/
     	@Comment("最后修改日期")
	    public static final String UD = "UD" ;
		/**
		* 最后修改时间 
		*/
     	@Comment("最后修改时间")
	    public static final String UTIME = "UTIME" ;
		/**
		* 是否用于海外贸易 
		*/
     	@Comment("是否用于海外贸易")
	    public static final String ZBYZ1 = "ZBYZ1" ;
		/**
		* GTM规格 
		*/
     	@Comment("GTM规格")
	    public static final String ZCS01 = "ZCS01" ;
		/**
		* 负荷指数 
		*/
     	@Comment("负荷指数")
	    public static final String ZCS02 = "ZCS02" ;
		/**
		* 速度级别 
		*/
     	@Comment("速度级别")
	    public static final String ZCS03 = "ZCS03" ;
		/**
		* TT/TL 
		*/
     	@Comment("TT/TL")
	    public static final String ZCS04 = "ZCS04" ;
		/**
		* 是否（HB) 
		*/
     	@Comment("是否（HB)")
	    public static final String ZCS05 = "ZCS05" ;
		/**
		* 是否ECE 
		*/
     	@Comment("是否ECE")
	    public static final String ZCS06 = "ZCS06" ;
		/**
		* 是否-S 
		*/
     	@Comment("是否-S")
	    public static final String ZCS07 = "ZCS07" ;
		/**
		* 是否BR 
		*/
     	@Comment("是否BR")
	    public static final String ZCS08 = "ZCS08" ;
		/**
		* 是否CCC 
		*/
     	@Comment("是否CCC")
	    public static final String ZCS09 = "ZCS09" ;
		/**
		* 是否BIS 
		*/
     	@Comment("是否BIS")
	    public static final String ZCS10 = "ZCS10" ;
		/**
		* 是否SNI 
		*/
     	@Comment("是否SNI")
	    public static final String ZCS11 = "ZCS11" ;
		/**
		* 是否M+S 
		*/
     	@Comment("是否M+S")
	    public static final String ZCS12 = "ZCS12" ;
		/**
		* ZCS13 
		*/
     	@Comment("ZCS13")
	    public static final String ZCS13 = "ZCS13" ;
		/**
		* ZCS15 
		*/
     	@Comment("ZCS15")
	    public static final String ZCS15 = "ZCS15" ;
		/**
		* ZCS16 
		*/
     	@Comment("ZCS16")
	    public static final String ZCS16 = "ZCS16" ;
		/**
		* ZCS17 
		*/
     	@Comment("ZCS17")
	    public static final String ZCS17 = "ZCS17" ;
		/**
		* ZML3 
		*/
     	@Comment("ZML3")
	    public static final String ZML3 = "ZML3" ;
		/**
		* ZML4 
		*/
     	@Comment("ZML4")
	    public static final String ZML4 = "ZML4" ;
		/**
		* ZPEL 
		*/
     	@Comment("ZPEL")
	    public static final String ZPEL = "ZPEL" ;
		/**
		* ZPOS 
		*/
     	@Comment("ZPOS")
	    public static final String ZPOS = "ZPOS" ;
		/**
		* ZTIC 
		*/
     	@Comment("ZTIC")
	    public static final String ZTIC = "ZTIC" ;
		/**
		* ZWBM 
		*/
     	@Comment("ZWBM")
	    public static final String ZWBM = "ZWBM" ;
    
}
