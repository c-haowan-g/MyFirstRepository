/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

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
 * 手持登录履历表
 * @author 王超
 * @Date 2020-06-04 09:14:13
 */
@ATDefinition("C_MM_PDALOGIN_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_PDALogin_Record")
public class PdaLoginRecord extends RockWellBaseEntity{
    
    
    @Comment("班次")
    @Column(nullable=false,length=80)
    private String class_id_s;
    
    @Comment("手持编号")
    @Column(nullable=false,length=80)
    private String equip_code_s;
    
    @Comment("设备IP")
    @Column(nullable=false,length=80)
    private String equip_ip_s;
    
    @Comment("班组")
    @Column(nullable=false,length=80)
    private String group_id_s;
    
    @Comment("登录时间")
    @Column(nullable=false,length=0)
    private Date login_time_t;
    
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
    private String spare_5_s;
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("登录人")
    @Column(nullable=false,length=80)
    private String worker_id_s;
    
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_ip_s(){
        return equip_ip_s;
    }
    
    @XmlElement
    public void setEquip_ip_s(String equip_ip_s){
        this.equip_ip_s=equip_ip_s;
    }
        
    public String getGroup_id_s(){
        return group_id_s;
    }
    
    @XmlElement
    public void setGroup_id_s(String group_id_s){
        this.group_id_s=group_id_s;
    }
        
    public Date getLogin_time_t(){
        return login_time_t;
    }
    
    @XmlElement
    public void setLogin_time_t(Date login_time_t){
        this.login_time_t=login_time_t;
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
        
    public String getSpare_5_s(){
        return spare_5_s;
    }
    
    @XmlElement
    public void setSpare_5_s(String spare_5_s){
        this.spare_5_s=spare_5_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }
        
    
    
    
}
