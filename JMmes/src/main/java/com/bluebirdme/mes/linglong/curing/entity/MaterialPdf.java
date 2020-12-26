/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 模具标识图维护
 * 
 * @author 周清玉
 * @Date 2018-08-20 13:57:26
 */
@ATDefinition("C_QM_MaterialPdf")
@Entity
@XmlRootElement
@Table(name = "AT_C_QM_MATERIALPDF")
public class MaterialPdf extends RockWellBaseEntity {

	@Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
	@Column(nullable = true, length = 160)
	private String agenc_no_s;

	@Comment("更新人")
	@Column(nullable = true, length = 160)
	private String changed_by_s;

	@Comment("更新时间")
	@Column(nullable = true, length = 11)
	private Date changed_time_t;

	@Comment("创建人")
	@Column(nullable = false, length = 160)
	private String created_by_s;

	@Comment("创建时间")
	@Column(nullable = false, length = 11)
	private Date created_time_t;

	@Comment("类型编号")
	@Column(nullable = true, length = 160)
	private String file_type_s;

	@Comment("有效标志")
	@Column(nullable = true, length = 160)
	private String is_flag_s;

	@Comment("物料编号")
	@Column(nullable = true, length = 160)
	private String material_code_s;

	@Comment("pdf系统文件名称")
	@Column(nullable = true, length = 160)
	private String pdf_name_final_s;

	@Comment("原始PDF名称")
	@Column(nullable = true, length = 160)
	private String pdf_name_original_s;

	@Comment("记录标志，A可用，D删除")
	@Column(nullable = true, length = 160)
	private String record_flag_s;

	@Comment("备用字段1")
	@Column(nullable = true, length = 160)
	private String spare1_s;

	@Comment("备用字段2")
	@Column(nullable = true, length = 160)
	private String spare2_s;

	@Comment("备用字段3")
	@Column(nullable = true, length = 160)
	private String spare3_s;

	@Comment("备用字段4")
	@Column(nullable = true, length = 160)
	private String spare4_s;

	@Comment("备用字段5")
	@Column(nullable = true, length = 160)
	private String spare5_s;

	@Comment("存放路径")
	@Column(nullable = true, length = 320)
	private String storage_path_s;

	@Comment("工厂（1全钢 2半钢）")
	@Column(nullable = false, length = 160)
	private String s_factory_s;

	@Comment("上传人")
	@Column(nullable = true, length = 160)
	private String uploader_s;

	@Comment("上传时间")
	@Column(nullable = true, length = 11)
	private Date upload_time_t;

	@Comment("当前版本号")
	@Column(nullable = true, length = 160)
	private String vision_s;

	@Comment("CHANGED_TIME_U")
	@Column(nullable = true, length = 11)
	private Date changed_time_u;

	@Comment("CREATED_TIME_U")
	@Column(nullable = true, length = 11)
	private Date created_time_u;

	@Comment("UPLOAD_TIME_U")
	@Column(nullable = true, length = 11)
	private Date upload_time_u;

	@Comment("CREATED_TIME_Z")
	@Column(nullable = true, length = 128)
	private String created_time_z;

	@Comment("UPLOAD_TIME_Z")
	@Column(nullable = true, length = 128)
	private String upload_time_z;

	@Comment("CHANGED_TIME_Z")
	@Column(nullable = true, length = 128)
	private String changed_time_z;

	public String getAgenc_no_s() {
		return agenc_no_s;
	}

	@XmlElement
	public void setAgenc_no_s(String agenc_no_s) {
		this.agenc_no_s = agenc_no_s;
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

	public String getFile_type_s() {
		return file_type_s;
	}

	@XmlElement
	public void setFile_type_s(String file_type_s) {
		this.file_type_s = file_type_s;
	}

	public String getIs_flag_s() {
		return is_flag_s;
	}

	@XmlElement
	public void setIs_flag_s(String is_flag_s) {
		this.is_flag_s = is_flag_s;
	}

	public String getMaterial_code_s() {
		return material_code_s;
	}

	@XmlElement
	public void setMaterial_code_s(String material_code_s) {
		this.material_code_s = material_code_s;
	}

	public String getPdf_name_final_s() {
		return pdf_name_final_s;
	}

	@XmlElement
	public void setPdf_name_final_s(String pdf_name_final_s) {
		this.pdf_name_final_s = pdf_name_final_s;
	}

	public String getPdf_name_original_s() {
		return pdf_name_original_s;
	}

	@XmlElement
	public void setPdf_name_original_s(String pdf_name_original_s) {
		this.pdf_name_original_s = pdf_name_original_s;
	}

	public String getRecord_flag_s() {
		return record_flag_s;
	}

	@XmlElement
	public void setRecord_flag_s(String record_flag_s) {
		this.record_flag_s = record_flag_s;
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

	public String getStorage_path_s() {
		return storage_path_s;
	}

	@XmlElement
	public void setStorage_path_s(String storage_path_s) {
		this.storage_path_s = storage_path_s;
	}

	public String getS_factory_s() {
		return s_factory_s;
	}

	@XmlElement
	public void setS_factory_s(String s_factory_s) {
		this.s_factory_s = s_factory_s;
	}

	public String getUploader_s() {
		return uploader_s;
	}

	@XmlElement
	public void setUploader_s(String uploader_s) {
		this.uploader_s = uploader_s;
	}

	public Date getUpload_time_t() {
		return upload_time_t;
	}

	@XmlElement
	public void setUpload_time_t(Date upload_time_t) {
		this.upload_time_t = upload_time_t;
	}

	public String getVision_s() {
		return vision_s;
	}

	@XmlElement
	public void setVision_s(String vision_s) {
		this.vision_s = vision_s;
	}

	public Date getChanged_time_u() {
		return changed_time_u;
	}

	@XmlElement
	public void setChanged_time_u(Date changed_time_u) {
		this.changed_time_u = changed_time_u;
	}

	public Date getCreated_time_u() {
		return created_time_u;
	}

	@XmlElement
	public void setCreated_time_u(Date created_time_u) {
		this.created_time_u = created_time_u;
	}

	public Date getUpload_time_u() {
		return upload_time_u;
	}

	@XmlElement
	public void setUpload_time_u(Date upload_time_u) {
		this.upload_time_u = upload_time_u;
	}

	public String getCreated_time_z() {
		return created_time_z;
	}

	@XmlElement
	public void setCreated_time_z(String created_time_z) {
		this.created_time_z = created_time_z;
	}

	public String getUpload_time_z() {
		return upload_time_z;
	}

	@XmlElement
	public void setUpload_time_z(String upload_time_z) {
		this.upload_time_z = upload_time_z;
	}

	public String getChanged_time_z() {
		return changed_time_z;
	}

	@XmlElement
	public void setChanged_time_z(String changed_time_z) {
		this.changed_time_z = changed_time_z;
	}

}
