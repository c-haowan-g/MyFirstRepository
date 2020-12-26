/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.common.entity.DeviceList;


/**
 * PLM系统设备清单表
 * @author 周清玉
 * @Date 2019-09-10 13:40:17
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DeviceListServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return DeviceList.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public Map<String, Object> datagrid(Filter filter, Page page, Class clazz) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRows(filter, page, clazz));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal(filter, page));
		return ret;
	}
    
    public List<Map<String, Object>> searchByMaterial(String equipmentcodes) {
		SQLQuery query = getSession().createSQLQuery(getSQL("curingparameter"));
		query.setParameter("equipmentcodes", equipmentcodes);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
    
    /**
     * 获取设备名称和code的对应关系
     * 周清玉
     * 2019年2月28日
     * @return
     */
    public List<Map<String,Object>> getEquipcodeAndName() {
    	SQLQuery query=createSQLQuery(getSQL("getEquipcodeAndName"));
    	String SQL=query.getQueryString();
    	List<Map<String, Object>> list=query.list();
		return list;
	}

}
