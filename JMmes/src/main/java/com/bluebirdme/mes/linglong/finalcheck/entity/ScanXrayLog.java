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
import com.bluebirdme.core.system.annotations.Comment;

/**
 * X光扫描履历表
 * @author 马健斌
 * @Date 2018-08-05 09:07:46
 */
@Entity
@XmlRootElement
@Table(name="AT_D_QM_ScanXrayLog")
public class ScanXrayLog extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002  柳州 8003 泰国 8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标志，A可用，B删除")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MES_MainTyre 表 BARCODE")
    @Column(nullable=false,length=80)
    private String barcode_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("质检设备信息表主键：ID")
    @Column(nullable=true,length=0)
    private Integer entid_i;
    
    @Comment("质量等级编码")
    @Column(nullable=false,length=0)
    private Integer gradecd_i;
    
    @Comment("班组编号")
    @Column(nullable=true,length=80)
    private String groupcode_s;
    
    @Comment("分配索引号(!~1000)")
    @Column(nullable=true,length=0)
    private Integer index_i;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String itemid_s;
    
    @Comment("当前工序")
    @Column(nullable=false,length=0)
    private Integer proess_i;
    
    @Comment("班次编号")
    @Column(nullable=true,length=80)
    private String shiftcode_s;
    
    @Comment("备用字段1.")
    @Column(nullable=true,length=80)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=80)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=80)
    private String spare3_s;
    
    @Comment("备用字段4.")
    @Column(nullable=true,length=80)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=80)
    private String spare5_s;
    
    @Comment("轮胎状态编码：0-待检、1-合格、2-不合格")
    @Column(nullable=false,length=0)
    private Integer statecd_i;
    
    @Comment("工厂(1.全钢 2.半钢)")
    @Column(nullable=false,length=80)
    private String s_factory_s;
    
    @Comment("轮胎类型：B-半钢、Q-全钢、G-工程胎等、X光-斜交、S-试验胎")
    @Column(nullable=true,length=80)
    private String tyretype_s;
    
    @Comment("外胎重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
    @Comment("MES校验错误")
    @Column(nullable=true,length=80)
    private String etype_i;
    
    @Comment("品号")
    @Column(nullable=true,length=80)
    private String isok_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String remark_s;
    
    @Comment("工控下发是否成功：0-成功、1-失败")
    @Column(nullable=false,length=80)
    private String writein_s;
    
    @Comment("工控下发备注")
    @Column(nullable=true,length=80)
    private String writeinremark_s;
    
     
    public String getWriteinremark_s() {
		return writeinremark_s;
	}

	public void setWriteinremark_s(String writeinremark_s) {
		this.writeinremark_s = writeinremark_s;
	}

	public String getWritein_s() {
		return writein_s;
	}

	public void setWritein_s(String writein_s) {
		this.writein_s = writein_s;
	}

	public String getRemark_s() {
		return remark_s;
	}

	public void setRemark_s(String remark_s) {
		this.remark_s = remark_s;
	}

	public String getIsok_s() {
		return isok_s;
	}

	public void setIsok_s(String isok_s) {
		this.isok_s = isok_s;
	}

	public String getEtype_i() {
		return etype_i;
	}

	public void setEtype_i(String etype_i) {
		this.etype_i = etype_i;
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
        
     
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
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
        
     
    public Integer getEntid_i(){
        return entid_i;
    }
    
    @XmlElement
    public void setEntid_i(Integer entid_i){
        this.entid_i=entid_i;
    }
        
     
    public Integer getGradecd_i(){
        return gradecd_i;
    }
    
    @XmlElement
    public void setGradecd_i(Integer gradecd_i){
        this.gradecd_i=gradecd_i;
    }
        
     
    public String getGroupcode_s(){
        return groupcode_s;
    }
    
    @XmlElement
    public void setGroupcode_s(String groupcode_s){
        this.groupcode_s=groupcode_s;
    }
        
     
    public Integer getIndex_i(){
        return index_i;
    }
    
    @XmlElement
    public void setIndex_i(Integer index_i){
        this.index_i=index_i;
    }
        
     
    public String getItemid_s(){
        return itemid_s;
    }
    
    @XmlElement
    public void setItemid_s(String itemid_s){
        this.itemid_s=itemid_s;
    }
        
     
    public Integer getProess_i(){
        return proess_i;
    }
    
    @XmlElement
    public void setProess_i(Integer proess_i){
        this.proess_i=proess_i;
    }
        
     
    public String getShiftcode_s(){
        return shiftcode_s;
    }
    
    @XmlElement
    public void setShiftcode_s(String shiftcode_s){
        this.shiftcode_s=shiftcode_s;
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
        
     
    public Integer getStatecd_i(){
        return statecd_i;
    }
    
    @XmlElement
    public void setStatecd_i(Integer statecd_i){
        this.statecd_i=statecd_i;
    }
        
     
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
     
    public String getTyretype_s(){
        return tyretype_s;
    }
    
    @XmlElement
    public void setTyretype_s(String tyretype_s){
        this.tyretype_s=tyretype_s;
    }
        
     
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    
    
    
}
