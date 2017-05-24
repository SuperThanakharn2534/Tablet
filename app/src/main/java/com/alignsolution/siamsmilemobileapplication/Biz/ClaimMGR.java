package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

import java.sql.RowId;
import java.util.ArrayList;

/**
 * Created by aligndev on 17-May-17.
 */

public class ClaimMGR {

    public ArrayList<Claim> SelectData(Context context) {
        ArrayList<Claim> ClaimList = new ArrayList<Claim>();
        Claim Claim = new Claim();


        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Claim";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                Claim.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                Claim.setClaimCode(cursor.getString(cursor.getColumnIndexOrThrow("ClaimCode")));
                Claim.setClaimType(cursor.getString(cursor.getColumnIndexOrThrow("ClaimType")));
                Claim.setAccidentDate(cursor.getString(cursor.getColumnIndexOrThrow("AccidentDate")));
                Claim.setHospital(cursor.getString(cursor.getColumnIndexOrThrow("Hospital")));
                Claim.setHospitalInDate(cursor.getString(cursor.getColumnIndexOrThrow("HospitalInDate")));
                Claim.setHospitalOutDate(cursor.getString(cursor.getColumnIndexOrThrow("HospitalOutDate")));
                Claim.setProvince(cursor.getString(cursor.getColumnIndexOrThrow("Province")));
                Claim.setDescription(cursor.getString(cursor.getColumnIndexOrThrow("Description")));
                Claim.setChiefCormplain(cursor.getString(cursor.getColumnIndexOrThrow("ChiefCormplain")));
                Claim.setJudge(cursor.getString(cursor.getColumnIndexOrThrow("Judge")));
                Claim.setBankAccName(cursor.getString(cursor.getColumnIndexOrThrow("BankAccName")));
                Claim.setBankAccNo(cursor.getString(cursor.getColumnIndexOrThrow("BankAccNo")));
                Claim.setBankAccType(cursor.getString(cursor.getColumnIndexOrThrow("BankAccType")));
                Claim.setBank(cursor.getString(cursor.getColumnIndexOrThrow("Bank")));
                Claim.setBankBranch(cursor.getString(cursor.getColumnIndexOrThrow("BankBranch")));
                Claim.setAuthorizeDesc(cursor.getString(cursor.getColumnIndexOrThrow("AuthorizeDesc")));
                Claim.setAuthorizeSign(cursor.getString(cursor.getColumnIndexOrThrow("AuthorizeSign")));
                Claim.setAccidentDate(cursor.getString(cursor.getColumnIndexOrThrow("AccidentDate")));
                Claim.setStatus(cursor.getString(cursor.getColumnIndexOrThrow("Status")));
                Claim.setSubmitDate(cursor.getString(cursor.getColumnIndexOrThrow("SubmitDate")));
                Claim.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                Claim.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                Claim.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                Claim.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                ClaimList.add(Claim);


                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();
        return  ClaimList;
    }

