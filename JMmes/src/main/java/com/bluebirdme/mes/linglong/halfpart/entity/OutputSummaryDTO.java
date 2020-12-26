package com.bluebirdme.mes.linglong.halfpart.entity;

import java.util.List;

public class OutputSummaryDTO extends OutputSummary{
    
    private List<OutputSummary> inserted;
    private List<OutputSummary> deleted;
    private List<OutputSummary> updated;
    public List<OutputSummary> getInserted() {
        return inserted;
    }
    public void setInserted(List<OutputSummary> inserted) {
        this.inserted = inserted;
    }
    public List<OutputSummary> getDeleted() {
        return deleted;
    }
    public void setDeleted(List<OutputSummary> deleted) {
        this.deleted = deleted;
    }
    public List<OutputSummary> getUpdated() {
        return updated;
    }
    public void setUpdated(List<OutputSummary> updated) {
        this.updated = updated;
    }
    
    
    
}
