/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bluebirdme.core.system.annotations.Log;
import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.VehiclesDetailInfo;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

import java.util.Date;
/**
 * 口型板规格对应信息表
 * @author 栾和源
 * @Date 2020-03-04 11:27:02
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VehiclesDetailInfoServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return VehiclesDetailInfo.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
  
    @RockWellTransactional
    public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int num = 0;
		boolean ist = false;
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			
			List<Map<String, Object>> vehiclesdetailinfos = rockWellEntityDTO.getDeleted();
			for(Map<String, Object> newitem:vehiclesdetailinfos){
				VehiclesDetailInfo item = (VehiclesDetailInfo)MapTrunPojo.mapToEntity(newitem, getEntity());
        		// 修改存在状态
				item.setRecord_flag_s("D");
				// 修改创建时间
				Date date = new Date();
				item.setChanged_by_s(
						WebUtils.getUser().userName);
				Timestamp timestamp = DateUtil.dateToTime(date);
				item.setChanged_time_t(timestamp);
				update(item);
			}

		}
		
		
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> vehiclesdetailinfos = rockWellEntityDTO.getInserted();
			System.out.println("vehiclesdetailinfos"+vehiclesdetailinfos.size());
			for(Map<String, Object> newitem:vehiclesdetailinfos){
				VehiclesDetailInfo item = (VehiclesDetailInfo)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				item.setCreated_by_s(LLWebUtils.getUserName());
				item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setRecord_flag_s("A");
				item.setCreated_time_t(new Date());
				item.setChanged_by_s(LLWebUtils.getUserName());
				item.setChanged_time_t(new Date());
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("vehicles_barcode_s", item.getVehicles_barcode_s());
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("materialcode_s", item.getMaterialcode_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				addString.add(item.getVehicles_barcode_s()	
						+ item.getMaterialcode_s());
				ruplicateList.add(item.getVehicles_barcode_s()	
						+ item.getMaterialcode_s());
				
				if (list.size() != 0) {
					ist = true;
				}
				
				insertedList.add(item);
			}
			
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
			
			if (ist != false) {
				num = -1;
				
			} else {
				save(insertedList);
			}
			
		}

		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
			List insertedList = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				VehiclesDetailInfo item = (VehiclesDetailInfo) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i),
						VehiclesDetailInfo.class);
				item.setCreated_by_s(LLWebUtils.getUserName());
				item.setS_factory_s(LLWebUtils.factory());
				item.setChanged_by_s(LLWebUtils.getUserName());
				item.setChanged_time_t(new Date());
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("vehicles_barcode_s", item.getVehicles_barcode_s());
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				where.andEqual("materialcode_s", item.getMaterialcode_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);
				
				addString.add(item.getVehicles_barcode_s()	
						+ item.getMaterialcode_s());
				ruplicateList.add(item.getVehicles_barcode_s()	
						+ item.getMaterialcode_s());
				if (list.size() != 0) {
					ist = true;
				}
				
				insertedList.add(item);
			}
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
			// 页面输入与数据库的查
			if (ist != false) {
				num = -1;
			} else {
				update(insertedList);
			}
		}
		return num;

	}
    
    /**
   	 * 查出口型板条码、口型板规格显示在JSP页面下拉列表处
   	 * 
   	 * @return
   	 */
   	public List<Map<String, Object>> searchVehiclesDescription() {
   		SQLQuery query = createSQLQuery(getSQL("searchVehiclesDescription"));
   		String s_factory_s=LLWebUtils.factory();
   		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
   		//query.setParameter("area_name",AGENC_NO_S+s_factory_s+"B");
   		query.setParameter("s_factory_s",s_factory_s);
   		query.setParameter("agenc_no_s",AGENC_NO_S);
   		System.out.println(getSQL("searchVehiclesDescription").toString());
   		return query.list();
   	}
   	
   	/**
   	 * 查出物料板规格显示在JSP页面下拉列表处
   	 * 
   	 * @return
   	 */
   	public List<Map<String, Object>> searchMaterialDescription() {
   		SQLQuery query = createSQLQuery(getSQL("searchMaterialDescription"));
   		/*String s_factory_s=LLWebUtils.factory();
   		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
   		//query.setParameter("area_name",AGENC_NO_S+s_factory_s+"B");
   		query.setParameter("s_factory_s",s_factory_s);
   		query.setParameter("agenc_no_s",AGENC_NO_S);*/
   		System.out.println(getSQL("searchMaterialDescription").toString());
   		return query.list();
   	}
   	
   	/**
	 * 数据库查重
	 * 
	 * @return
	 */
   	/*
	@Log(code = "getRepeat", value = "数据库查重")
	@RequestMapping("getRepeat")
	public int getRepeat(String vehicles_barcode_s,String materialcode_s) throws Exception {
		System.out.println(vehicles_barcode_s);
		System.out.println(materialcode_s);
		
		SQLQuery query = getSession().createSQLQuery(getSQL("getRepeat"));
		query.setParameter("vehicles_barcode_s", vehicles_barcode_s);
		query.setParameter("materialcode_s", materialcode_s);
   		System.out.println(getSQL("getRepeat").toString());
   		System.out.println(query.uniqueResult());
   	
   		int result=Integer.parseInt(query.uniqueResult().toString()) ;
   		return result;
	}*/
		
   	
   	

}
