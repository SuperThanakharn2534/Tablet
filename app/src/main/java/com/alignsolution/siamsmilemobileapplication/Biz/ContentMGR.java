package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

import java.sql.RowId;
import java.util.ArrayList;

/**
 * Created by aligndev on 17-May-17.
 */

public class ContentMGR {

    public ArrayList<Content> SelectData(Context context) {
        ArrayList<Content> ContentList = new ArrayList<Content>();
        Content Content = new Content();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Content";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {

                Content.setRowId(String.valueOf(cursor.getColumnIndexOrThrow("RowId")));
                Content.setContentNo(cursor.getString(cursor.getColumnIndexOrThrow("ContentNo")));
                Content.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("Title")));
                Content.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                Content.setPicture(cursor.getString(cursor.getColumnIndexOrThrow("Picture")));
                Content.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                Content.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                Content.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                Content.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ContentList.add(Content);

            Log.i("Log","Log"+cursor.getColumnIndexOrThrow("RowId"));

            }
        }
        cursor.close();




        return  ContentList;
    }

    public boolean InsertData(Content content,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

       // Val.put("RowId",content.getRowId());
        Val.put("ContentNo",content.getContentNo());
        Val.put("Title",content.getTitle());
        Val.put("Description",content.getDescription());
        Val.put("Picture",content.getPicture());
        Val.put("CreatedOn",content.getCreatedOn());
        Val.put("ModifiedOn",content.getModifiedOn());
        Val.put("SyncDate",content.getSyncDate());
        Val.put("SyncStatus",content.getSyncStatus());

        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("Content", null,Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean UpdateData(Content content,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",content.getRowId());
        Val.put("ContentNo",content.getContentNo());
        Val.put("Title",content.getTitle());
        Val.put("Description",content.getDescription());
        Val.put("Picture",content.getPicture());
        Val.put("CreatedOn",content.getCreatedOn());
        Val.put("ModifiedOn",content.getModifiedOn());
        Val.put("SyncDate",content.getSyncDate());
        Val.put("SyncStatus",content.getSyncStatus());

        int rows ;
        Log.i("long","UpDateLong");
        rows  = db.update("Content",Val,"RowId = "+content.getRowId(),null);
        Log.i("Update","RowId = "+content.getRowId());
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean DeleteData(Content content,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",content.getRowId());
        Val.put("ContentNo",content.getContentNo());
        Val.put("Title",content.getTitle());
        Val.put("Description",content.getDescription());
        Val.put("Picture",content.getPicture());
        Val.put("CreatedOn",content.getCreatedOn());
        Val.put("ModifiedOn",content.getModifiedOn());
        Val.put("SyncDate",content.getSyncDate());
        Val.put("SyncStatus",content.getSyncStatus());

        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("content",content.getRowId(),null);
        //Log.i("Update","RowId = "+content.getRowId());
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

}
