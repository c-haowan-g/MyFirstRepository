/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.excel;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.xdemo.app.xutils.j2se.ReflectUtils;

import com.bluebirdme.core.system.annotations.Comment;
import com.bluebirdme.core.system.excel.ExcelContent;
import com.bluebirdme.core.system.excel.ExcelImportHandler;
import com.bluebirdme.core.system.excel.IExcelValueConvertor;
import com.bluebirdme.core.system.excel.ImportErrorMessage;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.mes.linglong.test.entity.ExcelDemo;
import com.bluebirdme.mes.linglong.test.service.ExcelDemoServiceImpl;

/**
 * 
 * @author Goofy
 * @Date 2018年8月8日 上午8:27:31
 */
public class MyExcelImportHandler extends ExcelImportHandler {
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Excel数据验证
	 */
	@Override
	public List<ImportErrorMessage> validate(ExcelContent content) {
		
		//获取所有的行，行结构{列索引:值}
		List<Map<Integer,String>> list=content.getRows();
		
		List<ImportErrorMessage> msgs=new ArrayList<ImportErrorMessage>();
		ImportErrorMessage msg=null;
		for(int rowIndex=0;rowIndex<list.size();rowIndex++){
			
			for(Integer columnIndex:list.get(rowIndex).keySet()){
				if(StringUtils.isBlank(list.get(rowIndex).get(columnIndex))){
					msg=new ImportErrorMessage(rowIndex+1, columnIndex+1, LanguageProvider.getMessage("tip.notnull"));
					msgs.add(msg);
				}
			}
		}
		
		return msgs;
	}

	@Override
	public void toDB(ExcelContent content) throws Exception {
		System.out.println("TO DB");
		List<ExcelDemo> list=convertToEntityList(ExcelDemo.class, content, null);
		ExcelDemoServiceImpl srv=(ExcelDemoServiceImpl)SpringContext.getBean("excelDemoServiceImpl");
		//srv.save(list);
	}

}
