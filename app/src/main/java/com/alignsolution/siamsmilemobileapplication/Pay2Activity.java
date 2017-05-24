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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OppurtunityProduct_MGR;

/**
 * Created by aligndev on 04-May-17.
 */

public class Pay2Activity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private DrawerLayout drawerLayout;
    private ListView Menulist;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OppurtunityProduct_MGR dataMGR = new OppurtunityProduct_MGR();
    ListView MenuList;
    ListView listView;
    ListView list;

    String[] itemname ={" APP ID : 00000001 \n" +
            "ชื่อ-นามสกุล : สมชาย  ศรีสุข\n" +
            "รหัสเลข Co-band : 484800059888\n" +
            "แผนประกัน : 501 – Silver\n" +
            "        สถานะกรมธรรม์ : ปกติ"
            ,"APP ID : 00000002\n" +
            "ชื่อ-นามสกุล : สมชาย  ศรีสุข \n" +
            "รหัสเลข Co-band : 484800059888 \n" +
            "แผนประกัน : 502 – Gold\n" +
            "สถานะกรมธรรม์ : ยกเลิก\n"};

    Integer[] imgid={
            R.drawable.image1,
            R.drawable.image2,


    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay2_main);
        try {

            SetHeader("จัดเก็บเบี้ยค้างชำระ",false,false);
            SetMenu();
            Setlistview();



        }catch (Exception e){
            Log.i("Err Log", "Pay2Activity : " + Log.getStackTraceString(e));
        }
    }

    public  void  Setlistview(){

        Pay2ActivityAdapter_list adapter=new Pay2ActivityAdapter_list(Pay2Activity.this,
                itemname, imgid);
        list=(ListView)findViewById(R.id.ProductList);
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                int itemPosition     = position;
                switch (position){
                    case  0:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        Intent myIntent = new Intent(getBaseContext(),PayDetailActivity.class);
                        startActivity(myIntent);
                        break;
                    case  1:
                        //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                        //myIntent =new Intent(activity,Activity_Opportunity2.class);
                        //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                        // activity.startActivity(myIntent);
                        Intent myIntent2 = new Intent(getBaseContext(),PayDetailActivity.class);
                        startActivity(myIntent2);

                        break;
                    default:
                        break;

                }

            }


        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,planets[position]+ "   was selected ", Toast.LENGTH_SHORT).show();

        selectItem(position);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void selectItem(int position) {
        menuMGR.CustomerMenuSelect(position,this);
    }

    public void  SetMenu(){

        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MenuAdapter menuAdapter = new MenuAdapter(Pay2Activity.this,
                menuMGR.MenuText(), menuMGR.MenuImg());
        MenuList = (ListView) findViewById(R.id.MenuList);
        MenuList.setAdapter(menuAdapter);
        MenuList.setOnItemClickListener(this);


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
