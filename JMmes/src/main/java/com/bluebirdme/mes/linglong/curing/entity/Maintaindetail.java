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
 * 设备维修履历
 * @author 周清玉
 * @Date 2019-09-4 09:20:07
 */
@ATDefinition("C_EM_MaintainDetail")
@Entity
@XmlRootElement
@Table(name = "AT_C_EM_MAINTAINDETAIL")
public class Maintaindetail extends RockWellBaseEntity{
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("维修开始时间")
    @Column(nullable=true,length=80)
    private String begin_time_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=100)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("维修结束时间")
    @Column(nullable=true,length=80)
    private String end_time_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=200)
    private String equip_name_s;
    
    @Comment("机台类型编码")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    @Comment("故障类型")
    @Column(nullable=true,length=80)
    private String fault_type_s;
    
    @Comment("备件信息")
    @Column(nullable=true,length=80)
    private String part_info_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("呼叫类型")
    @Column(nullable=true,length=100)
    private String repaircalltype_s;
    
    @Comment("维修方法")
    @Column(nullable=true,length=80)
    private String repick_method_s;
    
    @Comment("维修部位")
    @Column(nullable=true,length=80)
    private String repick_position_s;
    
    @Comment("维修原因")
    @Column(nullable=true,length=80)
    private String repick_reason_s;
    
    @Comment("维修结果 0-未完成 1-已完成 2-已确认")
    @Column(nullable=true,length=80)
    private String repick_result_s;
    
    @Comment("修理状态 0-呼叫中 1-维修中 2-维修完成")
    @Column(nullable=true,length=80)
    private String repick_status_s;
    
    @Comment("维修工ID")
    @Column(nullable=true,length=80)
    private String repick_worker_s;
    
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("生产线")
    @Column(nullable=true,length=80)
    private String workline_s;
    
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
        
    public String getBegin_time_s(){
        return begin_time_s;
    }
    
    @XmlElement
    public void setBegin_time_s(String begin_time_s){
        this.begin_time_s=begin_time_s;
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
        
    public String getEnd_time_s(){
        return end_time_s;
    }
    
    @XmlElement
    public void setEnd_time_s(String end_time_s){
        this.end_time_s=end_time_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public String getEquip_type_s(){
        return equip_type_s;
    }
    
    @XmlElement
    public void setEquip_type_s(String equip_type_s){
        this.equip_type_s=equip_type_s;
    }
        
    public String getFault_type_s(){
        return fault_type_s;
    }
    
    @XmlElement
    public void setFault_type_s(String fault_type_s){
        this.fault_type_s=fault_type_s;
    }
        
    public String getPart_info_s(){
        return part_info_s;
    }
    
    @XmlElement
    public void setPart_info_s(String part_info_s){
        this.part_info_s=part_info_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRepaircalltype_s(){
        return repaircalltype_s;
    }
    
    @XmlElement
    public void setRepaircalltype_s(String repaircalltype_s){
        this.repaircalltype_s=repaircalltype_s;
    }
        
    public String getRepick_method_s(){
        return repick_method_s;
    }
    
    @XmlElement
    public void setRepick_method_s(String repick_method_s){
        this.repick_method_s=repick_method_s;
    }
        
    public String getRepick_position_s(){
        return repick_position_s;
    }
    
    @XmlElement
    public void setRepick_position_s(String repick_position_s){
        this.repick_position_s=repick_position_s;
    }
        
    public String getRepick_reason_s(){
        return repick_reason_s;
    }
    
    @XmlElement
    public void setRepick_reason_s(String repick_reason_s){
        this.repick_reason_s=repick_reason_s;
    }
        
    public String getRepick_result_s(){
        return repick_result_s;
    }
    
    @XmlElement
    public void setRepick_result_s(String repick_result_s){
        this.repick_result_s=repick_result_s;
    }
        
    public String getRepick_status_s(){
        return repick_status_s;
    }
    
    @XmlElement
    public void setRepick_status_s(String repick_status_s){
        this.repick_status_s=repick_status_s;
    }
        
    public String getRepick_worker_s(){
        return repick_worker_s;
    }
    
    @XmlElement
    public void setRepick_worker_s(String repick_worker_s){
        this.repick_worker_s=repick_worker_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getWorkline_s(){
        return workline_s;
    }
    
    @XmlElement
    public void setWorkline_s(String workline_s){
        this.workline_s=workline_s;
    }
        
    public String getWorkshop_s(){
        return workshop_s;
    }
    
    @XmlElement
    public void setWorkshop_s(String workshop_s){
        this.workshop_s=workshop_s;
    }
        
    
    
    
}
