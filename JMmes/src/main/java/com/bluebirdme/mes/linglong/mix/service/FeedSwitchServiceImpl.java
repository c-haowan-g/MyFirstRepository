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

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.FeedSwitch;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSImplementService;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSInterface;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;

import java.util.Date;

/**
 * 密炼投料防错管控
 * 
 * @author 王超
 * @Date 2020-08-08 10:22:36
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FeedSwitchServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	/**
	 * ServiceImpl可以继承RockWellBaseServiceImpl,
	 * RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 * 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 * 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候
	 * ，返回值为List<Map<String,Object>>类型。
	 * RockWellBaseServiceImpl使用datagrid查询返回的是List
	 * <T>类型，这个类型是根据Controller里面，调用datagrid
	 * 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 * 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 * List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 * 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 * 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 * 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
	@Resource
	LingLongDataSource llds;
	
	@Resource
	PlanServiceImpl planSrv;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return FeedSwitch.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	public String downward(String recipecodelist[]) throws Exception {
		StringBuffer sb = new StringBuffer();
		String recipecode = "";
		int sucCount = 0;
		StringBuffer falseinfo = new StringBuffer();
		for (int i = 0; i < recipecodelist.length; i++) {
			recipecode = recipecodelist[i];
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			String result = "False";
			result = portType.reciveFeedSwitchSendByMES((String) null,
					(String) null, recipecode, LLWebUtils.getUser().userCode,
					LLWebUtils.getUser().userName);
			if (result.equals("OK"))
				sucCount++;
			else
				falseinfo.append((new StringBuilder()).append(recipecode)
						.append("下发失败，返回结果：").append(result).append("<br>")
						.toString());
		}
		sb.append("合计：" + recipecodelist.length + "条，" + "成功：" + sucCount
				+ "条；" + "失败：" + (recipecodelist.length - sucCount) + "条");
		sb.append("<br>");
		sb.append(falseinfo.toString());
		return sb.toString();
	}

	// 获取物料组信息
	public List<Map<String, Object>> getGroupName(String equip_code_s,
			String mater_type_s) {
		String matertypeStr[] = mater_type_s.split(",");
		SQLQuery query = createSQLQuery(getSQL("getGroupName"));
		query.setParameter("equip_code_s", equip_code_s);
		query.setParameterList("mater_type_s", matertypeStr);
		List<Map<String, Object>> listMap = query.list();
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}
	
	// 获取防错机台信息
	public List<Map<String, Object>> getfeedswitchequipall() {
		SQLQuery query = createSQLQuery(getSQL("getfeedswitchequipall"));
		String s_factory_s = "";
		if (LLWebUtils.factory().equals("1")) {
			s_factory_s = "1";
		}else {
			s_factory_s = "2";
		}
		query.setParameter("s_factory_s", s_factory_s);
		List<Map<String, Object>> listMap = query.list();
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		try {
			List<Map<String, Object>> listplm = planSrv.getplmByPlinenameall();
			for (int i = 0; i < returnlist.size(); i++) {
				for (int j = 0; j < listplm.size(); j++) {
					if (listplm.get(j).get("p_line_name").equals(returnlist.get(i).get("equip_code_s"))) {
						listplm.remove(j);
					}
				}
			}
			return listplm;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 开关控制
	@RockWellTransactional
	public List<String> openOrclose(Map<String, Object> updated)
			throws Exception {
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
	 * 
	 * @param map
	 * @param dataOnOffDate
	 */
	public String updateFeedSwitch(Map<String, Object> map, String openOrclose) {
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		String numfeedswitch = null;
		String status = "0";
		if (openOrclose.indexOf("打开") != -1) {
			status = "1";
		}
		try {
			// 查询需要修改的数据
			List<Map<String, Object>> list = queryUpdate(map
					.get("equip_code_s").toString());
			FeedSwitch feedSwitch = (FeedSwitch) MapTrunPojo.mapToEntity(
					list.get(0), FeedSwitch.class);
			feedSwitch.setChanged_by_s(WebUtils.getUser().userCode);
			feedSwitch.setChanged_time_t(timestamp);
			if (openOrclose.indexOf("等同物料") != -1) {
				if (feedSwitch.getIs_equal_switch_s() == null) {
					feedSwitch.setIs_equal_switch_s(status);
				} else {
					if (!feedSwitch.getIs_equal_switch_s().equals(status)) {
						feedSwitch.setIs_equal_switch_s(status);
					} else {
						numfeedswitch = feedSwitch.getEquip_code_s();
						return numfeedswitch;
					}
				}
			}
			if (openOrclose.indexOf("顺序执行") != -1) {
				if (feedSwitch.getIs_inorder_exec_switch_s() == null) {
					feedSwitch.setIs_inorder_exec_switch_s(status);
				} else {
					if (!feedSwitch.getIs_inorder_exec_switch_s()
							.equals(status)) {
						feedSwitch.setIs_inorder_exec_switch_s(status);
					} else {
						numfeedswitch = feedSwitch.getEquip_code_s();
						return numfeedswitch;
					}
				}
			}
			if (openOrclose.indexOf("主机手设置") != -1) {
				if (feedSwitch.getIs_master_switch_s() == null) {
					feedSwitch.setIs_master_switch_s(status);
				} else {
					if (!feedSwitch.getIs_master_switch_s().equals(status)) {
						feedSwitch.setIs_master_switch_s(status);
					} else {
						numfeedswitch = feedSwitch.getEquip_code_s();
						return numfeedswitch;
					}
				}
			}
			if (openOrclose.indexOf("洗车校验") != -1) {
				if (feedSwitch.getIs_carwash_switch_s() == null) {
					feedSwitch.setIs_carwash_switch_s(status);
				} else {
					if (!feedSwitch.getIs_carwash_switch_s().equals(status)) {
						feedSwitch.setIs_carwash_switch_s(status);
					} else {
						numfeedswitch = feedSwitch.getEquip_code_s();
						return numfeedswitch;
					}
				}
			}
			if (openOrclose.indexOf("接片控制") != -1) {
				if (feedSwitch.getIs_autosp_switch_s() == null) {
					feedSwitch.setIs_autosp_switch_s(status);
				} else {
					if (!feedSwitch.getIs_autosp_switch_s().equals(status)) {
						feedSwitch.setIs_autosp_switch_s(status);
					} else {
						numfeedswitch = feedSwitch.getEquip_code_s();
						return numfeedswitch;
					}
				}
			}
			update(feedSwitch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numfeedswitch;
	}

	/**
	 * 查询开关要修改的数据
	 * 
	 * @param filter
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> queryUpdate(String equip_code_s)
			throws Exception {
		Filter filter = new Filter();
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("equip_code_s", equip_code_s);
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
	public void saveChanges(RockWellEntityDTO rockWellEntityDTO)
			throws Exception {

		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List list = new ArrayList<>();
			for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
				// 将MAP转换为实体
				FeedSwitch feedswitch = (FeedSwitch) MapTrunPojo
						.mapToEntity(rockWellEntityDTO.getDeleted().get(i),
								FeedSwitch.class);
				// feedswitch.setCreated_time_t(new Date());
				list.add(feedswitch);
			}
			delete(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List list = new ArrayList<>();
			for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
				// 将MAP转换为实体
				FeedSwitch feedswitch = (FeedSwitch) MapTrunPojo.mapToEntity(
						rockWellEntityDTO.getInserted().get(i),
						FeedSwitch.class);
				if (!StringHelper.isNullOrEmpty(feedswitch.getSpare1_s())) {
					String[] strings = feedswitch.getSpare1_s().split(",");
					String spare = "";
					for (int j = 0; j < strings.length; j++) {
						spare = spare + geterpcode(strings[j]) + ",";
					}
					spare = spare.substring(0, spare.length() - 1);
					feedswitch.setSpare1_s(spare);
				}
				feedswitch.setId_s((System.currentTimeMillis() + "").substring(9));
				feedswitch.setS_factory_s(LLWebUtils.factory());
				feedswitch.setAgenc_no_s("8023");
				feedswitch.setEquip_name_s(planSrv.searchMixEquipName(feedswitch.getEquip_code_s()).get(0).get("DESCRIPTION").toString());
				feedswitch.setCreated_by_s(LLWebUtils.getUser().userCode);
				feedswitch.setCreated_time_t(new Date());
				list.add(feedswitch);
			}
			save(list);
		}
		/**
		 * 在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
		 */
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
				// 将MAP转换为实体
				FeedSwitch feedswitch = (FeedSwitch) MapTrunPojo
						.mapToEntity(rockWellEntityDTO.getUpdated().get(i),
								FeedSwitch.class);
				feedswitch.setChanged_by_s(LLWebUtils.getUser().userCode);
				feedswitch.setChanged_time_t(new Date());
				update(feedswitch);
			}
		}

	}
	
	// 获取数据字典名称
	public List<Map<String, Object>> getDictName(String erpcodestring) {
		if (!StringHelper.isNullOrEmpty(erpcodestring)) {
			String[] strings = erpcodestring.split(",");
			String spare = "";
			for (int j = 0; j < strings.length; j++) {
				spare = spare + getdictname(strings[j]) + ",";
			}
			spare = spare.substring(0, spare.length() - 1);
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			map.put("str", spare);
			list.add(map);
			return list;
		}
		return null;
	}
	
	/**
	 * 根据用户代码获取erpcode
	 */
	public String geterpcode(String dictcode) {
		if(StringHelper.isNullOrEmpty(dictcode)){
			return "";
		}
		SQLQuery query = getSession().createSQLQuery(getSQL("geterpcode"));
		query.setParameter("dictcode", dictcode);
		return (String) query.uniqueResult();
	}
	
	/**
	 * 根据erp值获取dictname
	 */
	public String getdictname(String erpcode) {
		if(StringHelper.isNullOrEmpty(erpcode)){
			return "";
		}
		SQLQuery query = getSession().createSQLQuery(getSQL("getdictname"));
		query.setParameter("erpcode", erpcode);
		return (String) query.uniqueResult();
	}
	
	// 获取物料组名称
	public List<Map<String, Object>> getMaterialGroupBySpare(String sparestring) {
		String[] stringscode = sparestring.split(",");
		String spare = "";
		for (int i = 0; i < stringscode.length; i++) {
			spare = spare + geterpcode(stringscode[i]) + ",";
		}
		spare = spare.substring(0, spare.length() - 1);
		String[] strings = spare.split(",");
		SQLQuery query = createSQLQuery(getSQL("getMaterialGroupBySpare"));
		query.setParameterList("strings", strings);
		List<Map<String, Object>> listMap = query.list();
		List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> orgMap : listMap) {
			Map<String, Object> map = new HashMap<>();
			map = TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}

}
