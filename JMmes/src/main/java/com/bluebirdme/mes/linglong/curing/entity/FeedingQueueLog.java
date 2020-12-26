/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 硫化扫描日志
 * @author 李新宇
 * @Date 2020-02-20 15:23:30
 */
@ATDefinition("C_MM_FEEDING_QUEUE_LOG")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_FEEDING_QUEUE_LOG")
public class FeedingQueueLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004 荆门8023 ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("更新人编号_BY")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("更新时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人编号")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;

    @Comment("投料人")
    @Column(nullable=true,length=80)
    private String product_operator_s;
    
    @Comment("队列ID")
    @Column(nullable=true,length=80)
    private String queue_id_s;
    
    @Comment("记录标志")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("投料时间")
    @Column(nullable=true,length=0)
    private Date scanning_time_t;
    
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
    
    @Comment("执行开始时间")
    @Column(nullable=true,length=0)
    private Date start_time_t;
    
    @Comment("状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("胎胚条码")
    @Column(nullable=true,length=80)
    private String tyrebar_code_s;

    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
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

    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getProduct_operator_s(){
        return product_operator_s;
    }
    
    @XmlElement
    public void setProduct_operator_s(String product_operator_s){
        this.product_operator_s=product_operator_s;
    }
        
    public String getQueue_id_s(){
        return queue_id_s;
    }
    
    @XmlElement
    public void setQueue_id_s(String queue_id_s){
        this.queue_id_s=queue_id_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public Date getScanning_time_t(){
        return scanning_time_t;
    }
    
    @XmlElement
    public void setScanning_time_t(Date scanning_time_t){
        this.scanning_time_t=scanning_time_t;
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
        
    public Date getStart_time_t(){
        return start_time_t;
    }
    
    @XmlElement
    public void setStart_time_t(Date start_time_t){
        this.start_time_t=start_time_t;
    }
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getTyrebar_code_s(){
        return tyrebar_code_s;
    }
    
    @XmlElement
    public void setTyrebar_code_s(String tyrebar_code_s){
        this.tyrebar_code_s=tyrebar_code_s;
    }
        
    
    
    
}
