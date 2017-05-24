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

public class TaskMGR {


    public ArrayList<Task> SelectData(Context context) {
        ArrayList<Task> TaskList = new ArrayList<Task>();
        Task Task = new Task();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Task";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                Task.setTaskNo(cursor.getString(cursor.getColumnIndexOrThrow("TaskNo")));
                Task.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("Title")));
                Task.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                Task.setAgentNo(cursor.getString(cursor.getColumnIndexOrThrow("AgentNo")));
                Task.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                Task.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                Task.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                Task.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                TaskList.add(Task);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();




        return TaskList;
    }

    public boolean InsertData(Task task,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",task.getRowId());
        Val.put("TaskNo",task.getTaskNo());
        Val.put("Title",task.getTitle());
        Val.put("Description",task.getDescription());
        Val.put("AgentNo",task.getAgentNo());
        Val.put("CreatedOn",task.getCreatedOn());
        Val.put("ModifiedOn",task.getModifiedOn());
        Val.put("SyncDate",task.getSyncDate());
        Val.put("SyncStatus",task.getSyncStatus());



        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("Task", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean UpdateData(Task task,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",task.getRowId());
        Val.put("TaskNo",task.getTaskNo());
        Val.put("Title",task.getTitle());
        Val.put("Description",task.getDescription());
        Val.put("AgentNo",task.getAgentNo());
        Val.put("CreatedOn",task.getCreatedOn());
        Val.put("ModifiedOn",task.getModifiedOn());
        Val.put("SyncDate",task.getSyncDate());
        Val.put("SyncStatus",task.getSyncStatus());



        int rows ;
        Log.i("long","InsertLong");
        rows  = db.update("Task",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean DeleteData(Task task,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",task.getRowId());
        Val.put("TaskNo",task.getTaskNo());
        Val.put("Title",task.getTitle());
        Val.put("Description",task.getDescription());
        Val.put("AgentNo",task.getAgentNo());
        Val.put("CreatedOn",task.getCreatedOn());
        Val.put("ModifiedOn",task.getModifiedOn());
        Val.put("SyncDate",task.getSyncDate());
        Val.put("SyncStatus",task.getSyncStatus());



        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("Task",task.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }
}
