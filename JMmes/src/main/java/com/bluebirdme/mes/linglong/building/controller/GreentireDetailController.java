/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.building.entity.GreentireDetail;
import com.bluebirdme.mes.linglong.building.service.GreentireDetailServiceImpl;

/**
 * 胎胚库存明细表
 * @author 王海霖
 * @Date 2019-01-15 15:07:25
 */
@Log(code="胎胚库存明细表",value="胎胚库存明细表")
@RestController
@RequestMapping("building/stockmanagement/greentiredetail")
public class GreentireDetailController extends RockWellFunctionalUDAController<Object> {
    
    @Resource GreentireDetailServiceImpl greentiredetailSrv;

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
    
    @Log(code="胎胚库存明细表_SEARCH",value="数据的查询",target=LogType.DB)
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
        return GsonTools.toJson(greentiredetailSrv.datagridUDA(filter, page));
    }
	
}
