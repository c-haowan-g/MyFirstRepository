/**
 * 信息化智能制造处
 * 山东玲珑轮胎股份有限公司
 * 2019版权所有
 */
package com.bluebirdme.mes.linglong.mix.export;

import com.bluebirdme.core.system.excel.ExcelContent;
import com.bluebirdme.core.system.excel.ExcelImportHandler;
import com.bluebirdme.core.system.excel.ImportErrorMessage;

import java.util.List;

import com.bluebirdme.core.common.entity.User;
import com.bluebirdme.core.common.service.UserServiceImpl;
import com.bluebirdme.core.system.spring.SpringContext;

import com.bluebirdme.mes.linglong.mix.entity.MixRfridScanningrate;

import com.bluebirdme.mes.linglong.mix.service.MixRfridScanningrateServiceImpl;
/**
 * 导入处理器
 * @author Goofy
 * @Date 2018年8月7日 下午3:11:33
 */
public class MixRfridScanningrateImportHandler extends ExcelImportHandler {

    @Override
    public List<ImportErrorMessage> validate(ExcelContent content) {
        return null;
    }

    @Override
    public void toDB(ExcelContent content) throws Exception {
        List<MixRfridScanningrate> list=convertToEntityList(MixRfridScanningrate.class, content, null);
        MixRfridScanningrateServiceImpl mixrfridscanningrateSrv=(MixRfridScanningrateServiceImpl)SpringContext.getBean("mixrfridscanningrateServiceImpl");
        mixrfridscanningrateSrv.save(list);
    }

}

