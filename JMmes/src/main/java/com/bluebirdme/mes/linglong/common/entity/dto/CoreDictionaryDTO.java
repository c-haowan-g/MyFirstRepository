/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.common.entity.CoreDictionary;

/**
 * 数据字典表
 * @author 高飞
 * @Date 2018-08-08 13:40:24
 */
public class CoreDictionaryDTO extends CoreDictionary{
    
    private List<CoreDictionary> inserted;
    private List<CoreDictionary> deleted;
    private List<CoreDictionary> updated;
    public List<CoreDictionary> getInserted() {
        return inserted;
    }
    public void setInserted(List<CoreDictionary> inserted) {
        this.inserted = inserted;
    }
    public List<CoreDictionary> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<CoreDictionary> deleted) {
        this.deleted = deleted;
    }
    public List<CoreDictionary> getUpdated() {
        return updated;
    }
    public void setUpdated(List<CoreDictionary> updated) {
        this.updated = updated;
    }
    
    
    
}
