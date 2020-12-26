/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;

/**
 * 玲珑项目WebUtils
 * @author Goofy
 * @Date 2018年8月10日 上午8:23:41
 */
public class LLWebUtils extends WebUtils {
	
	/**
	 * 进入页面时候，传入factory参数，在页面中会有一个factory的js变量来接受，ajax请求的的时候，将factory参数放到Request Headers中，传送到后台
	 * @author Goofy
	 * @Date 2018年8月10日 上午8:28:34
	 * @return
	 */
	public static String factory(){
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		
		String factory=request.getHeader(FactoryConstant.FACTORY);
		
		if(StringUtils.isBlank(factory)){
			factory=FactoryConstant.FACTORY_ALL;
		}
		
		return factory;
	}

}
