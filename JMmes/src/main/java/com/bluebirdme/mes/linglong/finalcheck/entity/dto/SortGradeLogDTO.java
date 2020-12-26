/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortGradeLog;

/**
 * 质检分检等级规则表(终检蓝英接口同步履历)
 * @author 周志祥
 * @Date 2018-11-28 13:33:09
 */
public class SortGradeLogDTO extends SortGradeLog{
    
    private List<SortGradeLog> inserted;
    private List<SortGradeLog> deleted;
    private List<SortGradeLog> updated;
    public List<SortGradeLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<SortGradeLog> inserted) {
        this.inserted = inserted;
    }
    public List<SortGradeLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SortGradeLog> deleted) {
        this.deleted = deleted;
    }
    public List<SortGradeLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SortGradeLog> updated) {
        this.updated = updated;
    }
    
    
    
}
