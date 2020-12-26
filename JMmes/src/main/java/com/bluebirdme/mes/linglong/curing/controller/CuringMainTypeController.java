/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CuringMainTypeServiceImpl;

/**
 * 硫化与成型轮胎主表
 * @author 李迺锟
 * @Date 2019-08-05 15:01:32
 */
@Log(code="硫化与成型轮胎主表",value="硫化与成型轮胎主表")
@RestController
@RequestMapping("curing/basedata/curingmaintype")
public class CuringMainTypeController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringMainTypeServiceImpl curingmaintypeSrv;
    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return curingmaintypeSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		// TODO Auto-generated method stub
		return curingmaintypeSrv;
	}
    
    

}
