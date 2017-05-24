package com.alignsolution.siamsmilemobileapplication.Biz;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;
import com.alignsolution.siamsmilemobileapplication.OpportunityProductStep2Activity;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/10/2017.
 */

public class OppurtunityProduct_MGR extends AppCompatActivity {

    public  void  OpenPromotion(String itemNo , Activity activity){

         Intent intent = new Intent(activity,OpportunityProductStep2Activity.class);
        intent.putExtra("itemNo",itemNo.toString());
           activity.startActivity(intent);



    }

    public ArrayList<Opportunity> SelectData(Context context) {
        ArrayList<Opportunity> OpportunityList = new ArrayList<Opportunity>();
        ArrayList<OpportunityProduct> opportunityProductsList = new ArrayList<>();
        Opportunity opportunity = new Opportunity();
        OpportunityProduct opportunityProduct =new OpportunityProduct();

        opportunity = new Opportunity();
        opportunityProduct = new OpportunityProduct();
        opportunity.setFirstName("คุณสมชาย");
        opportunity.setLastName("ศรีสุข");
        opportunity.setCardNo("1234567890123");
        opportunity.setPhoneNumber1("0899911234");
        opportunity.setProvince("อยุธยา");
        opportunity.setEmail("test1@gmail.com");
        opportunityProduct.setPercent("100%");
        OpportunityList.add(opportunity);
        opportunityProductsList.add(opportunityProduct);


        /*** Rows 2 ***/
        opportunity = new Opportunity();
        opportunityProduct = new OpportunityProduct();
        opportunity.setFirstName("คุณสมนึก");
        opportunity.setLastName("รักดี");
        opportunity.setCardNo("1654987635259");
        opportunity.setPhoneNumber1("0814556699");
        opportunity.setProvince("เชียงใหม่");
        opportunity.setEmail("test2@gmail.com");
        opportunityProduct.setPercent("50%");
        OpportunityList.add(opportunity);
        opportunityProductsList.add(opportunityProduct);
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

        return OpportunityList ;
        //return  opportunityProduct;
    }

    public boolean InsertData(Opportunity opportunity,Context context,OpportunityProduct opportunityProduct) {

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
        Val.put("GPSLong",opportunity.getGPSLong());
        Val.put("GPSLat",opportunity.getGPSLat());
        Val.put("AgentNo",opportunity.getAgentNo());
        Val.put("CreatedOn",opportunity.getCreatedOn());
        Val.put("ModifiedOn",opportunity.getModifiedOn());
        Val.put("SyncDate",opportunity.getSyncDate());
        Val.put("SyncStatus",opportunity.getSyncStatus());
        Val.put("Percent",opportunityProduct.getPercent());

        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("OpportunityProductNo", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public ArrayList<OpportunityProduct> SelectDataPro(Context context) {
        ArrayList<OpportunityProduct> OpportunityProductList = new ArrayList<OpportunityProduct>();
        OpportunityProduct opportunityProduct = new OpportunityProduct();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  OpportunityProduct";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                opportunityProduct.setOpportunityProductNo(cursor.getString(cursor.getColumnIndexOrThrow("OpportunityProductNo")));
                opportunityProduct.setProductNo(cursor.getString(cursor.getColumnIndexOrThrow("ProductNo")));
                opportunityProduct.setProductType(cursor.getString(cursor.getColumnIndexOrThrow("ProductType")));
                opportunityProduct.setInsureType(cursor.getString(cursor.getColumnIndexOrThrow("InsureType")));
                opportunityProduct.setPercent(cursor.getString(cursor.getColumnIndexOrThrow("Percent")));
                opportunityProduct.setPicture(cursor.getString(cursor.getColumnIndexOrThrow("Picture")));
                opportunityProduct.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                opportunityProduct.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                opportunityProduct.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                opportunityProduct.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                OpportunityProductList.add(opportunityProduct);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();

        return  OpportunityProductList;
    }

    public boolean InsertData(OpportunityProduct opportunityProduct,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("OpportunityProductNo", opportunityProduct.getRowId());
        Val.put("ProductNo", opportunityProduct.getProductNo());
        Val.put("ProductType", opportunityProduct.getProductType());
        Val.put("InsureType", opportunityProduct.getInsureType());
        Val.put("Percent", opportunityProduct.getPercent());
        Val.put("Picture", opportunityProduct.getPicture());
        Val.put("CreatedOn", opportunityProduct.getCreatedOn());
        Val.put("ModifiedOn", opportunityProduct.getModifiedOn());
        Val.put("SyncDate", opportunityProduct.getSyncDate());
        Val.put("SyncStatus", opportunityProduct.getSyncStatus());


        long rows;
        Log.i("long", "InsertLong");
        rows = db.insert("OpportunityProduct", null, Val);
        if (rows == -1) {
            aBoolean = false;
        }

        return aBoolean;
    }

    public boolean UpdateData(OpportunityProduct opportunityProduct,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("OpportunityProductNo", opportunityProduct.getRowId());
        Val.put("ProductNo", opportunityProduct.getProductNo());
        Val.put("ProductType", opportunityProduct.getProductType());
        Val.put("InsureType", opportunityProduct.getInsureType());
        Val.put("Percent", opportunityProduct.getPercent());
        Val.put("Picture", opportunityProduct.getPicture());
        Val.put("CreatedOn", opportunityProduct.getCreatedOn());
        Val.put("ModifiedOn", opportunityProduct.getModifiedOn());
        Val.put("SyncDate", opportunityProduct.getSyncDate());
        Val.put("SyncStatus", opportunityProduct.getSyncStatus());


        int rows;
        Log.i("long", "UpdateLong");
        rows = db.update("OpportunityProduct",Val,null,null);
        if (rows == -1) {
            aBoolean = false;
        }

        return aBoolean;
    }

    public boolean DeleteData(OpportunityProduct opportunityProduct,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",opportunityProduct.getRowId());
        Val.put("OpportunityProductNo", opportunityProduct.getOpportunityProductNo());
        Val.put("ProductNo", opportunityProduct.getProductNo());
        Val.put("ProductType", opportunityProduct.getProductType());
        Val.put("InsureType", opportunityProduct.getInsureType());
        Val.put("Percent", opportunityProduct.getPercent());
        Val.put("Picture", opportunityProduct.getPicture());
        Val.put("CreatedOn", opportunityProduct.getCreatedOn());
        Val.put("ModifiedOn", opportunityProduct.getModifiedOn());
        Val.put("SyncDate", opportunityProduct.getSyncDate());
        Val.put("SyncStatus", opportunityProduct.getSyncStatus());


        int rows;
        Log.i("long", "DeleteLong");
        rows = db.delete("OpportunityProduct",opportunityProduct.getRowId(),null);
        if (rows == -1) {
            aBoolean = false;
        }

        return aBoolean;
    }

}
