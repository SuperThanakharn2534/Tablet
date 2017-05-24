package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/11/2017.
 */


public class OpportunityProductStep2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;
    String itemNo;

    private Spinner dataProduct;
    private ArrayList<String> textlistproduct = new ArrayList<String>();
    public   int[] imgs = {R.drawable.person,R.drawable.group,R.drawable.car,R.drawable.person,R.drawable.group,R.drawable.car};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_product_step2);
        try {


            dataProduct = (Spinner) findViewById(R.id.spinner);
            datalistProduct();
            // Adapter ตัวแรก
            ArrayAdapter<String> adapterProduct = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, textlistproduct);
            dataProduct.setAdapter(adapterProduct);

            SetHeader("ผู้มุ่งหวัง/ปิดการขาย", false, false);
            SetMenu();
            datalistProduct();
            selectProduct();
            ButtonClick();


        }catch (Exception e){
            Log.i("Err Log", "DasboardActivity : " + Log.getStackTraceString(e));
        }


    }

    private  void ButtonClick(){
        Button button12 = (Button)findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OppurunityProductStep2ActivityPopup.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);
            }
        });

        Button button11 = (Button)findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),OpportunityProductSuccess_PopUp.class);
                intent.putExtra("itemNo",itemNo.toString());
                startActivity(intent);
            }
        });
    }

    private  void selectProduct(){

        android.util.Log.i(" group ",getIntent().getExtras().getString("itemNo"));
        itemNo = getIntent().getExtras().getString("itemNo");
        TextView textView42 = (TextView)findViewById(R.id.textView42);
        textView42.setText(itemNo);
        final ImageView img =(ImageView)findViewById(R.id.imageView6);
        img.setImageResource(imgs[Integer.parseInt(itemNo)]);
        if ( Integer.parseInt(itemNo) == 0) {
            textView42.setText("ประกันบุคคล");
        } else if (Integer.parseInt(itemNo) == 1) {
            textView42.setText("ประกันกลุ่ม");
        } else if (Integer.parseInt(itemNo) == 2) {
            textView42.setText("ประกันรถยนต์");
        } else if (Integer.parseInt(itemNo) == 3) {
            textView42.setText("ประกันบุคคล");
        } else if (Integer.parseInt(itemNo) == 4) {
            textView42.setText("ประกันกลุ่ม");
        } else if (Integer.parseInt(itemNo) == 5) {
            textView42.setText("ประกันรถยนต์");
        }
    }

    private void datalistProduct() {

        textlistproduct.add("รูปแบบประกัน");
        textlistproduct.add("SilVer  1+");
        textlistproduct.add("SilVer  2+");
        textlistproduct.add("SilVer  3+");
        textlistproduct.add("SilVer  4+");
        textlistproduct.add("SilVer ");


    }

    public void selectItem(int position) {
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

        MenuAdapter menuAdapter = new MenuAdapter(OpportunityProductStep2Activity.this,
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

        selectItem(position);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
