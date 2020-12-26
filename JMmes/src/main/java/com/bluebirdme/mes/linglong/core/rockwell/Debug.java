/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.rockwell;

import java.util.Date;

import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.PathUtils;

import com.bluebirdme.core.system.web.BizException;
import com.bluebirdme.mes.linglong.common.entity.CoreDictionary;
import com.bluebirdme.mes.linglong.test.entity.Foo;
import com.datasweep.compatibility.pnuts.EventSheetEnvironment;
import com.datasweep.compatibility.pnuts.FunctionThreadPool;
import com.datasweep.core.eventlog.EventLog;
import com.datasweep.core.eventlog.ShopOpsServerLog;
import com.rockwell.eventmanager.EventManager;
import com.rockwell.eventmanager.ShopOperationsServerConfiguration;
import com.rockwell.mes.commons.base.ifc.services.PCContext;
import com.rockwell.transactiongrouping.UserTransaction;

/**
 * 
 * @author Goofy
 * @Date 2018年8月23日 下午1:19:04
 */
public class Debug {
	public static void main(String[] args) throws Exception {
				ShopOperationsServerConfiguration shopoperationsserverconfiguration = ShopOperationsServerConfiguration.read(PathUtils.classPath() + "/ShopOperationsServer.xml");

		System.setProperty("rockwell.sos.home.bin", PathUtils.classPath());

		EventLog.setApplicationType(2);
		ShopOpsServerLog.setLogConfigProperties(shopoperationsserverconfiguration.getLogLevel(), shopoperationsserverconfiguration.getLogFileSize(), shopoperationsserverconfiguration.getLogFileCount());
		ShopOpsServerLog.setLogFolder(shopoperationsserverconfiguration.getLogFolder());
		EventLog.setLogLevel(shopoperationsserverconfiguration.getLogLevel());
		EventSheetEnvironment.setEventQueueSize(shopoperationsserverconfiguration.getMainProcessingQueue());
		EventSheetEnvironment.setHistoryQueueSize(shopoperationsserverconfiguration.getStatisticsHistoryQueue());
		EventSheetEnvironment.setDefaultPoolSize(shopoperationsserverconfiguration.getFunctionThreadPoolSize());

		FunctionThreadPool.setAssignmentQueueSize(shopoperationsserverconfiguration.getFunctionThreadProcessingQueue());

		EventManager eventManager = EventManager.createEventManager((EventSheetEnvironment) null, shopoperationsserverconfiguration);
		EventSheetEnvironment eventSheetEnvironment = eventManager.getEnvironment();

		PCContext.setEnvironment(eventSheetEnvironment);

		System.setProperty("com.datasweep.plantops.j2eevendor", "JBoss");
		long t1=System.currentTimeMillis();
		int suc=0;
		int err=0;
		long max=0;
		for(int i=0;i<10;i++){
			System.out.println((i+1)/100);
			long _t1=System.currentTimeMillis();
			CoreDictionary dict=new CoreDictionary();
			dict.setChanged_by_s("fdsafdsa");
			dict.setChanged_time_t(new Date());
			dict.setCreated_time_t(new Date());
			dict.setCreated_by_s("fdafdsafdsafdsafdsa");
			dict.setDeleted_i(1);
			dict.setDictcode_s("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
			dict.setDictdesc_s("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
			dict.setDictname_en_s("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			dict.setDictname_s("GGGGGGGGGGGGGGGGGGGGGDDDDDDDDDDDDDDDDDDDDDD");
			dict.setDictname_th_s("THHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHh");
			dict.setSortno_i(i);
			dict.setErpcode_s("FFFFFFFFFFFFFFDDDDDDDDDDDDDDDDDDDDDDDDDDD");
			/*UserTransaction t=RockWellUtils.getUserTransaction();
			t.begin();
			try {
				RockWellUtils.save(dict);
				t.commit();
				System.out.println("保存成功，并提交事务");
				long _t2=System.currentTimeMillis();
				System.out.println("本次耗时："+(_t2-_t1)+"ms");
				if((_t2-_t1)>max){
					max=_t2-_t1;
				}
				System.out.println(suc++);
			} catch (Exception e) {
				t.rollback();
				System.out.println("保存失败，并回滚事务");
				err++;
			}*/
		}
		long t2=System.currentTimeMillis();
		System.out.println("总耗时:"+(t2-t1)+"ms");
		System.out.println("平均耗时:"+((t2-t1)%100)+"ms");
		System.out.println("最慢操作:"+max+"ms");
		System.out.println("成功:"+(suc%100));
		System.out.println("失败:"+(err%100));
		
		
		
	}
	
	public static void main2(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Foo foo=new Foo();
		foo.setAtr_key(84131L);
		foo.setName_s("高飞");
		System.out.println(foo.getClass().getDeclaredField("atr_key").getName());
	}
}
