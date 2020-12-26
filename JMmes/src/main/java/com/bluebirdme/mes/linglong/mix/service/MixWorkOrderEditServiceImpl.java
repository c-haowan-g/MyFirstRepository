package com.bluebirdme.mes.linglong.mix.service;

import com.bluebirdme.core.common.entity.User;
import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.mix.entity.MixWorkOrderEdit;
/*import com.bluebirdme.mes.linglong.mix.entity.dto.MixWorkOrderEditDTO;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSImplementService;
import com.bluebirdme.mes.linglong.wsdl.mixserviceex.MESWSInterface;
import com.bluebirdme.mes.mobile.common.service.DateUtils;*/
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xdemo.app.xutils.j2se.ListUtils;

@Service
@Transactional(rollbackFor={Exception.class})
public class MixWorkOrderEditServiceImpl extends RockWellBaseServiceImpl<MixWorkOrderEdit>
{

  @Resource
  LingLongDataSource llds;

  protected Session getSession()
  {
    return this.llds.getSession();
  }

  protected Class getEntity()
  {
    return MixWorkOrderEdit.class;
  }

  protected boolean useCache()
  {
    return false;
  }

  /*@RockWellTransactional
  public void saveChanges(MixWorkOrderEditDTO drtrack) throws Exception
  {
    if (!ListUtils.isEmpty(drtrack.getDeleted())) {
      delete(drtrack.getDeleted());
    }
    if (!ListUtils.isEmpty(drtrack.getInserted())) {
      save(drtrack.getInserted());
    }
    if (!ListUtils.isEmpty(drtrack.getUpdated()))
      update(drtrack.getUpdated());
  }*/

  public Map<String, Object> datagrid2(Filter filter, Page page, Class clazz)
    throws Exception
  {
    Map ret = new HashMap();

    ret.put("rows", datagridRows2(filter, page, clazz));
    filter.setOrder(null);
    filter.setSort(null);
    ret.put("total", datagridTotal2(filter, page));

    return ret;
  }

  public Long datagridTotal2(Filter filter, Page page) throws Exception
  {
    if (getSQL("datagrid_total2") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
    }
    String totalSql = getSQL("datagrid_total2", filter.getFilter());

    if (page.getTotalRows() == 0L)
    {
      SQLQuery query = getSession().createSQLQuery(totalSql);

      setParameter(query, filter);

      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
    }
    return Long.valueOf(page.getTotalRows());
  }

  public <K> List<K> datagridRows2(Filter filter, Page page, Class<K> clazz)
    throws Exception
  {
    if (getSQL("datagrid_rows2") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
    }
    String dataSql = getSQL("datagrid_rows2", filter.getFilter());

    SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

    setParameter(query, filter);

    if (page.getAll() == 0) {
      query.setMaxResults(page.getRows());
      query.setFirstResult((page.getPage() - 1) * page.getRows());
    }

    return query.list();
  }

  public Map<String, Object> setup(Filter filter, Page page, Class clazz) throws Exception
  {
    Map ret = new HashMap();

    ret.put("rows", setupRows(filter, page, clazz));
    filter.setOrder(null);
    filter.setSort(null);
    ret.put("total", setupTotal(filter, page));

    return ret;
  }

  public Long setupTotal(Filter filter, Page page) throws Exception
  {
    if (getSQL("setup_total") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
    }
    String totalSql = getSQL("setup_total", filter.getFilter());

    if (page.getTotalRows() == 0L)
    {
      SQLQuery query = getSession().createSQLQuery(totalSql);

      setParameter(query, filter);

      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
    }
    return Long.valueOf(page.getTotalRows());
  }

  public <K> List<K> setupRows(Filter filter, Page page, Class<K> clazz)
    throws Exception
  {
    if (getSQL("setup_rows") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
    }
    String dataSql = getSQL("setup_rows", filter.getFilter());

    SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

    setParameter(query, filter);

    if (page.getAll() == 0) {
      query.setMaxResults(page.getRows());
      query.setFirstResult((page.getPage() - 1) * page.getRows());
    }

    return query.list();
  }

  public Map<String, Object> setup2(Filter filter, Page page, Class clazz) throws Exception
  {
    Map ret = new HashMap();

    ret.put("rows", setupRows2(filter, page, clazz));
    filter.setOrder(null);
    filter.setSort(null);
    ret.put("total", setupTotal2(filter, page));

    return ret;
  }

