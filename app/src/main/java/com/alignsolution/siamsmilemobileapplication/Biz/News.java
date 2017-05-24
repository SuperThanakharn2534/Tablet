package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class News {


    private String RowId;
    private String NewsNo;
    private String URL;
    private String Title;
    private String Description;
    private String Picture;
    private String StartDate;
    private String EndDate;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;

    public String getRowId() {
        return RowId;
    }
    public String getNewsNo() {
        return  NewsNo;
    }
    public String getURL() {
        return URL;
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
    public String getStartDate(){
        return StartDate;
    }
    public String getEndDate(){
        return EndDate;
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
    public void setNewsNo(String newsNo) {
        this.NewsNo = newsNo;
    }
    public void setURL(String url) {
        this.URL = url;
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
    public void setStartDate(String startDate){
        this.StartDate = startDate;
    }
    public void setEndDate(String endDate){
        this.EndDate = endDate;
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
