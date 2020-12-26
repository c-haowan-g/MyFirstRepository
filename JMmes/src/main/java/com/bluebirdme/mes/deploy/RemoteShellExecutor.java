/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.deploy;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.xdemo.app.xutils.ext.GsonTools;

import ch.ethz.ssh2.ChannelCondition;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

/**
 * 
 * @author Goofy
 * @Date 2018年9月27日 下午2:32:39
 */
public class RemoteShellExecutor {
	
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
     * @param ip
     * @param usr
     * @param pasword
     */
    public RemoteShellExecutor(String ip, String usr, String pasword) {
         this.ip = ip;
        this.osUsername = usr;
        this.password = pasword;
    }


    /**
    * 登录
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
    public int  exec(String cmds) throws Exception {
        InputStream stdOut = null;
        InputStream stdErr = null;
        String outStr = "";
        int ret = -1;
        try {
            Boolean a= login();
            System.out.println(a);
        if (a) {
            // Open a new {@link Session} on this connection
            Session session = conn.openSession();
            // Execute a command on the remote machine.
            System.out.println(cmds);
            session.execCommand(cmds);
            
            stdOut = new StreamGobbler(session.getStdout());
            outStr = processStream(stdOut, charset);
            
            stdErr = new StreamGobbler(session.getStderr());
            
            session.waitForCondition(ChannelCondition.EXIT_STATUS, TIME_OUT);
            
            System.out.println(outStr);
            
            ret = session.getExitStatus();
        } else {
            throw new Exception("登录远程机器失败" + ip); // 自定义异常类 实现略
        }
        } finally {
            if (conn != null) {
                conn.close();
            }
            IOUtils.closeQuietly(stdOut);
            IOUtils.closeQuietly(stdErr);
        }
        return ret;
    }

    /**
    * @param in
    * @param charset
    * @return
    * @throws IOException
    * @throws UnsupportedEncodingException
    */
    private String processStream(InputStream in, String charset) throws Exception {
        byte[] buf = new byte[1024];
        StringBuilder sb = new StringBuilder();
        while (in.read(buf) != -1) {
            sb.append(new String(buf, charset));
        }
        return sb.toString();
    }

    /**
     * 0：IP1
     * 1：IP2
     * 2：Tomcat 停止-启动间隔
     * 3：两台机器集群，先后Tomcat重启的等待时间
     * 4：用户名
     * 5：密码
     * @param args
     * @throws Exception
     */
   public static void main(String args[]) throws Exception {
	   System.out.println(GsonTools.toJson(args));
	   RemoteShellExecutor executor =null; 

       System.out.println("============================================================");
       
       executor=new RemoteShellExecutor(args[0], args[4],args[5]);
       
       System.out.println("机器IP:"+args[0]);
       System.out.println("正在停止Tomcat服务...");
       executor.exec("/opt/apache-tomcat-8.0.53/bin/shutdown.sh");
       
       System.out.println("等待 "+args[2]+"秒 进行启动...");
       Thread.sleep(Long.parseLong(args[2])*1000L);
       
       System.out.println("正在启动Tomcat服务");
       executor.exec("/opt/apache-tomcat-8.0.53/bin/startup.sh");
       
       System.out.println("正在等待 "+args[0]+" Tomcat 启动完毕，等待:"+Long.parseLong(args[3])*1000L);
       
       Thread.sleep(Long.parseLong(args[3])*1000L);
       
       System.out.println("============================================================");
       
       executor=new RemoteShellExecutor(args[1], args[4],args[5]);
       
       System.out.println("机器IP:"+args[1]);
       System.out.println("正在停止Tomcat服务...");
       executor.exec("/opt/apache-tomcat-8.0.53/bin/shutdown.sh");
       
       System.out.println("等待 "+args[2]+"秒 进行启动...");
       Thread.sleep(Long.parseLong(args[2])*1000L);
       
       System.out.println("正在启动Tomcat服务");
       executor.exec("/opt/apache-tomcat-8.0.53/bin/startup.sh");
       
       System.out.println(">>>>>>>>>集群重启完毕");
       
   }
}
