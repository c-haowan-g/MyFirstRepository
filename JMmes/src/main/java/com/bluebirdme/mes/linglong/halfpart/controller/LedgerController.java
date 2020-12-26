/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import java.util.Arrays;







import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.alibaba.fastjson.JSONArray;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.LedgerServiceImpl;


/**
 * (半部件)库存台账
 * @author 栾和源
 * @Date 2020-03-05 16:11:38
 */
@Log(code="(半部件)库存台账",value="(半部件)库存台账")
@RestController
@RequestMapping("halfpart/stockmanagement/ledger")
public class LedgerController extends RockWellFunctionalUDAController<Object> {
    
    @Resource LedgerServiceImpl ledgerSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return ledgerSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return ledgerSrv;
	}
    
    
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
       //	Map<String, Object> list = getUDAService().datagridUDA(filter, page);
   		//return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
   		Map map = ledgerSrv.searchAll(filter, page);
		return toJson(map);
   	}
    
    /**
	  * 按物料编码查询
	  * @return
	 */
	@Log(code = "searchByMaterialCode", value = "按物料编码查询")
	@RequestMapping("searchByMaterialCode")
	
	public String searchByMaterialCode(Filter filter, Page page) throws Exception {
		Map map = ledgerSrv.searchByMaterialCode(filter, page);
		return toJson(map);
	}
	
	/**
	  * 按库存类型查询
	  * @return
	 */
	@Log(code = "searchByStockType", value = "按库存类型查询")
	@RequestMapping("searchByStockType")
	public String searchByStockType(Filter filter, Page page) throws Exception {
		Map map = ledgerSrv.searchByStockType(filter, page);
		return toJson(map);
	}
	@RequestMapping({"getSummaryInfo"})
	  public Response getSummaryInfo(Page page, String[] summaryCondition, String[] queryCondition) throws Exception {
	    List chooseList = Arrays.asList(summaryCondition);
	    List arrayTolist = Arrays.asList(queryCondition);
	    String listToString = arrayTolist.toString();
	    List queryList = null;
	    queryList = (List)JSONArray.parse(listToString);
	    Map queryMap = (Map)queryList.get(0);
	    return Response.suc(this.ledgerSrv.getSummaryInfo(chooseList, queryMap));
	  }

}
