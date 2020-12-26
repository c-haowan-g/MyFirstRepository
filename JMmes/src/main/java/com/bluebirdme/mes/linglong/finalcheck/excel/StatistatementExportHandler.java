/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.finalcheck.service.StatistatementServiceImpl;
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.core.system.spring.SpringContext;

import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 导出处理器
 * @author qingyu_zhou
 * @Date 2019年8月29日 下午2:30:34
 */
public class StatistatementExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName) throws Exception {
    	StatistatementServiceImpl service = (StatistatementServiceImpl) SpringContext.getBean(StringUtils
    		//需要将"StatistatementServiceImpl"首字母改为小写
   				.firstCharToLowerCase("StatistatementServiceImpl"));
   		List<Object> list = new ArrayList<>();
   
   		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean(StringUtils
   				.firstCharToLowerCase("exportServiceImpl"));
   		
   	// 转换数据，数据赋值
   		int m = 0;
		int n = 0;
		if (filter.toString().contains("huizong_s")) {
			m = 1;
		}
		if (filter.toString().contains("xiangxi_s")) {
			n = 1;
		}
		if (m == 1 && n == 0) {
			List<Map<String,Object>> entityList = service.appearance(filter, page);
	   		List<Map<String,Object>> entityList2 = service.xrayance(filter, page);
	   		entityList.addAll(entityList2);
	   		System.out.println(entityList);
	   		if (entityList != null) {
	   			for (int i = 0; i < entityList.size(); i++) {
	   				if(entityList.get(i).get("gradecd_s")!=null&&entityList.get(i).get("gradecd_s")!=null){
	   					entityList.get(i).put("gradecd_s", exportCombox.getDictname(entityList.get(i).get("gradecd_s").toString()));
	   				}
//	   				if(entityList.get(i).get("proess_s")!=null&&entityList.get(i).get("proess_s")!=null){
//	   					entityList.get(i).put("proess_s", exportCombox.getDictname(entityList.get(i).get("proess_s").toString()));
//	   				}
	   				if(entityList.get(i).get("proess_s")==null){
	   					//System.out.println(entityList.get(i).get("proess_s"));
	   					entityList.get(i).put("proess_s", "x光病象");
	   					
	   				}else{
	   					//System.out.println(entityList.get(i).get("proess_s"));
	   					entityList.get(i).put("proess_s", "外观病象");
	   				}
	   				if(entityList.get(i).get("reascd_s")!=null&&entityList.get(i).get("reascd_s")!=""  ){
	   					String str =(String) entityList.get(i).get("reascd_s");
	   					if(str.charAt(0)=='0')
	   					{
	   						continue;
	   					}
	   					if(Character.isDigit(str.charAt(0)) ){
					    entityList.get(i).put("reascd_s", service.searchUsercode(entityList.get(i).get("reascd_s").toString()).get(0).get("reas_cn_s"));}
					}
	   			}
	   		}
	   		if (entityList != null) {
	   			for (int i = 0; i < entityList.size(); i++) {
	   				list.add(entityList.get(i));
	   			}
	   		}
		}else if(m == 0 && n == 1){

			List<Map<String,Object>> entityList = service.appearance1(filter, page);
	   		List<Map<String,Object>> entityList2 = service.xrayance1(filter, page);
	   		entityList.addAll(entityList2);
	   		System.out.println(entityList);
	   		if (entityList != null) {
	   			for (int i = 0; i < entityList.size(); i++) {
	   				if(entityList.get(i).get("gradecd_s")!=null&&entityList.get(i).get("gradecd_s")!=null){
	   					entityList.get(i).put("gradecd_s", exportCombox.getDictname(entityList.get(i).get("gradecd_s").toString()));
	   				}
//	   				if(entityList.get(i).get("proess_s")!=null&&entityList.get(i).get("proess_s")!=null){
//	   					entityList.get(i).put("proess_s", exportCombox.getDictname(entityList.get(i).get("proess_s").toString()));
//	   				}
	   				if(entityList.get(i).get("proess_s")==null){
	   					//System.out.println(entityList.get(i).get("proess_s"));
	   					entityList.get(i).put("proess_s", "x光病象");
	   					//entityList.get(i).put("reascd_s", service.searchUsercode(entityList.get(i).get("reascd_s").toString()).get(0).get("reas_cn_s"));
	   				}else{
	   					//System.out.println(entityList.get(i).get("proess_s"));
	   					entityList.get(i).put("proess_s", "外观病象");
	   				}
	   				if(entityList.get(i).get("reascd_s")!=null&&entityList.get(i).get("reascd_s")!=""){
					    //entityList.get(i).put("reascd_s", service.searchUsercode(entityList.get(i).get("reascd_s").toString()).get(0).get("reas_cn_s"));
	   					String str =(String) entityList.get(i).get("reascd_s");
	   					if(str.charAt(0)=='0')
	   					{
	   						continue;
	   					}
	   					if(Character.isDigit(str.charAt(0)) ){
					    entityList.get(i).put("reascd_s", service.searchUsercode(entityList.get(i).get("reascd_s").toString()).get(0).get("reas_cn_s"));}
					}
	   			}
	   		}
	   		if (entityList != null) {
	   			for (int i = 0; i < entityList.size(); i++) {
	   				list.add(entityList.get(i));
	   			}
	   		}
		
		}
   		
   		
   		
//   		if (entityList2 != null) {
//   			for (int i = 0; i < entityList2.size(); i++) {
//   				if(entityList2.get(i).get("gradecd_s")!=null&&entityList2.get(i).get("gradecd_s")!=null){
//   					entityList2.get(i).put("gradecd_s", exportCombox.getDictname(entityList2.get(i).get("gradecd_s").toString()));
//   				}
//   				if(entityList2.get(i).get("proess_s").toString().equals("252008")){
//   					entityList2.get(i).put("proess_s", "外观病象");
//   				}else{
//   					entityList2.get(i).put("proess_s", "x光病象");
//   				}
//   				if(entityList2.get(i).get("reascd_s")!=null&&entityList2.get(i).get("reascd_s")!=""){
//				    entityList2.get(i).put("reascd_s", service.searchUsercode(entityList2.get(i).get("reascd_s").toString()).get(0).get("reas_cn_s"));
//				}
//   			}
//   		}
//   		if (entityList2 != null) {
//   			for (int i = 0; i < entityList2.size(); i++) {
//   				list.add(entityList2.get(i));
//   			}
//   		}
   		
   		return list;
   	}
    @Override
    public void regFormatter() {
    
       
        
    }

}
