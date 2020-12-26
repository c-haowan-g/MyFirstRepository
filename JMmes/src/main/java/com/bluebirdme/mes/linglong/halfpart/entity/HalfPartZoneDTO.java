package com.bluebirdme.mes.linglong.halfpart.entity;


import java.util.List;

import com.bluebirdme.mes.linglong.halfpart.entity.HalfPartZone;

/**
 * 库区库位管理
 * @author 兰颖慧
 * @Date 2019-04-18 15:02:27
 */
public class HalfPartZoneDTO extends HalfPartZone{
    
    private List<HalfPartZone> inserted;
    private List<HalfPartZone> deleted;
    private List<HalfPartZone> updated;
    public List<HalfPartZone> getInserted() {
        return inserted;
    }
    public void setInserted(List<HalfPartZone> inserted) {
        this.inserted = inserted;
    }
    public List<HalfPartZone> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<HalfPartZone> deleted) {
        this.deleted = deleted;
    }
    public List<HalfPartZone> getUpdated() {
        return updated;
    }
    public void setUpdated(List<HalfPartZone> updated) {
        this.updated = updated;
    }
    
    
    
}
