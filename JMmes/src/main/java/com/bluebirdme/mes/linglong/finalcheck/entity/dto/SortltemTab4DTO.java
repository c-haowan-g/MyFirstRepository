/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;

import com.bluebirdme.mes.linglong.finalcheck.entity.SortltemTab4;

/**
 * è´¨æ£åæ£ç©æè§åè¡¨
 * @author lcm
 * @Date 2018-08-15 09:28:58
 */
public class SortltemTab4DTO extends SortltemTab4{
    
    private List<SortltemTab4> inserted;
    private List<SortltemTab4> deleted;
    private List<SortltemTab4> updated;
    private String enttype;//设备类型，界面上方下拉框的值
    public String getEnttype() {
		return enttype;
	}
	public void setEnttype(String enttype) {
		this.enttype = enttype;
	}
	public List<SortltemTab4> getInserted() {
        return inserted;
    }
    public void setInserted(List<SortltemTab4> inserted) {
        this.inserted = inserted;
    }
    public List<SortltemTab4> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<SortltemTab4> deleted) {
        this.deleted = deleted;
    }
    public List<SortltemTab4> getUpdated() {
        return updated;
    }
    public void setUpdated(List<SortltemTab4> updated) {
        this.updated = updated;
    }
    
    
    
}
