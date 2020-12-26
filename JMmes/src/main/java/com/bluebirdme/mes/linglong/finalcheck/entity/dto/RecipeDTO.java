/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.Recipe;

/**
 * 配方标准维护
 * @author 司乔靖
 * @Date 2018-08-01 10:00:25
 */
public class RecipeDTO extends Recipe{
    
    private List<Recipe> inserted;
    private List<Recipe> deleted;
    private List<Recipe> updated;
    public List<Recipe> getInserted() {
        return inserted;
    }
    public void setInserted(List<Recipe> inserted) {
        this.inserted = inserted;
    }
    public List<Recipe> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Recipe> deleted) {
        this.deleted = deleted;
    }
    public List<Recipe> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Recipe> updated) {
        this.updated = updated;
    }
    
    
    
}
