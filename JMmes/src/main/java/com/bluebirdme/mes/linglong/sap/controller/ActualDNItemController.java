/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.Map;

import javax.annotation.Resource;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.sap.entity.ActualDNItem;
import com.bluebirdme.mes.linglong.sap.service.ActualDNItemServiceImpl;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemATO;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemDTO;

/**
 * 成品发货明细表
 * @author 周清玉
 * @Date 2018-12-20 11:37:17
 */
@Log(code="InvoiceEnquiry",value="发货单及发货实绩查询")
@RestController
@RequestMapping("sap/InvoiceEnquiry/Item/ActualDNItem")
public class ActualDNItemController extends RockWellFunctionalController<ActualDNItem> {
    
    @Resource ActualDNItemServiceImpl actualdnitemSrv;

    @Override
    protected RockWellBaseServiceImpl<ActualDNItem> getService() {
        return actualdnitemSrv;
    }
    
    
    
    /**
	 * 查询全部 页面初始化使用
	 * 
	 * @param filter
	 * @param page
	 * @param clazz
	 * @return
	 * @throws Exception
	 * 周清玉
	 */
	@RequestMapping("searchBy")
	public String searchByEntName(Filter filter, Page page, Class clazz)throws Exception {
		Map list = actualdnitemSrv.datagridrowTO(filter,ActualDNItemATO.class);
		return toJson(list);
	}
    
	
	@Log(code="成品发货明细表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody ActualDNItemDTO actualdnitem) throws Exception {
    	if(actualdnitemSrv.saveChanges(actualdnitem) != 1 ){
    		return Response.error(Response.SYS_EXCEPTION, "失败",actualdnitem);
    		
    	};
    	return Response.suc();
    }
}
