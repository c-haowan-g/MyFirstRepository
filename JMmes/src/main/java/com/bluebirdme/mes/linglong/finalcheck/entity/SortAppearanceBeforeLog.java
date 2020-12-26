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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 质检外观前分拣履历表
 * 
 * @author 刘朋
 * @Date 2019-01-07 11:38:44
 */
@ATDefinition("D_QM_SORTAPPEARANCELOG")
@Entity
@XmlRootElement
@Table(name = "AT_D_QM_SORTAPPEARANCELOG")
public class SortAppearanceBeforeLog extends RockWellBaseEntity {

	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
	@Column(nullable = true, length = 80)
	private String agenc_no_s;

	@Comment("归档标记")
	@Column(nullable = true, length = 80)
	private String arch_flag_s;

	@Comment("轮胎条码：MainTyre 表 BARCODE")
	@Column(nullable = true, length = 80)
	private String barcode_s;

	@Comment("修改人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("修改时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = false, length = 80)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = false, length = 0)
	private Date created_time_t;

	@Comment("错误类型： 1:轮胎条码不存在 2:机台信息不存在 3:规格索引不存在 4:轮胎状态不允许分配 5:轮胎规格规则未维护 6:拨胎器异常 7:机台停止 8:扫描头未读取到条码 9:其它")
	@Column(nullable = true, length = 0)
	private Integer etype_i;

	@Comment("质量等级编码")
	@Column(nullable = false, length = 0)
	private String gradecd_i;

	@Comment("MES校验是否成功：0-失败，1-成功")
	@Column(nullable = false, length = 0)
	private Integer isok_i;

	@Comment("品号")
	@Column(nullable = true, length = 80)
	private String itemid_s;

	@Comment("工序")
	@Column(nullable = false, length = 0)
	private String proess_i;

	@Comment("实绩去向：MES_ZJ_Ent 表 ID")
	@Column(nullable = true, length = 80)
	private String realmachinebar_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 80)
	private String record_flag_s;

	@Comment("备注")
	@Column(nullable = true, length = 200)
	private String remark_s;

	@Comment("分拣去向：MES_ZJ_Ent 表 ID")
	@Column(nullable = true, length = 80)
	private String sortmachinebar_s;

	@Comment("操作时间")
	@Column(nullable = true, length = 0)
	private Date sorttime_t;

	@Comment("分拣点：0-割毛前、1-外观前、2-外观后、3-X光后、4-动均前、5-入库前")
	@Column(nullable = false, length = 0)
	private String sorttype_i;

	@Comment("备用字段1")
	@Column(nullable = true, length = 80)
	private String spare1_s;

	@Comment("备用字段2")
	@Column(nullable = true, length = 80)
	private String spare2_s;

	@Comment("备用字段3")
	@Column(nullable = true, length = 80)
	private String spare3_s;

	@Comment("备用字段4")
	@Column(nullable = true, length = 80)
	private String spare4_s;

	@Comment("备用字段5")
	@Column(nullable = true, length = 80)
	private String spare5_s;

	@Comment("工厂(1.全钢 2.半钢)")
	@Column(nullable = false, length = 80)
	private String s_factory_s;

	@Comment("工控下发备注")
	@Column(nullable = true, length = 80)
	private String writeinremark_s;

	@Comment("工控下发是否成功：0-成功、1-失败")
	@Column(nullable = true, length = 80)
	private String writein_s;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
	}

	public String getArch_flag_s() {
		return arch_flag_s;
	}

	@XmlElement
	public void setArch_flag_s(String arch_flag_s) {
		this.arch_flag_s = arch_flag_s;
	}

	public String getBarcode_s() {
		return barcode_s;
	}

	@XmlElement
	public void setBarcode_s(String barcode_s) {
		this.barcode_s = barcode_s;
	}

	public String getChanged_by_s() {
		return changed_by_s;
	}

	@XmlElement
	public void setChanged_by_s(String changed_by_s) {
		this.changed_by_s = changed_by_s;
	}

	public Date getChanged_time_t() {
		return changed_time_t;
	}

	@XmlElement
	public void setChanged_time_t(Date changed_time_t) {
		this.changed_time_t = changed_time_t;
	}

	public String getCreated_by_s() {
		return created_by_s;
	}

	@XmlElement
	public void setCreated_by_s(String created_by_s) {
		this.created_by_s = created_by_s;
	}

	public Date getCreated_time_t() {
		return created_time_t;
	}

	@XmlElement
	public void setCreated_time_t(Date created_time_t) {
		this.created_time_t = created_time_t;
	}

	public Integer getEtype_i() {
		return etype_i;
	}

	@XmlElement
	public void setEtype_i(Integer etype_i) {
		this.etype_i = etype_i;
	}

	

	public String getGradecd_i() {
		return gradecd_i;
	}

	public void setGradecd_i(String gradecd_i) {
		this.gradecd_i = gradecd_i;
	}

	public Integer getIsok_i() {
		return isok_i;
	}

	@XmlElement
	public void setIsok_i(Integer isok_i) {
		this.isok_i = isok_i;
	}

	public String getItemid_s() {
		return itemid_s;
	}

	@XmlElement
	public void setItemid_s(String itemid_s) {
		this.itemid_s = itemid_s;
	}

	

	public String getProess_i() {
		return proess_i;
	}

	public void setProess_i(String proess_i) {
		this.proess_i = proess_i;
	}

	public String getRealmachinebar_s() {
		return realmachinebar_s;
	}

	@XmlElement
	public void setRealmachinebar_s(String realmachinebar_s) {
		this.realmachinebar_s = realmachinebar_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
	}

	public String getRemark_s() {
		return remark_s;
	}

	@XmlElement
	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}

	public String getSortmachinebar_s() {
		return sortmachinebar_s;
	}

	@XmlElement
	public void setSortmachinebar_s(String sortmachinebar_s) {
		this.sortmachinebar_s = sortmachinebar_s;
	}

	public Date getSorttime_t() {
		return sorttime_t;
	}

	@XmlElement
	public void setSorttime_t(Date sorttime_t) {
		this.sorttime_t = sorttime_t;
	}


	
	
	public String getSorttype_i() {
		return sorttype_i;
	}

	public void setSorttype_i(String sorttype_i) {
		this.sorttype_i = sorttype_i;
	}

	public String getSpare1_s() {
		return spare1_s;
	}

	@XmlElement
	public void setSpare1_s(String spare1_s) {
		this.spare1_s = spare1_s;
	}

	public String getSpare2_s() {
		return spare2_s;
	}

	@XmlElement
	public void setSpare2_s(String spare2_s) {
		this.spare2_s = spare2_s;
	}

	public String getSpare3_s() {
		return spare3_s;
	}

	@XmlElement
	public void setSpare3_s(String spare3_s) {
		this.spare3_s = spare3_s;
	}

	public String getSpare4_s() {
		return spare4_s;
	}

	@XmlElement
	public void setSpare4_s(String spare4_s) {
		this.spare4_s = spare4_s;
	}

	public String getSpare5_s() {
		return spare5_s;
	}

	@XmlElement
	public void setSpare5_s(String spare5_s) {
		this.spare5_s = spare5_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getWriteinremark_s() {
		return writeinremark_s;
	}

	@XmlElement
	public void setWriteinremark_s(String writeinremark_s) {
		this.writeinremark_s = writeinremark_s;
	}

	public String getWritein_s() {
		return writein_s;
	}

	@XmlElement
	public void setWritein_s(String writein_s) {
		this.writein_s = writein_s;
	}

}
