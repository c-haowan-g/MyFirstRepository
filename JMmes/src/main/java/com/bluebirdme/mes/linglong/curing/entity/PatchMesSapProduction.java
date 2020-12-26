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
 * 产量固化与SAP抛帐
 *
 * @author 刘朋
 * @Date 2019-8-026
 */
@ATDefinition("INT_SAP_MesSapProduction")
@Entity
@XmlRootElement
@Table(name = "AT_INT_SAP_MesSapProduction")
public class PatchMesSapProduction extends RockWellBaseEntity {

    @Comment("实际固化数量")
    @Column(nullable = true, length = 0)
    private String actual_quantity_f;

    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable = true, length = 80)
    private String agenc_no_s;

    @Comment("上传批次号")
    @Column(nullable = true, length = 80)
    private String batch_id_s;

    @Comment("产品下线批次（当前年份，过账日期前4位）")
    @Column(nullable = true, length = 80)
    private String batch_s;

    @Comment("BOI标示（1：一期，2：二期，0：国内）")
    @Column(nullable = true, length = 80)
    private String boi_flag_s;

    @Comment("班次")
    @Column(nullable = true, length = 80)
    private String class_id_s;

    @Comment("同过账日期")
    @Column(nullable = true, length = 80)
    private String doc_date_s;

    @Comment("字段1")
    @Column(nullable = true, length = 80)
    private String dummy1_s;

    @Comment("字段2")
    @Column(nullable = true, length = 80)
    private String dummy2_s;

    @Comment("字段3")
    @Column(nullable = true, length = 80)
    private String dummy3_s;

    @Comment("字段4")
    @Column(nullable = true, length = 80)
    private String dummy4_s;

    @Comment("凭证抬头文本")
    @Column(nullable = true, length = 100)
    private String headtxt_s;

    @Comment("物料编码（18位）")
    @Column(nullable = true, length = 80)
    private String material_code_s;

    @Comment("物料名称")
    @Column(nullable = true, length = 200)
    private String material_name_s;

    @Comment("备注")
    @Column(nullable = true, length = 200)
    private String memo_s;

    @Comment("操作时间")
    @Column(nullable = true, length = 80)
    private String operate_time_s;

    @Comment("操作工编号")
    @Column(nullable = true, length = 80)
    private String operate_userid_s;

    @Comment("操作工姓名")
    @Column(nullable = true, length = 80)
    private String operate_usernane_s;

    @Comment("工厂号")
    @Column(nullable = true, length = 100)
    private String plant_s;

    @Comment("过账日期（默认当前日期YYYYMMDD 月底最后一天16点之后跨天）")
    @Column(nullable = true, length = 80)
    private String post_date_s;

    @Comment("报工工序")
    @Column(nullable = true, length = 80)
    private String process_s;

    @Comment("报产方式（01：报产，02：冲产）")
    @Column(nullable = true, length = 80)
    private String product_type_s;

    @Comment("生产版本")
    @Column(nullable = true, length = 100)
    private String pro_version_s;

    @Comment("实际数量")
    @Column(nullable = true, length = 0)
    private String quantity_f;

    @Comment("记录标志,A可用，D删除")
    @Column(nullable = true, length = 80)
    private String record_flag_s;

    @Comment("记录标示（0:未上传SAP；1：已上传未返回结果；2：SAP返回OK；3：SAP返回NG)")
    @Column(nullable = true, length = 80)
    private String record_sap_flag_s;

    @Comment("冲销标识")
    @Column(nullable = true, length = 80)
    private String reverser_flag_s;

    @Comment("无注释")
    @Column(nullable = true, length = 80)
    private String rush_quantity_s;

    @Comment("记录一下物料编码80位的")
    @Column(nullable = true, length = 80)
    private String rush_serid_s;

    @Comment("无注释")
    @Column(nullable = true, length = 0)
    private Date rush_time_t;

    @Comment("无注释")
    @Column(nullable = true, length = 80)
    private String rush_userid_s;

    @Comment("LZMES+YYYYmmdd+类型 （01/02）+4 位流水号")
    @Column(nullable = true, length = 80)
    private String serid_s;

    @Comment("固化标识(0 未固化 1 固化)")
    @Column(nullable = true, length = 80)
    private String solid_flag_s;

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

    @Comment("下线库位")
    @Column(nullable = true, length = 80)
    private String storage_loc_s;

    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable = false, length = 80)
    private String s_factory_s;

    @Comment("上传次数")
    @Column(nullable = true, length = 80)
    private String upload_num_s;

    @Comment("上传时间")
    @Column(nullable = true, length = 0)
    private Date upload_time_t;

    @Comment("上传人")
    @Column(nullable = true, length = 80)
    private String upload_userid_s;

    public String getActual_quantity_f() {
        return actual_quantity_f;
    }

    @XmlElement
    public void setActual_quantity_f(String actual_quantity_f) {
        this.actual_quantity_f = actual_quantity_f;
    }

    public String getAgenc_no_s() {
        return agenc_no_s;
    }

    @XmlElement
    public void setAgenc_no_s(String agenc_no_s) {
        this.agenc_no_s = agenc_no_s;
    }

    public String getBatch_id_s() {
        return batch_id_s;
    }

    @XmlElement
    public void setBatch_id_s(String batch_id_s) {
        this.batch_id_s = batch_id_s;
    }

    public String getBatch_s() {
        return batch_s;
    }

    @XmlElement
    public void setBatch_s(String batch_s) {
        this.batch_s = batch_s;
    }

    public String getBoi_flag_s() {
        return boi_flag_s;
    }

    @XmlElement
    public void setBoi_flag_s(String boi_flag_s) {
        this.boi_flag_s = boi_flag_s;
    }

    public String getClass_id_s() {
        return class_id_s;
    }

    @XmlElement
    public void setClass_id_s(String class_id_s) {
        this.class_id_s = class_id_s;
    }

    public String getDoc_date_s() {
        return doc_date_s;
    }

    @XmlElement
    public void setDoc_date_s(String doc_date_s) {
        this.doc_date_s = doc_date_s;
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

    public String getHeadtxt_s() {
        return headtxt_s;
    }

    @XmlElement
    public void setHeadtxt_s(String headtxt_s) {
        this.headtxt_s = headtxt_s;
    }

    public String getMaterial_code_s() {
        return material_code_s;
    }

    @XmlElement
    public void setMaterial_code_s(String material_code_s) {
        this.material_code_s = material_code_s;
    }

    public String getMaterial_name_s() {
        return material_name_s;
    }

    @XmlElement
    public void setMaterial_name_s(String material_name_s) {
        this.material_name_s = material_name_s;
    }

    public String getMemo_s() {
        return memo_s;
    }

    @XmlElement
    public void setMemo_s(String memo_s) {
        this.memo_s = memo_s;
    }

    public String getOperate_time_s() {
        return operate_time_s;
    }

    @XmlElement
    public void setOperate_time_s(String operate_time_s) {
        this.operate_time_s = operate_time_s;
    }

    public String getOperate_userid_s() {
        return operate_userid_s;
    }

    @XmlElement
    public void setOperate_userid_s(String operate_userid_s) {
        this.operate_userid_s = operate_userid_s;
    }

    public String getOperate_usernane_s() {
        return operate_usernane_s;
    }

    @XmlElement
    public void setOperate_usernane_s(String operate_usernane_s) {
        this.operate_usernane_s = operate_usernane_s;
    }

    public String getPlant_s() {
        return plant_s;
    }

    @XmlElement
    public void setPlant_s(String plant_s) {
        this.plant_s = plant_s;
    }

    public String getPost_date_s() {
        return post_date_s;
    }

    @XmlElement
    public void setPost_date_s(String post_date_s) {
        this.post_date_s = post_date_s;
    }

    public String getProcess_s() {
        return process_s;
    }

    @XmlElement
    public void setProcess_s(String process_s) {
        this.process_s = process_s;
    }

    public String getProduct_type_s() {
        return product_type_s;
    }

    @XmlElement
    public void setProduct_type_s(String product_type_s) {
        this.product_type_s = product_type_s;
    }

    public String getPro_version_s() {
        return pro_version_s;
    }

    @XmlElement
    public void setPro_version_s(String pro_version_s) {
        this.pro_version_s = pro_version_s;
    }

    public String getQuantity_f() {
        return quantity_f;
    }

    @XmlElement
    public void setQuantity_f(String quantity_f) {
        this.quantity_f = quantity_f;
    }

    public String getRecord_flag_s() {
        return record_flag_s;
    }

    @XmlElement
    public void setRecord_flag_s(String record_flag_s) {
        this.record_flag_s = record_flag_s;
    }

    public String getRecord_sap_flag_s() {
        return record_sap_flag_s;
    }

    @XmlElement
    public void setRecord_sap_flag_s(String record_sap_flag_s) {
        this.record_sap_flag_s = record_sap_flag_s;
    }

    public String getReverser_flag_s() {
        return reverser_flag_s;
    }

    @XmlElement
    public void setReverser_flag_s(String reverser_flag_s) {
        this.reverser_flag_s = reverser_flag_s;
    }

    public String getRush_quantity_s() {
        return rush_quantity_s;
    }

    @XmlElement
    public void setRush_quantity_s(String rush_quantity_s) {
        this.rush_quantity_s = rush_quantity_s;
    }

    public String getRush_serid_s() {
        return rush_serid_s;
    }

    @XmlElement
    public void setRush_serid_s(String rush_serid_s) {
        this.rush_serid_s = rush_serid_s;
    }

    public Date getRush_time_t() {
        return rush_time_t;
    }

    @XmlElement
    public void setRush_time_t(Date rush_time_t) {
        this.rush_time_t = rush_time_t;
    }

    public String getRush_userid_s() {
        return rush_userid_s;
    }

    @XmlElement
    public void setRush_userid_s(String rush_userid_s) {
        this.rush_userid_s = rush_userid_s;
    }

    public String getSerid_s() {
        return serid_s;
    }

    @XmlElement
    public void setSerid_s(String serid_s) {
        this.serid_s = serid_s;
    }

    public String getSolid_flag_s() {
        return solid_flag_s;
    }

    @XmlElement
    public void setSolid_flag_s(String solid_flag_s) {
        this.solid_flag_s = solid_flag_s;
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

    public String getStorage_loc_s() {
        return storage_loc_s;
    }

    @XmlElement
    public void setStorage_loc_s(String storage_loc_s) {
        this.storage_loc_s = storage_loc_s;
    }

    public String getS_factory_s() {
        return s_factory_s;
    }

    @XmlElement
    public void setS_factory_s(String s_factory_s) {
        this.s_factory_s = s_factory_s;
    }

    public String getUpload_num_s() {
        return upload_num_s;
    }

    @XmlElement
    public void setUpload_num_s(String upload_num_s) {
        this.upload_num_s = upload_num_s;
    }

    public Date getUpload_time_t() {
        return upload_time_t;
    }

    @XmlElement
    public void setUpload_time_t(Date upload_time_t) {
        this.upload_time_t = upload_time_t;
    }

    public String getUpload_userid_s() {
        return upload_userid_s;
    }

    @XmlElement
    public void setUpload_userid_s(String upload_userid_s) {
        this.upload_userid_s = upload_userid_s;
    }

}
