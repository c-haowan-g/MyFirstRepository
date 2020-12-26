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
 * 密炼小料库存实时表
 * @author 陈国强
 * @Date 2020-08-29 08:25:16
 */
@ATDefinition("MX_WH_ITEM_INV")
@Entity
@XmlRootElement
@Table(name="AT_MX_WH_ITEM_INV")
public class MixSmallMaterial extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("基本单位")
    @Column(nullable=true,length=6)
    private String baseunit_s;
    
    @Comment("开始车次号")
    @Column(nullable=true,length=80)
    private String begin_train_num_s;
    
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
    
    @Comment("检测人")
    @Column(nullable=true,length=200)
    private String check_by_s;
    
    @Comment("最终检测结果")
    @Column(nullable=true,length=80)
    private String check_result_s;
    
    @Comment("检测日期")
    @Column(nullable=true,length=0)
    private Date check_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=200)
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
    
    @Comment("结束车次号")
    @Column(nullable=true,length=80)
    private String end_train_num_s;
    
    @Comment("机台编码")
    @Column(nullable=true,length=25)
    private String equip_code_s;
    
    @Comment("物料过期日期")
    @Column(nullable=true,length=0)
    private Date expiry_date_t;
    
    @Comment("超期处理次数")
    @Column(nullable=true,length=0)
    private Integer expiry_hand_count_i;
    
    @Comment("超期处理备注")
    @Column(nullable=true,length=100)
    private String expiry_hand_remark_s;
    
    @Comment("等级编码-备用")
    @Column(nullable=true,length=50)
    private String grade_code_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("入库日期")
    @Column(nullable=true,length=0)
    private Date in_time_t;
    
    @Comment("打印标识卡：0-未打印、1-已打印、2-补充打印")
    @Column(nullable=true,length=25)
    private String is_print_s;
    
    @Comment("批次号")
    @Column(nullable=true,length=80)
    private String lot_no_s;
    
    @Comment("配套")
    @Column(nullable=true,length=80)
    private String matchingcode_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=40)
    private String materialgroup_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=25)
    private String material_code_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String material_name_s;
    
    @Comment("是否超期:0-正常状态 1-超期")
    @Column(nullable=true,length=5)
    private String outofdateflag_s;
    
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
    @Column(nullable=true,length=0)
    private Date product_time_t;
    
    @Comment("区分阶段（小试XS、中试ZS、大试DS、投产TC）")
    @Column(nullable=true,length=80)
    private String prophase_s;
    
    @Comment("库存剩余数量")
    @Column(nullable=true,length=0)
    private String qty_left_f;
    
    @Comment("放行原因：067001-特殊放行、067002-超期处理")
    @Column(nullable=true,length=50)
    private String reas_code_s;
    
    @Comment("密炼配方BOM版本")
    @Column(nullable=true,length=80)
    private String recipe_bom_version_s;
    
    @Comment("密炼生成配方名称")
    @Column(nullable=true,length=80)
    private String recipe_code_name_s;
    
    @Comment("密炼生成配方编号，外键，INT_PLM_MIXRECIPE_EDIT.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("反馈备注")
    @Column(nullable=true,length=2)
    private String return_remark_s;
    
    @Comment("反馈状态：0-无请求、1-未反馈、2-已反馈")
    @Column(nullable=true,length=80)
    private String return_state_s;
    
    @Comment("反馈时间")
    @Column(nullable=true,length=0)
    private Date return_time_t;
    
    @Comment("自检标识：默认0合格，1不合格")
    @Column(nullable=true,length=5)
    private String self_flag_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=80)
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
    
    @Comment("备用字段5：密炼接口预留：配方类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗")
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
    
    @Comment("同步时间")
    @Column(nullable=true,length=0)
    private Date sync_create_time_t;
    
    @Comment("工厂代码（1.全钢，2.半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("是否试验料：0-否，1-是")
    @Column(nullable=true,length=50)
    private String testmat_flag_s;
    
    @Comment("托盘编号")
    @Column(nullable=true,length=80)
    private String tray_code_s;
    
    @Comment("立库编号")
    @Column(nullable=true,length=25)
    private String warehouseid_s;
    
    @Comment("出库目标位置")
    @Column(nullable=true,length=25)
    private String warehouse_location_s;
    
    @Comment("胶料立库出库方式：073001-指定批次、073002-指定托盘、073003-指定物料编码、073004-指定配套代码、073005-物料编码、073006-指定配方名称、073007-指定载具编号")
    @Column(nullable=true,length=25)
    private String warehouse_mode_s;
    
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
        
    public String getBegin_train_num_s(){
        return begin_train_num_s;
    }
    
    @XmlElement
    public void setBegin_train_num_s(String begin_train_num_s){
        this.begin_train_num_s=begin_train_num_s;
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
        
    public String getEnd_train_num_s(){
        return end_train_num_s;
    }
    
    @XmlElement
    public void setEnd_train_num_s(String end_train_num_s){
        this.end_train_num_s=end_train_num_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
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
        
    public String getIs_print_s(){
        return is_print_s;
    }
    
    @XmlElement
    public void setIs_print_s(String is_print_s){
        this.is_print_s=is_print_s;
    }
        
    public String getLot_no_s(){
        return lot_no_s;
    }
    
    @XmlElement
    public void setLot_no_s(String lot_no_s){
        this.lot_no_s=lot_no_s;
    }
        
    public String getMatchingcode_s(){
        return matchingcode_s;
    }
    
    @XmlElement
    public void setMatchingcode_s(String matchingcode_s){
        this.matchingcode_s=matchingcode_s;
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
        
    public String getOutofdateflag_s(){
        return outofdateflag_s;
    }
    
    @XmlElement
    public void setOutofdateflag_s(String outofdateflag_s){
        this.outofdateflag_s=outofdateflag_s;
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
        
    public Date getProduct_time_t(){
        return product_time_t;
    }
    
    @XmlElement
    public void setProduct_time_t(Date product_time_t){
        this.product_time_t=product_time_t;
    }
        
    public String getProphase_s(){
        return prophase_s;
    }
    
    @XmlElement
    public void setProphase_s(String prophase_s){
        this.prophase_s=prophase_s;
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
        
    public String getRecipe_bom_version_s(){
        return recipe_bom_version_s;
    }
    
    @XmlElement
    public void setRecipe_bom_version_s(String recipe_bom_version_s){
        this.recipe_bom_version_s=recipe_bom_version_s;
    }
        
    public String getRecipe_code_name_s(){
        return recipe_code_name_s;
    }
    
    @XmlElement
    public void setRecipe_code_name_s(String recipe_code_name_s){
        this.recipe_code_name_s=recipe_code_name_s;
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
        
    public String getReturn_remark_s(){
        return return_remark_s;
    }
    
    @XmlElement
    public void setReturn_remark_s(String return_remark_s){
        this.return_remark_s=return_remark_s;
    }
        
    public String getReturn_state_s(){
        return return_state_s;
    }
    
    @XmlElement
    public void setReturn_state_s(String return_state_s){
        this.return_state_s=return_state_s;
    }
        
    public Date getReturn_time_t(){
        return return_time_t;
    }
    
    @XmlElement
    public void setReturn_time_t(Date return_time_t){
        this.return_time_t=return_time_t;
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
        
    public String getSupplier_name_s(){
        return supplier_name_s;
    }
    
    @XmlElement
    public void setSupplier_name_s(String supplier_name_s){
        this.supplier_name_s=supplier_name_s;
    }
        
    public Date getSync_create_time_t(){
        return sync_create_time_t;
    }
    
    @XmlElement
    public void setSync_create_time_t(Date sync_create_time_t){
        this.sync_create_time_t=sync_create_time_t;
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
        
    public String getWo_no_s(){
        return wo_no_s;
    }
    
    @XmlElement
    public void setWo_no_s(String wo_no_s){
        this.wo_no_s=wo_no_s;
    }
        
    
    
    
}
