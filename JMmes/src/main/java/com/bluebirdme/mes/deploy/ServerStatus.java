/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.deploy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 
 * @author Goofy
 * @Date 2018年9月30日 下午4:44:45
 */
public class ServerStatus {
	
	final String SERVER_37="192.168.86.6";
	final String SERVER_38="192.168.86.11";
	
	final String USER="linglong";
	final String PASSWORD="Linglong123*";
	
	final int TOMCAT_PORT=18080;
	
	final int JBOSS_PORT=8080;
	
	final int SSH_PORT=22;
	
	void check(){
		
	}
	
	void tomcat(){
		
	}
	
	void amq(){
		
	}
	
	void jboss(){
		
	}
	
	/**
	 * 测试端口号是否正常
	 * @param ip IP地址
	 * @param port 端口号
	 * @return
	 */
	boolean checkPort(String ip,int port){
		Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(ip, port));
            return true;
        } catch (IOException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
		
	}
	
}
