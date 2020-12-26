/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.constant.Lang;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

/**
 * 数据字典表
 * 
 * @author 高飞
 * @Date 2018-08-08 13:40:24
 */
@ATDefinition("CM_BS_COREDICTIONARY")
@Entity
@XmlRootElement
@Table(name = "AT_CM_BS_COREDICTIONARY")
public class CoreDictionary extends RockWellBaseEntity {

	@Comment("更新人")
	@Column(nullable = true, length = 80)
	private String changed_by_s;

	@Comment("更新时间")
	@Column(nullable = true, length = 0)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = false, length = 80)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = false, length = 0)
	private Date created_time_t;

	@Comment("0：正常，1：删除")
	@Column(nullable = true, length = 0)
	private Integer deleted_i;

	@Comment("字典代码")
	@Column(nullable = true, length = 255)
	private String dictcode_s;

	@Comment("字典描述")
	@Column(nullable = true, length = 255)
	private String dictdesc_s;

	@Comment("字典英文名称")
	@Column(nullable = true, length = 255)
	private String dictname_en_s;

	@Comment("字典名称")
	@Column(nullable = true, length = 255)
	private String dictname_s;

	@Comment("字典泰语名称")
	@Column(nullable = true, length = 255)
	private String dictname_th_s;

	@Comment(" ")
	@Column(nullable = true, length = 255)
	private String erpcode_s;

	@Comment(" ")
	@Column(nullable = true, length = 0)
	private Long pid_i;

	@Comment(" ")
	@Column(nullable = true, length = 0)
	private Integer sortno_i;

	@Comment(" ")
	@Column(nullable = true, length = 0)
	private Integer typeid_i;

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

	public Integer getDeleted_i() {
		return deleted_i;
	}

	@XmlElement
	public void setDeleted_i(Integer deleted_i) {
		this.deleted_i = deleted_i;
	}

	public String getDictcode_s() {
		return dictcode_s;
	}

	@XmlElement
	public void setDictcode_s(String dictcode_s) {
		this.dictcode_s = dictcode_s;
	}

	public String getDictdesc_s() {
		return dictdesc_s;
	}

	@XmlElement
	public void setDictdesc_s(String dictdesc_s) {
		this.dictdesc_s = dictdesc_s;
	}

	public String getDictname_en_s() {
		return dictname_en_s;
	}

	@XmlElement
	public void setDictname_en_s(String dictname_en_s) {
		this.dictname_en_s = dictname_en_s;
	}

	public String getDictname_s() {
		return dictname_s;
	}

	@XmlElement
	public void setDictname_s(String dictname_s) {
		this.dictname_s = dictname_s;
	}

	public String getDictname_th_s() {
		return dictname_th_s;
	}

	@XmlElement
	public void setDictname_th_s(String dictname_th_s) {
		this.dictname_th_s = dictname_th_s;
	}

	public String getErpcode_s() {
		return erpcode_s;
	}

	@XmlElement
	public void setErpcode_s(String erpcode_s) {
		this.erpcode_s = erpcode_s;
	}

	public Long getPid_i() {
		return pid_i;
	}

	@XmlElement
	public void setPid_i(Long pid_i) {
		this.pid_i = pid_i;
	}

	public Integer getSortno_i() {
		return sortno_i;
	}

	@XmlElement
	public void setSortno_i(Integer sortno_i) {
		this.sortno_i = sortno_i;
	}

	public Integer getTypeid_i() {
		return typeid_i;
	}

	@XmlElement
	public void setTypeid_i(Integer typeid_i) {
		this.typeid_i = typeid_i;
	}

	public String getText(String language) {

		switch (language) {
		case Lang.EN:

			return dictname_en_s;
		case Lang.TH:
			return dictname_th_s;

		default:
			return dictname_s;

		}
	}
	
	public String getText() {
		String language=LanguageProvider.getLanguage();
		switch (language) {
		case Lang.EN:

			return dictname_en_s;
		case Lang.TH:
			return dictname_th_s;

		default:
			return dictname_s;

		}
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(sdf.format(new Date()));
	}

}
