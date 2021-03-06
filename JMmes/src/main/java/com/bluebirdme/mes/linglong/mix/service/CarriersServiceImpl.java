/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.Carriers;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
/**
 * 密炼载具信息表
 * @author 王超
 * @Date 2020-08-03 15:27:50
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CarriersServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return Carriers.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
    	int mun = 0;
    	boolean ist = false;
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List<Map<String, Object>> equipmentmateriallist = rockWellEntityDTO.getDeleted();
			for(Map<String, Object> newitem:equipmentmateriallist){
				Carriers item = (Carriers)MapTrunPojo.mapToEntity(newitem, getEntity());
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
				Carriers item = (Carriers)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setRecord_flag_s("A");
				item.setCreated_by_s(WebUtils.getUser().userCode);
				item.setCreated_time_t(new Date());
				if (item.getIsuse_s().equals("已使用")) {
					item.setIsuse_s("1");
				} else {
					item.setIsuse_s("0");
				}
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("record_flag_s", "A");
				where.andEqual("carrier_code_s", item.getCarrier_code_s());
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
				Carriers item = (Carriers)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(WebUtils.getUser().userCode);
				if (item.getIsuse_s().equals("已使用")) {
					item.setIsuse_s("1");
				} else {
					item.setIsuse_s("0");
				}
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("record_flag_s", "A");
				where.andEqual("carrier_code_s", item.getCarrier_code_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						if (!list.get(i).get("ATR_KEY").toString().equals(item.getAtr_key().toString())) {
							ist = true;
						}
					}
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
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toUserName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toUserName"));
		query.setParameter("usercode", usercode);
		System.out.println(getSQL("toUserName").toString());
		TransformUpperCase transformUpperCase = new TransformUpperCase();
		List<Map<String, Object>> result_1 = query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}

}
