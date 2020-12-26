/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.sap.entity.Materials;

/**
 * SAP物料基础数据
 * @author 李彦
 * @Date 2018-08-09 11:50:47
 */
public class MaterialsDTO extends Materials{
    
    private List<Materials> inserted;
    private List<Materials> deleted;
    private List<Materials> updated;
    public List<Materials> getInserted() {
        return inserted;
    }
    public void setInserted(List<Materials> inserted) {
        this.inserted = inserted;
    }
    public List<Materials> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Materials> deleted) {
        this.deleted = deleted;
    }
    public List<Materials> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Materials> updated) {
        this.updated = updated;
    }
    
    
    
}
