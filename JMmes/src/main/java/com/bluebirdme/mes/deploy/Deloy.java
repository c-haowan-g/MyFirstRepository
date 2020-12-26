/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.deploy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.DigestException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.vfs2.FileSystemException;
import org.xdemo.app.xutils.ext.sftp.SFTPUtils;
import org.xdemo.app.xutils.j2se.FileUtils;
import org.xdemo.app.xutils.j2se.HardwareUtils;
import org.xdemo.app.xutils.j2se.MD5Utils;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

/**
 * 发布部署
 * 
 * @author Goofy
 * @Date 2018年9月27日 下午1:37:02
 */
public class Deloy {

	private static void uploadJar(String ip, int port, String user, String password, String dir, String file) throws JSchException, SftpException, IOException, NoSuchAlgorithmException, DigestException {
		SFTPUtils sftp = SFTPUtils.getInstance(ip, port, user, password);
		sftp.upload(dir, file);
		String currentUser = System.getProperty("user.name");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMddHHmmss");
		String now=sdf2.format(new Date());
		String logFile="C:\\update.log."+now+".txt";
		
		FileUtils.write("操作人\t\t"+currentUser, logFile , false, true, Charset.forName("UTF-8"));
		FileUtils.write("操作时间\t\t"+sdf.format(new Date()), logFile , true, true, Charset.forName("UTF-8"));
		FileUtils.write("IP地址\t\t"+HardwareUtils.ip(true), logFile , true, true, Charset.forName("UTF-8"));
		FileUtils.write("MD5\t\t"+MD5Utils.md5(file), logFile , true, true, Charset.forName("UTF-8"));
		
		sftp.upload("/opt/apache-tomcat-8.0.53/webapps/updatehistory/", logFile);
	}

	/**
	 * 部署入口
	 * 
	 * @param args
	 * @throws NumberFormatException
	 * @throws JSchException
	 * @throws SftpException
	 * @throws IOException 
	 * @throws DigestException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NumberFormatException, JSchException, SftpException, IOException, NoSuchAlgorithmException, DigestException {
		//uploadJar(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4], args[5]);
		uploadJar("172.18.86.11", 22, "linglong", "Linglong123*",
		"/opt/rockwell/apache-tomcat-8.5.51/webapps/JMmes/WEB-INF/lib","E:/workspace/ME2014/linglongmes/build/mes.jar");


	}

}
