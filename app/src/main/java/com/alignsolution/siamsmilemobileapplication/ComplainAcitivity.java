package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alignsolution.siamsmilemobileapplication.Adapter.DasboardActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * Created by aligndev on 19-Apr-17.
 */

public  class ComplainAcitivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;

    //spinner
    private Spinner list_type;
    private ArrayList<String> Data = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        Log.i("CaptChar","Open ComplainActivity");

        try {


            SetHeader("ข้อเสนอแนะ", false, false);
            SetMenu();
            SetData();
            captcha();




        }catch (Exception e){}

    }

    public  void  captcha(){


        final TextCaptcha textCaptcha = new TextCaptcha(600, 150, 4, TextCaptcha.TextOptions.LETTERS_ONLY);
        ImageView imageView = (ImageView) findViewById(R.id.imgCaptchar);
        imageView.setImageBitmap(textCaptcha.getImage());

        Button btnCheck =(Button)findViewById(R.id.btConfirmData);
        final EditText edtTextCaptcha = (EditText) findViewById(R.id.edtTextCaptchar);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtTextCaptcha.setError(null);
                int numberOfCaptchaFalse = 0;


                //checking text captcha
                if (!textCaptcha.checkAnswer(edtTextCaptcha.getText().toString().trim())) {
                    edtTextCaptcha.setText("");
                    edtTextCaptcha.setError("Captcha is not match");
                    numberOfCaptchaFalse++;
                }

                if (numberOfCaptchaFalse == 0) {
                     edtTextCaptcha.setText("");
                    Toast.makeText(ComplainAcitivity.this, "All captcha texts match!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    public  void SetData(){


       Button btConfirmData = (Button) findViewById(R.id.btConfirmData);
        btConfirmData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent it = new Intent(getBaseContext(),ComplainAcitivity.class);
                startActivity(it);
            }
        });



        list_type = (Spinner) findViewById(R.id.spinner5);
        createList();

        // Spinner   Adapter ตัวแรก
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Data);
        list_type.setAdapter(adapter);

    }

    public void selectItem(int position) {
        Log.i("ERROR 00","SHOW ERROR");
        menuMGR.CustomerMenuSelect(position, this);
    }

    public void SetMenu() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        planets = getResources().getStringArray(R.array.CustomerMenu);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
        listView.setOnItemClickListener(this);

        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MenuAdapter menuAdapter = new MenuAdapter(ComplainAcitivity.this,
                menuMGR.MenuText(), menuMGR.MenuImg());
        MenuList = (ListView) findViewById(R.id.list);
        MenuList.setAdapter(menuAdapter);





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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,planets[position]+ "   was selected ", Toast.LENGTH_SHORT).show();
        Log.i("ERROR ","SHOW ERROR");
        selectItem(position);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createList() {
        Data.add("เลือกประเภท");
        Data.add("ประเภทที่1");
        Data.add("ประเภทที่2");
        Data.add("ประเภทที่3");
        Data.add("ประเภทที่4");
        Data.add("ประเภทที่5");

    }

}
