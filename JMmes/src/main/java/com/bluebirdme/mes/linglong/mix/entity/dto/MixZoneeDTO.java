/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.mix.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.mix.entity.MixZonee;

/**
 * 库区库位管理
 * @author 李迺锟
 * @Date 2019-04-18 15:02:27
 */
public class MixZoneeDTO extends MixZonee{
    
    private List<MixZonee> inserted;
    private List<MixZonee> deleted;
    private List<MixZonee> updated;
    public List<MixZonee> getInserted() {
        return inserted;
    }
    public void setInserted(List<MixZonee> inserted) {
        this.inserted = inserted;
    }
    public List<MixZonee> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<MixZonee> deleted) {
        this.deleted = deleted;
    }
    public List<MixZonee> getUpdated() {
        return updated;
    }
    public void setUpdated(List<MixZonee> updated) {
        this.updated = updated;
    }
    
    
    
}
