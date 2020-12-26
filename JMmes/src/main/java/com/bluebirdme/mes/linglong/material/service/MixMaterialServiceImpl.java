/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.material.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.material.entity.MixMaterial;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import java.util.Date;
/**
 * PLM密炼物料表
 * @author 李德晓
 * @Date 2020-08-05 13:04:58
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MixMaterialServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

	/**
	 *ServiceImpl可以继承RockWellBaseServiceImpl,RockWellUDABaseServiceImpl两个类的区别区分在一下几点上需要注意
	 1.RockWellUDABaseServiceImpl类继承了RockWellBaseServiceImpl
	 2.RockWellUDABaseServiceImpl使用datagridUDA查询全部的时候，返回值为List<Map<String,Object>>类型。
	 RockWellBaseServiceImpl使用datagrid查询返回的是List<T>类型，这个类型是根据Controller里面，调用datagrid
	 方法时传参的类型而决定，在sql中必须要写*查询全部，查询的全部要与实体类所对应。
	 3.本框架在使用增删改时，是操作实体类进行增删改的（这里说的是AT表的情况），因此使用RockWellEntityDTO接收参数之后需要将
	 List<Map<String,Object>>中的Map通过 MapTrunPojo.mapToEntity方法转换为实体类再进行操作。
	 4.如果是使用工厂模型的情况，那么我们的操作方式是直接操作RockWell中api里面的对象
	 5.在操作工厂模型UDA表时，setUDA这个方法的参数为setUDA(value,key)，key值为UDA的字段名称，
	 在代码生成的时候有一个实体类的UDA类，在这个实体类中存放了这个工厂模型对象所有的UDA属性，上面的key值可以直接引用。
	 * 
	 */
    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return MixMaterial.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	@RockWellTransactional
	 public int saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {
		int mun = 0;
		boolean ist = false;
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
		
		/*if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
			
			List<Map<String, Object>> rockWellEntityDTO = equipmentcapacity.getDeleted();
			for(Map<String, Object> newitem:equipmentcapacitys){
				MixMaterial item = (MixMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
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

		}*/
		
		
		/*if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List insertedList = new ArrayList<>();
			List<Map<String, Object>> rockWellEntityDTO = rockWellEntityDTO.getInserted();
			for(Map<String, Object> newitem:equipmentcapacitylist){
				MixMaterial item = (MixMaterial)MapTrunPojo.mapToEntity(newitem, getEntity());
				// 默认参数
				//item.setRecord_flag_s("A");
				//item.setS_factory_s(LLWebUtils.factory());
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
				item.setCreated_time_t(new Date());
				item.setCreated_by_s(LLWebUtils.getUser().userName);
				// 与数据库数据对查重判断
				Where where = new Where();
				//where.andEqual("s_factory_s", LLWebUtils.factory());
				//where.andEqual("record_flag_s", "A");
				//where.andEqual("equipmentcode_s", item.getEquipmentcode_s());
				//where.andEqual("materialgroup_s", item.getMaterialgroup_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				System.err.println(list);

				if (list.size() != 0) {
					ist = true;
				}
				insertedList.add(item);
			}
			
			
			if (ist != false) {
				mun = -1;
			} else {
				save(insertedList);
			}

		}*/

		if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			int con = rockWellEntityDTO.getUpdated().size();
			List insertedList = new ArrayList<>();
			for (int i = 0; i < con; i++) {
				MixMaterial item = (MixMaterial) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i),
						MixMaterial.class);
				item.setChanged_by_s(LLWebUtils.getUser().userName);
				item.setChanged_time_t(new Date());
				
				// 与数据库数据对查重判断
				//Where where = new Where();
				//where.andEqual("s_factory_s", LLWebUtils.factory());
				//where.andEqual("record_flag_s", "A");
				/*where.andEqual("equipmentcode_s", item.getEquipmentcode_s());
				where.andEqual("materialgroup_s", item.getMaterialgroup_s());
				//where.andEqual("materialcapacity_f", item.getMaterialcapacity_f());
				List<Map<String, Object>> list = findMapByWhere(where);
				
				System.err.println(list);

				if (list.size() != 0) {
					ist = true;
				}*/
				/*item.setDummy1_s("");
				item.setDummy2_s("");
				item.setDummy3_s("");
				item.setDummy4_s("");
				item.setDummy5_s("");*/
				insertedList.add(item);
			}
			// 集合去重
			RemoveDuplicate removeDuplicate = new RemoveDuplicate();
			// 去重之后的集合
			if (addString.size() != 1) {
				ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
			}
			// 页面输入与数据库的查重
			if (ist != false) {
				mun = -1;
			} else {
				update(insertedList);
			}
		}
		return mun;

	}
    public String downward(String[] mixmaterialList) throws Exception{

        StringBuffer sb=new StringBuffer();
        String mixmaterial="";
        int success=0;
        int fail=0;
        int i=0;
        for(;i<mixmaterialList.length;i++){
            mixmaterial=mixmaterialList[i];
           /* WSImplementService wsexinterface = new WSImplementService();
            WSExInterface portType = wsexinterface.getWSImplementPort();
            String state = portType.reciveMixMaterialSendByMES(null,null,mixmaterial, LLWebUtils.getUser().userCode,LLWebUtils.getUser().userName);*/
            /*if("OK".equals(state)){
                success++;
            }else{
                sb.append("物料编号："+mixmaterial+"下发结果："+state+"<br>");
                fail++;
            }*/

        }
        sb.append("总计："+i+"条;"+"成功："+success+"条;"+"失败："+fail+"条;");
        return sb.toString();

    }
    public Object findByMaterial(Filter filter, Page page, Class<MixMaterial> mixMaterialClass) throws Exception {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("rows", findByMaterialRow(filter, page, mixMaterialClass));
        filter.setOrder(null);
        filter.setSort(null);
        ret.put("total",findByMaterialTotal(filter, page));
        return ret;
    }
    @SuppressWarnings({ "hiding", "unchecked" })
	public <MixMaterial> List<MixMaterial> findByMaterialRow(Filter filter, Page page, Class<MixMaterial> mixMaterialClass)
            throws Exception {
        if(getSQL("findByMaterialRow") == null){
            throw new Exception(getClass() + ".xml中未找到ID为findByMaterialRow的SQL语句定义");
        }
        String dataSql = getSQL("findByMaterialRow", filter.getFilter());
        SQLQuery query = createSQLQuery(dataSql, mixMaterialClass == null ? getEntity() : mixMaterialClass);
        setParameter(query, filter);
        if (page.getAll() == 0) {
            query.setMaxResults(page.getRows());
            query.setFirstResult((page.getPage() - 1) * page.getRows());
        }
        return query.list();
    }
    public Long findByMaterialTotal(Filter filter, Page page) throws Exception {
        if (getSQL("findByMaterialTotal") == null){
            throw new Exception(getClass()
                    + ".xml中未找到ID为findByMaterialTotal的SQL语句定义");
        }
        String totalSql = getSQL("findByMaterialTotal", filter.getFilter());
        if (page.getTotalRows() == 0L) {
            SQLQuery query = getSession().createSQLQuery(totalSql);
            setParameter(query, filter);
            return ((BigDecimal) query.uniqueResult()).longValue();
        } else {
            return page.getTotalRows();
        }
    }

    	public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

    		/*String FACTORY = "s_factory_s";

    		if (!filter.getFilter().containsKey(FACTORY)) {
    			try {
    				filter.set("s_factory_s", LLWebUtils.factory());
    			} catch (Exception e) {
    				throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
    			}
    		}*/


    		Map<String, Object> ret = new HashMap<String, Object>();
    		ret.put("rows", datagridRowsUDA(filter, page));
    		filter.setOrder(null);
    		filter.setSort(null);
    		ret.put("total", datagridTotalUDA(filter, page));
    		return ret;

    	}

    	@SuppressWarnings({ "unchecked" })
    	public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
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
    }


