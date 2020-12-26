/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.wsdl.plmserviceex.WSExInterface;
import com.bluebirdme.mes.linglong.wsdl.plmserviceex.WSImplementService;


/**
 * PLM动平衡参数集成表
 * @author zqy
 * @Date 2019-06-27 14:24:00
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CommonPlmDynamicBalanceServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return null;
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
    
    /**
     * 下发
     * @param recipecodelist
     * @param status
     * @author 周清玉
     * @date 2019年7月1日
     */
    public String letdown(String[] recipecodelist){
    	StringBuffer sb=new StringBuffer();
    	String recipecode="";
    	for(int i=0;i<recipecodelist.length;i++){
    		recipecode=recipecodelist[i];
    		WSImplementService wsexinterface = new WSImplementService();
    		WSExInterface portType = wsexinterface.getWSImplementPort();
    		sb.append(recipecode+"下发结果："+portType.reciveDynamicBalanceRecipeSendByMES(null,null,recipecode,LLWebUtils.getUser().userCode,LLWebUtils.getUser().userName)+"<br>");
    	}
    	return sb.toString();
    }
}
