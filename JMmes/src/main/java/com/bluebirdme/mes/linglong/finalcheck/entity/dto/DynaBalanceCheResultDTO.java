/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynaBalanceCheResult;

/**
 * 2019
 * @author 司乔靖
 * @Date 2018-08-10 07:25:02
 */
public class DynaBalanceCheResultDTO extends DynaBalanceCheResult{
    
    private List<DynaBalanceCheResult> inserted;
    private List<DynaBalanceCheResult> deleted;
    private List<DynaBalanceCheResult> updated;
    public List<DynaBalanceCheResult> getInserted() {
        return inserted;
    }
    public void setInserted(List<DynaBalanceCheResult> inserted) {
        this.inserted = inserted;
    }
    public List<DynaBalanceCheResult> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<DynaBalanceCheResult> deleted) {
        this.deleted = deleted;
    }
    public List<DynaBalanceCheResult> getUpdated() {
        return updated;
    }
    public void setUpdated(List<DynaBalanceCheResult> updated) {
        this.updated = updated;
    }
    
    
    
}
