/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;
import org.apache.ecs.html.S;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellEntityDTO;
import com.bluebirdme.mes.linglong.halfpart.entity.Ledger;
import org.xdemo.app.xutils.j2se.ListUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.util.MapTrunPojo;

/**
 * (半部件)库存台账
 *
 * @author 李新宇
 * @Date 2020-03-12 08:17:06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HalfPartInventoryAccountServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Ledger.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    @RockWellTransactional
    public void saveChanges(RockWellEntityDTO rockWellEntityDTO) throws Exception {

        if (!ListUtils.isEmpty(rockWellEntityDTO.getDeleted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getDeleted().size(); i++) {
                //将MAP转换为实体
                Ledger ledger = (Ledger) MapTrunPojo.mapToEntity(rockWellEntityDTO.getDeleted().get(i), Ledger.class);
                //ledger.setCreated_time_t(new Date());
                list.add(ledger);
            }
            delete(list);
        }
        if (!ListUtils.isEmpty(rockWellEntityDTO.getInserted())) {
            List list = new ArrayList<>();
            for (int i = 0; i < rockWellEntityDTO.getInserted().size(); i++) {
                //将MAP转换为实体
                Ledger ledger = (Ledger) MapTrunPojo.mapToEntity(rockWellEntityDTO.getInserted().get(i), Ledger.class);
                //ledger.setCreated_time_t(new Date());
                list.add(ledger);
            }
            save(list);
        }
        /**
         *在使用update的时候要注意，这里的update传递参数的时候不要使用list进行传递
         */
        if (!ListUtils.isEmpty(rockWellEntityDTO.getUpdated())) {
            for (int i = 0; i < rockWellEntityDTO.getUpdated().size(); i++) {
                //将MAP转换为实体
                Ledger ledger = (Ledger) MapTrunPojo.mapToEntity(rockWellEntityDTO.getUpdated().get(i), Ledger.class);
                //ledger.setCreated_time_t(new Date());
                update(ledger);
            }
        }

    }


    public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page, Map param) throws Exception {
        if (getSQL("datagridUDA_rows") == null)
            throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_rows的SQL语句定义");
        if( filter.getFilter().get("expire") == null && param != null){
            filter.getFilter().put("expire", String.valueOf(param.get("expire")));
        }
        if (filter.getFilter().get("quality_status_s") != null &&
                Integer.parseInt((String) filter.getFilter().get("quality_status_s")) == 0) {
            filter.getFilter().remove("quality_status_s");
        }
        if (filter.getFilter().get("stocktype_s") != null &&
                Integer.parseInt((String) filter.getFilter().get("stocktype_s")) == 0) {
            filter.getFilter().remove("stocktype_s");
        }
        String dataSql = getSQL("datagridUDA_rows", filter.getFilter());
        System.out.println(dataSql);
        SQLQuery query = createSQLQuery(dataSql);
        if (filter.getFilter().get("expire") != null) {
            filter.getFilter().remove("expire");
        }
        setParameter(query, filter);
        if (page.getAll() == 0) {
            query.setMaxResults(page.getRows());
            query.setFirstResult((page.getPage() - 1) * page.getRows());
        }
        List<Map<String, Object>> listMap = query.list();
        // 大写变小写转换后的list
        List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> orgMap : listMap) {
            Map<String, Object> map = new HashMap<>();
            map = TransformUpperCase.transformUpperCase(orgMap);
            returnlist.add(map);
        }
        return returnlist;
    }


    public Long datagridTotalUDA(Filter filter, Page page) throws Exception {
        if (getSQL("datagridUDA_total") == null)
            throw new Exception(getClass() + ".xml中未找到ID为datagridUDA_total的SQL语句定义");
        if (filter.getFilter().get("quality_status_s") != null &&
                Integer.parseInt((String) filter.getFilter().get("quality_status_s")) == 0) {
            filter.getFilter().remove("quality_status_s");
        }
        if (filter.getFilter().get("stocktype_s") != null &&
                Integer.parseInt((String) filter.getFilter().get("stocktype_s")) == 0) {
            filter.getFilter().remove("stocktype_s");
        }
        String totalSql = getSQL("datagridUDA_total", filter.getFilter());
        if (filter.getFilter().get("expire") != null) {
            filter.getFilter().remove("expire");
        }
        System.out.println(totalSql);
        if (page.getTotalRows() == 0L) {
            SQLQuery query = getSession().createSQLQuery(totalSql);
            setParameter(query, filter);
            return ((BigDecimal) query.uniqueResult()).longValue();
        } else {
            return page.getTotalRows();
        }
    }


    public Map<String, Object> datagridUDA(Filter filter, Page page) throws Exception {

        String FACTORY = "s_factory_s";

        if (!filter.getFilter().containsKey(FACTORY)) {
            try {
                filter.set("s_factory_s", LLWebUtils.factory());
            } catch (Exception e) {
                throw new Exception("当前请求的查询参数Filter中，无全钢或半钢标识:s_factory_s,或用户未登录");
            }
        }
        Map<String, Object> ret = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<>();
        map.put("expire", filter.getFilter().get("expire"));
        ret.put("total", datagridTotalUDA(filter, page));
        ret.put("rows", datagridRowsUDA(filter, page, map));
        filter.setOrder(null);
        filter.setSort(null);
        return ret;

    }


    /**
     * 超期申请
     * 李新宇
     * 2020/3/13 16：11
     *
     * @param atr_keys
     * @return
     */
    public Object apply(String[] atr_keys) {
        StringBuilder builder = new StringBuilder("");
        try {
            for (String atr_key : atr_keys) {
                String sql = "select * from AT_A_SM_LEDGER where atr_key = " + atr_key;
                SQLQuery query = createSQLQuery(sql);
                List<Map<String, Object>> list = query.list();
                if (list.get(0).get("ISREQUEST_S").equals("1")) {
                    builder.append(list.get(0).get("BARCODE_S") + ",");
                    continue;
                }
                Ledger ledger = (Ledger) MapTrunPojo.mapToEntity(list.get(0), Ledger.class);
                ledger.setIsrequest_s("1");
                update(ledger);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        if (!builder.toString().equals("")) {
            return builder.append("已申请,请勿重复申请！").toString();
        }
        return builder.append("success").toString();
    }


    /**
     * 获取数据字典延期时间
     * 李新宇
     * 2020/3/14 8:18
     */
    public String getDelayTime() throws Exception {
        String sql = getSQL("get_delaytime");
        if (sql == null) {
            throw new Exception(getClass() + ".xml中未找到ID为get_delaytime的SQL语句定义");
        }
        String delayTime = (String) getSession().createSQLQuery(sql).uniqueResult();
        return delayTime;
    }

    /**
     * 延期处理
     * 李新宇
     * 2020/3/14 8:24
     */
    public Object handle(String[] atr_keys) {
        Integer delayTime = null;
        String selectByAtrKey = null;
        SQLQuery query = null;
        Map<String, Object> map = null;
        Ledger ledger = null;
        Calendar calendar = Calendar.getInstance();
        try {
            delayTime = Integer.parseInt(getDelayTime());
            for (String atr_key : atr_keys) {
                selectByAtrKey = "select * from AT_A_SM_LEDGER where atr_key = " + atr_key;
                query = createSQLQuery(selectByAtrKey);
                map = (Map<String, Object>) query.uniqueResult();
                ledger = (Ledger) MapTrunPojo.mapToEntity(map, Ledger.class);
                ledger.setOuttime_t(dateEditor(ledger.getOuttime_t(), calendar, delayTime));
                if (ledger.getTimelimit_f() != null) {
                    ledger.setTimelimit_f("" + (Integer.parseInt((String) ledger.getTimelimit_f()) + delayTime));
                }else {
                    ledger.setTimelimit_f(""  + delayTime);
                }
                ledger.setDelaytime_t(new Date());
                ledger.setIsrequest_s("0");
                update(ledger);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }


    /**
     * 修改时间工具
     * 李新宇
     * 2020/3/14 8:41
     */
    private Date dateEditor(Date date, Calendar calendar, Integer editor) {
        calendar.setTime(date);
        /* calendar.set(Calendar.HOUR, calendar.get((Calendar.HOUR) + editor));*/
        calendar.add(Calendar.HOUR, +editor);
        return calendar.getTime();
    }
}
