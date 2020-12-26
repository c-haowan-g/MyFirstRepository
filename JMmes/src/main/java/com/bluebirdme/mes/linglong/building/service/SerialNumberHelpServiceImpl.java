/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.building.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.core.system.orm.sql.Where;
import com.bluebirdme.core.system.web.WebUtils;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.core.utils.LLWebUtils;
import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.util.DateUtil;
import com.bluebirdme.mes.linglong.util.RemoveDuplicate;
import com.bluebirdme.mes.linglong.building.entity.SerialNumberHelp;
import com.bluebirdme.mes.linglong.building.entity.dto.SerialNumberHelpDTO;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * Unit
 * @author 时永良
 * @Date 2019-07-12 13:12:11
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class SerialNumberHelpServiceImpl extends RockWellBaseServiceImpl<SerialNumberHelp> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return SerialNumberHelp.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public int saveChanges(SerialNumberHelpDTO serialnumberhelp) throws Exception{
		boolean ist = false;
		int num=0;
		// 页面多行同时添加时的查重判断
		List<String> addString = new ArrayList<>();
		List ruplicateList = new ArrayList<>();
        if (!ListUtils.isEmpty(serialnumberhelp.getDeleted())) {
        	num=1;
            delete(serialnumberhelp.getDeleted());
        }
        if (!ListUtils.isEmpty(serialnumberhelp.getInserted())) {
        	List<SerialNumberHelp> serialNumberHelpList=serialnumberhelp.getInserted();
        	for(int i=0;i<serialNumberHelpList.size();i++){
        		//创建人
        		serialNumberHelpList.get(i).setCreateby_s(WebUtils.getUser().userCode);
        		//计数
        		serialNumberHelpList.get(i).setSerialnumber_i(1);
        		// 与数据库数据对查重判断
				Where where = new Where();
				where.andEqual("flag_s", serialNumberHelpList.get(i).getFlag_s());
				List<Map<String, Object>> list = findMapByWhere(where);
				if(list.size()!=0){
					ist=true;
				}
				addString.add(serialNumberHelpList.get(i).getFlag_s());
				ruplicateList.add(serialNumberHelpList.get(i).getFlag_s());
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		ist = true;
        	}
        	if (ist == false) {
        		num=1;
        		save(serialnumberhelp.getInserted());
        	}
        }
        if (!ListUtils.isEmpty(serialnumberhelp.getUpdated())) {
        	List<SerialNumberHelp> serialNumberHelpList=serialnumberhelp.getInserted();
        	for(int i=0;i<serialNumberHelpList.size();i++){
        		//修改人
        		serialNumberHelpList.get(i).setChangeby_s(WebUtils.getUser().userCode);
        		//计数
        		serialNumberHelpList.get(i).setSerialnumber_i(1);
        		// 与数据库数据对查重判断
    			Where where = new Where();
    			where.andEqual("flag_s", serialNumberHelpList.get(i).getFlag_s());
    			List<Map<String, Object>> list = findMapByWhere(where);
    			if(list.size()!=0){
    				ist=true;
    			}
    			addString.add(serialNumberHelpList.get(i).getFlag_s());
				ruplicateList.add(serialNumberHelpList.get(i).getFlag_s());
        	}
        	// 集合去重
        	RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        	// 去重之后的集合
        	if (addString.size() != 1) {
        		ruplicateList = removeDuplicate.removeDuplicate(ruplicateList);
        	}
        	if (addString.size() != ruplicateList.size()) {
        		ist = true;
        	}
        	// 页面输入与数据库的查重
        	if (ist == false) {
        		num=1;
        		update(serialnumberhelp.getUpdated());
        	} 
        }
    return num;
    }

}
