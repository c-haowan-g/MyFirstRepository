/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

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
import com.bluebirdme.mes.linglong.sap.service.MaterialsLogServiceImpl;

/**
 * sap物料基础数据日志
 * @author 时永良
 * @Date 2018-10-17 14:06:59
 */
@Log(code="AT_INT_SAP_MATERIALS_LOG",value="sap物料基础数据日志")
@RestController
@RequestMapping("sap/MaterialLog")
public class MaterialsLogController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialsLogServiceImpl materialslogSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialslogSrv;
    }

	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialslogSrv;
	}
    
	 /**
		 * 
		 * @Title: 页面初始化
		 * @Description: TODO(查询)
		 * @return: String 返回类型
		 * 
		 */
		@RequestMapping("getData")
		public String datagrid(Filter filter, Page page)
				throws Exception {
			return GsonTools.toJson(materialslogSrv.datagridUDA(filter, page));
		}

}
