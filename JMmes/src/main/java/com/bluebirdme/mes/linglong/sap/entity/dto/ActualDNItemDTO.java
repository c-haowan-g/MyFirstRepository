/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.sap.entity.ActualDNItem;

/**
 * 成品发货明细表
 * @author 周清玉
 * @Date 2018-12-20 11:37:17
 */
public class ActualDNItemDTO extends ActualDNItem{
    
    private List<ActualDNItem> deleted;
    public List<ActualDNItem> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<ActualDNItem> deleted) {
        this.deleted = deleted;
    }
    
}
