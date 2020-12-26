/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.List;
import java.util.Map;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.halfpart.service.PlateInfoServiceImpl;



/**
 * 半部件口型板信息
 * @author 栾和源
 * @Date 2020-01-22 08:00:37
 */
@Log(code="plateinfo",value="palteinfo")
@RestController
@RequestMapping("/halfpart/plateinfo")
public class PlateInfoController extends RockWellFunctionalUDAController<Object> {
    
    @Resource PlateInfoServiceImpl plateinfoSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return plateinfoSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return plateinfoSrv;
	}
    
    
    @Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {
    	Map<String, Object> list = getUDAService().datagridUDA(filter, page);
		return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
	}
    
    
    
    @Log(code="plateinfo_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        plateinfoSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    
    
    /**
	  * 查出口型板编码和RFID码显示在JSP页面下拉列表处
	  * @return
	 */
	@Log(code = "searchDescription", value = "查出口型板编码和RFID码显示在JSP页面下拉列表处")
	@RequestMapping("searchDescription")
	public String searchDescription() throws Exception {
		System.out.println("1");
		List<Map<String, Object>> list = plateinfoSrv.searchDescription();
		return toJson(list);
	}

    
    
    
    
    
}
