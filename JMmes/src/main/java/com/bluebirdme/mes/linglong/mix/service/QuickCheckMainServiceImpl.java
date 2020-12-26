/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.mix.entity.QuickCheckMain;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * 密炼胶料快检主表
 * @author 栾和源
 * @Date 2020-12-17 11:15:45
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class QuickCheckMainServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return QuickCheckMain.class;
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
        		QuickCheckMain quickcheckmain=(QuickCheckMain) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), QuickCheckMain.class);
        		//quickcheckmain.setCreated_time_t(new Date()); 
        		list.add(quickcheckmain);
        	}
        	delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		QuickCheckMain quickcheckmain =(QuickCheckMain) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), QuickCheckMain.class);
        		//quickcheckmain.setCreated_time_t(new Date()); 
        		list.add(quickcheckmain);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		QuickCheckMain quickcheckmain=(QuickCheckMain) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), QuickCheckMain.class);
        		//quickcheckmain.setCreated_time_t(new Date()); 
        		update(quickcheckmain);
        	}
        }
    
    }
    
    public List<Map<String, Object>> searchById(String id) {
        SQLQuery query = getSession().createSQLQuery(getSQL("byId"));
        query.setParameter("id", id);
        query.setResultTransformer((ResultTransformer)Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
      }
    
    
    
    
    
      
      public List<Map<String, Object>> lbwd(String[] args) {
        SQLQuery query = createSQLQuery(getSQL("lbwd"));
        String lot_no = "";
        for (int i = 0; i < args.length; i++) {
          lot_no = lot_no + args[i] + ",";
        }
        
        lot_no = lot_no.substring(0, lot_no.length() - 1);
        query.setParameterList("lot_no", (Object[])lot_no.split(","));
        return query.list();
      }
    
    
    
    
    
      
      public List<Map<String, Object>> lbnj(String[] args) {
        SQLQuery query = createSQLQuery(getSQL("lbnj"));
        String lot_no = "";
        for (int i = 0; i < args.length; i++) {
          lot_no = lot_no + args[i] + ",";
        }
        lot_no = lot_no.substring(0, lot_no.length() - 1);
        query.setParameterList("lot_no", (Object[])lot_no.split(","));
        return query.list();
      }
    
    
    
    
    
    
      
      public List<Map<String, Object>> mnwd(String[] args) {
        SQLQuery query = createSQLQuery(getSQL("mnwd"));
        String lot_no = "";
        for (int i = 0; i < args.length; i++) {
          lot_no = lot_no + args[i] + ",";
        }
        
        lot_no = lot_no.substring(0, lot_no.length() - 1);
        query.setParameterList("lot_no", (Object[])lot_no.split(","));
        return query.list();
      }
    
    
    
    
    
      
      public List<Map<String, Object>> mnnj(String[] args) {
        SQLQuery query = createSQLQuery(getSQL("mnnj"));
        String lot_no = "";
        for (int i = 0; i < args.length; i++) {
          lot_no = lot_no + args[i] + ",";
        }
        lot_no = lot_no.substring(0, lot_no.length() - 1);
        query.setParameterList("lot_no", (Object[])lot_no.split(","));
        return query.list();
      }
    
    
    
    
    
    
      
      public List<Map<String, Object>> kjqx(String[] args, String type) {
        List<Map<String, Object>> newlist = null;
        List<Map<String, Object>> result = new ArrayList<>();
        int s = 0;
        if (type.equals("LBWD")) {
          newlist = lbwd(args);
        } else if (type.equals("LBNJ")) {
          newlist = lbnj(args);
        } else if (type.equals("MNWD")) {
          newlist = mnwd(args);
        } else {
          newlist = mnnj(args);
        } 
        String xmwd = "";
        String smwd = "";
        String ds = "";
        String syh = "";
        if (newlist != null) {
          for (int i = 0; i < newlist.size(); i++) {
            Map<String, Object> res = new HashMap<>();
            xmwd = ((Map)newlist.get(i)).get("SPARE3_S").toString();
            smwd = ((Map)newlist.get(i)).get("SPARE2_S").toString();
            ds = ((Map)newlist.get(i)).get("SPARE1_S").toString();
            syh = ((Map)newlist.get(i)).get("SAMPLENO_S").toString();
            if (i > 0) {
              res.put("smwd", smwd);
              res.put("xmwd", xmwd);
              res.put("ds", ds);
              res.put("syh", syh);
              System.out.println(res);
            } 
            
            result.add(res);
          } 
        }
        
        return result;
      }

}
