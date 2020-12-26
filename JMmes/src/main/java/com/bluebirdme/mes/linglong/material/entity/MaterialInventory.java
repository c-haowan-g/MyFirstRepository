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
 * 原材料库存表
 * @author 李德晓
 * @Date 2020-08-06 12:12:08
 */
@SuppressWarnings("serial")
@ATDefinition("RM_WH_ITEM_INV")
@Entity
@XmlRootElement
@Table(name="AT_RM_WH_ITEM_INV")
public class MaterialInventory extends RockWellBaseEntity{
    
    
    @Comment("SAP报产固化标识：0-未固化、1-已固化")
    @Column(nullable=true,length=2)
    private String actual_flag_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("基本单位")
    @Column(nullable=true,length=6)
    private String baseunit_s;
    
    @Comment("载具编号")
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
    
    @Comment("检测人")
    @Column(nullable=true,length=20)
    private String check_by_s;
    
    @Comment("最终检测结果")
    @Column(nullable=true,length=80)
    private String check_result_s;
    
    @Comment("检测日期")
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
    
    @Comment("允许出库日期")
    @Column(nullable=true,length=0)
    private Date date_allow_out_t;
    
    @Comment("SAP内向交货单表，内向交货单行号")
    @Column(nullable=true,length=80)
    private String dn_dnitem_s;
    
    @Comment("SAP内向交货单表，内向交货单号")
    @Column(nullable=true,length=80)
    private String dn_dnno_s;
    
    @Comment("SAP内向交货单表，出货单单号")
    @Column(nullable=true,length=80)
    private String dn_salordid_s;
    
    @Comment("SAP内向交货单表，出货单行号")
    @Column(nullable=true,length=80)
    private String dn_salorditem_s;
    
    @Comment("物料过期日期")
    @Column(nullable=true,length=0)
    private Date expiry_date_t;
    
    @Comment("超期处理次数")
    @Column(nullable=false,length=0)
    private Integer expiry_hand_count_i;
    
    @Comment("超期处理备注")
    @Column(nullable=true,length=100)
    private String expiry_hand_remark_s;
    
    @Comment("等级编码")
    @Column(nullable=false,length=50)
    private String grade_code_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("入库日期")
    @Column(nullable=true,length=0)
    private Date in_time_t;
    
    @Comment("进厂批次（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=40)
    private String materialgroup_s;
    
    @Comment("物料类别(上辅机定义)")
    @Column(nullable=true,length=40)
    private String materialtype_s;
    
    @Comment("物料类别（SAP定义）")
    @Column(nullable=true,length=40)
    private String materialtype_sap_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=40)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("入库数量")
    @Column(nullable=true,length=0)
    private Integer num_in_i;
    
    @Comment("是否超期:0-正常状态 1-超期")
    @Column(nullable=true,length=5)
    private String outofdateflag_s;
    
    @Comment("是否优先使用：0-否、1-是")
    @Column(nullable=true,length=50)
    private String prioritymat_flag_s;
    
    @Comment("供应商原料批次号生产日期")
    @Column(nullable=true,length=0)
    private Date product_time_t;
    
    @Comment("入库重量")
    @Column(nullable=true,length=0)
    private String qty_in_f;
    
    @Comment("库存剩余重量")
    @Column(nullable=true,length=0)
    private String qty_left_f;
    
    @Comment("放行原因")
    @Column(nullable=true,length=50)
    private String reas_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("SAP报产冲销标识：0-否、1-是")
    @Column(nullable=true,length=2)
    private String reverser_flag_s;
    
