/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.common.service.SerialServiceImpl;
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
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.building.entity.RoleMethod;
import com.bluebirdme.mes.linglong.building.entity.TireCar;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * 成型胎胚车维护表
 * @author 时永良
 * @Date 2019-03-02 11:06:03
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TireCarServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource LingLongDataSource llds;
    @Resource SerialServiceImpl serialSrv;// 系统参数获取
    @Override
    protected Session getSession() {
        return llds.getSession();
    }
    @Override
    protected Class getEntity() {
        return TireCar.class;
    }
    @Override
    protected boolean useCache() {
        return false;
    }
    @RockWellTransactional
    public String saveChanges( RockWellEntityDTO rockWellEntityDTO) throws Exception{
    	String newAddTireShelfCode=null;
    	List<String> addString = new ArrayList<>();
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
			List<Map<String, Object>> TireCarList = rockWellEntityDTO.getInserted();
			List<Object> tireCars=new ArrayList<Object>();//保存对象
			List<String> result = new ArrayList<>();
			Integer loadNum=null;
			for (int i = 0; i < TireCarList.size(); i++) {
				TireCar item = (TireCar)MapTrunPojo.mapToEntity(TireCarList.get(i), getEntity());
				item.setCreated_by_s(LLWebUtils.getUser().userCode);   //自动添加创建人
				item.setCreated_time_t(new Date());                  //自动添加创建时间
				item.setRecord_flag_s("A"); 	                       //自动添加Record
				item.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
				item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);   //自动添加机构代码-8023
				newAddTireShelfCode=item.getTire_shelf_code_s(); 	   //获取输入的胎胚车编号
				if(newAddTireShelfCode.length()!=7){
					result.add(newAddTireShelfCode+"胎胚车编码必须为七位");
					continue;
				}
				String test=newAddTireShelfCode.substring(0,3);
				String testString="HBG";
				if(!test.equals(testString)){
					result.add(newAddTireShelfCode+"胎胚车编码不符合校验规则");
					continue;
				}
				/*根据 胎胚车编码 进行查重*/
				if (duplicationCheck(newAddTireShelfCode) == true) //数据库内判重
				{  
					result.add(newAddTireShelfCode+"胎胚车编码数据库内已存在");
					continue;
				}
				if(addString.contains(newAddTireShelfCode)) //界面新增行判重
				{
					result.add(newAddTireShelfCode+"胎胚车编码重复添加");
					continue;
				}else{
					addString.add(newAddTireShelfCode); //
					tireCars.add(item);
				}
			}
			if(result.size()>0){
				return result.toString();	
			}
			else{
				save(tireCars);
				return "操作成功";
			}
		 }
        //删除行
        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
        	List<Map<String, Object>> tirecarList = rockWellEntityDTO.getDeleted();
        	List<Object> tireCars=new ArrayList<Object>();//保存对象
			for (int i = 0; i < tirecarList.size(); i++) {
				TireCar item = (TireCar)MapTrunPojo.mapToEntity(tirecarList.get(i), getEntity());
				item.setRecord_flag_s("D");
				// 自动添加删除操作的时间
				item.setChanged_time_t(new Date());
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				tireCars.add(item);
			}
			update(tireCars);
			return "操作成功";
        }
        //修改行
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
			List<Map<String, Object>> TireCarList = rockWellEntityDTO.getUpdated();
			List<Object> tireCars=new ArrayList<Object>();//保存对象
			List<String> result = new ArrayList<>();
			for(Map<String, Object> newitem:TireCarList){
				TireCar item = (TireCar)MapTrunPojo.mapToEntity(newitem, getEntity());
				item.setChanged_by_s(LLWebUtils.getUser().userCode);
				item.setChanged_time_t(new Date());
				if(StringHelper.isNullOrEmpty(newAddTireShelfCode)){
					tireCars.add(item);
				}else{
					/*根据 胎胚车编码 进行查重*/
					if (duplicationCheck(newAddTireShelfCode) == true) //数据库内判重
					{  
						result.add(newAddTireShelfCode+"胎胚车编码数据库内已存在");
						continue;
					}
					if(addString.contains(newAddTireShelfCode)) //界面新增行判重
					{
						result.add(newAddTireShelfCode+"胎胚车编码重复添加");
						continue;
					}else{
						addString.add(newAddTireShelfCode); //
						tireCars.add(item);
					}
				}
            }
			update(tireCars);
            return "操作成功";
        }
       return "未进行任何操作";
 }

	/**
	 * 胎胚数据的查询
	 * 
	 * @return
	 */
	public List<String> searchByTireCarCode() {
		SQLQuery query = createSQLQuery(getSQL("TireCarCodeQuery"));
		return query.list();
	}
	

	/**
	 * 
	 * @Title:BatchAdd
	 * @Description: 通过输入初始胎胚条码及批量导入数量，按顺序批量添加胎胚条码
	 * @return: List<Map<String,Object>> 返回类型
	 * 
	 */
