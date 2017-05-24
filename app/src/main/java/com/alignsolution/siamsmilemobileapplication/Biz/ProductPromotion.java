package com.alignsolution.siamsmilemobileapplication.Biz;

import javax.sql.StatementEvent;

/**
 * Created by aligndev on 06-May-17.
 */

public class ProductPromotion {

    private String RowId;
    private String ProductNo;
    private String ProductName;
    private String ProductItem;
    private String Description;
    private String ProductType;
    private String Benefit;
    private String BirthDate;
    private String CardNo;
    private String CreatedOn;
    private String ModifiedOn;
    private String SyncDate;
    private String SyncStatus;


    public String getRowId() {
        return RowId;
    }
    public String getProductNo() {
        return ProductNo;
    }
    public String getProductName() {
        return ProductName;
    }
    public String getProductType() {
        return ProductType;
    }
    public String getProductItem(){
        return  ProductItem;
    }
    public String getDescription() {
        return Description;
    }
    public String getBenefit() {
        return Benefit;
    }
    public String getBirthDate(){
        return  BirthDate;
    }
    public String getCardNo(){
        return  CardNo;
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
    public void setProductNo(String productNo) {
        this.ProductNo = productNo;
    }
    public void setProductName(String productName) {
        this.ProductName = productName;
    }
    public void setProductType(String productType) {
        this.ProductType = productType;
    }
    public void setProductItem(String productItem){
        this.ProductItem =productItem;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
    public void setBenefit(String benefit) {
        this.Benefit = benefit;
    }
    public void setBirthDate(String birthDate){
        this.BirthDate = birthDate;
    }
    public void setCardNo(String cardNo){
        this.CardNo = cardNo;
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
