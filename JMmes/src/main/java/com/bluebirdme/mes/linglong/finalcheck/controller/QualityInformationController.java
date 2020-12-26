/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.finalcheck.entity.QualityInformation;
import com.bluebirdme.mes.linglong.finalcheck.service.QualityInformationServiceImpl;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.QualityInformationATO;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.QualityInformationDTO;

/**
 * 质量汇总信息
 * @author 司乔靖
 * @Date 2019-02-10 13:58:38
 */
@Log(code="质量汇总信息",value="质量汇总信息")
@RestController
@RequestMapping("finalcheck/qualityInspectionRecord/qualityInformation")
public class QualityInformationController extends RockWellFunctionalController<QualityInformation> {
    
    @Resource QualityInformationServiceImpl qualityinformationSrv;

    @Override
    protected RockWellBaseServiceImpl<QualityInformation> getService() {
        return qualityinformationSrv;
    }
    
    
    @Log(code="质量汇总信息_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody QualityInformationDTO qualityinformation ) throws Exception {
        qualityinformationSrv.saveChanges(qualityinformation);
        return Response.suc();
    }

    @Override
   	@Log(value = "查询列表", code = "ALL", target = LogType.CONSOLE)
   	@ResponseBody
   	@RequestMapping("datagrid")
   	public String datagrid(Filter filter, Page page) throws Exception {
    	Map map=qualityinformationSrv.datagrid(filter, page, QualityInformationATO.class);
   		return toJson(map);
   	}

    
}
