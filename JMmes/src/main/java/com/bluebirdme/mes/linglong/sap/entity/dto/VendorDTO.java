/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.sap.entity.Vendor;

/**
 * 供应商信息表
 * @author 周清玉
 * @Date 2018-09-25 10:28:55
 */
public class VendorDTO extends Vendor{
    
    private List<Vendor> inserted;
    private List<Vendor> deleted;
    private List<Vendor> updated;
    public List<Vendor> getInserted() {
        return inserted;
    }
    public void setInserted(List<Vendor> inserted) {
        this.inserted = inserted;
    }
    public List<Vendor> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Vendor> deleted) {
        this.deleted = deleted;
    }
    public List<Vendor> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Vendor> updated) {
        this.updated = updated;
    }
    
    
    
}