public String BatchAdd(Integer startCode,Integer loadNum,int batchNum) throws Exception {
   List<TireCar> tireCarBatchList = new ArrayList<>();
   List<String> batchAddResult = new ArrayList<>();
   String tireCarCode=null;
   if(startCode<0||startCode>9999){
	     return "超出编码范围0-9999！";
     }
   if(batchNum<=0){
		 return "批量数量不可为0！";
     }
   int i=1; 
   while(i<=batchNum){
	   if((startCode<10)==true){
		   tireCarCode=("HBG000"+startCode);
		   if(duplicationCheck(String.valueOf(tireCarCode))==true){
			     batchAddResult.add(tireCarCode+"条码数据库已存在,未添加该条码，其他条码添加成功");
				 startCode++;
				 i++;  
			     continue;
		    }else{
		        TireCar tireCar=new TireCar();
		        tireCar.setRecord_flag_s("A"); 	                       //自动添加Record
		        tireCar.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
		        tireCar.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);    //自动添加机构代码-8023
		        tireCar.setCreated_by_s(LLWebUtils.getUser().userCode);    //自动添加创建人
		        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
		        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
		        tireCar.setFull_loaded_number_i(loadNum);                //满载数量
		        tireCar.setTire_shelf_code_s(tireCarCode);
		        tireCarBatchList.add(tireCar);
			    }
		   
	   }
	   if((startCode>=10&&startCode<100)==true){
		   tireCarCode=("HBG00"+startCode);
		   if(duplicationCheck(String.valueOf(tireCarCode))==true){
			     batchAddResult.add(tireCarCode+"条码数据库已存在,未添加该条码，其他条码添加成功");
				 startCode++;
				 i++;  
			     continue;
		    }else{
		        TireCar tireCar=new TireCar();
		        tireCar.setRecord_flag_s("A"); 	                       //自动添加Record
		        tireCar.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
		        tireCar.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);    //自动添加机构代码-8023
		        tireCar.setCreated_by_s(LLWebUtils.getUser().userCode);    //自动添加创建人
		        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
		        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
		        tireCar.setFull_loaded_number_i(loadNum);                //满载数量
		        tireCar.setTire_shelf_code_s(tireCarCode);
		        tireCarBatchList.add(tireCar);
			    }
		   
	   }
	   if((startCode>=100&&startCode<1000)==true){
		   tireCarCode=("HBG0"+startCode);
		   if(duplicationCheck(String.valueOf(tireCarCode))==true){
			     batchAddResult.add(tireCarCode+"条码数据库已存在,未添加该条码，其他条码添加成功");
				 startCode++;
				 i++;  
			     continue;
		    }else{
		        TireCar tireCar=new TireCar();
		        tireCar.setRecord_flag_s("A"); 	                       //自动添加Record
		        tireCar.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
		        tireCar.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);    //自动添加机构代码-8023
		        tireCar.setCreated_by_s(LLWebUtils.getUser().userCode);    //自动添加创建人
		        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
		        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
		        tireCar.setFull_loaded_number_i(loadNum);                //满载数量
		        tireCar.setTire_shelf_code_s(tireCarCode);
		        tireCarBatchList.add(tireCar);
			    }
				   
			   }
			   if((startCode>=1000&&startCode<10000)==true){
				   tireCarCode=("HBG"+startCode); 
				   if(duplicationCheck(String.valueOf(tireCarCode))==true){
					     batchAddResult.add(tireCarCode+"条码数据库已存在,未添加该条码，其他条码添加成功");
						 startCode++;
						 i++;  
					     continue;
					        	      //return "新增条码数据库已存在";
				    }else{
				        TireCar tireCar=new TireCar();
				        tireCar.setRecord_flag_s("A"); 	                       //自动添加Record
				        tireCar.setS_factory_s(LLWebUtils.factory()); 	       //自动添加工厂代码-1全钢 2半钢
				        tireCar.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);    //自动添加机构代码-8023
				        tireCar.setCreated_by_s(LLWebUtils.getUser().userCode);    //自动添加创建人
				        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
				        tireCar.setCreated_time_t(new Date());                   //自动添加创建时间
				        tireCar.setFull_loaded_number_i(loadNum);                //满载数量
				        tireCar.setTire_shelf_code_s(tireCarCode);
				        tireCarBatchList.add(tireCar);
					    }
				   
			   }
			   startCode++;
			   i++;   
		   }
		   RockWellUtils.save(tireCarBatchList);
		   if (batchAddResult.size()!=0){
			    return batchAddResult.toString();
		   }
		   return "批量导入条码成功";
		}
		
		   /*
		    * 根据胎胚车的数据字典代码查代码值 
		    */
		    public Integer searchCode(String dictCode){
		    	SQLQuery query = getSession().createSQLQuery(getSQL("searchCode"));
		    	query.setParameter("dictCode", dictCode);
				return Integer.parseInt((String)query.uniqueResult());
				
		    }
			  /**	
			* 判重
			* 兰颖慧-2019/03
			* 
			*/
			public boolean duplicationCheck(String newAdd) throws Exception {
				Where where1 = new Where();  
				where1.andEqual("tire_shelf_code_s", newAdd);
				where1.andEqual("record_flag_s", "A");     
				List<Map<String, Object>> list = findMapByWhere(where1); //
				if (list.size() != 0) //数据库内判重
				{  
					return true;
				}
				else{
					return false;
				}
			}
}
