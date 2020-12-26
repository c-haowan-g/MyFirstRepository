/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.core.common.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.tomcat.util.http.MimeHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.MapUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import sun.misc.BASE64Decoder;

import com.bluebirdme.core.common.entity.ExportOptions;
import com.bluebirdme.core.common.service.ExportOptionsServiceImpl;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.NoLogin;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.excel.ExcelExportHandler;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;

/**
 * Excel导出操作Controller
 * 
 * @author Goofy
 * @Date 2018年7月7日 上午9:34:03
 */
@RestController
@RequestMapping("/excel")
public class ExcelExportController extends BaseController<Object> {

	@Resource
	ExportOptionsServiceImpl optionsSrv;

	private void addHeader(HttpServletRequest request, String k, String v) {
		Class<? extends HttpServletRequest> requestClass = request.getClass();
		try {
			Field request1 = requestClass.getDeclaredField("request");
			request1.setAccessible(true);
			Object o = request1.get(request);
			Field coyoteRequest = o.getClass().getDeclaredField("coyoteRequest");
			coyoteRequest.setAccessible(true);
			Object o1 = coyoteRequest.get(o);
			Field headers = o1.getClass().getDeclaredField("headers");
			headers.setAccessible(true);
			MimeHeaders o2 = (MimeHeaders) headers.get(o1);
			o2.addValue(k).setString(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@NoLogin
	@Log(value = "导出Excel", code = "EXCEL_EXPORT", target = LogType.CONSOLE)
	@RequestMapping("/export")
	public void export(String filter, Integer pageNo, Integer rows, Integer all, String ids, String factory, String serviceName, String options, String handler) throws Exception {
		// String logFile=PathUtils.classPath()+File.separator+"excel.log";

		BASE64Decoder b = new BASE64Decoder();

		filter = new String(b.decodeBuffer(filter.replace(" ", "+").replace("\n", "")), Charset.forName("UTF-8"));
		handler = new String(b.decodeBuffer(handler.replace(" ", "+").replace("\n", "")), Charset.forName("UTF-8"));
		serviceName = new String(b.decodeBuffer(serviceName.replace(" ", "+").replace("\n", "")), Charset.forName("UTF-8"));
		options = new String(b.decodeBuffer(options.replace(" ", "+").replace("\n", "")), Charset.forName("UTF-8"));

		Page page = new Page();
		page.setAll(all == null ? 0 : all);
		page.setPage(pageNo == null ? 1 : pageNo);
		page.setRows(rows == null ? 15 : rows);

		addHeader(request, FactoryConstant.FACTORY, factory);

		Map<String, String> map;
		try {
			map = GsonTools.jsonToMap(filter);
		} catch (Exception e) {
			map = new HashMap<String, String>();
		}

		Filter _filter = new Filter();
		_filter.setFilter(map);

		ExportOptions _options = optionsSrv.unique("handler", handler);

		if (_options == null) {
			ExportOptions ops = new ExportOptions();
			ops.setHandler(handler);
			ops.setOptions(options);
			ops.setServiceName(serviceName);
			optionsSrv.save(ops);
		} else {
			_options.setOptions(options);
			optionsSrv.update(_options);
		}

		Map<String, Object> options2 = GsonTools.jsonToMap(options);

		@SuppressWarnings("unchecked")
		ArrayList<Map<String, Object>> columns = (ArrayList<Map<String, Object>>) options2.get("columns");

		Integer exportScope = Integer.parseInt(options2.get("exportScope").toString());

		if (exportScope == 1) {
			page.setAll(1);
		}

		String excelName = (String) options2.get("name");
		excelName = excelName.endsWith(".csv") ? excelName : (excelName + ".csv");

		StringBuffer titles = new StringBuffer();

		String[] columnNames = new String[columns.size()];

		for (int i = 0, j = columns.size(); i < j; i++) {
			titles.append(parseContent((columns.get(i).get("columnTextName").toString().toUpperCase().equals("ID")?"序号":columns.get(i).get("columnTextName").toString())) + ",");
			columnNames[i] = (String) columns.get(i).get("columnName");
		}

		response.getOutputStream().write("pleas wait...".getBytes());
		
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("content-disposition", "attachment;filename=" + new String(excelName.getBytes("GBK"), "ISO-8859-1"));
		
		OutputStream writer = response.getOutputStream();
		writer.write((titles+ System.getProperty("line.separator")).getBytes("GBK"));
		// 缓冲输出到客户端，浏览器将立即开始下载，提高用户体验
		writer.flush();
		System.out.println("FLUSHED");
		ExcelExportHandler export = (ExcelExportHandler) Class.forName(handler).newInstance();
		
		if(page.getAll()==1){
			//writer.close();
			//return;
		}
		
		export.regFormatter();

		List<Object> rowsData = null;

		int batchQueryCount = 100;

		int pageNum = 1;

		for (;;) {
			System.out.println("导出-正在查询 第" + pageNum + "页数据");
			page.setAll(0);
			page.setPage(pageNum++);
			page.setRows(batchQueryCount);
			long t1=System.currentTimeMillis();
			if (exportScope == 1 || exportScope == 2) {
				rowsData = export.getRows(_filter, page, serviceName);
			} else {
				Long[] ids2 = new Long[ids.split(",").length];
				int i = 0;
				for (String id : ids.split(",")) {
					ids2[i++] = Long.parseLong(id);
				}
				rowsData = export.getRows(ids2, serviceName);
			}
			long t2=System.currentTimeMillis();
			System.out.println("数据查询完成，耗时:"+(t2-t1)+"ms");
			// 导出数据
			for (Object obj : rowsData) {
				/*parseRow(writer, obj, columnNames, export);*/
				Map<String, Object> dataMap=null;
				if(obj instanceof Map){
					dataMap=(Map<String, Object>) obj;
				}else{
					dataMap = MapUtils.entityToMap(obj);
				}
				IExcelValueFormatter formatter = null;
				StringBuffer sb = new StringBuffer();
				for (String column : columnNames) {
					formatter = export.getFormatter(column);
					if(dataMap.get(column) instanceof Date){
						sb.append("\t");
					}
					if (formatter != null) {
						sb.append(parseContent(formatter.format(dataMap.get(column))) + ",");
					} else {
						sb.append(parseContent(dataMap.get(column)==null?"":dataMap.get(column).toString()) + ",");
					}
				}
				writer.write((sb.toString()+ System.getProperty("line.separator")).getBytes("GBK"));
				writer.flush();
			}

			if (rowsData.size() < batchQueryCount) {
				break;
			}
		}
		writer.close();
		System.out.println("导出数据写入完成");
	}

	void parseRow(OutputStream writer, Object source, String[] columns, ExcelExportHandler export) throws IllegalArgumentException, IllegalAccessException {

		Map<String, Object> map = MapUtils.entityToMap(source);

		IExcelValueFormatter formatter = null;
		StringBuffer sb = new StringBuffer();
		for (String column : columns) {
			formatter = export.getFormatter(column);
			if (formatter != null) {
				sb.append(formatter.format(map.get(column)) + ",");
			} else {
				sb.append(map.get(column) + ",");
			}
		}
		writeRow(writer, sb.toString());
	}

	void writeRow(OutputStream writer, String content) {
		try {
			writer.write((content + System.getProperty("line.separator")).getBytes("GBK"));
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void download(SXSSFWorkbook wb, String excelName) throws Exception {
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename=" + new String((excelName).getBytes("gbk"), "iso8859-1") + ".xlsx");
		response.setContentType("application/msexcel");// 定义输出类型

		OutputStream os = response.getOutputStream();

		wb.write(os);
		wb.dispose();

		os.flush();
		os.close();

	}
	
	
	private String parseContent(String str) {
		if(StringUtils.isBlank(str)){
			return "";
		}
		//csv格式如果有逗号，整体用双引号括起来；如果里面还有双引号就替换成两个双引号，这样导出来的格式就不会有问题了			
		String tempDescription=str;
		tempDescription=tempDescription.replace("\n", " ").replace("\r", " ").replace("null", "");
		//如果有逗号
		if(str.contains(",")){				
			//如果还有双引号，先将双引号转义，避免两边加了双引号后转义错误
			if(str.contains("\"")){
				tempDescription=str.replace("\"", "\"\"");
			}
			//在将逗号转义
			tempDescription="\""+tempDescription+"\"";
		}
		return tempDescription;
	}

	public static void main(String[] args) {
		Map<String,Object> x=new HashMap<String,Object>();
		System.out.println(x instanceof HashMap);
	}

}
