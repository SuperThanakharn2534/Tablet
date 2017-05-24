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

public class NewsMGR {

    public ArrayList<News> SelectData(Context context) {
        ArrayList<News> NewsList = new ArrayList<News>();
        News News = new News();

// Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  News";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                News.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                News.setNewsNo(cursor.getString(cursor.getColumnIndexOrThrow("NewsNo")));
                News.setURL(cursor.getString(cursor.getColumnIndexOrThrow("URL")));
                News.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("Title")));
                News.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                News.setPicture(cursor.getString(cursor.getColumnIndexOrThrow("Picture")));
                News.setStartDate(cursor.getString(cursor.getColumnIndexOrThrow("StartDate")));
                News.setEndDate(cursor.getString(cursor.getColumnIndexOrThrow("EndDate")));
                News.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                News.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                News.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                News.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                NewsList.add(News);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return NewsList;
    }


    public boolean InsertData(News news,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",news.getRowId());
        Val.put("NewsNo",news.getNewsNo());
        Val.put("URL",news.getTitle());
        Val.put("Title",news.getTitle());
        Val.put("Description",news.getDescription());
        Val.put("Picture",news.getPicture());
        Val.put("StartDate",news.getStartDate());
        Val.put("EndDate",news.getEndDate());
        Val.put("CreatedOn",news.getCreatedOn());
        Val.put("ModifiedOn",news.getModifiedOn());
        Val.put("SyncDate",news.getSyncDate());
        Val.put("SyncStatus",news.getSyncStatus());

        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("news", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean UpdateData(News news,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",news.getRowId());
        Val.put("NewsNo",news.getNewsNo());
        Val.put("URL",news.getTitle());
        Val.put("Title",news.getTitle());
        Val.put("Description",news.getDescription());
        Val.put("Picture",news.getPicture());
        Val.put("StartDate",news.getStartDate());
        Val.put("EndDate",news.getEndDate());
        Val.put("CreatedOn",news.getCreatedOn());
        Val.put("ModifiedOn",news.getModifiedOn());
        Val.put("SyncDate",news.getSyncDate());
        Val.put("SyncStatus",news.getSyncStatus());

        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("news",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean DeleteData(News news,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

       // Val.put("RowId",news.getRowId());
        Val.put("NewsNo",news.getNewsNo());
        Val.put("URL",news.getTitle());
        Val.put("Title",news.getTitle());
        Val.put("Description",news.getDescription());
        Val.put("Picture",news.getPicture());
        Val.put("StartDate",news.getStartDate());
        Val.put("EndDate",news.getEndDate());
        Val.put("CreatedOn",news.getCreatedOn());
        Val.put("ModifiedOn",news.getModifiedOn());
        Val.put("SyncDate",news.getSyncDate());
        Val.put("SyncStatus",news.getSyncStatus());

        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.delete("news",news.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }
}
