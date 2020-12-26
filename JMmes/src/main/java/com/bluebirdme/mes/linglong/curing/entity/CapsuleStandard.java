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
 * 胶囊工艺标准表
 * @author 周清玉
 * @Date 2018-09-11 08:20:49
 */
@ATDefinition("C_QM_CapsuleStandard")
@Entity
@XmlRootElement
@Table(name="AT_C_QM_CAPSULESTANDARD")
public class CapsuleStandard extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("报警值")
    @Column(nullable=true,length=0)
    private Integer alarm_number_i;
    
    @Comment("厂商")
    @Column(nullable=true,length=200)
    private String capsule_factory_s;
    
    @Comment("胶囊规格")
    @Column(nullable=true,length=200)
    private String capsule_spec_s;
    
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
    
    @Comment("胶囊编码")
    @Column(nullable=true,length=80)
    private String material_capsulecode_s;
    
    @Comment("最高使用次数")
    @Column(nullable=true,length=0)
    private Integer max_limit_i;
    
    @Comment("超上限使用次数")
    @Column(nullable=true,length=0)
    private Integer over_limit_i;
    
    @Comment("胶囊校验位码")
    @Column(nullable=true,length=80)
    private String parity_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
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
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Integer getAlarm_number_i(){
        return alarm_number_i;
    }
    
    @XmlElement
    public void setAlarm_number_i(Integer alarm_number_i){
        this.alarm_number_i=alarm_number_i;
    }
        
    public String getCapsule_factory_s(){
        return capsule_factory_s;
    }
    
    @XmlElement
    public void setCapsule_factory_s(String capsule_factory_s){
        this.capsule_factory_s=capsule_factory_s;
    }
        
    public String getCapsule_spec_s(){
        return capsule_spec_s;
    }
    
    @XmlElement
    public void setCapsule_spec_s(String capsule_spec_s){
        this.capsule_spec_s=capsule_spec_s;
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
        
    public String getMaterial_capsulecode_s(){
        return material_capsulecode_s;
    }
    
    @XmlElement
    public void setMaterial_capsulecode_s(String material_capsulecode_s){
        this.material_capsulecode_s=material_capsulecode_s;
    }
        
    public Integer getMax_limit_i(){
        return max_limit_i;
    }
    
    @XmlElement
    public void setMax_limit_i(Integer max_limit_i){
        this.max_limit_i=max_limit_i;
    }
        
    public Integer getOver_limit_i(){
        return over_limit_i;
    }
    
    @XmlElement
    public void setOver_limit_i(Integer over_limit_i){
        this.over_limit_i=over_limit_i;
    }
        
    public String getParity_code_s(){
        return parity_code_s;
    }
    
    @XmlElement
    public void setParity_code_s(String parity_code_s){
        this.parity_code_s=parity_code_s;
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
