/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
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
 * 计划库存分析报表_密炼日计划表
 * @author mengh
 * @Date 2020-02-17 11:10:21
 */
@ATDefinition("MX_PP_PLAN")
@Entity
@XmlRootElement
@Table(name="AT_MX_PP_PLAN")
public class MixPlanAnalysis extends RockWellBaseEntity{
    
    
    @Comment("中班执行结束时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_finish_checktime_mid_t;
    
    @Comment("早班执行结束时间")
    @Column(nullable=true,length=0)
    private Date act_finish_checktime_mor_t;
    
    @Comment("晚班执行结束时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_finish_checktime_nig_t;
    
    @Comment("中班执行结束时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_finish_time_mid_t;
    
    @Comment("早班执行结束时间")
    @Column(nullable=true,length=0)
    private Date act_finish_time_mor_t;
    
    @Comment("晚班执行结束时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_finish_time_nig_t;
    
    @Comment("中班执行开始时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_start_checktime_mid_t;
    
    @Comment("早班执行开始时间")
    @Column(nullable=true,length=0)
    private Date act_start_checktime_mor_t;
    
    @Comment("晚班执行开始时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_start_checktime_nig_t;
    
    @Comment("中班执行开始时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_start_time_mid_t;
    
    @Comment("早班执行开始时间")
    @Column(nullable=true,length=0)
    private Date act_start_time_mor_t;
    
    @Comment("晚班执行开始时间：展示DD HH:MM:MM")
    @Column(nullable=true,length=0)
    private Date act_start_time_nig_t;
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
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
    @Column(nullable=true,length=20)
    private String check_by_s;
    
    @Comment("审核人姓名")
    @Column(nullable=true,length=200)
    private String check_name_s;
    
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
    
    @Comment("机台条码")
    @Column(nullable=true,length=40)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("料仓是否清理")
    @Column(nullable=true,length=40)
    private String is_silo_clean_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("备注")
    @Column(nullable=true,length=500)
    private String memo_s;
    
    @Comment("密炼生成配方编号")
    @Column(nullable=true,length=80)
    private String mixrecipe_recipe_code_s;
    
    @Comment("门尼仪机台条码")
    @Column(nullable=true,length=80)
    private String mi_equip_code_s;
    
    @Comment("门尼仪机台名称")
    @Column(nullable=true,length=80)
    private String mi_equip_name_s;
    
    @Comment("计划生产日期")
    @Column(nullable=true,length=40)
    private String plan_date_s;
    
    @Comment("执行结束时间")
    @Column(nullable=true,length=0)
    private Date plan_finish_time_t;
    
    @Comment("日计划号")
    @Column(nullable=true,length=40)
    private String plan_no_s;
    
    @Comment("执行开始时间")
    @Column(nullable=true,length=0)
    private Date plan_start_time_t;
    
    @Comment("计划状态")
    @Column(nullable=true,length=40)
    private String plan_status_s;
    
    @Comment("计划类型")
    @Column(nullable=true,length=40)
    private String plan_type_s;
    
    @Comment("成本收集器版本")
    @Column(nullable=true,length=40)
    private String production_ver_s;
    
    @Comment("中班检验不合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_bad_mid_i;
    
    @Comment("早班检验不合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_bad_mor_i;
    
    @Comment("晚班检验不合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_bad_nig_i;
    
    @Comment("中班检验合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_good_mid_i;
    
    @Comment("早班检验合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_good_mor_i;
    
    @Comment("晚班检验合格数量")
    @Column(nullable=true,length=0)
    private Integer qty_check_good_nig_i;
    
    @Comment("中班计划检验量：车数*检验百分比")
    @Column(nullable=true,length=0)
    private Float qty_check_mid_f;
    
    @Comment("早班计划检验量：车数*检验百分比")
    @Column(nullable=true,length=0)
    private Float qty_check_mor_f;
    
    @Comment("晚班计划检验量：车数*检验百分比")
    @Column(nullable=true,length=0)
    private Float qty_check_nig_f;
    
    @Comment("日计划检验量：车数*检验百分比")
    @Column(nullable=true,length=0)
    private Float qty_check_plan_f;
    
    @Comment("中班完成数量")
    @Column(nullable=true,length=0)
    private Integer qty_complete_mid_i;
    
    @Comment("早班完成数量")
    @Column(nullable=true,length=0)
    private Integer qty_complete_mor_i;
    
    @Comment("晚班完成数量")
    @Column(nullable=true,length=0)
    private Integer qty_complete_nig_i;
    
    @Comment("中班计划量")
    @Column(nullable=true,length=0)
    private Integer qty_mid_i;
    
    @Comment("早班计划量")
    @Column(nullable=true,length=0)
    private Integer qty_mor_i;
    
    @Comment("晚班计划量")
    @Column(nullable=true,length=0)
    private Integer qty_nig_i;
    
    @Comment("日计划量")
    @Column(nullable=true,length=0)
    private Integer qty_plan_i;
    
    @Comment("快检检验配方编号")
    @Column(nullable=true,length=80)
    private String quickcheck_recipe_code_s;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
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
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("备用字段1：密炼接口预留")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2：密炼接口预留")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3：密炼接口预留")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4：密炼接口预留")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5：密炼接口预留")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6：是否生成领料计划：0-否、1-是")
    @Column(nullable=true,length=100)
    private String spare6_s;
    
    @Comment("备用字段7：配方名称")
    @Column(nullable=true,length=100)
    private String spare7_s;
    
    @Comment("备用字段8：工单顺序号")
    @Column(nullable=true,length=100)
    private String spare8_s;
    
    @Comment("备用字段9")
    @Column(nullable=true,length=100)
    private String spare9_s;
    
    @Comment("中班状态")
    @Column(nullable=true,length=80)
    private String status_check_mid_s;
    
    @Comment("早班状态")
    @Column(nullable=true,length=80)
    private String status_check_mor_s;
    
    @Comment("晚班状态")
    @Column(nullable=true,length=800)
    private String status_check_nig_s;
    
    @Comment("中班状态")
    @Column(nullable=true,length=80)
    private String status_mid_s;
    
    @Comment("早班状态")
    @Column(nullable=true,length=80)
    private String status_mor_s;
    
    @Comment("晚班状态")
    @Column(nullable=true,length=80)
    private String status_nig_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    //日完成量
    private String play_complete;
    //日完成率
    private String play_completion;
    //早班
    private String qty_completion_mor_i;
    //中班
    private String qty_completion_mid_i;
    //晚班
    private String qty_completion_nig_i;
    
    
    
    
    public String getPlay_complete() {
		return play_complete;
	}

	public void setPlay_complete(String play_complete) {
		this.play_complete = play_complete;
	}

	public String getPlay_completion() {
		return play_completion;
	}

	public void setPlay_completion(String play_completion) {
		this.play_completion = play_completion;
	}

	public String getQty_completion_mor_i() {
		return qty_completion_mor_i;
	}

	public void setQty_completion_mor_i(String qty_completion_mor_i) {
		this.qty_completion_mor_i = qty_completion_mor_i;
	}

	public String getQty_completion_mid_i() {
		return qty_completion_mid_i;
	}

	public void setQty_completion_mid_i(String qty_completion_mid_i) {
		this.qty_completion_mid_i = qty_completion_mid_i;
	}

	public String getQty_completion_nig_i() {
		return qty_completion_nig_i;
	}

	public void setQty_completion_nig_i(String qty_completion_nig_i) {
		this.qty_completion_nig_i = qty_completion_nig_i;
	}

	public Date getAct_finish_checktime_mid_t(){
        return act_finish_checktime_mid_t;
    }
    
    @XmlElement
    public void setAct_finish_checktime_mid_t(Date act_finish_checktime_mid_t){
        this.act_finish_checktime_mid_t=act_finish_checktime_mid_t;
    }
        
    public Date getAct_finish_checktime_mor_t(){
        return act_finish_checktime_mor_t;
    }
    
    @XmlElement
    public void setAct_finish_checktime_mor_t(Date act_finish_checktime_mor_t){
        this.act_finish_checktime_mor_t=act_finish_checktime_mor_t;
    }
        
    public Date getAct_finish_checktime_nig_t(){
        return act_finish_checktime_nig_t;
    }
    
    @XmlElement
    public void setAct_finish_checktime_nig_t(Date act_finish_checktime_nig_t){
        this.act_finish_checktime_nig_t=act_finish_checktime_nig_t;
    }
        
    public Date getAct_finish_time_mid_t(){
        return act_finish_time_mid_t;
    }
    
    @XmlElement
    public void setAct_finish_time_mid_t(Date act_finish_time_mid_t){
        this.act_finish_time_mid_t=act_finish_time_mid_t;
    }
        
    public Date getAct_finish_time_mor_t(){
        return act_finish_time_mor_t;
    }
    
    @XmlElement
    public void setAct_finish_time_mor_t(Date act_finish_time_mor_t){
        this.act_finish_time_mor_t=act_finish_time_mor_t;
    }
        
    public Date getAct_finish_time_nig_t(){
        return act_finish_time_nig_t;
    }
    
    @XmlElement
    public void setAct_finish_time_nig_t(Date act_finish_time_nig_t){
        this.act_finish_time_nig_t=act_finish_time_nig_t;
    }
        
    public Date getAct_start_checktime_mid_t(){
        return act_start_checktime_mid_t;
    }
    
    @XmlElement
    public void setAct_start_checktime_mid_t(Date act_start_checktime_mid_t){
        this.act_start_checktime_mid_t=act_start_checktime_mid_t;
    }
        
    public Date getAct_start_checktime_mor_t(){
        return act_start_checktime_mor_t;
    }
    
    @XmlElement
    public void setAct_start_checktime_mor_t(Date act_start_checktime_mor_t){
        this.act_start_checktime_mor_t=act_start_checktime_mor_t;
    }
        
    public Date getAct_start_checktime_nig_t(){
        return act_start_checktime_nig_t;
    }
    
    @XmlElement
    public void setAct_start_checktime_nig_t(Date act_start_checktime_nig_t){
        this.act_start_checktime_nig_t=act_start_checktime_nig_t;
    }
        
    public Date getAct_start_time_mid_t(){
        return act_start_time_mid_t;
    }
    
    @XmlElement
    public void setAct_start_time_mid_t(Date act_start_time_mid_t){
        this.act_start_time_mid_t=act_start_time_mid_t;
    }
        
    public Date getAct_start_time_mor_t(){
        return act_start_time_mor_t;
    }
    
    @XmlElement
    public void setAct_start_time_mor_t(Date act_start_time_mor_t){
        this.act_start_time_mor_t=act_start_time_mor_t;
    }
        
    public Date getAct_start_time_nig_t(){
        return act_start_time_nig_t;
    }
    
    @XmlElement
    public void setAct_start_time_nig_t(Date act_start_time_nig_t){
        this.act_start_time_nig_t=act_start_time_nig_t;
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
        
    public String getCheck_name_s(){
        return check_name_s;
    }
    
    @XmlElement
    public void setCheck_name_s(String check_name_s){
        this.check_name_s=check_name_s;
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
        
    public String getMixrecipe_recipe_code_s(){
        return mixrecipe_recipe_code_s;
    }
    
    @XmlElement
    public void setMixrecipe_recipe_code_s(String mixrecipe_recipe_code_s){
        this.mixrecipe_recipe_code_s=mixrecipe_recipe_code_s;
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
        
    public String getPlan_date_s(){
        return plan_date_s;
    }
    
    @XmlElement
    public void setPlan_date_s(String plan_date_s){
        this.plan_date_s=plan_date_s;
    }
        
    public Date getPlan_finish_time_t(){
        return plan_finish_time_t;
    }
    
    @XmlElement
    public void setPlan_finish_time_t(Date plan_finish_time_t){
        this.plan_finish_time_t=plan_finish_time_t;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public Date getPlan_start_time_t(){
        return plan_start_time_t;
    }
    
    @XmlElement
    public void setPlan_start_time_t(Date plan_start_time_t){
        this.plan_start_time_t=plan_start_time_t;
    }
        
    public String getPlan_status_s(){
        return plan_status_s;
    }
    
    @XmlElement
    public void setPlan_status_s(String plan_status_s){
        this.plan_status_s=plan_status_s;
    }
        
    public String getPlan_type_s(){
        return plan_type_s;
    }
    
    @XmlElement
    public void setPlan_type_s(String plan_type_s){
        this.plan_type_s=plan_type_s;
    }
        
    public String getProduction_ver_s(){
        return production_ver_s;
    }
    
    @XmlElement
    public void setProduction_ver_s(String production_ver_s){
        this.production_ver_s=production_ver_s;
    }
        
    public Integer getQty_check_bad_mid_i(){
        return qty_check_bad_mid_i;
    }
    
    @XmlElement
    public void setQty_check_bad_mid_i(Integer qty_check_bad_mid_i){
        this.qty_check_bad_mid_i=qty_check_bad_mid_i;
    }
        
    public Integer getQty_check_bad_mor_i(){
        return qty_check_bad_mor_i;
    }
    
    @XmlElement
    public void setQty_check_bad_mor_i(Integer qty_check_bad_mor_i){
        this.qty_check_bad_mor_i=qty_check_bad_mor_i;
    }
        
    public Integer getQty_check_bad_nig_i(){
        return qty_check_bad_nig_i;
    }
    
    @XmlElement
    public void setQty_check_bad_nig_i(Integer qty_check_bad_nig_i){
        this.qty_check_bad_nig_i=qty_check_bad_nig_i;
    }
        
    public Integer getQty_check_good_mid_i(){
        return qty_check_good_mid_i;
    }
    
    @XmlElement
    public void setQty_check_good_mid_i(Integer qty_check_good_mid_i){
        this.qty_check_good_mid_i=qty_check_good_mid_i;
    }
        
    public Integer getQty_check_good_mor_i(){
        return qty_check_good_mor_i;
    }
    
    @XmlElement
    public void setQty_check_good_mor_i(Integer qty_check_good_mor_i){
        this.qty_check_good_mor_i=qty_check_good_mor_i;
    }
        
    public Integer getQty_check_good_nig_i(){
        return qty_check_good_nig_i;
    }
    
    @XmlElement
    public void setQty_check_good_nig_i(Integer qty_check_good_nig_i){
        this.qty_check_good_nig_i=qty_check_good_nig_i;
    }
        
    public Float getQty_check_mid_f(){
        return qty_check_mid_f;
    }
    
    @XmlElement
    public void setQty_check_mid_f(Float qty_check_mid_f){
        this.qty_check_mid_f=qty_check_mid_f;
    }
        
    public Float getQty_check_mor_f(){
        return qty_check_mor_f;
    }
    
    @XmlElement
    public void setQty_check_mor_f(Float qty_check_mor_f){
        this.qty_check_mor_f=qty_check_mor_f;
    }
        
    public Float getQty_check_nig_f(){
        return qty_check_nig_f;
    }
    
    @XmlElement
    public void setQty_check_nig_f(Float qty_check_nig_f){
        this.qty_check_nig_f=qty_check_nig_f;
    }
        
    public Float getQty_check_plan_f(){
        return qty_check_plan_f;
    }
    
    @XmlElement
    public void setQty_check_plan_f(Float qty_check_plan_f){
        this.qty_check_plan_f=qty_check_plan_f;
    }
        
    public Integer getQty_complete_mid_i(){
        return qty_complete_mid_i;
    }
    
    @XmlElement
    public void setQty_complete_mid_i(Integer qty_complete_mid_i){
        this.qty_complete_mid_i=qty_complete_mid_i;
    }
        
    public Integer getQty_complete_mor_i(){
        return qty_complete_mor_i;
    }
    
    @XmlElement
    public void setQty_complete_mor_i(Integer qty_complete_mor_i){
        this.qty_complete_mor_i=qty_complete_mor_i;
    }
        
    public Integer getQty_complete_nig_i(){
        return qty_complete_nig_i;
    }
    
    @XmlElement
    public void setQty_complete_nig_i(Integer qty_complete_nig_i){
        this.qty_complete_nig_i=qty_complete_nig_i;
    }
        
    public Integer getQty_mid_i(){
        return qty_mid_i;
    }
    
    @XmlElement
    public void setQty_mid_i(Integer qty_mid_i){
        this.qty_mid_i=qty_mid_i;
    }
        
    public Integer getQty_mor_i(){
        return qty_mor_i;
    }
    
    @XmlElement
    public void setQty_mor_i(Integer qty_mor_i){
        this.qty_mor_i=qty_mor_i;
    }
        
    public Integer getQty_nig_i(){
        return qty_nig_i;
    }
    
    @XmlElement
    public void setQty_nig_i(Integer qty_nig_i){
        this.qty_nig_i=qty_nig_i;
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
        
    public String getStatus_check_mid_s(){
        return status_check_mid_s;
    }
    
    @XmlElement
    public void setStatus_check_mid_s(String status_check_mid_s){
        this.status_check_mid_s=status_check_mid_s;
    }
        
    public String getStatus_check_mor_s(){
        return status_check_mor_s;
    }
    
    @XmlElement
    public void setStatus_check_mor_s(String status_check_mor_s){
        this.status_check_mor_s=status_check_mor_s;
    }
        
    public String getStatus_check_nig_s(){
        return status_check_nig_s;
    }
    
    @XmlElement
    public void setStatus_check_nig_s(String status_check_nig_s){
        this.status_check_nig_s=status_check_nig_s;
    }
        
    public String getStatus_mid_s(){
        return status_mid_s;
    }
    
    @XmlElement
    public void setStatus_mid_s(String status_mid_s){
        this.status_mid_s=status_mid_s;
    }
        
    public String getStatus_mor_s(){
        return status_mor_s;
    }
    
    @XmlElement
    public void setStatus_mor_s(String status_mor_s){
        this.status_mor_s=status_mor_s;
    }
        
    public String getStatus_nig_s(){
        return status_nig_s;
    }
    
    @XmlElement
    public void setStatus_nig_s(String status_nig_s){
        this.status_nig_s=status_nig_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    
    
    
}
