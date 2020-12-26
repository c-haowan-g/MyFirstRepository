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
 * PLM动平衡参数表
 * @author 刘程明
 * @Date 2018-12-05 14:25:20
 */
@ATDefinition("INT_PLM_DYNAMICBALANCE")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_DYNAMICBALANCE")
public class PlmDynamicBalance extends RockWellBaseEntity{
    
    
    @Comment("胎圈直径(内径)")
    @Column(nullable=true,length=80)
    private String beaddiameter_s;
    
    @Comment("CON")
    @Column(nullable=true,length=80)
    private String con_s;
    
    @Comment("凹凸度")
    @Column(nullable=true,length=80)
    private String camber_s;
    
    @Comment("类别：TBROE、TBRRE")
    @Column(nullable=true,length=80)
    private String category_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String comment_s;
    
    @Comment("描述")
    @Column(nullable=true,length=80)
    private String description_s;
    
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
    
    @Comment("外直径")
    @Column(nullable=true,length=80)
    private String externaldiameter_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("等级")
    @Column(nullable=true,length=80)
    private String grade_s;
    
    @Comment("层级")
    @Column(nullable=true,length=80)
    private String hierarchy_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("LFV")
    @Column(nullable=true,length=80)
    private String lfv_s;
    
    @Comment("侧向跳动")
    @Column(nullable=true,length=80)
    private String lateralbeating_s;
    
    @Comment("负荷")
    @Column(nullable=true,length=80)
    private String load_s;
    
    @Comment("最大外径")
    @Column(nullable=true,length=80)
    private String maxoutsidediameter_s;
    
    @Comment("最小外径")
    @Column(nullable=true,length=80)
    private String minimumoutsidediameter_s;
    
    @Comment("花纹")
    @Column(nullable=true,length=80)
    private String pattern_s;
    
    @Comment("气压")
    @Column(nullable=true,length=80)
    private String pressure_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("RFV")
    @Column(nullable=true,length=80)
    private String rfv_s;
    
    @Comment("RIH")
    @Column(nullable=true,length=80)
    private String rih_s;
    
    @Comment("径向跳动")
    @Column(nullable=true,length=80)
    private String runout_s;
    
    @Comment("SAP号")
    @Column(nullable=true,length=80)
    private String sapcode_s;
    
    @Comment("数据同步处理：A-新增、U-修改、D-删除")
    @Column(nullable=true,length=80)
    private String sync_flag_s;
    
    @Comment("轮胎断面宽度(充气后最宽的部分)")
    @Column(nullable=true,length=80)
    private String sectionwidth_s;
    
    @Comment("打标特殊要求")
    @Column(nullable=true,length=80)
    private String specialrequire_s;
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("静平衡")
    @Column(nullable=true,length=80)
    private String staticbalance_s;
    
    @Comment("胎压公差")
    @Column(nullable=true,length=80)
    private String tirepressuretolerance_s;
    
    @Comment("Total")
    @Column(nullable=true,length=80)
    private String total_s;
    
    @Comment("Up/Low")
    @Column(nullable=true,length=80)
    private String uplow_s;
    
    public String getBeaddiameter_s(){
        return beaddiameter_s;
    }
    
    @XmlElement
    public void setBeaddiameter_s(String beaddiameter_s){
        this.beaddiameter_s=beaddiameter_s;
    }
        
    public String getCon_s(){
        return con_s;
    }
    
    @XmlElement
    public void setCon_s(String con_s){
        this.con_s=con_s;
    }
        
    public String getCamber_s(){
        return camber_s;
    }
    
    @XmlElement
    public void setCamber_s(String camber_s){
        this.camber_s=camber_s;
    }
        
    public String getCategory_s(){
        return category_s;
    }
    
    @XmlElement
    public void setCategory_s(String category_s){
        this.category_s=category_s;
    }
        
    public String getComment_s(){
        return comment_s;
    }
    
    @XmlElement
    public void setComment_s(String comment_s){
        this.comment_s=comment_s;
    }
        
    public String getDescription_s(){
        return description_s;
    }
    
