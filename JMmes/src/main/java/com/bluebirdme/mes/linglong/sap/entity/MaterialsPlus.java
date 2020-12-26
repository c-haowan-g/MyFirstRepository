/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity;

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
 * 物料信息扩展表
 * @author 周清玉
 * @Date 2019-05-05 10:32:29
 */
@ATDefinition("INT_SAP_MATERIALSPLUS")
@Entity
@XmlRootElement
@Table(name="AT_INT_SAP_MATERIALSPLUS")
public class MaterialsPlus extends RockWellBaseEntity{
    
    
    @Comment("机构代码")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("警报值")
    @Column(nullable=true,length=0)
    private String alarmvalue_f;
    
    @Comment("子口宽")
    @Column(nullable=false,length=0)
    private String beadwidth_d;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("内径")
    @Column(nullable=false,length=0)
    private String innerdia_d;
    
    @Comment("物料编号80位")
    @Column(nullable=true,length=600)
    private String materialcode_s;
    
    @Comment("物料描述")
    @Column(nullable=true,length=600)
    private String materialdesc_s;
    
    @Comment("规格")
    @Column(nullable=true,length=200)
    private String materialspec_s;
    
    @Comment("最大库存")
    @Column(nullable=true,length=0)
    private String maximumstock_f;
    
    @Comment("最小库存")
    @Column(nullable=true,length=0)
    private String minimumstock_f;
    
    @Comment("外径")
    @Column(nullable=false,length=0)
    private String outerdia_d;
    
    @Comment("最大存放时间")
    @Column(nullable=true,length=0)
    private String overtime_f;
    
    @Comment("A有效，D无效")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("最小存放时间")
    @Column(nullable=true,length=0)
    private String smalltime_f;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
    @Comment("备用字段11")
    @Column(nullable=true,length=80)
    private String spare11_s;
    
    @Comment("备用字段12")
    @Column(nullable=true,length=80)
    private String spare12_s;
    
    @Comment("备用字段13")
    @Column(nullable=true,length=80)
    private String spare13_s;
    
    @Comment("备用字段14")
    @Column(nullable=true,length=80)
    private String spare14_s;
    
    @Comment("备用字段15")
    @Column(nullable=true,length=80)
    private String spare15_s;
    
    @Comment("备用字段16")
    @Column(nullable=true,length=80)
    private String spare16_s;
    
    @Comment("备用字段17")
    @Column(nullable=true,length=80)
    private String spare17_s;
    
    @Comment("备用字段18")
    @Column(nullable=true,length=80)
    private String spare18_s;
    
    @Comment("备用字段19")
    @Column(nullable=true,length=80)
    private String spare19_s;
    
    @Comment("钢丝压延垫布层数")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段20")
    @Column(nullable=true,length=80)
    private String spare20_s;
    
    @Comment("打印卡片最大数量")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("加温是否管控：0-否、1-是")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("最短加温时间")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("最长加温时间")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("有效期是否管控：0-否、1-是")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("库存是否报警：0-否、1-是")
    @Column(nullable=true,length=80)
    private String stockalarm_s;
    
    @Comment("工厂")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("截面高-未用")
    @Column(nullable=false,length=0)
    private String tyreheight_d;
    
    @Comment("断面宽-左用")
    @Column(nullable=false,length=0)
    private String tyrewidth_d;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlarmvalue_f(){
        return alarmvalue_f;
    }
    
    @XmlElement
    public void setAlarmvalue_f(String alarmvalue_f){
        this.alarmvalue_f=alarmvalue_f;
    }
        
    public String getBeadwidth_d(){
        return beadwidth_d;
    }
    
