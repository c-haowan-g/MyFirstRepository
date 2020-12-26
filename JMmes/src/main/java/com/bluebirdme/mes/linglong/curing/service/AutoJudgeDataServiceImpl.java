/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

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

import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.AutoJudgeDatas;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

/**
 * 硫化报警参数（零售）
 * 
 * @author 时永良
 * @Date 2019年7月19日08:51:15
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AutoJudgeDataServiceImpl extends RockWellBaseServiceImpl<AutoJudgeDatas> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return AutoJudgeDatas.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy() {
		SQLQuery query = createSQLQuery(getSQL("searchBy"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		return query.list();
	}

	@RockWellTransactional
	public void save(AutoJudgeDatas t) throws Exception {
		RockWellUtils.save(t);
	}
	/**
	 * 修改汇总
	 * 
	 * @param rblist
	 * @param rhlist
	 * @throws Exception 
	 */
	@RockWellTransactional
	public void updateAll(List<Map<String, Object>> list) throws Exception {
		if (list.size() == 14) {
			if (list.get(13).get("DIV").equals("rbDiv")) {
				rbUpdate(list);
			} else if (list.get(13).get("DIV").equals("rhDiv")) {
				rhUpdate(list);
			}
		}else {
			if (list.size() == 18) {
				if (list.get(17).get("DIV").equals("nywDiv")) {
					nywUpdate(list);
				}
			}else {
				if (list.get(116).get("DIV").equals("nyyDiv")) {
					nyyUpdate(list);
				}
			}

		}

	}

	/**
	 * 修改热板数据
	 * @throws Exception 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RockWellTransactional
	public void rbUpdate(List<Map<String, Object>> list) throws Exception {
		// 传值回来的map
		Map<String, Object> map = list.get(0);
		List<String> listKey = new ArrayList<>(); 
		//修改条件
		Map<String,Object> mapWhere = new HashMap<>();
		//修改值
		Map<String,Object> mapValue = new HashMap<>();
		
		//延时秒数
		String time  = null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getKey().indexOf("Time") != -1) {
			   time=entry.getValue().toString();
			} else {
			   listKey.add(entry.getKey().subSequence(0, 7).toString());
			}
			   listKey = RemoveDuplicate.removeDuplicate(listKey);
		}
		
		for(int i=0;i<listKey.size();i++){
			for (String key : map.keySet()) {
				if (key.indexOf(listKey.get(i)) != -1) {
						if (key.indexOf("l") != -1) {
							String L=(String) map.get(key);
							mapValue.put("limit_lower_s", L);
						}
						if (key.indexOf("p") != -1) {
							String p =(String) map.get(key);
							mapValue.put("limit_upper_s", p);
						}
						if (key.subSequence(7, 8).equals("a")) {
							String A =(String) map.get(key);
							mapValue.put("limit_lower_s", A);
						}
						if (key.subSequence(7, 8).equals("b")) {
							String B = (String) map.get(key);
							mapValue.put("limit_upper_s", B);
						}
						if (key.indexOf("JUDGE") != -1) {
							String JUDGE = (String) map.get(key);
							mapValue.put("judge_lever_s", JUDGE);
						}
						
					}
			  }
			mapValue.put("changed_by_s", WebUtils.getUser().userCode);
			// 创建时间的添加
			Date date = new Date();
			Timestamp timestamp = DateUtil.dateToTime(date);
			mapValue.put("changed_time_t",timestamp);
			mapValue.put("valid_delay_s",time);
			mapWhere.put("alarm_deal_code_s", listKey.get(i));
			mapWhere.put("isoere_s", "RE");
			mapWhere.put("s_factory_s", LLWebUtils.factory());
			update(mapWhere,mapValue);
			mapValue.clear();
		 }
		
	
	}

	/**
	 * 热环温度
	 * @param list
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RockWellTransactional
	public void rhUpdate(List<Map<String, Object>> list) throws Exception {
		// 传值回来的map
		Map<String, Object> map = list.get(0);
		List<String> listKey = new ArrayList<>(); 
		//修改条件
		Map<String,Object> mapWhere = new HashMap<>();
		//修改值
		Map<String,Object> mapValue = new HashMap<>();
		//延时秒数
		String time  = null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getKey().indexOf("Time") != -1) {
			   time=entry.getValue().toString();
			} else {
			   listKey.add(entry.getKey().subSequence(0, 7).toString());
			}
			   listKey = RemoveDuplicate.removeDuplicate(listKey);
		}
		
		for(int i=0;i<listKey.size();i++){
			for (String key : map.keySet()) {
				if (key.indexOf(listKey.get(i)) != -1) {

					if (key.indexOf("l") != -1) {
						String L=(String) map.get(key);
						mapValue.put("limit_lower_s", L);
					}
					if (key.indexOf("p") != -1) {
						String p =(String) map.get(key);
						mapValue.put("limit_upper_s", p);
					}
					if (key.subSequence(7, 8).equals("a")) {
						String A =(String) map.get(key);
						mapValue.put("limit_lower_s", A);
					}
					if (key.subSequence(7, 8).equals("b")) {
						String B = (String) map.get(key);
						mapValue.put("limit_upper_s", B);
					}
					if (key.indexOf("JUDGE") != -1) {
						String JUDGE = (String) map.get(key);
						mapValue.put("judge_lever_s", JUDGE);
					}
				 }
			}
			mapValue.put("changed_by_s", WebUtils.getUser().userCode);
			// 创建时间的添加
			Date date = new Date();
			Timestamp timestamp = DateUtil.dateToTime(date);
			mapValue.put("changed_time_t",timestamp);
			mapValue.put("valid_delay_s",time);
			mapWhere.put("alarm_deal_code_s", listKey.get(i));
			mapWhere.put("isoere_s", "RE");
			mapWhere.put("s_factory_s", LLWebUtils.factory());
			update(mapWhere,mapValue);
			mapValue.clear();
		 }
	}
	
	
	/**
	 * 修改内压温度数据
	 * @throws Exception 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RockWellTransactional
	public void nywUpdate(List<Map<String, Object>> list) throws Exception {
		// 传值回来的map
		Map<String, Object> map = list.get(0);
		List<String> listKey = new ArrayList<>(); 
		//修改条件
		Map<String,Object> mapWhere = new HashMap<>();
		//修改值
		Map<String,Object> mapValue = new HashMap<>();
		//延时秒数
		String time  = null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getKey().indexOf("Time") != -1) {
			   time=entry.getValue().toString();
			} else {
			   listKey.add(entry.getKey().subSequence(0, 7).toString());
			}
			   listKey = RemoveDuplicate.removeDuplicate(listKey);
		}
		//多长时间之后
		String value_two_s="";
		for(int i=0;i<listKey.size();i++){
			for (String key : map.keySet()) {
				value_two_s = (String) map.get("EMC3011t");
				if (key.indexOf(listKey.get(i)) != -1) {
						if (key.indexOf("l") != -1) {
							String L=(String) map.get(key);
							mapValue.put("limit_lower_s", L);
						}
						if (key.indexOf("p") != -1) {
							String p =(String) map.get(key);
							mapValue.put("limit_upper_s", p);
						}
						if (key.subSequence(7, 8).equals("a")) {
							String A =(String) map.get(key);
							mapValue.put("limit_lower_s", A);
						}
						if (key.subSequence(7, 8).equals("b")) {
							String B = (String) map.get(key);
							mapValue.put("limit_upper_s", B);
						}
						if (key.subSequence(7, 8).equals("t")) {
							String T = (String) map.get(key);
							mapValue.put("value_two_s", T);
						}
						if (key.indexOf("JUDGE") != -1) {
							String JUDGE = (String) map.get(key);
							mapValue.put("judge_lever_s", JUDGE);
						}
						
					}
			  }
			mapValue.put("value_two_s", value_two_s);
			mapValue.put("changed_by_s", WebUtils.getUser().userCode);
			// 创建时间的添加
			Date date = new Date();
			Timestamp timestamp = DateUtil.dateToTime(date);
			mapValue.put("changed_time_t",timestamp);
			mapValue.put("valid_delay_s",time);
			mapWhere.put("alarm_deal_code_s", listKey.get(i));
			mapWhere.put("isoere_s", "RE");
			mapWhere.put("s_factory_s", LLWebUtils.factory());
			update(mapWhere,mapValue);
			value_two_s="";
			mapValue.clear();
		 }
	}

	/**
	 * 修改内压压力数据
	 * @throws Exception 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@RockWellTransactional
	public void nyyUpdate(List<Map<String, Object>> list) throws Exception {
		// 传值回来的map
		Map<String, Object> map = list.get(0);
		//修改条件
		Map<String,Object> mapWhere = new HashMap<>();
		//修改值
		Map<String,Object> mapValue = new HashMap<>();
		//修改时间集合
		List<Map<String,Object>> listMapTime= new ArrayList<Map<String,Object>>();
		List<String> listKey = new ArrayList<>(); 
		//延时秒数
		String time  = null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getKey().indexOf("Time") != -1) {
			   time=entry.getValue().toString();
			} else {
			   listKey.add(entry.getKey().subSequence(0, 7).toString());
			}
			   listKey = RemoveDuplicate.removeDuplicate(listKey);
		}
		
		for(int i=0;i<listKey.size();i++){
			for (String key : map.keySet()) {
				if (key.indexOf(listKey.get(i)) != -1) {
						if (key.indexOf("l") != -1) {
							String L=(String) map.get(key);
							mapValue.put("limit_lower_s", L);
						}
						if (key.indexOf("p") != -1) {
							String p =(String) map.get(key);
							mapValue.put("limit_upper_s", p);
						}
						if (key.subSequence(7, 8).equals("a")) {
							String A =(String) map.get(key);
							mapValue.put("limit_lower_s", A);
						}
						if (key.subSequence(7, 8).equals("b")) {
							String B = (String) map.get(key);
							mapValue.put("limit_upper_s", B);
						}
						if (key.subSequence(7, 8).equals("t")) {
							String T = (String) map.get(key);
							mapValue.put("value_two_s", T);
							/*Map<String,Object> mapTime= new HashMap<>();
							mapTime.put("key_id", listKey.get(i));
							mapTime.put("Value", T);
							listMapTime.add(mapTime);*/
						}
						if (key.indexOf("JUDGE") != -1) {
							String JUDGE = (String) map.get(key);
							mapValue.put("judge_lever_s", JUDGE);
						}
						
					}
			  }
			
			mapValue.put("changed_by_s", WebUtils.getUser().userCode);
			// 创建时间的添加
			Date date = new Date();
			Timestamp timestamp = DateUtil.dateToTime(date);
			mapValue.put("changed_time_t",timestamp);
			mapValue.put("valid_delay_s",time);
			mapWhere.put("alarm_deal_code_s", listKey.get(i));
			mapWhere.put("isoere_s", "RE");
			mapWhere.put("s_factory_s", LLWebUtils.factory());
			update(mapWhere,mapValue);
			mapValue.clear();
		 }
		//updateNyylTime(listMapTime);
	}
	
	/**
	 * 
	 * @param list 修改条件
	 */
	@RockWellTransactional
	public void updateNyylTime(List<Map<String,Object>> list){
		for(int i =0;i<list.size();i++){
			SQLQuery query = createSQLQuery(getSQL("addSaveQuery"));
			query.setParameter("s_factory_s", LLWebUtils.factory());
			query.setParameter("alarm_deal_code_s", list.get(i).get("key_id"));
			List<Map<String,Object>> listMap=query.list();
			
			SQLQuery queryid = createSQLQuery(getSQL("queryIdUpdate"));
			queryid.setParameter("plc_pointdesc_s", listMap.get(0).get("PLC_POINTDESC_S"));
			queryid.setParameter("isoere_s", listMap.get(0).get("ISOERE_S"));
			queryid.setParameter("value_one_s", listMap.get(0).get("VALUE_ONE_S"));
			queryid.setParameter("s_factory_s", listMap.get(0).get("S_FACTORY_S"));
			List<Map<String,Object>> listMapID=query.list();
			for(Map<String,Object> map_idMap : listMapID){
				try {
					update(map_idMap.get("ATR_KEY").toString(),"value_two_s",list.get(i).get("Value"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
}
	
	
	
	
