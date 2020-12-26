/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.curing.entity.MoldChangePlan;

/**
 * 硫化换模计划表
 * @author 李彦
 * @Date 2018-08-07 13:21:53
 */
public class MoldChangePlanDTO extends MoldChangePlan{
    
    private List<MoldChangePlan> inserted;
    private List<MoldChangePlan> deleted;
    private List<MoldChangePlan> updated;
    public List<MoldChangePlan> getInserted() {
        return inserted;
    }
    public void setInserted(List<MoldChangePlan> inserted) {
        this.inserted = inserted;
    }
    public List<MoldChangePlan> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<MoldChangePlan> deleted) {
        this.deleted = deleted;
    }
    public List<MoldChangePlan> getUpdated() {
        return updated;
    }
    public void setUpdated(List<MoldChangePlan> updated) {
        this.updated = updated;
    }
    
    
    
}
