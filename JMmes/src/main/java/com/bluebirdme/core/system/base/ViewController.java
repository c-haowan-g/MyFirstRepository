package com.bluebirdme.core.system.base;

import org.jgroups12.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xdemo.app.xutils.j2se.RandomUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;

/**
 * 页面跳转处理，可以处理常用的无参传递，有参数的处理在相应的模块Controller中自己处理
 * 
 * @author Goofy 252887950@qq.com www.xdemo.org
 * @Date 2017年8月31日 下午2:48:21
 */
@Log(value = "视图模块", code = "VIEW")
@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/view")
public class ViewController extends BaseController {

	@Log(value = "访问视图", code = "VIEW_001", target = LogType.CONSOLE)
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView forward(String page, String factory) {
		// 不传参数，默认0； 不区分：0 全钢：1 半钢：2
		if (StringUtils.isBlank(factory)) {
			factory = FactoryConstant.FACTORY_ALL;
		}
		model.addAttribute(FactoryConstant.FACTORY, factory);
		model.addAttribute("rnd", RandomUtils.randomString(32, true));
		return new ModelAndView(page,model);
	}

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			RandomUtils.randomString(32, true);
		}

		long t2 = System.currentTimeMillis();
		
		

		for (int i = 0; i < 100000; i++) {
			UUID.randomUUID().toString();
		}
		long t3=System.currentTimeMillis();
		
		System.out.println("随机数平均:"+(t2-t1));
		System.out.println("UUID平均:"+(t3-t2));
	}
}