  public Long setupTotal2(Filter filter, Page page) throws Exception
  {
    if (getSQL("setup_total2") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_total的SQL语句定义");
    }
    String totalSql = getSQL("setup_total2", filter.getFilter());

    if (page.getTotalRows() == 0L)
    {
      SQLQuery query = getSession().createSQLQuery(totalSql);

      setParameter(query, filter);

      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
    }
    return Long.valueOf(page.getTotalRows());
  }

  public <K> List<K> setupRows2(Filter filter, Page page, Class<K> clazz)
    throws Exception
  {
    if (getSQL("setup_rows2") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_rows的SQL语句定义");
    }
    String dataSql = getSQL("setup_rows2", filter.getFilter());

    SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

    setParameter(query, filter);

    if (page.getAll() == 0) {
      query.setMaxResults(page.getRows());
      query.setFirstResult((page.getPage() - 1) * page.getRows());
    }

    return query.list();
  }

  private String buildcommonMsg(Integer type, String msg) {
    String color = "";
    if (type.equals(Integer.valueOf(0)))
      color = "<font color=ff0000>";
    else if (type.equals(Integer.valueOf(1)))
      color = "<font color=000000>";
    else if (type.equals(Integer.valueOf(2))) {
      color = "<font color=f7df09>";
    }
    return color + msg + "<br>";
  }

  public String downward(String[] recipecodelist)
    throws Exception
  {
    StringBuffer sb = new StringBuffer();
    String recipecode = "";
    int sucCount = 0;
    StringBuffer falseinfo = new StringBuffer();
    for (int i = 0; i < recipecodelist.length; i++) {
      recipecode = recipecodelist[i];
   //   MESWSImplementService wsexinterface = new MESWSImplementService();
   //   MESWSInterface portType = wsexinterface.getMESWSImplementPort();
      String result = "False";
  //    result = portType.reciveWoSendByMES(null, null, recipecode, LLWebUtils.getUser().userCode, 
  //      LLWebUtils.getUser().userName);
      if (result.equals("OK"))
        sucCount += 1;
      else {
        falseinfo.append(recipecode + "下发失败，返回结果：" + result + "<br>");
      }
    }
    sb.append("合计：" + recipecodelist.length + "条，成功：" + sucCount + "条；失败：" + (recipecodelist.length - sucCount) + "条");

    sb.append("<br>");
    sb.append(falseinfo.toString());
    return sb.toString();
  }

  public String check(String[] recipecodelist)
    throws Exception
  {
    StringBuffer sb = new StringBuffer();
    String recipecode = "";

    StringBuffer falseinfo = new StringBuffer();
    for (int i = 0; i < recipecodelist.length; i++) {
      String[] contentStr = recipecodelist[i].split("\\|");
      recipecode = contentStr[2];
   //   MESWSImplementService wsexinterface = new MESWSImplementService();
   //   MESWSInterface portType = wsexinterface.getMESWSImplementPort();
      String result = "False";

    //  result = portType
    //    .reciveMixerMasterByMES(null, null, "Check", contentStr[0], contentStr[1], recipecode, null, null, 
    //    LLWebUtils.getUser().userCode, LLWebUtils.getUser().userName);
      if (!result.equals("OK"))
      {
        falseinfo.append(recipecode + ":" + result + "<br>");
      }
    }
    sb.append(falseinfo.toString());
    return sb.toString();
  }

  public String end(String[] recipecodelist)
    throws Exception
  {
    StringBuffer sb = new StringBuffer();
    String recipecode = "";
    int sucCount = 0;
    StringBuffer falseinfo = new StringBuffer();
    for (int i = 0; i < recipecodelist.length; i++) {
      recipecode = recipecodelist[i];
    //  MESWSImplementService wsexinterface = new MESWSImplementService();
    //  MESWSInterface portType = wsexinterface.getMESWSImplementPort();
      String result = "False";
   //   result = portType.reciveWoCloseByMES(null, null, recipecode, LLWebUtils.getUser().userCode, 
   //     LLWebUtils.getUser().userName);
      if (result.equals("OK"))
        sucCount += 1;
      else {
        falseinfo.append(recipecode + "工单关闭失败，返回结果：" + result + "<br>");
      }
    }
    sb.append("合计：" + recipecodelist.length + "条，成功：" + sucCount + "条；失败：" + (recipecodelist.length - sucCount) + "条");

    sb.append("<br>");
    sb.append(falseinfo.toString());
    return sb.toString();
  }

