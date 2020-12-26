/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.service;

import java.math.BigDecimal;
import java.util.*;

import javax.annotation.Resource;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.FilterRule;
import com.bluebirdme.core.system.web.Page;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.LLConstant;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellUtils;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.SortStoragItem;
import com.bluebirdme.mes.linglong.finalcheck.entity.dto.SortStoragItemDTO;
import org.xdemo.app.xutils.j2se.StringUtils;

/**
 * 入库规则维护
 *
 * @author 刘程明
 * @Date 2018-08-16 07:23:04
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SortStoragItemServiceImpl extends RockWellBaseServiceImpl<SortStoragItem> {

    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SortStoragItem.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    public void saveChanges(SortStoragItemDTO sortstoragitem) throws Exception {
        if (!ListUtils.isEmpty(sortstoragitem.getDeleted())) {
            delete(sortstoragitem.getDeleted());
        }
        if (!ListUtils.isEmpty(sortstoragitem.getInserted())) {
            String factoryString = LLWebUtils.factory();
            String factoryCodeString = FactoryConstant.JING_MEN_CODE;
            List<SortStoragItem> SortStoragList = sortstoragitem.getInserted();
            for (SortStoragItem item : SortStoragList) {
                item.setCreated_by_s(WebUtils.getUserName());
                item.setCreated_time_t(new Date());
                item.setNum_i(1);
                item.setRecord_flag_s("A");
                ;
                item.setStation_i(260006);
                item.setS_factory_s(factoryString);
                item.setAgenc_no_s(factoryCodeString);
            }
            save(SortStoragList);
        }
        if (!ListUtils.isEmpty(sortstoragitem.getUpdated())) {
            List<SortStoragItem> sortstoragitemList = sortstoragitem.getUpdated();
            for (SortStoragItem item : sortstoragitemList) {
                item.setChanged_by_s(LLWebUtils.getUser().userName);
                item.setChanged_time_t(new Date());
            }
            update(sortstoragitemList);
        }

    }

    /**
     * 获取入库分拣规则维护是否有相同数据
     *
     * @param entbarcode
     * @param itemid
     * @param gradecode
     * @return num
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    private BigDecimal getRecipeNoByID(String entbarcode, String itemid, int gradecode) throws Exception {
        SQLQuery query = getSession().createSQLQuery(getSQL("SortStorag_namecount"));
        query.setParameter("entbarcode_s", entbarcode);
        query.setParameter("itemid_s", itemid);
        query.setParameter("gradecode_i", gradecode);
        BigDecimal num = ((BigDecimal) query.uniqueResult());
        return num;
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getEntCodeName() throws Exception {
        SQLQuery query = createSQLQuery(getSQL("EntCodeName"));
        List<Map<String, Object>> list = query.list();
        return list;
    }


    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getmaterial() throws Exception {
        if (LLWebUtils.factory().equals("2")) {
            // 全钢
            SQLQuery query = createSQLQuery(getSQL("quangangmaterial"));
            List<Map<String, Object>> list = query.list();
            return list;
        } else {
            SQLQuery query = createSQLQuery(getSQL("bangangmaterial"));
            List<Map<String, Object>> list = query.list();
            return list;
        }

    }


    /**
     * 保存数据
     *
     * @param listform 前端返回的数据
     * @throws Exception
     */
    public Boolean saveChanges2(String[] list, String type) throws Exception {
        List<SortStoragItem> sortStoragItemList = new ArrayList<SortStoragItem>();
        int j = 0;
        for (int i = 0; i < list.length / 4; i++) {
            SortStoragItem item = new SortStoragItem();
            item.setItemid_s(list[j].toString());//设置物料编码
            item.setGradecode_i(list[j + 1].toString());//设置质量等级
            item.setEntbarcode_s(list[j + 2].toString());//设置机台编码
            item.setTrackno_s(list[j + 3].toString());//设置道口号
            if (type.equals("0")) {
                Where where = new Where();
                where.andEqual("itemid_s", list[j].toString());//设置物料编码
                where.andEqual("gradecode_i", Integer.valueOf(list[j + 1].toString()));//设置质量等级
                where.andEqual("entbarcode_s", list[j + 2].toString());//设置机台编码
                where.andEqual("trackno_s", list[j + 3].toString());//设置道口号
                List<SortStoragItem> deleteItems = findByWhere(where);
                delete(deleteItems);
            }
            item.setCreated_by_s(LLWebUtils.getUserName());
            item.setCreated_time_t(new Date());
            item.setRecord_flag_s(LLConstant.Record_Flag.AVAILIABLE);
            item.setAgenc_no_s(LLConstant.JING_MEN_CODE);
            item.setS_factory_s(LLWebUtils.factory());
            item.setNum_i(100);//全检
            item.setStation_i(260006);//分拣点
            item.setStationdesc_s("分拣点:" + list[j + 2].toString() + "道口号" + list[j + 3].toString());
            sortStoragItemList.add(item);
            j = j + 4;
        }
        //保存,type:0删除，1保存
        if (type.equals("1")) {
            save(sortStoragItemList);
        }
        return true;
    }

    /**
     * 查询出选中规格已有的质量等级
     *
     * @param materialCode 品号
     * @return
     */
    public List<Map<String, Object>> findExitGradeCode(String materialCode) {
        if (materialCode.isEmpty()) {
            return null;
        }
        String factoryString = LLWebUtils.factory();
        SQLQuery query = createSQLQuery(getSQL("exitGradeCode"));
        query.setParameter("materialCode", materialCode);
        query.setParameter("s_factory_s", factoryString);
        List<Map<String, Object>> list = query.list();
        return list;
    }

    /**
     * 根据品号+质量等级获取机台信息
     *
     * @param materialCode 品号
     * @param gradeCode    等级编码
     * @return
     */
    public List<Map<String, Object>> findExitEntCode(String materialCode, String gradeCode) {
        if (materialCode.isEmpty()) {
            return null;
        }
        String factoryString = LLWebUtils.factory();
        SQLQuery query = createSQLQuery(getSQL("exitEntCode"));
        query.setParameter("materialCode", materialCode);
        query.setParameter("gradeCode", gradeCode);
        query.setParameter("s_factory_s", factoryString);
        List<Map<String, Object>> list = query.list();
        return list;
    }

    /**
     * 根据品号查询出没有维护的质量等级编码
     *
     * @param materialCode 品号
     * @return
     */
    public List<Map<String, Object>> findnoSelectGradeCode(String itemid_s) {
        if (itemid_s.isEmpty()) {
            return null;
        }
        String factoryString = LLWebUtils.factory();
        SQLQuery query = createSQLQuery(getSQL("noSelectGradeCode"));
        query.setParameter("itemid_s", itemid_s);
        query.setParameter("s_factory_s", factoryString);
        List<Map<String, Object>> list = query.list();
        return list;
    }
    //findnoSelectTracknoCode

    /**
     * 查询出没有维护的设备条码
     *
     * @param itemid_s
     * @return
     */
    public List<Map<String, Object>> findnoSelectTracknoCode(String itemid_s, String gradecode) {
        if (itemid_s.isEmpty() || gradecode.isEmpty()) {
            return null;
        }
        String factoryString = LLWebUtils.factory();
        SQLQuery query = createSQLQuery(getSQL("noSelectTrackNo"));
        query.setParameter("itemid_s", itemid_s);
        query.setParameter("gradeCode", gradecode);
        query.setParameter("s_factory_s", factoryString);
        List<Map<String, Object>> list = query.list();
        return list;
    }


    public List<Map<String, Object>> getPartsDatagrid(Filter filter) throws Exception {
        String sql = getSQL("getPartsRows", filter);
        if (sql == null) {
            throw new Exception(getClass() + ".xml中未发现ID为getPartsRows的SQL语句定义");
        }
        SQLQuery query = createSQLQuery(sql);
        setParameter(query, filter);
        return query.list();
    }
}
