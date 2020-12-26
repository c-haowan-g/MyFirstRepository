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
import com.bluebirdme.mes.linglong.common.service.ExportServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.sap.entity.PlandnHeader;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.PlandnHeaderATO;
import com.bluebirdme.mes.linglong.sap.service.ActualAmountHeaderServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.ActualDNHeaderServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.ActualDNItemServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.ActualamountItemServiceImpl;
import com.bluebirdme.mes.linglong.sap.service.PlandnHeaderServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;


/**
 * 发货单及发货实绩查询
 * @author 周清玉
 * @Date 2018-12-12 11:55:10
 */
@Log(code="InvoiceEnquiry",value="发货单及发货实绩查询")
@RestController
@RequestMapping("sap/InvoiceEnquiry")
public class PlandnHeaderController extends RockWellFunctionalController<PlandnHeader> {
    
    @Resource PlandnHeaderServiceImpl plandhheeaderSrv;
    @Resource ActualDNHeaderServiceImpl actualDNHeaderServiceImpl;
    @Resource ActualDNItemServiceImpl actualDNItemServiceImpl;
    
    @Resource ActualAmountHeaderServiceImpl actualAmountHeaderServiceImpl;
    @Resource ActualamountItemServiceImpl actualamountItemServiceImpl;
   

    @Override
    protected RockWellBaseServiceImpl<PlandnHeader> getService() {
        return plandhheeaderSrv;
    }
    
    
    
    @RequestMapping("searchdetial")
    public String searchdetial(Filter filter, Page page,Class clazz) throws Exception {
    	Map map = plandhheeaderSrv.datagrid2(filter, page,PlandnHeaderATO.class);
    	List<PlandnHeaderATO> list =(List<PlandnHeaderATO>) map.get("rows");
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String,Object> Obj = new HashMap<String, Object>();
		for(int i =0;i<list.size();i++){
			Obj=MapTrunPojo.entityToMap(list.get(i));
			Obj.put("lineitemno_s", list.get(i).getLineitemno_s());
			Obj.put("materialcode_s", list.get(i).getMaterialcode_s());
			Obj.put("qty_s", list.get(i).getQty_s());	
			Obj.put("batch_s", list.get(i).getBatch_s());	
			//查询出实际发货数量
			List<Map<String,Object>> listRealityQty=plandhheeaderSrv.RealityQty2(list.get(i).getSnno_s(),list.get(i).getMaterialcode_s());
			Obj.put("realityqty_s",listRealityQty.get(0).get("REALITYQTY").toString());
			Obj.put("differenceqty_s",Integer.parseInt(list.get(i).getQty_s().toString())-Integer.parseInt(listRealityQty.get(0).get("REALITYQTY").toString()));
			listMap.add(Obj);
		}
		map.put("rows", listMap);
        return toJson(map);
    }
    
