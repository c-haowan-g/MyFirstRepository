/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.SortGrade;

/**
 * 质检分拣等级规则表
 * @author 刘程明
 * @Date 2018-08-16 12:23:33
 */
public class SortGradeDTO extends SortGrade{
    
    private List<SortGrade> inserted;
    private List<SortGrade> deleted;
    private List<SortGrade> updated;
    public List<SortGrade> getInserted() {
        return inserted;
    }
    public void setInserted(List<SortGrade> inserted) {
        this.inserted = inserted;
    }
    public List<SortGrade> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SortGrade> deleted) {
        this.deleted = deleted;
    }
    public List<SortGrade> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SortGrade> updated) {
        this.updated = updated;
    }
    
    
    
}
