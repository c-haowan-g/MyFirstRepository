/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.entity;

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
 * 原材料称量表
 * @author 李德晓
 * @Date 2020-08-10 15:29:52
 */
@ATDefinition("RM_MM_WEIGHTTOFACTORY")
@Entity
@XmlRootElement
@Table(name="AT_RM_MM_WEIGHTTOFACTORY")
public class WeightFactory extends RockWellBaseEntity{
    
    
    @Comment("机构编号")
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
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("到货日期")
    @Column(nullable=true,length=80)
    private String delivery_date_s;
    
    @Comment("SAP内向交货单表，内向交货单行号")
    @Column(nullable=true,length=80)
    private String dn_dnitem_s;
    
    @Comment("SAP内向交货单表，内向交货单号")
    @Column(nullable=true,length=80)
    private String dn_dnno_s;
    
    @Comment("SAP内向交货单表，ERP 采购订单行号")
    @Column(nullable=true,length=80)
    private String dn_referenceitem_s;
    
    @Comment("SAP内向交货单表，ERP 采购订单号")
    @Column(nullable=true,length=80)
    private String dn_referenceno_s;
    
    @Comment("SAP内向交货单表，出货单单号")
    @Column(nullable=true,length=80)
    private String dn_salordid_s;
    
    @Comment("SAP内向交货单表，出货单行号")
    @Column(nullable=true,length=80)
    private String dn_salorditem_s;
    
    @Comment("过毛操作人")
    @Column(nullable=true,length=20)
    private String gross_by_s;
    
    @Comment("过毛操作人姓名")
    @Column(nullable=true,length=200)
    private String gross_name_s;
    
    @Comment("过毛重时间")
    @Column(nullable=true,length=0)
    private Date gross_time_t;
    
    @Comment("毛重")
    @Column(nullable=true,length=0)
    private String gross_weight_f;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("是否入库：0-否、1-是")
    @Column(nullable=true,length=20)
    private String is_instore_s;
    
    @Comment("进厂批次")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("净重（实际交货数量）")
    @Column(nullable=true,length=0)
    private String net_weight_f;
    
    @Comment("供应商原料批次号生产日期")
    @Column(nullable=true,length=0)
    private Date product_time_t;
    
    @Comment("交货数量")
    @Column(nullable=true,length=0)
    private String qty_left_f;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("样品批次")
    @Column(nullable=true,length=80)
    private String samplebatch_s;
    
    @Comment("预留1")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("称量状态：007001-未接收、007002-已接收、007003-称量中、007004-称量完成")
    @Column(nullable=true,length=40)
    private String status_s;
    
    @Comment("供应商编号")
    @Column(nullable=true,length=100)
    private String supplier_code_s;
    
    @Comment("供应商批次号：长度21位  物料号(9位)、年月日(6位)、供应商（6位）")
    @Column(nullable=true,length=100)
    private String supplier_lot_no_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("过皮操作人")
    @Column(nullable=true,length=20)
    private String tare_by_s;
    
    @Comment("过皮操作人姓名")
    @Column(nullable=true,length=200)
    private String tare_name_s;
    
    @Comment("过皮重时间")
    @Column(nullable=true,length=0)
    private Date tare_time_t;
    
    @Comment("皮重")
    @Column(nullable=true,length=0)
    private String tare_weight_f;
    
    @Comment("专业组ID")
    @Column(nullable=true,length=80)
    private String tdmgroupid_s;
    
    @Comment("TDM检测任务推送表，MES业务主键")
    @Column(nullable=true,length=80)
    private String testare_mesbusinesscode_s;
    
    @Comment("操作班组")
    @Column(nullable=true,length=20)
    private String weight_group_s;
    
    @Comment("计量单号")
    @Column(nullable=true,length=80)
    private String weight_number_s;
    
    @Comment("操作班次")
    @Column(nullable=true,length=20)
    private String weight_shift_s;
    
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
        
    public String getDelivery_date_s(){
        return delivery_date_s;
    }
    
    @XmlElement
    public void setDelivery_date_s(String delivery_date_s){
        this.delivery_date_s=delivery_date_s;
    }
        
    public String getDn_dnitem_s(){
        return dn_dnitem_s;
    }
    
    @XmlElement
    public void setDn_dnitem_s(String dn_dnitem_s){
        this.dn_dnitem_s=dn_dnitem_s;
    }
        
    public String getDn_dnno_s(){
        return dn_dnno_s;
    }
    
    @XmlElement
    public void setDn_dnno_s(String dn_dnno_s){
        this.dn_dnno_s=dn_dnno_s;
    }
        
    public String getDn_referenceitem_s(){
        return dn_referenceitem_s;
    }
    
    @XmlElement
    public void setDn_referenceitem_s(String dn_referenceitem_s){
        this.dn_referenceitem_s=dn_referenceitem_s;
    }
        
    public String getDn_referenceno_s(){
        return dn_referenceno_s;
    }
    
