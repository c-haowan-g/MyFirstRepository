/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package ${packageName}.entity.dto;

import java.util.List;
import ${packageName}.entity.${entityName};

/**
 * ${comment}
 * @author ${author}
 * @Date ${time}
 */
public class ${entityName}DTO extends ${entityName}{
    
    private List<${entityName}> inserted;
    private List<${entityName}> deleted;
    private List<${entityName}> updated;
    public List<${entityName}> getInserted() {
        return inserted;
    }
    public void setInserted(List<${entityName}> inserted) {
        this.inserted = inserted;
    }
    public List<${entityName}> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<${entityName}> deleted) {
        this.deleted = deleted;
    }
    public List<${entityName}> getUpdated() {
        return updated;
    }
    public void setUpdated(List<${entityName}> updated) {
        this.updated = updated;
    }
    
    
    
}
