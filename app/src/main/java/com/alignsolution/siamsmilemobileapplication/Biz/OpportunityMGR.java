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

public class OpportunityMGR {

    public ArrayList<Opportunity> SelectData(Context context) {
        ArrayList<Opportunity> OpportunityList = new ArrayList<Opportunity>();
        Opportunity opportunity = new Opportunity();


        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Opportunity";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {


                opportunity.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                opportunity.setOpportunityNo(cursor.getString(cursor.getColumnIndexOrThrow("OpportunityNo")));
                opportunity.setFirstName(cursor.getString(cursor.getColumnIndexOrThrow("FirstName")));
                opportunity.setLastName(cursor.getString(cursor.getColumnIndexOrThrow("LastName")));
                opportunity.setCardNo(cursor.getString(cursor.getColumnIndexOrThrow("CardNo")));
                opportunity.setPhoneNumber1(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber1")));
                opportunity.setPhoneNumber2(cursor.getString(cursor.getColumnIndexOrThrow("PhoneNumber2")));
                opportunity.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("Email")));
                opportunity.setLineId(cursor.getString(cursor.getColumnIndexOrThrow("LineId")));
                opportunity.setAddress(cursor.getString(cursor.getColumnIndexOrThrow("Address")));
                opportunity.setSubDistrict(cursor.getString(cursor.getColumnIndexOrThrow("SubDistrict")));
                opportunity.setDistrict(cursor.getString(cursor.getColumnIndexOrThrow("District")));
                opportunity.setProvince(cursor.getString(cursor.getColumnIndexOrThrow("Province")));
                opportunity.setPlace(cursor.getString(cursor.getColumnIndexOrThrow("Place")));
                opportunity.setInstitute(cursor.getString(cursor.getColumnIndexOrThrow("Institute")));
                opportunity.setRemark(cursor.getString(cursor.getColumnIndexOrThrow("Remark")));
                opportunity.setPictureType(cursor.getString(cursor.getColumnIndexOrThrow("PictureType")));
                opportunity.setPicture(cursor.getString(cursor.getColumnIndexOrThrow("Picture")));
                opportunity.setGPSLat(cursor.getString(cursor.getColumnIndexOrThrow("GPSLat")));
                opportunity.setGPSLong(cursor.getString(cursor.getColumnIndexOrThrow("GPSLong")));
                opportunity.setAgentNo(cursor.getString(cursor.getColumnIndexOrThrow("AgentNo")));
                opportunity.setOpportunityType(cursor.getString(cursor.getColumnIndexOrThrow("OpportunityType")));
                opportunity.setCause(cursor.getString(cursor.getColumnIndexOrThrow("Cause")));
                opportunity.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                opportunity.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                opportunity.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                opportunity.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                OpportunityList.add(opportunity);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
//
//        opportunity = new Opportunity();
//        opportunity.setFirstName("คุณสมชาย");
//        opportunity.setLastName("ศรีสุข");
//        opportunity.setCardNo("1234567890123");
//        opportunity.setPhoneNumber1("0899911234");
//        opportunity.setProvince("หนองบัวลำภู");
//        opportunity.setEmail("test1@gmail.com");
//        OpportunityList.add(opportunity);
//            /*** Rows 2 ***/
//        opportunity = new Opportunity();
//        opportunity.setFirstName("คุณสมนึก");
//        opportunity.setLastName("รักดี");
//        opportunity.setCardNo("1654987635259");
//        opportunity.setPhoneNumber1("0814556699");
//        opportunity.setProvince("เชียงใหม่");
//        opportunity.setEmail("test2@gmail.com");
//        OpportunityList.add(opportunity);


//            /*** Rows 3 ***/
//            opportunity = new HashMap<String, String>();
//            opportunity.put("์Name", "คุณสมหญิง น่ารัก");
//            opportunity.put("Id card", "1123665987896");
//            opportunity.put("PhoneNumber", "0877611122");
//            opportunity.put("Province", "กรุงเทพฯ");
//            opportunity.put("E-Mail", "test3@gmail.com");
//            MyArrList.add(map);
//            /*** Rows 4 ***/
//            opportunity = new HashMap<String, String>();
//            opportunity.put("์Name", "คุณสมรัก ดำดี");
//            opportunity.put("Id card", "1369966998959");
//            opportunity.put("PhoneNumber", "0899211123");
//            opportunity.put("Province", "ขอนแก่น");
//            opportunity.put("E-Mail", "test4@gmail.com");
//            MyArrList.add(map);
//            /*** Rows 5 ***/
//            opportunity = new HashMap<String, String>();
//            opportunity.put("์Name", "คุณสมชาติ สีดา");
//            opportunity.put("Id card", "1977788554449");
//            opportunity.put("PhoneNumber", "0899911234");
//            opportunity.put("Province", "สกลนคร");
//            opportunity.put("E-Mail", "test5@gmail.com");
//            MyArrList.add(map);
//            /*** Rows 6 ***/
//            opportunity = new HashMap<String, String>();
//            opportunity.put("์Name", "คุณสมชาย ทำนา");
//            opportunity.put("Id card", "1498852001369");
//            opportunity.put("PhoneNumber", "0899911234");
//            opportunity.put("Province", "สงขลา");
//            opportunity.put("E-Mail", "test6@gmail.com");
//            MyArrList.add(map);
        return OpportunityList;
    }

    public boolean InsertData(Opportunity opportunity,Context context) {

        DataBase database = new DataBase(context);
          Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();

        Val.put("RowId" , opportunity.getRowId());
        Val.put("FirstName",opportunity.getFirstName());
        Val.put("LastName", opportunity.getLastName());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("CardNo",opportunity.getCardNo());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("PhoneNumber1",opportunity.getPhoneNumber1());
        Val.put("PhoneNumber2",opportunity.getPhoneNumber2());
        Val.put("Email",opportunity.getEmail());
        Val.put("LineId",opportunity.getLineId());
        Val.put("Address",opportunity.getAddress());
        Val.put("Province",opportunity.getProvince());
        Val.put("Remark",opportunity.getRemark());
        Val.put("Picture",opportunity.getPicture());
        Val.put("GPSLat",opportunity.getGPSLat());
        Val.put("GPSLong",opportunity.getGPSLong());
        Val.put("OpportunityType",opportunity.getOpportunityType());
        Val.put("Cause",opportunity.getCause());
        Val.put("PictureType",opportunity.getPictureType());
        Val.put("Institute",opportunity.getInstitute());
        Val.put("Place",opportunity.getPlace());
        Val.put("District",opportunity.getDistrict());
        Val.put("SubDistrict",opportunity.getSubDistrict());
        Val.put("AgentNo",opportunity.getAgentNo());
        Val.put("CreatedOn",opportunity.getCreatedOn());
        Val.put("ModifiedOn",opportunity.getModifiedOn());
        Val.put("SyncDate",opportunity.getSyncDate());
        Val.put("SyncStatus",opportunity.getSyncStatus());

         long rows ;
             Log.i("long","InsertLong");
        rows  = db.insert("opportunity", null, Val);
         if (rows == -1 ){
             aBoolean = false;
         }
          return  aBoolean;





    }

    public boolean UpdateData(Opportunity opportunity,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        Val.put("FirstName",opportunity.getFirstName().toString());
        Val.put("LastName", opportunity.getLastName().toString());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("CardNo",opportunity.getCardNo());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("PhoneNumber1",opportunity.getPhoneNumber1());
        Val.put("PhoneNumber2",opportunity.getPhoneNumber2());
        Val.put("Email",opportunity.getEmail());
        Val.put("LineId",opportunity.getLineId());
        Val.put("Address",opportunity.getAddress());
        Val.put("Province",opportunity.getProvince());
        Val.put("Remark",opportunity.getRemark());
        Val.put("Picture",opportunity.getPicture());
        Val.put("GPSLat",opportunity.getGPSLat());
        Val.put("GPSLong",opportunity.getGPSLong());
        Val.put("OpportunityType",opportunity.getOpportunityType());
        Val.put("Cause",opportunity.getCause());
        Val.put("PictureType",opportunity.getPictureType());
        Val.put("Institute",opportunity.getInstitute());
        Val.put("Place",opportunity.getPlace());
        Val.put("District",opportunity.getDistrict());
        Val.put("SubDistrict",opportunity.getSubDistrict());
        Val.put("AgentNo",opportunity.getAgentNo());
        Val.put("CreatedOn",opportunity.getCreatedOn());
        Val.put("ModifiedOn",opportunity.getModifiedOn());
        Val.put("SyncDate",opportunity.getSyncDate());
        Val.put("SyncStatus",opportunity.getSyncStatus());

        long rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("Opportunity",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }
        return  aBoolean;





    }

    public boolean DeleteData(Opportunity opportunity,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        Val.put("FirstName",opportunity.getFirstName());
        Val.put("LastName", opportunity.getLastName());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("CardNo",opportunity.getCardNo());
        Val.put("OpportunityNo",opportunity.getOpportunityNo());
        Val.put("PhoneNumber1",opportunity.getPhoneNumber1());
        Val.put("PhoneNumber2",opportunity.getPhoneNumber2());
        Val.put("Email",opportunity.getEmail());
        Val.put("LineId",opportunity.getLineId());
        Val.put("Address",opportunity.getAddress());
        Val.put("Province",opportunity.getProvince());
        Val.put("Remark",opportunity.getRemark());
        Val.put("Picture",opportunity.getPicture());
        Val.put("GPSLat",opportunity.getGPSLat());
        Val.put("GPSLong",opportunity.getGPSLong());
        Val.put("OpportunityType",opportunity.getOpportunityType());
        Val.put("Cause",opportunity.getCause());
        Val.put("PictureType",opportunity.getPictureType());
        Val.put("Institute",opportunity.getInstitute());
        Val.put("Place",opportunity.getPlace());
        Val.put("District",opportunity.getDistrict());
        Val.put("SubDistrict",opportunity.getSubDistrict());
        Val.put("AgentNo",opportunity.getAgentNo());
        Val.put("CreatedOn",opportunity.getCreatedOn());
        Val.put("ModifiedOn",opportunity.getModifiedOn());
        Val.put("SyncDate",opportunity.getSyncDate());
        Val.put("SyncStatus",opportunity.getSyncStatus());

        long rows ;
        Log.i("long","UpdateLong");
        rows  = db.delete("Opportunity",opportunity.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }
        return  aBoolean;





    }
}
