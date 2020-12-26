/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * 角色功能对应表
 * @author 兰颖慧
 * @Date 2019-03-18 09:12:58
 */
@ATDefinition("B_MM_RoleMethod")
@Entity
@XmlRootElement
@Table(name="AT_B_MM_ROLEMETHOD")
public class RoleMethod extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("修改人")
    @Column(nullable=false,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=false,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("功能代码")
    @Column(nullable=false,length=80)
    private String method_code_s;
    
    @Comment("功能名称")
    @Column(nullable=false,length=80)
    private String method_name_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("角色ID")
    @Column(nullable=false,length=80)
    private String role_id_s;
    
    @Comment("角色名称")
    @Column(nullable=false,length=80)
    private String role_name_s;
    
    @Comment("备用字段1")
    @Column(nullable=false,length=80)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=false,length=80)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=false,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=false,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=false,length=80)
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
        
    public String getMethod_code_s(){
        return method_code_s;
    }
    
    @XmlElement
    public void setMethod_code_s(String method_code_s){
        this.method_code_s=method_code_s;
    }
        
    public String getMethod_name_s(){
        return method_name_s;
    }
    
    @XmlElement
    public void setMethod_name_s(String method_name_s){
        this.method_name_s=method_name_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRole_id_s(){
        return role_id_s;
    }
    
    @XmlElement
    public void setRole_id_s(String role_id_s){
        this.role_id_s=role_id_s;
    }
        
    public String getRole_name_s(){
        return role_name_s;
    }
    
    @XmlElement
    public void setRole_name_s(String role_name_s){
        this.role_name_s=role_name_s;
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
