/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

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
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.service.TyreReasAlermMaintainServiceImpl;

/**
 * 外观检测后工序报警病象计数配置表
 * @author 司乔靖
 * @Date 2019-05-20 11:10:40
 */
@Log(code="finalcheck/baseData/ReasAlermMaintain",value="finalcheck/baseData/ReasAlermMaintain")
@RestController
@RequestMapping("finalcheck/baseData/ReasAlermMaintain")
public class TyreReasAlermMaintainController extends RockWellFunctionalUDAController<Object> {
    
    @Resource TyreReasAlermMaintainServiceImpl tyrereasalermmaintainSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return tyrereasalermmaintainSrv;
    }
    
    
    @Log(code="finalcheck/baseData/ReasAlermMaintain_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
    	//tyrereasalermmaintainSrv.saveChanges(rockWellEntityDTO);
		if (tyrereasalermmaintainSrv.saveChanges(rockWellEntityDTO) == -1) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复", rockWellEntityDTO);
		}
        return Response.suc();
    }
    
 
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return tyrereasalermmaintainSrv;
	}
    /**
     * @return string
     * @Description: 返回数据表格数据
     * @author 王海霖
     */
    @Log(code="获取病象数据",value="查询数据",target=LogType.CONSOLE)
    @RequestMapping("getReasByCode")
    public String getReasByCode()throws Exception{
    	return GsonTools.toJson(tyrereasalermmaintainSrv.getReasByCode());
    }
    
    /**
     * datagrid 数据查询
     * @return string
     * @Description: 返回数据表格数据
     * @author 王海霖
     */
    @Log(code="datagrid数据查询",value="查询数据",target=LogType.CONSOLE)
    @RequestMapping("datagrid_min")
    public String datagrid(Filter filter, Page page)throws Exception{
    	//return GsonTools.toJson(tyrereasalermmaintainSrv.datagrid(filter,page, TyreReasAlerMaintainATO.class));
    	return GsonTools.toJson(getUDAService().datagridUDA(filter, page));
    }
    
//    @RequestMapping("CheckMoldCode")
//	public String CheckMoldCode(String mold_code) throws Exception {
//		int data = tyrereasalermmaintainSrv.CheckMoldCode(mold_code);
//		return toJson(data);
//	}
}
