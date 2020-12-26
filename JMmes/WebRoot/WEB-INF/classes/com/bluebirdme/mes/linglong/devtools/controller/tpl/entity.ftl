/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package ${packageName}.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.bluebirdme.mes.linglong.core.RockWellBaseEntity;
import com.bluebirdme.mes.linglong.core.rockwell.ATDefinition;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * ${comment}
 * @author ${author}
 * @Date ${time}
 */
@ATDefinition("${tableName?substring(3)}")
@Entity
@XmlRootElement
@Table(name="${tableName}")
public class ${entityName} extends RockWellBaseEntity{
    
    <#list columns as c>
    
    @Comment("${c.memo}")
    @Column(nullable=${c.nullable},length=${c.dataLength})
    private ${c.type} ${c.name?lower_case};
    </#list>
    
    <#list columns as c>
    public ${c.type} get${c.name?lower_case?cap_first}(){
        return ${c.name?lower_case};
    }
    
    @XmlElement
    public void set${c.name?lower_case?cap_first}(${c.type} ${c.name?lower_case}){
        this.${c.name?lower_case}=${c.name?lower_case};
    }
        
    </#list>
    
    
    
}
