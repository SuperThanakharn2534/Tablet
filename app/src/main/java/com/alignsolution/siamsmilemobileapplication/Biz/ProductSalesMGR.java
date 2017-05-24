package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

import java.util.ArrayList;

/**
 * Created by aligndev on 17-May-17.
 */

public class ProductSalesMGR {

    public ArrayList<ProductSales> SelectData(Context context) {
        ArrayList<ProductSales> ProductSalesList = new ArrayList<ProductSales>();
        ProductSales ProductSales = new ProductSales();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  ProductSales";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                ProductSales.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                ProductSales.setProductSalesNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductSalesNo")));
                ProductSales.setAppId(cursor.getString(cursor.getColumnIndexOrThrow("AppId")));
                ProductSales.setProductNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductNo")));
                ProductSales.setPolicyMonth(cursor.getString(cursor.getColumnIndexOrThrow("PolicyMonth")));
                ProductSales.setPolicyYear(cursor.getString(cursor.getColumnIndexOrThrow("PolicyYear")));
                ProductSales.setScreenDate(cursor.getString(cursor.getColumnIndexOrThrow("ScreenDate")));
                ProductSales.setRelationCustomer(cursor.getString(cursor.getColumnIndexOrThrow("RelationCustomer")));
                ProductSales.setCardNo(cursor.getString(cursor.getColumnIndexOrThrow("CardNo")));
                ProductSales.setCustmerName(cursor.getString(cursor.getColumnIndexOrThrow("CustmerName")));
                ProductSales.setCareer(cursor.getString(cursor.getColumnIndexOrThrow("Career")));
                ProductSales.setCareerLavel(cursor.getString(cursor.getColumnIndexOrThrow("CareerLavel")));
                ProductSales.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("Email")));
                ProductSales.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("Address")));
                ProductSales.setPaymentType(cursor.getString(cursor.getColumnIndexOrThrow("PaymentType")));
                ProductSales.setPremium(cursor.getString(cursor.getColumnIndexOrThrow("Premium")));
                ProductSales.setAgentNo(cursor.getString(cursor.getColumnIndexOrThrow("AgentNo")));
                ProductSales.setInvoiceNo(cursor.getString(cursor.getColumnIndexOrThrow("InvoiceNo")));
                ProductSales.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                ProductSales.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                ProductSales.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                ProductSales.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ProductSalesList.add(ProductSales);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();




        return ProductSalesList;

    }

    public boolean InsertData(ProductSales productSales,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();


        Val.put("RowId",productSales.getRowId());
        Val.put("ProductSalesNo",productSales.getProductSalesNo());
        Val.put("AppId",productSales.getAppId());
        Val.put("ProductNo",productSales.getProductNo());
        Val.put("PolicyMonth",productSales.getPolicyMonth());
        Val.put("PolicyYear",productSales.getPolicyYear());
        Val.put("ScreenDate",productSales.getScreenDate());
        Val.put("RelationCustomer",productSales.getRelationCustomer());
        Val.put("CardNo",productSales.getCardNo());
        Val.put("CustmerName",productSales.getCustmerName());
        Val.put("Career",productSales.getCareer());
        Val.put("CareerLavel",productSales.getCareerLavel());
        Val.put("PhoneNumber",productSales.getPhoneNumber());
        Val.put("Email",productSales.getEmail());
        Val.put("Address",productSales.getAddress());
        Val.put("PaymentType",productSales.getPaymentType());
        Val.put("Premium",productSales.getPremium());
        Val.put("AgentNo",productSales.getAgentNo());
        Val.put("InvoiceNo",productSales.getInvoiceNo());
        Val.put("CreatedOn",productSales.getCreatedOn());
        Val.put("ModifiedOn",productSales.getModifiedOn());
        Val.put("SyncDate",productSales.getSyncDate());
        Val.put("SyncStatus",productSales.getSyncStatus());



        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("ProductSales", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean UpdateData(ProductSales productSales,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();


        //Val.put("RowId",productSales.getRowId());
        Val.put("ProductSalesNo",productSales.getProductSalesNo());
        Val.put("AppId",productSales.getAppId());
        Val.put("ProductNo",productSales.getProductNo());
        Val.put("PolicyMonth",productSales.getPolicyMonth());
        Val.put("PolicyYear",productSales.getPolicyYear());
        Val.put("ScreenDate",productSales.getScreenDate());
        Val.put("RelationCustomer",productSales.getRelationCustomer());
        Val.put("CardNo",productSales.getCardNo());
        Val.put("CustmerName",productSales.getCustmerName());
        Val.put("Career",productSales.getCareer());
        Val.put("CareerLavel",productSales.getCareerLavel());
        Val.put("PhoneNumber",productSales.getPhoneNumber());
        Val.put("Email",productSales.getEmail());
        Val.put("Address",productSales.getAddress());
        Val.put("PaymentType",productSales.getPaymentType());
        Val.put("Premium",productSales.getPremium());
        Val.put("AgentNo",productSales.getAgentNo());
        Val.put("InvoiceNo",productSales.getInvoiceNo());
        Val.put("CreatedOn",productSales.getCreatedOn());
        Val.put("ModifiedOn",productSales.getModifiedOn());
        Val.put("SyncDate",productSales.getSyncDate());
        Val.put("SyncStatus",productSales.getSyncStatus());



        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("ProductSales",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }
    public boolean DeleteData(ProductSales productSales,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();


        //Val.put("RowId",productSales.getRowId());
        Val.put("ProductSalesNo",productSales.getProductSalesNo());
        Val.put("AppId",productSales.getAppId());
        Val.put("ProductNo",productSales.getProductNo());
        Val.put("PolicyMonth",productSales.getPolicyMonth());
        Val.put("PolicyYear",productSales.getPolicyYear());
        Val.put("ScreenDate",productSales.getScreenDate());
        Val.put("RelationCustomer",productSales.getRelationCustomer());
        Val.put("CardNo",productSales.getCardNo());
        Val.put("CustmerName",productSales.getCustmerName());
        Val.put("Career",productSales.getCareer());
        Val.put("CareerLavel",productSales.getCareerLavel());
        Val.put("PhoneNumber",productSales.getPhoneNumber());
        Val.put("Email",productSales.getEmail());
        Val.put("Address",productSales.getAddress());
        Val.put("PaymentType",productSales.getPaymentType());
        Val.put("Premium",productSales.getPremium());
        Val.put("AgentNo",productSales.getAgentNo());
        Val.put("InvoiceNo",productSales.getInvoiceNo());
        Val.put("CreatedOn",productSales.getCreatedOn());
        Val.put("ModifiedOn",productSales.getModifiedOn());
        Val.put("SyncDate",productSales.getSyncDate());
        Val.put("SyncStatus",productSales.getSyncStatus());



        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.delete("ProductSales",productSales.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }



}
