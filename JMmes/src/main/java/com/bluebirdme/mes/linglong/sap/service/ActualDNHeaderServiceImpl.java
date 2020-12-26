/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.util.ArrayList;
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
import com.bluebirdme.mes.linglong.sap.entity.ActualDNHeader;


/**
 * 成品发货主表
 * @author 周清玉
 * @Date 2018-12-20 18:57:29
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ActualDNHeaderServiceImpl extends RockWellBaseServiceImpl<ActualDNHeader> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ActualDNHeader.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
   

    public List<ActualDNHeader> queryActualDNHeader(String snno_s,Class dto) throws Exception {
    	Filter filter = new Filter();
    	filter.set("snno_s", snno_s);
    	SQLQuery query = createSQLQuery(getSQL("queryActualDNHeader"), dto);
    	query.setParameter("snno_s", snno_s);
    	return query.list();
    }
    
    /**
     * 根据id对数据进行修改
     * @param id atr_key
     * @param actualDNHeader 成品发货主表
     * 表明已经上传
     * @throws Exception
     */
    public void updateOne(Long atr_key) throws Exception{
    	Map<String,Object> keyMap = new HashMap<>();
    	keyMap.put("atr_key", atr_key);
    	Map<String,Object> valueMap = new HashMap<>();
    	valueMap.put("flag_s", "1");
    	update(keyMap,valueMap);
    }
}
