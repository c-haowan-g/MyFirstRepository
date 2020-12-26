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
 * 密炼投料履历
 * @author 栾和源
 * @Date 2020-08-03 11:41:49
 */
@ATDefinition("MX_MM_FEED_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_FEED_RECORD")
public class Drrecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 荆门 8023")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("载具条码（母胶投入时胶架条码）")
    @Column(nullable=true,length=40)
    private String carrier_code_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=100)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=100)
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
    
    @Comment("机台编码")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("允许误差")
    @Column(nullable=true,length=80)
    private String error_allow_s;
    
    @Comment("投料班组：301001-甲班、301002-乙班、301003-丙班")
    @Column(nullable=true,length=80)
    private String group_code_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("投料类型：056001-炭黑、056002-油料、056003-胶料上辅机、056004-小料上辅机、056005-人工配料、056006-碎胶投料碎胶投料")
    @Column(nullable=true,length=20)
    private String input_type_s;
    
    @Comment("批次号")
    @Column(nullable=true,length=40)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("输送线：炭黑、油料输送")
    @Column(nullable=true,length=80)
    private String pipeline_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("密炼生成配方编号")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("扫描人")
    @Column(nullable=true,length=100)
    private String scan_by_s;
    
    @Comment("扫描人姓名")
    @Column(nullable=true,length=200)
    private String scan_name_s;
    
    @Comment("扫描时间")
    @Column(nullable=true,length=80)
    private String scan_time_s;
    
    @Comment("当前车次号")
    @Column(nullable=true,length=20)
    private String serial_id_s;
    
    @Comment("投料班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String shift_code_s;
    
    @Comment("连通料仓号：炭黑、油料输送")
    @Column(nullable=true,length=80)
    private String silono_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("备用字段1：供应商代码")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2：供应商名称")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3：是否校验通过： 066001-投料准备、 066002-等待反馈、 066003-通过、 066004-未通过、066005-其它")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4：密炼通讯反馈备注")
    @Column(nullable=true,length=2000)
    private String spare4_s;
    
    @Comment("备用字段5：小料数量")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6：是否掺胶：Yes-掺胶、No-不掺胶")
    @Column(nullable=true,length=100)
    private String spare6_s;
    
    @Comment("备用字段7：配方阶段：ZC-正常、ZCC-不正常、SY-实验")
    @Column(nullable=true,length=100)
    private String spare7_s;
    
    @Comment("备用字段8：配方类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗")
    @Column(nullable=true,length=100)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=100)
    private String spare9_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("投料重量")
    @Column(nullable=true,length=20)
    private String weight_s;
    
    @Comment("称量类型： 0-炭黑称 1-油料称 2-胶料称 3-小料称 4-小料称 5-油料称2 6-小料在胶料称 7-预分散称 8-返回胶专用秤")
    @Column(nullable=true,length=20)
    private String weigh_type_s;
    
    @Comment("工单生产日期")
    @Column(nullable=true,length=80)
    private String wo_date_s;
    
    @Comment("密炼工单跟踪表，工单号，外键，MX_PP_WO.WO_NO")
    @Column(nullable=true,length=80)
    private String wo_no_s;
    
    @Comment("工单班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String wo_shift_s;
    
    @Comment("工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭")
    @Column(nullable=true,length=80)
    private String wo_status_s;
    
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
        
    public String getCarrier_code_s(){
        return carrier_code_s;
    }
    
    @XmlElement
    public void setCarrier_code_s(String carrier_code_s){
        this.carrier_code_s=carrier_code_s;
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
        
    public String getError_allow_s(){
        return error_allow_s;
    }
    
    @XmlElement
    public void setError_allow_s(String error_allow_s){
        this.error_allow_s=error_allow_s;
    }
        
    public String getGroup_code_s(){
        return group_code_s;
    }
    
    @XmlElement
    public void setGroup_code_s(String group_code_s){
        this.group_code_s=group_code_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInput_type_s(){
        return input_type_s;
    }
    
    @XmlElement
    public void setInput_type_s(String input_type_s){
        this.input_type_s=input_type_s;
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
        
    public String getPipeline_s(){
        return pipeline_s;
    }
    
    @XmlElement
    public void setPipeline_s(String pipeline_s){
        this.pipeline_s=pipeline_s;
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
        
    public String getScan_by_s(){
        return scan_by_s;
    }
    
    @XmlElement
    public void setScan_by_s(String scan_by_s){
        this.scan_by_s=scan_by_s;
    }
        
    public String getScan_name_s(){
        return scan_name_s;
    }
    
    @XmlElement
    public void setScan_name_s(String scan_name_s){
        this.scan_name_s=scan_name_s;
    }
        
    public String getScan_time_s(){
        return scan_time_s;
    }
    
    @XmlElement
    public void setScan_time_s(String scan_time_s){
        this.scan_time_s=scan_time_s;
    }
        
    public String getSerial_id_s(){
        return serial_id_s;
    }
    
    @XmlElement
    public void setSerial_id_s(String serial_id_s){
        this.serial_id_s=serial_id_s;
    }
        
    public String getShift_code_s(){
        return shift_code_s;
    }
    
    @XmlElement
    public void setShift_code_s(String shift_code_s){
        this.shift_code_s=shift_code_s;
    }
        
    public String getSilono_s(){
        return silono_s;
    }
    
    @XmlElement
    public void setSilono_s(String silono_s){
        this.silono_s=silono_s;
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
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    public String getWeigh_type_s(){
        return weigh_type_s;
    }
    
    @XmlElement
    public void setWeigh_type_s(String weigh_type_s){
        this.weigh_type_s=weigh_type_s;
    }
        
    public String getWo_date_s(){
        return wo_date_s;
    }
    
    @XmlElement
    public void setWo_date_s(String wo_date_s){
        this.wo_date_s=wo_date_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    public String getWo_shift_s(){
        return wo_shift_s;
    }
    
    @XmlElement
    public void setWo_shift_s(String wo_shift_s){
        this.wo_shift_s=wo_shift_s;
    }
        
    public String getWo_status_s(){
        return wo_status_s;
    }
    
    @XmlElement
    public void setWo_status_s(String wo_status_s){
        this.wo_status_s=wo_status_s;
    }
        
    
    
    
}
