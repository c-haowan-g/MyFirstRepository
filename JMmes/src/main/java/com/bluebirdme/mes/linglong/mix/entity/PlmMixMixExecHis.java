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
 * PLM密炼工艺执行历史表
 * @author 栾和源
 * @Date 2020-08-13 13:50:26
 */
@ATDefinition("INT_PLM_MIXMIX_EXEC_HIS")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_MIXMIX_EXEC_HIS")
public class PlmMixMixExecHis extends RockWellBaseEntity{
    
    
    @Comment("动作代码")
    @Column(nullable=true,length=0)
    private Integer act_code_i;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("冷却鼓速度")
    @Column(nullable=true,length=0)
    private String coolspeed_mix_d;
    
    @Comment("备用1")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("备用2")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=100)
    private String id_s;
    
    @Comment("步序")
    @Column(nullable=true,length=0)
    private Integer mix_id_i;
    
    @Comment("开练机序号")
    @Column(nullable=true,length=0)
    private Integer openequip_id_i;
    
    @Comment("开炼机速度")
    @Column(nullable=true,length=0)
    private String openmixspeed_mix_d;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方编号-13位：外键，INT_PLM_MIXRECIPE.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=5)
    private String record_flag_s;
    
    @Comment("辊距")
    @Column(nullable=true,length=0)
    private String rollor_mix_d;
    
    @Comment("胶温")
    @Column(nullable=true,length=0)
    private String rubtemp_mix_d;
    
    @Comment("同步时间")
    @Column(nullable=true,length=0)
    private Date sync_create_time_t;
    
    @Comment("数据同步处理：A-新增、U-修改、D-删除")
    @Column(nullable=true,length=80)
    private String sync_flag_s;
    
    @Comment("1#-3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_flauto_s;
    
    @Comment("数据同步处理标记：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_s;
    
    @Comment("数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_s;
    
    @Comment("数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("压力")
    @Column(nullable=true,length=0)
    private String set_press_d;
    
    @Comment("转速")
    @Column(nullable=true,length=0)
    private String set_rota_d;
    
    @Comment("能量")
    @Column(nullable=true,length=0)
    private String set_enter_d;
    
    @Comment("功率")
    @Column(nullable=true,length=0)
    private String set_power_d;
    
    @Comment("温度")
    @Column(nullable=true,length=0)
    private String set_temp_d;
    
    @Comment("持续时间")
    @Column(nullable=true,length=0)
    private String set_time_d;
    
    @Comment("速差比")
    @Column(nullable=true,length=0)
    private String speeddiff_mix_d;
    
    @Comment("条件代码")
    @Column(nullable=true,length=0)
    private String term_code_d;
    
    @Comment("水温")
    @Column(nullable=true,length=0)
    private String watrtemp_mix_d;
    
    public Integer getAct_code_i(){
        return act_code_i;
    }
    
    @XmlElement
    public void setAct_code_i(Integer act_code_i){
        this.act_code_i=act_code_i;
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
        
    public String getCoolspeed_mix_d(){
        return coolspeed_mix_d;
    }
    
    @XmlElement
    public void setCoolspeed_mix_d(String coolspeed_mix_d){
        this.coolspeed_mix_d=coolspeed_mix_d;
    }
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
    }
        
    public String getGuid_s(){
        return guid_s;
    }
    
    @XmlElement
    public void setGuid_s(String guid_s){
        this.guid_s=guid_s;
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
        
    public Integer getOpenequip_id_i(){
        return openequip_id_i;
    }
    
    @XmlElement
    public void setOpenequip_id_i(Integer openequip_id_i){
        this.openequip_id_i=openequip_id_i;
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
        
    public String getRecipe_code_s(){
        return recipe_code_s;
    }
    
    @XmlElement
    public void setRecipe_code_s(String recipe_code_s){
        this.recipe_code_s=recipe_code_s;
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
        
    public Date getSync_create_time_t(){
        return sync_create_time_t;
    }
    
    @XmlElement
    public void setSync_create_time_t(Date sync_create_time_t){
        this.sync_create_time_t=sync_create_time_t;
    }
        
    public String getSync_flag_s(){
        return sync_flag_s;
    }
    
    @XmlElement
    public void setSync_flag_s(String sync_flag_s){
        this.sync_flag_s=sync_flag_s;
    }
        
    public String getSync_hand_flag_flauto_s(){
        return sync_hand_flag_flauto_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_flauto_s(String sync_hand_flag_flauto_s){
        this.sync_hand_flag_flauto_s=sync_hand_flag_flauto_s;
    }
        
    public String getSync_hand_flag_s(){
        return sync_hand_flag_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_s(String sync_hand_flag_s){
        this.sync_hand_flag_s=sync_hand_flag_s;
    }
        
    public String getSync_hand_msg_s(){
        return sync_hand_msg_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_s(String sync_hand_msg_s){
        this.sync_hand_msg_s=sync_hand_msg_s;
    }
        
    public Date getSync_hand_time_t(){
        return sync_hand_time_t;
    }
    
    @XmlElement
    public void setSync_hand_time_t(Date sync_hand_time_t){
        this.sync_hand_time_t=sync_hand_time_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
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
        
    public String getSpeeddiff_mix_d(){
        return speeddiff_mix_d;
    }
    
    @XmlElement
    public void setSpeeddiff_mix_d(String speeddiff_mix_d){
        this.speeddiff_mix_d=speeddiff_mix_d;
    }
        
    public String getTerm_code_d(){
        return term_code_d;
    }
    
    @XmlElement
    public void setTerm_code_d(String term_code_d){
        this.term_code_d=term_code_d;
    }
        
    public String getWatrtemp_mix_d(){
        return watrtemp_mix_d;
    }
    
    @XmlElement
    public void setWatrtemp_mix_d(String watrtemp_mix_d){
        this.watrtemp_mix_d=watrtemp_mix_d;
    }
        
    
    
    
}
