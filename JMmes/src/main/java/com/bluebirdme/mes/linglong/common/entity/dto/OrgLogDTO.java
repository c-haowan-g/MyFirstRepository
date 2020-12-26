/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.common.entity.OrgLog;

/**
 * 组织机构日志表
 * @author 刘朋
 * @Date 2018-10-17 09:02:58
 */
public class OrgLogDTO extends OrgLog{
    
    private List<OrgLog> inserted;
    private List<OrgLog> deleted;
    private List<OrgLog> updated;
    public List<OrgLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<OrgLog> inserted) {
        this.inserted = inserted;
    }
    public List<OrgLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<OrgLog> deleted) {
        this.deleted = deleted;
    }
    public List<OrgLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<OrgLog> updated) {
        this.updated = updated;
    }
    
    
    
}
