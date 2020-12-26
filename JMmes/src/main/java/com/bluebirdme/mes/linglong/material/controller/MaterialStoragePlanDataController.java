/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.controller;

import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.material.service.MaterialStoragePlanDataServiceImpl;


/**
 * 盘库数据管理表
 * @author 李德晓
 * @Date 2020-08-11 08:41:41
 */
@Log(code="盘库数据管理表",value="盘库数据管理表")
@RestController
@RequestMapping("material/stockManagement/materialstorageplandata")
public class MaterialStoragePlanDataController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MaterialStoragePlanDataServiceImpl materialstorageplandataSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return materialstorageplandataSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return materialstorageplandataSrv;
	}
    
    @Log(code="盘库数据管理表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        materialstorageplandataSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Override
    @Log(value = "信息列表查询", code = "信息列表查询", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    
    @RequestMapping({"getJobName"})
    public String getJobName(String date) throws Exception {
      List<Map<String, Object>> getJobName = this.materialstorageplandataSrv.getJobName(date);
      return toJson(getJobName);
    }
    /*@RequestMapping({"lock"})
    public Response lock(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.lock(ids));
    }
    
    @RequestMapping({"unlock"})
    public Response unlock(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.unlock(ids));
    }
    
    @RequestMapping({"scanning"})
    public Response scanning(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.scanning(ids));
    }
    
    @RequestMapping({"deletes"})
    public Response deletes(Long[] ids) throws Exception {
      return Response.suc(this.mixstorageplandataSrv.deletes(ids));
    }*/

}
