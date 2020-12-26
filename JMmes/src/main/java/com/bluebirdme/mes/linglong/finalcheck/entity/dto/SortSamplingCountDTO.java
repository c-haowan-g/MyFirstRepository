/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.SortSamplingCount;

/**
 * 质检分拣抽检计数表
 * @author 刘程明
 * @Date 2019-04-25 16:35:26
 */
public class SortSamplingCountDTO extends SortSamplingCount{
    
    private List<SortSamplingCount> inserted;
    private List<SortSamplingCount> deleted;
    private List<SortSamplingCount> updated;
    public List<SortSamplingCount> getInserted() {
        return inserted;
    }
    public void setInserted(List<SortSamplingCount> inserted) {
        this.inserted = inserted;
    }
    public List<SortSamplingCount> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SortSamplingCount> deleted) {
        this.deleted = deleted;
    }
    public List<SortSamplingCount> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SortSamplingCount> updated) {
        this.updated = updated;
    }
    
    
    
}
