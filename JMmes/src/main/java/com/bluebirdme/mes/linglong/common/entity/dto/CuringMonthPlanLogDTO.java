/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.common.entity.CuringMonthPlanLog;

/**
 * 轮胎主表(同步硫化月计划实际产量及已过动平衡量)
 * @author 兰颖慧
 * @Date 2019-02-20 17:30:34
 */
public class CuringMonthPlanLogDTO extends CuringMonthPlanLog{
    
    private List<CuringMonthPlanLog> inserted;
    private List<CuringMonthPlanLog> deleted;
    private List<CuringMonthPlanLog> updated;
    public List<CuringMonthPlanLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<CuringMonthPlanLog> inserted) {
        this.inserted = inserted;
    }
    public List<CuringMonthPlanLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<CuringMonthPlanLog> deleted) {
        this.deleted = deleted;
    }
    public List<CuringMonthPlanLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<CuringMonthPlanLog> updated) {
        this.updated = updated;
    }
    
    
    
}
