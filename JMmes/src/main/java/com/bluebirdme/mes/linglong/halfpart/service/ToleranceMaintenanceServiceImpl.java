/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.ToleranceMaintenance;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Process;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * 半部件砝码公差维护表
 * @author 时永良
 * @Date 2020-12-04 14:58:57
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ToleranceMaintenanceServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return ToleranceMaintenance.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		ToleranceMaintenance tolerancemaintenance =(ToleranceMaintenance) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), ToleranceMaintenance.class);
        		tolerancemaintenance.setRecord_flag_s("A");
        		tolerancemaintenance.setAgenc_no_s("8023");
        		tolerancemaintenance.setS_factory_s(LLWebUtils.factory());
        		tolerancemaintenance.setCreated_time_t(new Date()); 
        		tolerancemaintenance.setCreated_by_s(LLWebUtils.getUserName());
        		list.add(tolerancemaintenance);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		ToleranceMaintenance tolerancemaintenance=(ToleranceMaintenance) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), ToleranceMaintenance.class);
        		tolerancemaintenance.setProductionline_s(tolerancemaintenance.getProductionline_s());
        		tolerancemaintenance.setStandardweight_s(tolerancemaintenance.getStandardweight_s());
        		tolerancemaintenance.setTolerance_s(tolerancemaintenance.getTolerance_s());
        		tolerancemaintenance.setChanged_by_s(LLWebUtils.getUserName());
        		tolerancemaintenance.setChanged_time_t(new Date());
        		update(tolerancemaintenance);
        	}
        }
    
    }

	/**
 	 * 获得半部件用产线
 	 * 时永良
 	 * get production name in half-part
 	 * 2020年3月6日14:50:59
 	 */
	public String getHalfPartProductionLine(String plinename){
 		SQLQuery query=createSQLQuery(getSQL("getHalfPartProductionLine"));
 		query.setParameter("process",Process.HalfPart);
 		query.setParameter("plinename", plinename);
		if(LLWebUtils.factory().equals(Factory.FullSteel)){  //根据全钢和半钢区分area
			query.setParameter("factory",Factory.FullSteel);
		}else if(LLWebUtils.factory().equals(Factory.HalfSteel)){
			query.setParameter("factory",Factory.HalfSteel);
		}
		List<Map<String, Object>> list=query.list();
    	if(list==null){
    		return null;
    	}
		return list.get(0).get("DESCRIPTION").toString();
 	}
	
	/**
 	 * 获得半部件用产线
 	 * 时永良
 	 * get production name in half-part
 	 * 2020年3月6日14:50:59
 	 */
	public List<String> getBuildingProductionLine(){
 		SQLQuery query=createSQLQuery(getSQL("getBuildingProductionLine"));
 		query.setParameter("process",Process.Building);
 		
		if(LLWebUtils.factory().equals(Factory.FullSteel)){  //根据全钢和半钢区分area
			query.setParameter("factory",Factory.FullSteel);
		}else if(LLWebUtils.factory().equals(Factory.HalfSteel)){
			query.setParameter("factory",Factory.HalfSteel);
		}
		/*List<Map<String, Object>> list=query.list();
    	if(list==null){
    		return null;
    	}
    	List<String> list2=new ArrayList<String>();
    	for(int i=0;i<list.size();i++){
    		list2.add(list.get(0).get("DESCRIPTION").toString());
    	}*/
		
		return query.list();
	}
	
}
