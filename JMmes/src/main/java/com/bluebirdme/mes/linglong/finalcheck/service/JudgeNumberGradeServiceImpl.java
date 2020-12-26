/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mondrian.rolap.sql.SqlQuery;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumberGrade;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeNumberGradeDTO;

/**
 * 动平衡均匀机检测配套标准等级表
 * @author 刘程明
 * @Date 2018-11-13 14:44:43
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JudgeNumberGradeServiceImpl extends RockWellBaseServiceImpl<JudgeNumberGrade> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return JudgeNumberGrade.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public int saveChanges(JudgeNumberGradeDTO judgenumbergrade) throws Exception{
        
        if (!ListUtils.isEmpty(judgenumbergrade.getDeleted())) {
        	List<JudgeNumberGrade> judgenumbergradeList = judgenumbergrade.getDeleted();
        	for(JudgeNumberGrade item:judgenumbergradeList)
        	{
        		item.setRecord_flag_s("D");
        		item.setChanged_by_s(LLWebUtils.getUser().userName);
        		item.setChanged_time_t(new Date());
        	}
            update(judgenumbergradeList);
            return 0;
        }
        if (!ListUtils.isEmpty(judgenumbergrade.getInserted())) {
        	List<JudgeNumberGrade> judgenumbergradeList = judgenumbergrade.getInserted();
        	List<String> addString = new ArrayList<>();
    		List ruplicateList = new ArrayList<>();
    		int mun = 0;
    		boolean ist = false;
        	for(JudgeNumberGrade item:judgenumbergradeList)
        	{
        		item.setS_factory_s(LLWebUtils.factory());
        		item.setCreated_by_s(LLWebUtils.getUser().userName);
        		item.setCreated_time_t(new Date());
        		item.setRecord_flag_s("A");
        		item.setArch_flag_s("0");
        		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		 
        		// 通过质量等级查询是否有重复数据
        	/*	int rs = ((BigDecimal) getSession().createSQLQuery(getSQL("selectdouble"))
        				.setParameter("judgeno_", item.getJudgeno_s())
        				.setParameter("enttype_s", item.getEnttype_s())
        				.setParameter("cegradecode_s", item.getCegradecode_s())
        				.uniqueResult()).intValue();*/
        		// 通过动平衡下发等级查询是否有重复数据
				SQLQuery sqlQuery = getSession().createSQLQuery(getSQL("selectdouble2"));
				sqlQuery.setParameter("judgeno_", item.getJudgeno_s());
				sqlQuery.setParameter("enttype_s", item.getEnttype_s());
				sqlQuery.setParameter("machinegradecode_s", item.getMachinegradecode_s());
				sqlQuery.setParameter("s_factory_s",LLWebUtils.factory());
				BigDecimal rs2 = (BigDecimal) sqlQuery.uniqueResult();
        		if (rs2.intValue()>0) {
        			ist = true;
        		} else {
        			mun = 0;
        		}
        	}
        	if (ist != false) {
				mun = -1;
			} else {
				save(judgenumbergradeList);
			}
        	return mun;
            
        }
        if (!ListUtils.isEmpty(judgenumbergrade.getUpdated())) {
        	List<JudgeNumberGrade> judgenumbergradeList = judgenumbergrade.getUpdated();
        	List<String> addString = new ArrayList<>();
    		List ruplicateList = new ArrayList<>();
    		int mun = 0;
    		boolean ist = false;
        	for(JudgeNumberGrade item:judgenumbergradeList)
        	{
        		item.setChanged_by_s(LLWebUtils.getUser().userName);
        		item.setChanged_time_t(new Date());
        		// 通过质量等级查询是否有重复数据
        		/*int rs = ((BigDecimal) getSession().createSQLQuery(getSQL("selectdouble"))
        				.setParameter("judgeno_", item.getJudgeno_s())
        				.setParameter("enttype_s", item.getEnttype_s())
        				.setParameter("cegradecode_s", item.getCegradecode_s())
        				.uniqueResult()).intValue();*/
        		// 通过动平衡下发等级查询是否有重复数据
        		int rs2 = ((BigDecimal) getSession().createSQLQuery(getSQL("selectdouble3"))
        				.setParameter("judgeno_", item.getJudgeno_s())
        				.setParameter("enttype_s", item.getEnttype_s())
        				.setParameter("cegradecode_s", item.getCegradecode_s())
        				.setParameter("machinegradecode_s", item.getMachinegradecode_s())
        				.uniqueResult()).intValue();
        		if (rs2>0) {
        			ist = true;
        		} else {
        			mun = 0;
        		}
        	}
        	if (ist != false) {
				mun = -1;
			} else {
				update(judgenumbergradeList);
			}
        	return mun;
        }
		return 0;
    
    }
    //从基础数据表查询机台下发等级
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getMachineGradeCombox() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxMachineGrade"));
    	List<Map<String, Object>> list=query.list();
	    return list;
    }
    
    //从工序等级维护页面拉动平衡等级信息
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> comboxDynamicGrade() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxDynamicGrade"));
    	query.setParameter("s_factory_s",LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
	    return list;
    }
    
    //从工序等级维护页面拉均匀性等级信息
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> comboxUniformGrade() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxUniformGrade"));
    	query.setParameter("s_factory_s",LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
	    return list;
    }

}
