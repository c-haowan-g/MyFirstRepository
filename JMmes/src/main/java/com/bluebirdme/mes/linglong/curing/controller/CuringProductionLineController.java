/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.curing.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xdemo.app.xutils.ext.GsonTools;

import com.alibaba.fastjson.JSONArray;
import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.annotations.support.LogType;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.service.CuringProductionLineInfoServiceImpl;
import com.bluebirdme.mes.linglong.curing.service.CuringProductionLineServiceImpl;
import com.bluebirdme.mes.linglong.curing.entity.dto.UdaDto;

/**
 * 硫化产线设备维护页面
 * @author 时永良
 * @Date 2019-07-13 09:55:26
 */
@Log(code="硫化产线设备维护页面",value="硫化产线设备维护页面")
@RestController
@RequestMapping("curing/baseData/curingProductionLine")
public class CuringProductionLineController extends RockWellFunctionalUDAController<Object> {
    
    @Resource CuringProductionLineServiceImpl curingproductionlineSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return curingproductionlineSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return curingproductionlineSrv;
	}
    
		/**
		 * 根据process返回硫化的产线信息
		 * 时永良
		 * 2019年2月27日
		 * @param sitename：全钢1 半钢2
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
			return toJson(curingproductionlineSrv.getProductline(map));
		}	
		
		/**
		 * 通过产线名称获取产线下设备信息
		 * 时永良
		 * 2019年2月27日
		 * @param plinename ：9BSA01
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("getEquipByProductlineName")
		public String getEquipByProductlineName(String plinename) throws Exception{
			return toJson(curingproductionlineSrv.getEquipByProductlineName(plinename));
		}
		
		/**
		 * 获取产线下设备信息(投料口、产出口),通过equip_key
		 * 时永良
		 * 2019年2月27日
		 * @param equipKey equipment的id
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("getEquipByEquipKey")
		public String getEquipByEquipKey(String equipKey) throws Exception{
			return toJson(curingproductionlineSrv.getEquipByEquipKey(equipKey));
		}
		
		/**
		 * 通过工段名称返回产线，比如：半钢硫化Area得名字为80232C
		 * 时永良
		 * 2019年1月23日
		 * @param parentkey
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("getProductlineByAreaName")
		public String getProductlineByAreaName(String areaname) throws Exception{
			return toJson(curingproductionlineSrv.getProductlineByAreaName(areaname));
		}
		
		 @Log(code="FactoryProductLine_Save",value="保存产线数据的增删改",target=LogType.DB)
		    @RequestMapping("saveProductLineChanges")
		    public Response saveProductLineChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		        return Response.suc(curingproductionlineSrv.saveProductLineChanges(rockWellEntityDTO));
		    }
		 
		  @Log(code="FactoryEquipmentModel_Save",value="保存设备机型数据的增删改",target=LogType.DB)
		    @RequestMapping("saveEquipmentModelChanges")
		    public Response saveEquipmentModelChanges(@RequestBody RockWellEntityDTO rockWellEntityDTO) throws Exception {
		    	String message=curingproductionlineSrv.saveEquipmentModelChanges(rockWellEntityDTO);
				return Response.error(Response.SYS_EXCEPTION,message,null);
		    }	 
		  @Log(code="FactoryEquipment_Save",value="保存子设备投料口,产出口数据的增删改",target=LogType.DB)
		    @RequestMapping("saveEquipmentChanges")
		    public Response saveEquipmentChanges(@RequestBody Map<String, Object> rockWellEntityDTO) throws Exception {
		        return Response.suc(curingproductionlineSrv.saveEquipmentChanges(rockWellEntityDTO));
		    }
		  
		    /**
			  * 查出机台编码,机台名称显示在JSP页面下拉列表处
			  * @return
			 */
			@Log(code = "searchDescription", value = "查出机台名称显示在JSP页面下拉列表处")
			@RequestMapping("searchDescription")
			public String searchDescription() throws Exception {
				List<Map<String, Object>> list = curingproductionlineSrv.searchDescription();
				return toJson(list);
			}
			
			/**
			  * 根据数据字典查出所需控制项（320为数据字典中代码号）
			  * @return
			 */
			@Log(code = "searchBy320", value = "根据数据字典查出所需控制项")
			@RequestMapping("searchBy320")
			public String searchBy320(String logo) throws Exception {
				List<Map<String, Object>> list = curingproductionlineSrv.searchBy320(logo);
				return toJson(list);
			}
}
