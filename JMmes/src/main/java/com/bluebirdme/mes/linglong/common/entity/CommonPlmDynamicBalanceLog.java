/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity;

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
 * PLM动平衡标准集成日志表
 * @author 刘程明
 * @Date 2019-07-02 17:26:05
 */
@ATDefinition("INT_PLM_DYNAMICBALANCE_LOG")
@Entity
@XmlRootElement
@Table(name="AT_INT_PLM_DYNAMICBALANCE_LOG")
public class CommonPlmDynamicBalanceLog extends RockWellBaseEntity{
    
    
    @Comment("角度效应下限")
    @Column(nullable=true,length=80)
    private String angleeffectlowerbound_s;
    
    @Comment("角度效应上限")
    @Column(nullable=true,length=80)
    private String angleeffectupperbound_s;
    
    @Comment("胎圈直径(内径)")
    @Column(nullable=true,length=80)
    private String beaddiameter_s;
    
    @Comment("胎圈宽度")
    @Column(nullable=true,length=80)
    private String beadwidth_s;
    
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
    
    @Comment("CON")
    @Column(nullable=true,length=80)
    private String con_s;
    
    @Comment("凹凸度")
    @Column(nullable=true,length=80)
    private String camber_s;
    
    @Comment("设备类别：TBROE-全钢配套、TBRRE-全钢零售、PCROE-半钢配套、PCRRE-半钢零售")
    @Column(nullable=true,length=80)
    private String category_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String comment_s;
    
    @Comment("力偶不平衡量")
    @Column(nullable=true,length=80)
    private String coupleunbalance_s;
    
    @Comment("描述")
    @Column(nullable=true,length=80)
    private String description_s;
    
    @Comment("下凸")
    @Column(nullable=true,length=80)
    private String downbulge_s;
    
    @Comment("下凹")
    @Column(nullable=true,length=80)
    private String downconcave_s;
    
    @Comment("下侧跳")
    @Column(nullable=true,length=80)
    private String downjump_s;
    
