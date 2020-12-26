/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.Reas;

/**
 * 质检病象信息表
 * @author 司乔靖
 * @Date 2018-08-06 10:27:44
 */
public class ReasDTO extends Reas{
    
    private List<Reas> inserted;
    private List<Reas> deleted;
    private List<Reas> updated;
    public List<Reas> getInserted() {
        return inserted;
    }
    public void setInserted(List<Reas> inserted) {
        this.inserted = inserted;
    }
    public List<Reas> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Reas> deleted) {
        this.deleted = deleted;
    }
    public List<Reas> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Reas> updated) {
        this.updated = updated;
    }
    
    
    
}
