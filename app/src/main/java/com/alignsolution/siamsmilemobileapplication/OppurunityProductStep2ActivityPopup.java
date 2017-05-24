package com.alignsolution.siamsmilemobileapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/11/2017.
 */

public class OppurunityProductStep2ActivityPopup extends AppCompatActivity {
    private Spinner textspinner;
    private ArrayList<String> spinner = new ArrayList<String>();
    String itemNo;
    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_opportunity_product_step2_popup);
        try {
                    ButtonClick();
                    PagePopUp();
                    Spinner();



        }catch (Exception e){
            Log.i("Err Log", "DasboardActivity : " + Log.getStackTraceString(e));
        }
    }

    private void textlistdata(){
        spinner.add("ระบุเปอร์เซ็นต์ความสนใจ");
        spinner.add("10%");
        spinner.add("20%");
        spinner.add("30%");
        spinner.add("40%");
        spinner.add("50%");
        spinner.add("60%");
        spinner.add("70%");
        spinner.add("80%");
        spinner.add("90%");
        spinner.add("100%");


    }
    private  void PagePopUp(){

        //PopUp Page
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.99),(int)(height*.99));

    }
    private  void Spinner(){
        textspinner = (Spinner) findViewById(R.id.spinner4);
        textlistdata();
        // Adapter ตัวแรก
        ArrayAdapter<String> adapterThai = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, spinner);
        textspinner.setAdapter(adapterThai);
    }
    private  void ButtonClick(){

        //GetExtra
        itemNo = getIntent().getExtras().getString("itemNo");

        Button btBrowseImg =(Button)findViewById(R.id.btBrowseImg);
        btBrowseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }
        });


        Button btConfirm =(Button)findViewById(R.id.btConfirm);
        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityDetailActivity.class);
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
    }


//    public void loadImagefromGallery(View view) {
//        // Create intent to Open Image applications like Gallery, Google Photos
//        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        // Start the Intent
//        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
//
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.imgView);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

}
