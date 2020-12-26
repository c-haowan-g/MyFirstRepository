/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.sap.entity.ActualamountItem;

/**
 * 实装量ITEM 
 * @author 周清玉
 * @Date 2018-12-12 13:13:46
 */
public class ActualamountItemDTO extends ActualamountItem{
    
    private List<ActualamountItem> inserted;
    private List<ActualamountItem> deleted;
    private List<ActualamountItem> updated;
    public List<ActualamountItem> getInserted() {
        return inserted;
    }
    public void setInserted(List<ActualamountItem> inserted) {
        this.inserted = inserted;
    }
    public List<ActualamountItem> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ActualamountItem> deleted) {
        this.deleted = deleted;
    }
    public List<ActualamountItem> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ActualamountItem> updated) {
        this.updated = updated;
    }
    
    
    
}
