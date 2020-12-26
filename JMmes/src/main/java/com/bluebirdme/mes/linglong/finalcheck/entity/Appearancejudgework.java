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
 * 外观改判作业记录履历
 * @author 徐秉正
 * @Date 2020-05-15 13:22:56
 */
@ATDefinition("D_QM_APPEARANCEJUDGEWORK")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_APPEARANCEJUDGEWORK")
public class Appearancejudgework extends RockWellBaseEntity{
    
    
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
    
    @Comment("改判人")
    @Column(nullable=true,length=80)
    private String operator_s;
    
    @Comment("记录标志(A可用 D删除)")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
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
        
    public String getOperator_s(){
        return operator_s;
    }
    
    @XmlElement
    public void setOperator_s(String operator_s){
        this.operator_s=operator_s;
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
        
    
    
    
}
