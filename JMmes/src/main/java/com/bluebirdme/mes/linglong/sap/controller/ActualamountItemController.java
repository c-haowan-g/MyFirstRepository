/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.sap.entity.ActualamountItem;
import com.bluebirdme.mes.linglong.sap.service.ActualamountItemServiceImpl;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualamountItemATO;

/**
 * 实装量ITEM 
 * @author 周清玉
 * @Date 2018-12-12 13:13:46
 */
@Log(code="InvoiceEnquiry",value="发货单及发货实绩查询")
@RestController
@RequestMapping("sap/InvoiceEnquiry/Item")
public class ActualamountItemController extends RockWellFunctionalController<ActualamountItem> {
    
    @Resource ActualamountItemServiceImpl actualamountitemSrv;

    @Override
    protected RockWellBaseServiceImpl<ActualamountItem> getService() {
        return actualamountitemSrv;
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
		Map list = actualamountitemSrv.datagrid(filter, page,ActualamountItemATO.class);
		return toJson(list);
	}


}
