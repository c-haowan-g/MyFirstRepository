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
 * TDM检测任务拒绝表[TDM发MES]
 * @author 李昂
 * @Date 2020-08-12 08:39:19
 */
@ATDefinition("INT_TDM_TESTTASKDENIAL")
@Entity
@XmlRootElement
@Table(name="AT_INT_TDM_TESTTASKDENIAL")
public class TestTaskDenial extends RockWellBaseEntity{
    
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("预留1")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("MES 业务主键")
    @Column(nullable=true,length=80)
    private String mesbusinesscode_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("拒绝原因")
    @Column(nullable=true,length=80)
    private String refusereason_s;
    
    @Comment("样品批次：进厂批次")
    @Column(nullable=true,length=80)
    private String samplebatch_s;
    
    @Comment("条码：长度21位  条码前九位（物料名）、后六位（厂家）")
    @Column(nullable=true,length=80)
    private String venderbatch_s;
    
    @Comment("条码：长度15位  条码前九位（物料名）、后六位（厂家）")
    @Column(nullable=true,length=80)
    private String venderbatch_short_s;
    
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
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
        
    public String getRefusereason_s(){
        return refusereason_s;
    }
    
    @XmlElement
    public void setRefusereason_s(String refusereason_s){
        this.refusereason_s=refusereason_s;
    }
        
    public String getSamplebatch_s(){
        return samplebatch_s;
    }
    
    @XmlElement
    public void setSamplebatch_s(String samplebatch_s){
        this.samplebatch_s=samplebatch_s;
    }
        
    public String getVenderbatch_s(){
        return venderbatch_s;
    }
    
    @XmlElement
    public void setVenderbatch_s(String venderbatch_s){
        this.venderbatch_s=venderbatch_s;
    }
        
    public String getVenderbatch_short_s(){
        return venderbatch_short_s;
    }
    
    @XmlElement
    public void setVenderbatch_short_s(String venderbatch_short_s){
        this.venderbatch_short_s=venderbatch_short_s;
    }
        
    
    
    
}
