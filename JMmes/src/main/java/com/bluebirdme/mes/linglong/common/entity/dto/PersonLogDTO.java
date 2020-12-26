/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.common.entity.PersonLog;

/**
 * 用户管理日志表
 * @author 刘朋
 * @Date 2018-10-17 10:49:36
 */
public class PersonLogDTO extends PersonLog{
    
    private List<PersonLog> inserted;
    private List<PersonLog> deleted;
    private List<PersonLog> updated;
    public List<PersonLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<PersonLog> inserted) {
        this.inserted = inserted;
    }
    public List<PersonLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<PersonLog> deleted) {
        this.deleted = deleted;
    }
    public List<PersonLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<PersonLog> updated) {
        this.updated = updated;
    }
    
    
    
}
