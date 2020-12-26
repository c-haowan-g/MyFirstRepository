package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.QueryCheckXrayResultServiceImpl;
/**
 * X光检测信息查询
 * @author 时永良
 * @Date 2020年2月24日13:31:06
 */
@Log(code="X光质检信息表",value="X光质检信息表")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/queryCheckXrayResult")
public class QueryCheckXrayResultController extends RockWellFunctionalUDAController<Object>{
	@Resource QueryCheckXrayResultServiceImpl querycheckxrayresultSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return querycheckxrayresultSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return querycheckxrayresultSrv;
	}
    
    @Override
	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
    	Map<String, Object> map = querycheckxrayresultSrv.datagridUDAReWrite(filter, page);
    	return GsonTools.toJson(map);
    }
    
//    @Log(code = "SearchDefectName", value = "查询病象描述（中文）", target = LogType.CONSOLE)
//	@RequestMapping("SearchDefectName")
//	public String SearchDefectName(String checkseq,String defectid) throws Exception {
//		List<Map<String, Object>> list = querycheckxrayresultSrv.SearchDefectName(checkseq,defectid);
//		return toJson(list);
//	}
//    
    @Log(code = "SearchDefectName", value = "查询病象描述（中文）", target = LogType.CONSOLE)
	@RequestMapping("SearchDefectName")
    public String SearchDefectName(int count,String code,String starttime,String endtime) throws Exception {
		List<Map<String, Object>> list = querycheckxrayresultSrv.SearchDefectName(count,code,starttime,endtime);
		String string = "";
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				string += list.get(i).get("REAS_CN_S") + ";";
			}
		}
		List<String> listtwo = new ArrayList<String>();
		listtwo.add(string);
		return toJson(listtwo);
	}
    /**
     * 访问FTP上的图片下载并返回给前端用于显示
     * @param workId
     * @param response
     * @param filepath 数据库存储路径
     * @throws InterruptedException
     */
    @RequestMapping("getFtpImage")
    @ResponseBody
    public String getFtpImage (String workId,HttpServletResponse response,@RequestParam String filepath,@RequestParam String title) throws InterruptedException { 
    	String msg="success";
    	//创建FTP连接
        FTPClient ftp = null;
        OutputStream outStream  = null;
        InputStream in = null;
        try {
			ftp= initFTP(ftp);
			//下载文件
            in = ftp.retrieveFileStream(new String(filepath.getBytes("gbk"), "ISO-8859-1"));//防止存储路径中有中文，导致返回InputStream为null
            if(in==null){
            	msg="请检查 "+title+" 在FTP存储路径是否正确";
            	return msg;
            }
            String picType = filepath.split("\\.")[1];
            BufferedImage bufImg = null;
            bufImg = ImageIO.read(in);
            outStream = response.getOutputStream();
            ImageIO.write(bufImg, picType, outStream);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			 if(in!=null) {
				 try {
					 in.close();
					destroy(ftp);
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		}
        return msg;
    }
    
    //FTP初始化
    public  FTPClient initFTP(FTPClient ftp) throws IOException {
    	  InputStream in = QueryCheckXrayResultController.class
				.getResourceAsStream("/xray-application.properties");
    	  Properties properties=new Properties();
          properties.load(in);
          String addr = properties.getProperty("ftp_url");
          int port=Integer.valueOf(properties.getProperty("ftp_port")).intValue();//端口
          String username=properties.getProperty("ftp_username");
          String password=properties.getProperty("ftp_password");
          ftp = new FTPClient();
          ftp.connect(addr,port);
          ftp.login(username,password);
          ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
          ftp.setControlEncoding("GBK");
          ftp.setBufferSize(1024*1024*10); //设置缓冲区上传速度为10M，默认为1K
          ftp.setFileType(FTP.BINARY_FILE_TYPE);//设置上传方式位字节      
          ftp.enterLocalPassiveMode();//Switch to passive mode
          ftp.setAutodetectUTF8(true);
          return ftp;
    }
    //关闭FTP
    public void destroy(FTPClient ftp) throws IOException {
    	 if(ftp != null){
             ftp.disconnect();
             ftp = null;
         }
    }
}
