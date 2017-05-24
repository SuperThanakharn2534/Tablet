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

public class ComplainMGR {

    public ArrayList<Complain> SelectData(Context context) {
        ArrayList<Complain> ComplainList = new ArrayList<Complain>();
        Complain Complain = new Complain();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Complain";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {

                Complain.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                Complain.setComplainNo(cursor.getString(cursor.getColumnIndexOrThrow("ComplainNo")));
                Complain.setComplainType(cursor.getString(cursor.getColumnIndexOrThrow("ComplainType")));
                Complain.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                Complain.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                Complain.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                Complain.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                Complain.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ComplainList.add(Complain);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();



        return  ComplainList;
    }

    public boolean InsertData(Complain complain,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();
        Val.put("RowId",complain.getRowId());
        Val.put("ComplainNo",complain.getComplainNo());
        Val.put("ComplainType",complain.getComplainType());
        Val.put("Description ",complain.getDescription());
        Val.put("CreatedOn ",complain.getCreatedOn());
        Val.put("ModifiedOn   ",complain.getModifiedOn());
        Val.put("SyncDate  ",complain.getSyncDate());
        Val.put("SyncStatus ",complain.getSyncStatus());


        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("complain", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean UpdateData(Complain complain,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

       // Val.put("RowId",complain.getRowId());
        Val.put("ComplainNo",complain.getComplainNo());
        Val.put("ComplainType",complain.getComplainType());
        Val.put("Description",complain.getDescription());
        Val.put("CreatedOn",complain.getCreatedOn());
        Val.put("ModifiedOn",complain.getModifiedOn());
        Val.put("SyncDate",complain.getSyncDate());
        Val.put("SyncStatus",complain.getSyncStatus());


        int rows ;
        Log.i("long","UpDateLong");
        rows  = db.update("complain",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean DeleteData(Complain complain,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        // Val.put("RowId",complain.getRowId());
        Val.put("ComplainNo",complain.getComplainNo());
        Val.put("ComplainType",complain.getComplainType());
        Val.put("Description",complain.getDescription());
        Val.put("CreatedOn",complain.getCreatedOn());
        Val.put("ModifiedOn",complain.getModifiedOn());
        Val.put("SyncDate",complain.getSyncDate());
        Val.put("SyncStatus",complain.getSyncStatus());


        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("Complain",complain.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }
}
