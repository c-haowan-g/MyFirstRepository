/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.math.BigDecimal;
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

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.building.entity.BuildRecipePara;
import com.bluebirdme.mes.linglong.building.entity.CxProductionDayPlan;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * PLM配方下发基础参数表
 * @author 周清玉
 * @Date 2019-03-30 14:29:57
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class BuildRecipeParaServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return BuildRecipePara.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
    	List<Map<String,Object>> list=new ArrayList<>();
//        if (!ListUtils.isEmpty(buildrecipepara.getDeleted())) {
//            delete(buildrecipepara.getDeleted());
//        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
            save(rockWellEntityDTO.getInserted());
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	list=rockWellEntityDTO.getUpdated();
        	for(Map<String,Object> item:list ){
        		BuildRecipePara buildRecipePara =(BuildRecipePara) MapTrunPojo.mapToEntity(item, getEntity());
        		buildRecipePara.setChanged_by_s(LLWebUtils.getUser().userCode);
        		buildRecipePara.setChanged_time_t(new Date());
        		update(buildRecipePara);
        	}
          
        }
    
    }
    
    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsUDA(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalUDA(filter, page));
		return ret;

	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
		String FACTORY = "s_factory_s";

		if (!filter.getFilter().containsKey(FACTORY)) {
			try {
				filter.set("s_factory_s", LLWebUtils.factory());
			} catch (Exception e) {
				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
			}
		}
		if (getSQL("datagridUDA_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");

		String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
		System.out.println(dataSql);

		SQLQuery query = createSQLQuery(dataSql);
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

	public Long datagridTotalUDA(Filter filter, Page page) throws Exception {

		if (getSQL("datagridUDA_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");

		String totalSql = getSQL("datagridUDA_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
    /**
     * 根据成型工艺配方ID（Route_Name）和设备类型的PLM代码获取PLM配方下发基础参数
     * 时永良
     * 2019年3月30日
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
	public List<Map<String,Object>> getBuildingParaByProcessid(CxProductionDayPlan item) throws Exception {
    	String processID=item.getProcessbom_index_s();
    	String equipcpde=item.getEquip_code_s();//机台条码
    	
    	Object  entType =getSession().createSQLQuery(getSQL("getPLMEntType")).setParameter("plinename", equipcpde).uniqueResult();
    	if(entType==null){
    		return null;
    	}
    	
    	SQLQuery query=createSQLQuery(getSQL("getBuildingParaByProcessid"));
    	query.setParameter("processID", processID);
    	query.setParameter("factory", LLWebUtils.factory());
    	query.setParameter("equipmenttype", entType);
    	return query.list();
	}
	/**
	 * 查询参数类型下拉框内容
	 * @return
	 * @throws Exception
	 * @author 周清玉
	 * @date 2019年5月7日
	 */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getComboxparamtype() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxparamtype"));
    	query.setParameter("factory", LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
	    return list;
    }
    /**
     * 获取设备类型下拉框
     * @return
     * @throws Exception
     * @author 周清玉
     * @date 2019年5月7日
     */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getComboxequiptype() throws Exception
    {
    	SQLQuery query=createSQLQuery(getSQL("comboxequiptype"));
    	query.setParameter("factory", LLWebUtils.factory());
    	List<Map<String, Object>> list=query.list();
	    return list;
    }
}
