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
 * 密炼领料管理
 * @author 王超
 * @Date 2020-08-07 09:12:17
 */
@ATDefinition("MX_PP_MATERIALAPPLY")
@Entity
@XmlRootElement
@Table(name="AT_MX_PP_MATERIALAPPLY")
public class MaterialApply extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("领料申请单号：固定字符+工厂+生产日期+班次+四位流水号 例如 YL92019070110001")
    @Column(nullable=true,length=80)
    private String apply_no_s;
    
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
    @Column(nullable=true,length=40)
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
    
    @Comment("用料生产物料编码")
    @Column(nullable=true,length=200)
    private String child_material_code_s;
    
    @Comment("用料生产物料名称")
    @Column(nullable=true,length=200)
    private String child_material_name_s;
    
    @Comment("结单人")
    @Column(nullable=true,length=20)
    private String close_by_s;
    
    @Comment("结单人姓名")
    @Column(nullable=true,length=200)
    private String close_name_s;
    
    @Comment("结单日期")
    @Column(nullable=true,length=0)
    private Date close_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("数据添加方式：0-计划倒推、1-手动添加")
    @Column(nullable=true,length=80)
    private String data_addmode_s;
    
    @Comment("数据来源：075008-密炼生产、075013-半部件手持")
    @Column(nullable=true,length=80)
    private String data_source_s;
    
    @Comment("用料生产机台条码")
    @Column(nullable=true,length=40)
    private String equip_code_s;
    
    @Comment("用料生产机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("主键ID ")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("配套代码 例如 DQW")
    @Column(nullable=true,length=200)
    private String matchingcode_s;
    
    @Comment("用料生产物料编码")
    @Column(nullable=true,length=2000)
    private String material_code_s;
    
    @Comment("用料生产物料名称")
    @Column(nullable=true,length=2000)
    private String material_name_s;
    
    @Comment("日计划号，外键，MX_PP_PLAN.PLAN_NO")
    @Column(nullable=true,length=2000)
    private String plan_no_s;
    
    @Comment("用料生产日期")
    @Column(nullable=true,length=40)
    private String prod_date_s;
    
    @Comment("用料生产班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String prod_shift_s;
    
    @Comment("所属计划类型用料：051001-小料计划、051002-硫磺计划、051003-胶料计划")
    @Column(nullable=true,length=40)
    private String prod_type_s;
    
    @Comment("接收允许超差数量")
    @Column(nullable=true,length=0)
    private String qty_allow_receive_f;
    
    @Comment("用料生产数量")
    @Column(nullable=true,length=0)
    private String qty_apply_f;
    
    @Comment("接收：数量")
    @Column(nullable=true,length=0)
    private String qty_receive_f;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("备用字段1：领料申请需求类型：0-原材料领料需求、1-密炼领料需求")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2：子物料供应商代码：有两个以上的供应商，则用|分割开供应商代码，如100156|100360|100097 ")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3：发料库区编码 密炼库区类型：062001-B22胶料库、062002-线边库、062003-历史库、062004-小料库、062005-烘胶房、062006-母炼胶库、062007-终练胶料库、062008-返回胶库 原材料库区类型：005001-常温库、005002-加温库、005003-称量预入库、005004-线边库、005005-历史库、005006-炭黑库、005007-辅料库、005008-硫磺库、005009-橡胶库、005010-骨架材料库")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4：工单状态：054001-未下发、054002-已下发、054003-已执行、054004-已暂停、054005-已关闭")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("领料申请单号状态： 064001-未审核 064002-已审核 064003-发料中 064004-已关闭")
    @Column(nullable=true,length=80)
    private String status_check_s;
    
    @Comment("接收库位编号")
    @Column(nullable=true,length=25)
    private String store_code_s;
    
    @Comment("接收库区编码：062001-胶料库、062002-线边库、062003-历史库")
    @Column(nullable=true,length=25)
    private String store_type_s;
    
    @Comment("供应商编号：有两个以上的供应商，则用|分割开供应商代码，如100156|100360|100097 ")
    @Column(nullable=true,length=2000)
    private String supplier_code_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("工单号，外检，MX_PP_WO_EDIT.WO_NO")
    @Column(nullable=true,length=2000)
    private String wo_no_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getApply_no_s(){
        return apply_no_s;
    }
    
    @XmlElement
    public void setApply_no_s(String apply_no_s){
        this.apply_no_s=apply_no_s;
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
        
    public String getChild_material_code_s(){
        return child_material_code_s;
    }
    
    @XmlElement
    public void setChild_material_code_s(String child_material_code_s){
        this.child_material_code_s=child_material_code_s;
    }
        
    public String getChild_material_name_s(){
        return child_material_name_s;
    }
    
    @XmlElement
    public void setChild_material_name_s(String child_material_name_s){
        this.child_material_name_s=child_material_name_s;
    }
        
    public String getClose_by_s(){
        return close_by_s;
    }
    
    @XmlElement
    public void setClose_by_s(String close_by_s){
        this.close_by_s=close_by_s;
    }
        
    public String getClose_name_s(){
        return close_name_s;
    }
    
    @XmlElement
    public void setClose_name_s(String close_name_s){
        this.close_name_s=close_name_s;
    }
        
    public Date getClose_time_t(){
        return close_time_t;
    }
    
    @XmlElement
    public void setClose_time_t(Date close_time_t){
        this.close_time_t=close_time_t;
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
        
    public String getData_addmode_s(){
        return data_addmode_s;
    }
    
    @XmlElement
    public void setData_addmode_s(String data_addmode_s){
        this.data_addmode_s=data_addmode_s;
    }
        
    public String getData_source_s(){
        return data_source_s;
    }
    
    @XmlElement
    public void setData_source_s(String data_source_s){
        this.data_source_s=data_source_s;
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
        
    public String getMatchingcode_s(){
        return matchingcode_s;
    }
    
    @XmlElement
    public void setMatchingcode_s(String matchingcode_s){
        this.matchingcode_s=matchingcode_s;
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
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getProd_date_s(){
        return prod_date_s;
    }
    
    @XmlElement
    public void setProd_date_s(String prod_date_s){
        this.prod_date_s=prod_date_s;
    }
        
    public String getProd_shift_s(){
        return prod_shift_s;
    }
    
    @XmlElement
    public void setProd_shift_s(String prod_shift_s){
        this.prod_shift_s=prod_shift_s;
    }
        
    public String getProd_type_s(){
        return prod_type_s;
    }
    
    @XmlElement
    public void setProd_type_s(String prod_type_s){
        this.prod_type_s=prod_type_s;
    }
        
    public String getQty_allow_receive_f(){
        return qty_allow_receive_f;
    }
    
    @XmlElement
    public void setQty_allow_receive_f(String qty_allow_receive_f){
        this.qty_allow_receive_f=qty_allow_receive_f;
    }
        
    public String getQty_apply_f(){
        return qty_apply_f;
    }
    
    @XmlElement
    public void setQty_apply_f(String qty_apply_f){
        this.qty_apply_f=qty_apply_f;
    }
        
    public String getQty_receive_f(){
        return qty_receive_f;
    }
    
    @XmlElement
    public void setQty_receive_f(String qty_receive_f){
        this.qty_receive_f=qty_receive_f;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    public String getStatus_check_s(){
        return status_check_s;
    }
    
    @XmlElement
    public void setStatus_check_s(String status_check_s){
        this.status_check_s=status_check_s;
    }
        
    public String getStore_code_s(){
        return store_code_s;
    }
    
    @XmlElement
    public void setStore_code_s(String store_code_s){
        this.store_code_s=store_code_s;
    }
        
    public String getStore_type_s(){
        return store_type_s;
    }
    
    @XmlElement
    public void setStore_type_s(String store_type_s){
        this.store_type_s=store_type_s;
    }
        
    public String getSupplier_code_s(){
        return supplier_code_s;
    }
    
    @XmlElement
    public void setSupplier_code_s(String supplier_code_s){
        this.supplier_code_s=supplier_code_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
