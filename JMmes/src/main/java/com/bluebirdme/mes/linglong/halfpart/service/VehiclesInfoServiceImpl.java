/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.VehiclesInfo;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

import java.util.Date;
/**
 * 半部件工装载具信息
 * @author 栾和源
 * @Date 2020-03-03 15:56:00
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class VehiclesInfoServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return VehiclesInfo.class;
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
        		VehiclesInfo vehiclesinfo=(VehiclesInfo) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), VehiclesInfo.class);
        		//vehiclesinfo.setCreated_time_t(new Date()); 
        		vehiclesinfo.setRecord_flag_s("D");
        		list.add(vehiclesinfo);
        	}
        	update(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
        	List list = new ArrayList<>();
        	for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
        	    //将MAP转换为实体
        		VehiclesInfo vehiclesinfo =(VehiclesInfo) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), VehiclesInfo.class);
        		//vehiclesinfo.setCreated_time_t(new Date()); 
        		vehiclesinfo.setCreated_by_s(LLWebUtils.getUserName());
        		vehiclesinfo.setS_factory_s(LLWebUtils.factory());
        		vehiclesinfo.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
        		vehiclesinfo.setRecord_flag_s("A");
        		vehiclesinfo.setCreated_time_t(new Date());
        		vehiclesinfo.setChanged_by_s(LLWebUtils.getUserName());
        		vehiclesinfo.setChanged_time_t(new Date());
        		list.add(vehiclesinfo);
        	}
        	save(list);
        }
        /**
        *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
        */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
        	for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
        	    //将MAP转换为实体
        		VehiclesInfo vehiclesinfo=(VehiclesInfo) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), VehiclesInfo.class);
        		//vehiclesinfo.setCreated_time_t(new Date()); 
        		vehiclesinfo.setCreated_by_s(LLWebUtils.getUserName());
        		vehiclesinfo.setS_factory_s(LLWebUtils.factory());
        		vehiclesinfo.setChanged_by_s(LLWebUtils.getUserName());
        		vehiclesinfo.setChanged_time_t(new Date());
        		update(vehiclesinfo);
        	}
        }
    
    }


    /**
   	 * 查出载具类型和存放库位显示在JSP页面下拉列表处
   	 * 
   	 * @return
   	 */
   	public List<Map<String, Object>> searchDescription() {
   		SQLQuery query = createSQLQuery(getSQL("searchDescription"));
   		String s_factory_s=LLWebUtils.factory();
   		String AGENC_NO_S=FactoryConstant.JING_MEN_CODE;
   		//query.setParameter("area_name",AGENC_NO_S+s_factory_s+"B");
   		query.setParameter("s_factory_s",s_factory_s);
   		query.setParameter("agenc_no_s",AGENC_NO_S);
   		System.out.println(getSQL("searchDescription").toString());
   		return query.list();
   	}
   	
   	
   	
   	
   	/**
     * 从基础数据表(at_cm_bs_coredictionary)表中查询功能名称和功能代码
     * 
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String> searchMethodName(){
    	SQLQuery methodNameQuery=createSQLQuery(getSQL("searchMethodName"));
    	return methodNameQuery.list();
    } 

   	/**
     * 从库位设置表(storage_unit)表中查询库存地址
     * 
     * @return
     */
	@SuppressWarnings("unchecked")
	public List<String> searchLocation(){
    	SQLQuery methodNameQuery=createSQLQuery(getSQL("location"));
    	return methodNameQuery.list();
    } 
   	

	/**
	 * 载具条码重复性校验
	 * 
	 * @return
	 */
	public int checkVehiclesBarcode(String vehiclesBarcode,String atrkey) {
		SQLQuery query = createSQLQuery(getSQL("vehiclesBarcodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		query.setParameter("vehicles_barcode_s", vehiclesBarcode);
		int atrkey2;
		if(!(atrkey.equals(""))){
			atrkey2=Integer.parseInt(atrkey);
		}else{
			atrkey2=0;
		}
		query.setParameter("atr_key", atrkey2);
		List arr = query.list();
		if(arr.size()==0){
			return 1;
		}
		return 0;
	}
	
   	/**
	 * 批量添加条码
	 * @param vehiclesType
	 * @param startCode
	 * @param endCode
	 * @param capacity
	 * @param printflag
	 * @return
	 * @throws Exception
	 * @author 栾和源
	 * @date 2020年3月9日
	 */
	public String BatchAdd(String vehicles_type_z,String vehicles_type_c,String startCode,String endCode,String capacity,String printflag,String myIndexA,String myIndexB) throws Exception {
		
		StringBuffer batchAddResult = new StringBuffer();
		
		SQLQuery query = createSQLQuery(getSQL("betweenBarcodeQuery"));
		query.setParameter("s_factory_s", LLWebUtils.factory());
		if("1".equals(LLWebUtils.factory())){
			query.setParameter("startCode", myIndexA+startCode);
			query.setParameter("endCode", myIndexB+endCode);
		}else if("2".equals(LLWebUtils.factory())){
			query.setParameter("startCode", myIndexA+startCode);
			query.setParameter("endCode", myIndexB+endCode);
		}
		
		List<Map> arr = query.list();
		if (arr.size()>0) {
			for(int i=0;i<arr.size();i++){
				batchAddResult.append(arr.get(i).get("VEHICLES_BARCODE_S"));
				if(i!=(arr.size()-1)){
					batchAddResult.append(",");
				}
			}
			batchAddResult.append("载具条码已存在，批量 添加失败");
			return batchAddResult.toString();
		}
		List<Object> vehiclesInfoList = new ArrayList<>();
		for (int i=Integer.parseInt(startCode);i<=Integer.parseInt(endCode);i++) {
			
			VehiclesInfo vehiclesInfo = new VehiclesInfo();
			//手动添加字段
			//不够位数自动补零
			if("1".equals(LLWebUtils.factory())){
				if(myIndexA.equals("FAG")){
					DecimalFormat df=new DecimalFormat("0000");
					String result=df.format(i);
					vehiclesInfo.setVehicles_barcode_s(myIndexA+result);
				}
				if(myIndexA.equals("GAG")){
					DecimalFormat df=new DecimalFormat("00000");
					String result=df.format(i);
					vehiclesInfo.setVehicles_barcode_s(myIndexA+result);
				}
			}else if("2".equals(LLWebUtils.factory())){
				if(myIndexA.equals("FAG")){
					DecimalFormat df=new DecimalFormat("0000");
					String result=df.format(i);
					vehiclesInfo.setVehicles_barcode_s(myIndexA+result);
				}
				if(myIndexA.equals("GAG")){
					DecimalFormat df=new DecimalFormat("00000");
					String result=df.format(i);
					vehiclesInfo.setVehicles_barcode_s(myIndexA+result);
				}
			}
			
			
			vehiclesInfo.setCapacity_s(capacity);
			vehiclesInfo.setPrintflag_s(printflag);
			vehiclesInfo.setVehicles_type_s(vehicles_type_z);
			vehiclesInfo.setSpare1_s(vehicles_type_c); //备用字段:载具类型（从）
			//自动添加字段
			
			
			vehiclesInfo.setCreated_time_t(new Date()); // 自动添加创建时间
			vehiclesInfo.setChanged_time_t(new Date());
			vehiclesInfo.setRecord_flag_s("A"); // 自动添加Record
			vehiclesInfo.setS_factory_s(LLWebUtils.factory()); // 自动添加工厂代码-1全钢
																		// 2半钢
			vehiclesInfo.setAgenc_no_s(FactoryConstant.JING_MEN_CODE); // 自动添加机构代码-8003
			vehiclesInfo.setCreated_by_s(LLWebUtils.getUserName()); // 自动添加创建人
			vehiclesInfo.setChanged_by_s(LLWebUtils.getUserName());
			vehiclesInfoList.add(vehiclesInfo);
		}
		save(vehiclesInfoList);
		return "批量导入条码成功";
		
		
		
		
		
		/*String preString=vehiclesBarCode.substring(0,3);
		String lastString=vehiclesBarCode.substring(3,vehiclesBarCode.length());
		System.out.println(preString);
		System.out.println(lastString);
		Integer lastCode=Integer.valueOf(lastString);
	    List<Object> VehiclesInfoList = new ArrayList<>();
	    for(int i=0;i<batchNum;i++){
	    	String newCode=preString+(lastCode+i);
	    	VehiclesInfo vehiclesinfo=new VehiclesInfo();
	    	vehiclesinfo.setCreated_time_t(new Date());                  //自动添加创建时间
	    	vehiclesinfo.setChanged_time_t(new Date());
	    	vehiclesinfo.setRecord_flag_s("A"); 	                       //自动添加Record
	    	vehiclesinfo.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
	    	vehiclesinfo.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);   //自动添加机构代码-8023
	    	vehiclesinfo.setCreated_by_s(LLWebUtils.getUserName());   //自动添加创建人
	    	vehiclesinfo.setChanged_by_s(LLWebUtils.getUserName());
	    	vehiclesinfo.setVehicles_barcode_s(newCode);
	    	vehiclesinfo.setVehicles_type_s(vehiclesType);
	    	vehiclesinfo.setCapacity_s(capacity);
	    	vehiclesinfo.setPrintflag_s(printflag);
	    	VehiclesInfoList.add(vehiclesinfo);
	    }
	    save(VehiclesInfoList);
    
		return "批量导入条码成功";*/
	}
   	

}