    /**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 周清玉
	 */
    @Log(code="searchBy",value="查询全部 页面初始化使用")
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
    		 map = plandhheeaderSrv.datagrid(filter, page,clazz);
    	}else{
    		 //带有轮胎条码查询的时候
    		 Filter filterKey= new Filter();
    		 filterKey.set("barcode_s", barcode_s);
    		 map = plandhheeaderSrv.datagridBar(filterKey, page,clazz);
    	}
		List<PlandnHeader> list =(List<PlandnHeader>) map.get("rows");
		List<Map<String, Object>> listMap = new ArrayList<>();
		Map<String,Object> Obj = new HashMap<String, Object>();
		for(int i =0;i<list.size();i++){
			Obj=MapTrunPojo.entityToMap(list.get(i));
			Obj.put("snno_s", list.get(i).getSnno_s());
			Obj.put("docdate_s", list.get(i).getDocdate_s());
			Obj.put("customerid_s", list.get(i).getCustomerid_s());
			///根据ID号查询客户名称等
			List<Map<String,Object>> listQueryCustomename =plandhheeaderSrv.queryCustomename(list.get(i).getCustomerid_s());
			String customename =listQueryCustomename.get(0).get("CUSTOMENAME_S").toString();
			Obj.put("customename_s", customename);
			//查看当前发货单状态
			String	dummy1= list.get(i).getDummy3_s();
			if(dummy1==null){
			  dummy1="1";
			}
			switch(dummy1){
				case "1": 
					Obj.put("obj", "接受");
					break;
				case "2": 
					Obj.put("obj", "执行");
					break;
				case "3": 
					Obj.put("obj", "关闭");
					break;
			}
			//查询出预计发货数量
			List<Map<String,Object>> a= plandhheeaderSrv.a(list.get(i).getSnno_s());
			List<Map<String,Object>> listSumQty=new ArrayList<>();
			listSumQty=plandhheeaderSrv.SumQty(a.get(0).get("ATR_KEY").toString());
			if(listSumQty.get(0).get("QTY_S")!=null&&listSumQty.get(0).get("QTY_S")!=""){
				Obj.put("sumqty_s", listSumQty.get(0).get("QTY_S").toString());
			}else{
				Obj.put("sumqty_s", 0);
			}
			
			//查询出实际发货数量
			List<Map<String,Object>> listRealityQty=plandhheeaderSrv.RealityQty(list.get(i).getSnno_s());
			if(listRealityQty.get(0).get("REALITYQTY")!=null&&listRealityQty.get(0).get("REALITYQTY")!=""){
				Obj.put("realityqty_s", listRealityQty.get(0).get("REALITYQTY").toString());
			}else{
				Obj.put("realityqty_s", 0);
			}
			
			//计算出发货差异数量
			String QTY_SDummy="0";
			String REALITYQTY_SDummy="0";
			if(listSumQty.get(0).get("QTY_S")!=null&&listSumQty.get(0).get("QTY_S")!=""){
				QTY_SDummy=listSumQty.get(0).get("QTY_S").toString();
			}
			if(listRealityQty.get(0).get("REALITYQTY")!=null&&listRealityQty.get(0).get("REALITYQTY")!=""){
				REALITYQTY_SDummy=listRealityQty.get(0).get("REALITYQTY").toString();
			}
			Obj.put("differenceqty_s",Integer.parseInt(QTY_SDummy)-Integer.parseInt(REALITYQTY_SDummy));
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
		filter.set("snno_s",snno_s);
		Map mapUp = plandhheeaderSrv.datagrid(filter, page,PlandnHeader.class);
		Map mapDown = plandhheeaderSrv.datagrid2(filter, page,PlandnHeaderATO.class);
		Map mapOff = actualDNItemServiceImpl.datagridrowTO(filter,ActualDNItemATO.class);
		
		@SuppressWarnings("unchecked")
		List<PlandnHeader> listUp = (List<PlandnHeader>) mapUp.get("rows");
		List<PlandnHeaderATO> listDown = (List<PlandnHeaderATO>) mapDown.get("rows");
		List<ActualDNItemATO> listOff = (List<ActualDNItemATO>) mapOff.get("rows");
		
		//将数据字典编码转换为名称
		ExportServiceImpl exportCombox = (ExportServiceImpl) SpringContext.getBean("exportServiceImpl");
		// 转换下拉框
//		for (int i = 0; i < listDown.size(); i++) {
//			listDown.get(i).setBatch_s(exportCombox.getDictname(listDown.get(i).getBatch_s()));
//		}
		for (int i = 0; i < listOff.size(); i++) {
			listOff.get(i).setGradecode_s(exportCombox.getDictname(listOff.get(i).getGradecode_s()));
		}
		
		plandhheeaderSrv.exportService(snno_s, request, response,listUp,listDown,listOff);
		return null;
	}
	
	
	/**
	 * 随车单数据消息
	 * @param snno_s 发货单号
	 * @return
	 */
	@RequestMapping("searchTheAccessoryBySonn")
	public String searchTheAccessoryBySonn(String snno_s){
		Map<String,Object> map= plandhheeaderSrv.searchTheAccessoryBySonn(snno_s);
		return toJson(map);
	}
	
	@RequestMapping("theAccessoryExportExcel")
	public String theAccessoryExportExcel(@RequestParam("snno_s")String snno_s,@RequestParam("customename_s")String customename_s, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
			
		plandhheeaderSrv.theAccessoryExportExcel(snno_s, customename_s,request, response);
		return snno_s;
	}
	
	/**
	 * 销售发货数量
	 * @param filter
	 * @return
	 */
	@RequestMapping("plandnitemColumnQty")
	public List<Map<String, Object>> plandnitemColumnQty(Filter filter){
		List<Map<String, Object>> list =plandhheeaderSrv.plandnitemColumnQty(filter);
		for(int i=0;i<list.size();i++){
			if(list.get(i).get("QTY_S")==null){
				list.get(i).put("QTY_S", 0);
			}
			if(list.get(i).get("DIFFERENCE")==null){
				list.get(i).put("DIFFERENCE", 0);
			}
		}
		return list;
	}
	/**
	 * 调拨发货数量
	 * @param filter
	 * @return
	 */
	@RequestMapping("inAllocatingColumnQty")
	public List<Map<String, Object>> inAllocatingColumnQty(Filter filter){
		List<Map<String, Object>> list = plandhheeaderSrv.inAllocatingColumnQty(filter);
		for(int i=0;i<list.size();i++){
			if(list.get(i).get("QTY_S")==null){
				list.get(i).put("QTY_S", 0);
			}
			if(list.get(i).get("DIFFERENCE")==null){
				list.get(i).put("DIFFERENCE", 0);
			}
		}
		return list;
	}
	
}
