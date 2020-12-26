/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeItem;

/**
 * 质检配方规格表
 * @author 刘程明
 * @Date 2018-08-08 14:16:57
 */
public class RecipeItemDTO extends RecipeItem{
    
    private List<RecipeItem> inserted;
    private List<RecipeItem> deleted;
    private List<RecipeItem> updated;
    private String enttype;
    
    public String getEnttype() {
		return enttype;
	}
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}
	public List<RecipeItem> getInserted() {
        return inserted;
    }
    public void setInserted(List<RecipeItem> inserted) {
        this.inserted = inserted;
    }
    public List<RecipeItem> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<RecipeItem> deleted) {
        this.deleted = deleted;
    }
    public List<RecipeItem> getUpdated() {
        return updated;
    }
    public void setUpdated(List<RecipeItem> updated) {
        this.updated = updated;
    }
    
    
    
}
