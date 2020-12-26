/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity;

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
 * 密炼月产量表
 * @author 陈国强
 * @Date 2020-08-21 08:25:16
 */
@ATDefinition("MX_RP_MONTHPROD")
@Entity
@XmlRootElement
@Table(name="AT_MX_RP_MONTHPROD")
public class MixMonthlyReport extends RockWellBaseEntity{
    
    
    @Comment("机构编号： 柳州 8003")
    @Column(nullable=true,length=16)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=2)
    private String arch_flag_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=100)
    private String created_by_s;
    
    @Comment("创建人姓名")
    @Column(nullable=true,length=200)
    private String created_name_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("8日车数")
    @Column(nullable=true,length=0)
    private Integer eightday_train_i;
    
    @Comment("8日重量")
    @Column(nullable=true,length=0)
    private String eightday_weight_d;
    
    @Comment("18日车数")
    @Column(nullable=true,length=0)
    private Integer eighteenday_train_i;
    
    @Comment("18日重量")
    @Column(nullable=true,length=0)
    private String eighteenday_weight_d;
    
    @Comment("11日车数")
    @Column(nullable=true,length=0)
    private Integer elevenday_train_i;
    
    @Comment("11日重量")
    @Column(nullable=true,length=0)
    private String elevenday_weight_d;
    
    @Comment("机台编码")
    @Column(nullable=false,length=40)
    private String equip_code_s;
    
    @Comment("机台名称")
    @Column(nullable=false,length=40)
    private String equip_name_s;
    
    @Comment("15日车数")
    @Column(nullable=true,length=0)
    private Integer fifteenday_train_i;
    
    @Comment("15日重量")
    @Column(nullable=true,length=0)
    private String fifteenday_weight_d;
    
    @Comment("5日车数")
    @Column(nullable=true,length=0)
    private Integer fiveday_train_i;
    
    @Comment("5日重量")
    @Column(nullable=true,length=0)
    private String fiveday_weight_d;
    
    @Comment("4日车数")
    @Column(nullable=true,length=0)
    private Integer fourday_train_i;
    
    @Comment("4日重量")
    @Column(nullable=true,length=0)
    private String fourday_weight_d;
    
    @Comment("14日车数")
    @Column(nullable=true,length=0)
    private Integer fourteenday_train_i;
    
    @Comment("14日重量")
    @Column(nullable=true,length=0)
    private String fourteenday_weight_d;
    
    @Comment("主键ID")
    @Column(nullable=true,length=80)
    private String id_s;
    
    @Comment("主机手")
    @Column(nullable=true,length=100)
    private String master_by_s;
    
    @Comment("主机手姓名")
    @Column(nullable=true,length=200)
    private String master_name_s;
    
    @Comment("物料编号")
    @Column(nullable=true,length=100)
    private String materialcode_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=40)
    private String materialgroup_s;
    
    @Comment("物料名称")
    @Column(nullable=true,length=200)
    private String materialname_s;
    
    @Comment("物料规格")
    @Column(nullable=true,length=200)
    private String materialspec_s;
    
    @Comment("月份 年+月->201808")
    @Column(nullable=false,length=40)
    private String month_s;
    
    @Comment("9日车数")
    @Column(nullable=true,length=0)
    private Integer nineday_train_i;
    
    @Comment("9日重量")
    @Column(nullable=true,length=0)
    private String nineday_weight_d;
    
    @Comment("19日车数")
    @Column(nullable=true,length=0)
    private Integer ninteenday_train_i;
    
    @Comment("19日重量")
    @Column(nullable=true,length=0)
    private String ninteenday_weight_d;
    
    @Comment("1日车数")
    @Column(nullable=true,length=0)
    private Integer oneday_train_i;
    
    @Comment("1日重量")
    @Column(nullable=true,length=0)
    private String oneday_weight_d;
    
    @Comment("配方编号")
    @Column(nullable=true,length=40)
    private String recipe_code_s;
    
    @Comment("配方名称")
    @Column(nullable=true,length=80)
    private String recipe_name_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=2)
    private String record_flag_s;
    
    @Comment("7日车数")
    @Column(nullable=true,length=0)
    private Integer sevenday_train_i;
    
    @Comment("7日重量")
    @Column(nullable=true,length=0)
    private String sevenday_weight_d;
    
    @Comment("17日车数")
    @Column(nullable=true,length=0)
    private Integer seventeenday_train_i;
    
    @Comment("17日重量")
    @Column(nullable=true,length=0)
    private String seventeenday_weight_d;
    
    @Comment("6日车数")
    @Column(nullable=true,length=0)
    private Integer sixday_train_i;
    
    @Comment("6日重量")
    @Column(nullable=true,length=0)
    private String sixday_weight_d;
    
    @Comment("16日车数")
    @Column(nullable=true,length=0)
    private Integer sixteenday_train_i;
    
    @Comment("16日重量")
    @Column(nullable=true,length=0)
    private String sixteenday_weight_d;
    
    @Comment("月产量报表类型：1-密炼、2-半部件、3-成型")
    @Column(nullable=true,length=100)
    private String spare1_s;
    
    @Comment("备用字段2")
    @Column(nullable=true,length=100)
    private String spare2_s;
    
    @Comment("备用字段3")
    @Column(nullable=true,length=100)
    private String spare3_s;
    
    @Comment("备用字段4")
    @Column(nullable=true,length=100)
    private String spare4_s;
    
    @Comment("备用字段5")
    @Column(nullable=true,length=100)
    private String spare5_s;
    
    @Comment("工厂：1-全钢、2-半钢")
    @Column(nullable=true,length=5)
    private String s_factory_s;
    
    @Comment("10日车数")
    @Column(nullable=true,length=0)
    private Integer tenday_train_i;
    
    @Comment("10日重量")
    @Column(nullable=true,length=0)
    private String tenday_weight_d;
    
    @Comment("13日车数")
    @Column(nullable=true,length=0)
    private Integer thirteenday_train_i;
    
    @Comment("13日重量")
    @Column(nullable=true,length=0)
    private String thirteenday_weight_d;
    
    @Comment("30日车数")
    @Column(nullable=true,length=0)
    private Integer thirtyday_train_i;
    
    @Comment("30日重量")
    @Column(nullable=true,length=0)
    private String thirtyday_weight_d;
    
    @Comment("31日车数")
    @Column(nullable=true,length=0)
    private Integer thirtyoneday_train_i;
    
    @Comment("31日重量")
    @Column(nullable=true,length=0)
    private String thirtyoneday_weight_d;
    
    @Comment("3日车数")
    @Column(nullable=true,length=0)
    private Integer threeday_train_i;
    
    @Comment("3日重量")
    @Column(nullable=true,length=0)
    private String threeday_weight_d;
    
    @Comment("12日车数")
    @Column(nullable=true,length=0)
    private Integer twelvenday_train_i;
    
    @Comment("12日重量")
    @Column(nullable=true,length=0)
    private String twelvenday_weight_d;
    
    @Comment("20日车数")
    @Column(nullable=true,length=0)
    private Integer twentyday_train_i;
    
    @Comment("20日重量")
    @Column(nullable=true,length=0)
    private String twentyday_weight_d;
    
    @Comment("28日车数")
    @Column(nullable=true,length=0)
    private Integer twentyeightday_train_i;
    
    @Comment("28日重量")
    @Column(nullable=true,length=0)
    private String twentyeightday_weight_d;
    
    @Comment("25日车数")
    @Column(nullable=true,length=0)
    private Integer twentyfiveday_train_i;
    
    @Comment("25日重量")
    @Column(nullable=true,length=0)
    private String twentyfiveday_weight_d;
    
    @Comment("24日车数")
    @Column(nullable=true,length=0)
    private Integer twentyfourday_train_i;
    
    @Comment("24日重量")
    @Column(nullable=true,length=0)
    private String twentyfourday_weight_d;
    
    @Comment("29日车数")
    @Column(nullable=true,length=0)
    private Integer twentynineday_train_i;
    
    @Comment("29日重量")
    @Column(nullable=true,length=0)
    private String twentynineday_weight_d;
    
    @Comment("21日车数")
    @Column(nullable=true,length=0)
    private Integer twentyoneday_train_i;
    
    @Comment("21日重量")
    @Column(nullable=true,length=0)
    private String twentyoneday_weight_d;
    
    @Comment("27日车数")
    @Column(nullable=true,length=0)
    private Integer twentysevenday_train_i;
    
    @Comment("27日重量")
    @Column(nullable=true,length=0)
    private String twentysevenday_weight_d;
    
    @Comment("26日车数")
    @Column(nullable=true,length=0)
    private Integer twentysixday_train_i;
    
    @Comment("26日重量")
    @Column(nullable=true,length=0)
    private String twentysixday_weight_d;
    
    @Comment("23日车数")
    @Column(nullable=true,length=0)
    private Integer twentythreeday_train_i;
    
    @Comment("23日重量")
    @Column(nullable=true,length=0)
    private String twentythreeday_weight_d;
    
    @Comment("22日车数")
    @Column(nullable=true,length=0)
    private Integer twentytwoday_train_i;
    
    @Comment("22日重量")
    @Column(nullable=true,length=0)
    private String twentytwoday_weight_d;
    
    @Comment("2日车数")
    @Column(nullable=true,length=0)
    private Integer twoday_train_i;
    
    @Comment("2日重量")
    @Column(nullable=true,length=0)
    private String twoday_weight_d;
    
    @Comment("总数量")
    
    private Integer total_train_i;
    
    @Comment("总质量")
   
    private String total_weight_d;
    
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
        
    public String getCreated_by_s(){
        return created_by_s;
    }
    
    @XmlElement
    public void setCreated_by_s(String created_by_s){
        this.created_by_s=created_by_s;
    }
        
    public String getCreated_name_s(){
        return created_name_s;
    }
    
    @XmlElement
    public void setCreated_name_s(String created_name_s){
        this.created_name_s=created_name_s;
    }
        
    public Date getCreated_time_t(){
        return created_time_t;
    }
    
    @XmlElement
    public void setCreated_time_t(Date created_time_t){
        this.created_time_t=created_time_t;
    }
        
    public Integer getEightday_train_i(){
        return eightday_train_i;
    }
    
    @XmlElement
    public void setEightday_train_i(Integer eightday_train_i){
        this.eightday_train_i=eightday_train_i;
    }
        
    public String getEightday_weight_d(){
        return eightday_weight_d;
    }
    
    @XmlElement
    public void setEightday_weight_d(String eightday_weight_d){
        this.eightday_weight_d=eightday_weight_d;
    }
        
    public Integer getEighteenday_train_i(){
        return eighteenday_train_i;
    }
    
    @XmlElement
    public void setEighteenday_train_i(Integer eighteenday_train_i){
        this.eighteenday_train_i=eighteenday_train_i;
    }
        
    public String getEighteenday_weight_d(){
        return eighteenday_weight_d;
    }
    
    @XmlElement
    public void setEighteenday_weight_d(String eighteenday_weight_d){
        this.eighteenday_weight_d=eighteenday_weight_d;
    }
        
    public Integer getElevenday_train_i(){
        return elevenday_train_i;
    }
    
    @XmlElement
    public void setElevenday_train_i(Integer elevenday_train_i){
        this.elevenday_train_i=elevenday_train_i;
    }
        
    public String getElevenday_weight_d(){
        return elevenday_weight_d;
    }
    
    @XmlElement
    public void setElevenday_weight_d(String elevenday_weight_d){
        this.elevenday_weight_d=elevenday_weight_d;
    }
        
    public String getEquip_code_s(){
        return equip_code_s;
    }
    
    @XmlElement
    public void setEquip_code_s(String equip_code_s){
        this.equip_code_s=equip_code_s;
    }
        
    public String getEquip_name_s(){
        return equip_name_s;
    }
    
    @XmlElement
    public void setEquip_name_s(String equip_name_s){
        this.equip_name_s=equip_name_s;
    }
        
    public Integer getFifteenday_train_i(){
        return fifteenday_train_i;
    }
    
    @XmlElement
    public void setFifteenday_train_i(Integer fifteenday_train_i){
        this.fifteenday_train_i=fifteenday_train_i;
    }
        
    public String getFifteenday_weight_d(){
        return fifteenday_weight_d;
    }
    
    @XmlElement
    public void setFifteenday_weight_d(String fifteenday_weight_d){
        this.fifteenday_weight_d=fifteenday_weight_d;
    }
        
    public Integer getFiveday_train_i(){
        return fiveday_train_i;
    }
    
    @XmlElement
    public void setFiveday_train_i(Integer fiveday_train_i){
        this.fiveday_train_i=fiveday_train_i;
    }
        
    public String getFiveday_weight_d(){
        return fiveday_weight_d;
    }
    
    @XmlElement
    public void setFiveday_weight_d(String fiveday_weight_d){
        this.fiveday_weight_d=fiveday_weight_d;
    }
        
    public Integer getFourday_train_i(){
        return fourday_train_i;
    }
    
    @XmlElement
    public void setFourday_train_i(Integer fourday_train_i){
        this.fourday_train_i=fourday_train_i;
    }
        
    public String getFourday_weight_d(){
        return fourday_weight_d;
    }
    
    @XmlElement
    public void setFourday_weight_d(String fourday_weight_d){
        this.fourday_weight_d=fourday_weight_d;
    }
        
    public Integer getFourteenday_train_i(){
        return fourteenday_train_i;
    }
    
    @XmlElement
    public void setFourteenday_train_i(Integer fourteenday_train_i){
        this.fourteenday_train_i=fourteenday_train_i;
    }
        
    public String getFourteenday_weight_d(){
        return fourteenday_weight_d;
    }
    
    @XmlElement
    public void setFourteenday_weight_d(String fourteenday_weight_d){
        this.fourteenday_weight_d=fourteenday_weight_d;
    }
        
    public String getId_s(){
        return id_s;
    }
    
    @XmlElement
    public void setId_s(String id_s){
        this.id_s=id_s;
    }
        
    public String getMaster_by_s(){
        return master_by_s;
    }
    
    @XmlElement
    public void setMaster_by_s(String master_by_s){
        this.master_by_s=master_by_s;
    }
        
    public String getMaster_name_s(){
        return master_name_s;
    }
    
    @XmlElement
    public void setMaster_name_s(String master_name_s){
        this.master_name_s=master_name_s;
    }
        
    public String getMaterialcode_s(){
        return materialcode_s;
    }
    
    @XmlElement
    public void setMaterialcode_s(String materialcode_s){
        this.materialcode_s=materialcode_s;
    }
        
    public String getMaterialgroup_s(){
        return materialgroup_s;
    }
    
    @XmlElement
    public void setMaterialgroup_s(String materialgroup_s){
        this.materialgroup_s=materialgroup_s;
    }
        
    public String getMaterialname_s(){
        return materialname_s;
    }
    
    @XmlElement
    public void setMaterialname_s(String materialname_s){
        this.materialname_s=materialname_s;
    }
        
    public String getMaterialspec_s(){
        return materialspec_s;
    }
    
    @XmlElement
    public void setMaterialspec_s(String materialspec_s){
        this.materialspec_s=materialspec_s;
    }
        
    public String getMonth_s(){
        return month_s;
    }
    
    @XmlElement
    public void setMonth_s(String month_s){
        this.month_s=month_s;
    }
        
    public Integer getNineday_train_i(){
        return nineday_train_i;
    }
    
    @XmlElement
    public void setNineday_train_i(Integer nineday_train_i){
        this.nineday_train_i=nineday_train_i;
    }
        
    public String getNineday_weight_d(){
        return nineday_weight_d;
    }
    
    @XmlElement
    public void setNineday_weight_d(String nineday_weight_d){
        this.nineday_weight_d=nineday_weight_d;
    }
        
    public Integer getNinteenday_train_i(){
        return ninteenday_train_i;
    }
    
    @XmlElement
    public void setNinteenday_train_i(Integer ninteenday_train_i){
        this.ninteenday_train_i=ninteenday_train_i;
    }
        
    public String getNinteenday_weight_d(){
        return ninteenday_weight_d;
    }
    
    @XmlElement
    public void setNinteenday_weight_d(String ninteenday_weight_d){
        this.ninteenday_weight_d=ninteenday_weight_d;
    }
        
    public Integer getOneday_train_i(){
        return oneday_train_i;
    }
    
    @XmlElement
    public void setOneday_train_i(Integer oneday_train_i){
        this.oneday_train_i=oneday_train_i;
    }
        
    public String getOneday_weight_d(){
        return oneday_weight_d;
    }
    
    @XmlElement
    public void setOneday_weight_d(String oneday_weight_d){
        this.oneday_weight_d=oneday_weight_d;
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
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public Integer getSevenday_train_i(){
        return sevenday_train_i;
    }
    
    @XmlElement
    public void setSevenday_train_i(Integer sevenday_train_i){
        this.sevenday_train_i=sevenday_train_i;
    }
        
    public String getSevenday_weight_d(){
        return sevenday_weight_d;
    }
    
    @XmlElement
    public void setSevenday_weight_d(String sevenday_weight_d){
        this.sevenday_weight_d=sevenday_weight_d;
    }
        
    public Integer getSeventeenday_train_i(){
        return seventeenday_train_i;
    }
    
    @XmlElement
    public void setSeventeenday_train_i(Integer seventeenday_train_i){
        this.seventeenday_train_i=seventeenday_train_i;
    }
        
    public String getSeventeenday_weight_d(){
        return seventeenday_weight_d;
    }
    
    @XmlElement
    public void setSeventeenday_weight_d(String seventeenday_weight_d){
        this.seventeenday_weight_d=seventeenday_weight_d;
    }
        
    public Integer getSixday_train_i(){
        return sixday_train_i;
    }
    
    @XmlElement
    public void setSixday_train_i(Integer sixday_train_i){
        this.sixday_train_i=sixday_train_i;
    }
        
    public String getSixday_weight_d(){
        return sixday_weight_d;
    }
    
    @XmlElement
    public void setSixday_weight_d(String sixday_weight_d){
        this.sixday_weight_d=sixday_weight_d;
    }
        
    public Integer getSixteenday_train_i(){
        return sixteenday_train_i;
    }
    
    @XmlElement
    public void setSixteenday_train_i(Integer sixteenday_train_i){
        this.sixteenday_train_i=sixteenday_train_i;
    }
        
    public String getSixteenday_weight_d(){
        return sixteenday_weight_d;
    }
    
    @XmlElement
    public void setSixteenday_weight_d(String sixteenday_weight_d){
        this.sixteenday_weight_d=sixteenday_weight_d;
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
        
    public Integer getTenday_train_i(){
        return tenday_train_i;
    }
    
    @XmlElement
    public void setTenday_train_i(Integer tenday_train_i){
        this.tenday_train_i=tenday_train_i;
    }
        
    public String getTenday_weight_d(){
        return tenday_weight_d;
    }
    
    @XmlElement
    public void setTenday_weight_d(String tenday_weight_d){
        this.tenday_weight_d=tenday_weight_d;
    }
        
    public Integer getThirteenday_train_i(){
        return thirteenday_train_i;
    }
    
    @XmlElement
    public void setThirteenday_train_i(Integer thirteenday_train_i){
        this.thirteenday_train_i=thirteenday_train_i;
    }
        
    public String getThirteenday_weight_d(){
        return thirteenday_weight_d;
    }
    
    @XmlElement
    public void setThirteenday_weight_d(String thirteenday_weight_d){
        this.thirteenday_weight_d=thirteenday_weight_d;
    }
        
    public Integer getThirtyday_train_i(){
        return thirtyday_train_i;
    }
    
    @XmlElement
    public void setThirtyday_train_i(Integer thirtyday_train_i){
        this.thirtyday_train_i=thirtyday_train_i;
    }
        
    public String getThirtyday_weight_d(){
        return thirtyday_weight_d;
    }
    
    @XmlElement
    public void setThirtyday_weight_d(String thirtyday_weight_d){
        this.thirtyday_weight_d=thirtyday_weight_d;
    }
        
    public Integer getThirtyoneday_train_i(){
        return thirtyoneday_train_i;
    }
    
    @XmlElement
    public void setThirtyoneday_train_i(Integer thirtyoneday_train_i){
        this.thirtyoneday_train_i=thirtyoneday_train_i;
    }
        
    public String getThirtyoneday_weight_d(){
        return thirtyoneday_weight_d;
    }
    
    @XmlElement
    public void setThirtyoneday_weight_d(String thirtyoneday_weight_d){
        this.thirtyoneday_weight_d=thirtyoneday_weight_d;
    }
        
    public Integer getThreeday_train_i(){
        return threeday_train_i;
    }
    
    @XmlElement
    public void setThreeday_train_i(Integer threeday_train_i){
        this.threeday_train_i=threeday_train_i;
    }
        
    public String getThreeday_weight_d(){
        return threeday_weight_d;
    }
    
    @XmlElement
    public void setThreeday_weight_d(String threeday_weight_d){
        this.threeday_weight_d=threeday_weight_d;
    }
        
    public Integer getTwelvenday_train_i(){
        return twelvenday_train_i;
    }
    
    @XmlElement
    public void setTwelvenday_train_i(Integer twelvenday_train_i){
        this.twelvenday_train_i=twelvenday_train_i;
    }
        
    public String getTwelvenday_weight_d(){
        return twelvenday_weight_d;
    }
    
    @XmlElement
    public void setTwelvenday_weight_d(String twelvenday_weight_d){
        this.twelvenday_weight_d=twelvenday_weight_d;
    }
        
    public Integer getTwentyday_train_i(){
        return twentyday_train_i;
    }
    
    @XmlElement
    public void setTwentyday_train_i(Integer twentyday_train_i){
        this.twentyday_train_i=twentyday_train_i;
    }
        
    public String getTwentyday_weight_d(){
        return twentyday_weight_d;
    }
    
    @XmlElement
    public void setTwentyday_weight_d(String twentyday_weight_d){
        this.twentyday_weight_d=twentyday_weight_d;
    }
        
    public Integer getTwentyeightday_train_i(){
        return twentyeightday_train_i;
    }
    
    @XmlElement
    public void setTwentyeightday_train_i(Integer twentyeightday_train_i){
        this.twentyeightday_train_i=twentyeightday_train_i;
    }
        
    public String getTwentyeightday_weight_d(){
        return twentyeightday_weight_d;
    }
    
    @XmlElement
    public void setTwentyeightday_weight_d(String twentyeightday_weight_d){
        this.twentyeightday_weight_d=twentyeightday_weight_d;
    }
        
    public Integer getTwentyfiveday_train_i(){
        return twentyfiveday_train_i;
    }
    
    @XmlElement
    public void setTwentyfiveday_train_i(Integer twentyfiveday_train_i){
        this.twentyfiveday_train_i=twentyfiveday_train_i;
    }
        
    public String getTwentyfiveday_weight_d(){
        return twentyfiveday_weight_d;
    }
    
    @XmlElement
    public void setTwentyfiveday_weight_d(String twentyfiveday_weight_d){
        this.twentyfiveday_weight_d=twentyfiveday_weight_d;
    }
        
    public Integer getTwentyfourday_train_i(){
        return twentyfourday_train_i;
    }
    
    @XmlElement
    public void setTwentyfourday_train_i(Integer twentyfourday_train_i){
        this.twentyfourday_train_i=twentyfourday_train_i;
    }
        
    public String getTwentyfourday_weight_d(){
        return twentyfourday_weight_d;
    }
    
    @XmlElement
    public void setTwentyfourday_weight_d(String twentyfourday_weight_d){
        this.twentyfourday_weight_d=twentyfourday_weight_d;
    }
        
    public Integer getTwentynineday_train_i(){
        return twentynineday_train_i;
    }
    
    @XmlElement
    public void setTwentynineday_train_i(Integer twentynineday_train_i){
        this.twentynineday_train_i=twentynineday_train_i;
    }
        
    public String getTwentynineday_weight_d(){
        return twentynineday_weight_d;
    }
    
    @XmlElement
    public void setTwentynineday_weight_d(String twentynineday_weight_d){
        this.twentynineday_weight_d=twentynineday_weight_d;
    }
        
    public Integer getTwentyoneday_train_i(){
        return twentyoneday_train_i;
    }
    
    @XmlElement
    public void setTwentyoneday_train_i(Integer twentyoneday_train_i){
        this.twentyoneday_train_i=twentyoneday_train_i;
    }
        
    public String getTwentyoneday_weight_d(){
        return twentyoneday_weight_d;
    }
    
    @XmlElement
    public void setTwentyoneday_weight_d(String twentyoneday_weight_d){
        this.twentyoneday_weight_d=twentyoneday_weight_d;
    }
        
    public Integer getTwentysevenday_train_i(){
        return twentysevenday_train_i;
    }
    
    @XmlElement
    public void setTwentysevenday_train_i(Integer twentysevenday_train_i){
        this.twentysevenday_train_i=twentysevenday_train_i;
    }
        
    public String getTwentysevenday_weight_d(){
        return twentysevenday_weight_d;
    }
    
    @XmlElement
    public void setTwentysevenday_weight_d(String twentysevenday_weight_d){
        this.twentysevenday_weight_d=twentysevenday_weight_d;
    }
        
    public Integer getTwentysixday_train_i(){
        return twentysixday_train_i;
    }
    
    @XmlElement
    public void setTwentysixday_train_i(Integer twentysixday_train_i){
        this.twentysixday_train_i=twentysixday_train_i;
    }
        
    public String getTwentysixday_weight_d(){
        return twentysixday_weight_d;
    }
    
    @XmlElement
    public void setTwentysixday_weight_d(String twentysixday_weight_d){
        this.twentysixday_weight_d=twentysixday_weight_d;
    }
        
    public Integer getTwentythreeday_train_i(){
        return twentythreeday_train_i;
    }
    
    @XmlElement
    public void setTwentythreeday_train_i(Integer twentythreeday_train_i){
        this.twentythreeday_train_i=twentythreeday_train_i;
    }
        
    public String getTwentythreeday_weight_d(){
        return twentythreeday_weight_d;
    }
    
    @XmlElement
    public void setTwentythreeday_weight_d(String twentythreeday_weight_d){
        this.twentythreeday_weight_d=twentythreeday_weight_d;
    }
        
    public Integer getTwentytwoday_train_i(){
        return twentytwoday_train_i;
    }
    
    @XmlElement
    public void setTwentytwoday_train_i(Integer twentytwoday_train_i){
        this.twentytwoday_train_i=twentytwoday_train_i;
    }
        
    public String getTwentytwoday_weight_d(){
        return twentytwoday_weight_d;
    }
    
    @XmlElement
    public void setTwentytwoday_weight_d(String twentytwoday_weight_d){
        this.twentytwoday_weight_d=twentytwoday_weight_d;
    }
        
    public Integer getTwoday_train_i(){
        return twoday_train_i;
    }
    
    @XmlElement
    public void setTwoday_train_i(Integer twoday_train_i){
        this.twoday_train_i=twoday_train_i;
    }
        
    public String getTwoday_weight_d(){
        return twoday_weight_d;
    }
    
    @XmlElement
    public void setTwoday_weight_d(String twoday_weight_d){
        this.twoday_weight_d=twoday_weight_d;
    }

	public Integer getTotal_train_i() {
		return total_train_i;
	}
	
	public void setTotal_train_i(Integer total_train_i) {
		this.total_train_i = total_train_i;
	}

	public String getTotal_weight_d() {
		return total_weight_d;
	}
	
	public void setTotal_weight_d(String total_weight_d) {
		this.total_weight_d = total_weight_d;
	}
        
    
    
    
}
