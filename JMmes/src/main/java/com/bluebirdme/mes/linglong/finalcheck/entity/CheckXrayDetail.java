/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * X光质检信息明细表
 * @author 栾和源
 * @Date 2020-02-24 09:20:21
 */
@ATDefinition("D_QM_CHECKXRAYDETAIL")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_CHECKXRAYDETAIL")
public class CheckXrayDetail extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 荆门 8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("检查次数")
    @Column(nullable=true,length=0)
    private Integer checkseq_i;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("缺陷ID")
    @Column(nullable=true,length=80)
    private String defectid_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("记录标志，A当前可检，D历史可检")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("工厂(1.全钢 2.半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("条码号")
    @Column(nullable=false,length=80)
    private String tyrebarcode_s;
    
    @Comment("上下模")
    @Column(nullable=true,length=80)
    private String upordown_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Integer getCheckseq_i(){
        return checkseq_i;
    }
    
    @XmlElement
    public void setCheckseq_i(Integer checkseq_i){
        this.checkseq_i=checkseq_i;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDefectid_s(){
        return defectid_s;
    }
    
    @XmlElement
    public void setDefectid_s(String defectid_s){
        this.defectid_s=defectid_s;
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
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyrebarcode_s(){
        return tyrebarcode_s;
    }
    
    @XmlElement
    public void setTyrebarcode_s(String tyrebarcode_s){
        this.tyrebarcode_s=tyrebarcode_s;
    }
        
    public String getUpordown_s(){
        return upordown_s;
    }
    
    @XmlElement
    public void setUpordown_s(String upordown_s){
        this.upordown_s=upordown_s;
    }
        
    
    
    
}