    @Comment("自检标识：默认0合格，1不合格")
    @Column(nullable=true,length=5)
    private String self_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识：0-未下发、1-已下发、2-下发失败")
    @Column(nullable=true,length=80)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("备用字段10")
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("备用字段1：数量")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2：单件重量")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3：库区名称")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4：库位名称")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5：发料状态：010001-待发料、010002-发料中、010003-发料完成")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6：DQW检测项名称-气味等级是否合格：0-无DQW检测项，1-合格，2-不合格")
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
    
    @Comment("状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格、特殊放行的）、 001004-封锁（MES不能调拨出库） 001005-特殊放行（24小时内无检测结果可操作，反之不允许）")
    @Column(nullable=true,length=50)
    private String state_code_s;
    
    @Comment("库位编号")
    @Column(nullable=true,length=25)
    private String store_code_s;
    
    @Comment("库区类型：005001-常温库、005002-加温库、005003-称量预入库、005004-线边库、005006-炭黑库、005007-辅料库、005008-硫磺库、005009-橡胶库、005010-骨架材料库、005011-油料库、005012-立体库、005013-白炭黑库")
    @Column(nullable=true,length=25)
    private String store_type_s;
    
    @Comment("供应商编号")
    @Column(nullable=true,length=100)
    private String supplier_code_s;
    
    @Comment("供应商原料批次号（9位品号+生产日期+6供应商编号）：21位或23位 例如：1010000091904271005500001")
    @Column(nullable=true,length=100)
    private String supplier_lot_no_s;
    
    @Comment("供应商全称")
    @Column(nullable=true,length=200)
    private String supplier_name_s;
    
    @Comment("截存结束时间")
    @Column(nullable=true,length=0)
    private Date sys_finish_time_t;
    
    @Comment("截存开始时间")
    @Column(nullable=true,length=0)
    private Date sys_start_time_t;
    
    @Comment("是否试验料：0-否，1-是")
    @Column(nullable=true,length=50)
    private String testmat_flag_s;
    
    @Comment("TDM检测任务推送表，MES业务主键")
    @Column(nullable=true,length=40)
    private String test_mesbusinesscode_s;
    
    @Comment("托盘编号")
    @Column(nullable=true,length=25)
    private String tray_code_s;
    
    @Comment("立库编号")
    @Column(nullable=true,length=25)
    private String warehouseid_s;
    
    @Comment("出库目标位置")
    @Column(nullable=true,length=25)
    private String warehouse_location_s;
    
    @Comment("出库方式")
    @Column(nullable=true,length=25)
    private String warehouse_mode_s;
    
    @Comment("原材料称量表，计量单号")
    @Column(nullable=true,length=40)
    private String weight_number_s;
    
    public String getActual_flag_s(){
        return actual_flag_s;
    }
    
    @XmlElement
    public void setActual_flag_s(String actual_flag_s){
        this.actual_flag_s=actual_flag_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getBaseunit_s(){
        return baseunit_s;
    }
    
    @XmlElement
    public void setBaseunit_s(String baseunit_s){
        this.baseunit_s=baseunit_s;
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
        
    public String getCheck_result_s(){
        return check_result_s;
    }
    
    @XmlElement
    public void setCheck_result_s(String check_result_s){
        this.check_result_s=check_result_s;
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
        
    public Date getDate_allow_out_t(){
        return date_allow_out_t;
    }
    
    @XmlElement
    public void setDate_allow_out_t(Date date_allow_out_t){
        this.date_allow_out_t=date_allow_out_t;
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
        
    public Date getExpiry_date_t(){
        return expiry_date_t;
    }
    
    @XmlElement
    public void setExpiry_date_t(Date expiry_date_t){
        this.expiry_date_t=expiry_date_t;
    }
        
    public Integer getExpiry_hand_count_i(){
        return expiry_hand_count_i;
    }
    
    @XmlElement
    public void setExpiry_hand_count_i(Integer expiry_hand_count_i){
        this.expiry_hand_count_i=expiry_hand_count_i;
    }
        
    public String getExpiry_hand_remark_s(){
        return expiry_hand_remark_s;
    }
    
    @XmlElement
    public void setExpiry_hand_remark_s(String expiry_hand_remark_s){
        this.expiry_hand_remark_s=expiry_hand_remark_s;
    }
        
    public String getGrade_code_s(){
        return grade_code_s;
    }
    
    @XmlElement
    public void setGrade_code_s(String grade_code_s){
        this.grade_code_s=grade_code_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public Date getIn_time_t(){
        return in_time_t;
    }
    
    @XmlElement
    public void setIn_time_t(Date in_time_t){
        this.in_time_t=in_time_t;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
    }
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
    }
        
    public String getMaterialtype_s(){
        return materialtype_s;
    }
    
    @XmlElement
    public void setMaterialtype_s(String materialtype_s){
        this.materialtype_s=materialtype_s;
    }
        
    public String getMaterialtype_sap_s(){
        return materialtype_sap_s;
    }
    
    @XmlElement
    public void setMaterialtype_sap_s(String materialtype_sap_s){
        this.materialtype_sap_s=materialtype_sap_s;
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
        
    public Integer getNum_in_i(){
        return num_in_i;
    }
    
    @XmlElement
    public void setNum_in_i(Integer num_in_i){
        this.num_in_i=num_in_i;
    }
        
    public String getOutofdateflag_s(){
        return outofdateflag_s;
    }
    
    @XmlElement
    public void setOutofdateflag_s(String outofdateflag_s){
        this.outofdateflag_s=outofdateflag_s;
    }
        
    public String getPrioritymat_flag_s(){
        return prioritymat_flag_s;
    }
    
    @XmlElement
    public void setPrioritymat_flag_s(String prioritymat_flag_s){
        this.prioritymat_flag_s=prioritymat_flag_s;
    }
        
    public Date getProduct_time_t(){
        return product_time_t;
    }
    
    @XmlElement
    public void setProduct_time_t(Date product_time_t){
        this.product_time_t=product_time_t;
    }
        
    public String getQty_in_f(){
        return qty_in_f;
    }
    
    @XmlElement
    public void setQty_in_f(String qty_in_f){
        this.qty_in_f=qty_in_f;
    }
        
    public String getQty_left_f(){
        return qty_left_f;
    }
    
    @XmlElement
    public void setQty_left_f(String qty_left_f){
        this.qty_left_f=qty_left_f;
    }
        
    public String getReas_code_s(){
        return reas_code_s;
    }
    
    @XmlElement
    public void setReas_code_s(String reas_code_s){
        this.reas_code_s=reas_code_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getReverser_flag_s(){
        return reverser_flag_s;
    }
    
    @XmlElement
    public void setReverser_flag_s(String reverser_flag_s){
        this.reverser_flag_s=reverser_flag_s;
    }
        
    public String getSelf_flag_s(){
        return self_flag_s;
    }
    
    @XmlElement
    public void setSelf_flag_s(String self_flag_s){
        this.self_flag_s=self_flag_s;
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
        
    public String getState_code_s(){
        return state_code_s;
    }
    
    @XmlElement
    public void setState_code_s(String state_code_s){
        this.state_code_s=state_code_s;
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
        
    public String getSupplier_lot_no_s(){
        return supplier_lot_no_s;
    }
    
    @XmlElement
    public void setSupplier_lot_no_s(String supplier_lot_no_s){
        this.supplier_lot_no_s=supplier_lot_no_s;
    }
        
    public String getSupplier_name_s(){
        return supplier_name_s;
    }
    
    @XmlElement
    public void setSupplier_name_s(String supplier_name_s){
        this.supplier_name_s=supplier_name_s;
    }
        
    public Date getSys_finish_time_t(){
        return sys_finish_time_t;
    }
    
    @XmlElement
    public void setSys_finish_time_t(Date sys_finish_time_t){
        this.sys_finish_time_t=sys_finish_time_t;
    }
        
    public Date getSys_start_time_t(){
        return sys_start_time_t;
    }
    
    @XmlElement
    public void setSys_start_time_t(Date sys_start_time_t){
        this.sys_start_time_t=sys_start_time_t;
    }
        
    public String getTestmat_flag_s(){
        return testmat_flag_s;
    }
    
    @XmlElement
    public void setTestmat_flag_s(String testmat_flag_s){
        this.testmat_flag_s=testmat_flag_s;
    }
        
    public String getTest_mesbusinesscode_s(){
        return test_mesbusinesscode_s;
    }
    
    @XmlElement
    public void setTest_mesbusinesscode_s(String test_mesbusinesscode_s){
        this.test_mesbusinesscode_s=test_mesbusinesscode_s;
    }
        
    public String getTray_code_s(){
        return tray_code_s;
    }
    
    @XmlElement
    public void setTray_code_s(String tray_code_s){
        this.tray_code_s=tray_code_s;
    }
        
    public String getWarehouseid_s(){
        return warehouseid_s;
    }
    
    @XmlElement
    public void setWarehouseid_s(String warehouseid_s){
        this.warehouseid_s=warehouseid_s;
    }
        
    public String getWarehouse_location_s(){
        return warehouse_location_s;
    }
    
    @XmlElement
    public void setWarehouse_location_s(String warehouse_location_s){
        this.warehouse_location_s=warehouse_location_s;
    }
        
    public String getWarehouse_mode_s(){
        return warehouse_mode_s;
    }
    
    @XmlElement
    public void setWarehouse_mode_s(String warehouse_mode_s){
        this.warehouse_mode_s=warehouse_mode_s;
    }
        
    public String getWeight_number_s(){
        return weight_number_s;
    }
    
    @XmlElement
    public void setWeight_number_s(String weight_number_s){
        this.weight_number_s=weight_number_s;
    }
        
    
    
    
}
