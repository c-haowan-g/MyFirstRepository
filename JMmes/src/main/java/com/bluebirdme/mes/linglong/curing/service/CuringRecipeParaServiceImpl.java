/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.CuringRecipePara;
import com.bluebirdme.mes.linglong.curing.entity.dto.CuringRecipeParaDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.VehiclesDetailInfo;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * PLM配方下发基础参数表
 * 
 * @author 刘朋
 * 修改人   :徐秉正
 * @Date 2018-09-27 10:55:48
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CuringRecipeParaServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return CuringRecipePara.class;
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

	@RockWellTransactional
	public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

		int mun = 0;
		BigDecimal rs = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		HttpSession session = request.getSession();

		
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			
			List<Map<String, Object>> curingRecipeParas = rockWellEntityDTO.getDeleted();
			for(Map<String, Object> newitem:curingRecipeParas){
				CuringRecipePara item = (CuringRecipePara)MapTrunPojo.mapToEntity(newitem, getEntity());
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
		
		
		
		
		
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> curingRecipeParas = rockWellEntityDTO.getInserted();
			System.out.println("vehiclesdetailinfos"+curingRecipeParas.size());
			for(Map<String, Object> newitem:curingRecipeParas){
				CuringRecipePara item = (CuringRecipePara)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				
				// 逻辑地址
				String code = item.getLogicaladdress_s();
				String s_factory_s = item.getS_factory_s();
				item.setChanged_by_s(LLWebUtils.getUserName());
				item.setChanged_time_t(new Date());
				// 通过逻辑地址是否有重复数据
				rs = (BigDecimal) getSession().createSQLQuery(getSQL("insert_curingrecipepara"))
						.setParameter("logicaladdress_s", code).setParameter("s_factory_s", s_factory_s).uniqueResult();
						
				insertedList.add(item);
			}

			if (rs.intValue() > 0) {
				mun = -1;
			} else {
				save(insertedList);
			}
			
		}
		
		
		
		
		
		
		
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			List stingList=new ArrayList<>();
			for (Map<String,Object> item:rockWellEntityDTO.getUpdated()) {
				CuringRecipePara curingRecipePara =(CuringRecipePara) MapTrunPojo.mapToEntity(item, getEntity());
				Long atr_key = curingRecipePara.getAtr_key();
				String s_factory_s = curingRecipePara.getS_factory_s();
				// 逻辑地址
				String code = curingRecipePara.getLogicaladdress_s();
				if("硫化".equals(curingRecipePara.getBasetype_s())){
					curingRecipePara.setBasetype_s("2");
				}else if("成型".equals(curingRecipePara.getBasetype_s())){
					curingRecipePara.setBasetype_s("1");
				}
				/* 更新时间 */
				curingRecipePara.setChanged_time_t(new Date());
				/* 更新人 */
				curingRecipePara.setChanged_by_s(WebUtils.getUser().userCode);
				// 通过逻辑地址是否有重复数据
				rs = (BigDecimal) getSession().createSQLQuery(getSQL("select_curingrecipepara"))
						.setParameter("logicaladdress_s", code).setParameter("s_factory_s", s_factory_s)
						.setParameter("atr_key", atr_key).uniqueResult();
				stingList.add(curingRecipePara);
			}

			if (rs.intValue() > 0) {
				mun = -1;
			} else {
				update(stingList);
				mun = 0;
			}
		}

		return mun;

	}

}
