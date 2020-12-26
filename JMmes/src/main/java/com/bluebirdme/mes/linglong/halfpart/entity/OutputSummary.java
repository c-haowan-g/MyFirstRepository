package com.bluebirdme.mes.linglong.halfpart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

@ATDefinition("A_MM_OUTPUT")
@Entity
@XmlRootElement
@Table(name="AT_A_MM_OUTPUT")
public class OutputSummary extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("副手")
    @Column(nullable=true,length=80)
    private String assistantone_s;
    
    @Comment("副手")
    @Column(nullable=true,length=80)
    private String assistantthree_s;
    
    @Comment("副手")
    @Column(nullable=true,length=80)
    private String assistanttwo_s;
    
    @Comment("产出批次条码")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("更正前载具")
    @Column(nullable=true,length=80)
    private String changebeforevehicles_s;
    
    @Comment("修改人(补产出人、取消产出人)")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间(补产出时间、取消产出时间)")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("卷曲工 副手")
    @Column(nullable=true,length=80)
    private String curlyassistantthree_s;
    
    @Comment("卷曲工 副手")
    @Column(nullable=true,length=80)
    private String curlyassistone_s;
    
    @Comment("卷曲工 副手")
    @Column(nullable=true,length=80)
    private String curlyassisttwo_s;
    
    @Comment("卷曲工主手")
    @Column(nullable=true,length=80)
    private String curlyworker_s;
    
    @Comment("更正前规格")
    @Column(nullable=true,length=80)
    private String column_11_s;
    
    @Comment("产出口")
    @Column(nullable=true,length=80)
    private String exportcode_s;
    
    @Comment("产出开始时间")
    @Column(nullable=true,length=0)
    private Date inputtime_t;
    
    @Comment("产出是否入库 0 否 1是")
    @Column(nullable=true,length=80)
    private String isstore_s;
    
    @Comment("机台条码")
    @Column(nullable=true,length=80)
    private String machinecode_s;
    
    @Comment("机台名称")
    @Column(nullable=true,length=80)
    private String machinename_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String materialcode_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=80)
    private String materialname_s;
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String materspec_s;
    
    @Comment("主手操作工")
    @Column(nullable=true,length=80)
    private String operator_s;
    
    @Comment("产出班次")
    @Column(nullable=true,length=80)
    private String outclass_s;
    
    @Comment("产出标记 基础数据105 105001正常产出105002补产出105003取消产出")
    @Column(nullable=true,length=80)
    private String outflag_s;
    
    @Comment("产出班组")
    @Column(nullable=true,length=80)
    private String outgroup_s;
    
    @Comment("产出量（重量，数量，长度）")
    @Column(nullable=true,length=0)
    private String outnum_f;
    
    @Comment("产出存储标记 0服务端 1客户端")
    @Column(nullable=true,length=80)
    private String outputflag_s;
    
    @Comment("产出结束时间")
    @Column(nullable=true,length=0)
    private Date outputtime_t;
    
    @Comment("日计划号-工单号")
    @Column(nullable=true,length=80)
    private String planno_s;
    
    @Comment("工装条码(口型板)")
    @Column(nullable=true,length=80)
    private String plate_code_s;
    
    @Comment("打印次数")
    @Column(nullable=true,length=0)
    private Integer printcount_i;
    
    @Comment("是否打印  0：否 1 是")
    @Column(nullable=true,length=80)
    private String printstatus_s;
    
    @Comment("质检人")
    @Column(nullable=true,length=80)
    private String qualityby_s;
    
    @Comment("质检时间")
    @Column(nullable=true,length=0)
    private Date qualitydate_t;
    
    @Comment("质量状态 基础数据 106 ")
    @Column(nullable=true,length=80)
    private String qualitystate_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("产出更正前的数量")
    @Column(nullable=true,length=0)
    private String repairoutquantity_f;
    
    @Comment("报工流水号")
    @Column(nullable=true,length=80)
    private String serid_s;
    
    @Comment("固化标识 ")
    @Column(nullable=true,length=80)
    private String solidifyflag_s;
    
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
    
    @Comment("使用状态 当前批次的状态 基础数据107")
    @Column(nullable=true,length=80)
    private String use_state_s;
    
    @Comment("载具条码(工字轮)")
    @Column(nullable=true,length=80)
    private String vehicles_code_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAssistantone_s(){
        return assistantone_s;
    }
    
    @XmlElement
    public void setAssistantone_s(String assistantone_s){
        this.assistantone_s=assistantone_s;
    }
        
    public String getAssistantthree_s(){
        return assistantthree_s;
    }
    
    @XmlElement
    public void setAssistantthree_s(String assistantthree_s){
        this.assistantthree_s=assistantthree_s;
    }
        
    public String getAssistanttwo_s(){
        return assistanttwo_s;
    }
    
    @XmlElement
    public void setAssistanttwo_s(String assistanttwo_s){
        this.assistanttwo_s=assistanttwo_s;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getChangebeforevehicles_s(){
        return changebeforevehicles_s;
    }
    
    @XmlElement
    public void setChangebeforevehicles_s(String changebeforevehicles_s){
        this.changebeforevehicles_s=changebeforevehicles_s;
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
        
    public String getCurlyassistantthree_s(){
        return curlyassistantthree_s;
    }
    
    @XmlElement
    public void setCurlyassistantthree_s(String curlyassistantthree_s){
        this.curlyassistantthree_s=curlyassistantthree_s;
    }
        
    public String getCurlyassistone_s(){
        return curlyassistone_s;
    }
    
    @XmlElement
    public void setCurlyassistone_s(String curlyassistone_s){
        this.curlyassistone_s=curlyassistone_s;
    }
        
    public String getCurlyassisttwo_s(){
        return curlyassisttwo_s;
    }
    
    @XmlElement
    public void setCurlyassisttwo_s(String curlyassisttwo_s){
        this.curlyassisttwo_s=curlyassisttwo_s;
    }
        
    public String getCurlyworker_s(){
        return curlyworker_s;
    }
    
    @XmlElement
    public void setCurlyworker_s(String curlyworker_s){
        this.curlyworker_s=curlyworker_s;
    }
        
    public String getColumn_11_s(){
        return column_11_s;
    }
    
    @XmlElement
    public void setColumn_11_s(String column_11_s){
        this.column_11_s=column_11_s;
    }
        
    public String getExportcode_s(){
        return exportcode_s;
    }
    
    @XmlElement
    public void setExportcode_s(String exportcode_s){
        this.exportcode_s=exportcode_s;
    }
        
    public Date getInputtime_t(){
        return inputtime_t;
    }
    
    @XmlElement
    public void setInputtime_t(Date inputtime_t){
        this.inputtime_t=inputtime_t;
    }
        
    public String getIsstore_s(){
        return isstore_s;
    }
    
    @XmlElement
    public void setIsstore_s(String isstore_s){
        this.isstore_s=isstore_s;
    }
        
    public String getMachinecode_s(){
        return machinecode_s;
    }
    
    @XmlElement
    public void setMachinecode_s(String machinecode_s){
        this.machinecode_s=machinecode_s;
    }
        
    public String getMachinename_s(){
        return machinename_s;
    }
    
    @XmlElement
    public void setMachinename_s(String machinename_s){
        this.machinename_s=machinename_s;
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
        
    public String getMaterspec_s(){
        return materspec_s;
    }
    
    @XmlElement
    public void setMaterspec_s(String materspec_s){
        this.materspec_s=materspec_s;
    }
        
    public String getOperator_s(){
        return operator_s;
    }
    
    @XmlElement
    public void setOperator_s(String operator_s){
        this.operator_s=operator_s;
    }
        
    public String getOutclass_s(){
        return outclass_s;
    }
    
    @XmlElement
    public void setOutclass_s(String outclass_s){
        this.outclass_s=outclass_s;
    }
        
    public String getOutflag_s(){
        return outflag_s;
    }
    
    @XmlElement
    public void setOutflag_s(String outflag_s){
        this.outflag_s=outflag_s;
    }
        
    public String getOutgroup_s(){
        return outgroup_s;
    }
    
    @XmlElement
    public void setOutgroup_s(String outgroup_s){
        this.outgroup_s=outgroup_s;
    }
        
    public String getOutnum_f(){
        return outnum_f;
    }
    
    @XmlElement
    public void setOutnum_f(String outnum_f){
        this.outnum_f=outnum_f;
    }
        
    public String getOutputflag_s(){
        return outputflag_s;
    }
    
    @XmlElement
    public void setOutputflag_s(String outputflag_s){
        this.outputflag_s=outputflag_s;
    }
        
    public Date getOutputtime_t(){
        return outputtime_t;
    }
    
    @XmlElement
    public void setOutputtime_t(Date outputtime_t){
        this.outputtime_t=outputtime_t;
    }
        
    public String getPlanno_s(){
        return planno_s;
    }
    
    @XmlElement
    public void setPlanno_s(String planno_s){
        this.planno_s=planno_s;
    }
        
    public String getPlate_code_s(){
        return plate_code_s;
    }
    
    @XmlElement
    public void setPlate_code_s(String plate_code_s){
        this.plate_code_s=plate_code_s;
    }
        
    public Integer getPrintcount_i(){
        return printcount_i;
    }
    
    @XmlElement
    public void setPrintcount_i(Integer printcount_i){
        this.printcount_i=printcount_i;
    }
        
    public String getPrintstatus_s(){
        return printstatus_s;
    }
    
    @XmlElement
    public void setPrintstatus_s(String printstatus_s){
        this.printstatus_s=printstatus_s;
    }
        
    public String getQualityby_s(){
        return qualityby_s;
    }
    
    @XmlElement
    public void setQualityby_s(String qualityby_s){
        this.qualityby_s=qualityby_s;
    }
        
    public Date getQualitydate_t(){
        return qualitydate_t;
    }
    
    @XmlElement
    public void setQualitydate_t(Date qualitydate_t){
        this.qualitydate_t=qualitydate_t;
    }
        
    public String getQualitystate_s(){
        return qualitystate_s;
    }
    
    @XmlElement
    public void setQualitystate_s(String qualitystate_s){
        this.qualitystate_s=qualitystate_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRepairoutquantity_f(){
        return repairoutquantity_f;
    }
    
    @XmlElement
    public void setRepairoutquantity_f(String repairoutquantity_f){
        this.repairoutquantity_f=repairoutquantity_f;
    }
        
    public String getSerid_s(){
        return serid_s;
    }
    
    @XmlElement
    public void setSerid_s(String serid_s){
        this.serid_s=serid_s;
    }
        
    public String getSolidifyflag_s(){
        return solidifyflag_s;
    }
    
    @XmlElement
    public void setSolidifyflag_s(String solidifyflag_s){
        this.solidifyflag_s=solidifyflag_s;
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
        
    public String getUse_state_s(){
        return use_state_s;
    }
    
    @XmlElement
    public void setUse_state_s(String use_state_s){
        this.use_state_s=use_state_s;
    }
        
    public String getVehicles_code_s(){
        return vehicles_code_s;
    }
    
    @XmlElement
    public void setVehicles_code_s(String vehicles_code_s){
        this.vehicles_code_s=vehicles_code_s;
    }
        
    
    
    
}
