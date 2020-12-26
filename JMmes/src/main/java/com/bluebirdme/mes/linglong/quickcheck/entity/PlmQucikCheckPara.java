/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.quickcheck.entity;

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
 * PLM快检标准参数从表
 * @author 肖吉朔
 * @Date 2020-08-18 13:50:49
 */
@ATDefinition("INT_PLM_QUICKCHECKPARA")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_QUICKCHECKPARA")
public class PlmQucikCheckPara extends RockWellBaseEntity{
    
    
    @Comment("预留1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=80)
    private String dummy5_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("检验项目类型：门尼类、硫变类、硬度类、比重类、物性、VMA、其它 门尼类：M(1+4)、T5 硫变类：ML、MH、Ts1、T25、T30、T60、T90、T25' 硬度类：硬度 比重类：比重 物性：H抽出 VMA：流动值、膨胀率 其它：△G'、X")
    @Column(nullable=true,length=80)
    private String inspectionitemname_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方编号-13位：外键，INT_PLM_QUICKCHECK.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("检测方法： 门尼类：M(1+4)、T5 硫变类：ML、MH、Ts1、T25、T30、T60、T90、T25' 硬度类：硬度 比重类：比重 物性：H抽出 VMA：流动值、膨胀率 其它：△G'、X 说明： 1、温度环境+检验时长（分钟），例如：150+3，150度的环境下，做3分钟的试验 2、ML+(预热（分钟）+检验时长（分钟）)，例如：ML(1+4)，预热1分钟，实验4分钟")
    @Column(nullable=true,length=80)
    private String testmethod_s;
    
    @Comment("上限值符号：0-不包含、1-包含")
    @Column(nullable=true,length=80)
    private String valuemaxsign_s;
    
    @Comment("上限值")
    @Column(nullable=true,length=80)
    private String valuemax_s;
    
    @Comment("下限值符号：0-不包含、1-包含")
    @Column(nullable=true,length=80)
    private String valueminsign_s;
    
    @Comment("下限值")
    @Column(nullable=true,length=80)
    private String valuemin_s;
    
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
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInspectionitemname_s(){
        return inspectionitemname_s;
    }
    
    @XmlElement
    public void setInspectionitemname_s(String inspectionitemname_s){
        this.inspectionitemname_s=inspectionitemname_s;
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
        
    public String getTestmethod_s(){
        return testmethod_s;
    }
    
    @XmlElement
    public void setTestmethod_s(String testmethod_s){
        this.testmethod_s=testmethod_s;
    }
        
    public String getValuemaxsign_s(){
        return valuemaxsign_s;
    }
    
    @XmlElement
    public void setValuemaxsign_s(String valuemaxsign_s){
        this.valuemaxsign_s=valuemaxsign_s;
    }
        
    public String getValuemax_s(){
        return valuemax_s;
    }
    
    @XmlElement
    public void setValuemax_s(String valuemax_s){
        this.valuemax_s=valuemax_s;
    }
        
    public String getValueminsign_s(){
        return valueminsign_s;
    }
    
    @XmlElement
    public void setValueminsign_s(String valueminsign_s){
        this.valueminsign_s=valueminsign_s;
    }
        
    public String getValuemin_s(){
        return valuemin_s;
    }
    
    @XmlElement
    public void setValuemin_s(String valuemin_s){
        this.valuemin_s=valuemin_s;
    }
        
    
    
    
}
