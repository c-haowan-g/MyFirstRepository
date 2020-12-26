/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.entity;

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
 * 原材料质量检测
 * @author 李昂
 * @Date 2020-08-13 08:19:06
 */
@ATDefinition("INT_TDM_TESTTASKPUSH")
@Entity
@XmlRootElement
@Table(name="AT_INT_TDM_TESTTASKPUSH")
public class RawQualityAnalysis extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
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
    
    @Comment("任务反馈标记：0-待处理、1-已处理、2-已拒绝")
    @Column(nullable=true,length=80)
    private String data_check_flag_s;
    
    @Comment("备用字段1：DQW检测项名称-气味等级是否合格：0-无DQW检测项，1-合格，2-不合格")
    @Column(nullable=true,length=100)
    private String dummy1_s;
    
    @Comment("备用字段2：物料组名称")
    @Column(nullable=true,length=100)
    private String dummy2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String dummy3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String dummy4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String dummy5_s;
    
    @Comment("最终检测结果")
    @Column(nullable=true,length=80)
    private String finalresult_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("MES业务主键")
    @Column(nullable=true,length=80)
    private String mesbusinesscode_s;
    
    @Comment("是否超期:0-正常状态 1-超期")
    @Column(nullable=true,length=5)
    private String outofdateflag_s;
    
    @Comment("条码：长度15位  条码前九位（物料名）、后六位（厂家）")
    @Column(nullable=true,length=80)
    private String producername_custom_s;
    
    @Comment("条码：长度21位  条码前九位（物料名）、后六位（厂家）")
    @Column(nullable=true,length=80)
    private String producername_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("拒绝原因")
    @Column(nullable=true,length=500)
    private String refusereason_s;
    
    @Comment("拒绝-接收时间")
    @Column(nullable=true,length=0)
    private Date refuse_receive_time_t;
    
    @Comment("结果-接收时间")
    @Column(nullable=true,length=0)
    private Date result_receive_time_t;
    
    @Comment("检测结果：JSON格式")
    @Column(nullable=true,length=2000)
    private String result_s;
    
    @Comment("样品批次：进厂批次")
    @Column(nullable=true,length=80)
    private String samplebatch_s;
    
    @Comment("样品名称")
    @Column(nullable=true,length=80)
    private String samplename_s;
    
    @Comment("SAP号")
    @Column(nullable=true,length=80)
    private String sapcode_s;
    
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
    
    @Comment("MES状态编码： 001001-合格、 001002-不合格、 001003-待检状态 (MES发起的调拨只能调合格的）、 001004-封锁（MES不能调拨出库）")
    @Column(nullable=true,length=80)
    private String state_code_s;
    
    @Comment("进货数量")
    @Column(nullable=true,length=80)
    private String stocknum_s;
    
    @Comment("供应商")
    @Column(nullable=true,length=80)
    private String suppliername_s;
    
   
    
    @Comment("专业组ID 114 技术中心化学组（招远） 115 技术中心物理组（招远） 123 实验中心化学检测室（招远） 124 实验中心半成品实验室（招远） 1101 实验中心化学实验室（柳州） 1102 实验中心半成品实验室（柳州）")
    @Column(nullable=true,length=80)
    private String tdmgroupid_s;
    
    @Comment("厂家批次")
    @Column(nullable=true,length=80)
    private String venderbatch_s;
    
    @Comment("分项结论")
    @Column(nullable=true,length=80)
    private String sub_conclusion_d;
    
    @Comment("检测项目")
    @Column(nullable=true,length=80)
    private String test_items_d;
    
    @Comment("检测参数")
    @Column(nullable=true,length=80)
    private String test_paras_d;
    
    @Comment("检测方法")
    @Column(nullable=true,length=80)
    private String test_method_d;
    
    @Comment("检测结果")
    @Column(nullable=true,length=80)
    private String test_result_d;
    
    @Comment("执行标准")
    @Column(nullable=true,length=80)
    private String executive_standard_d;
    
    @Comment("条件名称")
    @Column(nullable=true,length=80)
    private String executive_name_d;
    
    @Comment("条件单位")
    @Column(nullable=true,length=80)
    private String executive_unit_d;
    
    @Comment("条件要求值")
    @Column(nullable=true,length=80)
    private String executive_reqvalue_d;
    
    @Comment("条件实际值")
    @Column(nullable=true,length=80)
    private String executive_actualvalue_d;
    
    @Comment("判定范围")
    @Column(nullable=true,length=80)
    private String decisionscope_d;
    
    @Comment("送检日期")
    @Column(nullable=true,length=0)
    private Date receive_time_d;
    
    
    public String getTest_items_d() {
		return test_items_d;
	}

	public void setTest_items_d(String test_items_d) {
		this.test_items_d = test_items_d;
	}

	public String getTest_paras_d() {
		return test_paras_d;
	}

	public void setTest_paras_d(String test_paras_d) {
		this.test_paras_d = test_paras_d;
	}

	public String getTest_method_d() {
		return test_method_d;
	}

	public void setTest_method_d(String test_method_d) {
		this.test_method_d = test_method_d;
	}

	public String getTest_result_d() {
		return test_result_d;
	}

	public void setTest_result_d(String test_result_d) {
		this.test_result_d = test_result_d;
	}

	public String getExecutive_standard_d() {
		return executive_standard_d;
	}

	public void setExecutive_standard_d(String executive_standard_d) {
		this.executive_standard_d = executive_standard_d;
	}

	public String getExecutive_name_d() {
		return executive_name_d;
	}

	public void setExecutive_name_d(String executive_name_d) {
		this.executive_name_d = executive_name_d;
	}

	public String getExecutive_unit_d() {
		return executive_unit_d;
	}

	public void setExecutive_unit_d(String executive_unit_d) {
		this.executive_unit_d = executive_unit_d;
	}

	public String getExecutive_reqvalue_d() {
		return executive_reqvalue_d;
	}

	public void setExecutive_reqvalue_d(String executive_reqvalue_d) {
		this.executive_reqvalue_d = executive_reqvalue_d;
	}

	public String getExecutive_actualvalue_d() {
		return executive_actualvalue_d;
	}

	public void setExecutive_actualvalue_d(String executive_actualvalue_d) {
		this.executive_actualvalue_d = executive_actualvalue_d;
	}

	public String getDecisionscope_d() {
		return decisionscope_d;
	}

	public void setDecisionscope_d(String decisionscope_d) {
		this.decisionscope_d = decisionscope_d;
	}

	public Date getReceive_time_d() {
		return receive_time_d;
	}

	public void setReceive_time_d(Date receive_time_d) {
		this.receive_time_d = receive_time_d;
	}

	public String getSub_conclusion_d() {
		return sub_conclusion_d;
	}

	public String getsub_conclusion_d(){
        return sub_conclusion_d;
    }
    
    @XmlElement
    public void setSub_conclusion_d(String sub_conclusion_d){
        this.sub_conclusion_d=sub_conclusion_d;
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
        
    public String getData_check_flag_s(){
        return data_check_flag_s;
    }
    
    @XmlElement
    public void setData_check_flag_s(String data_check_flag_s){
        this.data_check_flag_s=data_check_flag_s;
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
        
    public String getFinalresult_s(){
        return finalresult_s;
    }
    
    @XmlElement
    public void setFinalresult_s(String finalresult_s){
        this.finalresult_s=finalresult_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getMesbusinesscode_s(){
        return mesbusinesscode_s;
    }
    
    @XmlElement
    public void setMesbusinesscode_s(String mesbusinesscode_s){
        this.mesbusinesscode_s=mesbusinesscode_s;
    }
        
    public String getOutofdateflag_s(){
        return outofdateflag_s;
    }
    
    @XmlElement
    public void setOutofdateflag_s(String outofdateflag_s){
        this.outofdateflag_s=outofdateflag_s;
    }
        
    public String getProducername_custom_s(){
        return producername_custom_s;
    }
    
    @XmlElement
    public void setProducername_custom_s(String producername_custom_s){
        this.producername_custom_s=producername_custom_s;
    }
        
    public String getProducername_s(){
        return producername_s;
    }
    
    @XmlElement
    public void setProducername_s(String producername_s){
        this.producername_s=producername_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRefusereason_s(){
        return refusereason_s;
    }
    
    @XmlElement
    public void setRefusereason_s(String refusereason_s){
        this.refusereason_s=refusereason_s;
    }
        
    public Date getRefuse_receive_time_t(){
        return refuse_receive_time_t;
    }
    
    @XmlElement
    public void setRefuse_receive_time_t(Date refuse_receive_time_t){
        this.refuse_receive_time_t=refuse_receive_time_t;
    }
        
    public Date getResult_receive_time_t(){
        return result_receive_time_t;
    }
    
    @XmlElement
    public void setResult_receive_time_t(Date result_receive_time_t){
        this.result_receive_time_t=result_receive_time_t;
    }
        
    public String getResult_s(){
        return result_s;
    }
    
    @XmlElement
    public void setResult_s(String result_s){
        this.result_s=result_s;
    }
        
    public String getSamplebatch_s(){
        return samplebatch_s;
    }
    
    @XmlElement
    public void setSamplebatch_s(String samplebatch_s){
        this.samplebatch_s=samplebatch_s;
    }
        
    public String getSamplename_s(){
        return samplename_s;
    }
    
    @XmlElement
    public void setSamplename_s(String samplename_s){
        this.samplename_s=samplename_s;
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
        
    public String getState_code_s(){
        return state_code_s;
    }
    
    @XmlElement
    public void setState_code_s(String state_code_s){
        this.state_code_s=state_code_s;
    }
        
    public String getStocknum_s(){
        return stocknum_s;
    }
    
    @XmlElement
    public void setStocknum_s(String stocknum_s){
        this.stocknum_s=stocknum_s;
    }
        
    public String getSuppliername_s(){
        return suppliername_s;
    }
    
    @XmlElement
    public void setSuppliername_s(String suppliername_s){
        this.suppliername_s=suppliername_s;
    }
        
   
    
  
    public String getTdmgroupid_s(){
        return tdmgroupid_s;
    }
    
    @XmlElement
    public void setTdmgroupid_s(String tdmgroupid_s){
        this.tdmgroupid_s=tdmgroupid_s;
    }
        
    public String getVenderbatch_s(){
        return venderbatch_s;
    }
    
    @XmlElement
    public void setVenderbatch_s(String venderbatch_s){
        this.venderbatch_s=venderbatch_s;
    }
        
    
    
    
}
