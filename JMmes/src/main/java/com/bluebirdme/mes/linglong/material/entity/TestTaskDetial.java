/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.entity;

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
 * TDM检测结果明细表[TDM发MES]
 * @author 李昂
 * @Date 2020-08-12 08:40:37
 */
@ATDefinition("INT_TDM_TESTTASKDETIAL")
@Entity
@XmlRootElement
@Table(name="AT_INT_TDM_TESTTASKDETIAL")
public class TestTaskDetial extends RockWellBaseEntity{
    
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("判定范围")
    @Column(nullable=true,length=80)
    private String decisionscope_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String dummy5_s;
    
    @Comment("条件实际值")
    @Column(nullable=true,length=80)
    private String executive_actualvalue_s;
    
    @Comment("条件名称")
    @Column(nullable=true,length=80)
    private String executive_name_s;
    
    @Comment("条件要求值")
    @Column(nullable=true,length=80)
    private String executive_reqvalue_s;
    
    @Comment("执行标准")
    @Column(nullable=true,length=80)
    private String executive_standard_s;
    
    @Comment("条件单位")
    @Column(nullable=true,length=80)
    private String executive_unit_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("MES业务主键：INT_TDM_TESTTASKRESULT.MESBUSINESSCODE")
    @Column(nullable=true,length=80)
    private String mesbusinesscode_s;
    
    @Comment("业务主键")
    @Column(nullable=true,length=80)
    private String natural_key_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("分项结论")
    @Column(nullable=true,length=80)
    private String sub_conclusion_s;
    
    @Comment("检测项目")
    @Column(nullable=true,length=80)
    private String test_items_s;
    
    @Comment("检测方法")
    @Column(nullable=true,length=80)
    private String test_method_s;
    
    @Comment("检测参数")
    @Column(nullable=true,length=80)
    private String test_paras_s;
    
    @Comment("测试结果")
    @Column(nullable=true,length=80)
    private String test_result_s;
    
    @Comment("条码")
    @Column(nullable=true,length=80)
    private String venderbatch_s;
    
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getDecisionscope_s(){
        return decisionscope_s;
    }
    
    @XmlElement
    public void setDecisionscope_s(String decisionscope_s){
        this.decisionscope_s=decisionscope_s;
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
        
    public String getExecutive_actualvalue_s(){
        return executive_actualvalue_s;
    }
    
    @XmlElement
    public void setExecutive_actualvalue_s(String executive_actualvalue_s){
        this.executive_actualvalue_s=executive_actualvalue_s;
    }
        
    public String getExecutive_name_s(){
        return executive_name_s;
    }
    
    @XmlElement
    public void setExecutive_name_s(String executive_name_s){
        this.executive_name_s=executive_name_s;
    }
        
    public String getExecutive_reqvalue_s(){
        return executive_reqvalue_s;
    }
    
    @XmlElement
    public void setExecutive_reqvalue_s(String executive_reqvalue_s){
        this.executive_reqvalue_s=executive_reqvalue_s;
    }
        
    public String getExecutive_standard_s(){
        return executive_standard_s;
    }
    
    @XmlElement
    public void setExecutive_standard_s(String executive_standard_s){
        this.executive_standard_s=executive_standard_s;
    }
        
    public String getExecutive_unit_s(){
        return executive_unit_s;
    }
    
    @XmlElement
    public void setExecutive_unit_s(String executive_unit_s){
        this.executive_unit_s=executive_unit_s;
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
        
    public String getMesbusinesscode_s(){
        return mesbusinesscode_s;
    }
    
    @XmlElement
    public void setMesbusinesscode_s(String mesbusinesscode_s){
        this.mesbusinesscode_s=mesbusinesscode_s;
    }
        
    public String getNatural_key_s(){
        return natural_key_s;
    }
    
    @XmlElement
    public void setNatural_key_s(String natural_key_s){
        this.natural_key_s=natural_key_s;
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
        
    public String getSub_conclusion_s(){
        return sub_conclusion_s;
    }
    
    @XmlElement
    public void setSub_conclusion_s(String sub_conclusion_s){
        this.sub_conclusion_s=sub_conclusion_s;
    }
        
    public String getTest_items_s(){
        return test_items_s;
    }
    
    @XmlElement
    public void setTest_items_s(String test_items_s){
        this.test_items_s=test_items_s;
    }
        
    public String getTest_method_s(){
        return test_method_s;
    }
    
    @XmlElement
    public void setTest_method_s(String test_method_s){
        this.test_method_s=test_method_s;
    }
        
    public String getTest_paras_s(){
        return test_paras_s;
    }
    
    @XmlElement
    public void setTest_paras_s(String test_paras_s){
        this.test_paras_s=test_paras_s;
    }
        
    public String getTest_result_s(){
        return test_result_s;
    }
    
    @XmlElement
    public void setTest_result_s(String test_result_s){
        this.test_result_s=test_result_s;
    }
        
    public String getVenderbatch_s(){
        return venderbatch_s;
    }
    
    @XmlElement
    public void setVenderbatch_s(String venderbatch_s){
        this.venderbatch_s=venderbatch_s;
    }
        
    
    
    
}
