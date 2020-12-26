/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.common.service.CoreDictionaryServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.sap.entity.Reservation;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.InAllocatingOutboundATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.InAllocatingOutboundDTO;
import com.bluebirdme.mes.linglong.sap.service.ActualDNItemServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.InAllocatingOutboundServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;


/**
 * 调拨出库报表
 * @author 时永良
 * @Date 2019年1月4日09:13:46
 */
@Log(code="InAllocatingOutbound",value="调拨出库报表")
@RestController
@RequestMapping("sap/inallocatingoutbound")
public class InAllocatingOutboundController extends RockWellFunctionalController<Reservation> {
    
    @Resource InAllocatingOutboundServiceImpl inallocatingoutboundSrv;
    @Resource ActualDNItemServiceImpl actualDNItemServiceImpl;
    
    @Override
    protected RockWellBaseServiceImpl<Reservation> getService() {
        return inallocatingoutboundSrv;
    }
    
    
    /**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 时永良
	 */
	@RequestMapping("searchBy")
	public String searchByEntName(Filter filter, Page page, Class clazz)throws Exception {
		String barcode_s=filter.get("barcode_s");
		Map<String, String> filterMap=filter.getFilter(); 
    	int ifBar=0;
    	for(String key:filterMap.keySet()){
    		if(key.equals("barcode_s")){
    			ifBar=1;
    			break;
    		}
    	}
    	Map map =null;
    	if(ifBar==0){
    		 map = inallocatingoutboundSrv.datagrid(filter, page, InAllocatingOutboundATO.class);
    	}else{
    		 //带有轮胎条码查询的时候
    		Filter filterKey= new Filter();
    		filterKey.set("barcode_s", barcode_s);
    		map = inallocatingoutboundSrv.datagridBar(filterKey, page, InAllocatingOutboundATO.class);
    	}
		
		List<InAllocatingOutboundATO> list =(List<InAllocatingOutboundATO>) map.get("rows");
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String,Object> Obj = new HashMap<String, Object>();
		for(int i =0;i<list.size();i++){
			Obj=MapTrunPojo.entityToMap(list.get(i));
			Obj.put("reserno_s", list.get(i).getReserno_s());
			Obj.put("order_s", list.get(i).getOrder_s());
			Obj.put("plantfrom_s", list.get(i).getPlantfrom_s());
			Obj.put("plantto_s", list.get(i).getPlantto_s());
			Obj.put("storlocfrom_s", list.get(i).getStorlocfrom_s());
			Obj.put("storlocto_s", list.get(i).getStorlocto_s());
			Obj.put("qty_s", list.get(i).getQty_s());
			Obj.put("demondsdate_s", list.get(i).getDemondsdate_s());
			if(list.get(i).getIsdeliver_s().equals("1")){
				Obj.put("isdeliver_s", "发货");
			}else if(list.get(i).getIsdeliver_s().equals("0")){
				Obj.put("isdeliver_s", "未发货");
			}
			//查询出实际发货数量
			List<Map<String,Object>> listRealityQty=inallocatingoutboundSrv.RealityQty(list.get(i).getReserno_s());
			Obj.put("realityqty_s",listRealityQty.get(0).get("REALITYQTY").toString());
			//计算出发货差异数量
			Obj.put("differenceqty_s",Integer.parseInt( list.get(i).getQty_s())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));
			listMap.add(Obj);
		}
		map.put("rows", listMap);
		return toJson(map);
	}
	/**
	 * 调拨出库（下）
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchdetial")
    public String searchdetial(Filter filter, Page page,Class clazz) throws Exception {
		Map map = inallocatingoutboundSrv.datagrid2(filter, page, InAllocatingOutboundDTO.class);
		List<InAllocatingOutboundDTO> list =(List<InAllocatingOutboundDTO>) map.get("rows");
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String,Object> Obj = new HashMap<String, Object>();
		for(int i =0;i<list.size();i++){
			Obj=MapTrunPojo.entityToMap(list.get(i));
			Obj.put("reseritem_s", list.get(i).getReseritem_s());	
			Obj.put("matcode_s", list.get(i).getMatcode_s());	
			Obj.put("qty_s", list.get(i).getQty_s());	
			Obj.put("materialdesc_s", list.get(i).getMaterialdesc_s());	
			//查询出实际发货数量
			List<Map<String,Object>> listRealityQty=inallocatingoutboundSrv.RealityQty2(list.get(i).getReserno_s(),list.get(i).getMatcode_s());
			Obj.put("realityqty_s",listRealityQty.get(0).get("REALITYQTY").toString());
			Obj.put("differenceqty_s",Integer.parseInt(list.get(i).getQty_s().toString())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));
			listMap.add(Obj);
		}
		map.put("rows", listMap);
		return toJson(map);
	}
	
	//数据导出
	@SuppressWarnings("unchecked")
	@RequestMapping("exprot")
	public String exprot(@RequestParam("snno_s")String snno_s,HttpServletRequest request,
			HttpServletResponse response,Filter filter,Page page) throws Exception{
		System.out.println(snno_s+"单号");
		filter.set("reserno_s",snno_s);
		Filter filter2=new Filter();
		filter2.set("snno_s",snno_s);
		Map mapUp = inallocatingoutboundSrv.datagrid(filter, page,InAllocatingOutboundATO.class);
		Map mapDown = inallocatingoutboundSrv.datagrid2(filter, page,InAllocatingOutboundDTO.class);
		Map mapOff = actualDNItemServiceImpl.datagridrowTO(filter2,ActualDNItemATO.class);
		
		@SuppressWarnings("unchecked")
		List<InAllocatingOutboundATO> listUp = (List<InAllocatingOutboundATO>) mapUp.get("rows");
		List<InAllocatingOutboundDTO> listDown = (List<InAllocatingOutboundDTO>) mapDown.get("rows");
		List<ActualDNItemATO> listOff = (List<ActualDNItemATO>) mapOff.get("rows");
		
		//将数据字典编码转换为名称
//		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		CoreDictionaryServiceImpl coredictionary = (CoreDictionaryServiceImpl) SpringContext.getBean("coreDictionaryServiceImpl");

 		Map<String,Object> map =coredictionary.keyValuePair("253");
		// 转换下拉框
		for (int i = 0; i < listOff.size(); i++) {
			listOff.get(i).setGradecode_s(map.get(listOff.get(i).getGradecode_s()).toString());
		}
		
//		System.out.println(listUp.size());
//		System.out.println(listDown.size());
//		System.out.println(listOff.size());
		inallocatingoutboundSrv.exportService(snno_s, request, response,listUp,listDown,listOff);
		return null;
	}
	
}
