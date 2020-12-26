/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.CuringProductionLineInfoServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;

/**
 * 硫化机台信息管理
 * @author 司乔靖
 * @Date 2019-07-13 09:55:26
 */
@Log(code="硫化机台信息管理",value="硫化机台信息管理")
@RestController
@RequestMapping("curing/baseData/curingProductionLineInfo")
public class CuringProductionLineInfoController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringProductionLineInfoServiceImpl curingproductionlineinfoSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingproductionlineinfoSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return curingproductionlineinfoSrv;
	}
    
    @Log(code="硫化机台信息管理_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody UdaDto udaDto ) throws Exception {
        curingproductionlineinfoSrv.saveChanges(udaDto);
        return Response.suc();
    }
    
    @Log(value = "UDA数据查询功能", code = "FUNC_009", target = LogType.CONSOLE)
	@RequestMapping("datagridUDA2")
	public String datagridUDA(Filter filter, Page page) throws Exception {
    	String factory=LLWebUtils.factory();
		filter.set("s_factory_s", factory);
		return GsonTools.toJson(curingproductionlineinfoSrv.datagridUDA(filter, page));
	}

	/**
	 * 机台编码重复性校验
	 * @return 标识  1不重复可添加/0已存在不可添加
	 */
	@RequestMapping("checkPLineName")
	public String checkPLineName(String plinename,String plinekey) {
		int i = curingproductionlineinfoSrv.checkPLineName(plinename,plinekey);
		return Integer.toString(i);
	}
    
	 /**
		 * 
		 * @Title: comboxProductlineEqu
		 * @Description: TODO(硫化产线下拉框)
		 * @return: String 返回类型
		 * 
		 */
		@Log(code = "comboxProductlineEqu", value = "查询硫化机产线code")
		@RequestMapping("comboxProductlineEqu")
		public String comboxProductlineEqu() throws Exception {
			String factory=LLWebUtils.factory();
			List<Map<String, Object>> list = curingproductionlineinfoSrv.getProductlineEqu(factory);
			return toJson(list);
		}
}
