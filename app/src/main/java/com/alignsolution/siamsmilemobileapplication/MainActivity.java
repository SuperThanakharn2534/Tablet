package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Log.i("creatData"," Pcreate01_Main");

        try {

            SetHeader("  ", false, false);
            Runable();



        }catch (Exception e){}


//        //  Header  TooBar  image and icon
//        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
//                | ActionBar.DISPLAY_SHOW_CUSTOM);
//        ImageView imageView = new ImageView(getSupportActionBar().getThemedContext());
//        getSupportActionBar().setCustomView(R.layout.activity_login_header);



    }

    public  void Runable(){

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) { }
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        }).start();

    }

    public void SetHeader(String TextTitle, boolean ShowAddButton, boolean ShowNotify) {

        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_header);

        TextView Title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.txtTitle);
        Title.setText(TextTitle);

        if (!ShowAddButton) {
            ImageButton btnAdd = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.btnAdd);
            btnAdd.setVisibility(View.GONE);
        }

        if (!ShowNotify) {

            ImageView imgNotify = (ImageView) getSupportActionBar().getCustomView().findViewById(R.id.imgnotify);
            imgNotify.setVisibility(View.GONE);
        }


    }


    }

