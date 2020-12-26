/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.TyreReasAlermMaintain;

/**
 * 外观检测后工序报警病象计数配置表
 * @author 司乔靖
 * @Date 2019-05-20 11:10:40
 */
public class TyreReasAlermMaintainDTO extends TyreReasAlermMaintain{
    
    private List<TyreReasAlermMaintain> inserted;
    private List<TyreReasAlermMaintain> deleted;
    private List<TyreReasAlermMaintain> updated;
    public List<TyreReasAlermMaintain> getInserted() {
        return inserted;
    }
    public void setInserted(List<TyreReasAlermMaintain> inserted) {
        this.inserted = inserted;
    }
    public List<TyreReasAlermMaintain> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<TyreReasAlermMaintain> deleted) {
        this.deleted = deleted;
    }
    public List<TyreReasAlermMaintain> getUpdated() {
        return updated;
    }
    public void setUpdated(List<TyreReasAlermMaintain> updated) {
        this.updated = updated;
    }
    
    
    
}
