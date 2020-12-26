/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.controller;

import java.io.File;
import java.util.List;

import org.xdemo.app.xutils.ext.ZipUtils;
import org.xdemo.app.xutils.j2se.FileUtils;

import com.datasweep.compatibility.client.ATRow;
import com.datasweep.compatibility.client.Response;
import com.datasweep.compatibility.pnuts.Functions;
import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.objects.MESATObject;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 
 * @author Goofy
 * @Date 2018年8月21日 下午2:48:41
 */
public class Test2 extends MESATObject{
	
	
	
	private String code;
	
	

	@Override
	public String getATDefinitionName() {
		return "Test2";
	}

	public static void main(String[] args) {
		
		List<File> files=FileUtils.getFiles("D:\\lib");
		for(File file:files){
			System.out.println(file.getName());
			ZipUtils.unZip(file.getAbsolutePath(), "D:\\xxx\\");
		}
		
	}
	
	
	

}
