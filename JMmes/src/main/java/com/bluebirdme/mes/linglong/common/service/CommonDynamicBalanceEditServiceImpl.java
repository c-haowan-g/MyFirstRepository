/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.common.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.common.entity.CommonDynamicBalanceEdit;
import com.bluebirdme.mes.linglong.common.entity.dto.CommonDynamicBalanceEditDTO;
import com.bluebirdme.mes.linglong.wsdl.plmserviceex.WSExInterface;
import com.bluebirdme.mes.linglong.wsdl.plmserviceex.WSImplementService;

import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * PLM动平衡标准管理表
 * @author 刘程明
 * @Date 2019-07-09 10:05:32
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class CommonDynamicBalanceEditServiceImpl extends RockWellBaseServiceImpl<CommonDynamicBalanceEdit> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return CommonDynamicBalanceEdit.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(CommonDynamicBalanceEditDTO commondynamicbalanceedit) throws Exception{
        
        if (!ListUtils.isEmpty(commondynamicbalanceedit.getDeleted())) {
            delete(commondynamicbalanceedit.getDeleted());
        }
        if (!ListUtils.isEmpty(commondynamicbalanceedit.getInserted())) {
            save(commondynamicbalanceedit.getInserted());
        }
        if (!ListUtils.isEmpty(commondynamicbalanceedit.getUpdated())) {
            update(commondynamicbalanceedit.getUpdated());
        }
    
    }

    /**
     * 下发
     * @param recipecodelist
     * @param status
     * @author 刘程明
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
	/**
	 * 动平衡标准启用、停用
	 * @param recipecodelist
	 * @param status
	 * @return
	 * @author 刘程明
	 * @date 2019年7月1日
	 */
    public String standardmanage(String[] recipecodelist,String status){
    	StringBuffer sb=new StringBuffer();
    	String recipecode="";
    	for(int i=0;i<recipecodelist.length;i++){
    		recipecode=recipecodelist[i];
    		WSImplementService wsexinterface = new WSImplementService();
    		WSExInterface portType = wsexinterface.getWSImplementPort();
    		sb.append(recipecode+"结果："+portType.reciveDynamicBalanceRecipeStartOrStopByMES(null,null,recipecode,status,LLWebUtils.getUser().userCode,LLWebUtils.getUser().userName)+"<br>");
    	}
    	return sb.toString();
    }
    
    
}
