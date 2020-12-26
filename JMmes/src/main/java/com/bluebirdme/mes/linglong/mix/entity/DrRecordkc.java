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
 * 密炼库存操作履历表
 * @author 陈国强
 * @Date 2020-08-16 09:58:50
 */
@ATDefinition("MX_WH_ITEM_INV_RECORD")
@Entity
@XmlRootElement
@Table(name="AT_MX_WH_ITEM_INV_RECORD")
public class DrRecordkc extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
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
    @Column(nullable=true,length=200)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=200)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("机台编码")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("物料过期日期")
    @Column(nullable=true,length=80)
    private String expiry_date_s;
    
    @Comment("等级编码-备用")
    @Column(nullable=true,length=50)
    private String grade_code_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("库存操作类型：072001-入库、072002-出库、072003-移库、072004-发料、072005-第三方反馈")
    @Column(nullable=true,length=80)
    private String inv_type_s;
    
    @Comment("批次号")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=40)
    private String materialgroup_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=25)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("出库状态：0-未出库、1-已出库")
    @Column(nullable=true,length=25)
    private String out_flag_s;
    
    @Comment("密炼日计划表，日计划号，外键，MX_PP_PLAN.PLAN_NO")
    @Column(nullable=true,length=80)
    private String plan_no_s;
    
    @Comment("是否优先使用：0-否、1-是")
    @Column(nullable=true,length=50)
    private String prioritymat_flag_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=80)
    private String product_time_s;
    
    @Comment("操作生产日期：yyyyMMdd")
    @Column(nullable=true,length=80)
    private String prod_date_s;
    
    @Comment("操作生产班次：302001-早班、302002-中班、302003-晚班")
    @Column(nullable=true,length=80)
    private String prod_shift_code_s;
    
    @Comment("操作库存量")
    @Column(nullable=true,length=0)
    private String qty_f;
    
    @Comment("库存剩余数量")
    @Column(nullable=true,length=0)
    private String qty_left_f;
    
    @Comment("放行原因：067001-特殊放行、067002-超期处理")
    @Column(nullable=true,length=50)
    private String reas_code_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
    @Comment("密炼生成配方编号")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("请求备注")
    @Column(nullable=true,length=200)
    private String request_remark_s;
    
    @Comment("请求状态：0-发出请求、1-正常反馈、2-离线反馈")
    @Column(nullable=true,length=25)
    private String request_state_s;
    
    @Comment("入库、出库请求时间")
    @Column(nullable=true,length=0)
    private Date request_time_t;
    
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
    
    @Comment("备用字段10：被拆批次号")
    @Column(nullable=true,length=100)
    private String spare10_s;
    
    @Comment("备用字段1：密炼接口预留：小料接口传无称量实绩原因备注，数据同步处理：A-最新数据、D-删除，重新下发：下发人，胶片立库接口预留：出库楼层1-一楼、2-二楼")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2：密炼接口预留：胶料接口传载具编号、小料接口传小料车装车总袋数，重新下发：下发人姓名，胶片立库接口预留：空胶案类型 1-胶案、2-工字轮 出库区分为063014时传值")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3：密炼接口预留：小料接口传产出类型：0-小料袋、1-小料车，线边库下发接口传是否掺胶：Yes-掺胶、No-不掺胶，重新下发：下发时间，胶片立库接口预留：载具数量，默认1")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4：密炼接口预留：小料接口传小料袋关联小料车批次号，线边库下发接口传配方阶段：ZC-正常、ZCC-不正常、SY-实验，重新下发：下发标识：0-未下发、1-已下发、2-下发失败 原材料领料、发料-进厂批次：（G固定字符+4位年号+-固定字符+4位流水号）例如：G2019-0001")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5：密炼接口预留：线边库下发接口传配方类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗 烘胶房拆胶-打印方式： 069001-未打印 069002-已打印（手动） 069003-已打印（自动） 069004-补充打印")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("备用字段6：拆批人")
    @Column(nullable=true,length=100)
    private String spare6_s;
    
    @Comment("备用字段7：拆批时间")
    @Column(nullable=true,length=100)
    private String spare7_s;
    
    @Comment("备用字段8：入烘胶房时间")
    @Column(nullable=true,length=100)
    private String spare8_s;
    
    @Comment("备用字段9：出烘胶房时间")
    @Column(nullable=true,length=100)
    private String spare9_s;
    
    @Comment("状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库）")
    @Column(nullable=true,length=50)
    private String state_code_s;
    
    @Comment("库位编号")
    @Column(nullable=true,length=25)
    private String store_code_s;
    
    @Comment("库区类型：062001-胶料库、062002-线边库、062004-普通小料包库、062005-烘胶房-天然胶库、062006-母炼胶-胶案库、062007-终练胶-胶案库、062008-返回胶库、062009-母炼胶-小车库、062010-终练胶-小车库、062011-烘胶房-合成胶库、062012-硫磺小料包库、062013-炭黑库(密炼)、062014-辅料库(密炼)、062015-硫磺库(密炼)、062016-油料库(密炼)、062017-烘胶房-线边库")
    @Column(nullable=true,length=25)
    private String store_type_s;
    
    @Comment("原材料供应商编号")
    @Column(nullable=true,length=100)
    private String supplier_code_s;
    
    @Comment("原材料供应商全称")
    @Column(nullable=true,length=200)
    private String supplier_name_s;
    
    @Comment("工厂代码（1.全钢，2.半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("是否试验料：0-否，1-是")
    @Column(nullable=true,length=50)
    private String testmat_flag_s;
    
    @Comment("托盘编号")
    @Column(nullable=true,length=25)
    private String tray_code_s;
    
    @Comment("立库编号（1、2、3、4、5...）")
    @Column(nullable=true,length=25)
    private String warehouseid_s;
    
    @Comment("出库目标位置")
    @Column(nullable=true,length=25)
    private String warehouse_location_s;
    
    @Comment("出库方式：1-指定批次、2-指定托盘、3-指定物料编码、4-指定配套代码、物料编码、5-指定配方名称、6-指定载具编号")
    @Column(nullable=true,length=25)
    private String warehouse_mode_s;
    
    @Comment("库存操作备注")
    @Column(nullable=true,length=500)
    private String warehouse_remark_s;
    
    @Comment("库存操作区分： 063001-产出新增入库 063002-手动入库 063003-退库入库 063004-返回胶入库 063005-空胶案入库 063010-生产出库 063011-手动出库 063012-检查出库 063013-不良出库 063014-空胶案出库 063020-生产移库 063021-手动移库 063022-检查移库 063023-不良移库  063024-拆批入库  063025-手动盘库 063030-手动发料 063031-自动发料 063040-库存更新 063041-其它")
    @Column(nullable=true,length=25)
    private String warehouse_type_s;
    
    @Comment("密炼工单跟踪表，工单号，外检，MX_PP_WO_EDIT.WO_NO")
    @Column(nullable=true,length=40)
    private String wo_no_s;
    
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
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getExpiry_date_s(){
        return expiry_date_s;
    }
    
    @XmlElement
    public void setExpiry_date_s(String expiry_date_s){
        this.expiry_date_s=expiry_date_s;
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
        
    public String getInv_type_s(){
        return inv_type_s;
    }
    
    @XmlElement
    public void setInv_type_s(String inv_type_s){
        this.inv_type_s=inv_type_s;
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
        
    public String getOut_flag_s(){
        return out_flag_s;
    }
    
    @XmlElement
    public void setOut_flag_s(String out_flag_s){
        this.out_flag_s=out_flag_s;
    }
        
    public String getPlan_no_s(){
        return plan_no_s;
    }
    
    @XmlElement
    public void setPlan_no_s(String plan_no_s){
        this.plan_no_s=plan_no_s;
    }
        
    public String getPrioritymat_flag_s(){
        return prioritymat_flag_s;
    }
    
    @XmlElement
    public void setPrioritymat_flag_s(String prioritymat_flag_s){
        this.prioritymat_flag_s=prioritymat_flag_s;
    }
        
    public String getProduct_time_s(){
        return product_time_s;
    }
    
    @XmlElement
    public void setProduct_time_s(String product_time_s){
        this.product_time_s=product_time_s;
    }
        
    public String getProd_date_s(){
        return prod_date_s;
    }
    
    @XmlElement
    public void setProd_date_s(String prod_date_s){
        this.prod_date_s=prod_date_s;
    }
        
    public String getProd_shift_code_s(){
        return prod_shift_code_s;
    }
    
    @XmlElement
    public void setProd_shift_code_s(String prod_shift_code_s){
        this.prod_shift_code_s=prod_shift_code_s;
    }
        
    public String getQty_f(){
        return qty_f;
    }
    
    @XmlElement
    public void setQty_f(String qty_f){
        this.qty_f=qty_f;
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
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
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
        
    public String getRequest_remark_s(){
        return request_remark_s;
    }
    
    @XmlElement
    public void setRequest_remark_s(String request_remark_s){
        this.request_remark_s=request_remark_s;
    }
        
    public String getRequest_state_s(){
        return request_state_s;
    }
    
    @XmlElement
    public void setRequest_state_s(String request_state_s){
        this.request_state_s=request_state_s;
    }
        
    public Date getRequest_time_t(){
        return request_time_t;
    }
    
    @XmlElement
    public void setRequest_time_t(Date request_time_t){
        this.request_time_t=request_time_t;
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
        
    public String getSupplier_name_s(){
        return supplier_name_s;
    }
    
    @XmlElement
    public void setSupplier_name_s(String supplier_name_s){
        this.supplier_name_s=supplier_name_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTestmat_flag_s(){
        return testmat_flag_s;
    }
    
    @XmlElement
    public void setTestmat_flag_s(String testmat_flag_s){
        this.testmat_flag_s=testmat_flag_s;
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
        
    public String getWarehouse_remark_s(){
        return warehouse_remark_s;
    }
    
    @XmlElement
    public void setWarehouse_remark_s(String warehouse_remark_s){
        this.warehouse_remark_s=warehouse_remark_s;
    }
        
    public String getWarehouse_type_s(){
        return warehouse_type_s;
    }
    
    @XmlElement
    public void setWarehouse_type_s(String warehouse_type_s){
        this.warehouse_type_s=warehouse_type_s;
    }
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
