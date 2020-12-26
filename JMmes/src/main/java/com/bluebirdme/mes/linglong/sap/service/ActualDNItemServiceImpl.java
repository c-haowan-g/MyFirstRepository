/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.ActualDNItem;
import com.bluebirdme.mes.linglong.sap.entity.dto.ActualDNItemDTO;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 成品发货明细表
 * @author 周清玉
 * @Date 2018-12-20 11:37:17
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ActualDNItemServiceImpl extends RockWellBaseServiceImpl<ActualDNItem> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ActualDNItem.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
	/**
	 * 
	 * @param snno_s
	 * @param dto
	 * @return
	 * @throws Exception
	 */
    public List<ActualDNItem> queryActualDNitem(String snno_s,Class dto) throws Exception {
    	Filter filter = new Filter();
    	filter.set("snno_s", snno_s);
    	SQLQuery query = createSQLQuery(getSQL("queryActualDNitem"), dto);
    	query.setParameter("snno_s", snno_s);
    	return query.list();
    }
    
    @RockWellTransactional
    public int saveChanges(ActualDNItemDTO actualdnitem) throws Exception{
    	int mun = 0;
    	//删除方法
        if (!ListUtils.isEmpty(actualdnitem.getDeleted())) {
        	List<ActualDNItem> actualdnitemlist=actualdnitem.getDeleted();
        	for (int i = 0; i < actualdnitemlist.size(); i++) {
        		StringBuffer sql = new StringBuffer("delete from AT_INT_SAP_ACTUALDNITEM where"); 
        		String barcode=actualdnitemlist.get(i).getBarcode_s();
                sql.append(" BARCODE_S='" + barcode + "'");    		
                RockWellUtils.execSQL(sql.toString());
			}
        	mun=1;
        }
		return mun;
    }
    
    
    public Map<String, Object> datagridrowTO(Filter filter, Class clazz) throws Exception {
		String FACTORY = "s_factory_s";
		if (clazz == null) {
			clazz = getEntity();
		}

		if (!filter.getFilter().containsKey(FACTORY)) {

			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}


		Map<String, Object> ret = new HashMap<String, Object>();

		ret.put("rows", datagridRowsTO(filter,  clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total","");

		return ret;
	}
    
    
	public <K> List<K> datagridRowsTO(Filter filter, Class<K> clazz) throws Exception {
		String FACTORY = "s_factory_s";
		if (!filter.getFilter().containsKey(FACTORY)) {
			if (hasField(FACTORY, clazz)) {
				try {
					filter.set("s_factory_s", LLWebUtils.factory());
				} catch (Exception e) {
					throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
				}
			}
		}
		if (getSQL("datagrid_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
		String dataSql = getSQL("datagrid_rows", filter.getFilter());
		SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);
		setParameter(query, filter);
		return query.list();
	}
	
}
