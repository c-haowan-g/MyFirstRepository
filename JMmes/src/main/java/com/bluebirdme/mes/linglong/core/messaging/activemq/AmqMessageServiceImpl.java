/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.messaging.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 高飞
 * @Date 2018年8月29日 上午11:50:00
 */
@Service
public class AmqMessageServiceImpl {

	@Autowired
	@Qualifier("jmsTopicTemplate")
	private JmsTemplate topic;

	@Autowired
	@Qualifier("jmsQueueTemplate")
	private JmsTemplate queue;

	public void sendTopicMessage(String destination, final String message) {
		topic.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}
	
	public void sendQueueMessage(String destination, final String message) {
		queue.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});
	}

}
