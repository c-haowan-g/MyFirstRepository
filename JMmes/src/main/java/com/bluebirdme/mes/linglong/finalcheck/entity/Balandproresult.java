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
 * 质检动平衡检测结果表(国际计测)
 * @author 王海霖
 * @Date 2019-01-18 15:32:07
 */
@ATDefinition("D_QM_BALANDRRORESULT")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_BALANDRRORESULT")
public class Balandproresult extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远8000；德州8002；柳州8003；泰国8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("动平衡总等级")
    @Column(nullable=true,length=80)
    private String balance_total_rank_s;
    
    @Comment("轮胎条码：MainTyre.BARCODE")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("偶不平衡量角度")
    @Column(nullable=true,length=80)
    private String couple_unbalance_deg_s;
    
    @Comment("偶不平衡量")
    @Column(nullable=true,length=80)
    private String couple_unbalance_g_s;
    
    @Comment("偶不平衡量等级")
    @Column(nullable=true,length=80)
    private String couple_unbalance_rank_s;
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("轮胎检测等级")
    @Column(nullable=true,length=80)
    private String grade_code_s;
    
    @Comment("下部侧向凸角度2")
    @Column(nullable=true,length=80)
    private String lb_bulging2_deg_s;
    
    @Comment("下部侧向凸值2")
    @Column(nullable=true,length=80)
    private String lb_bulging2_mm_s;
    
    @Comment("下部侧向凸等级2")
    @Column(nullable=true,length=80)
    private String lb_bulging2_rank_s;
    
    @Comment("下部侧向凸角度3")
    @Column(nullable=true,length=80)
    private String lb_bulging3_deg_s;
    
    @Comment("下部侧向凸值3")
    @Column(nullable=true,length=80)
    private String lb_bulging3_mm_s;
    
    @Comment("下部侧向凸等级3")
    @Column(nullable=true,length=80)
    private String lb_bulging3_rank_s;
    
    @Comment("下部侧向凸角度1")
    @Column(nullable=true,length=80)
    private String lb_bulging_deg_s;
    
    @Comment("下部侧向凸值1")
    @Column(nullable=true,length=80)
    private String lb_bulging_mm_s;
    
    @Comment("下部侧向凸等级1")
    @Column(nullable=true,length=80)
    private String lb_bulging_rank_s;
    
    @Comment("下部侧向凹角度2")
    @Column(nullable=true,length=80)
    private String lb_dent2_deg_s;
    
    @Comment("下部侧向凹值2")
    @Column(nullable=true,length=80)
    private String lb_dent2_mm_s;
    
    @Comment("下部侧向凹等级2")
    @Column(nullable=true,length=80)
    private String lb_dent2_rank_s;
    
    @Comment("下部侧向凹角度3")
    @Column(nullable=true,length=80)
    private String lb_dent3_deg_s;
    
    @Comment("下部侧向凹值3")
    @Column(nullable=true,length=80)
    private String lb_dent3_mm_s;
    
    @Comment("下部侧向凹等级3")
    @Column(nullable=true,length=80)
    private String lb_dent3_rank_s;
    
    @Comment("下部侧向凹角度1")
    @Column(nullable=true,length=80)
    private String lb_dent_deg_s;
    
    @Comment("下部侧向凹值1")
    @Column(nullable=true,length=80)
    private String lb_dent_mm_s;
    
    @Comment("下部侧向凹等级1")
    @Column(nullable=true,length=80)
    private String lb_dent_rank_s;
    
    @Comment("下部侧向跳动一次谐波角度2")
    @Column(nullable=true,length=80)
    private String lb_oa2_1h_deg_s;
    
    @Comment("下部侧向跳动一次谐波值2")
    @Column(nullable=true,length=80)
    private String lb_oa2_1h_mm_s;
    
    @Comment("下部侧向跳动一次谐波等级2")
    @Column(nullable=true,length=80)
    private String lb_oa2_1h_rank_s;
    
    @Comment("下部侧向跳动角度2")
    @Column(nullable=true,length=80)
    private String lb_oa2_deg_s;
    
    @Comment("下部侧向跳动值2")
    @Column(nullable=true,length=80)
    private String lb_oa2_mm_s;
    
    @Comment("下部侧向跳动等级2")
    @Column(nullable=true,length=80)
    private String lb_oa2_rank_s;
    
    @Comment("下部侧向跳动一次谐波角度3")
    @Column(nullable=true,length=80)
    private String lb_oa3_1h_deg_s;
    
    @Comment("下部侧向跳动一次谐波值3")
    @Column(nullable=true,length=80)
    private String lb_oa3_1h_mm_s;
    
    @Comment("下部侧向跳动一次谐波等级3")
    @Column(nullable=true,length=80)
    private String lb_oa3_1h_rank_s;
    
    @Comment("下部侧向跳动角度3")
    @Column(nullable=true,length=80)
    private String lb_oa3_deg_s;
    
    @Comment("下部侧向跳动值3")
    @Column(nullable=true,length=80)
    private String lb_oa3_mm_s;
    
    @Comment("下部侧向跳动等级3")
    @Column(nullable=true,length=80)
    private String lb_oa3_rank_s;
    
    @Comment("下部侧向跳动一次谐波角度1")
    @Column(nullable=true,length=80)
    private String lb_oa_1h_deg_s;
    
    @Comment("下部侧向跳动一次谐波值1")
    @Column(nullable=true,length=80)
    private String lb_oa_1h_mm_s;
    
    @Comment("下部侧向跳动一次谐波等级1")
    @Column(nullable=true,length=80)
    private String lb_oa_1h_rank_s;
    
    @Comment("下部侧向跳动角度1")
    @Column(nullable=true,length=80)
    private String lb_oa_deg_s;
    
    @Comment("下部侧向跳动值1")
    @Column(nullable=true,length=80)
    private String lb_oa_mm_s;
    
    @Comment("下部侧向跳动等级1")
    @Column(nullable=true,length=80)
    private String lb_oa_rank_s;
    
    @Comment("下面不平衡量角度")
    @Column(nullable=true,length=80)
    private String lower_unbalance_deg_s;
    
    @Comment("下面不平衡量")
    @Column(nullable=true,length=80)
    private String lower_unbalance_g_s;
    
    @Comment("下面不平衡量等级")
    @Column(nullable=true,length=80)
    private String lower_unbalance_rank_s;
    
    @Comment("下部侧向跳动N次谐波角度1")
    @Column(nullable=true,length=80)
    private String lro_b1_nth_deg_s;
    
    @Comment("下部侧向跳动N次谐波值1")
    @Column(nullable=true,length=80)
    private String lro_b1_nth_mm_s;
    
    @Comment("下部侧向跳动N次谐波等级1")
    @Column(nullable=true,length=80)
    private String lro_b1_nth_rank_s;
    
    @Comment("下部侧向跳动N次谐波角度2")
    @Column(nullable=true,length=80)
    private String lro_b2_nth_deg_s;
    
    @Comment("下部侧向跳动N次谐波值2")
    @Column(nullable=true,length=80)
    private String lro_b2_nth_mm_s;
    
    @Comment("下部侧向跳动N次谐波等级2")
    @Column(nullable=true,length=80)
    private String lro_b2_nth_rank_s;
    
    @Comment("下部侧向跳动N次谐波角度3")
    @Column(nullable=true,length=80)
    private String lro_b3_nth_deg_s;
    
    @Comment("下部侧向跳动N次谐波值3")
    @Column(nullable=true,length=80)
    private String lro_b3_nth_mm_s;
    
    @Comment("下部侧向跳动N次谐波等级3")
    @Column(nullable=true,length=80)
    private String lro_b3_nth_rank_s;
    
    @Comment("上部侧向跳动N次谐波角度1")
    @Column(nullable=true,length=80)
    private String lro_t1_nth_deg_s;
    
    @Comment("上部侧向跳动N次谐波值1")
    @Column(nullable=true,length=80)
    private String lro_t1_nth_mm_s;
    
    @Comment("上部侧向跳动N次谐波等级1")
    @Column(nullable=true,length=80)
    private String lro_t1_nth_rank_s;
    
    @Comment("上部侧向跳动N次谐波角度2")
    @Column(nullable=true,length=80)
    private String lro_t2_nth_deg_s;
    
    @Comment("上部侧向跳动N次谐波值2")
    @Column(nullable=true,length=80)
    private String lro_t2_nth_mm_s;
    
    @Comment("上部侧向跳动N次谐波等级2")
    @Column(nullable=true,length=80)
    private String lro_t2_nth_rank_s;
    
    @Comment("上部侧向跳动N次谐波角度3")
    @Column(nullable=true,length=80)
    private String lro_t3_nth_deg_s;
    
    @Comment("上部侧向跳动N次谐波值3")
    @Column(nullable=true,length=80)
    private String lro_t3_nth_mm_s;
    
    @Comment("上部侧向跳动N次谐波等级3")
    @Column(nullable=true,length=80)
    private String lro_t3_nth_rank_s;
    
    @Comment("上部侧向凸角度2")
    @Column(nullable=true,length=80)
    private String lt_bulging2_deg_s;
    
    @Comment("上部侧向凸值2")
    @Column(nullable=true,length=80)
    private String lt_bulging2_mm_s;
    
    @Comment("上部侧向凸等级2")
    @Column(nullable=true,length=80)
    private String lt_bulging2_rank_s;
    
    @Comment("上部侧向凸角度3")
    @Column(nullable=true,length=80)
    private String lt_bulging3_deg_s;
    
    @Comment("上部侧向凸值3")
    @Column(nullable=true,length=80)
    private String lt_bulging3_mm_s;
    
    @Comment("上部侧向凸等级3")
    @Column(nullable=true,length=80)
    private String lt_bulging3_rank_s;
    
    @Comment("上部侧向凸角度1")
    @Column(nullable=true,length=80)
    private String lt_bulging_deg_s;
    
    @Comment("上部侧向凸值1")
    @Column(nullable=true,length=80)
    private String lt_bulging_mm_s;
    
    @Comment("上部侧向凸等级1")
    @Column(nullable=true,length=80)
    private String lt_bulging_rank_s;
    
    @Comment("上部侧向凹角度2")
    @Column(nullable=true,length=80)
    private String lt_dent2_deg_s;
    
    @Comment("上部侧向凹值2")
    @Column(nullable=true,length=80)
    private String lt_dent2_mm_s;
    
    @Comment("上部侧向凹等级2")
    @Column(nullable=true,length=80)
    private String lt_dent2_rank_s;
    
    @Comment("上部侧向凹角度3")
    @Column(nullable=true,length=80)
    private String lt_dent3_deg_s;
    
    @Comment("上部侧向凹值3")
    @Column(nullable=true,length=80)
    private String lt_dent3_mm_s;
    
    @Comment("上部侧向凹等级3")
    @Column(nullable=true,length=80)
    private String lt_dent3_rank_s;
    
    @Comment("上部侧向凹角度1")
    @Column(nullable=true,length=80)
    private String lt_dent_deg_s;
    
    @Comment("上部侧向凹值1")
    @Column(nullable=true,length=80)
    private String lt_dent_mm_s;
    
    @Comment("上部侧向凹等级1")
    @Column(nullable=true,length=80)
    private String lt_dent_rank_s;
    
    @Comment("上部侧向跳动一次谐波角度2")
    @Column(nullable=true,length=80)
    private String lt_oa2_1h_deg_s;
    
    @Comment("上部侧向跳动一次谐波值2")
    @Column(nullable=true,length=80)
    private String lt_oa2_1h_mm_s;
    
    @Comment("上部侧向跳动一次谐波等级2")
    @Column(nullable=true,length=80)
    private String lt_oa2_1h_rank_s;
    
    @Comment("上部侧向跳动角度2")
    @Column(nullable=true,length=80)
    private String lt_oa2_deg_s;
    
    @Comment("上部侧向跳动值2")
    @Column(nullable=true,length=80)
    private String lt_oa2_mm_s;
    
    @Comment("上部侧向跳动等级2")
    @Column(nullable=true,length=80)
    private String lt_oa2_rank_s;
    
    @Comment("上部侧向跳动一次谐波角度3")
    @Column(nullable=true,length=80)
    private String lt_oa3_1h_deg_s;
    
    @Comment("上部侧向跳动一次谐波值3")
    @Column(nullable=true,length=80)
    private String lt_oa3_1h_mm_s;
    
    @Comment("上部侧向跳动一次谐波等级3")
    @Column(nullable=true,length=80)
    private String lt_oa3_1h_rank_s;
    
    @Comment("上部侧向跳动角度3")
    @Column(nullable=true,length=80)
    private String lt_oa3_deg_s;
    
    @Comment("上部侧向跳动值3")
    @Column(nullable=true,length=80)
    private String lt_oa3_mm_s;
    
    @Comment("上部侧向跳动等级3")
    @Column(nullable=true,length=80)
    private String lt_oa3_rank_s;
    
    @Comment("上部侧向跳动一次谐波角度1")
    @Column(nullable=true,length=80)
    private String lt_oa_1h_deg_s;
    
    @Comment("上部侧向跳动一次谐波值1")
    @Column(nullable=true,length=80)
    private String lt_oa_1h_mm_s;
    
    @Comment("上部侧向跳动一次谐波等级1")
    @Column(nullable=true,length=80)
    private String lt_oa_1h_rank_s;
    
    @Comment("上部侧向跳动角度1")
    @Column(nullable=true,length=80)
    private String lt_oa_deg_s;
    
    @Comment("上部侧向跳动值1")
    @Column(nullable=true,length=80)
    private String lt_oa_mm_s;
    
    @Comment("上部侧向跳动等级1")
    @Column(nullable=true,length=80)
    private String lt_oa_rank_s;
    
    @Comment("动平衡机台条码：D_EM_Ent.ENTBARCODE")
    @Column(nullable=true,length=80)
    private String machinebar_s;
    
    @Comment("下部径向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String rb_oa_1h_deg_s;
    
    @Comment("下部径向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String rb_oa_1h_mm_s;
    
    @Comment("下部径向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String rb_oa_1h_rank_s;
    
    @Comment("下部径向跳动角度")
    @Column(nullable=true,length=80)
    private String rb_oa_deg_s;
    
    @Comment("下部径向跳动值")
    @Column(nullable=true,length=80)
    private String rb_oa_mm_s;
    
    @Comment("下部径向跳动等级")
    @Column(nullable=true,length=80)
    private String rb_oa_rank_s;
    
    @Comment("中部径向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String rc_oa_1h_deg_s;
    
    @Comment("中部径向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String rc_oa_1h_mm_s;
    
    @Comment("中部径向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String rc_oa_1h_rank_s;
    
    @Comment("中部径向跳动角度")
    @Column(nullable=true,length=80)
    private String rc_oa_deg_s;
    
    @Comment("中部径向跳动值")
    @Column(nullable=true,length=80)
    private String rc_oa_mm_s;
    
    @Comment("中部径向跳动等级")
    @Column(nullable=true,length=80)
    private String rc_oa_rank_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=true,length=80)
    private String record_flag_s;
    
    @Comment("MES备注")
    @Column(nullable=true,length=200)
    private String remark_s;
    
    @Comment("跳动度总等级")
    @Column(nullable=true,length=80)
    private String ro_total_rank_s;
    
    @Comment("下部径向跳动N次谐波角度")
    @Column(nullable=true,length=80)
    private String rro_b_nth_deg_s;
    
    @Comment("下部径向跳动N次谐波值")
    @Column(nullable=true,length=80)
    private String rro_b_nth_mm_s;
    
    @Comment("下部径向跳动N次谐波等级")
    @Column(nullable=true,length=80)
    private String rro_b_nth_rank_s;
    
    @Comment("中部径向跳动N次谐波角度")
    @Column(nullable=true,length=80)
    private String rro_c_nth_deg_s;
    
    @Comment("中部径向跳动N次谐波值")
    @Column(nullable=true,length=80)
    private String rro_c_nth_mm_s;
    
    @Comment("中部径向跳动N次谐波等级")
    @Column(nullable=true,length=80)
    private String rro_c_nth_rank_s;
    
    @Comment("上部径向跳动N次谐波角度")
    @Column(nullable=true,length=80)
    private String rro_t_nth_deg_s;
    
    @Comment("上部径向跳动N次谐波值")
    @Column(nullable=true,length=80)
    private String rro_t_nth_mm_s;
    
    @Comment("上部径向跳动N次谐波等级")
    @Column(nullable=true,length=80)
    private String rro_t_nth_rank_s;
    
    @Comment("上部径向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String rt_oa_1h_deg_s;
    
    @Comment("上部径向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String rt_oa_1h_mm_s;
    
    @Comment("上部径向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String rt_oa_1h_rank_s;
    
    @Comment("上部径向跳动角度")
    @Column(nullable=true,length=80)
    private String rt_oa_deg_s;
    
    @Comment("上部径向跳动值")
    @Column(nullable=true,length=80)
    private String rt_oa_mm_s;
    
    @Comment("上部径向跳动等级")
    @Column(nullable=true,length=80)
    private String rt_oa_rank_s;
    
    @Comment("SAP品号")
    @Column(nullable=true,length=80)
    private String sap_item_s;
    
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
    
    @Comment("静合成不平衡量角度")
    @Column(nullable=true,length=80)
    private String static_unbalance_deg_s;
    
    @Comment("静合成不平衡量")
    @Column(nullable=true,length=80)
    private String static_unbalance_g_s;
    
    @Comment("静合成不平衡量等级")
    @Column(nullable=true,length=80)
    private String static_unbalance_rank_s;
    
    @Comment("工厂（1全钢 2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("测试模式1：精度测试0：正常测试")
    @Column(nullable=true,length=80)
    private String testmode_s;
    
    @Comment("上面不平衡量角度")
    @Column(nullable=true,length=80)
    private String upper_unbalance_deg_s;
    
    @Comment("上面不平衡量")
    @Column(nullable=true,length=80)
    private String upper_unbalance_g_s;
    
    @Comment("上面不平衡量等级")
    @Column(nullable=true,length=80)
    private String upper_unbalance_rank_s;
    
    @Comment("上面+下面不平衡量")
    @Column(nullable=true,length=80)
    private String up_low_unbalance_g_s;
    
    @Comment("上面+下面不平衡量等级")
    @Column(nullable=true,length=80)
    private String up_low_unbalance_rank_s;
    
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
        
    public String getBalance_total_rank_s(){
        return balance_total_rank_s;
    }
    
    @XmlElement
    public void setBalance_total_rank_s(String balance_total_rank_s){
        this.balance_total_rank_s=balance_total_rank_s;
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
        
    public String getCouple_unbalance_deg_s(){
        return couple_unbalance_deg_s;
    }
    
    @XmlElement
    public void setCouple_unbalance_deg_s(String couple_unbalance_deg_s){
        this.couple_unbalance_deg_s=couple_unbalance_deg_s;
    }
        
    public String getCouple_unbalance_g_s(){
        return couple_unbalance_g_s;
    }
    
    @XmlElement
    public void setCouple_unbalance_g_s(String couple_unbalance_g_s){
        this.couple_unbalance_g_s=couple_unbalance_g_s;
    }
        
    public String getCouple_unbalance_rank_s(){
        return couple_unbalance_rank_s;
    }
    
    @XmlElement
    public void setCouple_unbalance_rank_s(String couple_unbalance_rank_s){
        this.couple_unbalance_rank_s=couple_unbalance_rank_s;
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
        
    public String getGrade_code_s(){
        return grade_code_s;
    }
    
    @XmlElement
    public void setGrade_code_s(String grade_code_s){
        this.grade_code_s=grade_code_s;
    }
        
    public String getLb_bulging2_deg_s(){
        return lb_bulging2_deg_s;
    }
    
    @XmlElement
    public void setLb_bulging2_deg_s(String lb_bulging2_deg_s){
        this.lb_bulging2_deg_s=lb_bulging2_deg_s;
    }
        
    public String getLb_bulging2_mm_s(){
        return lb_bulging2_mm_s;
    }
    
    @XmlElement
    public void setLb_bulging2_mm_s(String lb_bulging2_mm_s){
        this.lb_bulging2_mm_s=lb_bulging2_mm_s;
    }
        
    public String getLb_bulging2_rank_s(){
        return lb_bulging2_rank_s;
    }
    
    @XmlElement
    public void setLb_bulging2_rank_s(String lb_bulging2_rank_s){
        this.lb_bulging2_rank_s=lb_bulging2_rank_s;
    }
        
    public String getLb_bulging3_deg_s(){
        return lb_bulging3_deg_s;
    }
    
    @XmlElement
    public void setLb_bulging3_deg_s(String lb_bulging3_deg_s){
        this.lb_bulging3_deg_s=lb_bulging3_deg_s;
    }
        
    public String getLb_bulging3_mm_s(){
        return lb_bulging3_mm_s;
    }
    
    @XmlElement
    public void setLb_bulging3_mm_s(String lb_bulging3_mm_s){
        this.lb_bulging3_mm_s=lb_bulging3_mm_s;
    }
        
    public String getLb_bulging3_rank_s(){
        return lb_bulging3_rank_s;
    }
    
    @XmlElement
    public void setLb_bulging3_rank_s(String lb_bulging3_rank_s){
        this.lb_bulging3_rank_s=lb_bulging3_rank_s;
    }
        
    public String getLb_bulging_deg_s(){
        return lb_bulging_deg_s;
    }
    
    @XmlElement
    public void setLb_bulging_deg_s(String lb_bulging_deg_s){
        this.lb_bulging_deg_s=lb_bulging_deg_s;
    }
        
    public String getLb_bulging_mm_s(){
        return lb_bulging_mm_s;
    }
    
    @XmlElement
    public void setLb_bulging_mm_s(String lb_bulging_mm_s){
        this.lb_bulging_mm_s=lb_bulging_mm_s;
    }
        
    public String getLb_bulging_rank_s(){
        return lb_bulging_rank_s;
    }
    
    @XmlElement
    public void setLb_bulging_rank_s(String lb_bulging_rank_s){
        this.lb_bulging_rank_s=lb_bulging_rank_s;
    }
        
    public String getLb_dent2_deg_s(){
        return lb_dent2_deg_s;
    }
    
    @XmlElement
    public void setLb_dent2_deg_s(String lb_dent2_deg_s){
        this.lb_dent2_deg_s=lb_dent2_deg_s;
    }
        
    public String getLb_dent2_mm_s(){
        return lb_dent2_mm_s;
    }
    
    @XmlElement
    public void setLb_dent2_mm_s(String lb_dent2_mm_s){
        this.lb_dent2_mm_s=lb_dent2_mm_s;
    }
        
    public String getLb_dent2_rank_s(){
        return lb_dent2_rank_s;
    }
    
    @XmlElement
    public void setLb_dent2_rank_s(String lb_dent2_rank_s){
        this.lb_dent2_rank_s=lb_dent2_rank_s;
    }
        
    public String getLb_dent3_deg_s(){
        return lb_dent3_deg_s;
    }
    
    @XmlElement
    public void setLb_dent3_deg_s(String lb_dent3_deg_s){
        this.lb_dent3_deg_s=lb_dent3_deg_s;
    }
        
    public String getLb_dent3_mm_s(){
        return lb_dent3_mm_s;
    }
    
    @XmlElement
    public void setLb_dent3_mm_s(String lb_dent3_mm_s){
        this.lb_dent3_mm_s=lb_dent3_mm_s;
    }
        
    public String getLb_dent3_rank_s(){
        return lb_dent3_rank_s;
    }
    
    @XmlElement
    public void setLb_dent3_rank_s(String lb_dent3_rank_s){
        this.lb_dent3_rank_s=lb_dent3_rank_s;
    }
        
    public String getLb_dent_deg_s(){
        return lb_dent_deg_s;
    }
    
    @XmlElement
    public void setLb_dent_deg_s(String lb_dent_deg_s){
        this.lb_dent_deg_s=lb_dent_deg_s;
    }
        
    public String getLb_dent_mm_s(){
        return lb_dent_mm_s;
    }
    
    @XmlElement
    public void setLb_dent_mm_s(String lb_dent_mm_s){
        this.lb_dent_mm_s=lb_dent_mm_s;
    }
        
    public String getLb_dent_rank_s(){
        return lb_dent_rank_s;
    }
    
    @XmlElement
    public void setLb_dent_rank_s(String lb_dent_rank_s){
        this.lb_dent_rank_s=lb_dent_rank_s;
    }
        
    public String getLb_oa2_1h_deg_s(){
        return lb_oa2_1h_deg_s;
    }
    
    @XmlElement
    public void setLb_oa2_1h_deg_s(String lb_oa2_1h_deg_s){
        this.lb_oa2_1h_deg_s=lb_oa2_1h_deg_s;
    }
        
    public String getLb_oa2_1h_mm_s(){
        return lb_oa2_1h_mm_s;
    }
    
    @XmlElement
    public void setLb_oa2_1h_mm_s(String lb_oa2_1h_mm_s){
        this.lb_oa2_1h_mm_s=lb_oa2_1h_mm_s;
    }
        
    public String getLb_oa2_1h_rank_s(){
        return lb_oa2_1h_rank_s;
    }
    
    @XmlElement
    public void setLb_oa2_1h_rank_s(String lb_oa2_1h_rank_s){
        this.lb_oa2_1h_rank_s=lb_oa2_1h_rank_s;
    }
        
    public String getLb_oa2_deg_s(){
        return lb_oa2_deg_s;
    }
    
    @XmlElement
    public void setLb_oa2_deg_s(String lb_oa2_deg_s){
        this.lb_oa2_deg_s=lb_oa2_deg_s;
    }
        
    public String getLb_oa2_mm_s(){
        return lb_oa2_mm_s;
    }
    
    @XmlElement
    public void setLb_oa2_mm_s(String lb_oa2_mm_s){
        this.lb_oa2_mm_s=lb_oa2_mm_s;
    }
        
    public String getLb_oa2_rank_s(){
        return lb_oa2_rank_s;
    }
    
    @XmlElement
    public void setLb_oa2_rank_s(String lb_oa2_rank_s){
        this.lb_oa2_rank_s=lb_oa2_rank_s;
    }
        
    public String getLb_oa3_1h_deg_s(){
        return lb_oa3_1h_deg_s;
    }
    
    @XmlElement
    public void setLb_oa3_1h_deg_s(String lb_oa3_1h_deg_s){
        this.lb_oa3_1h_deg_s=lb_oa3_1h_deg_s;
    }
        
    public String getLb_oa3_1h_mm_s(){
        return lb_oa3_1h_mm_s;
    }
    
    @XmlElement
    public void setLb_oa3_1h_mm_s(String lb_oa3_1h_mm_s){
        this.lb_oa3_1h_mm_s=lb_oa3_1h_mm_s;
    }
        
    public String getLb_oa3_1h_rank_s(){
        return lb_oa3_1h_rank_s;
    }
    
    @XmlElement
    public void setLb_oa3_1h_rank_s(String lb_oa3_1h_rank_s){
        this.lb_oa3_1h_rank_s=lb_oa3_1h_rank_s;
    }
        
    public String getLb_oa3_deg_s(){
        return lb_oa3_deg_s;
    }
    
    @XmlElement
    public void setLb_oa3_deg_s(String lb_oa3_deg_s){
        this.lb_oa3_deg_s=lb_oa3_deg_s;
    }
        
    public String getLb_oa3_mm_s(){
        return lb_oa3_mm_s;
    }
    
    @XmlElement
    public void setLb_oa3_mm_s(String lb_oa3_mm_s){
        this.lb_oa3_mm_s=lb_oa3_mm_s;
    }
        
    public String getLb_oa3_rank_s(){
        return lb_oa3_rank_s;
    }
    
    @XmlElement
    public void setLb_oa3_rank_s(String lb_oa3_rank_s){
        this.lb_oa3_rank_s=lb_oa3_rank_s;
    }
        
    public String getLb_oa_1h_deg_s(){
        return lb_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setLb_oa_1h_deg_s(String lb_oa_1h_deg_s){
        this.lb_oa_1h_deg_s=lb_oa_1h_deg_s;
    }
        
    public String getLb_oa_1h_mm_s(){
        return lb_oa_1h_mm_s;
    }
    
    @XmlElement
    public void setLb_oa_1h_mm_s(String lb_oa_1h_mm_s){
        this.lb_oa_1h_mm_s=lb_oa_1h_mm_s;
    }
        
    public String getLb_oa_1h_rank_s(){
        return lb_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setLb_oa_1h_rank_s(String lb_oa_1h_rank_s){
        this.lb_oa_1h_rank_s=lb_oa_1h_rank_s;
    }
        
    public String getLb_oa_deg_s(){
        return lb_oa_deg_s;
    }
    
    @XmlElement
    public void setLb_oa_deg_s(String lb_oa_deg_s){
        this.lb_oa_deg_s=lb_oa_deg_s;
    }
        
    public String getLb_oa_mm_s(){
        return lb_oa_mm_s;
    }
    
    @XmlElement
    public void setLb_oa_mm_s(String lb_oa_mm_s){
        this.lb_oa_mm_s=lb_oa_mm_s;
    }
        
    public String getLb_oa_rank_s(){
        return lb_oa_rank_s;
    }
    
    @XmlElement
    public void setLb_oa_rank_s(String lb_oa_rank_s){
        this.lb_oa_rank_s=lb_oa_rank_s;
    }
        
    public String getLower_unbalance_deg_s(){
        return lower_unbalance_deg_s;
    }
    
    @XmlElement
    public void setLower_unbalance_deg_s(String lower_unbalance_deg_s){
        this.lower_unbalance_deg_s=lower_unbalance_deg_s;
    }
        
    public String getLower_unbalance_g_s(){
        return lower_unbalance_g_s;
    }
    
    @XmlElement
    public void setLower_unbalance_g_s(String lower_unbalance_g_s){
        this.lower_unbalance_g_s=lower_unbalance_g_s;
    }
        
    public String getLower_unbalance_rank_s(){
        return lower_unbalance_rank_s;
    }
    
    @XmlElement
    public void setLower_unbalance_rank_s(String lower_unbalance_rank_s){
        this.lower_unbalance_rank_s=lower_unbalance_rank_s;
    }
        
    public String getLro_b1_nth_deg_s(){
        return lro_b1_nth_deg_s;
    }
    
    @XmlElement
    public void setLro_b1_nth_deg_s(String lro_b1_nth_deg_s){
        this.lro_b1_nth_deg_s=lro_b1_nth_deg_s;
    }
        
    public String getLro_b1_nth_mm_s(){
        return lro_b1_nth_mm_s;
    }
    
    @XmlElement
    public void setLro_b1_nth_mm_s(String lro_b1_nth_mm_s){
        this.lro_b1_nth_mm_s=lro_b1_nth_mm_s;
    }
        
    public String getLro_b1_nth_rank_s(){
        return lro_b1_nth_rank_s;
    }
    
    @XmlElement
    public void setLro_b1_nth_rank_s(String lro_b1_nth_rank_s){
        this.lro_b1_nth_rank_s=lro_b1_nth_rank_s;
    }
        
    public String getLro_b2_nth_deg_s(){
        return lro_b2_nth_deg_s;
    }
    
    @XmlElement
    public void setLro_b2_nth_deg_s(String lro_b2_nth_deg_s){
        this.lro_b2_nth_deg_s=lro_b2_nth_deg_s;
    }
        
    public String getLro_b2_nth_mm_s(){
        return lro_b2_nth_mm_s;
    }
    
    @XmlElement
    public void setLro_b2_nth_mm_s(String lro_b2_nth_mm_s){
        this.lro_b2_nth_mm_s=lro_b2_nth_mm_s;
    }
        
    public String getLro_b2_nth_rank_s(){
        return lro_b2_nth_rank_s;
    }
    
    @XmlElement
    public void setLro_b2_nth_rank_s(String lro_b2_nth_rank_s){
        this.lro_b2_nth_rank_s=lro_b2_nth_rank_s;
    }
        
    public String getLro_b3_nth_deg_s(){
        return lro_b3_nth_deg_s;
    }
    
    @XmlElement
    public void setLro_b3_nth_deg_s(String lro_b3_nth_deg_s){
        this.lro_b3_nth_deg_s=lro_b3_nth_deg_s;
    }
        
    public String getLro_b3_nth_mm_s(){
        return lro_b3_nth_mm_s;
    }
    
    @XmlElement
    public void setLro_b3_nth_mm_s(String lro_b3_nth_mm_s){
        this.lro_b3_nth_mm_s=lro_b3_nth_mm_s;
    }
        
    public String getLro_b3_nth_rank_s(){
        return lro_b3_nth_rank_s;
    }
    
    @XmlElement
    public void setLro_b3_nth_rank_s(String lro_b3_nth_rank_s){
        this.lro_b3_nth_rank_s=lro_b3_nth_rank_s;
    }
        
    public String getLro_t1_nth_deg_s(){
        return lro_t1_nth_deg_s;
    }
    
    @XmlElement
    public void setLro_t1_nth_deg_s(String lro_t1_nth_deg_s){
        this.lro_t1_nth_deg_s=lro_t1_nth_deg_s;
    }
        
    public String getLro_t1_nth_mm_s(){
        return lro_t1_nth_mm_s;
    }
    
    @XmlElement
    public void setLro_t1_nth_mm_s(String lro_t1_nth_mm_s){
        this.lro_t1_nth_mm_s=lro_t1_nth_mm_s;
    }
        
    public String getLro_t1_nth_rank_s(){
        return lro_t1_nth_rank_s;
    }
    
    @XmlElement
    public void setLro_t1_nth_rank_s(String lro_t1_nth_rank_s){
        this.lro_t1_nth_rank_s=lro_t1_nth_rank_s;
    }
        
    public String getLro_t2_nth_deg_s(){
        return lro_t2_nth_deg_s;
    }
    
    @XmlElement
    public void setLro_t2_nth_deg_s(String lro_t2_nth_deg_s){
        this.lro_t2_nth_deg_s=lro_t2_nth_deg_s;
    }
        
    public String getLro_t2_nth_mm_s(){
        return lro_t2_nth_mm_s;
    }
    
    @XmlElement
    public void setLro_t2_nth_mm_s(String lro_t2_nth_mm_s){
        this.lro_t2_nth_mm_s=lro_t2_nth_mm_s;
    }
        
    public String getLro_t2_nth_rank_s(){
        return lro_t2_nth_rank_s;
    }
    
    @XmlElement
    public void setLro_t2_nth_rank_s(String lro_t2_nth_rank_s){
        this.lro_t2_nth_rank_s=lro_t2_nth_rank_s;
    }
        
    public String getLro_t3_nth_deg_s(){
        return lro_t3_nth_deg_s;
    }
    
    @XmlElement
    public void setLro_t3_nth_deg_s(String lro_t3_nth_deg_s){
        this.lro_t3_nth_deg_s=lro_t3_nth_deg_s;
    }
        
    public String getLro_t3_nth_mm_s(){
        return lro_t3_nth_mm_s;
    }
    
    @XmlElement
    public void setLro_t3_nth_mm_s(String lro_t3_nth_mm_s){
        this.lro_t3_nth_mm_s=lro_t3_nth_mm_s;
    }
        
    public String getLro_t3_nth_rank_s(){
        return lro_t3_nth_rank_s;
    }
    
    @XmlElement
    public void setLro_t3_nth_rank_s(String lro_t3_nth_rank_s){
        this.lro_t3_nth_rank_s=lro_t3_nth_rank_s;
    }
        
    public String getLt_bulging2_deg_s(){
        return lt_bulging2_deg_s;
    }
    
    @XmlElement
    public void setLt_bulging2_deg_s(String lt_bulging2_deg_s){
        this.lt_bulging2_deg_s=lt_bulging2_deg_s;
    }
        
    public String getLt_bulging2_mm_s(){
        return lt_bulging2_mm_s;
    }
    
    @XmlElement
    public void setLt_bulging2_mm_s(String lt_bulging2_mm_s){
        this.lt_bulging2_mm_s=lt_bulging2_mm_s;
    }
        
    public String getLt_bulging2_rank_s(){
        return lt_bulging2_rank_s;
    }
    
    @XmlElement
    public void setLt_bulging2_rank_s(String lt_bulging2_rank_s){
        this.lt_bulging2_rank_s=lt_bulging2_rank_s;
    }
        
    public String getLt_bulging3_deg_s(){
        return lt_bulging3_deg_s;
    }
    
    @XmlElement
    public void setLt_bulging3_deg_s(String lt_bulging3_deg_s){
        this.lt_bulging3_deg_s=lt_bulging3_deg_s;
    }
        
    public String getLt_bulging3_mm_s(){
        return lt_bulging3_mm_s;
    }
    
    @XmlElement
    public void setLt_bulging3_mm_s(String lt_bulging3_mm_s){
        this.lt_bulging3_mm_s=lt_bulging3_mm_s;
    }
        
    public String getLt_bulging3_rank_s(){
        return lt_bulging3_rank_s;
    }
    
    @XmlElement
    public void setLt_bulging3_rank_s(String lt_bulging3_rank_s){
        this.lt_bulging3_rank_s=lt_bulging3_rank_s;
    }
        
    public String getLt_bulging_deg_s(){
        return lt_bulging_deg_s;
    }
    
    @XmlElement
    public void setLt_bulging_deg_s(String lt_bulging_deg_s){
        this.lt_bulging_deg_s=lt_bulging_deg_s;
    }
        
    public String getLt_bulging_mm_s(){
        return lt_bulging_mm_s;
    }
    
    @XmlElement
    public void setLt_bulging_mm_s(String lt_bulging_mm_s){
        this.lt_bulging_mm_s=lt_bulging_mm_s;
    }
        
    public String getLt_bulging_rank_s(){
        return lt_bulging_rank_s;
    }
    
    @XmlElement
    public void setLt_bulging_rank_s(String lt_bulging_rank_s){
        this.lt_bulging_rank_s=lt_bulging_rank_s;
    }
        
    public String getLt_dent2_deg_s(){
        return lt_dent2_deg_s;
    }
    
    @XmlElement
    public void setLt_dent2_deg_s(String lt_dent2_deg_s){
        this.lt_dent2_deg_s=lt_dent2_deg_s;
    }
        
    public String getLt_dent2_mm_s(){
        return lt_dent2_mm_s;
    }
    
    @XmlElement
    public void setLt_dent2_mm_s(String lt_dent2_mm_s){
        this.lt_dent2_mm_s=lt_dent2_mm_s;
    }
        
    public String getLt_dent2_rank_s(){
        return lt_dent2_rank_s;
    }
    
    @XmlElement
    public void setLt_dent2_rank_s(String lt_dent2_rank_s){
        this.lt_dent2_rank_s=lt_dent2_rank_s;
    }
        
    public String getLt_dent3_deg_s(){
        return lt_dent3_deg_s;
    }
    
    @XmlElement
    public void setLt_dent3_deg_s(String lt_dent3_deg_s){
        this.lt_dent3_deg_s=lt_dent3_deg_s;
    }
        
    public String getLt_dent3_mm_s(){
        return lt_dent3_mm_s;
    }
    
    @XmlElement
    public void setLt_dent3_mm_s(String lt_dent3_mm_s){
        this.lt_dent3_mm_s=lt_dent3_mm_s;
    }
        
    public String getLt_dent3_rank_s(){
        return lt_dent3_rank_s;
    }
    
    @XmlElement
    public void setLt_dent3_rank_s(String lt_dent3_rank_s){
        this.lt_dent3_rank_s=lt_dent3_rank_s;
    }
        
    public String getLt_dent_deg_s(){
        return lt_dent_deg_s;
    }
    
    @XmlElement
    public void setLt_dent_deg_s(String lt_dent_deg_s){
        this.lt_dent_deg_s=lt_dent_deg_s;
    }
        
    public String getLt_dent_mm_s(){
        return lt_dent_mm_s;
    }
    
    @XmlElement
    public void setLt_dent_mm_s(String lt_dent_mm_s){
        this.lt_dent_mm_s=lt_dent_mm_s;
    }
        
    public String getLt_dent_rank_s(){
        return lt_dent_rank_s;
    }
    
    @XmlElement
    public void setLt_dent_rank_s(String lt_dent_rank_s){
        this.lt_dent_rank_s=lt_dent_rank_s;
    }
        
    public String getLt_oa2_1h_deg_s(){
        return lt_oa2_1h_deg_s;
    }
    
    @XmlElement
    public void setLt_oa2_1h_deg_s(String lt_oa2_1h_deg_s){
        this.lt_oa2_1h_deg_s=lt_oa2_1h_deg_s;
    }
        
    public String getLt_oa2_1h_mm_s(){
        return lt_oa2_1h_mm_s;
    }
    
    @XmlElement
    public void setLt_oa2_1h_mm_s(String lt_oa2_1h_mm_s){
        this.lt_oa2_1h_mm_s=lt_oa2_1h_mm_s;
    }
        
    public String getLt_oa2_1h_rank_s(){
        return lt_oa2_1h_rank_s;
    }
    
    @XmlElement
    public void setLt_oa2_1h_rank_s(String lt_oa2_1h_rank_s){
        this.lt_oa2_1h_rank_s=lt_oa2_1h_rank_s;
    }
        
    public String getLt_oa2_deg_s(){
        return lt_oa2_deg_s;
    }
    
    @XmlElement
    public void setLt_oa2_deg_s(String lt_oa2_deg_s){
        this.lt_oa2_deg_s=lt_oa2_deg_s;
    }
        
    public String getLt_oa2_mm_s(){
        return lt_oa2_mm_s;
    }
    
    @XmlElement
    public void setLt_oa2_mm_s(String lt_oa2_mm_s){
        this.lt_oa2_mm_s=lt_oa2_mm_s;
    }
        
    public String getLt_oa2_rank_s(){
        return lt_oa2_rank_s;
    }
    
    @XmlElement
    public void setLt_oa2_rank_s(String lt_oa2_rank_s){
        this.lt_oa2_rank_s=lt_oa2_rank_s;
    }
        
    public String getLt_oa3_1h_deg_s(){
        return lt_oa3_1h_deg_s;
    }
    
    @XmlElement
    public void setLt_oa3_1h_deg_s(String lt_oa3_1h_deg_s){
        this.lt_oa3_1h_deg_s=lt_oa3_1h_deg_s;
    }
        
    public String getLt_oa3_1h_mm_s(){
        return lt_oa3_1h_mm_s;
    }
    
    @XmlElement
    public void setLt_oa3_1h_mm_s(String lt_oa3_1h_mm_s){
        this.lt_oa3_1h_mm_s=lt_oa3_1h_mm_s;
    }
        
    public String getLt_oa3_1h_rank_s(){
        return lt_oa3_1h_rank_s;
    }
    
    @XmlElement
    public void setLt_oa3_1h_rank_s(String lt_oa3_1h_rank_s){
        this.lt_oa3_1h_rank_s=lt_oa3_1h_rank_s;
    }
        
    public String getLt_oa3_deg_s(){
        return lt_oa3_deg_s;
    }
    
    @XmlElement
    public void setLt_oa3_deg_s(String lt_oa3_deg_s){
        this.lt_oa3_deg_s=lt_oa3_deg_s;
    }
        
    public String getLt_oa3_mm_s(){
        return lt_oa3_mm_s;
    }
    
    @XmlElement
    public void setLt_oa3_mm_s(String lt_oa3_mm_s){
        this.lt_oa3_mm_s=lt_oa3_mm_s;
    }
        
    public String getLt_oa3_rank_s(){
        return lt_oa3_rank_s;
    }
    
    @XmlElement
    public void setLt_oa3_rank_s(String lt_oa3_rank_s){
        this.lt_oa3_rank_s=lt_oa3_rank_s;
    }
        
    public String getLt_oa_1h_deg_s(){
        return lt_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setLt_oa_1h_deg_s(String lt_oa_1h_deg_s){
        this.lt_oa_1h_deg_s=lt_oa_1h_deg_s;
    }
        
    public String getLt_oa_1h_mm_s(){
        return lt_oa_1h_mm_s;
    }
    
    @XmlElement
    public void setLt_oa_1h_mm_s(String lt_oa_1h_mm_s){
        this.lt_oa_1h_mm_s=lt_oa_1h_mm_s;
    }
        
    public String getLt_oa_1h_rank_s(){
        return lt_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setLt_oa_1h_rank_s(String lt_oa_1h_rank_s){
        this.lt_oa_1h_rank_s=lt_oa_1h_rank_s;
    }
        
    public String getLt_oa_deg_s(){
        return lt_oa_deg_s;
    }
    
    @XmlElement
    public void setLt_oa_deg_s(String lt_oa_deg_s){
        this.lt_oa_deg_s=lt_oa_deg_s;
    }
        
    public String getLt_oa_mm_s(){
        return lt_oa_mm_s;
    }
    
    @XmlElement
    public void setLt_oa_mm_s(String lt_oa_mm_s){
        this.lt_oa_mm_s=lt_oa_mm_s;
    }
        
    public String getLt_oa_rank_s(){
        return lt_oa_rank_s;
    }
    
    @XmlElement
    public void setLt_oa_rank_s(String lt_oa_rank_s){
        this.lt_oa_rank_s=lt_oa_rank_s;
    }
        
    public String getMachinebar_s(){
        return machinebar_s;
    }
    
    @XmlElement
    public void setMachinebar_s(String machinebar_s){
        this.machinebar_s=machinebar_s;
    }
        
    public String getRb_oa_1h_deg_s(){
        return rb_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setRb_oa_1h_deg_s(String rb_oa_1h_deg_s){
        this.rb_oa_1h_deg_s=rb_oa_1h_deg_s;
    }
        
    public String getRb_oa_1h_mm_s(){
        return rb_oa_1h_mm_s;
    }
    
    @XmlElement
    public void setRb_oa_1h_mm_s(String rb_oa_1h_mm_s){
        this.rb_oa_1h_mm_s=rb_oa_1h_mm_s;
    }
        
    public String getRb_oa_1h_rank_s(){
        return rb_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setRb_oa_1h_rank_s(String rb_oa_1h_rank_s){
        this.rb_oa_1h_rank_s=rb_oa_1h_rank_s;
    }
        
    public String getRb_oa_deg_s(){
        return rb_oa_deg_s;
    }
    
    @XmlElement
    public void setRb_oa_deg_s(String rb_oa_deg_s){
        this.rb_oa_deg_s=rb_oa_deg_s;
    }
        
    public String getRb_oa_mm_s(){
        return rb_oa_mm_s;
    }
    
    @XmlElement
    public void setRb_oa_mm_s(String rb_oa_mm_s){
        this.rb_oa_mm_s=rb_oa_mm_s;
    }
        
    public String getRb_oa_rank_s(){
        return rb_oa_rank_s;
    }
    
    @XmlElement
    public void setRb_oa_rank_s(String rb_oa_rank_s){
        this.rb_oa_rank_s=rb_oa_rank_s;
    }
        
    public String getRc_oa_1h_deg_s(){
        return rc_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setRc_oa_1h_deg_s(String rc_oa_1h_deg_s){
        this.rc_oa_1h_deg_s=rc_oa_1h_deg_s;
    }
        
    public String getRc_oa_1h_mm_s(){
        return rc_oa_1h_mm_s;
    }
    
    @XmlElement
    public void setRc_oa_1h_mm_s(String rc_oa_1h_mm_s){
        this.rc_oa_1h_mm_s=rc_oa_1h_mm_s;
    }
        
    public String getRc_oa_1h_rank_s(){
        return rc_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setRc_oa_1h_rank_s(String rc_oa_1h_rank_s){
        this.rc_oa_1h_rank_s=rc_oa_1h_rank_s;
    }
        
    public String getRc_oa_deg_s(){
        return rc_oa_deg_s;
    }
    
    @XmlElement
    public void setRc_oa_deg_s(String rc_oa_deg_s){
        this.rc_oa_deg_s=rc_oa_deg_s;
    }
        
    public String getRc_oa_mm_s(){
        return rc_oa_mm_s;
    }
    
    @XmlElement
    public void setRc_oa_mm_s(String rc_oa_mm_s){
        this.rc_oa_mm_s=rc_oa_mm_s;
    }
        
    public String getRc_oa_rank_s(){
        return rc_oa_rank_s;
    }
    
    @XmlElement
    public void setRc_oa_rank_s(String rc_oa_rank_s){
        this.rc_oa_rank_s=rc_oa_rank_s;
    }
        
    public String getRecord_flag_s(){
        return record_flag_s;
    }
    
    @XmlElement
    public void setRecord_flag_s(String record_flag_s){
        this.record_flag_s=record_flag_s;
    }
        
    public String getRemark_s(){
        return remark_s;
    }
    
    @XmlElement
    public void setRemark_s(String remark_s){
        this.remark_s=remark_s;
    }
        
    public String getRo_total_rank_s(){
        return ro_total_rank_s;
    }
    
    @XmlElement
    public void setRo_total_rank_s(String ro_total_rank_s){
        this.ro_total_rank_s=ro_total_rank_s;
    }
        
    public String getRro_b_nth_deg_s(){
        return rro_b_nth_deg_s;
    }
    
    @XmlElement
    public void setRro_b_nth_deg_s(String rro_b_nth_deg_s){
        this.rro_b_nth_deg_s=rro_b_nth_deg_s;
    }
        
    public String getRro_b_nth_mm_s(){
        return rro_b_nth_mm_s;
    }
    
    @XmlElement
    public void setRro_b_nth_mm_s(String rro_b_nth_mm_s){
        this.rro_b_nth_mm_s=rro_b_nth_mm_s;
    }
        
    public String getRro_b_nth_rank_s(){
        return rro_b_nth_rank_s;
    }
    
    @XmlElement
    public void setRro_b_nth_rank_s(String rro_b_nth_rank_s){
        this.rro_b_nth_rank_s=rro_b_nth_rank_s;
    }
        
    public String getRro_c_nth_deg_s(){
        return rro_c_nth_deg_s;
    }
    
    @XmlElement
    public void setRro_c_nth_deg_s(String rro_c_nth_deg_s){
        this.rro_c_nth_deg_s=rro_c_nth_deg_s;
    }
        
    public String getRro_c_nth_mm_s(){
        return rro_c_nth_mm_s;
    }
    
    @XmlElement
    public void setRro_c_nth_mm_s(String rro_c_nth_mm_s){
        this.rro_c_nth_mm_s=rro_c_nth_mm_s;
    }
        
    public String getRro_c_nth_rank_s(){
        return rro_c_nth_rank_s;
    }
    
    @XmlElement
    public void setRro_c_nth_rank_s(String rro_c_nth_rank_s){
        this.rro_c_nth_rank_s=rro_c_nth_rank_s;
    }
        
    public String getRro_t_nth_deg_s(){
        return rro_t_nth_deg_s;
    }
    
    @XmlElement
    public void setRro_t_nth_deg_s(String rro_t_nth_deg_s){
        this.rro_t_nth_deg_s=rro_t_nth_deg_s;
    }
        
    public String getRro_t_nth_mm_s(){
        return rro_t_nth_mm_s;
    }
    
    @XmlElement
    public void setRro_t_nth_mm_s(String rro_t_nth_mm_s){
        this.rro_t_nth_mm_s=rro_t_nth_mm_s;
    }
        
    public String getRro_t_nth_rank_s(){
        return rro_t_nth_rank_s;
    }
    
    @XmlElement
    public void setRro_t_nth_rank_s(String rro_t_nth_rank_s){
        this.rro_t_nth_rank_s=rro_t_nth_rank_s;
    }
        
    public String getRt_oa_1h_deg_s(){
        return rt_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setRt_oa_1h_deg_s(String rt_oa_1h_deg_s){
        this.rt_oa_1h_deg_s=rt_oa_1h_deg_s;
    }
        
    public String getRt_oa_1h_mm_s(){
        return rt_oa_1h_mm_s;
    }
    
    @XmlElement
    public void setRt_oa_1h_mm_s(String rt_oa_1h_mm_s){
        this.rt_oa_1h_mm_s=rt_oa_1h_mm_s;
    }
        
    public String getRt_oa_1h_rank_s(){
        return rt_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setRt_oa_1h_rank_s(String rt_oa_1h_rank_s){
        this.rt_oa_1h_rank_s=rt_oa_1h_rank_s;
    }
        
    public String getRt_oa_deg_s(){
        return rt_oa_deg_s;
    }
    
    @XmlElement
    public void setRt_oa_deg_s(String rt_oa_deg_s){
        this.rt_oa_deg_s=rt_oa_deg_s;
    }
        
    public String getRt_oa_mm_s(){
        return rt_oa_mm_s;
    }
    
    @XmlElement
    public void setRt_oa_mm_s(String rt_oa_mm_s){
        this.rt_oa_mm_s=rt_oa_mm_s;
    }
        
    public String getRt_oa_rank_s(){
        return rt_oa_rank_s;
    }
    
    @XmlElement
    public void setRt_oa_rank_s(String rt_oa_rank_s){
        this.rt_oa_rank_s=rt_oa_rank_s;
    }
        
    public String getSap_item_s(){
        return sap_item_s;
    }
    
    @XmlElement
    public void setSap_item_s(String sap_item_s){
        this.sap_item_s=sap_item_s;
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
        
    public String getStatic_unbalance_deg_s(){
        return static_unbalance_deg_s;
    }
    
    @XmlElement
    public void setStatic_unbalance_deg_s(String static_unbalance_deg_s){
        this.static_unbalance_deg_s=static_unbalance_deg_s;
    }
        
    public String getStatic_unbalance_g_s(){
        return static_unbalance_g_s;
    }
    
    @XmlElement
    public void setStatic_unbalance_g_s(String static_unbalance_g_s){
        this.static_unbalance_g_s=static_unbalance_g_s;
    }
        
    public String getStatic_unbalance_rank_s(){
        return static_unbalance_rank_s;
    }
    
    @XmlElement
    public void setStatic_unbalance_rank_s(String static_unbalance_rank_s){
        this.static_unbalance_rank_s=static_unbalance_rank_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getTestmode_s(){
        return testmode_s;
    }
    
    @XmlElement
    public void setTestmode_s(String testmode_s){
        this.testmode_s=testmode_s;
    }
        
    public String getUpper_unbalance_deg_s(){
        return upper_unbalance_deg_s;
    }
    
    @XmlElement
    public void setUpper_unbalance_deg_s(String upper_unbalance_deg_s){
        this.upper_unbalance_deg_s=upper_unbalance_deg_s;
    }
        
    public String getUpper_unbalance_g_s(){
        return upper_unbalance_g_s;
    }
    
    @XmlElement
    public void setUpper_unbalance_g_s(String upper_unbalance_g_s){
        this.upper_unbalance_g_s=upper_unbalance_g_s;
    }
        
    public String getUpper_unbalance_rank_s(){
        return upper_unbalance_rank_s;
    }
    
    @XmlElement
    public void setUpper_unbalance_rank_s(String upper_unbalance_rank_s){
        this.upper_unbalance_rank_s=upper_unbalance_rank_s;
    }
        
    public String getUp_low_unbalance_g_s(){
        return up_low_unbalance_g_s;
    }
    
    @XmlElement
    public void setUp_low_unbalance_g_s(String up_low_unbalance_g_s){
        this.up_low_unbalance_g_s=up_low_unbalance_g_s;
    }
        
    public String getUp_low_unbalance_rank_s(){
        return up_low_unbalance_rank_s;
    }
    
    @XmlElement
    public void setUp_low_unbalance_rank_s(String up_low_unbalance_rank_s){
        this.up_low_unbalance_rank_s=up_low_unbalance_rank_s;
    }
        
    
    
    
}
