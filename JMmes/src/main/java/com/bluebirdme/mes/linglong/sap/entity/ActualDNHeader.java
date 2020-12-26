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
 * 成品发货主表
 * @author 周清玉
 * @Date 2018-12-20 18:57:29
 */
@ATDefinition("INT_SAP_ActualDNHeader")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_ACTUALDNHEADER")
public class ActualDNHeader extends RockWellBaseEntity{
    
    
    @Comment("机构编号")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("质量等级（批次）")
    @Column(nullable=true,length=80)
    private String batch_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("实际出库日期")
    @Column(nullable=true,length=80)
    private String deliverydate_s;
    
    @Comment("是否汇总到接口标识")
    @Column(nullable=true,length=80)
    private String flag_s;
    
    @Comment("客户编码（售达方")
    @Column(nullable=true,length=80)
    private String kunag_s;
    
    @Comment("发货单行项目编号")
    @Column(nullable=true,length=80)
    private String lineitemno_s;
    
    @Comment("物料号")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("客户名称")
    @Column(nullable=true,length=80)
    private String name_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=80)
    private String plant_s;
    
    @Comment("发货数量")
    @Column(nullable=true,length=0)
    private String qty_d;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("发货单号")
    @Column(nullable=true,length=80)
    private String snno_s;
    
    @Comment("发货单状态")
    @Column(nullable=true,length=80)
    private String snno_status_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("退货标识")
    @Column(nullable=true,length=80)
    private String srflag_s;
    
    @Comment("库位")
    @Column(nullable=true,length=80)
    private String storageloc_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getBatch_s(){
        return batch_s;
    }
    
    @XmlElement
    public void setBatch_s(String batch_s){
        this.batch_s=batch_s;
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
        
    public String getDeliverydate_s(){
        return deliverydate_s;
    }
    
    @XmlElement
    public void setDeliverydate_s(String deliverydate_s){
        this.deliverydate_s=deliverydate_s;
    }
        
    public String getFlag_s(){
        return flag_s;
    }
    
    @XmlElement
    public void setFlag_s(String flag_s){
        this.flag_s=flag_s;
    }
        
    public String getKunag_s(){
        return kunag_s;
    }
    
    @XmlElement
    public void setKunag_s(String kunag_s){
        this.kunag_s=kunag_s;
    }
        
    public String getLineitemno_s(){
        return lineitemno_s;
    }
    
    @XmlElement
    public void setLineitemno_s(String lineitemno_s){
        this.lineitemno_s=lineitemno_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getName_s(){
        return name_s;
    }
    
    @XmlElement
    public void setName_s(String name_s){
        this.name_s=name_s;
    }
        
    public String getPlant_s(){
        return plant_s;
    }
    
    @XmlElement
    public void setPlant_s(String plant_s){
        this.plant_s=plant_s;
    }
        
    public String getQty_d(){
        return qty_d;
    }
    
    @XmlElement
    public void setQty_d(String qty_d){
        this.qty_d=qty_d;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSnno_s(){
        return snno_s;
    }
    
    @XmlElement
    public void setSnno_s(String snno_s){
        this.snno_s=snno_s;
    }
        
    public String getSnno_status_s(){
        return snno_status_s;
    }
    
    @XmlElement
    public void setSnno_status_s(String snno_status_s){
        this.snno_status_s=snno_status_s;
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
        
    public String getSrflag_s(){
        return srflag_s;
    }
    
    @XmlElement
    public void setSrflag_s(String srflag_s){
        this.srflag_s=srflag_s;
    }
        
    public String getStorageloc_s(){
        return storageloc_s;
    }
    
    @XmlElement
    public void setStorageloc_s(String storageloc_s){
        this.storageloc_s=storageloc_s;
    }
        
    
    
    
}
