package com.bluebirdme.mes.deploy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * 
 * @author Goofy
 * @Date 2019年2月20日 下午1:42:17
 */
public class TomcatLog {

	private Connection conn;
	/** 远程机器IP */
	private String ip;
	/** 用户名 */
	private String osUsername;
	/** 密码 */
	private String password;
	private String charset = Charset.defaultCharset().toString();

	private static final int TIME_OUT = 1000 * 5 * 60;

	/**
	 * 构造函数
	 * 
	 * @param ip
	 * @param usr
	 * @param pasword
	 */
	public TomcatLog(String ip, String usr, String pasword) {
		this.ip = ip;
		this.osUsername = usr;
		this.password = pasword;
	}

	/**
	 * 登录
	 * 
	 * @return
	 * @throws IOException
	 */
	private boolean login() throws IOException {
		conn = new Connection(ip);
		conn.connect();
		return conn.authenticateWithPassword(osUsername, password);
	}

	/**
	 * 执行脚本
	 * 
	 * @param cmds
	 * @return
	 * @throws Exception
	 */
	public void exec(String cmds) throws Exception {
		InputStream is = null;
		BufferedReader reader = null;
		int ret = -1;
		try {
			System.out.println("正在登陆");
			if (login()) {
				System.out.println("SSH已连接");
				// Open a new {@link Session} on this connection
				Session session = conn.openSession();
				// Execute a command on the remote machine.
				session.execCommand(cmds);

				is = new StreamGobbler(session.getStdout());
				
				reader=new BufferedReader(new InputStreamReader(is));
				
				for(;;){
					System.out.println(reader.readLine());
				}
			} else {
				throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
			IOUtils.closeQuietly(is);
		}
	}

	public static void main(String args[]) throws Exception {
		TomcatLog executor = null;
		executor = new TomcatLog("192.168.55.38","root","linglong123");

		//executor.exec("tail -f /opt/apache-tomcat-8.0.53/logs/catalina.out");
		executor.exec("tail -f /opt/apache-tomcat-8.0.53/logs/catalina.out");
	}
}
