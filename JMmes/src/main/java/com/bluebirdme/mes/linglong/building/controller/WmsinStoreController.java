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
import com.bluebirdme.mes.linglong.building.entity.WmsinStore;
import com.bluebirdme.mes.linglong.building.service.WmsinStoreServiceImpl;
import com.google.gson.Gson;

/**
 * 胎胚入库实绩表
 * @author 王海霖
 * @Date 2019-01-12 08:51:42
 */
@Log(code="胎胚入库实绩表",value="胎胚入库实绩表")
@RestController
@RequestMapping("building/stockmanagement/wmsinstore")
public class WmsinStoreController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WmsinStoreServiceImpl wmsinstoreSrv;

  
   
    /**
     * @return string
     * @Description: 返回数据表格数据
     * @author 王海霖
     * @date 2019-1-12
     */
    @Log(code="胎胚入库实绩表_SEARCH",value="查询数据",target=LogType.CONSOLE)
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page)throws Exception{
    	return GsonTools.toJson(wmsinstoreSrv.datagridUDA(filter, page));
    }
    /**
     * @return string
     * @Description: 返回数据表格数据
     * @author 王海霖
     * @date 2019-1-12
     */
    @Log(code="获取成型机台集合",value="查询数据",target=LogType.CONSOLE)
    @RequestMapping("combox_entcode")
    public String combox_entcode()throws Exception{
    	return GsonTools.toJson(wmsinstoreSrv.getCombox_entcode());
    }
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return null;
	}
}
