/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortItemLog;

/**
 * 质检分拣物料规则表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-28 14:52:17
 */
public class SortItemLogDTO extends SortItemLog{
    
    private List<SortItemLog> inserted;
    private List<SortItemLog> deleted;
    private List<SortItemLog> updated;
    public List<SortItemLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<SortItemLog> inserted) {
        this.inserted = inserted;
    }
    public List<SortItemLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SortItemLog> deleted) {
        this.deleted = deleted;
    }
    public List<SortItemLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SortItemLog> updated) {
        this.updated = updated;
    }
    
    
    
}
