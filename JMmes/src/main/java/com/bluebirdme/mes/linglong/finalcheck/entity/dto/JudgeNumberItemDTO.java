/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberItem;

/**
 * 动平衡均匀机检测配套标准物料表
 * @author 刘程明
 * @Date 2018-11-13 15:30:47
 */
public class JudgeNumberItemDTO extends JudgeNumberItem{
    
    private List<JudgeNumberItem> inserted;
    private List<JudgeNumberItem> deleted;
    private List<JudgeNumberItem> updated;
    public List<JudgeNumberItem> getInserted() {
        return inserted;
    }
    public void setInserted(List<JudgeNumberItem> inserted) {
        this.inserted = inserted;
    }
    public List<JudgeNumberItem> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<JudgeNumberItem> deleted) {
        this.deleted = deleted;
    }
    public List<JudgeNumberItem> getUpdated() {
        return updated;
    }
    public void setUpdated(List<JudgeNumberItem> updated) {
        this.updated = updated;
    }
    
    
    
}
