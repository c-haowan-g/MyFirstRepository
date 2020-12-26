/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity;

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

/**
 * SAP物料基础数据
 * 
 * @author 李彦
 * @Date 2018-08-09 11:50:47
 */
@ATDefinition("INT_SAP_MATERIALS")
@Entity
@XmlRootElement
@Table(name = "AT_INT_SAP_MATERIALS")
public class Materials extends RockWellBaseEntity {

	@Comment("基本计量单位")
	@Column(nullable = true, length = 80)
	private String baseunit_s;

	@Comment("品牌")
	@Column(nullable = true, length = 80)
	private String brand_s;

	@Comment("层级")
	@Column(nullable = true, length = 120)
	private String cj_s;

	@Comment("创建时间")
	@Column(nullable = true, length = 80)
	private String ctime_s;

	@Comment("创建日期")
	@Column(nullable = true, length = 80)
	private String cdate_s;

	@Comment("公司号")
	@Column(nullable = false, length = 80)
	private String companycode_s;

	@Comment("产品组")
	@Column(nullable = true, length = 80)
	private String division_s;

	@Comment("预留1")
	@Column(nullable = true, length = 80)
	private String dummy1_s;

	@Comment("预留2")
	@Column(nullable = true, length = 80)
	private String dummy2_s;

	@Comment("预留3")
	@Column(nullable = true, length = 80)
	private String dummy3_s;

	@Comment("预留4")
	@Column(nullable = true, length = 80)
	private String dummy4_s;

	@Comment("寸口描述")
	@Column(nullable = true, length = 80)
	private String ewbez_s;

	@Comment("寸口")
	@Column(nullable = true, length = 80)
	private String extwg_s;

	@Comment("发货单位")
	@Column(nullable = true, length = 80)
	private String gissueunit_s;

	@Comment("货号")
	@Column(nullable = true, length = 80)
	private String hh_s;

	@Comment("HS号")
	@Column(nullable = true, length = 80)
	private String hs_s;

	@Comment("是否配套 OE配套 RE非配套")
	@Column(nullable = true, length = 80)
	private String isoeorre_s;
	@Comment("类别")
	@Column(nullable = true, length = 80)
	private String lbmc_s;

	@Comment("批号管理")
	@Column(nullable = true, length = 80)
	private String lotname_s;

	@Comment("长物料描述英文描述")
	@Column(nullable = true, length = 600)
	private String matdescfull_en_s;

	@Comment("长物料描述")
	@Column(nullable = true, length = 200)
	private String matdescfull_s;

	@Comment("长物料描述泰文描述")
	@Column(nullable = true, length = 600)
	private String matdescfull_th_s;

	@Comment("物料组")
	@Column(nullable = true, length = 80)
	private String matgrp_s;

	@Comment("工厂特定的物料状态")
	@Column(nullable = true, length = 80)
	private String matstatus_s;

	@Comment("物料类型")
	@Column(nullable = true, length = 80)
	private String mattyp_s;

	@Comment("物料编号80位")
	@Column(nullable = false, length = 80)
	private String materialcode_s;

	@Comment("物料描述英文描述")
	@Column(nullable = true, length = 600)
	private String materialdesc_en_s;

	@Comment("物料描述")
	@Column(nullable = true, length = 80)
	private String materialdesc_s;

	@Comment("物料描述泰文描述")
	@Column(nullable = true, length = 600)
	private String materialdesc_th_s;

	@Comment(" ")
	@Column(nullable = true, length = 80)
	private String materialgroup_s;

	@Comment("物料描述")
	@Column(nullable = true, length = 80)
	private String materialname_s;

	@Comment("物料号9位")
	@Column(nullable = false, length = 80)
	private String materialpure_s;

	@Comment("物料编号40位")
	@Column(nullable = true, length = 80)
	private String materialshort_s;

	@Comment("规格")
	@Column(nullable = true, length = 200)
	private String materialspec_s;

	@Comment("净重")
	@Column(nullable = true, length = 0)
	private String netheavy_f;

	@Comment("旧物料号")
	@Column(nullable = true, length = 80)
	private String oldmatcode_s;

