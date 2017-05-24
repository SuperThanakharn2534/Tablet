package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class Complain {

    private String RowId;
    private String ComplainNo;
    private String ComplainType;
    private String Description;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;



    public String getRowId() {
        return RowId;
    }
    public String getComplainNo() {
        return ComplainNo;
    }
    public String getComplainType() {
        return ComplainType;
    }
    public String getDescription() {
        return Description;
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
    public void setComplainNo(String createdOn) {
        this.ComplainNo = createdOn;
    }
    public void setComplainType(String complainType) {
        this.ComplainType = complainType;
    }
    public void setDescription(String description) {
        this.Description = description;
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
