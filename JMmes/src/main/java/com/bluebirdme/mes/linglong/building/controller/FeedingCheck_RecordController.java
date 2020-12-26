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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.service.FeedingCheck_RecordServiceImpl;

/**
 * 投料扫描及校验表
 * @author 司乔靖
 * @Date 2019-02-16 08:53:13
 */
@Log(code="投料扫描及校验表",value="投料扫描及校验表")
@RestController
@RequestMapping("building/productionManagement/feedingCheck_Record")
public class FeedingCheck_RecordController extends RockWellFunctionalUDAController<Object> {
    
    @Resource FeedingCheck_RecordServiceImpl feedingcheck_recordSrv;

    
    @Log(code="投料扫描及校验表_FIND",value="find",target=LogType.DB)
    @RequestMapping("datagrid")
    public String datagrid(Filter filter, Page page) throws Exception {
        return GsonTools.toJson(feedingcheck_recordSrv.datagridUDA(filter, page));
    }


	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return feedingcheck_recordSrv;
	}


	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return feedingcheck_recordSrv;
	}

}