	@Comment("超交率")
	@Column(nullable = true, length = 0)
	private String overdeliveryrate_f;

	@Comment("花纹")
	@Column(nullable = true, length = 80)
	private String pattern_s;

	@Comment("工厂号")
	@Column(nullable = false, length = 80)
	private String plant_s;

	@Comment("生产单位")
	@Column(nullable = true, length = 80)
	private String productunit_s;

	@Comment("采购单位")
	@Column(nullable = true, length = 80)
	private String purchaseunit_s;

	@Comment("换算比例(发货单位->基本单位)")
	@Column(nullable = true, length = 80)
	private String rategi2b_s;

	@Comment("换算比例(生产单位->基本单位)")
	@Column(nullable = true, length = 80)
	private String ratepp2b_s;

	@Comment("换算比例(采购单位->基本单位)")
	@Column(nullable = true, length = 80)
	private String ratepr2b_s;

	@Comment("换算比例(销售单位->基本单位)")
	@Column(nullable = true, length = 80)
	private String rateso2b_s;

	@Comment("换算比例(库存单位->基本单位)")
	@Column(nullable = true, length = 80)
	private String ratest2b_s;

	@Comment("特殊采购类型 ")
	@Column(nullable = true, length = 80)
	private String sobsl_s;

	@Comment("商品名称")
	@Column(nullable = true, length = 130)
	private String spmc_s;

	@Comment("同步时间")
	@Column(nullable = true, length = 0)
	private Date synchronous_time_t;

	@Comment("销售单位")
	@Column(nullable = true, length = 80)
	private String salesunit_s;

	@Comment(" ")
	@Column(nullable = true, length = 80)
	private String statusz1_s;

	@Comment("跨工厂物料状态")
	@Column(nullable = true, length = 80)
	private String status_s;

	@Comment("库存单位")
	@Column(nullable = true, length = 80)
	private String stockunit_s;

	@Comment("分厂号")
	@Column(nullable = true, length = 80)
	private String subplant_s;

	@Comment("泰国使用规格")
	@Column(nullable = true, length = 120)
	private String thspec_s;

	@Comment("胎胚号")
	@Column(nullable = true, length = 80)
	private String tpno_s;

	@Comment("最后修改时间")
	@Column(nullable = true, length = 80)
	private String utime_s;

	@Comment("最后修改日期")
	@Column(nullable = true, length = 80)
	private String udate_s;

	@Comment("是否用于海外贸易")
	@Column(nullable = true, length = 80)
	private String zbyz1_s;

	@Comment("GTM规格")
	@Column(nullable = true, length = 200)
	private String zcs01_s;

	@Comment("负荷指数")
	@Column(nullable = true, length = 80)
	private String zcs02_s;

	@Comment("速度级别")
	@Column(nullable = true, length = 80)
	private String zcs03_s;

	@Comment("TT/TL")
	@Column(nullable = true, length = 80)
	private String zcs04_s;

	@Comment("是否（HB）")
	@Column(nullable = true, length = 80)
	private String zcs05_s;

	@Comment("是否ECE")
	@Column(nullable = true, length = 80)
	private String zcs06_s;

	@Comment("是否-S")
	@Column(nullable = true, length = 80)
	private String zcs07_s;

	@Comment("是否BR")
	@Column(nullable = true, length = 80)
	private String zcs08_s;

	@Comment("是否CCC")
	@Column(nullable = true, length = 80)
	private String zcs09_s;

	@Comment("是否BIS")
	@Column(nullable = true, length = 80)
	private String zcs10_s;

	@Comment("是否SNI")
	@Column(nullable = true, length = 80)
	private String zcs11_s;

	@Comment("是否M+S")
	@Column(nullable = true, length = 80)
	private String zcs12_s;

	@Comment("重量")
	@Column(nullable = true, length = 80)
	private String zcs13_s;

	@Comment("装箱量40HC")
	@Column(nullable = true, length = 80)
	private String zcs15_s;

	@Comment("装箱量40FCL")
	@Column(nullable = true, length = 80)
	private String zcs16_s;