    public boolean InsertData(Claim claim, Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();
        Val.put("RowId",claim.getRowId());
        Val.put("ClaimCode", claim.getClaimCode());
        Val.put("ClaimType",claim.getClaimType());
        Val.put("AccidentDate",claim.getAccidentDate());
        Val.put("Hospital",claim.getHospital().toString());
        Val.put("HospitalInDate",claim.getHospitalInDate());
        Val.put("HospitalOutDate",claim.getHospitalOutDate());
        Val.put("Province",claim.getProvince().toString());
        Val.put("Description",claim.getDescription().toString());
        Val.put("ChiefCormplain",claim.getChiefCormplain());
        Val.put("Province",claim.getProvince());
        Val.put("Judge",claim.getJudge());
        Val.put("BankAccName",claim.getBankAccName().toString());
        Val.put("BankAccNo ",claim.getBankAccNo());
        Val.put("Bank",claim.getBank().toString());
        Val.put("BankBranch",claim.getBankBranch().toString());
        Val.put("AuthorizeDesc",claim.getAuthorizeDesc());
        Val.put("AuthorizeSign",claim.getAuthorizeSign());
        Val.put("Status",claim.getStatus());
        Val.put("SubmitDate",claim.getSubmitDate());
        Val.put("CreatedOn",claim.getCreatedOn());
        Val.put("ModifiedOn",claim.getModifiedOn());
        Val.put("SyncDate",claim.getSyncDate());
        Val.put("SyncStatus",claim.getSyncStatus());



        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("claim", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean UpdateData(Claim claim, Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();

        Val.put("ClaimCode", claim.getClaimCode());
        Val.put("ClaimType",claim.getClaimType());
        Val.put("AccidentDate",claim.getAccidentDate());
        Val.put("Hospital",claim.getHospital().toString());
        Val.put("HospitalInDate",claim.getHospitalInDate());
        Val.put("HospitalOutDate",claim.getHospitalOutDate());
        Val.put("Province",claim.getProvince().toString());
        Val.put("Description",claim.getDescription().toString());
        Val.put("ChiefCormplain",claim.getChiefCormplain());
        Val.put("Province",claim.getProvince());
        Val.put("Judge",claim.getJudge());
        Val.put("BankAccName",claim.getBankAccName().toString());
        Val.put("BankAccNo ",claim.getBankAccNo());
        Val.put("Bank",claim.getBank().toString());
        Val.put("BankBranch",claim.getBankBranch().toString());
        Val.put("AuthorizeDesc",claim.getAuthorizeDesc());
        Val.put("AuthorizeSign",claim.getAuthorizeSign());
        Val.put("Status",claim.getStatus());
        Val.put("SubmitDate",claim.getSubmitDate());
        Val.put("CreatedOn",claim.getCreatedOn());
        Val.put("ModifiedOn",claim.getModifiedOn());
        Val.put("SyncDate",claim.getSyncDate());
        Val.put("SyncStatus",claim.getSyncStatus());

        int rows ;
        Log.i("long","UpdateData");
        rows  = db.update("claim",Val,null,null);
//        rows  = db.update("claim",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

//    public Integer DeleteData(Claim claim  , Context context) {
//        DataBase database = new DataBase(context);
//        SQLiteDatabase db = database.getReadableDatabase();
//      return   db.delete("Claim",claim.getRowId(),null);
////        // Database
////        DataBase database = new DataBase(context);
////        SQLiteDatabase db  = database.getWritableDatabase();
////
////            return  db.delete("claim" ,claim.getRowId(),null);
//
//    }

//    public void DeleteData(Claim claim , String RowId ,Context context)
//    {
//        DataBase database = new DataBase(context);
//        SQLiteDatabase db = database.getWritableDatabase();
//        db.execSQL("DELETE FROM "+claim+" WHERE "+RowId+"='"+RowId+"'");
//        db.close();
//    }


    public boolean DeleteData(Claim claim, Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db  = database.getWritableDatabase();
        ContentValues Val= new ContentValues();

        Val.put("ClaimCode", claim.getClaimCode());
        Val.put("ClaimType",claim.getClaimType());
        Val.put("AccidentDate",claim.getAccidentDate());
        Val.put("Hospital",claim.getHospital());
        Val.put("HospitalInDate",claim.getHospitalInDate());
        Val.put("HospitalOutDate",claim.getHospitalOutDate());
        Val.put("Province",claim.getProvince());
        Val.put("Description",claim.getDescription());
        Val.put("ChiefCormplain",claim.getChiefCormplain());
        Val.put("Province",claim.getProvince());
        Val.put("Judge",claim.getJudge());
        Val.put("BankAccName",claim.getBankAccName());
        Val.put("BankAccNo ",claim.getBankAccNo());
        Val.put("Bank",claim.getBank());
        Val.put("BankBranch",claim.getBankBranch());
        Val.put("AuthorizeDesc",claim.getAuthorizeDesc());
        Val.put("AuthorizeSign",claim.getAuthorizeSign());
        Val.put("Status",claim.getStatus());
        Val.put("SubmitDate",claim.getSubmitDate());
        Val.put("CreatedOn",claim.getCreatedOn());
        Val.put("ModifiedOn",claim.getModifiedOn());
        Val.put("SyncDate",claim.getSyncDate());
        Val.put("SyncStatus",claim.getSyncStatus());

        int rows ;
        Log.i("long","UpdateData");
        rows  = db.delete("claim",claim.getRowId(),null);
//        rows  = db.update("claim",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }
}
