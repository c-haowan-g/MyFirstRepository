/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * X光质检信息表
 * @author 李新宇
 * @Date 2020-02-24 08:38:10
 */
@ATDefinition("D_QM_CHECKXRAYRESULT")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_CHECKXRAYRESULT")
public class CheckXrayResult extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004 荆门 8023")
    @Column(nullable=false,length=80)
    private String agenc_no_s;
    
    @Comment("检查次数")
    @Column(nullable=true,length=0)
    private Integer checkseq_i;
    
    @Comment("检测时间")
    @Column(nullable=true,length=80)
    private String checktime_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("备用字段1")
    @Column(nullable=true,length=80)
    private String dummy1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String dummy2_s;
    
    @Comment("设备ID")
    @Column(nullable=true,length=80)
    private String equipid_s;
    
    @Comment("检测等级")
    @Column(nullable=true,length=80)
    private String gradeid_s;
    
    @Comment("X光图片名称")
    @Column(nullable=true,length=80)
    private String imagename_s;
    
    @Comment("X光图片存储路径")
    @Column(nullable=true,length=80)
    private String imagesavepath_s;
    
    @Comment("记录标志，A当前可检，D历史可检")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("条码号")
    @Column(nullable=false,length=80)
    private String tyrebarcode_s;
    
    @Comment("检测人员ID")
    @Column(nullable=true,length=80)
    private String userid_s;
    
    @Comment("检测人员班次")
    @Column(nullable=true,length=80)
    private String usershift_s;
    
    @Comment("重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Integer getCheckseq_i(){
        return checkseq_i;
    }
    
    @XmlElement
    public void setCheckseq_i(Integer checkseq_i){
        this.checkseq_i=checkseq_i;
    }
        
    public String getChecktime_s(){
        return checktime_s;
    }
    
    @XmlElement
    public void setChecktime_s(String checktime_s){
        this.checktime_s=checktime_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
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
        
    public String getEquipid_s(){
        return equipid_s;
    }
    
    @XmlElement
    public void setEquipid_s(String equipid_s){
        this.equipid_s=equipid_s;
    }
        
    public String getGradeid_s(){
        return gradeid_s;
    }
    
    @XmlElement
    public void setGradeid_s(String gradeid_s){
        this.gradeid_s=gradeid_s;
    }
        
    public String getImagename_s(){
        return imagename_s;
    }
    
    @XmlElement
    public void setImagename_s(String imagename_s){
        this.imagename_s=imagename_s;
    }
        
    public String getImagesavepath_s(){
        return imagesavepath_s;
    }
    
    @XmlElement
    public void setImagesavepath_s(String imagesavepath_s){
        this.imagesavepath_s=imagesavepath_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTyrebarcode_s(){
        return tyrebarcode_s;
    }
    
    @XmlElement
    public void setTyrebarcode_s(String tyrebarcode_s){
        this.tyrebarcode_s=tyrebarcode_s;
    }
        
    public String getUserid_s(){
        return userid_s;
    }
    
    @XmlElement
    public void setUserid_s(String userid_s){
        this.userid_s=userid_s;
    }
        
    public String getUsershift_s(){
        return usershift_s;
    }
    
    @XmlElement
    public void setUsershift_s(String usershift_s){
        this.usershift_s=usershift_s;
    }
        
    
    
    
}
