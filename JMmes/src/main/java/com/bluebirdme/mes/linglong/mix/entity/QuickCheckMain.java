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
 * 密炼胶料快检主表
 * @author 栾和源
 * @Date 2020-12-17 11:15:45
 */
@ATDefinition("MX_QM_QUICKCHECKMAIN")
@Entity
@XmlRootElement
@Table(name="AT_MX_QM_QUICKCHECKMAIN")
public class QuickCheckMain extends RockWellBaseEntity{
    
    
    @Comment("机构编号")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("最终检验人员")
    @Column(nullable=true,length=20)
    private String check_by_s;
    
    @Comment("最终检验人姓名")
    @Column(nullable=true,length=200)
    private String check_name_s;
    
    @Comment("最终检测日期")
    @Column(nullable=true,length=25)
    private String check_time_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
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
    
    @Comment("是否曲线判：Y-是、N-否")
    @Column(nullable=true,length=25)
    private String decisionbyline_s;
    
    @Comment("生产机台条码")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("门尼机台条码")
    @Column(nullable=true,length=25)
    private String equip_mi_s;
    
    @Comment("生产机台名称")
    @Column(nullable=true,length=25)
    private String equip_name_s;
    
    @Comment("硫变仪机台条码")
    @Column(nullable=true,length=25)
    private String equip_sa_s;
    
    @Comment("物料过期日期")
    @Column(nullable=true,length=80)
    private String expiry_date_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("是否发送密炼：Y-是、N-否")
    @Column(nullable=true,length=25)
    private String is_sendmix_s;
    
    @Comment("胶料批次号")
    @Column(nullable=true,length=25)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=25)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=80)
    private String product_time_s;
    
    @Comment("生产日期：yyyyMMdd")
    @Column(nullable=true,length=80)
    private String prod_date_s;
    
    @Comment("生产班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String prod_shiift_s;
    
    @Comment("质量备注")
    @Column(nullable=true,length=600)
    private String qc_mark_s;
    
    @Comment("快检检验配方编号")
    @Column(nullable=true,length=80)
    private String quickcheck_recipe_code_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("取样试样号：喷码编码")
    @Column(nullable=true,length=25)
    private String sampleno_s;
    
    @Comment("顺序号")
    @Column(nullable=true,length=0)
    private Integer seq_i;
    
    @Comment("快检班次")
    @Column(nullable=true,length=25)
    private String shiift_check_s;
    
    @Comment("备用字段1：TS1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2：是否复检：N-否、Y-是")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3：T25")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("最终检测结果")
    @Column(nullable=true,length=25)
    private String state_code_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("取样车次号")
    @Column(nullable=true,length=25)
    private String train_num_s;
    
    @Comment("密炼工单跟踪表，工单号")
    @Column(nullable=true,length=80)
    private String wo_no_s;
    
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
        
    public String getCheck_time_s(){
        return check_time_s;
    }
    
    @XmlElement
    public void setCheck_time_s(String check_time_s){
        this.check_time_s=check_time_s;
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
        
    public String getDecisionbyline_s(){
        return decisionbyline_s;
    }
    
    @XmlElement
    public void setDecisionbyline_s(String decisionbyline_s){
        this.decisionbyline_s=decisionbyline_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_mi_s(){
        return equip_mi_s;
    }
    
    @XmlElement
    public void setEquip_mi_s(String equip_mi_s){
        this.equip_mi_s=equip_mi_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public String getEquip_sa_s(){
        return equip_sa_s;
    }
    
    @XmlElement
    public void setEquip_sa_s(String equip_sa_s){
        this.equip_sa_s=equip_sa_s;
    }
        
    public String getExpiry_date_s(){
        return expiry_date_s;
    }
    
    @XmlElement
    public void setExpiry_date_s(String expiry_date_s){
        this.expiry_date_s=expiry_date_s;
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
        
    public String getIs_sendmix_s(){
        return is_sendmix_s;
    }
    
    @XmlElement
    public void setIs_sendmix_s(String is_sendmix_s){
        this.is_sendmix_s=is_sendmix_s;
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
        
    public String getProduct_time_s(){
        return product_time_s;
    }
    
    @XmlElement
    public void setProduct_time_s(String product_time_s){
        this.product_time_s=product_time_s;
    }
        
    public String getProd_date_s(){
        return prod_date_s;
    }
    
    @XmlElement
    public void setProd_date_s(String prod_date_s){
        this.prod_date_s=prod_date_s;
    }
        
    public String getProd_shiift_s(){
        return prod_shiift_s;
    }
    
    @XmlElement
    public void setProd_shiift_s(String prod_shiift_s){
        this.prod_shiift_s=prod_shiift_s;
    }
        
    public String getQc_mark_s(){
        return qc_mark_s;
    }
    
    @XmlElement
    public void setQc_mark_s(String qc_mark_s){
        this.qc_mark_s=qc_mark_s;
    }
        
    public String getQuickcheck_recipe_code_s(){
        return quickcheck_recipe_code_s;
    }
    
    @XmlElement
    public void setQuickcheck_recipe_code_s(String quickcheck_recipe_code_s){
        this.quickcheck_recipe_code_s=quickcheck_recipe_code_s;
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
        
    public String getSampleno_s(){
        return sampleno_s;
    }
    
    @XmlElement
    public void setSampleno_s(String sampleno_s){
        this.sampleno_s=sampleno_s;
    }
        
    public Integer getSeq_i(){
        return seq_i;
    }
    
    @XmlElement
    public void setSeq_i(Integer seq_i){
        this.seq_i=seq_i;
    }
        
    public String getShiift_check_s(){
        return shiift_check_s;
    }
    
    @XmlElement
    public void setShiift_check_s(String shiift_check_s){
        this.shiift_check_s=shiift_check_s;
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
        
    public String getState_code_s(){
        return state_code_s;
    }
    
    @XmlElement
    public void setState_code_s(String state_code_s){
        this.state_code_s=state_code_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTrain_num_s(){
        return train_num_s;
    }
    
    @XmlElement
    public void setTrain_num_s(String train_num_s){
        this.train_num_s=train_num_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
