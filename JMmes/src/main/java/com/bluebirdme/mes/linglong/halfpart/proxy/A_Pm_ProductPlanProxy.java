/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.proxy;

import java.util.Date;

import org.apache.tomcat.jni.Time;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bluebird.proxy.BaseClientProxy;
import com.bluebird.webservice.SaveStatus;
import com.bluebirdme.mes.linglong.halfpart.entity.sos.A_Pm_ProductPlanWeb;
import com.bluebirdme.mes.linglong.halfpart.entity.sos.SosUrlAddress;

/**
 * 
 * @author 黄文娟
 * @Date 2019年4月16日 上午10:20:51
 */
public class A_Pm_ProductPlanProxy extends BaseClientProxy {
	/**
	 * 
	 * @param serverUrl SOS 发布地址
	 * @param javaClassFullName SOS 调用方法所在的文件的路径
	 */
	
	public A_Pm_ProductPlanProxy(String serverUrl, String javaClassFullName) {
		 
		super(serverUrl, javaClassFullName);
	}

/**
 * 
 * @param serverUrl SOS 发布地址
 * @param machineCode
 * @param javaClassFullName SOS 调用方法所在的文件的路径
 */
	public A_Pm_ProductPlanProxy(String serverUrl, String machineCode, String javaClassFullName) {
		super(serverUrl, machineCode, javaClassFullName);
	}

	/**
	 * 测试调用sos 服务保存数据
	 * @param data
	 * @return
	 * @throws Exception
	 * @author 黄文娟
	 * @Date 2019年4月16日 下午2:25:24
	 */
	public A_Pm_ProductPlanWeb Save(A_Pm_ProductPlanWeb data) throws Exception {
		data=new A_Pm_ProductPlanWeb();
		data.setAgenc_No("1");
		data.setCreated_Time(new Date());
		data.setCreated_By("test");
		data.setSaveStatus(SaveStatus.created);
		data.setPlanNo("20190417002");
		data.setEquip_Code("9ASF01");
		data.setMaterialCode("01264795555");
		data.setBuildingRecord("0");
		data.setHandFlag("0");
		data.setMaterialGroup("www");
		data.setMaterialDesc("12222");
		data.setMaterialName("222222");
		data.setOverPercent(0.05f);
		data.setParaVersion("1.0");
		data.setPlanDate("2019-4-20");
		data.setPlanQuantityconfirm(500f);
		data.setPlanQuantity(0f);
		data.setPlanstartTime(new Date());		 
		 data.setPlan_Order((long) 1);
		 data.setRecord_Flag("A");
		 data.setRepiceNo("s");
		 data.setSpecification("444");
		 data.setStatus("104001");
		 data.setS_Factory("1");
		 data.setPlanfinish((long)0);
		 data.setSAPVersion("2.0");
		 A_Pm_ProductPlanWeb result= super.sendData("save", data, A_Pm_ProductPlanWeb.class);
		 return result;
	}
}
