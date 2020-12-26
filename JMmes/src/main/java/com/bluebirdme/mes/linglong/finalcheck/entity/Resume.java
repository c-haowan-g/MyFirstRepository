/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * 改判作业履历表
 * @author 徐秉正
 * @Date 2020-05-25 08:07:02
 */
@ATDefinition("REVISION_WORK_RESUME")
@Entity
@XmlRootElement
@Table(name="AT_REVISION_WORK_RESUME")
public class Resume extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远8000；德州8002 柳州8003 泰国 8004 荆门8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("改判时间")
    @Column(nullable=true,length=0)
    private Date appearancejudge_time_t;
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("改判等级")
    @Column(nullable=true,length=80)
    private String curinggradecode_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String curingspeccode_s;
    
    @Comment("当前等级")
    @Column(nullable=true,length=80)
    private String ggrade_s;
    
    @Comment("改判人")
    @Column(nullable=true,length=80)
    private String operator_s;
    
    @Comment("病象描述")
    @Column(nullable=true,length=80)
    private String reas_r_s;
    
    @Comment("记录标志(A可用 D删除)")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
    @Comment("备用字段1")
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
    
    @Comment("备用字段6")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备注9")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("工厂")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Date getAppearancejudge_time_t(){
        return appearancejudge_time_t;
    }
    
    @XmlElement
    public void setAppearancejudge_time_t(Date appearancejudge_time_t){
        this.appearancejudge_time_t=appearancejudge_time_t;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getCuringgradecode_s(){
        return curinggradecode_s;
    }
    
    @XmlElement
    public void setCuringgradecode_s(String curinggradecode_s){
        this.curinggradecode_s=curinggradecode_s;
    }
        
    public String getCuringspeccode_s(){
        return curingspeccode_s;
    }
    
    @XmlElement
    public void setCuringspeccode_s(String curingspeccode_s){
        this.curingspeccode_s=curingspeccode_s;
    }
        
    public String getGgrade_s(){
        return ggrade_s;
    }
    
    @XmlElement
    public void setGgrade_s(String ggrade_s){
        this.ggrade_s=ggrade_s;
    }
        
    public String getOperator_s(){
        return operator_s;
    }
    
    @XmlElement
    public void setOperator_s(String operator_s){
        this.operator_s=operator_s;
    }
        
    public String getReas_r_s(){
        return reas_r_s;
    }
    
    @XmlElement
    public void setReas_r_s(String reas_r_s){
        this.reas_r_s=reas_r_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    
    
    
}
