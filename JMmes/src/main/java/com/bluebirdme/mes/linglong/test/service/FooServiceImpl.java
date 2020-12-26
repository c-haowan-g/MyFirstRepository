/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.test.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebirdme.mes.linglong.core.LingLongDataSource;
import com.bluebirdme.mes.linglong.core.RockWellBaseServiceImpl;
import com.bluebirdme.mes.linglong.core.rockwell.RockWellTransactional;
import com.bluebirdme.mes.linglong.test.entity.Foo;
import com.bluebirdme.mes.linglong.test.entity.dto.FooDTO;

import org.xdemo.app.xutils.j2se.ListUtils;

/**
 * FFFF
 * @author 高飞
 * @Date 2018-08-23 14:27:23
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class FooServiceImpl extends RockWellBaseServiceImpl<Foo> {

    @Resource LingLongDataSource llds;
    
    @Override
    protected Session getSession() {
        return llds.getSession();
    }

    @Override
    protected Class getEntity() {
        return Foo.class;
    }

    @Override
    protected boolean useCache() {
        return false;
    }
    
    @RockWellTransactional
    public void saveChanges(FooDTO foo) throws Exception{
        
        if (!ListUtils.isEmpty(foo.getDeleted())) {
            delete(foo.getDeleted());
        }
        if (!ListUtils.isEmpty(foo.getInserted())) {
            save(foo.getInserted());
        }
        if (!ListUtils.isEmpty(foo.getUpdated())) {
            update(foo.getUpdated());
        }
    
    }

}
