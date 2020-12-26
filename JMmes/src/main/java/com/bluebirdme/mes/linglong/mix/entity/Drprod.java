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
 * 密炼胶料产出实绩表
 * @author 栾和源
 * @Date 2020-08-04 09:34:26
 */
@ATDefinition("MX_MM_POLY_PROD")
@Entity
@XmlRootElement
@Table(name="AT_MX_MM_POLY_PROD")
public class Drprod extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 荆门 8023")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("基本单位")
    @Column(nullable=true,length=6)
    private String baseunit_s;
    
    @Comment("开始车次")
    @Column(nullable=true,length=0)
    private Integer begin_train_num_i;
    
    @Comment("载具条码：M + 8 位流水号")
    @Column(nullable=true,length=40)
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
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("误差值")
    @Column(nullable=true,length=0)
    private String cutpoly_weight_d;
    
    @Comment("切胶方式：1-手动切胶、2-自动切胶")
    @Column(nullable=true,length=25)
    private String cut_type_s;
    
    @Comment("结束车次")
    @Column(nullable=true,length=0)
    private Integer end_train_num_i;
    
    @Comment("机台编码：设备类型（2 位）+流水号（3 位） 例如 01001")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=40)
    private String equip_name_s;
    
    @Comment("物料过期日期")
    @Column(nullable=true,length=0)
    private Date expiry_date_t;
    
    @Comment("班组")
    @Column(nullable=true,length=25)
    private String group_code_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("是否绑定产出车次：0-否、1-是")
    @Column(nullable=true,length=80)
    private String is_bindtrain_s;
    
    @Comment("检验标识：0-否、1-是")
    @Column(nullable=true,length=25)
    private String is_check_s;
    
    @Comment("自检标识：0-合格、1-不合格")
    @Column(nullable=true,length=25)
    private String is_selfcheck_s;
    
    @Comment("批次信息，长度19位： 母胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 M919070110100100015 终炼胶批次号：固定字符+工厂+生产日期+班次+机台+计划号+开始车次+车数 例如 F919070110100100015")
    @Column(nullable=true,length=50)
    private String lot_no_s;
    
    @Comment("主机手")
    @Column(nullable=true,length=80)
    private String master_by_s;
    
    @Comment("主机手姓名")
    @Column(nullable=true,length=80)
    private String master_name_s;
    
    @Comment("配套")
    @Column(nullable=true,length=80)
    private String matchingcode_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=100)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("金属探测数")
    @Column(nullable=true,length=80)
    private String metal_num_s;
    
    @Comment("打印方式： 069001-未打印 069002-已打印（手动） 069003-已打印（自动） 069004-补充打印")
    @Column(nullable=true,length=25)
    private String print_type_s;
    
    @Comment("产出时间")
    @Column(nullable=true,length=0)
    private Date product_time_t;
    
    @Comment("生产日期")
    @Column(nullable=true,length=80)
    private String prod_date_s;
    
    @Comment("产出工位（胶架移除工位）：值域 0、1、2，0-摆片，1、2-卷曲位")
    @Column(nullable=true,length=80)
    private String prod_location_s;
    
    @Comment("产出方式： 068001-手动产出（正常计划） 068002-自动产出（正常计划） 068003-手动产出（离线计划） 068004-自动产出（离线计划")
    @Column(nullable=true,length=25)
    private String prod_type_s;
    
    @Comment("质量备注")
    @Column(nullable=true,length=600)
    private String qc_mark_s;
    
    @Comment("实际重量")
    @Column(nullable=true,length=25)
    private String real_weight_s;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
    @Comment("密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("RFID读取错误类型： 074001-离线载具条码未读到 074002-在线载具条码未读到 074003-载具条码MES不存在 074004-载具条码MES类型错误 074005-载具条码MES状态错误 074006-其它")
    @Column(nullable=true,length=80)
    private String rfid_etype_s;
    
    @Comment("RFID读取是否成功：0-失败，1-成功")
    @Column(nullable=true,length=80)
    private String rfid_isok_s;
    
    @Comment("RFID读取备注")
    @Column(nullable=true,length=800)
    private String rfid_remark_s;
    
    @Comment("快检开始车次")
    @Column(nullable=true,length=80)
    private String set_begin_train_num_s;
    
    @Comment("快检结束车次")
    @Column(nullable=true,length=80)
    private String set_end_train_num_s;
    
    @Comment("设定重量")
    @Column(nullable=true,length=25)
    private String set_weight_s;
    
    @Comment("架子数")
    @Column(nullable=true,length=25)
    private String shelves_num_s;
    
    @Comment("班次")
    @Column(nullable=true,length=25)
    private String shift_code_s;
    
    @Comment("提前量")
    @Column(nullable=true,length=0)
    private String slowdown_weight_d;
    
    @Comment("备用字段10：下发时间")
    @Column(nullable=true,length=2000)
    private String spare10_s;
    
    @Comment("备用字段1：物料最小存放时间或允许出库时间")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2：配方名称")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3：最小存放时间(h)")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4：最长存放时间(h)")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5：下发标识：0-未下发、1-已下发")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("备用字段6：生胶（车次消耗原材料胶料），名称+批次生产日期")
    @Column(nullable=true,length=2000)
    private String spare6_s;
    
    @Comment("备用字段7：塑解剂（车次消耗原材料胶料），名称+重量")
    @Column(nullable=true,length=2000)
    private String spare7_s;
    
    @Comment("备用字段8：下发人")
    @Column(nullable=true,length=2000)
    private String spare8_s;
    
    @Comment("备用字段9：下发姓名")
    @Column(nullable=true,length=2000)
    private String spare9_s;
    
    @Comment("接片人")
    @Column(nullable=true,length=80)
    private String splice_by_s;
    
    @Comment("接片人姓名")
    @Column(nullable=true,length=80)
    private String splice_name_s;
    
    @Comment("状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库）")
    @Column(nullable=true,length=50)
    private String state_code_s;
    
    @Comment("库位编号")
    @Column(nullable=true,length=25)
    private String store_code_s;
    
    @Comment("库区编码：062001-胶料库、062002-线边库、062003-历史库")
    @Column(nullable=true,length=25)
    private String store_type_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("托盘编号")
    @Column(nullable=true,length=25)
    private String tray_code_s;
    
    @Comment("立库编号（1、2、3、4、5...）")
    @Column(nullable=true,length=25)
    private String warehouseid_s;
    
    @Comment("密炼工单跟踪表，工单号，外键，MX_PP_WO_EDIT.WO_NO")
    @Column(nullable=true,length=50)
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
        
    public Integer getBegin_train_num_i(){
        return begin_train_num_i;
    }
    
    @XmlElement
    public void setBegin_train_num_i(Integer begin_train_num_i){
        this.begin_train_num_i=begin_train_num_i;
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
        
    public String getCutpoly_weight_d(){
        return cutpoly_weight_d;
    }
    
    @XmlElement
    public void setCutpoly_weight_d(String cutpoly_weight_d){
        this.cutpoly_weight_d=cutpoly_weight_d;
    }
        
    public String getCut_type_s(){
        return cut_type_s;
    }
    
    @XmlElement
    public void setCut_type_s(String cut_type_s){
        this.cut_type_s=cut_type_s;
    }
        
    public Integer getEnd_train_num_i(){
        return end_train_num_i;
    }
    
    @XmlElement
    public void setEnd_train_num_i(Integer end_train_num_i){
        this.end_train_num_i=end_train_num_i;
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
        
    public Date getExpiry_date_t(){
        return expiry_date_t;
    }
    
    @XmlElement
    public void setExpiry_date_t(Date expiry_date_t){
        this.expiry_date_t=expiry_date_t;
    }
        
    public String getGroup_code_s(){
        return group_code_s;
    }
    
    @XmlElement
    public void setGroup_code_s(String group_code_s){
        this.group_code_s=group_code_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIs_bindtrain_s(){
        return is_bindtrain_s;
    }
    
    @XmlElement
    public void setIs_bindtrain_s(String is_bindtrain_s){
        this.is_bindtrain_s=is_bindtrain_s;
    }
        
    public String getIs_check_s(){
        return is_check_s;
    }
    
    @XmlElement
    public void setIs_check_s(String is_check_s){
        this.is_check_s=is_check_s;
    }
        
    public String getIs_selfcheck_s(){
        return is_selfcheck_s;
    }
    
    @XmlElement
    public void setIs_selfcheck_s(String is_selfcheck_s){
        this.is_selfcheck_s=is_selfcheck_s;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
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
        
    public String getMetal_num_s(){
        return metal_num_s;
    }
    
    @XmlElement
    public void setMetal_num_s(String metal_num_s){
        this.metal_num_s=metal_num_s;
    }
        
    public String getPrint_type_s(){
        return print_type_s;
    }
    
    @XmlElement
    public void setPrint_type_s(String print_type_s){
        this.print_type_s=print_type_s;
    }
        
    public Date getProduct_time_t(){
        return product_time_t;
    }
    
    @XmlElement
    public void setProduct_time_t(Date product_time_t){
        this.product_time_t=product_time_t;
    }
        
    public String getProd_date_s(){
        return prod_date_s;
    }
    
    @XmlElement
    public void setProd_date_s(String prod_date_s){
        this.prod_date_s=prod_date_s;
    }
        
    public String getProd_location_s(){
        return prod_location_s;
    }
    
    @XmlElement
    public void setProd_location_s(String prod_location_s){
        this.prod_location_s=prod_location_s;
    }
        
    public String getProd_type_s(){
        return prod_type_s;
    }
    
    @XmlElement
    public void setProd_type_s(String prod_type_s){
        this.prod_type_s=prod_type_s;
    }
        
    public String getQc_mark_s(){
        return qc_mark_s;
    }
    
    @XmlElement
    public void setQc_mark_s(String qc_mark_s){
        this.qc_mark_s=qc_mark_s;
    }
        
    public String getReal_weight_s(){
        return real_weight_s;
    }
    
    @XmlElement
    public void setReal_weight_s(String real_weight_s){
        this.real_weight_s=real_weight_s;
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
        
    public String getRfid_etype_s(){
        return rfid_etype_s;
    }
    
    @XmlElement
    public void setRfid_etype_s(String rfid_etype_s){
        this.rfid_etype_s=rfid_etype_s;
    }
        
    public String getRfid_isok_s(){
        return rfid_isok_s;
    }
    
    @XmlElement
    public void setRfid_isok_s(String rfid_isok_s){
        this.rfid_isok_s=rfid_isok_s;
    }
        
    public String getRfid_remark_s(){
        return rfid_remark_s;
    }
    
    @XmlElement
    public void setRfid_remark_s(String rfid_remark_s){
        this.rfid_remark_s=rfid_remark_s;
    }
        
    public String getSet_begin_train_num_s(){
        return set_begin_train_num_s;
    }
    
    @XmlElement
    public void setSet_begin_train_num_s(String set_begin_train_num_s){
        this.set_begin_train_num_s=set_begin_train_num_s;
    }
        
    public String getSet_end_train_num_s(){
        return set_end_train_num_s;
    }
    
    @XmlElement
    public void setSet_end_train_num_s(String set_end_train_num_s){
        this.set_end_train_num_s=set_end_train_num_s;
    }
        
    public String getSet_weight_s(){
        return set_weight_s;
    }
    
    @XmlElement
    public void setSet_weight_s(String set_weight_s){
        this.set_weight_s=set_weight_s;
    }
        
    public String getShelves_num_s(){
        return shelves_num_s;
    }
    
    @XmlElement
    public void setShelves_num_s(String shelves_num_s){
        this.shelves_num_s=shelves_num_s;
    }
        
    public String getShift_code_s(){
        return shift_code_s;
    }
    
    @XmlElement
    public void setShift_code_s(String shift_code_s){
        this.shift_code_s=shift_code_s;
    }
        
    public String getSlowdown_weight_d(){
        return slowdown_weight_d;
    }
    
    @XmlElement
    public void setSlowdown_weight_d(String slowdown_weight_d){
        this.slowdown_weight_d=slowdown_weight_d;
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
        
    public String getSplice_by_s(){
        return splice_by_s;
    }
    
    @XmlElement
    public void setSplice_by_s(String splice_by_s){
        this.splice_by_s=splice_by_s;
    }
        
    public String getSplice_name_s(){
        return splice_name_s;
    }
    
    @XmlElement
    public void setSplice_name_s(String splice_name_s){
        this.splice_name_s=splice_name_s;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
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
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
