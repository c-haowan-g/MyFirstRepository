/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 首模检测查询
 * 
 * @author 刘朋
 * @Date 2018-08-08 12:02:29
 */
@ATDefinition("D_QM_Detial")
@Entity
@XmlRootElement
@Table(name = "AT_D_QM_Detial")
public class Detial extends RockWellBaseEntity {

	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
	@Column(nullable = false, length = 80)
	private String agenc_no_s;

	@Comment("成型换规首条确认标记： 1：换工装（换大规格）待检；2：普通换欧盟规格待检；0：质检已确认")
	@Column(nullable = true, length = 20)
	private String aqhmflag_s;

	@Comment("轮胎类型区分：0：正常；1：技术用胎；2：测温；3：扒废；4：质单； 5：实验胎；6：重建胎")
	@Column(nullable = true, length = 20)
	private String attribute_s;

	@Comment("轮胎条码：MainTyre 表 BARCODE")
	@Column(nullable = false, length = 20)
	private String barcode_s;

	@Comment("载具ID")
	@Column(nullable = true, length = 20)
	private String carriercode_s;

	@Comment("首中末件的标识：1首件2中件3末件")
	@Column(nullable = true, length = 20)
	private String checkflag_s;

	@Comment("曲线胎标记： 0：正常；1：曲线胎；2：SDS")
	@Column(nullable = true, length = 20)
	private String curveflag_s;

	@Comment("动平衡机条码：Ent 表 ENTBARCODE")
	@Column(nullable = true, length = 20)
	private String dbmbar_s;

	@Comment("物料等级代码")
	@Column(nullable = false, length = 20)
	private String gradecd_s;

	@Comment("班组代码")
	@Column(nullable = true, length = 20)
	private String groupcd_s;

	@Comment("是否复检：0未复检、1已复检过")
	@Column(nullable = true, length = 20)
	private String isrecheck_s;

	@Comment("物料类ID")
	@Column(nullable = false, length = 20)
	private String itemclassid_s;

	@Comment("品号")
	@Column(nullable = false, length = 20)
	private String itemid_s;

	@Comment("均匀机条码：Ent 表 ENTBARCODE")
	@Column(nullable = true, length = 20)
	private String jyxmbar_s;

	@Comment("是否新品")
	@Column(nullable = true, length = 20)
	private String newitem_s;

	@Comment("质检员工号")
	@Column(nullable = false, length = 20)
	private String operby_s;

	@Comment("质检时间")
	@Column(nullable = false, length = 0)
	private Date opertime_t;

	@Comment("当前工序")
	@Column(nullable = false, length = 20)
	private String proess_s;

	@Comment("病象代码：QM_Reas 表 ID")
	@Column(nullable = true, length = 20)
	private String reascd_s;

	@Comment("自检标识（默认0合格，1不合格)")
	@Column(nullable = true, length = 20)
	private String selfflag_s;

	@Comment("班次代码")
	@Column(nullable = true, length = 20)
	private String shiftcd_s;

	@Comment("轮胎状态编码：0-待检、1-合格、2-不合格")
	@Column(nullable = false, length = 20)
	private String statecd_s;

	@Comment("库区ID")
	@Column(nullable = true, length = 20)
	private String stockareacode_s;

	@Comment("工厂(1.全钢 2.半钢)")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	@Comment("工装器具ID")
	@Column(nullable = true, length = 20)
	private String utensilcode_s;

	@Comment("X光机条码：Ent 表 ENTBARCODE")
	@Column(nullable = true, length = 20)
	private String xraymbar_s;

	@Comment("外观工位条码")
	@Column(nullable = true, length = 20)
	private String visualvar_s;

	public String getVisualvar_s() {
		return visualvar_s;
	}

	public void setVisualvar_s(String visualvar_s) {
		this.visualvar_s = visualvar_s;
	}

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getAqhmflag_s() {
		return aqhmflag_s;
	}

	public void setAqhmflag_s(String aqhmflag_s) {
		this.aqhmflag_s = aqhmflag_s;
	}

