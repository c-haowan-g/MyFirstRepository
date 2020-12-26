/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 设备报警信息表
 * @author 边朝会
 * @Date 2020-08-08 11:20:06
 */
@ATDefinition("MX_MM_ALARM")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_ALARM")
public class MixAlarmData extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("报警编码")
    @Column(nullable=true,length=40)
    private String alarm_code_s;
    
    @Comment("报警内容")
    @Column(nullable=true,length=2)
    private String alarm_comments_s;
    
    @Comment("报警ID：GUID")
    @Column(nullable=true,length=80)
    private String alarm_id_s;
    
    @Comment("报警名称")
    @Column(nullable=true,length=200)
    private String alarm_name_s;
    
    @Comment("报警位置")
    @Column(nullable=true,length=200)
    private String alarm_position_s;
    
    @Comment("报警时间（报警开始时间、解除报警时间）")
    @Column(nullable=true,length=80)
    private String alarm_time_s;
    
    @Comment("触发类型")
    @Column(nullable=true,length=20)
    private String alarm_triangletype_s;
    
    @Comment("报警类型：059001-机械故障、059002-控制系统故障、059003-通讯故障、059004-安全报警、059005-接收异常")
    @Column(nullable=true,length=40)
    private String alarm_type_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("设备编号（可区分不同设备）")
    @Column(nullable=true,length=80)
    private String machine_code_s;
    
    @Comment("设备名称")
    @Column(nullable=true,length=80)
    private String machine_name_s;
    
    @Comment("接收备注")
    @Column(nullable=true,length=2)
    private String receive_remark_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("备用1")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用2：当前机台IP")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用3：生产日期：yyyyMMdd")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用4：生产班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("工厂代码（1.全钢，2.半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlarm_code_s(){
        return alarm_code_s;
    }
    
    @XmlElement
    public void setAlarm_code_s(String alarm_code_s){
        this.alarm_code_s=alarm_code_s;
    }
        
    public String getAlarm_comments_s(){
        return alarm_comments_s;
    }
    
    @XmlElement
    public void setAlarm_comments_s(String alarm_comments_s){
        this.alarm_comments_s=alarm_comments_s;
    }
        
    public String getAlarm_id_s(){
        return alarm_id_s;
    }
    
    @XmlElement
    public void setAlarm_id_s(String alarm_id_s){
        this.alarm_id_s=alarm_id_s;
    }
        
    public String getAlarm_name_s(){
        return alarm_name_s;
    }
    
    @XmlElement
    public void setAlarm_name_s(String alarm_name_s){
        this.alarm_name_s=alarm_name_s;
    }
        
    public String getAlarm_position_s(){
        return alarm_position_s;
    }
    
    @XmlElement
    public void setAlarm_position_s(String alarm_position_s){
        this.alarm_position_s=alarm_position_s;
    }
        
    public String getAlarm_time_s(){
        return alarm_time_s;
    }
    
    @XmlElement
    public void setAlarm_time_s(String alarm_time_s){
        this.alarm_time_s=alarm_time_s;
    }
        
    public String getAlarm_triangletype_s(){
        return alarm_triangletype_s;
    }
    
    @XmlElement
    public void setAlarm_triangletype_s(String alarm_triangletype_s){
        this.alarm_triangletype_s=alarm_triangletype_s;
    }
        
    public String getAlarm_type_s(){
        return alarm_type_s;
    }
    
    @XmlElement
    public void setAlarm_type_s(String alarm_type_s){
        this.alarm_type_s=alarm_type_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public String getChanged_name_s(){
        return changed_name_s;
    }
    
    @XmlElement
    public void setChanged_name_s(String changed_name_s){
        this.changed_name_s=changed_name_s;
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
        
    public String getCreated_name_s(){
        return created_name_s;
    }
    
    @XmlElement
    public void setCreated_name_s(String created_name_s){
        this.created_name_s=created_name_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDatasource_s(){
        return datasource_s;
    }
    
    @XmlElement
    public void setDatasource_s(String datasource_s){
        this.datasource_s=datasource_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getMachine_code_s(){
        return machine_code_s;
    }
    
    @XmlElement
    public void setMachine_code_s(String machine_code_s){
        this.machine_code_s=machine_code_s;
    }
        
    public String getMachine_name_s(){
        return machine_name_s;
    }
    
    @XmlElement
    public void setMachine_name_s(String machine_name_s){
        this.machine_name_s=machine_name_s;
    }
        
    public String getReceive_remark_s(){
        return receive_remark_s;
    }
    
    @XmlElement
    public void setReceive_remark_s(String receive_remark_s){
        this.receive_remark_s=receive_remark_s;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    
    
    
}
