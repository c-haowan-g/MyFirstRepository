/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.EntLog;

/**
 * 质检设备信息表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-27 16:21:40
 */
public class EntLogDTO extends EntLog{
    
    private List<EntLog> inserted;
    private List<EntLog> deleted;
    private List<EntLog> updated;
    public List<EntLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<EntLog> inserted) {
        this.inserted = inserted;
    }
    public List<EntLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<EntLog> deleted) {
        this.deleted = deleted;
    }
    public List<EntLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<EntLog> updated) {
        this.updated = updated;
    }
    
    
    
}
