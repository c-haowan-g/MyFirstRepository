/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.JudgeNumber;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.JudgeNumberDTO;

/**
 * 动平衡均匀机检测配套标准表
 * @author 刘程明
 * @Date 2018-11-13 13:24:54
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JudgeNumberServiceImpl extends RockWellBaseServiceImpl<JudgeNumber> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return JudgeNumber.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public String saveChanges(JudgeNumberDTO judgenumber) throws Exception{
        
        if (!ListUtils.isEmpty(judgenumber.getDeleted())) {
        	List<JudgeNumber> judgenumberList = judgenumber.getDeleted();
        	for(JudgeNumber item:judgenumberList)
        	{
        		item.setRecord_flag_s("D");
        		item.setChanged_by_s(LLWebUtils.getUser().userName);
        		item.setChanged_time_t(new Date());
        		String updateSQL = "update  AT_D_BS_JUDGENUMBERGRADE SET RECORD_FLAG_S ='D' WHERE JUDGENO_S = '"+item.getJudgeno_s()+"' and ENTTYPE_S = '"+item.getEnttype_s()+"' and S_FACTORY_S = '"+item.getS_factory_s()+"'";; 
        		System.out.println(updateSQL);
        		String updateSQLitem = "update  AT_D_BS_JUDGENUMBERITEM SET RECORD_FLAG_S ='D' WHERE JUDGENO_S = '"+item.getJudgeno_s()+"' and ENTTYPE_S = '"+item.getEnttype_s()+"' and S_FACTORY_S = '"+item.getS_factory_s()+"'";; 
        		
        		RockWellUtils.execSQL(updateSQL);
        		RockWellUtils.execSQL(updateSQLitem);
        	}
            update(judgenumberList);
        }
        if (!ListUtils.isEmpty(judgenumber.getInserted())) {
        	List<JudgeNumber> judgenumberList = judgenumber.getInserted();
        	for(JudgeNumber item:judgenumberList)
        	{
        		if(judgeNoIsExit(item.getJudgeno_s(),item.getEnttype_s())){
        			throw new Exception("设备类："+item.getEnttype_s()+"  "+item.getJudgeno_s()+"号检测标准号已经存在，不允许新增");
        		}
        		item.setS_factory_s(LLWebUtils.factory());
        		item.setCreated_by_s(LLWebUtils.getUser().userName);
        		item.setCreated_time_t(new Date());
        		item.setRecord_flag_s("A");
        		item.setArch_flag_s("0");
        		item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		/*if(isNull(item.getEnttype_s()).size()==0){
        			item.setJudgeno_s(String.valueOf(1));
        		}else{
        			int judge= getMaxNumber(item.getEnttype_s());
            		String result = String.valueOf(judge);
            		item.setJudgeno_s(result);
        		}*/
        	}
            save(judgenumberList);
        }
        if (!ListUtils.isEmpty(judgenumber.getUpdated())) {
        	List<JudgeNumber> judgenumberList = judgenumber.getUpdated();
        	for(JudgeNumber item:judgenumberList)
        	{
        		/*if(judgeNoIsExit(item.getJudgeno_s(),item.getEnttype_s())){
        			throw new Exception("设备类："+item.getEnttype_s()+"  "+item.getJudgeno_s()+"号检测标准号已经存在，不允许修改");
        		}*/
        		item.setChanged_by_s(LLWebUtils.getUser().userName);
        		item.setChanged_time_t(new Date());
        	}
            update(judgenumberList);
        }
		return "操作成功";
    
    }
   /**
    * 判断某设备类型下，编号是否已经存在
    * 刘程明
    * 2019年2月21日
    * @param judgeno编号
    * @param enttype设备类型
    * @return
    */
    private Boolean judgeNoIsExit(String judgeno,String enttype){
    	int count = ((BigDecimal) getSession().createSQLQuery(getSQL("judgeNoIsExit"))
				.setParameter("enttype_s", enttype)
				.setParameter("judgeno_s", judgeno)
				.setParameter("s_factory_s", LLWebUtils.factory())
				.uniqueResult()).intValue();
		return count > 0 ? true : false;
    }
    
    private int getMaxNumber(String entType){
    	String s_factory_s=LLWebUtils.factory();
    	int rs = ((BigDecimal) getSession().createSQLQuery(getSQL("manxnumber")).setParameter("s_factory_s", s_factory_s).setParameter("entType", entType)
				.uniqueResult()).intValue();
    	return rs+1;
    }
    
    private List<Map<String,Object>> isNull(String entType){
    	String s_factory_s=LLWebUtils.factory();
		SQLQuery query = createSQLQuery(getSQL("searchFromJudgeNumber"));
		query.setParameter("s_factory_s", s_factory_s);
		query.setParameter("entType", entType);
		return query.list();
    }
}
