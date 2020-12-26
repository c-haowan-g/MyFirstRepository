/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalController;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.Sortltem;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortltemAll;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortltemTab4;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortltemDTO;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortltemTab4DTO;
import com.bluebirdme.mes.linglong.finalcheck.service.SortltemServiceImpl;

/**
 * 分拣规则维护
 * @author lcm
 * @Date 2018-08-15 09:28:58
 */
@Log(code="ZJ_BZGL_FJGZ",value="分拣规则维护页面")
@RestController
@RequestMapping("finalcheck/reportCenter/sortltem")
public class SortltemController extends RockWellFunctionalController<Sortltem> {
    
    @Resource SortltemServiceImpl sortltemSrv;

    @Override
    protected RockWellBaseServiceImpl<Sortltem> getService() {
        return sortltemSrv;
    }
    
    @Log(code="ZJ_BJZL_FJGZ_SAVE_CHANGES",value="保存数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody SortltemDTO sortltem ) throws Exception{
        sortltemSrv.saveChanges(sortltem);
        return Response.suc();
    }
    /**
     * 查询第一个tab页的数据
     */
	@Log(value = "查询第一个tab页的数据", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid1")
	public String datagrid1(Filter filter, Page page,String filterRules) throws Exception {
		String entType=null;
		if(filter.get("entbarcode_s")!=null){
			String entCode=filter.get("entbarcode_s").toString();
			if (entCode.indexOf("FDPH") > -1) {
				entType="254004";
			}
			else if (entCode.indexOf("FLM") > -1) {
				entType="254004";
			}
			else if (entCode.indexOf("FJYX") > -1) {
				entType="254005";
			}
			//外观前使用动平衡的配方
			else if (entCode.indexOf("FWG") > -1) {
				entType="254004";
			}
			//X光前使用动平衡的配方
			else if (entCode.indexOf("FXG") > -1) {
				entType="254004";
			}
			else if (entCode.indexOf("FGM") > -1) {
				entType="254001";
			}
		}else{
			if(filter.get("station_i").equals("260005")){
				entType="254004";
			}else if(filter.get("station_i").equals("260007")){
				entType="254005";
			}else if(filter.get("station_i").equals("260002")){
				entType="254004";
			}else if(filter.get("station_i").equals("260008")){
				entType="254004";
			}
		}
		
    	String factoryString=LLWebUtils.factory();
      	String agenc_no_sString =FactoryConstant.JING_MEN_CODE;
    	filter.set("s_factory_s", factoryString);
  	   	filter.set("agenc_no_s",agenc_no_sString );
  	    filter.set("entType", entType);
		return GsonTools.toJson(sortltemSrv.datagrid1(filterRules,filter, page, SortltemAll.class));
	}
    /**
     * 查询第四个tab页的数据
     */
    @Log(value = "查询第四个tab页的数据", code = "FUNC_007", target = LogType.CONSOLE)
	@ResponseBody
	@RequestMapping("datagrid4")
	public String datagrid4(Filter filter, Page page) throws Exception {
    	String factoryString=LLWebUtils.factory();
      	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
    	filter.set("s_factory_s", factoryString);
  	   	filter.set("agenc_no_s",factoryCodeString );
		return GsonTools.toJson(sortltemSrv.datagrid4(filter, page, SortltemTab4.class));
	}
    
    /**
     * 查询第一个tab页,上方查询区域的机台下拉框
     * @return
     * @throws Exception
     */
    @Log(code="ZJ_BJZL_FJGZ_ENTCODENAME",value="获取机台条码和名称对应关系")
    @RequestMapping("combox_entcode")
   	public String combox_entcode(String spare1_s) throws Exception{
    	List<Map<String,Object>> list=sortltemSrv.getEntCodeName(spare1_s);
   		return toJson(list);
   	}
    /**
     * 查询第三个tab页,上方查询区域的机台下拉框
     * @return
     * @throws Exception
     */
    @Log(code="ZJ_BJZL_FJGZ_ENTCODENAME",value="获取机台条码和名称对应关系")
    @RequestMapping("combox_entcode3")
   	public String combox_entcode3() throws Exception{
    	List<Map<String,Object>> list=sortltemSrv.getEntCodeName3();
   		return toJson(list);
   	}
    /**
     * 抽检比例已有比例查询,分拣规则维护,第三个页面调用
     * @param itemid_s 品号
     * @return
     * @throws Exception
     */
    @Log(value = "抽检比例已有比例查询,分拣规则维护,第三个页面调用", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("getNum_i")
   	public String getNum_i(String itemid_s,String station_i) throws Exception {
   		List<Map<String, Object>> list = sortltemSrv.getNum_i(itemid_s,station_i);
   		return toJson(list);
   	}
    
    /**
     * 根据品号更新抽检比例,分拣规则维护,第四个页面调用
     * @param itemid_s 品号
     * @return
     * @throws Exception
     */
    @Log(value = "根据品号更新抽检比例,分拣规则维护,第四个页面调用", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("updateNum_i")
   	public Response updateNum_i(@RequestBody SortltemTab4DTO sortltemtab4) throws Exception {
    	sortltemSrv.updateNum_i(sortltemtab4);
    	return Response.suc();
   	}
    /**
     * 根据品号更新抽检比例,分拣规则维护,第5个页面调用
     * @param itemid_s 品号
     * @return
     * @throws Exception
     */
    @Log(value = "根据品号更新抽检比例,分拣规则维护,第四个页面调用", code = "FUNC_007", target = LogType.CONSOLE)
   	@RequestMapping("updateNum_i5")
   	public Response updateNum_i5(@RequestBody SortltemTab4DTO sortltemtab4) throws Exception {
    	sortltemSrv.updateNum_i5(sortltemtab4);
    	return Response.suc();
   	}
    /**
     * BY 时永良（新增，用于分拣规则维护-规格维护-机台下拉列表）
     * @param equip_type
     * @return
     * @throws Exception
     */
	@Log(code = "SearchEnt", value = "机台下拉框", target = LogType.CONSOLE)
	@RequestMapping("SearchEnt")
	public String SearchEnt(String equip_type) throws Exception {
		List<Map<String, Object>> list = sortltemSrv.SearchEnt(equip_type);
		return toJson(list);
	}
	
	
	 /**
     * BY 时永良（新增，用于分拣规则维护-规则查询-机台下拉列表）
     * @param equip_type
     * @return
     * @throws Exception
     */
	@Log(code = "SearchEntToRulesOfTheQuery", value = "机台下拉框", target = LogType.CONSOLE)
	@RequestMapping("SearchEntToRulesOfTheQuery")
	public String SearchEntToRulesOfTheQuery(String equip_type) throws Exception {
		List<Map<String, Object>> list = sortltemSrv.SearchEnt(equip_type);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("DESCRIPTION", "全部");
		map.put("EQUIP_NAME", "");
		list.add(map);
		return toJson(list);
	}
}