    @XmlElement
    public void setBeadwidth_d(String beadwidth_d){
        this.beadwidth_d=beadwidth_d;
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
        
    public String getInnerdia_d(){
        return innerdia_d;
    }
    
    @XmlElement
    public void setInnerdia_d(String innerdia_d){
        this.innerdia_d=innerdia_d;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialdesc_s(){
        return materialdesc_s;
    }
    
    @XmlElement
    public void setMaterialdesc_s(String materialdesc_s){
        this.materialdesc_s=materialdesc_s;
    }
        
    public String getMaterialspec_s(){
        return materialspec_s;
    }
    
    @XmlElement
    public void setMaterialspec_s(String materialspec_s){
        this.materialspec_s=materialspec_s;
    }
        
    public String getMaximumstock_f(){
        return maximumstock_f;
    }
    
    @XmlElement
    public void setMaximumstock_f(String maximumstock_f){
        this.maximumstock_f=maximumstock_f;
    }
        
    public String getMinimumstock_f(){
        return minimumstock_f;
    }
    
    @XmlElement
    public void setMinimumstock_f(String minimumstock_f){
        this.minimumstock_f=minimumstock_f;
    }
        
    public String getOuterdia_d(){
        return outerdia_d;
    }
    
    @XmlElement
    public void setOuterdia_d(String outerdia_d){
        this.outerdia_d=outerdia_d;
    }
        
    public String getOvertime_f(){
        return overtime_f;
    }
    
    @XmlElement
    public void setOvertime_f(String overtime_f){
        this.overtime_f=overtime_f;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSmalltime_f(){
        return smalltime_f;
    }
    
    @XmlElement
    public void setSmalltime_f(String smalltime_f){
        this.smalltime_f=smalltime_f;
    }
        
    public String getSpare10_s(){
    	return spare10_s;
    }
    
    @XmlElement
    public void setSpare10_s(String spare10_s){
        this.spare10_s=spare10_s;
    }
        
    public String getSpare11_s(){
        return spare11_s;
    }
    
    @XmlElement
    public void setSpare11_s(String spare11_s){
        this.spare11_s=spare11_s;
    }
        
    public String getSpare12_s(){
        return spare12_s;
    }
    
    @XmlElement
    public void setSpare12_s(String spare12_s){
        this.spare12_s=spare12_s;
    }
        
    public String getSpare13_s(){
        return spare13_s;
    }
    
    @XmlElement
    public void setSpare13_s(String spare13_s){
        this.spare13_s=spare13_s;
    }
        
    public String getSpare14_s(){
        return spare14_s;
    }
    
    @XmlElement
    public void setSpare14_s(String spare14_s){
        this.spare14_s=spare14_s;
    }
        
    public String getSpare15_s(){
        return spare15_s;
    }
    
    @XmlElement
    public void setSpare15_s(String spare15_s){
        this.spare15_s=spare15_s;
    }
        
    public String getSpare16_s(){
        return spare16_s;
    }
    
    @XmlElement
    public void setSpare16_s(String spare16_s){
        this.spare16_s=spare16_s;
    }
        
    public String getSpare17_s(){
        return spare17_s;
    }
    
    @XmlElement
    public void setSpare17_s(String spare17_s){
        this.spare17_s=spare17_s;
    }
        
    public String getSpare18_s(){
        return spare18_s;
    }
    
    @XmlElement
    public void setSpare18_s(String spare18_s){
        this.spare18_s=spare18_s;
    }
        
    public String getSpare19_s(){
        return spare19_s;
    }
    
    @XmlElement
    public void setSpare19_s(String spare19_s){
        this.spare19_s=spare19_s;
    }
        
    public String getSpare1_s(){
        return spare1_s;
    }
    
    @XmlElement
    public void setSpare1_s(String spare1_s){
        this.spare1_s=spare1_s;
    }
        
    public String getSpare20_s(){
        return spare20_s;
    }
    
    @XmlElement
    public void setSpare20_s(String spare20_s){
        this.spare20_s=spare20_s;
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
        
    public String getStockalarm_s(){
        return stockalarm_s;
    }
    
    @XmlElement
    public void setStockalarm_s(String stockalarm_s){
        this.stockalarm_s=stockalarm_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyreheight_d(){
        return tyreheight_d;
    }
    
    @XmlElement
    public void setTyreheight_d(String tyreheight_d){
        this.tyreheight_d=tyreheight_d;
    }
        
    public String getTyrewidth_d(){
        return tyrewidth_d;
    }
    
    @XmlElement
    public void setTyrewidth_d(String tyrewidth_d){
        this.tyrewidth_d=tyrewidth_d;
    }
        
    
    
    
}