    @Comment("预留1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("预留2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("预留3")
    @Column(nullable=true,length=80)
    private String dummy3_s;
    
    @Comment("预留4")
    @Column(nullable=true,length=80)
    private String dummy4_s;
    
    @Comment("预留5")
    @Column(nullable=true,length=80)
    private String dummy5_s;
    
    @Comment("检查型号")
    @Column(nullable=true,length=80)
    private String examinetype_s;
    
    @Comment("外直径")
    @Column(nullable=true,length=80)
    private String externaldiameter_s;
    
    @Comment("GUID，同一次报文传递的数据")
    @Column(nullable=true,length=80)
    private String guid_s;
    
    @Comment("等级")
    @Column(nullable=true,length=80)
    private String grade_s;
    
    @Comment("层级")
    @Column(nullable=true,length=80)
    private String hierarchy_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("LFV")
    @Column(nullable=true,length=80)
    private String lfv_s;
    
    @Comment("侧向跳动")
    @Column(nullable=true,length=80)
    private String lateralbeating_s;
    
    @Comment("负荷公差")
    @Column(nullable=true,length=80)
    private String loadtolerance_s;
    
    @Comment("负荷")
    @Column(nullable=true,length=80)
    private String load_s;
    
    @Comment("打标位置要求")
    @Column(nullable=true,length=80)
    private String markpositionrequire_s;
    
    @Comment("打标半径5")
    @Column(nullable=true,length=80)
    private String markradiusfive_s;
    
    @Comment("打标半径4")
    @Column(nullable=true,length=80)
    private String markradiusfour_s;
    
    @Comment("打标半径1")
    @Column(nullable=true,length=80)
    private String markradiusone_s;
    
    @Comment("打标半径3")
    @Column(nullable=true,length=80)
    private String markradiusthree_s;
    
    @Comment("打标半径2")
    @Column(nullable=true,length=80)
    private String markradiustwo_s;
    
    @Comment("最大外径")
    @Column(nullable=true,length=80)
    private String maxoutsidediameter_s;
    
    @Comment("最小外径")
    @Column(nullable=true,length=80)
    private String minimumoutsidediameter_s;
    
    @Comment("花纹")
    @Column(nullable=true,length=80)
    private String pattern_s;
    
    @Comment("气压")
    @Column(nullable=true,length=80)
    private String pressure_s;
    
    @Comment("接收时间")
    @Column(nullable=true,length=0)
    private Date receive_time_t;
    
    @Comment("配方启停人")
    @Column(nullable=true,length=80)
    private String recipe_by_s;
    
    @Comment("配方名称：设备类别+规格+花纹 例如 TBROE_115/110M LL CCC TL LRR OE_KCA651")
    @Column(nullable=true,length=500)
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
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("RFV")
    @Column(nullable=true,length=80)
    private String rfv_s;
    
    @Comment("RIH")
    @Column(nullable=true,length=80)
    private String rih_s;
    
    @Comment("径向力八次谐波")
    @Column(nullable=true,length=80)
    private String radialeightharmonics_s;
    
    @Comment("径向力一次谐波")
    @Column(nullable=true,length=80)
    private String radialfirstharmonics_s;
    
    @Comment("径向力二次谐波")
    @Column(nullable=true,length=80)
    private String radialrecondharmonics_s;
    
    @Comment("径向跳动")
    @Column(nullable=true,length=80)
    private String runout_s;
    
    @Comment("SAP号")
    @Column(nullable=true,length=80)
    private String sapcode_s;
    
    @Comment("下发人")
    @Column(nullable=true,length=80)
    private String send_by_s;
    
    @Comment("下发人姓名")
    @Column(nullable=true,length=200)
    private String send_name_s;
    
    @Comment("下发标识（下发成功后置逻辑删除）：0-未下发、1-已下发")
    @Column(nullable=true,length=80)
    private String send_state_s;
    
    @Comment("下发时间")
    @Column(nullable=true,length=0)
    private Date send_time_t;
    
    @Comment("轮胎断面宽度(充气后最宽的部分)")
    @Column(nullable=true,length=80)
    private String sectionwidth_s;
    
    @Comment("打标特殊要求")
    @Column(nullable=true,length=80)
    private String specialrequire_s;
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("静平衡")
    @Column(nullable=true,length=80)
    private String staticbalance_s;
    
    @Comment("锥度下限")
    @Column(nullable=true,length=80)
    private String taperlowerbound_s;
    
    @Comment("锥度上限")
    @Column(nullable=true,length=80)
    private String taperupperbound_s;
    
    @Comment("胎压公差")
    @Column(nullable=true,length=80)
    private String tirepressuretolerance_s;
    
    @Comment("Total")
    @Column(nullable=true,length=80)
    private String total_s;
    
    @Comment("上凸")
    @Column(nullable=true,length=80)
    private String upbulge_s;
    
    @Comment("上凹")
    @Column(nullable=true,length=80)
    private String upconcave_s;
    
    @Comment("上侧跳")
    @Column(nullable=true,length=80)
    private String upjump_s;
    
    @Comment("Up/Low")
    @Column(nullable=true,length=80)
    private String uplow_s;
    
    public String getAngleeffectlowerbound_s(){
        return angleeffectlowerbound_s;
    }
    
    @XmlElement
    public void setAngleeffectlowerbound_s(String angleeffectlowerbound_s){
        this.angleeffectlowerbound_s=angleeffectlowerbound_s;
    }
        
    public String getAngleeffectupperbound_s(){
        return angleeffectupperbound_s;
    }
    
    @XmlElement
    public void setAngleeffectupperbound_s(String angleeffectupperbound_s){
        this.angleeffectupperbound_s=angleeffectupperbound_s;
    }
        
    public String getBeaddiameter_s(){
        return beaddiameter_s;
    }
    
    @XmlElement
    public void setBeaddiameter_s(String beaddiameter_s){
        this.beaddiameter_s=beaddiameter_s;
    }
        
    public String getBeadwidth_s(){
        return beadwidth_s;
    }
    
    @XmlElement
    public void setBeadwidth_s(String beadwidth_s){
        this.beadwidth_s=beadwidth_s;
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
        
    public String getCon_s(){
        return con_s;
    }
    
    @XmlElement
    public void setCon_s(String con_s){
        this.con_s=con_s;
    }
        
    public String getCamber_s(){
        return camber_s;
    }
    
    @XmlElement
    public void setCamber_s(String camber_s){
        this.camber_s=camber_s;
    }
        
    public String getCategory_s(){
        return category_s;
    }
    
    @XmlElement
    public void setCategory_s(String category_s){
        this.category_s=category_s;
    }
        
    public String getComment_s(){
        return comment_s;
    }
    
    @XmlElement
    public void setComment_s(String comment_s){
        this.comment_s=comment_s;
    }
        
    public String getCoupleunbalance_s(){
        return coupleunbalance_s;
    }
    
    @XmlElement
    public void setCoupleunbalance_s(String coupleunbalance_s){
        this.coupleunbalance_s=coupleunbalance_s;
    }
        
    public String getDescription_s(){
        return description_s;
    }
    
    @XmlElement
    public void setDescription_s(String description_s){
        this.description_s=description_s;
    }
        
    public String getDownbulge_s(){
        return downbulge_s;
    }
    
    @XmlElement
    public void setDownbulge_s(String downbulge_s){
        this.downbulge_s=downbulge_s;
    }
        
    public String getDownconcave_s(){
        return downconcave_s;
    }
    
    @XmlElement
    public void setDownconcave_s(String downconcave_s){
        this.downconcave_s=downconcave_s;
    }
        
    public String getDownjump_s(){
        return downjump_s;
    }
    
    @XmlElement
    public void setDownjump_s(String downjump_s){
        this.downjump_s=downjump_s;
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
        
    public String getExaminetype_s(){
        return examinetype_s;
    }
    
    @XmlElement
    public void setExaminetype_s(String examinetype_s){
        this.examinetype_s=examinetype_s;
    }
        
    public String getExternaldiameter_s(){
        return externaldiameter_s;
    }
    
    @XmlElement
    public void setExternaldiameter_s(String externaldiameter_s){
        this.externaldiameter_s=externaldiameter_s;
    }
        
    public String getGuid_s(){
        return guid_s;
    }
    
    @XmlElement
    public void setGuid_s(String guid_s){
        this.guid_s=guid_s;
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
        
    public String getLfv_s(){
        return lfv_s;
    }
    
    @XmlElement
    public void setLfv_s(String lfv_s){
        this.lfv_s=lfv_s;
    }
        
    public String getLateralbeating_s(){
        return lateralbeating_s;
    }
    
    @XmlElement
    public void setLateralbeating_s(String lateralbeating_s){
        this.lateralbeating_s=lateralbeating_s;
    }
        
    public String getLoadtolerance_s(){
        return loadtolerance_s;
    }
    
    @XmlElement
    public void setLoadtolerance_s(String loadtolerance_s){
        this.loadtolerance_s=loadtolerance_s;
    }
        
    public String getLoad_s(){
        return load_s;
    }
    
    @XmlElement
    public void setLoad_s(String load_s){
        this.load_s=load_s;
    }
        
    public String getMarkpositionrequire_s(){
        return markpositionrequire_s;
    }
    
    @XmlElement
    public void setMarkpositionrequire_s(String markpositionrequire_s){
        this.markpositionrequire_s=markpositionrequire_s;
    }
        
    public String getMarkradiusfive_s(){
        return markradiusfive_s;
    }
    
    @XmlElement
    public void setMarkradiusfive_s(String markradiusfive_s){
        this.markradiusfive_s=markradiusfive_s;
    }
        
    public String getMarkradiusfour_s(){
        return markradiusfour_s;
    }
    
    @XmlElement
    public void setMarkradiusfour_s(String markradiusfour_s){
        this.markradiusfour_s=markradiusfour_s;
    }
        
    public String getMarkradiusone_s(){
        return markradiusone_s;
    }
    
    @XmlElement
    public void setMarkradiusone_s(String markradiusone_s){
        this.markradiusone_s=markradiusone_s;
    }
        
    public String getMarkradiusthree_s(){
        return markradiusthree_s;
    }
    
    @XmlElement
    public void setMarkradiusthree_s(String markradiusthree_s){
        this.markradiusthree_s=markradiusthree_s;
    }
        
    public String getMarkradiustwo_s(){
        return markradiustwo_s;
    }
    
    @XmlElement
    public void setMarkradiustwo_s(String markradiustwo_s){
        this.markradiustwo_s=markradiustwo_s;
    }
        
    public String getMaxoutsidediameter_s(){
        return maxoutsidediameter_s;
    }
    
    @XmlElement
    public void setMaxoutsidediameter_s(String maxoutsidediameter_s){
        this.maxoutsidediameter_s=maxoutsidediameter_s;
    }
        
    public String getMinimumoutsidediameter_s(){
        return minimumoutsidediameter_s;
    }
    
    @XmlElement
    public void setMinimumoutsidediameter_s(String minimumoutsidediameter_s){
        this.minimumoutsidediameter_s=minimumoutsidediameter_s;
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
        
    public String getRadialeightharmonics_s(){
        return radialeightharmonics_s;
    }
    
    @XmlElement
    public void setRadialeightharmonics_s(String radialeightharmonics_s){
        this.radialeightharmonics_s=radialeightharmonics_s;
    }
        
    public String getRadialfirstharmonics_s(){
        return radialfirstharmonics_s;
    }
    
    @XmlElement
    public void setRadialfirstharmonics_s(String radialfirstharmonics_s){
        this.radialfirstharmonics_s=radialfirstharmonics_s;
    }
        
    public String getRadialrecondharmonics_s(){
        return radialrecondharmonics_s;
    }
    
    @XmlElement
    public void setRadialrecondharmonics_s(String radialrecondharmonics_s){
        this.radialrecondharmonics_s=radialrecondharmonics_s;
    }
        
    public String getRunout_s(){
        return runout_s;
    }
    
    @XmlElement
    public void setRunout_s(String runout_s){
        this.runout_s=runout_s;
    }
        
    public String getSapcode_s(){
        return sapcode_s;
    }
    
    @XmlElement
    public void setSapcode_s(String sapcode_s){
        this.sapcode_s=sapcode_s;
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
        
    public String getSectionwidth_s(){
        return sectionwidth_s;
    }
    
    @XmlElement
    public void setSectionwidth_s(String sectionwidth_s){
        this.sectionwidth_s=sectionwidth_s;
    }
        
    public String getSpecialrequire_s(){
        return specialrequire_s;
    }
    
    @XmlElement
    public void setSpecialrequire_s(String specialrequire_s){
        this.specialrequire_s=specialrequire_s;
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
        
    public String getTaperlowerbound_s(){
        return taperlowerbound_s;
    }
    
    @XmlElement
    public void setTaperlowerbound_s(String taperlowerbound_s){
        this.taperlowerbound_s=taperlowerbound_s;
    }
        
    public String getTaperupperbound_s(){
        return taperupperbound_s;
    }
    
    @XmlElement
    public void setTaperupperbound_s(String taperupperbound_s){
        this.taperupperbound_s=taperupperbound_s;
    }
        
    public String getTirepressuretolerance_s(){
        return tirepressuretolerance_s;
    }
    
    @XmlElement
    public void setTirepressuretolerance_s(String tirepressuretolerance_s){
        this.tirepressuretolerance_s=tirepressuretolerance_s;
    }
        
    public String getTotal_s(){
        return total_s;
    }
    
    @XmlElement
    public void setTotal_s(String total_s){
        this.total_s=total_s;
    }
        
    public String getUpbulge_s(){
        return upbulge_s;
    }
    
    @XmlElement
    public void setUpbulge_s(String upbulge_s){
        this.upbulge_s=upbulge_s;
    }
        
    public String getUpconcave_s(){
        return upconcave_s;
    }
    
    @XmlElement
    public void setUpconcave_s(String upconcave_s){
        this.upconcave_s=upconcave_s;
    }
        
    public String getUpjump_s(){
        return upjump_s;
    }
    
    @XmlElement
    public void setUpjump_s(String upjump_s){
        this.upjump_s=upjump_s;
    }
        
    public String getUplow_s(){
        return uplow_s;
    }
    
    @XmlElement
    public void setUplow_s(String uplow_s){
        this.uplow_s=uplow_s;
    }
        
    
    
    
}
