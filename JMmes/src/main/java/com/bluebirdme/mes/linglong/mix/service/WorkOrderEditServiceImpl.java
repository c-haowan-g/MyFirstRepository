/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.WorkOrderEdit;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSImplementService;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSInterface;

/**
 * 密炼工单跟踪
 * 
 * @author 王超
 * @Date 2020-08-07 09:08:35
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class WorkOrderEditServiceImpl extends
		RockWellUDABaseServiceImpl<Object> {

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

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return WorkOrderEdit.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	// 胶料工单查询
	public Map<String, Object> datagridUDAjl(Filter filter, Page page)
			throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception(
						"当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDAjl(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDAjl(filter, page));
		return ret;

	}

	// 胶料工单查询
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDAjl(Filter filter, Page page)
			throws Exception {
		if (getSQL("datagridUDA_rowsjl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_rowsjl的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rowsjl", filter.getFilter());
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

	// 胶料工单查询
	public Long datagridTotalUDAjl(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_totaljl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_totaljl的SQL语句定义");

		String totalSql = getSQL("datagridUDA_totaljl", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	// 小料工单查询
	public Map<String, Object> datagridUDAxl(Filter filter, Page page)
			throws Exception {

		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception(
						"当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDAxl(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDAxl(filter, page));
		return ret;

	}

	// 小料工单查询
	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDAxl(Filter filter, Page page)
			throws Exception {
		if (getSQL("datagridUDA_rowsxl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_rowsxl的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rowsxl", filter.getFilter());
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

	// 小料工单查询
	public Long datagridTotalUDAxl(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_totalxl") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagridUDA_totalxl的SQL语句定义");

		String totalSql = getSQL("datagridUDA_totalxl", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	// 主机手实时查询
	public Map<String, Object> setup(Filter filter, Page page, Class<?> clazz)
			throws Exception {
		Map<String, Object> ret = new HashMap<>();
		ret.put("rows", setupRows(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", setupTotal(filter, page));
		return ret;
	}

	// 主机手实时查询
	public <K> List<K> setupRows(Filter filter, Page page, Class<K> clazz)
			throws Exception {
		if (getSQL("setup_rows") == null)
			throw new Exception(getClass() + ".xml文件中未找到ID为setup_rows的SQL语句定义");
		String dataSql = getSQL("setup_rows", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql, (clazz == null) ? getEntity()
				: clazz);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		return query.list();
	}

	// 主机手实时查询
	public Long setupTotal(Filter filter, Page page) throws Exception {
		if (getSQL("setup_total") == null)
			throw new Exception(getClass() + ".xml文件中未找到ID为setup_total的SQL语句定义");
		String totalSql = getSQL("setup_total", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			if (query.uniqueResult() != null)
				return Long.valueOf(((BigDecimal) query.uniqueResult())
						.longValue());
		}
		return Long.valueOf(page.getTotalRows());
	}

	// 主机手历史查询
	public Map<String, Object> setup2(Filter filter, Page page, Class<?> clazz)
			throws Exception {
		Map<String, Object> ret = new HashMap<>();
		ret.put("rows", setupRows2(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", setupTotal2(filter, page));
		return ret;
	}

	// 主机手历史查询
	public <K> List<K> setupRows2(Filter filter, Page page, Class<K> clazz)
			throws Exception {
		if (getSQL("setup_rows2") == null)
			throw new Exception(getClass() + ".xml文件中未找到ID为setup_rows2的SQL语句定义");
		String dataSql = getSQL("setup_rows2", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql, (clazz == null) ? getEntity()
				: clazz);
		setParameter(query, filter);
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		return query.list();
	}

	// 主机手历史查询
	public Long setupTotal2(Filter filter, Page page) throws Exception {
		if (getSQL("setup_total2") == null)
			throw new Exception(getClass()
					+ ".xml文件中未找到ID为setup_total2的SQL语句定义");
		String totalSql = getSQL("setup_total2", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return Long
					.valueOf(((BigDecimal) query.uniqueResult()).longValue());
		}
		return Long.valueOf(page.getTotalRows());
	}

	// 机台主机手设置查询
	public List<Map<String, Object>> geterpcode() {
		SQLQuery query = createSQLQuery(getSQL("geterpcode_s"));
		if (LLWebUtils.factory().toString().equals("2")) {
			query.setParameter("erpcode_s", "9");
		} else {
			query.setParameter("erpcode_s", "E");
		}
		return query.list();
	}

	public List<Map<String, Object>> getbatch(String recipecode) {
		SQLQuery query = createSQLQuery(getSQL("getbatch"));
		query.setParameter("recipecode", recipecode);
		return query.list();
	}

	// 主机手设置保存
	public String set(String[] ids) throws Exception {
		StringBuffer sb = new StringBuffer();
		String recipecode = "";
		String operateFlag = "";
		StringBuffer falseinfo = new StringBuffer();
		recipecode = ids[0];
		if (ids[3].toString().equals("set")) {
			operateFlag = "Set";
		} else if (ids[3].toString().equals("check")) {
			operateFlag = "Check";
		}
		MESWSImplementService wsexinterface = new MESWSImplementService();
		MESWSInterface portType = wsexinterface.getMESWSImplementPort();
		String result = "False";
		result = portType.reciveMixerMasterByMES((String) null, (String) null,
				operateFlag, GetCurProdDate().toString(), GetCurProdShiift()
						.toString(), recipecode, ids[1], ids[2], (LLWebUtils
						.getUser()).userCode, (LLWebUtils.getUser()).userName);
		if (result.equals("OK")) {
			falseinfo.append("机台" + recipecode + "主机手设置成功");
		} else {
			falseinfo.append("机台" + recipecode + "设置失败，返回结果：" + result);
		}
		sb.append(falseinfo.toString());
		return sb.toString();
	}

	// 关闭工单
	public String end(String[] recipecodelist) throws Exception {
		StringBuffer sb = new StringBuffer();
		String recipecode = "";
		int sucCount = 0;
		StringBuffer falseinfo = new StringBuffer();
		for (int i = 0; i < recipecodelist.length; i++) {
			recipecode = recipecodelist[i];
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			String result = "False";
			result = portType.reciveWoCloseByMES((String) null, (String) null,
					recipecode, (LLWebUtils.getUser()).userCode,
					(LLWebUtils.getUser()).userName);
			if (result.equals("OK")) {
				sucCount++;
			} else {
				falseinfo.append(recipecode + "工单关闭失败，返回结果：" + result + "<br>");
			}
		}
		sb.append("合计：" + recipecodelist.length + "条，成功：" + sucCount + "条；失败："
				+ (recipecodelist.length - sucCount) + "条");
		sb.append("<br>");
		sb.append(falseinfo.toString());
		return sb.toString();
	}

	// 工单上移
	public String upward(String[] ids) throws Exception {
		try {
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			StringBuffer errorBuffer = new StringBuffer();
			StringBuffer resultBuffer = new StringBuffer();
			String moveFlag = "Up";
			for (String item : ids) {
				String result = "False";
				result = portType.reciveWoMoveByMES((String) null,
						(String) null, item, moveFlag,
						(LLWebUtils.getUser()).userCode,
						(LLWebUtils.getUser()).userName);
				if (result.equals("OK")) {
					resultBuffer.append(buildcommonMsg(Integer.valueOf(1),
							"工单：" + item + "上移成功"));
					continue;
				}
				errorBuffer.append(buildcommonMsg(Integer.valueOf(0), "工单："
						+ item + "上移失败，返回结果：" + result));
			}
			return resultBuffer.toString() + "<br>" + errorBuffer.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	// 工单下移
	public String down(String[] ids) throws Exception {
		try {
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			StringBuffer errorBuffer = new StringBuffer();
			StringBuffer resultBuffer = new StringBuffer();
			String moveFlag = "Down";
			for (String item : ids) {
				String result = "False";
				result = portType.reciveWoMoveByMES((String) null,
						(String) null, item, moveFlag,
						(LLWebUtils.getUser()).userCode,
						(LLWebUtils.getUser()).userName);
				if (result.equals("OK")) {
					resultBuffer.append(buildcommonMsg(Integer.valueOf(1),
							"工单：" + item + "下移成功"));
					continue;
				}
				errorBuffer.append(buildcommonMsg(Integer.valueOf(0), "工单："
						+ item + "下移失败，返回结果：" + result));
			}
			return resultBuffer.toString() + "<br>" + errorBuffer.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	private String buildcommonMsg(Integer type, String msg) {
		String color = "";
		if (type.equals(Integer.valueOf(0))) {
			color = "<font color=ff0000>";
		} else if (type.equals(Integer.valueOf(1))) {
			color = "<font color=000000>";
		} else if (type.equals(Integer.valueOf(2))) {
			color = "<font color=f7df09>";
		}
		return color + msg + "<br>";
	}

	// 获取生产日期
	public static String GetCurProdDate() throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		int hh = calendar.get(11);
		if (hh >= 0 && hh < 8) {
			calendar.add(5, 0);
			date = calendar.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String dateString = formatter.format(date);
			return dateString;
		}
		if (hh < 16) {
			calendar.add(5, 0);
			date = calendar.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String dateString = formatter.format(date);
			return dateString;
		}
		calendar.add(5, 1);
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String dateString = formatter.format(date);
		return dateString;
	}

	// 获取当前班次
	public static String GetCurProdShiift() throws Exception {
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		int hh = calendar.get(11);
		if (hh >= 0 && hh < 8)
			return "302003";
		if (hh < 16)
			return "302001";
		return "302002";
	}

	// 下发
	public String downward(String[] recipecodelist) throws Exception {
		StringBuffer sb = new StringBuffer();
		String recipecode = "";
		int sucCount = 0;
		StringBuffer falseinfo = new StringBuffer();
		for (int i = 0; i < recipecodelist.length; i++) {
			recipecode = recipecodelist[i];
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			String result = "False";
			result = portType.reciveWoSendByMES((String) null, (String) null,
					recipecode, LLWebUtils.getUser().userCode,
					LLWebUtils.getUser().userName);
			if (result.equals("OK")) {
				sucCount = sucCount + 1;
			} else {
				falseinfo.append(recipecode + "下发失败，返回结果：" + result + "<br>");
			}
		}
		sb.append("合计：" + recipecodelist.length + "条，" + "成功：" + sucCount
				+ "条；" + "失败：" + (recipecodelist.length - sucCount) + "条");
		sb.append("<br>");
		sb.append(falseinfo.toString());
		return sb.toString();
	}

	// 校验主机手设置
	public String check(String[] recipecodelist) throws Exception {
		StringBuffer sb = new StringBuffer();
		String recipecode = "";
		StringBuffer falseinfo = new StringBuffer();
		for (int i = 0; i < recipecodelist.length; i++) {
			String[] contentStr = recipecodelist[i].split("\\|");
			recipecode = contentStr[2];
			MESWSImplementService wsexinterface = new MESWSImplementService();
			MESWSInterface portType = wsexinterface.getMESWSImplementPort();
			String result = "False";
			result = portType.reciveMixerMasterByMES((String) null,
					(String) null, "Check", contentStr[0], contentStr[1],
					recipecode, (String) null, (String) null,
					(LLWebUtils.getUser()).userCode,
					(LLWebUtils.getUser()).userName);
			if (!result.equals("OK"))
				falseinfo.append(recipecode + ":" + result + "<br>");
		}
		sb.append(falseinfo.toString());
		return sb.toString();
	}

	// 数据保存
	@RockWellTransactional
	public void saveChanges(RockWellEntityDTO rockWellEntityDTO)
			throws Exception {

		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			List list = new ArrayList<>();
			for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
				// 将MAP转换为实体
				WorkOrderEdit workorderedit = (WorkOrderEdit) MapTrunPojo
						.mapToEntity(rockWellEntityDTO.getDeleted().get(i),
								WorkOrderEdit.class);
				// workorderedit.setCreated_time_t(new Date());
				list.add(workorderedit);
			}
			delete(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List list = new ArrayList<>();
			for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
				// 将MAP转换为实体
				WorkOrderEdit workorderedit = (WorkOrderEdit) MapTrunPojo
						.mapToEntity(rockWellEntityDTO.getInserted().get(i),
								WorkOrderEdit.class);
				// workorderedit.setCreated_time_t(new Date());
				list.add(workorderedit);
			}
			save(list);
		}
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
				// 将MAP转换为实体
				WorkOrderEdit workorderedit = (WorkOrderEdit) MapTrunPojo
						.mapToEntity(rockWellEntityDTO.getUpdated().get(i),
								WorkOrderEdit.class);
				// workorderedit.setCreated_time_t(new Date());
				update(workorderedit);
			}
		}

	}

}
