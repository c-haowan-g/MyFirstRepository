/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 生产明细查询
 * @author 周清玉
 * @Date 2018-09-10 11:45:20
 */
@ATDefinition("C_MM_WorkOrderResult")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_WorkOrderResult")
public class WorkOrderResult extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=160)
    private String agenc_no_s;
    
    @Comment("胶囊条码")
    @Column(nullable=true,length=160)
    private String capsule_id_s;
    
    @Comment("更新人编号")
    @Column(nullable=true,length=160)
    private String changed_by_s;
    
    @Comment("更新时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("硫化班次")
    @Column(nullable=true,length=160)
    private String class_id_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=160)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=11)
    private Date created_time_t;
    
    @Comment("硫化扫描时间")
    @Column(nullable=true,length=11)
    private Date curings_candate_t;
    
    @Comment("硫化合模时间")
    @Column(nullable=true,length=11)
    private Date curing_closemoulddate_t;
    
    @Comment("硫化开模时间")
    @Column(nullable=true,length=11)
    private Date curing_openmoulddate_t;
    
    @Comment("硫化工人")
    @Column(nullable=true,length=160)
    private String curing_worker_s;
    
    @Comment("DOT号")
    @Column(nullable=true,length=160)
    private String dot_s;
    
    @Comment("机台编码")
    @Column(nullable=true,length=160)
    private String equip_code_s;
    
    @Comment("硫化首罐标识")
    @Column(nullable=true,length=160)
    private String first_potflag_s;
    
    @Comment("是否有效 1:有效 0 无效")
    @Column(nullable=true,length=160)
    private String isflag_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=160)
    private String material_code_s;
    
    @Comment("规格描述")
    @Column(nullable=true,length=160)
    private String material_name_s;
    
    @Comment("备注")
    @Column(nullable=true,length=160)
    private String memo_s;
    
    @Comment("模具条码")
    @Column(nullable=true,length=160)
    private String mold_code_s;
    
    @Comment("是否补硫化 1：是 0：否")
    @Column(nullable=true,length=160)
    private String patch_curingflag_s;
    
    @Comment("工单号")
    @Column(nullable=false,length=160)
    private String plan_no_s;
    
    @Comment("生产日期")
    @Column(nullable=true,length=16)
    private String product_date_s;
    
    @Comment("质检状态")
    @Column(nullable=false,length=160)
    private String quality_status_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=160)
    private String record_flag_s;
    
    @Comment("硫化班组")
    @Column(nullable=true,length=160)
    private String shift_id_s;
    
    @Comment("固化标识 1:已固化 0或者null :未固化")
    @Column(nullable=true,length=160)
    private String solidif_yflag_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=160)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=160)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=160)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=160)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=160)
    private String spare5_s;
    
    @Comment("特殊标识")
    @Column(nullable=true,length=160)
    private String special_mark_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=160)
    private String s_factory_s;
    
    @Comment("胎号")
    @Column(nullable=true,length=160)
    private String tyreno_s;
    
    @Comment("轮胎条码")
    @Column(nullable=false,length=160)
    private String tyre_barcode_s;
    
    @Comment("单位")
    @Column(nullable=true,length=160)
    private String unit_s;
    
    @Comment("生产版本")
    @Column(nullable=true,length=160)
    private String productionver_s;
    
    @Comment("点")
    @Column(nullable=true,length=40)
    private String embryos_point_s;
    

    @Comment("是否后充气报警")
    @Column(nullable=true,length=40)
    private String ispostinflation_s;

    
    public String getIspostinflation_s() {
		return ispostinflation_s;
	}

	public void setIspostinflation_s(String ispostinflation_s) {
		this.ispostinflation_s = ispostinflation_s;
	}

    @Comment("备用字段")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备用字段")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("备用字段")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getCapsule_id_s(){
        return capsule_id_s;
    }
    
    @XmlElement
    public void setCapsule_id_s(String capsule_id_s){
        this.capsule_id_s=capsule_id_s;
    }
        
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public Date getChanged_time_t(){
        return changed_time_t;
    }
    
    @XmlElement
    public void setChanged_time_t(Date changed_time_t){
        this.changed_time_t=changed_time_t;
    }
        
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
    }
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public Date getCurings_candate_t(){
        return curings_candate_t;
    }
    
    @XmlElement
    public void setCurings_candate_t(Date curings_candate_t){
        this.curings_candate_t=curings_candate_t;
    }
        
    public Date getCuring_closemoulddate_t(){
        return curing_closemoulddate_t;
    }
    
    @XmlElement
    public void setCuring_closemoulddate_t(Date curing_closemoulddate_t){
        this.curing_closemoulddate_t=curing_closemoulddate_t;
    }
        
    public Date getCuring_openmoulddate_t(){
        return curing_openmoulddate_t;
    }
    
    @XmlElement
    public void setCuring_openmoulddate_t(Date curing_openmoulddate_t){
        this.curing_openmoulddate_t=curing_openmoulddate_t;
    }
        
    public String getCuring_worker_s(){
        return curing_worker_s;
    }
    
    @XmlElement
    public void setCuring_worker_s(String curing_worker_s){
        this.curing_worker_s=curing_worker_s;
    }
        
    public String getDot_s(){
        return dot_s;
    }
    
    @XmlElement
    public void setDot_s(String dot_s){
        this.dot_s=dot_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getFirst_potflag_s(){
        return first_potflag_s;
    }
    
    @XmlElement
    public void setFirst_potflag_s(String first_potflag_s){
        this.first_potflag_s=first_potflag_s;
    }
        
    public String getIsflag_s(){
        return isflag_s;
    }
    
    @XmlElement
    public void setIsflag_s(String isflag_s){
        this.isflag_s=isflag_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getMold_code_s(){
        return mold_code_s;
    }
    
    @XmlElement
    public void setMold_code_s(String mold_code_s){
        this.mold_code_s=mold_code_s;
    }
        
    public String getPatch_curingflag_s(){
        return patch_curingflag_s;
    }
    
    @XmlElement
    public void setPatch_curingflag_s(String patch_curingflag_s){
        this.patch_curingflag_s=patch_curingflag_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProduct_date_s(){
        return product_date_s;
    }
    
    @XmlElement
    public void setProduct_date_s(String product_date_s){
        this.product_date_s=product_date_s;
    }
        
    public String getQuality_status_s(){
        return quality_status_s;
    }
    
    @XmlElement
    public void setQuality_status_s(String quality_status_s){
        this.quality_status_s=quality_status_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getShift_id_s(){
        return shift_id_s;
    }
    
    @XmlElement
    public void setShift_id_s(String shift_id_s){
        this.shift_id_s=shift_id_s;
    }
        
    public String getSolidif_yflag_s(){
        return solidif_yflag_s;
    }
    
    @XmlElement
    public void setSolidif_yflag_s(String solidif_yflag_s){
        this.solidif_yflag_s=solidif_yflag_s;
    }
        
    public String getSpare1_s(){
        return spare1_s;
    }
    
    @XmlElement
    public void setSpare1_s(String spare1_s){
        this.spare1_s=spare1_s;
    }
        
    public String getSpare2_s(){
        return spare2_s;
    }
    
    @XmlElement
    public void setSpare2_s(String spare2_s){
        this.spare2_s=spare2_s;
    }
        
    public String getSpare3_s(){
        return spare3_s;
    }
    
    @XmlElement
    public void setSpare3_s(String spare3_s){
        this.spare3_s=spare3_s;
    }
        
    public String getSpare4_s(){
        return spare4_s;
    }
    
    @XmlElement
    public void setSpare4_s(String spare4_s){
        this.spare4_s=spare4_s;
    }
        
    public String getSpare5_s(){
        return spare5_s;
    }
    
    @XmlElement
    public void setSpare5_s(String spare5_s){
        this.spare5_s=spare5_s;
    }
        
    public String getSpecial_mark_s(){
        return special_mark_s;
    }
    
    @XmlElement
    public void setSpecial_mark_s(String special_mark_s){
        this.special_mark_s=special_mark_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyreno_s(){
        return tyreno_s;
    }
    
    @XmlElement
    public void setTyreno_s(String tyreno_s){
        this.tyreno_s=tyreno_s;
    }
        
    public String getTyre_barcode_s(){
        return tyre_barcode_s;
    }
    
    @XmlElement
    public void setTyre_barcode_s(String tyre_barcode_s){
        this.tyre_barcode_s=tyre_barcode_s;
    }
        
    public String getUnit_s(){
        return unit_s;
    }
    
    @XmlElement
    public void setUnit_s(String unit_s){
        this.unit_s=unit_s;
    }
        
    public String getProductionver_s(){
        return productionver_s;
    }
    
    @XmlElement
    public void setProductionver_s(String productionver_s){
        this.productionver_s=productionver_s;
    }
        
    public String getEmbryos_point_s(){
        return embryos_point_s;
    }
    
    @XmlElement
    public void setEmbryos_point_s(String embryos_point_s){
        this.embryos_point_s=embryos_point_s;
    }

	public String getSpare6_s() {
		return spare6_s;
	}

	public void setSpare6_s(String spare6_s) {
		this.spare6_s = spare6_s;
	}

	public String getSpare7_s() {
		return spare7_s;
	}

	public void setSpare7_s(String spare7_s) {
		this.spare7_s = spare7_s;
	}

	public String getSpare8_s() {
		return spare8_s;
	}

	public void setSpare8_s(String spare8_s) {
		this.spare8_s = spare8_s;
	}

	public String getSpare9_s() {
		return spare9_s;
	}

	public void setSpare9_s(String spare9_s) {
		this.spare9_s = spare9_s;
	}

	public String getSpare10_s() {
		return spare10_s;
	}

	public void setSpare10_s(String spare10_s) {
		this.spare10_s = spare10_s;
	}
        
    
    
    
}
