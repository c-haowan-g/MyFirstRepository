/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * bom_uda
 * @author 王海霖
 * @Date 2019-06-24 15:06:48
 */

public class BillOfMaterialUDA {
    
	/**
	* BOM类型：外胎MBOM(CoverTireMBOM)胎胚MBOM(GreenTireMBOM)半部件MBOM(SemiPartMBOM)  
	*/
 	@Comment("BOM类型：外胎MBOM(CoverTireMBOM)胎胚MBOM(GreenTireMBOM)半部件MBOM(SemiPartMBOM) ")
    public static final String BOMMOLD = "BomMold" ;
	/**
	* 预留1 
	*/
 	@Comment("预留1")
    public static final String DUMMY1 = "DUMMY1" ;
	/**
	* 预留2 
	*/
 	@Comment("预留2")
    public static final String DUMMY2 = "DUMMY2" ;
	/**
	* 预留3 
	*/
 	@Comment("预留3")
    public static final String DUMMY3 = "DUMMY3" ;
	/**
	* 分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3  
	*/
 	@Comment("分厂 半钢 G1 全钢 G3 胎胚一次法 G1 胎胚二次法 G3 ")
    public static final String FACTORY = "Factory" ;
	/**
	* 父项SAP物料号 
	*/
 	@Comment("父项SAP物料号")
    public static final String MASTERSAP = "MasterSAP" ;
	/**
	* 父项SAP物料号-储胎9  
	*/
 	@Comment("父项SAP物料号-储胎9 ")
    public static final String MASTERSAP_TEMP = "MasterSAP_Temp" ;
	/**
	* 物料类型 PCR TBR  
	*/
 	@Comment("物料类型 PCR TBR ")
    public static final String MATERIALTYPE = "MaterialType" ;
	/**
	* 所属产品阶段 试制 01 试产 02 投产03  
	*/
 	@Comment("所属产品阶段 试制 01 试产 02 投产03 ")
    public static final String PROPHASE = "Prophase" ;
	/**
	* BOM替代号  
	*/
 	@Comment("BOM替代号 ")
    public static final String REPLACEBOM = "ReplaceBOM" ;
	/**
	* 工厂 柳州 8003  
	*/
 	@Comment("工厂 柳州 8003 ")
    public static final String WERKS = "WERKS" ;
    
}
