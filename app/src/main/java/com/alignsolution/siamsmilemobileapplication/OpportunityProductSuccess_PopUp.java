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

public class OpportunityProductSuccess_PopUp extends AppCompatActivity {

     String itemNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opportunity_product_popup_salecloss);
        itemNo = getIntent().getExtras().getString("itemNo");


        Button btClossSales =(Button)findViewById(R.id.btClossSales);
        btClossSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductSuccessPay1.class);
                startActivity(intent);

            }
        });

        Button btCancle =(Button)findViewById(R.id.btCancle);
        btCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductStep2Activity.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);

            }
        });

        //PopUp Page
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.5));



    }
}
