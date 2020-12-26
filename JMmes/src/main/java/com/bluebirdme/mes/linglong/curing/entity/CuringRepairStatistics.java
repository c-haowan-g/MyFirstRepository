/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
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
 * 硫化返修统计
 * @author 葛迎祥
 * @Date 2020-04-10 08:18:48
 */
@ATDefinition("C_QM_REPAIR_STATISTICS")
@Entity
@XmlRootElement
@Table(name="AT_C_QM_REPAIR_STATISTICS")
public class CuringRepairStatistics extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远 8000；德州 8002 柳州 8003 泰国 8004 荆门8023 ")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("8日返修量")
    @Column(nullable=true,length=0)
    private Integer eightday_i;
    
    @Comment("18日返修量")
    @Column(nullable=true,length=0)
    private Integer eighteenday_i;
    
    @Comment("11日返修量")
    @Column(nullable=true,length=0)
    private Integer elevenday_i;
    
    @Comment("15日返修量")
    @Column(nullable=true,length=0)
    private Integer fifteenday_i;
    
    @Comment("5日返修量")
    @Column(nullable=true,length=0)
    private Integer fiveday_i;
    
    @Comment("4日返修量")
    @Column(nullable=true,length=0)
    private Integer fourday_i;
    
    @Comment("14日返修量")
    @Column(nullable=true,length=0)
    private Integer fourteenday_i;
    
    @Comment("机台编号")
    @Column(nullable=true,length=80)
    private String machinecode_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=80)
    private String material_code_s;
    
    @Comment("物料描述")
    @Column(nullable=true,length=150)
    private String mterial_desc_s;
    
    @Comment("9日返修量")
    @Column(nullable=true,length=0)
    private Integer nineday_i;
    
    @Comment("19日返修量")
    @Column(nullable=true,length=0)
    private Integer ninteenday_i;
    
    @Comment("1日返修量")
    @Column(nullable=true,length=0)
    private Integer oneday_i;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("7日返修量")
    @Column(nullable=true,length=0)
    private Integer sevenday_i;
    
    @Comment("17日返修量")
    @Column(nullable=true,length=0)
    private Integer seventeenday_i;
    
    @Comment("6日返修量")
    @Column(nullable=true,length=0)
    private Integer sixday_i;
    
    @Comment("16日返修量")
    @Column(nullable=true,length=0)
    private Integer sixteenday_i;
    
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
    
    @Comment("厂区")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("10日返修量")
    @Column(nullable=true,length=0)
    private Integer tenday_i;
    
    @Comment("13日返修量")
    @Column(nullable=true,length=0)
    private Integer thirteenday_i;
    
    @Comment("30日返修量")
    @Column(nullable=true,length=0)
    private Integer thirtyday_i;
    
    @Comment("31日返修量")
    @Column(nullable=true,length=0)
    private Integer thirtyoneday_i;
    
    @Comment("3日返修量")
    @Column(nullable=true,length=0)
    private Integer threeday_i;
    
    @Comment("总计")
    @Column(nullable=true,length=0)
    private Integer total_num_i;
    
    @Comment("12日返修量")
    @Column(nullable=true,length=0)
    private Integer twelvenday_i;
    
    @Comment("20日返修量")
    @Column(nullable=true,length=0)
    private Integer twentyday_i;
    
    @Comment("28日返修量")
    @Column(nullable=true,length=0)
    private Integer twentyeightday_i;
    
    @Comment("25日返修量")
    @Column(nullable=true,length=0)
    private Integer twentyfiveday_i;
    
    @Comment("24日返修量")
    @Column(nullable=true,length=0)
    private Integer twentyfourday_i;
    
    @Comment("29日返修量")
    @Column(nullable=true,length=0)
    private Integer twentynineday_i;
    
    @Comment("21日返修量")
    @Column(nullable=true,length=0)
    private Integer twentyoneday_i;
    
    @Comment("27日返修量")
    @Column(nullable=true,length=0)
    private Integer twentysevenday_i;
    
    @Comment("26日返修量")
    @Column(nullable=true,length=0)
    private Integer twentysixday_i;
    
    @Comment("23日返修量")
    @Column(nullable=true,length=0)
    private Integer twentythreeday_i;
    
    @Comment("22日返修量")
    @Column(nullable=true,length=0)
    private Integer twentytwoday_i;
    
    @Comment("2日返修量")
    @Column(nullable=true,length=0)
    private Integer twoday_i;
    
    @Comment("更新时间")
    @Column(nullable=true,length=0)
    private Date update_time_t;
    
    @Comment("返修人员")
    @Column(nullable=true,length=80)
    private String worker_id_s;
    
    @Comment("当前月份")
    @Column(nullable=true,length=80)
    private String month_s;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public Integer getEightday_i(){
        return eightday_i;
    }
    
    @XmlElement
    public void setEightday_i(Integer eightday_i){
        this.eightday_i=eightday_i;
    }
        
    public Integer getEighteenday_i(){
        return eighteenday_i;
    }
    
    @XmlElement
    public void setEighteenday_i(Integer eighteenday_i){
        this.eighteenday_i=eighteenday_i;
    }
        
    public Integer getElevenday_i(){
        return elevenday_i;
    }
    
    @XmlElement
    public void setElevenday_i(Integer elevenday_i){
        this.elevenday_i=elevenday_i;
    }
        
    public Integer getFifteenday_i(){
        return fifteenday_i;
    }
    
    @XmlElement
    public void setFifteenday_i(Integer fifteenday_i){
        this.fifteenday_i=fifteenday_i;
    }
        
    public Integer getFiveday_i(){
        return fiveday_i;
    }
    
    @XmlElement
    public void setFiveday_i(Integer fiveday_i){
        this.fiveday_i=fiveday_i;
    }
        
    public Integer getFourday_i(){
        return fourday_i;
    }
    
    @XmlElement
    public void setFourday_i(Integer fourday_i){
        this.fourday_i=fourday_i;
    }
        
    public Integer getFourteenday_i(){
        return fourteenday_i;
    }
    
    @XmlElement
    public void setFourteenday_i(Integer fourteenday_i){
        this.fourteenday_i=fourteenday_i;
    }
        
    public String getMachinecode_s(){
        return machinecode_s;
    }
    
    @XmlElement
    public void setMachinecode_s(String machinecode_s){
        this.machinecode_s=machinecode_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMterial_desc_s(){
        return mterial_desc_s;
    }
    
    @XmlElement
    public void setMterial_desc_s(String mterial_desc_s){
        this.mterial_desc_s=mterial_desc_s;
    }
        
    public Integer getNineday_i(){
        return nineday_i;
    }
    
    @XmlElement
    public void setNineday_i(Integer nineday_i){
        this.nineday_i=nineday_i;
    }
        
    public Integer getNinteenday_i(){
        return ninteenday_i;
    }
    
    @XmlElement
    public void setNinteenday_i(Integer ninteenday_i){
        this.ninteenday_i=ninteenday_i;
    }
        
    public Integer getOneday_i(){
        return oneday_i;
    }
    
    @XmlElement
    public void setOneday_i(Integer oneday_i){
        this.oneday_i=oneday_i;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public Integer getSevenday_i(){
        return sevenday_i;
    }
    
    @XmlElement
    public void setSevenday_i(Integer sevenday_i){
        this.sevenday_i=sevenday_i;
    }
        
    public Integer getSeventeenday_i(){
        return seventeenday_i;
    }
    
    @XmlElement
    public void setSeventeenday_i(Integer seventeenday_i){
        this.seventeenday_i=seventeenday_i;
    }
        
    public Integer getSixday_i(){
        return sixday_i;
    }
    
    @XmlElement
    public void setSixday_i(Integer sixday_i){
        this.sixday_i=sixday_i;
    }
        
    public Integer getSixteenday_i(){
        return sixteenday_i;
    }
    
    @XmlElement
    public void setSixteenday_i(Integer sixteenday_i){
        this.sixteenday_i=sixteenday_i;
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
        
    public Integer getTenday_i(){
        return tenday_i;
    }
    
    @XmlElement
    public void setTenday_i(Integer tenday_i){
        this.tenday_i=tenday_i;
    }
        
    public Integer getThirteenday_i(){
        return thirteenday_i;
    }
    
    @XmlElement
    public void setThirteenday_i(Integer thirteenday_i){
        this.thirteenday_i=thirteenday_i;
    }
        
    public Integer getThirtyday_i(){
        return thirtyday_i;
    }
    
    @XmlElement
    public void setThirtyday_i(Integer thirtyday_i){
        this.thirtyday_i=thirtyday_i;
    }
        
    public Integer getThirtyoneday_i(){
        return thirtyoneday_i;
    }
    
    @XmlElement
    public void setThirtyoneday_i(Integer thirtyoneday_i){
        this.thirtyoneday_i=thirtyoneday_i;
    }
        
    public Integer getThreeday_i(){
        return threeday_i;
    }
    
    @XmlElement
    public void setThreeday_i(Integer threeday_i){
        this.threeday_i=threeday_i;
    }
        
    public Integer getTotal_num_i(){
        return total_num_i;
    }
    
    @XmlElement
    public void setTotal_num_i(Integer total_num_i){
        this.total_num_i=total_num_i;
    }
        
    public Integer getTwelvenday_i(){
        return twelvenday_i;
    }
    
    @XmlElement
    public void setTwelvenday_i(Integer twelvenday_i){
        this.twelvenday_i=twelvenday_i;
    }
        
    public Integer getTwentyday_i(){
        return twentyday_i;
    }
    
    @XmlElement
    public void setTwentyday_i(Integer twentyday_i){
        this.twentyday_i=twentyday_i;
    }
        
    public Integer getTwentyeightday_i(){
        return twentyeightday_i;
    }
    
    @XmlElement
    public void setTwentyeightday_i(Integer twentyeightday_i){
        this.twentyeightday_i=twentyeightday_i;
    }
        
    public Integer getTwentyfiveday_i(){
        return twentyfiveday_i;
    }
    
    @XmlElement
    public void setTwentyfiveday_i(Integer twentyfiveday_i){
        this.twentyfiveday_i=twentyfiveday_i;
    }
        
    public Integer getTwentyfourday_i(){
        return twentyfourday_i;
    }
    
    @XmlElement
    public void setTwentyfourday_i(Integer twentyfourday_i){
        this.twentyfourday_i=twentyfourday_i;
    }
        
    public Integer getTwentynineday_i(){
        return twentynineday_i;
    }
    
    @XmlElement
    public void setTwentynineday_i(Integer twentynineday_i){
        this.twentynineday_i=twentynineday_i;
    }
        
    public Integer getTwentyoneday_i(){
        return twentyoneday_i;
    }
    
    @XmlElement
    public void setTwentyoneday_i(Integer twentyoneday_i){
        this.twentyoneday_i=twentyoneday_i;
    }
        
    public Integer getTwentysevenday_i(){
        return twentysevenday_i;
    }
    
    @XmlElement
    public void setTwentysevenday_i(Integer twentysevenday_i){
        this.twentysevenday_i=twentysevenday_i;
    }
        
    public Integer getTwentysixday_i(){
        return twentysixday_i;
    }
    
    @XmlElement
    public void setTwentysixday_i(Integer twentysixday_i){
        this.twentysixday_i=twentysixday_i;
    }
        
    public Integer getTwentythreeday_i(){
        return twentythreeday_i;
    }
    
    @XmlElement
    public void setTwentythreeday_i(Integer twentythreeday_i){
        this.twentythreeday_i=twentythreeday_i;
    }
        
    public Integer getTwentytwoday_i(){
        return twentytwoday_i;
    }
    
    @XmlElement
    public void setTwentytwoday_i(Integer twentytwoday_i){
        this.twentytwoday_i=twentytwoday_i;
    }
        
    public Integer getTwoday_i(){
        return twoday_i;
    }
    
    @XmlElement
    public void setTwoday_i(Integer twoday_i){
        this.twoday_i=twoday_i;
    }
        
    public Date getUpdate_time_t(){
        return update_time_t;
    }
    
    @XmlElement
    public void setUpdate_time_t(Date update_time_t){
        this.update_time_t=update_time_t;
    }
        
    public String getWorker_id_s(){
        return worker_id_s;
    }
    
    @XmlElement
    public void setWorker_id_s(String worker_id_s){
        this.worker_id_s=worker_id_s;
    }

	public String getMonth_s() {
		return month_s;
	}

	public void setMonth_s(String month_s) {
		this.month_s = month_s;
	}
        
    
}