	public String getAttribute_s() {
		return attribute_s;
	}

	public void setAttribute_s(String attribute_s) {
		this.attribute_s = attribute_s;
	}

	public String getBarcode_s() {
		return barcode_s;
	}

	public void setBarcode_s(String barcode_s) {
		this.barcode_s = barcode_s;
	}

	public String getCarriercode_s() {
		return carriercode_s;
	}

	public void setCarriercode_s(String carriercode_s) {
		this.carriercode_s = carriercode_s;
	}

	public String getCheckflag_s() {
		return checkflag_s;
	}

	public void setCheckflag_s(String checkflag_s) {
		this.checkflag_s = checkflag_s;
	}

	public String getCurveflag_s() {
		return curveflag_s;
	}

	public void setCurveflag_s(String curveflag_s) {
		this.curveflag_s = curveflag_s;
	}

	public String getDbmbar_s() {
		return dbmbar_s;
	}

	public void setDbmbar_s(String dbmbar_s) {
		this.dbmbar_s = dbmbar_s;
	}

	public String getGradecd_s() {
		return gradecd_s;
	}

	public void setGradecd_s(String gradecd_s) {
		this.gradecd_s = gradecd_s;
	}

	public String getGroupcd_s() {
		return groupcd_s;
	}

	public void setGroupcd_s(String groupcd_s) {
		this.groupcd_s = groupcd_s;
	}

	public String getIsrecheck_s() {
		return isrecheck_s;
	}

	public void setIsrecheck_s(String isrecheck_s) {
		this.isrecheck_s = isrecheck_s;
	}

	public String getItemclassid_s() {
		return itemclassid_s;
	}

	public void setItemclassid_s(String itemclassid_s) {
		this.itemclassid_s = itemclassid_s;
	}

	public String getItemid_s() {
		return itemid_s;
	}

	public void setItemid_s(String itemid_s) {
		this.itemid_s = itemid_s;
	}

	public String getJyxmbar_s() {
		return jyxmbar_s;
	}

	public void setJyxmbar_s(String jyxmbar_s) {
		this.jyxmbar_s = jyxmbar_s;
	}

	public String getNewitem_s() {
		return newitem_s;
	}

	public void setNewitem_s(String newitem_s) {
		this.newitem_s = newitem_s;
	}

	public String getOperby_s() {
		return operby_s;
	}

	public void setOperby_s(String operby_s) {
		this.operby_s = operby_s;
	}

	public Date getOpertime_t() {
		return opertime_t;
	}

	public void setOpertime_t(Date opertime_t) {
		this.opertime_t = opertime_t;
	}

	public String getProess_s() {
		return proess_s;
	}

	public void setProess_s(String proess_s) {
		this.proess_s = proess_s;
	}

	public String getReascd_s() {
		return reascd_s;
	}

	public void setReascd_s(String reascd_s) {
		this.reascd_s = reascd_s;
	}

	public String getSelfflag_s() {
		return selfflag_s;
	}

	public void setSelfflag_s(String selfflag_s) {
		this.selfflag_s = selfflag_s;
	}

	public String getShiftcd_s() {
		return shiftcd_s;
	}

	public void setShiftcd_s(String shiftcd_s) {
		this.shiftcd_s = shiftcd_s;
	}

	public String getStatecd_s() {
		return statecd_s;
	}

	public void setStatecd_s(String statecd_s) {
		this.statecd_s = statecd_s;
	}

	public String getStockareacode_s() {
		return stockareacode_s;
	}

	public void setStockareacode_s(String stockareacode_s) {
		this.stockareacode_s = stockareacode_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getUtensilcode_s() {
		return utensilcode_s;
	}

	public void setUtensilcode_s(String utensilcode_s) {
		this.utensilcode_s = utensilcode_s;
	}

	public String getXraymbar_s() {
		return xraymbar_s;
	}

	public void setXraymbar_s(String xraymbar_s) {
		this.xraymbar_s = xraymbar_s;
	}

}
