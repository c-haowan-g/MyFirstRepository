/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.sap.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.MaterialsPlus;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.client.Part;
import com.datasweep.compatibility.client.PartClass;
import com.datasweep.compatibility.pnuts.Functions;
import com.ibm.icu.text.SimpleDateFormat;
import com.rockwell.mes.commons.base.ifc.services.PCContext;

/**
 * 物料信息扩展表
 * @author 时永良
 * @Date 2019-07-02 08:23:35
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MaterialsPlusWlsxServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
	protected Class getEntity() {
		return MaterialsPlus.class;
	}

    @Override
    protected boolean useCache() {
        return false;
    }
    
    public void savesingleChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
    	List<Map<String,Object>> listMapUpdate = rockWellEntityDTO.getUpdated();
		List<Map<String,Object>> listMapDelete = rockWellEntityDTO.getDeleted();
		List<Map<String,Object>> listMapInsert = rockWellEntityDTO.getInserted();
		List<MaterialsPlus> listMap = new ArrayList<>();
		String type ="";
		if(listMapUpdate!=null&&listMapUpdate.size()!=0){
			for(Map<String,Object> map :listMapUpdate){
				MaterialsPlus materialsplus=(MaterialsPlus) MapTrunPojo.mapToEntity(map, MaterialsPlus.class);
				listMap.add(materialsplus);
			}
			type="1";
		}else if(listMapDelete!=null&&listMapDelete.size()!=0){
			for(Map<String,Object> map :listMapDelete){
				MaterialsPlus materialsplus=(MaterialsPlus) MapTrunPojo.mapToEntity(map, MaterialsPlus.class);
				listMap.add(materialsplus);
			}
			type="2";
		}else if(listMapInsert!=null&&listMapInsert.size()!=0){
			for(Map<String,Object> map :listMapInsert){
				MaterialsPlus materialsplus=(MaterialsPlus) MapTrunPojo.mapToEntity(map, MaterialsPlus.class);
				listMap.add(materialsplus);
			}
			type="3";
		}else{
			return;
		}
		for (MaterialsPlus item: listMap) {
				// 操作人
			    item.setChanged_by_s(WebUtils.getUser().userCode);
				// 机构代码
			    item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);;
				// 工厂 不更新
			    item.setS_factory_s(LLWebUtils.factory());
				// 记录标志
			    item.setRecord_flag_s("A");
				
				if(item.getBeadwidth_d()==null){
					item.setBeadwidth_d("0");
				}
				if(item.getInnerdia_d()==null){
					item.setInnerdia_d("0");
				}
				if(item.getOuterdia_d()==null){
					item.setOuterdia_d("0");
				}
				if(item.getTyreheight_d()==null){
					item.setTyreheight_d("0");
				}
				if(item.getTyrewidth_d()==null){
					item.setTyrewidth_d("0");
				}
	
				// 修改时间的添加
				item.setChanged_time_t(new Date());
				if(type.equals("1")||type.equals("3")){
					item.setSpare10_s("1");
				}else{
					item.setSpare10_s("0");
					String sqlOvertime="SELECT overtime_f FROM AT_INT_SAP_MATERIALSPLUS T,part p,part_class pc,part_class_part pcp "+
							           "WHERE P .part_number = t .materialcode_s (+) and p.PART_KEY=PCP.PART_KEY and PCP.PART_CLASS_KEY=PC.PART_CLASS_KEY AND t .spare10_s = '0' "+
							           "AND pc.PART_CLASS_NAME IN (SELECT pc.PART_CLASS_NAME FROM AT_INT_SAP_MATERIALSPLUS t,part p,part_class pc,part_class_part pcp "+
							           "WHERE P .part_number = t .materialcode_s (+) and p.PART_KEY=PCP.PART_KEY and PCP.PART_CLASS_KEY=PC.PART_CLASS_KEY AND t .spare10_s = '1' AND t .materialcode_s = '"+item.getMaterialcode_s()+"')";
					String sqlSmalltime="SELECT smalltime_f FROM AT_INT_SAP_MATERIALSPLUS T,part p,part_class pc,part_class_part pcp "+
							           "WHERE P .part_number = t .materialcode_s (+) and p.PART_KEY=PCP.PART_KEY and PCP.PART_CLASS_KEY=PC.PART_CLASS_KEY AND t .spare10_s = '0' "+
							           "AND pc.PART_CLASS_NAME IN (SELECT pc.PART_CLASS_NAME FROM AT_INT_SAP_MATERIALSPLUS t,part p,part_class pc,part_class_part pcp "+
							           "WHERE P .part_number = t .materialcode_s (+) and p.PART_KEY=PCP.PART_KEY and PCP.PART_CLASS_KEY=PC.PART_CLASS_KEY AND t .spare10_s = '1' AND t .materialcode_s = '"+item.getMaterialcode_s()+"')";
					
					@SuppressWarnings("unchecked")
					SQLQuery query = createSQLQuery(getSQL("getOvertime"));
					query.setParameter("materialcode_s", item.getMaterialcode_s());
					List<Map<String,Object>> listObjectOvertime=query.list();
					if(listObjectOvertime.size()>0&&listObjectOvertime!=null){
						if(listObjectOvertime.get(0).get("OVERTIME_F")!=null){
							item.setOvertime_f(listObjectOvertime.get(0).get("OVERTIME_F").toString());
						}else{
							item.setOvertime_f(null);
						}
					}else{
						item.setOvertime_f(null);
					}
					@SuppressWarnings("unchecked")
					SQLQuery query1 = createSQLQuery(getSQL("getSmalltime"));
					query1.setParameter("materialcode_s", item.getMaterialcode_s());
					List<Map<String,Object>> listObjectSmalltime=query1.list();
					if(listObjectSmalltime.size()>0&&listObjectSmalltime!=null){
						if(listObjectSmalltime.get(0).get("SMALLTIME_F")!=null){
							item.setSmalltime_f(listObjectSmalltime.get(0).get("SMALLTIME_F").toString());
						}else{
							item.setSmalltime_f(null);
						}
					}else{
						item.setSmalltime_f(null);
					}
				}
				List<Object> list = this.findByField("materialcode_s", item.getMaterialcode_s());
				Object ob = (Object) list;
				List<MaterialsPlus> materialsPlusList = (List<MaterialsPlus>)ob ;
				//String sql="select *  from AT_INT_SAP_MATERIALS m, AT_INT_SAP_MATERIALSPLUS p,CORE_USER u where m.materialcode_s = p.materialcode_s(+) and m.matgrp_s='";
				//List<Object> listObject=getSession().createSQLQuery(sql).list();
				
				if (!ListUtils.isEmpty(materialsPlusList)) {
					if(type.equals("3")&&item.getAtr_key()==null){
						item.setAtr_key(materialsPlusList.get(0).getAtr_key());
					}
					update(item);
				} else {
					save(item);
				}
			}
	}

    //whl -获取物料大类 设置备用字段最大时间与最小时间-20200427
	@RockWellTransactional
	public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		List<Map<String,Object>> listMap = rockWellEntityDTO.getUpdated();
		for (Map<String,Object> item: listMap) {

			// 操作人
			String usercode=WebUtils.getUser().userCode;
			// 机构代码
			String agenc_no_s=FactoryConstant.JING_MEN_CODE;
			
			/*// 记录标志
			item.setRecord_flag_s("A");*/
			
			/*if(item.getBeadwidth_d()==null){
				item.setBeadwidth_d("0");
			}
			if(item.getInnerdia_d()==null){
				item.setInnerdia_d("0");
			}
			if(item.getOuterdia_d()==null){
				item.setOuterdia_d("0");
			}
			if(item.getTyreheight_d()==null){
				item.setTyreheight_d("0");
			}
			if(item.getTyrewidth_d()==null){
				item.setTyrewidth_d("0");
			}*/
			// 修改时间的添加
			//item.setChanged_time_t(new Date());
			String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			StringBuffer stringBuffer=new StringBuffer();
			stringBuffer.append("update  AT_INT_SAP_MATERIALSPLUS ");
			stringBuffer.append("set  changed_time_t=to_date('"+date+"','yyyy-MM-dd HH24:Mi:ss'),overtime_f="+item.get("overtime_f")+",smalltime_f ="+item.get("smalltime_f")+" ,CHANGED_BY_S = '"+usercode+"' ");
			stringBuffer.append("where materialcode_s in (SELECT p.part_number FROM part p,UDA_PART up,PART_CLASS pc,PART_CLASS_PART pcp,AT_INT_SAP_MATERIALSPLUS ma WHERE p.part_number = ma .materialcode_s (+) and p.PART_KEY=UP.OBJECT_KEY and p.PART_KEY=PCP.PART_KEY and PCP.PART_CLASS_KEY=PC.PART_CLASS_KEY ");
			stringBuffer.append("AND UP .companycode_s = '"+FactoryConstant.JING_MEN_CODE+"'  AND UP .mattyp_s != 'FERT'   and pc.PART_CLASS_NAME  not in ('221001','221002','211001','211003') and up.status_s is null  and ma.spare10_s = '0' ");
			stringBuffer.append("and pc.PART_CLASS_NAME ='"+item.get("matgrp_s")+"')");
			PartClass partClass = PCContext.getFunctions().getPartClassByName(item.get("matgrp_s").toString());//whl -获取物料大类 设置备用字段最大时间与最小时间-20200427
			partClass.setUDA(item.get("overtime_f").toString(), 1);//最大时间
			partClass.setUDA(item.get("smalltime_f").toString(), 0);//最小时间
			System.out.println(stringBuffer);
			RockWellUtils.execSQL(stringBuffer.toString());
			partClass.save();
			/*LZMESPRODUCT curing = new LZMESPRODUCT();
			curing.executeRequest();*/
		}

	}

	
	/**
	 * 返回物料信息
	 * @return
	 */
	public List<Map<String, Object>> SapMaterialList(){
		SQLQuery query = getSession().createSQLQuery(
				getSQL("datagrid_sapmaterial"));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	
	public Map<String, Object> datagridTime(Filter filter, Page page) throws Exception {

		// if(LLWebUtils.factory().equals("2")){
		// filter.set("factory", "in:221001,221002");
		// }else{
		// filter.set("factory", "in:211001,211003");
		// }
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsTime(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridTotalTime(filter, page));
		return ret;
	}

	public List<Map<String,Object>> datagridRowsTime(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_rowstime") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_rowstime的SQL语句定义");
		String dataSql = getSQL("datagrid_rowstime", filter.getFilter());
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

	public Long datagridTotalTime(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_totaltime") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_totaltime的SQL语句定义");
		String totalSql = getSQL("datagrid_totaltime", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
	
	public Map<String, Object> datagridGroupTime(Filter filter, Page page) throws Exception {

		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", datagridRowsGroupTime(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", datagridGroupTotalTime(filter, page));
		return ret;
	}

	public List<Map<String, Object>> datagridRowsGroupTime(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_grouptime") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_grouptime的SQL语句定义");
		String dataSql = getSQL("datagrid_grouptime", filter.getFilter());
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

	public Long datagridGroupTotalTime(Filter filter, Page page) throws Exception {
		if (getSQL("datagrid_grouptotaltime") == null)
			throw new Exception(getClass() + ".xml中未找到ID为datagrid_grouptotaltime的SQL语句定义");
		String totalSql = getSQL("datagrid_grouptotaltime", filter.getFilter());
		if (page.getTotalRows() == 0L) {
			SQLQuery query = getSession().createSQLQuery(totalSql);
			setParameter(query, filter);
			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}
}
