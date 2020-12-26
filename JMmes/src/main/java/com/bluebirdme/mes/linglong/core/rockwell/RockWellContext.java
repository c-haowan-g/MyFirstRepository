/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.rockwell;

import java.util.Date;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.xdemo.app.xutils.j2se.PathUtils;

import com.bluebirdme.core.system.web.BizException;
import com.datasweep.compatibility.pnuts.EventSheetEnvironment;
import com.datasweep.compatibility.pnuts.FunctionThreadPool;
import com.datasweep.core.eventlog.EventLog;
import com.datasweep.core.eventlog.ShopOpsServerLog;
import com.rockwell.eventmanager.EventManager;
import com.rockwell.eventmanager.ShopOperationsServerConfiguration;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 
 * @author Goofy
 * @Date 2018年8月16日 下午2:08:27
 */
@Component
public class RockWellContext implements ApplicationListener<ContextRefreshedEvent>{

	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			init();
        }
	}

	private void init() {
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
		/*new Thread(
			new Runnable() {
				@Override
				public void run() {
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
				}
			}
		).start();*/
	}


}