	@Comment("装箱量20FCL")
	@Column(nullable = true, length = 80)
	private String zcs17_s;

	@Comment("单胎最大载重量 ")
	@Column(nullable = true, length = 80)
	private String zml3_s;

	@Comment("双胎最大载重量 ")
	@Column(nullable = true, length = 80)
	private String zml4_s;

	@Comment("性能级别")
	@Column(nullable = true, length = 80)
	private String zpel_s;

	@Comment("轮胎设计位置")
	@Column(nullable = true, length = 80)
	private String zpos_s;

	@Comment("轮胎分类")
	@Column(nullable = true, length = 80)
	private String ztic_s;

	@Comment("宽胎基标记")
	@Column(nullable = true, length = 80)
	private String zwbm_s;

	public String getBaseunit_s() {
		return baseunit_s;
	}

	@XmlElement
	public void setBaseunit_s(String baseunit_s) {
		this.baseunit_s = baseunit_s;
	}

	public String getBrand_s() {
		return brand_s;
	}

	@XmlElement
	public void setBrand_s(String brand_s) {
		this.brand_s = brand_s;
	}

	public String getCj_s() {
		return cj_s;
	}

	@XmlElement
	public void setCj_s(String cj_s) {
		this.cj_s = cj_s;
	}

	public String getCtime_s() {
		return ctime_s;
	}

	@XmlElement
	public void setCtime_s(String ctime_s) {
		this.ctime_s = ctime_s;
	}

	public String getCdate_s() {
		return cdate_s;
	}

	@XmlElement
	public void setCdate_s(String cdate_s) {
		this.cdate_s = cdate_s;
	}

	public String getCompanycode_s() {
		return companycode_s;
	}

	@XmlElement
	public void setCompanycode_s(String companycode_s) {
		this.companycode_s = companycode_s;
	}

	public String getDivision_s() {
		return division_s;
	}

	@XmlElement
	public void setDivision_s(String division_s) {
		this.division_s = division_s;
	}

	public String getDummy1_s() {
		return dummy1_s;
	}

	@XmlElement
	public void setDummy1_s(String dummy1_s) {
		this.dummy1_s = dummy1_s;
	}

	public String getDummy2_s() {
		return dummy2_s;
	}

	@XmlElement
	public void setDummy2_s(String dummy2_s) {
		this.dummy2_s = dummy2_s;
	}

	public String getDummy3_s() {
		return dummy3_s;
	}

	@XmlElement
	public void setDummy3_s(String dummy3_s) {
		this.dummy3_s = dummy3_s;
	}

	public String getDummy4_s() {
		return dummy4_s;
	}

	@XmlElement
	public void setDummy4_s(String dummy4_s) {
		this.dummy4_s = dummy4_s;
	}

	public String getEwbez_s() {
		return ewbez_s;
	}

	@XmlElement
	public void setEwbez_s(String ewbez_s) {
		this.ewbez_s = ewbez_s;
	}

	public String getExtwg_s() {
		return extwg_s;
	}

	@XmlElement
	public void setExtwg_s(String extwg_s) {
		this.extwg_s = extwg_s;
	}

	public String getGissueunit_s() {
		return gissueunit_s;
	}

	@XmlElement
	public void setGissueunit_s(String gissueunit_s) {
		this.gissueunit_s = gissueunit_s;
	}

	public String getHh_s() {
		return hh_s;
	}

	@XmlElement
	public void setHh_s(String hh_s) {
		this.hh_s = hh_s;
	}

	public String getHs_s() {
		return hs_s;
	}

	@XmlElement
	public void setHs_s(String hs_s) {
		this.hs_s = hs_s;
	}

	public String getIsoeorre_s() {
		return isoeorre_s;
	}

	@XmlElement
	public void setIsoeorre_s(String isoeorre_s) {
		this.isoeorre_s = isoeorre_s;
	}

	public String getLbmc_s() {
		return lbmc_s;
	}

	@XmlElement
	public void setLbmc_s(String lbmc_s) {
		this.lbmc_s = lbmc_s;
	}

	public String getLotname_s() {
		return lotname_s;
	}

