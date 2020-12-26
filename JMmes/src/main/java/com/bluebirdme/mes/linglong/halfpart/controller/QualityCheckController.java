/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.QualityCheckServiceImpl;


/**
 * 质检检测履历
 * @author 葛迎祥
 * @Date 2020-06-29 15:52:31
 */
@Log(code="AT_A_QM_QUALITYCHECK",value="AT_A_QM_QUALITYCHECK")
@RestController
@RequestMapping("halfpart/productionManagement/qualitycheck")
public class QualityCheckController extends RockWellFunctionalUDAController<Object> {
    
    @Resource QualityCheckServiceImpl qualitycheckSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return qualitycheckSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return qualitycheckSrv;
	}
    
    @Log(code = "AT_A_QM_QUALITYCHECK", value = "查询全部页面初始化使用")
	@RequestMapping("datagridUDA")
	public String datagridUDA(Filter filter, Page page) throws Exception {
    	Map map = new HashMap();
    	map = qualitycheckSrv.datagridUDA(filter, page);
    	return toJson(map);
	}
    
    // 查询不合格原因显示在下拉列表处
    @Log(code="searchPoint",value="查询不合格原因显示在下拉列表处")
    @RequestMapping("searchPoint")
    public String searchHalfpartType() throws Exception {
    	List<Map<String, Object>> map = qualitycheckSrv.searchPoint();
        return toJson(qualitycheckSrv.searchPoint());
    }

}
