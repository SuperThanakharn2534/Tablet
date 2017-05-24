package com.alignsolution.siamsmilemobileapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by aligndev on 22-Apr-17.
 */

public class Activity_SignName_PopUp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signname_popup);

        Button cmd = (Button) findViewById(R.id.button52);
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it2 = new Intent(getBaseContext(),ClaimStep3Activity.class);
                startActivity(it2);
            }
        });

                Button cmd2 = (Button) findViewById(R.id.button51);
        cmd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it2 = new Intent(getBaseContext(),ClaimStep3Activity.class);
                startActivity(it2);
            }
        });


        //PopUp Page
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));
    }
}
