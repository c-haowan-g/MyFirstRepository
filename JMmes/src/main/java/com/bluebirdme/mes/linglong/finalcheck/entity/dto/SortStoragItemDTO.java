/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.SortStoragItem;

/**
 * 入库规则维护
 * @author 马健斌
 * @Date 2018-08-16 07:23:04
 */
public class SortStoragItemDTO extends SortStoragItem{
    
    private List<SortStoragItem> inserted;
    private List<SortStoragItem> deleted;
    private List<SortStoragItem> updated;
    public List<SortStoragItem> getInserted() {
        return inserted;
    }
    public void setInserted(List<SortStoragItem> inserted) {
        this.inserted = inserted;
    }
    public List<SortStoragItem> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SortStoragItem> deleted) {
        this.deleted = deleted;
    }
    public List<SortStoragItem> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SortStoragItem> updated) {
        this.updated = updated;
    }
    
    
    
}
