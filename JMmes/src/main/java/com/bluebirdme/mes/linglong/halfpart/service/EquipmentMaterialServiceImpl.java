/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.pnuts.xml.newDocument;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.spring.SpringContext;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.EquipmentMaterial;

import org.xdemo.app.xutils.j2se.ListUtils;
import org.xdemo.app.xutils.j2se.StringUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.pnutsfunctions.gui.datePicker;

import java.util.Date;
/**
 * 半部件机台物料维护
 * @author 王超
 * @Date 2020-03-03 16:10:49
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EquipmentMaterialServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return EquipmentMaterial.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public Map<String, Object> datagridgroupUDA(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridgroupRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridgroupTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridgroupRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("searchMaterialGroupAndIsPrimary") == null)
			throw new Exception(getClass() + ".xml中未找到ID为searchMaterialGroupAndIsPrimary的SQL语句定义");

		String dataSql = getSQL("searchMaterialGroupAndIsPrimary", filter.getFilter());
		System.out.println(dataSql);
		filter.set("equipmentcode_s", getEquipCodeByName(filter.get("equipmentcode_s")));
		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
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

	public Long datagridgroupTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("searchMaterialGroupAndIsPrimaryTotal") == null)
			throw new Exception(getClass() + ".xml中未找到ID为searchMaterialGroupAndIsPrimaryTotal的SQL语句定义");

		String totalSql = getSQL("searchMaterialGroupAndIsPrimaryTotal", filter.getFilter());

		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO equipmentmaterial) throws Exception{
        
    	int mun = 0;
    	boolean ist = false;
		
		if (!ListUtils.isEmpty(equipmentmaterial.getDeleted())) {
			List<Map<String, Object>> equipmentmateriallist = equipmentmaterial.getDeleted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				EquipmentMaterial item = (EquipmentMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 修改存在状态
				item.setRecord_flag_s("D");
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				update(item);
			}
		}
		
		if (!ListUtils.isEmpty(equipmentmaterial.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = equipmentmaterial.getInserted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				EquipmentMaterial item = (EquipmentMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setRecord_flag_s("A");
				item.setCreated_by_s(WebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setMaterialcode_s(getMaterialCodeByGroup(item.getMaterialgroup_s()).get(0).get("part_number").toString());
				item.setEquipmentcode_s(getEquipCodeByName(item.getEquipmentcode_s()).get(0).get("p_line_name").toString());
				item.setMaterialgroup_s(getCodeByGroupName(item.getMaterialgroup_s()).get(0).get("dictcode_s").toString());
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("equipmentcode_s", item.getEquipmentcode_s());
				where.andEqual("materialgroup_s", item.getMaterialgroup_s());
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

		if (!ListUtils.isEmpty(equipmentmaterial.getUpdated())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = equipmentmaterial.getUpdated();
			for(Map<String, Object> newitem:equipmentmateriallist){
				EquipmentMaterial item = (EquipmentMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setMaterialcode_s(getMaterialCodeByGroup(item.getMaterialgroup_s()).get(0).get("part_number").toString());
				item.setMaterialgroup_s(getCodeByGroupName(item.getMaterialgroup_s()).get(0).get("dictcode_s").toString());
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("equipmentcode_s", item.getEquipmentcode_s());
				where.andEqual("materialgroup_s", item.getMaterialgroup_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);

				if (list.size() > 1) {
					ist = true;
				}
				insertedList.add(item);
			}
			// 页面输入与数据库的查重
			if (ist != false) {
				mun = -1;
			} else {
				update(insertedList);
			}
		}
		return mun;
    
    }
    
	/**
	 * 查出机台条码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchEquipmentCode(Map<String,String> map) throws Exception {
		String p_line_name="";
		String category="";
		String description="";
		String sortname="";
		String sortorder="";
		if(map.size()>0){
			p_line_name=map.get("p_line_name").toString();
			description=map.get("description").toString();
			category=map.get("category").toString();
			if(map.containsKey(sortname)){
				sortname="p."+map.get(sortname).toString();
				sortorder=map.get(sortorder).toString();
			}
		}
		Filter filter=new Filter();
		filter.set("lineCode", p_line_name);
		filter.set("description", description);
		filter.set("process_s",Process.HalfPart);
		filter.set("category", category);
		filter.set("sitename", LLWebUtils.factory());
		filter.setSort(sortname);
		filter.setOrder(sortorder);
  		SQLQuery query=createSQLQuery(getSQL("searchEquipmentCode",filter));
  		List<Map<String, Object>> res=query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}
	
	/**
	 * 查出物料编码显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialCode() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialCode"));
		if (LLWebUtils.factory() == "1") {
			query.setParameter("sfs", "%半钢%");
		} 
		if (LLWebUtils.factory() == "2") {
			query.setParameter("sfs", "%全钢%");	
		}
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据机台条码查询物料
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialByEquipCode(String equipmentcode) {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialByEquipCode"));
		query.setParameter("equipmentcode_s", equipmentcode);
		List<Map<String, Object>> res = query.list();
  		List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
  		for (int i = 0; i < res.size(); i++) {
			list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
		}
		return list_new;
	}
	
	/**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialGroup() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialGroup"));
		String sfs = "";
		if (LLWebUtils.factory().equals("1")) {
			sfs = "%半钢%";
		} 
		if (LLWebUtils.factory().equals("2")) {
			sfs = "%全钢%";
		}
		query.setParameter("sfs", sfs);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
		
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toUserName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toUserName"));
		query.setParameter("usercode", usercode);
		System.out.println(getSQL("toUserName").toString());
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getMaterialNameByCode(String materialcode) {
		SQLQuery query = createSQLQuery(getSQL("getMaterialNameByCode"));
		query.setParameter("materialcode", materialcode);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据物料组查询物料
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getMaterialCodeByGroup(String materialgroup) {
		SQLQuery query = createSQLQuery(getSQL("getMaterialCodeByGroup"));
		query.setParameter("materialgroup", materialgroup);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据机台名查询机台编码
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getEquipCodeByName(String equipname) {
		SQLQuery query = createSQLQuery(getSQL("getEquipCodeByName"));
		query.setParameter("equipname", equipname);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据机台编码查询机台名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toEquipName(String equipcode) {
		SQLQuery query = createSQLQuery(getSQL("toEquipName"));
		query.setParameter("equipcode", equipcode);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据机台名称过滤物料组
	 * 
	 * @return
	 */
	public List<Map<String, Object>> filteByEquipName(String eqname) {
		SQLQuery query = createSQLQuery(getSQL("filteByEquipName"));
		String sfs = "";
		if (LLWebUtils.factory().equals("1")) {
			sfs = "%半钢%";
		} 
		if (LLWebUtils.factory().equals("2")) {
			sfs = "%全钢%";
		}
		query.setParameter("sfs", sfs);
		query.setParameter("eqcode", getEquipCodeByName(eqname).get(0).get("p_line_name").toString());
		System.out.println(getSQL("filteByEquipName"));
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据物料组编号查询物料组名称
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getNameByGroupCode(String materialgroup_s) {
		SQLQuery query = createSQLQuery(getSQL("getNameByGroupCode"));
		query.setParameter("materialgroup_s", materialgroup_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	/**
	 * 根据物料组名称查询物料组编号
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getCodeByGroupName(String materialgroup_s) {
		SQLQuery query = createSQLQuery(getSQL("getCodeByGroupName"));
		query.setParameter("materialgroup_s", materialgroup_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
}
