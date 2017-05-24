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

public class ProductContactMGR {

    public ArrayList<ProductContact> SelectData(Context context) {
        ArrayList<ProductContact> ProductContactList = new ArrayList<ProductContact>();
        ProductContact ProductContact = new ProductContact();


        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  ProductContact";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                ProductContact.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                ProductContact.setUserId(cursor.getString(cursor.getColumnIndexOrThrow("UserId")));
                ProductContact.setAgentCallDate(cursor.getString(cursor.getColumnIndexOrThrow("AgentCallDate")));
                ProductContact.setPhoneNumber(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber")));
                ProductContact.setProductNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductNo")));
                ProductContact.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                ProductContact.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                ProductContact.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                ProductContact.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ProductContactList.add(ProductContact);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();






        return ProductContactList;
    }

    public boolean InsertData(ProductContact productContact,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();
        Val.put("RowId",productContact.getRowId());
        Val.put("UserId",productContact.getUserID());
        Val.put("AgentCallDate",productContact.getAgentCallDate());
        Val.put("PhoneNumber",productContact.getPhoneNumber());
        Val.put("ProductNo",productContact.getProductNo());
        Val.put("CreatedOn",productContact.getCreatedOn());
        Val.put("ModifiedOn",productContact.getModifiedOn());
        Val.put("SyncDate",productContact.getSyncDate());
        Val.put("SyncStatus",productContact.getSyncStatus());




        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("ProductContact", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean UpdateData(ProductContact productContact,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();
        Val.put("RowId",productContact.getRowId());
        Val.put("UserId",productContact.getUserID());
        Val.put("AgentCallDate",productContact.getAgentCallDate());
        Val.put("PhoneNumber",productContact.getPhoneNumber());
        Val.put("ProductNo",productContact.getProductNo());
        Val.put("CreatedOn",productContact.getCreatedOn());
        Val.put("ModifiedOn",productContact.getModifiedOn());
        Val.put("SyncDate",productContact.getSyncDate());
        Val.put("SyncStatus",productContact.getSyncStatus());




        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("ProductContact",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean DeleteData(ProductContact productContact,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();
        Val.put("RowId",productContact.getRowId());
        Val.put("UserId",productContact.getUserID());
        Val.put("AgentCallDate",productContact.getAgentCallDate());
        Val.put("PhoneNumber",productContact.getPhoneNumber());
        Val.put("ProductNo",productContact.getProductNo());
        Val.put("CreatedOn",productContact.getCreatedOn());
        Val.put("ModifiedOn",productContact.getModifiedOn());
        Val.put("SyncDate",productContact.getSyncDate());
        Val.put("SyncStatus",productContact.getSyncStatus());




        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("ProductContact",productContact.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    }
