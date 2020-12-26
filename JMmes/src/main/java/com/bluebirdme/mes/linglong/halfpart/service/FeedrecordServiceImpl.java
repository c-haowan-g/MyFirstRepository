/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.Feedrecord;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;

/**
 * 投料记录
 * 
 * @author 徐秉正
 * @Date 2020-03-23 13:42:36
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class FeedrecordServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	/**
	 * ServiceImpl可以继承RockWellBaseServiceImpl,
	 * RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 * 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 * 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候
	 * ，返回值为List<Map<String,Object>>类型。
	 * RockWellBaseServiceImpl使用datagrid查询返回的是List
	 * <T>类型，这个类型是根据Controller里面，调用datagrid
	 * 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 * 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 * List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 * 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 * 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 * 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return Feedrecord.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
    public Integer saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        	int mun = 0;
    		boolean ist = false;
    		String materialcode_s = null;
    		String machinecode_s=null;
    		Long atr_key = null;
    		// Sql
    		BigDecimal rs = null;
    		BigDecimal rs1=null;
    		// 页面多行同时添加时的查重判断
    		List<String> addString = new ArrayList<>();
    		List ruplicateList = new ArrayList<>();
    		
    		List<String> materialaddString = new ArrayList<>();
    		List materialaddruplicateList = new ArrayList<>();
    		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
    			int con = rockWellEntityDTO.getDeleted().size();
            	List list = new ArrayList<>();
    			for(int i = 0; i < con; i++){
    				Feedrecord item = (Feedrecord)MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), Feedrecord.class);
            			// 修改存在状态
    				item.setRecord_flag_s("D");
    				// 修改创建时间
    				Date date = new Date();
//    				item.setChanged_by_s(
//    						WebUtils.getUser().userCode);
    				Timestamp timestamp = DateUtil.dateToTime(date);
    				item.setChanged_time_t(timestamp);
    				list.add(item);
    			}
    			update(list);
    		}
    		
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	int con = rockWellEntityDTO.getInserted().size();
        	List list = new ArrayList<>();
			for(int i = 0; i < con; i++){
					// 添加创建人
				Feedrecord item = (Feedrecord)MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), Feedrecord.class);
        		
				item.setCreated_by_s(
						WebUtils.getUser().userCode);
				item.setChanged_by_s(
						WebUtils.getUser().userCode);
				HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				HttpSession session = request.getSession();
				// 添加时间
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setCreated_time_t(timestamp);
				item.setChanged_time_t(timestamp);
				// 默认参数
				item.setRecord_flag_s("A");
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(
						FactoryConstant.JING_MEN_CODE);
				//item.setMaterialcode_s(materialGroupSave(item.getMaterialcode_s()).get(0).get("DICTNAME_S").toString());
				materialcode_s = item.getMaterialcode_s();
				machinecode_s=item.getMachinecode_s();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("materialcode_s",materialcode_s);
				List<Map<String, Object>> maplist = findMapByWhere(where);
				
				
				Where where1 = new Where();
				where1.andEqual("s_factory_s", LLWebUtils.factory());
				where1.andEqual("record_flag_s", "A");
				where1.andEqual("machinecode_s", item.getMachinecode_s());
				List<Map<String, Object>> maplist1 = findMapByWhere(where1);
				
				
				String listString=materialcode_s;
				addString.add(listString);
				ruplicateList.add(listString);

				
				String listmaterial_capsulecode_s=machinecode_s;
				materialaddString.add(listmaterial_capsulecode_s);
				materialaddruplicateList.add(listmaterial_capsulecode_s);
				
				
				if (maplist.size() != 0 && maplist1.size() != 0) {
					ist = true;
				}
//				if (maplist1.size() != 0) {
//					ist = true;
//				}
				list.add(item);
			}
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1&&materialaddString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
//			if (materialaddString.size() != 1) {
//				materialaddruplicateList = removeDuplicate.removeDuplicate(materialaddruplicateList);
//			}
			if (addString.size() != ruplicateList.size()&&materialaddString.size() != materialaddruplicateList.size()) {
				ist = true;
			}
//			if (materialaddString.size() != materialaddruplicateList.size()) {
//				ist = true;
//			}
			if (ist != false) {
				mun = -1;
			} else {
				save(list);
			}

		}
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	int con = rockWellEntityDTO.getUpdated().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
				Feedrecord item = (Feedrecord)MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), Feedrecord.class);
				// 时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_by_s(
						WebUtils.getUser().userCode);
				item.setChanged_time_t(timestamp);
				//item.setMaterialcode_s(materialGroupSave(item.getMaterialcode_s()).get(0).get("DICTNAME_S").toString());
				materialcode_s = item.getMaterialcode_s();
				atr_key=item.getAtr_key();
				// atr_key = mouldstockslist.get(i).getAtr_key();
				rs = (BigDecimal) getSession().createSQLQuery(getSQL("update"))
						.setParameter("materialcode_s", materialcode_s)
						.setParameter("s_factory_s", LLWebUtils.factory())
						.setParameter("atr_key", atr_key).uniqueResult();
				
				machinecode_s = item.getMachinecode_s();
				atr_key=item.getAtr_key();
				// atr_key = mouldstockslist.get(i).getAtr_key();
				rs1 = (BigDecimal) getSession().createSQLQuery(getSQL("update1"))
						.setParameter("machinecode_s", machinecode_s)
						.setParameter("s_factory_s", LLWebUtils.factory())
						.setParameter("atr_key", atr_key).uniqueResult();
				
				String listString=materialcode_s;
				addString.add(listString);
				ruplicateList.add(listString);
				
				String listmaterial_capsulecode_s=machinecode_s;
				materialaddString.add(listmaterial_capsulecode_s);
				materialaddruplicateList.add(listmaterial_capsulecode_s);
				if (rs.intValue() != 0&&rs1.intValue() != 0) {
					ist = true;
				}
//				if (rs1.intValue() != 0) {
//					ist = true;
//				}
				list.add(item);
        	}
				
			
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1&&addString.size() != ruplicateList.size()) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
//			if (addString.size() != ruplicateList.size()) {
//        		ist = true;
//        	}
			if (materialaddString.size() != 1&&materialaddruplicateList.size() != materialaddString.size()) {
				ruplicateList = removeDuplicate.removeDuplicate(materialaddruplicateList);
			}

//			if (materialaddruplicateList.size() != materialaddString.size()) {
//				ist = true;
//			}
			// 页面输入与数据库的查重
			if (ist != false) {
				mun = -1;
			} else {
				update(list);
			}
		
        }
		return mun;
	}

	/**
	 * 
	 * 查出q全钢所需要的物料
	 * 
	 * @param zoneName
	 * @param factory
	 * @return
	 */

	public List<Map<String, Object>> materialGroupList() {
		SQLQuery query = createSQLQuery(getSQL("materialGroupList"));

		return query.list();
	}

	public List<Map<String, Object>> materialGroupSearch(String data) {
		SQLQuery query = createSQLQuery(getSQL("materialGroupSearch"));
		System.out.println(query);
		System.out.println(getSQL("materialGroupSearch"));
query.setParameter("data", data);
		return query.list();
	}
	public List<Map<String, Object>> materialGroupSave(String data) {
		SQLQuery query = createSQLQuery(getSQL("materialGroupSave"));
		System.out.println(query);
		System.out.println(getSQL("materialGroupSave"));
query.setParameter("data", data);
		return query.list();
	}
	// 查询产线
	public List<String> getHalfPartProductionLine() {
		SQLQuery query = createSQLQuery(getSQL("getHalfPartProductionLine"));
		query.setParameter("process", Process.HalfPart);
		if (LLWebUtils.factory().equals(Factory.FullSteel)) { // 根据全钢和半钢区分area
			query.setParameter("factory", Factory.FullSteel);
		} else if (LLWebUtils.factory().equals(Factory.HalfSteel)) {
			query.setParameter("factory", Factory.HalfSteel);
		}
		return query.list();
	}

	// 查询当天日计划号
	public List<Map<String, Object>> getPlanno() {
		SQLQuery query = createSQLQuery(getSQL("getPlanno"));

		return query.list();
	}
	
	/**
	 * 查出物料组显示在JSP页面下拉列表处
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchMaterialGroup() {
		SQLQuery query = createSQLQuery(getSQL("searchMaterialGroup"));
		String sfs = "";
		if (LLWebUtils.factory().equals("1")) {
			sfs = "%半钢%";
		} 
		if (LLWebUtils.factory().equals("2")) {
			sfs = "%全钢%";
		}
		query.setParameter("sfs", sfs);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	/**
	 * 根据物料组编号查询物料组名称
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getNameByGroupCode(String materialgroup_s) {
		SQLQuery query = createSQLQuery(getSQL("getNameByGroupCode"));
		query.setParameter("materialgroup_s", materialgroup_s);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	/**
	 * 根据用户号码查询姓名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toUserName(String usercode) {
		SQLQuery query = createSQLQuery(getSQL("toUserName"));
		query.setParameter("usercode", usercode);
		System.out.println(getSQL("toUserName").toString());
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
	
	
	/**
	 * 根据机台编码查询机台名
	 * 
	 * @return
	 */
	public List<Map<String, Object>> toEquipName(String equipcode) {
		SQLQuery query = createSQLQuery(getSQL("toEquipName"));
		query.setParameter("equipcode", equipcode);
		TransformUpperCase transformUpperCase=new TransformUpperCase();
		List<Map<String, Object>> result_1=query.list();
		List<Map<String, Object>> list_1 = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < result_1.size(); i++) {
			list_1.add(TransformUpperCase.transformUpperCase(result_1.get(i)));
		}
		return list_1;
	}
	
}
