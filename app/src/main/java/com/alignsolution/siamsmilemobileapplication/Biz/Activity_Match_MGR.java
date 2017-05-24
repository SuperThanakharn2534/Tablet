package com.alignsolution.siamsmilemobileapplication.Biz;

import android.app.Activity;
import android.content.Intent;

import com.alignsolution.siamsmilemobileapplication.LoginActivity;

/**
 * Created by aligndev on 19-Apr-17.
 */

public class Activity_Match_MGR {
    public void OpenPromotion(String itemNo, Activity context) {
        Intent intent = new Intent(context,LoginActivity.class);
        intent.putExtra("itemNo",itemNo.toString());
        context.startActivity(intent);

    }
}
