/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.text.MessageFormat;
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
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;


/**
 * 成品质量检查日报表
 * @author 周清玉	
 * @Date 2019-08-13 15:28:51
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VisualmCheckSumPrintServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Resource ReasServiceImpl rsil;
    
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
    
  
    @SuppressWarnings("unchecked")
	public Map<String, Object> datagrid2(Filter filter, Page page)
			throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();

 
		
		
		
		ret.put("rows", datagridRows2(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotal2(filter, page));

		return ret;
		 
	}

	public Long datagridTotal2(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_total2") == null)
			throw new Exception(getClass()
					+ ".xml中未找到ID为datagrid_total2的SQL语句定义");
		
		List<Map<String,Object>> wgmapList = rsil.comboxReasCodeDescWg();
		wgmapList.remove(wgmapList.get(0));
		List<Map<String,Object>> xraymapList = rsil.comboxReasCodeDescXray();
		xraymapList.remove(xraymapList.get(0));
		
		List<String> reacodes_List = new ArrayList<>();
		String wgreascode_s = filter.get("wgreascode_s");
		String xrayreascode_s = filter.get("xrayreascode_s");
		
		if(wgreascode_s != null && wgreascode_s != ""){
			if("0".equals(wgreascode_s)){ // 查询外观全部病象
				for (int i = 0; i < wgmapList.size(); i++) {
					String curwg = (String) wgmapList.get(i).get("WGREASCODE");
					if(null != curwg && curwg != ""){
						reacodes_List.add(curwg);
					}
				}
			}else{
				reacodes_List.add(wgreascode_s);
			}
		}
		
		if(xrayreascode_s != null && xrayreascode_s != ""){
			if("0".equals(xrayreascode_s)){ // 查询X光全部病象
				for (int i = 0; i < xraymapList.size(); i++) {
					String curxray = (String) xraymapList.get(i).get("XRAYREASCODE");
					if(null != curxray && curxray != ""){
						reacodes_List.add(curxray);
					}
				}
			}else{
				reacodes_List.add(xrayreascode_s);
			}
		}	
		
		Filter filter2 = new Filter();
		
		if(filter.get("agenc_no_s") != null && filter.get("agenc_no_s") != ""){
			filter2.set("agenc_no_s", filter.get("agenc_no_s"));
		}
		if(filter.get("s_factory_s") != null && filter.get("s_factory_s") != ""){
			filter2.set("s_factory_s", filter.get("s_factory_s"));
		}
		if(filter.get("begin_created_time_visual") != null && filter.get("begin_created_time_visual") != ""){
			filter2.set("begin_created_time_visual", filter.get("begin_created_time_visual"));
		}
		if(filter.get("end_created_time_visual") != null && filter.get("end_created_time_visual") != ""){
			filter2.set("end_created_time_visual", filter.get("end_created_time_visual"));
		}
		
		if(filter.get("begin_created_time_rev") != null && filter.get("begin_created_time_rev") != ""){
			filter2.set("begin_created_time_rev", filter.get("begin_created_time_rev"));
		}
		if(filter.get("end_created_time_rev") != null && filter.get("end_created_time_rev") != ""){
			filter2.set("end_created_time_rev", filter.get("end_created_time_rev"));
		}
		
		if(filter.get("begin_created_time_building") != null && filter.get("begin_created_time_building") != ""){
			filter2.set("begin_created_time_building", filter.get("begin_created_time_building"));
		}
		if(filter.get("end_created_time_building") != null && filter.get("end_created_time_building") != ""){
			filter2.set("end_created_time_building", filter.get("end_created_time_building"));
		}
		if(filter.get("atpresentgradecode_s") != null && filter.get("atpresentgradecode_s") != ""){
			filter2.set("atpresentgradecode_s", filter.get("atpresentgradecode_s"));
		}
		if(filter.get("materialcode_s") != null && filter.get("materialcode_s") != ""){
			filter2.set("materialcode_s", filter.get("materialcode_s"));
		}
		if(filter.get("begin_created_time_curing") != null && filter.get("begin_created_time_curing") != ""){
			filter2.set("begin_created_time_curing", filter.get("begin_created_time_curing"));
		}
		if(filter.get("end_created_time_curing") != null && filter.get("end_created_time_curing") != ""){
			filter2.set("end_created_time_curing", filter.get("end_created_time_curing"));
		}
		if(filter.get("barcode_s") != null && filter.get("barcode_s") != ""){
			filter2.set("barcode_s", filter.get("barcode_s"));
		}
		
		if(reacodes_List.size() > 0){
			filter2.set("reascode_s", "0");
		}

		String totalSql = getSQL("datagrid_total2", filter2.getFilter());
		System.out.println(totalSql);
		
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			
			if(filter2.get("agenc_no_s") != null && filter2.get("agenc_no_s") != ""){
				query.setParameter("agenc_no_s", filter2.get("agenc_no_s"));
			}
			if(filter2.get("s_factory_s") != null && filter2.get("s_factory_s") != ""){
				query.setParameter("s_factory_s", filter2.get("s_factory_s"));
			}
			if(filter2.get("begin_created_time_visual") != null && filter2.get("begin_created_time_visual") != ""){
				query.setParameter("begin_created_time_visual", filter2.get("begin_created_time_visual"));
			}
			if(filter2.get("end_created_time_visual") != null && filter2.get("end_created_time_visual") != ""){
				query.setParameter("end_created_time_visual", filter2.get("end_created_time_visual"));
			}
			
			if(filter2.get("begin_created_time_rev") != null && filter2.get("begin_created_time_rev") != ""){
				query.setParameter("begin_created_time_rev", filter2.get("begin_created_time_rev"));
			}
			if(filter2.get("end_created_time_rev") != null && filter2.get("end_created_time_rev") != ""){
				query.setParameter("end_created_time_rev", filter2.get("end_created_time_rev"));
			}
			
			if(filter2.get("begin_created_time_building") != null && filter2.get("begin_created_time_building") != ""){
				query.setParameter("begin_created_time_building", filter2.get("begin_created_time_building"));
			}
			if(filter2.get("end_created_time_building") != null && filter2.get("end_created_time_building") != ""){
				query.setParameter("end_created_time_building", filter2.get("end_created_time_building"));
			}
			if(filter2.get("atpresentgradecode_s") != null && filter2.get("atpresentgradecode_s") != ""){
				query.setParameter("atpresentgradecode_s", filter2.get("atpresentgradecode_s"));
			}
			if(filter2.get("materialcode_s") != null && filter2.get("materialcode_s") != ""){
				query.setParameter("materialcode_s", filter2.get("materialcode_s"));
			}
			if(filter2.get("begin_created_time_curing") != null && filter2.get("begin_created_time_curing") != ""){
				query.setParameter("begin_created_time_curing", filter2.get("begin_created_time_curing"));
			}
			if(filter2.get("end_created_time_curing") != null && filter2.get("end_created_time_curing") != ""){
				query.setParameter("end_created_time_curing", filter2.get("end_created_time_curing"));
			}
			if(filter2.get("barcode_s") != null && filter2.get("barcode_s") != ""){
				query.setParameter("barcode_s", filter2.get("barcode_s"));
			}
			
			if(reacodes_List.size() > 0){
				query.setParameterList("reascode_s", reacodes_List);
			}

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
		
		
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String, Object>> datagridRows2(Filter filter, Page page)
			throws Exception {
		if (getSQL("datagrid_rows2") == null)
			throw new Exception(getClass()+MessageFormat.format
					(".xml中未找到ID为{0}的SQL语句定义","datagrid_CuringAndAppearanceDatarows"));

		List<Map<String,Object>> wgmapList = rsil.comboxReasCodeDescWg();
		wgmapList.remove(wgmapList.get(0));
		List<Map<String,Object>> xraymapList = rsil.comboxReasCodeDescXray();
		xraymapList.remove(xraymapList.get(0));
		
		List<String> reacodes_List = new ArrayList<>();
		String wgreascode_s = filter.get("wgreascode_s");
		String xrayreascode_s = filter.get("xrayreascode_s");
		
		if(wgreascode_s != null && wgreascode_s != ""){
			if("0".equals(wgreascode_s)){ // 查询外观全部病象
				for (int i = 0; i < wgmapList.size(); i++) {
					String curwg = (String) wgmapList.get(i).get("WGREASCODE");
					if(null != curwg && curwg != ""){
						reacodes_List.add(curwg);
					}
				}
			}else{
				reacodes_List.add(wgreascode_s);
			}
		}
		
		if(xrayreascode_s != null && xrayreascode_s != ""){
			if("0".equals(xrayreascode_s)){ // 查询X光全部病象
				for (int i = 0; i < xraymapList.size(); i++) {
					String curxray = (String) xraymapList.get(i).get("XRAYREASCODE");
					if(null != curxray && curxray != ""){
						reacodes_List.add(curxray);
					}
				}
			}else{
				reacodes_List.add(xrayreascode_s);
			}
		}
		
		Filter filter2 = new Filter();
		
		if(filter.get("agenc_no_s") != null && filter.get("agenc_no_s") != ""){
			filter2.set("agenc_no_s", filter.get("agenc_no_s"));
		}
		if(filter.get("s_factory_s") != null && filter.get("s_factory_s") != ""){
			filter2.set("s_factory_s", filter.get("s_factory_s"));
		}
		if(filter.get("begin_created_time_visual") != null && filter.get("begin_created_time_visual") != ""){
			filter2.set("begin_created_time_visual", filter.get("begin_created_time_visual"));
		}
		if(filter.get("end_created_time_visual") != null && filter.get("end_created_time_visual") != ""){
			filter2.set("end_created_time_visual", filter.get("end_created_time_visual"));
		}
		
		if(filter.get("begin_created_time_rev") != null && filter.get("begin_created_time_rev") != ""){
			filter2.set("begin_created_time_rev", filter.get("begin_created_time_rev"));
		}
		if(filter.get("end_created_time_rev") != null && filter.get("end_created_time_rev") != ""){
			filter2.set("end_created_time_rev", filter.get("end_created_time_rev"));
		}
		
		if(filter.get("begin_created_time_building") != null && filter.get("begin_created_time_building") != ""){
			filter2.set("begin_created_time_building", filter.get("begin_created_time_building"));
		}
		if(filter.get("end_created_time_building") != null && filter.get("end_created_time_building") != ""){
			filter2.set("end_created_time_building", filter.get("end_created_time_building"));
		}
		if(filter.get("atpresentgradecode_s") != null && filter.get("atpresentgradecode_s") != ""){
			filter2.set("atpresentgradecode_s", filter.get("atpresentgradecode_s"));
		}
		if(filter.get("materialcode_s") != null && filter.get("materialcode_s") != ""){
			filter2.set("materialcode_s", filter.get("materialcode_s"));
		}
		if(filter.get("begin_created_time_curing") != null && filter.get("begin_created_time_curing") != ""){
			filter2.set("begin_created_time_curing", filter.get("begin_created_time_curing"));
		}
		if(filter.get("end_created_time_curing") != null && filter.get("end_created_time_curing") != ""){
			filter2.set("end_created_time_curing", filter.get("end_created_time_curing"));
		}
		if(filter.get("barcode_s") != null && filter.get("barcode_s") != ""){
			filter2.set("barcode_s", filter.get("barcode_s"));
		}
		
		if(reacodes_List.size() > 0){
			filter2.set("reascode_s", "0");
		}
		
		String dataSql = getSQL("datagrid_rows2",filter2.getFilter());
		System.out.println(dataSql);
		
		SQLQuery query = createSQLQuery(dataSql);
		System.out.println("##############"+query);
		if(filter2.get("agenc_no_s") != null && filter2.get("agenc_no_s") != ""){
			query.setParameter("agenc_no_s", filter2.get("agenc_no_s"));
		}
		if(filter2.get("s_factory_s") != null && filter2.get("s_factory_s") != ""){
			query.setParameter("s_factory_s", filter2.get("s_factory_s"));
		}
		if(filter2.get("begin_created_time_visual") != null && filter2.get("begin_created_time_visual") != ""){
			query.setParameter("begin_created_time_visual", filter2.get("begin_created_time_visual"));
		}
		if(filter2.get("end_created_time_visual") != null && filter2.get("end_created_time_visual") != ""){
			query.setParameter("end_created_time_visual", filter2.get("end_created_time_visual"));
		}
		
		if(filter2.get("begin_created_time_rev") != null && filter2.get("begin_created_time_rev") != ""){
			query.setParameter("begin_created_time_rev", filter2.get("begin_created_time_rev"));
		}
		if(filter2.get("end_created_time_rev") != null && filter2.get("end_created_time_rev") != ""){
			query.setParameter("end_created_time_rev", filter2.get("end_created_time_rev"));
		}
		
		if(filter2.get("begin_created_time_building") != null && filter2.get("begin_created_time_building") != ""){
			query.setParameter("begin_created_time_building", filter2.get("begin_created_time_building"));
		}
		if(filter2.get("end_created_time_building") != null && filter2.get("end_created_time_building") != ""){
			query.setParameter("end_created_time_building", filter2.get("end_created_time_building"));
		}
		if(filter2.get("atpresentgradecode_s") != null && filter2.get("atpresentgradecode_s") != ""){
			query.setParameter("atpresentgradecode_s", filter2.get("atpresentgradecode_s"));
		}
		if(filter2.get("materialcode_s") != null && filter2.get("materialcode_s") != ""){
			query.setParameter("materialcode_s", filter2.get("materialcode_s"));
		}
		if(filter2.get("begin_created_time_curing") != null && filter2.get("begin_created_time_curing") != ""){
			query.setParameter("begin_created_time_curing", filter2.get("begin_created_time_curing"));
		}
		if(filter2.get("end_created_time_curing") != null && filter2.get("end_created_time_curing") != ""){
			query.setParameter("end_created_time_curing", filter2.get("end_created_time_curing"));
		}
		if(filter2.get("barcode_s") != null && filter2.get("barcode_s") != ""){
			query.setParameter("barcode_s", filter2.get("barcode_s"));
		}
		
		if(reacodes_List.size() > 0){
			query.setParameterList("reascode_s", reacodes_List);
		}
		
		if (page.getAll() == 0) {
			query.setMaxResults(page.getRows());
			query.setFirstResult((page.getPage() - 1) * page.getRows());
		}
		List<Map<String,Object>> listMap =query.list();
		//大写变小写转换后的list
		List<Map<String, Object>> returnlist = new ArrayList<Map<String,Object>>();
		for(Map<String,  Object> orgMap :listMap){
			Map<String,  Object> map = new HashMap<>();
			map=TransformUpperCase.transformUpperCase(orgMap);
			returnlist.add(map);
		}
		return returnlist;
	}
	
	/**
	 * 封装的datagrid数据
	 * 
	 * @Title: getdata
	 * @Description: TODO(描述)
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
	@SuppressWarnings("null")
	public List<Map<String, Object>> getdata(String beginTime, String endTime, String curingspeccode_s,
			String entbarcode_s) throws Exception {
		Filter filter = new Filter();
		filter.set("begin_created_time", beginTime);
		filter.set("end_created_time", endTime);
		filter.set("s_factory_s", LLWebUtils.factory());
		filter.set("curingspeccode_s", curingspeccode_s);
		filter.set("entbarcode_s", entbarcode_s);
		
		SQLQuery query1 = createSQLQuery(getSQL("datagrid_rows", filter.getFilter()));
		query1.setParameter("begin_created_time", filter.get("begin_created_time"));
		query1.setParameter("end_created_time", filter.get("end_created_time"));
		query1.setParameter("s_factory_s", filter.get("s_factory_s"));
		if (curingspeccode_s != "") {
			query1.setParameter("curingspeccode_s", filter.get("curingspeccode_s"));
		}
		if (entbarcode_s != "") {
			query1.setParameter("entbarcode_s", filter.get("entbarcode_s"));
		}

		SQLQuery query2 = createSQLQuery(getSQL("getGradeNum", filter.getFilter()));
		query2.setParameter("begin_created_time", filter.get("begin_created_time"));
		query2.setParameter("end_created_time", filter.get("end_created_time"));
		query2.setParameter("s_factory_s", filter.get("s_factory_s"));
		if (curingspeccode_s != "") {
			query2.setParameter("curingspeccode_s", filter.get("curingspeccode_s"));
		}
		if (entbarcode_s != "") {
			query2.setParameter("entbarcode_s", filter.get("entbarcode_s"));
		}
		List<Map<String, Object>> list1 = query1.list();
		List<Map<String, Object>> list2 = query2.list();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		return null;
	}
}
