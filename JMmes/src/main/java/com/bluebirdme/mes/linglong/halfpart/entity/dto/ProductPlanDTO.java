/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanExtend;

/**
 * 半部件日计划
 * @author 兰颖慧
 * @Date 2019-04-04 14:49:13
 */
public class ProductPlanDTO extends ProductPlan{
    
    private List<ProductPlan> inserted;
    private List<ProductPlan> deleted;
    private List<ProductPlan> updated;
    public List<ProductPlan> getInserted() {
        return inserted;
    }
    public void setInserted(List<ProductPlan> inserted) {
        this.inserted = inserted;
    }
    public List<ProductPlan> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ProductPlan> deleted) {
        this.deleted = deleted;
    }
    public List<ProductPlan> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ProductPlan> updated) {
        this.updated = updated;
    }
    
    
    
}
