/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.curing.entity.Zonee;

/**
 * 库区库位管理
 * @author 李迺锟
 * @Date 2019-04-18 15:02:27
 */
public class ZoneeDTO extends Zonee{
    
    private List<Zonee> inserted;
    private List<Zonee> deleted;
    private List<Zonee> updated;
    public List<Zonee> getInserted() {
        return inserted;
    }
    public void setInserted(List<Zonee> inserted) {
        this.inserted = inserted;
    }
    public List<Zonee> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Zonee> deleted) {
        this.deleted = deleted;
    }
    public List<Zonee> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Zonee> updated) {
        this.updated = updated;
    }
    
    
    
}
