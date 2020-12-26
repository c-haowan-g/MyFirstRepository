/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 质量降级汇总表
 * @author 周志祥
 * @Date 2019-03-13 08:33:42
 */
@ATDefinition("C_MM_QUALITYDEGRADE")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_QUALITYDEGRADE")
public class QualityDegrade extends RockWellBaseEntity{
    
    
    @Comment("审核意见")
    @Column(nullable=true,length=80)
    private String auditing_opinion_s;
    
    @Comment("审核状态")
    @Column(nullable=true,length=80)
    private String auditing_status_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date auditing_time_t;
    
    @Comment("审核人ID")
    @Column(nullable=true,length=80)
    private String auditing_userid_s;
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("成型机台")
    @Column(nullable=true,length=80)
    private String buildinmachinecode_s;
    
    @Comment("硫化机台")
    @Column(nullable=true,length=80)
    private String curingequip_code_s;
    
    @Comment("硫化时间")
    @Column(nullable=true,length=0)
    private Date curingtime_t;
    
    @Comment("动平衡等级")
    @Column(nullable=true,length=80)
    private String dynamicbalancegradecode_s;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String item_s;
    
    @Comment("判定级别")
    @Column(nullable=true,length=80)
    private String judge_grade_s;
    
    @Comment("判定人时间")
    @Column(nullable=true,length=0)
    private Date judge_time_t;
    
    @Comment("判定人")
    @Column(nullable=true,length=80)
    private String judge_userid_s;
    
    @Comment("操作员")
    @Column(nullable=true,length=80)
    private String operator_s;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date operator_time_t;
    
    @Comment("项目分类")
    @Column(nullable=true,length=80)
    private String pro_type_s;
    
    @Comment("病象")
    @Column(nullable=true,length=80)
    private String reascode_s_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("来源  1-报警;2-检测;3-改判")
    @Column(nullable=true,length=80)
    private String source_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spear10_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String spear1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String spear2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spear3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String spear4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spear5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String spear6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spear7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spear8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spear9_s;
    
    @Comment("规格名称")
    @Column(nullable=true,length=80)
    private String specname_s;
    
    @Comment(" 工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    public String getAuditing_opinion_s(){
        return auditing_opinion_s;
    }
    
    @XmlElement
    public void setAuditing_opinion_s(String auditing_opinion_s){
        this.auditing_opinion_s=auditing_opinion_s;
    }
        
    public String getAuditing_status_s(){
        return auditing_status_s;
    }
    
    @XmlElement
    public void setAuditing_status_s(String auditing_status_s){
        this.auditing_status_s=auditing_status_s;
    }
        
    public Date getAuditing_time_t(){
        return auditing_time_t;
    }
    
    @XmlElement
    public void setAuditing_time_t(Date auditing_time_t){
        this.auditing_time_t=auditing_time_t;
    }
        
    public String getAuditing_userid_s(){
        return auditing_userid_s;
    }
    
