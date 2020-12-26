/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.controller;

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
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.test.entity.Foo;
import com.bluebirdme.mes.linglong.test.service.FooServiceImpl;
import com.bluebirdme.mes.linglong.test.entity.dto.FooDTO;

/**
 * FFFF
 * @author 高飞
 * @Date 2018-08-23 14:27:23
 */
@Log(code="FDSA",value="FDSDFDS")
@RestController
@RequestMapping("/DADFDS")
public class FooController extends RockWellFunctionalController<Foo> {
    
    @Resource FooServiceImpl fooSrv;

    @Override
    protected RockWellBaseServiceImpl<Foo> getService() {
        return fooSrv;
    }
    
    
    @Log(code="FDSA_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody FooDTO foo ) throws Exception{
        fooSrv.saveChanges(foo);
        return Response.suc();
    }

}
