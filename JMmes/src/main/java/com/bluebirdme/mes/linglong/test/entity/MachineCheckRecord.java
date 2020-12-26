/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.entity;

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
 * 开班检查表
 * @author 周清玉
 * @Date 2019-08-09 08:42:13
 */
@ATDefinition("A_MM_MachineCheckRecord")
@Entity
@XmlRootElement
@Table(name="AT_A_MM_MACHINECHECKRECORD")
public class MachineCheckRecord extends RockWellBaseEntity{
    

	@Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 ")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("开班作业编码 ")
    @Column(nullable=false,length=80)
    private String beginwork_code_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("点检日期")
    @Column(nullable=true,length=80)
    private String check_date_s;
    
    @Comment("点检班次")
    @Column(nullable=true,length=80)
    private String class_id_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
//    @Comment("开班检查项目结果 ")
//    @Column(nullable=true,length=80)
//    private String column_16_s;
    
    @Comment("开班检查项目ID")
    @Column(nullable=true,length=80)
    private String eff_time_s;
    
    @Comment("点检结束时间 ")
    @Column(nullable=true,length=0)
    private Date end_time_t;
    
    @Comment("机台条码 ")
    @Column(nullable=false,length=80)
    private String equip_code_s;
    
    @Comment("开班检查项目名称 ")
    @Column(nullable=true,length=80)
    private String itemname_s;
    
    @Comment("检查项目备注 ")
    @Column(nullable=true,length=80)
    private String itemremark_s;
    
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
    
    @Comment("点检开始时间")
    @Column(nullable=true,length=0)
    private Date start_time_t;
    
    @Comment("点检状态 1：点检中，0：点检结束 ")
    @Column(nullable=false,length=80)
    private String status_s;
    
    @Comment("工厂（1全钢 2半钢） ")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("点检人工号 ")
    @Column(nullable=true,length=80)
    private String user_id_s;
    
    @Comment("点检人名称 ")
    @Column(nullable=true,length=80)
    private String user_name_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getBeginwork_code_s(){
        return beginwork_code_s;
    }
    
    @XmlElement
    public void setBeginwork_code_s(String beginwork_code_s){
        this.beginwork_code_s=beginwork_code_s;
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
        
    public String getCheck_date_s(){
        return check_date_s;
    }
    
    @XmlElement
    public void setCheck_date_s(String check_date_s){
        this.check_date_s=check_date_s;
    }
        
    public String getClass_id_s(){
        return class_id_s;
    }
    
    @XmlElement
    public void setClass_id_s(String class_id_s){
        this.class_id_s=class_id_s;
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
        
//    public String getColumn_16_s(){
//        return column_16_s;
//    }
//    
//    @XmlElement
//    public void setColumn_16_s(String column_16_s){
//        this.column_16_s=column_16_s;
//    }
        
    public String getEff_time_s(){
        return eff_time_s;
    }
    
    @XmlElement
    public void setEff_time_s(String eff_time_s){
        this.eff_time_s=eff_time_s;
    }
        
    public Date getEnd_time_t(){
        return end_time_t;
    }
    
    @XmlElement
    public void setEnd_time_t(Date end_time_t){
        this.end_time_t=end_time_t;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getItemname_s(){
        return itemname_s;
    }
    
    @XmlElement
    public void setItemname_s(String itemname_s){
        this.itemname_s=itemname_s;
    }
        
    public String getItemremark_s(){
        return itemremark_s;
    }
    
    @XmlElement
    public void setItemremark_s(String itemremark_s){
        this.itemremark_s=itemremark_s;
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
        
    public Date getStart_time_t(){
        return start_time_t;
    }
    
    @XmlElement
    public void setStart_time_t(Date start_time_t){
        this.start_time_t=start_time_t;
    }
        
    public String getStatus_s(){
        return status_s;
    }
    
    @XmlElement
    public void setStatus_s(String status_s){
        this.status_s=status_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getUser_id_s(){
        return user_id_s;
    }
    
    @XmlElement
    public void setUser_id_s(String user_id_s){
        this.user_id_s=user_id_s;
    }
        
    public String getUser_name_s(){
        return user_name_s;
    }
    
    @XmlElement
    public void setUser_name_s(String user_name_s){
        this.user_name_s=user_name_s;
    }
        
    
    
    
}
