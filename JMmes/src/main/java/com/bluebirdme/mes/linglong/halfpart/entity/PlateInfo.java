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
 * 半部件口型板信息
 * @author 栾和源
 * @Date 2020-01-22 08:00:37
 */
@ATDefinition("A_EM_PlateInfo")
@Entity
@XmlRootElement
@Table(name="AT_A_EM_PLATEINFO")
public class PlateInfo extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("存放库区")
    @Column(nullable=true,length=80)
    private String area_s;
    
    @Comment("批次条码")
    @Column(nullable=true,length=80)
    private String batchno_s;
    
    @Comment("开始使用时间（最新换上时间)")
    @Column(nullable=true,length=0)
    private Date begintime_t;
    
    @Comment("启用/停用 标识")
    @Column(nullable=true,length=80)
    private String canuseflag_s;
    
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
    
    @Comment("当前位置")
    @Column(nullable=true,length=80)
    private String currentlocation_s;
    
    @Comment("结束使用时间（最新换下时间）")
    @Column(nullable=true,length=0)
    private Date endtime_t;
    
    @Comment("是否在用 标志  1 / 0")
    @Column(nullable=true,length=80)
    private String flag_s;
    
    @Comment("内径")
    @Column(nullable=true,length=80)
    private String internaldiameter_s;
    
    @Comment("存放库位")
    @Column(nullable=true,length=80)
    private String location_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String memo_s;
    
    @Comment("口型板规格")
    @Column(nullable=true,length=80)
    private String mouthplatespecification_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date output_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
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
    
    @Comment("厚度")
    @Column(nullable=true,length=80)
    private String thickness_s;
    
    @Comment("累计使用次数")
    @Column(nullable=true,length=0)
    private Integer usecount_i;
    
    @Comment("条码规则(需校验口型板类型条码)")
    @Column(nullable=true,length=80)
    private String vehicles_barcode_s;
    
    @Comment("RFID码")
    @Column(nullable=true,length=80)
    private String vehicles_rfidcode_s;
    
    @Comment("类型 ：工装基础数据103")
    @Column(nullable=true,length=80)
    private String vehicles_type_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getArea_s(){
        return area_s;
    }
    
    @XmlElement
    public void setArea_s(String area_s){
        this.area_s=area_s;
    }
        
    public String getBatchno_s(){
        return batchno_s;
    }
    
    @XmlElement
    public void setBatchno_s(String batchno_s){
        this.batchno_s=batchno_s;
    }
        
    public Date getBegintime_t(){
        return begintime_t;
    }
    
    @XmlElement
    public void setBegintime_t(Date begintime_t){
        this.begintime_t=begintime_t;
    }
        
    public String getCanuseflag_s(){
        return canuseflag_s;
    }
    
    @XmlElement
    public void setCanuseflag_s(String canuseflag_s){
        this.canuseflag_s=canuseflag_s;
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
        
    public String getCurrentlocation_s(){
        return currentlocation_s;
    }
    
    @XmlElement
    public void setCurrentlocation_s(String currentlocation_s){
        this.currentlocation_s=currentlocation_s;
    }
        
    public Date getEndtime_t(){
        return endtime_t;
    }
    
    @XmlElement
    public void setEndtime_t(Date endtime_t){
        this.endtime_t=endtime_t;
    }
        
    public String getFlag_s(){
        return flag_s;
    }
    
    @XmlElement
    public void setFlag_s(String flag_s){
        this.flag_s=flag_s;
    }
        
    public String getInternaldiameter_s(){
        return internaldiameter_s;
    }
    
    @XmlElement
    public void setInternaldiameter_s(String internaldiameter_s){
        this.internaldiameter_s=internaldiameter_s;
    }
        
    public String getLocation_s(){
        return location_s;
    }
    
    @XmlElement
    public void setLocation_s(String location_s){
        this.location_s=location_s;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getMouthplatespecification_s(){
        return mouthplatespecification_s;
    }
    
    @XmlElement
    public void setMouthplatespecification_s(String mouthplatespecification_s){
        this.mouthplatespecification_s=mouthplatespecification_s;
    }
        
    public Date getOutput_time_t(){
        return output_time_t;
    }
    
    @XmlElement
    public void setOutput_time_t(Date output_time_t){
        this.output_time_t=output_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    public String getThickness_s(){
        return thickness_s;
    }
    
    @XmlElement
    public void setThickness_s(String thickness_s){
        this.thickness_s=thickness_s;
    }
        
    public Integer getUsecount_i(){
        return usecount_i;
    }
    
    @XmlElement
    public void setUsecount_i(Integer usecount_i){
        this.usecount_i=usecount_i;
    }
        
    public String getVehicles_barcode_s(){
        return vehicles_barcode_s;
    }
    
    @XmlElement
    public void setVehicles_barcode_s(String vehicles_barcode_s){
        this.vehicles_barcode_s=vehicles_barcode_s;
    }
        
    public String getVehicles_rfidcode_s(){
        return vehicles_rfidcode_s;
    }
    
    @XmlElement
    public void setVehicles_rfidcode_s(String vehicles_rfidcode_s){
        this.vehicles_rfidcode_s=vehicles_rfidcode_s;
    }
        
    public String getVehicles_type_s(){
        return vehicles_type_s;
    }
    
    @XmlElement
    public void setVehicles_type_s(String vehicles_type_s){
        this.vehicles_type_s=vehicles_type_s;
    }
        
    
    
    
}