  public String upward(Long[] ids) throws Exception
  {
    try
    {
      List list = findByIds(ids);
    //  MESWSImplementService wsexinterface = new MESWSImplementService();
    //  MESWSInterface portType = wsexinterface.getMESWSImplementPort();
      StringBuffer errorBuffer = new StringBuffer();
      StringBuffer resultBuffer = new StringBuffer();
      String moveFlag = "Up";
      /*for (MixWorkOrderEdit item : list) {
        String result = portType.reciveWoMoveByMES(null, null, item.getWo_no_s(), moveFlag, 
          LLWebUtils.getUser().userCode, LLWebUtils.getUser().userName);
        if (result.equals("OK"))
          resultBuffer.append(buildcommonMsg(Integer.valueOf(1), "工单：" + item.getWo_no_s() + result));
        else {
          errorBuffer.append(buildcommonMsg(Integer.valueOf(0), "工单：" + item.getWo_no_s() + result));
        }
      }*/
      return resultBuffer.toString() + "<br>" + errorBuffer.toString();
    } catch (Exception e) {
      return e.getMessage();
    }
  }

/*  public String down(Long[] ids) throws Exception
  {
    try {
      List list = findByIds(ids);
      MESWSImplementService wsexinterface = new MESWSImplementService();
      MESWSInterface portType = wsexinterface.getMESWSImplementPort();
      StringBuffer errorBuffer = new StringBuffer();
      StringBuffer resultBuffer = new StringBuffer();
      String moveFlag = "Down";
      for (MixWorkOrderEdit item : list) {
        String result = portType.reciveWoMoveByMES(null, null, item.getWo_no_s(), moveFlag, 
          LLWebUtils.getUser().userCode, LLWebUtils.getUser().userName);
        if (result.equals("OK"))
          resultBuffer.append(buildcommonMsg(Integer.valueOf(1), "工单：" + item.getWo_no_s() + result));
        else {
          errorBuffer.append(buildcommonMsg(Integer.valueOf(0), "工单：" + item.getWo_no_s() + result));
        }
      }
      return resultBuffer.toString() + "<br>" + errorBuffer.toString();
    } catch (Exception e) {
      return e.getMessage();
    }
  }*/

  public List<Map<String, Object>> getbatch(String recipecode)
  {
    SQLQuery query = createSQLQuery(getSQL("getbatch"));
    query.setParameter("recipecode", recipecode);
    return query.list();
  }

  public List<Map<String, Object>> geterpcode()
  {
    SQLQuery query = createSQLQuery(getSQL("geterpcode_s"));
    if (LLWebUtils.factory().toString().equals("2"))
      query.setParameter("erpcode_s", "9");
    else {
      query.setParameter("erpcode_s", "E");
    }
    return query.list();
  }

/*  public static String GetCurProdDate()
    throws Exception
  {
    int hh = DateUtils.getHour(new Date());
    if ((hh >= 0) && (hh < 8))
      return DateUtils.getCustomNextDateStr("yyyyMMdd", 0);
    if (hh < 16) {
      return DateUtils.getCustomNextDateStr("yyyyMMdd", 0);
    }
    return DateUtils.getCustomNextDateStr("yyyyMMdd", 1);
  }

  public static String GetCurProdShiift()
    throws Exception
  {
    int hh = DateUtils.getHour(new Date());
    if ((hh >= 0) && (hh < 8))
      return "302003";
    if (hh < 16) {
      return "302001";
    }
    return "302002";
  }
*/
/*  public String set(String[] ids)
    throws Exception
  {
    StringBuffer sb = new StringBuffer();
    String recipecode = "";
    String operateFlag = "";
    StringBuffer falseinfo = new StringBuffer();
    recipecode = ids[0];
    if (ids[3].toString().equals("set"))
      operateFlag = "Set";
    else if (ids[3].toString().equals("check")) {
      operateFlag = "Check";
    }
    MESWSImplementService wsexinterface = new MESWSImplementService();
    MESWSInterface portType = wsexinterface.getMESWSImplementPort();
    String result = "False";

    result = portType
      .reciveMixerMasterByMES(null, null, operateFlag, 
      GetCurProdDate().toString(), GetCurProdShiift().toString(), recipecode, ids[1], ids[2], 
      LLWebUtils.getUser().userCode, LLWebUtils.getUser().userName);
    if (result.equals("OK"))
      falseinfo.append("机台" + recipecode + result);
    else {
      falseinfo.append("机台" + recipecode + "设置失败，返回结果：" + result);
    }
    sb.append("<br>");
    sb.append(falseinfo.toString());
    return sb.toString();
  }*/
}