/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.common.entity.Zone;

/**
 * 库区库位管理
 * @author 李迺锟
 * @Date 2019-04-18 15:02:27
 */
public class ZoneDTO extends Zone{
    
    private List<Zone> inserted;
    private List<Zone> deleted;
    private List<Zone> updated;
    public List<Zone> getInserted() {
        return inserted;
    }
    public void setInserted(List<Zone> inserted) {
        this.inserted = inserted;
    }
    public List<Zone> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Zone> deleted) {
        this.deleted = deleted;
    }
    public List<Zone> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Zone> updated) {
        this.updated = updated;
    }
    
    
    
}
