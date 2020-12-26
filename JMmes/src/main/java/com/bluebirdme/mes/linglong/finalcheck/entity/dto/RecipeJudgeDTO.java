/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeJudge;

/**
 * 质检动平衡检测标准表-全钢
 * @author 刘程明
 * @Date 2018-12-05 10:52:49
 */
public class RecipeJudgeDTO extends RecipeJudge{
    
    private List<RecipeJudge> inserted;
    private List<RecipeJudge> deleted;
    private List<RecipeJudge> updated;
    public List<RecipeJudge> getInserted() {
        return inserted;
    }
    public void setInserted(List<RecipeJudge> inserted) {
        this.inserted = inserted;
    }
    public List<RecipeJudge> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<RecipeJudge> deleted) {
        this.deleted = deleted;
    }
    public List<RecipeJudge> getUpdated() {
        return updated;
    }
    public void setUpdated(List<RecipeJudge> updated) {
        this.updated = updated;
    }
    
    
    
}
