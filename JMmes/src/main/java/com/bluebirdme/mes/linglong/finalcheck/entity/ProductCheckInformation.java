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
 * 成品质检信息
 * @author 司乔靖
 * @Date 2019-02-10 13:37:36
 */
@ATDefinition("C_MM_MAINTYRE")
@Entity
@XmlRootElement
@Table(name="AT_C_MM_MAINTYRE")
public class ProductCheckInformation extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远8000；德州8002柳州8003泰国8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MainTyre.BARCODE")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("气泡病象编号：D_BS_Reas.REAS_CODE")
    @Column(nullable=true,length=10)
    private String blistercode_s;
    
    @Comment("气泡检查次数")
    @Column(nullable=true,length=0)
    private Integer blistercount_i;
    
    @Comment("气泡质量等级")
    @Column(nullable=true,length=80)
    private String blistergradecode_s;
    
    @Comment("气泡设备条码")
    @Column(nullable=true,length=20)
    private String blistermbarcode_s;
    
    @Comment("气泡通过时间")
    @Column(nullable=true,length=0)
    private Date blisterpasstime_t;
    
    @Comment("气泡质检员工号")
    @Column(nullable=true,length=10)
    private String blisteruserid_s;
    
    @Comment("成型换规首条确认标记：0-否，1-是")
    @Column(nullable=true,length=80)
    private String buildingfirstflag_s;
    
    @Comment("成型质量等级编码")
    @Column(nullable=true,length=80)
    private String buildingradecode_s;
    
    @Comment("成型物料编码")
    @Column(nullable=true,length=80)
    private String buildingspeccode_s;
    
    @Comment("成型作业ID")
    @Column(nullable=true,length=80)
    private String buildingtaskid_s;
    
    @Comment("成型生产时间")
    @Column(nullable=true,length=0)
    private Date buildingtime_t;
    
    @Comment("成型机台")
    @Column(nullable=true,length=80)
    private String buildinmachinecode_s;
    
    @Comment("物流装笼笼号")
    @Column(nullable=true,length=80)
    private String cagenumber_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("硫化合模时间")
    @Column(nullable=true,length=0)
    private Date curingclosemouldtime_t;
    
    @Comment("硫化换模首条确认标记：0-否，1-是")
    @Column(nullable=true,length=80)
    private String curingfirstflag_s;
    
    @Comment("硫化质量等级")
    @Column(nullable=true,length=80)
    private String curinggradecode_s;
    
    @Comment("硫化机台")
    @Column(nullable=true,length=80)
    private String curingmachinecode_s;
    
    @Comment("硫化开模时间")
    @Column(nullable=true,length=0)
    private Date curingopenmouldtime_t;
    
    @Comment("硫化物料编码")
    @Column(nullable=true,length=80)
    private String curingspeccode_s;
    
    @Comment("外胎延时硫化标记，1为延时硫化，其余为空")
    @Column(nullable=true,length=80)
    private String curingtimedelay_s;
    
    @Comment("硫化员工号")
    @Column(nullable=true,length=10)
    private String curinguserid_s;
    
    @Comment("疑问胎标记：1标记")
    @Column(nullable=true,length=80)
    private String doubtflag_s;
    
    @Comment("动平衡检查次数")
    @Column(nullable=true,length=0)
    private Integer dynamicbalancecount_i;
    
    @Comment("动平衡质量等级")
    @Column(nullable=true,length=80)
    private String dynamicbalancegradecode_s;
    
    @Comment("动平衡配方号")
    @Column(nullable=true,length=0)
    private Integer dynamicbalanceindex_i;
    
    @Comment("动平衡机条码")
    @Column(nullable=true,length=20)
    private String dynamicbalancembarcode_s;
    
    @Comment("动平衡通过时间")
    @Column(nullable=true,length=0)
    private Date dynamicbalancepasstime_t;
    
    @Comment("动平衡病象编号：D_BS_Reas.REAS_CODE")
    @Column(nullable=true,length=10)
    private String dynamicbalancereascode_s;
    
    @Comment("动平衡质检员工号")
    @Column(nullable=true,length=10)
    private String dynamicbalanceuserid_s;
    
    @Comment("质量等级编码")
    @Column(nullable=true,length=80)
    private String gradecode_s;
    
    @Comment("轮胎毛重量")
    @Column(nullable=true,length=0)
    private Integer grossweight_i;
    
    @Comment("割毛次数")
    @Column(nullable=true,length=0)
    private Integer hairscount_i;
    
    @Comment("割毛质量等级")
    @Column(nullable=true,length=80)
    private String hairsgradecode_s;
    
    @Comment("割毛操作时间")
    @Column(nullable=true,length=0)
    private Date hairspasstime_t;
    
    @Comment("物流推送-推送次数")
    @Column(nullable=true,length=0)
    private Integer handcount_i;
    
    @Comment("物流推送-推送标记：0-未推送，1-已推送")
    @Column(nullable=true,length=80)
    private String handflag_s;
    
    @Comment("镂空条码")
    @Column(nullable=true,length=80)
    private String hollowedbarcode_s;
    
    @Comment("跟踪胎标识：1跟踪")
    @Column(nullable=true,length=80)
    private String integratedcode_s;
    
    @Comment("是否复检：0未复检、1已复检过")
    @Column(nullable=true,length=80)
    private String isrck_s;
    
    @Comment("当前工序")
    @Column(nullable=true,length=80)
    private String proess_s;
    
    @Comment("病象编号：D_BS_Reas.REAS_CODE")
    @Column(nullable=true,length=80)
    private String reascode_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("物流推送-错误消息（处理成功是返回空）")
    @Column(nullable=true,length=383)
    private String returnmsg_s;
    
    @Comment("物流推送-返回处理结果状态(S:处理成功，E:处理失败，U:处理异常)")
    @Column(nullable=true,length=80)
    private String returnstatus_s;
    
    @Comment("销售方式：0-内销、1-外销")
    @Column(nullable=true,length=80)
    private String saletype_s;
    
    @Comment("内经")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("外径")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("截面高")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("硫化月计划号")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("子口宽")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("轮胎状态编码：0-待检、1-合格、2-不合格")
    @Column(nullable=true,length=80)
    private String statecode_s;
    
    @Comment("工厂（1全钢2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("预入库胎抽检扫描时间")
    @Column(nullable=true,length=0)
    private Date tackchecktime_t;
    
    @Comment("预入库胎抽检扫描人ID")
    @Column(nullable=true,length=80)
    private String tackcheckuserid_s;
    
    @Comment("总返修次数")
    @Column(nullable=true,length=0)
    private Integer totalreworknum_i;
    
    @Comment("轮胎去向标识：1-返修、2-割毛")
    @Column(nullable=true,length=80)
    private String trackdirection_s;
    
    @Comment("均匀度检查次数")
    @Column(nullable=true,length=0)
    private Integer uniformitycount_i;
    
    @Comment("均匀度质量等级")
    @Column(nullable=true,length=80)
    private String uniformitygradecode_s;
    
    @Comment("均匀度配方号")
    @Column(nullable=true,length=0)
    private Integer uniformityindex_i;
    
    @Comment("均匀度设备条码")
    @Column(nullable=true,length=20)
    private String uniformitymbarcode_s;
    
    @Comment("均匀度通过时间")
    @Column(nullable=true,length=0)
    private Date uniformitypasstime_t;
    
    @Comment("均匀度病象编号：D_BS_Reas.REAS_CODE")
    @Column(nullable=true,length=10)
    private String uniformityreascode_s;
    
    @Comment("均匀度质检员工号")
    @Column(nullable=true,length=10)
    private String uniformityuserid_s;
    
    @Comment("外胎检查次数")
    @Column(nullable=true,length=0)
    private Integer visualcount_i;
    
    @Comment("外胎重检一次操作时间")
    @Column(nullable=true,length=80)
    private String visuald1_s;
    
    @Comment("外胎重检二次操作时间")
    @Column(nullable=true,length=80)
    private String visuald3_s;
    
    @Comment("外胎质量等级")
    @Column(nullable=true,length=80)
    private String visualgradecode_s;
    
    @Comment("外胎重检一次检测工位")
    @Column(nullable=true,length=20)
    private String visualmbarcode1_s;
    
    @Comment("外胎重检一次检测工位")
    @Column(nullable=true,length=20)
    private String visualmbarcode2_s;
    
    @Comment("外胎操作时间")
    @Column(nullable=true,length=0)
    private Date visualpasstime_t;
    
    @Comment("外胎重检一次次扫描人ID")
    @Column(nullable=true,length=80)
    private String visualuserid1_s;
    
    @Comment("外胎重检二次扫描人ID")
    @Column(nullable=true,length=80)
    private String visualuserid2_s;
    
    @Comment("年周号")
    @Column(nullable=true,length=80)
    private String weeklynumber_s;
    
    @Comment("X光检查次数")
    @Column(nullable=true,length=0)
    private Integer xlightcount_i;
    
    @Comment("X光质量等级")
    @Column(nullable=true,length=80)
    private String xlightgradecode_s;
    
    @Comment("X光配方号")
    @Column(nullable=true,length=0)
    private Integer xlightindex_i;
    
    @Comment("X光机条码")
    @Column(nullable=true,length=20)
    private String xlightmbarcode_s;
    
    @Comment("X光通过时间")
    @Column(nullable=true,length=0)
    private Date xlightpasstime_t;
    
    @Comment("X光病象编号：D_BS_Reas.REAS_CODE")
    @Column(nullable=true,length=10)
    private String xlightreascode_s;
    
    @Comment("X光质检员工号")
    @Column(nullable=true,length=10)
    private String xlightuserid_s;
    
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
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getBlistercode_s(){
        return blistercode_s;
    }
    
    @XmlElement
    public void setBlistercode_s(String blistercode_s){
        this.blistercode_s=blistercode_s;
    }
        
    public Integer getBlistercount_i(){
        return blistercount_i;
    }
    
    @XmlElement
    public void setBlistercount_i(Integer blistercount_i){
        this.blistercount_i=blistercount_i;
    }
        
    public String getBlistergradecode_s(){
        return blistergradecode_s;
    }
    
    @XmlElement
    public void setBlistergradecode_s(String blistergradecode_s){
        this.blistergradecode_s=blistergradecode_s;
    }
        
    public String getBlistermbarcode_s(){
        return blistermbarcode_s;
    }
    
    @XmlElement
    public void setBlistermbarcode_s(String blistermbarcode_s){
        this.blistermbarcode_s=blistermbarcode_s;
    }
        
    public Date getBlisterpasstime_t(){
        return blisterpasstime_t;
    }
    
    @XmlElement
    public void setBlisterpasstime_t(Date blisterpasstime_t){
        this.blisterpasstime_t=blisterpasstime_t;
    }
        
    public String getBlisteruserid_s(){
        return blisteruserid_s;
    }
    
    @XmlElement
    public void setBlisteruserid_s(String blisteruserid_s){
        this.blisteruserid_s=blisteruserid_s;
    }
        
    public String getBuildingfirstflag_s(){
        return buildingfirstflag_s;
    }
    
    @XmlElement
    public void setBuildingfirstflag_s(String buildingfirstflag_s){
        this.buildingfirstflag_s=buildingfirstflag_s;
    }
        
    public String getBuildingradecode_s(){
        return buildingradecode_s;
    }
    
    @XmlElement
    public void setBuildingradecode_s(String buildingradecode_s){
        this.buildingradecode_s=buildingradecode_s;
    }
        
    public String getBuildingspeccode_s(){
        return buildingspeccode_s;
    }
    
    @XmlElement
    public void setBuildingspeccode_s(String buildingspeccode_s){
        this.buildingspeccode_s=buildingspeccode_s;
    }
        
    public String getBuildingtaskid_s(){
        return buildingtaskid_s;
    }
    
    @XmlElement
    public void setBuildingtaskid_s(String buildingtaskid_s){
        this.buildingtaskid_s=buildingtaskid_s;
    }
        
    public Date getBuildingtime_t(){
        return buildingtime_t;
    }
    
    @XmlElement
    public void setBuildingtime_t(Date buildingtime_t){
        this.buildingtime_t=buildingtime_t;
    }
        
    public String getBuildinmachinecode_s(){
        return buildinmachinecode_s;
    }
    
    @XmlElement
    public void setBuildinmachinecode_s(String buildinmachinecode_s){
        this.buildinmachinecode_s=buildinmachinecode_s;
    }
        
    public String getCagenumber_s(){
        return cagenumber_s;
    }
    
    @XmlElement
    public void setCagenumber_s(String cagenumber_s){
        this.cagenumber_s=cagenumber_s;
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
        
    public Date getCuringclosemouldtime_t(){
        return curingclosemouldtime_t;
    }
    
    @XmlElement
    public void setCuringclosemouldtime_t(Date curingclosemouldtime_t){
        this.curingclosemouldtime_t=curingclosemouldtime_t;
    }
        
    public String getCuringfirstflag_s(){
        return curingfirstflag_s;
    }
    
    @XmlElement
    public void setCuringfirstflag_s(String curingfirstflag_s){
        this.curingfirstflag_s=curingfirstflag_s;
    }
        
    public String getCuringgradecode_s(){
        return curinggradecode_s;
    }
    
    @XmlElement
    public void setCuringgradecode_s(String curinggradecode_s){
        this.curinggradecode_s=curinggradecode_s;
    }
        
    public String getCuringmachinecode_s(){
        return curingmachinecode_s;
    }
    
    @XmlElement
    public void setCuringmachinecode_s(String curingmachinecode_s){
        this.curingmachinecode_s=curingmachinecode_s;
    }
        
    public Date getCuringopenmouldtime_t(){
        return curingopenmouldtime_t;
    }
    
    @XmlElement
    public void setCuringopenmouldtime_t(Date curingopenmouldtime_t){
        this.curingopenmouldtime_t=curingopenmouldtime_t;
    }
        
    public String getCuringspeccode_s(){
        return curingspeccode_s;
    }
    
    @XmlElement
    public void setCuringspeccode_s(String curingspeccode_s){
        this.curingspeccode_s=curingspeccode_s;
    }
        
    public String getCuringtimedelay_s(){
        return curingtimedelay_s;
    }
    
    @XmlElement
    public void setCuringtimedelay_s(String curingtimedelay_s){
        this.curingtimedelay_s=curingtimedelay_s;
    }
        
    public String getCuringuserid_s(){
        return curinguserid_s;
    }
    
    @XmlElement
    public void setCuringuserid_s(String curinguserid_s){
        this.curinguserid_s=curinguserid_s;
    }
        
    public String getDoubtflag_s(){
        return doubtflag_s;
    }
    
    @XmlElement
    public void setDoubtflag_s(String doubtflag_s){
        this.doubtflag_s=doubtflag_s;
    }
        
    public Integer getDynamicbalancecount_i(){
        return dynamicbalancecount_i;
    }
    
    @XmlElement
    public void setDynamicbalancecount_i(Integer dynamicbalancecount_i){
        this.dynamicbalancecount_i=dynamicbalancecount_i;
    }
        
    public String getDynamicbalancegradecode_s(){
        return dynamicbalancegradecode_s;
    }
    
    @XmlElement
    public void setDynamicbalancegradecode_s(String dynamicbalancegradecode_s){
        this.dynamicbalancegradecode_s=dynamicbalancegradecode_s;
    }
        
    public Integer getDynamicbalanceindex_i(){
        return dynamicbalanceindex_i;
    }
    
    @XmlElement
    public void setDynamicbalanceindex_i(Integer dynamicbalanceindex_i){
        this.dynamicbalanceindex_i=dynamicbalanceindex_i;
    }
        
    public String getDynamicbalancembarcode_s(){
        return dynamicbalancembarcode_s;
    }
    
    @XmlElement
    public void setDynamicbalancembarcode_s(String dynamicbalancembarcode_s){
        this.dynamicbalancembarcode_s=dynamicbalancembarcode_s;
    }
        
    public Date getDynamicbalancepasstime_t(){
        return dynamicbalancepasstime_t;
    }
    
    @XmlElement
    public void setDynamicbalancepasstime_t(Date dynamicbalancepasstime_t){
        this.dynamicbalancepasstime_t=dynamicbalancepasstime_t;
    }
        
    public String getDynamicbalancereascode_s(){
        return dynamicbalancereascode_s;
    }
    
    @XmlElement
    public void setDynamicbalancereascode_s(String dynamicbalancereascode_s){
        this.dynamicbalancereascode_s=dynamicbalancereascode_s;
    }
        
    public String getDynamicbalanceuserid_s(){
        return dynamicbalanceuserid_s;
    }
    
    @XmlElement
    public void setDynamicbalanceuserid_s(String dynamicbalanceuserid_s){
        this.dynamicbalanceuserid_s=dynamicbalanceuserid_s;
    }
        
    public String getGradecode_s(){
        return gradecode_s;
    }
    
    @XmlElement
    public void setGradecode_s(String gradecode_s){
        this.gradecode_s=gradecode_s;
    }
        
    public Integer getGrossweight_i(){
        return grossweight_i;
    }
    
    @XmlElement
    public void setGrossweight_i(Integer grossweight_i){
        this.grossweight_i=grossweight_i;
    }
        
    public Integer getHairscount_i(){
        return hairscount_i;
    }
    
    @XmlElement
    public void setHairscount_i(Integer hairscount_i){
        this.hairscount_i=hairscount_i;
    }
        
    public String getHairsgradecode_s(){
        return hairsgradecode_s;
    }
    
    @XmlElement
    public void setHairsgradecode_s(String hairsgradecode_s){
        this.hairsgradecode_s=hairsgradecode_s;
    }
        
    public Date getHairspasstime_t(){
        return hairspasstime_t;
    }
    
    @XmlElement
    public void setHairspasstime_t(Date hairspasstime_t){
        this.hairspasstime_t=hairspasstime_t;
    }
        
    public Integer getHandcount_i(){
        return handcount_i;
    }
    
    @XmlElement
    public void setHandcount_i(Integer handcount_i){
        this.handcount_i=handcount_i;
    }
        
    public String getHandflag_s(){
        return handflag_s;
    }
    
    @XmlElement
    public void setHandflag_s(String handflag_s){
        this.handflag_s=handflag_s;
    }
        
    public String getHollowedbarcode_s(){
        return hollowedbarcode_s;
    }
    
    @XmlElement
    public void setHollowedbarcode_s(String hollowedbarcode_s){
        this.hollowedbarcode_s=hollowedbarcode_s;
    }
        
    public String getIntegratedcode_s(){
        return integratedcode_s;
    }
    
    @XmlElement
    public void setIntegratedcode_s(String integratedcode_s){
        this.integratedcode_s=integratedcode_s;
    }
        
    public String getIsrck_s(){
        return isrck_s;
    }
    
    @XmlElement
    public void setIsrck_s(String isrck_s){
        this.isrck_s=isrck_s;
    }
        
    public String getProess_s(){
        return proess_s;
    }
    
    @XmlElement
    public void setProess_s(String proess_s){
        this.proess_s=proess_s;
    }
        
    public String getReascode_s(){
        return reascode_s;
    }
    
    @XmlElement
    public void setReascode_s(String reascode_s){
        this.reascode_s=reascode_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getReturnmsg_s(){
        return returnmsg_s;
    }
    
    @XmlElement
    public void setReturnmsg_s(String returnmsg_s){
        this.returnmsg_s=returnmsg_s;
    }
        
    public String getReturnstatus_s(){
        return returnstatus_s;
    }
    
    @XmlElement
    public void setReturnstatus_s(String returnstatus_s){
        this.returnstatus_s=returnstatus_s;
    }
        
    public String getSaletype_s(){
        return saletype_s;
    }
    
    @XmlElement
    public void setSaletype_s(String saletype_s){
        this.saletype_s=saletype_s;
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
        
    public String getStatecode_s(){
        return statecode_s;
    }
    
    @XmlElement
    public void setStatecode_s(String statecode_s){
        this.statecode_s=statecode_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public Date getTackchecktime_t(){
        return tackchecktime_t;
    }
    
    @XmlElement
    public void setTackchecktime_t(Date tackchecktime_t){
        this.tackchecktime_t=tackchecktime_t;
    }
        
    public String getTackcheckuserid_s(){
        return tackcheckuserid_s;
    }
    
    @XmlElement
    public void setTackcheckuserid_s(String tackcheckuserid_s){
        this.tackcheckuserid_s=tackcheckuserid_s;
    }
        
    public Integer getTotalreworknum_i(){
        return totalreworknum_i;
    }
    
    @XmlElement
    public void setTotalreworknum_i(Integer totalreworknum_i){
        this.totalreworknum_i=totalreworknum_i;
    }
        
    public String getTrackdirection_s(){
        return trackdirection_s;
    }
    
    @XmlElement
    public void setTrackdirection_s(String trackdirection_s){
        this.trackdirection_s=trackdirection_s;
    }
        
    public Integer getUniformitycount_i(){
        return uniformitycount_i;
    }
    
    @XmlElement
    public void setUniformitycount_i(Integer uniformitycount_i){
        this.uniformitycount_i=uniformitycount_i;
    }
        
    public String getUniformitygradecode_s(){
        return uniformitygradecode_s;
    }
    
    @XmlElement
    public void setUniformitygradecode_s(String uniformitygradecode_s){
        this.uniformitygradecode_s=uniformitygradecode_s;
    }
        
    public Integer getUniformityindex_i(){
        return uniformityindex_i;
    }
    
    @XmlElement
    public void setUniformityindex_i(Integer uniformityindex_i){
        this.uniformityindex_i=uniformityindex_i;
    }
        
    public String getUniformitymbarcode_s(){
        return uniformitymbarcode_s;
    }
    
    @XmlElement
    public void setUniformitymbarcode_s(String uniformitymbarcode_s){
        this.uniformitymbarcode_s=uniformitymbarcode_s;
    }
        
    public Date getUniformitypasstime_t(){
        return uniformitypasstime_t;
    }
    
    @XmlElement
    public void setUniformitypasstime_t(Date uniformitypasstime_t){
        this.uniformitypasstime_t=uniformitypasstime_t;
    }
        
    public String getUniformityreascode_s(){
        return uniformityreascode_s;
    }
    
    @XmlElement
    public void setUniformityreascode_s(String uniformityreascode_s){
        this.uniformityreascode_s=uniformityreascode_s;
    }
        
    public String getUniformityuserid_s(){
        return uniformityuserid_s;
    }
    
    @XmlElement
    public void setUniformityuserid_s(String uniformityuserid_s){
        this.uniformityuserid_s=uniformityuserid_s;
    }
        
    public Integer getVisualcount_i(){
        return visualcount_i;
    }
    
    @XmlElement
    public void setVisualcount_i(Integer visualcount_i){
        this.visualcount_i=visualcount_i;
    }
        
    public String getVisuald1_s(){
        return visuald1_s;
    }
    
    @XmlElement
    public void setVisuald1_s(String visuald1_s){
        this.visuald1_s=visuald1_s;
    }
        
    public String getVisuald3_s(){
        return visuald3_s;
    }
    
    @XmlElement
    public void setVisuald3_s(String visuald3_s){
        this.visuald3_s=visuald3_s;
    }
        
    public String getVisualgradecode_s(){
        return visualgradecode_s;
    }
    
    @XmlElement
    public void setVisualgradecode_s(String visualgradecode_s){
        this.visualgradecode_s=visualgradecode_s;
    }
        
    public String getVisualmbarcode1_s(){
        return visualmbarcode1_s;
    }
    
    @XmlElement
    public void setVisualmbarcode1_s(String visualmbarcode1_s){
        this.visualmbarcode1_s=visualmbarcode1_s;
    }
        
    public String getVisualmbarcode2_s(){
        return visualmbarcode2_s;
    }
    
    @XmlElement
    public void setVisualmbarcode2_s(String visualmbarcode2_s){
        this.visualmbarcode2_s=visualmbarcode2_s;
    }
        
    public Date getVisualpasstime_t(){
        return visualpasstime_t;
    }
    
    @XmlElement
    public void setVisualpasstime_t(Date visualpasstime_t){
        this.visualpasstime_t=visualpasstime_t;
    }
        
    public String getVisualuserid1_s(){
        return visualuserid1_s;
    }
    
    @XmlElement
    public void setVisualuserid1_s(String visualuserid1_s){
        this.visualuserid1_s=visualuserid1_s;
    }
        
    public String getVisualuserid2_s(){
        return visualuserid2_s;
    }
    
    @XmlElement
    public void setVisualuserid2_s(String visualuserid2_s){
        this.visualuserid2_s=visualuserid2_s;
    }
        
    public String getWeeklynumber_s(){
        return weeklynumber_s;
    }
    
    @XmlElement
    public void setWeeklynumber_s(String weeklynumber_s){
        this.weeklynumber_s=weeklynumber_s;
    }
        
    public Integer getXlightcount_i(){
        return xlightcount_i;
    }
    
    @XmlElement
    public void setXlightcount_i(Integer xlightcount_i){
        this.xlightcount_i=xlightcount_i;
    }
        
    public String getXlightgradecode_s(){
        return xlightgradecode_s;
    }
    
    @XmlElement
    public void setXlightgradecode_s(String xlightgradecode_s){
        this.xlightgradecode_s=xlightgradecode_s;
    }
        
    public Integer getXlightindex_i(){
        return xlightindex_i;
    }
    
    @XmlElement
    public void setXlightindex_i(Integer xlightindex_i){
        this.xlightindex_i=xlightindex_i;
    }
        
    public String getXlightmbarcode_s(){
        return xlightmbarcode_s;
    }
    
    @XmlElement
    public void setXlightmbarcode_s(String xlightmbarcode_s){
        this.xlightmbarcode_s=xlightmbarcode_s;
    }
        
    public Date getXlightpasstime_t(){
        return xlightpasstime_t;
    }
    
    @XmlElement
    public void setXlightpasstime_t(Date xlightpasstime_t){
        this.xlightpasstime_t=xlightpasstime_t;
    }
        
    public String getXlightreascode_s(){
        return xlightreascode_s;
    }
    
    @XmlElement
    public void setXlightreascode_s(String xlightreascode_s){
        this.xlightreascode_s=xlightreascode_s;
    }
        
    public String getXlightuserid_s(){
        return xlightuserid_s;
    }
    
    @XmlElement
    public void setXlightuserid_s(String xlightuserid_s){
        this.xlightuserid_s=xlightuserid_s;
    }
        
    
    
    
}
