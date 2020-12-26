/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 密炼投料防错管控
 * @author 王超
 * @Date 2020-08-08 10:22:36
 */
@ATDefinition("MX_MM_FEEDSWITCH")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_FEEDSWITCH")
public class FeedSwitch extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=50)
    private String equip_name_s;
    
    @Comment("主键ID")
    @Column(nullable=false,length=80)
    private String id_s;
    
    @Comment("接片-控制：0-关、1-开")
    @Column(nullable=true,length=80)
    private String is_autosp_switch_s;
    
    @Comment("工单-洗车校验：0-关、1-开")
    @Column(nullable=true,length=80)
    private String is_carwash_switch_s;
    
    @Comment("日计划-等同物料选择：0-关、1-开")
    @Column(nullable=true,length=80)
    private String is_equal_switch_s;
    
    @Comment("工单-顺序执行：0-关、1-开")
    @Column(nullable=true,length=80)
    private String is_inorder_exec_switch_s;
    
    @Comment("工单-主机手设置：0-关、1-开")
    @Column(nullable=true,length=80)
    private String is_master_switch_s;
    
    @Comment("防错物料组名称：例如 半成品-母胶,半成品-混炼胶")
    @Column(nullable=true,length=1000)
    private String material_groupname_s;
    
    @Comment("防错物料组：例如 300001,300002")
    @Column(nullable=true,length=1000)
    private String material_group_s;
    
    @Comment("记录标志：A-可用，D-删除")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=80)
    private String send_name_s;
    
    @Comment("下发标识：0-未下发、1-已下发、2-下发失败")
    @Column(nullable=true,length=20)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=200)
    private String spare10_s;
    
    @Comment("备用字段1： 父物料类型： 母胶(LLMasterBatch)、 终炼胶(LLFinalBatchMPart)、 硫磺小料包(LLSulfurBagBatch)、 普通小料包(LLOrdinaryBagBatch)")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2：备注：例如 MW92007071008[已执行]")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3：状态：关闭、打开")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4：接片错误描述")
    @Column(nullable=true,length=2000)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=200)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=200)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=200)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=200)
    private String spare9_s;
    
    @Comment("接片-胶案移入工位（只有终炼有）：0-摆片，1、2-卷曲位")
    @Column(nullable=true,length=80)
    private String sp_carriermovein_loc_s;
    
    @Comment("接片-胶案移入信号：1-胶案架移入，0-MES读取后复位")
    @Column(nullable=true,length=80)
    private String sp_carriermovein_s;
    
    @Comment("接片-胶案移出信号：1-胶案架移出，0-MES读取后复位（PLC收到胶案移出信号为0后，由PLC清空产出重量）")
    @Column(nullable=true,length=80)
    private String sp_carriermoveout_s;
    
    @Comment("接片-胶案产出工位（只有终炼有）：0-摆片，1、2-卷曲位")
    @Column(nullable=true,length=80)
    private String sp_carriermove_loc_s;
    
    @Comment("接片-胶案重量")
    @Column(nullable=true,length=0)
    private String sp_carrierweight_d;
    
    @Comment("接片-当前动作：MES给PLC，用于MES客户端展示： 准备收胶：胶案移入->MES读RFID->读胶案重量->MES下发标准->结束； 1-完成胶案移入，胶案称量中； 2-完成胶案称重，标准下发中； 3- RFID未读取到，请手动移出； 4-未选择工单，请选择工单； 收胶控制： 摆片->移出->卡片打印->结束 6-完成标准下发，摆片中； 7-产出重量为零，不允许移出； 8-产出重量正常，卡片打印中； 收胶完成： 11-收胶完成；")
    @Column(nullable=true,length=80)
    private String sp_curaction_s;
    
    @Comment("接片-误差值")
    @Column(nullable=true,length=0)
    private String sp_cutpolyweight_d;
    
    @Comment("接片-通讯心跳")
    @Column(nullable=true,length=0)
    private Integer sp_netheart_i;
    
    @Comment("接片-自动/手动模式：0-自动、1-手动")
    @Column(nullable=true,length=80)
    private String sp_onlineoffline_s;
    
    @Comment("接片-产出重量")
    @Column(nullable=true,length=0)
    private String sp_prodweight_d;
    
    @Comment("接片-运行模式：0-联网运行、1-单机运行")
    @Column(nullable=true,length=80)
    private String sp_runmode_s;
    
    @Comment("接片-架子数")
    @Column(nullable=true,length=0)
    private Integer sp_shelf_num_i;
    
    @Comment("接片-提前量")
    @Column(nullable=true,length=0)
    private String sp_slowdownweight_d;
    
    @Comment("接片-标准重量")
    @Column(nullable=true,length=0)
    private String sp_standweight_d;
    
    @Comment("接片-工单号")
    @Column(nullable=true,length=80)
    private String sp_wo_no_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
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
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIs_autosp_switch_s(){
        return is_autosp_switch_s;
    }
    
    @XmlElement
    public void setIs_autosp_switch_s(String is_autosp_switch_s){
        this.is_autosp_switch_s=is_autosp_switch_s;
    }
        
    public String getIs_carwash_switch_s(){
        return is_carwash_switch_s;
    }
    
    @XmlElement
    public void setIs_carwash_switch_s(String is_carwash_switch_s){
        this.is_carwash_switch_s=is_carwash_switch_s;
    }
        
    public String getIs_equal_switch_s(){
        return is_equal_switch_s;
    }
    
    @XmlElement
    public void setIs_equal_switch_s(String is_equal_switch_s){
        this.is_equal_switch_s=is_equal_switch_s;
    }
        
    public String getIs_inorder_exec_switch_s(){
        return is_inorder_exec_switch_s;
    }
    
    @XmlElement
    public void setIs_inorder_exec_switch_s(String is_inorder_exec_switch_s){
        this.is_inorder_exec_switch_s=is_inorder_exec_switch_s;
    }
        
    public String getIs_master_switch_s(){
        return is_master_switch_s;
    }
    
    @XmlElement
    public void setIs_master_switch_s(String is_master_switch_s){
        this.is_master_switch_s=is_master_switch_s;
    }
        
    public String getMaterial_groupname_s(){
        return material_groupname_s;
    }
    
    @XmlElement
    public void setMaterial_groupname_s(String material_groupname_s){
        this.material_groupname_s=material_groupname_s;
    }
        
    public String getMaterial_group_s(){
        return material_group_s;
    }
    
    @XmlElement
    public void setMaterial_group_s(String material_group_s){
        this.material_group_s=material_group_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSend_by_s(){
        return send_by_s;
    }
    
    @XmlElement
    public void setSend_by_s(String send_by_s){
        this.send_by_s=send_by_s;
    }
        
    public String getSend_name_s(){
        return send_name_s;
    }
    
    @XmlElement
    public void setSend_name_s(String send_name_s){
        this.send_name_s=send_name_s;
    }
        
    public String getSend_state_s(){
        return send_state_s;
    }
    
    @XmlElement
    public void setSend_state_s(String send_state_s){
        this.send_state_s=send_state_s;
    }
        
    public Date getSend_time_t(){
        return send_time_t;
    }
    
    @XmlElement
    public void setSend_time_t(Date send_time_t){
        this.send_time_t=send_time_t;
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
        
    public String getSp_carriermovein_loc_s(){
        return sp_carriermovein_loc_s;
    }
    
    @XmlElement
    public void setSp_carriermovein_loc_s(String sp_carriermovein_loc_s){
        this.sp_carriermovein_loc_s=sp_carriermovein_loc_s;
    }
        
    public String getSp_carriermovein_s(){
        return sp_carriermovein_s;
    }
    
    @XmlElement
    public void setSp_carriermovein_s(String sp_carriermovein_s){
        this.sp_carriermovein_s=sp_carriermovein_s;
    }
        
    public String getSp_carriermoveout_s(){
        return sp_carriermoveout_s;
    }
    
    @XmlElement
    public void setSp_carriermoveout_s(String sp_carriermoveout_s){
        this.sp_carriermoveout_s=sp_carriermoveout_s;
    }
        
    public String getSp_carriermove_loc_s(){
        return sp_carriermove_loc_s;
    }
    
    @XmlElement
    public void setSp_carriermove_loc_s(String sp_carriermove_loc_s){
        this.sp_carriermove_loc_s=sp_carriermove_loc_s;
    }
        
    public String getSp_carrierweight_d(){
        return sp_carrierweight_d;
    }
    
    @XmlElement
    public void setSp_carrierweight_d(String sp_carrierweight_d){
        this.sp_carrierweight_d=sp_carrierweight_d;
    }
        
    public String getSp_curaction_s(){
        return sp_curaction_s;
    }
    
    @XmlElement
    public void setSp_curaction_s(String sp_curaction_s){
        this.sp_curaction_s=sp_curaction_s;
    }
        
    public String getSp_cutpolyweight_d(){
        return sp_cutpolyweight_d;
    }
    
    @XmlElement
    public void setSp_cutpolyweight_d(String sp_cutpolyweight_d){
        this.sp_cutpolyweight_d=sp_cutpolyweight_d;
    }
        
    public Integer getSp_netheart_i(){
        return sp_netheart_i;
    }
    
    @XmlElement
    public void setSp_netheart_i(Integer sp_netheart_i){
        this.sp_netheart_i=sp_netheart_i;
    }
        
    public String getSp_onlineoffline_s(){
        return sp_onlineoffline_s;
    }
    
    @XmlElement
    public void setSp_onlineoffline_s(String sp_onlineoffline_s){
        this.sp_onlineoffline_s=sp_onlineoffline_s;
    }
        
    public String getSp_prodweight_d(){
        return sp_prodweight_d;
    }
    
    @XmlElement
    public void setSp_prodweight_d(String sp_prodweight_d){
        this.sp_prodweight_d=sp_prodweight_d;
    }
        
    public String getSp_runmode_s(){
        return sp_runmode_s;
    }
    
    @XmlElement
    public void setSp_runmode_s(String sp_runmode_s){
        this.sp_runmode_s=sp_runmode_s;
    }
        
    public Integer getSp_shelf_num_i(){
        return sp_shelf_num_i;
    }
    
    @XmlElement
    public void setSp_shelf_num_i(Integer sp_shelf_num_i){
        this.sp_shelf_num_i=sp_shelf_num_i;
    }
        
    public String getSp_slowdownweight_d(){
        return sp_slowdownweight_d;
    }
    
    @XmlElement
    public void setSp_slowdownweight_d(String sp_slowdownweight_d){
        this.sp_slowdownweight_d=sp_slowdownweight_d;
    }
        
    public String getSp_standweight_d(){
        return sp_standweight_d;
    }
    
    @XmlElement
    public void setSp_standweight_d(String sp_standweight_d){
        this.sp_standweight_d=sp_standweight_d;
    }
        
    public String getSp_wo_no_s(){
        return sp_wo_no_s;
    }
    
    @XmlElement
    public void setSp_wo_no_s(String sp_wo_no_s){
        this.sp_wo_no_s=sp_wo_no_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
