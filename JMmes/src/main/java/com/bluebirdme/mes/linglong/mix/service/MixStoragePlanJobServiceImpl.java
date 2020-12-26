/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.MixStoragePlanJob;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * 盘库计划管理表
 * @author 陈国强
 * @Date 2020-08-18 08:37:07
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class MixStoragePlanJobServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return MixStoragePlanJob.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception{
        
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
        		//将MAP转换为实体
        		MixStoragePlanJob mixstorageplanjob=(MixStoragePlanJob) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), MixStoragePlanJob.class);
        		//mixstorageplanjob.setCreated_time_t(new Date()); 
        		list.add(mixstorageplanjob);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		MixStoragePlanJob mixstorageplanjob =(MixStoragePlanJob) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), MixStoragePlanJob.class);
        		//mixstorageplanjob.setCreated_time_t(new Date()); 
        		list.add(mixstorageplanjob);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		MixStoragePlanJob mixstorageplanjob=(MixStoragePlanJob) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), MixStoragePlanJob.class);
        		//mixstorageplanjob.setCreated_time_t(new Date()); 
        		update(mixstorageplanjob);
        	}
        }
    
    }
    @SuppressWarnings("unused")
	private String buildcommonMsg(Integer type, String msg) {
        String color = "";
        if (type.equals(Integer.valueOf(0))) {
          color = "<font color=ff0000>";
        } else if (type.equals(Integer.valueOf(1))) {
          color = "<font color=000000>";
        } else if (type.equals(Integer.valueOf(2))) {
          color = "<font color=f7df09>";
        } 
        return color + msg + "<br>";
      }
 /* public String down(Long[] ids) throws Exception {
    try {
      MESWSImplementService wsexinterface = new MESWSImplementService();
      INVWSInterface portType = wsexinterface.getMESWSImplementPort();
      StringBuffer errorBuffer = new StringBuffer();
      StringBuffer resultBuffer = new StringBuffer();
      String result = portType.reciveInventoryAddJobByMES(ids[1].toString(), ids[0].toString(), "347001", 
          (LLWebUtils.getUser()).userCode, (LLWebUtils.getUser()).userName, null, null, null, null, null);
      if (result.equals("OK")) {
        resultBuffer.append(buildcommonMsg(Integer.valueOf(1), "+ result"));
      } else {
        errorBuffer.append(buildcommonMsg(Integer.valueOf(0), "+ result"));
      } 
      return resultBuffer.toString() + "<br>" + errorBuffer.toString();
    } catch (Exception e) {
      return e.getMessage();
    } 
  }*/
  
  /*public String deletes(String[] ids) throws Exception {
    try {
      MESWSImplementService wsexinterface = new MESWSImplementService();
      INVWSInterface portType = wsexinterface.getMESWSImplementPort();
      StringBuffer errorBuffer = new StringBuffer();
      StringBuffer resultBuffer = new StringBuffer();
      String result = portType.reciveInventoryDelJobByMES(ids[0].toString(), "347001", (LLWebUtils.getUser()).userCode, (LLWebUtils.getUser()).userName, null, null, null, null, null);
      if (result.equals("OK")) {
        resultBuffer.append(buildcommonMsg(Integer.valueOf(1), "+ ids[0].toString() + ","+ result"));
      } else {
        errorBuffer.append(buildcommonMsg(Integer.valueOf(0), "+ ids[0].toString() + ","+ result"));
      } 
      return resultBuffer.toString() + "<br>" + errorBuffer.toString();
    } catch (Exception e) {
      return e.getMessage();
    } 
  }
*/

}
