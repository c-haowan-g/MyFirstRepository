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
import com.bluebirdme.mes.linglong.mix.entity.Drprod;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
//import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSImplementService;
//import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSInterface;


import java.util.Date;
/**
 * 密炼胶料产出实绩表
 * @author 栾和源
 * @Date 2020-08-04 09:34:26
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DrprodServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return Drprod.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    private String buildcommonMsg(Integer type,String msg) {
		String color="";
		if(type.equals(0)){
			color="<font color=ff0000>";//错误
		}else if(type.equals(1)){
			color="<font color=000000>";//正确
		}else if(type.equals(2)){
			color="<font color=f7df09>";//警告
		}
		return color+msg+"<br>";
	}
    
    /**
     * 重新下发       没有接口，先将方法注释
     * @param ids
     * @return
     * @throws Exception
     */
    public String downward(Long[] ids) throws Exception{
    	try {
    		/*List<Drprod> list=findByIds(ids);//查出要下发的计划
    		MESWSImplementService wsexinterface = new MESWSImplementService();
    		MESWSInterface portType = wsexinterface.getMESWSImplementPort();
    		StringBuffer errorBuffer=new StringBuffer();
    		StringBuffer resultBuffer=new StringBuffer();
        	for(Drprod item:list){
        		String result=portType.recivePolyProdByMES(null, null, item.getLot_no_s(), LLWebUtils.getUser().userCode, LLWebUtils.getUser().userName);
        		if(result=="OK"){
            	    resultBuffer.append(buildcommonMsg(1, "机台："+item.getEquip_code_s()+" "+"计划："+item.getLot_no_s()+result));
        		}else{
        			errorBuffer.append(buildcommonMsg(0, "机台："+item.getEquip_code_s()+" "+"计划："+item.getLot_no_s()+result));
        		}
        	}
        	return resultBuffer.toString()+"<br>"+errorBuffer.toString();*/
        	return "";
		} catch (Exception e) {
			return e.getMessage();
		}
    }

}