/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.Ent;

/**
 * 质检设备信息表
 * @author 司乔靖
 * @Date 2018-08-10 07:56:16
 */
public class EntDTO extends Ent{
    
    private List<Ent> inserted;
    private List<Ent> deleted;
    private List<Ent> updated;
    public List<Ent> getInserted() {
        return inserted;
    }
    public void setInserted(List<Ent> inserted) {
        this.inserted = inserted;
    }
    public List<Ent> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Ent> deleted) {
        this.deleted = deleted;
    }
    public List<Ent> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Ent> updated) {
        this.updated = updated;
    }
    
    
    
}
