/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebird.common.StringHelper;
import com.bluebirdme.core.common.service.SerialServiceImpl;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.HalfPartCommon.Factory;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlan;
import com.bluebirdme.mes.linglong.halfpart.entity.ProductPlanExtend;
import com.bluebirdme.mes.linglong.halfpart.entity.dto.ProductPlanExtendDTO;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

/**
 * 半部件日计划
 *
 * @author 兰颖慧
 * @Date 2019-04-04 14:49:13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProductPlanServiceImpl extends RockWellBaseServiceImpl<ProductPlan> {

    @Resource
    LingLongDataSource llds;
    @Resource
    SerialServiceImpl serialSrv;// 系统参数获取

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return ProductPlan.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    @RockWellTransactional
    public String saveChanges(ProductPlanExtendDTO productplan) throws Exception {
        List<ProductPlanExtend> productPlanList = new ArrayList<>();
        List<ProductPlan> newProductPlanList = new ArrayList<>();
        ProductPlan mornPlan = new ProductPlan();
        ProductPlan noonPlan = new ProductPlan();
        ProductPlan evenPlan = new ProductPlan();
        String check_plan_sql;
        try {
            if (!ListUtils.isEmpty(productplan.getInserted())) {
                productPlanList = productplan.getInserted();
                for (ProductPlanExtend item : productPlanList) {
                    check_plan_sql = "select count(2) from AT_A_PM_PRODUCTPLAN where MATERIALCODE_S = '"
                            + item.getMaterialcode_s() + "' and PLANDATE_S = '"
                            + item.getPlandate_s() + "' and EQUIP_CODE_S = '" + item.getEquip_code_s() +
                            "' and AGENC_NO_S = '8023' and RECORD_FLAG_S = 'A' and STATUS_S <> '104006' and S_FACTORY_S = '"+LLWebUtils.factory()+"'";
                    BigDecimal result = (BigDecimal) getSession().createSQLQuery(check_plan_sql).uniqueResult();
                    if (result.intValue() != 0) {
                        throw new Exception("机台" + item.getEquip_code_s() + " 生产的物料编码 " + item.getMaterialcode_s() + "已存在 ");
                    }
                    item.setS_factory_s(LLWebUtils.factory());
                    item.setCreated_by_s(LLWebUtils.getUser().userName);
                    item.setChanged_by_s(LLWebUtils.getUser().userName);
                    item.setCreated_time_t(new Date());
                    item.setChanged_time_t(new Date());
                    item.setAgenc_no_s(LLConstant.JING_MEN_CODE);
                    item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
                    item.setBuildingrecord_s("0");
                    item.setPlanfinish_f("0");
                    item.setPlanquantity_f(0f);
                    //构造早班计划
                    mornPlan = clone(item, "morn");
                    newProductPlanList.add(mornPlan);
                    //构造中班计划
                    noonPlan = clone(item, "noon");
                    newProductPlanList.add(noonPlan);
                    //构造晚班计划
                    evenPlan = clone(item, "even");
                    newProductPlanList.add(evenPlan);

                }
                save(newProductPlanList);
            }

            if (!ListUtils.isEmpty(productplan.getDeleted())) {
                productPlanList = productplan.getDeleted();
                for (ProductPlanExtend item : productPlanList) {
                    item.setRecord_flag_s(LLConstant.Record_Flag.DELETED);
                    item.setChanged_by_s(LLWebUtils.getUser().userCode);
                    item.setChanged_time_t(new Date());
                    //构造早班计划
                    mornPlan = clone(item, "morn");
                    newProductPlanList.add(mornPlan);
                    //构造中班计划
                    noonPlan = clone(item, "noon");
                    newProductPlanList.add(noonPlan);
                    //构造晚班计划
                    evenPlan = clone(item, "even");
                    newProductPlanList.add(evenPlan);
                }
                update(newProductPlanList);
            }
            if (!ListUtils.isEmpty(productplan.getUpdated())) {
                productPlanList = productplan.getUpdated();
                for (ProductPlanExtend item : productPlanList) {
                    check_plan_sql = "select PLANNO_S from AT_A_PM_PRODUCTPLAN where MATERIALCODE_S = '"
                            + item.getMaterialcode_s() + "' and PLANDATE_S = '"
                            + item.getPlandate_s() + "' and EQUIP_CODE_S = '" + item.getEquip_code_s() +
                            "' and AGENC_NO_S = '8023' and RECORD_FLAG_S = 'A' and STATUS_S <> '104006' and S_FACTORY_S = '"+LLWebUtils.factory()+"'";
                    List<String> result = getSession().createSQLQuery(check_plan_sql).list();
                    boolean flag = false;
                    if (result.size() != 0) {
                        if (result.size() == 3) {
                            if (result.contains(item.getMorn_planno_s()) && result.contains(item.getNoon_planno_s()) && result.contains(item.getEven_planno_s())) {
                                flag = true;
                            } else {
                                throw new Exception("机台" + item.getEquip_code_s() + " 生产的物料编码 " + item.getMaterialcode_s() + "已存在 ");
                            }
                        }

                    }
                    item.setChanged_by_s(LLWebUtils.getUser().userName);
                    item.setChanged_time_t(new Date());
                    //构造早班计划
                    mornPlan = clone(item, "morn");
                    newProductPlanList.add(mornPlan);
                    //构造中班计划
                    noonPlan = clone(item, "noon");
                    newProductPlanList.add(noonPlan);
                    //构造晚班计划
                    evenPlan = clone(item, "even");
                    newProductPlanList.add(evenPlan);
                }
                update(newProductPlanList);
            }
        } catch (Exception e) {
            return e.getMessage();
        }
        return "操作成功";
    }

    public ProductPlan clone(ProductPlanExtend item, String classes) {
        ProductPlan newItem = new ProductPlan();
        newItem.setAtr_key(item.getAtr_key());
        newItem.setAtr_name(item.getAtr_name());
        newItem.setAgenc_no_s(item.getAgenc_no_s());
        newItem.setAtr_key(item.getAtr_key());
        newItem.setBuildingrecord_s(item.getBuildingrecord_s());
        newItem.setChanged_by_s(item.getChanged_by_s());
        newItem.setChanged_time_t(item.getChanged_time_t());
        newItem.setCreated_by_s(item.getCreated_by_s());
        newItem.setCreated_time_t(item.getCreated_time_t());
        newItem.setCustomerflag_s(item.getCustomerflag_s());
        newItem.setEquip_code_s(item.getEquip_code_s());
        newItem.setEquip_outport_s(item.getEquip_outport_s());
        newItem.setHandflag_s(item.getHandflag_s());
        newItem.setMaterialcode_s(item.getMaterialcode_s());
        newItem.setMaterialdesc_s(item.getMaterialdesc_s());
        newItem.setMaterialgroup_s(item.getMaterialgroup_s());
        newItem.setMaterialname_s(item.getMaterialname_s());
        newItem.setMemo_s(item.getMemo_s());
        newItem.setOverpercent_f(item.getOverpercent_f());
        newItem.setParaversion_s(item.getParaversion_s());
        newItem.setPlandate_s(item.getPlandate_s());
        newItem.setPlanfinishtime_t(item.getPlanfinishtime_t());
        newItem.setPlanfinish_f(item.getPlanfinish_f());
        if (classes == "morn") {
            newItem.setPlanno_s(item.getMorn_planno_s());
            newItem.setClasscode_s("118001");
            newItem.setPlanquantityconfirm_f(item.getMorn_planquantityconfirm_f());
            newItem.setPlan_order_i(item.getMorn_plan_order_i());
            if (!(item.atr_key == null)) {
                newItem.setAtr_key(Long.valueOf(item.getMorn_atr_key()));
                newItem.setAtr_name(item.getMorn_atr_name());
            }
        }
        if (classes == "noon") {
            newItem.setPlanno_s(item.getNoon_planno_s());
            newItem.setClasscode_s("118002");
            newItem.setPlanquantityconfirm_f(item.getNoon_planquantityconfirm_f());
            newItem.setPlan_order_i(item.getNoon_plan_order_i());
            if (!(item.atr_key == null)) {
                newItem.setAtr_key(Long.valueOf(item.getNoon_atr_key()));
                newItem.setAtr_name(item.getNoon_atr_name());
            }
        }
        if (classes == "even") {
            newItem.setPlanno_s(item.getEven_planno_s());
            newItem.setClasscode_s("118003");
            newItem.setPlanquantityconfirm_f(item.getEven_planquantityconfirm_f());
            newItem.setPlan_order_i(item.getEven_plan_order_i());
            if (!(item.atr_key == null)) {
                newItem.setAtr_key(Long.valueOf(item.getEven_atr_key()));
                newItem.setAtr_name(item.getEven_atr_name());
            }
        }
        newItem.setPlanquantity_f(item.getPlanquantity_f());
        newItem.setPlanstarttime_t(item.getPlanstarttime_t());
        newItem.setRecord_flag_s(item.getRecord_flag_s());
        newItem.setRepiceno_s(item.getRepiceno_s());
        newItem.setReviewer_s(item.getReviewer_s());
        newItem.setReviewtime_t(item.getReviewtime_t());
        newItem.setSapversion_s(item.getSapversion_s());
        newItem.setSpare10_s(item.getSpare10_s());
        newItem.setSpare1_s(item.getSpare1_s());
        newItem.setSpare2_s(item.getSpare2_s());
        newItem.setSpare3_s(item.getSpare3_s());
        newItem.setSpare4_s(item.getSpare4_s());
        newItem.setSpare5_s(item.getSpare5_s());
        newItem.setSpare6_s(item.getSpare6_s());
        newItem.setSpare7_s(item.getSpare7_s());
        newItem.setSpare8_s(item.getSpare8_s());
        newItem.setSpare9_s(item.getSpare9_s()); //物料名称(备用字段)
        newItem.setSpecification_s(item.getSpecification_s());
        newItem.setStatus_s(item.getStatus_s());
        newItem.setS_factory_s(item.getS_factory_s());
        newItem.setDevicecode_s(item.getDevicecode_s());
        newItem.setProductstage_s(item.getProductstage_s());
        newItem.setParameterid_s(item.getParameterid_s());
        return newItem;
    }

    public List<ProductPlan> getProductPlan(ProductPlanExtend item) throws Exception {
        List<ProductPlan> productPlanList = new ArrayList<>();
        ProductPlan mornPlan = new ProductPlan();
        ProductPlan noonPlan = new ProductPlan();
        ProductPlan evenPlan = new ProductPlan();
        //构造早班计划
        mornPlan = clone(item, "morn");
        productPlanList.add(mornPlan);
        //构造中班计划
        noonPlan = clone(item, "noon");
        productPlanList.add(noonPlan);
        //构造晚班计划
        evenPlan = clone(item, "even");
        return productPlanList;
    }

    /**
     * select equip_code_s from table AT_A_PM_ProductPlan (半部件日计划表中筛选机台号 )
     * 2019/04/15 Yinghui.Lan
     */
    public List<String> searchEquipmentCode() {
        SQLQuery equipmentCodeQuery = createSQLQuery(getSQL("searchEquipmentCode"));
        return equipmentCodeQuery.list();
    }

    /**
     * getDataByMaterialCode
     * 根据物料名称获取物料编码、工艺版本号、配方版本、 生产版本（SAP下发版本号） 2019/04/24
     * Yinghui.Lan
     */
    public List<String> getDataByMaterialName(String materialName) {
        SQLQuery getDataByMaterialNameQuery = createSQLQuery(getSQL("getMaterialCodeByMaterialName"));
        getDataByMaterialNameQuery.setParameter("materialName", materialName);
        return getDataByMaterialNameQuery.list();
    }

    /**
     * getDataByMaterialCode
     * 根据物料编码获取物料名称、（工艺版本号、配方版本、 生产版本（SAP下发版本号） 2019/07/05）
     * Yinghui.Lan
     */
    public List<String> getDataByMaterialCode(String materialCode) {
        SQLQuery getDataByMaterialCodeQuery = createSQLQuery(getSQL("getMaterialNameByMaterialCode"));
        getDataByMaterialCodeQuery.setParameter("materialCode", materialCode);
        return getDataByMaterialCodeQuery.list();
    }

    /**
     * getDataByMaterialCode
     * 跟物料编码校验生产版本、BOM物料存在性及是否BOM有效期
     * Yinghui.Lan
     *
     * @throws Exception
     */
    public List<String> getCheckedDataByMaterialCode(String materialCode, String productStage) throws Exception {
        SQLQuery getNameAndVersionsByMaterialCode = createSQLQuery(getSQL("getNameAndVersionsByMaterialCode"));
        //SQLQuery getNameAndVersionsByMaterialCode = getSession().createSQLQuery(getSQL("getNameAndVersionsByMaterialCode"));
        getNameAndVersionsByMaterialCode.setParameter("materialCode", materialCode);
        return getNameAndVersionsByMaterialCode.list();
    }

    public String checkDataByMaterialCode(String materialCode, String productStage) throws Exception {
        String productVersion = null;
        //根据物料编码-校验生产版本是否存在
        SQLQuery getProdVerByCode = getSession().createSQLQuery(getSQL("getProductVersionByMaterialCode"));
        getProdVerByCode.setParameter("materialCode", materialCode);
        if (getProdVerByCode.uniqueResult() == null) {
            return materialCode.concat("生产版本不存在");
        } else {
            productVersion = getProdVerByCode.uniqueResult().toString();
            //根据物料编码、产品阶段、生产版本-校验物料_bom是否存在
            if (bomExistCheck(materialCode, productStage, productVersion) == false) {
                return materialCode.concat("在BOM中不存在子物料");
            }
            //根据物料编码、产品阶段、生产版本及时间校验_Bom有效期
            if (bomValidCheck(materialCode, productStage, productVersion) == false) {
                return materialCode.concat("对应物料超过BOM有效期");
            }
        }
        //根据物料编码校验工艺版本和配方版本是否存在
        SQLQuery getProcAndForVerByCode = getSession().createSQLQuery(getSQL("getProcessAndFormulaVersionByMaterialCode"));
        getProcAndForVerByCode.setParameter("materialCode", materialCode);
        if (getProcAndForVerByCode.list().isEmpty() == true) {
            return materialCode.concat("对应的工艺版本和配方(Bom)版本不存在");
        }
        return "StandardData";
    }

    /**
     * 根据物料编码校验生产版本是否存在
     * 跟物料编码进行相关校验
     * Yinghui.Lan
     *
     * @throws Exception
     */
    public List<String> getProductVersion(String materialCode) throws Exception {
        //根据物料编码-校验生产版本是否存在
        SQLQuery getProdVerByCode = createSQLQuery(getSQL("getProductVersionByMaterialCode"));
        getProdVerByCode.setParameter("materialCode", materialCode);
        return getProdVerByCode.list();
    }

    /**
     * 根据物料编码校验BOM存在性和有效期 、以及工艺版本和配方版本是否存在
     * 跟物料编码进行相关校验
     * Yinghui.Lan
     *
     * @throws Exception
     */

    public String checkBomAndVersion(String materialCode, String productStage, String productVersion) throws Exception {
        //根据物料编码、产品阶段、生产版本-校验物料_Bom是否存在
		/*if(bomExistCheck(materialCode,productStage,productVersion)==false){
			return materialCode.concat("在BOM中不存在子物料");
		}
		//根据物料编码、产品阶段、生产版本及时间校验_Bom有效期
    	if(bomValidCheck(materialCode,productStage,productVersion)==false){
    		return materialCode.concat("对应物料超过BOM有效期");
		}*/
        //根据物料编码校验工艺版本和配方版本是否存在
		/*SQLQuery getProcAndForVerByCode = getSession().createSQLQuery(getSQL("getProcessAndFormulaVersionByMaterialCode"));
		getProcAndForVerByCode.setParameter("materialCode", materialCode);
	    if(getProcAndForVerByCode.list().isEmpty()==true){
	    	return materialCode.concat("对应的工艺版本和配方(Bom)版本不存在");
	    }*/


        return "StandardData";
    }


    /**
     * 根据查询栏设定的计划日期生成日计划号 兰颖慧
     * create daily-plan code according plan date
     * Yinghui.Lan 2019/04/15
     */
    public List<String> createPlanCode(String planData) {
        List<String> planCodeList = serialSrv.serial("AP0" + planData, 4, 3);
        return planCodeList;
    }

    /**
     * 根据查询栏设定的计划日期生成日计划号 兰颖慧
     * create daily-plan code according plan date
     * Yinghui.Lan 2019/04/15
     */
    public String createOnePlanCode(String planData) {
        String planCode = serialSrv.serial("AP0" + planData, 4, 1).get(0).toString();
        return planCode;
    }

    @SuppressWarnings("unchecked")
    public List<String> getMaxPlanOrder(String planData) throws Exception {
        SQLQuery planOrder = getSession().createSQLQuery(getSQL("getMaxPlanOrder"));
        if (LLWebUtils.factory().equals(Factory.FullSteel)) {
            planOrder.setParameter("factory", LLWebUtils.factory());
        }
        if (LLWebUtils.factory().equals(Factory.HalfSteel)) {
            planOrder.setParameter("factory", Factory.HalfSteel);
        }
        planOrder.setParameter("planData", planData);
        return planOrder.list();
    }

    /**
     * 根据物料组获得超产百分比 兰颖慧
     * get Over-Percent By Material-Group Yinghui.Lan
     * 2019/04/24
     */
    @SuppressWarnings("unchecked")
    public List<String> getOverPercentByMaterialGroup(String materialGroup) {
        SQLQuery overPercentQuery = createSQLQuery(getSQL("getOverPercentByMaterialGroup"));
        overPercentQuery.setParameter("materialGroup", materialGroup);
        return overPercentQuery.list();
    }

    /**
     * 半部件日计划审核
     * 兰颖慧
     * 2019/04/25
     */
    public void audit(Long[] ids) throws Exception {
        List<ProductPlan> planList = findByIds(ids);
        for (ProductPlan item : planList) {
            item.setStatus_s("104002");
            item.setChanged_by_s(LLWebUtils.getUser().userCode);
            item.setChanged_time_t(new Date());
        }
        update(planList);
    }

    /**
     * 半部件日计划一键审核
     * 兰颖慧
     * 2019/04/25
     */
    @SuppressWarnings("unchecked")
    public void oneClickAudit(String planDate) throws Exception {
        SQLQuery oneClickAuditQuery = createSQLQuery(getSQL("oneClickAudit"));
        oneClickAuditQuery.setParameter("planDate", planDate);
        oneClickAuditQuery.setParameter("status", "104001");
        oneClickAuditQuery.setParameter("factory", LLWebUtils.factory());
        List<Map<String, Object>> planIdList = oneClickAuditQuery.list();
        int listSize = planIdList.size();
        int pre = listSize / 1000;
        int remain = listSize % 1000;
        List<Long[]> ids = new ArrayList<>();

        for (int i = 0; i < pre; i++) {
            Long[] id1 = new Long[1000];
            for (int j = 0; j < 1000; j++) {
                id1[j] = Long.parseLong(planIdList.get(i * 1000 + j).get("ATR_KEY").toString());
            }
            ids.add(id1);
        }
        if (remain > 0) {
            Long[] id2 = new Long[remain];
            for (int i = 0; i < remain; i++) {
                id2[i] = Long.parseLong(planIdList.get(pre * 1000 + i).get("ATR_KEY").toString());
            }
            ids.add(id2);
        }
        List<List<ProductPlan>> list = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            list.add(findByIds(ids.get(i)));
        }
        for (int i = 0; i < list.size(); i++) {
            List<ProductPlan> planList = list.get(i);
            for (int j = 0; j < planList.size(); j++) {
                planList.get(j).setStatus_s("104002");
                planList.get(j).setChanged_by_s(LLWebUtils.getUser().userCode);
                planList.get(j).setChanged_time_t(new Date());
            }
            update(planList);
        }
    }

    /**
     * 半部件日计划一键取消审核
     * 兰颖慧
     * 2019/04/25
     */
    @SuppressWarnings("unchecked")
    public void oneClickCancelAudit(String planDate) throws Exception {
        SQLQuery oneClickAuditQuery = createSQLQuery(getSQL("oneClickCancelAudit"));
        oneClickAuditQuery.setParameter("planDate", planDate);
        oneClickAuditQuery.setParameter("status", "104002");
        oneClickAuditQuery.setParameter("factory", LLWebUtils.factory());
        List<Map<String, Object>> planIdList = oneClickAuditQuery.list();
        int listSize = planIdList.size();
        int pre = listSize / 1000;
        int remain = listSize % 1000;
        List<Long[]> ids = new ArrayList<>();

        for (int i = 0; i < pre; i++) {
            Long[] id1 = new Long[1000];
            for (int j = 0; j < 1000; j++) {
                id1[j] = Long.parseLong(planIdList.get(i * 1000 + j).get("ATR_KEY").toString());
            }
            ids.add(id1);
        }
        if (remain > 0) {
            Long[] id2 = new Long[remain];
            for (int i = 0; i < remain; i++) {
                id2[i] = Long.parseLong(planIdList.get(pre * 1000 + i).get("ATR_KEY").toString());
            }
            ids.add(id2);
        }
        List<List<ProductPlan>> list = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            list.add(findByIds(ids.get(i)));
        }
        for (int i = 0; i < list.size(); i++) {
            List<ProductPlan> planList = list.get(i);
            for (int j = 0; j < planList.size(); j++) {
                planList.get(j).setStatus_s("104001");
                planList.get(j).setChanged_by_s(LLWebUtils.getUser().userCode);
                planList.get(j).setChanged_time_t(new Date());
            }
            update(planList);
        }
    }

    /**
     * 半部件日计划一键复制
     * 兰颖慧
     * 2019/04/25
     */
    @SuppressWarnings("unchecked")
    public void oneClickCopy(String fromPlanDate, String toPlanDate) throws Exception {
        List<Map<String, Object>> existPlanList = reLoadCopyPlan(toPlanDate);
        if (existPlanList.size() > 0) {
            return;
        }
        SQLQuery oneClickCopyQuery = createSQLQuery(getSQL("oneClickCopy"));
        oneClickCopyQuery.setParameter("planDate", fromPlanDate);
        oneClickCopyQuery.setParameter("factory", LLWebUtils.factory());
        List<Map<String, Object>> copyPlanList = oneClickCopyQuery.list();
        List<ProductPlan> planList = new ArrayList<>();
        Map<String, Object> copyItem = new HashMap<>();
        for (int i = 0; i < copyPlanList.size(); i++) {
            ProductPlan item = new ProductPlan();
            copyItem = copyPlanList.get(i);
            item.setPlandate_s(toPlanDate);
            item.setStatus_s("104001");
            item.setPlandate_s(toPlanDate);
            item.setPlanno_s(createOnePlanCode(toPlanDate));
            item.setCreated_by_s(LLWebUtils.getUser().userCode);
            item.setCreated_time_t(new Date());
            item.setS_factory_s(LLWebUtils.factory());
            item.setAgenc_no_s(LLConstant.JING_MEN_CODE);
            item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
            if (!(copyItem.get("SPARE3_S") == null)) {
                item.setSpare3_s(copyItem.get("SPARE3_S").toString());
            }
            if (!(copyItem.get("BUILDINGRECORD_S") == null)) {
                item.setBuildingrecord_s(copyItem.get("BUILDINGRECORD_S").toString());
            }
            if (!(copyItem.get("PLANFINISH_F") == null)) {
                item.setPlanfinish_f(copyItem.get("PLANFINISH_F").toString());
            }
            if (!(copyItem.get("PLANQUANTITY_F") == null)) {
                item.setPlanquantity_f(Float.parseFloat(copyItem.get("PLANQUANTITY_F").toString()));
            }
            if (!(copyItem.get("EQUIP_CODE_S") == null)) {
                item.setEquip_code_s(copyItem.get("EQUIP_CODE_S").toString());
            }
            if (!(copyItem.get("SPARE1_S") == null)) {
                item.setSpare1_s(copyItem.get("SPARE1_S").toString());
            }
            if (!(copyItem.get("CLASSCODE_S") == null)) {
                item.setClasscode_s(copyItem.get("CLASSCODE_S").toString());
            }
            if (!(copyItem.get("SPECIFICATION_S") == null)) {
                item.setSpecification_s(copyItem.get("SPECIFICATION_S").toString());
            }
            if (!(copyItem.get("MATERIALCODE_S") == null)) {
                item.setMaterialcode_s(copyItem.get("MATERIALCODE_S").toString());
            }
            if (!(copyItem.get("MATERIALNAME_S") == null)) {
                item.setMaterialname_s(copyItem.get("MATERIALNAME_S").toString());
            }
            if (!(copyItem.get("MATERIALGROUP_S") == null)) {
                item.setMaterialgroup_s(copyItem.get("MATERIALGROUP_S").toString());
            }
            if (!(copyItem.get("MATERIALDESC_S") == null)) {
                item.setMaterialdesc_s(copyItem.get("MATERIALDESC_S").toString());
            }
            if (!(copyItem.get("PRODUCTSTAGE_S") == null)) {
                item.setProductstage_s(copyItem.get("PRODUCTSTAGE_S").toString());
            }
            if (!(copyItem.get("PLANQUANTITYCONFIRM_F") == null)) {
                item.setPlanquantityconfirm_f(Float.parseFloat(copyItem.get("PLANQUANTITYCONFIRM_F").toString()));
            }
            if (!(copyItem.get("PLAN_ORDER_I") == null)) {
                item.setPlan_order_i(Integer.parseInt(copyItem.get("PLAN_ORDER_I").toString()));
            }
            if (!(copyItem.get("SAPVERSION_S") == null)) {
                item.setSapversion_s(copyItem.get("SAPVERSION_S").toString());
            }
            if (!(copyItem.get("PARAVERSION_S") == null)) {
                item.setParaversion_s(copyItem.get("PARAVERSION_S").toString());
            }
            if (!(copyItem.get("PARAMETERID_S") == null)) {
                item.setParameterid_s(copyItem.get("PARAMETERID_S").toString());
            }
            item.setRepiceno_s(copyItem.get("REPICENO_S").toString());
            if (!(copyItem.get("CUSTOMERFLAG_S") == null)) {
                item.setCustomerflag_s(copyItem.get("CUSTOMERFLAG_S").toString());
            }
            if (!(copyItem.get("HANDFLAG_S") == null)) {
                item.setHandflag_s(copyItem.get("HANDFLAG_S").toString());
            }
            if (!(copyItem.get("OVERPERCENT_F") == null)) {
                item.setOverpercent_f(Float.parseFloat(copyItem.get("OVERPERCENT_F").toString()));
            }
            planList.add(item);
        }
        save(planList);
    }

    /**
     * 半部件日计划撤销审核 兰颖慧-2019/04/25
     */
    public void cancelAudit(Long[] ids) throws Exception {
        List<ProductPlan> planList = findByIds(ids);
        for (ProductPlan item : planList) {
            item.setStatus_s("104001");
            item.setChanged_by_s(LLWebUtils.getUser().userCode);
            item.setChanged_time_t(new Date());
        }
        update(planList);
    }

    /**
     * 半部件日计划撤销审核 兰颖慧-2019/08/21
     */
    public void planClose(Long[] ids) throws Exception {
        List<ProductPlan> planList = findByIds(ids);
        for (ProductPlan item : planList) {
            item.setStatus_s("104006");
            item.setChanged_by_s(LLWebUtils.getUser().userCode);
            item.setChanged_time_t(new Date());
        }
        update(planList);
    }

    /**
     * 半部件日计划优先级上移-未使用 兰颖慧-2019/04/25
     */
    public void upper(Long[] ids) throws Exception {
        List<ProductPlan> planList = findByIds(ids);
        for (ProductPlan item : planList) {
            Integer planOrder = item.getPlan_order_i();

            Integer ccc = getPlanOrder(planOrder).get(0);
            item.setPlan_order_i(ccc);
            item.setChanged_by_s(LLWebUtils.getUser().userCode);
            item.setChanged_time_t(new Date());
        }
        update(planList);
    }

    /**
     * 半部件日计划优先级下移-未使用 兰颖慧-2019/04/25
     */
    public void lower(Long[] ids) throws Exception {
        List<ProductPlan> planList = findByIds(ids);
        for (ProductPlan item : planList) {
            Integer planOrder = item.getPlan_order_i();
            item.setPlan_order_i(getPlanOrder(planOrder).get(0));
            item.setChanged_by_s(LLWebUtils.getUser().userCode);
            item.setChanged_time_t(new Date());
        }
        update(planList);
    }

    /**
     * 获得日计划序列 兰颖慧-2019/04/25
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Integer> getPlanOrder(Integer planOrder) throws Exception {
        SQLQuery planOrderQuery = getSession().createSQLQuery(
                getSQL("getPlanOrder"));
        planOrderQuery.setParameter("planOrder", planOrder);
        return planOrderQuery.list();
    }

    /**
     * 校验Bom子物料存在性
     * materialCode 物料编码
     * productStage 产品阶段
     */
    public boolean bomExistCheck(String materialCode, String productStage, String productVersion) throws Exception {
        SQLQuery bomExistCheck = getSession().createSQLQuery(getSQL("bomExistCheck"));
        bomExistCheck.setParameter("materialCode", materialCode);
        bomExistCheck.setParameter("productStage", productStage);
        bomExistCheck.setParameter("productVersion", productVersion);

        if (bomExistCheck.list().isEmpty() == true) {
            return false;
        }
        if (bomExistCheck.list().size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 验证Bom有效期 materialCode 物料编码 productStage 产品阶段 productVersion 生产版本
     */
    public boolean bomValidCheck(String materialCode, String productStage, String productVersion) throws Exception {
        SQLQuery bomValidCheck = getSession().createSQLQuery(getSQL("bomValidCheck"));
        bomValidCheck.setParameter("materialCode", materialCode);
        bomValidCheck.setParameter("productStage", productStage);
        bomValidCheck.setParameter("productVersion", productVersion);
        if (bomValidCheck.list().isEmpty() == true) {
            return false;
        }
        if (bomValidCheck.list().size() == 0) {
            return false;
        }
        return true;
    }

    /**
     * 根据日期，机台号和班次获取数据
     * 兰颖慧
     * 2019-05-21
     */
    public Map<String, Object> getSortingData(Page page, String planDate, String equipCode, String classCode) throws Exception {
        Map<String, Object> sortingDataMap = new HashMap<>();
        sortingDataMap.put("rows", getSortingDataRows(page, planDate, equipCode, classCode));
        sortingDataMap.put("total", getSortingDataTotal(page, planDate, equipCode, classCode));
        return sortingDataMap;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSortingDataRows(Page page, String planDate, String equipCode, String classCode) throws Exception {
        SQLQuery getSortingData = createSQLQuery(getSQL("getSortingDataRows"));
        getSortingData.setParameter("planDate", planDate);
        getSortingData.setParameter("equipCode", equipCode);
        getSortingData.setParameter("classCode", classCode);
        getSortingData.setParameter("factory", LLWebUtils.factory());
        if (page.getAll() == 0) {
            getSortingData.setMaxResults(page.getRows());
            getSortingData.setFirstResult((page.getPage() - 1) * page.getRows());
        }
        List<Map<String, Object>> res = getSortingData.list();
        List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < res.size(); i++) {
            list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
        }
        return list_new;
    }

    public Long getSortingDataTotal(Page page, String planDate, String equipCode, String classCode) throws Exception {
        Long total = 0L;
        if (page.getTotalRows() == 0L) {
            SQLQuery getSortingData = getSession().createSQLQuery(getSQL("getSortingDataTotal"));
            getSortingData.setParameter("planDate", planDate);
            getSortingData.setParameter("equipCode", equipCode);
            getSortingData.setParameter("classCode", classCode);
            getSortingData.setParameter("factory", LLWebUtils.factory());
            total = ((BigDecimal) getSortingData.uniqueResult()).longValue();
        } else {
            total = page.getTotalRows();
        }
        return total;
    }

    /**
     * 获取同一机台下的全部物料组
     * 兰颖慧
     * 2019-05-30
     */
    public List<Map<String, Object>> getAllMaterialGroupUnderZone(String zoneName) throws Exception {
        SQLQuery query = createSQLQuery(getSQL("getAllMaterialGroupUnderZone"));
        query.setParameter("zoneName", zoneName);
        List<Map<String, Object>> result = query.list();
        List<Map<String, Object>> newlist = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < result.size(); i++) {
            newlist.add(TransformUpperCase.transformUpperCase(result.get(i)));
        }
        return newlist;
    }

    public List<Map<String, Object>> getAllMaterialGroupWithoutZone() throws Exception {
        SQLQuery query = createSQLQuery(getSQL("getAllMaterialGroupWithoutZone"));
        List<Map<String, Object>> result = query.list();
        List<Map<String, Object>> newlist = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < result.size(); i++) {
            newlist.add(TransformUpperCase.transformUpperCase(result.get(i)));
        }
        return newlist;
    }

    /**
     * 根据查询栏设定的计划日期生成日计划号 兰颖慧
     * create daily-plan code according plan date
     * Yinghui.Lan 2019/04/15
     */
    public List<String> createPlanNoWhenCopy(String planData, int num) {
        List<String> planNoList = serialSrv.serial("AP0" + planData, 4, num);
        return planNoList;
    }

    /**
     * 复制后页面重新加载复制后的数据
     * 2019-06-10
     * 兰颖慧
     */
    public List<Map<String, Object>> reLoadCopyPlan(String newDate) {
        SQLQuery query = createSQLQuery(getSQL("reLoadCopyPlan"));
        query.setParameter("newDate", newDate);
        query.setParameter("factory", LLWebUtils.factory());
        List<Map<String, Object>> result = query.list();
        List<Map<String, Object>> newlist = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < result.size(); i++) {
            newlist.add(TransformUpperCase.transformUpperCase(result.get(i)));
        }
        return newlist;
    }

    /**
     * 根据物料编码获取物料描述、物料规格以及对应物料组编码
     * 兰颖慧
     * 2019-07-08
     */
    public List<Map<String, Object>> getMatInfoByMatCode(String materialCode) throws Exception {
        SQLQuery query = createSQLQuery(getSQL("getMatInfoByMatCode"));
        query.setParameter("materialCode", materialCode);
        
        List<Map<String, Object>> queryList = query.list();
        if(queryList.size() > 1){
        	for (int i = 0; i < queryList.size(); i++) {
        		Map<String, Object> map = queryList.get(i);
        		String subitemdesc_s = (String) map.get("SUBITEMDESC_S");
        		if(null != subitemdesc_s && subitemdesc_s != ""){
        			if(subitemdesc_s.indexOf("全钢带束层_4") != -1){
        				queryList.remove(i);
        			}
        		}
			}
        }
        return queryList;
    }

    /**
     * 根据物料描述获取物料编码、物料规格以及对应物料组编码
     * 兰颖慧
     * 2019-07-08
     */
    public List<Map<String, Object>> getMatInfoByMatDesc(String materialDesc) throws Exception {
        SQLQuery query = createSQLQuery(getSQL("getMatInfoByMatDesc"));
        query.setParameter("materialDesc", materialDesc);

        List<Map<String, Object>> queryList = query.list();
        if(queryList.size() > 1){
        	for (int i = 0; i < queryList.size(); i++) {
        		Map<String, Object> map = queryList.get(i);
        		String subitemdesc_s = (String) map.get("SUBITEMDESC_S");
        		if(subitemdesc_s.indexOf("全钢带束层_4") != -1){
        			queryList.remove(i);
        		}
			}
        }
        return queryList;
    }

    /**
     * 根据物料规格获取物料编码、物料描述以及对应物料组编码
     * 兰颖慧
     * 2019-07-08
     */
    public List<Map<String, Object>> getMatInfoByMatSpec(String materialSpec) throws Exception {
        SQLQuery query = createSQLQuery(getSQL("getMatInfoByMatSpec"));
        query.setParameter("materialSpec", materialSpec);
        
        List<Map<String, Object>> queryList = query.list();
        if(queryList.size() > 1){
        	for (int i = 0; i < queryList.size(); i++) {
        		Map<String, Object> map = queryList.get(i);
        		String subitemdesc_s = (String) map.get("SUBITEMDESC_S");
        		if(null != subitemdesc_s && subitemdesc_s != ""){
        			if(subitemdesc_s.indexOf("全钢带束层_4") != -1){
        				queryList.remove(i);
        			}
        		}
			}
        }
        return queryList;
    }

    /**
     * 界面查询方法
     * 兰颖慧
     * 2019-08-30
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> getPlanInfoList(Filter filter, Page page, Class clazz) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("rows", searchRows(filter, page, clazz));
        result.put("total", searchTotal(filter, page));
        return result;
    }

    @SuppressWarnings("unchecked")
    public <K> List<K> searchRows(Filter filter, Page page, Class<K> clazz) throws Exception {
        filter.set("s_factory_s", LLWebUtils.factory());
        SQLQuery query = createSQLQuery(getSQL("filter_rows", filter));
        if (!StringHelper.isNullOrEmpty(filter.get("status_s"))) {
            query.setParameter("status_s", filter.get("status_s"));
        }
        if (!StringHelper.isNullOrEmpty(filter.get("plandate_s"))) {
            query.setParameter("plandate_s", filter.get("plandate_s"));
        }
        if (!StringHelper.isNullOrEmpty(filter.get("equip_code_s"))) {
            query.setParameter("equip_code_s", filter.get("equip_code_s"));
        }
        if (!StringHelper.isNullOrEmpty(filter.get("s_factory_s"))) {
            query.setParameter("s_factory_s", filter.get("s_factory_s"));
        }
        if (!StringHelper.isNullOrEmpty(filter.get("materialgroup_s"))) {
            query.setParameter("materialgroup_s", filter.get("materialgroup_s"));
        }
        if (!StringHelper.isNullOrEmpty(filter.get("specification_s"))) {
            query.setParameter("specification_s", filter.get("specification_s"));
        }
        if (!StringHelper.isNullOrEmpty(filter.get("materialcode_s"))) {
            query.setParameter("materialcode_s", filter.get("materialcode_s"));
        }
        if (page.getAll() == 0) {
            query.setMaxResults(page.getRows());
            query.setFirstResult((page.getPage() - 1) * page.getRows());
        }
        List<Map<String, Object>> res = query.list();
        List<Map<String, Object>> list_new = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < res.size(); i++) {
            list_new.add(TransformUpperCase.transformUpperCase(res.get(i)));
        }
        return (List<K>) list_new;
    }

    public Long searchTotal(Filter filter, Page page) throws Exception {
        filter.set("s_factory_s", LLWebUtils.factory());
        if (page.getTotalRows() == 0L) {
            SQLQuery query = getSession().createSQLQuery(getSQL("filter_total", filter));
            if (!StringHelper.isNullOrEmpty(filter.get("status_s"))) {
                query.setParameter("status_s", filter.get("status_s"));
            }
            if (!StringHelper.isNullOrEmpty(filter.get("plandate_s"))) {
                query.setParameter("plandate_s", filter.get("plandate_s"));
            }
            if (!StringHelper.isNullOrEmpty(filter.get("equip_code_s"))) {
                query.setParameter("equip_code_s", filter.get("equip_code_s"));
            }
            if (!StringHelper.isNullOrEmpty(filter.get("s_factory_s"))) {
                query.setParameter("s_factory_s", filter.get("s_factory_s"));
            }
            if (!StringHelper.isNullOrEmpty(filter.get("materialgroup_s"))) {
                query.setParameter("materialgroup_s", filter.get("materialgroup_s"));
            }
            if (!StringHelper.isNullOrEmpty(filter.get("specification_s"))) {
                query.setParameter("specification_s", filter.get("specification_s"));
            }
            if (!StringHelper.isNullOrEmpty(filter.get("materialcode_s"))) {
                query.setParameter("materialcode_s", filter.get("materialcode_s"));
            }
            return ((BigDecimal) query.uniqueResult()).longValue();
        } else {
            return page.getTotalRows();
        }
    }

}
