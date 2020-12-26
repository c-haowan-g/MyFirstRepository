/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 半部件信息修正履历
 * @author 葛迎祥
 * @Date 2020-12-23 13:55:16
 */
@ATDefinition("A_MM_UPDATEINFO")
@Entity
@XmlRootElement
@Table(name="AT_A_MM_UPDATEINFO")
public class UpdateInfo extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String ageno_no_s;
    
    @Comment("批次条码")
    @Column(nullable=true,length=80)
    private String batchcode_s;
    
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
    
    @Comment("部件名称")
    @Column(nullable=true,length=80)
    private String halfpartspec_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("新工装条码")
    @Column(nullable=true,length=80)
    private String newbarcode_s;
    
    @Comment("新数量")
    @Column(nullable=true,length=80)
    private String newnumber_s;
    
    @Comment("原工装条码")
    @Column(nullable=true,length=80)
    private String oldbarcode_s;
    
    @Comment("原数量")
    @Column(nullable=true,length=80)
    private String oldnumber_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("规格名称")
    @Column(nullable=true,length=80)
    private String repairitem_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare_10_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String spare_1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String spare_2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spare_3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare_4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare_5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String spare_6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spare_7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spare_8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spare_9_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    public String getAgeno_no_s(){
        return ageno_no_s;
    }
    
    @XmlElement
    public void setAgeno_no_s(String ageno_no_s){
        this.ageno_no_s=ageno_no_s;
    }
        
    public String getBatchcode_s(){
        return batchcode_s;
    }
    
    @XmlElement
    public void setBatchcode_s(String batchcode_s){
        this.batchcode_s=batchcode_s;
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
        
    public String getHalfpartspec_s(){
        return halfpartspec_s;
    }
    
    @XmlElement
    public void setHalfpartspec_s(String halfpartspec_s){
        this.halfpartspec_s=halfpartspec_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getNewbarcode_s(){
        return newbarcode_s;
    }
    
    @XmlElement
    public void setNewbarcode_s(String newbarcode_s){
        this.newbarcode_s=newbarcode_s;
    }
        
    public String getNewnumber_s(){
        return newnumber_s;
    }
    
    @XmlElement
    public void setNewnumber_s(String newnumber_s){
        this.newnumber_s=newnumber_s;
    }
        
    public String getOldbarcode_s(){
        return oldbarcode_s;
    }
    
    @XmlElement
    public void setOldbarcode_s(String oldbarcode_s){
        this.oldbarcode_s=oldbarcode_s;
    }
        
    public String getOldnumber_s(){
        return oldnumber_s;
    }
    
    @XmlElement
    public void setOldnumber_s(String oldnumber_s){
        this.oldnumber_s=oldnumber_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRepairitem_s(){
        return repairitem_s;
    }
    
    @XmlElement
    public void setRepairitem_s(String repairitem_s){
        this.repairitem_s=repairitem_s;
    }
        
    public String getSpare_10_s(){
        return spare_10_s;
    }
    
    @XmlElement
    public void setSpare_10_s(String spare_10_s){
        this.spare_10_s=spare_10_s;
    }
        
    public String getSpare_1_s(){
        return spare_1_s;
    }
    
    @XmlElement
    public void setSpare_1_s(String spare_1_s){
        this.spare_1_s=spare_1_s;
    }
        
    public String getSpare_2_s(){
        return spare_2_s;
    }
    
    @XmlElement
    public void setSpare_2_s(String spare_2_s){
        this.spare_2_s=spare_2_s;
    }
        
    public String getSpare_3_s(){
        return spare_3_s;
    }
    
    @XmlElement
    public void setSpare_3_s(String spare_3_s){
        this.spare_3_s=spare_3_s;
    }
        
    public String getSpare_4_s(){
        return spare_4_s;
    }
    
    @XmlElement
    public void setSpare_4_s(String spare_4_s){
        this.spare_4_s=spare_4_s;
    }
        
    public String getSpare_5_s(){
        return spare_5_s;
    }
    
    @XmlElement
    public void setSpare_5_s(String spare_5_s){
        this.spare_5_s=spare_5_s;
    }
        
    public String getSpare_6_s(){
        return spare_6_s;
    }
    
    @XmlElement
    public void setSpare_6_s(String spare_6_s){
        this.spare_6_s=spare_6_s;
    }
        
    public String getSpare_7_s(){
        return spare_7_s;
    }
    
    @XmlElement
    public void setSpare_7_s(String spare_7_s){
        this.spare_7_s=spare_7_s;
    }
        
    public String getSpare_8_s(){
        return spare_8_s;
    }
    
    @XmlElement
    public void setSpare_8_s(String spare_8_s){
        this.spare_8_s=spare_8_s;
    }
        
    public String getSpare_9_s(){
        return spare_9_s;
    }
    
    @XmlElement
    public void setSpare_9_s(String spare_9_s){
        this.spare_9_s=spare_9_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