	@XmlElement
	public void setLotname_s(String lotname_s) {
		this.lotname_s = lotname_s;
	}

	public String getMatdescfull_en_s() {
		return matdescfull_en_s;
	}

	@XmlElement
	public void setMatdescfull_en_s(String matdescfull_en_s) {
		this.matdescfull_en_s = matdescfull_en_s;
	}

	public String getMatdescfull_s() {
		return matdescfull_s;
	}

	@XmlElement
	public void setMatdescfull_s(String matdescfull_s) {
		this.matdescfull_s = matdescfull_s;
	}

	public String getMatdescfull_th_s() {
		return matdescfull_th_s;
	}

	@XmlElement
	public void setMatdescfull_th_s(String matdescfull_th_s) {
		this.matdescfull_th_s = matdescfull_th_s;
	}

	public String getMatgrp_s() {
		return matgrp_s;
	}

	@XmlElement
	public void setMatgrp_s(String matgrp_s) {
		this.matgrp_s = matgrp_s;
	}

	public String getMatstatus_s() {
		return matstatus_s;
	}

	@XmlElement
	public void setMatstatus_s(String matstatus_s) {
		this.matstatus_s = matstatus_s;
	}

	public String getMattyp_s() {
		return mattyp_s;
	}

	@XmlElement
	public void setMattyp_s(String mattyp_s) {
		this.mattyp_s = mattyp_s;
	}

	public String getMaterialcode_s() {
		return materialcode_s;
	}

	@XmlElement
	public void setMaterialcode_s(String materialcode_s) {
		this.materialcode_s = materialcode_s;
	}

	public String getMaterialdesc_en_s() {
		return materialdesc_en_s;
	}

	@XmlElement
	public void setMaterialdesc_en_s(String materialdesc_en_s) {
		this.materialdesc_en_s = materialdesc_en_s;
	}

	public String getMaterialdesc_s() {
		return materialdesc_s;
	}

	@XmlElement
	public void setMaterialdesc_s(String materialdesc_s) {
		this.materialdesc_s = materialdesc_s;
	}

	public String getMaterialdesc_th_s() {
		return materialdesc_th_s;
	}

	@XmlElement
	public void setMaterialdesc_th_s(String materialdesc_th_s) {
		this.materialdesc_th_s = materialdesc_th_s;
	}

	public String getMaterialgroup_s() {
		return materialgroup_s;
	}

	@XmlElement
	public void setMaterialgroup_s(String materialgroup_s) {
		this.materialgroup_s = materialgroup_s;
	}

	public String getMaterialname_s() {
		return materialname_s;
	}

	@XmlElement
	public void setMaterialname_s(String materialname_s) {
		this.materialname_s = materialname_s;
	}

	public String getMaterialpure_s() {
		return materialpure_s;
	}

	@XmlElement
	public void setMaterialpure_s(String materialpure_s) {
		this.materialpure_s = materialpure_s;
	}

	public String getMaterialshort_s() {
		return materialshort_s;
	}

	@XmlElement
	public void setMaterialshort_s(String materialshort_s) {
		this.materialshort_s = materialshort_s;
	}

	public String getMaterialspec_s() {
		return materialspec_s;
	}

	@XmlElement
	public void setMaterialspec_s(String materialspec_s) {
		this.materialspec_s = materialspec_s;
	}

	public String getNetheavy_f() {
		return netheavy_f;
	}

	@XmlElement
	public void setNetheavy_f(String netheavy_f) {
		this.netheavy_f = netheavy_f;
	}

	public String getOldmatcode_s() {
		return oldmatcode_s;
	}

	@XmlElement
	public void setOldmatcode_s(String oldmatcode_s) {
		this.oldmatcode_s = oldmatcode_s;
	}

	public String getOverdeliveryrate_f() {
		return overdeliveryrate_f;
	}

	@XmlElement
	public void setOverdeliveryrate_f(String overdeliveryrate_f) {
		this.overdeliveryrate_f = overdeliveryrate_f;
	}

	public String getPattern_s() {
		return pattern_s;
	}

	@XmlElement
	public void setPattern_s(String pattern_s) {
		this.pattern_s = pattern_s;
	}

