package com.bluebirdme.mes.linglong.halfpart.entity.dto;



/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */


import java.util.List;

import com.bluebirdme.mes.linglong.halfpart.entity.Equipmentcapacity;
public class EquipmentcapacityDTO extends Equipmentcapacity{
    
    private List<Equipmentcapacity> inserted;
    private List<Equipmentcapacity> deleted;
    private List<Equipmentcapacity> updated;
    public List<Equipmentcapacity> getInserted() {
        return inserted;
    }
    public void setInserted(List<Equipmentcapacity> inserted) {
        this.inserted = inserted;
    }
    public List<Equipmentcapacity> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Equipmentcapacity> deleted) {
        this.deleted = deleted;
    }
    public List<Equipmentcapacity> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Equipmentcapacity> updated) {
        this.updated = updated;
    }
    
    
    
}
