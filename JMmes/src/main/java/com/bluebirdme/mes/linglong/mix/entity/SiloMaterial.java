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
 * 密炼料仓物料维护表
 * @author 王超
 * @Date 2020-08-03 15:29:17
 */
@ATDefinition("MX_MM_SILOMATERIAL")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_SILOMATERIAL")
public class SiloMaterial extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=200)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("审核人")
    @Column(nullable=true,length=200)
    private String check_by_s;
    
    @Comment("审核人姓名")
    @Column(nullable=true,length=200)
    private String check_name_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date check_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=200)
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
    @Column(nullable=true,length=80)
    private String equip_name_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("物料类别(上辅机定义)：055001-炭黑、055002-小药、055003-粉料、055004-油料、055005-胶料 ：对应INT_PLM_MIXMATERIAL表MATERIALTYPE")
    @Column(nullable=true,length=80)
    private String materialtype_s;
    
    @Comment("物料编码：对应INT_PLM_MIXMATERIAL表MATERIALCODE")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称：对应INT_PLM_MIXMATERIAL表MATERIALNAME")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("输送线：加载炭黑、油料输送线基础数据")
    @Column(nullable=true,length=80)
    private String pipeline_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=80)
    private String send_name_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("料仓号：加载机台对应配置料仓号")
    @Column(nullable=true,length=80)
    private String silono_s;
    
    @Comment("下发标识：0-未下发、1-已下发、2-下发失败")
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
    
    @Comment("使用状态：058001-未审核、058002-已审核、058003-正下发、058004-已下发、058005-已执行、058006-已关闭")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("供应商代码 例如：100019|100018")
    @Column(nullable=true,length=2000)
    private String supplycode_s;
    
    @Comment("供应商名称 例如：A|B")
    @Column(nullable=true,length=2000)
    private String supplyname_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=80)
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
        
    public String getCheck_by_s(){
        return check_by_s;
    }
    
    @XmlElement
    public void setCheck_by_s(String check_by_s){
        this.check_by_s=check_by_s;
    }
        
    public String getCheck_name_s(){
        return check_name_s;
    }
    
    @XmlElement
    public void setCheck_name_s(String check_name_s){
        this.check_name_s=check_name_s;
    }
        
    public Date getCheck_time_t(){
        return check_time_t;
    }
    
    @XmlElement
    public void setCheck_time_t(Date check_time_t){
        this.check_time_t=check_time_t;
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
        
    public String getMaterialtype_s(){
        return materialtype_s;
    }
    
    @XmlElement
    public void setMaterialtype_s(String materialtype_s){
        this.materialtype_s=materialtype_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getPipeline_s(){
        return pipeline_s;
    }
    
    @XmlElement
    public void setPipeline_s(String pipeline_s){
        this.pipeline_s=pipeline_s;
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
        
    public Date getSend_time_t(){
        return send_time_t;
    }
    
    @XmlElement
    public void setSend_time_t(Date send_time_t){
        this.send_time_t=send_time_t;
    }
        
    public String getSilono_s(){
        return silono_s;
    }
    
    @XmlElement
    public void setSilono_s(String silono_s){
        this.silono_s=silono_s;
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
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getSupplycode_s(){
        return supplycode_s;
    }
    
    @XmlElement
    public void setSupplycode_s(String supplycode_s){
        this.supplycode_s=supplycode_s;
    }
        
    public String getSupplyname_s(){
        return supplyname_s;
    }
    
    @XmlElement
    public void setSupplyname_s(String supplyname_s){
        this.supplyname_s=supplyname_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
