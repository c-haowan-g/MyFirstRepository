package com.bluebirdme.mes.linglong.mix.service;

import com.bluebirdme.core.system.web.Filter;
import com.bluebirdme.core.system.web.Page;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.mix.entity.MixBatchReportAll;
//import com.bluebirdme.mes.linglong.mix.entity.dto.MixBatchReportAllDTO;
import java.math.BigDecimal;
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
public class MixBatchReportAllServiceImpl extends RockWellBaseServiceImpl<MixBatchReportAll>
{

  @Resource
  LingLongDataSource llds;

  protected Session getSession()
  {
    return this.llds.getSession();
  }

  protected Class getEntity()
  {
    return MixBatchReportAll.class;
  }

  protected boolean useCache()
  {
    return false;
  }

/*  @RockWellTransactional
  public void saveChanges(MixBatchReportAllDTO mixbatchreportall) throws Exception
  {
    if (!ListUtils.isEmpty(mixbatchreportall.getDeleted())) {
      delete(mixbatchreportall.getDeleted());
    }
    if (!ListUtils.isEmpty(mixbatchreportall.getInserted())) {
      save(mixbatchreportall.getInserted());
    }
    if (!ListUtils.isEmpty(mixbatchreportall.getUpdated()))
      update(mixbatchreportall.getUpdated());
  }*/

  public List<Map<String, Object>> getequipcodelist(String begindate, String enddate)
    throws Exception
  {
    SQLQuery query = createSQLQuery(getSQL("getequipcodelist"));
    query.setParameter("begindate", begindate);
    query.setParameter("enddate", enddate);
    return query.list();
  }

  public List<Map<String, Object>> getrecipecodelist(String begindate, String enddate)
    throws Exception
  {
    SQLQuery query = createSQLQuery(getSQL("getrecipecodelist"));
    query.setParameter("begindate", begindate);
    query.setParameter("enddate", enddate);
    return query.list();
  }

  public List<Map<String, Object>> getrecipecodebycodelist(String begindate, String enddate, String equipcode)
    throws Exception
  {
    SQLQuery query = createSQLQuery(getSQL("getrecipecodebycodelist"));
    query.setParameter("begindate", begindate);
    query.setParameter("enddate", enddate);
    query.setParameter("equipcode", equipcode);

    return query.list();
  }

  public Map<String, Object> datagridclick(Filter filter, Page page, Class clazz)
    throws Exception
  {
    Map ret = new HashMap();

    ret.put("rows", datagridRowsclick(filter, page, clazz));
    filter.setOrder(null);
    filter.setSort(null);
    ret.put("total", datagridTotalclick(filter, page));

    return ret;
  }

  public Long datagridTotalclick(Filter filter, Page page) throws Exception
  {
    if (getSQL("datagrid_totalclick") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_totalclick的SQL语句定义");
    }

    String totalSql = getSQL("datagrid_totalclick", filter.getFilter());

    if (page.getTotalRows() == 0L)
    {
      SQLQuery query = getSession().createSQLQuery(totalSql);

      setParameter(query, filter);

      return Long.valueOf(((BigDecimal)query.uniqueResult()).longValue());
    }
    return Long.valueOf(page.getTotalRows());
  }

  public <K> List<K> datagridRowsclick(Filter filter, Page page, Class<K> clazz)
    throws Exception
  {
    if (getSQL("datagrid_rowsclick") == null) {
      throw new Exception(getClass() + ".xml中未找到ID为datagrid_rowsclick的SQL语句定义");
    }
    String dataSql = getSQL("datagrid_rowsclick", filter.getFilter());

    SQLQuery query = createSQLQuery(dataSql, clazz == null ? getEntity() : clazz);

    setParameter(query, filter);

    if (page.getAll() == 0) {
      query.setMaxResults(page.getRows());
      query.setFirstResult((page.getPage() - 1) * page.getRows());
    }

    return query.list();
  }
}