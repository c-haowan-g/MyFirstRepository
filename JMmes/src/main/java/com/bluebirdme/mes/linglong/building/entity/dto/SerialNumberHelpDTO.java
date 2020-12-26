/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.building.entity.SerialNumberHelp;

/**
 * Unit
 * @author 时永良
 * @Date 2019-07-12 13:12:11
 */
public class SerialNumberHelpDTO extends SerialNumberHelp{
    
    private List<SerialNumberHelp> inserted;
    private List<SerialNumberHelp> deleted;
    private List<SerialNumberHelp> updated;
    public List<SerialNumberHelp> getInserted() {
        return inserted;
    }
    public void setInserted(List<SerialNumberHelp> inserted) {
        this.inserted = inserted;
    }
    public List<SerialNumberHelp> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SerialNumberHelp> deleted) {
        this.deleted = deleted;
    }
    public List<SerialNumberHelp> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SerialNumberHelp> updated) {
        this.updated = updated;
    }
    
    
    
}
