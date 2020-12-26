/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity;

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
 * 硫化参数维护
 * @author 周清玉
 * @Date 2018-08-29 16:00:14
 */
@ATDefinition("C_QM_AUTOJUDGEDATA")
@Entity
@XmlRootElement
@Table(name="AT_C_QM_AUTOJUDGEDATA")
public class AutoJudgeDatas extends RockWellBaseEntity{
    
    
    @Comment("条件地址1")
    @Column(nullable=true,length=160)
    private String address_one_s;
    
    @Comment("条件2")
    @Column(nullable=true,length=160)
    private String address_two_s;
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=160)
    private String agenc_no_s;
    
    @Comment("报警处置代码")
    @Column(nullable=true,length=160)
    private String alarm_deal_code_s;
    
    @Comment("报警处置描述")
    @Column(nullable=true,length=600)
    private String alarm_deal_desc_s;
    
    @Comment("归档标价")
    @Column(nullable=true,length=160)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=160)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=200)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=11)
    private Date created_time_t;
    
    @Comment("初次报警时间")
    @Column(nullable=true,length=11)
    private Date first_recordtime_t;
    
    @Comment("条件1达成时间")
    @Column(nullable=true,length=160)
    private String gettime_one_s;
    
    @Comment("轮胎判级")
    @Column(nullable=true,length=160)
    private String judge_lever_s;
    
    @Comment("检测类型  1、值比较 (测量值与设定值) 2、值差比较（测量值与设定值差）3、两点比较  4、条件比较  ")
    @Column(nullable=true,length=160)
    private String judge_type_s;
    
    @Comment("两点比较下限")
    @Column(nullable=true,length=160)
    private String limit_lower2_s;
    
    @Comment("下限")
    @Column(nullable=true,length=160)
    private String limit_lower_s;
    
    @Comment("两点比较上限")
    @Column(nullable=true,length=160)
    private String limit_upper2_s;
    
    @Comment("上限")
    @Column(nullable=true,length=160)
    private String limit_upper_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String memo_s;
    
    @Comment("OPC检测点描述")
    @Column(nullable=true,length=160)
    private String plc_pointdesc_s;
    
    @Comment("OPC检测点")
    @Column(nullable=true,length=160)
    private String plc_point_s;
    
    @Comment("两点比较检测点1")
    @Column(nullable=true,length=160)
    private String point_one_s;
    
    @Comment("两点比较检测点2")
    @Column(nullable=true,length=160)
    private String point_two_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=160)
    private String record_flag_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=160)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=160)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=160)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=160)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=160)
    private String spare5_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=false,length=160)
    private String s_factory_s;
    
    @Comment("有效延时")
    @Column(nullable=true,length=160)
    private String valid_delay_s;
    
    @Comment("条件值1")
    @Column(nullable=true,length=160)
    private String value_one_s;
    
    @Comment("条件值2")
    @Column(nullable=true,length=160)
    private String value_two_s;
    
    @Comment("零售 RE配套OE")
    @Column(nullable=true,length=80)
    private String isoere_s;
    
    public String getAddress_one_s(){
        return address_one_s;
    }
    
    @XmlElement
    public void setAddress_one_s(String address_one_s){
        this.address_one_s=address_one_s;
    }
        
    public String getAddress_two_s(){
        return address_two_s;
    }
    
    @XmlElement
    public void setAddress_two_s(String address_two_s){
        this.address_two_s=address_two_s;
    }
        
    public String getIsoere_s() {
		return isoere_s;
	}

	public void setIsoere_s(String isoere_s) {
		this.isoere_s = isoere_s;
	}

	public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAlarm_deal_code_s(){
        return alarm_deal_code_s;
    }
    
    @XmlElement
    public void setAlarm_deal_code_s(String alarm_deal_code_s){
        this.alarm_deal_code_s=alarm_deal_code_s;
    }
        
    public String getAlarm_deal_desc_s(){
        return alarm_deal_desc_s;
    }
    
    @XmlElement
    public void setAlarm_deal_desc_s(String alarm_deal_desc_s){
        this.alarm_deal_desc_s=alarm_deal_desc_s;
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
        
    public Date getFirst_recordtime_t(){
        return first_recordtime_t;
    }
    
    @XmlElement
    public void setFirst_recordtime_t(Date first_recordtime_t){
        this.first_recordtime_t=first_recordtime_t;
    }
        
    public String getGettime_one_s(){
        return gettime_one_s;
    }
    
    @XmlElement
    public void setGettime_one_s(String gettime_one_s){
        this.gettime_one_s=gettime_one_s;
    }
        
    public String getJudge_lever_s(){
        return judge_lever_s;
    }
    
    @XmlElement
    public void setJudge_lever_s(String judge_lever_s){
        this.judge_lever_s=judge_lever_s;
    }
        
    public String getJudge_type_s(){
        return judge_type_s;
    }
    
    @XmlElement
    public void setJudge_type_s(String judge_type_s){
        this.judge_type_s=judge_type_s;
    }
        
    public String getLimit_lower2_s(){
        return limit_lower2_s;
    }
    
    @XmlElement
    public void setLimit_lower2_s(String limit_lower2_s){
        this.limit_lower2_s=limit_lower2_s;
    }
        
    public String getLimit_lower_s(){
        return limit_lower_s;
    }
    
    @XmlElement
    public void setLimit_lower_s(String limit_lower_s){
        this.limit_lower_s=limit_lower_s;
    }
        
    public String getLimit_upper2_s(){
        return limit_upper2_s;
    }
    
    @XmlElement
    public void setLimit_upper2_s(String limit_upper2_s){
        this.limit_upper2_s=limit_upper2_s;
    }
        
    public String getLimit_upper_s(){
        return limit_upper_s;
    }
    
    @XmlElement
    public void setLimit_upper_s(String limit_upper_s){
        this.limit_upper_s=limit_upper_s;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getPlc_pointdesc_s(){
        return plc_pointdesc_s;
    }
    
    @XmlElement
    public void setPlc_pointdesc_s(String plc_pointdesc_s){
        this.plc_pointdesc_s=plc_pointdesc_s;
    }
        
    public String getPlc_point_s(){
        return plc_point_s;
    }
    
    @XmlElement
    public void setPlc_point_s(String plc_point_s){
        this.plc_point_s=plc_point_s;
    }
        
    public String getPoint_one_s(){
        return point_one_s;
    }
    
    @XmlElement
    public void setPoint_one_s(String point_one_s){
        this.point_one_s=point_one_s;
    }
        
    public String getPoint_two_s(){
        return point_two_s;
    }
    
    @XmlElement
    public void setPoint_two_s(String point_two_s){
        this.point_two_s=point_two_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
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
        
    public String getValid_delay_s(){
        return valid_delay_s;
    }
    
    @XmlElement
    public void setValid_delay_s(String valid_delay_s){
        this.valid_delay_s=valid_delay_s;
    }
        
    public String getValue_one_s(){
        return value_one_s;
    }
    
    @XmlElement
    public void setValue_one_s(String value_one_s){
        this.value_one_s=value_one_s;
    }
        
    public String getValue_two_s(){
        return value_two_s;
    }
    
    @XmlElement
    public void setValue_two_s(String value_two_s){
        this.value_two_s=value_two_s;
    }
        
    
    
    
}
