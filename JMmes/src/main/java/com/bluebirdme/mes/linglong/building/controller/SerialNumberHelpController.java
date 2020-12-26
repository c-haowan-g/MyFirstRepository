/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.building.entity.SerialNumberHelp;
import com.bluebirdme.mes.linglong.building.service.SerialNumberHelpServiceImpl;
import com.bluebirdme.mes.linglong.building.entity.dto.SerialNumberHelpATO;
import com.bluebirdme.mes.linglong.building.entity.dto.SerialNumberHelpDTO;

/**
 * UNIT序列号帮助
 * @author 时永良
 * @Date 2019-07-12 13:12:11
 */
@Log(code="building/test/unit",value="UNIT序列号帮助")
@RestController
@RequestMapping("building/test/unit")
public class SerialNumberHelpController extends RockWellFunctionalController<SerialNumberHelp> {
    
    @Resource SerialNumberHelpServiceImpl serialnumberhelpSrv;

    @Override
    protected RockWellBaseServiceImpl<SerialNumberHelp> getService() {
        return serialnumberhelpSrv;
    }
    
    /**
	 * 查询备模履历（初始化）
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("searchBy")
	public String searchBy(Filter filter, Page page, Class clazz)throws Exception {
		Map list = serialnumberhelpSrv.datagrid(filter, page, SerialNumberHelpATO.class);
		return toJson(list);
	}
	
    @Log(code="building/test/unit_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody SerialNumberHelpDTO serialnumberhelp ) throws Exception {
    	if(serialnumberhelpSrv.saveChanges(serialnumberhelp)==0){
    		return Response.error(Response.SYS_EXCEPTION, "代码重复",null);
    	}
        return Response.suc("ok");
    }

}
