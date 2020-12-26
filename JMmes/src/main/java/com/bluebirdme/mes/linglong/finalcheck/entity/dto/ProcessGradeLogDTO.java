/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGradeLog;

/**
 * 质检工序等级表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-28 11:37:41
 */
public class ProcessGradeLogDTO extends ProcessGradeLog{
    
    private List<ProcessGradeLog> inserted;
    private List<ProcessGradeLog> deleted;
    private List<ProcessGradeLog> updated;
    public List<ProcessGradeLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<ProcessGradeLog> inserted) {
        this.inserted = inserted;
    }
    public List<ProcessGradeLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ProcessGradeLog> deleted) {
        this.deleted = deleted;
    }
    public List<ProcessGradeLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ProcessGradeLog> updated) {
        this.updated = updated;
    }
    
    
    
}
