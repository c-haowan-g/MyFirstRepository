/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberGrade;

/**
 * 动平衡均匀机检测配套标准等级表
 * @author 刘程明
 * @Date 2018-11-13 14:44:43
 */
public class JudgeNumberGradeDTO extends JudgeNumberGrade{
    
    private List<JudgeNumberGrade> inserted;
    private List<JudgeNumberGrade> deleted;
    private List<JudgeNumberGrade> updated;
    public List<JudgeNumberGrade> getInserted() {
        return inserted;
    }
    public void setInserted(List<JudgeNumberGrade> inserted) {
        this.inserted = inserted;
    }
    public List<JudgeNumberGrade> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<JudgeNumberGrade> deleted) {
        this.deleted = deleted;
    }
    public List<JudgeNumberGrade> getUpdated() {
        return updated;
    }
    public void setUpdated(List<JudgeNumberGrade> updated) {
        this.updated = updated;
    }
    
    
    
}
