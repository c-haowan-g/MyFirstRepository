/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;














import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.CarWash;
import com.bluebirdme.mes.linglong.common.service.CarWashServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;


/**
 * PLM密炼配方洗车规则表
 * @author 陈国强
 * @Date 2020-09-07 16:14:36
 */
@Log(code="CarWash_Log",value="洗车日志")
@RestController
@RequestMapping("common/plm/CarWash")
public class CarWashController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CarWashServiceImpl carwashSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return carwashSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return carwashSrv;
	}
    
    @Log(code="CarWash_Log_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
    	      
    	      for (int i = 0; i <  rockWellEntityDTO.getInserted().size(); i++) {
    	    	  CarWash carwash =(CarWash) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), CarWash.class);
    	        int carwash_num_i = null == carwash.getCarwash_num_i() ? 0 : carwash.getCarwash_num_i().intValue();
    	        
    	        if ((!"0".equals(carwash.getSign_s())) && (!"".equals(carwash.getSign_s())) && 
    	          (carwash_num_i < 2)) {
    	          return Response.error("1", "有洗车要求时，洗车次数不能小于2", "");
    	        }

    	        
    	      }
    	    }
    	    if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
    	      
    	      for (int j = 0; j < rockWellEntityDTO.getUpdated().size(); j++) {
    	    	  CarWash carwash=(CarWash) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(j), CarWash.class);
    	        int carwash_num_i = null == carwash.getCarwash_num_i() ? 0 : carwash.getCarwash_num_i().intValue();
    	       
    	        if ((!"0".equals(carwash.getSign_s())) && (!"".equals(carwash.getSign_s())) && 
    	          (carwash_num_i < 2)) {
    	          return Response.error("1", "有洗车要求时，洗车次数不能小于2", "");
    	        }

    	       
    	      }
    	    }

    	    
        carwashSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(value="信息列表查询", code="FUNC_007", target=LogType.CONSOLE)
    @ResponseBody
    @RequestMapping({"datagrid"})
    public String datagrid(Filter filter, Page page) throws Exception {
      Map map = getService().datagrid(filter, page, CarWash.class);
      return GsonTools.toJson(map);
    }
    @RequestMapping({"getRecipeInfo"})
    public String getRecipeInfo() throws Exception
    {
      List list = this.carwashSrv.getRecipeInfo();
      return toJson(list);
    }

    @RequestMapping({"getWashRecipeInfo"})
    public String getWashRecipeInfo(String mater_type_s, String recipe_code_s) throws Exception {
      List list = this.carwashSrv.getWashRecipeInfo(mater_type_s, recipe_code_s);
      return toJson(list);
    }

}
