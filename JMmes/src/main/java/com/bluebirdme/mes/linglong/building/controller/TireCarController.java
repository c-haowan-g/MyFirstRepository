/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.TireCar;
import com.bluebirdme.mes.linglong.building.service.TireCarServiceImpl;

/**
 * 成型胎胚车维护表
 * @author wanghailin
 * @Date 2019-03-02 11:06:03
 */
@Log(code="AT_B_BM_TIRECAR",value="胎胚车信息维护")
@RestController
@RequestMapping("building/basedata/checktirecar")
public class TireCarController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TireCarServiceImpl tirecarSrv;

    @Override
  	@Log(value = "胎胚车查询", code = "tirecardatagrid", target = LogType.CONSOLE)
  	@ResponseBody
  	@RequestMapping("datagrid")
  	public String datagrid(Filter filter, Page page) throws Exception {
    	if(filter.get("tire_shelf_code_s")!=null&&filter.get("tire_shelf_code_s")!=""){
    		filter.getFilter().remove("start_time");
    		filter.getFilter().remove("end_time");
    	}
  		return GsonTools.toJson(tirecarSrv.datagridUDA(filter, page));
  	}
    @Log(code="AT_B_BM_TIRECAR_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        return Response.suc(tirecarSrv.saveChanges(rockWellEntityDTO));
    }
	@RequestMapping("searchBy")//这个方法是跟高飞封装的方法一样的
	public String searchByEntName(Filter filter, Page page)throws Exception {
		if(filter.get("tire_shelf_code_s")!=null&&filter.get("tire_shelf_code_s")!=""){
    		filter.getFilter().remove("start_time");
    		filter.getFilter().remove("end_time");
    	}
  		return GsonTools.toJson(tirecarSrv.datagridUDA(filter, page));
	}
	
	/**
	 * 胎胚编码数据的查询
	 * 
	 * @return
	 */
	@RequestMapping("searchByTireCarCode")
	public String searchByTireCarCode() {
		List<String> list = tirecarSrv.searchByTireCarCode();
		return toJson(list);
	}
	
	/**
	 * 批量导入胎胚编码
	 * @return 
	 * @Title: CheckDayPlan
	 * @Description: TODO(描述)
	 * @return: String 返回类型
	 * 
	 */
	@RequestMapping("BatchAdd")
	public Response BatchAdd(Integer startCode,Integer loadNum,int batchNum) throws Exception {
		//System.out.print("開始調用");
		return Response.suc(tirecarSrv.BatchAdd(startCode,loadNum,batchNum));
	}
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return tirecarSrv;
	}
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		// TODO Auto-generated method stub
		return tirecarSrv;
	}
}
