package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class ProductContact {

    private String RowId;
    private String UserId;
    private String AgentCallDate;
    private String PhoneNumber;
    private String ProductNo;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;

    public String getRowId() {
        return RowId;
    }
    public String getUserID() {
        return UserId;
    }
    public String getAgentCallDate() {
        return AgentCallDate;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getProductNo() {
        return ProductNo;
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
    public void setUserId(String userId) {
        this.UserId = userId;
    }
    public void setAgentCallDate(String agentCallDate) {
        this.AgentCallDate = agentCallDate;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }
    public void setProductNo(String productNo) {
        this.ProductNo = productNo;
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
