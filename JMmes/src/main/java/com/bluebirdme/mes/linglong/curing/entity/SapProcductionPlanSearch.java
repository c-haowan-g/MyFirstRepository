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

import com.bluebirdme.core.system.annotations.Comment;

/**
 * 硫化月计划查询
 * @author liyan
 * @Date 2018-08-25 10:00:04
 */
@Entity
@XmlRootElement
@Table(name="AT_C_PP_SAPPRODUCTIONPLAN")
public class SapProcductionPlanSearch extends RockWellBaseEntity{
    
    
    @Comment("机构编号（招远 8000；德州 8002  柳州 8003    泰国8004  ）")
    @Column(nullable=false,length=160)
    private String agenc_no_s;
    
    @Comment("机构名称")
    @Column(nullable=false,length=160)
    private String agen_name_s;
    
    @Comment("已过动平衡量")
    @Column(nullable=true,length=22)
    private BigDecimal balance_quantity_i;
    
    @Comment("BOM标识")
    @Column(nullable=true,length=160)
    private String bom_flag_s;
    
    @Comment("更新人编号")
    @Column(nullable=true,length=200)
    private String changed_by_s;
    
    @Comment("更新人时间")
    @Column(nullable=true,length=11)
    private Date changed_time_t;
    
    @Comment("创建人")
    @Column(nullable=true,length=200)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=11)
    private Date created_time_t;
    
    @Comment("8日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal eightday_i;
    
    @Comment("18日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal eighteenday_i;
    
    @Comment("11日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal elevenday_i;
    
    @Comment("15日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal fifteenday_i;
    
    @Comment("5日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal fiveday_i;
    
    @Comment("花纹")
    @Column(nullable=true,length=160)
    private String flowershape_s;
    
    @Comment("4日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal fourday_i;
    
    @Comment("14日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal fourteenday_i;
    
    @Comment("层级")
    @Column(nullable=true,length=160)
    private String layclass_s;
    
    @Comment("物料编码")
    @Column(nullable=true,length=160)
    private String material_code_s;
    
    @Comment("物料组")
    @Column(nullable=true,length=160)
    private String material_group_s;
    
    @Comment("物料描述")
    @Column(nullable=true,length=320)
    private String material_name_s;
    
    @Comment("备注")
    @Column(nullable=true,length=200)
    private String memo_s;
    
    @Comment("MES增加标识")
    @Column(nullable=true,length=160)
    private String mes_flag_s;
    
    @Comment("月份")
    @Column(nullable=false,length=22)
    private BigDecimal month_i;
    
    @Comment("9日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal nineday_i;
    
    @Comment("19日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal ninteenday_i;
    
    @Comment("1日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal oneday_i;
    
    @Comment("订单号")
    @Column(nullable=true,length=160)
    private String order_sap_s;
    
    @Comment("超产百分比")
    @Column(nullable=true,length=160)
    private String overproduction_percent_s;
    
    @Comment("月计划号")
    @Column(nullable=false,length=160)
    private String planno_month_s;
    
    @Comment("计划生产时间")
    @Column(nullable=true,length=11)
    private Date planproduct_time_t;
    
    @Comment("工厂号")
    @Column(nullable=false,length=160)
    private String plant_s;
    
    @Comment("计划结束时间")
    @Column(nullable=true,length=11)
    private Date plan_endtime_t;
    
    @Comment("计划开始时间")
    @Column(nullable=true,length=11)
    private Date plan_starttime_t;
    
    @Comment("计划状态")
    @Column(nullable=true,length=160)
    private String plan_status_s;
    
    @Comment("计划实际生产量")
    @Column(nullable=true,length=22)
    private String quantity_actual_f;
    
    @Comment("月计划数量")
    @Column(nullable=false,length=22)
    private String quantity_plan_f;
    
    @Comment("已排产数量")
    @Column(nullable=true,length=22)
    private String quantity_producted_f;
    
    @Comment("接收时间")
    @Column(nullable=true,length=11)
    private Date receive_time_t;
    
    @Comment("记录标志(A可用，D删除)")
    @Column(nullable=true,length=160)
    private String record_flag_s;
    
    @Comment("配方标识")
    @Column(nullable=true,length=160)
    private String repicp_flag_s;
    
    @Comment("SAP原数量")
    @Column(nullable=true,length=22)
    private String sap_quantity_original_f;
    
    @Comment("7日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal sevenday_i;
    
    @Comment("17日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal seventeenday_i;
    
    @Comment("6日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal sixday_i;
    
    @Comment("16日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal sixteenday_i;
    
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
    
    @Comment("规格")
    @Column(nullable=true,length=200)
    private String specification_s;
    
    @Comment("分厂号")
    @Column(nullable=true,length=160)
    private String subplant_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=160)
    private String s_factory_s;
    
    @Comment("10日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal tenday_i;
    
    @Comment("13日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal thirteenday_i;
    
    @Comment("30日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal thirtyday_i;
    
    @Comment("31日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal thirtyoneday_i;
    
    @Comment("3日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal threeday_i;
    
    @Comment("12日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twelvenday_i;
    
    @Comment("20日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentyday_i;
    
    @Comment("28日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentyeightday_i;
    
    @Comment("25日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentyfiveday_i;
    
    @Comment("24日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentyfourday_i;
    
    @Comment("29日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentynineday_i;
    
    @Comment("21日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentyoneday_i;
    
    @Comment("27日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentysevenday_i;
    
    @Comment("26日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentysixday_i;
    
    @Comment("23日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentythreeday_i;
    
    @Comment("22日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twentytwoday_i;
    
    @Comment("2日硫化量")
    @Column(nullable=true,length=22)
    private BigDecimal twoday_i;
    
    public String getAgenc_no_s(){
        return agenc_no_s;
    }
    
    @XmlElement
    public void setAgenc_no_s(String agenc_no_s){
        this.agenc_no_s=agenc_no_s;
    }
        
    public String getAgen_name_s(){
        return agen_name_s;
    }
    
    @XmlElement
    public void setAgen_name_s(String agen_name_s){
        this.agen_name_s=agen_name_s;
    }
        
    public BigDecimal getBalance_quantity_i(){
        return balance_quantity_i;
    }
    
    @XmlElement
    public void setBalance_quantity_i(BigDecimal balance_quantity_i){
        this.balance_quantity_i=balance_quantity_i;
    }
        
    public String getBom_flag_s(){
        return bom_flag_s;
    }
    
    @XmlElement
    public void setBom_flag_s(String bom_flag_s){
        this.bom_flag_s=bom_flag_s;
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
        
    public BigDecimal getEightday_i(){
        return eightday_i;
    }
    
    @XmlElement
    public void setEightday_i(BigDecimal eightday_i){
        this.eightday_i=eightday_i;
    }
        
    public BigDecimal getEighteenday_i(){
        return eighteenday_i;
    }
    
    @XmlElement
    public void setEighteenday_i(BigDecimal eighteenday_i){
        this.eighteenday_i=eighteenday_i;
    }
        
    public BigDecimal getElevenday_i(){
        return elevenday_i;
    }
    
    @XmlElement
    public void setElevenday_i(BigDecimal elevenday_i){
        this.elevenday_i=elevenday_i;
    }
        
    public BigDecimal getFifteenday_i(){
        return fifteenday_i;
    }
    
    @XmlElement
    public void setFifteenday_i(BigDecimal fifteenday_i){
        this.fifteenday_i=fifteenday_i;
    }
        
    public BigDecimal getFiveday_i(){
        return fiveday_i;
    }
    
    @XmlElement
    public void setFiveday_i(BigDecimal fiveday_i){
        this.fiveday_i=fiveday_i;
    }
        
    public String getFlowershape_s(){
        return flowershape_s;
    }
    
    @XmlElement
    public void setFlowershape_s(String flowershape_s){
        this.flowershape_s=flowershape_s;
    }
        
    public BigDecimal getFourday_i(){
        return fourday_i;
    }
    
    @XmlElement
    public void setFourday_i(BigDecimal fourday_i){
        this.fourday_i=fourday_i;
    }
        
    public BigDecimal getFourteenday_i(){
        return fourteenday_i;
    }
    
    @XmlElement
    public void setFourteenday_i(BigDecimal fourteenday_i){
        this.fourteenday_i=fourteenday_i;
    }
        
    public String getLayclass_s(){
        return layclass_s;
    }
    
    @XmlElement
    public void setLayclass_s(String layclass_s){
        this.layclass_s=layclass_s;
    }
        
    public String getMaterial_code_s(){
        return material_code_s;
    }
    
    @XmlElement
    public void setMaterial_code_s(String material_code_s){
        this.material_code_s=material_code_s;
    }
        
    public String getMaterial_group_s(){
        return material_group_s;
    }
    
    @XmlElement
    public void setMaterial_group_s(String material_group_s){
        this.material_group_s=material_group_s;
    }
        
    public String getMaterial_name_s(){
        return material_name_s;
    }
    
    @XmlElement
    public void setMaterial_name_s(String material_name_s){
        this.material_name_s=material_name_s;
    }
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getMes_flag_s(){
        return mes_flag_s;
    }
    
    @XmlElement
    public void setMes_flag_s(String mes_flag_s){
        this.mes_flag_s=mes_flag_s;
    }
        
    public BigDecimal getMonth_i(){
        return month_i;
    }
    
    @XmlElement
    public void setMonth_i(BigDecimal month_i){
        this.month_i=month_i;
    }
        
    public BigDecimal getNineday_i(){
        return nineday_i;
    }
    
    @XmlElement
    public void setNineday_i(BigDecimal nineday_i){
        this.nineday_i=nineday_i;
    }
        
    public BigDecimal getNinteenday_i(){
        return ninteenday_i;
    }
    
    @XmlElement
    public void setNinteenday_i(BigDecimal ninteenday_i){
        this.ninteenday_i=ninteenday_i;
    }
        
    public BigDecimal getOneday_i(){
        return oneday_i;
    }
    
    @XmlElement
    public void setOneday_i(BigDecimal oneday_i){
        this.oneday_i=oneday_i;
    }
        
    public String getOrder_sap_s(){
        return order_sap_s;
    }
    
    @XmlElement
    public void setOrder_sap_s(String order_sap_s){
        this.order_sap_s=order_sap_s;
    }
        
    public String getOverproduction_percent_s(){
        return overproduction_percent_s;
    }
    
    @XmlElement
    public void setOverproduction_percent_s(String overproduction_percent_s){
        this.overproduction_percent_s=overproduction_percent_s;
    }
        
    public String getPlanno_month_s(){
        return planno_month_s;
    }
    
    @XmlElement
    public void setPlanno_month_s(String planno_month_s){
        this.planno_month_s=planno_month_s;
    }
        
    public Date getPlanproduct_time_t(){
        return planproduct_time_t;
    }
    
    @XmlElement
    public void setPlanproduct_time_t(Date planproduct_time_t){
        this.planproduct_time_t=planproduct_time_t;
    }
        
    public String getPlant_s(){
        return plant_s;
    }
    
    @XmlElement
    public void setPlant_s(String plant_s){
        this.plant_s=plant_s;
    }
        
    public Date getPlan_endtime_t(){
        return plan_endtime_t;
    }
    
    @XmlElement
    public void setPlan_endtime_t(Date plan_endtime_t){
        this.plan_endtime_t=plan_endtime_t;
    }
        
    public Date getPlan_starttime_t(){
        return plan_starttime_t;
    }
    
    @XmlElement
    public void setPlan_starttime_t(Date plan_starttime_t){
        this.plan_starttime_t=plan_starttime_t;
    }
        
    public String getPlan_status_s(){
        return plan_status_s;
    }
    
    @XmlElement
    public void setPlan_status_s(String plan_status_s){
        this.plan_status_s=plan_status_s;
    }
        
    public String getQuantity_actual_f(){
        return quantity_actual_f;
    }
    
    @XmlElement
    public void setQuantity_actual_f(String quantity_actual_f){
        this.quantity_actual_f=quantity_actual_f;
    }
        
    public String getQuantity_plan_f(){
        return quantity_plan_f;
    }
    
    @XmlElement
    public void setQuantity_plan_f(String quantity_plan_f){
        this.quantity_plan_f=quantity_plan_f;
    }
        
    public String getQuantity_producted_f(){
        return quantity_producted_f;
    }
    
    @XmlElement
    public void setQuantity_producted_f(String quantity_producted_f){
        this.quantity_producted_f=quantity_producted_f;
    }
        
    public Date getReceive_time_t(){
        return receive_time_t;
    }
    
    @XmlElement
    public void setReceive_time_t(Date receive_time_t){
        this.receive_time_t=receive_time_t;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRepicp_flag_s(){
        return repicp_flag_s;
    }
    
    @XmlElement
    public void setRepicp_flag_s(String repicp_flag_s){
        this.repicp_flag_s=repicp_flag_s;
    }
        
    public String getSap_quantity_original_f(){
        return sap_quantity_original_f;
    }
    
    @XmlElement
    public void setSap_quantity_original_f(String sap_quantity_original_f){
        this.sap_quantity_original_f=sap_quantity_original_f;
    }
        
    public BigDecimal getSevenday_i(){
        return sevenday_i;
    }
    
    @XmlElement
    public void setSevenday_i(BigDecimal sevenday_i){
        this.sevenday_i=sevenday_i;
    }
        
    public BigDecimal getSeventeenday_i(){
        return seventeenday_i;
    }
    
    @XmlElement
    public void setSeventeenday_i(BigDecimal seventeenday_i){
        this.seventeenday_i=seventeenday_i;
    }
        
    public BigDecimal getSixday_i(){
        return sixday_i;
    }
    
    @XmlElement
    public void setSixday_i(BigDecimal sixday_i){
        this.sixday_i=sixday_i;
    }
        
    public BigDecimal getSixteenday_i(){
        return sixteenday_i;
    }
    
    @XmlElement
    public void setSixteenday_i(BigDecimal sixteenday_i){
        this.sixteenday_i=sixteenday_i;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getSubplant_s(){
        return subplant_s;
    }
    
    @XmlElement
    public void setSubplant_s(String subplant_s){
        this.subplant_s=subplant_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public BigDecimal getTenday_i(){
        return tenday_i;
    }
    
    @XmlElement
    public void setTenday_i(BigDecimal tenday_i){
        this.tenday_i=tenday_i;
    }
        
    public BigDecimal getThirteenday_i(){
        return thirteenday_i;
    }
    
    @XmlElement
    public void setThirteenday_i(BigDecimal thirteenday_i){
        this.thirteenday_i=thirteenday_i;
    }
        
    public BigDecimal getThirtyday_i(){
        return thirtyday_i;
    }
    
    @XmlElement
    public void setThirtyday_i(BigDecimal thirtyday_i){
        this.thirtyday_i=thirtyday_i;
    }
        
    public BigDecimal getThirtyoneday_i(){
        return thirtyoneday_i;
    }
    
    @XmlElement
    public void setThirtyoneday_i(BigDecimal thirtyoneday_i){
        this.thirtyoneday_i=thirtyoneday_i;
    }
        
    public BigDecimal getThreeday_i(){
        return threeday_i;
    }
    
    @XmlElement
    public void setThreeday_i(BigDecimal threeday_i){
        this.threeday_i=threeday_i;
    }
        
    public BigDecimal getTwelvenday_i(){
        return twelvenday_i;
    }
    
    @XmlElement
    public void setTwelvenday_i(BigDecimal twelvenday_i){
        this.twelvenday_i=twelvenday_i;
    }
        
    public BigDecimal getTwentyday_i(){
        return twentyday_i;
    }
    
    @XmlElement
    public void setTwentyday_i(BigDecimal twentyday_i){
        this.twentyday_i=twentyday_i;
    }
        
    public BigDecimal getTwentyeightday_i(){
        return twentyeightday_i;
    }
    
    @XmlElement
    public void setTwentyeightday_i(BigDecimal twentyeightday_i){
        this.twentyeightday_i=twentyeightday_i;
    }
        
    public BigDecimal getTwentyfiveday_i(){
        return twentyfiveday_i;
    }
    
    @XmlElement
    public void setTwentyfiveday_i(BigDecimal twentyfiveday_i){
        this.twentyfiveday_i=twentyfiveday_i;
    }
        
    public BigDecimal getTwentyfourday_i(){
        return twentyfourday_i;
    }
    
    @XmlElement
    public void setTwentyfourday_i(BigDecimal twentyfourday_i){
        this.twentyfourday_i=twentyfourday_i;
    }
        
    public BigDecimal getTwentynineday_i(){
        return twentynineday_i;
    }
    
    @XmlElement
    public void setTwentynineday_i(BigDecimal twentynineday_i){
        this.twentynineday_i=twentynineday_i;
    }
        
    public BigDecimal getTwentyoneday_i(){
        return twentyoneday_i;
    }
    
    @XmlElement
    public void setTwentyoneday_i(BigDecimal twentyoneday_i){
        this.twentyoneday_i=twentyoneday_i;
    }
        
    public BigDecimal getTwentysevenday_i(){
        return twentysevenday_i;
    }
    
    @XmlElement
    public void setTwentysevenday_i(BigDecimal twentysevenday_i){
        this.twentysevenday_i=twentysevenday_i;
    }
        
    public BigDecimal getTwentysixday_i(){
        return twentysixday_i;
    }
    
    @XmlElement
    public void setTwentysixday_i(BigDecimal twentysixday_i){
        this.twentysixday_i=twentysixday_i;
    }
        
    public BigDecimal getTwentythreeday_i(){
        return twentythreeday_i;
    }
    
    @XmlElement
    public void setTwentythreeday_i(BigDecimal twentythreeday_i){
        this.twentythreeday_i=twentythreeday_i;
    }
        
    public BigDecimal getTwentytwoday_i(){
        return twentytwoday_i;
    }
    
    @XmlElement
    public void setTwentytwoday_i(BigDecimal twentytwoday_i){
        this.twentytwoday_i=twentytwoday_i;
    }
        
    public BigDecimal getTwoday_i(){
        return twoday_i;
    }
    
    @XmlElement
    public void setTwoday_i(BigDecimal twoday_i){
        this.twoday_i=twoday_i;
    }
        
    
    
    
}
