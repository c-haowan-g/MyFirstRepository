/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.excel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.DefaultExcelExportHandler;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.service.MainTyreServiceImpl;

/**
 * 导出处理器
 * @author 硫化外观合格率报表 周清玉
 * @Date 2018年7月13日 下午2:30:34
 */
public class CuringAndApperanceQualificationExportHandler extends DefaultExcelExportHandler {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    MainTyreServiceImpl service = (MainTyreServiceImpl) SpringContext.getBean(StringUtils.firstCharToLowerCase("MainTyreServiceImpl"));
  
    @Override
    public void regFormatter() {
    }

	@Override
   	public List<Object> getRows(Filter filter, Page page, String serviceName)
   			throws Exception {
    	List<Object> list = new ArrayList<Object>();
    	filter.set("s_factory_s", LLWebUtils.factory());
    	filter.set("agenc_no_s", FactoryConstant.JING_MEN_CODE);
    	List<Map<String, Object>> entityList = service.datagridCuringAndAppearanceRows(filter, page);
   		
   		if (entityList != null) {
   			for (int i = 0; i < entityList.size(); i++) {
   				if(entityList.get(i).get("appearancecheckoutputcount").equals("0")){
   					entityList.get(i).put("appearancecheckoutputcount", "100%");
   				}else{
   					float one = 0;float two = 0;float three = 0;
   					if(entityList.get(i).get("appearancecheckoutputcount") != null){
   						one = Integer.valueOf(entityList.get(i).get("appearancecheckoutputcount").toString());
   						three = Integer.valueOf(entityList.get(i).get("appearancecheckoutputcount").toString());
   					}
   					if(entityList.get(i).get("failcount") != null){
   						two =Integer.valueOf(entityList.get(i).get("failcount").toString());
   					}
   					
   					String four = (one-two)/three*100 + "%";
   					
   					Map< String, Object> map = new HashMap<String, Object>();
   					map.put("curingmachinecode_s", entityList.get(i).get("curingmachinecode_s"));
   					map.put("materialcode_s", entityList.get(i).get("materialcode_s"));
   					map.put("materialdesc_s", entityList.get(i).get("materialdesc_s"));
   					map.put("curingoutputcount", entityList.get(i).get("curingoutputcount"));
   					map.put("appearancecheckoutputcount", entityList.get(i).get("appearancecheckoutputcount"));
   					map.put("failcount", entityList.get(i).get("failcount"));
   					map.put("failurerate", four);
   					//将map转为实体
   					list.add(map);
   				}
   			}
   		}
		return list;
   	}
}
