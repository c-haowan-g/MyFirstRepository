/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.core.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.ObjectUtils;

import com.bluebirdme.core.common.entity.Attachment;
import com.bluebirdme.core.common.service.AttachmentServiceImpl;
import com.bluebirdme.core.common.service.ExportOptionsServiceImpl;
import com.bluebirdme.core.common.service.SystemConfigServiceImpl;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseController;
import com.bluebirdme.core.system.excel.ExcelContent;
import com.bluebirdme.core.system.excel.ExcelImportHandler;
import com.bluebirdme.core.system.excel.ImportErrorMessage;
import com.bluebirdme.core.system.web.Response;

/**
 * Excel导入操作Controller
 * 
 * @author Goofy
 * @Date 2018年7月7日 上午9:34:03
 */
@Log(value = "Excel导入", code = "EXCEL")
@RestController
@RequestMapping("/excel")
public class ExcelImportController extends BaseController<Object> {

	@Resource
	ExportOptionsServiceImpl optionsSrv;
	@Resource
	AttachmentServiceImpl attSrv;
	@Resource
	SystemConfigServiceImpl configSrv;

	@Log(value = "Excel导入", code = "EXCEL_IMPORT", target = LogType.DB)
	@RequestMapping("/import")
	public Response doImport(Long fileId, String handlerClass) throws Exception {

		Attachment attachment = attSrv.findById(fileId);

		ExcelImportHandler importHandler = (ExcelImportHandler) Class.forName(handlerClass).newInstance();

		ExcelContent content = importHandler.getContent(attachment.getPhysicaDiskPath());

		Attachment errorAtt = null;
		// 验证返回的错误信息
		List<ImportErrorMessage> msgs = importHandler.validate(content);

		// 如果错误信息不为空
		if (!ListUtils.isEmpty(msgs)) {

			// content中的数据保留正确的，错误的删除
			// 错误的行号
			Set<Integer> errorRowNumbers = new TreeSet<Integer>();

			List<Map<Integer, String>> errors = new ArrayList<Map<Integer, String>>();

			// 找出错误的行号
			for (int i = msgs.size() - 1; i >= 0; i--) {
				errorRowNumbers.add(msgs.get(i).getRow());
			}
			// 表格数据
			List<Map<Integer, String>> list = content.getRows();
			// 获取错误的行数据
			for (Integer i : errorRowNumbers) {
				errors.add(list.get(i - 2));
			}
			// 保留错误数据
			content.setRows(errors);
			// 写数据到新文件
			errorAtt = writeError(content, attachment, msgs);
			// 在数据中删除错误的行
			// Integer ns[] = errorRowNumbers.toArray(new Integer[] {});
			//
			// for (int i = ns.length - 1; i >= 0; i--) {
			// list.remove(ns[i] - 2);
			// }

			// 正确的数据
			content.setRows(list);
		}

		importHandler.toDB(content);

		if (!ListUtils.isEmpty(msgs)) {
			return Response.error(Response.SYS_EXCEPTION, getMessage("tip.importError"), errorAtt);
		}

		return Response.suc();
	}

	public Attachment writeError(ExcelContent content, Attachment old, List<ImportErrorMessage> msgs) throws Exception {

		SXSSFWorkbook wb = new SXSSFWorkbook();

		SXSSFSheet sheet = wb.createSheet("未导入的数据");

		int rowIndex = 0;

		SXSSFRow row = sheet.createRow(rowIndex++);

		int columns = 0;

		Map<String, Integer> header = content.getHeaders();

		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(header.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});

		for (Entry<String, Integer> aEntry : list) {
			row.createCell(columns++).setCellValue(aEntry.getKey());
		}

		for (Map<Integer, String> rowData : content.getRows()) {
			columns = 0;
			row = sheet.createRow(rowIndex++);
			for (Entry<String, Integer> aEntry : list) {
				row.createCell(columns++).setCellValue(rowData.get(aEntry.getValue()));
			}
		}

		// 写错误信息
		sheet = wb.createSheet("错误原因");
		rowIndex = 0;
		row = sheet.createRow(rowIndex++);
		int maxColumnIndex = 0;
		columns = 0;
		for (Entry<String, Integer> aEntry : list) {
			row.createCell(columns++).setCellValue(aEntry.getKey());
		}

		for (Map<Integer, String> rowData : content.getRows()) {
			columns = 0;
			row = sheet.createRow(rowIndex++);
			for (Entry<String, Integer> aEntry : list) {
				row.createCell(columns++).setCellValue(rowData.get(aEntry.getValue()));
				if (columns > maxColumnIndex) {
					maxColumnIndex = columns;
				}
			}
		}

		Map<Integer, String> error = new HashMap<Integer, String>();
		for (ImportErrorMessage msg : msgs) {
			if (!error.containsKey(msg.getRow())) {
				error.put(msg.getRow(), "");
			}
			error.put(msg.getRow(), error.get(msg.getRow()) + " / " + getError(msg));
		}
		rowIndex = 1;
		for (String msg : error.values()) {
			row = sheet.getRow(rowIndex++);
			row.createCell(maxColumnIndex).setCellValue(msg);
		}

		Attachment newAttachment = ObjectUtils.copy(old);

		String uploadPath = configSrv.get("UPLOAD_PATH");

		String fileUUIDName = UUID.randomUUID().toString();

		newAttachment.setFileUUIDName(fileUUIDName);

		newAttachment.setPhysicaDiskPath(uploadPath + File.separator + newAttachment.getDir() + File.separator
				+ fileUUIDName + ".xlsx");

		newAttachment.setWebPath("/import/" + fileUUIDName + ".xlsx");

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(uploadPath + File.separator + newAttachment.getDir() + File.separator
					+ fileUUIDName + ".xlsx");
			wb.write(fos);
		} catch (Exception e) {
			throw e;
		} finally {
			if (fos != null) {
				fos.close();
			}
			wb.close();
		}

		attSrv.save(newAttachment);

		return newAttachment;
	}

	public String getError(ImportErrorMessage msg) {
		StringBuffer sb = new StringBuffer();
		/*
		 * if (msg.getRow() != null) { sb.append(msg.getRow() +
		 * getMessage("tip.row")); }
		 */
		if (msg.getColumn() != null) {
			if (msg.getColumn() == 4) {
				sb.append(" " + "4-5" + getMessage("tip.column"));
			} else {
				sb.append(" " + msg.getColumn() + getMessage("tip.column"));
			}
		}
		sb.append(" " + msg.getMessage());

		return sb.toString();

	}

}