	public String getPlant_s() {
		return plant_s;
	}

	@XmlElement
	public void setPlant_s(String plant_s) {
		this.plant_s = plant_s;
	}

	public String getProductunit_s() {
		return productunit_s;
	}

	@XmlElement
	public void setProductunit_s(String productunit_s) {
		this.productunit_s = productunit_s;
	}

	public String getPurchaseunit_s() {
		return purchaseunit_s;
	}

	@XmlElement
	public void setPurchaseunit_s(String purchaseunit_s) {
		this.purchaseunit_s = purchaseunit_s;
	}

	public String getRategi2b_s() {
		return rategi2b_s;
	}

	@XmlElement
	public void setRategi2b_s(String rategi2b_s) {
		this.rategi2b_s = rategi2b_s;
	}

	public String getRatepp2b_s() {
		return ratepp2b_s;
	}

	@XmlElement
	public void setRatepp2b_s(String ratepp2b_s) {
		this.ratepp2b_s = ratepp2b_s;
	}

	public String getRatepr2b_s() {
		return ratepr2b_s;
	}

	@XmlElement
	public void setRatepr2b_s(String ratepr2b_s) {
		this.ratepr2b_s = ratepr2b_s;
	}

	public String getRateso2b_s() {
		return rateso2b_s;
	}

	@XmlElement
	public void setRateso2b_s(String rateso2b_s) {
		this.rateso2b_s = rateso2b_s;
	}

	public String getRatest2b_s() {
		return ratest2b_s;
	}

	@XmlElement
	public void setRatest2b_s(String ratest2b_s) {
		this.ratest2b_s = ratest2b_s;
	}

	public String getSobsl_s() {
		return sobsl_s;
	}

	@XmlElement
	public void setSobsl_s(String sobsl_s) {
		this.sobsl_s = sobsl_s;
	}

	public String getSpmc_s() {
		return spmc_s;
	}

	@XmlElement
	public void setSpmc_s(String spmc_s) {
		this.spmc_s = spmc_s;
	}

	public Date getSynchronous_time_t() {
		return synchronous_time_t;
	}

	@XmlElement
	public void setSynchronous_time_t(Date synchronous_time_t) {
		this.synchronous_time_t = synchronous_time_t;
	}

	public String getSalesunit_s() {
		return salesunit_s;
	}

	@XmlElement
	public void setSalesunit_s(String salesunit_s) {
		this.salesunit_s = salesunit_s;
	}

	public String getStatusz1_s() {
		return statusz1_s;
	}

	@XmlElement
	public void setStatusz1_s(String statusz1_s) {
		this.statusz1_s = statusz1_s;
	}

	public String getStatus_s() {
		return status_s;
	}

	@XmlElement
	public void setStatus_s(String status_s) {
		this.status_s = status_s;
	}

	public String getStockunit_s() {
		return stockunit_s;
	}

	@XmlElement
	public void setStockunit_s(String stockunit_s) {
		this.stockunit_s = stockunit_s;
	}

	public String getSubplant_s() {
		return subplant_s;
	}

	@XmlElement
	public void setSubplant_s(String subplant_s) {
		this.subplant_s = subplant_s;
	}

	public String getThspec_s() {
		return thspec_s;
	}

	@XmlElement
	public void setThspec_s(String thspec_s) {
		this.thspec_s = thspec_s;
	}

	public String getTpno_s() {
		return tpno_s;
	}

	@XmlElement
	public void setTpno_s(String tpno_s) {
		this.tpno_s = tpno_s;
	}

	public String getUtime_s() {
		return utime_s;
	}

	@XmlElement
	public void setUtime_s(String utime_s) {
		this.utime_s = utime_s;
	}

	public String getUdate_s() {
		return udate_s;
	}

	@XmlElement
	public void setUdate_s(String udate_s) {
		this.udate_s = udate_s;
	}

	public String getZbyz1_s() {
		return zbyz1_s;
	}

	@XmlElement
	public void setZbyz1_s(String zbyz1_s) {
		this.zbyz1_s = zbyz1_s;
	}

	public String getZcs01_s() {
		return zcs01_s;
	}

