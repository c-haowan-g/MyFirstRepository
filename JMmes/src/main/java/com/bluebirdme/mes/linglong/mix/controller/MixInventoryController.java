/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



//import com.bluebirdme.mes.linglong.mix.entity.MixInventory;
//import org.xdemo.app.xutils.ext.GsonTools;
//import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.service.MixInventoryServiceImpl;


/**
 * 密炼库存实时表
 * @author 陈国强
 * @Date 2020-08-14 09:26:09
 */
@Log(code="密炼库存实时表",value="密炼库存实时表")
@RestController
@RequestMapping("mix/storageManagement/mixInventory")
public class MixInventoryController extends RockWellFunctionalUDAController<Object> {
    
    @Resource MixInventoryServiceImpl mixinventorySrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return mixinventorySrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return mixinventorySrv;
	}
    
    @Log(code="密炼库存实时表_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
//    	 if(null!=rockWellEntityDTO.getUpdated()){
//             List<Map<String, Object>> list= rockWellEntityDTO.getUpdated();
//             for(int i=0;i<list.size();i++){
//                 //list.get(i).setState_code_s("001001");//物料状特殊放行态：合格
//                 //list.get(i).setReas_code_s("067001");//放行原因：
//             }
//         }
        mixinventorySrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    @Log(value = "密炼物料下发查询", code = "ALL", target = LogType.CONSOLE)
    @RequestMapping("datagrid2")
    public String datagrid2(Filter filter, Page page) throws Exception {
  	filter.set("s_factory_s", LLWebUtils.factory());
    	return GsonTools.toJson(getUDAService().datagridUDA(filter, page));

//        String lot_no_s = filter.get("lot_no_s");
//        if(lot_no_s!=null){
//         Filter filter1 = new Filter();
//            filter1.set("lot_no_s",lot_no_s);
//            filter1.set("s_factory_s", LLWebUtils.factory());
//            return GsonTools.toJson(mixinventorySrv.datagrid(filter1, page, MixInventory.class));
//        }
//        filter.set("s_factory_s", LLWebUtils.factory());
//
//        return GsonTools.toJson(mixinventorySrv.datagrid(filter, page, MixInventory.class));
    }

}
