/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.Dynabalancereversal;

/**
 * 质检动平衡翻转维护
 * @author 马建斌
 * @Date 2018-10-12 10:21:29
 */
public class DynabalancereversalDTO extends Dynabalancereversal{
    
    private List<Dynabalancereversal> inserted;
    private List<Dynabalancereversal> deleted;
    private List<Dynabalancereversal> updated;
    public List<Dynabalancereversal> getInserted() {
        return inserted;
    }
    public void setInserted(List<Dynabalancereversal> inserted) {
        this.inserted = inserted;
    }
    public List<Dynabalancereversal> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Dynabalancereversal> deleted) {
        this.deleted = deleted;
    }
    public List<Dynabalancereversal> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Dynabalancereversal> updated) {
        this.updated = updated;
    }
    
    
    
}
