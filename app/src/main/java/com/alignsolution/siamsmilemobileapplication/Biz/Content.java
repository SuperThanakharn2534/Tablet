package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class Content {


    private String RowId;
    private String ContentNo;
    private String Title;
    private String Description;
    private String Picture;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;


    public String getRowId() {
        return RowId;
    }
    public String getContentNo() {
        return ContentNo;
    }
    public String getTitle() {
        return Title;
    }
    public String getDescription() {
        return Description;
    }
    public String getPicture() {
        return Picture;
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
    public void setContentNo(String contentNo) {
        this.ContentNo = contentNo;
    }
    public void setTitle(String title) {
        this.Title = title;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
    public void setPicture(String picture) {
        this.Picture = picture;
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