	@XmlElement
	public void setZcs01_s(String zcs01_s) {
		this.zcs01_s = zcs01_s;
	}

	public String getZcs02_s() {
		return zcs02_s;
	}

	@XmlElement
	public void setZcs02_s(String zcs02_s) {
		this.zcs02_s = zcs02_s;
	}

	public String getZcs03_s() {
		return zcs03_s;
	}

	@XmlElement
	public void setZcs03_s(String zcs03_s) {
		this.zcs03_s = zcs03_s;
	}

	public String getZcs04_s() {
		return zcs04_s;
	}

	@XmlElement
	public void setZcs04_s(String zcs04_s) {
		this.zcs04_s = zcs04_s;
	}

	public String getZcs05_s() {
		return zcs05_s;
	}

	@XmlElement
	public void setZcs05_s(String zcs05_s) {
		this.zcs05_s = zcs05_s;
	}

	public String getZcs06_s() {
		return zcs06_s;
	}

	@XmlElement
	public void setZcs06_s(String zcs06_s) {
		this.zcs06_s = zcs06_s;
	}

	public String getZcs07_s() {
		return zcs07_s;
	}

	@XmlElement
	public void setZcs07_s(String zcs07_s) {
		this.zcs07_s = zcs07_s;
	}

	public String getZcs08_s() {
		return zcs08_s;
	}

	@XmlElement
	public void setZcs08_s(String zcs08_s) {
		this.zcs08_s = zcs08_s;
	}

	public String getZcs09_s() {
		return zcs09_s;
	}

	@XmlElement
	public void setZcs09_s(String zcs09_s) {
		this.zcs09_s = zcs09_s;
	}

	public String getZcs10_s() {
		return zcs10_s;
	}

	@XmlElement
	public void setZcs10_s(String zcs10_s) {
		this.zcs10_s = zcs10_s;
	}

	public String getZcs11_s() {
		return zcs11_s;
	}

	@XmlElement
	public void setZcs11_s(String zcs11_s) {
		this.zcs11_s = zcs11_s;
	}

	public String getZcs12_s() {
		return zcs12_s;
	}

	@XmlElement
	public void setZcs12_s(String zcs12_s) {
		this.zcs12_s = zcs12_s;
	}

	public String getZcs13_s() {
		return zcs13_s;
	}

	@XmlElement
	public void setZcs13_s(String zcs13_s) {
		this.zcs13_s = zcs13_s;
	}

	public String getZcs15_s() {
		return zcs15_s;
	}

	@XmlElement
	public void setZcs15_s(String zcs15_s) {
		this.zcs15_s = zcs15_s;
	}

	public String getZcs16_s() {
		return zcs16_s;
	}

	@XmlElement
	public void setZcs16_s(String zcs16_s) {
		this.zcs16_s = zcs16_s;
	}

	public String getZcs17_s() {
		return zcs17_s;
	}

	@XmlElement
	public void setZcs17_s(String zcs17_s) {
		this.zcs17_s = zcs17_s;
	}

	public String getZml3_s() {
		return zml3_s;
	}

	@XmlElement
	public void setZml3_s(String zml3_s) {
		this.zml3_s = zml3_s;
	}

	public String getZml4_s() {
		return zml4_s;
	}

	@XmlElement
	public void setZml4_s(String zml4_s) {
		this.zml4_s = zml4_s;
	}

	public String getZpel_s() {
		return zpel_s;
	}

	@XmlElement
	public void setZpel_s(String zpel_s) {
		this.zpel_s = zpel_s;
	}

	public String getZpos_s() {
		return zpos_s;
	}

	@XmlElement
	public void setZpos_s(String zpos_s) {
		this.zpos_s = zpos_s;
	}

	public String getZtic_s() {
		return ztic_s;
	}

	@XmlElement
	public void setZtic_s(String ztic_s) {
		this.ztic_s = ztic_s;
	}

	public String getZwbm_s() {
		return zwbm_s;
	}

	@XmlElement
	public void setZwbm_s(String zwbm_s) {
		this.zwbm_s = zwbm_s;
	}

}
