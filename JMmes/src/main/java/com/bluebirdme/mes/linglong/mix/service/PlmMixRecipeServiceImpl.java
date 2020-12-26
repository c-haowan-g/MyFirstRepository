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
import com.bluebirdme.mes.linglong.mix.entity.PlmMixRecipe;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;
import com.bluebirdme.mes.linglong.wsdl.plmserviceex.WSExInterface;
import com.bluebirdme.mes.linglong.wsdl.plmserviceex.WSImplementService;

import java.util.Date;
/**
 * PLM密炼配方集成表
 * @author 栾和源
 * @Date 2020-08-08 14:03:08
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class PlmMixRecipeServiceImpl extends  RockWellUDABaseServiceImpl<Object> {

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
        return PlmMixRecipe.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    /**
     * 审核与取消审核
     * @author heyuan_luan
     * @param recipecodelist
     * @param status
     * @return
     */
    public String audit(String[] recipecodelist, String status) {
        StringBuffer sb = new StringBuffer();
        String recipecode = "";
        int sucCount = 0;
        StringBuffer falseinfo = new StringBuffer();
        for (int i = 0; i < recipecodelist.length; i++) {
          recipecode = recipecodelist[i];
          WSImplementService wsexinterface = new WSImplementService();
          WSExInterface portType = wsexinterface.getWSImplementPort();
          String result = "False";
          result = portType.reciveMixRecipeCheckByMES(null, null, recipecode, status, (LLWebUtils.getUser()).userCode, (LLWebUtils.getUser()).userName);
          if (result.equals("OK")) {
            sucCount++;
          } else {
            falseinfo.append(recipecode + "操作失败，返回结果："+ result + "<br>");
          } 
        } 
        sb.append("合计："+ recipecodelist.length + "条，成功："+ sucCount + "条;失败："+ (recipecodelist.length - sucCount) + "条");
        sb.append("<br>");
        sb.append(falseinfo.toString());
        return sb.toString();
      }

    /**
     * 密炼配方下发
     * @author heyuan_luan
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    public String downward(String[] recipecodelist) throws Exception {
        StringBuffer sb = new StringBuffer();
        String recipecode = "";
        int sucCount = 0;
        StringBuffer falseinfo = new StringBuffer();
        for (int i = 0; i < recipecodelist.length; i++) {
          recipecode = recipecodelist[i];
          WSImplementService wsexinterface = new WSImplementService();
          WSExInterface portType = wsexinterface.getWSImplementPort();
          String result = "False";
          result = portType.reciveMixRecipeSendByMES(null, null, recipecode, (LLWebUtils.getUser()).userCode, (LLWebUtils.getUser()).userName);
          if (result.equals("OK")) {
            sucCount++;
          } else {
            falseinfo.append(recipecode + "下发失败，返回结果："+ result + "<br>");
          } 
        } 
        sb.append("合计："+ recipecodelist.length + "条，成功："+ sucCount + "条;失败："+ (recipecodelist.length - sucCount) + "条");
        sb.append("<br>");
        sb.append(falseinfo.toString());
        return sb.toString();
      }
    
    /**
     * 密炼配方重新下发
     * @param recipecodelist
     * @return
     * @throws Exception
     */
    public String reissue(String[] recipecodelist) throws Exception {
        StringBuffer sb = new StringBuffer();
        String recipecode = "";
        int sucCount = 0;
        StringBuffer falseinfo = new StringBuffer();
        for (int i = 0; i < recipecodelist.length; i++) {
          recipecode = recipecodelist[i];
          WSImplementService wsexinterface = new WSImplementService();
          WSExInterface portType = wsexinterface.getWSImplementPort();
          String result = "False";
          result = portType.reciveMixRecipeReSendByMES(null, null, recipecode, (LLWebUtils.getUser()).userCode, (LLWebUtils.getUser()).userName);
          if (result.equals("OK")) {
            sucCount++;
          } else {
            falseinfo.append(recipecode + "下发失败，返回结果："+ result + "<br>");
          } 
        } 
        sb.append("合计："+ recipecodelist.length + "条，成功："+ sucCount + "条;失败："+ (recipecodelist.length - sucCount) + "条");
        sb.append("<br>");
        sb.append(falseinfo.toString());
        return sb.toString();
      }
    
    
    /**
     * 待用和停用
     * @param recipecodelist
     * @param status
     * @return
     */
    public String startstoprecipe(String[] recipecodelist, String status) {
        StringBuffer sb = new StringBuffer();
        String recipecode = "";
        WSImplementService wsexinterface = new WSImplementService();
        WSExInterface portType = wsexinterface.getWSImplementPort();
        for (int i = 0; i < recipecodelist.length; i++) {
          recipecode = recipecodelist[i];
          //缺少接口，暂注释
          //sb.append(recipecode + "启停结果"+ portType.reciveMixRecipeWaitOrStopByMES(null, null, recipecode, status, (LLWebUtils.getUser()).userCode, (LLWebUtils.getUser()).userName) + "<br>");
        } 
        return sb.toString();
      }
    
}
