/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.FeedSwitchServiceImpl;

/**
 * 密炼投料防错管控
 * @author 王超
 * @Date 2020-08-08 10:22:36
 */
@Log(code="密炼投料防错管控",value="密炼投料防错管控")
@RestController
@RequestMapping("mix/baseData/feedSwitch")
public class FeedSwitchController extends RockWellFunctionalUDAController<Object> {
    
    @Resource FeedSwitchServiceImpl feedswitchSrv;

    @Override
    protected RockWellBaseServiceImpl<Object> getService() {
        return feedswitchSrv;
    }
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return feedswitchSrv;
	}
    
    /**
	 * 控制开关
	 * @param openOrclose
	 * @return
	 * @throws Exception
	 */
    @Log(code = "密炼投料防错管控开关控制", value = "密炼投料防错管控开关控制")
	@RequestMapping("openOrclose")
	public Response openOrclose(@RequestBody Map<String, Object> updated)throws Exception {
		List<String> list = feedswitchSrv.openOrclose(updated);
		if (list.size() != 0) {
			return Response.error(Response.SYS_EXCEPTION, list+"已经是当前状态","error");
		}
		return Response.suc();
	}
	
	/**
	 * 获取物料组信息
	 * @param openOrclose
	 * @return
	 * @throws Exception
	 */
    @Log(code = "密炼投料防错管控选择行获取物料组信息", value = "密炼投料防错管控选择行获取物料组信息")
	@RequestMapping("getGroupName")
    public String getGroupName(String equip_code_s, String mater_type_s) throws Exception {
		List<Map<String, Object>> list = feedswitchSrv.getGroupName(equip_code_s, mater_type_s);
        return toJson(list);
    }
    
	/**
	 * 下发
	 * @param openOrclose
	 * @return
	 * @throws Exception
	 */
    @Log(code = "密炼投料防错管控重新下发", value = "密炼投料防错管控重新下发")
	@RequestMapping("downward")
    public Response downward(String recipecodelist[]) throws Exception {
        return Response.suc(feedswitchSrv.downward(recipecodelist));
    }
    
    @Log(code="密炼投料防错管控_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        feedswitchSrv.saveChanges(rockWellEntityDTO);
        return Response.suc();
    }
    
    @Log(code = "密炼投料防错管控", value = "信息列表查询")
	@RequestMapping("datagrid")
	public String datagrid(Filter filter, Page page) throws Exception {    	
    	Map map = feedswitchSrv.datagridUDA(filter, page);
		return toJson(map);
	}
    
    /**
	 * 获取机台信息
	 * @param openOrclose
	 * @return
	 * @throws Exception
	 */
    @Log(code = "密炼投料防错管控获取机台信息", value = "密炼投料防错管控获取机台信")
	@RequestMapping("getfeedswitchequipall")
    public String getfeedswitchequipall() throws Exception {
		List<Map<String, Object>> list = feedswitchSrv.getfeedswitchequipall();
        return toJson(list);
    }
    
    /**
	 * 获取数据字典名称
	 * @param erpcodestring
	 * @return
	 * @throws Exception
	 */
    @Log(code = "获取数据字典名称", value = "获取数据字典名称")
	@RequestMapping("getDictName")
    public String getDictName(String erpcodestring) throws Exception {
    	List<Map<String, Object>> list = feedswitchSrv.getDictName(erpcodestring);
    	return toJson(list);
    }
    
    /**
	 * 获取物料组列表
	 * @param sparestring
	 * @return
	 * @throws Exception
	 */
    @Log(code = "获取数据字典名称", value = "获取数据字典名称")
	@RequestMapping("getMaterialGroupBySpare")
    public String getMaterialGroupBySpare(String sparestring) throws Exception {
    	List<Map<String, Object>> list = feedswitchSrv.getMaterialGroupBySpare(sparestring);
    	return toJson(list);
    }

}
