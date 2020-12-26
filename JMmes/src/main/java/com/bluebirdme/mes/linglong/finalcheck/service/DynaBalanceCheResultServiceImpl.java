/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.DynaBalanceCheResult;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.DynaBalanceCheResultDTO;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 动平衡检查履历表
 * @author 时永良
 * @Date 2018-08-10 07:25:02
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DynaBalanceCheResultServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return DynaBalanceCheResult.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getEntCodeName() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("EntCodeName"));
    	query.setParameter("s_factory_s", LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
		return list;
    }
    
    @SuppressWarnings("unchecked")
    public String exportEntcode(String code) throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("exportEntcode"));
    	query.setParameter("code", code);
    	List<Map<String, Object>> list=query.list();
    	if(list.size()!=0){
    		return list.get(0).get("ENTNAME_S").toString();
    	}
		return null;
    }
    
    
    @SuppressWarnings("unchecked")
	public String getEndNameByEntCode(String entCode) throws Exception {
		SQLQuery query = createSQLQuery(getSQL("getEndNameByEntCode"));
		query.setParameter("s_factory_s", "2");
		query.setParameter("entCode", entCode);
		String result = null;
		List<Map<String, Object>> list = query.list();
		for(int i = 0; i < list.size(); i++){
			result = list.get(i).get("DESCRIPTION").toString();
		}
		return result;
	}

}
