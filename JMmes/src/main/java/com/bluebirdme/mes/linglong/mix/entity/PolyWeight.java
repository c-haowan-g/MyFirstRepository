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
 * 密炼胶料产出称量实绩表
 * @author 陈国强
 * @Date 2020-09-17 17:04:06
 */
@ATDefinition("MX_MM_POLYWEIGHT_PROD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_POLYWEIGHT_PROD")
public class PolyWeight extends RockWellBaseEntity{
    
    
    @Comment("机构编号：柳州 8003")
    @Column(nullable=true,length=10)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("允许误差")
    @Column(nullable=true,length=25)
    private String error_allow_s;
    
    @Comment("实际误差")
    @Column(nullable=true,length=25)
    private String error_out_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("消耗批次号")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("实际重量")
    @Column(nullable=true,length=25)
    private String real_weight_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("设定重量")
    @Column(nullable=true,length=25)
    private String set_weight_s;
    
    @Comment("生产方式：手动、自动")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("投料防错校验开关：C-关闭，B-打开")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("防错校验打开，无消耗批次号原因备注 例如：当前防错开关下发计划号-接收时间(yyyy-MM-dd hh:mm:ss): FW92004231030-2020-04-24 16:33:22")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("工厂代码（1.全钢，2.半钢）")
    @Column(nullable=true,length=10)
    private String s_factory_s;
    
    @Comment("外键ID：MX_MM_POLYTRAIN_PROD.ID")
    @Column(nullable=true,length=80)
    private String trainprod_id_s;
    
    @Comment("是否超差（没有判定结果）")
    @Column(nullable=true,length=25)
    private String warning_sgn_s;
    
    @Comment("称量序号")
    @Column(nullable=true,length=25)
    private String weight_id_s;
    
    @Comment("称量时间")
    @Column(nullable=true,length=25)
    private String weight_time_s;
    
    @Comment("称量类型（称量类型定义）")
    @Column(nullable=true,length=25)
    private String weight_type_s;
    
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
        
    public String getError_allow_s(){
        return error_allow_s;
    }
    
    @XmlElement
    public void setError_allow_s(String error_allow_s){
        this.error_allow_s=error_allow_s;
    }
        
    public String getError_out_s(){
        return error_out_s;
    }
    
    @XmlElement
    public void setError_out_s(String error_out_s){
        this.error_out_s=error_out_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
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
        
    public String getReal_weight_s(){
        return real_weight_s;
    }
    
    @XmlElement
    public void setReal_weight_s(String real_weight_s){
        this.real_weight_s=real_weight_s;
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
        
    public String getSet_weight_s(){
        return set_weight_s;
    }
    
    @XmlElement
    public void setSet_weight_s(String set_weight_s){
        this.set_weight_s=set_weight_s;
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
        
    public String getTrainprod_id_s(){
        return trainprod_id_s;
    }
    
    @XmlElement
    public void setTrainprod_id_s(String trainprod_id_s){
        this.trainprod_id_s=trainprod_id_s;
    }
        
    public String getWarning_sgn_s(){
        return warning_sgn_s;
    }
    
    @XmlElement
    public void setWarning_sgn_s(String warning_sgn_s){
        this.warning_sgn_s=warning_sgn_s;
    }
        
    public String getWeight_id_s(){
        return weight_id_s;
    }
    
    @XmlElement
    public void setWeight_id_s(String weight_id_s){
        this.weight_id_s=weight_id_s;
    }
        
    public String getWeight_time_s(){
        return weight_time_s;
    }
    
    @XmlElement
    public void setWeight_time_s(String weight_time_s){
        this.weight_time_s=weight_time_s;
    }
        
    public String getWeight_type_s(){
        return weight_type_s;
    }
    
    @XmlElement
    public void setWeight_type_s(String weight_type_s){
        this.weight_type_s=weight_type_s;
    }
        
    
    
    
}
