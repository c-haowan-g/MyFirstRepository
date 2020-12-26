/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.TyreReasAlermMaintain;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 外观检测后工序报警病象计数配置表
 * @author 司乔靖
 * @Date 2019-05-20 11:10:40
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TyreReasAlermMaintainServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return TyreReasAlermMaintain.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	int mun = 0;
		boolean ist = false;
		//String reas_code_s = null;
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List<Map<String, Object>> Lists = rockWellEntityDTO.getDeleted();
        	for(Map<String, Object> newitem:Lists)
        	{
        		TyreReasAlermMaintain item = (TyreReasAlermMaintain)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setRecord_flag_s("D");
        		// 修改创建时间
				Date date = new Date();
        		item.setChanged_by_s(LLWebUtils.getUser().userCode);
        		Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_time_t(timestamp);
				update(item);
        	}
            //update(Lists);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List insertedList = new ArrayList<>();
        	List<Map<String, Object>> Lists = rockWellEntityDTO.getInserted();
        	for(Map<String, Object> newitem:Lists)
        	{
        		TyreReasAlermMaintain item = (TyreReasAlermMaintain)MapTrunPojo.mapToEntity(newitem, getEntity());
        		item.setS_factory_s(LLWebUtils.factory());
        		item.setCreated_by_s(LLWebUtils.getUser().userCode);
        		// 添加时间
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setCreated_time_t(timestamp);
        		item.setRecord_flag_s("A");
        		item.setArch_flag_s("0");
        		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		item.setProess_s("252008");
        		
        		// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("reas_code_s", item.getReas_code_s());
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
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
        	List<Map<String, Object>> Lists = rockWellEntityDTO.getUpdated();
        	for(Map<String, Object> newitem:Lists)
        	{
        		TyreReasAlermMaintain item = (TyreReasAlermMaintain)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
        		item.setChanged_by_s(LLWebUtils.getUser().userCode);
        		item.setCreated_time_t(timestamp);
        		// 与数据库数据对查重判断
				Where where = new Where();
//				where.andEqual("reas_code_s", item.getReas_code_s());
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				
				
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
     * 获取所有病象
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<Map<String,Object>> getReasByCode()throws Exception{
    	Filter filter=new Filter();
    	filter.set("reas_grp_type_s", "261003");
    	filter.set("factory", LLWebUtils.factory());
    	SQLQuery query = createSQLQuery(getSQL("getReasByCode"));
    	
    	query.setParameter("reas_grp_type_s", "261003");
    	query.setParameter("factory", LLWebUtils.factory());
    	//setParameter(query, filter);
    	List<Map<String,Object>> lists=query.list();
    	return lists;
    }
    
   
    
    
    
//    /**
//     * 获取数据datagrid
//     */
//    public TyreReasAlerMaintainATO datagrid_min(Filter filter, Page page,Class classz)throws Exception{
//    	//createSQLQuery(getSQL("datagrid_rows"), dto)
//    	return null;
//    } 
}






