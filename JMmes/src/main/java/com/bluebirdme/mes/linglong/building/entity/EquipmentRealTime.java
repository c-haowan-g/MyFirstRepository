/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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
 * 设备报警停机实时表
 * @author 李新宇
 * @Date 2020-01-20 09:33:58
 */
@ATDefinition("B_EM_EQUIPMENTREALTIME")
@Entity
@XmlRootElement
@Table(name="AT_B_EM_EQUIPMENTREALTIME")
public class EquipmentRealTime extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("报警次数")
    @Column(nullable=true,length=0)
    private Integer alarm_count_i;
    
    @Comment("报警等级")
    @Column(nullable=true,length=80)
    private String alarm_level_s;
    
    @Comment("报警值")
    @Column(nullable=true,length=80)
    private String alarm_value_s;
    
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
    
    @Comment("报警代码")
    @Column(nullable=true,length=80)
    private String downtime_code_s;
    
    @Comment("报警内容")
    @Column(nullable=true,length=80)
    private String downtime_detail_s;
    
    @Comment("报警结束时间")
    @Column(nullable=true,length=0)
    private Date downtime_etime_t;
    
    @Comment("报警来源")
    @Column(nullable=true,length=80)
    private String downtime_source_s;
    
    @Comment("报警处理状态")
    @Column(nullable=true,length=80)
    private String downtime_status_s;
    
    @Comment("报警开始时间")
    @Column(nullable=true,length=0)
    private Date downtime_stime_t;
    
    @Comment("报警类型")
    @Column(nullable=true,length=80)
    private String downtime_type_s;
    
    @Comment("机台条码")
    @Column(nullable=false,length=80)
    private String equip_code_s;
    
    @Comment("放行人")
    @Column(nullable=true,length=80)
    private String quality_confirmor_s;
    
    @Comment("放行时间")
    @Column(nullable=true,length=0)
    private Date quality_confirmtime_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String remarks_s;
    
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
    
    @Comment("是否需要下发停机")
    @Column(nullable=true,length=80)
    private String stoporder_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("车间")
    @Column(nullable=true,length=80)
    private String workshop_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Integer getAlarm_count_i(){
        return alarm_count_i;
    }
    
    @XmlElement
    public void setAlarm_count_i(Integer alarm_count_i){
        this.alarm_count_i=alarm_count_i;
    }
        
    public String getAlarm_level_s(){
        return alarm_level_s;
    }
    
    @XmlElement
    public void setAlarm_level_s(String alarm_level_s){
        this.alarm_level_s=alarm_level_s;
    }
        
    public String getAlarm_value_s(){
        return alarm_value_s;
    }
    
    @XmlElement
    public void setAlarm_value_s(String alarm_value_s){
        this.alarm_value_s=alarm_value_s;
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
        
    public String getDowntime_code_s(){
        return downtime_code_s;
    }
    
    @XmlElement
    public void setDowntime_code_s(String downtime_code_s){
        this.downtime_code_s=downtime_code_s;
    }
        
    public String getDowntime_detail_s(){
        return downtime_detail_s;
    }
    
    @XmlElement
    public void setDowntime_detail_s(String downtime_detail_s){
        this.downtime_detail_s=downtime_detail_s;
    }
        
    public Date getDowntime_etime_t(){
        return downtime_etime_t;
    }
    
    @XmlElement
    public void setDowntime_etime_t(Date downtime_etime_t){
        this.downtime_etime_t=downtime_etime_t;
    }
        
    public String getDowntime_source_s(){
        return downtime_source_s;
    }
    
    @XmlElement
    public void setDowntime_source_s(String downtime_source_s){
        this.downtime_source_s=downtime_source_s;
    }
        
    public String getDowntime_status_s(){
        return downtime_status_s;
    }
    
    @XmlElement
    public void setDowntime_status_s(String downtime_status_s){
        this.downtime_status_s=downtime_status_s;
    }
        
    public Date getDowntime_stime_t(){
        return downtime_stime_t;
    }
    
    @XmlElement
    public void setDowntime_stime_t(Date downtime_stime_t){
        this.downtime_stime_t=downtime_stime_t;
    }
        
    public String getDowntime_type_s(){
        return downtime_type_s;
    }
    
    @XmlElement
    public void setDowntime_type_s(String downtime_type_s){
        this.downtime_type_s=downtime_type_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getQuality_confirmor_s(){
        return quality_confirmor_s;
    }
    
    @XmlElement
    public void setQuality_confirmor_s(String quality_confirmor_s){
        this.quality_confirmor_s=quality_confirmor_s;
    }
        
    public Date getQuality_confirmtime_t(){
        return quality_confirmtime_t;
    }
    
    @XmlElement
    public void setQuality_confirmtime_t(Date quality_confirmtime_t){
        this.quality_confirmtime_t=quality_confirmtime_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemarks_s(){
        return remarks_s;
    }
    
    @XmlElement
    public void setRemarks_s(String remarks_s){
        this.remarks_s=remarks_s;
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
        
    public String getStoporder_s(){
        return stoporder_s;
    }
    
    @XmlElement
    public void setStoporder_s(String stoporder_s){
        this.stoporder_s=stoporder_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getWorkshop_s(){
        return workshop_s;
    }
    
    @XmlElement
    public void setWorkshop_s(String workshop_s){
        this.workshop_s=workshop_s;
    }
        
    
    
    
}
