/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.test.entity.Foo;

/**
 * FFFF
 * @author 高飞
 * @Date 2018-08-23 14:27:23
 */
public class FooDTO extends Foo{
    
    private List<Foo> inserted;
    private List<Foo> deleted;
    private List<Foo> updated;
    public List<Foo> getInserted() {
        return inserted;
    }
    public void setInserted(List<Foo> inserted) {
        this.inserted = inserted;
    }
    public List<Foo> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<Foo> deleted) {
        this.deleted = deleted;
    }
    public List<Foo> getUpdated() {
        return updated;
    }
    public void setUpdated(List<Foo> updated) {
        this.updated = updated;
    }
    
    
    
}
