/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.Sortltem;

/**
 * è´¨æ£åæ£ç©æè§åè¡¨
 * @author lcm
 * @Date 2018-08-15 09:28:58
 */
public class SortltemDTO extends Sortltem{
    
    private List<Sortltem> inserted;
    private List<Sortltem> deleted;
    private List<Sortltem> updated;
    public List<Sortltem> getInserted() {
        return inserted;
    }
    public void setInserted(List<Sortltem> inserted) {
        this.inserted = inserted;
    }
    public List<Sortltem> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Sortltem> deleted) {
        this.deleted = deleted;
    }
    public List<Sortltem> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Sortltem> updated) {
        this.updated = updated;
    }
    
    
    
}
