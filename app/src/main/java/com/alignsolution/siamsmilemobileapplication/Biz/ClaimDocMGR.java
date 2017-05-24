package com.alignsolution.siamsmilemobileapplication.Biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.alignsolution.siamsmilemobileapplication.DataBase;

import java.util.ArrayList;

/**
 * Created by aligndev on 16-May-17.
 */

public class ClaimDocMGR {

    public ArrayList<ClaimDoc> SelectData(Context context) {
        ArrayList<ClaimDoc>ClaimDocList = new ArrayList<ClaimDoc>();
        ClaimDoc claimDoc = new ClaimDoc();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  ClaimDoc";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {


                claimDoc.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                claimDoc.setAppId(cursor.getString(cursor.getColumnIndexOrThrow("AppId")));
                claimDoc.setClaimNo(cursor.getString(cursor.getColumnIndexOrThrow("ClaimNo")));
                claimDoc.setInvoiceTotal(cursor.getString(cursor.getColumnIndexOrThrow("InvoiceTotal")));
                claimDoc.setInvoiceDocType(cursor.getString(cursor.getColumnIndexOrThrow("InvoiceDocType")));
                claimDoc.setMedicalCert(cursor.getString(cursor.getColumnIndexOrThrow("MedicalCert")));
                claimDoc.setMedicalCertDocType(cursor.getString(cursor.getColumnIndexOrThrow("MedicalCertDocType")));
                claimDoc.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                claimDoc.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                claimDoc.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                claimDoc.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));

                ClaimDocList.add(claimDoc);


                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();

        return  ClaimDocList;
    }

    public boolean InsertData(ClaimDoc claimDoc, Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",claimDoc.getRowId());
        Val.put("AppId", claimDoc.getAppId());
        Val.put("ClaimNo",claimDoc.getClaimNo());
        Val.put("InvoiceTotal",claimDoc.getInvoiceTotal());
        Val.put("InvoiceDocType",claimDoc.getInvoiceDocType());
        Val.put("MedicalCert",claimDoc.getMedicalCert());
        Val.put("MedicalCertDocType",claimDoc.getMedicalCertDocType());
        Val.put("CreatedOn",claimDoc.getCreatedOn());
        Val.put("ModifiedOn",claimDoc.getModifiedOn());
        Val.put("SyncDate",claimDoc.getSyncDate());
        Val.put("SyncStatus ",claimDoc.getSyncStatus());

        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("ClaimDoc", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;

    }

    public boolean UpdateData(ClaimDoc claimDoc, Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("AppId", claimDoc.getAppId());
        Val.put("ClaimNo",claimDoc.getClaimNo());
        Val.put("InvoiceTotal",claimDoc.getInvoiceTotal());
        Val.put("InvoiceDocType",claimDoc.getInvoiceDocType());
        Val.put("MedicalCert",claimDoc.getMedicalCert());
        Val.put("MedicalCertDocType",claimDoc.getMedicalCertDocType());
        Val.put("CreatedOn",claimDoc.getCreatedOn());
        Val.put("ModifiedOn",claimDoc.getModifiedOn());
        Val.put("SyncDate",claimDoc.getSyncDate());
        Val.put("SyncStatus",claimDoc.getSyncStatus());

        int rows ;
         Log.i("Data","UpdateData");
        rows  = db.update("claimDoc",Val,claimDoc.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }
        return  aBoolean;

    }

    public boolean DeleteData(ClaimDoc claimDoc, Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("AppId", claimDoc.getAppId());
        Val.put("ClaimNo",claimDoc.getClaimNo());
        Val.put("InvoiceTotal",claimDoc.getInvoiceTotal());
        Val.put("InvoiceDocType",claimDoc.getInvoiceDocType());
        Val.put("MedicalCert",claimDoc.getMedicalCert());
        Val.put("MedicalCertDocType",claimDoc.getMedicalCertDocType());
        Val.put("CreatedOn",claimDoc.getCreatedOn());
        Val.put("ModifiedOn",claimDoc.getModifiedOn());
        Val.put("SyncDate",claimDoc.getSyncDate());
        Val.put("SyncStatus",claimDoc.getSyncStatus());

        int rows ;
        Log.i("Data","UpdateData");
        rows  = db.delete("claimDoc",claimDoc.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }
        return  aBoolean;

    }

}
