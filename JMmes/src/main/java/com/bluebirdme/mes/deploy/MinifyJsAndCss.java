/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2018版权所有
 */
package com.bluebirdme.mes.deploy;

import java.io.IOException;
import java.nio.charset.Charset;

import org.xdemo.app.xutils.j2se.FileUtils;

/**
 * 
 * @author Goofy
 * @Date 2018年9月28日 下午2:41:43
 */
public class MinifyJsAndCss {
	
	public static void main(String[] args) throws IOException {
	
		String js[]={"jquery-1.12.4.min.js","jquery.ajax.ext.js","jquery.easyui.min.js","jquery.easyui.custom.js","jquery.easyui.default.js","jquery.easyui.extentions.js","jquery.toast.min.js","jquery.ztree.all.min.js","stomp.min.js","utils.js","ext.js","file.js","Calendar.js","ajaxfileupload.js","component.js"};
		String css[]={"easyui.css","jquery.toast.min.css","zTreeStyle.css"};
		for (String jsFile:js) {
			System.out.println("正在合并"+jsFile);
			String content[]=FileUtils.read("D:\\x\\"+jsFile,Charset.forName("UTF-8"));
			for(String c:content){
				FileUtils.write(c, "D:\\mini.js", true, true);
			}
			
		}
		for (String cssFile:css) {
			System.out.println("正在合并"+cssFile);
			String content[]=FileUtils.read("D:\\x\\"+cssFile,Charset.forName("UTF-8"));
			for(String c:content){
				FileUtils.write(c, "D:\\mini.css", true, true);
			}
		}
	}

}
