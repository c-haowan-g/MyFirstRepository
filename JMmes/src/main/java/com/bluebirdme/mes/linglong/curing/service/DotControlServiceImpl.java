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

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.DotControl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.ibm.icu.math.BigDecimal;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 年周号管控物料
 * 
 * @author 周清玉
 * @Date 2018-09-08 15:47:33
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class DotControlServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return DotControl.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public Integer saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		// 物料编码
		String material_code_s = null;
		// atr_key
		Long atr_key = null;
		// Sql
		BigDecimal rs = null;
		/**
		 * 带有默认值的数据
		 */
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		// 删除
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			// set指定的数据
			List<Map<String, Object>> dotControlList = rockWellEntityDTO.getDeleted();
			List<DotControl> list = new ArrayList<>();
			for (int i = 0; i < dotControlList.size(); i++) {
				DotControl dotControl=(DotControl) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), DotControl.class);
				dotControl.setRecord_flag_s("D"); 
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				dotControl.setChanged_time_t(timestamp); 
        		list.add(dotControl);
        	}
			update(list);
		}

		// 添加
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			// set指定的数据
			List<Map<String, Object>> dotControlList = rockWellEntityDTO.getInserted();
			List listDotControl = new ArrayList<>();
			for (int i = 0; i < dotControlList.size(); i++) {
				DotControl dotControl=(DotControl) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), DotControl.class);
				
				dotControl.setChanged_by_s(WebUtils.getUser().userCode);
				// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				dotControl.setChanged_time_t(timestamp);
				//物料编码
				material_code_s=dotControl.getMaterial_code_s();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("material_code_s", material_code_s);
				where.andEqual("record_flag_s", "A");
				List<Map<String, Object>> list = findMapByWhere(where);
				// 需要查重的条件
				String listString = material_code_s;

				addString.add(listString);
				ruplicateList.add(listString);
				//
				if (list.size() != 0) {
					ist = true;
				}
				listDotControl.add(dotControl);
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
			if (ist != false) {
				mun = -1;
			} else {
				save(listDotControl);
			}
		}
		
		return mun;
	}

	
	public Map<String, Object> datagridz(Filter filter, Page page) throws Exception {
			Map<String, Object> ret = new HashMap<String, Object>();
			ret.put("rows", datagridRowsz(filter, page));
			filter.setOrder(null);
			filter.setSort(null);
			ret.put("total", super.datagridTotal(filter, page));
			return ret;
		}
		
		public List<Map<String, Object>> datagridRowsz(Filter filter, Page page) throws Exception {
			
			if (getSQL("datagrid_rows") == null)
				throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

			String dataSql = getSQL("datagrid_rows", filter.getFilter());
			System.out.println(dataSql);

			SQLQuery query = createSQLQuery(dataSql);
			if(LLWebUtils.factory().equals("2")){
				filter.set("factory", "in:221001,221002");
			}else{
				filter.set("factory", "in:211001,211003");
			}
			
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
		
}
