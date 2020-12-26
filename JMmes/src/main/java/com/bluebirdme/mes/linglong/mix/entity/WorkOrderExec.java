/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 密炼工单下发
 * @author 王超
 * @Date 2020-08-07 09:07:42
 */
@ATDefinition("MX_PP_WO_EXEC")
@Entity
@XmlRootElement
@Table(name="AT_MX_PP_WO_EXEC")
public class WorkOrderExec extends RockWellBaseEntity{
    
    
    @Comment("执行结束时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_finish_checktime_t;
    
    @Comment("执行结束时间")
    @Column(nullable=true,length=0)
    private Date act_finish_time_t;
    
    @Comment("执行开始时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_start_checktime_t;
    
    @Comment("执行开始时间")
    @Column(nullable=true,length=0)
    private Date act_start_time_t;
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("开始检验车次号")
    @Column(nullable=true,length=80)
    private String begin_check_train_num_s;
    
    @Comment("开始生产车次号")
    @Column(nullable=true,length=80)
    private String begin_proc_train_num_s;
    
    @Comment("BOM版本：胶料计划")
    @Column(nullable=true,length=80)
    private String bom_ver_id_s;
    
    @Comment("工器具的条码：小料车")
    @Column(nullable=true,length=80)
    private String carrier_code_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("审核人")
    @Column(nullable=true,length=40)
    private String check_by_s;
    
    @Comment("审核状态：0-未审核、1-已审核")
    @Column(nullable=true,length=20)
    private String check_state_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date check_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据来源：075001-全钢-万向、075002-全钢-北院、075003-半钢-软控、075004-半钢-万向、075005-人工配料、075006-快检、075007-地磅、075008-密炼产出、075009-MES")
    @Column(nullable=true,length=80)
    private String datasource_s;
    
    @Comment("结束检验车次号")
    @Column(nullable=true,length=80)
    private String end_check_train_num_s;
    
    @Comment("结束生产车次号")
    @Column(nullable=true,length=80)
    private String end_proc_train_num_s;
    
    @Comment("机台条码 ")
    @Column(nullable=true,length=40)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=80)
    private String equip_name_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("料仓是否清理：0-否、1-是 增粘/补强树脂类：每月清理一次料仓，其它类每三个月清理一次料仓； 不溶性硫磺和硫磺粉料仓：每月清理一次,其它类每三个月清理一次料仓")
    @Column(nullable=true,length=40)
    private String is_silo_clean_s;
    
    @Comment("主机手")
    @Column(nullable=true,length=100)
    private String master_by_s;
    
    @Comment("主机手姓名")
    @Column(nullable=true,length=200)
    private String master_name_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("备注：母胶卡片显示-生胶（车次消耗原材料胶料），名称+批次生产日期-MEMO")
    @Column(nullable=true,length=2000)
    private String memo_s;
    
    @Comment("门尼仪机台条码")
    @Column(nullable=true,length=80)
    private String mi_equip_code_s;
    
    @Comment("门尼仪机台名称")
    @Column(nullable=true,length=80)
    private String mi_equip_name_s;
    
    @Comment("密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("成本收集器版本")
    @Column(nullable=true,length=40)
    private String production_ver_s;
    
    @Comment("检验不合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_bad_i;
    
    @Comment("工单检验完成量")
    @Column(nullable=true,length=0)
    private Integer qty_check_complete_i;
    
    @Comment("工单检验量：车数*检验百分比")
    @Column(nullable=true,length=0)
    private String qty_check_f;
    
    @Comment("检验合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_good_i;
    
    @Comment("工单完成数量")
    @Column(nullable=true,length=0)
    private Integer qty_complete_i;
    
    @Comment("工单计划数量")
    @Column(nullable=true,length=0)
    private Integer qty_plan_i;
    
    @Comment("快检检验配方编号，外键，INT_PLM_QUICKCHECK_EDIT.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String quickcheck_recipe_code_s;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
    @Comment("密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("硫变仪机台条码")
    @Column(nullable=true,length=80)
    private String sa_equip_code_s;
    
    @Comment("硫变仪机台名称")
    @Column(nullable=true,length=80)
    private String sa_equip_name_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=20)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识：0-未下发、1-已下发、2-下发失败")
    @Column(nullable=true,length=2)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("密炼快检检验百分比")
    @Column(nullable=true,length=80)
    private String sip_s;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=80)
    private String spare10_s;
    
    @Comment("快检数据同步处理时间")
    @Column(nullable=true,length=80)
    private String spare11_s;
    
    @Comment("快检数据同步处理标记：0-未处理、1-已处理")
    @Column(nullable=true,length=80)
    private String spare12_s;
    
    @Comment("快检数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String spare13_s;
    
    @Comment("密炼产出数据同步处理时间")
    @Column(nullable=true,length=80)
    private String spare14_s;
    
    @Comment("密炼产出数据同步处理标记：0-未处理、1-已处理")
    @Column(nullable=true,length=2000)
    private String spare15_s;
    
    @Comment("密炼产出数据同步处理反馈")
    @Column(nullable=true,length=80)
    private String spare16_s;
    
    @Comment("备用字段17：根据曲线车次是否检查：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String spare17_s;
    
    @Comment("备用字段18：根据曲线车次检查情况")
    @Column(nullable=true,length=2000)
    private String spare18_s;
    
    @Comment("备用字段19：根据曲线车次检查处理时间")
    @Column(nullable=true,length=80)
    private String spare19_s;
    
    @Comment("备用字段1：密炼接口预留")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段20：母胶卡片显示-塑解剂（车次消耗原材料胶料），名称+重量-SPARE20")
    @Column(nullable=true,length=2000)
    private String spare20_s;
    
    @Comment("备用字段2：密炼接口预留")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3：密炼接口预留")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4：密炼接口预留")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5：密炼接口预留")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("备用字段6：是否生成领料计划：0-否、1-是")
    @Column(nullable=true,length=80)
    private String spare6_s;
    
    @Comment("备用字段7：密炼接口预留，配套")
    @Column(nullable=true,length=80)
    private String spare7_s;
    
    @Comment("备用字段8：计划生成：配方名称")
    @Column(nullable=true,length=80)
    private String spare8_s;
    
    @Comment("备用字段9：计划生成：是否有等同物料：0-否、1-是")
    @Column(nullable=true,length=80)
    private String spare9_s;
    
    @Comment("快检工单状态：054001-未生成、054002-已生成、054003-已执行、054004-已暂停、054005-已关闭")
    @Column(nullable=true,length=80)
    private String status_check_s;
    
    @Comment("同步时间")
    @Column(nullable=true,length=0)
    private Date sync_create_time_t;
    
    @Comment("数据同步处理：A-新增、U-修改、D-删除")
    @Column(nullable=true,length=80)
    private String sync_flag_s;
    
    @Comment("数据同步处理标记：0-未处理、1-已处理")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_s;
    
    @Comment("数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_s;
    
    @Comment("数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_t;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("当前检验车次")
    @Column(nullable=true,length=80)
    private String train_num_s;
    
    @Comment("当前称量车次")
    @Column(nullable=true,length=80)
    private String weightche_s;
    
    @Comment("工单生产日期")
    @Column(nullable=true,length=40)
    private String wo_date_s;
    
    @Comment("工单班组：301001-甲班、301002-乙班、301003-丙班")
    @Column(nullable=true,length=80)
    private String wo_group_s;
    
    @Comment("工单号")
    @Column(nullable=true,length=40)
    private String wo_no_s;
    
    @Comment("工单顺序号")
    @Column(nullable=true,length=0)
    private Integer wo_seq_i;
    
    @Comment("工单班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String wo_shift_s;
    
    @Comment("工单状态：054001-正下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭")
    @Column(nullable=true,length=40)
    private String wo_status_s;
    
    @Comment("计划类型：051001-小料计划、051002-硫磺计划、051003-胶料计划（包括快检计划信息）")
    @Column(nullable=true,length=40)
    private String wo_type_s;
    
    public Date getAct_finish_checktime_t(){
        return act_finish_checktime_t;
    }
    
    @XmlElement
    public void setAct_finish_checktime_t(Date act_finish_checktime_t){
        this.act_finish_checktime_t=act_finish_checktime_t;
    }
        
    public Date getAct_finish_time_t(){
        return act_finish_time_t;
    }
    
    @XmlElement
    public void setAct_finish_time_t(Date act_finish_time_t){
        this.act_finish_time_t=act_finish_time_t;
    }
        
    public Date getAct_start_checktime_t(){
        return act_start_checktime_t;
    }
    
    @XmlElement
    public void setAct_start_checktime_t(Date act_start_checktime_t){
        this.act_start_checktime_t=act_start_checktime_t;
    }
        
    public Date getAct_start_time_t(){
        return act_start_time_t;
    }
    
    @XmlElement
    public void setAct_start_time_t(Date act_start_time_t){
        this.act_start_time_t=act_start_time_t;
    }
        
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
        
    public String getBegin_check_train_num_s(){
        return begin_check_train_num_s;
    }
    
    @XmlElement
    public void setBegin_check_train_num_s(String begin_check_train_num_s){
        this.begin_check_train_num_s=begin_check_train_num_s;
    }
        
    public String getBegin_proc_train_num_s(){
        return begin_proc_train_num_s;
    }
    
    @XmlElement
    public void setBegin_proc_train_num_s(String begin_proc_train_num_s){
        this.begin_proc_train_num_s=begin_proc_train_num_s;
    }
        
    public String getBom_ver_id_s(){
        return bom_ver_id_s;
    }
    
    @XmlElement
    public void setBom_ver_id_s(String bom_ver_id_s){
        this.bom_ver_id_s=bom_ver_id_s;
    }
        
    public String getCarrier_code_s(){
        return carrier_code_s;
    }
    
    @XmlElement
    public void setCarrier_code_s(String carrier_code_s){
        this.carrier_code_s=carrier_code_s;
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
        
    public String getEnd_check_train_num_s(){
        return end_check_train_num_s;
    }
    
    @XmlElement
    public void setEnd_check_train_num_s(String end_check_train_num_s){
        this.end_check_train_num_s=end_check_train_num_s;
    }
        
    public String getEnd_proc_train_num_s(){
        return end_proc_train_num_s;
    }
    
    @XmlElement
    public void setEnd_proc_train_num_s(String end_proc_train_num_s){
        this.end_proc_train_num_s=end_proc_train_num_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIs_silo_clean_s(){
        return is_silo_clean_s;
    }
    
    @XmlElement
    public void setIs_silo_clean_s(String is_silo_clean_s){
        this.is_silo_clean_s=is_silo_clean_s;
    }
        
    public String getMaster_by_s(){
        return master_by_s;
    }
    
    @XmlElement
    public void setMaster_by_s(String master_by_s){
        this.master_by_s=master_by_s;
    }
        
    public String getMaster_name_s(){
        return master_name_s;
    }
    
    @XmlElement
    public void setMaster_name_s(String master_name_s){
        this.master_name_s=master_name_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getMi_equip_code_s(){
        return mi_equip_code_s;
    }
    
    @XmlElement
    public void setMi_equip_code_s(String mi_equip_code_s){
        this.mi_equip_code_s=mi_equip_code_s;
    }
        
    public String getMi_equip_name_s(){
        return mi_equip_name_s;
    }
    
    @XmlElement
    public void setMi_equip_name_s(String mi_equip_name_s){
        this.mi_equip_name_s=mi_equip_name_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProduction_ver_s(){
        return production_ver_s;
    }
    
    @XmlElement
    public void setProduction_ver_s(String production_ver_s){
        this.production_ver_s=production_ver_s;
    }
        
    public Integer getQty_check_bad_i(){
        return qty_check_bad_i;
    }
    
    @XmlElement
    public void setQty_check_bad_i(Integer qty_check_bad_i){
        this.qty_check_bad_i=qty_check_bad_i;
    }
        
    public Integer getQty_check_complete_i(){
        return qty_check_complete_i;
    }
    
    @XmlElement
    public void setQty_check_complete_i(Integer qty_check_complete_i){
        this.qty_check_complete_i=qty_check_complete_i;
    }
        
    public String getQty_check_f(){
        return qty_check_f;
    }
    
    @XmlElement
    public void setQty_check_f(String qty_check_f){
        this.qty_check_f=qty_check_f;
    }
        
    public Integer getQty_check_good_i(){
        return qty_check_good_i;
    }
    
    @XmlElement
    public void setQty_check_good_i(Integer qty_check_good_i){
        this.qty_check_good_i=qty_check_good_i;
    }
        
    public Integer getQty_complete_i(){
        return qty_complete_i;
    }
    
    @XmlElement
    public void setQty_complete_i(Integer qty_complete_i){
        this.qty_complete_i=qty_complete_i;
    }
        
    public Integer getQty_plan_i(){
        return qty_plan_i;
    }
    
    @XmlElement
    public void setQty_plan_i(Integer qty_plan_i){
        this.qty_plan_i=qty_plan_i;
    }
        
    public String getQuickcheck_recipe_code_s(){
        return quickcheck_recipe_code_s;
    }
    
    @XmlElement
    public void setQuickcheck_recipe_code_s(String quickcheck_recipe_code_s){
        this.quickcheck_recipe_code_s=quickcheck_recipe_code_s;
    }
        
    public String getRecipe_bom_version_s(){
        return recipe_bom_version_s;
    }
    
    @XmlElement
    public void setRecipe_bom_version_s(String recipe_bom_version_s){
        this.recipe_bom_version_s=recipe_bom_version_s;
    }
        
    public String getRecipe_code_s(){
        return recipe_code_s;
    }
    
    @XmlElement
    public void setRecipe_code_s(String recipe_code_s){
        this.recipe_code_s=recipe_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSa_equip_code_s(){
        return sa_equip_code_s;
    }
    
    @XmlElement
    public void setSa_equip_code_s(String sa_equip_code_s){
        this.sa_equip_code_s=sa_equip_code_s;
    }
        
    public String getSa_equip_name_s(){
        return sa_equip_name_s;
    }
    
    @XmlElement
    public void setSa_equip_name_s(String sa_equip_name_s){
        this.sa_equip_name_s=sa_equip_name_s;
    }
        
    public String getSend_by_s(){
        return send_by_s;
    }
    
    @XmlElement
    public void setSend_by_s(String send_by_s){
        this.send_by_s=send_by_s;
    }
        
    public String getSend_name_s(){
        return send_name_s;
    }
    
    @XmlElement
    public void setSend_name_s(String send_name_s){
        this.send_name_s=send_name_s;
    }
        
    public String getSend_state_s(){
        return send_state_s;
    }
    
    @XmlElement
    public void setSend_state_s(String send_state_s){
        this.send_state_s=send_state_s;
    }
        
    public Date getSend_time_t(){
        return send_time_t;
    }
    
    @XmlElement
    public void setSend_time_t(Date send_time_t){
        this.send_time_t=send_time_t;
    }
        
    public String getSip_s(){
        return sip_s;
    }
    
    @XmlElement
    public void setSip_s(String sip_s){
        this.sip_s=sip_s;
    }
        
    public String getSpare10_s(){
        return spare10_s;
    }
    
    @XmlElement
    public void setSpare10_s(String spare10_s){
        this.spare10_s=spare10_s;
    }
        
    public String getSpare11_s(){
        return spare11_s;
    }
    
    @XmlElement
    public void setSpare11_s(String spare11_s){
        this.spare11_s=spare11_s;
    }
        
    public String getSpare12_s(){
        return spare12_s;
    }
    
    @XmlElement
    public void setSpare12_s(String spare12_s){
        this.spare12_s=spare12_s;
    }
        
    public String getSpare13_s(){
        return spare13_s;
    }
    
    @XmlElement
    public void setSpare13_s(String spare13_s){
        this.spare13_s=spare13_s;
    }
        
    public String getSpare14_s(){
        return spare14_s;
    }
    
    @XmlElement
    public void setSpare14_s(String spare14_s){
        this.spare14_s=spare14_s;
    }
        
    public String getSpare15_s(){
        return spare15_s;
    }
    
    @XmlElement
    public void setSpare15_s(String spare15_s){
        this.spare15_s=spare15_s;
    }
        
    public String getSpare16_s(){
        return spare16_s;
    }
    
    @XmlElement
    public void setSpare16_s(String spare16_s){
        this.spare16_s=spare16_s;
    }
        
    public String getSpare17_s(){
        return spare17_s;
    }
    
    @XmlElement
    public void setSpare17_s(String spare17_s){
        this.spare17_s=spare17_s;
    }
        
    public String getSpare18_s(){
        return spare18_s;
    }
    
    @XmlElement
    public void setSpare18_s(String spare18_s){
        this.spare18_s=spare18_s;
    }
        
    public String getSpare19_s(){
        return spare19_s;
    }
    
    @XmlElement
    public void setSpare19_s(String spare19_s){
        this.spare19_s=spare19_s;
    }
        
    public String getSpare1_s(){
        return spare1_s;
    }
    
    @XmlElement
    public void setSpare1_s(String spare1_s){
        this.spare1_s=spare1_s;
    }
        
    public String getSpare20_s(){
        return spare20_s;
    }
    
    @XmlElement
    public void setSpare20_s(String spare20_s){
        this.spare20_s=spare20_s;
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
        
    public String getStatus_check_s(){
        return status_check_s;
    }
    
    @XmlElement
    public void setStatus_check_s(String status_check_s){
        this.status_check_s=status_check_s;
    }
        
    public Date getSync_create_time_t(){
        return sync_create_time_t;
    }
    
    @XmlElement
    public void setSync_create_time_t(Date sync_create_time_t){
        this.sync_create_time_t=sync_create_time_t;
    }
        
    public String getSync_flag_s(){
        return sync_flag_s;
    }
    
    @XmlElement
    public void setSync_flag_s(String sync_flag_s){
        this.sync_flag_s=sync_flag_s;
    }
        
    public String getSync_hand_flag_s(){
        return sync_hand_flag_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_s(String sync_hand_flag_s){
        this.sync_hand_flag_s=sync_hand_flag_s;
    }
        
    public String getSync_hand_msg_s(){
        return sync_hand_msg_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_s(String sync_hand_msg_s){
        this.sync_hand_msg_s=sync_hand_msg_s;
    }
        
    public Date getSync_hand_time_t(){
        return sync_hand_time_t;
    }
    
    @XmlElement
    public void setSync_hand_time_t(Date sync_hand_time_t){
        this.sync_hand_time_t=sync_hand_time_t;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTrain_num_s(){
        return train_num_s;
    }
    
    @XmlElement
    public void setTrain_num_s(String train_num_s){
        this.train_num_s=train_num_s;
    }
        
    public String getWeightche_s(){
        return weightche_s;
    }
    
    @XmlElement
    public void setWeightche_s(String weightche_s){
        this.weightche_s=weightche_s;
    }
        
    public String getWo_date_s(){
        return wo_date_s;
    }
    
    @XmlElement
    public void setWo_date_s(String wo_date_s){
        this.wo_date_s=wo_date_s;
    }
        
    public String getWo_group_s(){
        return wo_group_s;
    }
    
    @XmlElement
    public void setWo_group_s(String wo_group_s){
        this.wo_group_s=wo_group_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    public Integer getWo_seq_i(){
        return wo_seq_i;
    }
    
    @XmlElement
    public void setWo_seq_i(Integer wo_seq_i){
        this.wo_seq_i=wo_seq_i;
    }
        
    public String getWo_shift_s(){
        return wo_shift_s;
    }
    
    @XmlElement
    public void setWo_shift_s(String wo_shift_s){
        this.wo_shift_s=wo_shift_s;
    }
        
    public String getWo_status_s(){
        return wo_status_s;
    }
    
    @XmlElement
    public void setWo_status_s(String wo_status_s){
        this.wo_status_s=wo_status_s;
    }
        
    public String getWo_type_s(){
        return wo_type_s;
    }
    
    @XmlElement
    public void setWo_type_s(String wo_type_s){
        this.wo_type_s=wo_type_s;
    }
        
    
    
    
}
