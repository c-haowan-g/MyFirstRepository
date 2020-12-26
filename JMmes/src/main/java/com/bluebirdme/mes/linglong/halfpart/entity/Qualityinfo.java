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
 * AT_A_QM_QUALITYINFO
 * @author 葛迎祥
 * @Date 2020-06-28 16:55:16
 */
@ATDefinition("A_QM_QualityInfo")
@Entity
@XmlRootElement
@Table(name="AT_A_QM_QUALITYINFO")
public class Qualityinfo extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("批次号")
    @Column(nullable=true,length=80)
    private String batch_code_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String bz_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("等级")
    @Column(nullable=true,length=80)
    private String grade_s;
    
    @Comment("半部件类型")
    @Column(nullable=true,length=80)
    private String halfpart_type_s;
    
    @Comment("物料代码")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String materialname_s;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date oper_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("载具条码")
    @Column(nullable=true,length=80)
    private String rfid_code_s;
    
    @Comment("病象描述")
    @Column(nullable=true,length=80)
    private String sickelephants_desc_s;
    
    @Comment("病象编号")
    @Column(nullable=true,length=80)
    private String sickelephants_no_s;
    
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
    
    @Comment("备用字段9")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("处理措施")
    @Column(nullable=true,length=80)
    private String treatmentmeaure_s;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String worker_id_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBatch_code_s(){
        return batch_code_s;
    }
    
    @XmlElement
    public void setBatch_code_s(String batch_code_s){
        this.batch_code_s=batch_code_s;
    }
        
    public String getBz_s(){
        return bz_s;
    }
    
    @XmlElement
    public void setBz_s(String bz_s){
        this.bz_s=bz_s;
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
        
    public String getGrade_s(){
        return grade_s;
    }
    
    @XmlElement
    public void setGrade_s(String grade_s){
        this.grade_s=grade_s;
    }
        
    public String getHalfpart_type_s(){
        return halfpart_type_s;
    }
    
    @XmlElement
    public void setHalfpart_type_s(String halfpart_type_s){
        this.halfpart_type_s=halfpart_type_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialname_s(){
        return materialname_s;
    }
    
    @XmlElement
    public void setMaterialname_s(String materialname_s){
        this.materialname_s=materialname_s;
    }
        
    public Date getOper_time_t(){
        return oper_time_t;
    }
    
    @XmlElement
    public void setOper_time_t(Date oper_time_t){
        this.oper_time_t=oper_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRfid_code_s(){
        return rfid_code_s;
    }
    
    @XmlElement
    public void setRfid_code_s(String rfid_code_s){
        this.rfid_code_s=rfid_code_s;
    }
        
    public String getSickelephants_desc_s(){
        return sickelephants_desc_s;
    }
    
    @XmlElement
    public void setSickelephants_desc_s(String sickelephants_desc_s){
        this.sickelephants_desc_s=sickelephants_desc_s;
    }
        
    public String getSickelephants_no_s(){
        return sickelephants_no_s;
    }
    
    @XmlElement
    public void setSickelephants_no_s(String sickelephants_no_s){
        this.sickelephants_no_s=sickelephants_no_s;
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
        
    public String getTreatmentmeaure_s(){
        return treatmentmeaure_s;
    }
    
    @XmlElement
    public void setTreatmentmeaure_s(String treatmentmeaure_s){
        this.treatmentmeaure_s=treatmentmeaure_s;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }
        
    
    
    
}
