/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.EqualMaterial;
import com.bluebirdme.mes.linglong.mix.entity.FeedSwitch;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * PLM等同物料维护
 * @author 王超
 * @Date 2020-09-08 11:54:53
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EqualMaterialServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
    protected Class getEntity() {
        return EqualMaterial.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    //开关控制
    @RockWellTransactional
	public List<String> openOrclose(Map<String, Object> updated) throws Exception {
		List<String> ruturnNum = new ArrayList<>();
		String openOrclose = updated.get("type").toString();
		List<Map<String, Object>> feedList = (List<Map<String, Object>>) updated.get("updated");
		// 日志的list集合
		for (int i = 0; i < feedList.size(); i++) {
			String misString = updateFeedSwitch(feedList.get(i), openOrclose);
			if (misString != null) {
				ruturnNum.add(misString);
			}
		}
		return ruturnNum;
	}
    
    /**
	 * 修改控制表的数据
	 * @param map
	 * @param dataOnOffDate
	 */
	public String updateFeedSwitch(Map<String, Object> map, String openOrclose) {
		String numfeedswitch = null;
		String status = "0";
		if (openOrclose.indexOf("开启") != -1) {
			status = "1";
		}
		try {
			// 查询需要修改的数据
			List<Map<String, Object>> list = queryUpdate(map.get("materialcode_s").toString());
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					EqualMaterial equalMaterial = (EqualMaterial) MapTrunPojo.mapToEntity(list.get(i), EqualMaterial.class);
					if (openOrclose.indexOf("等级管控") != -1) {
						if (equalMaterial.getDummy2_s() == null) {
							equalMaterial.setDummy2_s(status);
						} else {
							if (!equalMaterial.getDummy2_s().equals(status)) {
								equalMaterial.setDummy2_s(status);
							}else {
								numfeedswitch += equalMaterial.getGroupname_s();
								return numfeedswitch;
							}
						}
					}
					update(equalMaterial);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numfeedswitch;
	}
	
	/**
	 * 查询开关要修改的数据
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryUpdate(String materialcode) throws Exception {
		Filter filter = new Filter();
		filter.set("materialcode", materialcode);
		if (getSQL("queryUpdate") == null)
			throw new Exception(getClass() + ".xml中未找到ID为queryUpdate的SQL语句定义");
		String dataSql = getSQL("queryUpdate", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		List<Map<String, Object>> listMap = query.list();
		// 大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
    	int mun = 0;
    	boolean ist = false;
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO.getDeleted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				EqualMaterial item = (EqualMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
				delete(item.getAtr_key().toString());
			}
		}
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO.getInserted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				EqualMaterial item = (EqualMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setRecord_flag_s("A");
				item.setCreated_by_s(WebUtils.getUser().userCode);
				item.setCreated_name_s(WebUtils.getUser().userName);
				item.setCreated_time_t(new Date());
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("record_flag_s", "A");
				where.andEqual("materialcode_s", item.getMaterialcode_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				if (list.size() != 0) {
					ist = true;
				}
				insertedList.add(item);
			}
			if (ist != false) {
				mun = -1;
			} else {
				save(insertedList);
			}
		}

		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO.getUpdated();
			for(Map<String, Object> newitem:equipmentmateriallist){
				EqualMaterial item = (EqualMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
				insertedList.add(item);
			}
			update(insertedList);
		}
		return mun;
    
    }
    
    /**
	 * 获取机台列表
	 * @return
	 */
	public List<Map<String, Object>> getGroupnamesList() {
		SQLQuery query = createSQLQuery(getSQL("getGroupnamesList"));
		System.out.println(getSQL("getGroupnamesList").toString());
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 获取等同物料列表
	 * @return
	 */
	public List<Map<String, Object>> getEqualMatInfo() {
		SQLQuery query = createSQLQuery(getSQL("getEqualMatInfo"));
		System.out.println(getSQL("getEqualMatInfo").toString());
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
    
	/**
	 * 获取密炼物料列表
	 * @return
	 */
	public List<Map<String, Object>> getMixMatInfo() {
		SQLQuery query = createSQLQuery(getSQL("getMixMatInfo"));
		System.out.println(getSQL("getMixMatInfo").toString());
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

}