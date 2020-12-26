/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.building.service.WeightInfoServiceImpl;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.ibm.icu.text.NumberFormat;

/**
 * 成型胎胚重量合格率（机台）导出
 * @author 栾和源
 * @Date 2020-01-15 11:22:25
 */
public class WeightInfoExportHandler extends DefaultExcelExportHandler {
    
    
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @SuppressWarnings({ "rawtypes", "unchecked", "null" })
    @Override
    public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	WeightInfoServiceImpl shu = (WeightInfoServiceImpl) SpringContext.getBean(StringUtils
				.firstCharToLowerCase("weightInfoServiceImpl"));
    	
		List<Object> listATO = new ArrayList<>();
		List<Map<String, Object>> listshu = shu.datagridRowsUDA(filter, page);
		
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		String begin_time=filter.get("begintime");
		String end_time=filter.get("endtime");
		List<Map<String, Object>> weightData = shu.getWeightData();
		BigDecimal valueMax = new BigDecimal(weightData.get(0).get("VALUEMAX_S").toString().substring(1, weightData.get(0).get("VALUEMAX_S").toString().length()));
		System.out.println("valueMax:"+valueMax);
		BigDecimal valueMin = new BigDecimal(weightData.get(0).get("VALUEMIN_S").toString().substring(1, weightData.get(0).get("VALUEMIN_S").toString().length()));
		System.out.println("valueMin:"+valueMin);
		// 转换下拉框                                                                                                               
		if (listshu != null) {
			for (int i = 0; i < listshu.size(); i++) {
				
				if(listshu.get(i).containsKey("standard_weight_s")){
					if(listshu.get(i).get("standard_weight_s") == null){
						listshu.get(i).put("max_weight_s", "0");
						listshu.get(i).put("min_weight_s", "0");
					}else{
						BigDecimal valueStandard = new BigDecimal(listshu.get(i).get("standard_weight_s").toString());
						System.out.println("valueStandard:"+valueStandard);
						listshu.get(i).put("max_weight_s", valueStandard.multiply(valueMax).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
						listshu.get(i).put("min_weight_s", valueStandard.multiply(valueMin).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
					}
				}
				
				
				String equip_code_s = listshu.get(i).get("equip_code_s").toString();
				String material_code_s = listshu.get(i).get("material_code_s").toString();
				
				
				List<Map<String, Object>> getMaterialName = shu.getMaterialName(begin_time,end_time,material_code_s);
				
				if(getMaterialName.isEmpty()){
					listshu.get(i).put("material_name_s", "");
				}else{
					listshu.get(i).put("material_name_s", getMaterialName.get(0).get("MATERIAL_NAME_S"));
				}
				
				
				String max_weight_s = listshu.get(i).get("max_weight_s").toString();
				String min_weight_s = listshu.get(i).get("min_weight_s").toString();
				
				if(listshu.get(i).get("standard_weight_s") == null){
					listshu.get(i).put("standard_weight_s", "0");
					listshu.get(i).put("weight_ok_s", "0");
					listshu.get(i).put("weight_sml_s", "0");
					listshu.get(i).put("weight_big_s", "0");
					listshu.get(i).put("weight_rate_s", "0%");
					
					
				}else{
					
					List<Map<String, Object>> getWeightPercent = shu.getWeightPercent(begin_time,end_time,equip_code_s, material_code_s,max_weight_s, min_weight_s);
						
					listshu.get(i).put("weight_ok_s", getWeightPercent.get(0).get("WEIGHT_OK_S"));
					listshu.get(i).put("weight_sml_s", getWeightPercent.get(0).get("WEIGHT_SML_S"));
					listshu.get(i).put("weight_big_s", getWeightPercent.get(0).get("WEIGHT_BIG_S"));
						
						
					BigDecimal weightOk = new BigDecimal(listshu.get(i).get("weight_ok_s").toString());
					BigDecimal valueTotal = new BigDecimal(listshu.get(i).get("total_number_count").toString());
					BigDecimal v =weightOk.divide(valueTotal, 4, RoundingMode.HALF_UP);
						
					NumberFormat percent = NumberFormat.getPercentInstance();
					percent.setMaximumFractionDigits(2);
					listshu.get(i).put("weight_rate_s",percent.format(v.doubleValue()));
					//listshu.get(i).put("weight_rate_s",(Math.round(weightOk/valueTotal*10000)/100+"%"));
					
					}
				
				
				listATO.add(listshu.get(i));
				
			}
					
		}
		
		
		return listATO;
    }
	@Override
	public void regFormatter() {
		// TODO Auto-generated method stub
		
	}
    
    
   
   
}

