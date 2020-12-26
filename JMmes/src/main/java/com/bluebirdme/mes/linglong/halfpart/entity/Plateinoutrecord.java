/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity;

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
 * 半部件调拨记录查询
 * @author 徐秉正
 * @Date 2020-03-13 10:58:42
 */
@ATDefinition("A_MM_PLATEINOUTRECORD")
@Entity
@XmlRootElement
@Table(name="AT_A_MM_PLATEINOUTRECORD")
public class Plateinoutrecord extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("批次条码")
    @Column(nullable=true,length=80)
    private String batch_no_s;
    
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
    
    @Comment("调入位置")
    @Column(nullable=true,length=80)
    private String in_location_s;
    
    @Comment("位置")
    @Column(nullable=true,length=80)
    private String location_s;
    
    @Comment("主键")
    @Column(nullable=true,length=80)
    private String mainid_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=80)
    private String materialgroup_s;
    
    @Comment("物料编码 ")
    @Column(nullable=true,length=80)
    private String materielcode_s;
    
    @Comment("物料名称 ")
    @Column(nullable=true,length=80)
    private String materielname_s;
    
    @Comment("操作班组 ")
    @Column(nullable=true,length=80)
    private String operate_class_s;
    
    @Comment("操作班次 ")
    @Column(nullable=true,length=80)
    private String operate_shift_s;
    
    @Comment("操作类型 0 换上 1 换下")
    @Column(nullable=true,length=80)
    private String operate_type_s;
    
    @Comment("调出位置")
    @Column(nullable=true,length=80)
    private String out_location_s;
    
    @Comment("生产计划号(记录入库时生产的计划号) ")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("口型板条码")
    @Column(nullable=true,length=80)
    private String plate_no_s;
    
    @Comment("规格 ")
    @Column(nullable=true,length=80)
    private String plate_spec_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("载具条码")
    @Column(nullable=true,length=80)
    private String rfid_no_s;
    
    @Comment("SAP物料组 基础数据308 外部系统301开头的")
    @Column(nullable=true,length=80)
    private String sapm_group_s;
    
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
    
    @Comment("数量")
    @Column(nullable=true,length=0)
    private Integer weight_i;
    
    @Comment("操作人")
    @Column(nullable=true,length=80)
    private String workid_s;
    
    @Comment("操作时间")
    @Column(nullable=true,length=0)
    private Date worktime_t;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBatch_no_s(){
        return batch_no_s;
    }
    
    @XmlElement
    public void setBatch_no_s(String batch_no_s){
        this.batch_no_s=batch_no_s;
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
        
    public String getIn_location_s(){
        return in_location_s;
    }
    
    @XmlElement
    public void setIn_location_s(String in_location_s){
        this.in_location_s=in_location_s;
    }
        
    public String getLocation_s(){
        return location_s;
    }
    
    @XmlElement
    public void setLocation_s(String location_s){
        this.location_s=location_s;
    }
        
    public String getMainid_s(){
        return mainid_s;
    }
    
    @XmlElement
    public void setMainid_s(String mainid_s){
        this.mainid_s=mainid_s;
    }
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
    }
        
    public String getMaterielcode_s(){
        return materielcode_s;
    }
    
    @XmlElement
    public void setMaterielcode_s(String materielcode_s){
        this.materielcode_s=materielcode_s;
    }
        
    public String getMaterielname_s(){
        return materielname_s;
    }
    
    @XmlElement
    public void setMaterielname_s(String materielname_s){
        this.materielname_s=materielname_s;
    }
        
    public String getOperate_class_s(){
        return operate_class_s;
    }
    
    @XmlElement
    public void setOperate_class_s(String operate_class_s){
        this.operate_class_s=operate_class_s;
    }
        
    public String getOperate_shift_s(){
        return operate_shift_s;
    }
    
    @XmlElement
    public void setOperate_shift_s(String operate_shift_s){
        this.operate_shift_s=operate_shift_s;
    }
        
    public String getOperate_type_s(){
        return operate_type_s;
    }
    
    @XmlElement
    public void setOperate_type_s(String operate_type_s){
        this.operate_type_s=operate_type_s;
    }
        
    public String getOut_location_s(){
        return out_location_s;
    }
    
    @XmlElement
    public void setOut_location_s(String out_location_s){
        this.out_location_s=out_location_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getPlate_no_s(){
        return plate_no_s;
    }
    
    @XmlElement
    public void setPlate_no_s(String plate_no_s){
        this.plate_no_s=plate_no_s;
    }
        
    public String getPlate_spec_s(){
        return plate_spec_s;
    }
    
    @XmlElement
    public void setPlate_spec_s(String plate_spec_s){
        this.plate_spec_s=plate_spec_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRfid_no_s(){
        return rfid_no_s;
    }
    
    @XmlElement
    public void setRfid_no_s(String rfid_no_s){
        this.rfid_no_s=rfid_no_s;
    }
        
    public String getSapm_group_s(){
        return sapm_group_s;
    }
    
    @XmlElement
    public void setSapm_group_s(String sapm_group_s){
        this.sapm_group_s=sapm_group_s;
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
        
    public Integer getWeight_i(){
        return weight_i;
    }
    
    @XmlElement
    public void setWeight_i(Integer weight_i){
        this.weight_i=weight_i;
    }
        
    public String getWorkid_s(){
        return workid_s;
    }
    
    @XmlElement
    public void setWorkid_s(String workid_s){
        this.workid_s=workid_s;
    }
        
    public Date getWorktime_t(){
        return worktime_t;
    }
    
    @XmlElement
    public void setWorktime_t(Date worktime_t){
        this.worktime_t=worktime_t;
    }
        
    
    
    
}
