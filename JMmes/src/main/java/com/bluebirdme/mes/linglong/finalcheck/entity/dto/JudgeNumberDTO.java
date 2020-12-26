/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumber;

/**
 * 动平衡均匀机检测配套标准表
 * @author 刘程明
 * @Date 2018-11-13 13:24:54
 */
public class JudgeNumberDTO extends JudgeNumber{
    
    private List<JudgeNumber> inserted;
    private List<JudgeNumber> deleted;
    private List<JudgeNumber> updated;
    public List<JudgeNumber> getInserted() {
        return inserted;
    }
    public void setInserted(List<JudgeNumber> inserted) {
        this.inserted = inserted;
    }
    public List<JudgeNumber> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<JudgeNumber> deleted) {
        this.deleted = deleted;
    }
    public List<JudgeNumber> getUpdated() {
        return updated;
    }
    public void setUpdated(List<JudgeNumber> updated) {
        this.updated = updated;
    }
    
    
    
}
