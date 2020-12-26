/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.common.entity.ZoneUnit;


/**
 * 库位维护
 * @author 李迺锟
 * @Date 2019-01-11 15:02:27
 */
public class ZoneUnitDTO extends ZoneUnit{
    
    private List<ZoneUnit> inserted;
    private List<ZoneUnit> deleted;
    private List<ZoneUnit> updated;
    public  List<ZoneUnit> getInserted() {
        return inserted;
    }
    public void setInserted(List<ZoneUnit> inserted) {
        this.inserted = inserted;
    }
    public List<ZoneUnit> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ZoneUnit> deleted) {
        this.deleted = deleted;
    }
    public List<ZoneUnit> getUpdated() {
        return updated;
    }
    public void setUpdated(List<ZoneUnit> updated) {
        this.updated = updated;
    }
    
    
    
}
