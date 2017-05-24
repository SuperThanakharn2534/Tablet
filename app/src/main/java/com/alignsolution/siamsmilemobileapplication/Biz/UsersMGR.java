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

public class UsersMGR {
    private SQLiteDatabase database;
        public ArrayList<Users> SelectData(Context context) {
            ArrayList<Users> UsersList = new ArrayList<Users>();
            Users oUsers = new Users();
        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Users ";// where  LOWER(UserLogin) = LOWER('"+Username+"') and Password = '"+Password+"'";

        Log.i("Log",selectQuery);
        SQLiteDatabase db  = database.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                oUsers.setRowID(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                oUsers.setUserID(cursor.getString(cursor.getColumnIndexOrThrow("UserId")));
                oUsers.setUserLogin(cursor.getString(cursor.getColumnIndexOrThrow("UserLogin")));
                oUsers.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("Password")));
                oUsers.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow("FirstName")));
                oUsers.setLastName(cursor.getString(cursor.getColumnIndexOrThrow("LastName")));
                oUsers.setCardNo(cursor.getString(cursor.getColumnIndexOrThrow("CardNo")));
                oUsers.setBirthDate(cursor.getString(cursor.getColumnIndexOrThrow("BirthDate")));
                oUsers.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("Email")));
                oUsers.setPhoneNumber1(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber1")));
                oUsers.setPhoneNumber2(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber2")));
                oUsers.setHomeAddress1(cursor.getString(cursor.getColumnIndexOrThrow("HomeAddress1")));
                oUsers.setHomeAddress2(cursor.getString(cursor.getColumnIndexOrThrow("HomeAddress2")));
                oUsers.setWorkAddress1(cursor.getString(cursor.getColumnIndexOrThrow("WorkAddress1")));
                oUsers.setWorkAddress2(cursor.getString(cursor.getColumnIndexOrThrow("WorkAddress2")));
                oUsers.setHomeSubdistrict(cursor.getString(cursor.getColumnIndexOrThrow("HomeSubdistrict")));
                oUsers.setHomeDistrict(cursor.getString(cursor.getColumnIndexOrThrow("HomeDistrict")));
                oUsers.setHomeZipCode(cursor.getString(cursor.getColumnIndexOrThrow("HomeZipCode")));
                oUsers.setWorkSubdistrict(cursor.getString(cursor.getColumnIndexOrThrow("WorkSubdistrict")));
                oUsers.setWorkDistrict(cursor.getString(cursor.getColumnIndexOrThrow("WorkDistrict")));
                oUsers.setWorkZipCode(cursor.getString(cursor.getColumnIndexOrThrow("WorkZipCode")));
                oUsers.setAgentSubdistrict(cursor.getString(cursor.getColumnIndexOrThrow("AgentSubdistrict")));
                oUsers.setAgentDistrict(cursor.getString(cursor.getColumnIndexOrThrow("AgentDistrict")));
                oUsers.setAgentProvice(cursor.getString(cursor.getColumnIndexOrThrow("AgentProvice")));
                oUsers.setUserType(cursor.getString(cursor.getColumnIndexOrThrow("UserType")));
                oUsers.setPicture(cursor.getString(cursor.getColumnIndexOrThrow("Picture")));
                oUsers.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                oUsers.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                oUsers.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                oUsers.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                UsersList.add(oUsers);

                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return UsersList;
    }

        public boolean InsertData(Users users,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

            Val.put("RowId",users.getRowID());
            Val.put("UserId",users.getUserID());
            Val.put("UserLogin",users.getUserLogin());
            Val.put("Password",users.getPassword());
            Val.put("FirstName",users.getFirstName());
            Val.put("LastName",users.getLastName());
            Val.put("CardNo",users.getCardNo());
            Val.put("BirthDate",users.getBirthDate());
            Val.put("Email",users.getEmail());
            Val.put("PhoneNumber1",users.getPhoneNumber1());
            Val.put("PhoneNumber2",users.getPhoneNumber2());
            Val.put("HomeAddress1",users.getHomeAddress1());
            Val.put("WorkAddress1",users.getWorkAddress1());
            Val.put("HomeAddress2",users.getHomeAddress2());
            Val.put("WorkAddress2",users.getWorkAddress2());
            Val.put("HomeSubdistrict",users.getHomeSubdistrict());
            Val.put("HomeDistrict",users.getHomeDistrict());
            Val.put("HomeZipCode",users.getHomeZipCode());
            Val.put("WorkSubdistrict",users.getWorkSubdistrict());
            Val.put("WorkDistrict",users.getWorkDistrict());
            Val.put("WorkZipCode",users.getWorkZipCode());
            Val.put("AgentSubdistrict",users.getAgentSubdistrict());
            Val.put("AgentDistrict",users.getAgentDistrict());
            Val.put("AgentProvice",users.getAgentProvice());
            Val.put("UserType",users.getUserType());
            Val.put("Picture",users.getPicture());
            Val.put("CreatedOn",users.getCreatedOn());
            Val.put("ModifiedOn",users.getModifiedOn());
            Val.put("SyncDate",users.getSyncDate());
            Val.put("SyncStatus",users.getSyncStatus());



            long rows ;
            Log.i("long","InsertLong");
            rows  = db.insert("Users", null, Val);
            if (rows == -1 ){
                aBoolean = false;
            }

            return  aBoolean;
    }

         public boolean UpdateData(Users users,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",users.getRowID());
        Val.put("UserId",users.getUserID());
        Val.put("UserLogin",users.getUserLogin());
        Val.put("Password",users.getPassword());
        Val.put("FirstName",users.getFirstName());
        Val.put("LastName",users.getLastName());
        Val.put("CardNo",users.getCardNo());
        Val.put("BirthDate",users.getBirthDate());
        Val.put("Email",users.getEmail());
        Val.put("PhoneNumber1",users.getPhoneNumber1());
        Val.put("PhoneNumber2",users.getPhoneNumber2());
        Val.put("HomeAddress1",users.getHomeAddress1());
        Val.put("WorkAddress1",users.getWorkAddress1());
        Val.put("HomeAddress2",users.getHomeAddress2());
        Val.put("WorkAddress2",users.getWorkAddress2());
        Val.put("HomeSubdistrict",users.getHomeSubdistrict());
        Val.put("HomeDistrict",users.getHomeDistrict());
        Val.put("HomeZipCode",users.getHomeZipCode());
        Val.put("WorkSubdistrict",users.getWorkSubdistrict());
        Val.put("WorkDistrict",users.getWorkDistrict());
        Val.put("WorkZipCode",users.getWorkZipCode());
        Val.put("AgentSubdistrict",users.getAgentSubdistrict());
        Val.put("AgentDistrict",users.getAgentDistrict());
        Val.put("AgentProvice",users.getAgentProvice());
        Val.put("UserType",users.getUserType());
        Val.put("Picture",users.getPicture());
        Val.put("CreatedOn",users.getCreatedOn());
        Val.put("ModifiedOn",users.getModifiedOn());
        Val.put("SyncDate",users.getSyncDate());
        Val.put("SyncStatus",users.getSyncStatus());



        int rows ;
        Log.i("long","InsertLong");
        rows  = db.update("Users",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean DeleteData(Users users,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        //Val.put("RowId",users.getRowID());
        Val.put("UserId",users.getUserID());
        Val.put("UserLogin",users.getUserLogin());
        Val.put("Password",users.getPassword());
        Val.put("FirstName",users.getFirstName());
        Val.put("LastName",users.getLastName());
        Val.put("CardNo",users.getCardNo());
        Val.put("BirthDate",users.getBirthDate());
        Val.put("Email",users.getEmail());
        Val.put("PhoneNumber1",users.getPhoneNumber1());
        Val.put("PhoneNumber2",users.getPhoneNumber2());
        Val.put("HomeAddress1",users.getHomeAddress1());
        Val.put("WorkAddress1",users.getWorkAddress1());
        Val.put("HomeAddress2",users.getHomeAddress2());
        Val.put("WorkAddress2",users.getWorkAddress2());
        Val.put("HomeSubdistrict",users.getHomeSubdistrict());
        Val.put("HomeDistrict",users.getHomeDistrict());
        Val.put("HomeZipCode",users.getHomeZipCode());
        Val.put("WorkSubdistrict",users.getWorkSubdistrict());
        Val.put("WorkDistrict",users.getWorkDistrict());
        Val.put("WorkZipCode",users.getWorkZipCode());
        Val.put("AgentSubdistrict",users.getAgentSubdistrict());
        Val.put("AgentDistrict",users.getAgentDistrict());
        Val.put("AgentProvice",users.getAgentProvice());
        Val.put("UserType",users.getUserType());
        Val.put("Picture",users.getPicture());
        Val.put("CreatedOn",users.getCreatedOn());
        Val.put("ModifiedOn",users.getModifiedOn());
        Val.put("SyncDate",users.getSyncDate());
        Val.put("SyncStatus",users.getSyncStatus());



        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("Users",users.getRowID(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }



}





