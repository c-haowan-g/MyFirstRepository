/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.deploy;

/**
 * 
 * @author Goofy
 * @Date 2018年9月29日 下午2:04:02
 */
public class Tomcat {
	
	static RemoteShellExecutor shell;
	
	public static void start() throws Exception{
		shell.exec("sh /opt/rockwell/apache-tomcat-8.5.31/bin/startup.sh");
	}
	
	public static void stop() throws Exception{
		shell.exec("sh /opt/rockwell/apache-tomcat-8.5.31/bin/shutdown.sh");
	}

	public static void restart() throws Exception{
		stop();
		System.out.println("kaishi2");
		Thread.sleep(30000L);
		start();
	}
	
	public static void main(String[] args) throws Exception {
//		String ip="192.168.55.37",user="root",password="linglong123";
		String ip="192.168.86.11";
		String user="linglong";
		String password="Linglong123*";
		shell=new RemoteShellExecutor(ip,user,password);
		restart();
	}
	
}