    @XmlElement
    public void setDescription_s(String description_s){
        this.description_s=description_s;
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
        
    public String getExternaldiameter_s(){
        return externaldiameter_s;
    }
    
    @XmlElement
    public void setExternaldiameter_s(String externaldiameter_s){
        this.externaldiameter_s=externaldiameter_s;
    }
        
    public String getGuid_s(){
        return guid_s;
    }
    
    @XmlElement
    public void setGuid_s(String guid_s){
        this.guid_s=guid_s;
    }
        
    public String getGrade_s(){
        return grade_s;
    }
    
    @XmlElement
    public void setGrade_s(String grade_s){
        this.grade_s=grade_s;
    }
        
    public String getHierarchy_s(){
        return hierarchy_s;
    }
    
    @XmlElement
    public void setHierarchy_s(String hierarchy_s){
        this.hierarchy_s=hierarchy_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getLfv_s(){
        return lfv_s;
    }
    
    @XmlElement
    public void setLfv_s(String lfv_s){
        this.lfv_s=lfv_s;
    }
        
    public String getLateralbeating_s(){
        return lateralbeating_s;
    }
    
    @XmlElement
    public void setLateralbeating_s(String lateralbeating_s){
        this.lateralbeating_s=lateralbeating_s;
    }
        
    public String getLoad_s(){
        return load_s;
    }
    
    @XmlElement
    public void setLoad_s(String load_s){
        this.load_s=load_s;
    }
        
    public String getMaxoutsidediameter_s(){
        return maxoutsidediameter_s;
    }
    
    @XmlElement
    public void setMaxoutsidediameter_s(String maxoutsidediameter_s){
        this.maxoutsidediameter_s=maxoutsidediameter_s;
    }
        
    public String getMinimumoutsidediameter_s(){
        return minimumoutsidediameter_s;
    }
    
    @XmlElement
    public void setMinimumoutsidediameter_s(String minimumoutsidediameter_s){
        this.minimumoutsidediameter_s=minimumoutsidediameter_s;
    }
        
    public String getPattern_s(){
        return pattern_s;
    }
    
    @XmlElement
    public void setPattern_s(String pattern_s){
        this.pattern_s=pattern_s;
    }
        
    public String getPressure_s(){
        return pressure_s;
    }
    
    @XmlElement
    public void setPressure_s(String pressure_s){
        this.pressure_s=pressure_s;
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
        
    public String getRfv_s(){
        return rfv_s;
    }
    
    @XmlElement
    public void setRfv_s(String rfv_s){
        this.rfv_s=rfv_s;
    }
        
    public String getRih_s(){
        return rih_s;
    }
    
    @XmlElement
    public void setRih_s(String rih_s){
        this.rih_s=rih_s;
    }
        
    public String getRunout_s(){
        return runout_s;
    }
    
    @XmlElement
    public void setRunout_s(String runout_s){
        this.runout_s=runout_s;
    }
        
    public String getSapcode_s(){
        return sapcode_s;
    }
    
    @XmlElement
    public void setSapcode_s(String sapcode_s){
        this.sapcode_s=sapcode_s;
    }
        
    public String getSync_flag_s(){
        return sync_flag_s;
    }
    
    @XmlElement
    public void setSync_flag_s(String sync_flag_s){
        this.sync_flag_s=sync_flag_s;
    }
        
    public String getSectionwidth_s(){
        return sectionwidth_s;
    }
    
    @XmlElement
    public void setSectionwidth_s(String sectionwidth_s){
        this.sectionwidth_s=sectionwidth_s;
    }
        
    public String getSpecialrequire_s(){
        return specialrequire_s;
    }
    
    @XmlElement
    public void setSpecialrequire_s(String specialrequire_s){
        this.specialrequire_s=specialrequire_s;
    }
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getStaticbalance_s(){
        return staticbalance_s;
    }
    
    @XmlElement
    public void setStaticbalance_s(String staticbalance_s){
        this.staticbalance_s=staticbalance_s;
    }
        
    public String getTirepressuretolerance_s(){
        return tirepressuretolerance_s;
    }
    
    @XmlElement
    public void setTirepressuretolerance_s(String tirepressuretolerance_s){
        this.tirepressuretolerance_s=tirepressuretolerance_s;
    }
        
    public String getTotal_s(){
        return total_s;
    }
    
    @XmlElement
    public void setTotal_s(String total_s){
        this.total_s=total_s;
    }
        
    public String getUplow_s(){
        return uplow_s;
    }
    
    @XmlElement
    public void setUplow_s(String uplow_s){
        this.uplow_s=uplow_s;
    }
        
    
    
    
}
