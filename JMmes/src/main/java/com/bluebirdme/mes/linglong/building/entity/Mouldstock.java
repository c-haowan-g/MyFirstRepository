/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

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
 * 机头库存表
 * @author lnk
 * @Date 2019-01-11 17:24:50
 */
@ATDefinition("B_MM_MouldStock")
@Entity
@XmlRootElement
@Table(name="AT_B_MM_MOULDSTOCK")
public class Mouldstock extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("使用次数报警值")
    @Column(nullable=true,length=80)
    private String alarm_number_s;
    
    @Comment("机头编码")
    @Column(nullable=true,length=80)
    private String capsule_code_s;
    
    @Comment("厂商")
    @Column(nullable=true,length=80)
    private String capsule_factory_s;
    
    @Comment("机头批次号")
    @Column(nullable=true,length=80)
    private String capsule_id_s;
    
    @Comment("机头名称")
    @Column(nullable=true,length=80)
    private String capsule_name_s;
    
    @Comment("机头规格")
    @Column(nullable=true,length=80)
    private String capsule_specification_s;
    
    @Comment("机头类型")
    @Column(nullable=true,length=80)
    private String capsule_type_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("采购进厂日期")
    @Column(nullable=true,length=0)
    private Date in_time_t;
    
    @Comment("机头校验位码")
    @Column(nullable=true,length=80)
    private String parity_code_s;
    
    @Comment("采购人")
    @Column(nullable=true,length=80)
    private String purchaser_s;
    
    @Comment("换上时间")
    @Column(nullable=true,length=0)
    private Date put_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("换下时间")
    @Column(nullable=true,length=0)
    private Date replaced_time_t;
    
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
    
    @Comment("机头状态")
    @Column(nullable=true,length=80)
    private String status_s;
    
    @Comment("存放库区")
    @Column(nullable=true,length=80)
    private String store_area_s;
    
    @Comment("存放位置")
    @Column(nullable=true,length=80)
    private String store_location_s;
    
    @Comment("供应商编号")
    @Column(nullable=true,length=80)
    private String suppliers_no_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("累计使用次数")
    @Column(nullable=true,length=80)
    private String total_number_s;
    
    @Comment("入库人")
    @Column(nullable=true,length=80)
    private String user_id_s;
    
    @Comment("入库时间")
    @Column(nullable=true,length=0)
    private Date use_time_t;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlarm_number_s(){
        return alarm_number_s;
    }
    
    @XmlElement
    public void setAlarm_number_s(String alarm_number_s){
        this.alarm_number_s=alarm_number_s;
    }
        
    public String getCapsule_code_s(){
        return capsule_code_s;
    }
    
    @XmlElement
    public void setCapsule_code_s(String capsule_code_s){
        this.capsule_code_s=capsule_code_s;
    }
        
    public String getCapsule_factory_s(){
        return capsule_factory_s;
    }
    
    @XmlElement
    public void setCapsule_factory_s(String capsule_factory_s){
        this.capsule_factory_s=capsule_factory_s;
    }
        
    public String getCapsule_id_s(){
        return capsule_id_s;
    }
    
    @XmlElement
    public void setCapsule_id_s(String capsule_id_s){
        this.capsule_id_s=capsule_id_s;
    }
        
    public String getCapsule_name_s(){
        return capsule_name_s;
    }
    
    @XmlElement
    public void setCapsule_name_s(String capsule_name_s){
        this.capsule_name_s=capsule_name_s;
    }
        
    public String getCapsule_specification_s(){
        return capsule_specification_s;
    }
    
    @XmlElement
    public void setCapsule_specification_s(String capsule_specification_s){
        this.capsule_specification_s=capsule_specification_s;
    }
        
    public String getCapsule_type_s(){
        return capsule_type_s;
    }
    
    @XmlElement
    public void setCapsule_type_s(String capsule_type_s){
        this.capsule_type_s=capsule_type_s;
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
        
    public Date getIn_time_t(){
        return in_time_t;
    }
    
    @XmlElement
    public void setIn_time_t(Date in_time_t){
        this.in_time_t=in_time_t;
    }
        
    public String getParity_code_s(){
        return parity_code_s;
    }
    
    @XmlElement
    public void setParity_code_s(String parity_code_s){
        this.parity_code_s=parity_code_s;
    }
        
    public String getPurchaser_s(){
        return purchaser_s;
    }
    
    @XmlElement
    public void setPurchaser_s(String purchaser_s){
        this.purchaser_s=purchaser_s;
    }
        
    public Date getPut_time_t(){
        return put_time_t;
    }
    
    @XmlElement
    public void setPut_time_t(Date put_time_t){
        this.put_time_t=put_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public Date getReplaced_time_t(){
        return replaced_time_t;
    }
    
    @XmlElement
    public void setReplaced_time_t(Date replaced_time_t){
        this.replaced_time_t=replaced_time_t;
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
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getStore_area_s(){
        return store_area_s;
    }
    
    @XmlElement
    public void setStore_area_s(String store_area_s){
        this.store_area_s=store_area_s;
    }
        
    public String getStore_location_s(){
        return store_location_s;
    }
    
    @XmlElement
    public void setStore_location_s(String store_location_s){
        this.store_location_s=store_location_s;
    }
        
    public String getSuppliers_no_s(){
        return suppliers_no_s;
    }
    
    @XmlElement
    public void setSuppliers_no_s(String suppliers_no_s){
        this.suppliers_no_s=suppliers_no_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTotal_number_s(){
        return total_number_s;
    }
    
    @XmlElement
    public void setTotal_number_s(String total_number_s){
        this.total_number_s=total_number_s;
    }
        
    public String getUser_id_s(){
        return user_id_s;
    }
    
    @XmlElement
    public void setUser_id_s(String user_id_s){
        this.user_id_s=user_id_s;
    }
        
    public Date getUse_time_t(){
        return use_time_t;
    }
    
    @XmlElement
    public void setUse_time_t(Date use_time_t){
        this.use_time_t=use_time_t;
    }
        
    
    
    
}
