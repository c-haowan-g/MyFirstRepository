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
 * 机台信息状态表
 * @author 刘程明
 * @Date 2019-03-06 18:31:24
 */
@ATDefinition("CM_EM_MachineStatus")
@Entity
@XmlRootElement
@Table(name="AT_CM_EM_MACHINESTATUS")
public class MachineStatus extends RockWellBaseEntity{
    
    
    @Comment("机构编号：数据字典 303： 招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("自动/手动要料状态")
    @Column(nullable=true,length=80)
    private String auto_hand_s;
    
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
    
    @Comment("首条计数")
    @Column(nullable=true,length=0)
    private Integer firstnum_i;
    
    @Comment("上一个物料编码")
    @Column(nullable=true,length=80)
    private String lastmaterialcode_s;
    
    @Comment("上一个物料名称")
    @Column(nullable=true,length=80)
    private String lastmaterialname_s;
    
    @Comment("机台条码：需给规则")
    @Column(nullable=true,length=80)
    private String machinebarcode_s;
    
    @Comment("机台状态：数据字典 101")
    @Column(nullable=true,length=80)
    private String machinestatus_s;
    
    @Comment("当前物料编码")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("当前物料名称")
    @Column(nullable=true,length=80)
    private String materialname_s;
    
    @Comment("当前物料规格")
    @Column(nullable=true,length=80)
    private String materialspec_s;
    
    @Comment("物料过期时间")
    @Column(nullable=true,length=0)
    private String material_beyondtime_f;
    
    @Comment("物料存放时间")
    @Column(nullable=true,length=0)
    private String material_parktime_f;
    
    @Comment("机头编码")
    @Column(nullable=true,length=80)
    private String mouldcode_s;
    
    @Comment("工单编号")
    @Column(nullable=true,length=80)
    private String order_code_s;
    
    @Comment("工单完成量")
    @Column(nullable=true,length=0)
    private Integer order_finishi_i;
    
    @Comment("工单计划量")
    @Column(nullable=true,length=0)
    private Integer order_quantity_i;
    
    @Comment("完成量")
    @Column(nullable=true,length=0)
    private Integer outquantity_i;
    
    @Comment("当前计划号")
    @Column(nullable=true,length=80)
    private String planno_s;
    
    @Comment("计划量")
    @Column(nullable=true,length=0)
    private Integer planquantity_i;
    
    @Comment("工艺配方索引号(系统生成)")
    @Column(nullable=true,length=80)
    private String process_index_s;
    
    @Comment("物料版本")
    @Column(nullable=true,length=80)
    private String productiongver_s;
    
    @Comment("生产模式 ：0单条或 1批量")
    @Column(nullable=true,length=80)
    private String producttype_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String remarks_s;
    
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
    
    @Comment("工号1")
    @Column(nullable=true,length=80)
    private String worker1_id_s;
    
    @Comment("姓名1")
    @Column(nullable=true,length=80)
    private String worker1_name_s;
    
    @Comment("工号2")
    @Column(nullable=true,length=80)
    private String worker2_id_s;
    
    @Comment("姓名2")
    @Column(nullable=true,length=80)
    private String worker2_name_s;
    
    @Comment("工号3")
    @Column(nullable=true,length=80)
    private String worker3_id_s;
    
    @Comment("姓名3")
    @Column(nullable=true,length=80)
    private String worker3_name_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAuto_hand_s(){
        return auto_hand_s;
    }
    
    @XmlElement
    public void setAuto_hand_s(String auto_hand_s){
        this.auto_hand_s=auto_hand_s;
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
        
    public Integer getFirstnum_i(){
        return firstnum_i;
    }
    
    @XmlElement
    public void setFirstnum_i(Integer firstnum_i){
        this.firstnum_i=firstnum_i;
    }
        
    public String getLastmaterialcode_s(){
        return lastmaterialcode_s;
    }
    
    @XmlElement
    public void setLastmaterialcode_s(String lastmaterialcode_s){
        this.lastmaterialcode_s=lastmaterialcode_s;
    }
        
    public String getLastmaterialname_s(){
        return lastmaterialname_s;
    }
    
    @XmlElement
    public void setLastmaterialname_s(String lastmaterialname_s){
        this.lastmaterialname_s=lastmaterialname_s;
    }
        
    public String getMachinebarcode_s(){
        return machinebarcode_s;
    }
    
    @XmlElement
    public void setMachinebarcode_s(String machinebarcode_s){
        this.machinebarcode_s=machinebarcode_s;
    }
        
    public String getMachinestatus_s(){
        return machinestatus_s;
    }
    
    @XmlElement
    public void setMachinestatus_s(String machinestatus_s){
        this.machinestatus_s=machinestatus_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialname_s(){
        return materialname_s;
    }
    
    @XmlElement
    public void setMaterialname_s(String materialname_s){
        this.materialname_s=materialname_s;
    }
        
    public String getMaterialspec_s(){
        return materialspec_s;
    }
    
    @XmlElement
    public void setMaterialspec_s(String materialspec_s){
        this.materialspec_s=materialspec_s;
    }
        
    public String getMaterial_beyondtime_f(){
        return material_beyondtime_f;
    }
    
    @XmlElement
    public void setMaterial_beyondtime_f(String material_beyondtime_f){
        this.material_beyondtime_f=material_beyondtime_f;
    }
        
    public String getMaterial_parktime_f(){
        return material_parktime_f;
    }
    
    @XmlElement
    public void setMaterial_parktime_f(String material_parktime_f){
        this.material_parktime_f=material_parktime_f;
    }
        
    public String getMouldcode_s(){
        return mouldcode_s;
    }
    
    @XmlElement
    public void setMouldcode_s(String mouldcode_s){
        this.mouldcode_s=mouldcode_s;
    }
        
    public String getOrder_code_s(){
        return order_code_s;
    }
    
    @XmlElement
    public void setOrder_code_s(String order_code_s){
        this.order_code_s=order_code_s;
    }
        
    public Integer getOrder_finishi_i(){
        return order_finishi_i;
    }
    
    @XmlElement
    public void setOrder_finishi_i(Integer order_finishi_i){
        this.order_finishi_i=order_finishi_i;
    }
        
    public Integer getOrder_quantity_i(){
        return order_quantity_i;
    }
    
    @XmlElement
    public void setOrder_quantity_i(Integer order_quantity_i){
        this.order_quantity_i=order_quantity_i;
    }
        
    public Integer getOutquantity_i(){
        return outquantity_i;
    }
    
    @XmlElement
    public void setOutquantity_i(Integer outquantity_i){
        this.outquantity_i=outquantity_i;
    }
        
    public String getPlanno_s(){
        return planno_s;
    }
    
    @XmlElement
    public void setPlanno_s(String planno_s){
        this.planno_s=planno_s;
    }
        
    public Integer getPlanquantity_i(){
        return planquantity_i;
    }
    
    @XmlElement
    public void setPlanquantity_i(Integer planquantity_i){
        this.planquantity_i=planquantity_i;
    }
        
    public String getProcess_index_s(){
        return process_index_s;
    }
    
    @XmlElement
    public void setProcess_index_s(String process_index_s){
        this.process_index_s=process_index_s;
    }
        
    public String getProductiongver_s(){
        return productiongver_s;
    }
    
    @XmlElement
    public void setProductiongver_s(String productiongver_s){
        this.productiongver_s=productiongver_s;
    }
        
    public String getProducttype_s(){
        return producttype_s;
    }
    
    @XmlElement
    public void setProducttype_s(String producttype_s){
        this.producttype_s=producttype_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemarks_s(){
        return remarks_s;
    }
    
    @XmlElement
    public void setRemarks_s(String remarks_s){
        this.remarks_s=remarks_s;
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
        
    public String getWorker1_id_s(){
        return worker1_id_s;
    }
    
    @XmlElement
    public void setWorker1_id_s(String worker1_id_s){
        this.worker1_id_s=worker1_id_s;
    }
        
    public String getWorker1_name_s(){
        return worker1_name_s;
    }
    
    @XmlElement
    public void setWorker1_name_s(String worker1_name_s){
        this.worker1_name_s=worker1_name_s;
    }
        
    public String getWorker2_id_s(){
        return worker2_id_s;
    }
    
    @XmlElement
    public void setWorker2_id_s(String worker2_id_s){
        this.worker2_id_s=worker2_id_s;
    }
        
    public String getWorker2_name_s(){
        return worker2_name_s;
    }
    
    @XmlElement
    public void setWorker2_name_s(String worker2_name_s){
        this.worker2_name_s=worker2_name_s;
    }
        
    public String getWorker3_id_s(){
        return worker3_id_s;
    }
    
    @XmlElement
    public void setWorker3_id_s(String worker3_id_s){
        this.worker3_id_s=worker3_id_s;
    }
        
    public String getWorker3_name_s(){
        return worker3_name_s;
    }
    
    @XmlElement
    public void setWorker3_name_s(String worker3_name_s){
        this.worker3_name_s=worker3_name_s;
    }
        
    
}
