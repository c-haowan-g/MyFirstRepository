/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 半部件校称记录表
 * @author 时永良
 * @Date 2020-12-08 13:34:03
 */
@ATDefinition("A_EM_CALIBRATIONRECORD")
@Entity
@XmlRootElement
@Table(name="AT_A_EM_CALIBRATIONRECORD")
public class CalibRationRecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002 柳州 8003 泰国 8004 荆门8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("班组")
    @Column(nullable=true,length=80)
    private String classcode_s;
    
    @Comment("班次")
    @Column(nullable=true,length=80)
    private String classteam_s;
    
    @Comment("检测时间")
    @Column(nullable=false,length=0)
    private Date detectiontime_t;
    
    @Comment("产线名称")
    @Column(nullable=true,length=80)
    private String productionline_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("称量结果")
    @Column(nullable=true,length=80)
    private String result_s;
    
    @Comment(" 备用字段1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment(" 备用字段2")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment(" 备用字段3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment(" 备用字段4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment(" 备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("标准重量")
    @Column(nullable=true,length=0)
    private String standardweight_f;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("公差值")
    @Column(nullable=true,length=0)
    private String tolerance_f;
    
    @Comment("称量重量")
    @Column(nullable=false,length=0)
    private String weight_f;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String workerid_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getClasscode_s(){
        return classcode_s;
    }
    
    @XmlElement
    public void setClasscode_s(String classcode_s){
        this.classcode_s=classcode_s;
    }
        
    public String getClassteam_s(){
        return classteam_s;
    }
    
    @XmlElement
    public void setClassteam_s(String classteam_s){
        this.classteam_s=classteam_s;
    }
        
    public Date getDetectiontime_t(){
        return detectiontime_t;
    }
    
    @XmlElement
    public void setDetectiontime_t(Date detectiontime_t){
        this.detectiontime_t=detectiontime_t;
    }
        
    public String getProductionline_s(){
        return productionline_s;
    }
    
    @XmlElement
    public void setProductionline_s(String productionline_s){
        this.productionline_s=productionline_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getResult_s(){
        return result_s;
    }
    
    @XmlElement
    public void setResult_s(String result_s){
        this.result_s=result_s;
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
        
    public String getStandardweight_f(){
        return standardweight_f;
    }
    
    @XmlElement
    public void setStandardweight_f(String standardweight_f){
        this.standardweight_f=standardweight_f;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTolerance_f(){
        return tolerance_f;
    }
    
    @XmlElement
    public void setTolerance_f(String tolerance_f){
        this.tolerance_f=tolerance_f;
    }
        
    public String getWeight_f(){
        return weight_f;
    }
    
    @XmlElement
    public void setWeight_f(String weight_f){
        this.weight_f=weight_f;
    }
        
    public String getWorkerid_s(){
        return workerid_s;
    }
    
    @XmlElement
    public void setWorkerid_s(String workerid_s){
        this.workerid_s=workerid_s;
    }
        
    
    
    
}
