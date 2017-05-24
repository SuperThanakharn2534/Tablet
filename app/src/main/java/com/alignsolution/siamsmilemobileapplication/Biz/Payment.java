package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class Payment {

    private String RowId;
    private String PaymentNo;
    private String PaymentType;
    private String Premium;
    private String AgentNo;
    private String InvoiceNo;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;

    public String getRowId() {
        return RowId;
    }
    public String getPaymentNo() {
        return PaymentNo;
    }
    public String getPaymentType() {
        return PaymentType;
    }
    public String getPremium() {
        return Premium;
    }
    public String getAgentNo() {
        return AgentNo;
    }
    public String getInvoiceNo() {
        return InvoiceNo;
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
    public void setPaymentNo(String paymentNo) {
        this.PaymentNo = paymentNo;
    }
    public void setPaymentType(String paymentType) {
        this.PaymentType = paymentType;
    }
    public void setPremium(String premium) {
        this.Premium = premium;
    }
    public void setAgentNo(String agentNo) {
        this.AgentNo = agentNo;
    }
    public void setInvoiceNo(String invoiceNo) {
        this.InvoiceNo = invoiceNo;
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
