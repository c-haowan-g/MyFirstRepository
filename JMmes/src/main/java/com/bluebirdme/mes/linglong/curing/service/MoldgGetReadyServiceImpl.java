/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.pnuts.tools.console;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
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
import com.bluebirdme.mes.linglong.curing.entity.MoldRecord;
import com.bluebirdme.mes.linglong.curing.entity.MoldgGetReady;
import com.bluebirdme.mes.linglong.test.entity.MachineCheckRecord;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.datasweep.compatibility.pnutsfunctions.box.returnBoxHistory;

/**
 * 模具备模
 * 
 * @author 时永良
 * @Date 2018-08-24 15:07:23
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MoldgGetReadyServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MoldgGetReady.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}
	/**
	 * 根据换模计划号，拿到日计划中计划数量左和计划数量右
	 * @param moldchangePlanno
	 * @return
	 */
	@SuppressWarnings("unchecked")
    public List<Map<String,Object>> getPlanNum(String moldchangePlanno){
    	SQLQuery query = getSession().createSQLQuery(getSQL("getPlanNum"));
		query.setParameter("planno_changemold_s", moldchangePlanno);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String, Object>> res=query.list();
		return res;
    }
	
	
	/**
	 * 左模具数据的查询
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> left(Map<String,Object> map) {
		SQLQuery query = getSession().createSQLQuery(getSQL("leftQuery"));
		query.setParameter("speccode_left_s", map.get("speccode_left_s"));
		query.setParameter("flowercode_left_s", map.get("flowercode_left_s"));
		//query.setParameter("equip_code_s", map.get("equip_code_s"));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		
		SQLQuery query2 = getSession().createSQLQuery(getSQL("leftQuery2"));
		query2.setParameter("speccode_left_s", map.get("speccode_left_s"));
		query2.setParameter("flowercode_left_s", map.get("flowercode_left_s"));
		query2.setParameter("equip_code_s", map.get("equip_code_s"));
		query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> res1=query.list();
		List<Map<String, Object>> res2=query2.list();
		
		res2.addAll(res1);
		return res2;
	}
	/**
	 * 右模具数据的查询
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> right(Map<String,Object> map) {
		SQLQuery query = getSession().createSQLQuery(getSQL("rightQuery"));
		query.setParameter("speccode_right_s", map.get("speccode_right_s"));
		query.setParameter("flowercode_right_s", map.get("flowercode_right_s"));
		//query.setParameter("equip_code_s", map.get("equip_code_s"));
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		
		SQLQuery query2 = getSession().createSQLQuery(getSQL("rightQuery2"));
		query2.setParameter("speccode_right_s", map.get("speccode_right_s"));
		query2.setParameter("flowercode_right_s", map.get("flowercode_right_s"));
		query2.setParameter("equip_code_s", map.get("equip_code_s"));
		query2.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> res1=query.list();
		List<Map<String, Object>> res2=query2.list();
		res2.addAll(res1);
		return res2;
	}

	@RockWellTransactional
	public int moldSave(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		// 修改
		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
			List list = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				MoldgGetReady moldgGetReady=(MoldgGetReady) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), MoldgGetReady.class);
				moldgGetReady.setExecutive_s("0");
				update(moldgGetReady);
				saveMold(moldgGetReady,"206002");
			}
		}	
		if(!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())){
			int con = rockWellEntityDTO.getDeleted().size();
			List list = new ArrayList<>();
			String executive_s=null;
			String plan_status_s=null;
			for (int i = 0; i < con; i++) {
				MoldgGetReady moldgGetReady=(MoldgGetReady) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), MoldgGetReady.class);
				moldgGetReady.setMold_barcode_left_s("");
				moldgGetReady.setMoldbarcode_right_s("");
				executive_s=moldgGetReady.getExecutive_s();
				plan_status_s=moldgGetReady.getPlan_status_s();
				if(executive_s.equals("1")||plan_status_s.equals("219006")){
					return -1;
				}else{
					saveMold(moldgGetReady,"206001");
					update(moldgGetReady);
				}
			}
		}
		return 0;
	}
	
	/**
	 * 备模时履历方法
	 * @param chmode_plan_no_s 换模计划号
	 * optype_s 操作类型
	 * material_code_left_s 左模物料
	 * @throws Exception 
	 */
	@RockWellTransactional
	public void saveMold(MoldgGetReady moldgGetReady,String Optype_s) throws Exception{
		MoldRecord moldRecord = new MoldRecord();
		//操作类型
		moldRecord.setOptype_s(Optype_s);
		//计划号
		moldRecord.setChmode_plan_no_s(moldgGetReady.getPlanno_changemold_s());
		//左模物料
		moldRecord.setMaterial_code_left_s(moldgGetReady.getMaterial_code_left_s());
		//左模模具编码
		moldRecord.setMold_code_left_s(moldgGetReady.getMold_barcode_left_s());
		//右模物料
		moldRecord.setMaterial_code_right_s(moldgGetReady.getMaterial_code_right_s());
		//右模编码
		moldRecord.setMold_code_right_s(moldgGetReady.getMoldbarcode_right_s());
		// 机构编码
		moldRecord.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
		//机台，也就是产线编码
		moldRecord.setEquip_code_s(moldgGetReady.getEquip_code_s());
		// 创建时间跟修改时间的添加
		Date date = new Date();
		Timestamp timestamp = DateUtil.dateToTime(date);
		moldRecord.setCreated_time_t(timestamp);
		moldRecord.setChanged_time_t(timestamp);
		//创建人，修改人
		moldRecord.setCreated_by_s(WebUtils.getUser().userCode);
		moldRecord.setChanged_by_s(WebUtils.getUser().userCode);
		//是否可读
		moldRecord.setRecord_flag_s("A");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		//工厂
		moldRecord.setS_factory_s(com.bluebirdme.mes.linglong.core.utils.LLWebUtils.factory());
		RockWellUtils.save(moldRecord);
	}
	
	
	/**
	 * 备模履历查询
	 */
	@SuppressWarnings("unused")
	public Map<String, Object> moldRecordDatagrid(Filter filter, Page page) throws Exception {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("rows", moldRecordDatagridRows(filter, page));
		filter.setOrder(null);
		filter.setSort(null);
		ret.put("total", moldRecordDatagridTotal(filter, page));
		return ret;
	}
	
	public Long moldRecordDatagridTotal(Filter filter, Page page) throws Exception {

		if (getSQL("moldRecordDatagrid_total") == null)
			throw new Exception(getClass() + ".xml中未找到ID为moldRecordDatagrid_total的SQL语句定义");

		String totalSql = getSQL("moldRecordDatagrid_total", filter.getFilter());

		if (page.getTotalRows() == 0L) {

			SQLQuery query = getSession().createSQLQuery(totalSql);

			setParameter(query, filter);

			return ((BigDecimal) query.uniqueResult()).longValue();
		} else {
			return page.getTotalRows();
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Map<String,Object>> moldRecordDatagridRows(Filter filter, Page page) throws Exception {

		if (getSQL("moldRecordDatagrid_rows") == null)
			throw new Exception(getClass() + ".xml中未找到ID为moldRecordDatagrid_rows的SQL语句定义");

		String dataSql = getSQL("moldRecordDatagrid_rows", filter.getFilter());
		System.out.println(dataSql);
		SQLQuery query = createSQLQuery(dataSql);
		setParameter(query, filter);

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
		return  returnlist;
	}
	/**
	 * 验证换模计划是否是已审核状态
	 * @param planno_s 换模计划号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Boolean validMoldChangePlan(String planno_s) {
		if (planno_s == null) {
			return false;
		}
		String count="0";
		List<Map<String, Object>> codes = createSQLQuery(getSQL("validMoldChangePlan")).setParameter("moldchangeplanno_s", planno_s).list();
		for(Map<String,Object> map :codes){
			  count =map.get("COUNT").toString();
   	       }
		
		if(count.equals("0")) 
			return false;
		else 
			return true;
	}
}
