/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.common.controller;

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
import com.bluebirdme.mes.linglong.common.service.RockWellFactoryModelServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellFunctionalUDAController;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 工厂模型表
 * @author 时永良
 * @Date 2019-07-30 10:51:23
 */
@Log(code="ROCKWELLFACTORYMODEL_LOG",value="工厂模型表日志")
@RestController
@RequestMapping("common/basedata/factorymodel")
public class RockWellFactoryModelController extends RockWellFunctionalUDAController<Object> {
    
    @Resource RockWellFactoryModelServiceImpl rockwellfactorymodelSrv;
    @Override
    protected RockWellUDABaseServiceImpl<Object> getUDAService() {
    	return rockwellfactorymodelSrv;
    }
 	@Override
 	protected RockWellBaseServiceImpl<Object> getService() {
 		return rockwellfactorymodelSrv;
 	}
   	@RequestMapping("factorymodeltree")
    public String factorymodeltree(String id) throws Exception {
   		List<Map<String, Object>> treeDataList=rockwellfactorymodelSrv.getFactoryModelTreeData();
  		List<Map<String, Object>> main = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("id", -1);
		root.put("text", "荆门工厂");
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(id==null||id.equals("")){
			for (Map<String, Object> treeitem : treeDataList) {
				if(treeitem.get("PARENT_ID")==null){
					map = new HashMap<String, Object>();
					if(treeitem.get("CHILD_KEY")!=null){
						map.put("id", treeitem.get("CHILD_KEY").toString());
					}
					if(treeitem.get("CHILD_DESC")!=null){
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
				if(treeitem.get("PARENT_ID")!=null&&treeitem.get("PARENT_ID").toString().equals(id)){
					map = new HashMap<String, Object>();
					if(treeitem.get("CHILD_KEY")!=null){
						map.put("id", treeitem.get("CHILD_KEY").toString());
					}
					if(treeitem.get("CHILD_DESC")!=null){
						map.put("text", treeitem.get("CHILD_DESC").toString());
					}
					map.put("state", "closed");
					main.add(map);
				}
			}
		}
		return toJson(main);
   	}
   	
    @RequestMapping("getTreeNodeInfo")
    public String getTreeNodeInfo( String level,String key) throws Exception {
    	return toJson(rockwellfactorymodelSrv.getTreeNodeInfo(level,key));
    }
    
    @Log(code="ROCKWELLFACTORYMODEL_ADD",value="添加",target=LogType.DB)
    @RequestMapping("add")
    public String add(@RequestBody Map<String,Object> list_map) throws Exception {
    	return toJson(rockwellfactorymodelSrv.add(list_map));
    }
    
    @Log(code="ROCKWELLFACTORYMODEL_EDIT",value="编辑",target=LogType.DB)
    @RequestMapping("edit")
    public String saveMain(@RequestBody Map<String,Object> list_map) throws Exception {
    	return toJson(rockwellfactorymodelSrv.edit(list_map));
    }
    
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
    * @author 刘程明
    * @date 2019年8月8日
    */
    @RequestMapping("getProductionInfoByAreaName")
   	public String getProductionInfoByAreaName(String areaname) throws Exception{
    	List<Map<String,Object>> list=rockwellfactorymodelSrv.getProductionInfoByAreaName(areaname);
   		return toJson(list);
   	}
   	
}
