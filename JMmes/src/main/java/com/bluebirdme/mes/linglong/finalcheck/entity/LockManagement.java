/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * 轮胎锁定信息管理表
 * @author 陈国强
 * @Date 2020-12-01 14:24:14
 */
@ATDefinition("D_QM_LOCK_MANAGEMENT")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_LOCK_MANAGEMENT")
public class LockManagement extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("向后锁定数量")
    @Column(nullable=true,length=80)
    private String b_lock_num_s;
    
    @Comment("向后废品数量")
    @Column(nullable=true,length=80)
    private String b_rejecttire_num_s;
    
    @Comment("向后次品数量")
    @Column(nullable=true,length=80)
    private String b_twoleve_num_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("管控规则")
    @Column(nullable=true,length=80)
    private String control_rules_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("向前锁定数量")
    @Column(nullable=true,length=80)
    private String f_lock_num_s;
    
    @Comment("向前废品数量")
    @Column(nullable=true,length=80)
    private String f_rejecttire_num_s;
    
    @Comment("向前次品数量")
    @Column(nullable=true,length=80)
    private String f_twoleve_num_s;
    
    @Comment("病象名称")
    @Column(nullable=true,length=80)
    private String reas_cn_s;
    
    @Comment("病象编号")
    @Column(nullable=true,length=80)
    private String reas_code_s;
    
    @Comment("记录标志(A可用 D删除)")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
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
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getB_lock_num_s(){
        return b_lock_num_s;
    }
    
    @XmlElement
    public void setB_lock_num_s(String b_lock_num_s){
        this.b_lock_num_s=b_lock_num_s;
    }
        
    public String getB_rejecttire_num_s(){
        return b_rejecttire_num_s;
    }
    
    @XmlElement
    public void setB_rejecttire_num_s(String b_rejecttire_num_s){
        this.b_rejecttire_num_s=b_rejecttire_num_s;
    }
        
    public String getB_twoleve_num_s(){
        return b_twoleve_num_s;
    }
    
    @XmlElement
    public void setB_twoleve_num_s(String b_twoleve_num_s){
        this.b_twoleve_num_s=b_twoleve_num_s;
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
        
    public String getControl_rules_s(){
        return control_rules_s;
    }
    
    @XmlElement
    public void setControl_rules_s(String control_rules_s){
        this.control_rules_s=control_rules_s;
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
        
    public String getF_lock_num_s(){
        return f_lock_num_s;
    }
    
    @XmlElement
    public void setF_lock_num_s(String f_lock_num_s){
        this.f_lock_num_s=f_lock_num_s;
    }
        
    public String getF_rejecttire_num_s(){
        return f_rejecttire_num_s;
    }
    
    @XmlElement
    public void setF_rejecttire_num_s(String f_rejecttire_num_s){
        this.f_rejecttire_num_s=f_rejecttire_num_s;
    }
        
    public String getF_twoleve_num_s(){
        return f_twoleve_num_s;
    }
    
    @XmlElement
    public void setF_twoleve_num_s(String f_twoleve_num_s){
        this.f_twoleve_num_s=f_twoleve_num_s;
    }
        
    public String getReas_cn_s(){
        return reas_cn_s;
    }
    
    @XmlElement
    public void setReas_cn_s(String reas_cn_s){
        this.reas_cn_s=reas_cn_s;
    }
        
    public String getReas_code_s(){
        return reas_code_s;
    }
    
    @XmlElement
    public void setReas_code_s(String reas_code_s){
        this.reas_code_s=reas_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSpare10_s(){
        return spare10_s;
    }
    
    @XmlElement
    public void setSpare10_s(String spare10_s){
        this.spare10_s=spare10_s;
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
        
    public String getSpare6_s(){
        return spare6_s;
    }
    
    @XmlElement
    public void setSpare6_s(String spare6_s){
        this.spare6_s=spare6_s;
    }
        
    public String getSpare7_s(){
        return spare7_s;
    }
    
    @XmlElement
    public void setSpare7_s(String spare7_s){
        this.spare7_s=spare7_s;
    }
        
    public String getSpare8_s(){
        return spare8_s;
    }
    
    @XmlElement
    public void setSpare8_s(String spare8_s){
        this.spare8_s=spare8_s;
    }
        
    public String getSpare9_s(){
        return spare9_s;
    }
    
    @XmlElement
    public void setSpare9_s(String spare9_s){
        this.spare9_s=spare9_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
