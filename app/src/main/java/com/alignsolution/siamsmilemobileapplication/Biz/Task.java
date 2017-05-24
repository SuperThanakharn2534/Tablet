package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class Task {


    private String RowId;
    private String TaskNo;
    private String Title;
    private String Description;
    private String AgentNo;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;

    public String getRowId() {
        return RowId;
    }
    public String getTaskNo() {
        return TaskNo;
    }
    public String getTitle() {
        return Title;
    }
    public String getDescription() {
        return Description;
    }
    public String getAgentNo() {
        return AgentNo;
    }
    public String getCreatedOn() {
        return CreatedOn;
    }
    public String getModifiedOn() {
        return ModifiedOn;
    }
    public String getSyncDate() {
        return SyncDate;
    }
    public String getSyncStatus() {
        return SyncStatus;
    }



    public void setRowId(String rowId) {
        this.RowId = rowId;
    }
    public void setTaskNo(String taskNo) {
        this.TaskNo = taskNo;
    }
    public void setTitle(String title) {
        this.Title = title;
    }
    public void setDescription(String description) {
        this.Description =  description;
    }
    public void setAgentNo(String agentNo) {
        this.AgentNo = agentNo;
    }
    public void setCreatedOn(String createdOn) {
        this.CreatedOn = createdOn;
    }
    public void setModifiedOn(String modifiedOn) {
        this.ModifiedOn = modifiedOn;
    }
    public void setSyncDate(String syncDate) {
        this.SyncDate = syncDate;
    }
    public void setSyncStatus(String syncStatus) {
        this.SyncStatus = syncStatus;
    }



}
