/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 华东工程中心（无锡）
 * 2016版权所有
 */
package com.bluebirdme.core.system.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.xdemo.app.xutils.j2se.ReflectUtils;

import com.bluebirdme.core.system.annotations.Comment;

/**
 * Excel数据操作
 * 
 * @author Goofy
 * @Date 2016年5月19日 下午4:15:30
 */
public abstract class ExcelImportHandler {

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Excel数据校验
	 * 
	 * @param content
	 * @return
	 */
	public abstract List<ImportErrorMessage> validate(ExcelContent content);

	/**
	 * 写入数据库
	 * 
	 * @param content
	 * @return
	 */
	public abstract void toDB(ExcelContent content) throws Exception;

	protected <T> List<T> convertToEntityList(Class<T> clazz, ExcelContent content, Map<String, IExcelValueConvertor> convertors) throws Exception {
		List<Field> list = ReflectUtils.getFields(clazz, false);

		if (convertors == null) {
			convertors = new HashMap<String, IExcelValueConvertor>();
		}

		List<T> ret = new ArrayList<T>();

		Map<String, Integer> header = content.getHeaders();

		// 字段名和Excel中列的对应关系，如:name-1，age-2
		Map<Field, Integer> columnAndIndex = new HashMap<Field, Integer>();

		Comment comment = null;

		for (Field field : list) {

			comment = field.getAnnotation(Comment.class);

			if (comment == null) {
				continue;
			}

			if (header.containsKey(comment.value())) {
				columnAndIndex.put(field, header.get(comment.value()));
			}
		}
		T t = null;
		String type;
		String value;
		for (Map<Integer, String> row : content.getRows()) {

			t = clazz.newInstance();

			for (Field field : columnAndIndex.keySet()) {

				field.setAccessible(true);
				type = field.getType().getSimpleName().toUpperCase();
				value = row.get(columnAndIndex.get(field));

				if (value == null) {
					field.set(t, null);
					continue;
				}
				if (convertors.get(field.getName()) != null) {
					field.set(t, convertors.get(field.getName()).convert(value));
					continue;
				}

				switch (type) {
				case "STRING":
					field.set(t, value);
					break;
				case "DATE":
					field.set(t, format.parse(value));
					break;
				case "INTEGER":
					field.set(t, Double.valueOf(Double.parseDouble(value)).intValue());
					break;
				case "DOUBLE":
					field.set(t, Double.parseDouble(value));
					break;
				case "FLOAT":
					field.set(t, Float.parseFloat(value));
					break;
				case "BIGDECIMAL":
					field.set(t, new BigDecimal(value));
					break;
				case "LONG":
					field.set(t, Double.valueOf(Double.parseDouble(value)).longValue());
					break;
				default:
					throw new Exception("无法识别的数据类型" + type);
				}
			}

			ret.add(t);
		}

		return ret;
	}

	/**
	 * 获取Excel内容
	 * 
	 * @author Goofy
	 * @Date 2018年8月5日 上午11:40:22
	 * @param excelFilePath
	 * @return
	 * @throws IOException
	 */
	public ExcelContent getContent(String excelFilePath) throws IOException {
		List<Map<Integer, String>> rows = new ArrayList<Map<Integer, String>>();

		// 读取文件
		XSSFWorkbook wb = new XSSFWorkbook(excelFilePath);

		Sheet sheet = wb.getSheetAt(0);
		Row title = sheet.getRow(0);

		Map<String, Integer> header = new TreeMap<String, Integer>();

		for (int i = 0; i < title.getPhysicalNumberOfCells(); i++) {
			header.put(title.getCell(i).getStringCellValue(), i);
		}

		Map<Integer, String> row = null;

		int rowIndex = 0;
		int columns = header.size();
		Cell cell = null;
		Row row_ = null;

		for (Iterator<Row> it = sheet.rowIterator(); it.hasNext();) {

			row_ = it.next();
			
			if (rowIndex++ == 0) {
				continue;
			}

			if (row_ == null) {
				break;
			}

			row = new TreeMap<Integer, String>();

			Object value = null;

			for (int i = 0; i < columns; i++) {
				cell = row_.getCell(i);
				if (cell != null) {
					cell.setCellType(CellType.STRING);
					value=cell.getStringCellValue();
					if (value != null)
						row.put(i, value.toString());
					else
						row.put(i, null);
				} else {
					row.put(i, null);
				}
			}
			
			if(checkRow(row)){
				rows.add(row);
			}
		}

		wb.close();

		return new ExcelContent(header, rows);
	}
	
	boolean checkRow(Map<Integer, String> row){
		boolean valid=false;
		for(String str:row.values()){
			if(!StringUtils.isBlank(str)){
				valid=true;
				break;
			}
		}
		return valid;
	}

}
