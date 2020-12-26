/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.curing.entity.ZoneeUnit;


/**
 * 库位维护
 * @author 李迺锟
 * @Date 2019-01-11 15:02:27
 */
public class ZoneeUnitDTO extends ZoneeUnit{
    
    private List<ZoneeUnit> inserted;
    private List<ZoneeUnit> deleted;
    private List<ZoneeUnit> updated;
    public  List<ZoneeUnit> getInserted() {
        return inserted;
    }
    public void setInserted(List<ZoneeUnit> inserted) {
        this.inserted = inserted;
    }
    public List<ZoneeUnit> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ZoneeUnit> deleted) {
        this.deleted = deleted;
    }
    public List<ZoneeUnit> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ZoneeUnit> updated) {
        this.updated = updated;
    }
    
    
    
}
