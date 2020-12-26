/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;
import com.bluebirdme.core.system.annotations.Comment;

/**
 * 硫化机台控制履历
 * @author 周清玉
 * @Date 2018-08-12 16:51:12
 */
@ATDefinition("C_MM_ControlDetail")
@Entity
@Table(name="AT_C_MM_ControlDetail")
public class ControlDetail extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("机台条码")
    @Column(nullable=false,length=80)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=200)
    private String equip_name_s;
    
    @Comment("机台类型")
    @Column(nullable=true,length=80)
    private String equip_type_s;
    
    @Comment("操作开关项")
    @Column(nullable=true,length=100)
    private String operate_item_s;
    
    @Comment("开关项状态(1打开/0关闭)")
    @Column(nullable=true,length=80)
    private String operate_status_s;
    
    @Comment("记录标志,A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
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
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
     
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
     
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
     
    public Date getChanged_time_t(){
        return changed_time_t;
    }
    
    public void setChanged_time_t(Date changed_time_t){
        this.changed_time_t=changed_time_t;
    }
        
     
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
     
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
     
    public String getEquip_type_s(){
        return equip_type_s;
    }
    
    public void setEquip_type_s(String equip_type_s){
        this.equip_type_s=equip_type_s;
    }
        
     
    public String getOperate_item_s(){
        return operate_item_s;
    }
    
    public void setOperate_item_s(String operate_item_s){
        this.operate_item_s=operate_item_s;
    }
        
     
    public String getOperate_status_s(){
        return operate_status_s;
    }
    
    public void setOperate_status_s(String operate_status_s){
        this.operate_status_s=operate_status_s;
    }
        
     
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
     
    public String getSpare1_s(){
        return spare1_s;
    }
    
    public void setSpare1_s(String spare1_s){
        this.spare1_s=spare1_s;
    }
        
     
    public String getSpare2_s(){
        return spare2_s;
    }
    
    public void setSpare2_s(String spare2_s){
        this.spare2_s=spare2_s;
    }
        
     
    public String getSpare3_s(){
        return spare3_s;
    }
    
    public void setSpare3_s(String spare3_s){
        this.spare3_s=spare3_s;
    }
        
     
    public String getSpare4_s(){
        return spare4_s;
    }
    
    public void setSpare4_s(String spare4_s){
        this.spare4_s=spare4_s;
    }
        
     
    public String getSpare5_s(){
        return spare5_s;
    }
    
    public void setSpare5_s(String spare5_s){
        this.spare5_s=spare5_s;
    }
        
     
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
