/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.curing.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.curing.entity.MaterialPdf;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;

/**
 * 模具标识图维护
 * 
 * @author 时永良
 * @Date 2018-08-20 13:57:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MaterialPdfServiceImpl extends RockWellUDABaseServiceImpl<Object> {

	@Resource
	LingLongDataSource llds;

	@Override
	protected Session getSession() {
		return llds.getSession();
	}

	@Override
	protected Class getEntity() {
		return MaterialPdf.class;
	}

	@Override
	protected boolean useCache() {
		return false;
	}

	@RockWellTransactional
	public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		// 物料编码
		String material_code_s = null;
		String vision_s = null;
		// atr_key
		Long atr_key = null;
		// Sql
		BigDecimal rs = null;
		//需要修改有效无效的物料集合
		List<String> listSql = new ArrayList<>();
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		// 删除
		if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			int con = rockWellEntityDTO.getDeleted().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
        		MaterialPdf materialPdf=(MaterialPdf) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), MaterialPdf.class);
        		materialPdf.setRecord_flag_s("D");
        		// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				materialPdf.setChanged_time_t(timestamp);
				materialPdf.setCreated_time_t(timestamp);
				list.add(materialPdf);
        	}
        	update(list);
		}

		// 添加
		if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			int con = rockWellEntityDTO.getInserted().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
        		MaterialPdf materialPdf=(MaterialPdf) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), MaterialPdf.class);
        	    if(materialPdf.getIs_flag_s().equals("1")){
        	    	listSql.add(materialPdf.getMaterial_code_s());
        	    }
        	    materialPdf.setCreated_by_s(WebUtils.getUser().userCode);
        	    materialPdf.setChanged_by_s(WebUtils.getUser().userCode);
        	    materialPdf.setUploader_s(WebUtils.getUser().userCode);
        	    materialPdf.setRecord_flag_s("A");
        	    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
				HttpSession session = request.getSession();
				materialPdf.setS_factory_s(LLWebUtils.factory());
				// 创建时间的添加
				Date date = new Date();
				Timestamp timestamp = DateUtil.dateToTime(date);
				materialPdf.setCreated_time_t(timestamp);
				materialPdf.setChanged_time_t(timestamp);
				materialPdf.setUpload_time_t(timestamp);
				// 机构编码
				materialPdf.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				// 物料编码
				material_code_s = materialPdf.getMaterial_code_s();
				// 版本
				vision_s =materialPdf.getVision_s();
				// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("material_code_s", material_code_s);
				where.andEqual("vision_s", vision_s);
				where.andEqual("s_factory_s", LLWebUtils.factory());
				where.andEqual("record_flag_s", "A");
				List<Map<String, Object>> mapList = findMapByWhere(where);
				// 需要查重的条件
				String listString = material_code_s + vision_s;
				addString.add(listString);
				ruplicateList.add(listString);
				if (mapList.size() != 0) {
					ist = true;
				}
				list.add(materialPdf);
        	}
        	// 集合去重
        				RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        				// 去重之后的集合
        				if (addString.size() != 1) {
        					ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        				}
        				if (addString.size() != ruplicateList.size()) {
        					ist = true;
        				}
        				// 页面输入与数据库的查重
        				if (ist != false) {
        					mun = -1;
        				} else {
        					for(int k=0;k<listSql.size();k++ ){
        						StringBuffer sql = new StringBuffer("update AT_C_QM_MATERIALPDF set Is_flag_s ='0'");
        						sql.append(" where Material_code_s='"+listSql.get(k)+"'");
        						System.out.println(sql);
        						RockWellUtils.execSQL(sql.toString());
        					}
        					save(list);
        				}
		}

		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
        	List list = new ArrayList<>();
        	// set指定的数据
        	for (int i = 0; i < con; i++) {
        		MaterialPdf materialPdf=(MaterialPdf) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), MaterialPdf.class);
        		//判断新添加的数据是否有效如是有效就加上集合中
        		 if(materialPdf.getIs_flag_s().equals("1")){
         	    	listSql.add(materialPdf.getMaterial_code_s());
        		 }
        		 // 修改人
         	     materialPdf.setChanged_by_s(WebUtils.getUser().userCode);
         	     // 上传人
         	     materialPdf.setUploader_s(WebUtils.getUser().userCode);
         	     // 创建时间的添加
 				Date date = new Date();
 				Timestamp timestamp = DateUtil.dateToTime(date);
 			    // 维护时间
 				materialPdf.setChanged_time_t(timestamp);
 				materialPdf.setCreated_time_t(timestamp);
 			    // 上传时间
 				materialPdf.setUpload_time_t(timestamp);
 			    // 物料编码
				material_code_s = materialPdf.getMaterial_code_s();
				// 版本
				vision_s =materialPdf.getVision_s();
				// atr_key
				atr_key = materialPdf.getAtr_key();
				// 与数据库数据对查重判断
				rs = (BigDecimal) getSession().createSQLQuery(getSQL("update"))
						.setParameter("material_code_s", material_code_s)
						.setParameter("vision_s", vision_s)
						.setParameter("s_factory_s", LLWebUtils.factory())
						.setParameter("atr_key", atr_key).uniqueResult();
				// 需要查重的条件
				String listString = material_code_s + vision_s;
				addString.add(listString);
				ruplicateList.add(listString);
				//
				if (rs.intValue() != 0) {
					ist = true;
				}
				list.add(materialPdf);
        	}
        	// 集合去重
        				RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        				// 去重之后的集合
        				if (addString.size() != 1) {
        					ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        				}
        				if (addString.size() != ruplicateList.size()) {
        					ist = true;
        				}
        				// 页面输入与数据库的查重
        				if (ist != false) {
        					mun = -1;
        				} else {
        					for(int k=0;k<listSql.size();k++ ){
        						StringBuffer sql = new StringBuffer("update AT_C_QM_MATERIALPDF set Is_flag_s ='0'");
        						sql.append(" where Material_code_s='"+listSql.get(k)+"'");
        						System.out.println(sql);
        						RockWellUtils.execSQL(sql.toString());
        					}
        					update(list);
        				}
		}
		return mun;
	}

	/**
	 * 物料编码的查询
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchByMaterial() {
		SQLQuery query = createSQLQuery(getSQL("searchByMaterial"));
		String s_factory_s=LLWebUtils.factory();
		String[] paraStringsQ=new String[2];
		paraStringsQ[0]="211001";
		paraStringsQ[1]="211003";
		
		String[] paraStringsB=new String[2];
		paraStringsB[0]="221001";
		paraStringsB[1]="221002";
		if(s_factory_s.equals("1")){
			query.setParameterList("matgrp_s", paraStringsQ);
		}
		if(s_factory_s.equals("2")){
			query.setParameterList("matgrp_s", paraStringsB);
		}
		List<Map<String, Object>> list = query.list();
		return list;
	}
}
