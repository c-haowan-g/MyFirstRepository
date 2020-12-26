/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.curing.entity.CuringRecipePara;

/**
 * PLM配方下发基础参数表
 * @author 刘朋
 * @Date 2018-09-27 10:55:48
 */
public class CuringRecipeParaDTO extends CuringRecipePara{
    
    private List<CuringRecipePara> inserted;
    private List<CuringRecipePara> deleted;
    private List<CuringRecipePara> updated;
    public List<CuringRecipePara> getInserted() {
        return inserted;
    }
    public void setInserted(List<CuringRecipePara> inserted) {
        this.inserted = inserted;
    }
    public List<CuringRecipePara> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<CuringRecipePara> deleted) {
        this.deleted = deleted;
    }
    public List<CuringRecipePara> getUpdated() {
        return updated;
    }
    public void setUpdated(List<CuringRecipePara> updated) {
        this.updated = updated;
    }
    
    
    
}
