/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 取消硫化作业履历表
 * @author 孙尊龙
 * @Date 2020-05-04 11:48:45
 */
@ATDefinition("C_MM_CURINGCANCELWORK")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_CURINGCANCELWORK")
public class CuringCancelWork extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 荆门 8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("取消硫化操作时间")
    @Column(nullable=true,length=0)
    private Date curing_cancel_time_t;
    
    @Comment("硫化开始时间")
    @Column(nullable=true,length=0)
    private Date curing_state_time_t;
    
    @Comment("硫化工人")
    @Column(nullable=true,length=80)
    private String curing_worker_s;
    
    @Comment("机台ID")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String operator_s;
    
    @Comment("记录标志(A可用，D删除)")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("轮胎条码")
    @Column(nullable=true,length=80)
    private String tyrebarcode_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Date getCuring_cancel_time_t(){
        return curing_cancel_time_t;
    }
    
    @XmlElement
    public void setCuring_cancel_time_t(Date curing_cancel_time_t){
        this.curing_cancel_time_t=curing_cancel_time_t;
    }
        
    public Date getCuring_state_time_t(){
        return curing_state_time_t;
    }
    
    @XmlElement
    public void setCuring_state_time_t(Date curing_state_time_t){
        this.curing_state_time_t=curing_state_time_t;
    }
        
    public String getCuring_worker_s(){
        return curing_worker_s;
    }
    
    @XmlElement
    public void setCuring_worker_s(String curing_worker_s){
        this.curing_worker_s=curing_worker_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
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
        
    public String getTyrebarcode_s(){
        return tyrebarcode_s;
    }
    
    @XmlElement
    public void setTyrebarcode_s(String tyrebarcode_s){
        this.tyrebarcode_s=tyrebarcode_s;
    }
        
    
    
    
}
