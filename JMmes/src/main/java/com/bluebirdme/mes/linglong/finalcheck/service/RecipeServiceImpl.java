/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.sap.entity.PlmDynamicBalance;
import com.bluebirdme.mes.linglong.sap.service.PlmDynamicBalanceServiceImpl;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import com.bluebirdme.mes.linglong.finalcheck.entity.Recipe;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeJudge;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeJudgeLog;
import com.bluebirdme.mes.linglong.finalcheck.entity.Sortltem;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.RecipeDTO;

import org.xdemo.app.xutils.j2se.ListUtils;



/**
 * 配方标准维护
 * @author 司乔靖
 * @Date 2018-08-01 10:00:25
 */
@Service
public class RecipeServiceImpl extends RockWellBaseServiceImpl<Recipe> {

    @Resource LingLongDataSource llds;
    // @Resource CoreDictionaryServiceImpl cddServiceImpl;
    @Resource RecipeItemServiceImpl recipeItemService;
    @Resource PlmDynamicBalanceServiceImpl plmDynamicBalanceServiceImpl;
    @Resource RecipeJudgeServiceImpl recipeJudgeServiceImpl;
    @Resource RecipeJudgeLogServiceImpl recipeJudgeLogServiceImpl;
    @Resource SortltemServiceImpl sortltemServiceImpl;
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Recipe.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
	@RockWellTransactional
    public String saveChanges(RecipeDTO recipe) throws Exception{
        
        if (!ListUtils.isEmpty(recipe.getDeleted())) {
        	 List<Recipe> recipeList = recipe.getDeleted();
        	 for(Recipe item:recipeList) {
        		List<RecipeItem> deletelist = recipeItemService.findByField("recipeid_i", item.getAtr_key().intValue());
        		if(deletelist.size()==0){
        			break;
        		}
        		for(RecipeItem list:deletelist){
        			List<Sortltem> sortltemList = sortltemServiceImpl.findByField("itemid_s", list.getItemid_s());
        			if(sortltemList.size()==0){
            			break;
            		}
        			sortltemServiceImpl.delete(sortltemList);
        		}
        		recipeItemService.delete(deletelist); 
        	 }
        	 delete(recipe.getDeleted());
        }
        if (!ListUtils.isEmpty(recipe.getInserted())) {
        	String factoryString=LLWebUtils.factory();
        	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
        	List<Recipe> recipeList = recipe.getInserted();
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	List<String> errormsg= new ArrayList<>();
        	//int maxCode=0;
        	for(Recipe item:recipeList)
        	{  
        		addString.add(item.getRecipeno_s());
    		    ruplicateList.add(item.getRecipeno_s());
        		//maxCode=getRecipeMaxNo(item.getEnttype_i().toString(),factoryString,factoryCodeString);
        		item.setCreated_by_s(LLWebUtils.getUser().userCode);
        		item.setCreated_time_t(new Date());
        		item.setRecord_flag_s("A");
        		item.setArch_flag_s("0");
        		item.setS_factory_s(factoryString);
        		item.setAgenc_no_s(factoryCodeString);
        		List<Map<String, Object>> list = searchBy254(item.getEnttype_i());
        		String DICTNAME_S = (String) list.get(0).get("DICTNAME_S");
        		/*根据 配方号 进行查重*/
    			if (duplicationCheck(item.getRecipeno_s(),item.getEnttype_i()) == true) //数据库内判重
    			{  
    				errormsg.add(DICTNAME_S+"设备类的"+item.getRecipeno_s()+"配方号在数据库内已存在，不允许新增！");
    				continue;
    			}
    			// 集合去重
            	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
            	// 去重之后的集合
            	if (addString.size() != 1) {
            		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
            	}
            	if (addString.size() != ruplicateList.size()) {
        			errormsg.add(DICTNAME_S+"设备类的"+item.getRecipeno_s()+"配方号在界面重复添加！");
            	}
        	}
        	if(errormsg.size()>0){
				return errormsg.get(0).toString();	
			}
			else{
				save(recipeList);
				return "操作成功";
			}
           
        }
        if (!ListUtils.isEmpty(recipe.getUpdated())) {
        	// 页面多行同时添加时的查重判断
        	List<String> addString = new ArrayList<>();
        	List ruplicateList = new ArrayList<>();
        	List<String> errormsg= new ArrayList<>();
        	List<Recipe> recipeList = recipe.getUpdated();
        	for(Recipe item:recipeList)
        	{   
        		addString.add(item.getRecipeno_s());
		        ruplicateList.add(item.getRecipeno_s());
        		item.setChanged_by_s(LLWebUtils.getUser().userCode);
        		item.setChanged_time_t(new Date());
        		List<Map<String, Object>> list = searchBy254(item.getEnttype_i());
        		String DICTNAME_S = (String) list.get(0).get("DICTNAME_S");
        		/*根据 配方号 进行查重*/
    			if (duplicationCheck(item.getRecipeno_s(),item.getEnttype_i()) == true) //数据库内判重
    			{  
    				errormsg.add(DICTNAME_S+"设备类的"+item.getRecipeno_s()+"配方号在数据库内已存在，不允许修改！");
    				continue;
    			}
    			// 集合去重
            	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
            	// 去重之后的集合
            	if (addString.size() != 1) {
            		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
            	}
            	if (addString.size() != ruplicateList.size()) {
        			errormsg.add(DICTNAME_S+"设备类的"+item.getRecipeno_s()+"配方号在界面重复修改！");
            	}
        	}
        	if(errormsg.size()>0){
				return errormsg.get(0).toString();	
			}
			else{
				update(recipeList);
				return "操作成功";
			}
           
        }
        return "操作成功";
    }
   /**	
	* 判重
	* 时永良-2019/03
	* 
	*/
	public boolean duplicationCheck(String recipeNo,String entType) throws Exception {
		Where where1 = new Where();  
		where1.andEqual("recipeno_s", recipeNo);
		where1.andEqual("enttype_i", entType);
		where1.andEqual("record_flag_s", "A");    
		where1.andEqual("s_factory_s", LLWebUtils.factory()); 
		List<Map<String, Object>> list = findMapByWhere(where1); //
		if (list.size() != 0) //数据库内判重
		{  
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 根据数据字典查出设备类所对应的的中文（254XXX为数据字典中代码号）
	 * 
	 * @return
	 */
	public List<Map<String, Object>> searchBy254(String code) {
		SQLQuery query = createSQLQuery(getSQL("searchBy254"));
		query.setParameter("dictcode_s",code);
		return query.list();
	}
    /**
     * 获取配方号最大值
     * @param enttype_i 设备类型
     * @param factory 工厂：全钢，半钢
     * @param factoryCode 机构编号
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public int getRecipeMaxNo(String enttype_i,String factory,String factoryCode) throws Exception
    {
    	Filter filter = new Filter();
    	filter.set("enttype_i", enttype_i);
    	filter.set("s_factory_s", factory);
    	filter.set("agenc_no_s", factoryCode);
    	SQLQuery query=createSQLQuery(getSQL("recipe_no_max",filter.getFilter()));
    	query.setParameter("enttype_i", enttype_i);
    	query.setParameter("s_factory_s", factory);
    	query.setParameter("agenc_no_s", factoryCode);
    	List<Map<String, Object>> list=query.list();
    	for(Map<String,Object> map :list){
    		for(String key:map.keySet()){
    			int result=  Integer.parseInt(map.get(key).toString());
			   return  result+1;
			}
    	}
    	return 0;
    }
    /**
     * 获取AT_D_BS_Recipe表ID
     * @param recipe
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Recipe> getRecipeID(Recipe recipe) throws Exception
    {
 	    String factoryString=LLWebUtils.factory();
     	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
 	   	Filter filter = new Filter();
 	   	filter.set("s_factory_s", factoryString);
 	   	filter.set("agenc_no_s",factoryCodeString );
 	   if(recipe.getRecipeno_s()!= null && !recipe.getRecipeno_s().isEmpty())
	   	{
	   		filter.set("recipeno_s", recipe.getRecipeno_s());
	   	}
	   	if(recipe.getEnttype_i()!= null && !recipe.getEnttype_i().toString().isEmpty())
	   	{
	   		filter.set("enttype_i", recipe.getEnttype_i());
	   	}
 	   	SQLQuery query=createSQLQuery(getSQL("getRecipeID",filter.getFilter()),Recipe.class);
 	   	query.setParameter("s_factory_s", filter.get("s_factory_s"));
     	query.setParameter("agenc_no_s",filter.get("agenc_no_s") );
     	query.setParameter("recipeno_s", filter.get("recipeno_s"));
     	query.setParameter("enttype_i", filter.get("enttype_i") );
 		return query.list();
    }
    /**
     * 获取第二个tab页的下拉框
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public List<Map<String,Object>> getRecipeno() throws Exception
    {
 	    String factoryString=LLWebUtils.factory();
     	String factoryCodeString =FactoryConstant.JING_MEN_CODE;
 	   	Filter filter = new Filter();
 	   	filter.set("s_factory_s", factoryString);
 	   	filter.set("agenc_no_s",factoryCodeString );
    	SQLQuery query=createSQLQuery(getSQL("comboxRecipeno",filter.getFilter()));
    	query.setParameter("s_factory_s", filter.get("s_factory_s"));
     	query.setParameter("agenc_no_s",filter.get("agenc_no_s") );
    	List<Map<String, Object>> list=query.list();
	    return list;
    }
    /**
     * 保存将PLM动平衡标准信息保存至配方表及另
     * @param recipeno
     * @param judgeID
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public Boolean saveJudgeIDToRecipe(String recipeno,String judgeID) throws Exception {
		//更新recipe表
		List<Recipe> updatelist= findByField("recipeno_s", recipeno);
		for(Recipe item : updatelist){
			item.setJudgeid_i(Integer.parseInt(judgeID));
		}
		update(updatelist);
		//根据plmDynamicBalance表数据更新at_d_bs_recipejudge表
	  
		PlmDynamicBalance plmDynamicBalance=plmDynamicBalanceServiceImpl.findById(Long.parseLong(judgeID));
	    
		Map<String, Object> searchValueMap=new HashMap<String, Object>();
		searchValueMap.put("recipeno_s", recipeno);
		searchValueMap.put("s_factory_s", LLWebUtils.factory());
	    List<RecipeJudge> exitRecipeJudge=recipeJudgeServiceImpl.findByMap(searchValueMap);
	    if(exitRecipeJudge.size()==0){
	    	RecipeJudge item= new RecipeJudge();
	  	    item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
	  	    item.setS_factory_s(LLWebUtils.factory());
	  	    item.setCreated_by_s(LLWebUtils.getUser().userName);
	  	    item.setCreated_time_t(new Date());
	  	    item.setRecord_flag_s("A");
	  	    item.setArch_flag_s("0");
	  	    
	  	    item.setRecipeno_s(recipeno);
	  	    item.setCheckno_s(judgeID);
	  	    item.setCategory_s(plmDynamicBalance.getCategory_s());
	  	    item.setSap_code_s(plmDynamicBalance.getSapcode_s());
	  	    item.setSpecification_s(plmDynamicBalance.getSpecification_s());
	  	    item.setAirpressure_s(plmDynamicBalance.getPressure_s());//气压
	  	    item.setGrade_s(plmDynamicBalance.getGrade_s());
	  	    item.setStaticbalance_s(plmDynamicBalance.getStaticbalance_s());
	  	    item.setRro_s(plmDynamicBalance.getRunout_s());//径向跳动
	  	    item.setLro_s(plmDynamicBalance.getLateralbeating_s());//侧向跳动
	  	    item.setOutsidediameter_s(plmDynamicBalance.getExternaldiameter_s());//轮胎外直径
	  	    item.setInsidediameter_s(plmDynamicBalance.getBeaddiameter_s());//轮胎直径
	  	    item.setWidthoftyresection_s(plmDynamicBalance.getSectionwidth_s());//轮胎断面宽度
	  	    item.setHierarchy_s(plmDynamicBalance.getHierarchy_s());
	  	    item.setDyn_1_plane_s(plmDynamicBalance.getUplow_s());//动平衡单边
	  	    item.setDyn_2_planes_s(plmDynamicBalance.getTotal_s());//动平衡双边  
	  	    item.setLt_bulging_s(plmDynamicBalance.getCamber_s());//上凸
	  	    item.setLb_bulging_s(plmDynamicBalance.getCamber_s());//下凸
	  	    item.setLb_dent_s(plmDynamicBalance.getCamber_s());//下凹
	  	    item.setLt_dent_s(plmDynamicBalance.getCamber_s());//上凹
	  	    item.setPattern_s(plmDynamicBalance.getPattern_s());
	  	    item.setPressure_s(plmDynamicBalance.getPressure_s());//气压
	  	    item.setLoad_s(plmDynamicBalance.getLoad_s());
	  	    item.setDescription_s(plmDynamicBalance.getDescription_s());
	  	    /* 
	  	    item.setTyrewidth_s();//轮胎宽度
	  	    item.setBeadwidth_s();//轮圈宽度
	  	    item.setPressure_s();//胎压
	  	    item.setTolerance_positive_s();//胎压正公差
	  	    item.setTolerance_minus_s();//胎压负公差
	  	    item.setMarkingradius_1_s();//打标半径1
	  	    item.setMarkingradius_2_s();//打标半径2
	  	    item.setMarkingradius_3_s();//打标半径3
	  	    item.setMarkingradius_4_s();//打标半径4
	  	    item.setMarkingradius_5_s();//打标半径5*/
	  	    item.setMax_diameter_s(plmDynamicBalance.getMaxoutsidediameter_s());//最大外径
	  	    item.setMin_diameter_s(plmDynamicBalance.getMinimumoutsidediameter_s());//最小外径
	  	    item.setRfv_s(plmDynamicBalance.getRfv_s());
	  	    item.setRih_s(plmDynamicBalance.getRih_s());
	  	    item.setLfv_s(plmDynamicBalance.getLfv_s());
	  	    item.setCon_s(plmDynamicBalance.getCon_s());
	  	    item.setComment_s(plmDynamicBalance.getComment_s());
	  	    recipeJudgeServiceImpl.save(item);
	    }
	    else{
	    	 for(RecipeJudge item:exitRecipeJudge){
	 	  	    item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
		  	    item.setS_factory_s(LLWebUtils.factory());
		  	    item.setCreated_by_s(LLWebUtils.getUser().userName);
		  	    item.setCreated_time_t(new Date());
		  	    item.setRecord_flag_s("A");
		  	    item.setArch_flag_s("0");
		  	    
		  	    item.setRecipeno_s(recipeno);
		  	    item.setCheckno_s(judgeID);
		  	    item.setCategory_s(plmDynamicBalance.getCategory_s());
		  	    item.setSap_code_s(plmDynamicBalance.getSapcode_s());
		  	    item.setSpecification_s(plmDynamicBalance.getSpecification_s());
		  	    item.setAirpressure_s(plmDynamicBalance.getPressure_s());//气压
		  	    item.setGrade_s(plmDynamicBalance.getGrade_s());
		  	    item.setStaticbalance_s(plmDynamicBalance.getStaticbalance_s());
		  	    item.setRro_s(plmDynamicBalance.getRunout_s());//径向跳动
		  	    item.setLro_s(plmDynamicBalance.getLateralbeating_s());//侧向跳动
		  	    item.setOutsidediameter_s(plmDynamicBalance.getExternaldiameter_s());//轮胎外直径
		  	    item.setInsidediameter_s(plmDynamicBalance.getBeaddiameter_s());//轮胎直径
		  	    item.setWidthoftyresection_s(plmDynamicBalance.getSectionwidth_s());//轮胎断面宽度
		  	    item.setHierarchy_s(plmDynamicBalance.getHierarchy_s());
		  	    item.setDyn_1_plane_s(plmDynamicBalance.getUplow_s());//动平衡单边
		  	    item.setDyn_2_planes_s(plmDynamicBalance.getTotal_s());//动平衡双边  
		  	    item.setLt_bulging_s(plmDynamicBalance.getCamber_s());//上凸
		  	    item.setLb_bulging_s(plmDynamicBalance.getCamber_s());//下凸
		  	    item.setLb_dent_s(plmDynamicBalance.getCamber_s());//下凹
		  	    item.setLt_dent_s(plmDynamicBalance.getCamber_s());//上凹
		  	    item.setPattern_s(plmDynamicBalance.getPattern_s());
		  	    item.setPressure_s(plmDynamicBalance.getPressure_s());//气压
		  	    item.setLoad_s(plmDynamicBalance.getLoad_s());
		  	    item.setDescription_s(plmDynamicBalance.getDescription_s());
		  	    /* 
		  	    item.setTyrewidth_s();//轮胎宽度
		  	    item.setBeadwidth_s();//轮圈宽度
		  	    item.setPressure_s();//胎压
		  	    item.setTolerance_positive_s();//胎压正公差
		  	    item.setTolerance_minus_s();//胎压负公差
		  	    item.setMarkingradius_1_s();//打标半径1
		  	    item.setMarkingradius_2_s();//打标半径2
		  	    item.setMarkingradius_3_s();//打标半径3
		  	    item.setMarkingradius_4_s();//打标半径4
		  	    item.setMarkingradius_5_s();//打标半径5*/
		  	    item.setMax_diameter_s(plmDynamicBalance.getMaxoutsidediameter_s());//最大外径
		  	    item.setMin_diameter_s(plmDynamicBalance.getMinimumoutsidediameter_s());//最小外径
		  	    item.setRfv_s(plmDynamicBalance.getRfv_s());
		  	    item.setRih_s(plmDynamicBalance.getRih_s());
		  	    item.setLfv_s(plmDynamicBalance.getLfv_s());
		  	    item.setCon_s(plmDynamicBalance.getCon_s());
		  	    item.setComment_s(plmDynamicBalance.getComment_s());
		  	    recipeJudgeServiceImpl.update(item);
	    	 }    
	    }
	    wrireRecipejudgeLog(recipeno,judgeID,plmDynamicBalance);
	    return true;
	}
	/**
	 * 保存履历至recipeitem表
	 * @param recipeno
	 * @param judgeID
	 * @param plmDynamicBalance
	 * @throws Exception
	 */
	private void wrireRecipejudgeLog(String recipeno,String judgeID,PlmDynamicBalance plmDynamicBalance) throws Exception {
		RecipeJudgeLog item= new RecipeJudgeLog();
  	    item.setAgenc_no_s(FactoryConstant.JING_MEN_CODE);
  	    item.setS_factory_s(LLWebUtils.factory());
  	    item.setCreated_by_s(LLWebUtils.getUser().userName);
  	    item.setCreated_time_t(new Date());
  	    item.setRecord_flag_s("A");
  	    item.setArch_flag_s("0");
  	    
  	    item.setRecipeno_s(recipeno);
  	    item.setCheckno_s(judgeID);
  	    item.setCategory_s(plmDynamicBalance.getCategory_s());
  	    item.setSap_code_s(plmDynamicBalance.getSapcode_s());
  	    item.setSpecification_s(plmDynamicBalance.getSpecification_s());
  	    item.setAirpressure_s(plmDynamicBalance.getPressure_s());//气压
  	    item.setGrade_s(plmDynamicBalance.getGrade_s());
  	    item.setStaticbalance_s(plmDynamicBalance.getStaticbalance_s());
  	    item.setRro_s(plmDynamicBalance.getRunout_s());//径向跳动
  	    item.setLro_s(plmDynamicBalance.getLateralbeating_s());//侧向跳动
  	    item.setOutsidediameter_s(plmDynamicBalance.getExternaldiameter_s());//轮胎外直径
  	    item.setInsidediameter_s(plmDynamicBalance.getBeaddiameter_s());//轮胎直径
  	    item.setWidthoftyresection_s(plmDynamicBalance.getSectionwidth_s());//轮胎断面宽度
  	    item.setHierarchy_s(plmDynamicBalance.getHierarchy_s());
  	    item.setDyn_1_plane_s(plmDynamicBalance.getUplow_s());//动平衡单边
  	    item.setDyn_2_planes_s(plmDynamicBalance.getTotal_s());//动平衡双边  
  	    item.setLt_bulging_s(plmDynamicBalance.getCamber_s());//上凸
  	    item.setLb_bulging_s(plmDynamicBalance.getCamber_s());//下凸
  	    item.setLb_dent_s(plmDynamicBalance.getCamber_s());//下凹
  	    item.setLt_dent_s(plmDynamicBalance.getCamber_s());//上凹
  	    item.setPattern_s(plmDynamicBalance.getPattern_s());
  	    item.setPressure_s(plmDynamicBalance.getPressure_s());//气压
  	    item.setLoad_s(plmDynamicBalance.getLoad_s());
  	    item.setDescription_s(plmDynamicBalance.getDescription_s());
  	    /* 
  	    item.setTyrewidth_s();//轮胎宽度
  	    item.setBeadwidth_s();//轮圈宽度
  	    item.setPressure_s();//胎压
  	    item.setTolerance_positive_s();//胎压正公差
  	    item.setTolerance_minus_s();//胎压负公差
  	    item.setMarkingradius_1_s();//打标半径1
  	    item.setMarkingradius_2_s();//打标半径2
  	    item.setMarkingradius_3_s();//打标半径3
  	    item.setMarkingradius_4_s();//打标半径4
  	    item.setMarkingradius_5_s();//打标半径5*/
  	    item.setMax_diameter_s(plmDynamicBalance.getMaxoutsidediameter_s());//最大外径
  	    item.setMin_diameter_s(plmDynamicBalance.getMinimumoutsidediameter_s());//最小外径
  	    item.setRfv_s(plmDynamicBalance.getRfv_s());
  	    item.setRih_s(plmDynamicBalance.getRih_s());
  	    item.setLfv_s(plmDynamicBalance.getLfv_s());
  	    item.setCon_s(plmDynamicBalance.getCon_s());
  	    item.setComment_s(plmDynamicBalance.getComment_s());
  	    recipeJudgeLogServiceImpl.save(item);
	}

	    
	    @SuppressWarnings({ "unchecked" })
		public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz)
				throws Exception {

			if (getSQL("datagrid_rows2") == null)
				throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows2的SQL语句定义");

			String dataSql = getSQL("datagrid_rows2", filter.getFilter());

			SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity()
					: clazz);

			setParameter(query, filter);

			if (page.getAll() == 0) {
				query.setMaxResults(page.getRows());
				query.setFirstResult((page.getPage() - 1) * page.getRows());
			}

			return query.list();
		}
	    
	    @SuppressWarnings("unchecked")
	    public List<Map<String,Object>> getPFCodeName() throws Exception
	    {
	    	SQLQuery query=createSQLQuery(getSQL("PFCodeName"));
	    	List<Map<String, Object>> list=query.list();
			return list;
	    }
	    
	    /**
		 * 通过设备类型、配方号，查询显示规格
		 * 
		 * @Title: getRecipeItems
		 * @Description: TODO(2019-09-21 lp修改)
		 * @return: List<Map<String,Object>> 返回类型
		 * 
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String, Object>> getRecipeItems(String enttype_s, String recipeNumber) throws Exception {
			String factoryString = LLWebUtils.factory();
			String agenc_no_sString = FactoryConstant.JING_MEN_CODE;
			SQLQuery query = createSQLQuery(getSQL("getRecipeItems"));
			query.setParameter("s_factory_s", factoryString);
			query.setParameter("agenc_no_s", agenc_no_sString);
			query.setParameter("enttype_s", enttype_s);
			query.setParameter("recipeno_s", recipeNumber);
			List<String> QGParaLists=new ArrayList<>();
	    	List<String> BGParaLists=new ArrayList<>();
			if (factoryString.equals("1")) {
				QGParaLists.add("211001");
				QGParaLists.add("211003");
	    		query.setParameterList("matgrp_s", QGParaLists);
			}
			if (factoryString.equals("2")) {
				BGParaLists.add("221001");
				BGParaLists.add("221002");
	    		query.setParameterList("matgrp_s", BGParaLists);
			}
			List<Map<String, Object>> list = query.list();
			// 大写变小写转换后的list
			List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> orgMap : list) {
				Map<String, Object> map = new HashMap<>();
				map = TransformUpperCase.transformUpperCase(orgMap);
				returnlist.add(map);
			}
			return returnlist;
		}
}
