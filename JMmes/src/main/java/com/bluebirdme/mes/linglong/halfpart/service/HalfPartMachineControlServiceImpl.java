
package com.bluebirdme.mes.linglong.halfpart.service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bluebird.clientdata.MachineConfig;
import com.bluebird.clientdata.ResponeResult;
import com.bluebird.clientproxy.PartProessDataProxy;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.building.entity.Usecontrollog;
import com.bluebirdme.mes.linglong.core.constant.FactoryConstant;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.halfpart.entity.Productcontrol;
import com.bluebirdme.mes.linglong.util.TransformUpperCase;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.halfpart.entity.Machinestate;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;

/**
 * 机台控制管理
 *
 * @author 李新宇
 * @Date 2020-03-05 11:15:54
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HalfPartMachineControlServiceImpl extends RockWellUDABaseServiceImpl<Object> {

    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Machinestate.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }


    @Override
    public List<Map<String, Object>> datagridRowsUDA(Filter filter, Page page) throws Exception {
        List<Map<String, Object>> list = searchBy119();
        StringBuffer sql = new StringBuffer("select A.*,B.category,B.DESCRIPTION AS machinename_s,B.P_LINE_NAME , B.PROCESS_S ,B.MACHINESTATUS_S from (");
        sql.append("select  MACHINEBARCODE_S ,");
        try {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).get("DICTCODE_S") != null) {
                    sql.append("sum( CASE WHEN CONTROLITEM_S = '" + list.get(i).get("DICTCODE_S") + "' THEN CONTROLSTATUS_S END ) as A" + list.get(i).get("DICTCODE_S") + " ");
                }
                if (i != list.size() - 1) {
                    sql.append(",");
                }
            }
        } catch (Exception e) {

        }
        sql.append(" from  AT_CM_EM_PRODUCTCONTROL AP where 1=1 GROUP BY MACHINEBARCODE_S ) A");
        sql.append(" RIGHT JOIN ( ");
        sql.append(" SELECT p.DESCRIPTION, p.P_LINE_NAME,p.category,p.P_LINE_KEY,up.PROCESS_S,am.MACHINESTATUS_S ");
        sql.append(" FROM AREA c,AREA_PRODUCTION_LINE d,PRODUCTION_LINE p ");
        sql.append(" left join  UDA_PRODUCTIONLINE up on  up.OBJECT_KEY = p.p_line_key ");
        sql.append(" left join AT_CM_EM_MACHINESTATUS am on   p.P_line_name = am .MACHINEBARCODE_S  and am.RECORD_FLAG_S = 'A' ");
        sql.append(" WHERE  c.AREA_KEY = d.PARENT_KEY  AND  d.CHILD_KEY = p.P_LINE_KEY AND c.AREA_NAME = '"+FactoryConstant.JING_MEN_CODE+LLWebUtils.factory()+"A'");
        if (filter.getFilter().get("machinebarcode_s") != null) {
            sql.append(" and p.P_LINE_NAME =  '" + filter.getFilter().get("machinebarcode_s") + "'  ");
        }
//        if (filter.getFilter().get("machinetype_s") != null) {
//            sql.append(" and p.category =  '" + filter.getFilter().get("machinetype_s") + "'  ");
//        }
        sql.append(" order by p.CREATION_TIME asc ) B ON A.MACHINEBARCODE_S = B.P_LINE_NAME ");

        String querySQL = sql.toString();
        System.out.println(querySQL);
        SQLQuery query = createSQLQuery(querySQL);
        if (page.getAll() == 0) {
            query.setMaxResults(page.getRows());
            query.setFirstResult((page.getPage() - 1) * page.getRows());
        }
        List<Map<String, Object>> listMap = query.list();
        List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> orgMap : listMap) {
            Map<String, Object> map = new HashMap<>();
            map = TransformUpperCase.transformUpperCase(orgMap);
            returnlist.add(map);
        }
        return returnlist;
    }


    public List<Map<String, Object>> searchBy119() throws Exception {
        String dataSql = getSQL("searchBy119");
        if (dataSql == null || dataSql.equals("")) {
            throw new Exception(getClass() + ".xml中未找到ID为searchBy119的SQL语句定义");
        }
        SQLQuery query = createSQLQuery(dataSql);
        List<Map<String, Object>> list = query.list();
        return list;
    }


    public Map<String, Object> datagridLog(Filter filter, Page page) throws Exception {
    	filter.set("s_factory_s", LLWebUtils.factory());
    	String sql = getSQL("datagridLog", filter.getFilter());
        if (sql == null) {
            throw new Exception(getClass() + ".xml中未发现ID为datagridLog的SQL语句定义");
        }
        System.out.println(sql);
        SQLQuery query = createSQLQuery(sql);
        setParameter(query, filter);
        if (page.getAll() == 0) {
            query.setMaxResults(page.getRows());
            query.setFirstResult((page.getPage() - 1) * page.getRows());
        }
        List<Map<String, Object>> list = query.list();
        List<Map<String, Object>> returnlist = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> orgMap : list) {
            Map<String, Object> map = new HashMap<>();
            map = TransformUpperCase.transformUpperCase(orgMap);
            returnlist.add(map);
        }
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("rows", returnlist);
        filter.setOrder(null);
        filter.setSort(null);
        ret.put("total", datagridLogTotal(filter, page));
        return ret;
    }

    private Object datagridLogTotal(Filter filter, Page page) throws Exception {
        String sql = getSQL("datagridLog_total", filter.getFilter());
        if (sql == null) {
            throw new Exception(getClass() + ".xml中未发现ID为datagridLog_total的SQL语句定义");
        }
        if (page.getTotalRows() == 0L) {
            SQLQuery query = getSession().createSQLQuery(sql);
            setParameter(query, filter);
            return ((BigDecimal) query.uniqueResult()).longValue();
        } else {
            return page.getTotalRows();
        }
    }


    public Object changeState(Filter filter, String[] barCodes) throws Exception {
        StringBuffer resultStr = new StringBuffer("");
        if (filter.getFilter().get("oper") != null && barCodes != null) {
            try {
                for (String barcode : barCodes) {
                    String selectSql = "select * from AT_CM_EM_PRODUCTCONTROL " +
                            "where 1=1 and  MACHINEBARCODE_S = '" + barcode + "' and CONTROLITEM_S = '" + filter.getFilter().get("code") + "'";

                    SQLQuery query = createSQLQuery(selectSql);
                    List<Map<String, Object>> result = query.list();
                    String webServiceAddress="";
        			if(LLWebUtils.factory().equals("2")){
        				webServiceAddress="http://192.168.168.232:11012/winceService?wsdl";//半钢
        			}
        			if(filter.getFilter().get("code").equals("119001")&&filter.getFilter().get("oper").equals("0")){
        				try {
        					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,barcode);
        					MachineConfig machineConfig = new MachineConfig();
        					machineConfig.setMachineCode(barcode);
        					ResponeResult result1=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
        					if(!result1.getResult().equals("OK")){
        					    return result1.getResult();
        					}
        				}catch(Exception e) {
        					return "出现其他错误:"+e.getMessage();
        				}	
        			}
        			if(filter.getFilter().get("code").equals("119002")&&filter.getFilter().get("oper").equals("0")){
        				try {
        					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,barcode);
        					MachineConfig machineConfig = new MachineConfig();
        					machineConfig.setMachineCode(barcode);
        					ResponeResult result1=partProessDataProxy.relieveToolingStopAlarm(machineConfig);
        					if(!result1.getResult().equals("OK")){
        					    return result1.getResult();
        					}
        				}catch(Exception e) {
        					return "出现其他错误:"+e.getMessage();
        				}	
        			}
        			if(filter.getFilter().get("code").equals("119003")&&filter.getFilter().get("oper").equals("0")){
        				try {
        					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,barcode);
        					MachineConfig machineConfig = new MachineConfig();
        					machineConfig.setMachineCode(barcode);
        					ResponeResult result1=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
        					if(!result1.getResult().equals("OK")){
        					    return result1.getResult();
        					}
        				}catch(Exception e) {
        					return "出现其他错误:"+e.getMessage();
        				}	
        			}
        			if(filter.getFilter().get("code").equals("119009")&&filter.getFilter().get("oper").equals("0")){
        				try {
        					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,barcode);
        					MachineConfig machineConfig = new MachineConfig();
        					machineConfig.setMachineCode(barcode);
        					ResponeResult result1=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
        					if(!result1.getResult().equals("OK")){
        					    return result1.getResult();
        					}
        				}catch(Exception e) {
        					return "出现其他错误:"+e.getMessage();
        				}	
        			}
        			if(filter.getFilter().get("code").equals("119010")&&filter.getFilter().get("oper").equals("0")){
        				try {
        					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,barcode);
        					MachineConfig machineConfig = new MachineConfig();
        					machineConfig.setMachineCode(barcode);
        					ResponeResult result1=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
        					if(!result1.getResult().equals("OK")){
        					    return result1.getResult();
        					}
        				}catch(Exception e) {
        					return "出现其他错误:"+e.getMessage();
        				}	
        			}
        			if(filter.getFilter().get("code").equals("119011")&&filter.getFilter().get("oper").equals("0")){
        				try {
        					PartProessDataProxy partProessDataProxy=new PartProessDataProxy(webServiceAddress,barcode);
        					MachineConfig machineConfig = new MachineConfig();
        					machineConfig.setMachineCode(barcode);
        					ResponeResult result1=partProessDataProxy.relieveMachineFeedingAlarm(machineConfig);
        					if(!result1.getResult().equals("OK")){
        					    return result1.getResult();
        					}
        				}catch(Exception e) {
        					return "出现其他错误:"+e.getMessage();
        				}	
        			}
        			
                    if (result != null && result.size() != 0) {
                        if (result.get(0).get("CONTROLSTATUS_S").equals(filter.getFilter().get("oper"))) {
                            resultStr.append(barcode + ",");
                            continue;
                        }
                    }
                    Productcontrol productcontrol = new Productcontrol();
                    productcontrol.setControltype_s("0");
                    productcontrol.setRecord_flag_s("A");
                    productcontrol.setMachinebarcode_s(barcode);
                    productcontrol.setControlstatus_s(filter.getFilter().get("oper"));
                    productcontrol.setControlitem_s(filter.getFilter().get("code"));
                    productcontrol.setControlcode_s(barcode + filter.getFilter().get("code"));
                    productcontrol.setS_factory_s(LLWebUtils.factory());
                    productcontrol.setAgenc_no_s("8023");
                    if (result.size() == 1) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        productcontrol.setCreated_time_t(format.parse(result.get(0).get("CREATED_TIME_T").toString()));
                        productcontrol.setCreated_by_s(result.get(0).get("CREATED_BY_S").toString());
                        productcontrol.setControlstatus_s(filter.getFilter().get("oper"));
                        productcontrol.setChanged_by_s(LLWebUtils.getUser().getUserCode());
                        productcontrol.setChanged_time_s(format.format(new Date()));
                        productcontrol.setAtr_key(Long.parseLong(result.get(0).get("ATR_KEY").toString()));
                        update(productcontrol);
                    } else if (result.isEmpty()) {
                        productcontrol.setCreated_time_t(new Date());
                        productcontrol.setCreated_by_s(LLWebUtils.getUser().userCode);
                        save(productcontrol);
                    }

                    //将操作添加到日志表
                    Usecontrollog log = new Usecontrollog();
                    log.setAgenc_no_s("8023");
                    log.setCreated_by_s(LLWebUtils.getUser().getUserCode());
                    log.setCreated_time_t(new Date());
                    log.setS_factory_s(LLWebUtils.factory());
                    log.setRecord_flag_s("A");
                    log.setMachinebarcode_s(barcode);
                    log.setControltype_s("0");
                    log.setControlstatus_s(filter.getFilter().get("oper"));
                    log.setControlitem_s(filter.getFilter().get("code"));
                    log.setControlcode_s(barcode + filter.getFilter().get("code"));
                    log.setSpare1_s("252004");
                    save(log);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "error";
            }
        }
        if (resultStr.toString().equals("")) {
            return "success";
        }
        return resultStr.append("已经为当前状态,无需重复操作!").toString();
    }

}
