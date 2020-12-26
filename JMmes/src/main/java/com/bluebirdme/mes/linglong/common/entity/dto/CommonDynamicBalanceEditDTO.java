/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.common.entity.CommonDynamicBalanceEdit;

/**
 * PLM动平衡标准管理表
 * @author 刘程明
 * @Date 2019-07-09 10:05:32
 */
public class CommonDynamicBalanceEditDTO extends CommonDynamicBalanceEdit{
    
    private List<CommonDynamicBalanceEdit> inserted;
    private List<CommonDynamicBalanceEdit> deleted;
    private List<CommonDynamicBalanceEdit> updated;
    public List<CommonDynamicBalanceEdit> getInserted() {
        return inserted;
    }
    public void setInserted(List<CommonDynamicBalanceEdit> inserted) {
        this.inserted = inserted;
    }
    public List<CommonDynamicBalanceEdit> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<CommonDynamicBalanceEdit> deleted) {
        this.deleted = deleted;
    }
    public List<CommonDynamicBalanceEdit> getUpdated() {
        return updated;
    }
    public void setUpdated(List<CommonDynamicBalanceEdit> updated) {
        this.updated = updated;
    }
    
    
    
}
