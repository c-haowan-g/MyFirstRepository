/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.service.GreenTireCodePrestoreServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.GreenTireCodePrestore;

/**
 * 胎胚条码预存表
 * @author 王海霖
 * @Date 2019-08-28 12:45:58
 */
@Log(code="AT_B_MM_GREENTIREPRESTORE_LOG",value="胎胚条码预先导入")
@RestController
@RequestMapping("building/basedata/greentirecodeprestore")
public class GreenTireCodePrestoreController extends RockWellFunctionalUDAController<Object> {
    
    @Resource GreenTireCodePrestoreServiceImpl greentirecodeprestoreSrv;
    
    @Override
  	@Log(value = "胎胚车条码查询", code = "greentirecodeprestoredatagrid", target = LogType.CONSOLE)
  	@ResponseBody
  	@RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page) throws Exception {
    	boolean panduan=false;
    	if(filter.get("barcode_s")!=null&&filter.get("barcode_s")!=""){
    		panduan=true;
    	}
    	if(filter.get("status_s")!=null&&filter.get("status_s")!=""){
    		panduan=true;
    	}
    	if(panduan==true){
    		filter.getFilter().remove("start_time");
    		filter.getFilter().remove("end_time");
    	}
  		return GsonTools.toJson(greentirecodeprestoreSrv.datagridUDA(filter, page));
  	}
    
    
   
    
    @Log(code="AT_B_MM_GREENTIREPRESTORE_LOG_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	 String result= greentirecodeprestoreSrv.saveChanges(rockWellEntityDTO);
    	 return Response.suc(result);
    }
	/**
	 * 批量导入胎胚编码
	 * @return 
	 * @Title: CheckDayPlan
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("BatchAdd")
	public Response BatchAdd(String equipCode,String greenTireCode,int batchNum) throws Exception {
		return Response.suc(greentirecodeprestoreSrv.BatchAdd(equipCode,greenTireCode,batchNum));
	}
	
  /**	
   * 获取数据库内胎胚编码的最大值
   * 王海霖-2019/08/28
   *
   */
	@RequestMapping("getMaxBarcode")
	public String getMaxBarcode() throws Exception{
		return  toJson(greentirecodeprestoreSrv.getMaxBarcode());
	}

	/**
	 * 批量更新
	 * @param equipCode
	 * @param greenTireCode
	 * @param batchNum
	 * @return
	 * @throws Exception
	 * @author 刘程明
	 * @date 2019年4月24日
	 */
	@RequestMapping("BatchEdit")
	public Response BatchEdit(String equipCode,String greenTireCode,String greenTireCodeEnd,int batchNum) throws Exception {
		return Response.suc(greentirecodeprestoreSrv.BatchEdit(equipCode,greenTireCode,greenTireCodeEnd,batchNum));
	}









	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return greentirecodeprestoreSrv;
	}




	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return greentirecodeprestoreSrv;
	}
}