    @XmlElement
    public void setDn_referenceno_s(String dn_referenceno_s){
        this.dn_referenceno_s=dn_referenceno_s;
    }
        
    public String getDn_salordid_s(){
        return dn_salordid_s;
    }
    
    @XmlElement
    public void setDn_salordid_s(String dn_salordid_s){
        this.dn_salordid_s=dn_salordid_s;
    }
        
    public String getDn_salorditem_s(){
        return dn_salorditem_s;
    }
    
    @XmlElement
    public void setDn_salorditem_s(String dn_salorditem_s){
        this.dn_salorditem_s=dn_salorditem_s;
    }
        
    public String getGross_by_s(){
        return gross_by_s;
    }
    
    @XmlElement
    public void setGross_by_s(String gross_by_s){
        this.gross_by_s=gross_by_s;
    }
        
    public String getGross_name_s(){
        return gross_name_s;
    }
    
    @XmlElement
    public void setGross_name_s(String gross_name_s){
        this.gross_name_s=gross_name_s;
    }
        
    public Date getGross_time_t(){
        return gross_time_t;
    }
    
    @XmlElement
    public void setGross_time_t(Date gross_time_t){
        this.gross_time_t=gross_time_t;
    }
        
    public String getGross_weight_f(){
        return gross_weight_f;
    }
    
    @XmlElement
    public void setGross_weight_f(String gross_weight_f){
        this.gross_weight_f=gross_weight_f;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIs_instore_s(){
        return is_instore_s;
    }
    
    @XmlElement
    public void setIs_instore_s(String is_instore_s){
        this.is_instore_s=is_instore_s;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
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
        
    public String getNet_weight_f(){
        return net_weight_f;
    }
    
    @XmlElement
    public void setNet_weight_f(String net_weight_f){
        this.net_weight_f=net_weight_f;
    }
        
    public Date getProduct_time_t(){
        return product_time_t;
    }
    
    @XmlElement
    public void setProduct_time_t(Date product_time_t){
        this.product_time_t=product_time_t;
    }
        
    public String getQty_left_f(){
        return qty_left_f;
    }
    
    @XmlElement
    public void setQty_left_f(String qty_left_f){
        this.qty_left_f=qty_left_f;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getSamplebatch_s(){
        return samplebatch_s;
    }
    
    @XmlElement
    public void setSamplebatch_s(String samplebatch_s){
        this.samplebatch_s=samplebatch_s;
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
        
    public String getSupplier_code_s(){
        return supplier_code_s;
    }
    
    @XmlElement
    public void setSupplier_code_s(String supplier_code_s){
        this.supplier_code_s=supplier_code_s;
    }
        
    public String getSupplier_lot_no_s(){
        return supplier_lot_no_s;
    }
    
    @XmlElement
    public void setSupplier_lot_no_s(String supplier_lot_no_s){
        this.supplier_lot_no_s=supplier_lot_no_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTare_by_s(){
        return tare_by_s;
    }
    
    @XmlElement
    public void setTare_by_s(String tare_by_s){
        this.tare_by_s=tare_by_s;
    }
        
    public String getTare_name_s(){
        return tare_name_s;
    }
    
    @XmlElement
    public void setTare_name_s(String tare_name_s){
        this.tare_name_s=tare_name_s;
    }
        
    public Date getTare_time_t(){
        return tare_time_t;
    }
    
    @XmlElement
    public void setTare_time_t(Date tare_time_t){
        this.tare_time_t=tare_time_t;
    }
        
    public String getTare_weight_f(){
        return tare_weight_f;
    }
    
    @XmlElement
    public void setTare_weight_f(String tare_weight_f){
        this.tare_weight_f=tare_weight_f;
    }
        
    public String getTdmgroupid_s(){
        return tdmgroupid_s;
    }
    
    @XmlElement
    public void setTdmgroupid_s(String tdmgroupid_s){
        this.tdmgroupid_s=tdmgroupid_s;
    }
        
    public String getTestare_mesbusinesscode_s(){
        return testare_mesbusinesscode_s;
    }
    
    @XmlElement
    public void setTestare_mesbusinesscode_s(String testare_mesbusinesscode_s){
        this.testare_mesbusinesscode_s=testare_mesbusinesscode_s;
    }
        
    public String getWeight_group_s(){
        return weight_group_s;
    }
    
    @XmlElement
    public void setWeight_group_s(String weight_group_s){
        this.weight_group_s=weight_group_s;
    }
        
    public String getWeight_number_s(){
        return weight_number_s;
    }
    
    @XmlElement
    public void setWeight_number_s(String weight_number_s){
        this.weight_number_s=weight_number_s;
    }
        
    public String getWeight_shift_s(){
        return weight_shift_s;
    }
    
    @XmlElement
    public void setWeight_shift_s(String weight_shift_s){
        this.weight_shift_s=weight_shift_s;
    }
        
    
    
    
}
