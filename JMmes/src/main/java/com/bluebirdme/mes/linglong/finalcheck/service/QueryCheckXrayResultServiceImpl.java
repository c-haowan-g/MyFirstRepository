package com.bluebirdme.mes.linglong.finalcheck.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.bluebirdme.core.system.web.Page;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellUDABaseServiceImpl;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.finalcheck.entity.CheckXrayResult;

/**
 * X光检测信息查询
 *
 * @author 时永良
 * @Date 2020年2月24日13:31:06
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QueryCheckXrayResultServiceImpl extends RockWellUDABaseServiceImpl<Object> {
    @Resource
    LingLongDataSource llds;

    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return CheckXrayResult.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }

    /**
     * 查询病象描述（中文）
     *
     * @Title: SearchDefectName
     * @Description: TODO(描述)
     * @return: List<Map < String, Object>> 返回类型
     */
//    @SuppressWarnings("unchecked")
//    public List<Map<String, Object>> SearchDefectName(String checkseq,String defectid) throws Exception {
//        SQLQuery query = createSQLQuery(getSQL("SearchDefectName"));
//        query.setParameter("s_factory_s", LLWebUtils.factory());
//        query.setParameter("checkseq_i", checkseq);
//        query.setParameter("defectid_s", defectid);
//        List<Map<String, Object>> list = query.list();
//        return list;
//    }

   /* * 查询病象描述（中文）
    *
    * @Title: SearchDefectName
    * @Description: TODO(描述)
    * @return: List<Map < String, Object>> 返回类型
    */
   @SuppressWarnings("unchecked")
   public List<Map<String, Object>> SearchDefectName(String barcode, int count,String starttime,String endtime) throws Exception {
       SQLQuery query = createSQLQuery(getSQL("SearchDefectName"));
       query.setParameter("s_factory_s", LLWebUtils.factory());
       query.setParameter("barcode", barcode);
       query.setParameter("count", count);
       query.setParameter("starttime", starttime);
       query.setParameter("endtime", endtime);
       List<Map<String, Object>> list = query.list();
       return list;
   }
    /**
     * 查询X光明细（包括病象等信息）
     *
     * @Title: SearchDefect
     * @Description: TODO(描述)
     * @return: List<Map < String, Object>> 返回类型
     */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> SearchDefectName(int count,String code,String starttime,String endtime) throws Exception {
        SQLQuery query = createSQLQuery(getSQL("SearchDefectName"));
        query.setParameter("s_factory_s", LLWebUtils.factory());
        query.setParameter("count", count);
        query.setParameter("code", code);
        query.setParameter("starttime", starttime);
        query.setParameter("endtime", endtime);
        List<Map<String, Object>> list = query.list();
        return list;
    }


    /**
     * @author 李新宇
     * 字段处理从Controller中抽离
     */
    public Map<String, Object> datagridUDAReWrite(Filter filter, Page page) throws Exception {
        Map<String, Object> map = datagridUDA(filter, page);
//        List<Map<String, Object>> rowsList = (List<Map<String, Object>>) map.get("rows");
//        List<Map<String, Object>> defectList = SearchDefect(filter);
//        StringBuffer defect = null;
//        for (int i = 0; i <6; i++) {
//            defect = new StringBuffer("");
//            for (int j = 0; j < defectList.size(); j++) {
//                if (rowsList.get(i).get("tyrebarcode_s").equals(defectList.get(j).get("TYREBARCODE_S"))) {
//                    if (defectList.get(j).get("REAS_CN_S") != null) {
//                        if (!defect.toString().equals("")) {
//                            defect.append(",");
//                        }
//                        defect.append(defectList.get(j).get("REAS_CN_S").toString());
//                        defect.append(defectList.get(j).get("CHECKSEQ_I").toString());
//                    }
//                }
//            }
//            if (!rowsList.get(i).get("gradeid_s").equals("253001")) {
//                rowsList.get(i).put("defectid_s", defect);
//            } else {
//                rowsList.get(i).put("defectid_s", "无病象");
//            }
//        }
        return map;
    }

}
