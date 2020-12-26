/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * 质检配方判定标准表-全钢
 * @author 刘程明
 * @Date 2018-12-06 11:37:48
 */
@ATDefinition("D_BS_RecipeJudge_Log")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_RECIPEJUDGE_LOG")
public class RecipeJudgeLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("气压")
    @Column(nullable=true,length=80)
    private String airpressure_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("胎圈宽度（英寸）")
    @Column(nullable=true,length=80)
    private String beadwidth_s;
    
    @Comment("设备类别：TBROE-全钢配套、TBRRE-全钢零售、PCROE-半钢配套、PCRRE-半钢零售")
    @Column(nullable=true,length=80)
    private String category_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("判定标准ID：INT_PLM_DYNAMICBALANCE.ATR_KEY")
    @Column(nullable=true,length=80)
    private String checkno_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String comment_s;
    
    @Comment("CON")
    @Column(nullable=true,length=80)
    private String con_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=100)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("描述")
    @Column(nullable=true,length=80)
    private String description_s;
    
    @Comment("动平衡（单边）")
    @Column(nullable=true,length=80)
    private String dyn_1_plane_s;
    
    @Comment("动平衡（双边）")
    @Column(nullable=true,length=80)
    private String dyn_2_planes_s;
    
    @Comment("等级")
    @Column(nullable=true,length=80)
    private String grade_s;
    
    @Comment("层级")
    @Column(nullable=true,length=80)
    private String hierarchy_s;
    
    @Comment("ID主键")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("胎圈直径")
    @Column(nullable=true,length=80)
    private String insidediameter_s;
    
    @Comment("下凸")
    @Column(nullable=true,length=80)
    private String lb_bulging_s;
    
    @Comment("下凹")
    @Column(nullable=true,length=80)
    private String lb_dent_s;
    
    @Comment("LFV")
    @Column(nullable=true,length=80)
    private String lfv_s;
    
    @Comment("侧向跳动")
    @Column(nullable=true,length=80)
    private String lro_s;
    
    @Comment("上凸")
    @Column(nullable=true,length=80)
    private String lt_bulging_s;
    
    @Comment("上凹")
    @Column(nullable=true,length=80)
    private String lt_dent_s;
    
    @Comment("负荷")
    @Column(nullable=true,length=80)
    private String load_s;
    
    @Comment("最大外径（外径+公差）")
    @Column(nullable=true,length=80)
    private String max_diameter_s;
    
    @Comment("最小外径（外径-公差）")
    @Column(nullable=true,length=80)
    private String min_diameter_s;
    
    @Comment("打标半径1")
    @Column(nullable=true,length=80)
    private String markingradius_1_s;
    
    @Comment("打标半径2")
    @Column(nullable=true,length=80)
    private String markingradius_2_s;
    
    @Comment("打标半径3")
    @Column(nullable=true,length=80)
    private String markingradius_3_s;
    
    @Comment("打标半径4")
    @Column(nullable=true,length=80)
    private String markingradius_4_s;
    
    @Comment("打标半径5")
    @Column(nullable=true,length=80)
    private String markingradius_5_s;
    
    @Comment("外直径")
    @Column(nullable=true,length=80)
    private String outsidediameter_s;
    
    @Comment("花纹")
    @Column(nullable=true,length=80)
    private String pattern_s;
    
    @Comment("胎压")
    @Column(nullable=true,length=80)
    private String pressure_s;
    
    @Comment("检查型号：D_BS_Recipe.RECIPENO")
    @Column(nullable=true,length=80)
    private String recipeno_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("RFV")
    @Column(nullable=true,length=80)
    private String rfv_s;
    
    @Comment("RIH")
    @Column(nullable=true,length=80)
    private String rih_s;
    
    @Comment("径向跳动")
    @Column(nullable=true,length=80)
    private String rro_s;
    
    @Comment("当前生产SAP号")
    @Column(nullable=true,length=80)
    private String sap_code_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("打标特殊要求")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("静平衡")
    @Column(nullable=true,length=80)
    private String staticbalance_s;
    
    @Comment("同步时间")
    @Column(nullable=true,length=0)
    private Date sync_create_time_t;
    
    @Comment("数据同步处理：A-新增、U-修改、D-删除")
    @Column(nullable=true,length=80)
    private String sync_flag_s;
    
    @Comment("数据同步处理标记：0-未处理、1-已处理")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_s;
    
    @Comment("数据同步处理反馈")
    @Column(nullable=true,length=80)
    private String sync_hand_msg_s;
    
    @Comment("处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_t;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("胎压负公差")
    @Column(nullable=true,length=80)
    private String tolerance_minus_s;
    
    @Comment("胎压正公差")
    @Column(nullable=true,length=80)
    private String tolerance_positive_s;
    
    @Comment("轮胎宽度（英寸）")
    @Column(nullable=true,length=80)
    private String tyrewidth_s;
    
    @Comment("轮胎规格")
    @Column(nullable=true,length=80)
    private String tyrespecification_s;
    
    @Comment("轮胎断面宽度")
    @Column(nullable=true,length=80)
    private String widthoftyresection_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAirpressure_s(){
        return airpressure_s;
    }
    
    @XmlElement
    public void setAirpressure_s(String airpressure_s){
        this.airpressure_s=airpressure_s;
    }
        
    public String getArch_flag_s(){
        return arch_flag_s;
    }
    
    @XmlElement
    public void setArch_flag_s(String arch_flag_s){
        this.arch_flag_s=arch_flag_s;
    }
        
    public String getBeadwidth_s(){
        return beadwidth_s;
    }
    
    @XmlElement
    public void setBeadwidth_s(String beadwidth_s){
        this.beadwidth_s=beadwidth_s;
    }
        
    public String getCategory_s(){
        return category_s;
    }
    
    @XmlElement
    public void setCategory_s(String category_s){
        this.category_s=category_s;
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
        
    public String getCheckno_s(){
        return checkno_s;
    }
    
    @XmlElement
    public void setCheckno_s(String checkno_s){
        this.checkno_s=checkno_s;
    }
        
    public String getComment_s(){
        return comment_s;
    }
    
    @XmlElement
    public void setComment_s(String comment_s){
        this.comment_s=comment_s;
    }
        
    public String getCon_s(){
        return con_s;
    }
    
    @XmlElement
    public void setCon_s(String con_s){
        this.con_s=con_s;
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
        
    public String getDescription_s(){
        return description_s;
    }
    
    @XmlElement
    public void setDescription_s(String description_s){
        this.description_s=description_s;
    }
        
    public String getDyn_1_plane_s(){
        return dyn_1_plane_s;
    }
    
    @XmlElement
    public void setDyn_1_plane_s(String dyn_1_plane_s){
        this.dyn_1_plane_s=dyn_1_plane_s;
    }
        
    public String getDyn_2_planes_s(){
        return dyn_2_planes_s;
    }
    
    @XmlElement
    public void setDyn_2_planes_s(String dyn_2_planes_s){
        this.dyn_2_planes_s=dyn_2_planes_s;
    }
        
    public String getGrade_s(){
        return grade_s;
    }
    
    @XmlElement
    public void setGrade_s(String grade_s){
        this.grade_s=grade_s;
    }
        
    public String getHierarchy_s(){
        return hierarchy_s;
    }
    
    @XmlElement
    public void setHierarchy_s(String hierarchy_s){
        this.hierarchy_s=hierarchy_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getInsidediameter_s(){
        return insidediameter_s;
    }
    
    @XmlElement
    public void setInsidediameter_s(String insidediameter_s){
        this.insidediameter_s=insidediameter_s;
    }
        
    public String getLb_bulging_s(){
        return lb_bulging_s;
    }
    
    @XmlElement
    public void setLb_bulging_s(String lb_bulging_s){
        this.lb_bulging_s=lb_bulging_s;
    }
        
    public String getLb_dent_s(){
        return lb_dent_s;
    }
    
    @XmlElement
    public void setLb_dent_s(String lb_dent_s){
        this.lb_dent_s=lb_dent_s;
    }
        
    public String getLfv_s(){
        return lfv_s;
    }
    
    @XmlElement
    public void setLfv_s(String lfv_s){
        this.lfv_s=lfv_s;
    }
        
    public String getLro_s(){
        return lro_s;
    }
    
    @XmlElement
    public void setLro_s(String lro_s){
        this.lro_s=lro_s;
    }
        
    public String getLt_bulging_s(){
        return lt_bulging_s;
    }
    
    @XmlElement
    public void setLt_bulging_s(String lt_bulging_s){
        this.lt_bulging_s=lt_bulging_s;
    }
        
    public String getLt_dent_s(){
        return lt_dent_s;
    }
    
    @XmlElement
    public void setLt_dent_s(String lt_dent_s){
        this.lt_dent_s=lt_dent_s;
    }
        
    public String getLoad_s(){
        return load_s;
    }
    
    @XmlElement
    public void setLoad_s(String load_s){
        this.load_s=load_s;
    }
        
    public String getMax_diameter_s(){
        return max_diameter_s;
    }
    
    @XmlElement
    public void setMax_diameter_s(String max_diameter_s){
        this.max_diameter_s=max_diameter_s;
    }
        
    public String getMin_diameter_s(){
        return min_diameter_s;
    }
    
    @XmlElement
    public void setMin_diameter_s(String min_diameter_s){
        this.min_diameter_s=min_diameter_s;
    }
        
    public String getMarkingradius_1_s(){
        return markingradius_1_s;
    }
    
    @XmlElement
    public void setMarkingradius_1_s(String markingradius_1_s){
        this.markingradius_1_s=markingradius_1_s;
    }
        
    public String getMarkingradius_2_s(){
        return markingradius_2_s;
    }
    
    @XmlElement
    public void setMarkingradius_2_s(String markingradius_2_s){
        this.markingradius_2_s=markingradius_2_s;
    }
        
    public String getMarkingradius_3_s(){
        return markingradius_3_s;
    }
    
    @XmlElement
    public void setMarkingradius_3_s(String markingradius_3_s){
        this.markingradius_3_s=markingradius_3_s;
    }
        
    public String getMarkingradius_4_s(){
        return markingradius_4_s;
    }
    
    @XmlElement
    public void setMarkingradius_4_s(String markingradius_4_s){
        this.markingradius_4_s=markingradius_4_s;
    }
        
    public String getMarkingradius_5_s(){
        return markingradius_5_s;
    }
    
    @XmlElement
    public void setMarkingradius_5_s(String markingradius_5_s){
        this.markingradius_5_s=markingradius_5_s;
    }
        
    public String getOutsidediameter_s(){
        return outsidediameter_s;
    }
    
    @XmlElement
    public void setOutsidediameter_s(String outsidediameter_s){
        this.outsidediameter_s=outsidediameter_s;
    }
        
    public String getPattern_s(){
        return pattern_s;
    }
    
    @XmlElement
    public void setPattern_s(String pattern_s){
        this.pattern_s=pattern_s;
    }
        
    public String getPressure_s(){
        return pressure_s;
    }
    
    @XmlElement
    public void setPressure_s(String pressure_s){
        this.pressure_s=pressure_s;
    }
        
    public String getRecipeno_s(){
        return recipeno_s;
    }
    
    @XmlElement
    public void setRecipeno_s(String recipeno_s){
        this.recipeno_s=recipeno_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRfv_s(){
        return rfv_s;
    }
    
    @XmlElement
    public void setRfv_s(String rfv_s){
        this.rfv_s=rfv_s;
    }
        
    public String getRih_s(){
        return rih_s;
    }
    
    @XmlElement
    public void setRih_s(String rih_s){
        this.rih_s=rih_s;
    }
        
    public String getRro_s(){
        return rro_s;
    }
    
    @XmlElement
    public void setRro_s(String rro_s){
        this.rro_s=rro_s;
    }
        
    public String getSap_code_s(){
        return sap_code_s;
    }
    
    @XmlElement
    public void setSap_code_s(String sap_code_s){
        this.sap_code_s=sap_code_s;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getStaticbalance_s(){
        return staticbalance_s;
    }
    
    @XmlElement
    public void setStaticbalance_s(String staticbalance_s){
        this.staticbalance_s=staticbalance_s;
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
        
    public String getSync_hand_flag_s(){
        return sync_hand_flag_s;
    }
    
    @XmlElement
    public void setSync_hand_flag_s(String sync_hand_flag_s){
        this.sync_hand_flag_s=sync_hand_flag_s;
    }
        
    public String getSync_hand_msg_s(){
        return sync_hand_msg_s;
    }
    
    @XmlElement
    public void setSync_hand_msg_s(String sync_hand_msg_s){
        this.sync_hand_msg_s=sync_hand_msg_s;
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
        
    public String getTolerance_minus_s(){
        return tolerance_minus_s;
    }
    
    @XmlElement
    public void setTolerance_minus_s(String tolerance_minus_s){
        this.tolerance_minus_s=tolerance_minus_s;
    }
        
    public String getTolerance_positive_s(){
        return tolerance_positive_s;
    }
    
    @XmlElement
    public void setTolerance_positive_s(String tolerance_positive_s){
        this.tolerance_positive_s=tolerance_positive_s;
    }
        
    public String getTyrewidth_s(){
        return tyrewidth_s;
    }
    
    @XmlElement
    public void setTyrewidth_s(String tyrewidth_s){
        this.tyrewidth_s=tyrewidth_s;
    }
        
    public String getTyrespecification_s(){
        return tyrespecification_s;
    }
    
    @XmlElement
    public void setTyrespecification_s(String tyrespecification_s){
        this.tyrespecification_s=tyrespecification_s;
    }
        
    public String getWidthoftyresection_s(){
        return widthoftyresection_s;
    }
    
    @XmlElement
    public void setWidthoftyresection_s(String widthoftyresection_s){
        this.widthoftyresection_s=widthoftyresection_s;
    }
        
    
    
    
}
