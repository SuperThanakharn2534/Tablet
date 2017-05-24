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

public class PaymentMGR {

    public ArrayList<Payment> SelectData(Context context) {
        ArrayList<Payment> PaymentList = new ArrayList<Payment>();
        Payment Payment = new Payment();

        // Database
        DataBase database = new DataBase(context);
        String selectQuery = "SELECT  * FROM  Payment";
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {


                Payment.setRowId(cursor.getString(cursor.getColumnIndexOrThrow("RowId")));
                Payment.setPaymentNo(cursor.getString(cursor.getColumnIndexOrThrow("PaymentNo")));
                Payment.setPaymentType(cursor.getString(cursor.getColumnIndexOrThrow("PaymentType")));
                Payment.setPremium(cursor.getString(cursor.getColumnIndexOrThrow("Premium")));
                Payment.setAgentNo(cursor.getString(cursor.getColumnIndexOrThrow("AgentNo")));
                Payment.setInvoiceNo(cursor.getString(cursor.getColumnIndexOrThrow("InvoiceNo")));
                Payment.setCreatedOn(cursor.getString(cursor.getColumnIndexOrThrow("CreatedOn")));
                Payment.setModifiedOn(cursor.getString(cursor.getColumnIndexOrThrow("ModifiedOn")));
                Payment.setSyncDate(cursor.getString(cursor.getColumnIndexOrThrow("SyncDate")));
                Payment.setSyncStatus(cursor.getString(cursor.getColumnIndexOrThrow("SyncStatus")));
                PaymentList.add(Payment);



                // get the data into array, or class variable
            } while (cursor.moveToNext());
        }
        cursor.close();




        return PaymentList;
    }

    public boolean InsertData(Payment payment,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",payment.getRowId());
        Val.put("PaymentNo",payment.getPaymentNo());
        Val.put("PaymentType",payment.getPaymentType());
        Val.put("Premium",payment.getPremium());
        Val.put("AgentNo",payment.getAgentNo());
        Val.put("InvoiceNo",payment.getInvoiceNo());
        Val.put("CreatedOn",payment.getCreatedOn());
        Val.put("ModifiedOn",payment.getModifiedOn());
        Val.put("SyncDate",payment.getSyncDate());
        Val.put("SyncStatus",payment.getSyncStatus());




        long rows ;
        Log.i("long","InsertLong");
        rows  = db.insert("Payment", null, Val);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean UpdateData(Payment payment,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",payment.getRowId());
        Val.put("PaymentNo",payment.getPaymentNo());
        Val.put("PaymentType",payment.getPaymentType());
        Val.put("Premium",payment.getPremium());
        Val.put("AgentNo",payment.getAgentNo());
        Val.put("InvoiceNo",payment.getInvoiceNo());
        Val.put("CreatedOn",payment.getCreatedOn());
        Val.put("ModifiedOn",payment.getModifiedOn());
        Val.put("SyncDate",payment.getSyncDate());
        Val.put("SyncStatus",payment.getSyncStatus());




        int rows ;
        Log.i("long","UpdateLong");
        rows  = db.update("Payment",Val,null,null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

    public boolean DeleteData(Payment payment,Context context) {

        DataBase database = new DataBase(context);
        Boolean aBoolean = true;
        SQLiteDatabase db = database.getWritableDatabase();
        ContentValues Val = new ContentValues();

        Val.put("RowId",payment.getRowId());
        Val.put("PaymentNo",payment.getPaymentNo());
        Val.put("PaymentType",payment.getPaymentType());
        Val.put("Premium",payment.getPremium());
        Val.put("AgentNo",payment.getAgentNo());
        Val.put("InvoiceNo",payment.getInvoiceNo());
        Val.put("CreatedOn",payment.getCreatedOn());
        Val.put("ModifiedOn",payment.getModifiedOn());
        Val.put("SyncDate",payment.getSyncDate());
        Val.put("SyncStatus",payment.getSyncStatus());




        int rows ;
        Log.i("long","DeleteLong");
        rows  = db.delete("Payment",payment.getRowId(),null);
        if (rows == -1 ){
            aBoolean = false;
        }

        return  aBoolean;
    }

}
