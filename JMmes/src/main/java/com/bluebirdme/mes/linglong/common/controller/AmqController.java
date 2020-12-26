/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.messaging.activemq.AmqMessageServiceImpl;

/**
 * 
 * @author LingLong-2
 * @Date 2018年8月30日 上午8:19:40
 */
@NoLogin
@RestController
@RequestMapping("/amq")
public class AmqController {
	
	@Resource AmqMessageServiceImpl amqSrv;
	
	@ResponseBody
	@RequestMapping("send/topic")
	public Response sendTopicMessage(String target,String message){
		amqSrv.sendTopicMessage(target, message);
		return Response.suc();
	}
	
	@ResponseBody
	@RequestMapping("send/queue")
	public Response sendQueueMessage(String target,String message){
		amqSrv.sendQueueMessage(target, message);
		return Response.suc();
	}

}
