/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import com.datasweep.compatibility.ui.Time;
import com.rockwell.mes.commons.base.ifc.services.IFunctionsEx;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂模型管理
 * @author 王超
 * @Date 2020-08-03 10:16:32
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class RockWellFactoryModelServiceImplMix extends RockWellUDABaseServiceImpl<Object> {
	/**
	 *ServiceImpl可以继承RockWellBaseServiceImpl,RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候，返回值为List<Map<String,Object>>类型。
	 RockWellBaseServiceImpl使用datagrid查询返回的是List<T>类型，这个类型是根据Controller里面，调用datagrid
	 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
    @Resource LingLongDataSource llds;
    
    @Override
	protected Session getSession() {
    	return llds.getSession();
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@Override
	protected Class getEntity() {
		return   null;
	}
	
	public IFunctionsEx  getFunction(){
    	return PCContext.getFunctions();
    }
    public Time getDBTime() {
    	return getFunction().getDBTime();
	}
    public String getUserName() {
		return LLWebUtils.getUserName();
	}
    
    public List<Map<String, Object>> factorymodeludasearch(String treenodeid, String treelevel) {
        List<Map<String, Object>> list_new = new ArrayList<>();
        if (!treelevel.equals("0"))
          if (!treelevel.equals("1"))
            if (!treelevel.equals("2"))
              if (treelevel.equals("3")) {
                SQLQuery query = createSQLQuery(getSQL("getProductionUDAValueByID"));
                query.setParameter("plinekey", treenodeid);
                List<Map<String, Object>> udaValueList = query.list();
                if (udaValueList.size() == 0)
                  return null; 
                Map<String, Object> udaValue = udaValueList.get(0);
                SQLQuery columnquery = createSQLQuery(getSQL("getUDAColumnInfo"));
                columnquery.setParameter("objecttype", "ProductionLine");
                List<Map<String, Object>> udaColumnList = columnquery.list();
                for (int j = 0; j < udaColumnList.size(); j++) {
                  Map<String, Object> udaColumnItem = udaColumnList.get(j);
                  String db_name = udaColumnItem.get("DB_NAME").toString();
                  Object value = udaValue.get(db_name);
                  udaColumnItem.put("UDA_VALUE", value);
                  udaColumnItem.put("OBJECT_KEY", udaValue.get("OBJECT_KEY"));
                  list_new.add(udaColumnItem);
                } 
              } else if (!treelevel.equals("4")) {
                if (treelevel.equals("5")) {
                  SQLQuery query = createSQLQuery(getSQL("getEquipmentUDAValueByID"));
                  query.setParameter("equipkey", treenodeid);
                  List<Map<String, Object>> udaValueList = query.list();
                  if (udaValueList.size() == 0)
                    return null; 
                  Map<String, Object> udaValue = udaValueList.get(0);
                  SQLQuery columnquery = createSQLQuery(getSQL("getUDAColumnInfo"));
                  columnquery.setParameter("objecttype", "Equipment");
                  List<Map<String, Object>> udaColumnList = columnquery.list();
                  for (int j = 0; j < udaColumnList.size(); j++) {
                    Map<String, Object> udaColumnItem = udaColumnList.get(j);
                    String db_name = udaColumnItem.get("DB_NAME").toString();
                    Object value = udaValue.get(db_name);
                    udaColumnItem.put("UDA_VALUE", value);
                    udaColumnItem.put("OBJECT_KEY", udaValue.get("OBJECT_KEY"));
                    list_new.add(udaColumnItem);
                  } 
                } 
              }    
        List<Map<String, Object>> result = new ArrayList<>();
        for (int i = 0; i < list_new.size(); i++)
          result.add(TransformUpperCase.transformUpperCase(list_new.get(i))); 
        return result;
      }
    
 	/**
 	 * 获取树的数据
 	 * @return
 	 * @throws Exception
 	 * @author 王超
 	 * @date 2020-08-03 10:16:32
 	 */
  	@SuppressWarnings("unchecked")
  	public List<Map<String, Object>> getFactoryModelTreeData() throws Exception{
  		List<Map<String, Object>> treeDataList=createSQLQuery(getSQL("getFactoryList")).list();
		return treeDataList;
  	}
  	
  	/**
  	 * 点击左侧数，根据节点名称，获取节点信息
  	 * @param name
  	 * @return
  	 * @throws Exception
  	 * @author 王超
  	 * @date 2020-08-03 10:16:32
  	 */
  	 @SuppressWarnings("unchecked")
     public List<Map<String,Object>> getTreeNodeInfo(String level,String key) throws Exception
     {
  		 String sql = "";
  		if(level.equals("0")){
  			   return null;
		}else if(level.equals("1")){
				sql = getSQL("getSiteInfoByKey");
		}else if(level.equals("2")){
				sql = getSQL("getAreaInfoByKey");
		}else if(level.equals("3")){
				sql = getSQL("getProductionInfoByKey");
		}else if(level.equals("4")){
				sql = getSQL("getWorkcenterInfoByKey");
		}else if(level.equals("5")){
				sql = getSQL("getFatherEquipmentInfoByKey");
		}else if(level.equals("6")){
				sql = getSQL("getChildEquipmentInfoByKey");
		}
     	SQLQuery query = createSQLQuery(sql);
     	query.setParameter("key", key);
     	List<Map<String, Object>> res = query.list();
     	List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
     }
  	/**
   	 * 左侧树新增数据
   	 * @param name
   	 * @param description
   	 * @return
   	 * @author 王超
   	 * @throws Exception 
   	 * @date 2020-08-03 10:16:32
   	 */
   	@RockWellTransactional
   	public Map<String, Object> add(Map<String,Object> list_map) throws Exception {
   		try {
   			Map<String, Object> result = new HashMap<String, Object>();//返回结果
   			String level = list_map.get("level").toString();
   			String parentcode = list_map.get("parentcode").toString();
   			String name = list_map.get("name").toString();;
   			String description = list_map.get("description").toString();
   			
   			if(level.equals("0")){
   				result.put("id", saveSite( name, description));
   				result.put("text",description);//追加节点的名称-------------------------------
   			}else if(level.equals("1")){
   				result.put("id", saveArea(parentcode, name, description));
   				result.put("text",description);//追加节点的名称-------------------------------
   				
   			}else if(level.equals("2")){
   				result.put("id", saveProductline(parentcode, name, description));
   				result.put("text",description);//追加节点的名称-------------------------------
   			}else if(level.equals("3")){
   				result.put("id", saveWorkCenter(parentcode, name, description));
   				result.put("text",description);//追加节点的名称-------------------------------
   			}
   			else if(level.equals("4")){
   				result.put("id",saveFatherEquipment(parentcode, name, description));
   				result.put("text",description);//追加节点的名称-------------------------------
   			}
   			else if(level.equals("5")){
   				result.put("id",saveChildEquipment(parentcode, name, description));
   				result.put("text",description);//追加节点的名称-------------------------------
   			}
   			return result;
 		} catch (Exception e) {
 			throw e;
 		}
 	}
	//厂区保存方法
  	public Long saveSite(String name,String description) {
		com.datasweep.compatibility.client.Site itemSite = getFunction().createSite(name);
		itemSite.setDescription(description);
		itemSite.save();
  		return itemSite.getKey();
	}
  	//工段保存方法
    public Long saveArea(String siteKey,String areaName,String areaDescription) throws Exception {
    	com.datasweep.compatibility.client.Area area = getFunction().createArea(areaName);
    	area.setDescription(areaDescription);
    	area.save();
    	siteAddArea(siteKey,areaName);
    	return area.getKey();
	}
    //产线保存方法
    public Long saveProductline(String areaKey,String productionName,String productionDescription) throws Exception {
    	com.datasweep.compatibility.client.ProductionLine productionline = getFunction().createProductionLine(productionName);
    	productionline.setDescription(productionDescription);
    	productionline.save();
    	areaAddProduction(areaKey,productionName);
    	return productionline.getKey();
	}
    //工作中心保存方法
    public Long saveWorkCenter(String productionKey,String workcenterName,String workcentedescription) throws Exception {
    	com.datasweep.compatibility.client.WorkCenter workcenter = getFunction().createWorkCenter(workcenterName);
    	workcenter.setDescription(workcentedescription);
    	workcenter.save();
    	productionAddWorkcenter(productionKey,workcenterName);
    	return workcenter.getKey();
	}
    //父设备保存方法
    public Long saveFatherEquipment(String workcenterKey,String equipmentName,String equipmentDescription) throws Exception {
    	com.datasweep.compatibility.client.Equipment equipment = getFunction().createEquipment(equipmentName);
    	equipment.setDescription(equipmentDescription);
    	equipment.save();
        workcenterAddEquipment(workcenterKey,equipmentName);
    	return equipment.getKey();
	}
    //子设备保存方法
    public Long saveChildEquipment(String fatherEquipmentKey,String childEquipmentName,String childEquipmentDescription) throws Exception {
    	com.datasweep.compatibility.client.Equipment equipment = getFunction().createEquipment(childEquipmentName);
    	equipment.setDescription(childEquipmentDescription);
    	equipment.save();
        equipmentAddEquipment(fatherEquipmentKey,childEquipmentName);
    	return equipment.getKey();
	}
    //厂区下挂工段
    public void siteAddArea(String siteKey,String areaname) throws Exception {
    	Long site_key = Long.parseLong(siteKey);
    	com.datasweep.compatibility.client.Site site = getFunction().getSiteByKey(site_key);
    	if(site == null){
    		throw new Exception("site层不存在");
    	}
    	site.refresh();
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByName(areaname);
    	site.addArea(area);
    	site.save();
	}
    //工段下挂产线
    public void areaAddProduction(String areaKey,String productionname) throws Exception {
    	Long area_Key = Long.parseLong(areaKey);
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByKey(area_Key);
    	if(area == null){
    		throw new Exception("area层不存在");
    	}
    	area.refresh();
    	com.datasweep.compatibility.client.ProductionLine productionLine = getFunction().getProductionLineByName(productionname);
    	area.addProductionLine(productionLine);;
    	area.save();
	}
    //产线下挂工作中心
    public void productionAddWorkcenter(String productionKey,String workcenterName) throws Exception{
    	Long production_Key = Long.parseLong(productionKey);
    	com.datasweep.compatibility.client.ProductionLine productionline = getFunction().getProductionLineByKey(production_Key);
    	if(productionline == null){
    		throw new Exception("productionline层不存在");
    	}
    	productionline.refresh();
    	com.datasweep.compatibility.client.WorkCenter workCenter = getFunction().getWorkCenterByName(workcenterName);
    	productionline.addWorkCenter(workCenter);
    	productionline.save();
    }
    //工作中心下挂设备
    public void workcenterAddEquipment(String workcenterKey,String equipmentName) throws Exception{
    	Long workcenter_Key = Long.parseLong(workcenterKey);
    	com.datasweep.compatibility.client.WorkCenter workCenter = getFunction().getWorkCenterByKey(workcenter_Key);
    	if(workCenter == null){
    		throw new Exception("workCenter层不存在");
    	}
    	workCenter.refresh();
    	com.datasweep.compatibility.client.Equipment equipment = getFunction().getEquipmentByName(equipmentName);
    	workCenter.addEquipment(equipment);
    	workCenter.save();
    }
    
    //父设备下挂子设备
    public void equipmentAddEquipment(String fatherEquipmentKey,String childEquipmentName) throws Exception{
    	Long fatherequipment_Key = Long.parseLong(fatherEquipmentKey);
    	com.datasweep.compatibility.client.Equipment fatherEquipment = getFunction().getEquipmentByKey(fatherequipment_Key);
    	if(fatherEquipment == null){
    		throw new Exception("equipment层不存在");
    	}
    	fatherEquipment.refresh();
    	com.datasweep.compatibility.client.Equipment childEquipment = getFunction().getEquipmentByName(childEquipmentName);
    	fatherEquipment.addEquipment(childEquipment);
    	fatherEquipment.save();
    }
    
  	/**
   	 * 左侧树编辑数据
   	 * @param name
   	 * @param description
   	 * @return
   	 * @author 王超
   	 * @throws Exception 
   	 * @date 2020-08-03 10:16:32
   	 */
   	@RockWellTransactional
   	public Map<String, Object> edit(Map<String,Object> list_map) throws Exception {
   		try {
   			Map<String, Object> result = new HashMap<String, Object>();//返回结果
   			String level = list_map.get("level").toString();
   			String key = list_map.get("id").toString();
   			String name = list_map.get("name").toString();
   			String description = list_map.get("description").toString();
   			
   			if(level.equals("0")){
   				return null;
   			}else if(level.equals("1")){
   				editSiteNameAndDescription(key,name,description);
   			}else if(level.equals("2")){
   				editAreaNameAndDescription(key,name,description);	
   			}else if(level.equals("3")){
   				editProductionNameAndDescription(key,name,description);
   			}else if(level.equals("4")){
   				editWorkCenterNameAndDescription(key,name,description);
   			}else if(level.equals("5")){
   				editFatherEquipMentNameAndDescription(key,name,description);
   			}else if(level.equals("6")){
   				editChildEquipMentNameAndDescription(key,name,description);
   			}
   			return result;
 		} catch (Exception e) {
 			throw e;
 		}
 	}
   	private void editSiteNameAndDescription(String sitekey,String name,String description){
  		Long site_key = Long.parseLong(sitekey);
  		com.datasweep.compatibility.client.Site site = getFunction().getSiteByKey(site_key);
  		site.setName(name);
  		site.setDescription(description);
  		site.save();
  	};

  	private void editAreaNameAndDescription(String areakey,String name,String description){
  		Long area_key = Long.parseLong(areakey);
  		com.datasweep.compatibility.client.Area area = getFunction().getAreaByKey(area_key);
  		area.setName(name);
  		area.setDescription(description);
  		area.save();
  	};

  	private void editProductionNameAndDescription(String plinekey,String name,String description){
  		Long pline_key = Long.parseLong(plinekey);
  		com.datasweep.compatibility.client.ProductionLine productionline = getFunction().getProductionLineByKey(pline_key);
  		productionline.setName(name);
  		productionline.setDescription(description);
  		productionline.save();
  	};

  	private void editWorkCenterNameAndDescription(String wckey,String name,String description){
  		Long wc_key = Long.parseLong(wckey);
  		com.datasweep.compatibility.client.WorkCenter workCenter = getFunction().getWorkCenterByKey(wc_key);
  		workCenter.setName(name);
  		workCenter.setDescription(description);
  		workCenter.save();
  	};

  	private void editFatherEquipMentNameAndDescription(String equipkey,String name,String description){
  		Long equip_key = Long.parseLong(equipkey);
  		com.datasweep.compatibility.client.Equipment equipment = getFunction().getEquipmentByKey(equip_key);
  		equipment.setName(name);
  		equipment.setDescription(description);
  		equipment.save();
  	};
  	
	private void editChildEquipMentNameAndDescription(String equipkey,String name,String description){
  		Long equip_key = Long.parseLong(equipkey);
  		com.datasweep.compatibility.client.Equipment equipment = getFunction().getEquipmentByKey(equip_key);
  		equipment.setName(name);
  		equipment.setDescription(description);
  		equipment.save();
  	};
  	
  	
  	/**
  	 * 左侧树删除数据
  	 * @param name
  	 * @param description
  	 * @return
  	 * @author 王超
  	 * @throws Exception 
  	 * @date 2020-08-03 10:16:32
  	 */
  	@RockWellTransactional
  	public String remove(Map<String,Object> list_map) throws Exception {
  		try {
  			StringBuffer result = new StringBuffer();
  			String level = list_map.get("level").toString();
  			String parentcode = list_map.get("parentcode").toString();
  			String code = list_map.get("code").toString();;
  			if(level.equals("1")){
  				deleteSite(code);
  			}else if(level.equals("2")){
  				deleteArea(parentcode,code);
  			}else if(level.equals("3")){
  				deleteProductline(parentcode, code);
  			}else if(level.equals("4")){
  				deleteWorkCenter(parentcode, code);
  			}else if(level.equals("5")){
  				deleteFatherEquipment(parentcode, code);
  			}else if(level.equals("6")){
  				deleteChildEquipment(parentcode, code);
  			}
  			result.append("操作成功");
  			return result.toString();
		} catch (Exception e) {
			throw e;
		}
	}
  	//厂区删除方法
  	public void deleteSite(String sitekey) {
  		Long site_key = Long.parseLong(sitekey);
		com.datasweep.compatibility.client.Site itemSite = getFunction().getSiteByKey(site_key);
		itemSite.delete(getDBTime(), getUserName() + "删除了" + itemSite.getName());
	}
  	//工段删除方法
    public void deleteArea(String siteKey,String areaKey) throws Exception {
    	Long site_key = Long.parseLong(siteKey);
    	Long area_key = Long.parseLong(areaKey);
    	com.datasweep.compatibility.client.Site site = getFunction().getSiteByKey(site_key);
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByKey(area_key);
    	site.removeArea(area);
    	site.save();//先移除关系
    	area.delete(getDBTime(), getUserName() + "删除了" + area.getName());
	}
    //产线删除方法
    public void deleteProductline(String areaKey,String productionKey) throws Exception {
    	Long area_key = Long.parseLong(areaKey);
    	Long production_key = Long.parseLong(productionKey);
    	com.datasweep.compatibility.client.Area area = getFunction().getAreaByKey(area_key);
    	com.datasweep.compatibility.client.ProductionLine productionline = getFunction().getProductionLineByKey(production_key);
    	area.removeProductionLine(productionline);
    	area.save();
    	productionline.delete(getDBTime(), getUserName() + "删除了" + productionline.getName());
    }
    //工作中心删除方法
    public void deleteWorkCenter(String productionKey,String workcenterKey) throws Exception {
    	Long production_key = Long.parseLong(productionKey);
    	Long workcenter_key = Long.parseLong(workcenterKey);
    	com.datasweep.compatibility.client.ProductionLine productionline = getFunction().getProductionLineByKey(production_key);
    	com.datasweep.compatibility.client.WorkCenter workcenter = getFunction().getWorkCenterByKey(workcenter_key);
    	productionline.removeWorkCenter(workcenter);
    	productionline.save();
    	workcenter.delete(getDBTime(), getUserName() + "删除了" + workcenter.getName());
	}
    //父设备删除方法
    public void deleteFatherEquipment(String workcenterKey,String equipmentKey) throws Exception {
    	Long workcenter_key = Long.parseLong(workcenterKey);
    	Long equipment_key = Long.parseLong(equipmentKey);
    	com.datasweep.compatibility.client.WorkCenter workcenter = getFunction().getWorkCenterByKey(workcenter_key);
    	com.datasweep.compatibility.client.Equipment equipment = getFunction().getEquipmentByKey(equipment_key);
    	workcenter.removeEquipment(equipment);
    	workcenter.save();
    	equipment.delete(getDBTime(), getUserName() + "删除了" + equipment.getName());
	}
    //子设备删除方法
    public void deleteChildEquipment(String fatherEquipmentKey,String childEquipmentKey) throws Exception {
    	Long fatherequipment_key = Long.parseLong(fatherEquipmentKey);
    	Long childequipment_key = Long.parseLong(childEquipmentKey);
    	com.datasweep.compatibility.client.Equipment fatherEquipment = getFunction().getEquipmentByKey(fatherequipment_key);
    	com.datasweep.compatibility.client.Equipment childEquipment = getFunction().getEquipmentByKey(childequipment_key);
    	fatherEquipment.removeEquipment(childEquipment);
		fatherEquipment.save();
    	childEquipment.delete(getDBTime(), getUserName() + "删除了" + childEquipment.getName());
	}
  	
  	//通过工段名称返回该工段下的产线信息
  	@SuppressWarnings("unchecked")
    public List<Map<String,Object>> getProductionInfoByAreaName(String areaname) throws Exception{
     	SQLQuery query = createSQLQuery(getSQL("getProductionInfoByAreaName"));
     	query.setParameter("areaname", areaname);
     	List<Map<String, Object>> res = query.list();
     	List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
    }
  	
  	
  	//根据计划类型获取对应的机台列表
    public List<Map<String, Object>> getMixProductionInfo(String plantype) throws Exception {
        try {
          String areaname = "";
          String[] matchlist = null;
          
          if (LLWebUtils.factory().equals("1")) {
            areaname = "80231MX";
            if (plantype.equals("051003")) {
              matchlist = new String[] { "E0101", "E0102", "E0103", "E0104", "E0105", "E0106", "E0107", "E0108" };
            }
            if (plantype.equals("051002")) {
              matchlist = new String[] { "E0201", "E0202", "E0203" };
            }
            if (plantype.equals("051001")) {
              matchlist = new String[] { "E0204", "E0205", "E0206" };
            }
            
            if (plantype.equals("051003051001")) {
              matchlist = new String[] { "E01", "E02" };
            }
            
            if (plantype.equals("051004")) {
              matchlist = new String[] { "E01", "E0201", "E0202", "E0203", "E34", "E35" };
            }
          } else {
            areaname = "80232MX";
            if (plantype.equals("051003")) {
              matchlist = new String[] { "90101", "90102", "90103", "90104", "90105", "90106", "90107", "90108" };
            }
            if (plantype.equals("051002")) {
              matchlist = new String[] { "90201", "90202", "90203" };
            }
            if (plantype.equals("051001")) {
              matchlist = new String[] { "90204", "90205", "90206" };
            }
            
            if (plantype.equals("051004")) {
              matchlist = new String[] { "90101", "90102", "90103", "90104", "90105", "90106", "90107", "90108", "90201", "90202", "90203", "934", "935" };
            }
    
            
            if (plantype.equals("051003051001")) {
              matchlist = new String[] { "9010", "9020" };
            }
            
            if (plantype.equals("908907")) {
              matchlist = new String[] { "908", "907" };
            }
          } 
          return getProductionInfoByAreaNameAndMatchlist(areaname, matchlist);
        } catch (Exception e) {
          return null;
        } 
      }
    
    
    public List<Map<String, Object>> getProductionInfoByAreaNameAndMatchlist(String areaname, String[] matchlist) throws Exception {
        StringBuffer sql = new StringBuffer();
        sql.append("select   a.area_name,a.description areadescription,p.p_line_name,p.description,up.*");
        sql.append(" from area a, area_production_line l2, production_line p,uda_productionline up");
        sql.append(" where l2.parent_key = a.area_key");
        sql.append(" and l2.child_key = p.p_line_key");
        sql.append(" and p.p_line_key=up.object_key(+)");
        if (matchlist != null && matchlist.length > 0) {
          String matchString = "";
          sql.append(" and REGEXP_LIKE(p.p_line_name, '(");
          for (int j = 0; j < matchlist.length; j++) {
            matchString = matchString + matchlist[j].toString() + "|";
          }
          sql.append(matchString.substring(0, matchString.length() - 1).trim());
          sql.append(")') ");
        } 
        if (!areaname.equals("")) {
          
          sql.append(" and a.area_name='");
          sql.append(areaname + "'");
        } 
        sql.append(" order by p.p_line_name");
        
        SQLQuery query = createSQLQuery(sql.toString());
        List<Map<String, Object>> res = query.list();
        List<Map<String, Object>> list_new = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
          list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
        }
        return list_new;
      }
  	
  	
}
