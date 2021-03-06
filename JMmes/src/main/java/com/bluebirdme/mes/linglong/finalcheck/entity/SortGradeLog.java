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
 * 质检分检等级规则表(终检蓝英接口同步履历)
 * @author 司乔靖
 * @Date 2018-11-28 13:33:09
 */
@ATDefinition("D_BS_SORTGRADE_LOG")
@Entity
@XmlRootElement
@Table(name="AT_D_BS_SORTGRADE_LOG")
public class SortGradeLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=20)
    private String arch_flag_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=20)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=20)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("D_ZJ_Ent 表 ID")
    @Column(nullable=true,length=80)
    private String entbarcode_s;
    
    @Comment("质量等级编码")
    @Column(nullable=true,length=0)
    private String gradecd_i;
    
    @Comment("质量等级描述")
    @Column(nullable=true,length=120)
    private String gradedesc_s;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("下工序处理：0-不允许，1-允许")
    @Column(nullable=true,length=0)
    private Integer ischeck_i;
    
    @Comment("工序描述")
    @Column(nullable=true,length=120)
    private String proessdesc_s;
    
    @Comment("工序")
    @Column(nullable=true,length=0)
    private String proess_i;
    
    @Comment("记录标志，A当前可检，D历史可检")
    @Column(nullable=true,length=20)
    private String record_flag_s;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=20)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=20)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=20)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=20)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=20)
    private String spare5_s;
    
    @Comment("分拣点描述")
    @Column(nullable=true,length=120)
    private String stationdesc_s;
    
    @Comment("分拣点：0-割毛前、1-外观前、4-动均前、5-入库前")
    @Column(nullable=true,length=0)
    private String station_i;
    
    @Comment("数据同步创建时间")
    @Column(nullable=true,length=0)
    private Date sync_create_time_t;
    
    @Comment("数据同步处理：A-新增、U-修改、D-删除")
    @Column(nullable=true,length=80)
    private String sync_flag_s;
    
    @Comment("数据同步处理标记：0-未处理、1-已处理")
    @Column(nullable=true,length=80)
    private String sync_hand_flag_s;
    
    @Comment("数据同步处理反馈")
    @Column(nullable=true,length=200)
    private String sync_hand_msg_s;
    
    @Comment("数据同步处理时间")
    @Column(nullable=true,length=0)
    private Date sync_hand_time_t;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=true,length=20)
    private String s_factory_s;
    
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
        
    public String getEntbarcode_s(){
        return entbarcode_s;
    }
    
    @XmlElement
    public void setEntbarcode_s(String entbarcode_s){
        this.entbarcode_s=entbarcode_s;
    }
        
   
        
    public String getGradecd_i() {
		return gradecd_i;
	}

	public void setGradecd_i(String gradecd_i) {
		this.gradecd_i = gradecd_i;
	}

	public String getGradedesc_s(){
        return gradedesc_s;
    }
    
    @XmlElement
    public void setGradedesc_s(String gradedesc_s){
        this.gradedesc_s=gradedesc_s;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public Integer getIscheck_i(){
        return ischeck_i;
    }
    
    @XmlElement
    public void setIscheck_i(Integer ischeck_i){
        this.ischeck_i=ischeck_i;
    }
        
    public String getProessdesc_s(){
        return proessdesc_s;
    }
    
    @XmlElement
    public void setProessdesc_s(String proessdesc_s){
        this.proessdesc_s=proessdesc_s;
    }
        
  
        
    public String getProess_i() {
		return proess_i;
	}

	public void setProess_i(String proess_i) {
		this.proess_i = proess_i;
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
        
    public String getStationdesc_s(){
        return stationdesc_s;
    }
    
    @XmlElement
    public void setStationdesc_s(String stationdesc_s){
        this.stationdesc_s=stationdesc_s;
    }
        
   
        
    public String getStation_i() {
		return station_i;
	}

	public void setStation_i(String station_i) {
		this.station_i = station_i;
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
        
    
    
    
}
