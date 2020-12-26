/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.ProcessGrade;

/**
 * è´¨æ£å·¥åºç­çº§è¡¨
 * @author åç¨æ
 * @Date 2018-08-16 12:26:07
 */
public class ProcessGradeDTO extends ProcessGrade{
    
    private List<ProcessGrade> inserted;
    private List<ProcessGrade> deleted;
    private List<ProcessGrade> updated;
    public List<ProcessGrade> getInserted() {
        return inserted;
    }
    public void setInserted(List<ProcessGrade> inserted) {
        this.inserted = inserted;
    }
    public List<ProcessGrade> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ProcessGrade> deleted) {
        this.deleted = deleted;
    }
    public List<ProcessGrade> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ProcessGrade> updated) {
        this.updated = updated;
    }
    
    
    
}
