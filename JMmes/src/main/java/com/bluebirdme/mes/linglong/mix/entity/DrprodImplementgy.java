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
 * 密炼胶料产出工艺实绩表
 * @author 陈国强
 * @Date 2020-09-16 09:51:21
 */
@ATDefinition("MX_MM_POLYMIX_PROD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_POLYMIX_PROD")
public class DrprodImplementgy extends RockWellBaseEntity{
    
    
    @Comment("动作代码")
    @Column(nullable=true,length=80)
    private String act_code_s;
    
    @Comment("机构编号")
    @Column(nullable=true,length=10)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("冷却鼓速度（一次法参数）")
    @Column(nullable=true,length=0)
    private String coolspeed_mix_d;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("步序")
    @Column(nullable=true,length=0)
    private Integer mix_id_i;
    
    @Comment("开炼机速度（一次法参数）")
    @Column(nullable=true,length=0)
    private String openmixspeed_mix_d;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("辊距（一次法参数）")
    @Column(nullable=true,length=0)
    private String rollor_mix_d;
    
    @Comment("胶温（一次法参数）")
    @Column(nullable=true,length=0)
    private String rubtemp_mix_d;
    
    @Comment("能量")
    @Column(nullable=true,length=0)
    private String set_enter_d;
    
    @Comment("功率")
    @Column(nullable=true,length=0)
    private String set_power_d;
    
    @Comment("压力")
    @Column(nullable=true,length=0)
    private String set_press_d;
    
    @Comment("转速")
    @Column(nullable=true,length=0)
    private String set_rota_d;
    
    @Comment("温度")
    @Column(nullable=true,length=0)
    private String set_temp_d;
    
    @Comment("持续时间")
    @Column(nullable=true,length=0)
    private String set_time_d;
    
    @Comment("备用1")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("速差比（一次法参数）")
    @Column(nullable=true,length=0)
    private String speeddiff_mix_d;
    
    @Comment("工厂代码（1.全钢，2.半钢）")
    @Column(nullable=true,length=10)
    private String s_factory_s;
    
    @Comment("条件代码")
    @Column(nullable=true,length=80)
    private String term_code_s;
    
    @Comment("外键ID：MX_MM_POLYTRAIN_PROD.ID")
    @Column(nullable=true,length=80)
    private String trainprod_id_s;
    
    @Comment("水温（一次法参数）")
    @Column(nullable=true,length=0)
    private String watrtemp_mix_d;
    
    public String getAct_code_s(){
        return act_code_s;
    }
    
    @XmlElement
    public void setAct_code_s(String act_code_s){
        this.act_code_s=act_code_s;
    }
        
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
        
    public String getCoolspeed_mix_d(){
        return coolspeed_mix_d;
    }
    
    @XmlElement
    public void setCoolspeed_mix_d(String coolspeed_mix_d){
        this.coolspeed_mix_d=coolspeed_mix_d;
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
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public Integer getMix_id_i(){
        return mix_id_i;
    }
    
    @XmlElement
    public void setMix_id_i(Integer mix_id_i){
        this.mix_id_i=mix_id_i;
    }
        
    public String getOpenmixspeed_mix_d(){
        return openmixspeed_mix_d;
    }
    
    @XmlElement
    public void setOpenmixspeed_mix_d(String openmixspeed_mix_d){
        this.openmixspeed_mix_d=openmixspeed_mix_d;
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
        
    public String getRollor_mix_d(){
        return rollor_mix_d;
    }
    
    @XmlElement
    public void setRollor_mix_d(String rollor_mix_d){
        this.rollor_mix_d=rollor_mix_d;
    }
        
    public String getRubtemp_mix_d(){
        return rubtemp_mix_d;
    }
    
    @XmlElement
    public void setRubtemp_mix_d(String rubtemp_mix_d){
        this.rubtemp_mix_d=rubtemp_mix_d;
    }
        
    public String getSet_enter_d(){
        return set_enter_d;
    }
    
    @XmlElement
    public void setSet_enter_d(String set_enter_d){
        this.set_enter_d=set_enter_d;
    }
        
    public String getSet_power_d(){
        return set_power_d;
    }
    
    @XmlElement
    public void setSet_power_d(String set_power_d){
        this.set_power_d=set_power_d;
    }
        
    public String getSet_press_d(){
        return set_press_d;
    }
    
    @XmlElement
    public void setSet_press_d(String set_press_d){
        this.set_press_d=set_press_d;
    }
        
    public String getSet_rota_d(){
        return set_rota_d;
    }
    
    @XmlElement
    public void setSet_rota_d(String set_rota_d){
        this.set_rota_d=set_rota_d;
    }
        
    public String getSet_temp_d(){
        return set_temp_d;
    }
    
    @XmlElement
    public void setSet_temp_d(String set_temp_d){
        this.set_temp_d=set_temp_d;
    }
        
    public String getSet_time_d(){
        return set_time_d;
    }
    
    @XmlElement
    public void setSet_time_d(String set_time_d){
        this.set_time_d=set_time_d;
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
        
    public String getSpeeddiff_mix_d(){
        return speeddiff_mix_d;
    }
    
    @XmlElement
    public void setSpeeddiff_mix_d(String speeddiff_mix_d){
        this.speeddiff_mix_d=speeddiff_mix_d;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTerm_code_s(){
        return term_code_s;
    }
    
    @XmlElement
    public void setTerm_code_s(String term_code_s){
        this.term_code_s=term_code_s;
    }
        
    public String getTrainprod_id_s(){
        return trainprod_id_s;
    }
    
    @XmlElement
    public void setTrainprod_id_s(String trainprod_id_s){
        this.trainprod_id_s=trainprod_id_s;
    }
        
    public String getWatrtemp_mix_d(){
        return watrtemp_mix_d;
    }
    
    @XmlElement
    public void setWatrtemp_mix_d(String watrtemp_mix_d){
        this.watrtemp_mix_d=watrtemp_mix_d;
    }
        
    
    
    
}
