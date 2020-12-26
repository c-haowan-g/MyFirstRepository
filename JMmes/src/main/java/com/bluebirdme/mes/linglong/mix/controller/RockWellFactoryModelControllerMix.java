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
import com.bluebirdme.core.system.web.Response;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.mix.service.RockWellFactoryModelServiceImplMix;

/**
 * 工厂模型管理
 * @author 王超
 * @Date 2020-08-03 10:16:32
 */
@Log(code="工厂模型管理",value="工厂模型管理")
@RestController
@RequestMapping("mix/baseData/rockWellFactoryModel")
public class RockWellFactoryModelControllerMix extends RockWellFunctionalUDAController<Object> {
    
    @Resource RockWellFactoryModelServiceImplMix rockwellfactorymodelSrv;
    
    @Override
	protected RockWellUDABaseServiceImpl<Object> getUDAService() {
		return rockwellfactorymodelSrv;
	}

	@Override
	protected RockWellBaseServiceImpl<Object> getService() {
		return rockwellfactorymodelSrv;
	}
    
	/**
	 * 工厂模型查询
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("factorymodeltree")
    public String factorymodeltree(String id) throws Exception {
   		List<Map<String, Object>> treeDataList = rockwellfactorymodelSrv.getFactoryModelTreeData();
  		List<Map<String, Object>> main = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("id", -1);
		root.put("text", "荆门工厂");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(id == null || id.equals("")){
			for (Map<String, Object> treeitem : treeDataList) {
				if(treeitem.get("PARENT_ID") == null){
					map = new HashMap<String, Object>();
					if(treeitem.get("CHILD_KEY") != null){
						map.put("id", treeitem.get("CHILD_KEY").toString());
					}
					if(treeitem.get("CHILD_DESC") != null){
						map.put("text", treeitem.get("CHILD_DESC").toString());
					}
					map.put("state", "closed");
					children.add(map);
				}
			}
			root.put("children", children);
			main.add(root);
		}else{
			for (Map<String, Object> treeitem : treeDataList) {
				if(treeitem.get("PARENT_ID") != null&&treeitem.get("PARENT_ID").toString().equals(id)){
					map = new HashMap<String, Object>();
					if(treeitem.get("CHILD_KEY") != null){
						map.put("id", treeitem.get("CHILD_KEY").toString());
					}
					if(treeitem.get("CHILD_DESC") != null){
						map.put("text", treeitem.get("CHILD_DESC").toString());
					}
					map.put("state", "closed");
					main.add(map);
				}
			}
		}
		return toJson(main);
   	}
   	
	/**
	 * 根据节点名称获取信息
	 * @param level
	 * @param key
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("getTreeNodeInfo")
    public String getTreeNodeInfo( String level,String key) throws Exception {
    	return toJson(rockwellfactorymodelSrv.getTreeNodeInfo(level,key));
    }
    
    @RequestMapping({"factorymodeludasearch"})
    public String factorymodeludasearch(String treenodeid, String treelevel) throws Exception {
      List<Map<String, Object>> treeDataList = this.rockwellfactorymodelSrv.factorymodeludasearch(treenodeid, treelevel);
      return toJson(treeDataList);
    }
    
    /**
	 * 添加节点
	 * @param level
	 * @param key
	 * @return
	 * @throws Exception
	 */
    @Log(code="ROCKWELLFACTORYMODEL_ADD",value="添加",target=LogType.DB)
    @RequestMapping("add")
    public String add(@RequestBody Map<String,Object> list_map) throws Exception {
    	return toJson(rockwellfactorymodelSrv.add(list_map));
    }
    
    /**
	 * 修改节点
	 * @param level
	 * @param key
	 * @return
	 * @throws Exception
	 */
    @Log(code="ROCKWELLFACTORYMODEL_EDIT",value="编辑",target=LogType.DB)
    @RequestMapping("edit")
    public String saveMain(@RequestBody Map<String,Object> list_map) throws Exception {
    	return toJson(rockwellfactorymodelSrv.edit(list_map));
    }
    
    /**
	 * 删除节点
	 * @param level
	 * @param key
	 * @return
	 * @throws Exception
	 */
    @Log(code="ROCKWELLFACTORYMODEL_REMOVE",value="删除",target=LogType.DB)
    @RequestMapping("remove")
    public Response remove(@RequestBody Map<String,Object> list_map) throws Exception {
    	return Response.suc(rockwellfactorymodelSrv.remove(list_map));
    }
   	
   /**
    * 对外接口-返回产线及其UDA信息
    * @param areaname 工段名称：例如：80232B是半钢成型
    * @return
    * @throws Exception
    * @author 王超
    * @date 2020-08-03 10:16:32
    */
    @RequestMapping("getProductionInfoByAreaName")
   	public String getProductionInfoByAreaName(String areaname) throws Exception{
    	List<Map<String,Object>> list = rockwellfactorymodelSrv.getProductionInfoByAreaName(areaname);
   		return toJson(list);
   	}
    
    @RequestMapping({"getProductionInfoByAreaNameAndMatchlist"})
    public String getProductionInfoByAreaNameAndMatchlist(String areaname, String[] match) throws Exception {
      List<Map<String, Object>> list = this.rockwellfactorymodelSrv.getProductionInfoByAreaNameAndMatchlist(areaname, match);
      
      return toJson(list);
    }
  
    ////根据计划类型获取对应的机台列表
    @RequestMapping({"getMixProductionInfo"})
    public String getMixProductionInfo(String plantype) throws Exception {
      List<Map<String, Object>> list = this.rockwellfactorymodelSrv.getMixProductionInfo(plantype);
      return toJson(list);
    }

}
