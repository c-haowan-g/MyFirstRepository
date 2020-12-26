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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.Wmsoutstore;
import com.bluebirdme.mes.linglong.building.service.WmsoutstoreServiceImpl;

/**
 * 胎胚出库实绩表
 * @author 王海霖
 * @Date 2019-01-14 15:53:15
 */
@Log(code="胎胚出库实绩表",value="胎胚出库实绩表")
@RestController
@RequestMapping("building/stockmanagement/wmsoutstore")
public class WmsoutstoreController extends RockWellFunctionalUDAController<Object> {
    
    @Resource WmsoutstoreServiceImpl wmsoutstoreSrv;


    
    @Log(code="胎胚出库实绩表_SEARCH",value="数据查询",target=LogType.CONSOLE)
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
        return GsonTools.toJson(wmsoutstoreSrv.datagridUDA(filter, page));
    }



	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return wmsoutstoreSrv;
	}



	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return wmsoutstoreSrv;
	}
}
