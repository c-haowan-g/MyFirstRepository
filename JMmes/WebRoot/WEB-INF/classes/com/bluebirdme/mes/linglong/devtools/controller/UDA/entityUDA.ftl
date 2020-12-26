/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package ${packageName}.uda;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * ${comment}
 * @author ${author}
 * @Date ${time}
 */

public class ${entityName}UDA {
    
    <#list columns as c>
		/**
		* ${c.memo} 
		*/
     	@Comment("${c.memo}")
	    public static final String ${c.name?upper_case} = "${c.name}" ;
    </#list>
    
}
