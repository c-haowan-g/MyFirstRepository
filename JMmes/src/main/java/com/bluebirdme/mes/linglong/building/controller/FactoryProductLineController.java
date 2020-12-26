/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.building.entity.FactoryProductLine;
import com.bluebirdme.mes.linglong.building.service.FactoryProductLineServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.DictcodeConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;


/**
 * 成型机台信息管理
 * @author 时永良
 * @Date 2019年8月5日14:11:17
 */
@Log(code="FactoryProductLine",value="机台信息管理操作日志")
@RestController
@RequestMapping("building/basedata/productline")

public class FactoryProductLineController extends RockWellFunctionalUDAController<Object> {
    
    @Resource FactoryProductLineServiceImpl cxproductlineSrv;
	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return cxproductlineSrv;
	}
	
	@Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return cxproductlineSrv;
	}
    @Log(code="FactoryProductLine_Save",value="保存产线数据的增删改",target=LogType.DB)
    @RequestMapping("saveChanges")
    public Response saveChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
        return Response.suc(cxproductlineSrv.saveChanges(rockWellEntityDTO));
    }
    
    @Log(code="FactoryEquipmentModel_Save",value="保存设备机型数据的增删改",target=LogType.DB)
    @RequestMapping("saveEquipmentModelChanges")
    public Response saveEquipmentModelChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
    	String message=cxproductlineSrv.saveEquipmentModelChanges(rockWellEntityDTO);
		return Response.error(Response.SYS_EXCEPTION,message,null);
    }
    
    @Log(code="FactoryEquipment_Save",value="保存子设备投料口,产出口数据的增删改",target=LogType.DB)
    @RequestMapping("saveEquipmentChanges")
    public Response saveEquipmentChanges(@RequestBody Map<String, Object> rockWellEntityDTO) throws Exception {
        return Response.suc(cxproductlineSrv.saveEquipmentChanges(rockWellEntityDTO));
    }
    
    /**
	 * 获取设备机型信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("equipmentModelList")
	public String equipmentModelList() throws Exception{
		return toJson(cxproductlineSrv.equipmentModelList());
	}
	
	/**
	 * 获取Site信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("site")
	public String site() throws Exception{
		return toJson(cxproductlineSrv.getSite());
	}
	/**
	 * 通过site名称获取area
	 * 刘程明
	 * 2019年3月5日
	 * @param sitename：全钢1 半钢2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getAreaBySitename")
	public String getAreaBySitename(String sitename) throws Exception{
		return toJson(cxproductlineSrv.getAreaBySitename(sitename));
	}
	/**
	 * 根据site返回成型的产线信息
	 * 刘程明
	 * 2019年2月27日
	 * @param sitename：全钢1 半钢2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getProductline")
	public String getProductline(String process_s) throws Exception{
		return toJson(cxproductlineSrv.getProductline(process_s));
	}
	
	/**
	 * 根据设备条码和日期获取当前条件下的日计划号
	 * 刘程明
	 * 2019年3月15日
	 * @param equipCode 设备条码例如:FBSA01
	 * @param productDate 时期:例如:20190311
	 * @return
	 */
	@RequestMapping("searchDayplannoByEquipCodeAndPlanDate")
	public String searchDayplannoByEquipCodeAndPlanDate(String equipCode,String productDate) {
		List<String> list = cxproductlineSrv.searchDayplannoByEquipCodeAndPlanDate(equipCode,productDate);
		System.out.println(toJson(list));
		return toJson(list);
	}
	
	/**
	 * 通过工序获取产线信息
	 * @param areaname
	 * @return
	 * @throws Exception
	 * @author 刘程明
	 * @date 2019年7月15日
	 */
	@RequestMapping("getProductlineByProcess")
	public String getProductlineByProcess(String process) throws Exception{
		String areaname="";
		//成型-252005，
		if(process.equals(DictcodeConstant.DICT252005)){
			if(LLWebUtils.factory().equals("1")){
				areaname="80231B";
			}else{
				areaname="80232B";
			}
		}
		return toJson(cxproductlineSrv.getProductlineByAreaName(areaname));
	}
	/**
	 * 通过工段名称返回产线，比如：半钢成型Area得名字为80232B
	 * 刘程明
	 * 2019年1月23日
	 * @param parentkey
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getProductlineByAreaName")
	public String getProductlineByAreaName(String areaname) throws Exception{
		return toJson(cxproductlineSrv.getProductlineByAreaName(areaname));
	}
	
	/**
	 * 根据site返回成型的产线信息
	 * 刘程明
	 * 2019年2月27日
	 * @param sitename：全钢1 半钢2
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getProductlineBySiteName")
	public String getProductlineBySiteName(String sitename) throws Exception{
		return toJson(cxproductlineSrv.getProductlineBySiteName(sitename));
	}
	
	/**
	 * 通过产线名称获取产线下设备信息
	 * 刘程明
	 * 2019年2月27日
	 * @param plinename ：9BSA01
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getEquipByProductlineName")
	public String getEquipByProductlineName(String plinename) throws Exception{
		return toJson(cxproductlineSrv.getEquipByProductlineName(plinename));
	}
	
	/**
	 * 获取产线下设备信息(投料口、产出口),通过equip_key
	 * 刘程明
	 * 2019年2月27日
	 * @param equipKey equipment的id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("getEquipByEquipKey")
	public String getEquipByEquipKey(String equipKey) throws Exception{
		return toJson(cxproductlineSrv.getEquipByEquipKey(equipKey));
	}
	
	/**
	 * 
	 * 刘程明
	 * 2019年3月1日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("materialTypeList")
	public String materialTypeList() throws Exception{
		List<Map<String,Object>> list=cxproductlineSrv.materialTypeList();
		return toJson(list);
	}
    
	/**
	  * 根据189查出对应数据字典（189为数据字典中代码号）
	  * @return
	 */
	@Log(code = "searchBy189", value = "根据189查出对应数据字典")
	@RequestMapping("searchBy189")
	public String searchBy189() throws Exception {
		List<Map<String, Object>> list = cxproductlineSrv.searchBy189();
		return toJson(list);
	}
	
	@Log(code = "DICT_SAVE_CHANGES", value = "保存数据的增删改")
	@RequestMapping("saveDictChanges")
	public Response saveDictChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		List<String> repeatCodes =cxproductlineSrv.saveDictChanges(rockWellEntityDTO);
		if (!ListUtils.isEmpty(repeatCodes)) {
			return Response.error(Response.SYS_EXCEPTION, "代码重复", repeatCodes);
		}
		return Response.suc();
	}
}
