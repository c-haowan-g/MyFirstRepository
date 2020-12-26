/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.Judge;

/**
 * 配方标准维护
 * @author 刘程明
 * @Date 2018-08-01 10:00:25
 */
public class JudgeVO extends Judge{
    
    private List<Judge> inserted;
    private List<Judge> deleted;
    private List<Judge> updated;
    public List<Judge> getInserted() {
        return inserted;
    }
    public void setInserted(List<Judge> inserted) {
        this.inserted = inserted;
    }
    public List<Judge> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Judge> deleted) {
        this.deleted = deleted;
    }
    public List<Judge> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Judge> updated) {
        this.updated = updated;
    }
    
    
    
}
