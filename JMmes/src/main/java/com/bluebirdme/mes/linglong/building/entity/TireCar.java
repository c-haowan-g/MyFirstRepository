/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.core.system.orm.sql.Where;

/**
 * 成型胎胚车维护表
 * @author 兰颖慧
 * @Date 2019-03-02 11:06:03
 */
@ATDefinition("B_BM_TireCar")  //
@Entity
@XmlRootElement
@Table(name="AT_B_BM_TIRECAR")
public class TireCar extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("更新人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("更新时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("满载数量")
    @Column(nullable=true,length=0)
    private Integer full_loaded_number_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("RFID")
    @Column(nullable=true,length=80)
    private String rfidcode_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String space1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String space2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String space3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=80)
    private String space4_s;
    
    @Comment("备用字段5")
    @Column(nullable=false,length=80)
    private String space5_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("胎胚车编号")
    @Column(nullable=false,length=80)
    private String tire_shelf_code_s;
    
    @Comment("胎胚车描述")
    @Column(nullable=true,length=80)
    private String tire_shelf_description_s;
    
    @Comment("胎胚车名称")
    @Column(nullable=true,length=80)
    private String tire_shelf_name_s;
 
    
	public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
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
        
    public Integer getFull_loaded_number_i(){
        return full_loaded_number_i;
    }
    
    @XmlElement
    public void setFull_loaded_number_i(Integer full_loaded_number_i){
        this.full_loaded_number_i=full_loaded_number_i;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRfidcode_s(){
        return rfidcode_s;
    }
    
    @XmlElement
    public void setRfidcode_s(String rfidcode_s){
        this.rfidcode_s=rfidcode_s;
    }
        
    public String getSpace1_s(){
        return space1_s;
    }
    
    @XmlElement
    public void setSpace1_s(String space1_s){
        this.space1_s=space1_s;
    }
        
    public String getSpace2_s(){
        return space2_s;
    }
    
    @XmlElement
    public void setSpace2_s(String space2_s){
        this.space2_s=space2_s;
    }
        
    public String getSpace3_s(){
        return space3_s;
    }
    
    @XmlElement
    public void setSpace3_s(String space3_s){
        this.space3_s=space3_s;
    }
        
    public String getSpace4_s(){
        return space4_s;
    }
    
    @XmlElement
    public void setSpace4_s(String space4_s){
        this.space4_s=space4_s;
    }
        
    public String getSpace5_s(){
        return space5_s;
    }
    
    @XmlElement
    public void setSpace5_s(String space5_s){
        this.space5_s=space5_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTire_shelf_code_s(){
        return tire_shelf_code_s;
    }
    
    @XmlElement
    public void setTire_shelf_code_s(String tire_shelf_code_s){
        this.tire_shelf_code_s=tire_shelf_code_s;
    }
        
    public String getTire_shelf_description_s(){
        return tire_shelf_description_s;
    }
    
    @XmlElement
    public void setTire_shelf_description_s(String tire_shelf_description_s){
        this.tire_shelf_description_s=tire_shelf_description_s;
    }
        
    public String getTire_shelf_name_s(){
        return tire_shelf_name_s;
    }
    
    @XmlElement
    public void setTire_shelf_name_s(String tire_shelf_name_s){
        this.tire_shelf_name_s=tire_shelf_name_s;
    }
        
    
}
