package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 06-May-17.
 */

public class ClaimDoc {



    private String RowId;
    private String AppId;
    private String ClaimNo;
    private String InvoiceTotal;
    private String InvoiceDocType;
    private String MedicalCert;
    private String MedicalCertDocType;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;


    public String getRowId() {
        return RowId;
    }
    public String getAppId() {
        return AppId;
    }
    public String getClaimNo() {
        return ClaimNo;
    }
    public String getInvoiceTotal() {
        return InvoiceTotal;
    }
    public String getInvoiceDocType() {
        return InvoiceDocType;
    }
    public String getMedicalCert() {
        return MedicalCert;
    }
    public String getMedicalCertDocType() {
        return MedicalCertDocType;
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
    public void setClaimNo(String claimNo) {
        this.ClaimNo = claimNo;
    }
    public void setInvoiceTotal(String invoiceDTotal) {
        this.InvoiceTotal = invoiceDTotal;
    }
    public void setInvoiceDocType(String invoiceDocType) {
        this.InvoiceDocType = invoiceDocType;
    }
    public void setMedicalCert(String medicalCert) {
        this.MedicalCert = medicalCert;
    }
    public void setMedicalCertDocType(String medicalCertDocType) {
        this.MedicalCertDocType = medicalCertDocType;
    }
    public void setAppId(String appId) {
        this.AppId = appId;
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
