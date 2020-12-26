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
 * PLM密炼配方执行历史表
 * @author 栾和源
 * @Date 2020-08-07 13:37:58
 */
@ATDefinition("INT_PLM_MIXRECIPE_EXEC_HIS")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_MIXRECIPE_EXEC_HIS")
public class PlmMixRecipeExecHis extends RockWellBaseEntity{
    
    
    @Comment("父物料PLM版本")
    @Column(nullable=true,length=100)
    private String b_version_s;
    
    @Comment("炭黑回收时间")
    @Column(nullable=true,length=0)
    private Integer cb_recycletime_i;
    
    @Comment("炭黑回收类型：0-不回收、1-回收")
    @Column(nullable=true,length=100)
    private String cb_recycletype_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改人姓名")
    @Column(nullable=true,length=200)
    private String changed_name_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("审核人")
    @Column(nullable=true,length=80)
    private String check_by_s;
    
    @Comment("审核人姓名")
    @Column(nullable=true,length=200)
    private String check_name_s;
    
    @Comment("审核状态：0-未审核、1-已审核")
    @Column(nullable=true,length=80)
    private String check_state_s;
    
    @Comment("审核时间")
    @Column(nullable=true,length=0)
    private Date check_time_t;
    
    @Comment("误差值")
    @Column(nullable=true,length=0)
    private String cutpoly_weight_d;
    
    @Comment("数据来源：0-PLM原数据、1-自动生成")
    @Column(nullable=true,length=80)
    private String data_source_s;
    
    @Comment("数据来源类型：0-上辅机配方、1-配料系统配方")
    @Column(nullable=true,length=80)
    private String data_source_type_s;
    
    @Comment("卸料门温度")
    @Column(nullable=true,length=0)
    private Integer ddoor_temp_i;
    
    @Comment("加硫限制")
    @Column(nullable=true,length=0)
    private Integer dischangetime_i;
    
    @Comment("区分阶段（小试XS、中试ZS、大试DS、投产TC）")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("每车标准时间")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("原材料气味控制")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("原材料等级控制")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("配方替代号")
    @Column(nullable=true,length=100)
    private String edt_code_s;
    
