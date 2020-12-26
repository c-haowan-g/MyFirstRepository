/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import javax.annotation.Resource;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import com.bluebirdme.core.system.web.Filter;
import com.rockwell.mes.ws.server.Obj;
import freemarker.template.TemplateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.finalcheck.entity.XrayMaintain;

import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * X光检测数据维护表
 *
 * @author 时永良
 * @Date 2020-02-21 16:09:51
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class XrayMaintainServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return XrayMaintain.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    @RockWellTransactional
    public String saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
                //将MAP转换为实体
                XrayMaintain xraymaintain = (XrayMaintain) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), XrayMaintain.class);
                if (xraymaintain.getRecord_flag_s() != null) {
                    xraymaintain.setRecord_flag_s("D");
                } else {
                    return xraymaintain.getAtr_key() + "删除失败";
                }
                update(xraymaintain);
            }
            return "success";
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
            List list = new ArrayList<>();
            for (Map<String, Object> newitem : rockWellEntityDTO.getInserted()) {
                //将MAP转换为实体
                XrayMaintain xraymaintain = (XrayMaintain) MapTrunPojo.mapToEntity(newitem, XrayMaintain.class);
                if (checkMaterialCode(xraymaintain.getMaterial_code_s()) == 0) {
                    xraymaintain.setS_factory_s(LLWebUtils.factory());  //设置全钢半钢 1/2
                    xraymaintain.setAgenc_no_s(LLConstant.JING_MEN_CODE);  //设置机构代码8023
                    xraymaintain.setCreated_time_t(new Date());
                    xraymaintain.setCreated_by_s(LLWebUtils.getUser().userCode);
                    xraymaintain.setRadius_f(newitem.get("radius_f").toString());
                    xraymaintain.setRecord_flag_s("A");
                    xraymaintain.setTyreheight_f(newitem.get("tyreheight_f").toString());
                    list.add(xraymaintain);
                } else {
                    return "规格品号已被占用";
                }
            }
            save(list);
            return "success";
        }
        /**
         *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
         */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
            for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
                //将MAP转换为实体
                XrayMaintain xraymaintain = (XrayMaintain) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), XrayMaintain.class);
                //xraymaintain.setCreated_time_t(new Date());
                Integer check = checkMaterialCode(xraymaintain.getMaterial_code_s());
                switch (check) {
                    case 1 :
                        SQLQuery query = getSession().createSQLQuery
                                ("select atr_key from AT_D_BS_XRAYMAINTAIN where record_flag_s = 'A' and MATERIAL_CODE_S="+xraymaintain.getMaterial_code_s());
                        String key = xraymaintain.getAtr_key().toString();
                        String db_key = query.uniqueResult().toString();
                        if(key.equals(db_key)){
                            xraymaintain.setChanged_by_s(LLWebUtils.getUser().userCode);
                            xraymaintain.setChanged_time_t(new Date());
                            update(xraymaintain);
                        }else {
                            return "规格品号已被占用";
                        }
                        break;
                    case 0 :
                        xraymaintain.setChanged_by_s(LLWebUtils.getUser().userCode);
                        xraymaintain.setChanged_time_t(new Date());
                        update(xraymaintain);
                        break;
                    default:
                        return "规格品号已被占用";
                }

            }
            return "success";
        }
        return null;
    }

    /**
     * @return 检查表中MaterialCode是否存在保证唯一性
     * @author 李新宇
     * @Date 2020/2/22 09:30
     */
    private Integer checkMaterialCode(String code) {
        Filter filter = new Filter();
        if (code != null) {
            filter.getFilter().put("MATERIAL_CODE_S", code);
        }

        String query = null;
        BigDecimal countNum = null;
        try {
            query = getSQL("check_material_code", filter);
            SQLQuery sqlQuery = createSQLQuery(query);
            setParameter(sqlQuery, filter);
            Map<String, Object> countMaterial_code = (Map<String, Object>) sqlQuery.uniqueResult();
            countNum = (BigDecimal) countMaterial_code.get("COUNT(1)");
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(countNum.toString());
    }


    /**
     * 外胎物料信息--X光检测数据维护
     * 时永良 2020年2月22日
     *
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> fertMaterialList() {
        SQLQuery query = getSession().createSQLQuery(getSQL("fertMaterialList"));
        String factoryString = LLWebUtils.factory();
        List<String> QGParaLists = new ArrayList<>();
        List<String> BGParaLists = new ArrayList<>();
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
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

}
