/**
 * 上海蓝鸟集团
 * 上海蓝鸟科技股份有限公司
 * 2018版权所有
 */
package com.bluebirdme.mes.linglong.finalcheck.entity.dto;

import java.util.List;
import com.bluebirdme.mes.linglong.finalcheck.entity.RecipeJudgeLog;

/**
 * 质检配方判定标准表-全钢
 * @author 刘程明
 * @Date 2018-12-06 11:37:48
 */
public class RecipeJudgeLogDTO extends RecipeJudgeLog{
    
    private List<RecipeJudgeLog> inserted;
    private List<RecipeJudgeLog> deleted;
    private List<RecipeJudgeLog> updated;
    public List<RecipeJudgeLog> getInserted() {
        return inserted;
    }
    public void setInserted(List<RecipeJudgeLog> inserted) {
        this.inserted = inserted;
    }
    public List<RecipeJudgeLog> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<RecipeJudgeLog> deleted) {
        this.deleted = deleted;
    }
    public List<RecipeJudgeLog> getUpdated() {
        return updated;
    }
    public void setUpdated(List<RecipeJudgeLog> updated) {
        this.updated = updated;
    }
    
    
    
}