    @Comment("机台代码")
    @Column(nullable=true,length=80)
    private String equip_code_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=100)
    private String id_s;
    
    @Comment("是否掺胶：Yes-掺胶、No-不掺胶")
    @Column(nullable=true,length=100)
    private String ismixed_s;
    
    @Comment("是否使用三区温度：0-不使用、1-使用")
    @Column(nullable=true,length=100)
    private String is_useareatemp_s;
    
    @Comment("MES机台条码")
    @Column(nullable=true,length=80)
    private String mes_equip_code_s;
    
    @Comment("MES机台名称")
    @Column(nullable=true,length=80)
    private String mes_equip_name_s;
    
    @Comment("补偿温度")
    @Column(nullable=true,length=0)
    private Integer makeup_temp_i;
    
    @Comment("配套")
    @Column(nullable=true,length=100)
    private String matchingcode_s;
    
    @Comment("父物料名称")
    @Column(nullable=true,length=200)
    private String mater_name_s;
    
    @Comment("父物料类型： 母胶(LLMasterBatch) 终炼胶M(LLFinalBatchMPart)")
    @Column(nullable=true,length=100)
    private String mater_type_s;
    
    @Comment("父物料SAP品号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F）")
    @Column(nullable=true,length=100)
    private String mater_code_s;
    
    @Comment("父物料SAP品号")
    @Column(nullable=true,length=80)
    private String mater_code_temp_s;
    
    @Comment("最高进胶温度")
    @Column(nullable=true,length=0)
    private Integer max_inploytemp_i;
    
    @Comment("最低进胶温度")
    @Column(nullable=true,length=0)
    private Integer min_inploytemp_i;
    
    @Comment("超温最短时间")
    @Column(nullable=true,length=0)
    private Integer overtemp_mintime_i;
    
    @Comment("紧急排胶温度")
    @Column(nullable=true,length=0)
    private Integer overtemp_temp_i;
    
    @Comment("超时排胶时间")
    @Column(nullable=true,length=0)
    private Integer overtime_time_i;
    
    @Comment("小料包重量")
    @Column(nullable=true,length=80)
    private String pack_weight_s;
    
    @Comment("工厂代码")
    @Column(nullable=true,length=100)
    private String plant_s;
    
    @Comment("配方阶段：ZC-正常、SY-不正常")
    @Column(nullable=true,length=100)
    private String prescriptionstage_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方启停人")
    @Column(nullable=true,length=80)
    private String recipe_by_s;
    
    @Comment("配方名称：父物料名称+工艺类型（是否掺胶+配方阶段+工艺类型）")
    @Column(nullable=true,length=100)
    private String recipe_code_name_s;
    
    @Comment("配方编号-13位：Java系统当前时间 例如 1552888628141")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("配方启停人姓名")
    @Column(nullable=true,length=200)
    private String recipe_name_s;
    
    @Comment("配方状态：323001-待用、323002-正用、323003-停用")
    @Column(nullable=true,length=80)
    private String recipe_status_s;
    
    @Comment("配方启停时间")
    @Column(nullable=true,length=0)
    private Date recipe_time_t;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=5)
    private String record_flag_s;
    
    @Comment("父物料工艺PLM版本")
    @Column(nullable=true,length=100)
    private String r_version_s;
    
    @Comment("转子温度")
    @Column(nullable=true,length=0)
    private Integer roll_temp_i;
    
    @Comment("工艺类型：1-正常、2-返炼、3-洗车、4-返洗、5-正洗")
    @Column(nullable=true,length=100)
    private String routing_type_s;
    
    @Comment("SAP可选文本")
    @Column(nullable=true,length=80)
    private String sap_version_s;
    
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
    
    @Comment("提前量")
    @Column(nullable=true,length=0)
    private String slowdown_weight_d;
    
    @Comment("同步时间")
    @Column(nullable=true,length=0)
    private Date sync_create_time_t;
    
    @Comment("数据同步处理：A-新增、U-修改、D-删除")
    @Column(nullable=true,length=80)
    private String sync_flag_s;
    
    @Comment("1#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_flauto1_s;
    
    @Comment("2#小料上辅机-数据同步处理标记：0-未处理、1-已处理、3-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_flauto2_s;
    
    @Comment("3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、4-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_flauto3_s;
    
    @Comment("1#-3#小料上辅机-数据同步处理标记：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_flauto_s;
    
    @Comment("人工配料-数据同步处理标记：0-未处理、1-已处理、2-处理失败")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_flhand_s;
    
    @Comment("数据同步处理标记：0-未处理、1-已处理、2-处理失败已处理")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_s;
    
    @Comment("1#小料上辅机-数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_flauto1_s;
    
    @Comment("2#小料上辅机-数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_flauto2_s;
    
    @Comment("3#小料上辅机-数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_flauto3_s;
    
    @Comment("人工配料-数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_flhand_s;
    
    @Comment("数据同步处理反馈")
    @Column(nullable=true,length=2000)
    private String sync_hand_msg_s;
    
    @Comment("1#小料上辅机-数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_flauto1_t;
    
    @Comment("2#小料上辅机-数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_flauto2_t;
    
    @Comment("3#小料上辅机-数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_flauto3_t;
    
    @Comment("人工配料-数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_flhand_t;
    
    @Comment("数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_t;
    
    @Comment("数据同步下发工单号")
    @Column(nullable=true,length=80)
    private String sync_wo_no_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("设定重量")
    @Column(nullable=true,length=0)
    private String set_weigh_d;
    
    @Comment("架子数")
    @Column(nullable=true,length=0)
    private Integer shelf_num_i;
    
    @Comment("侧壁温度")
    @Column(nullable=true,length=0)
    private Integer side_temp_i;
    
    public String getB_version_s(){
        return b_version_s;
    }
    
    @XmlElement
    public void setB_version_s(String b_version_s){
        this.b_version_s=b_version_s;
    }
        
    public Integer getCb_recycletime_i(){
        return cb_recycletime_i;
    }
    
    @XmlElement
    public void setCb_recycletime_i(Integer cb_recycletime_i){
        this.cb_recycletime_i=cb_recycletime_i;
    }
        
    public String getCb_recycletype_s(){
        return cb_recycletype_s;
    }
    
    @XmlElement
    public void setCb_recycletype_s(String cb_recycletype_s){
        this.cb_recycletype_s=cb_recycletype_s;
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
        
    public String getCutpoly_weight_d(){
        return cutpoly_weight_d;
    }
    
    @XmlElement
    public void setCutpoly_weight_d(String cutpoly_weight_d){
        this.cutpoly_weight_d=cutpoly_weight_d;
    }
        
    public String getData_source_s(){
        return data_source_s;
    }
    
    @XmlElement
    public void setData_source_s(String data_source_s){
        this.data_source_s=data_source_s;
    }
        
    public String getData_source_type_s(){
        return data_source_type_s;
    }
    
    @XmlElement
    public void setData_source_type_s(String data_source_type_s){
        this.data_source_type_s=data_source_type_s;
    }
        
    public Integer getDdoor_temp_i(){
        return ddoor_temp_i;
    }
    
    @XmlElement
    public void setDdoor_temp_i(Integer ddoor_temp_i){
        this.ddoor_temp_i=ddoor_temp_i;
    }
        
    public Integer getDischangetime_i(){
        return dischangetime_i;
    }
    
    @XmlElement
    public void setDischangetime_i(Integer dischangetime_i){
        this.dischangetime_i=dischangetime_i;
    }
        
    public String getDummy1_s(){
        return dummy1_s;
    }
    
    @XmlElement
    public void setDummy1_s(String dummy1_s){
        this.dummy1_s=dummy1_s;
    }
        
    public String getDummy2_s(){
        return dummy2_s;
    }
    
    @XmlElement
    public void setDummy2_s(String dummy2_s){
        this.dummy2_s=dummy2_s;
    }
        
    public String getDummy3_s(){
        return dummy3_s;
    }
    
    @XmlElement
    public void setDummy3_s(String dummy3_s){
        this.dummy3_s=dummy3_s;
    }
        
    public String getDummy4_s(){
        return dummy4_s;
    }
    
    @XmlElement
    public void setDummy4_s(String dummy4_s){
        this.dummy4_s=dummy4_s;
    }
        
    public String getDummy5_s(){
        return dummy5_s;
    }
    
    @XmlElement
    public void setDummy5_s(String dummy5_s){
        this.dummy5_s=dummy5_s;
    }
        
    public String getEdt_code_s(){
        return edt_code_s;
    }
    
    @XmlElement
    public void setEdt_code_s(String edt_code_s){
        this.edt_code_s=edt_code_s;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getGuid_s(){
        return guid_s;
    }
    
    @XmlElement
    public void setGuid_s(String guid_s){
        this.guid_s=guid_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getIsmixed_s(){
        return ismixed_s;
    }
    
    @XmlElement
    public void setIsmixed_s(String ismixed_s){
        this.ismixed_s=ismixed_s;
    }
        
    public String getIs_useareatemp_s(){
        return is_useareatemp_s;
    }
    
    @XmlElement
    public void setIs_useareatemp_s(String is_useareatemp_s){
        this.is_useareatemp_s=is_useareatemp_s;
    }
        
    public String getMes_equip_code_s(){
        return mes_equip_code_s;
    }
    
    @XmlElement
    public void setMes_equip_code_s(String mes_equip_code_s){
        this.mes_equip_code_s=mes_equip_code_s;
    }
        
    public String getMes_equip_name_s(){
        return mes_equip_name_s;
    }
    
    @XmlElement
    public void setMes_equip_name_s(String mes_equip_name_s){
        this.mes_equip_name_s=mes_equip_name_s;
    }
        
    public Integer getMakeup_temp_i(){
        return makeup_temp_i;
    }
    
    @XmlElement
    public void setMakeup_temp_i(Integer makeup_temp_i){
        this.makeup_temp_i=makeup_temp_i;
    }
        
    public String getMatchingcode_s(){
        return matchingcode_s;
    }
    
    @XmlElement
    public void setMatchingcode_s(String matchingcode_s){
        this.matchingcode_s=matchingcode_s;
    }
        
    public String getMater_name_s(){
        return mater_name_s;
    }
    
    @XmlElement
    public void setMater_name_s(String mater_name_s){
        this.mater_name_s=mater_name_s;
    }
        
    public String getMater_type_s(){
        return mater_type_s;
    }
    
    @XmlElement
    public void setMater_type_s(String mater_type_s){
        this.mater_type_s=mater_type_s;
    }
        
    public String getMater_code_s(){
        return mater_code_s;
    }
    
    @XmlElement
    public void setMater_code_s(String mater_code_s){
        this.mater_code_s=mater_code_s;
    }
        
    public String getMater_code_temp_s(){
        return mater_code_temp_s;
    }
    
    @XmlElement
    public void setMater_code_temp_s(String mater_code_temp_s){
        this.mater_code_temp_s=mater_code_temp_s;
    }
        
    public Integer getMax_inploytemp_i(){
        return max_inploytemp_i;
    }
    
    @XmlElement
    public void setMax_inploytemp_i(Integer max_inploytemp_i){
        this.max_inploytemp_i=max_inploytemp_i;
    }
        
    public Integer getMin_inploytemp_i(){
        return min_inploytemp_i;
    }
    
    @XmlElement
    public void setMin_inploytemp_i(Integer min_inploytemp_i){
        this.min_inploytemp_i=min_inploytemp_i;
    }
        
    public Integer getOvertemp_mintime_i(){
        return overtemp_mintime_i;
    }
    
    @XmlElement
    public void setOvertemp_mintime_i(Integer overtemp_mintime_i){
        this.overtemp_mintime_i=overtemp_mintime_i;
    }
        
    public Integer getOvertemp_temp_i(){
        return overtemp_temp_i;
    }
    
    @XmlElement
    public void setOvertemp_temp_i(Integer overtemp_temp_i){
        this.overtemp_temp_i=overtemp_temp_i;
    }
        
    public Integer getOvertime_time_i(){
        return overtime_time_i;
    }
    
    @XmlElement
    public void setOvertime_time_i(Integer overtime_time_i){
        this.overtime_time_i=overtime_time_i;
    }
        
    public String getPack_weight_s(){
        return pack_weight_s;
    }
    
    @XmlElement
    public void setPack_weight_s(String pack_weight_s){
        this.pack_weight_s=pack_weight_s;
    }
        
    public String getPlant_s(){
        return plant_s;
    }
    
    @XmlElement
    public void setPlant_s(String plant_s){
        this.plant_s=plant_s;
    }
        
    public String getPrescriptionstage_s(){
        return prescriptionstage_s;
    }
    
    @XmlElement
    public void setPrescriptionstage_s(String prescriptionstage_s){
        this.prescriptionstage_s=prescriptionstage_s;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public String getRecipe_by_s(){
        return recipe_by_s;
    }
    
    @XmlElement
    public void setRecipe_by_s(String recipe_by_s){
        this.recipe_by_s=recipe_by_s;
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
        
    public String getRecipe_name_s(){
        return recipe_name_s;
    }
    
    @XmlElement
    public void setRecipe_name_s(String recipe_name_s){
        this.recipe_name_s=recipe_name_s;
    }
        
    public String getRecipe_status_s(){
        return recipe_status_s;
    }
    
    @XmlElement
    public void setRecipe_status_s(String recipe_status_s){
        this.recipe_status_s=recipe_status_s;
    }
        
    public Date getRecipe_time_t(){
        return recipe_time_t;
    }
    
    @XmlElement
    public void setRecipe_time_t(Date recipe_time_t){
        this.recipe_time_t=recipe_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getR_version_s(){
        return r_version_s;
    }
    
    @XmlElement
    public void setR_version_s(String r_version_s){
        this.r_version_s=r_version_s;
    }
        
    public Integer getRoll_temp_i(){
        return roll_temp_i;
    }
    
    @XmlElement
    public void setRoll_temp_i(Integer roll_temp_i){
        this.roll_temp_i=roll_temp_i;
    }
        
    public String getRouting_type_s(){
        return routing_type_s;
    }
    
    @XmlElement
    public void setRouting_type_s(String routing_type_s){
        this.routing_type_s=routing_type_s;
    }
        
    public String getSap_version_s(){
        return sap_version_s;
    }
    
    @XmlElement
    public void setSap_version_s(String sap_version_s){
        this.sap_version_s=sap_version_s;
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
        
    public String getSlowdown_weight_d(){
        return slowdown_weight_d;
    }
    
    @XmlElement
    public void setSlowdown_weight_d(String slowdown_weight_d){
        this.slowdown_weight_d=slowdown_weight_d;
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
        
    public String getSync_hand_flag_flauto1_s(){
        return sync_hand_flag_flauto1_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_flauto1_s(String sync_hand_flag_flauto1_s){
        this.sync_hand_flag_flauto1_s=sync_hand_flag_flauto1_s;
    }
        
    public String getSync_hand_flag_flauto2_s(){
        return sync_hand_flag_flauto2_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_flauto2_s(String sync_hand_flag_flauto2_s){
        this.sync_hand_flag_flauto2_s=sync_hand_flag_flauto2_s;
    }
        
    public String getSync_hand_flag_flauto3_s(){
        return sync_hand_flag_flauto3_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_flauto3_s(String sync_hand_flag_flauto3_s){
        this.sync_hand_flag_flauto3_s=sync_hand_flag_flauto3_s;
    }
        
    public String getSync_hand_flag_flauto_s(){
        return sync_hand_flag_flauto_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_flauto_s(String sync_hand_flag_flauto_s){
        this.sync_hand_flag_flauto_s=sync_hand_flag_flauto_s;
    }
        
    public String getSync_hand_flag_flhand_s(){
        return sync_hand_flag_flhand_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_flhand_s(String sync_hand_flag_flhand_s){
        this.sync_hand_flag_flhand_s=sync_hand_flag_flhand_s;
    }
        
    public String getSync_hand_flag_s(){
        return sync_hand_flag_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_s(String sync_hand_flag_s){
        this.sync_hand_flag_s=sync_hand_flag_s;
    }
        
    public String getSync_hand_msg_flauto1_s(){
        return sync_hand_msg_flauto1_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_flauto1_s(String sync_hand_msg_flauto1_s){
        this.sync_hand_msg_flauto1_s=sync_hand_msg_flauto1_s;
    }
        
    public String getSync_hand_msg_flauto2_s(){
        return sync_hand_msg_flauto2_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_flauto2_s(String sync_hand_msg_flauto2_s){
        this.sync_hand_msg_flauto2_s=sync_hand_msg_flauto2_s;
    }
        
    public String getSync_hand_msg_flauto3_s(){
        return sync_hand_msg_flauto3_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_flauto3_s(String sync_hand_msg_flauto3_s){
        this.sync_hand_msg_flauto3_s=sync_hand_msg_flauto3_s;
    }
        
    public String getSync_hand_msg_flhand_s(){
        return sync_hand_msg_flhand_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_flhand_s(String sync_hand_msg_flhand_s){
        this.sync_hand_msg_flhand_s=sync_hand_msg_flhand_s;
    }
        
    public String getSync_hand_msg_s(){
        return sync_hand_msg_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_s(String sync_hand_msg_s){
        this.sync_hand_msg_s=sync_hand_msg_s;
    }
        
    public Date getSync_hand_time_flauto1_t(){
        return sync_hand_time_flauto1_t;
    }
    
    @XmlElement
    public void setSync_hand_time_flauto1_t(Date sync_hand_time_flauto1_t){
        this.sync_hand_time_flauto1_t=sync_hand_time_flauto1_t;
    }
        
    public Date getSync_hand_time_flauto2_t(){
        return sync_hand_time_flauto2_t;
    }
    
    @XmlElement
    public void setSync_hand_time_flauto2_t(Date sync_hand_time_flauto2_t){
        this.sync_hand_time_flauto2_t=sync_hand_time_flauto2_t;
    }
        
    public Date getSync_hand_time_flauto3_t(){
        return sync_hand_time_flauto3_t;
    }
    
    @XmlElement
    public void setSync_hand_time_flauto3_t(Date sync_hand_time_flauto3_t){
        this.sync_hand_time_flauto3_t=sync_hand_time_flauto3_t;
    }
        
    public Date getSync_hand_time_flhand_t(){
        return sync_hand_time_flhand_t;
    }
    
    @XmlElement
    public void setSync_hand_time_flhand_t(Date sync_hand_time_flhand_t){
        this.sync_hand_time_flhand_t=sync_hand_time_flhand_t;
    }
        
    public Date getSync_hand_time_t(){
        return sync_hand_time_t;
    }
    
    @XmlElement
    public void setSync_hand_time_t(Date sync_hand_time_t){
        this.sync_hand_time_t=sync_hand_time_t;
    }
        
    public String getSync_wo_no_s(){
        return sync_wo_no_s;
    }
    
    @XmlElement
    public void setSync_wo_no_s(String sync_wo_no_s){
        this.sync_wo_no_s=sync_wo_no_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getSet_weigh_d(){
        return set_weigh_d;
    }
    
    @XmlElement
    public void setSet_weigh_d(String set_weigh_d){
        this.set_weigh_d=set_weigh_d;
    }
        
    public Integer getShelf_num_i(){
        return shelf_num_i;
    }
    
    @XmlElement
    public void setShelf_num_i(Integer shelf_num_i){
        this.shelf_num_i=shelf_num_i;
    }
        
    public Integer getSide_temp_i(){
        return side_temp_i;
    }
    
    @XmlElement
    public void setSide_temp_i(Integer side_temp_i){
        this.side_temp_i=side_temp_i;
    }
        
    
    
    
}
