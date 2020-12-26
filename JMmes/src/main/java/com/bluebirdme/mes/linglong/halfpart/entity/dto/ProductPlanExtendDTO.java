/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanExtend;

/**
 * 半部件日计划
 * @author 兰颖慧
 * @Date 2019-04-04 14:49:13
 */
public class ProductPlanExtendDTO extends ProductPlanExtend{
    
    private List<ProductPlanExtend> inserted;
    private List<ProductPlanExtend> deleted;
    private List<ProductPlanExtend> updated;
    public List<ProductPlanExtend> getInserted() {
        return inserted;
    }
    public void setInserted(List<ProductPlanExtend> inserted) {
        this.inserted = inserted;
    }
    public List<ProductPlanExtend> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ProductPlanExtend> deleted) {
        this.deleted = deleted;
    }
    public List<ProductPlanExtend> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ProductPlanExtend> updated) {
        this.updated = updated;
    }
    
    
    
}
