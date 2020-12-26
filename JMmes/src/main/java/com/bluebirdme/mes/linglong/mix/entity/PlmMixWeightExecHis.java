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
 * PLM密炼称量执行历史表
 * @author 栾和源
 * @Date 2020-08-13 13:44:22
 */
@ATDefinition("INT_PLM_MIXWEIGHT_EXEC_HIS")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_MIXWEIGHT_EXEC_HIS")
public class PlmMixWeightExecHis extends RockWellBaseEntity{
    
    
    @Comment("子物料版本")
    @Column(nullable=true,length=80)
    private String bc_version_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("是否掺胶")
    @Column(nullable=true,length=100)
    private String childismixed_s;
    
    @Comment("配方阶段")
    @Column(nullable=true,length=100)
    private String childprescriptionstage_s;
    
    @Comment("子物料名称")
    @Column(nullable=true,length=200)
    private String child_matername_s;
    
    @Comment("子物料SAP号：存储9位品号（返回胶、实验胶11位，例如 300000308_-F）")
    @Column(nullable=true,length=100)
    private String child_matercode_s;
    
    @Comment("子物料SAP号")
    @Column(nullable=true,length=80)
    private String child_matercode_temp_s;
    
    @Comment("数据来源：0-PLM原数据、1-自动生成")
    @Column(nullable=true,length=80)
    private String data_source_s;
    
    @Comment("数据来源类型：0-上辅机配方、1-配料系统配方")
    @Column(nullable=true,length=80)
    private String data_source_type_s;
    
    @Comment("塑解剂称上允许误差")
    @Column(nullable=true,length=80)
    private String degrad_allow_s;
    
    @Comment("塑解剂称上设定重量（精度增加一位）")
    @Column(nullable=true,length=80)
    private String degrad_weight_s;
    
    @Comment("小料袋重")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("每车标准时间")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用5：等同物料备注（原物料：{0}-{1}，等同物料：{2}-{3}）")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("允许误差： 0.3-C.B.-炭黑 0.02-F.L.-粉料 0.1-Oil-油料 2-Poly-返回胶 0.3-Poly-胶料")
    @Column(nullable=true,length=0)
    private String error_allow_d;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("主键，同时在从表中关联主键")
    @Column(nullable=true,length=100)
    private String id_s;
    
    @Comment("投入母胶工艺类型")
    @Column(nullable=true,length=100)
    private String into_routing_s;
    
    @Comment("投入母胶类型")
    @Column(nullable=true,length=100)
    private String into_type_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方编号-13位：外键，INT_PLM_MIXRECIPE.RECIPE_CODE")
    @Column(nullable=true,length=80)
    private String recipe_code_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=100)
    private String record_flag_s;
    
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
    
    @Comment("数据同步处理标记：0-未处理、1-已处理、2-处理失败")
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
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("称量")
    @Column(nullable=true,length=0)
    private String set_weight_d;
    
    @Comment("子物料供应商代码")
    @Column(nullable=true,length=100)
    private String supply_code_s;
    
    @Comment("子物料的粘度标准")
    @Column(nullable=true,length=100)
    private String viscositystandard_s;
    
    @Comment("小料分类属性")
    @Column(nullable=true,length=100)
    private String weight_prop_s;
    
    @Comment("称量序号")
    @Column(nullable=true,length=0)
    private Integer weight_id_i;
    
    @Comment("称量类型： 0-炭黑称 1-油料称 2-胶料称 3-小料称 5-油料称2 6-小料用胶料称 7-预分散称 8-一次法返回胶称 9-密炼机粉料称")
    @Column(nullable=true,length=0)
    private Integer weight_type_i;
    
    public String getBc_version_s(){
        return bc_version_s;
    }
    
    @XmlElement
    public void setBc_version_s(String bc_version_s){
        this.bc_version_s=bc_version_s;
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
        
    public String getChildismixed_s(){
        return childismixed_s;
    }
    
    @XmlElement
    public void setChildismixed_s(String childismixed_s){
        this.childismixed_s=childismixed_s;
    }
        
    public String getChildprescriptionstage_s(){
        return childprescriptionstage_s;
    }
    
    @XmlElement
    public void setChildprescriptionstage_s(String childprescriptionstage_s){
        this.childprescriptionstage_s=childprescriptionstage_s;
    }
        
    public String getChild_matername_s(){
        return child_matername_s;
    }
    
    @XmlElement
    public void setChild_matername_s(String child_matername_s){
        this.child_matername_s=child_matername_s;
    }
        
    public String getChild_matercode_s(){
        return child_matercode_s;
    }
    
    @XmlElement
    public void setChild_matercode_s(String child_matercode_s){
        this.child_matercode_s=child_matercode_s;
    }
        
    public String getChild_matercode_temp_s(){
        return child_matercode_temp_s;
    }
    
    @XmlElement
    public void setChild_matercode_temp_s(String child_matercode_temp_s){
        this.child_matercode_temp_s=child_matercode_temp_s;
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
        
    public String getDegrad_allow_s(){
        return degrad_allow_s;
    }
    
    @XmlElement
    public void setDegrad_allow_s(String degrad_allow_s){
        this.degrad_allow_s=degrad_allow_s;
    }
        
    public String getDegrad_weight_s(){
        return degrad_weight_s;
    }
    
    @XmlElement
    public void setDegrad_weight_s(String degrad_weight_s){
        this.degrad_weight_s=degrad_weight_s;
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
        
    public String getError_allow_d(){
        return error_allow_d;
    }
    
    @XmlElement
    public void setError_allow_d(String error_allow_d){
        this.error_allow_d=error_allow_d;
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
        
    public String getInto_routing_s(){
        return into_routing_s;
    }
    
    @XmlElement
    public void setInto_routing_s(String into_routing_s){
        this.into_routing_s=into_routing_s;
    }
        
    public String getInto_type_s(){
        return into_type_s;
    }
    
    @XmlElement
    public void setInto_type_s(String into_type_s){
        this.into_type_s=into_type_s;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
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
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getSet_weight_d(){
        return set_weight_d;
    }
    
    @XmlElement
    public void setSet_weight_d(String set_weight_d){
        this.set_weight_d=set_weight_d;
    }
        
    public String getSupply_code_s(){
        return supply_code_s;
    }
    
    @XmlElement
    public void setSupply_code_s(String supply_code_s){
        this.supply_code_s=supply_code_s;
    }
        
    public String getViscositystandard_s(){
        return viscositystandard_s;
    }
    
    @XmlElement
    public void setViscositystandard_s(String viscositystandard_s){
        this.viscositystandard_s=viscositystandard_s;
    }
        
    public String getWeight_prop_s(){
        return weight_prop_s;
    }
    
    @XmlElement
    public void setWeight_prop_s(String weight_prop_s){
        this.weight_prop_s=weight_prop_s;
    }
        
    public Integer getWeight_id_i(){
        return weight_id_i;
    }
    
    @XmlElement
    public void setWeight_id_i(Integer weight_id_i){
        this.weight_id_i=weight_id_i;
    }
        
    public Integer getWeight_type_i(){
        return weight_type_i;
    }
    
    @XmlElement
    public void setWeight_type_i(Integer weight_type_i){
        this.weight_type_i=weight_type_i;
    }
        
    
    
    
}
