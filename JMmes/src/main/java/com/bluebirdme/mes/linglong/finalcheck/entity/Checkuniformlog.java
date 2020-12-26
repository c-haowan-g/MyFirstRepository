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
 * 质检均匀机检测履历表_全钢
 * @author 周志祥
 * @Date 2019-05-02 10:00:12
 */
@ATDefinition("D_QM_CHECKUNIFORMLOG")
@Entity
@XmlRootElement
@Table(name="AT_D_QM_CHECKUNIFORMLOG")
public class Checkuniformlog extends RockWellBaseEntity{
						
    
    @Comment("机构编号：招远_8000；德州_8002__柳州_8003_泰国_8004")
    @Column(nullable=true,length=80)
    private String agenc_no_s;
    
    @Comment("归档标记")
    @Column(nullable=true,length=80)
    private String arch_flag_s;
    
    @Comment("轮胎条码：MainTyre.BARCODE")
    @Column(nullable=false,length=80)
    private String barcode_s;
    
    @Comment("反转侧向力偏移值")
    @Column(nullable=true,length=80)
    private String ccw_lfd_kgf_s;
    
    @Comment("反转侧向力偏移等级")
    @Column(nullable=true,length=80)
    private String ccw_lfd_rank_s;
    
    @Comment("反转侧向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_10h_deg_s;
    
    @Comment("反转侧向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_10h_kgf_s;
    
    @Comment("反转侧向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_10h_rank_s;
    
    @Comment("反转侧向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_1h_deg_s;
    
    @Comment("反转侧向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_1h_kgf_s;
    
    @Comment("反转侧向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_1h_rank_s;
    
    @Comment("反转侧向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_2h_deg_s;
    
    @Comment("反转侧向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_2h_kgf_s;
    
    @Comment("反转侧向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_2h_rank_s;
    
    @Comment("反转侧向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_3h_deg_s;
    
    @Comment("反转侧向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_3h_kgf_s;
    
    @Comment("反转侧向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_3h_rank_s;
    
    @Comment("反转侧向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_4h_deg_s;
    
    @Comment("反转侧向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_4h_kgf_s;
    
    @Comment("反转侧向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_4h_rank_s;
    
    @Comment("反转侧向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_5h_deg_s;
    
    @Comment("反转侧向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_5h_kgf_s;
    
    @Comment("反转侧向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_5h_rank_s;
    
    @Comment("反转侧向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_6h_deg_s;
    
    @Comment("反转侧向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_6h_kgf_s;
    
    @Comment("反转侧向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_6h_rank_s;
    
    @Comment("反转侧向力波动七次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_7h_deg_s;
    
    @Comment("反转侧向力波动七次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_7h_kgf_s;
    
    @Comment("反转侧向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_7h_rank_s;
    
    @Comment("反转侧向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_8h_deg_s;
    
    @Comment("反转侧向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_8h_kgf_s;
    
    @Comment("反转侧向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_8h_rank_s;
    
    @Comment("反转侧向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_9h_deg_s;
    
    @Comment("反转侧向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_9h_kgf_s;
    
    @Comment("反转侧向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_9h_rank_s;
    
    @Comment("反转侧向力波动角度")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_deg_s;
    
    @Comment("反转侧向力波动值")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_kgf_s;
    
    @Comment("反转侧向力波动等级")
    @Column(nullable=true,length=80)
    private String ccw_lfv_oa_rank_s;
    
    @Comment("反转径向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_10h_deg_s;
    
    @Comment("反转径向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_10h_kgf_s;
    
    @Comment("反转径向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_10h_rank_s;
    
    @Comment("反转径向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_1h_deg_s;
    
    @Comment("反转径向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_1h_kgf_s;
    
    @Comment("反转径向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_1h_rank_s;
    
    @Comment("反转径向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_2h_deg_s;
    
    @Comment("反转径向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_2h_kgf_s;
    
    @Comment("反转径向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_2h_rank_s;
    
    @Comment("反转径向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_3h_deg_s;
    
    @Comment("反转径向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_3h_kgf_s;
    
    @Comment("反转径向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_3h_rank_s;
    
    @Comment("反转径向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_4h_deg_s;
    
    @Comment("反转径向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_4h_kgf_s;
    
    @Comment("反转径向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_4h_rank_s;
    
    @Comment("反转径向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_5h_deg_s;
    
    @Comment("反转径向力波动五次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_5h_kgf_s;
    
    @Comment("反转径向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_5h_rank_s;
    
    @Comment("反转径向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_6h_deg_s;
    
    @Comment("反转径向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_6h_kgf_s;
    
    @Comment("反转径向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_6h_rank_s;
    
    @Comment("反转径向力波动七次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_7h_deg_s;
    
    @Comment("反转径向力波动七次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_7h_kgf_s;
    
    @Comment("反转径向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_7h_rank_s;
    
    @Comment("反转径向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_8h_deg_s;
    
    @Comment("反转径向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_8h_kgf_s;
    
    @Comment("反转径向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_8h_rank_s;
    
    @Comment("反转径向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_9h_deg_s;
    
    @Comment("反转径向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_9h_kgf_s;
    
    @Comment("反转径向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_9h_rank_s;
    
    @Comment("反转径向力波动角度")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_deg_s;
    
    @Comment("反转径向力波动值")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_kgf_s;
    
    @Comment("反转径向力波动等级")
    @Column(nullable=true,length=80)
    private String ccw_rfv_oa_rank_s;
    
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
    
    @Comment("创建人")
    @Column(nullable=true,length=80)
    private String created_by_s;
    
    @Comment("创建时间")
    @Column(nullable=true,length=0)
    private Date created_time_t;
    
    @Comment("正转侧向力偏移值")
    @Column(nullable=true,length=80)
    private String cw_lfd_kgf_s;
    
    @Comment("正转侧向力偏移等级")
    @Column(nullable=true,length=80)
    private String cw_lfd_rank_s;
    
    @Comment("侧向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_10h_deg_s;
    
    @Comment("侧向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_10h_kgf_s;
    
    @Comment("侧向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_10h_rank_s;
    
    @Comment("侧向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_1h_deg_s;
    
    @Comment("侧向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_1h_kgf_s;
    
    @Comment("侧向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_1h_rank_s;
    
    @Comment("侧向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_2h_deg_s;
    
    @Comment("侧向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_2h_kgf_s;
    
    @Comment("侧向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_2h_rank_s;
    
    @Comment("侧向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_3h_deg_s;
    
    @Comment("侧向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_3h_kgf_s;
    
    @Comment("侧向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_3h_rank_s;
    
    @Comment("侧向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_4h_deg_s;
    
    @Comment("侧向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_4h_kgf_s;
    
    @Comment("侧向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_4h_rank_s;
    
    @Comment("侧向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_5h_deg_s;
    
    @Comment("侧向力波动五次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_5h_kgf_s;
    
    @Comment("侧向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_5h_rank_s;
    
    @Comment("侧向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_6h_deg_s;
    
    @Comment("侧向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_6h_kgf_s;
    
    @Comment("侧向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_6h_rank_s;
    
    @Comment("侧向力波动七次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_7h_deg_s;
    
    @Comment("侧向力波动七次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_7h_kgf_s;
    
    @Comment("侧向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_7h_rank_s;
    
    @Comment("侧向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_8h_deg_s;
    
    @Comment("侧向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_8h_kgf_s;
    
    @Comment("侧向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_8h_rank_s;
    
    @Comment("侧向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_9h_deg_s;
    
    @Comment("侧向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_9h_kgf_s;
    
    @Comment("侧向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_9h_rank_s;
    
    @Comment("侧向力波动角度")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_deg_s;
    
    @Comment("侧向力波动值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_kgf_s;
    
    @Comment("侧向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String cw_lfv_oa_rank_s;
    
    @Comment("径向力波动十次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_10h_deg_s;
    
    @Comment("径向力波动十次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_10h_kgf_s;
    
    @Comment("径向力波动十次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_10h_rank_s;
    
    @Comment("径向力波动一次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_1h_deg_s;
    
    @Comment("径向力波动一次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_1h_kgf_s;
    
    @Comment("径向力波动一次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_1h_rank_s;
    
    @Comment("径向力波动二次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_2h_deg_s;
    
    @Comment("径向力波动二次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_2h_kgf_s;
    
    @Comment("径向力波动二次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_2h_rank_s;
    
    @Comment("径向力波动三次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_3h_deg_s;
    
    @Comment("径向力波动三次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_3h_kgf_s;
    
    @Comment("径向力波动三次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_3h_rank_s;
    
    @Comment("径向力波动四次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_4h_deg_s;
    
    @Comment("径向力波动四次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_4h_kgf_s;
    
    @Comment("径向力波动四次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_4h_rank_s;
    
    @Comment("径向力波动五次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_5h_deg_s;
    
    @Comment("径向力波动五次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_5h_kgf_s;
    
    @Comment("径向力波动五次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_5h_rank_s;
    
    @Comment("径向力波动六次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_6h_deg_s;
    
    @Comment("径向力波动六次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_6h_kgf_s;
    
    @Comment("径向力波动六次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_6h_rank_s;
    
    @Comment("径向力波动七次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_7h_deg_s;
    
    @Comment("径向力波动七次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_7h_kgf_s;
    
    @Comment("径向力波动七次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_7h_rank_s;
    
    @Comment("径向力波动八次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_8h_deg_s;
    
    @Comment("径向力波动八次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_8h_kgf_s;
    
    @Comment("径向力波动八次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_8h_rank_s;
    
    @Comment("径向力波动九次谐波角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_9h_deg_s;
    
    @Comment("径向力波动九次谐波值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_9h_kgf_s;
    
    @Comment("径向力波动九次谐波等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_9h_rank_s;
    
    @Comment("径向力波动角度")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_deg_s;
    
    @Comment("径向力波动值")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_kgf_s;
    
    @Comment("径向力波动等级")
    @Column(nullable=true,length=80)
    private String cw_rfv_oa_rank_s;
    
    @Comment("轮胎总等级")
    @Column(nullable=false,length=80)
    private String gradecode_s;
    
    @Comment("下部侧向凸角度")
    @Column(nullable=true,length=80)
    private String lb_bulging_deg_s;
    
    @Comment("下部侧向凸值")
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
    
    @Comment("下部侧向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String lb_oa_1h_deg_s;
    
    @Comment("下部侧向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String lb_oa_1h_mm_s;
    
    @Comment("下部侧向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String lb_oa_1h_rank_s;
    
    @Comment("下部侧向跳动角度")
    @Column(nullable=true,length=80)
    private String lb_oa_deg_s;
    
    @Comment("下部侧向跳动值")
    @Column(nullable=true,length=80)
    private String lb_oa_mm_s;
    
    @Comment("下部侧向跳动等级")
    @Column(nullable=true,length=80)
    private String lb_oa_rank_s;
    
    @Comment("荷重")
    @Column(nullable=true,length=80)
    private String load_s;
    
    @Comment("上部侧向凸角度")
    @Column(nullable=true,length=80)
    private String lt_bulging_deg_s;
    
    @Comment("上部侧向凸值")
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
    
    @Comment("上部侧向跳动一次谐波角度")
    @Column(nullable=true,length=80)
    private String lt_oa_1h_deg_s;
    
    @Comment("上部侧向跳动一次谐波值")
    @Column(nullable=true,length=80)
    private String lt_oa_1h_mm_s;
    
    @Comment("上部侧向跳动一次谐波等级")
    @Column(nullable=true,length=80)
    private String lt_oa_1h_rank_s;
    
    @Comment("上部侧向跳动角度")
    @Column(nullable=true,length=80)
    private String lt_oa_deg_s;
    
    @Comment("上部侧向跳动值")
    @Column(nullable=true,length=80)
    private String lt_oa_mm_s;
    
    @Comment("上部侧向跳动等级")
    @Column(nullable=true,length=80)
    private String lt_oa_rank_s;
    
    @Comment("均匀机机台条码：D_EM_Ent.ENTBARCODE")
    @Column(nullable=true,length=80)
    private String machinebar_s;
    
    @Comment("备注")
    @Column(nullable=true,length=80)
    private String memo_s;
    
    @Comment("轮胎外直径")
    @Column(nullable=true,length=80)
    private String outside_diameter_mm_s;
    
    @Comment("轮胎外直径等级")
    @Column(nullable=true,length=80)
    private String outside_diameter_rank_s;
    
    @Comment("帘布效应（跑偏，角度效应）")
    @Column(nullable=true,length=80)
    private String ply_kgf_s;
    
    @Comment("帘布效应等级")
    @Column(nullable=true,length=80)
    private String ply_rank_s;
    
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
    
    @Comment("跳动度总等级")
    @Column(nullable=false,length=80)
    private String ro_total_rank_s;
    
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
    
    @Comment("规格")
    @Column(nullable=true,length=80)
    private String specification_s;
    
    @Comment("工厂（1全钢_2半钢）")
    @Column(nullable=true,length=80)
    private String s_factory_s;
    
    @Comment("均匀性总等级")
    @Column(nullable=false,length=80)
    private String ufm_total_rank_s;
    
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
        
    public String getCcw_lfv_oa_10h_deg_s(){
        return ccw_lfv_oa_10h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_10h_deg_s(String ccw_lfv_oa_10h_deg_s){
        this.ccw_lfv_oa_10h_deg_s=ccw_lfv_oa_10h_deg_s;
    }
        
    public String getCcw_lfv_oa_10h_kgf_s(){
        return ccw_lfv_oa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_10h_kgf_s(String ccw_lfv_oa_10h_kgf_s){
        this.ccw_lfv_oa_10h_kgf_s=ccw_lfv_oa_10h_kgf_s;
    }
        
    public String getCcw_lfv_oa_10h_rank_s(){
        return ccw_lfv_oa_10h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_10h_rank_s(String ccw_lfv_oa_10h_rank_s){
        this.ccw_lfv_oa_10h_rank_s=ccw_lfv_oa_10h_rank_s;
    }
        
    public String getCcw_lfv_oa_1h_deg_s(){
        return ccw_lfv_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_1h_deg_s(String ccw_lfv_oa_1h_deg_s){
        this.ccw_lfv_oa_1h_deg_s=ccw_lfv_oa_1h_deg_s;
    }
        
    public String getCcw_lfv_oa_1h_kgf_s(){
        return ccw_lfv_oa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_1h_kgf_s(String ccw_lfv_oa_1h_kgf_s){
        this.ccw_lfv_oa_1h_kgf_s=ccw_lfv_oa_1h_kgf_s;
    }
        
    public String getCcw_lfv_oa_1h_rank_s(){
        return ccw_lfv_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_1h_rank_s(String ccw_lfv_oa_1h_rank_s){
        this.ccw_lfv_oa_1h_rank_s=ccw_lfv_oa_1h_rank_s;
    }
        
    public String getCcw_lfv_oa_2h_deg_s(){
        return ccw_lfv_oa_2h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_2h_deg_s(String ccw_lfv_oa_2h_deg_s){
        this.ccw_lfv_oa_2h_deg_s=ccw_lfv_oa_2h_deg_s;
    }
        
    public String getCcw_lfv_oa_2h_kgf_s(){
        return ccw_lfv_oa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_2h_kgf_s(String ccw_lfv_oa_2h_kgf_s){
        this.ccw_lfv_oa_2h_kgf_s=ccw_lfv_oa_2h_kgf_s;
    }
        
    public String getCcw_lfv_oa_2h_rank_s(){
        return ccw_lfv_oa_2h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_2h_rank_s(String ccw_lfv_oa_2h_rank_s){
        this.ccw_lfv_oa_2h_rank_s=ccw_lfv_oa_2h_rank_s;
    }
        
    public String getCcw_lfv_oa_3h_deg_s(){
        return ccw_lfv_oa_3h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_3h_deg_s(String ccw_lfv_oa_3h_deg_s){
        this.ccw_lfv_oa_3h_deg_s=ccw_lfv_oa_3h_deg_s;
    }
        
    public String getCcw_lfv_oa_3h_kgf_s(){
        return ccw_lfv_oa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_3h_kgf_s(String ccw_lfv_oa_3h_kgf_s){
        this.ccw_lfv_oa_3h_kgf_s=ccw_lfv_oa_3h_kgf_s;
    }
        
    public String getCcw_lfv_oa_3h_rank_s(){
        return ccw_lfv_oa_3h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_3h_rank_s(String ccw_lfv_oa_3h_rank_s){
        this.ccw_lfv_oa_3h_rank_s=ccw_lfv_oa_3h_rank_s;
    }
        
    public String getCcw_lfv_oa_4h_deg_s(){
        return ccw_lfv_oa_4h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_4h_deg_s(String ccw_lfv_oa_4h_deg_s){
        this.ccw_lfv_oa_4h_deg_s=ccw_lfv_oa_4h_deg_s;
    }
        
    public String getCcw_lfv_oa_4h_kgf_s(){
        return ccw_lfv_oa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_4h_kgf_s(String ccw_lfv_oa_4h_kgf_s){
        this.ccw_lfv_oa_4h_kgf_s=ccw_lfv_oa_4h_kgf_s;
    }
        
    public String getCcw_lfv_oa_4h_rank_s(){
        return ccw_lfv_oa_4h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_4h_rank_s(String ccw_lfv_oa_4h_rank_s){
        this.ccw_lfv_oa_4h_rank_s=ccw_lfv_oa_4h_rank_s;
    }
        
    public String getCcw_lfv_oa_5h_deg_s(){
        return ccw_lfv_oa_5h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_5h_deg_s(String ccw_lfv_oa_5h_deg_s){
        this.ccw_lfv_oa_5h_deg_s=ccw_lfv_oa_5h_deg_s;
    }
        
    public String getCcw_lfv_oa_5h_kgf_s(){
        return ccw_lfv_oa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_5h_kgf_s(String ccw_lfv_oa_5h_kgf_s){
        this.ccw_lfv_oa_5h_kgf_s=ccw_lfv_oa_5h_kgf_s;
    }
        
    public String getCcw_lfv_oa_5h_rank_s(){
        return ccw_lfv_oa_5h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_5h_rank_s(String ccw_lfv_oa_5h_rank_s){
        this.ccw_lfv_oa_5h_rank_s=ccw_lfv_oa_5h_rank_s;
    }
        
    public String getCcw_lfv_oa_6h_deg_s(){
        return ccw_lfv_oa_6h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_6h_deg_s(String ccw_lfv_oa_6h_deg_s){
        this.ccw_lfv_oa_6h_deg_s=ccw_lfv_oa_6h_deg_s;
    }
        
    public String getCcw_lfv_oa_6h_kgf_s(){
        return ccw_lfv_oa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_6h_kgf_s(String ccw_lfv_oa_6h_kgf_s){
        this.ccw_lfv_oa_6h_kgf_s=ccw_lfv_oa_6h_kgf_s;
    }
        
    public String getCcw_lfv_oa_6h_rank_s(){
        return ccw_lfv_oa_6h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_6h_rank_s(String ccw_lfv_oa_6h_rank_s){
        this.ccw_lfv_oa_6h_rank_s=ccw_lfv_oa_6h_rank_s;
    }
        
    public String getCcw_lfv_oa_7h_deg_s(){
        return ccw_lfv_oa_7h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_7h_deg_s(String ccw_lfv_oa_7h_deg_s){
        this.ccw_lfv_oa_7h_deg_s=ccw_lfv_oa_7h_deg_s;
    }
        
    public String getCcw_lfv_oa_7h_kgf_s(){
        return ccw_lfv_oa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_7h_kgf_s(String ccw_lfv_oa_7h_kgf_s){
        this.ccw_lfv_oa_7h_kgf_s=ccw_lfv_oa_7h_kgf_s;
    }
        
    public String getCcw_lfv_oa_7h_rank_s(){
        return ccw_lfv_oa_7h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_7h_rank_s(String ccw_lfv_oa_7h_rank_s){
        this.ccw_lfv_oa_7h_rank_s=ccw_lfv_oa_7h_rank_s;
    }
        
    public String getCcw_lfv_oa_8h_deg_s(){
        return ccw_lfv_oa_8h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_8h_deg_s(String ccw_lfv_oa_8h_deg_s){
        this.ccw_lfv_oa_8h_deg_s=ccw_lfv_oa_8h_deg_s;
    }
        
    public String getCcw_lfv_oa_8h_kgf_s(){
        return ccw_lfv_oa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_8h_kgf_s(String ccw_lfv_oa_8h_kgf_s){
        this.ccw_lfv_oa_8h_kgf_s=ccw_lfv_oa_8h_kgf_s;
    }
        
    public String getCcw_lfv_oa_8h_rank_s(){
        return ccw_lfv_oa_8h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_8h_rank_s(String ccw_lfv_oa_8h_rank_s){
        this.ccw_lfv_oa_8h_rank_s=ccw_lfv_oa_8h_rank_s;
    }
        
    public String getCcw_lfv_oa_9h_deg_s(){
        return ccw_lfv_oa_9h_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_9h_deg_s(String ccw_lfv_oa_9h_deg_s){
        this.ccw_lfv_oa_9h_deg_s=ccw_lfv_oa_9h_deg_s;
    }
        
    public String getCcw_lfv_oa_9h_kgf_s(){
        return ccw_lfv_oa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_9h_kgf_s(String ccw_lfv_oa_9h_kgf_s){
        this.ccw_lfv_oa_9h_kgf_s=ccw_lfv_oa_9h_kgf_s;
    }
        
    public String getCcw_lfv_oa_9h_rank_s(){
        return ccw_lfv_oa_9h_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_9h_rank_s(String ccw_lfv_oa_9h_rank_s){
        this.ccw_lfv_oa_9h_rank_s=ccw_lfv_oa_9h_rank_s;
    }
        
    public String getCcw_lfv_oa_deg_s(){
        return ccw_lfv_oa_deg_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_deg_s(String ccw_lfv_oa_deg_s){
        this.ccw_lfv_oa_deg_s=ccw_lfv_oa_deg_s;
    }
        
    public String getCcw_lfv_oa_kgf_s(){
        return ccw_lfv_oa_kgf_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_kgf_s(String ccw_lfv_oa_kgf_s){
        this.ccw_lfv_oa_kgf_s=ccw_lfv_oa_kgf_s;
    }
        
    public String getCcw_lfv_oa_rank_s(){
        return ccw_lfv_oa_rank_s;
    }
    
    @XmlElement
    public void setCcw_lfv_oa_rank_s(String ccw_lfv_oa_rank_s){
        this.ccw_lfv_oa_rank_s=ccw_lfv_oa_rank_s;
    }
        
    public String getCcw_rfv_oa_10h_deg_s(){
        return ccw_rfv_oa_10h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_10h_deg_s(String ccw_rfv_oa_10h_deg_s){
        this.ccw_rfv_oa_10h_deg_s=ccw_rfv_oa_10h_deg_s;
    }
        
    public String getCcw_rfv_oa_10h_kgf_s(){
        return ccw_rfv_oa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_10h_kgf_s(String ccw_rfv_oa_10h_kgf_s){
        this.ccw_rfv_oa_10h_kgf_s=ccw_rfv_oa_10h_kgf_s;
    }
        
    public String getCcw_rfv_oa_10h_rank_s(){
        return ccw_rfv_oa_10h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_10h_rank_s(String ccw_rfv_oa_10h_rank_s){
        this.ccw_rfv_oa_10h_rank_s=ccw_rfv_oa_10h_rank_s;
    }
        
    public String getCcw_rfv_oa_1h_deg_s(){
        return ccw_rfv_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_1h_deg_s(String ccw_rfv_oa_1h_deg_s){
        this.ccw_rfv_oa_1h_deg_s=ccw_rfv_oa_1h_deg_s;
    }
        
    public String getCcw_rfv_oa_1h_kgf_s(){
        return ccw_rfv_oa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_1h_kgf_s(String ccw_rfv_oa_1h_kgf_s){
        this.ccw_rfv_oa_1h_kgf_s=ccw_rfv_oa_1h_kgf_s;
    }
        
    public String getCcw_rfv_oa_1h_rank_s(){
        return ccw_rfv_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_1h_rank_s(String ccw_rfv_oa_1h_rank_s){
        this.ccw_rfv_oa_1h_rank_s=ccw_rfv_oa_1h_rank_s;
    }
        
    public String getCcw_rfv_oa_2h_deg_s(){
        return ccw_rfv_oa_2h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_2h_deg_s(String ccw_rfv_oa_2h_deg_s){
        this.ccw_rfv_oa_2h_deg_s=ccw_rfv_oa_2h_deg_s;
    }
        
    public String getCcw_rfv_oa_2h_kgf_s(){
        return ccw_rfv_oa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_2h_kgf_s(String ccw_rfv_oa_2h_kgf_s){
        this.ccw_rfv_oa_2h_kgf_s=ccw_rfv_oa_2h_kgf_s;
    }
        
    public String getCcw_rfv_oa_2h_rank_s(){
        return ccw_rfv_oa_2h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_2h_rank_s(String ccw_rfv_oa_2h_rank_s){
        this.ccw_rfv_oa_2h_rank_s=ccw_rfv_oa_2h_rank_s;
    }
        
    public String getCcw_rfv_oa_3h_deg_s(){
        return ccw_rfv_oa_3h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_3h_deg_s(String ccw_rfv_oa_3h_deg_s){
        this.ccw_rfv_oa_3h_deg_s=ccw_rfv_oa_3h_deg_s;
    }
        
    public String getCcw_rfv_oa_3h_kgf_s(){
        return ccw_rfv_oa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_3h_kgf_s(String ccw_rfv_oa_3h_kgf_s){
        this.ccw_rfv_oa_3h_kgf_s=ccw_rfv_oa_3h_kgf_s;
    }
        
    public String getCcw_rfv_oa_3h_rank_s(){
        return ccw_rfv_oa_3h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_3h_rank_s(String ccw_rfv_oa_3h_rank_s){
        this.ccw_rfv_oa_3h_rank_s=ccw_rfv_oa_3h_rank_s;
    }
        
    public String getCcw_rfv_oa_4h_deg_s(){
        return ccw_rfv_oa_4h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_4h_deg_s(String ccw_rfv_oa_4h_deg_s){
        this.ccw_rfv_oa_4h_deg_s=ccw_rfv_oa_4h_deg_s;
    }
        
    public String getCcw_rfv_oa_4h_kgf_s(){
        return ccw_rfv_oa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_4h_kgf_s(String ccw_rfv_oa_4h_kgf_s){
        this.ccw_rfv_oa_4h_kgf_s=ccw_rfv_oa_4h_kgf_s;
    }
        
    public String getCcw_rfv_oa_4h_rank_s(){
        return ccw_rfv_oa_4h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_4h_rank_s(String ccw_rfv_oa_4h_rank_s){
        this.ccw_rfv_oa_4h_rank_s=ccw_rfv_oa_4h_rank_s;
    }
        
    public String getCcw_rfv_oa_5h_deg_s(){
        return ccw_rfv_oa_5h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_5h_deg_s(String ccw_rfv_oa_5h_deg_s){
        this.ccw_rfv_oa_5h_deg_s=ccw_rfv_oa_5h_deg_s;
    }
        
    public String getCcw_rfv_oa_5h_kgf_s(){
        return ccw_rfv_oa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_5h_kgf_s(String ccw_rfv_oa_5h_kgf_s){
        this.ccw_rfv_oa_5h_kgf_s=ccw_rfv_oa_5h_kgf_s;
    }
        
    public String getCcw_rfv_oa_5h_rank_s(){
        return ccw_rfv_oa_5h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_5h_rank_s(String ccw_rfv_oa_5h_rank_s){
        this.ccw_rfv_oa_5h_rank_s=ccw_rfv_oa_5h_rank_s;
    }
        
    public String getCcw_rfv_oa_6h_deg_s(){
        return ccw_rfv_oa_6h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_6h_deg_s(String ccw_rfv_oa_6h_deg_s){
        this.ccw_rfv_oa_6h_deg_s=ccw_rfv_oa_6h_deg_s;
    }
        
    public String getCcw_rfv_oa_6h_kgf_s(){
        return ccw_rfv_oa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_6h_kgf_s(String ccw_rfv_oa_6h_kgf_s){
        this.ccw_rfv_oa_6h_kgf_s=ccw_rfv_oa_6h_kgf_s;
    }
        
    public String getCcw_rfv_oa_6h_rank_s(){
        return ccw_rfv_oa_6h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_6h_rank_s(String ccw_rfv_oa_6h_rank_s){
        this.ccw_rfv_oa_6h_rank_s=ccw_rfv_oa_6h_rank_s;
    }
        
    public String getCcw_rfv_oa_7h_deg_s(){
        return ccw_rfv_oa_7h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_7h_deg_s(String ccw_rfv_oa_7h_deg_s){
        this.ccw_rfv_oa_7h_deg_s=ccw_rfv_oa_7h_deg_s;
    }
        
    public String getCcw_rfv_oa_7h_kgf_s(){
        return ccw_rfv_oa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_7h_kgf_s(String ccw_rfv_oa_7h_kgf_s){
        this.ccw_rfv_oa_7h_kgf_s=ccw_rfv_oa_7h_kgf_s;
    }
        
    public String getCcw_rfv_oa_7h_rank_s(){
        return ccw_rfv_oa_7h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_7h_rank_s(String ccw_rfv_oa_7h_rank_s){
        this.ccw_rfv_oa_7h_rank_s=ccw_rfv_oa_7h_rank_s;
    }
        
    public String getCcw_rfv_oa_8h_deg_s(){
        return ccw_rfv_oa_8h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_8h_deg_s(String ccw_rfv_oa_8h_deg_s){
        this.ccw_rfv_oa_8h_deg_s=ccw_rfv_oa_8h_deg_s;
    }
        
    public String getCcw_rfv_oa_8h_kgf_s(){
        return ccw_rfv_oa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_8h_kgf_s(String ccw_rfv_oa_8h_kgf_s){
        this.ccw_rfv_oa_8h_kgf_s=ccw_rfv_oa_8h_kgf_s;
    }
        
    public String getCcw_rfv_oa_8h_rank_s(){
        return ccw_rfv_oa_8h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_8h_rank_s(String ccw_rfv_oa_8h_rank_s){
        this.ccw_rfv_oa_8h_rank_s=ccw_rfv_oa_8h_rank_s;
    }
        
    public String getCcw_rfv_oa_9h_deg_s(){
        return ccw_rfv_oa_9h_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_9h_deg_s(String ccw_rfv_oa_9h_deg_s){
        this.ccw_rfv_oa_9h_deg_s=ccw_rfv_oa_9h_deg_s;
    }
        
    public String getCcw_rfv_oa_9h_kgf_s(){
        return ccw_rfv_oa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_9h_kgf_s(String ccw_rfv_oa_9h_kgf_s){
        this.ccw_rfv_oa_9h_kgf_s=ccw_rfv_oa_9h_kgf_s;
    }
        
    public String getCcw_rfv_oa_9h_rank_s(){
        return ccw_rfv_oa_9h_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_9h_rank_s(String ccw_rfv_oa_9h_rank_s){
        this.ccw_rfv_oa_9h_rank_s=ccw_rfv_oa_9h_rank_s;
    }
        
    public String getCcw_rfv_oa_deg_s(){
        return ccw_rfv_oa_deg_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_deg_s(String ccw_rfv_oa_deg_s){
        this.ccw_rfv_oa_deg_s=ccw_rfv_oa_deg_s;
    }
        
    public String getCcw_rfv_oa_kgf_s(){
        return ccw_rfv_oa_kgf_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_kgf_s(String ccw_rfv_oa_kgf_s){
        this.ccw_rfv_oa_kgf_s=ccw_rfv_oa_kgf_s;
    }
        
    public String getCcw_rfv_oa_rank_s(){
        return ccw_rfv_oa_rank_s;
    }
    
    @XmlElement
    public void setCcw_rfv_oa_rank_s(String ccw_rfv_oa_rank_s){
        this.ccw_rfv_oa_rank_s=ccw_rfv_oa_rank_s;
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
        
    public String getCw_lfv_oa_10h_deg_s(){
        return cw_lfv_oa_10h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_10h_deg_s(String cw_lfv_oa_10h_deg_s){
        this.cw_lfv_oa_10h_deg_s=cw_lfv_oa_10h_deg_s;
    }
        
    public String getCw_lfv_oa_10h_kgf_s(){
        return cw_lfv_oa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_10h_kgf_s(String cw_lfv_oa_10h_kgf_s){
        this.cw_lfv_oa_10h_kgf_s=cw_lfv_oa_10h_kgf_s;
    }
        
    public String getCw_lfv_oa_10h_rank_s(){
        return cw_lfv_oa_10h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_10h_rank_s(String cw_lfv_oa_10h_rank_s){
        this.cw_lfv_oa_10h_rank_s=cw_lfv_oa_10h_rank_s;
    }
        
    public String getCw_lfv_oa_1h_deg_s(){
        return cw_lfv_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_1h_deg_s(String cw_lfv_oa_1h_deg_s){
        this.cw_lfv_oa_1h_deg_s=cw_lfv_oa_1h_deg_s;
    }
        
    public String getCw_lfv_oa_1h_kgf_s(){
        return cw_lfv_oa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_1h_kgf_s(String cw_lfv_oa_1h_kgf_s){
        this.cw_lfv_oa_1h_kgf_s=cw_lfv_oa_1h_kgf_s;
    }
        
    public String getCw_lfv_oa_1h_rank_s(){
        return cw_lfv_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_1h_rank_s(String cw_lfv_oa_1h_rank_s){
        this.cw_lfv_oa_1h_rank_s=cw_lfv_oa_1h_rank_s;
    }
        
    public String getCw_lfv_oa_2h_deg_s(){
        return cw_lfv_oa_2h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_2h_deg_s(String cw_lfv_oa_2h_deg_s){
        this.cw_lfv_oa_2h_deg_s=cw_lfv_oa_2h_deg_s;
    }
        
    public String getCw_lfv_oa_2h_kgf_s(){
        return cw_lfv_oa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_2h_kgf_s(String cw_lfv_oa_2h_kgf_s){
        this.cw_lfv_oa_2h_kgf_s=cw_lfv_oa_2h_kgf_s;
    }
        
    public String getCw_lfv_oa_2h_rank_s(){
        return cw_lfv_oa_2h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_2h_rank_s(String cw_lfv_oa_2h_rank_s){
        this.cw_lfv_oa_2h_rank_s=cw_lfv_oa_2h_rank_s;
    }
        
    public String getCw_lfv_oa_3h_deg_s(){
        return cw_lfv_oa_3h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_3h_deg_s(String cw_lfv_oa_3h_deg_s){
        this.cw_lfv_oa_3h_deg_s=cw_lfv_oa_3h_deg_s;
    }
        
    public String getCw_lfv_oa_3h_kgf_s(){
        return cw_lfv_oa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_3h_kgf_s(String cw_lfv_oa_3h_kgf_s){
        this.cw_lfv_oa_3h_kgf_s=cw_lfv_oa_3h_kgf_s;
    }
        
    public String getCw_lfv_oa_3h_rank_s(){
        return cw_lfv_oa_3h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_3h_rank_s(String cw_lfv_oa_3h_rank_s){
        this.cw_lfv_oa_3h_rank_s=cw_lfv_oa_3h_rank_s;
    }
        
    public String getCw_lfv_oa_4h_deg_s(){
        return cw_lfv_oa_4h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_4h_deg_s(String cw_lfv_oa_4h_deg_s){
        this.cw_lfv_oa_4h_deg_s=cw_lfv_oa_4h_deg_s;
    }
        
    public String getCw_lfv_oa_4h_kgf_s(){
        return cw_lfv_oa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_4h_kgf_s(String cw_lfv_oa_4h_kgf_s){
        this.cw_lfv_oa_4h_kgf_s=cw_lfv_oa_4h_kgf_s;
    }
        
    public String getCw_lfv_oa_4h_rank_s(){
        return cw_lfv_oa_4h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_4h_rank_s(String cw_lfv_oa_4h_rank_s){
        this.cw_lfv_oa_4h_rank_s=cw_lfv_oa_4h_rank_s;
    }
        
    public String getCw_lfv_oa_5h_deg_s(){
        return cw_lfv_oa_5h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_5h_deg_s(String cw_lfv_oa_5h_deg_s){
        this.cw_lfv_oa_5h_deg_s=cw_lfv_oa_5h_deg_s;
    }
        
    public String getCw_lfv_oa_5h_kgf_s(){
        return cw_lfv_oa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_5h_kgf_s(String cw_lfv_oa_5h_kgf_s){
        this.cw_lfv_oa_5h_kgf_s=cw_lfv_oa_5h_kgf_s;
    }
        
    public String getCw_lfv_oa_5h_rank_s(){
        return cw_lfv_oa_5h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_5h_rank_s(String cw_lfv_oa_5h_rank_s){
        this.cw_lfv_oa_5h_rank_s=cw_lfv_oa_5h_rank_s;
    }
        
    public String getCw_lfv_oa_6h_deg_s(){
        return cw_lfv_oa_6h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_6h_deg_s(String cw_lfv_oa_6h_deg_s){
        this.cw_lfv_oa_6h_deg_s=cw_lfv_oa_6h_deg_s;
    }
        
    public String getCw_lfv_oa_6h_kgf_s(){
        return cw_lfv_oa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_6h_kgf_s(String cw_lfv_oa_6h_kgf_s){
        this.cw_lfv_oa_6h_kgf_s=cw_lfv_oa_6h_kgf_s;
    }
        
    public String getCw_lfv_oa_6h_rank_s(){
        return cw_lfv_oa_6h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_6h_rank_s(String cw_lfv_oa_6h_rank_s){
        this.cw_lfv_oa_6h_rank_s=cw_lfv_oa_6h_rank_s;
    }
        
    public String getCw_lfv_oa_7h_deg_s(){
        return cw_lfv_oa_7h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_7h_deg_s(String cw_lfv_oa_7h_deg_s){
        this.cw_lfv_oa_7h_deg_s=cw_lfv_oa_7h_deg_s;
    }
        
    public String getCw_lfv_oa_7h_kgf_s(){
        return cw_lfv_oa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_7h_kgf_s(String cw_lfv_oa_7h_kgf_s){
        this.cw_lfv_oa_7h_kgf_s=cw_lfv_oa_7h_kgf_s;
    }
        
    public String getCw_lfv_oa_7h_rank_s(){
        return cw_lfv_oa_7h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_7h_rank_s(String cw_lfv_oa_7h_rank_s){
        this.cw_lfv_oa_7h_rank_s=cw_lfv_oa_7h_rank_s;
    }
        
    public String getCw_lfv_oa_8h_deg_s(){
        return cw_lfv_oa_8h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_8h_deg_s(String cw_lfv_oa_8h_deg_s){
        this.cw_lfv_oa_8h_deg_s=cw_lfv_oa_8h_deg_s;
    }
        
    public String getCw_lfv_oa_8h_kgf_s(){
        return cw_lfv_oa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_8h_kgf_s(String cw_lfv_oa_8h_kgf_s){
        this.cw_lfv_oa_8h_kgf_s=cw_lfv_oa_8h_kgf_s;
    }
        
    public String getCw_lfv_oa_8h_rank_s(){
        return cw_lfv_oa_8h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_8h_rank_s(String cw_lfv_oa_8h_rank_s){
        this.cw_lfv_oa_8h_rank_s=cw_lfv_oa_8h_rank_s;
    }
        
    public String getCw_lfv_oa_9h_deg_s(){
        return cw_lfv_oa_9h_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_9h_deg_s(String cw_lfv_oa_9h_deg_s){
        this.cw_lfv_oa_9h_deg_s=cw_lfv_oa_9h_deg_s;
    }
        
    public String getCw_lfv_oa_9h_kgf_s(){
        return cw_lfv_oa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_9h_kgf_s(String cw_lfv_oa_9h_kgf_s){
        this.cw_lfv_oa_9h_kgf_s=cw_lfv_oa_9h_kgf_s;
    }
        
    public String getCw_lfv_oa_9h_rank_s(){
        return cw_lfv_oa_9h_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_9h_rank_s(String cw_lfv_oa_9h_rank_s){
        this.cw_lfv_oa_9h_rank_s=cw_lfv_oa_9h_rank_s;
    }
        
    public String getCw_lfv_oa_deg_s(){
        return cw_lfv_oa_deg_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_deg_s(String cw_lfv_oa_deg_s){
        this.cw_lfv_oa_deg_s=cw_lfv_oa_deg_s;
    }
        
    public String getCw_lfv_oa_kgf_s(){
        return cw_lfv_oa_kgf_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_kgf_s(String cw_lfv_oa_kgf_s){
        this.cw_lfv_oa_kgf_s=cw_lfv_oa_kgf_s;
    }
        
    public String getCw_lfv_oa_rank_s(){
        return cw_lfv_oa_rank_s;
    }
    
    @XmlElement
    public void setCw_lfv_oa_rank_s(String cw_lfv_oa_rank_s){
        this.cw_lfv_oa_rank_s=cw_lfv_oa_rank_s;
    }
        
    public String getCw_rfv_oa_10h_deg_s(){
        return cw_rfv_oa_10h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_10h_deg_s(String cw_rfv_oa_10h_deg_s){
        this.cw_rfv_oa_10h_deg_s=cw_rfv_oa_10h_deg_s;
    }
        
    public String getCw_rfv_oa_10h_kgf_s(){
        return cw_rfv_oa_10h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_10h_kgf_s(String cw_rfv_oa_10h_kgf_s){
        this.cw_rfv_oa_10h_kgf_s=cw_rfv_oa_10h_kgf_s;
    }
        
    public String getCw_rfv_oa_10h_rank_s(){
        return cw_rfv_oa_10h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_10h_rank_s(String cw_rfv_oa_10h_rank_s){
        this.cw_rfv_oa_10h_rank_s=cw_rfv_oa_10h_rank_s;
    }
        
    public String getCw_rfv_oa_1h_deg_s(){
        return cw_rfv_oa_1h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_1h_deg_s(String cw_rfv_oa_1h_deg_s){
        this.cw_rfv_oa_1h_deg_s=cw_rfv_oa_1h_deg_s;
    }
        
    public String getCw_rfv_oa_1h_kgf_s(){
        return cw_rfv_oa_1h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_1h_kgf_s(String cw_rfv_oa_1h_kgf_s){
        this.cw_rfv_oa_1h_kgf_s=cw_rfv_oa_1h_kgf_s;
    }
        
    public String getCw_rfv_oa_1h_rank_s(){
        return cw_rfv_oa_1h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_1h_rank_s(String cw_rfv_oa_1h_rank_s){
        this.cw_rfv_oa_1h_rank_s=cw_rfv_oa_1h_rank_s;
    }
        
    public String getCw_rfv_oa_2h_deg_s(){
        return cw_rfv_oa_2h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_2h_deg_s(String cw_rfv_oa_2h_deg_s){
        this.cw_rfv_oa_2h_deg_s=cw_rfv_oa_2h_deg_s;
    }
        
    public String getCw_rfv_oa_2h_kgf_s(){
        return cw_rfv_oa_2h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_2h_kgf_s(String cw_rfv_oa_2h_kgf_s){
        this.cw_rfv_oa_2h_kgf_s=cw_rfv_oa_2h_kgf_s;
    }
        
    public String getCw_rfv_oa_2h_rank_s(){
        return cw_rfv_oa_2h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_2h_rank_s(String cw_rfv_oa_2h_rank_s){
        this.cw_rfv_oa_2h_rank_s=cw_rfv_oa_2h_rank_s;
    }
        
    public String getCw_rfv_oa_3h_deg_s(){
        return cw_rfv_oa_3h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_3h_deg_s(String cw_rfv_oa_3h_deg_s){
        this.cw_rfv_oa_3h_deg_s=cw_rfv_oa_3h_deg_s;
    }
        
    public String getCw_rfv_oa_3h_kgf_s(){
        return cw_rfv_oa_3h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_3h_kgf_s(String cw_rfv_oa_3h_kgf_s){
        this.cw_rfv_oa_3h_kgf_s=cw_rfv_oa_3h_kgf_s;
    }
        
    public String getCw_rfv_oa_3h_rank_s(){
        return cw_rfv_oa_3h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_3h_rank_s(String cw_rfv_oa_3h_rank_s){
        this.cw_rfv_oa_3h_rank_s=cw_rfv_oa_3h_rank_s;
    }
        
    public String getCw_rfv_oa_4h_deg_s(){
        return cw_rfv_oa_4h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_4h_deg_s(String cw_rfv_oa_4h_deg_s){
        this.cw_rfv_oa_4h_deg_s=cw_rfv_oa_4h_deg_s;
    }
        
    public String getCw_rfv_oa_4h_kgf_s(){
        return cw_rfv_oa_4h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_4h_kgf_s(String cw_rfv_oa_4h_kgf_s){
        this.cw_rfv_oa_4h_kgf_s=cw_rfv_oa_4h_kgf_s;
    }
        
    public String getCw_rfv_oa_4h_rank_s(){
        return cw_rfv_oa_4h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_4h_rank_s(String cw_rfv_oa_4h_rank_s){
        this.cw_rfv_oa_4h_rank_s=cw_rfv_oa_4h_rank_s;
    }
        
    public String getCw_rfv_oa_5h_deg_s(){
        return cw_rfv_oa_5h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_5h_deg_s(String cw_rfv_oa_5h_deg_s){
        this.cw_rfv_oa_5h_deg_s=cw_rfv_oa_5h_deg_s;
    }
        
    public String getCw_rfv_oa_5h_kgf_s(){
        return cw_rfv_oa_5h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_5h_kgf_s(String cw_rfv_oa_5h_kgf_s){
        this.cw_rfv_oa_5h_kgf_s=cw_rfv_oa_5h_kgf_s;
    }
        
    public String getCw_rfv_oa_5h_rank_s(){
        return cw_rfv_oa_5h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_5h_rank_s(String cw_rfv_oa_5h_rank_s){
        this.cw_rfv_oa_5h_rank_s=cw_rfv_oa_5h_rank_s;
    }
        
    public String getCw_rfv_oa_6h_deg_s(){
        return cw_rfv_oa_6h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_6h_deg_s(String cw_rfv_oa_6h_deg_s){
        this.cw_rfv_oa_6h_deg_s=cw_rfv_oa_6h_deg_s;
    }
        
    public String getCw_rfv_oa_6h_kgf_s(){
        return cw_rfv_oa_6h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_6h_kgf_s(String cw_rfv_oa_6h_kgf_s){
        this.cw_rfv_oa_6h_kgf_s=cw_rfv_oa_6h_kgf_s;
    }
        
    public String getCw_rfv_oa_6h_rank_s(){
        return cw_rfv_oa_6h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_6h_rank_s(String cw_rfv_oa_6h_rank_s){
        this.cw_rfv_oa_6h_rank_s=cw_rfv_oa_6h_rank_s;
    }
        
    public String getCw_rfv_oa_7h_deg_s(){
        return cw_rfv_oa_7h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_7h_deg_s(String cw_rfv_oa_7h_deg_s){
        this.cw_rfv_oa_7h_deg_s=cw_rfv_oa_7h_deg_s;
    }
        
    public String getCw_rfv_oa_7h_kgf_s(){
        return cw_rfv_oa_7h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_7h_kgf_s(String cw_rfv_oa_7h_kgf_s){
        this.cw_rfv_oa_7h_kgf_s=cw_rfv_oa_7h_kgf_s;
    }
        
    public String getCw_rfv_oa_7h_rank_s(){
        return cw_rfv_oa_7h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_7h_rank_s(String cw_rfv_oa_7h_rank_s){
        this.cw_rfv_oa_7h_rank_s=cw_rfv_oa_7h_rank_s;
    }
        
    public String getCw_rfv_oa_8h_deg_s(){
        return cw_rfv_oa_8h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_8h_deg_s(String cw_rfv_oa_8h_deg_s){
        this.cw_rfv_oa_8h_deg_s=cw_rfv_oa_8h_deg_s;
    }
        
    public String getCw_rfv_oa_8h_kgf_s(){
        return cw_rfv_oa_8h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_8h_kgf_s(String cw_rfv_oa_8h_kgf_s){
        this.cw_rfv_oa_8h_kgf_s=cw_rfv_oa_8h_kgf_s;
    }
        
    public String getCw_rfv_oa_8h_rank_s(){
        return cw_rfv_oa_8h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_8h_rank_s(String cw_rfv_oa_8h_rank_s){
        this.cw_rfv_oa_8h_rank_s=cw_rfv_oa_8h_rank_s;
    }
        
    public String getCw_rfv_oa_9h_deg_s(){
        return cw_rfv_oa_9h_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_9h_deg_s(String cw_rfv_oa_9h_deg_s){
        this.cw_rfv_oa_9h_deg_s=cw_rfv_oa_9h_deg_s;
    }
        
    public String getCw_rfv_oa_9h_kgf_s(){
        return cw_rfv_oa_9h_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_9h_kgf_s(String cw_rfv_oa_9h_kgf_s){
        this.cw_rfv_oa_9h_kgf_s=cw_rfv_oa_9h_kgf_s;
    }
        
    public String getCw_rfv_oa_9h_rank_s(){
        return cw_rfv_oa_9h_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_9h_rank_s(String cw_rfv_oa_9h_rank_s){
        this.cw_rfv_oa_9h_rank_s=cw_rfv_oa_9h_rank_s;
    }
        
    public String getCw_rfv_oa_deg_s(){
        return cw_rfv_oa_deg_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_deg_s(String cw_rfv_oa_deg_s){
        this.cw_rfv_oa_deg_s=cw_rfv_oa_deg_s;
    }
        
    public String getCw_rfv_oa_kgf_s(){
        return cw_rfv_oa_kgf_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_kgf_s(String cw_rfv_oa_kgf_s){
        this.cw_rfv_oa_kgf_s=cw_rfv_oa_kgf_s;
    }
        
    public String getCw_rfv_oa_rank_s(){
        return cw_rfv_oa_rank_s;
    }
    
    @XmlElement
    public void setCw_rfv_oa_rank_s(String cw_rfv_oa_rank_s){
        this.cw_rfv_oa_rank_s=cw_rfv_oa_rank_s;
    }
        
    public String getGradecode_s(){
        return gradecode_s;
    }
    
    @XmlElement
    public void setGradecode_s(String gradecode_s){
        this.gradecode_s=gradecode_s;
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
        
    public String getLoad_s(){
        return load_s;
    }
    
    @XmlElement
    public void setLoad_s(String load_s){
        this.load_s=load_s;
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
        
    public String getMemo_s(){
        return memo_s;
    }
    
    @XmlElement
    public void setMemo_s(String memo_s){
        this.memo_s=memo_s;
    }
        
    public String getOutside_diameter_mm_s(){
        return outside_diameter_mm_s;
    }
    
    @XmlElement
    public void setOutside_diameter_mm_s(String outside_diameter_mm_s){
        this.outside_diameter_mm_s=outside_diameter_mm_s;
    }
        
    public String getOutside_diameter_rank_s(){
        return outside_diameter_rank_s;
    }
    
    @XmlElement
    public void setOutside_diameter_rank_s(String outside_diameter_rank_s){
        this.outside_diameter_rank_s=outside_diameter_rank_s;
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
        
    public String getRo_total_rank_s(){
        return ro_total_rank_s;
    }
    
    @XmlElement
    public void setRo_total_rank_s(String ro_total_rank_s){
        this.ro_total_rank_s=ro_total_rank_s;
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
        
    public String getSpecification_s(){
        return specification_s;
    }
    
    @XmlElement
    public void setSpecification_s(String specification_s){
        this.specification_s=specification_s;
    }
        
    public String getS_factory_s(){
        return s_factory_s;
    }
    
    @XmlElement
    public void setS_factory_s(String s_factory_s){
        this.s_factory_s=s_factory_s;
    }
        
    public String getUfm_total_rank_s(){
        return ufm_total_rank_s;
    }
    
    @XmlElement
    public void setUfm_total_rank_s(String ufm_total_rank_s){
        this.ufm_total_rank_s=ufm_total_rank_s;
    }
        
    
    
    
}
