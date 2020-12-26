package com.bluebirdme.mes.linglong.halfpart.entity;

import java.util.List;

import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartUnit;


/**
 * 库位维护
 * @author 兰颖慧
 * @Date 2019-01-11 15:02:27
 */
public class HalfPartUnitDTO extends HalfPartUnit{
    
    private List<HalfPartUnit> inserted;
    private List<HalfPartUnit> deleted;
    private List<HalfPartUnit> updated;
    public  List<HalfPartUnit> getInserted() {
        return inserted;
    }
    public void setInserted(List<HalfPartUnit> inserted) {
        this.inserted = inserted;
    }
    public List<HalfPartUnit> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<HalfPartUnit> deleted) {
        this.deleted = deleted;
    }
    public List<HalfPartUnit> getUpdated() {
        return updated;
    }
    public void setUpdated(List<HalfPartUnit> updated) {
        this.updated = updated;
    }
    
    
    
}
