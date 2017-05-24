package com.alignsolution.siamsmilemobileapplication.Biz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.alignsolution.siamsmilemobileapplication.LoginActivity;

/**
 * Created by aligndev on 21-Apr-17.
 */

public class Activity_NewsSiamSmile extends AppCompatActivity {

    public  void  OpenPromotion(Activity activity){

        Intent intent = new Intent(activity,LoginActivity.class);
        startActivity(intent);



    }
}
