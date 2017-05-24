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

public class PolicyMGR {

    public ArrayList<Policy> SelectData(Context context) {
        ArrayList<Policy> PolicyList = new ArrayList<Policy>();
        Policy Policy = new Policy();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Policy";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {

                Policy.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                Policy.setAppId(cursor.getString(cursor.getColumnIndexOrThrow("AppId")));
                Policy.setPolicyStatus (cursor.getString(cursor.getColumnIndexOrThrow("PolicyStatus")));
                Policy.setStatus (cursor.getString(cursor.getColumnIndexOrThrow("Status")));
                Policy.setPlan(cursor.getString(cursor.getColumnIndexOrThrow("Plan")));
                Policy.setStartDate(cursor.getString(cursor.getColumnIndexOrThrow("StartDate")));
                Policy.setEndDate(cursor.getString(cursor.getColumnIndexOrThrow("EndDate")));
                Policy.setUserId(cursor.getString(cursor.getColumnIndexOrThrow("UserId")));
                Policy.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow("FirstName")));
                Policy.setLastName(cursor.getString(cursor.getColumnIndexOrThrow("LastName")));
                Policy.setMobileNo(cursor.getString(cursor.getColumnIndexOrThrow("MobileNo")));
                Policy.setProvince(cursor.getString(cursor.getColumnIndexOrThrow("Province")));
                Policy.setCardNo(cursor.getString(cursor.getColumnIndexOrThrow("CardNo")));
                Policy.setPolicyCardNo(cursor.getString(cursor.getColumnIndexOrThrow("PolicyCardNo")));
                Policy.setPayer(cursor.getString(cursor.getColumnIndexOrThrow("Payer")));
                Policy.setBirthDate(cursor.getString(cursor.getColumnIndexOrThrow("BirthDate")));
                Policy.setAge(cursor.getString(cursor.getColumnIndexOrThrow("Age")));
                Policy.setAgeOnInsure(cursor.getString(cursor.getColumnIndexOrThrow("AgeOnInsure")));
                Policy.setAgeInsure(cursor.getString(cursor.getColumnIndexOrThrow("AgeInsure")));
                Policy.setAgentNo(cursor.getString(cursor.getColumnIndexOrThrow("AgentNo")));
                Policy.setAgentName(cursor.getString(cursor.getColumnIndexOrThrow("AgentName")));
                Policy.setBranch(cursor.getString(cursor.getColumnIndexOrThrow("Branch")));
                Policy.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                Policy.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                Policy.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                Policy.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                PolicyList.add(Policy);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();


        return PolicyList;
    }

    public boolean InsertData(Policy policy,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",policy.getRowId());
        Val.put("AppId",policy.getAppId());
        Val.put("PolicyStatus",policy.getCliamNo());
        Val.put("Status",policy.getStatus());
        Val.put("Company",policy.getCompany());
        Val.put("Plan",policy.getPlan());
        Val.put("StartDate",policy.getStartDate());
        Val.put("EndDate",policy.getEndDate());
        Val.put("UserId",policy.getUserId());
        Val.put("FirstName",policy.getFirstName());
        Val.put("LastName",policy.getLastName());
        Val.put("MobileNo",policy.getMobileNo());
        Val.put("Province",policy.getProvince());
        Val.put("CardNo",policy.getCardNo());
        Val.put("PolicyCardNo",policy.getPolicyCardNo());
        Val.put("Payer",policy.getPayer());
        Val.put("BirthDate",policy.getBirthDate());
        Val.put("Age",policy.getAge());
        Val.put("AgeOnInsure",policy.getAgeOnInsure());
        Val.put("AgeInsure",policy.getAgeInsure());
        Val.put("AgentNo",policy.getAgentNo());
        Val.put("AgentName",policy.getAgentName());
        Val.put("Branch",policy.getBranch());
        Val.put("CreatedOn",policy.getCreatedOn());
        Val.put("ModifiedOn",policy.getModifiedOn());
        Val.put("SyncDate",policy.getSyncDate());
        Val.put("SyncStatus",policy.getSyncStatus());


        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("Policy", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean UpdateData(Policy policy,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",policy.getRowId());
        Val.put("AppId",policy.getAppId());
        Val.put("PolicyStatus",policy.getCliamNo());
        Val.put("Status",policy.getStatus());
        Val.put("Company",policy.getCompany());
        Val.put("Plan",policy.getPlan());
        Val.put("StartDate",policy.getStartDate());
        Val.put("EndDate",policy.getEndDate());
        Val.put("UserId",policy.getUserId());
        Val.put("FirstName",policy.getFirstName());
        Val.put("LastName",policy.getLastName());
        Val.put("MobileNo",policy.getMobileNo());
        Val.put("Province",policy.getProvince());
        Val.put("CardNo",policy.getCardNo());
        Val.put("PolicyCardNo",policy.getPolicyCardNo());
        Val.put("Payer",policy.getPayer());
        Val.put("BirthDate",policy.getBirthDate());
        Val.put("Age",policy.getAge());
        Val.put("AgeOnInsure",policy.getAgeOnInsure());
        Val.put("AgeInsure",policy.getAgeInsure());
        Val.put("AgentNo",policy.getAgentNo());
        Val.put("AgentName",policy.getAgentName());
        Val.put("Branch",policy.getBranch());
        Val.put("CreatedOn",policy.getCreatedOn());
        Val.put("ModifiedOn",policy.getModifiedOn());
        Val.put("SyncDate",policy.getSyncDate());
        Val.put("SyncStatus",policy.getSyncStatus());


        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("Policy",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean DeleteData(Policy policy,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",policy.getRowId());
        Val.put("AppId",policy.getAppId());
        Val.put("PolicyStatus",policy.getCliamNo());
        Val.put("Status",policy.getStatus());
        Val.put("Company",policy.getCompany());
        Val.put("Plan",policy.getPlan());
        Val.put("StartDate",policy.getStartDate());
        Val.put("EndDate",policy.getEndDate());
        Val.put("UserId",policy.getUserId());
        Val.put("FirstName",policy.getFirstName());
        Val.put("LastName",policy.getLastName());
        Val.put("MobileNo",policy.getMobileNo());
        Val.put("Province",policy.getProvince());
        Val.put("CardNo",policy.getCardNo());
        Val.put("PolicyCardNo",policy.getPolicyCardNo());
        Val.put("Payer",policy.getPayer());
        Val.put("BirthDate",policy.getBirthDate());
        Val.put("Age",policy.getAge());
        Val.put("AgeOnInsure",policy.getAgeOnInsure());
        Val.put("AgeInsure",policy.getAgeInsure());
        Val.put("AgentNo",policy.getAgentNo());
        Val.put("AgentName",policy.getAgentName());
        Val.put("Branch",policy.getBranch());
        Val.put("CreatedOn",policy.getCreatedOn());
        Val.put("ModifiedOn",policy.getModifiedOn());
        Val.put("SyncDate",policy.getSyncDate());
        Val.put("SyncStatus",policy.getSyncStatus());


        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("Policy",policy.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }


    }
