/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.building.entity.ZonebUnit;



/**
 * 库位维护
 * @author 李迺锟
 * @Date 2019-01-11 15:02:27
 */
public class ZonebUnitDTO extends ZonebUnit{
    
    private List<ZonebUnit> inserted;
    private List<ZonebUnit> deleted;
    private List<ZonebUnit> updated;
    public  List<ZonebUnit> getInserted() {
        return inserted;
    }
    public void setInserted(List<ZonebUnit> inserted) {
        this.inserted = inserted;
    }
    public List<ZonebUnit> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ZonebUnit> deleted) {
        this.deleted = deleted;
    }
    public List<ZonebUnit> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ZonebUnit> updated) {
        this.updated = updated;
    }
    
    
    
}
