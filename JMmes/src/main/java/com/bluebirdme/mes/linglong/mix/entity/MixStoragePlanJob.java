/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 盘库计划管理表
 * @author 陈国强
 * @Date 2020-08-18 08:37:07
 */
@ATDefinition("CM_WH_ITEM_INV_JOB")
@Entity
@XmlRootElement
@Table(name="AT_CM_WH_ITEM_INV_JOB")
public class MixStoragePlanJob extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003 ")
    @Column(nullable=false,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=2)
    private String arch_flag_s;
    
    @Comment("结存人 ")
    @Column(nullable=true,length=20)
    private String balance_by_s;
    
    @Comment("结存人姓名")
    @Column(nullable=true,length=200)
    private String balance_name_s;
    
    @Comment("结存数量")
    @Column(nullable=true,length=0)
    private String balance_qty_f;
    
    @Comment("结存标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String balance_state_s;
    
    @Comment("结存时间 ")
    @Column(nullable=true,length=0)
    private Date balance_time_t;
    
    @Comment("结存重量")
    @Column(nullable=true,length=0)
    private String balance_weight_f;
    
    @Comment("修改人 ")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间 ")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("对库人")
    @Column(nullable=true,length=20)
    private String check_by_s;
    
    @Comment("对库结束时间")
    @Column(nullable=true,length=100)
    private String check_finish_time_s;
    
    @Comment("对库人姓名")
    @Column(nullable=true,length=200)
    private String check_name_s;
    
    @Comment("对库出库-结束时间")
    @Column(nullable=true,length=0)
    private Date check_out_finish_time_t;
    
    @Comment("对库出库-数量")
    @Column(nullable=true,length=0)
    private String check_out_qty_f;
    
    @Comment("对库出库-开始时间")
    @Column(nullable=true,length=0)
    private Date check_out_start_time_t;
    
    @Comment("对库出库标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String check_out_state_s;
    
    @Comment("对库出库-重量")
    @Column(nullable=true,length=0)
    private String check_out_weight_f;
    
    @Comment("对库产出-结束时间")
    @Column(nullable=true,length=0)
    private Date check_prod_finish_time_t;
    
    @Comment("对库产出-数量")
    @Column(nullable=true,length=0)
    private String check_prod_qty_f;
    
    @Comment("对库产出-开始时间")
    @Column(nullable=true,length=0)
    private Date check_prod_start_time_t;
    
    @Comment("对库产出标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String check_prod_state_s;
    
    @Comment("对库产出-重量")
    @Column(nullable=true,length=0)
    private String check_prod_weight_f;
    
    @Comment("对库退库-重量")
    @Column(nullable=true,length=0)
    private String check_returnt_weight_f;
    
    @Comment("对库退库-结束时间")
    @Column(nullable=true,length=0)
    private Date check_return_finish_time_t;
    
    @Comment("对库退库-数量")
    @Column(nullable=true,length=0)
    private String check_return_qty_f;
    
    @Comment("对库退库-开始时间")
    @Column(nullable=true,length=0)
    private Date check_return_start_time_t;
    
    @Comment("对库退库标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String check_return_state_s;
    
    @Comment("对库开始时间")
    @Column(nullable=true,length=100)
    private String check_start_time_s;
    
    @Comment("对库标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String check_state_s;
    
    @Comment("对库时间")
    @Column(nullable=true,length=0)
    private Date check_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间 ")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源： 347001-原材料 347002-密炼 347003-半部件 347004-成型 347005-硫化")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("截存人")
    @Column(nullable=true,length=80)
    private String intercept_by_s;
    
    @Comment("截存人姓名")
    @Column(nullable=true,length=200)
    private String intercept_name_s;
    
    @Comment("截存标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String intercept_state_s;
    
    @Comment("截存时间")
    @Column(nullable=true,length=0)
    private Date intercept_time_t;
    
    @Comment("盘点区域")
    @Column(nullable=false,length=20)
    private String inventory_area_s;
    
    @Comment("盘点结束时间")
    @Column(nullable=true,length=100)
    private String inventory_finish_time_s;
    
    @Comment("盘点数量")
    @Column(nullable=true,length=0)
    private String inventory_qty_f;
    
    @Comment("盘点开始时间")
    @Column(nullable=true,length=100)
    private String inventory_start_time_s;
    
    @Comment("对库盘点标识：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String inventory_state_s;
    
    @Comment("盘点重量")
    @Column(nullable=true,length=0)
    private String inventory_weight_f;
    
    @Comment("作业日期：YYYYMMDD作业日期")
    @Column(nullable=true,length=80)
    private String job_date_s;
    
    @Comment("作业名称")
    @Column(nullable=false,length=200)
    private String job_name_s;
    
    @Comment("作业编号")
    @Column(nullable=false,length=80)
    private String job_no_s;
    
    @Comment("作业班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String job_shift_s;
    
    @Comment("作业状态： 343001-盘库开始 343002-盘库中 343003-盘库结束 343004-对库开始 343005-对库中 343006-对库结束 343007-结存开始 343008-结存结束 343009-作业完成 343010-作业作废")
    @Column(nullable=false,length=80)
    private String job_status_s;
    
    @Comment("记录标志：A-可用，D-删除 ")
    @Column(nullable=false,length=2)
    private String record_flag_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("备用字段1 ")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6")
    @Column(nullable=true,length=100)
    private String spare6_s;
    
    @Comment("备用字段7")
    @Column(nullable=true,length=100)
    private String spare7_s;
    
    @Comment("备用字段8")
    @Column(nullable=true,length=100)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=100)
    private String spare9_s;
    
    @Comment("截存结束时间")
    @Column(nullable=true,length=0)
    private Date sys_finish_time_t;
    
    @Comment("截存计划-数量")
    @Column(nullable=true,length=0)
    private String sys_plan_qty_f;
    
    @Comment("截存计划-重量")
    @Column(nullable=true,length=0)
    private String sys_plan_weight_f;
    
    @Comment("截存开始时间")
    @Column(nullable=true,length=0)
    private Date sys_start_time_t;
    
    @Comment("工厂：1-全钢、2-半钢 ")
    @Column(nullable=true,length=5)
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
        
    public String getBalance_by_s(){
        return balance_by_s;
    }
    
    @XmlElement
    public void setBalance_by_s(String balance_by_s){
        this.balance_by_s=balance_by_s;
    }
        
    public String getBalance_name_s(){
        return balance_name_s;
    }
    
    @XmlElement
    public void setBalance_name_s(String balance_name_s){
        this.balance_name_s=balance_name_s;
    }
        
    public String getBalance_qty_f(){
        return balance_qty_f;
    }
    
    @XmlElement
    public void setBalance_qty_f(String balance_qty_f){
        this.balance_qty_f=balance_qty_f;
    }
        
    public String getBalance_state_s(){
        return balance_state_s;
    }
    
    @XmlElement
    public void setBalance_state_s(String balance_state_s){
        this.balance_state_s=balance_state_s;
    }
        
    public Date getBalance_time_t(){
        return balance_time_t;
    }
    
    @XmlElement
    public void setBalance_time_t(Date balance_time_t){
        this.balance_time_t=balance_time_t;
    }
        
    public String getBalance_weight_f(){
        return balance_weight_f;
    }
    
    @XmlElement
    public void setBalance_weight_f(String balance_weight_f){
        this.balance_weight_f=balance_weight_f;
    }
        
    public String getChanged_by_s(){
        return changed_by_s;
    }
    
    @XmlElement
    public void setChanged_by_s(String changed_by_s){
        this.changed_by_s=changed_by_s;
    }
        
    public String getChanged_name_s(){
        return changed_name_s;
    }
    
    @XmlElement
    public void setChanged_name_s(String changed_name_s){
        this.changed_name_s=changed_name_s;
    }
        
    public Date getChanged_time_t(){
        return changed_time_t;
    }
    
    @XmlElement
    public void setChanged_time_t(Date changed_time_t){
        this.changed_time_t=changed_time_t;
    }
        
    public String getCheck_by_s(){
        return check_by_s;
    }
    
    @XmlElement
    public void setCheck_by_s(String check_by_s){
        this.check_by_s=check_by_s;
    }
        
    public String getCheck_finish_time_s(){
        return check_finish_time_s;
    }
    
    @XmlElement
    public void setCheck_finish_time_s(String check_finish_time_s){
        this.check_finish_time_s=check_finish_time_s;
    }
        
    public String getCheck_name_s(){
        return check_name_s;
    }
    
    @XmlElement
    public void setCheck_name_s(String check_name_s){
        this.check_name_s=check_name_s;
    }
        
    public Date getCheck_out_finish_time_t(){
        return check_out_finish_time_t;
    }
    
    @XmlElement
    public void setCheck_out_finish_time_t(Date check_out_finish_time_t){
        this.check_out_finish_time_t=check_out_finish_time_t;
    }
        
    public String getCheck_out_qty_f(){
        return check_out_qty_f;
    }
    
    @XmlElement
    public void setCheck_out_qty_f(String check_out_qty_f){
        this.check_out_qty_f=check_out_qty_f;
    }
        
    public Date getCheck_out_start_time_t(){
        return check_out_start_time_t;
    }
    
    @XmlElement
    public void setCheck_out_start_time_t(Date check_out_start_time_t){
        this.check_out_start_time_t=check_out_start_time_t;
    }
        
    public String getCheck_out_state_s(){
        return check_out_state_s;
    }
    
    @XmlElement
    public void setCheck_out_state_s(String check_out_state_s){
        this.check_out_state_s=check_out_state_s;
    }
        
    public String getCheck_out_weight_f(){
        return check_out_weight_f;
    }
    
    @XmlElement
    public void setCheck_out_weight_f(String check_out_weight_f){
        this.check_out_weight_f=check_out_weight_f;
    }
        
    public Date getCheck_prod_finish_time_t(){
        return check_prod_finish_time_t;
    }
    
    @XmlElement
    public void setCheck_prod_finish_time_t(Date check_prod_finish_time_t){
        this.check_prod_finish_time_t=check_prod_finish_time_t;
    }
        
    public String getCheck_prod_qty_f(){
        return check_prod_qty_f;
    }
    
    @XmlElement
    public void setCheck_prod_qty_f(String check_prod_qty_f){
        this.check_prod_qty_f=check_prod_qty_f;
    }
        
    public Date getCheck_prod_start_time_t(){
        return check_prod_start_time_t;
    }
    
    @XmlElement
    public void setCheck_prod_start_time_t(Date check_prod_start_time_t){
        this.check_prod_start_time_t=check_prod_start_time_t;
    }
        
    public String getCheck_prod_state_s(){
        return check_prod_state_s;
    }
    
    @XmlElement
    public void setCheck_prod_state_s(String check_prod_state_s){
        this.check_prod_state_s=check_prod_state_s;
    }
        
    public String getCheck_prod_weight_f(){
        return check_prod_weight_f;
    }
    
    @XmlElement
    public void setCheck_prod_weight_f(String check_prod_weight_f){
        this.check_prod_weight_f=check_prod_weight_f;
    }
        
    public String getCheck_returnt_weight_f(){
        return check_returnt_weight_f;
    }
    
    @XmlElement
    public void setCheck_returnt_weight_f(String check_returnt_weight_f){
        this.check_returnt_weight_f=check_returnt_weight_f;
    }
        
    public Date getCheck_return_finish_time_t(){
        return check_return_finish_time_t;
    }
    
    @XmlElement
    public void setCheck_return_finish_time_t(Date check_return_finish_time_t){
        this.check_return_finish_time_t=check_return_finish_time_t;
    }
        
    public String getCheck_return_qty_f(){
        return check_return_qty_f;
    }
    
    @XmlElement
    public void setCheck_return_qty_f(String check_return_qty_f){
        this.check_return_qty_f=check_return_qty_f;
    }
        
    public Date getCheck_return_start_time_t(){
        return check_return_start_time_t;
    }
    
    @XmlElement
    public void setCheck_return_start_time_t(Date check_return_start_time_t){
        this.check_return_start_time_t=check_return_start_time_t;
    }
        
    public String getCheck_return_state_s(){
        return check_return_state_s;
    }
    
    @XmlElement
    public void setCheck_return_state_s(String check_return_state_s){
        this.check_return_state_s=check_return_state_s;
    }
        
    public String getCheck_start_time_s(){
        return check_start_time_s;
    }
    
    @XmlElement
    public void setCheck_start_time_s(String check_start_time_s){
        this.check_start_time_s=check_start_time_s;
    }
        
    public String getCheck_state_s(){
        return check_state_s;
    }
    
    @XmlElement
    public void setCheck_state_s(String check_state_s){
        this.check_state_s=check_state_s;
    }
        
    public Date getCheck_time_t(){
        return check_time_t;
    }
    
    @XmlElement
    public void setCheck_time_t(Date check_time_t){
        this.check_time_t=check_time_t;
    }
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public String getCreated_name_s(){
        return created_name_s;
    }
    
    @XmlElement
    public void setCreated_name_s(String created_name_s){
        this.created_name_s=created_name_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public String getDatasource_s(){
        return datasource_s;
    }
    
    @XmlElement
    public void setDatasource_s(String datasource_s){
        this.datasource_s=datasource_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIntercept_by_s(){
        return intercept_by_s;
    }
    
    @XmlElement
    public void setIntercept_by_s(String intercept_by_s){
        this.intercept_by_s=intercept_by_s;
    }
        
    public String getIntercept_name_s(){
        return intercept_name_s;
    }
    
    @XmlElement
    public void setIntercept_name_s(String intercept_name_s){
        this.intercept_name_s=intercept_name_s;
    }
        
    public String getIntercept_state_s(){
        return intercept_state_s;
    }
    
    @XmlElement
    public void setIntercept_state_s(String intercept_state_s){
        this.intercept_state_s=intercept_state_s;
    }
        
    public Date getIntercept_time_t(){
        return intercept_time_t;
    }
    
    @XmlElement
    public void setIntercept_time_t(Date intercept_time_t){
        this.intercept_time_t=intercept_time_t;
    }
        
    public String getInventory_area_s(){
        return inventory_area_s;
    }
    
    @XmlElement
    public void setInventory_area_s(String inventory_area_s){
        this.inventory_area_s=inventory_area_s;
    }
        
    public String getInventory_finish_time_s(){
        return inventory_finish_time_s;
    }
    
    @XmlElement
    public void setInventory_finish_time_s(String inventory_finish_time_s){
        this.inventory_finish_time_s=inventory_finish_time_s;
    }
        
    public String getInventory_qty_f(){
        return inventory_qty_f;
    }
    
    @XmlElement
    public void setInventory_qty_f(String inventory_qty_f){
        this.inventory_qty_f=inventory_qty_f;
    }
        
    public String getInventory_start_time_s(){
        return inventory_start_time_s;
    }
    
    @XmlElement
    public void setInventory_start_time_s(String inventory_start_time_s){
        this.inventory_start_time_s=inventory_start_time_s;
    }
        
    public String getInventory_state_s(){
        return inventory_state_s;
    }
    
    @XmlElement
    public void setInventory_state_s(String inventory_state_s){
        this.inventory_state_s=inventory_state_s;
    }
        
    public String getInventory_weight_f(){
        return inventory_weight_f;
    }
    
    @XmlElement
    public void setInventory_weight_f(String inventory_weight_f){
        this.inventory_weight_f=inventory_weight_f;
    }
        
    public String getJob_date_s(){
        return job_date_s;
    }
    
    @XmlElement
    public void setJob_date_s(String job_date_s){
        this.job_date_s=job_date_s;
    }
        
    public String getJob_name_s(){
        return job_name_s;
    }
    
    @XmlElement
    public void setJob_name_s(String job_name_s){
        this.job_name_s=job_name_s;
    }
        
    public String getJob_no_s(){
        return job_no_s;
    }
    
    @XmlElement
    public void setJob_no_s(String job_no_s){
        this.job_no_s=job_no_s;
    }
        
    public String getJob_shift_s(){
        return job_shift_s;
    }
    
    @XmlElement
    public void setJob_shift_s(String job_shift_s){
        this.job_shift_s=job_shift_s;
    }
        
    public String getJob_status_s(){
        return job_status_s;
    }
    
    @XmlElement
    public void setJob_status_s(String job_status_s){
        this.job_status_s=job_status_s;
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
        
    public Date getSys_finish_time_t(){
        return sys_finish_time_t;
    }
    
    @XmlElement
    public void setSys_finish_time_t(Date sys_finish_time_t){
        this.sys_finish_time_t=sys_finish_time_t;
    }
        
    public String getSys_plan_qty_f(){
        return sys_plan_qty_f;
    }
    
    @XmlElement
    public void setSys_plan_qty_f(String sys_plan_qty_f){
        this.sys_plan_qty_f=sys_plan_qty_f;
    }
        
    public String getSys_plan_weight_f(){
        return sys_plan_weight_f;
    }
    
    @XmlElement
    public void setSys_plan_weight_f(String sys_plan_weight_f){
        this.sys_plan_weight_f=sys_plan_weight_f;
    }
        
    public Date getSys_start_time_t(){
        return sys_start_time_t;
    }
    
    @XmlElement
    public void setSys_start_time_t(Date sys_start_time_t){
        this.sys_start_time_t=sys_start_time_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
