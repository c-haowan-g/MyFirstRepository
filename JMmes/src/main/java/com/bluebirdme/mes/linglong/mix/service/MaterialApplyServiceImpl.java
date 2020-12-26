/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.MaterialApply;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * 密炼领料管理
 * @author 王超
 * @Date 2020-08-07 09:12:17
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaterialApplyServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return MaterialApply.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    /**
	 * 根据机台条码查询名称
	 * @return
	 */
	public List<Map<String, Object>> searchMixEquipName(String equipcode) {
		SQLQuery query = createSQLQuery(getSQL("searchMixEquipName"));
		if (LLWebUtils.factory().equals("1")) {
			query.setParameter("factory", "80231MX");
		} else {
			query.setParameter("factory", "80232MX");
		}
		query.setParameter("equipcode", equipcode);
		System.out.println(getSQL("searchMixEquipName").toString());
		TransformUpperCase transformUpperCase = new TransformUpperCase();
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
    	int mun = 0;
    	boolean ist = false;
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO.getDeleted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				MaterialApply item = (MaterialApply)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 修改存在状态
				item.setRecord_flag_s("D");
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				update(item);
			}
		}
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO.getInserted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				MaterialApply item = (MaterialApply)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setRecord_flag_s("A");
				item.setCreated_by_s(WebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				item.setEquip_name_s(searchMixEquipName(item.getEquip_code_s()).get(0).get("description").toString());
				if (StringHelper.isNullOrEmpty(item.getQty_receive_f())) {
					item.setQty_receive_f("0");
				}
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("record_flag_s", "A");
				where.andEqual("apply_no_s", item.getApply_no_s());
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
				MaterialApply item = (MaterialApply)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				if (item.getStatus_check_s().toString().equals("064001")) {
					item.setCheck_by_s(null);
					item.setCheck_name_s(null);
					item.setCheck_time_t(null);
				}
				if (item.getStatus_check_s().toString().equals("064002")) {
					item.setCheck_by_s(WebUtils.getUser().userCode);
					item.setCheck_name_s(WebUtils.getUser().userName);
					item.setCheck_time_t(new Date());
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
    
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}
    public Map<String, Object> datagridUDA2(Filter filter, Page page) throws Exception {

		


		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
		System.out.println(dataSql);

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

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

}
