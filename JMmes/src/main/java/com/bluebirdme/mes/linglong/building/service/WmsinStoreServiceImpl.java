/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.building.entity.WmsinStore;

/**
 * 胎胚入库实绩表
 * @author 王海霖
 * @Date 2019-01-12 08:51:42
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class WmsinStoreServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return WmsinStore.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
 
    
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getCombox_entcode() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("getCombox_entcode"));
    	query.setParameter("area_name", FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"B");
    	List<Map<String, Object>> list=query.list();
    	/*Map<String, Object>map=new HashMap<String, Object>();
    	map.put("P_LINE_NAME", " ");
    	list.add(0, map);//插入空字符串
*/		return list;
    }
    

}
