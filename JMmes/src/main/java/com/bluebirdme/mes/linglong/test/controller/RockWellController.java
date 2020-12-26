/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.controller;

import java.util.Date;

import org.jdesktop.jdic.desktop.internal.MailerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xdemo.app.xutils.j2se.mail.Email;
import org.xdemo.app.xutils.j2se.mail.SmtpServer;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.web.BizException;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.test.entity.Foo;
import com.datasweep.compatibility.client.ATRow;
import com.datasweep.compatibility.client.Server;
import com.datasweep.compatibility.pnuts.Functions;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 
 * @author Goofy
 * @Date 2018年8月21日 下午2:33:51
 */
@Log(value="RCK",code="RCK")
@NoLogin
@Controller
@RequestMapping("/rockwell")
public class RockWellController {

	@Log(value="RockWell测试",code="RCK_TEST")
	@ResponseBody
	@RequestMapping("/test")
	public Response test() throws Exception {

		/*for(int i=0;i<100;i++){
			Sortltem item = new Sortltem();
			UserTransaction u=RockWellUtils.getUserTransaction();
			item.setAgenc_no_s("123");
			item.setArch_flag_s("123");

			ATRow row = RockWellUtils.toATRow(item);
			u.begin();
			row.save(new Time(), "", null);
			System.out.println("第"+(i)+"次事务");
			u.commit();
		}*/
		
		Foo foo=new Foo();
		foo.setAtr_key(84128L);
		foo.setName_s("李四");
		foo.setBirthday_t(new Date());
		
		RockWellUtils.save(foo);
		
		//System.out.println(1 / 0);

		/*
		 * Server server=PCContext.getServerImpl();
		 * 
		 * Functions func = PCContext.getFunctions(); Time time =
		 * func.getDBTime(); Test2 test=new Test2(); ATRow atRow =
		 * test.getATRow(); atRow.setValue("cOde", "123"); UserTransaction
		 * transaction =(UserTransaction)func.getUserTransaction().getResult();
		 * transaction.begin(); atRow.save(time, "", null);
		 * transaction.commit();
		 */
		return Response.suc();
	}

}
