/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.controller;

import javax.annotation.Resource;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;

import com.bluebirdme.mes.linglong.sap.entity.Vendor;
import com.bluebirdme.mes.linglong.sap.service.VendorServiceImpl;

import com.bluebirdme.mes.linglong.sap.entity.dto.VendorDTO;

/**
 * 供应商信息表
 * @author 李迺锟
 * @Date 2018-09-25 10:28:55
 */
@Log(code="Vendor",value="Vendor")
@RestController
@RequestMapping("common/Vendor")
public class VendorController extends RockWellFunctionalController<Vendor> {
    
    @Resource VendorServiceImpl vendorSrv;

    @Override
    protected RockWellBaseServiceImpl<Vendor> getService() {
        return vendorSrv;
    }
    
    
    @Log(code="Vendor_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody VendorDTO vendor ) throws Exception {
        vendorSrv.saveChanges(vendor);
        return Response.suc();
    }

}
