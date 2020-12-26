/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.building.entity.Zoneb;


/**
 * 库区库位管理
 * @author 李迺锟
 * @Date 2019-04-18 15:02:27
 */
public class ZonebDTO extends Zoneb{
    
    private List<Zoneb> inserted;
    private List<Zoneb> deleted;
    private List<Zoneb> updated;
    public List<Zoneb> getInserted() {
        return inserted;
    }
    public void setInserted(List<Zoneb> inserted) {
        this.inserted = inserted;
    }
    public List<Zoneb> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Zoneb> deleted) {
        this.deleted = deleted;
    }
    public List<Zoneb> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Zoneb> updated) {
        this.updated = updated;
    }
    
    
    
}
