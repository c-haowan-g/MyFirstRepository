/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.QualityInformation;

/**
 * 质量汇总信息
 * @author 司乔靖
 * @Date 2019-02-10 13:58:38
 */
public class QualityInformationDTO extends QualityInformation{
    
    private List<QualityInformation> inserted;
    private List<QualityInformation> deleted;
    private List<QualityInformation> updated;
    public List<QualityInformation> getInserted() {
        return inserted;
    }
    public void setInserted(List<QualityInformation> inserted) {
        this.inserted = inserted;
    }
    public List<QualityInformation> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<QualityInformation> deleted) {
        this.deleted = deleted;
    }
    public List<QualityInformation> getUpdated() {
        return updated;
    }
    public void setUpdated(List<QualityInformation> updated) {
        this.updated = updated;
    }
    
    
    
}
