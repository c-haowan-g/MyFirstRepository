/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.core.messaging.ws;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.web.Response;
import com.google.common.collect.Maps;

/**
 * 
 * @author LingLong-2
 * @Date 2018年8月27日 下午7:37:46
 */
@Component
public class TextHandler extends TextWebSocketHandler {

	private static final Map<String, WebSocketSession> ips = Maps.newConcurrentMap();

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		try {
			if (session.isOpen()) {
				session.close();
			}
			ips.remove(session.getAttributes().get("ip").toString());
		} catch (Exception e) {
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		ips.put(session.getAttributes().get("ip").toString(), session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		try {
			super.handleTransportError(session, exception);
		} catch (Exception e) {
		}
	}
	
	

	/**
	 * 发送消息
	 * 
	 * @param ip
	 *            接收IP
	 * @param obj
	 *            消息内容
	 * @throws IOException
	 */
	public void sendMessage(String ip, Response response) throws IOException {
		ips.get(ip).sendMessage(new TextMessage(GsonTools.toJson(response)));
	}

	public void broadcast(Response response) {
		for (String ip : ips.keySet()) {
			try {
				if (ips.get(ip).isOpen()) {
					ips.get(ip).sendMessage(new TextMessage(GsonTools.toJson(response)));
				}
			} catch (Exception e) {
			}
		}
	}

}