    @XmlElement
    public void setAuditing_userid_s(String auditing_userid_s){
        this.auditing_userid_s=auditing_userid_s;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getBuildinmachinecode_s(){
        return buildinmachinecode_s;
    }
    
    @XmlElement
    public void setBuildinmachinecode_s(String buildinmachinecode_s){
        this.buildinmachinecode_s=buildinmachinecode_s;
    }
        
    public String getCuringequip_code_s(){
        return curingequip_code_s;
    }
    
    @XmlElement
    public void setCuringequip_code_s(String curingequip_code_s){
        this.curingequip_code_s=curingequip_code_s;
    }
        
    public Date getCuringtime_t(){
        return curingtime_t;
    }
    
    @XmlElement
    public void setCuringtime_t(Date curingtime_t){
        this.curingtime_t=curingtime_t;
    }
        
    public String getDynamicbalancegradecode_s(){
        return dynamicbalancegradecode_s;
    }
    
    @XmlElement
    public void setDynamicbalancegradecode_s(String dynamicbalancegradecode_s){
        this.dynamicbalancegradecode_s=dynamicbalancegradecode_s;
    }
        
    public String getItem_s(){
        return item_s;
    }
    
    @XmlElement
    public void setItem_s(String item_s){
        this.item_s=item_s;
    }
        
    public String getJudge_grade_s(){
        return judge_grade_s;
    }
    
    @XmlElement
    public void setJudge_grade_s(String judge_grade_s){
        this.judge_grade_s=judge_grade_s;
    }
        
    public Date getJudge_time_t(){
        return judge_time_t;
    }
    
    @XmlElement
    public void setJudge_time_t(Date judge_time_t){
        this.judge_time_t=judge_time_t;
    }
        
    public String getJudge_userid_s(){
        return judge_userid_s;
    }
    
    @XmlElement
    public void setJudge_userid_s(String judge_userid_s){
        this.judge_userid_s=judge_userid_s;
    }
        
    public String getOperator_s(){
        return operator_s;
    }
    
    @XmlElement
    public void setOperator_s(String operator_s){
        this.operator_s=operator_s;
    }
        
    public Date getOperator_time_t(){
        return operator_time_t;
    }
    
    @XmlElement
    public void setOperator_time_t(Date operator_time_t){
        this.operator_time_t=operator_time_t;
    }
        
    public String getPro_type_s(){
        return pro_type_s;
    }
    
    @XmlElement
    public void setPro_type_s(String pro_type_s){
        this.pro_type_s=pro_type_s;
    }
        
    public String getReascode_s_s(){
        return reascode_s_s;
    }
    
    @XmlElement
    public void setReascode_s_s(String reascode_s_s){
        this.reascode_s_s=reascode_s_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSource_s(){
        return source_s;
    }
    
    @XmlElement
    public void setSource_s(String source_s){
        this.source_s=source_s;
    }
        
    public String getSpear10_s(){
        return spear10_s;
    }
    
    @XmlElement
    public void setSpear10_s(String spear10_s){
        this.spear10_s=spear10_s;
    }
        
    public String getSpear1_s(){
        return spear1_s;
    }
    
    @XmlElement
    public void setSpear1_s(String spear1_s){
        this.spear1_s=spear1_s;
    }
        
    public String getSpear2_s(){
        return spear2_s;
    }
    
    @XmlElement
    public void setSpear2_s(String spear2_s){
        this.spear2_s=spear2_s;
    }
        
    public String getSpear3_s(){
        return spear3_s;
    }
    
    @XmlElement
    public void setSpear3_s(String spear3_s){
        this.spear3_s=spear3_s;
    }
        
    public String getSpear4_s(){
        return spear4_s;
    }
    
    @XmlElement
    public void setSpear4_s(String spear4_s){
        this.spear4_s=spear4_s;
    }
        
    public String getSpear5_s(){
        return spear5_s;
    }
    
    @XmlElement
    public void setSpear5_s(String spear5_s){
        this.spear5_s=spear5_s;
    }
        
    public String getSpear6_s(){
        return spear6_s;
    }
    
    @XmlElement
    public void setSpear6_s(String spear6_s){
        this.spear6_s=spear6_s;
    }
        
    public String getSpear7_s(){
        return spear7_s;
    }
    
    @XmlElement
    public void setSpear7_s(String spear7_s){
        this.spear7_s=spear7_s;
    }
        
    public String getSpear8_s(){
        return spear8_s;
    }
    
    @XmlElement
    public void setSpear8_s(String spear8_s){
        this.spear8_s=spear8_s;
    }
        
    public String getSpear9_s(){
        return spear9_s;
    }
    
    @XmlElement
    public void setSpear9_s(String spear9_s){
        this.spear9_s=spear9_s;
    }
        
    public String getSpecname_s(){
        return specname_s;
    }
    
    @XmlElement
    public void setSpecname_s(String specname_s){
        this.specname_s=specname_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
