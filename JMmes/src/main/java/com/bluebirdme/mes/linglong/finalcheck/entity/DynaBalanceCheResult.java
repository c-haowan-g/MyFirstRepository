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
 * 质检动平衡检测结果表
 * @author 时永良
 * @Date 2019-08-07 16:24:09
 */
@ATDefinition("D_QM_DYNABALANCECHERESULT")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_DYNABALANCECHERESULT")
public class DynaBalanceCheResult extends RockWellBaseEntity{
    
    
    @Comment("机构编号：招远8000；德州8002；柳州8003；泰国8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=false,length=80)
    private String arch_flag_s;
    
    @Comment("动平衡总等级")
    @Column(nullable=true,length=80)
    private String balancetotal_rank_s;
    
    @Comment("轮胎条码：MainTyre 表 BARCODE")
    @Column(nullable=true,length=80)
    private String barcode_s;
    
    @Comment("反转侧向力偏移值")
    @Column(nullable=true,length=80)
    private String ccw_lfd_kgf_s;
    
    @Comment("反转侧向力偏移等级")
    @Column(nullable=true,length=80)
    private String ccw_lfd_rank_s;
    
    @Comment("反转侧向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_10h_deg_s;
    
    @Comment("反转侧向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_10h_kgf_s;
    
    @Comment("反转侧向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_10h_rank_s;
    
    @Comment("反转侧向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_1h_deg_s;
    
    @Comment("反转侧向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_1h_kgf_s;
    
    @Comment("反转侧向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_1h_rank_s;
    
    @Comment("反转侧向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_2h_deg_s;
    
    @Comment("反转侧向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_2h_kgf_s;
    
    @Comment("反转侧向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_2h_rank_s;
    
    @Comment("反转侧向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_3h_deg_s;
    
    @Comment("反转侧向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_3h_kgf_s;
    
    @Comment("反转侧向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_3h_rank_s;
    
    @Comment("反转侧向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_4h_deg_s;
    
    @Comment("反转侧向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_4h_kgf_s;
    
    @Comment("反转侧向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_4h_rank_s;
    
    @Comment("反转侧向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_5h_deg_s;
    
    @Comment("反转侧向力波动五次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_5h_kgf_s;
    
    @Comment("反转侧向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_5h_rank_s;
    
    @Comment("反转侧向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_6h_deg_s;
    
    @Comment("反转侧向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_6h_kgf_s;
    
    @Comment("反转侧向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_6h_rank_s;
    
    @Comment("反转侧向力波动七次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_7h_deg_s;
    
    @Comment("反转侧向力波动七次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_7h_kgf_s;
    
    @Comment("反转侧向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_7h_rank_s;
    
    @Comment("反转侧向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_8h_deg_s;
    
    @Comment("反转侧向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_8h_kgf_s;
    
    @Comment("反转侧向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_8h_rank_s;
    
    @Comment("反转侧向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_9h_deg_s;
    
    @Comment("反转侧向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_9h_kgf_s;
    
    @Comment("反转侧向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_9h_rank_s;
    
    @Comment("反转侧向力波动角度")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_deg_s;
    
    @Comment("反转侧向力波动值 ")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_kgf_s;
    
    @Comment("反转侧向力波动等级")
    @Column(nullable=true,length=80)
    private String ccw_lfvoa_rank_s;
    
    @Comment("反转径向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_10h_deg_s;
    
    @Comment("反转径向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_10h_kgf_s;
    
    @Comment("反转径向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_10h_rank_s;
    
    @Comment("反转径向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_1h_deg_s;
    
    @Comment("反转径向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_1h_kgf_s;
    
    @Comment("反转径向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_1h_rank_s;
    
    @Comment("反转径向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_2h_deg_s;
    
    @Comment("反转径向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_2h_kgf_s;
    
    @Comment("反转径向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_2h_rank_s;
    
    @Comment("反转径向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_3h_deg_s;
    
    @Comment("反转径向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_3h_kgf_s;
    
    @Comment("反转径向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_3h_rank_s;
    
    @Comment("反转径向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_4h_deg_s;
    
    @Comment("反转径向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_4h_kgf_s;
    
    @Comment("反转径向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_4h_rank_s;
    
    @Comment("反转径向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_5h_deg_s;
    
    @Comment("反转径向力波动五次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_5h_kgf_s;
    
    @Comment("反转径向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_5h_rank_s;
    
    @Comment("反转径向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_6h_deg_s;
    
    @Comment("反转径向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_6h_kgf_s;
    
    @Comment("反转径向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_6h_rank_s;
    
    @Comment("反转径向力波动七次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_7h_deg_s;
    
    @Comment("反转径向力波动七次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_7h_kgf_s;
    
    @Comment("反转径向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_7h_rank_s;
    
    @Comment("反转径向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_8h_deg_s;
    
    @Comment("反转径向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_8h_kgf_s;
    
    @Comment("反转径向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_8h_rank_s;
    
    @Comment("反转径向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_9h_deg_s;
    
    @Comment("反转径向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_9h_kgf_s;
    
    @Comment("反转径向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_9h_rank_s;
    
    @Comment("反转径向力波动角度 ")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_deg_s;
    
    @Comment("反转径向力波动值")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_kgf_s;
    
    @Comment("反转径向力波动等级")
    @Column(nullable=true,length=80)
    private String ccw_rfvoa_rank_s;
    
    @Comment("修改人")
    @Column(nullable=true,length=80)
    private String changed_by_s;
    
    @Comment("修改时间")
    @Column(nullable=true,length=0)
    private Date changed_time_t;
    
    @Comment("锥度值")
    @Column(nullable=true,length=80)
    private String con_kgf_s;
    
    @Comment("锥度等级")
    @Column(nullable=true,length=80)
    private String con_rank_s;
    
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
    @Column(nullable=false,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=false,length=0)
    private Date created_time_t;
    
    @Comment("正转侧向力偏移值")
    @Column(nullable=true,length=80)
    private String cw_lfd_kgf_s;
    
    @Comment("正转侧向力偏移等级 ")
    @Column(nullable=true,length=80)
    private String cw_lfd_rank_s;
    
    @Comment("侧向力波动十次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_10h_deg_s;
    
    @Comment("侧向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_10h_kgf_s;
    
    @Comment("侧向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_10h_rank_s;
    
    @Comment("侧向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_1h_deg_s;
    
    @Comment("侧向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_1h_kgf_s;
    
    @Comment("侧向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_1h_rank_s;
    
    @Comment("侧向力波动二次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_2h_deg_s;
    
    @Comment("侧向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_2h_kgf_s;
    
    @Comment("侧向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_2h_rank_s;
    
    @Comment("侧向力波动三次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_3h_deg_s;
    
    @Comment("侧向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_3h_kgf_s;
    
    @Comment("侧向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_3h_rank_s;
    
    @Comment("侧向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_4h_deg_s;
    
    @Comment("侧向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_4h_kgf_s;
    
    @Comment("侧向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_4h_rank_s;
    
    @Comment("侧向力波动五次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_5h_deg_s;
    
    @Comment("侧向力波动五次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_5h_kgf_s;
    
    @Comment("侧向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_5h_rank_s;
    
    @Comment("侧向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_6h_deg_s;
    
    @Comment("侧向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_6h_kgf_s;
    
    @Comment("侧向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_6h_rank_s;
    
    @Comment("侧向力波动七次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_7h_deg_s;
    
    @Comment("侧向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_7h_kgf_s;
    
    @Comment("侧向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_7h_rank_s;
    
    @Comment("侧向力波动八次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_8h_deg_s;
    
    @Comment("侧向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_8h_kgf_s;
    
    @Comment("侧向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_8h_rank_s;
    
    @Comment("侧向力波动九次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_9h_deg_s;
    
    @Comment("侧向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_9h_kgf_s;
    
    @Comment("侧向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_9h_rank_s;
    
    @Comment("侧向力波动角度")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_deg_s;
    
    @Comment("侧向力波动值 ")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_kgf_s;
    
    @Comment("侧向力波动等级")
    @Column(nullable=true,length=80)
    private String cw_lfvoa_rank_s;
    
    @Comment("径向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_10h_deg_s;
    
    @Comment("径向力波动十次谐波值 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_10h_kgf_s;
    
    @Comment("径向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_10h_rank_s;
    
    @Comment("径向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_1h_deg_s;
    
    @Comment("径向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_1h_kgf_s;
    
    @Comment("径向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_1h_rank_s;
    
    @Comment("径向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_2h_deg_s;
    
    @Comment("径向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_2h_kgf_s;
    
    @Comment("径向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_2h_rank_s;
    
    @Comment("径向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_3h_deg_s;
    
    @Comment("径向力波动三次谐波值 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_3h_kgf_s;
    
    @Comment("径向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_3h_rank_s;
    
    @Comment("径向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_4h_deg_s;
    
    @Comment("径向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_4h_kgf_s;
    
    @Comment("径向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_4h_rank_s;
    
    @Comment("径向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_5h_deg_s;
    
    @Comment("径向力波动五次谐波值 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_5h_kgf_s;
    
    @Comment("径向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_5h_rank_s;
    
    @Comment("径向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_6h_deg_s;
    
    @Comment("径向力波动六次谐波值 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_6h_kgf_s;
    
    @Comment("径向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_6h_rank_s;
    
    @Comment("径向力波动七次谐波角度 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_7h_deg_s;
    
    @Comment("径向力波动七次谐波值 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_7h_kgf_s;
    
    @Comment("径向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_7h_rank_s;
    
    @Comment("径向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_8h_deg_s;
    
    @Comment("径向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_8h_kgf_s;
    
    @Comment("径向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_8h_rank_s;
    
    @Comment("径向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_9h_deg_s;
    
    @Comment("径向力波动九次谐波值 ")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_9h_kgf_s;
    
    @Comment("径向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_9h_rank_s;
    
    @Comment("径向力波动角度")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_deg_s;
    
    @Comment("径向力波动值")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_kgf_s;
    
    @Comment("径向力波动等级")
    @Column(nullable=true,length=80)
    private String cw_rfvoa_rank_s;
    
    @Comment("下部侧向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String lboa_1h_deg_s;
    
    @Comment("下部侧向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String lboa_1h_mm_s;
    
    @Comment("下部侧向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String lboa_1h_rank_s;
    
    @Comment("下部侧向跳动角度")
    @Column(nullable=true,length=80)
    private String lboa_deg_s;
    
    @Comment("下部侧向跳动值")
    @Column(nullable=true,length=80)
    private String lboa_mm_s;
    
    @Comment("下部侧向跳动等级")
    @Column(nullable=true,length=80)
    private String lboa_rank_s;
    
    @Comment("下部侧向凸角度")
    @Column(nullable=true,length=80)
    private String lb_bulging_deg_s;
    
    @Comment("下部侧向凸值 ")
    @Column(nullable=true,length=80)
    private String lb_bulging_mm_s;
    
    @Comment("下部侧向凸等级")
    @Column(nullable=true,length=80)
    private String lb_bulging_rank_s;
    
    @Comment("下部侧向凹角度")
    @Column(nullable=true,length=80)
    private String lb_dent_deg_s;
    
    @Comment("下部侧向凹值")
    @Column(nullable=true,length=80)
    private String lb_dent_mm_s;
    
    @Comment("下部侧向凹等级")
    @Column(nullable=true,length=80)
    private String lb_dent_rank_s;
    
    @Comment("荷重")
    @Column(nullable=true,length=80)
    private String load_s;
    
    @Comment("下面不平衡量角度")
    @Column(nullable=true,length=80)
    private String lower_unbalance_deg_s;
    
    @Comment("下面不平衡量")
    @Column(nullable=true,length=80)
    private String lower_unbalance_g_s;
    
    @Comment("下面不平衡量等级")
    @Column(nullable=true,length=80)
    private String lower_unbalance_rank_s;
    
    @Comment("上部侧向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String ltoa_1h_deg_s;
    
    @Comment("上部侧向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String ltoa_1h_mm_s;
    
    @Comment("上部侧向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String ltoa_1h_rank_s;
    
    @Comment("上部侧向跳动角度")
    @Column(nullable=true,length=80)
    private String ltoa_deg_s;
    
    @Comment("上部侧向跳动值")
    @Column(nullable=true,length=80)
    private String ltoa_mm_s;
    
    @Comment("上部侧向跳动等级")
    @Column(nullable=true,length=80)
    private String ltoa_rank_s;
    
    @Comment("上部侧向凸角度")
    @Column(nullable=true,length=80)
    private String lt_bulging_deg_s;
    
    @Comment("上部侧向凸值 ")
    @Column(nullable=true,length=80)
    private String lt_bulging_mm_s;
    
    @Comment("上部侧向凸等级")
    @Column(nullable=true,length=80)
    private String lt_bulging_rank_s;
    
    @Comment("上部侧向凹角度")
    @Column(nullable=true,length=80)
    private String lt_dent_deg_s;
    
    @Comment("上部侧向凹值")
    @Column(nullable=true,length=80)
    private String lt_dent_mm_s;
    
    @Comment("上部侧向凹等级")
    @Column(nullable=true,length=80)
    private String lt_dent_rank_s;
    
    @Comment("动平衡机台条码：D_EM_Ent 表 ENTBARCODE")
    @Column(nullable=true,length=80)
    private String machinebar_s;
    
    @Comment("MODELNO")
    @Column(nullable=true,length=80)
    private String modelno_s;
    
    @Comment("测试时间")
    @Column(nullable=true,length=0)
    private Date outputtime_t;
    
    @Comment("轮胎外直径")
    @Column(nullable=true,length=80)
    private String outsidediameter_mm_s;
    
    @Comment("轮胎外直径等级")
    @Column(nullable=true,length=80)
    private String outsidediameter_rank_s;
    
    @Comment("帘布效应（跑偏，角度效应）")
    @Column(nullable=true,length=80)
    private String ply_kgf_s;
    
    @Comment("帘布效应等级")
    @Column(nullable=true,length=80)
    private String ply_rank_s;
    
    @Comment("下部径向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String rboa_1h_deg_s;
    
    @Comment("下部径向跳动一次谐波值 ")
    @Column(nullable=true,length=80)
    private String rboa_1h_mm_s;
    
    @Comment("下部径向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String rboa_1h_rank_s;
    
    @Comment("下部径向跳动角度")
    @Column(nullable=true,length=80)
    private String rboa_deg_s;
    
    @Comment("下部径向跳动值")
    @Column(nullable=true,length=80)
    private String rboa_mm_s;
    
    @Comment("下部径向跳动等级 ")
    @Column(nullable=true,length=80)
    private String rboa_rank_s;
    
    @Comment("中部径向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String rcoa_1h_deg_s;
    
    @Comment("中部径向跳动一次谐波值 ")
    @Column(nullable=true,length=80)
    private String rcoa_1h_mm_s;
    
    @Comment("中部径向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String rcoa_1h_rank_s;
    
    @Comment("中部径向跳动角度")
    @Column(nullable=true,length=80)
    private String rcoa_deg_s;
    
    @Comment("中部径向跳动值")
    @Column(nullable=true,length=80)
    private String rcoa_mm_s;
    
    @Comment("中部径向跳动等级 ")
    @Column(nullable=true,length=80)
    private String rcoa_rank_s;
    
    @Comment("记录标志，A可用，D删除")
    @Column(nullable=false,length=80)
    private String record_flag_s;
    
    @Comment("MES备注")
    @Column(nullable=true,length=80)
    private String remark_s;
    
    @Comment("跳动度总等级")
    @Column(nullable=true,length=80)
    private String rototal_rank_s;
    
    @Comment("上部径向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String rtoa_1h_deg_s;
    
    @Comment("上部径向跳动一次谐波值 ")
    @Column(nullable=true,length=80)
    private String rtoa_1h_mm_s;
    
    @Comment("上部径向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String rtoa_1h_rank_s;
    
    @Comment("上部径向跳动角度")
    @Column(nullable=true,length=80)
    private String rtoa_deg_s;
    
    @Comment("上部径向跳动值")
    @Column(nullable=true,length=80)
    private String rtoa_mm_s;
    
    @Comment("上部径向跳动等级 ")
    @Column(nullable=true,length=80)
    private String rtoa_rank_s;
    
    @Comment("静合成不平衡量角度 ")
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
    
    @Comment("轮胎总等级")
    @Column(nullable=true,length=80)
    private String tire_total_ratings_s;
    
    @Comment("均匀性总等级")
    @Column(nullable=true,length=80)
    private String ufm_totalrank_s;
    
    @Comment("上面+下面不平衡量")
    @Column(nullable=true,length=80)
    private String uplow_unbalance_g_s;
    
    @Comment("上面+下面不平衡量等级")
    @Column(nullable=true,length=80)
    private String uplow_unbalance_rank_s;
    
    @Comment("上面不平衡量角度")
    @Column(nullable=true,length=80)
    private String upper_unbalance_deg_s;
    
    @Comment("上面不平衡量")
    @Column(nullable=true,length=80)
    private String upper_unbalance_g_s;
    
    @Comment("上面不平衡量等级")
    @Column(nullable=true,length=80)
    private String upper_unbalance_rank_s;
    
    @Comment("轮胎重量等级")
    @Column(nullable=true,length=80)
    private String weight_rank_s;
    
    @Comment("轮胎重量")
    @Column(nullable=true,length=80)
    private String weight_s;
    
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
        
    public String getBalancetotal_rank_s(){
        return balancetotal_rank_s;
    }
    
    @XmlElement
    public void setBalancetotal_rank_s(String balancetotal_rank_s){
        this.balancetotal_rank_s=balancetotal_rank_s;
    }
        
    public String getBarcode_s(){
        return barcode_s;
    }
    
    @XmlElement
    public void setBarcode_s(String barcode_s){
        this.barcode_s=barcode_s;
    }
        
    public String getCcw_lfd_kgf_s(){
        return ccw_lfd_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfd_kgf_s(String ccw_lfd_kgf_s){
        this.ccw_lfd_kgf_s=ccw_lfd_kgf_s;
    }
        
    public String getCcw_lfd_rank_s(){
        return ccw_lfd_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfd_rank_s(String ccw_lfd_rank_s){
        this.ccw_lfd_rank_s=ccw_lfd_rank_s;
    }
        
    public String getCcw_lfvoa_10h_deg_s(){
        return ccw_lfvoa_10h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_10h_deg_s(String ccw_lfvoa_10h_deg_s){
        this.ccw_lfvoa_10h_deg_s=ccw_lfvoa_10h_deg_s;
    }
        
    public String getCcw_lfvoa_10h_kgf_s(){
        return ccw_lfvoa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_10h_kgf_s(String ccw_lfvoa_10h_kgf_s){
        this.ccw_lfvoa_10h_kgf_s=ccw_lfvoa_10h_kgf_s;
    }
        
    public String getCcw_lfvoa_10h_rank_s(){
        return ccw_lfvoa_10h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_10h_rank_s(String ccw_lfvoa_10h_rank_s){
        this.ccw_lfvoa_10h_rank_s=ccw_lfvoa_10h_rank_s;
    }
        
    public String getCcw_lfvoa_1h_deg_s(){
        return ccw_lfvoa_1h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_1h_deg_s(String ccw_lfvoa_1h_deg_s){
        this.ccw_lfvoa_1h_deg_s=ccw_lfvoa_1h_deg_s;
    }
        
    public String getCcw_lfvoa_1h_kgf_s(){
        return ccw_lfvoa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_1h_kgf_s(String ccw_lfvoa_1h_kgf_s){
        this.ccw_lfvoa_1h_kgf_s=ccw_lfvoa_1h_kgf_s;
    }
        
    public String getCcw_lfvoa_1h_rank_s(){
        return ccw_lfvoa_1h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_1h_rank_s(String ccw_lfvoa_1h_rank_s){
        this.ccw_lfvoa_1h_rank_s=ccw_lfvoa_1h_rank_s;
    }
        
    public String getCcw_lfvoa_2h_deg_s(){
        return ccw_lfvoa_2h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_2h_deg_s(String ccw_lfvoa_2h_deg_s){
        this.ccw_lfvoa_2h_deg_s=ccw_lfvoa_2h_deg_s;
    }
        
    public String getCcw_lfvoa_2h_kgf_s(){
        return ccw_lfvoa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_2h_kgf_s(String ccw_lfvoa_2h_kgf_s){
        this.ccw_lfvoa_2h_kgf_s=ccw_lfvoa_2h_kgf_s;
    }
        
    public String getCcw_lfvoa_2h_rank_s(){
        return ccw_lfvoa_2h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_2h_rank_s(String ccw_lfvoa_2h_rank_s){
        this.ccw_lfvoa_2h_rank_s=ccw_lfvoa_2h_rank_s;
    }
        
    public String getCcw_lfvoa_3h_deg_s(){
        return ccw_lfvoa_3h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_3h_deg_s(String ccw_lfvoa_3h_deg_s){
        this.ccw_lfvoa_3h_deg_s=ccw_lfvoa_3h_deg_s;
    }
        
    public String getCcw_lfvoa_3h_kgf_s(){
        return ccw_lfvoa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_3h_kgf_s(String ccw_lfvoa_3h_kgf_s){
        this.ccw_lfvoa_3h_kgf_s=ccw_lfvoa_3h_kgf_s;
    }
        
    public String getCcw_lfvoa_3h_rank_s(){
        return ccw_lfvoa_3h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_3h_rank_s(String ccw_lfvoa_3h_rank_s){
        this.ccw_lfvoa_3h_rank_s=ccw_lfvoa_3h_rank_s;
    }
        
    public String getCcw_lfvoa_4h_deg_s(){
        return ccw_lfvoa_4h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_4h_deg_s(String ccw_lfvoa_4h_deg_s){
        this.ccw_lfvoa_4h_deg_s=ccw_lfvoa_4h_deg_s;
    }
        
    public String getCcw_lfvoa_4h_kgf_s(){
        return ccw_lfvoa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_4h_kgf_s(String ccw_lfvoa_4h_kgf_s){
        this.ccw_lfvoa_4h_kgf_s=ccw_lfvoa_4h_kgf_s;
    }
        
    public String getCcw_lfvoa_4h_rank_s(){
        return ccw_lfvoa_4h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_4h_rank_s(String ccw_lfvoa_4h_rank_s){
        this.ccw_lfvoa_4h_rank_s=ccw_lfvoa_4h_rank_s;
    }
        
    public String getCcw_lfvoa_5h_deg_s(){
        return ccw_lfvoa_5h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_5h_deg_s(String ccw_lfvoa_5h_deg_s){
        this.ccw_lfvoa_5h_deg_s=ccw_lfvoa_5h_deg_s;
    }
        
    public String getCcw_lfvoa_5h_kgf_s(){
        return ccw_lfvoa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_5h_kgf_s(String ccw_lfvoa_5h_kgf_s){
        this.ccw_lfvoa_5h_kgf_s=ccw_lfvoa_5h_kgf_s;
    }
        
    public String getCcw_lfvoa_5h_rank_s(){
        return ccw_lfvoa_5h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_5h_rank_s(String ccw_lfvoa_5h_rank_s){
        this.ccw_lfvoa_5h_rank_s=ccw_lfvoa_5h_rank_s;
    }
        
    public String getCcw_lfvoa_6h_deg_s(){
        return ccw_lfvoa_6h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_6h_deg_s(String ccw_lfvoa_6h_deg_s){
        this.ccw_lfvoa_6h_deg_s=ccw_lfvoa_6h_deg_s;
    }
        
    public String getCcw_lfvoa_6h_kgf_s(){
        return ccw_lfvoa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_6h_kgf_s(String ccw_lfvoa_6h_kgf_s){
        this.ccw_lfvoa_6h_kgf_s=ccw_lfvoa_6h_kgf_s;
    }
        
    public String getCcw_lfvoa_6h_rank_s(){
        return ccw_lfvoa_6h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_6h_rank_s(String ccw_lfvoa_6h_rank_s){
        this.ccw_lfvoa_6h_rank_s=ccw_lfvoa_6h_rank_s;
    }
        
    public String getCcw_lfvoa_7h_deg_s(){
        return ccw_lfvoa_7h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_7h_deg_s(String ccw_lfvoa_7h_deg_s){
        this.ccw_lfvoa_7h_deg_s=ccw_lfvoa_7h_deg_s;
    }
        
    public String getCcw_lfvoa_7h_kgf_s(){
        return ccw_lfvoa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_7h_kgf_s(String ccw_lfvoa_7h_kgf_s){
        this.ccw_lfvoa_7h_kgf_s=ccw_lfvoa_7h_kgf_s;
    }
        
    public String getCcw_lfvoa_7h_rank_s(){
        return ccw_lfvoa_7h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_7h_rank_s(String ccw_lfvoa_7h_rank_s){
        this.ccw_lfvoa_7h_rank_s=ccw_lfvoa_7h_rank_s;
    }
        
    public String getCcw_lfvoa_8h_deg_s(){
        return ccw_lfvoa_8h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_8h_deg_s(String ccw_lfvoa_8h_deg_s){
        this.ccw_lfvoa_8h_deg_s=ccw_lfvoa_8h_deg_s;
    }
        
    public String getCcw_lfvoa_8h_kgf_s(){
        return ccw_lfvoa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_8h_kgf_s(String ccw_lfvoa_8h_kgf_s){
        this.ccw_lfvoa_8h_kgf_s=ccw_lfvoa_8h_kgf_s;
    }
        
    public String getCcw_lfvoa_8h_rank_s(){
        return ccw_lfvoa_8h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_8h_rank_s(String ccw_lfvoa_8h_rank_s){
        this.ccw_lfvoa_8h_rank_s=ccw_lfvoa_8h_rank_s;
    }
        
    public String getCcw_lfvoa_9h_deg_s(){
        return ccw_lfvoa_9h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_9h_deg_s(String ccw_lfvoa_9h_deg_s){
        this.ccw_lfvoa_9h_deg_s=ccw_lfvoa_9h_deg_s;
    }
        
    public String getCcw_lfvoa_9h_kgf_s(){
        return ccw_lfvoa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_9h_kgf_s(String ccw_lfvoa_9h_kgf_s){
        this.ccw_lfvoa_9h_kgf_s=ccw_lfvoa_9h_kgf_s;
    }
        
    public String getCcw_lfvoa_9h_rank_s(){
        return ccw_lfvoa_9h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_9h_rank_s(String ccw_lfvoa_9h_rank_s){
        this.ccw_lfvoa_9h_rank_s=ccw_lfvoa_9h_rank_s;
    }
        
    public String getCcw_lfvoa_deg_s(){
        return ccw_lfvoa_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_deg_s(String ccw_lfvoa_deg_s){
        this.ccw_lfvoa_deg_s=ccw_lfvoa_deg_s;
    }
        
    public String getCcw_lfvoa_kgf_s(){
        return ccw_lfvoa_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_kgf_s(String ccw_lfvoa_kgf_s){
        this.ccw_lfvoa_kgf_s=ccw_lfvoa_kgf_s;
    }
        
    public String getCcw_lfvoa_rank_s(){
        return ccw_lfvoa_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfvoa_rank_s(String ccw_lfvoa_rank_s){
        this.ccw_lfvoa_rank_s=ccw_lfvoa_rank_s;
    }
        
    public String getCcw_rfvoa_10h_deg_s(){
        return ccw_rfvoa_10h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_10h_deg_s(String ccw_rfvoa_10h_deg_s){
        this.ccw_rfvoa_10h_deg_s=ccw_rfvoa_10h_deg_s;
    }
        
    public String getCcw_rfvoa_10h_kgf_s(){
        return ccw_rfvoa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_10h_kgf_s(String ccw_rfvoa_10h_kgf_s){
        this.ccw_rfvoa_10h_kgf_s=ccw_rfvoa_10h_kgf_s;
    }
        
    public String getCcw_rfvoa_10h_rank_s(){
        return ccw_rfvoa_10h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_10h_rank_s(String ccw_rfvoa_10h_rank_s){
        this.ccw_rfvoa_10h_rank_s=ccw_rfvoa_10h_rank_s;
    }
        
    public String getCcw_rfvoa_1h_deg_s(){
        return ccw_rfvoa_1h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_1h_deg_s(String ccw_rfvoa_1h_deg_s){
        this.ccw_rfvoa_1h_deg_s=ccw_rfvoa_1h_deg_s;
    }
        
    public String getCcw_rfvoa_1h_kgf_s(){
        return ccw_rfvoa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_1h_kgf_s(String ccw_rfvoa_1h_kgf_s){
        this.ccw_rfvoa_1h_kgf_s=ccw_rfvoa_1h_kgf_s;
    }
        
    public String getCcw_rfvoa_1h_rank_s(){
        return ccw_rfvoa_1h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_1h_rank_s(String ccw_rfvoa_1h_rank_s){
        this.ccw_rfvoa_1h_rank_s=ccw_rfvoa_1h_rank_s;
    }
        
    public String getCcw_rfvoa_2h_deg_s(){
        return ccw_rfvoa_2h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_2h_deg_s(String ccw_rfvoa_2h_deg_s){
        this.ccw_rfvoa_2h_deg_s=ccw_rfvoa_2h_deg_s;
    }
        
    public String getCcw_rfvoa_2h_kgf_s(){
        return ccw_rfvoa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_2h_kgf_s(String ccw_rfvoa_2h_kgf_s){
        this.ccw_rfvoa_2h_kgf_s=ccw_rfvoa_2h_kgf_s;
    }
        
    public String getCcw_rfvoa_2h_rank_s(){
        return ccw_rfvoa_2h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_2h_rank_s(String ccw_rfvoa_2h_rank_s){
        this.ccw_rfvoa_2h_rank_s=ccw_rfvoa_2h_rank_s;
    }
        
    public String getCcw_rfvoa_3h_deg_s(){
        return ccw_rfvoa_3h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_3h_deg_s(String ccw_rfvoa_3h_deg_s){
        this.ccw_rfvoa_3h_deg_s=ccw_rfvoa_3h_deg_s;
    }
        
    public String getCcw_rfvoa_3h_kgf_s(){
        return ccw_rfvoa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_3h_kgf_s(String ccw_rfvoa_3h_kgf_s){
        this.ccw_rfvoa_3h_kgf_s=ccw_rfvoa_3h_kgf_s;
    }
        
    public String getCcw_rfvoa_3h_rank_s(){
        return ccw_rfvoa_3h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_3h_rank_s(String ccw_rfvoa_3h_rank_s){
        this.ccw_rfvoa_3h_rank_s=ccw_rfvoa_3h_rank_s;
    }
        
    public String getCcw_rfvoa_4h_deg_s(){
        return ccw_rfvoa_4h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_4h_deg_s(String ccw_rfvoa_4h_deg_s){
        this.ccw_rfvoa_4h_deg_s=ccw_rfvoa_4h_deg_s;
    }
        
    public String getCcw_rfvoa_4h_kgf_s(){
        return ccw_rfvoa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_4h_kgf_s(String ccw_rfvoa_4h_kgf_s){
        this.ccw_rfvoa_4h_kgf_s=ccw_rfvoa_4h_kgf_s;
    }
        
    public String getCcw_rfvoa_4h_rank_s(){
        return ccw_rfvoa_4h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_4h_rank_s(String ccw_rfvoa_4h_rank_s){
        this.ccw_rfvoa_4h_rank_s=ccw_rfvoa_4h_rank_s;
    }
        
    public String getCcw_rfvoa_5h_deg_s(){
        return ccw_rfvoa_5h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_5h_deg_s(String ccw_rfvoa_5h_deg_s){
        this.ccw_rfvoa_5h_deg_s=ccw_rfvoa_5h_deg_s;
    }
        
    public String getCcw_rfvoa_5h_kgf_s(){
        return ccw_rfvoa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_5h_kgf_s(String ccw_rfvoa_5h_kgf_s){
        this.ccw_rfvoa_5h_kgf_s=ccw_rfvoa_5h_kgf_s;
    }
        
    public String getCcw_rfvoa_5h_rank_s(){
        return ccw_rfvoa_5h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_5h_rank_s(String ccw_rfvoa_5h_rank_s){
        this.ccw_rfvoa_5h_rank_s=ccw_rfvoa_5h_rank_s;
    }
        
    public String getCcw_rfvoa_6h_deg_s(){
        return ccw_rfvoa_6h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_6h_deg_s(String ccw_rfvoa_6h_deg_s){
        this.ccw_rfvoa_6h_deg_s=ccw_rfvoa_6h_deg_s;
    }
        
    public String getCcw_rfvoa_6h_kgf_s(){
        return ccw_rfvoa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_6h_kgf_s(String ccw_rfvoa_6h_kgf_s){
        this.ccw_rfvoa_6h_kgf_s=ccw_rfvoa_6h_kgf_s;
    }
        
    public String getCcw_rfvoa_6h_rank_s(){
        return ccw_rfvoa_6h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_6h_rank_s(String ccw_rfvoa_6h_rank_s){
        this.ccw_rfvoa_6h_rank_s=ccw_rfvoa_6h_rank_s;
    }
        
    public String getCcw_rfvoa_7h_deg_s(){
        return ccw_rfvoa_7h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_7h_deg_s(String ccw_rfvoa_7h_deg_s){
        this.ccw_rfvoa_7h_deg_s=ccw_rfvoa_7h_deg_s;
    }
        
    public String getCcw_rfvoa_7h_kgf_s(){
        return ccw_rfvoa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_7h_kgf_s(String ccw_rfvoa_7h_kgf_s){
        this.ccw_rfvoa_7h_kgf_s=ccw_rfvoa_7h_kgf_s;
    }
        
    public String getCcw_rfvoa_7h_rank_s(){
        return ccw_rfvoa_7h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_7h_rank_s(String ccw_rfvoa_7h_rank_s){
        this.ccw_rfvoa_7h_rank_s=ccw_rfvoa_7h_rank_s;
    }
        
    public String getCcw_rfvoa_8h_deg_s(){
        return ccw_rfvoa_8h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_8h_deg_s(String ccw_rfvoa_8h_deg_s){
        this.ccw_rfvoa_8h_deg_s=ccw_rfvoa_8h_deg_s;
    }
        
    public String getCcw_rfvoa_8h_kgf_s(){
        return ccw_rfvoa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_8h_kgf_s(String ccw_rfvoa_8h_kgf_s){
        this.ccw_rfvoa_8h_kgf_s=ccw_rfvoa_8h_kgf_s;
    }
        
    public String getCcw_rfvoa_8h_rank_s(){
        return ccw_rfvoa_8h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_8h_rank_s(String ccw_rfvoa_8h_rank_s){
        this.ccw_rfvoa_8h_rank_s=ccw_rfvoa_8h_rank_s;
    }
        
    public String getCcw_rfvoa_9h_deg_s(){
        return ccw_rfvoa_9h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_9h_deg_s(String ccw_rfvoa_9h_deg_s){
        this.ccw_rfvoa_9h_deg_s=ccw_rfvoa_9h_deg_s;
    }
        
    public String getCcw_rfvoa_9h_kgf_s(){
        return ccw_rfvoa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_9h_kgf_s(String ccw_rfvoa_9h_kgf_s){
        this.ccw_rfvoa_9h_kgf_s=ccw_rfvoa_9h_kgf_s;
    }
        
    public String getCcw_rfvoa_9h_rank_s(){
        return ccw_rfvoa_9h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_9h_rank_s(String ccw_rfvoa_9h_rank_s){
        this.ccw_rfvoa_9h_rank_s=ccw_rfvoa_9h_rank_s;
    }
        
    public String getCcw_rfvoa_deg_s(){
        return ccw_rfvoa_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_deg_s(String ccw_rfvoa_deg_s){
        this.ccw_rfvoa_deg_s=ccw_rfvoa_deg_s;
    }
        
    public String getCcw_rfvoa_kgf_s(){
        return ccw_rfvoa_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_kgf_s(String ccw_rfvoa_kgf_s){
        this.ccw_rfvoa_kgf_s=ccw_rfvoa_kgf_s;
    }
        
    public String getCcw_rfvoa_rank_s(){
        return ccw_rfvoa_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfvoa_rank_s(String ccw_rfvoa_rank_s){
        this.ccw_rfvoa_rank_s=ccw_rfvoa_rank_s;
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
        
    public String getCon_kgf_s(){
        return con_kgf_s;
    }
    
    @XmlElement
    public void setCon_kgf_s(String con_kgf_s){
        this.con_kgf_s=con_kgf_s;
    }
        
    public String getCon_rank_s(){
        return con_rank_s;
    }
    
    @XmlElement
    public void setCon_rank_s(String con_rank_s){
        this.con_rank_s=con_rank_s;
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
        
    public String getCw_lfd_kgf_s(){
        return cw_lfd_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfd_kgf_s(String cw_lfd_kgf_s){
        this.cw_lfd_kgf_s=cw_lfd_kgf_s;
    }
        
    public String getCw_lfd_rank_s(){
        return cw_lfd_rank_s;
    }
    
    @XmlElement
    public void setCw_lfd_rank_s(String cw_lfd_rank_s){
        this.cw_lfd_rank_s=cw_lfd_rank_s;
    }
        
    public String getCw_lfvoa_10h_deg_s(){
        return cw_lfvoa_10h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_10h_deg_s(String cw_lfvoa_10h_deg_s){
        this.cw_lfvoa_10h_deg_s=cw_lfvoa_10h_deg_s;
    }
        
    public String getCw_lfvoa_10h_kgf_s(){
        return cw_lfvoa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_10h_kgf_s(String cw_lfvoa_10h_kgf_s){
        this.cw_lfvoa_10h_kgf_s=cw_lfvoa_10h_kgf_s;
    }
        
    public String getCw_lfvoa_10h_rank_s(){
        return cw_lfvoa_10h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_10h_rank_s(String cw_lfvoa_10h_rank_s){
        this.cw_lfvoa_10h_rank_s=cw_lfvoa_10h_rank_s;
    }
        
    public String getCw_lfvoa_1h_deg_s(){
        return cw_lfvoa_1h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_1h_deg_s(String cw_lfvoa_1h_deg_s){
        this.cw_lfvoa_1h_deg_s=cw_lfvoa_1h_deg_s;
    }
        
    public String getCw_lfvoa_1h_kgf_s(){
        return cw_lfvoa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_1h_kgf_s(String cw_lfvoa_1h_kgf_s){
        this.cw_lfvoa_1h_kgf_s=cw_lfvoa_1h_kgf_s;
    }
        
    public String getCw_lfvoa_1h_rank_s(){
        return cw_lfvoa_1h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_1h_rank_s(String cw_lfvoa_1h_rank_s){
        this.cw_lfvoa_1h_rank_s=cw_lfvoa_1h_rank_s;
    }
        
    public String getCw_lfvoa_2h_deg_s(){
        return cw_lfvoa_2h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_2h_deg_s(String cw_lfvoa_2h_deg_s){
        this.cw_lfvoa_2h_deg_s=cw_lfvoa_2h_deg_s;
    }
        
    public String getCw_lfvoa_2h_kgf_s(){
        return cw_lfvoa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_2h_kgf_s(String cw_lfvoa_2h_kgf_s){
        this.cw_lfvoa_2h_kgf_s=cw_lfvoa_2h_kgf_s;
    }
        
    public String getCw_lfvoa_2h_rank_s(){
        return cw_lfvoa_2h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_2h_rank_s(String cw_lfvoa_2h_rank_s){
        this.cw_lfvoa_2h_rank_s=cw_lfvoa_2h_rank_s;
    }
        
    public String getCw_lfvoa_3h_deg_s(){
        return cw_lfvoa_3h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_3h_deg_s(String cw_lfvoa_3h_deg_s){
        this.cw_lfvoa_3h_deg_s=cw_lfvoa_3h_deg_s;
    }
        
    public String getCw_lfvoa_3h_kgf_s(){
        return cw_lfvoa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_3h_kgf_s(String cw_lfvoa_3h_kgf_s){
        this.cw_lfvoa_3h_kgf_s=cw_lfvoa_3h_kgf_s;
    }
        
    public String getCw_lfvoa_3h_rank_s(){
        return cw_lfvoa_3h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_3h_rank_s(String cw_lfvoa_3h_rank_s){
        this.cw_lfvoa_3h_rank_s=cw_lfvoa_3h_rank_s;
    }
        
    public String getCw_lfvoa_4h_deg_s(){
        return cw_lfvoa_4h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_4h_deg_s(String cw_lfvoa_4h_deg_s){
        this.cw_lfvoa_4h_deg_s=cw_lfvoa_4h_deg_s;
    }
        
    public String getCw_lfvoa_4h_kgf_s(){
        return cw_lfvoa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_4h_kgf_s(String cw_lfvoa_4h_kgf_s){
        this.cw_lfvoa_4h_kgf_s=cw_lfvoa_4h_kgf_s;
    }
        
    public String getCw_lfvoa_4h_rank_s(){
        return cw_lfvoa_4h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_4h_rank_s(String cw_lfvoa_4h_rank_s){
        this.cw_lfvoa_4h_rank_s=cw_lfvoa_4h_rank_s;
    }
        
    public String getCw_lfvoa_5h_deg_s(){
        return cw_lfvoa_5h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_5h_deg_s(String cw_lfvoa_5h_deg_s){
        this.cw_lfvoa_5h_deg_s=cw_lfvoa_5h_deg_s;
    }
        
    public String getCw_lfvoa_5h_kgf_s(){
        return cw_lfvoa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_5h_kgf_s(String cw_lfvoa_5h_kgf_s){
        this.cw_lfvoa_5h_kgf_s=cw_lfvoa_5h_kgf_s;
    }
        
    public String getCw_lfvoa_5h_rank_s(){
        return cw_lfvoa_5h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_5h_rank_s(String cw_lfvoa_5h_rank_s){
        this.cw_lfvoa_5h_rank_s=cw_lfvoa_5h_rank_s;
    }
        
    public String getCw_lfvoa_6h_deg_s(){
        return cw_lfvoa_6h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_6h_deg_s(String cw_lfvoa_6h_deg_s){
        this.cw_lfvoa_6h_deg_s=cw_lfvoa_6h_deg_s;
    }
        
    public String getCw_lfvoa_6h_kgf_s(){
        return cw_lfvoa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_6h_kgf_s(String cw_lfvoa_6h_kgf_s){
        this.cw_lfvoa_6h_kgf_s=cw_lfvoa_6h_kgf_s;
    }
        
    public String getCw_lfvoa_6h_rank_s(){
        return cw_lfvoa_6h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_6h_rank_s(String cw_lfvoa_6h_rank_s){
        this.cw_lfvoa_6h_rank_s=cw_lfvoa_6h_rank_s;
    }
        
    public String getCw_lfvoa_7h_deg_s(){
        return cw_lfvoa_7h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_7h_deg_s(String cw_lfvoa_7h_deg_s){
        this.cw_lfvoa_7h_deg_s=cw_lfvoa_7h_deg_s;
    }
        
    public String getCw_lfvoa_7h_kgf_s(){
        return cw_lfvoa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_7h_kgf_s(String cw_lfvoa_7h_kgf_s){
        this.cw_lfvoa_7h_kgf_s=cw_lfvoa_7h_kgf_s;
    }
        
    public String getCw_lfvoa_7h_rank_s(){
        return cw_lfvoa_7h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_7h_rank_s(String cw_lfvoa_7h_rank_s){
        this.cw_lfvoa_7h_rank_s=cw_lfvoa_7h_rank_s;
    }
        
    public String getCw_lfvoa_8h_deg_s(){
        return cw_lfvoa_8h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_8h_deg_s(String cw_lfvoa_8h_deg_s){
        this.cw_lfvoa_8h_deg_s=cw_lfvoa_8h_deg_s;
    }
        
    public String getCw_lfvoa_8h_kgf_s(){
        return cw_lfvoa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_8h_kgf_s(String cw_lfvoa_8h_kgf_s){
        this.cw_lfvoa_8h_kgf_s=cw_lfvoa_8h_kgf_s;
    }
        
    public String getCw_lfvoa_8h_rank_s(){
        return cw_lfvoa_8h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_8h_rank_s(String cw_lfvoa_8h_rank_s){
        this.cw_lfvoa_8h_rank_s=cw_lfvoa_8h_rank_s;
    }
        
    public String getCw_lfvoa_9h_deg_s(){
        return cw_lfvoa_9h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_9h_deg_s(String cw_lfvoa_9h_deg_s){
        this.cw_lfvoa_9h_deg_s=cw_lfvoa_9h_deg_s;
    }
        
    public String getCw_lfvoa_9h_kgf_s(){
        return cw_lfvoa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_9h_kgf_s(String cw_lfvoa_9h_kgf_s){
        this.cw_lfvoa_9h_kgf_s=cw_lfvoa_9h_kgf_s;
    }
        
    public String getCw_lfvoa_9h_rank_s(){
        return cw_lfvoa_9h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_9h_rank_s(String cw_lfvoa_9h_rank_s){
        this.cw_lfvoa_9h_rank_s=cw_lfvoa_9h_rank_s;
    }
        
    public String getCw_lfvoa_deg_s(){
        return cw_lfvoa_deg_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_deg_s(String cw_lfvoa_deg_s){
        this.cw_lfvoa_deg_s=cw_lfvoa_deg_s;
    }
        
    public String getCw_lfvoa_kgf_s(){
        return cw_lfvoa_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_kgf_s(String cw_lfvoa_kgf_s){
        this.cw_lfvoa_kgf_s=cw_lfvoa_kgf_s;
    }
        
    public String getCw_lfvoa_rank_s(){
        return cw_lfvoa_rank_s;
    }
    
    @XmlElement
    public void setCw_lfvoa_rank_s(String cw_lfvoa_rank_s){
        this.cw_lfvoa_rank_s=cw_lfvoa_rank_s;
    }
        
    public String getCw_rfvoa_10h_deg_s(){
        return cw_rfvoa_10h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_10h_deg_s(String cw_rfvoa_10h_deg_s){
        this.cw_rfvoa_10h_deg_s=cw_rfvoa_10h_deg_s;
    }
        
    public String getCw_rfvoa_10h_kgf_s(){
        return cw_rfvoa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_10h_kgf_s(String cw_rfvoa_10h_kgf_s){
        this.cw_rfvoa_10h_kgf_s=cw_rfvoa_10h_kgf_s;
    }
        
    public String getCw_rfvoa_10h_rank_s(){
        return cw_rfvoa_10h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_10h_rank_s(String cw_rfvoa_10h_rank_s){
        this.cw_rfvoa_10h_rank_s=cw_rfvoa_10h_rank_s;
    }
        
    public String getCw_rfvoa_1h_deg_s(){
        return cw_rfvoa_1h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_1h_deg_s(String cw_rfvoa_1h_deg_s){
        this.cw_rfvoa_1h_deg_s=cw_rfvoa_1h_deg_s;
    }
        
    public String getCw_rfvoa_1h_kgf_s(){
        return cw_rfvoa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_1h_kgf_s(String cw_rfvoa_1h_kgf_s){
        this.cw_rfvoa_1h_kgf_s=cw_rfvoa_1h_kgf_s;
    }
        
    public String getCw_rfvoa_1h_rank_s(){
        return cw_rfvoa_1h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_1h_rank_s(String cw_rfvoa_1h_rank_s){
        this.cw_rfvoa_1h_rank_s=cw_rfvoa_1h_rank_s;
    }
        
    public String getCw_rfvoa_2h_deg_s(){
        return cw_rfvoa_2h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_2h_deg_s(String cw_rfvoa_2h_deg_s){
        this.cw_rfvoa_2h_deg_s=cw_rfvoa_2h_deg_s;
    }
        
    public String getCw_rfvoa_2h_kgf_s(){
        return cw_rfvoa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_2h_kgf_s(String cw_rfvoa_2h_kgf_s){
        this.cw_rfvoa_2h_kgf_s=cw_rfvoa_2h_kgf_s;
    }
        
    public String getCw_rfvoa_2h_rank_s(){
        return cw_rfvoa_2h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_2h_rank_s(String cw_rfvoa_2h_rank_s){
        this.cw_rfvoa_2h_rank_s=cw_rfvoa_2h_rank_s;
    }
        
    public String getCw_rfvoa_3h_deg_s(){
        return cw_rfvoa_3h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_3h_deg_s(String cw_rfvoa_3h_deg_s){
        this.cw_rfvoa_3h_deg_s=cw_rfvoa_3h_deg_s;
    }
        
    public String getCw_rfvoa_3h_kgf_s(){
        return cw_rfvoa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_3h_kgf_s(String cw_rfvoa_3h_kgf_s){
        this.cw_rfvoa_3h_kgf_s=cw_rfvoa_3h_kgf_s;
    }
        
    public String getCw_rfvoa_3h_rank_s(){
        return cw_rfvoa_3h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_3h_rank_s(String cw_rfvoa_3h_rank_s){
        this.cw_rfvoa_3h_rank_s=cw_rfvoa_3h_rank_s;
    }
        
    public String getCw_rfvoa_4h_deg_s(){
        return cw_rfvoa_4h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_4h_deg_s(String cw_rfvoa_4h_deg_s){
        this.cw_rfvoa_4h_deg_s=cw_rfvoa_4h_deg_s;
    }
        
    public String getCw_rfvoa_4h_kgf_s(){
        return cw_rfvoa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_4h_kgf_s(String cw_rfvoa_4h_kgf_s){
        this.cw_rfvoa_4h_kgf_s=cw_rfvoa_4h_kgf_s;
    }
        
    public String getCw_rfvoa_4h_rank_s(){
        return cw_rfvoa_4h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_4h_rank_s(String cw_rfvoa_4h_rank_s){
        this.cw_rfvoa_4h_rank_s=cw_rfvoa_4h_rank_s;
    }
        
    public String getCw_rfvoa_5h_deg_s(){
        return cw_rfvoa_5h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_5h_deg_s(String cw_rfvoa_5h_deg_s){
        this.cw_rfvoa_5h_deg_s=cw_rfvoa_5h_deg_s;
    }
        
    public String getCw_rfvoa_5h_kgf_s(){
        return cw_rfvoa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_5h_kgf_s(String cw_rfvoa_5h_kgf_s){
        this.cw_rfvoa_5h_kgf_s=cw_rfvoa_5h_kgf_s;
    }
        
    public String getCw_rfvoa_5h_rank_s(){
        return cw_rfvoa_5h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_5h_rank_s(String cw_rfvoa_5h_rank_s){
        this.cw_rfvoa_5h_rank_s=cw_rfvoa_5h_rank_s;
    }
        
    public String getCw_rfvoa_6h_deg_s(){
        return cw_rfvoa_6h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_6h_deg_s(String cw_rfvoa_6h_deg_s){
        this.cw_rfvoa_6h_deg_s=cw_rfvoa_6h_deg_s;
    }
        
    public String getCw_rfvoa_6h_kgf_s(){
        return cw_rfvoa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_6h_kgf_s(String cw_rfvoa_6h_kgf_s){
        this.cw_rfvoa_6h_kgf_s=cw_rfvoa_6h_kgf_s;
    }
        
    public String getCw_rfvoa_6h_rank_s(){
        return cw_rfvoa_6h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_6h_rank_s(String cw_rfvoa_6h_rank_s){
        this.cw_rfvoa_6h_rank_s=cw_rfvoa_6h_rank_s;
    }
        
    public String getCw_rfvoa_7h_deg_s(){
        return cw_rfvoa_7h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_7h_deg_s(String cw_rfvoa_7h_deg_s){
        this.cw_rfvoa_7h_deg_s=cw_rfvoa_7h_deg_s;
    }
        
    public String getCw_rfvoa_7h_kgf_s(){
        return cw_rfvoa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_7h_kgf_s(String cw_rfvoa_7h_kgf_s){
        this.cw_rfvoa_7h_kgf_s=cw_rfvoa_7h_kgf_s;
    }
        
    public String getCw_rfvoa_7h_rank_s(){
        return cw_rfvoa_7h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_7h_rank_s(String cw_rfvoa_7h_rank_s){
        this.cw_rfvoa_7h_rank_s=cw_rfvoa_7h_rank_s;
    }
        
    public String getCw_rfvoa_8h_deg_s(){
        return cw_rfvoa_8h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_8h_deg_s(String cw_rfvoa_8h_deg_s){
        this.cw_rfvoa_8h_deg_s=cw_rfvoa_8h_deg_s;
    }
        
    public String getCw_rfvoa_8h_kgf_s(){
        return cw_rfvoa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_8h_kgf_s(String cw_rfvoa_8h_kgf_s){
        this.cw_rfvoa_8h_kgf_s=cw_rfvoa_8h_kgf_s;
    }
        
    public String getCw_rfvoa_8h_rank_s(){
        return cw_rfvoa_8h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_8h_rank_s(String cw_rfvoa_8h_rank_s){
        this.cw_rfvoa_8h_rank_s=cw_rfvoa_8h_rank_s;
    }
        
    public String getCw_rfvoa_9h_deg_s(){
        return cw_rfvoa_9h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_9h_deg_s(String cw_rfvoa_9h_deg_s){
        this.cw_rfvoa_9h_deg_s=cw_rfvoa_9h_deg_s;
    }
        
    public String getCw_rfvoa_9h_kgf_s(){
        return cw_rfvoa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_9h_kgf_s(String cw_rfvoa_9h_kgf_s){
        this.cw_rfvoa_9h_kgf_s=cw_rfvoa_9h_kgf_s;
    }
        
    public String getCw_rfvoa_9h_rank_s(){
        return cw_rfvoa_9h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_9h_rank_s(String cw_rfvoa_9h_rank_s){
        this.cw_rfvoa_9h_rank_s=cw_rfvoa_9h_rank_s;
    }
        
    public String getCw_rfvoa_deg_s(){
        return cw_rfvoa_deg_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_deg_s(String cw_rfvoa_deg_s){
        this.cw_rfvoa_deg_s=cw_rfvoa_deg_s;
    }
        
    public String getCw_rfvoa_kgf_s(){
        return cw_rfvoa_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_kgf_s(String cw_rfvoa_kgf_s){
        this.cw_rfvoa_kgf_s=cw_rfvoa_kgf_s;
    }
        
    public String getCw_rfvoa_rank_s(){
        return cw_rfvoa_rank_s;
    }
    
    @XmlElement
    public void setCw_rfvoa_rank_s(String cw_rfvoa_rank_s){
        this.cw_rfvoa_rank_s=cw_rfvoa_rank_s;
    }
        
    public String getLboa_1h_deg_s(){
        return lboa_1h_deg_s;
    }
    
    @XmlElement
    public void setLboa_1h_deg_s(String lboa_1h_deg_s){
        this.lboa_1h_deg_s=lboa_1h_deg_s;
    }
        
    public String getLboa_1h_mm_s(){
        return lboa_1h_mm_s;
    }
    
    @XmlElement
    public void setLboa_1h_mm_s(String lboa_1h_mm_s){
        this.lboa_1h_mm_s=lboa_1h_mm_s;
    }
        
    public String getLboa_1h_rank_s(){
        return lboa_1h_rank_s;
    }
    
    @XmlElement
    public void setLboa_1h_rank_s(String lboa_1h_rank_s){
        this.lboa_1h_rank_s=lboa_1h_rank_s;
    }
        
    public String getLboa_deg_s(){
        return lboa_deg_s;
    }
    
    @XmlElement
    public void setLboa_deg_s(String lboa_deg_s){
        this.lboa_deg_s=lboa_deg_s;
    }
        
    public String getLboa_mm_s(){
        return lboa_mm_s;
    }
    
    @XmlElement
    public void setLboa_mm_s(String lboa_mm_s){
        this.lboa_mm_s=lboa_mm_s;
    }
        
    public String getLboa_rank_s(){
        return lboa_rank_s;
    }
    
    @XmlElement
    public void setLboa_rank_s(String lboa_rank_s){
        this.lboa_rank_s=lboa_rank_s;
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
        
    public String getLoad_s(){
        return load_s;
    }
    
    @XmlElement
    public void setLoad_s(String load_s){
        this.load_s=load_s;
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
        
    public String getLtoa_1h_deg_s(){
        return ltoa_1h_deg_s;
    }
    
    @XmlElement
    public void setLtoa_1h_deg_s(String ltoa_1h_deg_s){
        this.ltoa_1h_deg_s=ltoa_1h_deg_s;
    }
        
    public String getLtoa_1h_mm_s(){
        return ltoa_1h_mm_s;
    }
    
    @XmlElement
    public void setLtoa_1h_mm_s(String ltoa_1h_mm_s){
        this.ltoa_1h_mm_s=ltoa_1h_mm_s;
    }
        
    public String getLtoa_1h_rank_s(){
        return ltoa_1h_rank_s;
    }
    
    @XmlElement
    public void setLtoa_1h_rank_s(String ltoa_1h_rank_s){
        this.ltoa_1h_rank_s=ltoa_1h_rank_s;
    }
        
    public String getLtoa_deg_s(){
        return ltoa_deg_s;
    }
    
    @XmlElement
    public void setLtoa_deg_s(String ltoa_deg_s){
        this.ltoa_deg_s=ltoa_deg_s;
    }
        
    public String getLtoa_mm_s(){
        return ltoa_mm_s;
    }
    
    @XmlElement
    public void setLtoa_mm_s(String ltoa_mm_s){
        this.ltoa_mm_s=ltoa_mm_s;
    }
        
    public String getLtoa_rank_s(){
        return ltoa_rank_s;
    }
    
    @XmlElement
    public void setLtoa_rank_s(String ltoa_rank_s){
        this.ltoa_rank_s=ltoa_rank_s;
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
        
    public String getMachinebar_s(){
        return machinebar_s;
    }
    
    @XmlElement
    public void setMachinebar_s(String machinebar_s){
        this.machinebar_s=machinebar_s;
    }
        
    public String getModelno_s(){
        return modelno_s;
    }
    
    @XmlElement
    public void setModelno_s(String modelno_s){
        this.modelno_s=modelno_s;
    }
        
    public Date getOutputtime_t(){
        return outputtime_t;
    }
    
    @XmlElement
    public void setOutputtime_t(Date outputtime_t){
        this.outputtime_t=outputtime_t;
    }
        
    public String getOutsidediameter_mm_s(){
        return outsidediameter_mm_s;
    }
    
    @XmlElement
    public void setOutsidediameter_mm_s(String outsidediameter_mm_s){
        this.outsidediameter_mm_s=outsidediameter_mm_s;
    }
        
    public String getOutsidediameter_rank_s(){
        return outsidediameter_rank_s;
    }
    
    @XmlElement
    public void setOutsidediameter_rank_s(String outsidediameter_rank_s){
        this.outsidediameter_rank_s=outsidediameter_rank_s;
    }
        
    public String getPly_kgf_s(){
        return ply_kgf_s;
    }
    
    @XmlElement
    public void setPly_kgf_s(String ply_kgf_s){
        this.ply_kgf_s=ply_kgf_s;
    }
        
    public String getPly_rank_s(){
        return ply_rank_s;
    }
    
    @XmlElement
    public void setPly_rank_s(String ply_rank_s){
        this.ply_rank_s=ply_rank_s;
    }
        
    public String getRboa_1h_deg_s(){
        return rboa_1h_deg_s;
    }
    
    @XmlElement
    public void setRboa_1h_deg_s(String rboa_1h_deg_s){
        this.rboa_1h_deg_s=rboa_1h_deg_s;
    }
        
    public String getRboa_1h_mm_s(){
        return rboa_1h_mm_s;
    }
    
    @XmlElement
    public void setRboa_1h_mm_s(String rboa_1h_mm_s){
        this.rboa_1h_mm_s=rboa_1h_mm_s;
    }
        
    public String getRboa_1h_rank_s(){
        return rboa_1h_rank_s;
    }
    
    @XmlElement
    public void setRboa_1h_rank_s(String rboa_1h_rank_s){
        this.rboa_1h_rank_s=rboa_1h_rank_s;
    }
        
    public String getRboa_deg_s(){
        return rboa_deg_s;
    }
    
    @XmlElement
    public void setRboa_deg_s(String rboa_deg_s){
        this.rboa_deg_s=rboa_deg_s;
    }
        
    public String getRboa_mm_s(){
        return rboa_mm_s;
    }
    
    @XmlElement
    public void setRboa_mm_s(String rboa_mm_s){
        this.rboa_mm_s=rboa_mm_s;
    }
        
    public String getRboa_rank_s(){
        return rboa_rank_s;
    }
    
    @XmlElement
    public void setRboa_rank_s(String rboa_rank_s){
        this.rboa_rank_s=rboa_rank_s;
    }
        
    public String getRcoa_1h_deg_s(){
        return rcoa_1h_deg_s;
    }
    
    @XmlElement
    public void setRcoa_1h_deg_s(String rcoa_1h_deg_s){
        this.rcoa_1h_deg_s=rcoa_1h_deg_s;
    }
        
    public String getRcoa_1h_mm_s(){
        return rcoa_1h_mm_s;
    }
    
    @XmlElement
    public void setRcoa_1h_mm_s(String rcoa_1h_mm_s){
        this.rcoa_1h_mm_s=rcoa_1h_mm_s;
    }
        
    public String getRcoa_1h_rank_s(){
        return rcoa_1h_rank_s;
    }
    
    @XmlElement
    public void setRcoa_1h_rank_s(String rcoa_1h_rank_s){
        this.rcoa_1h_rank_s=rcoa_1h_rank_s;
    }
        
    public String getRcoa_deg_s(){
        return rcoa_deg_s;
    }
    
    @XmlElement
    public void setRcoa_deg_s(String rcoa_deg_s){
        this.rcoa_deg_s=rcoa_deg_s;
    }
        
    public String getRcoa_mm_s(){
        return rcoa_mm_s;
    }
    
    @XmlElement
    public void setRcoa_mm_s(String rcoa_mm_s){
        this.rcoa_mm_s=rcoa_mm_s;
    }
        
    public String getRcoa_rank_s(){
        return rcoa_rank_s;
    }
    
    @XmlElement
    public void setRcoa_rank_s(String rcoa_rank_s){
        this.rcoa_rank_s=rcoa_rank_s;
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
        
    public String getRototal_rank_s(){
        return rototal_rank_s;
    }
    
    @XmlElement
    public void setRototal_rank_s(String rototal_rank_s){
        this.rototal_rank_s=rototal_rank_s;
    }
        
    public String getRtoa_1h_deg_s(){
        return rtoa_1h_deg_s;
    }
    
    @XmlElement
    public void setRtoa_1h_deg_s(String rtoa_1h_deg_s){
        this.rtoa_1h_deg_s=rtoa_1h_deg_s;
    }
        
    public String getRtoa_1h_mm_s(){
        return rtoa_1h_mm_s;
    }
    
    @XmlElement
    public void setRtoa_1h_mm_s(String rtoa_1h_mm_s){
        this.rtoa_1h_mm_s=rtoa_1h_mm_s;
    }
        
    public String getRtoa_1h_rank_s(){
        return rtoa_1h_rank_s;
    }
    
    @XmlElement
    public void setRtoa_1h_rank_s(String rtoa_1h_rank_s){
        this.rtoa_1h_rank_s=rtoa_1h_rank_s;
    }
        
    public String getRtoa_deg_s(){
        return rtoa_deg_s;
    }
    
    @XmlElement
    public void setRtoa_deg_s(String rtoa_deg_s){
        this.rtoa_deg_s=rtoa_deg_s;
    }
        
    public String getRtoa_mm_s(){
        return rtoa_mm_s;
    }
    
    @XmlElement
    public void setRtoa_mm_s(String rtoa_mm_s){
        this.rtoa_mm_s=rtoa_mm_s;
    }
        
    public String getRtoa_rank_s(){
        return rtoa_rank_s;
    }
    
    @XmlElement
    public void setRtoa_rank_s(String rtoa_rank_s){
        this.rtoa_rank_s=rtoa_rank_s;
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
        
    public String getTire_total_ratings_s(){
        return tire_total_ratings_s;
    }
    
    @XmlElement
    public void setTire_total_ratings_s(String tire_total_ratings_s){
        this.tire_total_ratings_s=tire_total_ratings_s;
    }
        
    public String getUfm_totalrank_s(){
        return ufm_totalrank_s;
    }
    
    @XmlElement
    public void setUfm_totalrank_s(String ufm_totalrank_s){
        this.ufm_totalrank_s=ufm_totalrank_s;
    }
        
    public String getUplow_unbalance_g_s(){
        return uplow_unbalance_g_s;
    }
    
    @XmlElement
    public void setUplow_unbalance_g_s(String uplow_unbalance_g_s){
        this.uplow_unbalance_g_s=uplow_unbalance_g_s;
    }
        
    public String getUplow_unbalance_rank_s(){
        return uplow_unbalance_rank_s;
    }
    
    @XmlElement
    public void setUplow_unbalance_rank_s(String uplow_unbalance_rank_s){
        this.uplow_unbalance_rank_s=uplow_unbalance_rank_s;
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
        
    public String getWeight_rank_s(){
        return weight_rank_s;
    }
    
    @XmlElement
    public void setWeight_rank_s(String weight_rank_s){
        this.weight_rank_s=weight_rank_s;
    }
        
    public String getWeight_s(){
        return weight_s;
    }
    
    @XmlElement
    public void setWeight_s(String weight_s){
        this.weight_s=weight_s;
    }
        
    
    
    
}
