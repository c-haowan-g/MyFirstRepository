/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity;

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
 * X光检测履历
 * @author majb
 * @Date 2018-08-09 07:39:33
 */
@ATDefinition("D_QM_CheckXrayLog")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_CheckXrayLog")
public class CheckXrayLog extends RockWellBaseEntity{
    
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String additionalinfo_s;
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String centerx_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String centery_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String clockwise_s;
    
    @Comment("图片名称")
    @Column(nullable=true,length=100)
    private String connectedfile_s;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String currentheight_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String currentleft_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String currenttop_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String currentwidth_s;
    
    @Comment("时间日期：年月日 20110920")
    @Column(nullable=true,length=80)
    private String da_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String defectcomment_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String defectlevel_s;
    
    @Comment("病象名称：D_BS_Reas 表 ID描述")
    @Column(nullable=true,length=80)
    private String defectname_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String defectoperator_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String defectsize_s;
    
    @Comment("病象编号：D_BS_Reas 表 ID")
    @Column(nullable=true,length=80)
    private String defects_s;
    
    @Comment("自动判级时间")
    @Column(nullable=true,length=0)
    private Date defecttime_t;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String drawingprimitive_s;
    
    @Comment("质检等级编码")
    @Column(nullable=false,length=80)
    private String gradecd_s;
    
    @Comment("班组")
    @Column(nullable=true,length=80)
    private String groupcode_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String gr_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String ic_s;
    
    @Comment("硫化规格代码")
    @Column(nullable=true,length=80)
    private String itemid_s;
    
    @Comment("轮胎状态编码")
    @Column(nullable=false,length=80)
    private String itemstate_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String lda_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String linetime_s;
    
    @Comment("备注信息")
    @Column(nullable=true,length=200)
    private String memo_s;
    
    @Comment("机台条码：D_EM_Ent 表 ENTBARCODE")
    @Column(nullable=false,length=80)
    private String mn_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String nm_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String op_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String originalheight_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String originalwidth_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String pc_s;
    
    @Comment("轮胎条码：MES_MainTyre 表 BARCODE")
    @Column(nullable=false,length=80)
    private String pn_s;
    
    @Comment("当前工序")
    @Column(nullable=false,length=80)
    private String proess_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String reascdformes_s;
    
    @Comment("病象编号：D_BS_Reas 表 ID")
    @Column(nullable=true,length=80)
    private String reascd_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String sizex_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String sizey_s;
    
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
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("时间日期：时分秒 140509")
    @Column(nullable=true,length=80)
    private String ti_s;
    
    @Comment("轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎")
    @Column(nullable=true,length=80)
    private String tyretypecode_s;
    
    @Comment("质检员")
    @Column(nullable=false,length=80)
    private String userid_s;
    
    @Comment(" ")
    @Column(nullable=true,length=80)
    private String vertorigin_s;
    
     
    public String getAdditionalinfo_s(){
        return additionalinfo_s;
    }
    
    @XmlElement
    public void setAdditionalinfo_s(String additionalinfo_s){
        this.additionalinfo_s=additionalinfo_s;
    }
        
     
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
        
     
    public String getCenterx_s(){
        return centerx_s;
    }
    
    @XmlElement
    public void setCenterx_s(String centerx_s){
        this.centerx_s=centerx_s;
    }
        
     
    public String getCentery_s(){
        return centery_s;
    }
    
