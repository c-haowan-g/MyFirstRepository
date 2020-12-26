package com.bluebirdme.mes.linglong.curing.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bluebirdme.core.system.excel.ExcelContent;
import com.bluebirdme.core.system.excel.ExcelImportHandler;
import com.bluebirdme.core.system.excel.ImportErrorMessage;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.LanguageProvider;
import com.bluebirdme.mes.linglong.curing.entity.CapsuleStock;
import com.bluebirdme.mes.linglong.curing.service.CapsuleStockServiceImpl;

public class CapsuleStockImportHandler extends ExcelImportHandler {

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * Excel数据验证
	 */
	@Override
	public List<ImportErrorMessage> validate(ExcelContent content) {

		// 获取所有的行，行结构{列索引:值}
		List<Map<Integer, String>> list = content.getRows();

		List<ImportErrorMessage> msgs = new ArrayList<ImportErrorMessage>();
		ImportErrorMessage msg = null;
		for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {

			for (Integer columnIndex : list.get(rowIndex).keySet()) {
				if (StringUtils.isEmpty(list.get(rowIndex).get(columnIndex))) {
					msg = new ImportErrorMessage(rowIndex + 1, columnIndex + 1,
							LanguageProvider.getMessage("tip.notnull"));
					msgs.add(msg);
				}
			}
		}

		return msgs;
	}

	@Override
	public void toDB(ExcelContent content) throws Exception {
		System.out.println("TO DB");
		List<CapsuleStock> list = convertToEntityList(CapsuleStock.class,
				content, null);
		CapsuleStockServiceImpl srv = (CapsuleStockServiceImpl) SpringContext
				.getBean("capsuleStockServiceImpl");
		srv.save(list);
	}

}
