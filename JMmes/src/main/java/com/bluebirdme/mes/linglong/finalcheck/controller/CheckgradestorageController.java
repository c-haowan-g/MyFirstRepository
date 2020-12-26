/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.finalcheck.service.CheckgradestorageServiceImpl;


/**
 * 机检废次品入库确认表
 * @author 徐秉正
 * @Date 2020-09-02 15:37:03
 */
@Log(code="Checkgradestorage",value="机检废次品入库确认")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/checkgradegradestorage/checkgradegradestorage")
public class CheckgradestorageController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CheckgradestorageServiceImpl checkgradestorageSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return checkgradestorageSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return checkgradestorageSrv;
	}
    
    
    /**
	 * 按汇总查询
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 徐秉正
	 */
	@Log(code = "checkgradestorage", value = "查询汇总初始化使用")
	@RequestMapping("searchInit2")
	public String searchInit2(Filter filter, Page page) throws Exception {
		Map map = checkgradestorageSrv.searchsum(filter, page);
		return toJson(map);
	}
	
	 /**
		 * 按详细查询
		 * @param filter
		 * @param page
		 * @param clazz
		 * @return
		 * @throws Exception
		 * 徐秉正
		 */
		@Log(code = "checkgradestorage", value = "查询汇总初始化使用")
		@RequestMapping("searchInit3")
		public String searchInit3(Filter filter, Page page) throws Exception {
			Map map = checkgradestorageSrv.searchall(filter, page);
			return toJson(map);
		}
    
//    @Log(code="Checkgradestorage_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
//    @RequestMapping("saveChanges")
//    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
//        checkgradestorageSrv.saveChanges(rockWellEntityDTO);
//        return Response.suc();
//    }

}
