package com.alignsolution.siamsmilemobileapplication.Biz;

/**
 * Created by aligndev on 18-May-17.
 */

public class ProductItem {

    private String RowId;
    private String ProductItemNo;
    private String ProductItemName;
    private String ProductNo;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;

    public String getRowId() {
        return RowId;
    }
    public String getProductItemNo(){
        return  ProductItemNo;
    }
    public String getProductItemName(){
        return  ProductItemName;
    }
    public String getProductNo(){
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
    public void setProductItemNo(String productItemNo){
        this.ProductItemNo = productItemNo;
    }
    public void  setProductItemName(String productItemName){
        this.ProductItemName = productItemName;
    }
    public void  setProductNo(String productNo){
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
