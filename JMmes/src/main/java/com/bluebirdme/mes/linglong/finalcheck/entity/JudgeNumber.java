/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * 动平衡均匀机检测配套标准表
 * @author 刘程明
 * @Date 2018-11-13 13:24:54
 */
@ATDefinition("D_BS_JudgeNumber")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_JudgeNumber")
public class JudgeNumber extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=2)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=20)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("设备类：254001-割毛，254002-外观，254003-X光机、254004-动平衡、254005-均匀性、254006-入库")
    @Column(nullable=false,length=80)
    private String enttype_s;
    
    @Comment("该标准编号下的规格数")
    @Column(nullable=true,length=20)
    private String itemcount_s;
    
    @Comment("检测标准编号")
    @Column(nullable=false,length=20)
    private String judgeno_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
    @Comment("规格备注")
    @Column(nullable=true,length=20)
    private String remark_s;
    
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=5)
    private String s_factory_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
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
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getEnttype_s(){
        return enttype_s;
    }
    
    @XmlElement
    public void setEnttype_s(String enttype_s){
        this.enttype_s=enttype_s;
    }
        
    public String getItemcount_s(){
        return itemcount_s;
    }
    
    @XmlElement
    public void setItemcount_s(String itemcount_s){
        this.itemcount_s=itemcount_s;
    }
        
    public String getJudgeno_s(){
        return judgeno_s;
    }
    
    @XmlElement
    public void setJudgeno_s(String judgeno_s){
        this.judgeno_s=judgeno_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemark_s(){
        return remark_s;
    }
    
    @XmlElement
    public void setRemark_s(String remark_s){
        this.remark_s=remark_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
