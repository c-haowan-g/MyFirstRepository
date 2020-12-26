/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.building.entity.MouldSpec;
import com.bluebirdme.mes.linglong.building.entity.Mouldstock;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import freemarker.template.TemplateException;
/**
 * 机头库存表
 * @author lnk
 * @Date 2019-01-11 17:24:50
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MouldstockServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Mouldstock.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
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
	
    public List<Map<String, Object>> searchByLocation() throws TemplateException, IOException {
		SQLQuery query = createSQLQuery(getSQL("searchByLocation"));
		query.setParameter("factory",LLWebUtils.factory());
		return query.list();
	}
    
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	int mun = -1;
    	boolean slv = true;
    	boolean ist = false;
        // 机头编码
    	String capsule_code_s =null;
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List<Object> ruplicateList = new ArrayList<>();
		
    	//删除方法
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List<Map<String, Object>> mouldsstocklist = rockWellEntityDTO.getDeleted();
        	List newList=new ArrayList<>();
        	for(Map<String, Object> newitem:mouldsstocklist){
        		Mouldstock item = (Mouldstock)MapTrunPojo.mapToEntity(newitem, getEntity());
        		//修改存在状态
        		item.setRecord_flag_s("D");
        		String delsql= "update AT_B_BM_MOULDSPEC SET RECORD_FLAG_S='D' where  CAPSULE_CODE_S='"+item.getCapsule_code_s()+"'";
        		RockWellUtils.execSQL(delsql);
        		//修改创建时间
        		Date date = new Date();
        		Timestamp timestamp = DateUtil.dateToTime(date);
        		item.setChanged_by_s(WebUtils.getUser().userCode);
        		item.setChanged_time_t(timestamp);
        		newList.add(item);
			}
        	update(newList);
        	mun = 0;
        }
        //添加方法
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List<Map<String, Object>> mouldsstocklist = rockWellEntityDTO.getInserted();
            List newList=new ArrayList<>();
        	for(Map<String, Object> newitem:mouldsstocklist){
        		Mouldstock item = (Mouldstock)MapTrunPojo.mapToEntity(newitem, getEntity());
        		
        		//添加创建人
        		item.setCreated_by_s(WebUtils.getUser().userCode);
        		//添加创建时间
        		Date date = new Date();
        		Timestamp timestamp = DateUtil.dateToTime(date);
        		item.setCreated_time_t(timestamp);
        		item.setS_factory_s(LLWebUtils.factory());
        		//默认参数
        		item.setAlarm_number_s("0");
        		item.setRecord_flag_s("A");
        		item.setS_factory_s(LLWebUtils.factory());
        		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		capsule_code_s = item.getCapsule_code_s();
        		// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("capsule_code_s", capsule_code_s);
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				List<Map<String, Object>> list = findMapByWhere(where);
				addString.add(capsule_code_s);
				ruplicateList.add(capsule_code_s);
				if (list.size() != 0   ) {
					ist = true;
				}
				if(LLWebUtils.factory().equals(FactoryConstant.BAN_GANG)){
					if(item.getCapsule_code_s().length() == 9 ){
						if( item.getCapsule_code_s().subSequence(0, 3).equals("HBJ")){
							slv =true;
						}else{
							slv =false;
							mun =-2;
						}
					}else{
						slv =false;
						mun =-2;
					}
				}
				
				if(LLWebUtils.factory().equals(FactoryConstant.QUAN_GANG)){
					if(item.getCapsule_code_s().length() == 9 ){
						if( item.getCapsule_code_s().subSequence(0, 3).equals("FBJ")){
							slv =true;
						}else{
							slv =false;
							mun =-2;
						}
					}else{
						slv =false;
						mun =-2;
					}
				}
				newList.add(item);
        	}
        	
        	// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
			if (addString.size() != ruplicateList.size()) {
				ist = true;
			}
			if (ist != false || slv == false) {
				
			} else{
				//保存
				save(newList);
				mun = 0;
			}
			ruplicateList.clear();
			addString.clear();
        }
        
        
        //修改方法
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	List<Map<String, Object>> mouldsstocklist = rockWellEntityDTO.getUpdated();
        	List newList=new ArrayList<>();
        	for(Map<String, Object> newitem:mouldsstocklist){
        		Mouldstock item = (Mouldstock)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_by_s(WebUtils.getUser().userCode);
				item.setCreated_time_t(timestamp);
				capsule_code_s = item.getCapsule_code_s();
				//atr_key = mouldstockslist.get(i).getAtr_key();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("capsule_code_s", capsule_code_s);
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				//List<Map<String, Object>> list = findMapByWhere(where);
				Long atr_key = item.getAtr_key();
				BigDecimal rs1 = (BigDecimal) getSession().createSQLQuery(getSQL("update1"))
						.setParameter("capsulecode_s", capsule_code_s)
						.setParameter("s_factory_s", LLWebUtils.factory())
						.setParameter("atr_key", atr_key).uniqueResult();
				
				
				addString.add(capsule_code_s);
				ruplicateList.add(capsule_code_s);
				if (rs1.intValue() != 0) {
					ist = true;
				}
				if(item.getCapsule_code_s().length() == 9 ){
					if( item.getCapsule_code_s().subSequence(2, 3).equals("J")){
						slv =true;
					}else{
						slv =false;
						mun =-2;
					}
				}else{
					slv =false;
					mun =-2;
				}
				newList.add(item);
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		ist = true;
        	}
        	// 页面输入与数据库的查重
        	if (ist != false || slv == false) {
        		
        	} else {
        		update(newList);
        		mun = 0;
        	}
        }
		return mun;
     
    }

}
