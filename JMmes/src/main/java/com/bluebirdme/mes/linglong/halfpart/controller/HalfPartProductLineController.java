/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.halfpart.service.HalfPartProductLineServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Area;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;

/**
 * 半部件机台信息管理
 * @author 时永良
 * @Date 2020年3月6日08:15:37
 */
@Log(code="FactoryProductLine",value="机台信息管理操作日志")
@RestController
@RequestMapping("halfpart/basedata/productlinemanager")
public class HalfPartProductLineController extends RockWellFunctionalUDAController<Object> {
    
    @Resource HalfPartProductLineServiceImpl productlineSrv;
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return productlineSrv;
	}
    
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return productlineSrv;
	}
	
    @Log(code="HalfPartProductLine_Save",value="保存半部件产线数据的增删改",target=LogType.DB)
    @RequestMapping("saveProductLineChanges")
    public Response SaveProductLineChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO ) throws Exception {
        return Response.suc(productlineSrv.saveProductLineChanges(rockWellEntityDTO));
    }
    
    @Log(code="FactoryEquipmentModel_Save",value="保存设备机型数据的增删改",target=LogType.DB)
    @RequestMapping("saveEquipmentModelChanges")
    public Response saveEquipmentModelChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
    	String message=productlineSrv.saveEquipmentModelChanges(rockWellEntityDTO);
		return Response.error(Response.SYS_EXCEPTION,message,null);
    }
    
    @Log(code="HalfPartEquipment_Save",value="保存子设备数据的增删改(半部件)",target=LogType.DB)
    @RequestMapping("saveEquipmentChanges")
    public Response SaveEquipmentChanges(@RequestBody Map<String, Object> rockWellEntityDTO ) throws Exception {
        return Response.suc(productlineSrv.saveEquipmentChanges((rockWellEntityDTO)));
    }
    
    
	/**
	 * 获取Site信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("site")
	public String site() throws Exception{
		return toJson(productlineSrv.getSite());
	}
	/**
	 * 通过site名称获取area
	 * 时永良
	 * 2020年3月6日14:51:47
	 * @param sitename：全钢1 半钢2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getAreaBySitename")
	public String getAreaBySitename(String sitename) throws Exception{
		return toJson(productlineSrv.getAreaBySitename(sitename));
	}
	/**
	 * 根据site(全钢/半钢)、返回半部件的产线信息（产线查询）
	 * 时永良
	 * 2020年3月6日14:51:53
	 * @param process_s：工序，前台写死252004，半部件
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getProductline")
	public String getProductline(final String[] list_map) throws Exception{
		Map<String,String> map=new HashMap<>();
		if(list_map!=null){
			String string=Arrays.asList(list_map).toString();
			List<Map<String,String>> list=(List<Map<String,String>>)JSONArray.parse(string);
			map=list.get(0);
		}
		return toJson(productlineSrv.getProductline(map));
	}
	
	/**
	 * 通过产线名称获取产线下设备信息（机台设备查询）
	 * 时永良
	 * 2020年3月6日14:52:08
	 * @param plinename ：9BSA01
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getEquipByProductlineName")
	public String getEquipByProductlineName(String plinename) throws Exception{
		return toJson(productlineSrv.getEquipByProductlineName(plinename));
	}
	/**
	 * 获取产线下设备信息(投料口、产出口),通过equip_key（子设备查询）
	 * 时永良
	 * 2020年3月12日15:59:12
	 * @param equipKey equipment的id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getEquipByEquipKey")
	public String getEquipByEquipKey(String equipKey) throws Exception{
		return toJson(productlineSrv.getEquipByEquipKey(equipKey));
	}
	
	/**
	 * 通过工段名称返回产线，比如：半钢成型Area得名字为80032B
	 * 时永良
	 * 2020年3月6日14:51:58
	 * @param parentkey
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getProductlineByAreaName")
	public String getProductlineByAreaName(String areaname) throws Exception{
		return toJson(productlineSrv.getProductlineByAreaName(areaname));
	}
	/**
	 * 根据site返回成型的产线信息
	 * 时永良
	 * 2020年3月6日14:52:03
	 * @param sitename：全钢1 半钢2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getProductlineBySiteName")
	public String getProductlineBySiteName(String sitename) throws Exception{
		return toJson(productlineSrv.getProductlineBySiteName(sitename));
	}
	
	/**
	 * 
	 * 时永良
	 * 2020年3月6日14:52:14
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestMapping("materialTypeList")
	public String materialTypeList() throws Exception{
		List<Map<String,Object>> list=productlineSrv.materialTypeList();
		return toJson(list);
	}
 	/**
 	 * 获得半部件用产线
 	 * 时永良
 	 * get production name in half-part
 	 * 2020年3月6日14:52:24
 	 * 
 	 */
	@RequestMapping("getHalfPartProductionLine")
 	public String getHalfPartProductionLine() throws Exception{
		List<String> list=productlineSrv.getHalfPartProductionLine();
		return toJson(list);
 	}
	
 	/**
 	 * 生成子设备条码
 	 * 时永良
 	 * 2020年3月6日14:52:30
 	 */
	@RequestMapping("creatEquipName")
	public String creatEquipName(String productLineName,String equipType){
		String equipName=productlineSrv.creatEquipName(productLineName, equipType);
		return equipName;
 	}
	/**
	 * 根据数据字典211获取半部件用产线类型的数据字典
	 * 时永良
	 * 2020年3月6日14:52:36
	 * 
	 */
	@RequestMapping("getProductLineType")
	public String getProductLineType() throws Exception{
		List<String> productLineType=productlineSrv.getProductLineType();
		return toJson(productLineType);
	}
	/**
	 * 编辑产线时判断有口型板时是否维护了口型板型子设备
	 * 时永良
	 * 2020年3月6日14:52:42
	 * 
	 */
	@RequestMapping("plasticJudge")
	public boolean plasticJudge(String lineName) throws Exception{
		boolean plasticJudge=productlineSrv.plasticJudge(lineName);
		return plasticJudge;
	}
	/**
	 * 删除产线时判断是否维护了库区
	 * 时永良
	 * 2020年3月6日14:52:48
	 * @return 
	 * 
	 */
	@RequestMapping("zoneExistJudge")
	public String zoneExistJudge(String[] productLine) {
		List<String> zoneExistJudge=productlineSrv.zoneExistJudge(productLine);
		return toJson(zoneExistJudge);
	}
	
	/**
	  * 根据数据字典查出所需控制项（211为数据字典中代码号）
	  * 时永良
	  * 2020年3月6日15:41:12
	  * @return
	 */
	@Log(code = "searchBy211", value = "根据数据字典查出所需控制项")
	@RequestMapping("searchBy211")
	public String searchBy211(String logo) throws Exception {
		List<Map<String, Object>> list = productlineSrv.searchBy211(logo);
		return toJson(list);
	}
	
	/**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@Log(code = "searchMaterialGroup", value = "查出物料组显示在JSP页面下拉列表处")
	@RequestMapping("searchMaterialGroup")
	public String searchMaterialGroup() throws Exception {
		List<Map<String, Object>> list = productlineSrv.searchMaterialGroup();
		return toJson(list);
	}
}
