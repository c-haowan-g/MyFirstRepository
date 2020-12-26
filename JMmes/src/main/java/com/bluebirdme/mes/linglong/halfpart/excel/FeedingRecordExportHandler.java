/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.halfpart.entity.FeedingRecord;
import com.bluebirdme.mes.linglong.halfpart.service.FeedingRecordServiceImpl;

/**
 * 导出处理器
 * @author Goofy
 * @Date 2018年7月13日 下午2:30:34
 */
public class FeedingRecordExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	FeedingRecordServiceImpl feedingRecord =
    (FeedingRecordServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("FeedingRecordServiceImpl"));

		List<Object> listATO = new ArrayList<>();
		List<FeedingRecord> output = feedingRecord.datagridRows(filter, page, FeedingRecord.class);
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		// 转换下拉框
		if(output!=null){
			for(int i=0;i<output.size();i++){
				//班次 基础数据118
				if(NullString(output.get(i).getBz_class_s())){
					output.get(i).setBz_class_s(exportCombox.getDictname(output.get(i).getBz_class_s()));
				}
				//投料类型 基础数据308
				if(NullString(output.get(i).getFeedingtype_s())){
					output.get(i).setFeedingtype_s(exportCombox.getDictname(output.get(i).getFeedingtype_s()));
				}
			}
		}
		if (output != null) {
			for (int i = 0; i < output.size(); i++) {
				listATO.add(output.get(i));
			}
		}
		return listATO;
	}
    /**
   	 * 判断字符串是否为空，若为空则返回false,否则返回true
   	 * @param value
   	 * @return
   	 */
   	private boolean NullString(String value){
   		boolean t=false;
   		if(null!=value&&!"".equals(value)){
   			t=true;
   		}
   		return t;
   	}
    @Override
    public void regFormatter() {
    
    }

}
