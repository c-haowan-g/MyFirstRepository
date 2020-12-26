/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.base.BaseServiceImpl;
import com.bluebirdme.core.system.base.FunctionalController;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.common.controller.RockWellFactoryModelController;
import com.bluebirdme.mes.linglong.common.entity.RockWellFactoryModel;
//import com.bluebirdme.mes.linglong.common.entity.dto.RockWellFactoryModelDTO;
import com.bluebirdme.mes.linglong.common.service.RockWellFactoryModelServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.MixFactoryModelServiceImpl;

/**
 * 工厂模型表
 * @author 刘程明
 * @Date 2019-07-30 10:51:23
 */
@Log(code="ROCKWELLFACTORYMODEL_LOG",value="工厂模型表日志")
@RestController
@RequestMapping("mix/basedata/rockwellFactoryModel")
public class MixFactoryModelController extends FunctionalController<RockWellFactoryModel> {
    @Resource MixFactoryModelServiceImpl rockwellfactorymodelSrv;
    @Override
	protected BaseServiceImpl<RockWellFactoryModel> getService() {
		return rockwellfactorymodelSrv;
	}
    
    @RequestMapping("getProductionInfoByAreaNameAndMatchlist")
   	public String getProductionInfoByAreaNameAndMatchlist(String areaname,String[] match) throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getProductionInfoByAreaNameAndMatchlist(areaname,match);
   		return toJson(list);
   	}

    //根据计划类型获取对应的机台列表
    @RequestMapping("getMixProductionInfo")
   	public String getMixProductionInfo(String plantype) throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getMixProductionInfo(plantype);
   		return toJson(list);
   	}
    //获取小料的机台列表
    @RequestMapping("getMixXLProductionInfo")
   	public String getMixXLProductionInfo() throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getMixProductionInfo();
   		return toJson(list);
   	}
    
    //根据计划类型获取对应的机台列表
    @RequestMapping("getHopperInfoByPlinename")
   	public String getHopperInfoByPlinename(String plinename) throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getHopperInfoByPlinename(plinename);
   		return toJson(list);
   	}
    
    //获取Rfid的机台列表
    @RequestMapping("getRfidByPlinename")
   	public String getRfidByPlinename() throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getRfidByPlinename();
   		return toJson(list);
   	}
    
    //获取plm的机台列表
    @RequestMapping("getplmByPlinename")
   	public String getplmByPlinename() throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getplmByPlinename();
   		return toJson(list);
   	}
    
    //获取plm的机台列表 不区分全钢半钢
    @RequestMapping("getplmByPlinenameall")
   	public String getplmByPlinenameall() throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getplmByPlinenameall();
   		return toJson(list);
   	}
    //根据库区名称获取库位信息
    @RequestMapping("getMixStorageUnitByZoneName")
   	public String getMixStorageUnitByZoneName(String zonename)  throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getMixStorageUnitByZoneName(zonename);
   		return toJson(list);
   	}
    //获取密炼所有库区，底层根据全钢半钢区分
    @RequestMapping("getMixStorageZone")
   	public String getMixStorageZone() throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getMixStorageZone();
   		return toJson(list);
   	}
}
