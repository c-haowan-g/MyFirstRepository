/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.excel;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.service.WorkorderResultServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.excel.IExcelValueFormatter;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class WorkorderResultExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	WorkorderResultServiceImpl service = (WorkorderResultServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"WorkorderResultServiceImpl"首字母改为小写
   				.firstCharToLowerCase("WorkorderResultServiceImpl"));
   		List<Object> list = new ArrayList<Object>();
   		List<Map<String,Object>> entityList = service.datagridRowsUDA(filter, page);
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
//		List<Object> listATO = new ArrayList<>();


//		
		
		// 转换下拉框
//		if (listshu != null) {
//			for (int i = 0; i < listshu.size(); i++) {
//				// <!-- 产出标记 基础数据105 105001正常产出105002补产出105003取消产出 -->
//				//判断map中是否包含指定的key
//				if (listshu.get(i).containsKey("add_flag_s")){
//					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
//					listshu.get(i).put("add_flag_s", exportCombox.getDictname(listshu.get(i).get("add_flag_s").toString()));
//				}
//				// <!-- 数据字典177 -->
//				//判断map中是否包含指定的key
//				if (listshu.get(i).containsKey("solid_yflag_s")){
//					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
//					listshu.get(i).put("solid_yflag_s", exportCombox.getDictname(listshu.get(i).get("solid_yflag_s").toString()));
//				}
//				// <!-- 数据字典253 -->
//				//判断map中是否包含指定的key
//				if (listshu.get(i).containsKey("quality_status_s")){
//					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
//					listshu.get(i).put("quality_status_s", exportCombox.getDictname(listshu.get(i).get("quality_status_s").toString()));
//				}
//				// <!-- 重量是否合格 -->
//				//判断map中是否包含指定的key
//				if (listshu.get(i).containsKey("quality_weight_status_s")){
//					//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
//					if(listshu.get(i).get("spare5_s")==null){
//						if(listshu.get(i).get("building_weight_s") == null){
//							listshu.get(i).put("quality_weight_status_s", "");
//						}else{
//							listshu.get(i).put("quality_weight_status_s", "合格");
//						}
//					}else{
//						listshu.get(i).put("quality_weight_status_s", listshu.get(i).get("spare5_s"));
//					}
//					
//				}	
//				//上下限重量
//				if(listshu.get(i).containsKey("max_weight_s")&&listshu.get(i).containsKey("min_weight_s")){
//					if(listshu.get(i).get("standard_weight_s") == null){
//						listshu.get(i).put("max_weight_s", "");
//						listshu.get(i).put("min_weight_s", "");
//					}else{
//						BigDecimal valueStandard = new BigDecimal(listshu.get(i).get("standard_weight_s").toString());
//						listshu.get(i).put("max_weight_s", valueStandard.multiply(valueMax).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
//						listshu.get(i).put("min_weight_s", valueStandard.multiply(valueMin).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
//					}
//				}
//			}
//		}
		
		/**
		 * 导出数据转换
		 * @author 李德晓
		 * 2020/8/14修改上下限重量导出（区分半钢、全钢）
		 * @Date 2020-08-14 15:20:24
		 *  
		 */
		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				
   				//转换是否补成型成中文
   				if (entityList.get(i).get("add_flag_s") != null) {
					if (entityList.get(i).get("add_flag_s").equals("105001")) {
						entityList.get(i).put("add_flag_s", "正常产出");
					} else if(entityList.get(i).get("add_flag_s").equals("105002")){
						entityList.get(i).put("add_flag_s", "补产出");
					}else if(entityList.get(i).get("add_flag_s").equals("105003")){
					    entityList.get(i).put("add_flag_s", "取消产出");
					}
				}
   				
   				//转换补产出类型成中文
   				
   				if (entityList.get(i).get("created_by_s") != null) {
					if (entityList.get(i).get("created_by_s").equals("360001")) {
						entityList.get(i).put("created_by_s", "新增");
					} else if(entityList.get(i).get("created_by_s").equals("360002")){
						entityList.get(i).put("created_by_s", "条码替换");
					}else if(entityList.get(i).get("created_by_s").equals("360003")){
					    entityList.get(i).put("created_by_s", "规格更改");
					}
				}
   				
   				if(entityList.get(i).get("add_flag_s").equals("正常产出")){
   					entityList.get(i).put("created_by_s", "");
   				}
   				//转换质量等级成中文
   			 if (entityList.get(i).get("quality_status_s") != null) {
                 entityList.get(i).put("quality_status_s", exportCombox.getDictName((String) entityList.get(i).get("quality_status_s")));
             }
   		       //转换固化状态成中文
   			 if (entityList.get(i).get("solid_yflag_s") != null) {
                 entityList.get(i).put("solid_yflag_s", exportCombox.getDictName((String) entityList.get(i).get("solid_yflag_s")));
             }
   		      //转换班次成中文
   			 
   			if (entityList.get(i).get("building_shift_s") != null) {
                entityList.get(i).put("building_shift_s", exportCombox.getDictName((String) entityList.get(i).get("building_shift_s")));
            }
   		 //转换补录原因成中文
  			 
   			if (entityList.get(i).get("spare1_s") != null) {
                entityList.get(i).put("spare1_s", exportCombox.getDictName((String) entityList.get(i).get("spare1_s")));
            }
   		     //转换是否首条成中文
				if (entityList.get(i).get("first_s") != null) {
				   if (entityList.get(i).get("first_s").equals("0")) {
					entityList.get(i).put("first_s", "是");
				} else if(entityList.get(i).get("first_s").equals("1")){
					entityList.get(i).put("first_s", "否");
				}
			}
				
				if (entityList.get(i).containsKey("quality_weight_status_s")){
				//如果存在，可以直接put新的键值对。新的键值会自动覆盖之前的。
					if(entityList.get(i).get("spare5_s")==null){
						if(entityList.get(i).get("building_weight_s") == null){
							entityList.get(i).put("quality_weight_status_s", "");
					}else{
						entityList.get(i).put("quality_weight_status_s", "合格");
						}
				}else{
					entityList.get(i).put("quality_weight_status_s", entityList.get(i).get("spare5_s"));
				}
				
				}	
				//上下限重量
				
				if(LLWebUtils.factory().equals("1")){
				List<Map<String, Object>> weightData = service.getWeightData();
				BigDecimal valueMax = new BigDecimal(weightData.get(0).get("VALUEMAX_S").toString().substring(1, weightData.get(0).get("VALUEMAX_S").toString().length()));
				BigDecimal valueMin = new BigDecimal(weightData.get(0).get("VALUEMIN_S").toString().substring(1, weightData.get(0).get("VALUEMIN_S").toString().length()));
				if(entityList.get(i).containsKey("max_weight_s")&&entityList.get(i).containsKey("min_weight_s")){
					if(entityList.get(i).get("standard_weight_s") == null){
						entityList.get(i).put("max_weight_s", "");
						entityList.get(i).put("min_weight_s", "");
					}else{
						BigDecimal valueStandard = new BigDecimal(entityList.get(i).get("standard_weight_s").toString());
						entityList.get(i).put("max_weight_s", valueStandard.multiply(valueMax).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
						entityList.get(i).put("min_weight_s", valueStandard.multiply(valueMin).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
					}
				}
				}else if(LLWebUtils.factory().equals("2")){
					List<Map<String, Object>> weightData = service.getHalfWeightData();
					BigDecimal valueMax = new BigDecimal(weightData.get(0).get("VALUEMAX_S").toString().substring(1, weightData.get(0).get("VALUEMAX_S").toString().length()));
					BigDecimal valueMin = new BigDecimal(weightData.get(0).get("VALUEMIN_S").toString().substring(1, weightData.get(0).get("VALUEMIN_S").toString().length()));
					if(entityList.get(i).containsKey("max_weight_s")&&entityList.get(i).containsKey("min_weight_s")){
						if(entityList.get(i).get("standard_weight_s") == null){
							entityList.get(i).put("max_weight_s", "");
							entityList.get(i).put("min_weight_s", "");
						}else{
							BigDecimal valueStandard = new BigDecimal(entityList.get(i).get("standard_weight_s").toString());
							entityList.get(i).put("max_weight_s", valueStandard.multiply(valueMax).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
							entityList.get(i).put("min_weight_s", valueStandard.multiply(valueMin).setScale(3,BigDecimal.ROUND_HALF_UP).toString());
						}
					}
				}
				
   				list.add(entityList.get(i));
   			}
   		}
   		return list;
	}
    
    
    @Override
    public void regFormatter() {
//        //<!-- 是否首条 0：是， 1：否 -->
//        regFormatter("first_s", new IExcelValueFormatter() {
//        	@Override
//        	public String format(Object value) {
//        		if(((String)value).equals("0")){return "是";}
//            	if(((String)value).equals("1")){return "否";}
//				return null;
//			}
//        });
    }
}
