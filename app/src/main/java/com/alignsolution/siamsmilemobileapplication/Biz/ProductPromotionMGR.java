package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

import java.util.ArrayList;

/**
 * Created by aligndev on 08-May-17.
 */

public class ProductPromotionMGR  {
    private SQLiteDatabase database;

        public ArrayList<ProductPromotion> SelectData(Context context) {
            ArrayList<ProductPromotion> ProductPromotionList = new ArrayList<ProductPromotion>();
            ProductPromotion oProductPromotion = new ProductPromotion();


        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  ProductPromotion";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                oProductPromotion.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                oProductPromotion.setProductNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductNo")));
                oProductPromotion.setProductName(cursor.getString(cursor.getColumnIndexOrThrow("ProductName")));
                oProductPromotion.setProductType(cursor.getString(cursor.getColumnIndexOrThrow("ProductType")));
                oProductPromotion.setProductItem(cursor.getString(cursor.getColumnIndexOrThrow("ProductItem")));
                oProductPromotion.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                oProductPromotion.setBenefit(cursor.getString(cursor.getColumnIndexOrThrow("Benefit")));
                oProductPromotion.setBirthDate(cursor.getString(cursor.getColumnIndexOrThrow("BirthDate")));
                oProductPromotion.setCardNo(cursor.getString(cursor.getColumnIndexOrThrow("CardNo")));
                oProductPromotion.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                oProductPromotion.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                oProductPromotion.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                oProductPromotion.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ProductPromotionList.add(oProductPromotion);


                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return ProductPromotionList;
    }

        public boolean InsertData(ProductPromotion productPromotion,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        Val.put("RowId",  productPromotion.getRowId());
        Val.put("ProductNo",  productPromotion.getProductNo());
        Val.put("ProductName",productPromotion.getProductName().toString());
        Val.put("ProductType",productPromotion.getProductType());
        Val.put("ProductItem",productPromotion.getProductItem());
        Val.put("Description",productPromotion.getDescription());
        Val.put("Benefit",    productPromotion.getBenefit());
        Val.put("CardNo",productPromotion.getCardNo());
        Val.put("BirthDate",productPromotion.getBirthDate());
        Val.put("CreatedOn",productPromotion.getCreatedOn());
        Val.put("ModifiedOn",productPromotion.getModifiedOn());
        Val.put("SyncDate",productPromotion.getSyncDate());
        Val.put("SyncStatus",productPromotion.getSyncStatus());

        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("ProductPromotion", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }



        return  aBoolean;
    }

        public boolean UpdateData(ProductPromotion productPromotion,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        //Val.put("RowId",  productPromotion.getRowId());
        Val.put("ProductNo",  productPromotion.getProductNo());
        Val.put("ProductName",productPromotion.getProductName().toString());
        Val.put("ProductType",productPromotion.getProductType());
        Val.put("ProductItem",productPromotion.getProductItem());
        Val.put("Description",productPromotion.getDescription());
        Val.put("Benefit",    productPromotion.getBenefit());
        Val.put("CardNo",productPromotion.getCardNo());
        Val.put("BirthDate",productPromotion.getBirthDate());
        Val.put("CreatedOn",productPromotion.getCreatedOn());
        Val.put("ModifiedOn",productPromotion.getModifiedOn());
        Val.put("SyncDate",productPromotion.getSyncDate());
        Val.put("SyncStatus",productPromotion.getSyncStatus());

        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("ProductPromotion",Val,productPromotion.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }



        return  aBoolean;
    }

        public boolean DeleteData(ProductPromotion productPromotion,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        //Val.put("RowId",  productPromotion.getRowId());
        Val.put("ProductNo",  productPromotion.getProductNo());
        Val.put("ProductName",productPromotion.getProductName());
        Val.put("ProductType",productPromotion.getProductType());
        Val.put("ProductItem",productPromotion.getProductItem());
        Val.put("Description",productPromotion.getDescription());
        Val.put("Benefit",    productPromotion.getBenefit());
        Val.put("CardNo",productPromotion.getCardNo());
        Val.put("BirthDate",productPromotion.getBirthDate());
        Val.put("CreatedOn",productPromotion.getCreatedOn());
        Val.put("ModifiedOn",productPromotion.getModifiedOn());
        Val.put("SyncDate",productPromotion.getSyncDate());
        Val.put("SyncStatus",productPromotion.getSyncStatus());

        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("ProductPromotion",productPromotion.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }



        return  aBoolean;
    }





    }
