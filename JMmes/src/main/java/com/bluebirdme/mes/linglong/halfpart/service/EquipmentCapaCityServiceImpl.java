/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.bluebirdme.mes.linglong.halfpart.entity.Equipmentcapacity;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

import java.util.Date;
/**
 * 半部件全钢机台产能维护
 * @author 李德晓
 * @Date 2020-01-22 08:38:14
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EquipmentCapaCityServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Equipmentcapacity.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
   
	@RockWellTransactional
    public int saveChanges(RockWellEntityDTO equipmentcapacity) throws Exception {
		int mun = 0;
		boolean ist = false;
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		
		if (!ListUtils.isEmpty(equipmentcapacity.getDeleted())) {
			
			List<Map<String, Object>> equipmentcapacitys = equipmentcapacity.getDeleted();
			for(Map<String, Object> newitem:equipmentcapacitys){
				Equipmentcapacity item = (Equipmentcapacity)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 修改存在状态
				item.setRecord_flag_s("D");
				// 修改创建时间
				Date date = new Date();
				item.setChanged_by_s(
						WebUtils.getUser().userName);
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_time_t(timestamp);
				update(item);
			}

		}
		
		
		if (!ListUtils.isEmpty(equipmentcapacity.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> equipmentcapacitylist = equipmentcapacity.getInserted();
			for(Map<String, Object> newitem:equipmentcapacitylist){
				Equipmentcapacity item = (Equipmentcapacity)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setRecord_flag_s("A");
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setCreated_time_t(new Date());
				item.setCreated_by_s(LLWebUtils.getUser().userName);
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

		if (!ListUtils.isEmpty(equipmentcapacity.getUpdated())) {
			int con = equipmentcapacity.getUpdated().size();
			List insertedList = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				Equipmentcapacity item = (Equipmentcapacity) MapTrunPojo.mapToEntity(equipmentcapacity.getUpdated().get(i),
						Equipmentcapacity.class);
				item.setChanged_by_s(LLWebUtils.getUser().userName);
				item.setChanged_time_t(new Date());
				
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				/*where.andEqual("equipmentcode_s", item.getEquipmentcode_s());
				where.andEqual("materialgroup_s", item.getMaterialgroup_s());
				//where.andEqual("materialcapacity_f", item.getMaterialcapacity_f());
				List<Map<String, Object>> list = findMapByWhere(where);
				
				System.err.println(list);

				if (list.size() != 0) {
					ist = true;
				}*/
				insertedList.add(item);
			}
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
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
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> searchMaterialGroup() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialGroup"));		
		return query.list();
	}

	/**
	 * 查出机台名称显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchDescription() {
		SQLQuery query =  createSQLQuery(getSQL("searchDescription"));
		return query.list();
	}


}
