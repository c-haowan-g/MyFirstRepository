/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynamicBalance;

/**
 * PLM动平衡参数表
 * @author 赵怀浩
 * @Date 2018-11-28 09:19:33
 */
public class DynamicBalanceDTO extends DynamicBalance{
    
    private List<DynamicBalance> inserted;
    private List<DynamicBalance> deleted;
    private List<DynamicBalance> updated;
    public List<DynamicBalance> getInserted() {
        return inserted;
    }
    public void setInserted(List<DynamicBalance> inserted) {
        this.inserted = inserted;
    }
    public List<DynamicBalance> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<DynamicBalance> deleted) {
        this.deleted = deleted;
    }
    public List<DynamicBalance> getUpdated() {
        return updated;
    }
    public void setUpdated(List<DynamicBalance> updated) {
        this.updated = updated;
    }
    
    
    
}