    @XmlElement
    public void setCentery_s(String centery_s){
        this.centery_s=centery_s;
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
        
     
    public String getClockwise_s(){
        return clockwise_s;
    }
    
    @XmlElement
    public void setClockwise_s(String clockwise_s){
        this.clockwise_s=clockwise_s;
    }
        
     
    public String getConnectedfile_s(){
        return connectedfile_s;
    }
    
    @XmlElement
    public void setConnectedfile_s(String connectedfile_s){
        this.connectedfile_s=connectedfile_s;
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
        
     
    public String getCurrentheight_s(){
        return currentheight_s;
    }
    
    @XmlElement
    public void setCurrentheight_s(String currentheight_s){
        this.currentheight_s=currentheight_s;
    }
        
     
    public String getCurrentleft_s(){
        return currentleft_s;
    }
    
    @XmlElement
    public void setCurrentleft_s(String currentleft_s){
        this.currentleft_s=currentleft_s;
    }
        
     
    public String getCurrenttop_s(){
        return currenttop_s;
    }
    
    @XmlElement
    public void setCurrenttop_s(String currenttop_s){
        this.currenttop_s=currenttop_s;
    }
        
     
    public String getCurrentwidth_s(){
        return currentwidth_s;
    }
    
    @XmlElement
    public void setCurrentwidth_s(String currentwidth_s){
        this.currentwidth_s=currentwidth_s;
    }
        
     
    public String getDa_s(){
        return da_s;
    }
    
    @XmlElement
    public void setDa_s(String da_s){
        this.da_s=da_s;
    }
        
     
    public String getDefectcomment_s(){
        return defectcomment_s;
    }
    
    @XmlElement
    public void setDefectcomment_s(String defectcomment_s){
        this.defectcomment_s=defectcomment_s;
    }
        
     
    public String getDefectlevel_s(){
        return defectlevel_s;
    }
    
    @XmlElement
    public void setDefectlevel_s(String defectlevel_s){
        this.defectlevel_s=defectlevel_s;
    }
        
     
    public String getDefectname_s(){
        return defectname_s;
    }
    
    @XmlElement
    public void setDefectname_s(String defectname_s){
        this.defectname_s=defectname_s;
    }
        
     
    public String getDefectoperator_s(){
        return defectoperator_s;
    }
    
    @XmlElement
    public void setDefectoperator_s(String defectoperator_s){
        this.defectoperator_s=defectoperator_s;
    }
        
     
    public String getDefectsize_s(){
        return defectsize_s;
    }
    
    @XmlElement
    public void setDefectsize_s(String defectsize_s){
        this.defectsize_s=defectsize_s;
    }
        
     
    public String getDefects_s(){
        return defects_s;
    }
    
    @XmlElement
    public void setDefects_s(String defects_s){
        this.defects_s=defects_s;
    }
        
     
    public Date getDefecttime_t(){
        return defecttime_t;
    }
    
    @XmlElement
    public void setDefecttime_t(Date defecttime_t){
        this.defecttime_t=defecttime_t;
    }
        
     
    public String getDrawingprimitive_s(){
        return drawingprimitive_s;
    }
    
    @XmlElement
    public void setDrawingprimitive_s(String drawingprimitive_s){
        this.drawingprimitive_s=drawingprimitive_s;
    }
        
     
    public String getGradecd_s(){
        return gradecd_s;
    }
    
    @XmlElement
    public void setGradecd_s(String gradecd_s){
        this.gradecd_s=gradecd_s;
    }
        
     
    public String getGroupcode_s(){
        return groupcode_s;
    }
    
    @XmlElement
    public void setGroupcode_s(String groupcode_s){
        this.groupcode_s=groupcode_s;
    }
        
     
    public String getGr_s(){
        return gr_s;
    }
    
    @XmlElement
    public void setGr_s(String gr_s){
        this.gr_s=gr_s;
    }
        
     
    public String getIc_s(){
        return ic_s;
    }
    
    @XmlElement
    public void setIc_s(String ic_s){
        this.ic_s=ic_s;
    }
        
     
    public String getItemid_s(){
        return itemid_s;
    }
    
    @XmlElement
    public void setItemid_s(String itemid_s){
        this.itemid_s=itemid_s;
    }
        
     
    public String getItemstate_s(){
        return itemstate_s;
    }
    
    @XmlElement
    public void setItemstate_s(String itemstate_s){
        this.itemstate_s=itemstate_s;
    }
        
     
    public String getLda_s(){
        return lda_s;
    }
    
    @XmlElement
    public void setLda_s(String lda_s){
        this.lda_s=lda_s;
    }
        
     
    public String getLinetime_s(){
        return linetime_s;
    }
    
    @XmlElement
    public void setLinetime_s(String linetime_s){
        this.linetime_s=linetime_s;
    }
        
     
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
     
    public String getMn_s(){
        return mn_s;
    }
    
    @XmlElement
    public void setMn_s(String mn_s){
        this.mn_s=mn_s;
    }
        
     
    public String getNm_s(){
        return nm_s;
    }
    
    @XmlElement
    public void setNm_s(String nm_s){
        this.nm_s=nm_s;
    }
        
     
    public String getOp_s(){
        return op_s;
    }
    
    @XmlElement
    public void setOp_s(String op_s){
        this.op_s=op_s;
    }
        
     
    public String getOriginalheight_s(){
        return originalheight_s;
    }
    
    @XmlElement
    public void setOriginalheight_s(String originalheight_s){
        this.originalheight_s=originalheight_s;
    }
        
     
    public String getOriginalwidth_s(){
        return originalwidth_s;
    }
    
    @XmlElement
    public void setOriginalwidth_s(String originalwidth_s){
        this.originalwidth_s=originalwidth_s;
    }
        
     
    public String getPc_s(){
        return pc_s;
    }
    
    @XmlElement
    public void setPc_s(String pc_s){
        this.pc_s=pc_s;
    }
        
     
    public String getPn_s(){
        return pn_s;
    }
    
    @XmlElement
    public void setPn_s(String pn_s){
        this.pn_s=pn_s;
    }
        
     
    public String getProess_s(){
        return proess_s;
    }
    
    @XmlElement
    public void setProess_s(String proess_s){
        this.proess_s=proess_s;
    }
        
     
    public String getReascdformes_s(){
        return reascdformes_s;
    }
    
    @XmlElement
    public void setReascdformes_s(String reascdformes_s){
        this.reascdformes_s=reascdformes_s;
    }
        
     
    public String getReascd_s(){
        return reascd_s;
    }
    
    @XmlElement
    public void setReascd_s(String reascd_s){
        this.reascd_s=reascd_s;
    }
        
     
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
     
    public String getSizex_s(){
        return sizex_s;
    }
    
    @XmlElement
    public void setSizex_s(String sizex_s){
        this.sizex_s=sizex_s;
    }
        
     
    public String getSizey_s(){
        return sizey_s;
    }
    
    @XmlElement
    public void setSizey_s(String sizey_s){
        this.sizey_s=sizey_s;
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
        
     
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
     
    public String getTi_s(){
        return ti_s;
    }
    
    @XmlElement
    public void setTi_s(String ti_s){
        this.ti_s=ti_s;
    }
        
     
    public String getTyretypecode_s(){
        return tyretypecode_s;
    }
    
    @XmlElement
    public void setTyretypecode_s(String tyretypecode_s){
        this.tyretypecode_s=tyretypecode_s;
    }
        
     
    public String getUserid_s(){
        return userid_s;
    }
    
    @XmlElement
    public void setUserid_s(String userid_s){
        this.userid_s=userid_s;
    }
        
     
    public String getVertorigin_s(){
        return vertorigin_s;
    }
    
    @XmlElement
    public void setVertorigin_s(String vertorigin_s){
        this.vertorigin_s=vertorigin_s;
    }
        
    
    
    
}
