/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanLog;

/**
 * 半部件日计划倒推异常记录表
 * @author 兰颖慧
 * @Date 2019-08-08 16:01:47
 */
public class ProductPlanLogDTO extends ProductPlanLog{
    
    private List<ProductPlanLog> inserted;
    private List<ProductPlanLog> deleted;
    private List<ProductPlanLog> updated;
    public List<ProductPlanLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<ProductPlanLog> inserted) {
        this.inserted = inserted;
    }
    public List<ProductPlanLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ProductPlanLog> deleted) {
        this.deleted = deleted;
    }
    public List<ProductPlanLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ProductPlanLog> updated) {
        this.updated = updated;
    }
    
    
    
}
