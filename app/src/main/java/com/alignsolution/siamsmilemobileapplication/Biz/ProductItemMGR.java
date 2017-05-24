package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

import java.util.ArrayList;

/**
 * Created by aligndev on 18-May-17.
 */

public class ProductItemMGR {

    public ArrayList<ProductItem> SelectData(Context context) {
        ArrayList<ProductItem> ProductItemList = new ArrayList<ProductItem>();
        ProductItem productItem = new ProductItem();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  ProductItem";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                productItem.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                productItem.setProductItemNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductItemNo")));
                productItem.setProductItemName(cursor.getString(cursor.getColumnIndexOrThrow("ProductItemName")));
                productItem.setProductNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductNo")));
                productItem.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                productItem.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                productItem.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                productItem.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ProductItemList.add(productItem);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();



        return ProductItemList;
    }

    public boolean InsertData(ProductItem productItem,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",productItem.getRowId());
        Val.put("ProductItemNo",productItem.getProductItemNo());
        Val.put("ProductItemName",productItem.getProductItemName());
        Val.put("ProductNo",productItem.getProductNo());
        Val.put("CreatedOn",productItem.getCreatedOn());
        Val.put("ModifiedOn",productItem.getModifiedOn());
        Val.put("SyncDate",productItem.getSyncDate());
        Val.put("SyncStatus",productItem.getSyncStatus());


        long rows;
        Log.i("long", "InsertLong");
        rows = db.insert("ProductItem", null, Val);
        if (rows == -1) {
            aBoolean = false;
        }

        return aBoolean;

    }

    public boolean UpdateData(ProductItem productItem,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",productItem.getRowId());
        Val.put("ProductItemNo",productItem.getProductItemNo());
        Val.put("ProductItemName",productItem.getProductItemName());
        Val.put("ProductNo",productItem.getProductNo());
        Val.put("CreatedOn",productItem.getCreatedOn());
        Val.put("ModifiedOn",productItem.getModifiedOn());
        Val.put("SyncDate",productItem.getSyncDate());
        Val.put("SyncStatus",productItem.getSyncStatus());


        int rows;
        Log.i("long", "UpdateLong");
        rows = db.update("ProductItem",Val,null,null);
        if (rows == -1) {
            aBoolean = false;
        }

        return aBoolean;

    }

    public boolean DeleteData(ProductItem productItem,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",productItem.getRowId());
        Val.put("ProductItemNo",productItem.getProductItemNo());
        Val.put("ProductItemName",productItem.getProductItemName());
        Val.put("ProductNo",productItem.getProductNo());
        Val.put("CreatedOn",productItem.getCreatedOn());
        Val.put("ModifiedOn",productItem.getModifiedOn());
        Val.put("SyncDate",productItem.getSyncDate());
        Val.put("SyncStatus",productItem.getSyncStatus());


        int rows;
        Log.i("long", "DeleteLong");
        rows = db.delete("ProductItem",productItem.getRowId(),null);
        if (rows == -1) {
            aBoolean = false;
        }

        return aBoolean;

    }

    }
