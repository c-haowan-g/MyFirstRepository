/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.sap.entity.PlmDynamicBalance;

/**
 * PLM动平衡参数表
 * @author 刘程明
 * @Date 2018-12-05 14:25:20
 */
public class PlmDynamicBalanceDTO extends PlmDynamicBalance{
    
    private List<PlmDynamicBalance> inserted;
    private List<PlmDynamicBalance> deleted;
    private List<PlmDynamicBalance> updated;
    public List<PlmDynamicBalance> getInserted() {
        return inserted;
    }
    public void setInserted(List<PlmDynamicBalance> inserted) {
        this.inserted = inserted;
    }
    public List<PlmDynamicBalance> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<PlmDynamicBalance> deleted) {
        this.deleted = deleted;
    }
    public List<PlmDynamicBalance> getUpdated() {
        return updated;
    }
    public void setUpdated(List<PlmDynamicBalance> updated) {
        this.updated = updated;
    }
    
    
    
}
